This directory is organized into two subdirectories

bin - contains separate directories for each recognizable grammar by
      PlagiarismDetection.jar Each grammar directory contains
      the _tokens file containing a list of keywords in
      the language and _token_mapings file containing the mapping between the _tokens file and the tokens understood by PlagiarismDetection.jar

src - contains the ANTLR4 grammar file (file extension .g4). Follow the README 
      file to generate the token file in the bin directory

### ADDING A NEW ANTLR4 GRAMMAR

To add a new language grammar for PlagiarismDetection.jar to recognize:

1. Assuming the new language is called "lang", create a new directory
   under SSID/lib/antlr/grammars/bin/ called "lang"

2. Inside the "lang" directory you will need to have the following files:

   a. lang_tokens
      This is the tokens file produced by ANTLR4. It provides a mapping
      from the token type number provided by the ANTLR4 runtime library to
      the token names defined in the .g4 ANTLR grammar file

   b. lang_token_mappings
      This file is a csv that needs to be written manually to map
      the tokens defined in lang_tokens to the tokens understood by
      PlagiarismDetection.jar. The tokens in lang_tokens must be mapped
      to either Symbol, Constant, Variable, or Keyword. Token names found
      in _tokens file but not in the _token_mappings file will be ignored.
      For example, comment-type tokens should be ignored. Alternatively,
      assign these tokens with the label "Ignore"

3. Each grammar has its associated LangLexer.java and LangParser.java in the source code of PlagiarsmDetection (SSID/lib/java/PlagiarismDetection/src Antlr4Grammars) that is required for PlagiarismDetection.jar to understand the grammar. SSID/lib/antlr/grammars/src/README shows the steps to generate the LangLexer.java and LangParser.java files.

   *In theory only LangLexer.java is needed for PlagiarismDetection.jar but some LangLexer.java makes use of methods from LangParser.java. LangParser.java is included in to prevent compilation issues when building PlagiarismDetection.jar

4. Edit SSID/lib/java/PlagiarismDetection/src/Tokenizer/ANTLRDynamicTokenizer.java to include new LangLexer. See SSID/lib/java/PlagiarismDetection/README 
on how to edit java code.

### ANTLR4 Tool and Runtime Libaries

Obtain antlr-4.8-complete.jar using
<pre>
wget https://www.antlr.org/download/antlr-4.8-complete.jar
</pre>

The binary file (antlr-4.8-complete.jar) located in SSID/lib/java/jar
has the binaries for 
   - Antlr4 Tool needed to extract the LangLexer.java and LangParser.java files 
   from the Lang.g4 file

   - Antlr4 Runtime libaries needed for PlagairismDetection.jar to use 
   the langLexer.java and LangParser.java files to understand the Lang_tokens file.