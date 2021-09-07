/*
BSD License
Copyright (c) 2013, Tom Everett
All rights reserved.
Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:
1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Tom Everett nor the names of its contributors
   may be used to endorse or promote products derived from this software
   without specific prior written permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
/*
* Grammar based on yacc-keable for matlab by Danny Luk 12/1995
*
* http://www.angelfire.com/ar/CompiladoresUCSE/images/MATLAB.zip
*/

grammar matlab;


primary_expression
   : IDENTIFIER
   | CONSTANT
   | STRING_LITERAL
   | '(' expression ')'
   | '[' ']'
   | '[' array_list ']'
   ;

postfix_expression
   : primary_expression
   | array_expression
   | postfix_expression TRANSPOSE
   | postfix_expression NCTRANSPOSE
   ;

index_expression
   : ':'
   | expression
   ;

index_expression_list
   : index_expression
   | index_expression_list ',' index_expression
   ;

array_expression
   : IDENTIFIER '(' index_expression_list ')'
   ;

unary_expression
   : postfix_expression
   | unary_operator postfix_expression
   ;

unary_operator
   : '+'
   | '-'
   | '~'
   ;

multiplicative_expression
   : unary_expression
   | multiplicative_expression '*' unary_expression
   | multiplicative_expression '/' unary_expression
   | multiplicative_expression '\\' unary_expression
   | multiplicative_expression '^' unary_expression
   | multiplicative_expression ARRAYMUL unary_expression
   | multiplicative_expression ARRAYDIV unary_expression
   | multiplicative_expression ARRAYRDIV unary_expression
   | multiplicative_expression ARRAYPOW unary_expression
   ;

additive_expression
   : multiplicative_expression
   | additive_expression '+' multiplicative_expression
   | additive_expression '-' multiplicative_expression
   ;

relational_expression
   : additive_expression
   | relational_expression '<' additive_expression
   | relational_expression '>' additive_expression
   | relational_expression LE_OP additive_expression
   | relational_expression GE_OP additive_expression
   ;

equality_expression
   : relational_expression
   | equality_expression EQ_OP relational_expression
   | equality_expression NE_OP relational_expression
   ;

and_expression
   : equality_expression
   | and_expression '&' equality_expression
   ;

or_expression
   : and_expression
   | or_expression '|' and_expression
   ;

expression
   : or_expression
   | expression ':' or_expression
   ;

assignment_expression
   : postfix_expression '=' expression
   ;

eostmt
   : ','
   | ';'
   | CR
   ;

statement_list
   : statement
   | statement_list statement
   ;

identifier_list
   : IDENTIFIER
   | identifier_list IDENTIFIER
   ;

global_statement
   : GLOBAL identifier_list eostmt
   ;

clear_statement
   : CLEAR identifier_list eostmt
   ;

expression_statement
   : eostmt
   | expression eostmt
   ;

assignment_statement
   : assignment_expression eostmt
   ;

array_element
   : expression
   | expression_statement
   ;

array_list
   : array_element
   | array_list array_element
   ;

selection_statement
   : IF expression statement_list END eostmt
   | IF expression statement_list ELSE statement_list END eostmt
   | IF expression statement_list elseif_clause END eostmt
   | IF expression statement_list elseif_clause ELSE statement_list END eostmt
   ;

elseif_clause
   : ELSEIF expression statement_list
   | elseif_clause ELSEIF expression statement_list
   ;

iteration_statement
   : WHILE expression statement_list END eostmt
   | FOR IDENTIFIER '=' expression statement_list END eostmt
   | FOR '(' IDENTIFIER '=' expression ')' statement_list END eostmt
   ;

jump_statement
   : BREAK eostmt
   | RETURN eostmt
   ;

translation_unit
   : statement_list
   | FUNCTION function_declare eostmt statement_list
   ;

func_ident_list
   : IDENTIFIER
   | func_ident_list ',' IDENTIFIER
   ;

func_return_list
   : IDENTIFIER
   | '[' func_ident_list ']'
   ;

function_declare_lhs
   : IDENTIFIER
   | IDENTIFIER '(' ')'
   | IDENTIFIER '(' func_ident_list ')'
   ;

function_declare
   : function_declare_lhs
   | func_return_list '=' function_declare_lhs
   ;


ARRAYMUL
   : '.*'
   ;


ARRAYDIV
   : '.\\'
   ;


ARRAYRDIV
   : './'
   ;


ARRAYPOW
   : '.^'
   ;


BREAK
   : 'break'
   ;


RETURN
   : 'return'
   ;


FUNCTION
   : 'function'
   ;


FOR
   : 'for'
   ;


WHILE
   : 'while'
   ;


END
   : 'end'
   ;


GLOBAL
   : 'global'
   ;


IF
   : 'if'
   ;


CLEAR
   : 'clear'
   ;


ELSE
   : 'else'
   ;


ELSEIF
   : 'elseif'
   ;


LE_OP
   : '<='
   ;


GE_OP
   : '>='
   ;


EQ_OP
   : '=='
   ;


NE_OP
   : '~='
   ;


NCTRANSPOSE
   : '.\''
   ;


STRING_LITERAL
   : '\'' ( ~ '\'' | '\'\'' ) * '\''
   ;


IDENTIFIER
   : [a-zA-Z] [a-zA-Z0-9_]*
   ;


CONSTANT
   : NUMBER (E SIGN? NUMBER)?
   ;


fragment NUMBER
   : ('0' .. '9') + ('.' ('0' .. '9') +)?
   ;


fragment E
   : 'E' | 'e'
   ;


fragment SIGN
   : ('+' | '-')
   ;


CR
   : [\r\n] +
   ;


WS
   : [ \t] + -> skip
   ;

//// LEXER RULES

// Match all newline characters
NL : ('\r' '\n' | '\r' | '\n') -> channel(HIDDEN);

// Match comments and send them to the HIDDEN channel
BLOCKCOMMENT	: '%{' .*?  '%}' -> channel(HIDDEN);
COMMENT			: '%' .*? NL  -> channel(HIDDEN);

// Match whitespace characters and skip
WS : [ \t] { maybeString = true; } -> skip;

// Match the multiline break and skip it
ELLIPSIS: '...' -> skip;

// Keywords
BREAK		: 'break';
CASE		: 'case';
CATCH		: 'catch';
CLASSDEF	: 'classdef';
CONTINUE	: 'continue';
ELSE		: 'else';
ELSEIF		: 'elseif';
END			: 'end';
FOR			: 'for';
FUNCTION	: 'function';
GET			: 'get';
GLOBAL		: 'global';
IF			: 'if';
OTHERWISE	: 'otherwise';
PERSISTENT	: 'persistent';
PROPERTIES	: 'properties';
RETURN		: 'return';
SET			: 'set';
SWITCH		: 'switch';
TRY			: 'try';
WHILE		: 'while';

// Special Keywords //
//////////////////////

STATIC	: 'Static';

// Two Character Operators
ELMENT_WISE_LEFT_DIVIDE		: './';
ELMENT_WISE_POWER			: '.^';
ELMENT_WISE_RIGHT_DIVIDE	: '.\\';
ELMENT_WISE_TIMES			: '.*';
ELMENT_WISE_TRANSPOSE		: '.\'';
EQUALS						: '==' {maybeString = true;};
GREATER_THAN_OR_EQUAL		: '>=';
LESS_THAN_OR_EQUAL			: '<=';
LOGICAL_AND					: '&&';
LOGICAL_OR					: '||';
NOT_EQUAL					: '~=';

// Single Character Operators
ASSIGN			: '=' { maybeString = true; };
BINARY_AND		: '&';
BINARY_OR		: '|';
COLON			: ':';
GREATER_THAN	: '>' { maybeString = true; };
LEFT_DIVIDE		: '/';
LESS_THAN		: '<' { maybeString = true; };
MINUS			: '-';
NOT				: '~';
PLUS			: '+';
POWER			: '^';
RIGHT_DIVIDE	: '\\';
TIMES			: '*';
TRANSPOSE		: '\'' | 'transpose';

// Special Characters
AT						: '@';
COMMA					: ',' {maybeString = true;};
DOT						: '.';
SEMI_COLON				: ';' {maybeString = true;};
LEFT_BRACE				: '{' {maybeString = true;};
LEFT_PARENTHESIS		: '(' {maybeString = true;};
LEFT_SQUARE_BRACKET		: '[' {maybeString = true;};
QUESTION				: '?';
RIGHT_BRACE				: '}' {maybeString = false;};
RIGHT_PARENTHESIS		: ')' {maybeString = false;};
RIGHT_SQUARE_BRACKET	: ']' {maybeString = false;};

// Atoms - identifiers, strings, numbers, whitespace
ID: [a-zA-Z] [a-zA-Z0-9_]* { maybeString = false; };

IMAGINARY
:	INT 'i'
|	FLOAT 'i'
;

INT: DIGIT+;

FLOAT
:	DIGIT+ '.' DIGIT* EXPONENT?
|	DIGIT+			  EXPONENT
|		   '.' DIGIT+ EXPONENT?
;

fragment
EXPONENT: ('e'|'E') ('+'|'-')? DIGIT+;

fragment
DIGIT: [0-9];

STRING : {maybeString}? '\'' ( ~('\'' | '\r' | '\n') | '\'\'')* '\'';


//// Parser Rules ////
//////////////////////

// Atoms //
///////////

atom_boolean
:	'true'
|	'false'
;

atom_empty_array
:	LEFT_SQUARE_BRACKET RIGHT_SQUARE_BRACKET
;

atom_empty_cell
:	LEFT_BRACE RIGHT_BRACE
;

atom_end
:	END
;

atom_float
:	FLOAT
;

atom_imaginary
:	IMAGINARY
;

atom_index_all
:	COLON
;

atom_integer
:	INT
;

atom_meta
:	QUESTION atom_var
|	LEFT_BRACE (QUESTION atom_var (COMMA? QUESTION atom_var)*)? RIGHT_BRACE
;

atom_string
:	STRING
;

atom_var
:	ID
|	GET
|	SET
|	STATIC
;

matlab_file:
	( def_class | statement | def_function )*
;

// # Definitions
// 
// Definitions are MATLAB language constructs that only 'define' something. A definition when
// evaluated does not result in a value. A definition is a template only.

def_class
:	CLASSDEF 
	(	LEFT_PARENTHESIS 
		( attrib_class_boolean ( ASSIGN atom_boolean )? | attrib_class_meta ( ASSIGN atom_meta )? )*
		RIGHT_PARENTHESIS
	)*

	atom_var ( LESS_THAN atom_var (BINARY_AND atom_var)* )*

	(	PROPERTIES
		(	LEFT_PARENTHESIS
			(	attrib_property_boolean ( ASSIGN atom_boolean )?
			|	attrib_property_access  ( ASSIGN atom_access )?
			)
			(	COMMA
				(	attrib_property_boolean ( ASSIGN atom_boolean )?
				|	attrib_property_access  ( ASSIGN atom_access )?
				)
			)*
			RIGHT_PARENTHESIS
		)?	// Zero or one property attribute blocks
		( atom_var | st_assign )*
		END
	)*	// Zero or more property blocks
	
	(	'methods'
		(	LEFT_PARENTHESIS
			(	attrib_method_boolean ( ASSIGN atom_boolean )?
			|	attrib_method_access  ( ASSIGN atom_access )?
			)
			(	COMMA
				(	attrib_method_boolean ( ASSIGN atom_boolean )?
				|	attrib_method_access  ( ASSIGN atom_access )?
				)
			)*
			RIGHT_PARENTHESIS
		)?	// Zero or one property attribute blocks
		def_function*
		END
	)*	// Zero or more property blocks

	( RETURN | END )?
;

def_function:
	FUNCTION (function_returns ASSIGN)? ((GET | SET) DOT)? atom_var function_params?
	statement*
	(END | RETURN)?
;

attrib_class_boolean
:	'Abstract'
|	'ConstructOnLoad'
|	'HandleCompatible'
|	'Hidden'
|	'Sealed'
;

attrib_class_meta
:	'AllowedSubclasses'
|	'InferiorClasses'
;

attrib_property_boolean
:	'AbortSet'
|	'Abstract'
|	'Constant'
|	'Dependent'
|	'GetObservable'
|	'Hidden'
|	'NonCopyable'
|	'SetObservable'
|	'Transient'
;

attrib_property_access
:	'Access'
|	'GetAccess'
|	'SetAccess'	
;

attrib_method_boolean
:	'Abstract'
|	'Hidden'
|	'Sealed'
|	STATIC
;

attrib_method_access
:	'Access'
;

atom_access
:	'public'
|	'protected'
|	'private'
|	atom_meta
;

// # Statements

// MATLAB does allow for return values to be specified without a COMMA, e.g. [h w] = size(X); 
// However, it does give a warning saying this is not recommended. Thus we don't parse this kind
// of assignment.
st_assign
:	( atom_var | xpr_array_index | xpr_cell_index | xpr_field )
  	ASSIGN 
	( atom_empty_cell | xpr_tree | xpr_handle )

| 	LEFT_SQUARE_BRACKET 
	( NOT | atom_var | xpr_array_index | xpr_cell_index | xpr_field ) 
	( COMMA ( NOT | atom_var | xpr_array_index | xpr_cell_index | xpr_field ) )*
  	RIGHT_SQUARE_BRACKET

	ASSIGN 
	
	( atom_empty_cell | xpr_tree | xpr_handle )
;

st_command:
	atom_var command_argument+
;

// if_statement can be multiline or single line
st_if
:	(IF xpr_tree COMMA?
		statement*
	(ELSEIF xpr_tree COMMA?
		statement*)*
	(ELSE
		statement*)?
	END)
|	IF xpr_tree (COMMA | SEMI_COLON) statement (COMMA | SEMI_COLON) END
;

st_for:
	FOR atom_var ASSIGN xpr_tree COMMA?
		statement*
	END
;

st_switch:
	SWITCH xpr_tree
		(CASE xpr_tree
			statement*)*
		(OTHERWISE
			statement*)?
	END
;

st_try:
	TRY COMMA?
		statement*
	(CATCH atom_var?
		statement*)*
	END
;

st_while:
	WHILE xpr_tree COMMA?
		statement*
	END
;

function_params
:	LEFT_PARENTHESIS (atom_var (COMMA atom_var)*)? RIGHT_PARENTHESIS
;

function_returns
:	atom_var
|	LEFT_SQUARE_BRACKET atom_var (COMMA atom_var)* RIGHT_SQUARE_BRACKET
;

statement
:
   global_statement
   | clear_statement
   | assignment_statement
   | expression_statement
   | selection_statement
   | iteration_statement
   | jump_statement
   |
	(	st_assign
	| 	st_command
	| 	st_if
	| 	st_for
	| 	st_switch
	| 	st_try
	| 	st_while
	| 	xpr_function
	| 	xpr_field
	| 	xpr_tree
	| 	atom_var
	| 	BREAK
	| 	CONTINUE
	| 	RETURN
	)
( COMMA | SEMI_COLON )?
;

// ## Expression Trees
//
// Expression trees model a generic expression in MATLAB. The difference between `xpr_tree` and
// `xpr_tree_` (with underscore) is that `xpr_tree_` includes the `end` keyword can can be used
// for array or cell indexing. To make this work we also need `xpr_array_` and `xpr_cell_` which
// are analogous.
xpr_tree
:	atom_boolean
|	atom_empty_array
|	atom_float
|	atom_imaginary
|	atom_integer
|	atom_string
|	atom_var
|	xpr_array
|	xpr_array_index
|	xpr_cell
|	xpr_cell_index
|	xpr_field
|	xpr_function
|	LEFT_PARENTHESIS xpr_tree RIGHT_PARENTHESIS
|	xpr_tree (ELMENT_WISE_TRANSPOSE | TRANSPOSE)
|	xpr_tree (ELMENT_WISE_POWER | POWER) xpr_tree
|	(PLUS | MINUS | NOT) xpr_tree
|	xpr_tree (ELMENT_WISE_TIMES | ELMENT_WISE_RIGHT_DIVIDE | ELMENT_WISE_LEFT_DIVIDE) xpr_tree
|	xpr_tree (TIMES | RIGHT_DIVIDE | LEFT_DIVIDE) xpr_tree
|	xpr_tree (PLUS | MINUS) xpr_tree
|	xpr_tree COLON xpr_tree
|	xpr_tree LESS_THAN xpr_tree
|	xpr_tree LESS_THAN_OR_EQUAL xpr_tree
|	xpr_tree GREATER_THAN xpr_tree
|	xpr_tree GREATER_THAN_OR_EQUAL xpr_tree
|	xpr_tree EQUALS xpr_tree
|	xpr_tree NOT_EQUAL xpr_tree
|	xpr_tree BINARY_AND xpr_tree
|	xpr_tree BINARY_OR xpr_tree
|	xpr_tree LOGICAL_AND xpr_tree
|	xpr_tree LOGICAL_OR xpr_tree
;

xpr_tree_
:	atom_boolean
|	atom_empty_array
|	atom_end
|	atom_float
|	atom_imaginary
|	atom_integer
|	atom_string
|	atom_var
|	xpr_array_
|	xpr_array_index
|	xpr_cell_
|	xpr_cell_index
|	xpr_field
|	xpr_function
|	LEFT_PARENTHESIS xpr_tree_ RIGHT_PARENTHESIS
|	xpr_tree_ (ELMENT_WISE_TRANSPOSE | TRANSPOSE)
|	xpr_tree_ (ELMENT_WISE_POWER | POWER) xpr_tree_
|	(PLUS | MINUS | NOT) xpr_tree_
|	xpr_tree_ (ELMENT_WISE_TIMES | ELMENT_WISE_RIGHT_DIVIDE | ELMENT_WISE_LEFT_DIVIDE) xpr_tree_
|	xpr_tree_ (TIMES | RIGHT_DIVIDE | LEFT_DIVIDE) xpr_tree_
|	xpr_tree_ (PLUS | MINUS) xpr_tree_
|	xpr_tree_ COLON xpr_tree_
|	xpr_tree_ LESS_THAN xpr_tree_
|	xpr_tree_ LESS_THAN_OR_EQUAL xpr_tree_
|	xpr_tree_ GREATER_THAN xpr_tree_
|	xpr_tree_ GREATER_THAN_OR_EQUAL xpr_tree_
|	xpr_tree_ EQUALS xpr_tree_
|	xpr_tree_ NOT_EQUAL xpr_tree_
|	xpr_tree_ BINARY_AND xpr_tree_
|	xpr_tree_ BINARY_OR xpr_tree_
|	xpr_tree_ LOGICAL_AND xpr_tree_
|	xpr_tree_ LOGICAL_OR xpr_tree_
;

// Apparently MATLAB doesn't care whether you add commas to an array definition or not. E.g.
// [0 0 8]	[[0 0 8] [9 0 8]]	[[0 0 8],[9 0 8]]	[[0 0, 8],[9 0 8]] and
// [0 8 9, 10, 40 50 60] are all valid matlab expressions.
// The caveat is that you can't have two simultaneous commas. That throws an error. 
// E.g. [0,,1] is not allowed.
xpr_array
:	LEFT_SQUARE_BRACKET xpr_tree (COMMA? xpr_tree)* RIGHT_SQUARE_BRACKET
|	LEFT_SQUARE_BRACKET xpr_tree (COMMA? xpr_tree)* (SEMI_COLON xpr_tree (COMMA? xpr_tree)*)* RIGHT_SQUARE_BRACKET
;

xpr_array_
:	LEFT_SQUARE_BRACKET xpr_tree_ (COMMA? xpr_tree_)* RIGHT_SQUARE_BRACKET
|	LEFT_SQUARE_BRACKET xpr_tree_ (COMMA? xpr_tree_)* (SEMI_COLON xpr_tree_ (COMMA? xpr_tree_)*)* RIGHT_SQUARE_BRACKET
;

xpr_cell
:	LEFT_BRACE (xpr_tree | xpr_handle) (COMMA? (xpr_tree | xpr_handle))* RIGHT_BRACE
|	LEFT_BRACE (xpr_tree | xpr_handle) (COMMA? (xpr_tree | xpr_handle))* (SEMI_COLON (xpr_tree | xpr_handle) (COMMA? (xpr_tree | xpr_handle))*)* RIGHT_BRACE
;

xpr_cell_
:	LEFT_BRACE xpr_tree_ (COMMA? xpr_tree_)* RIGHT_BRACE
|	LEFT_BRACE xpr_tree_ (COMMA? xpr_tree_)* (SEMI_COLON xpr_tree_ (COMMA? xpr_tree_)*)* RIGHT_BRACE
;

// An array_index expression in MATLAB is an expression that takes an array and indexes it to give
// some subset of the array. This can work on multidimentional arrays or cell arrays.
// 
// SYNTAX
//	identifier (index_express [, indexexpression] ...)
xpr_array_index
:	(xpr_cell_index | atom_var) LEFT_PARENTHESIS (atom_index_all | xpr_tree_) (COMMA (atom_index_all | xpr_tree_))* RIGHT_PARENTHESIS
;

xpr_cell_index
:	atom_var LEFT_BRACE (atom_index_all | xpr_tree_) (COMMA (atom_index_all | xpr_tree_))* RIGHT_BRACE
;

// a.b == identifier DOT identifier
// a.b.c == (a.b).c == field_access DOT identifier
// a.b.c.f() == ((a.b).c).f()
xpr_field
:	atom_var DOT atom_var
|	atom_var DOT xpr_array_index
|	atom_var DOT xpr_cell_index
|	atom_var DOT xpr_function
|	xpr_array_index DOT atom_var
|	xpr_array_index DOT xpr_array_index
|	xpr_array_index DOT xpr_cell_index
|	xpr_array_index DOT xpr_function
|	xpr_cell_index DOT atom_var
|	xpr_cell_index DOT xpr_array_index
|	xpr_cell_index DOT xpr_cell_index
|	xpr_cell_index DOT xpr_function
|	xpr_field DOT atom_var
|	xpr_field DOT xpr_array_index
|	xpr_field DOT xpr_cell_index
|	xpr_field DOT xpr_function
;

xpr_function
:	atom_var 
	LEFT_PARENTHESIS 
	((xpr_tree | xpr_handle | atom_empty_cell) (COMMA (xpr_tree | xpr_handle | atom_empty_cell))*)? 
	RIGHT_PARENTHESIS
;

xpr_handle
:	AT atom_var
|	AT function_params statement
;

command_argument
:	ID
;