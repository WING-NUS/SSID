set ANTLR3HOME="C:\Documents and Settings\amelinte\Desktop\cppparser\antlr-3.2.jar"
rem set CLASSPATH="%ANTLR3HOME%;%CLASSPATH%"

@echo off

REM cls

echo Removing old files...

REM del .\output\CPP_grammar_*.*
del CPP_grammar_.tokens
rem del CPP_grammar_Lexer.c
del CPP_grammar_Lexer.cpp
del CPP_grammar_Lexer.h
rem del CPP_grammar_Parser.c
del CPP_grammar_Parser.cpp
del CPP_grammar_Parser.h

echo done.
echo.

echo Generating code...

REM java org.antlr.Tool -o output CPP_grammar_.g >build.txt 2>&1
java -jar %ANTLR3HOME%  CPP_grammar_.g >build.txt 2>&1

echo Generation done. Output redirected to build.txt
echo.

move CPP_grammar_Lexer.c CPP_grammar_Lexer.cpp
move CPP_grammar_Parser.c CPP_grammar_Parser.cpp

echo Files generated are:

REM dir .\output\CPP_grammar_*.*
dir .\CPP_grammar_*.*


echo.


