import org.antlr.v4.codegen.target.Python3Target;
import org.antlr.v4.runtime.Token;

import java.util.StringJoiner;
import lexers.Python3Lexer;

public class ANTLR4Helpers {
    private ANTLRDynamicTokenizer(String language) {
      // Set language and binPath to run lexer
      this.language = language;
      // this.binPath = ANTLRDynamicTokenizer.grammarsBinDir + "/" + this.language + "/" + this.language + "_lexer";
      
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
      // Expected format of lexerOutput :
      // printf("%u,%u,%u,%u,%s\n", currToken->getLine(currToken), startPosition, tokenLength, currToken->getType(currToken), tokenString.c_str());
      ArrayList<String> lexerOutput = new ArrayList<String>();

      // Call Antlr4 Lexer to generate tokens from char stream
      Python3Lexer lexer = new Python3Lexer(CharStreams.fromFileName(fileName));

      List<? extends Token> tokenList = new ArrayList<>(); 
      tokenList = lexer.getAllTokens(); 
      for (Token token : tokenList) { 
        String lineNumber = token.getLine();
        String startNumber = token.getStartIndex();
        String tokenType = token.getType();
        String tokenString = lexer.getVocabulary().getSymbolicName(tokenType);
        String tokenLength = tokenString.length();

        StringJoiner joiner = new StringJoiner(",");
        joiner.add(lineNumber).add(startNumber).add(tokenLength).add(tokenType).add(tokenString);
        String row = joiner.toString();
        lexerOutput.add(row);
      }
      // Return lexer output as string array
      return lexerOutput;
    }

}