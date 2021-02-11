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

import Antlr4Grammars.javalang.*;
import Antlr4Grammars.c.*;
import Antlr4Grammars.python3.*;
import Antlr4Grammars.cpp.*;
import Antlr4Grammars.scala.*;
import Antlr4Grammars.matlab.*;
import Antlr4Grammars.ocaml.*;

import java.io.*;
import java.util.*;
import pd.utils.*;
import pd.utils.Tokens.*;
import org.antlr.v4.runtime.*;

public final class ANTLRDynamicTokenizer extends Tokenizer {
  private static String grammarsBinDir;
  private static Hashtable<String, ANTLRDynamicTokenizer> tokenizers = new Hashtable<String, ANTLRDynamicTokenizer>();
  private String language;
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
    for (int i = 0; i < grammarBinFiles.length; ++i) {
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
    Iterator<Submission> itr = submissions.iterator();
    while (itr.hasNext()) {
      Submission s = itr.next();
      tokenize(s);
      if (s.getCodeTokens().size() == 0) {
        System.err.println("Empty file detected & would be removed from Plagiarism Detection");
        itr.remove();
      }
    }
  }

  private void tokenize(Submission s) {
    // Get path of Submission, otherwise, create temp file
    String path = s.getPath();
    String tmpFileName = null;
    System.out.println("Preparing temp file...");
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
    System.out.println("Temp file prepared");

    // Run ANTLR and read tokens
    ArrayList<String> lexerOutput = null;
    try {
      System.out.println("Preparing to run lexer");
      lexerOutput = runLexer(path);
      System.out.println("Lexer completed");
    } catch (Exception ex) {
      System.err.println("Error running lexer");
      System.err.println(ex);
      System.exit(1);
    }

    // Convert tokens to PlagiarismDetection tokens
    TokenList tokenList = null;
    try {
      System.out.println("Converting to PD readable Tokens");
      tokenList = processLexerOutput(lexerOutput);
      System.out.println("Convert completed");
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
    this.language = language;

    // Read tokenNames
    String tokenNamesPath = ANTLRDynamicTokenizer.grammarsBinDir + "/" + this.language + "/" + this.language
        + "_tokens";
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
    String tokenNameMappingsPath = ANTLRDynamicTokenizer.grammarsBinDir + "/" + this.language + "/" + this.language
        + "_token_mappings";
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
    ArrayList<String> lexerOutput = new ArrayList<String>();
    // Call Antlr4 Lexer to generate tokens from char stream
    String[] args = { language, fileName };
    Lexer lexer = getLexer(args);
    for (Token token = lexer.nextToken(); token.getType() != Token.EOF; token = lexer.nextToken()) {
      String lineNumber = String.valueOf(token.getLine());
      String startNumber = String.valueOf(token.getStartIndex());
      String tokenType = String.valueOf(token.getType());
      String tokenString = token.getText();
      String tokenLength = String.valueOf(tokenString.length());

      StringJoiner joiner = new StringJoiner(",");
      joiner.add(lineNumber).add(startNumber).add(tokenLength).add(tokenType).add(tokenString);
      String row = joiner.toString();
      lexerOutput.add(row);
      // System.out.println(lexer.getVocabulary().getSymbolicName(token.getType()));
    }
    // Return lexer output as string array
    return lexerOutput;
  }

  private Lexer getLexer(String[] args) throws IOException, Exception {
    String language = args[0];
    String fileName = args[1];
    // check against language in grammarbinDir
    if (language.equals("java")) {
      JavaLexer lexer = new JavaLexer(CharStreams.fromFileName(fileName));
      return lexer;
    } else if (language.equals("c")) {
      CLexer lexer = new CLexer(CharStreams.fromFileName(fileName));
      return lexer;
    } else if (language.equals("cpp")) {
      CPP14Lexer lexer = new CPP14Lexer(CharStreams.fromFileName(fileName));
      return lexer;
    } else if (language.equals("python3")) {
      Python3Lexer lexer = new Python3Lexer(CharStreams.fromFileName(fileName));
      return lexer;
    } else if (language.equals("scala")) {	
      ScalaLexer lexer = new ScalaLexer(CharStreams.fromFileName(fileName));
      return lexer;
    } else if (language.equals("matlab")) {	
      matlabLexer lexer = new matlabLexer(CharStreams.fromFileName(fileName));
    } else if (language.equals("ocaml")) {	
      OcamlLexer lexer = new OcamlLexer(CharStreams.fromFileName(fileName));
      return lexer;
    } else {
      String errorMessage = String.format(
          "%s Lexer not found. %s package containing the Lexer may have been excluded in build process.", language,
          language);
      throw new Exception(errorMessage);
    }
  }

  private TokenList processLexerOutput(ArrayList<String> lexerOutput) throws Exception {
    TokenList tokens = new TokenList();
    ArrayList<String> filteredLexerOutput = new ArrayList<String>();

    // Remove Unmapped and Ignored Token names so that we can predict end of
    // statement in the next loop
    for (String tokenString : lexerOutput) {
      // Extract info
      String[] cols = tokenString.split(",");
      String tokenClassString;

      if (cols.length >= 4) {
        // Defensive programming
        String tokenType = cols[3];

        // Get token class string
        String tokenName = this.tokenNames.get(tokenType);
        if (tokenName == null) {
          throw new Exception("Unrecognized token type: " + tokenType);
        }
        tokenClassString = this.tokenNameMappings.get(tokenName);
        if (tokenClassString == null) {
          throw new Exception("Unrecognized token name: " + tokenName);
        }
      } else {
        tokenClassString = "Ignore";
        // Filter out \n statements
        if (!tokenString.equals("\n") && !tokenString.equals("\\n")) {
          System.out.println("Unknown format, ignoring line: " + tokenString);
        }
      }

      if (tokenClassString.equals("Symbol") || tokenClassString.equals("Variable")
          || tokenClassString.equals("Constant") || tokenClassString.equals("Keyword")) {
        filteredLexerOutput.add(tokenString);
      } else if (tokenClassString.equals("Ignore")) {
        // Ignore token
      } else {
        throw new Exception("Unrecognized token class: " + tokenClassString);
      }
    }

    // Loop through filtered tokens
    int lastLineNumber = -1;
    boolean statementHasNonCountableKeyword = false;
    for (int i = 0; i < filteredLexerOutput.size(); ++i) {
      // Get tokenStrings
      String tokenString = filteredLexerOutput.get(i);
      String nextTokenString = null;
      if (i != filteredLexerOutput.size() - 1) {
        nextTokenString = filteredLexerOutput.get(i + 1);
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
        throw new Exception("Unrecognized token type: " + tokenType);
      }
      String tokenClassString = this.tokenNameMappings.get(tokenName);
      if (tokenClassString == null) {
        throw new Exception("Unrecognized token name: " + tokenName);
      }

      // Set startOfStatement variable based on lineNumbers
      boolean isStartOfStatement = (lineNumber != lastLineNumber);

      // Set EndOfStatementType enum type based on nextLineNumber
      TokenSSID.EndOfStatementType endOfStatementType;
      if (nextLineNumber == lineNumber) {
        endOfStatementType = TokenSSID.EndOfStatementType.FALSE;
      } else if (statementHasNonCountableKeyword) {
        endOfStatementType = TokenSSID.EndOfStatementType.NON_COUNTABLE;
      } else {
        endOfStatementType = TokenSSID.EndOfStatementType.COUNTABLE;
      }

      // Figure out Token class and then create
      if (tokenClassString.equals("Symbol")) {
        tokens.add(new SymbolToken(tokenText, startingPosition, endingPosition, lineNumber, isStartOfStatement,
            endOfStatementType));
      } else if (tokenClassString.equals("Variable")) {
        tokens.add(new VariableToken(tokenText, startingPosition, endingPosition, lineNumber, isStartOfStatement,
            endOfStatementType));
      } else if (tokenClassString.equals("Constant")) {
        tokens.add(
            new ConstantToken(startingPosition, endingPosition, lineNumber, isStartOfStatement, endOfStatementType));
      } else if (tokenClassString.equals("Keyword")) {
        if (tokenText.matches(REGEX_NON_COUNTABLE_KEYWORDS)) {
          // We assume that the non-countable keyword cannot be the last token
          // of the statement. Otherwise, endOfStatementType will not be set
          // correctly.
          statementHasNonCountableKeyword = true;
        }
        tokens.add(new KeywordToken(tokenText, startingPosition, endingPosition, lineNumber, isStartOfStatement,
            endOfStatementType));
      }

      // Update
      lastLineNumber = lineNumber;
      if (endOfStatementType != TokenSSID.EndOfStatementType.FALSE) {
        statementHasNonCountableKeyword = false;
      }
    }

    return tokens;
  }
}
