/*
This file is part of SSID.

SSID is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SSID is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with SSID.  If not, see <http://www.gnu.org/licenses/>.
 */
 
package Tokenizer;

import java.io.*;
import java.util.*;
import pd.utils.*;
import pd.utils.Tokens.*;

public final class ANTLRDynamicTokenizer extends Tokenizer {
  private static String grammarsBinDir;
  private static Hashtable<String, ANTLRDynamicTokenizer> tokenizers = new Hashtable<String, ANTLRDynamicTokenizer>();
  private String language;
  private String binPath;
  private Hashtable<String, String> tokenNames;
  private Hashtable<String, String> tokenNameMappings;
  private String REGEX_NON_COUNTABLE_KEYWORDS = "^(import|include|package|require)$";
  
  /*
   * Sets the directory path to find recognizable grammars
   */
  public static void setGrammarsBinDir(String grammarsBinDir) {
    if (ANTLRDynamicTokenizer.grammarsBinDir == null) {
      ANTLRDynamicTokenizer.grammarsBinDir = grammarsBinDir;
    }
  }

  /*
   * Checks if directory for language is present in grammarsBinDir
   */
  public static boolean understandsLanguage(String language) {
    File[] grammarBinFiles = (new File(ANTLRDynamicTokenizer.grammarsBinDir)).listFiles();
    boolean hasBinForLanguage = false;
    for (int i=0; i<grammarBinFiles.length; ++i) {
      if (grammarBinFiles[i].getName().equals(language)) {
        hasBinForLanguage = true;
      }
    }

    return hasBinForLanguage;
  }

  /*
   * Creates or returns tokenizer from hashtable
   */
	public static Tokenizer getTokenizer(String language) throws Exception {
    if (ANTLRDynamicTokenizer.grammarsBinDir == null) {
      throw new Exception("getTokenizer() called without grammarsBinDir defined");
    }
    if (!ANTLRDynamicTokenizer.tokenizers.containsKey(language)) {
      ANTLRDynamicTokenizer.tokenizers.put(language, new ANTLRDynamicTokenizer(language));
    }

    return ANTLRDynamicTokenizer.tokenizers.get(language);
	}

	public void TokenizeSubmissions(ArrayList<Submission> submissions) {
		for (Submission s : submissions) {
			tokenize(s);
		}
	}

	private void tokenize(Submission s) {
    // Get path of Submission, otherwise, create temp file
    String path =  s.getPath();
    String tmpFileName = null;
    if (path == null) {
      // Create temp file for submission
      ArrayList<String> lines = s.getCombinedCode();
      tmpFileName = "/tmp/SSID_ANTLRDynamicTokenizer-" + (new java.util.Date()).getTime() + "-" + Math.random(); 
      try {
        FileWriter fileWriter = new FileWriter(new File(tmpFileName));
        for (String line : lines) {
          fileWriter.write(line + "\n");
        }
        fileWriter.close();
      } catch (Exception e) {
        System.err.println("Error writing to temp file: " + tmpFileName);
        System.exit(1);
      }
      path = tmpFileName;
    }
    
    // Run ANTLR and read tokens
    ArrayList<String> lexerOutput = null;
    try {
      lexerOutput = runLexer(path);
    } catch (Exception ex) {
      System.err.println("Error running lexer");
      System.err.println(ex);
      System.exit(1);
    }

    // Convert tokens to PlagiarismDetection tokens
    TokenList tokenList = null;
    try {
      tokenList = processLexerOutput(lexerOutput);
    } catch (Exception ex) {
      System.err.println(ex);
      System.exit(1);
    }
    s.setCodeTokens(tokenList);

    // Delete temp file if any
    if (tmpFileName != null) {
      (new File(tmpFileName)).delete();
    }
  }

  private ANTLRDynamicTokenizer(String language) {
    // Set language and binPath to run lexer
    this.language = language;
    this.binPath = ANTLRDynamicTokenizer.grammarsBinDir + "/" + this.language + "/" + this.language + "_lexer";
    
    // Read tokenNames
    String tokenNamesPath = ANTLRDynamicTokenizer.grammarsBinDir + "/" + this.language + "/" + this.language + "_tokens";
    this.tokenNames = new Hashtable<String, String>();
    try {
      File tokenNamesFile = new File(tokenNamesPath);
      Scanner scanner = new Scanner(tokenNamesFile);
      while (scanner.hasNext()) {
        String[] cols = scanner.nextLine().split("=");
        this.tokenNames.put(cols[1], cols[0]);
      }
      scanner.close();
    } catch (Exception ex) {
      System.err.println(ex);
      System.exit(1);
    }
    
    // Read tokenNameMappings
    String tokenNameMappingsPath = ANTLRDynamicTokenizer.grammarsBinDir + "/" + this.language + "/" + this.language + "_token_mappings";
    this.tokenNameMappings = new Hashtable<String, String>();
    try {
      File tokenNameMappingsFile = new File(tokenNameMappingsPath);
      Scanner scanner = new Scanner(tokenNameMappingsFile);
      while (scanner.hasNext()) {
        String[] cols = scanner.nextLine().split(",");
        this.tokenNameMappings.put(cols[0], cols[1].intern());
      }
      scanner.close();
    } catch (Exception ex) {
      System.err.println(ex);
      System.exit(1);
    }
  }

  private ArrayList<String> runLexer(String fileName) throws Exception {
    // Run lexer as separate process
    Runtime runtime = Runtime.getRuntime();
    String commandString = this.binPath + " " + fileName;
    Process lexerProcess = runtime.exec(commandString); 

    // Read lexer output
    Scanner lexerScanner = new Scanner(lexerProcess.getInputStream());
    ArrayList<String> lexerOutput = new ArrayList<String>();
    while (lexerScanner.hasNext()) {
      lexerOutput.add(lexerScanner.nextLine());
    }
    lexerScanner.close();

    // Read lexer error
    Scanner lexerErrorScanner = new Scanner(lexerProcess.getErrorStream());
    StringBuffer errorSb = new StringBuffer();
    while (lexerErrorScanner.hasNext()) {
      errorSb.append(lexerErrorScanner.nextLine());
    }
    lexerErrorScanner.close();

    // Clean up
    try {
      lexerProcess.waitFor();
    } catch (InterruptedException ex) {
      System.err.println("hi");
      System.err.println(ex);
      System.exit(1);
    }

    // Check for error
    if (lexerProcess.exitValue() != 0) {
      throw new Exception("Lexer exit with value "+lexerProcess.exitValue()+": "+errorSb.toString());
    }

    // Return lexer output as string array
    return lexerOutput;
  }

  private TokenList processLexerOutput(ArrayList<String> lexerOutput) throws Exception {
    TokenList tokens = new TokenList();
    ArrayList<String> filteredLexerOutput = new ArrayList<String>();

    // Remove Unmapped and Ignored Token names so that we can predict end of statement in the next loop
    for (String tokenString : lexerOutput ) {
      // Extract info
      String[] cols = tokenString.split(",");
      String tokenType = cols[3];

      // Get token class string
      String tokenName = this.tokenNames.get(tokenType);
      if (tokenName == null) {
        throw new Exception("Unrecognized token type: "+tokenType);
      }
      String tokenClassString = this.tokenNameMappings.get(tokenName);
      if (tokenClassString == null) {
        throw new Exception("Unrecognized token name: "+tokenName);
      }

      if (tokenClassString.equals("Symbol")
          || tokenClassString.equals("Variable")
          || tokenClassString.equals("Constant")
          || tokenClassString.equals("Keyword")) {
        filteredLexerOutput.add(tokenString);
      } else if (tokenClassString.equals("Ignore")) {
        // Ignore token
      } else {
        throw new Exception("Unrecognized token class: "+tokenClassString);
      }
    }

    // Loop through filtered tokens
    int lastLineNumber = -1;
    boolean statementHasNonCountableKeyword = false;
    for (int i=0; i<filteredLexerOutput.size(); ++i) {
      // Get tokenStrings
      String tokenString = filteredLexerOutput.get(i);
      String nextTokenString = null;
      if (i != filteredLexerOutput.size() - 1) {
        nextTokenString = filteredLexerOutput.get(i+1);
      }

      // Extract info
      String[] cols = tokenString.split(",");
      int lineNumber = Integer.parseInt(cols[0]) - 1; // lineNumber by ANTLR starts at 1, we need it to start at 0
      int nextLineNumber = -1;
      if (nextTokenString != null) {
        nextLineNumber = Integer.parseInt(nextTokenString.split(",")[0]) - 1;
      }
      int startingPosition = Integer.parseInt(cols[1]);
      int tokenLength = Integer.parseInt(cols[2]);
      int endingPosition = startingPosition + tokenLength - 1;
      String tokenType = cols[3];
      String tokenText = null;
      if (cols.length == 5) {
        tokenText = cols[4];
      } else if (tokenString.matches(".*,,$")) {
        tokenText = ",";
      }

      // Get token class string
      String tokenName = this.tokenNames.get(tokenType);
      if (tokenName == null) {
        throw new Exception("Unrecognized token type: "+tokenType);
      }
      String tokenClassString = this.tokenNameMappings.get(tokenName);
      if (tokenClassString == null) {
        throw new Exception("Unrecognized token name: "+tokenName);
      }

      // Set startOfStatement variable based on lineNumbers
      boolean isStartOfStatement = (lineNumber != lastLineNumber);

      // Set EndOfStatementType enum type based on nextLineNumber
      Token.EndOfStatementType endOfStatementType;
      if (nextLineNumber == lineNumber) {
        endOfStatementType = Token.EndOfStatementType.FALSE;
      } else if (statementHasNonCountableKeyword) {
        endOfStatementType = Token.EndOfStatementType.NON_COUNTABLE;
      } else {
        endOfStatementType = Token.EndOfStatementType.COUNTABLE;
      }

      // Figure out Token class and then create
      if (tokenClassString.equals("Symbol")) {
        tokens.add(new SymbolToken( tokenText, 
                                    startingPosition, 
                                    endingPosition, 
                                    lineNumber, 
                                    isStartOfStatement,
                                    endOfStatementType));
      } else if (tokenClassString.equals("Variable")) {
        tokens.add(new VariableToken( tokenText,
                                      startingPosition, 
                                      endingPosition, 
                                      lineNumber, 
                                      isStartOfStatement,
                                      endOfStatementType));
      } else if (tokenClassString.equals("Constant")) {
        tokens.add(new ConstantToken( startingPosition, 
                                      endingPosition, 
                                      lineNumber, 
                                      isStartOfStatement,
                                      endOfStatementType));
      } else if (tokenClassString.equals("Keyword")) {
        if (tokenText.matches(REGEX_NON_COUNTABLE_KEYWORDS)) {
          // We assume that the non-countable keyword cannot be the last token
          // of the statement. Otherwise, endOfStatementType will not be set 
          // correctly.
          statementHasNonCountableKeyword = true;
        }
        tokens.add(new KeywordToken(  tokenText,
                                      startingPosition, 
                                      endingPosition, 
                                      lineNumber, 
                                      isStartOfStatement,
                                      endOfStatementType));
      }

      // Update
      lastLineNumber = lineNumber;
      if (endOfStatementType != Token.EndOfStatementType.FALSE) {
        statementHasNonCountableKeyword = false;
      }
    }

    return tokens;
  }
}
