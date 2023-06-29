Add support for new language in SSID
=======================

This guide will list the steps required to add support for a new language in SSID. To better illustrate the steps, we will assume that the language that we want to add support is called "lang"


### Adding grammar file

1. Go to `/lib/antlr/grammars/`. You will see that this directory is organized into two subdirectories

> bin - contains separate directories for each recognizable grammar by PlagiarismDetection.jar. Each grammar directory contains the _tokens file containing a list of keywords in the language and _token_mapings file containing the mapping between the _tokens file and the tokens understood by PlagiarismDetection.jar

> src - contains the ANTLR4 grammar file (file extension .g4). Follow the README file to generate the token file in the bin directory  

2. Now, go under `src` folder and create a folder with the language name, which in our case will be "lang".

3. For the respective language that you are intending to add support, look for the grammar file (. g4) understood by Antlr4, publicly available at https://github.com/antlr/grammars-v4

4. If the grammar file is available, retrieve the file into the created folder by using the `wget` command. For instance, for the lang language, the command will look something like this:

<pre>
wget https://raw.githubusercontent.com/antlr/grammars-v4/master/lang/lang.g4
</pre>

5. If the grammar file is unavailable, then you will need to write your own grammar file based on the parsers for the respective language.

### Extraction of .g4 file using the Antlr Tool

6. Extract the respective .g4 using the Antlr Tool in antlr-4.8-complete.jar. For the lang language, the command will look like this:

<pre>
java -jar ../../../../java/jar/antlr-4.8-complete.jar -no-listener -no-visitor -package Antlr4Grammars.lang lang.g4
</pre>

7. Once the extraction is done, there will be 6 files. They are:

	1. lang.tokens
	2. langLexer.java
	3. langParser.java
	4. langLexer.tokens
	5. langLexer.interp
	6. lang.interp

> Files (iv) - (vi) are not needed and can be deleted.

8. Rename the `lang.tokens` file to `lang_tokens` file.

9. Now go to `/lib/antlr/grammars/bin` folder and create a folder with the language name, which in our case will be "lang". This folder will be used to store the `lang_tokens` file &`lang_token_mappings` file (which will be created later by us). As such, move the `lang_tokens` file from the `/src/` folder to this newly created folder.

10. Now go to `/lib/java/PlagiarismDetection/src/Antlr4Grammars/` and create a folder with the language name, which in our case will be "lang". This foler will be used to store `langLexer.java` file & `langParser.java` file. As such, move these two files from the `/lib/antlr/grammars/src` folder to this newly created folder.

> Each grammar has its associated LangLexer.java and LangParser.java in the source code of PlagiarsmDetection (SSID/lib/java/PlagiarismDetection/src Antlr4Grammars) that is required for PlagiarismDetection.jar to understand the grammar.

> In theory only LangLexer.java is needed for PlagiarismDetection.jar but some LangLexer.java makes use of methods from LangParser.java. LangParser.java is included in to prevent compilation issues when building PlagiarismDetection.jar


### Creation of token mappings file
11. Navigate back to `/lib/antlr/grammars/bin/lang` and create a file named `lang_token_mappings` file. Manually assign the tokens defined in `lang_tokens` to tokens understood by PlagiarismDetection.jar. Read below to find out more.

> `lang_tokens` is the tokens file produced by ANTLR4. It provides a mapping from the token type number provided by the ANTLR4 runtime library to the token names defined in the .g4 ANTLR grammar file

> `lang_token_mappings` is a csv file that needs to be written manually to map the tokens defined in `lang_tokens` to the tokens understood by PlagiarismDetection.jar. The tokens in lang_tokens must be mapped to either Symbol, Constant, Variable, or Keyword. To ignore a particular token in `lang_tokens`, assign it with the label "Ignore" in `lang_token_mappings` file.

### Including new language lexer & making UI changes to add language option
12. Now, navigate to `/lib/java/PlagiarismDetection/src/Tokenizer/ANTLRDynamicTokenizer.java`. Allow ANTLRDynamicTokenizer to access LangLexer.java inside the package
Antlr4Grammars.lang
    <pre>
    import Antlr4Grammars.lang.*;
    </pre>

13. Under the same file, allow the function `getLexer(String[ ] args)` in line 196 to obtain the correct LangLexer.
    <pre>
    else if (language.equals("lang")) {
      LangLexer lexer = new LangLexer(CharStreams.fromFileName(fileName));
      return lexer;
    }
    </pre>
14. Run "ant" to rebuild.

15. Now navigate to `/app/models/assignment.rb` and add the respective language name under `LANGUAGES` & `PRETTIFY_LANGUAGES`

16. Next, navigate to `/app/assets/javascripts/assignment_file_upload.js` and add the respective language extension and language name under `languageHashMap`

17. Finally, navigate to `lib/submissions_handler.rb` and modify `accepted_formats` in line 78 to include file extension type for the language.





