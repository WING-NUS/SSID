The build.xml file can be used by Apache Ant to build the jar file
and install it in the appropriate directory (./../jar).
To do so, simply run "ant"


Adding New Grammar
==================

The instructions from antlr/README and antlr/grammars/README must be completed before the following steps can be carried out.

Perform the following steps in src/Tokenzier/ANTLRDynamicTokenizer.java to allow the built PlagiarismDetection.jar to read new Antlr4 grammar.

1. Allow ANTLRDynamicTokenizer to access LangLexer.java inside the package 
Antlr4Grammars.lang
    <pre>
    import Antlr4Grammars.c.*;
    </pre>

2. Allow the function getLexer(String[] args) to obtain the correct LangLexer. 
    <pre>
    else if (language.equals("lang")) {
      LangLexer lexer = new LangLexer(CharStreams.fromFileName(fileName));
      return lexer;
    }
    </pre>
    In the case of C language,
    <pre>
    else if (language.equals("c")) {
      CLexer lexer = new CLexer(CharStreams.fromFileName(fileName));
      return lexer;
    }
    </pre>

3. run "ant"

