SSID_README

October 2012
Jesse Prabawa Gozali

This directory contains files from the publicly available ANTLR C++
Grammar. This readme will outline installation instructions should you
need to recompile or modify the provided C++ lexer in the directory
SSID/lib/antlr/grammars/bin/cpp/cpp_lexer

Note that you don't need to perform all the steps outlined below. Each
step will have a description of what it does and why you would want to
perform the step.

Compiling the C++ Grammar File
==============================

The grammar file is actually the file CPP_grammar_.g contained in this
directory. If you would like to modify this grammar file or use a more
updated version of the grammar file or use an updated version of ANTLR,
you may follow instructions outlined in this section and skip any steps
as necessary.

1. Download the Grammar file from
   http://www.antlr.org/grammar/1295920686207/antlr3.2_cpp_parser4.1.0.zip
   The files in this zip file are essentially files in this directory.

2. Unzip

3. Deduce the instructions in compile.bat to produce CPP_grammar_Lexer.cpp,
   CPP_grammar_Parser.cpp and CPP_grammar_.tokens. Essentially, they are:

   a. Run: java -jar PATH_TO_ANTLR_JAR CPP_grammar_.g > build.txt 2>&1
      where PATH_TO_ANTLR_JAR should be SSID/lib/java/jar/antlr-3.4-complete.jar

   b. Rename resulting c files to cpp:
      mv CPP_grammar_Lexer.c CPP_grammar_Lexer.cpp
      mv CPP_grammar_Parser.c CPP_grammar_Parser.cpp

4. Copy the tokens file to the assumed location and name by
   PlagiarismDetection.jar: cp CPP_grammar_.tokens
   SSID/lib/antlr/grammars/bin/cpp/cpp_tokens

Modifying How The Lexer Is Used
===============================

4. The cpp_full_prog.cpp has been modified for SSID to output token
   information in a csv format. The format of the csv and the name of the
   binary (cpp_lexer; see step 8) cannot be changed without editing the
   PlagiarismDetection.jar file in SSID/lib/java/jar/PlagiarismDetection.jar
   whose source and build files are at SSID/lib/java/PlagiarismDetection/

   For more information on how to massage information out of the lexer,
   tokens or (currently unused) parser, please refer to the C runtime API at
   http://www.antlr.org/api/C/struct_a_n_t_l_r3___t_o_k_e_n___s_o_u_r_c_e__struct.html 

   Essentially, the ANTLR C runtime library works by defining a series
   of structs with dynamically allocated function pointers in each struct
   to be used to manipulate said struct, hence the weird looking function
   calls like "currToken->getType(currToken)"

COMPILING THE C++ LEXER
=======================

5. If you are using the grammar file CPP_grammar_.g from the zip file in
   step 1, edit file CPP_grammar_Parser.cpp produced in step 3 and comment out 
   line 29639 (there is an extra ');' present) that will prohibit the file from
   compiling. The version in this directory has already been modified unless step
   3 was performed and overwrites the modified version.

6. If you are using the original cpp_full_prog.cpp file from the zip file
   in step 1 and not the version already modified in this directory, edit
   line 239 and change "input  = antlr3AsciiFileStreamNew(fName);" with:
   "input  = antlr3FileStreamNew(fName, 4);". The integer 4 refers to
   the constant ANTLR3_ENC_8BIT found in antlr3defs.h (in the C runtime
   library version 3.4; see README file in SSID/lib/antlr/README; So you wont
   find the definition in the antlr3defs.h found in the zip file from step 1)

   More information on this edit: Inspired by
   http://www.antlr.org/wiki/display/ANTLR3/Five+minute+introduction+to+ANTLR+3,
   there is no longer a method call for "antlr3AsciiFileStreamNew(fName)"
   in the runtime library we are using.

7. Compile and link: g++ -o cpp_full_prog cpp_full_prog.cpp CPP_grammar_Lexer.cpp CPP_grammar_Parser.cpp Helper/*.cpp -I/usr/local/include/ -I./antlr_include/ -L/usr/local/lib/ -lantlr3c

8. Copy to the binary into its assumed location with its assumed name
   cp cpp_full_prog SSID/lib/antlr/grammars/bin/cpp/cpp_lexer

