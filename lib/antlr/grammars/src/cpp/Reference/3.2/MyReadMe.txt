MyReadMe.txt

Version 4.1 January 2011

Notes for C++ grammar file to generate ANTLR parser (in C++)
(Best viewed with tabs set to 4)

Contents
==========

1. Past

2. Present
     If you experience any problems with running these programs please read these
   notes first.

3. Future


1. Past
==========

This C++ grammar file was originally written and published in 1994 by,

Authors: Sumana Srinivasan, NeXT Inc.;            sumana_srinivasan@next.com
         Terence Parr, Parr Research Corporation; parrt@parr-research.com
         Russell Quong, Purdue University;        quong@ecn.purdue.edu

as VERSION 1.2 for use with PCCTS (The original C version of ANTLR).

In 1997-1999 it was adapted for use in a project to analyse data flow
in C programs by Lasitha Leelasena, Sue Black (sueblack@gmail.com(2007)) and 
David Wigg (wiggjd@bcs.org.uk(2007)). The generated parser was in C++ and 
all of our included statement code was in C.

In 2000, in view of the fact that ANTLR had then been re-written in Java 
and any further development of PCCTS had been suspended, it was decided
that we should convert our version of the C grammar for PCCTS into 
use with ANTLR. As all our included application code was in C it was 
decided to use the option to produce the generated parser in C++ to 
avoid the need to rewrite this application code as well.

During 2001-2002 we were fortunate enough to have the services of a 
visiting tutor, Jiangu Zuo, from Jianghan University, Wuhan, China who
carried out most of this work. However, this conversion was quite a 
lot more difficult than we had hoped and took us about a year to 
complete. We have tried to make a record of problems encountered and 
to give some solutions. If you would like further information please
contact wiggjd@bcs.org.uk .

The most difficult problem concerned the lack of 'hoisting' in ANTLR 2.7.3
which we were only able to overcome in the time available by copying 
the generated hoisting code from the PCCTS version into our new 
grammar file, hence some of the mysterious C++ statements at the 
beginning of a number of productions.

In August 2002 I reported that this grammar file would be published
'soon' when remaining problems had been cleared up and the grammar was
fit to be published. In the event, for a variety of reasons, this was
not achieved.

So, in view of the number of requests being made for access to this 
grammar I agreed in February 2003 to it being published on the 
www.antlr.org website for general use under the usual terms, in the 
hope that interested users would let me know how it could be improved.
Unfortunately, though it could handle C code and some C++ it was 
unable to handle namespaces and a lot of templates so it left a lot to 
be desired.

In September 2003 I supplied a much improved version which I called 
V2.0. This version was picked up by some users. A few problems were 
raised which have since been solved.

Since then I have been concentrating on tidying up what had become a
rather confusing system and trying to produce a cleaner, tidier and 
easier to understand system and also one easier to use in your 
application. No doubt I have not entirely succeeded yet, but I hope
it is better than it was.

I have introduced the idea of subclassing a user's application code using
an example application program called MyCode.cpp. I hope this clear 
separation of code will lead to a greater clarity of code between the 
application and the parser which will also enable users to install CPP_parser
updates more easily.

In July 2004 I published version 3.0 on the Antlr website (antlr.org).

Since then I have been dealing with users' queries, extending the
range of programs tested and clarifying the grammar file (CPP_parser.g)
to match the language definition enclosed (grammar.txt) with the
package more closely.

In November 2005 I published version 3.1 on the Antlr website (antlr.org).

Since then I have continued dealing with users' queries, extending the
range of programs tested and clarifying the grammar file (CPP_parser.g)
to match the language definition enclosed (grammar.txt) with the
package more closely.


November 2007.

I have called this last version, Version 3.2 published November 2007.

I am not proposing to do any more work on this parser other than to try
to solve any problems sent to me by users. If anyone wishes to take this
parser any further I would be pleased to know. I am anxious to hand it on
to someone who can develope it further. An important further development 
would be to convert it to run under ANTLR 3.x .

I am using MSVC 6.0 under Windows.

I created a static source library for the ANTLR code (2.7.3) with
some modifications as discussed below. I assume it will run with
with any later version of Antlr 2.7 (see HowToBuildStaticLibrary.txt).

Please note that this version continues to be used to parse pre-processed
*.i files (with or without embedded #line directives (obtained by using 
the /P command in compilation when using MSVC) ).

However, programs with other extensions (eg. *.cpp) will work correctly 
without being pre-processend provided no types used in the program
are undeclared and there are no specifically pre-processing commands such as 
#ifdef, #include etc. present.

As described in the file "HowToUseCPP_parser.txt" the program MyCode.cpp shows
how a user can extract any required data from the parser.

However, it should be noted that the default is that unless there is a
#line directive at the beginning of the program.i file (containing
therefore the name of the main file being processed) no MyCode functions will
be entered. The reason for this is that we need to process all the included 
files first to obtain typing information but we will probably not want to 
extract any other information from them. Any MyCode functions are entered only
whenever and whilst a #line directive containing the name of the main program
is detected.

I include a small demonstration program, quadratic.i, which you could use to 
test the set up of your system.

Although I cannot say it has been thoroughly tested (since a I have
not yet found a comprehensive test package for C++) it appears to
parse a wide variety of programs of mine and of many other peoples' 
all of which contain a considerable quantity of included files 
containing a great deal of complex code.

It should be noted that this version still handles scoping in a
relatively simplistic manner but this does not appear to be a 
problem (though I agree it might be desirable for some users). To 
do this properly would entail some work to update the antlr 
supporting code in dictionary.cpp etc.

Briefly, as far as scoping is concerned, all template parameter names and 
all type names are held in level 1. All variable names are held in lower 
levels (with higher numbers) but continue to be deleted when they go out 
of scope (See NotesScopes.txt).

Each run should end with the following two statements,

"Support exitExternalScope scope now 0 as required"
"Parse ended"

showing that the scope level had been returned to zero correctly.

I have included a C++ syntax definition (grammar.txt) which appears
to be up to date. If not, please let me know.

Notes about running this version.

* I am currently using antlr 2.7.3 but it should work with any later 
	version of antlr 2.7 .  If not, please let me know.

* A suitable version of ANTLR for MSVC users should be available from
	http://www.antlr2.org .

* The following type of warning produced during compilation of 
   CPPLexer.cpp and CPPParser.cpp can be ignored,

   CPPParser.cpp(163) : warning C4101: 'pe' : unreferenced local variable

* I have introduced a "statementTrace" feature in CPP_parser.g during
   testing which I have found useful. See CPP_parser.g . This can be
   set on (or off) by altering "statementTrace" in CPPParser.cpp and 
   recompiling and linking only (To avoid regenerating lexer and parser
   from CPP_parser.g as well).
   
   With statementTrace set to 1 you get a list of statement types as
   they are detected from external_declaration and/or member_declaration
   in CPP_parser.g.

   With statementTrace set to 2 you also get a record of each symbol
   declared showing its name, scope level, and type (See list in 
   CPPSymbol.hpp).

   The trace output will display but you should be able to place trace 
   output in a trace file like this in a DOS window,

   ...\CPP_parser3.2>debug\CPP_parser  TestIfiles\program.i > program.trace

   I have also found this feature useful for providing the ability to check
   the output from one run to another after making any modifications
   to the parser. Just keep your "standard" or "correct" version of the
   trace output in a separate "archive" file and use this to compare
   with the output of any new updated version.
   
   You can do a file compare like this in a DOS window,

   ...\CPP_parser3.2>fc  /n  programA.trace  program.trace

* I have also implemented a dynamic trace facility to use the excellent
   trace facility in ANTLR by including some extra code in 
   LLkParser.hpp and LLkParser.cpp called antlrTrace() before 
   generating the static antlr library. 
   
  To use this facility you have to use my modified version of 
   LLkParser.hpp and LLkParser.cpp included in this package to replace
   the versions supplied in the ANTLR library (...\lib\cpp\antlr and 
   ...\lib\cpp\src respectively).

  If you don't want to use this facility please comment out all 7
	references to "antlrTrace(false/true);" in CPP_parser.g.

  The advantage of this facility is that, by always generating with
   antlr tracing initially (using -traceParser etc.), antlr tracing 
   can be switched on or off completely by changing the antlrTrace(false) 
   statement in init() in CPPParser.cpp appropriately and recompiling and 
   linking without also having to regenerate from the grammar file each time.

  To use this facility selectively, particularly when debugging a 
   problem statement in a large program, I have included the following
   statements in the grammar file which respectively turn ANTLR trace 
   on and then off,

   "antlrTrace_on" and "antlrTrace_off"

  To use this facility you then have to include "antlrTrace_on" 
   in the source code just before the statement you want to debug and
   "antlrTrace_off" just after the statement you want to debug.

* I have also supplied a slightly modified version of parser.cpp in 
   the ANTLR package which could be used to produce extra error messages
   to cerr (as well as cout) so that these messages would not be missed
   if and when the standard output was piped to a file for debugging 
   purposes.

* I still include MyCode.cpp (with MyCode.hpp) to demonstrate how your
   application code can be subclassed in CPPParser. You can, of course,
   take over, delete, include and amend any of these functions to suit
   your application by following the same pattern.
   
   I recommend using this feature with this grammar as I think it will 
   make it easier both for me to issue updated versions of the CPP_parser 
   grammar from time to time and for you to accept and use them since 
   the code for the parser and your application can then be kept strictly
   apart.

* I have made some modifications to reduce the default tab size from 8 to 4
   spaces. The first is in CharScanner.cpp in the ANTLR source library code
   where I changed the 3 constructors appropriately (eg. tabsize(4)). 

  I believe the source code of tab() supplied in CharScanner.hpp doesn't work
   correctly because for a tab at the beginning of a line tab() appears to be
   entered twice. I have therefore also included an amended version of 
   CharScanner.hpp which you could use to replace the one supplied for the 
   ANTLR source library.

* There is one known problem with the CPP_parser.g grammar and this is connected
   with "asm" statements. The only way I could find of dealing with them was
   to treat them rather like comments but unfortunately this was not as 
   straightforward as it sounds and they are now included in the ID production
   in the lexer. The one problem left is that in asm statements there needs to 
   be at least one space before any '(' or '{' following the "_asm".

* There should not be any ambiguity warnings generated by the ANTLR compiler 
   from CPP_parser.g .

* End of notes about running this version.



2. Present
==========

Ported to ANTLR 3.2. 



3. Future
==========

   I would be grateful if any user of this grammar would advise me and/or
the e-mail group (antlr-interest@antlr.org) of any improvement they 
have been able to make to this grammar, for the benefit of other users.

   As I have mentioned above, I am not proposing to do any more work on
this parser other than for a limited period to try to solve any problems 
sent to me by users. 

   I am now looking for someone to take over this parser for further development
such as a conversion for it to run under the new ANTLR version 3. I should
be able to assist anyone taking over for a limited period.

   Any volunteer should contact me at wiggjd@bcs.org.uk .


Thankyou,


David Wigg
Research Fellow
Centre for Systems and Software Engineering
London South Bank University
London, UK.
wiggjd@bcs.org.uk
sueblack@gmail.com

November 2007
