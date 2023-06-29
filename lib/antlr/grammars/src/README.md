Steps to build grammar.
=======================

The grammar files (.g4) understood by Antlr4 is publicly available
at https://github.com/antlr/grammars-v4

### Demonstration using C language

1. Obtain grammar file (C.g4) 
<pre>
wget https://raw.githubusercontent.com/antlr/grammars-v4/master/c/C.g4
</pre>

2. Extract C.g4 using the Antlr Tool in antlr-4.8-complete.jar
<pre>
java -jar ../../../../java/jar/antlr-4.8-complete.jar -no-listener -no-visitor -package Antlr4Grammars.c C.g4
</pre>

3. Extracted files consist of 6 files
	(a) C.tokens
	(b) CLexer.java
	(c) CParser.java
	(d) CLexer.tokens
	(e) CLexer.interp
	(f) C.interp

	Files (d) - (f) are not needed and can be deleted.

4. Copy the token file to the antlr/grammars/bin folder and rename
cp C.tokens ../../bin/c/c_tokens

5. Copy the CLexer.java and CParser.java file to source code of PlagiarismDetection
<pre>
cp *java ../../../../java/PlagiarismDetection/src/Antlr4Grammars/c
</pre>

6. Create the c_token_mappings file to map tokens found in c_tokens to tokens
understood by PlagiarismDetection.jar





