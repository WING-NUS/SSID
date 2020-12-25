grammar Ocaml;

and: 'and';        
as: 'as';   
Assert: 'assert';      
asr: 'asr';         
begin: 'begin';       
Class: 'class';
constraint: 'constraint';  
Do: 'do';          
done: 'done';        
downto: 'downto';     
Else: 'else';        
end: 'end';
exception: 'Exception';   
external: 'external';    
False: 'false';       
For: 'for';         
fun: 'fun';         
function: 'function';
functor: 'functor';     
If: 'if';          
in: 'in';          
include: 'include';     
inherit: 'inherit';     
initializer: 'initializer';
land: 'land';       
lazy: 'lazy';        
let: 'let';         
lor: 'lor';         
lsl: 'lsl';         
lsr: 'lsr';
lxor: 'lxor';        
match: 'match';       
method: 'method';      
mod: 'mod';         
module: 'module';      
mutable: 'mutable';
New: 'new';         
nonrec: 'nonrec';     
object: 'object';      
of: 'of';          
open: 'open';       
or: 'or';
Private: 'private';     
rec: 'rec';         
sig: 'sig';         
struct: 'struct';      
then: 'then';        
to: 'to';
True: 'true';        
Try: 'try';         
type: 'type';        
val: 'val';         
virtual: 'virtual';     
when: 'when';
While: 'while';       
with: 'with';

Ident: (Letter | '_' ) (Letter | '0' .. '9' | '_' )+;

CapitalizedIdent :	('A' .. 'Z') (Letter |  '0' .. '9' | '_' )+;  

LowercaseIdent: ('a' .. 'z' | '_' ) (Letter |  '0' .. '9' |  '_' )+; 

fragment Letter : 'A' .. 'Z' | 'a' .. 'z';

fragment Digit
   : '0' | NonZeroDigit
   ;

fragment NonZeroDigit
   : '1' .. '9'
   ;

fragment ExponentPart
   : ('E' | 'e') ('+' | '-')? Digit +
   ;

fragment PrintableChar
   : '\u0020' .. '\u007F'
   ;

fragment WhiteSpace
   : '\u0020' | '\u0009' | '\u000D' | '\u000A'
   ;

fragment CharEscapeSeq
    : '\\' ('b' | 't' | 'n' | 'r' | '"' | '\'' | '\\' | '\u0020')
    | '\\' ('0' .. '9') ('0' .. '9') ('0' .. '9')
    | '\\x' ('0' .. '9' | 'A' .. 'F' | 'a' .. 'f') ('0' .. '9' | 'A' .. 'F' | 'a' .. 'f')
    ;

fragment StringElement
   : '\u0020' | '\u0009' | '\u0023' .. '\u007F' | CharEscapeSeq
   ;

fragment MultiLineChars
   : '\\' NL ('\u0020' | '\u0009') 
   ;

WS
   :  WhiteSpace+ -> skip
   ;

NEWLINE
   : NL+ -> skip
   ;

IntegerLiteral	
    : '-'? ('0' .. '9') ('0' .. '9' |  '_')+  
 	| '-'? ('0x' | '0X') ('0' .. '9' | 'A' .. 'F' | 'a' .. 'f') ('0' .. '9' | 'A' .. 'F' | 'a' .. 'f' | '_')+  
 	| '-'? ('0o' | '0O') ('0' .. '7') ( '0' .. '7' | '_' )+  
 	| '-'? ('0b' | '0B') ('0' .. '1') ( '0' .. '1' | '_' )+
    ;  

FloatLiteral	
    : '-'? Digit + '.' Digit +  
    | '-'? Digit + ExponentPart
    ;

CharacterLiteral
   : '\'' (PrintableChar | CharEscapeSeq) '\''
   ;

StringLiteral
   : '"' StringElement* '"' | '"' MultiLineChars* '"'
   ;

NL
   : '\n'
   ;

LabelName	
    : LowercaseIdent
    ;  
 
Label	
    : '~' + LabelName + ':'
    ;  
 
OptLabel	
    : '?' + LabelName +  ':'
    ;

InfixSymbol
    : ('=' | '<' | '>' | '@' | '^' | '|' | '&' | '+' | '-' | '*' | '/' | '$' | '%') (OperatorChar)+
    ;

PrefixSymbol
    : '!' (OperatorChar)+
    | ('?' | '~') (OperatorChar)+
    ;

OperatorChar
    :  '!' | '$' | '%' | '&' | '*' | '+' | '-' | '.' | '/' 
    | ':' |'<' | '=' | '>' | '?' | '@' | '^' | '|' | '~'
    ;
 