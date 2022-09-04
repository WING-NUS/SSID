// Generated from /Users/sibinhho99/SSID/lib/antlr/grammars/src/haskell/HaskellLexer.g4 by ANTLR 4.8
package Antlr4Grammars.haskell;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HaskellLexer extends HaskellBaseLexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, TAB=2, WS=3, AS=4, CASE=5, CLASS=6, DATA=7, DEFAULT=8, DERIVING=9, 
		DO=10, ELSE=11, HIDING=12, IF=13, IMPORT=14, IN=15, INFIX=16, INFIXL=17, 
		INFIXR=18, INSTANCE=19, LET=20, MODULE=21, NEWTYPE=22, OF=23, QUALIFIED=24, 
		THEN=25, TYPE=26, WHERE=27, WILDCARD=28, FORALL=29, FOREIGN=30, EXPORT=31, 
		SAFE=32, INTERRUPTIBLE=33, UNSAFE=34, MDO=35, FAMILY=36, ROLE=37, STDCALL=38, 
		CCALL=39, CAPI=40, CPPCALL=41, JSCALL=42, REC=43, GROUP=44, BY=45, USING=46, 
		PATTERN=47, STOCK=48, ANYCLASS=49, VIA=50, LANGUAGE=51, OPTIONS_GHC=52, 
		OPTIONS=53, INLINE=54, NOINLINE=55, SPECIALISE=56, SPECINLINE=57, SOURCE=58, 
		RULES=59, SCC=60, DEPRECATED=61, WARNING=62, UNPACK=63, NOUNPACK=64, ANN=65, 
		MINIMAL=66, CTYPE=67, OVERLAPPING=68, OVERLAPPABLE=69, OVERLAPS=70, INCOHERENT=71, 
		COMPLETE=72, LCASE=73, DoubleArrow=74, DoubleColon=75, Arrow=76, Revarrow=77, 
		LarrowTail=78, RarrowTail=79, LLarrowTail=80, RRarrowTail=81, Hash=82, 
		Less=83, Greater=84, Ampersand=85, Pipe=86, Bang=87, Caret=88, Plus=89, 
		Minus=90, Asterisk=91, Percent=92, Divide=93, Tilde=94, Atsign=95, DDollar=96, 
		Dollar=97, DoubleDot=98, Dot=99, Semi=100, QuestionMark=101, Comma=102, 
		Colon=103, Eq=104, Quote=105, DoubleQuote=106, ReverseSlash=107, BackQuote=108, 
		AopenParen=109, AcloseParen=110, TopenTexpQuote=111, TcloseTExpQoute=112, 
		TopenExpQuote=113, TopenPatQuote=114, TopenTypQoute=115, TopenDecQoute=116, 
		TcloseQoute=117, OpenBoxParen=118, CloseBoxParen=119, OpenRoundBracket=120, 
		CloseRoundBracket=121, OpenSquareBracket=122, CloseSquareBracket=123, 
		CHAR=124, STRING=125, VARID=126, CONID=127, OpenPragmaBracket=128, ClosePragmaBracket=129, 
		COMMENT=130, NCOMMENT=131, OCURLY=132, CCURLY=133, VOCURLY=134, VCCURLY=135, 
		SEMI=136, DECIMAL=137, OCTAL=138, HEXADECIMAL=139, FLOAT=140, EXPONENT=141;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEWLINE", "TAB", "WS", "AS", "CASE", "CLASS", "DATA", "DEFAULT", "DERIVING", 
			"DO", "ELSE", "HIDING", "IF", "IMPORT", "IN", "INFIX", "INFIXL", "INFIXR", 
			"INSTANCE", "LET", "MODULE", "NEWTYPE", "OF", "QUALIFIED", "THEN", "TYPE", 
			"WHERE", "WILDCARD", "FORALL", "FOREIGN", "EXPORT", "SAFE", "INTERRUPTIBLE", 
			"UNSAFE", "MDO", "FAMILY", "ROLE", "STDCALL", "CCALL", "CAPI", "CPPCALL", 
			"JSCALL", "REC", "GROUP", "BY", "USING", "PATTERN", "STOCK", "ANYCLASS", 
			"VIA", "LANGUAGE", "OPTIONS_GHC", "OPTIONS", "INLINE", "NOINLINE", "SPECIALISE", 
			"SPECINLINE", "SOURCE", "RULES", "SCC", "DEPRECATED", "WARNING", "UNPACK", 
			"NOUNPACK", "ANN", "MINIMAL", "CTYPE", "OVERLAPPING", "OVERLAPPABLE", 
			"OVERLAPS", "INCOHERENT", "COMPLETE", "LCASE", "SYMBOL", "DoubleArrow", 
			"DoubleColon", "Arrow", "Revarrow", "LarrowTail", "RarrowTail", "LLarrowTail", 
			"RRarrowTail", "Hash", "Less", "Greater", "Ampersand", "Pipe", "Bang", 
			"Caret", "Plus", "Minus", "Asterisk", "Percent", "Divide", "Tilde", "Atsign", 
			"DDollar", "Dollar", "DoubleDot", "Dot", "Semi", "QuestionMark", "Comma", 
			"Colon", "Eq", "Quote", "DoubleQuote", "ReverseSlash", "BackQuote", "AopenParen", 
			"AcloseParen", "TopenTexpQuote", "TcloseTExpQoute", "TopenExpQuote", 
			"TopenPatQuote", "TopenTypQoute", "TopenDecQoute", "TcloseQoute", "OpenBoxParen", 
			"CloseBoxParen", "OpenRoundBracket", "CloseRoundBracket", "OpenSquareBracket", 
			"CloseSquareBracket", "CHAR", "STRING", "VARID", "CONID", "OpenPragmaBracket", 
			"ClosePragmaBracket", "COMMENT", "NCOMMENT", "OCURLY", "CCURLY", "VOCURLY", 
			"VCCURLY", "SEMI", "DECIMAL", "OCTAL", "HEXADECIMAL", "DIGIT", "ASCDIGIT", 
			"UNIDIGIT", "OCTIT", "HEXIT", "FLOAT", "EXPONENT", "LARGE", "ASCLARGE", 
			"UNILARGE", "SMALL", "ASCSMALL", "UNISMALL", "ASCSYMBOL", "UNISYMBOL", 
			"CLASSIFY_Sc", "CLASSIFY_Sk", "CLASSIFY_Sm", "CLASSIFY_So"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'as'", "'case'", "'class'", "'data'", "'default'", 
			"'deriving'", "'do'", "'else'", "'hiding'", "'if'", "'import'", "'in'", 
			"'infix'", "'infixl'", "'infixr'", "'instance'", "'let'", "'module'", 
			"'newtype'", "'of'", "'qualified'", "'then'", "'type'", "'where'", "'_'", 
			"'forall'", "'foreign'", "'export'", "'safe'", "'interruptible'", "'unsafe'", 
			"'mdo'", "'family'", "'role'", "'stdcall'", "'ccall'", "'capi'", "'cplusplus'", 
			"'javascript'", "'rec'", "'group'", "'by'", "'using'", "'pattern'", "'stock'", 
			"'anyclass'", "'via'", "'LANGUAGE'", "'OPTIONS_GHC'", "'OPTIONS'", "'INLINE'", 
			"'NOINLINE'", "'SPECIALISE'", "'SPECIALISE_INLINE'", "'SOURCE'", "'RULES'", 
			"'SCC'", "'DEPRECATED'", "'WARNING'", "'UNPACK'", "'NOUNPACK'", "'ANN'", 
			"'MINIMAL'", "'CTYPE'", "'OVERLAPPING'", "'OVERLAPPABLE'", "'OVERLAPS'", 
			"'INCOHERENT'", "'COMPLETE'", null, "'=>'", "'::'", "'->'", "'<-'", "'-<'", 
			"'>-'", "'-<<'", "'>>-'", "'#'", "'<'", "'>'", "'&'", "'|'", "'!'", "'^'", 
			"'+'", "'-'", "'*'", "'%'", "'/'", "'~'", "'@'", "'$$'", "'$'", "'..'", 
			"'.'", "';'", "'?'", "','", "':'", "'='", "'''", "''''", "'\\'", "'`'", 
			null, null, "'[||'", "'||]'", "'[|'", "'[p|'", "'[t|'", "'[d|'", "'|]'", 
			"'(#'", "'#)'", "'('", "')'", "'['", "']'", null, null, null, null, "'{-#'", 
			"'#-}'", null, null, "'{'", "'}'", "'VOCURLY'", "'VCCURLY'", "'SEMI'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "TAB", "WS", "AS", "CASE", "CLASS", "DATA", "DEFAULT", 
			"DERIVING", "DO", "ELSE", "HIDING", "IF", "IMPORT", "IN", "INFIX", "INFIXL", 
			"INFIXR", "INSTANCE", "LET", "MODULE", "NEWTYPE", "OF", "QUALIFIED", 
			"THEN", "TYPE", "WHERE", "WILDCARD", "FORALL", "FOREIGN", "EXPORT", "SAFE", 
			"INTERRUPTIBLE", "UNSAFE", "MDO", "FAMILY", "ROLE", "STDCALL", "CCALL", 
			"CAPI", "CPPCALL", "JSCALL", "REC", "GROUP", "BY", "USING", "PATTERN", 
			"STOCK", "ANYCLASS", "VIA", "LANGUAGE", "OPTIONS_GHC", "OPTIONS", "INLINE", 
			"NOINLINE", "SPECIALISE", "SPECINLINE", "SOURCE", "RULES", "SCC", "DEPRECATED", 
			"WARNING", "UNPACK", "NOUNPACK", "ANN", "MINIMAL", "CTYPE", "OVERLAPPING", 
			"OVERLAPPABLE", "OVERLAPS", "INCOHERENT", "COMPLETE", "LCASE", "DoubleArrow", 
			"DoubleColon", "Arrow", "Revarrow", "LarrowTail", "RarrowTail", "LLarrowTail", 
			"RRarrowTail", "Hash", "Less", "Greater", "Ampersand", "Pipe", "Bang", 
			"Caret", "Plus", "Minus", "Asterisk", "Percent", "Divide", "Tilde", "Atsign", 
			"DDollar", "Dollar", "DoubleDot", "Dot", "Semi", "QuestionMark", "Comma", 
			"Colon", "Eq", "Quote", "DoubleQuote", "ReverseSlash", "BackQuote", "AopenParen", 
			"AcloseParen", "TopenTexpQuote", "TcloseTExpQoute", "TopenExpQuote", 
			"TopenPatQuote", "TopenTypQoute", "TopenDecQoute", "TcloseQoute", "OpenBoxParen", 
			"CloseBoxParen", "OpenRoundBracket", "CloseRoundBracket", "OpenSquareBracket", 
			"CloseSquareBracket", "CHAR", "STRING", "VARID", "CONID", "OpenPragmaBracket", 
			"ClosePragmaBracket", "COMMENT", "NCOMMENT", "OCURLY", "CCURLY", "VOCURLY", 
			"VCCURLY", "SEMI", "DECIMAL", "OCTAL", "HEXADECIMAL", "FLOAT", "EXPONENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public HaskellLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HaskellLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 1:
			TAB_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 134:
			VOCURLY_action((RuleContext)_localctx, actionIndex);
			break;
		case 135:
			VCCURLY_action((RuleContext)_localctx, actionIndex);
			break;
		case 136:
			SEMI_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			    this.processNEWLINEToken();

			break;
		}
	}
	private void TAB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			    this.processTABToken();

			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:

			    this.processWSToken();

			break;
		}
	}
	private void VOCURLY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 this.SetHidden(); 
			break;
		}
	}
	private void VCCURLY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 this.SetHidden(); 
			break;
		}
	}
	private void SEMI_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 this.SetHidden(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\u008f\u04a5\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_"+
		"\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k"+
		"\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv"+
		"\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t"+
		"\u0080\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084"+
		"\4\u0085\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089"+
		"\t\u0089\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d"+
		"\4\u008e\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092"+
		"\t\u0092\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096"+
		"\4\u0097\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b"+
		"\t\u009b\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f"+
		"\4\u00a0\t\u00a0\3\2\5\2\u0143\n\2\3\2\3\2\5\2\u0147\n\2\3\2\3\2\3\3\6"+
		"\3\u014c\n\3\r\3\16\3\u014d\3\3\3\3\3\4\6\4\u0153\n\4\r\4\16\4\u0154\3"+
		"\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3"+
		" \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*"+
		"\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,"+
		"\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3"+
		"\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\38\38\38\38\38\38\38\38\38\39\39\39\39\39\39\39\39\39\3"+
		"9\39\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3"+
		";\3;\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3?\3?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3"+
		"A\3A\3A\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3D\3E\3E\3"+
		"E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3"+
		"G\3G\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3"+
		"I\3I\3I\3I\3I\3I\3J\3J\3J\7J\u0347\nJ\fJ\16J\u034a\13J\3J\3J\3J\3J\3J"+
		"\3K\3K\5K\u0353\nK\3L\3L\3L\3M\3M\3M\3N\3N\3N\3O\3O\3O\3P\3P\3P\3Q\3Q"+
		"\3Q\3R\3R\3R\3R\3S\3S\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z"+
		"\3[\3[\3\\\3\\\3]\3]\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\3b\3c\3c\3d\3d\3d\3"+
		"e\3e\3f\3f\3g\3g\3h\3h\3i\3i\3j\3j\3k\3k\3l\3l\3l\3m\3m\3n\3n\3o\3o\3"+
		"o\3o\3o\3p\3p\3p\3p\3q\3q\3q\3q\3r\3r\3r\3r\3s\3s\3s\3t\3t\3t\3t\3u\3"+
		"u\3u\3u\3v\3v\3v\3v\3w\3w\3w\3x\3x\3x\3y\3y\3y\3z\3z\3{\3{\3|\3|\3}\3"+
		"}\3~\3~\3~\3~\3~\3~\3~\3~\5~\u03e1\n~\3~\3~\3\177\3\177\3\177\3\177\3"+
		"\177\3\177\3\177\3\177\7\177\u03ed\n\177\f\177\16\177\u03f0\13\177\3\177"+
		"\3\177\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\7\u0080\u03f9\n\u0080\f"+
		"\u0080\16\u0080\u03fc\13\u0080\3\u0080\7\u0080\u03ff\n\u0080\f\u0080\16"+
		"\u0080\u0402\13\u0080\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\7\u0081"+
		"\u0409\n\u0081\f\u0081\16\u0081\u040c\13\u0081\3\u0081\7\u0081\u040f\n"+
		"\u0081\f\u0081\16\u0081\u0412\13\u0081\3\u0082\3\u0082\3\u0082\3\u0082"+
		"\3\u0083\3\u0083\3\u0083\3\u0083\3\u0084\3\u0084\3\u0084\3\u0084\7\u0084"+
		"\u0420\n\u0084\f\u0084\16\u0084\u0423\13\u0084\3\u0084\3\u0084\3\u0085"+
		"\3\u0085\3\u0085\3\u0085\3\u0085\7\u0085\u042c\n\u0085\f\u0085\16\u0085"+
		"\u042f\13\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0086\3\u0086"+
		"\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088"+
		"\3\u0088\3\u0088\3\u0088\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a"+
		"\3\u008a\3\u008a\3\u008b\6\u008b\u0456\n\u008b\r\u008b\16\u008b\u0457"+
		"\3\u008c\3\u008c\3\u008c\6\u008c\u045d\n\u008c\r\u008c\16\u008c\u045e"+
		"\3\u008d\3\u008d\3\u008d\6\u008d\u0464\n\u008d\r\u008d\16\u008d\u0465"+
		"\3\u008e\3\u008e\5\u008e\u046a\n\u008e\3\u008f\3\u008f\3\u0090\3\u0090"+
		"\3\u0091\3\u0091\3\u0092\5\u0092\u0473\n\u0092\3\u0093\3\u0093\3\u0093"+
		"\3\u0093\5\u0093\u0479\n\u0093\3\u0093\3\u0093\3\u0093\5\u0093\u047e\n"+
		"\u0093\3\u0094\3\u0094\5\u0094\u0482\n\u0094\3\u0094\3\u0094\3\u0095\3"+
		"\u0095\5\u0095\u0488\n\u0095\3\u0096\3\u0096\3\u0097\3\u0097\3\u0098\3"+
		"\u0098\5\u0098\u0490\n\u0098\3\u0099\3\u0099\3\u009a\3\u009a\3\u009b\3"+
		"\u009b\3\u009c\3\u009c\3\u009c\3\u009c\5\u009c\u049c\n\u009c\3\u009d\3"+
		"\u009d\3\u009e\3\u009e\3\u009f\3\u009f\3\u00a0\3\u00a0\3\u042d\2\u00a1"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o"+
		"9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH"+
		"\u008fI\u0091J\u0093K\u0095\2\u0097L\u0099M\u009bN\u009dO\u009fP\u00a1"+
		"Q\u00a3R\u00a5S\u00a7T\u00a9U\u00abV\u00adW\u00afX\u00b1Y\u00b3Z\u00b5"+
		"[\u00b7\\\u00b9]\u00bb^\u00bd_\u00bf`\u00c1a\u00c3b\u00c5c\u00c7d\u00c9"+
		"e\u00cbf\u00cdg\u00cfh\u00d1i\u00d3j\u00d5k\u00d7l\u00d9m\u00dbn\u00dd"+
		"o\u00dfp\u00e1q\u00e3r\u00e5s\u00e7t\u00e9u\u00ebv\u00edw\u00efx\u00f1"+
		"y\u00f3z\u00f5{\u00f7|\u00f9}\u00fb~\u00fd\177\u00ff\u0080\u0101\u0081"+
		"\u0103\u0082\u0105\u0083\u0107\u0084\u0109\u0085\u010b\u0086\u010d\u0087"+
		"\u010f\u0088\u0111\u0089\u0113\u008a\u0115\u008b\u0117\u008c\u0119\u008d"+
		"\u011b\2\u011d\2\u011f\2\u0121\2\u0123\2\u0125\u008e\u0127\u008f\u0129"+
		"\2\u012b\2\u012d\2\u012f\2\u0131\2\u0133\2\u0135\2\u0137\2\u0139\2\u013b"+
		"\2\u013d\2\u013f\2\3\2\31\3\2\13\13\n\2\"\"\u00a2\u00a2\u1682\u1682\u2002"+
		"\u2002\u200c\u200c\u2031\u2031\u2061\u2061\u3002\u3002\t\2$$*+..==]]_"+
		"_bb\b\2)+..==]]__bb\4\2\f\f\17\17\3\2%%\4\2QQqq\4\2ZZzz\3\2\62;&\2\u0662"+
		"\u066b\u06f2\u06fb\u07c2\u07cb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8"+
		"\u0af1\u0b68\u0b71\u0be8\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0de8"+
		"\u0df1\u0e52\u0e5b\u0ed2\u0edb\u0f22\u0f2b\u1042\u104b\u1092\u109b\u17e2"+
		"\u17eb\u1812\u181b\u1948\u1951\u19d2\u19db\u1a82\u1a8b\u1a92\u1a9b\u1b52"+
		"\u1b5b\u1bb2\u1bbb\u1c42\u1c4b\u1c52\u1c5b\ua622\ua62b\ua8d2\ua8db\ua902"+
		"\ua90b\ua9d2\ua9db\ua9f2\ua9fb\uaa52\uaa5b\uabf2\uabfb\uff12\uff1b\3\2"+
		"\629\5\2\62;CHch\4\2GGgg\4\2--//\3\2C\\\u0250\2\u00c2\u00d8\u00da\u00e0"+
		"\u0102\u0102\u0104\u0104\u0106\u0106\u0108\u0108\u010a\u010a\u010c\u010c"+
		"\u010e\u010e\u0110\u0110\u0112\u0112\u0114\u0114\u0116\u0116\u0118\u0118"+
		"\u011a\u011a\u011c\u011c\u011e\u011e\u0120\u0120\u0122\u0122\u0124\u0124"+
		"\u0126\u0126\u0128\u0128\u012a\u012a\u012c\u012c\u012e\u012e\u0130\u0130"+
		"\u0132\u0132\u0134\u0134\u0136\u0136\u0138\u0138\u013b\u013b\u013d\u013d"+
		"\u013f\u013f\u0141\u0141\u0143\u0143\u0145\u0145\u0147\u0147\u0149\u0149"+
		"\u014c\u014c\u014e\u014e\u0150\u0150\u0152\u0152\u0154\u0154\u0156\u0156"+
		"\u0158\u0158\u015a\u015a\u015c\u015c\u015e\u015e\u0160\u0160\u0162\u0162"+
		"\u0164\u0164\u0166\u0166\u0168\u0168\u016a\u016a\u016c\u016c\u016e\u016e"+
		"\u0170\u0170\u0172\u0172\u0174\u0174\u0176\u0176\u0178\u0178\u017a\u017b"+
		"\u017d\u017d\u017f\u017f\u0183\u0184\u0186\u0186\u0188\u0189\u018b\u018d"+
		"\u0190\u0193\u0195\u0196\u0198\u019a\u019e\u019f\u01a1\u01a2\u01a4\u01a4"+
		"\u01a6\u01a6\u01a8\u01a9\u01ab\u01ab\u01ae\u01ae\u01b0\u01b1\u01b3\u01b5"+
		"\u01b7\u01b7\u01b9\u01ba\u01be\u01be\u01c6\u01c6\u01c9\u01c9\u01cc\u01cc"+
		"\u01cf\u01cf\u01d1\u01d1\u01d3\u01d3\u01d5\u01d5\u01d7\u01d7\u01d9\u01d9"+
		"\u01db\u01db\u01dd\u01dd\u01e0\u01e0\u01e2\u01e2\u01e4\u01e4\u01e6\u01e6"+
		"\u01e8\u01e8\u01ea\u01ea\u01ec\u01ec\u01ee\u01ee\u01f0\u01f0\u01f3\u01f3"+
		"\u01f6\u01f6\u01f8\u01fa\u01fc\u01fc\u01fe\u01fe\u0200\u0200\u0202\u0202"+
		"\u0204\u0204\u0206\u0206\u0208\u0208\u020a\u020a\u020c\u020c\u020e\u020e"+
		"\u0210\u0210\u0212\u0212\u0214\u0214\u0216\u0216\u0218\u0218\u021a\u021a"+
		"\u021c\u021c\u021e\u021e\u0220\u0220\u0222\u0222\u0224\u0224\u0226\u0226"+
		"\u0228\u0228\u022a\u022a\u022c\u022c\u022e\u022e\u0230\u0230\u0232\u0232"+
		"\u0234\u0234\u023c\u023d\u023f\u0240\u0243\u0243\u0245\u0248\u024a\u024a"+
		"\u024c\u024c\u024e\u024e\u0250\u0250\u0372\u0372\u0374\u0374\u0378\u0378"+
		"\u0381\u0381\u0388\u0388\u038a\u038c\u038e\u038e\u0390\u0391\u0393\u03a3"+
		"\u03a5\u03ad\u03d1\u03d1\u03d4\u03d6\u03da\u03da\u03dc\u03dc\u03de\u03de"+
		"\u03e0\u03e0\u03e2\u03e2\u03e4\u03e4\u03e6\u03e6\u03e8\u03e8\u03ea\u03ea"+
		"\u03ec\u03ec\u03ee\u03ee\u03f0\u03f0\u03f6\u03f6\u03f9\u03f9\u03fb\u03fc"+
		"\u03ff\u0431\u0462\u0462\u0464\u0464\u0466\u0466\u0468\u0468\u046a\u046a"+
		"\u046c\u046c\u046e\u046e\u0470\u0470\u0472\u0472\u0474\u0474\u0476\u0476"+
		"\u0478\u0478\u047a\u047a\u047c\u047c\u047e\u047e\u0480\u0480\u0482\u0482"+
		"\u048c\u048c\u048e\u048e\u0490\u0490\u0492\u0492\u0494\u0494\u0496\u0496"+
		"\u0498\u0498\u049a\u049a\u049c\u049c\u049e\u049e\u04a0\u04a0\u04a2\u04a2"+
		"\u04a4\u04a4\u04a6\u04a6\u04a8\u04a8\u04aa\u04aa\u04ac\u04ac\u04ae\u04ae"+
		"\u04b0\u04b0\u04b2\u04b2\u04b4\u04b4\u04b6\u04b6\u04b8\u04b8\u04ba\u04ba"+
		"\u04bc\u04bc\u04be\u04be\u04c0\u04c0\u04c2\u04c3\u04c5\u04c5\u04c7\u04c7"+
		"\u04c9\u04c9\u04cb\u04cb\u04cd\u04cd\u04cf\u04cf\u04d2\u04d2\u04d4\u04d4"+
		"\u04d6\u04d6\u04d8\u04d8\u04da\u04da\u04dc\u04dc\u04de\u04de\u04e0\u04e0"+
		"\u04e2\u04e2\u04e4\u04e4\u04e6\u04e6\u04e8\u04e8\u04ea\u04ea\u04ec\u04ec"+
		"\u04ee\u04ee\u04f0\u04f0\u04f2\u04f2\u04f4\u04f4\u04f6\u04f6\u04f8\u04f8"+
		"\u04fa\u04fa\u04fc\u04fc\u04fe\u04fe\u0500\u0500\u0502\u0502\u0504\u0504"+
		"\u0506\u0506\u0508\u0508\u050a\u050a\u050c\u050c\u050e\u050e\u0510\u0510"+
		"\u0512\u0512\u0514\u0514\u0516\u0516\u0518\u0518\u051a\u051a\u051c\u051c"+
		"\u051e\u051e\u0520\u0520\u0522\u0522\u0524\u0524\u0526\u0526\u0528\u0528"+
		"\u052a\u052a\u052c\u052c\u052e\u052e\u0530\u0530\u0533\u0558\u10a2\u10c7"+
		"\u10c9\u10c9\u10cf\u10cf\u13a2\u13f7\u1e02\u1e02\u1e04\u1e04\u1e06\u1e06"+
		"\u1e08\u1e08\u1e0a\u1e0a\u1e0c\u1e0c\u1e0e\u1e0e\u1e10\u1e10\u1e12\u1e12"+
		"\u1e14\u1e14\u1e16\u1e16\u1e18\u1e18\u1e1a\u1e1a\u1e1c\u1e1c\u1e1e\u1e1e"+
		"\u1e20\u1e20\u1e22\u1e22\u1e24\u1e24\u1e26\u1e26\u1e28\u1e28\u1e2a\u1e2a"+
		"\u1e2c\u1e2c\u1e2e\u1e2e\u1e30\u1e30\u1e32\u1e32\u1e34\u1e34\u1e36\u1e36"+
		"\u1e38\u1e38\u1e3a\u1e3a\u1e3c\u1e3c\u1e3e\u1e3e\u1e40\u1e40\u1e42\u1e42"+
		"\u1e44\u1e44\u1e46\u1e46\u1e48\u1e48\u1e4a\u1e4a\u1e4c\u1e4c\u1e4e\u1e4e"+
		"\u1e50\u1e50\u1e52\u1e52\u1e54\u1e54\u1e56\u1e56\u1e58\u1e58\u1e5a\u1e5a"+
		"\u1e5c\u1e5c\u1e5e\u1e5e\u1e60\u1e60\u1e62\u1e62\u1e64\u1e64\u1e66\u1e66"+
		"\u1e68\u1e68\u1e6a\u1e6a\u1e6c\u1e6c\u1e6e\u1e6e\u1e70\u1e70\u1e72\u1e72"+
		"\u1e74\u1e74\u1e76\u1e76\u1e78\u1e78\u1e7a\u1e7a\u1e7c\u1e7c\u1e7e\u1e7e"+
		"\u1e80\u1e80\u1e82\u1e82\u1e84\u1e84\u1e86\u1e86\u1e88\u1e88\u1e8a\u1e8a"+
		"\u1e8c\u1e8c\u1e8e\u1e8e\u1e90\u1e90\u1e92\u1e92\u1e94\u1e94\u1e96\u1e96"+
		"\u1ea0\u1ea0\u1ea2\u1ea2\u1ea4\u1ea4\u1ea6\u1ea6\u1ea8\u1ea8\u1eaa\u1eaa"+
		"\u1eac\u1eac\u1eae\u1eae\u1eb0\u1eb0\u1eb2\u1eb2\u1eb4\u1eb4\u1eb6\u1eb6"+
		"\u1eb8\u1eb8\u1eba\u1eba\u1ebc\u1ebc\u1ebe\u1ebe\u1ec0\u1ec0\u1ec2\u1ec2"+
		"\u1ec4\u1ec4\u1ec6\u1ec6\u1ec8\u1ec8\u1eca\u1eca\u1ecc\u1ecc\u1ece\u1ece"+
		"\u1ed0\u1ed0\u1ed2\u1ed2\u1ed4\u1ed4\u1ed6\u1ed6\u1ed8\u1ed8\u1eda\u1eda"+
		"\u1edc\u1edc\u1ede\u1ede\u1ee0\u1ee0\u1ee2\u1ee2\u1ee4\u1ee4\u1ee6\u1ee6"+
		"\u1ee8\u1ee8\u1eea\u1eea\u1eec\u1eec\u1eee\u1eee\u1ef0\u1ef0\u1ef2\u1ef2"+
		"\u1ef4\u1ef4\u1ef6\u1ef6\u1ef8\u1ef8\u1efa\u1efa\u1efc\u1efc\u1efe\u1efe"+
		"\u1f00\u1f00\u1f0a\u1f11\u1f1a\u1f1f\u1f2a\u1f31\u1f3a\u1f41\u1f4a\u1f4f"+
		"\u1f5b\u1f5b\u1f5d\u1f5d\u1f5f\u1f5f\u1f61\u1f61\u1f6a\u1f71\u1fba\u1fbd"+
		"\u1fca\u1fcd\u1fda\u1fdd\u1fea\u1fee\u1ffa\u1ffd\u2104\u2104\u2109\u2109"+
		"\u210d\u210f\u2112\u2114\u2117\u2117\u211b\u211f\u2126\u2126\u2128\u2128"+
		"\u212a\u212a\u212c\u212f\u2132\u2135\u2140\u2141\u2147\u2147\u2185\u2185"+
		"\u2c02\u2c30\u2c62\u2c62\u2c64\u2c66\u2c69\u2c69\u2c6b\u2c6b\u2c6d\u2c6d"+
		"\u2c6f\u2c72\u2c74\u2c74\u2c77\u2c77\u2c80\u2c82\u2c84\u2c84\u2c86\u2c86"+
		"\u2c88\u2c88\u2c8a\u2c8a\u2c8c\u2c8c\u2c8e\u2c8e\u2c90\u2c90\u2c92\u2c92"+
		"\u2c94\u2c94\u2c96\u2c96\u2c98\u2c98\u2c9a\u2c9a\u2c9c\u2c9c\u2c9e\u2c9e"+
		"\u2ca0\u2ca0\u2ca2\u2ca2\u2ca4\u2ca4\u2ca6\u2ca6\u2ca8\u2ca8\u2caa\u2caa"+
		"\u2cac\u2cac\u2cae\u2cae\u2cb0\u2cb0\u2cb2\u2cb2\u2cb4\u2cb4\u2cb6\u2cb6"+
		"\u2cb8\u2cb8\u2cba\u2cba\u2cbc\u2cbc\u2cbe\u2cbe\u2cc0\u2cc0\u2cc2\u2cc2"+
		"\u2cc4\u2cc4\u2cc6\u2cc6\u2cc8\u2cc8\u2cca\u2cca\u2ccc\u2ccc\u2cce\u2cce"+
		"\u2cd0\u2cd0\u2cd2\u2cd2\u2cd4\u2cd4\u2cd6\u2cd6\u2cd8\u2cd8\u2cda\u2cda"+
		"\u2cdc\u2cdc\u2cde\u2cde\u2ce0\u2ce0\u2ce2\u2ce2\u2ce4\u2ce4\u2ced\u2ced"+
		"\u2cef\u2cef\u2cf4\u2cf4\ua642\ua642\ua644\ua644\ua646\ua646\ua648\ua648"+
		"\ua64a\ua64a\ua64c\ua64c\ua64e\ua64e\ua650\ua650\ua652\ua652\ua654\ua654"+
		"\ua656\ua656\ua658\ua658\ua65a\ua65a\ua65c\ua65c\ua65e\ua65e\ua660\ua660"+
		"\ua662\ua662\ua664\ua664\ua666\ua666\ua668\ua668\ua66a\ua66a\ua66c\ua66c"+
		"\ua66e\ua66e\ua682\ua682\ua684\ua684\ua686\ua686\ua688\ua688\ua68a\ua68a"+
		"\ua68c\ua68c\ua68e\ua68e\ua690\ua690\ua692\ua692\ua694\ua694\ua696\ua696"+
		"\ua698\ua698\ua69a\ua69a\ua69c\ua69c\ua724\ua724\ua726\ua726\ua728\ua728"+
		"\ua72a\ua72a\ua72c\ua72c\ua72e\ua72e\ua730\ua730\ua734\ua734\ua736\ua736"+
		"\ua738\ua738\ua73a\ua73a\ua73c\ua73c\ua73e\ua73e\ua740\ua740\ua742\ua742"+
		"\ua744\ua744\ua746\ua746\ua748\ua748\ua74a\ua74a\ua74c\ua74c\ua74e\ua74e"+
		"\ua750\ua750\ua752\ua752\ua754\ua754\ua756\ua756\ua758\ua758\ua75a\ua75a"+
		"\ua75c\ua75c\ua75e\ua75e\ua760\ua760\ua762\ua762\ua764\ua764\ua766\ua766"+
		"\ua768\ua768\ua76a\ua76a\ua76c\ua76c\ua76e\ua76e\ua770\ua770\ua77b\ua77b"+
		"\ua77d\ua77d\ua77f\ua780\ua782\ua782\ua784\ua784\ua786\ua786\ua788\ua788"+
		"\ua78d\ua78d\ua78f\ua78f\ua792\ua792\ua794\ua794\ua798\ua798\ua79a\ua79a"+
		"\ua79c\ua79c\ua79e\ua79e\ua7a0\ua7a0\ua7a2\ua7a2\ua7a4\ua7a4\ua7a6\ua7a6"+
		"\ua7a8\ua7a8\ua7aa\ua7aa\ua7ac\ua7b0\ua7b2\ua7b6\ua7b8\ua7b8\uff23\uff3c"+
		"\4\2aac|\u0259\2\u00b7\u00b7\u00e1\u00f8\u00fa\u0101\u0103\u0103\u0105"+
		"\u0105\u0107\u0107\u0109\u0109\u010b\u010b\u010d\u010d\u010f\u010f\u0111"+
		"\u0111\u0113\u0113\u0115\u0115\u0117\u0117\u0119\u0119\u011b\u011b\u011d"+
		"\u011d\u011f\u011f\u0121\u0121\u0123\u0123\u0125\u0125\u0127\u0127\u0129"+
		"\u0129\u012b\u012b\u012d\u012d\u012f\u012f\u0131\u0131\u0133\u0133\u0135"+
		"\u0135\u0137\u0137\u0139\u013a\u013c\u013c\u013e\u013e\u0140\u0140\u0142"+
		"\u0142\u0144\u0144\u0146\u0146\u0148\u0148\u014a\u014b\u014d\u014d\u014f"+
		"\u014f\u0151\u0151\u0153\u0153\u0155\u0155\u0157\u0157\u0159\u0159\u015b"+
		"\u015b\u015d\u015d\u015f\u015f\u0161\u0161\u0163\u0163\u0165\u0165\u0167"+
		"\u0167\u0169\u0169\u016b\u016b\u016d\u016d\u016f\u016f\u0171\u0171\u0173"+
		"\u0173\u0175\u0175\u0177\u0177\u0179\u0179\u017c\u017c\u017e\u017e\u0180"+
		"\u0182\u0185\u0185\u0187\u0187\u018a\u018a\u018e\u018f\u0194\u0194\u0197"+
		"\u0197\u019b\u019d\u01a0\u01a0\u01a3\u01a3\u01a5\u01a5\u01a7\u01a7\u01aa"+
		"\u01aa\u01ac\u01ad\u01af\u01af\u01b2\u01b2\u01b6\u01b6\u01b8\u01b8\u01bb"+
		"\u01bc\u01bf\u01c1\u01c8\u01c8\u01cb\u01cb\u01ce\u01ce\u01d0\u01d0\u01d2"+
		"\u01d2\u01d4\u01d4\u01d6\u01d6\u01d8\u01d8\u01da\u01da\u01dc\u01dc\u01de"+
		"\u01df\u01e1\u01e1\u01e3\u01e3\u01e5\u01e5\u01e7\u01e7\u01e9\u01e9\u01eb"+
		"\u01eb\u01ed\u01ed\u01ef\u01ef\u01f1\u01f2\u01f5\u01f5\u01f7\u01f7\u01fb"+
		"\u01fb\u01fd\u01fd\u01ff\u01ff\u0201\u0201\u0203\u0203\u0205\u0205\u0207"+
		"\u0207\u0209\u0209\u020b\u020b\u020d\u020d\u020f\u020f\u0211\u0211\u0213"+
		"\u0213\u0215\u0215\u0217\u0217\u0219\u0219\u021b\u021b\u021d\u021d\u021f"+
		"\u021f\u0221\u0221\u0223\u0223\u0225\u0225\u0227\u0227\u0229\u0229\u022b"+
		"\u022b\u022d\u022d\u022f\u022f\u0231\u0231\u0233\u0233\u0235\u023b\u023e"+
		"\u023e\u0241\u0242\u0244\u0244\u0249\u0249\u024b\u024b\u024d\u024d\u024f"+
		"\u024f\u0251\u0295\u0297\u02b1\u0373\u0373\u0375\u0375\u0379\u0379\u037d"+
		"\u037f\u0392\u0392\u03ae\u03d0\u03d2\u03d3\u03d7\u03d9\u03db\u03db\u03dd"+
		"\u03dd\u03df\u03df\u03e1\u03e1\u03e3\u03e3\u03e5\u03e5\u03e7\u03e7\u03e9"+
		"\u03e9\u03eb\u03eb\u03ed\u03ed\u03ef\u03ef\u03f1\u03f5\u03f7\u03f7\u03fa"+
		"\u03fa\u03fd\u03fe\u0432\u0461\u0463\u0463\u0465\u0465\u0467\u0467\u0469"+
		"\u0469\u046b\u046b\u046d\u046d\u046f\u046f\u0471\u0471\u0473\u0473\u0475"+
		"\u0475\u0477\u0477\u0479\u0479\u047b\u047b\u047d\u047d\u047f\u047f\u0481"+
		"\u0481\u0483\u0483\u048d\u048d\u048f\u048f\u0491\u0491\u0493\u0493\u0495"+
		"\u0495\u0497\u0497\u0499\u0499\u049b\u049b\u049d\u049d\u049f\u049f\u04a1"+
		"\u04a1\u04a3\u04a3\u04a5\u04a5\u04a7\u04a7\u04a9\u04a9\u04ab\u04ab\u04ad"+
		"\u04ad\u04af\u04af\u04b1\u04b1\u04b3\u04b3\u04b5\u04b5\u04b7\u04b7\u04b9"+
		"\u04b9\u04bb\u04bb\u04bd\u04bd\u04bf\u04bf\u04c1\u04c1\u04c4\u04c4\u04c6"+
		"\u04c6\u04c8\u04c8\u04ca\u04ca\u04cc\u04cc\u04ce\u04ce\u04d0\u04d1\u04d3"+
		"\u04d3\u04d5\u04d5\u04d7\u04d7\u04d9\u04d9\u04db\u04db\u04dd\u04dd\u04df"+
		"\u04df\u04e1\u04e1\u04e3\u04e3\u04e5\u04e5\u04e7\u04e7\u04e9\u04e9\u04eb"+
		"\u04eb\u04ed\u04ed\u04ef\u04ef\u04f1\u04f1\u04f3\u04f3\u04f5\u04f5\u04f7"+
		"\u04f7\u04f9\u04f9\u04fb\u04fb\u04fd\u04fd\u04ff\u04ff\u0501\u0501\u0503"+
		"\u0503\u0505\u0505\u0507\u0507\u0509\u0509\u050b\u050b\u050d\u050d\u050f"+
		"\u050f\u0511\u0511\u0513\u0513\u0515\u0515\u0517\u0517\u0519\u0519\u051b"+
		"\u051b\u051d\u051d\u051f\u051f\u0521\u0521\u0523\u0523\u0525\u0525\u0527"+
		"\u0527\u0529\u0529\u052b\u052b\u052d\u052d\u052f\u052f\u0531\u0531\u0563"+
		"\u0589\u13fa\u13ff\u1c82\u1c8a\u1d02\u1d2d\u1d6d\u1d79\u1d7b\u1d9c\u1e03"+
		"\u1e03\u1e05\u1e05\u1e07\u1e07\u1e09\u1e09\u1e0b\u1e0b\u1e0d\u1e0d\u1e0f"+
		"\u1e0f\u1e11\u1e11\u1e13\u1e13\u1e15\u1e15\u1e17\u1e17\u1e19\u1e19\u1e1b"+
		"\u1e1b\u1e1d\u1e1d\u1e1f\u1e1f\u1e21\u1e21\u1e23\u1e23\u1e25\u1e25\u1e27"+
		"\u1e27\u1e29\u1e29\u1e2b\u1e2b\u1e2d\u1e2d\u1e2f\u1e2f\u1e31\u1e31\u1e33"+
		"\u1e33\u1e35\u1e35\u1e37\u1e37\u1e39\u1e39\u1e3b\u1e3b\u1e3d\u1e3d\u1e3f"+
		"\u1e3f\u1e41\u1e41\u1e43\u1e43\u1e45\u1e45\u1e47\u1e47\u1e49\u1e49\u1e4b"+
		"\u1e4b\u1e4d\u1e4d\u1e4f\u1e4f\u1e51\u1e51\u1e53\u1e53\u1e55\u1e55\u1e57"+
		"\u1e57\u1e59\u1e59\u1e5b\u1e5b\u1e5d\u1e5d\u1e5f\u1e5f\u1e61\u1e61\u1e63"+
		"\u1e63\u1e65\u1e65\u1e67\u1e67\u1e69\u1e69\u1e6b\u1e6b\u1e6d\u1e6d\u1e6f"+
		"\u1e6f\u1e71\u1e71\u1e73\u1e73\u1e75\u1e75\u1e77\u1e77\u1e79\u1e79\u1e7b"+
		"\u1e7b\u1e7d\u1e7d\u1e7f\u1e7f\u1e81\u1e81\u1e83\u1e83\u1e85\u1e85\u1e87"+
		"\u1e87\u1e89\u1e89\u1e8b\u1e8b\u1e8d\u1e8d\u1e8f\u1e8f\u1e91\u1e91\u1e93"+
		"\u1e93\u1e95\u1e95\u1e97\u1e9f\u1ea1\u1ea1\u1ea3\u1ea3\u1ea5\u1ea5\u1ea7"+
		"\u1ea7\u1ea9\u1ea9\u1eab\u1eab\u1ead\u1ead\u1eaf\u1eaf\u1eb1\u1eb1\u1eb3"+
		"\u1eb3\u1eb5\u1eb5\u1eb7\u1eb7\u1eb9\u1eb9\u1ebb\u1ebb\u1ebd\u1ebd\u1ebf"+
		"\u1ebf\u1ec1\u1ec1\u1ec3\u1ec3\u1ec5\u1ec5\u1ec7\u1ec7\u1ec9\u1ec9\u1ecb"+
		"\u1ecb\u1ecd\u1ecd\u1ecf\u1ecf\u1ed1\u1ed1\u1ed3\u1ed3\u1ed5\u1ed5\u1ed7"+
		"\u1ed7\u1ed9\u1ed9\u1edb\u1edb\u1edd\u1edd\u1edf\u1edf\u1ee1\u1ee1\u1ee3"+
		"\u1ee3\u1ee5\u1ee5\u1ee7\u1ee7\u1ee9\u1ee9\u1eeb\u1eeb\u1eed\u1eed\u1eef"+
		"\u1eef\u1ef1\u1ef1\u1ef3\u1ef3\u1ef5\u1ef5\u1ef7\u1ef7\u1ef9\u1ef9\u1efb"+
		"\u1efb\u1efd\u1efd\u1eff\u1eff\u1f01\u1f09\u1f12\u1f17\u1f22\u1f29\u1f32"+
		"\u1f39\u1f42\u1f47\u1f52\u1f59\u1f62\u1f69\u1f72\u1f7f\u1f82\u1f89\u1f92"+
		"\u1f99\u1fa2\u1fa9\u1fb2\u1fb6\u1fb8\u1fb9\u1fc0\u1fc0\u1fc4\u1fc6\u1fc8"+
		"\u1fc9\u1fd2\u1fd5\u1fd8\u1fd9\u1fe2\u1fe9\u1ff4\u1ff6\u1ff8\u1ff9\u210c"+
		"\u210c\u2110\u2111\u2115\u2115\u2131\u2131\u2136\u2136\u213b\u213b\u213e"+
		"\u213f\u2148\u214b\u2150\u2150\u2186\u2186\u2c32\u2c60\u2c63\u2c63\u2c67"+
		"\u2c68\u2c6a\u2c6a\u2c6c\u2c6c\u2c6e\u2c6e\u2c73\u2c73\u2c75\u2c76\u2c78"+
		"\u2c7d\u2c83\u2c83\u2c85\u2c85\u2c87\u2c87\u2c89\u2c89\u2c8b\u2c8b\u2c8d"+
		"\u2c8d\u2c8f\u2c8f\u2c91\u2c91\u2c93\u2c93\u2c95\u2c95\u2c97\u2c97\u2c99"+
		"\u2c99\u2c9b\u2c9b\u2c9d\u2c9d\u2c9f\u2c9f\u2ca1\u2ca1\u2ca3\u2ca3\u2ca5"+
		"\u2ca5\u2ca7\u2ca7\u2ca9\u2ca9\u2cab\u2cab\u2cad\u2cad\u2caf\u2caf\u2cb1"+
		"\u2cb1\u2cb3\u2cb3\u2cb5\u2cb5\u2cb7\u2cb7\u2cb9\u2cb9\u2cbb\u2cbb\u2cbd"+
		"\u2cbd\u2cbf\u2cbf\u2cc1\u2cc1\u2cc3\u2cc3\u2cc5\u2cc5\u2cc7\u2cc7\u2cc9"+
		"\u2cc9\u2ccb\u2ccb\u2ccd\u2ccd\u2ccf\u2ccf\u2cd1\u2cd1\u2cd3\u2cd3\u2cd5"+
		"\u2cd5\u2cd7\u2cd7\u2cd9\u2cd9\u2cdb\u2cdb\u2cdd\u2cdd\u2cdf\u2cdf\u2ce1"+
		"\u2ce1\u2ce3\u2ce3\u2ce5\u2ce6\u2cee\u2cee\u2cf0\u2cf0\u2cf5\u2cf5\u2d02"+
		"\u2d27\u2d29\u2d29\u2d2f\u2d2f\ua643\ua643\ua645\ua645\ua647\ua647\ua649"+
		"\ua649\ua64b\ua64b\ua64d\ua64d\ua64f\ua64f\ua651\ua651\ua653\ua653\ua655"+
		"\ua655\ua657\ua657\ua659\ua659\ua65b\ua65b\ua65d\ua65d\ua65f\ua65f\ua661"+
		"\ua661\ua663\ua663\ua665\ua665\ua667\ua667\ua669\ua669\ua66b\ua66b\ua66d"+
		"\ua66d\ua66f\ua66f\ua683\ua683\ua685\ua685\ua687\ua687\ua689\ua689\ua68b"+
		"\ua68b\ua68d\ua68d\ua68f\ua68f\ua691\ua691\ua693\ua693\ua695\ua695\ua697"+
		"\ua697\ua699\ua699\ua69b\ua69b\ua69d\ua69d\ua725\ua725\ua727\ua727\ua729"+
		"\ua729\ua72b\ua72b\ua72d\ua72d\ua72f\ua72f\ua731\ua733\ua735\ua735\ua737"+
		"\ua737\ua739\ua739\ua73b\ua73b\ua73d\ua73d\ua73f\ua73f\ua741\ua741\ua743"+
		"\ua743\ua745\ua745\ua747\ua747\ua749\ua749\ua74b\ua74b\ua74d\ua74d\ua74f"+
		"\ua74f\ua751\ua751\ua753\ua753\ua755\ua755\ua757\ua757\ua759\ua759\ua75b"+
		"\ua75b\ua75d\ua75d\ua75f\ua75f\ua761\ua761\ua763\ua763\ua765\ua765\ua767"+
		"\ua767\ua769\ua769\ua76b\ua76b\ua76d\ua76d\ua76f\ua76f\ua771\ua771\ua773"+
		"\ua77a\ua77c\ua77c\ua77e\ua77e\ua781\ua781\ua783\ua783\ua785\ua785\ua787"+
		"\ua787\ua789\ua789\ua78e\ua78e\ua790\ua790\ua793\ua793\ua795\ua797\ua799"+
		"\ua799\ua79b\ua79b\ua79d\ua79d\ua79f\ua79f\ua7a1\ua7a1\ua7a3\ua7a3\ua7a5"+
		"\ua7a5\ua7a7\ua7a7\ua7a9\ua7a9\ua7ab\ua7ab\ua7b7\ua7b7\ua7b9\ua7b9\ua7fc"+
		"\ua7fc\uab32\uab5c\uab62\uab67\uab72\uabc1\ufb02\ufb08\ufb15\ufb19\uff43"+
		"\uff5c\f\2##%(,-/\61<<>B^^``~~\u0080\u0080\23\2&&\u00a4\u00a7\u0591\u0591"+
		"\u060d\u060d\u09f4\u09f5\u09fd\u09fd\u0af3\u0af3\u0bfb\u0bfb\u0e41\u0e41"+
		"\u17dd\u17dd\u20a2\u20c0\ua83a\ua83a\ufdfe\ufdfe\ufe6b\ufe6b\uff06\uff06"+
		"\uffe2\uffe3\uffe7\uffe8\36\2``bb\u00aa\u00aa\u00b1\u00b1\u00b6\u00b6"+
		"\u00ba\u00ba\u02c4\u02c7\u02d4\u02e1\u02e7\u02ed\u02ef\u02ef\u02f1\u0301"+
		"\u0377\u0377\u0386\u0387\u1fbf\u1fbf\u1fc1\u1fc3\u1fcf\u1fd1\u1fdf\u1fe1"+
		"\u1fef\u1ff1\u1fff\u2000\u309d\u309e\ua702\ua718\ua722\ua723\ua78b\ua78c"+
		"\uab5d\uab5d\ufbb4\ufbc3\uff40\uff40\uff42\uff42\uffe5\uffe5\67\2-->@"+
		"~~\u0080\u0080\u00ae\u00ae\u00b3\u00b3\u00d9\u00d9\u00f9\u00f9\u03f8\u03f8"+
		"\u0608\u060a\u2046\u2046\u2054\u2054\u207c\u207e\u208c\u208e\u211a\u211a"+
		"\u2142\u2146\u214d\u214d\u2192\u2196\u219c\u219d\u21a2\u21a2\u21a5\u21a5"+
		"\u21a8\u21a8\u21b0\u21b0\u21d0\u21d1\u21d4\u21d4\u21d6\u21d6\u21f6\u2301"+
		"\u2322\u2323\u237e\u237e\u239d\u23b5\u23de\u23e3\u25b9\u25b9\u25c3\u25c3"+
		"\u25fa\u2601\u2671\u2671\u27c2\u27c6\u27c9\u27e7\u27f2\u2801\u2902\u2984"+
		"\u299b\u29d9\u29de\u29fd\u2a00\u2b01\u2b32\u2b46\u2b49\u2b4e\ufb2b\ufb2b"+
		"\ufe64\ufe64\ufe66\ufe68\uff0d\uff0d\uff1e\uff20\uff5e\uff5e\uff60\uff60"+
		"\uffe4\uffe4\uffeb\uffeeu\2\u00a8\u00a8\u00ab\u00ab\u00b0\u00b0\u00b2"+
		"\u00b2\u0484\u0484\u058f\u0590\u0610\u0611\u06e0\u06e0\u06eb\u06eb\u06ff"+
		"\u0700\u07f8\u07f8\u09fc\u09fc\u0b72\u0b72\u0bf5\u0bfa\u0bfc\u0bfc\u0c81"+
		"\u0c81\u0d51\u0d51\u0d7b\u0d7b\u0f03\u0f05\u0f15\u0f15\u0f17\u0f19\u0f1c"+
		"\u0f21\u0f36\u0f36\u0f38\u0f38\u0f3a\u0f3a\u0fc0\u0fc7\u0fc9\u0fce\u0fd0"+
		"\u0fd1\u0fd7\u0fda\u10a0\u10a1\u1392\u139b\u1942\u1942\u19e0\u1a01\u1b63"+
		"\u1b6c\u1b76\u1b7e\u2102\u2103\u2105\u2108\u210a\u210b\u2116\u2116\u2118"+
		"\u2119\u2120\u2125\u2127\u2127\u2129\u2129\u212b\u212b\u2130\u2130\u213c"+
		"\u213d\u214c\u214c\u214e\u214f\u2151\u2151\u218c\u218d\u2197\u219b\u219e"+
		"\u21a1\u21a3\u21a4\u21a6\u21a7\u21a9\u21af\u21b1\u21cf\u21d2\u21d3\u21d5"+
		"\u21d5\u21d7\u21f5\u2302\u2309\u230e\u2321\u2324\u232a\u232d\u237d\u237f"+
		"\u239c\u23b6\u23dd\u23e4\u2400\u2402\u2428\u2442\u244c\u249e\u24eb\u2502"+
		"\u25b8\u25ba\u25c2\u25c4\u25f9\u2602\u2670\u2672\u2769\u2796\u27c1\u2802"+
		"\u2901\u2b02\u2b31\u2b47\u2b48\u2b4f\u2b75\u2b78\u2b97\u2b9a\u2bbb\u2bbf"+
		"\u2bca\u2bcc\u2bd3\u2bee\u2bf1\u2ce7\u2cec\u2e82\u2e9b\u2e9d\u2ef5\u2f02"+
		"\u2fd7\u2ff2\u2ffd\u3006\u3006\u3014\u3015\u3022\u3022\u3038\u3039\u3040"+
		"\u3041\u3192\u3193\u3198\u31a1\u31c2\u31e5\u3202\u3220\u322c\u3249\u3252"+
		"\u3252\u3262\u3281\u328c\u32b2\u32c2\u3300\u3302\u3401\u4dc2\u4e01\ua492"+
		"\ua4c8\ua82a\ua82d\ua838\ua839\ua83b\ua83b\uaa79\uaa7b\ufdff\ufdff\uffe6"+
		"\uffe6\uffea\uffea\uffef\ufff0\ufffe\uffff\2\u04be\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2"+
		"\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3"+
		"\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2"+
		"\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b"+
		"\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2"+
		"\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad"+
		"\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2"+
		"\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf"+
		"\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2"+
		"\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1"+
		"\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2\2\2\u00d9\3\2\2"+
		"\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df\3\2\2\2\2\u00e1\3\2\2\2\2\u00e3"+
		"\3\2\2\2\2\u00e5\3\2\2\2\2\u00e7\3\2\2\2\2\u00e9\3\2\2\2\2\u00eb\3\2\2"+
		"\2\2\u00ed\3\2\2\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2\2\2\u00f3\3\2\2\2\2\u00f5"+
		"\3\2\2\2\2\u00f7\3\2\2\2\2\u00f9\3\2\2\2\2\u00fb\3\2\2\2\2\u00fd\3\2\2"+
		"\2\2\u00ff\3\2\2\2\2\u0101\3\2\2\2\2\u0103\3\2\2\2\2\u0105\3\2\2\2\2\u0107"+
		"\3\2\2\2\2\u0109\3\2\2\2\2\u010b\3\2\2\2\2\u010d\3\2\2\2\2\u010f\3\2\2"+
		"\2\2\u0111\3\2\2\2\2\u0113\3\2\2\2\2\u0115\3\2\2\2\2\u0117\3\2\2\2\2\u0119"+
		"\3\2\2\2\2\u0125\3\2\2\2\2\u0127\3\2\2\2\3\u0146\3\2\2\2\5\u014b\3\2\2"+
		"\2\7\u0152\3\2\2\2\t\u0158\3\2\2\2\13\u015b\3\2\2\2\r\u0160\3\2\2\2\17"+
		"\u0166\3\2\2\2\21\u016b\3\2\2\2\23\u0173\3\2\2\2\25\u017c\3\2\2\2\27\u017f"+
		"\3\2\2\2\31\u0184\3\2\2\2\33\u018b\3\2\2\2\35\u018e\3\2\2\2\37\u0195\3"+
		"\2\2\2!\u0198\3\2\2\2#\u019e\3\2\2\2%\u01a5\3\2\2\2\'\u01ac\3\2\2\2)\u01b5"+
		"\3\2\2\2+\u01b9\3\2\2\2-\u01c0\3\2\2\2/\u01c8\3\2\2\2\61\u01cb\3\2\2\2"+
		"\63\u01d5\3\2\2\2\65\u01da\3\2\2\2\67\u01df\3\2\2\29\u01e5\3\2\2\2;\u01e7"+
		"\3\2\2\2=\u01ee\3\2\2\2?\u01f6\3\2\2\2A\u01fd\3\2\2\2C\u0202\3\2\2\2E"+
		"\u0210\3\2\2\2G\u0217\3\2\2\2I\u021b\3\2\2\2K\u0222\3\2\2\2M\u0227\3\2"+
		"\2\2O\u022f\3\2\2\2Q\u0235\3\2\2\2S\u023a\3\2\2\2U\u0244\3\2\2\2W\u024f"+
		"\3\2\2\2Y\u0253\3\2\2\2[\u0259\3\2\2\2]\u025c\3\2\2\2_\u0262\3\2\2\2a"+
		"\u026a\3\2\2\2c\u0270\3\2\2\2e\u0279\3\2\2\2g\u027d\3\2\2\2i\u0286\3\2"+
		"\2\2k\u0292\3\2\2\2m\u029a\3\2\2\2o\u02a1\3\2\2\2q\u02aa\3\2\2\2s\u02b5"+
		"\3\2\2\2u\u02c7\3\2\2\2w\u02ce\3\2\2\2y\u02d4\3\2\2\2{\u02d8\3\2\2\2}"+
		"\u02e3\3\2\2\2\177\u02eb\3\2\2\2\u0081\u02f2\3\2\2\2\u0083\u02fb\3\2\2"+
		"\2\u0085\u02ff\3\2\2\2\u0087\u0307\3\2\2\2\u0089\u030d\3\2\2\2\u008b\u0319"+
		"\3\2\2\2\u008d\u0326\3\2\2\2\u008f\u032f\3\2\2\2\u0091\u033a\3\2\2\2\u0093"+
		"\u0343\3\2\2\2\u0095\u0352\3\2\2\2\u0097\u0354\3\2\2\2\u0099\u0357\3\2"+
		"\2\2\u009b\u035a\3\2\2\2\u009d\u035d\3\2\2\2\u009f\u0360\3\2\2\2\u00a1"+
		"\u0363\3\2\2\2\u00a3\u0366\3\2\2\2\u00a5\u036a\3\2\2\2\u00a7\u036e\3\2"+
		"\2\2\u00a9\u0370\3\2\2\2\u00ab\u0372\3\2\2\2\u00ad\u0374\3\2\2\2\u00af"+
		"\u0376\3\2\2\2\u00b1\u0378\3\2\2\2\u00b3\u037a\3\2\2\2\u00b5\u037c\3\2"+
		"\2\2\u00b7\u037e\3\2\2\2\u00b9\u0380\3\2\2\2\u00bb\u0382\3\2\2\2\u00bd"+
		"\u0384\3\2\2\2\u00bf\u0386\3\2\2\2\u00c1\u0388\3\2\2\2\u00c3\u038a\3\2"+
		"\2\2\u00c5\u038d\3\2\2\2\u00c7\u038f\3\2\2\2\u00c9\u0392\3\2\2\2\u00cb"+
		"\u0394\3\2\2\2\u00cd\u0396\3\2\2\2\u00cf\u0398\3\2\2\2\u00d1\u039a\3\2"+
		"\2\2\u00d3\u039c\3\2\2\2\u00d5\u039e\3\2\2\2\u00d7\u03a0\3\2\2\2\u00d9"+
		"\u03a3\3\2\2\2\u00db\u03a5\3\2\2\2\u00dd\u03a7\3\2\2\2\u00df\u03ac\3\2"+
		"\2\2\u00e1\u03b0\3\2\2\2\u00e3\u03b4\3\2\2\2\u00e5\u03b8\3\2\2\2\u00e7"+
		"\u03bb\3\2\2\2\u00e9\u03bf\3\2\2\2\u00eb\u03c3\3\2\2\2\u00ed\u03c7\3\2"+
		"\2\2\u00ef\u03ca\3\2\2\2\u00f1\u03cd\3\2\2\2\u00f3\u03d0\3\2\2\2\u00f5"+
		"\u03d2\3\2\2\2\u00f7\u03d4\3\2\2\2\u00f9\u03d6\3\2\2\2\u00fb\u03d8\3\2"+
		"\2\2\u00fd\u03e4\3\2\2\2\u00ff\u03f3\3\2\2\2\u0101\u0403\3\2\2\2\u0103"+
		"\u0413\3\2\2\2\u0105\u0417\3\2\2\2\u0107\u041b\3\2\2\2\u0109\u0426\3\2"+
		"\2\2\u010b\u0435\3\2\2\2\u010d\u0437\3\2\2\2\u010f\u0439\3\2\2\2\u0111"+
		"\u0443\3\2\2\2\u0113\u044d\3\2\2\2\u0115\u0455\3\2\2\2\u0117\u0459\3\2"+
		"\2\2\u0119\u0460\3\2\2\2\u011b\u0469\3\2\2\2\u011d\u046b\3\2\2\2\u011f"+
		"\u046d\3\2\2\2\u0121\u046f\3\2\2\2\u0123\u0472\3\2\2\2\u0125\u047d\3\2"+
		"\2\2\u0127\u047f\3\2\2\2\u0129\u0487\3\2\2\2\u012b\u0489\3\2\2\2\u012d"+
		"\u048b\3\2\2\2\u012f\u048f\3\2\2\2\u0131\u0491\3\2\2\2\u0133\u0493\3\2"+
		"\2\2\u0135\u0495\3\2\2\2\u0137\u049b\3\2\2\2\u0139\u049d\3\2\2\2\u013b"+
		"\u049f\3\2\2\2\u013d\u04a1\3\2\2\2\u013f\u04a3\3\2\2\2\u0141\u0143\7\17"+
		"\2\2\u0142\u0141\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u0147\7\f\2\2\u0145\u0147\7\17\2\2\u0146\u0142\3\2\2\2\u0146\u0145\3"+
		"\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\b\2\2\2\u0149\4\3\2\2\2\u014a\u014c"+
		"\t\2\2\2\u014b\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014b\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\b\3\3\2\u0150\6\3\2\2\2"+
		"\u0151\u0153\t\3\2\2\u0152\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0152"+
		"\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\b\4\4\2\u0157"+
		"\b\3\2\2\2\u0158\u0159\7c\2\2\u0159\u015a\7u\2\2\u015a\n\3\2\2\2\u015b"+
		"\u015c\7e\2\2\u015c\u015d\7c\2\2\u015d\u015e\7u\2\2\u015e\u015f\7g\2\2"+
		"\u015f\f\3\2\2\2\u0160\u0161\7e\2\2\u0161\u0162\7n\2\2\u0162\u0163\7c"+
		"\2\2\u0163\u0164\7u\2\2\u0164\u0165\7u\2\2\u0165\16\3\2\2\2\u0166\u0167"+
		"\7f\2\2\u0167\u0168\7c\2\2\u0168\u0169\7v\2\2\u0169\u016a\7c\2\2\u016a"+
		"\20\3\2\2\2\u016b\u016c\7f\2\2\u016c\u016d\7g\2\2\u016d\u016e\7h\2\2\u016e"+
		"\u016f\7c\2\2\u016f\u0170\7w\2\2\u0170\u0171\7n\2\2\u0171\u0172\7v\2\2"+
		"\u0172\22\3\2\2\2\u0173\u0174\7f\2\2\u0174\u0175\7g\2\2\u0175\u0176\7"+
		"t\2\2\u0176\u0177\7k\2\2\u0177\u0178\7x\2\2\u0178\u0179\7k\2\2\u0179\u017a"+
		"\7p\2\2\u017a\u017b\7i\2\2\u017b\24\3\2\2\2\u017c\u017d\7f\2\2\u017d\u017e"+
		"\7q\2\2\u017e\26\3\2\2\2\u017f\u0180\7g\2\2\u0180\u0181\7n\2\2\u0181\u0182"+
		"\7u\2\2\u0182\u0183\7g\2\2\u0183\30\3\2\2\2\u0184\u0185\7j\2\2\u0185\u0186"+
		"\7k\2\2\u0186\u0187\7f\2\2\u0187\u0188\7k\2\2\u0188\u0189\7p\2\2\u0189"+
		"\u018a\7i\2\2\u018a\32\3\2\2\2\u018b\u018c\7k\2\2\u018c\u018d\7h\2\2\u018d"+
		"\34\3\2\2\2\u018e\u018f\7k\2\2\u018f\u0190\7o\2\2\u0190\u0191\7r\2\2\u0191"+
		"\u0192\7q\2\2\u0192\u0193\7t\2\2\u0193\u0194\7v\2\2\u0194\36\3\2\2\2\u0195"+
		"\u0196\7k\2\2\u0196\u0197\7p\2\2\u0197 \3\2\2\2\u0198\u0199\7k\2\2\u0199"+
		"\u019a\7p\2\2\u019a\u019b\7h\2\2\u019b\u019c\7k\2\2\u019c\u019d\7z\2\2"+
		"\u019d\"\3\2\2\2\u019e\u019f\7k\2\2\u019f\u01a0\7p\2\2\u01a0\u01a1\7h"+
		"\2\2\u01a1\u01a2\7k\2\2\u01a2\u01a3\7z\2\2\u01a3\u01a4\7n\2\2\u01a4$\3"+
		"\2\2\2\u01a5\u01a6\7k\2\2\u01a6\u01a7\7p\2\2\u01a7\u01a8\7h\2\2\u01a8"+
		"\u01a9\7k\2\2\u01a9\u01aa\7z\2\2\u01aa\u01ab\7t\2\2\u01ab&\3\2\2\2\u01ac"+
		"\u01ad\7k\2\2\u01ad\u01ae\7p\2\2\u01ae\u01af\7u\2\2\u01af\u01b0\7v\2\2"+
		"\u01b0\u01b1\7c\2\2\u01b1\u01b2\7p\2\2\u01b2\u01b3\7e\2\2\u01b3\u01b4"+
		"\7g\2\2\u01b4(\3\2\2\2\u01b5\u01b6\7n\2\2\u01b6\u01b7\7g\2\2\u01b7\u01b8"+
		"\7v\2\2\u01b8*\3\2\2\2\u01b9\u01ba\7o\2\2\u01ba\u01bb\7q\2\2\u01bb\u01bc"+
		"\7f\2\2\u01bc\u01bd\7w\2\2\u01bd\u01be\7n\2\2\u01be\u01bf\7g\2\2\u01bf"+
		",\3\2\2\2\u01c0\u01c1\7p\2\2\u01c1\u01c2\7g\2\2\u01c2\u01c3\7y\2\2\u01c3"+
		"\u01c4\7v\2\2\u01c4\u01c5\7{\2\2\u01c5\u01c6\7r\2\2\u01c6\u01c7\7g\2\2"+
		"\u01c7.\3\2\2\2\u01c8\u01c9\7q\2\2\u01c9\u01ca\7h\2\2\u01ca\60\3\2\2\2"+
		"\u01cb\u01cc\7s\2\2\u01cc\u01cd\7w\2\2\u01cd\u01ce\7c\2\2\u01ce\u01cf"+
		"\7n\2\2\u01cf\u01d0\7k\2\2\u01d0\u01d1\7h\2\2\u01d1\u01d2\7k\2\2\u01d2"+
		"\u01d3\7g\2\2\u01d3\u01d4\7f\2\2\u01d4\62\3\2\2\2\u01d5\u01d6\7v\2\2\u01d6"+
		"\u01d7\7j\2\2\u01d7\u01d8\7g\2\2\u01d8\u01d9\7p\2\2\u01d9\64\3\2\2\2\u01da"+
		"\u01db\7v\2\2\u01db\u01dc\7{\2\2\u01dc\u01dd\7r\2\2\u01dd\u01de\7g\2\2"+
		"\u01de\66\3\2\2\2\u01df\u01e0\7y\2\2\u01e0\u01e1\7j\2\2\u01e1\u01e2\7"+
		"g\2\2\u01e2\u01e3\7t\2\2\u01e3\u01e4\7g\2\2\u01e48\3\2\2\2\u01e5\u01e6"+
		"\7a\2\2\u01e6:\3\2\2\2\u01e7\u01e8\7h\2\2\u01e8\u01e9\7q\2\2\u01e9\u01ea"+
		"\7t\2\2\u01ea\u01eb\7c\2\2\u01eb\u01ec\7n\2\2\u01ec\u01ed\7n\2\2\u01ed"+
		"<\3\2\2\2\u01ee\u01ef\7h\2\2\u01ef\u01f0\7q\2\2\u01f0\u01f1\7t\2\2\u01f1"+
		"\u01f2\7g\2\2\u01f2\u01f3\7k\2\2\u01f3\u01f4\7i\2\2\u01f4\u01f5\7p\2\2"+
		"\u01f5>\3\2\2\2\u01f6\u01f7\7g\2\2\u01f7\u01f8\7z\2\2\u01f8\u01f9\7r\2"+
		"\2\u01f9\u01fa\7q\2\2\u01fa\u01fb\7t\2\2\u01fb\u01fc\7v\2\2\u01fc@\3\2"+
		"\2\2\u01fd\u01fe\7u\2\2\u01fe\u01ff\7c\2\2\u01ff\u0200\7h\2\2\u0200\u0201"+
		"\7g\2\2\u0201B\3\2\2\2\u0202\u0203\7k\2\2\u0203\u0204\7p\2\2\u0204\u0205"+
		"\7v\2\2\u0205\u0206\7g\2\2\u0206\u0207\7t\2\2\u0207\u0208\7t\2\2\u0208"+
		"\u0209\7w\2\2\u0209\u020a\7r\2\2\u020a\u020b\7v\2\2\u020b\u020c\7k\2\2"+
		"\u020c\u020d\7d\2\2\u020d\u020e\7n\2\2\u020e\u020f\7g\2\2\u020fD\3\2\2"+
		"\2\u0210\u0211\7w\2\2\u0211\u0212\7p\2\2\u0212\u0213\7u\2\2\u0213\u0214"+
		"\7c\2\2\u0214\u0215\7h\2\2\u0215\u0216\7g\2\2\u0216F\3\2\2\2\u0217\u0218"+
		"\7o\2\2\u0218\u0219\7f\2\2\u0219\u021a\7q\2\2\u021aH\3\2\2\2\u021b\u021c"+
		"\7h\2\2\u021c\u021d\7c\2\2\u021d\u021e\7o\2\2\u021e\u021f\7k\2\2\u021f"+
		"\u0220\7n\2\2\u0220\u0221\7{\2\2\u0221J\3\2\2\2\u0222\u0223\7t\2\2\u0223"+
		"\u0224\7q\2\2\u0224\u0225\7n\2\2\u0225\u0226\7g\2\2\u0226L\3\2\2\2\u0227"+
		"\u0228\7u\2\2\u0228\u0229\7v\2\2\u0229\u022a\7f\2\2\u022a\u022b\7e\2\2"+
		"\u022b\u022c\7c\2\2\u022c\u022d\7n\2\2\u022d\u022e\7n\2\2\u022eN\3\2\2"+
		"\2\u022f\u0230\7e\2\2\u0230\u0231\7e\2\2\u0231\u0232\7c\2\2\u0232\u0233"+
		"\7n\2\2\u0233\u0234\7n\2\2\u0234P\3\2\2\2\u0235\u0236\7e\2\2\u0236\u0237"+
		"\7c\2\2\u0237\u0238\7r\2\2\u0238\u0239\7k\2\2\u0239R\3\2\2\2\u023a\u023b"+
		"\7e\2\2\u023b\u023c\7r\2\2\u023c\u023d\7n\2\2\u023d\u023e\7w\2\2\u023e"+
		"\u023f\7u\2\2\u023f\u0240\7r\2\2\u0240\u0241\7n\2\2\u0241\u0242\7w\2\2"+
		"\u0242\u0243\7u\2\2\u0243T\3\2\2\2\u0244\u0245\7l\2\2\u0245\u0246\7c\2"+
		"\2\u0246\u0247\7x\2\2\u0247\u0248\7c\2\2\u0248\u0249\7u\2\2\u0249\u024a"+
		"\7e\2\2\u024a\u024b\7t\2\2\u024b\u024c\7k\2\2\u024c\u024d\7r\2\2\u024d"+
		"\u024e\7v\2\2\u024eV\3\2\2\2\u024f\u0250\7t\2\2\u0250\u0251\7g\2\2\u0251"+
		"\u0252\7e\2\2\u0252X\3\2\2\2\u0253\u0254\7i\2\2\u0254\u0255\7t\2\2\u0255"+
		"\u0256\7q\2\2\u0256\u0257\7w\2\2\u0257\u0258\7r\2\2\u0258Z\3\2\2\2\u0259"+
		"\u025a\7d\2\2\u025a\u025b\7{\2\2\u025b\\\3\2\2\2\u025c\u025d\7w\2\2\u025d"+
		"\u025e\7u\2\2\u025e\u025f\7k\2\2\u025f\u0260\7p\2\2\u0260\u0261\7i\2\2"+
		"\u0261^\3\2\2\2\u0262\u0263\7r\2\2\u0263\u0264\7c\2\2\u0264\u0265\7v\2"+
		"\2\u0265\u0266\7v\2\2\u0266\u0267\7g\2\2\u0267\u0268\7t\2\2\u0268\u0269"+
		"\7p\2\2\u0269`\3\2\2\2\u026a\u026b\7u\2\2\u026b\u026c\7v\2\2\u026c\u026d"+
		"\7q\2\2\u026d\u026e\7e\2\2\u026e\u026f\7m\2\2\u026fb\3\2\2\2\u0270\u0271"+
		"\7c\2\2\u0271\u0272\7p\2\2\u0272\u0273\7{\2\2\u0273\u0274\7e\2\2\u0274"+
		"\u0275\7n\2\2\u0275\u0276\7c\2\2\u0276\u0277\7u\2\2\u0277\u0278\7u\2\2"+
		"\u0278d\3\2\2\2\u0279\u027a\7x\2\2\u027a\u027b\7k\2\2\u027b\u027c\7c\2"+
		"\2\u027cf\3\2\2\2\u027d\u027e\7N\2\2\u027e\u027f\7C\2\2\u027f\u0280\7"+
		"P\2\2\u0280\u0281\7I\2\2\u0281\u0282\7W\2\2\u0282\u0283\7C\2\2\u0283\u0284"+
		"\7I\2\2\u0284\u0285\7G\2\2\u0285h\3\2\2\2\u0286\u0287\7Q\2\2\u0287\u0288"+
		"\7R\2\2\u0288\u0289\7V\2\2\u0289\u028a\7K\2\2\u028a\u028b\7Q\2\2\u028b"+
		"\u028c\7P\2\2\u028c\u028d\7U\2\2\u028d\u028e\7a\2\2\u028e\u028f\7I\2\2"+
		"\u028f\u0290\7J\2\2\u0290\u0291\7E\2\2\u0291j\3\2\2\2\u0292\u0293\7Q\2"+
		"\2\u0293\u0294\7R\2\2\u0294\u0295\7V\2\2\u0295\u0296\7K\2\2\u0296\u0297"+
		"\7Q\2\2\u0297\u0298\7P\2\2\u0298\u0299\7U\2\2\u0299l\3\2\2\2\u029a\u029b"+
		"\7K\2\2\u029b\u029c\7P\2\2\u029c\u029d\7N\2\2\u029d\u029e\7K\2\2\u029e"+
		"\u029f\7P\2\2\u029f\u02a0\7G\2\2\u02a0n\3\2\2\2\u02a1\u02a2\7P\2\2\u02a2"+
		"\u02a3\7Q\2\2\u02a3\u02a4\7K\2\2\u02a4\u02a5\7P\2\2\u02a5\u02a6\7N\2\2"+
		"\u02a6\u02a7\7K\2\2\u02a7\u02a8\7P\2\2\u02a8\u02a9\7G\2\2\u02a9p\3\2\2"+
		"\2\u02aa\u02ab\7U\2\2\u02ab\u02ac\7R\2\2\u02ac\u02ad\7G\2\2\u02ad\u02ae"+
		"\7E\2\2\u02ae\u02af\7K\2\2\u02af\u02b0\7C\2\2\u02b0\u02b1\7N\2\2\u02b1"+
		"\u02b2\7K\2\2\u02b2\u02b3\7U\2\2\u02b3\u02b4\7G\2\2\u02b4r\3\2\2\2\u02b5"+
		"\u02b6\7U\2\2\u02b6\u02b7\7R\2\2\u02b7\u02b8\7G\2\2\u02b8\u02b9\7E\2\2"+
		"\u02b9\u02ba\7K\2\2\u02ba\u02bb\7C\2\2\u02bb\u02bc\7N\2\2\u02bc\u02bd"+
		"\7K\2\2\u02bd\u02be\7U\2\2\u02be\u02bf\7G\2\2\u02bf\u02c0\7a\2\2\u02c0"+
		"\u02c1\7K\2\2\u02c1\u02c2\7P\2\2\u02c2\u02c3\7N\2\2\u02c3\u02c4\7K\2\2"+
		"\u02c4\u02c5\7P\2\2\u02c5\u02c6\7G\2\2\u02c6t\3\2\2\2\u02c7\u02c8\7U\2"+
		"\2\u02c8\u02c9\7Q\2\2\u02c9\u02ca\7W\2\2\u02ca\u02cb\7T\2\2\u02cb\u02cc"+
		"\7E\2\2\u02cc\u02cd\7G\2\2\u02cdv\3\2\2\2\u02ce\u02cf\7T\2\2\u02cf\u02d0"+
		"\7W\2\2\u02d0\u02d1\7N\2\2\u02d1\u02d2\7G\2\2\u02d2\u02d3\7U\2\2\u02d3"+
		"x\3\2\2\2\u02d4\u02d5\7U\2\2\u02d5\u02d6\7E\2\2\u02d6\u02d7\7E\2\2\u02d7"+
		"z\3\2\2\2\u02d8\u02d9\7F\2\2\u02d9\u02da\7G\2\2\u02da\u02db\7R\2\2\u02db"+
		"\u02dc\7T\2\2\u02dc\u02dd\7G\2\2\u02dd\u02de\7E\2\2\u02de\u02df\7C\2\2"+
		"\u02df\u02e0\7V\2\2\u02e0\u02e1\7G\2\2\u02e1\u02e2\7F\2\2\u02e2|\3\2\2"+
		"\2\u02e3\u02e4\7Y\2\2\u02e4\u02e5\7C\2\2\u02e5\u02e6\7T\2\2\u02e6\u02e7"+
		"\7P\2\2\u02e7\u02e8\7K\2\2\u02e8\u02e9\7P\2\2\u02e9\u02ea\7I\2\2\u02ea"+
		"~\3\2\2\2\u02eb\u02ec\7W\2\2\u02ec\u02ed\7P\2\2\u02ed\u02ee\7R\2\2\u02ee"+
		"\u02ef\7C\2\2\u02ef\u02f0\7E\2\2\u02f0\u02f1\7M\2\2\u02f1\u0080\3\2\2"+
		"\2\u02f2\u02f3\7P\2\2\u02f3\u02f4\7Q\2\2\u02f4\u02f5\7W\2\2\u02f5\u02f6"+
		"\7P\2\2\u02f6\u02f7\7R\2\2\u02f7\u02f8\7C\2\2\u02f8\u02f9\7E\2\2\u02f9"+
		"\u02fa\7M\2\2\u02fa\u0082\3\2\2\2\u02fb\u02fc\7C\2\2\u02fc\u02fd\7P\2"+
		"\2\u02fd\u02fe\7P\2\2\u02fe\u0084\3\2\2\2\u02ff\u0300\7O\2\2\u0300\u0301"+
		"\7K\2\2\u0301\u0302\7P\2\2\u0302\u0303\7K\2\2\u0303\u0304\7O\2\2\u0304"+
		"\u0305\7C\2\2\u0305\u0306\7N\2\2\u0306\u0086\3\2\2\2\u0307\u0308\7E\2"+
		"\2\u0308\u0309\7V\2\2\u0309\u030a\7[\2\2\u030a\u030b\7R\2\2\u030b\u030c"+
		"\7G\2\2\u030c\u0088\3\2\2\2\u030d\u030e\7Q\2\2\u030e\u030f\7X\2\2\u030f"+
		"\u0310\7G\2\2\u0310\u0311\7T\2\2\u0311\u0312\7N\2\2\u0312\u0313\7C\2\2"+
		"\u0313\u0314\7R\2\2\u0314\u0315\7R\2\2\u0315\u0316\7K\2\2\u0316\u0317"+
		"\7P\2\2\u0317\u0318\7I\2\2\u0318\u008a\3\2\2\2\u0319\u031a\7Q\2\2\u031a"+
		"\u031b\7X\2\2\u031b\u031c\7G\2\2\u031c\u031d\7T\2\2\u031d\u031e\7N\2\2"+
		"\u031e\u031f\7C\2\2\u031f\u0320\7R\2\2\u0320\u0321\7R\2\2\u0321\u0322"+
		"\7C\2\2\u0322\u0323\7D\2\2\u0323\u0324\7N\2\2\u0324\u0325\7G\2\2\u0325"+
		"\u008c\3\2\2\2\u0326\u0327\7Q\2\2\u0327\u0328\7X\2\2\u0328\u0329\7G\2"+
		"\2\u0329\u032a\7T\2\2\u032a\u032b\7N\2\2\u032b\u032c\7C\2\2\u032c\u032d"+
		"\7R\2\2\u032d\u032e\7U\2\2\u032e\u008e\3\2\2\2\u032f\u0330\7K\2\2\u0330"+
		"\u0331\7P\2\2\u0331\u0332\7E\2\2\u0332\u0333\7Q\2\2\u0333\u0334\7J\2\2"+
		"\u0334\u0335\7G\2\2\u0335\u0336\7T\2\2\u0336\u0337\7G\2\2\u0337\u0338"+
		"\7P\2\2\u0338\u0339\7V\2\2\u0339\u0090\3\2\2\2\u033a\u033b\7E\2\2\u033b"+
		"\u033c\7Q\2\2\u033c\u033d\7O\2\2\u033d\u033e\7R\2\2\u033e\u033f\7N\2\2"+
		"\u033f\u0340\7G\2\2\u0340\u0341\7V\2\2\u0341\u0342\7G\2\2\u0342\u0092"+
		"\3\2\2\2\u0343\u0348\7^\2\2\u0344\u0347\5\3\2\2\u0345\u0347\5\7\4\2\u0346"+
		"\u0344\3\2\2\2\u0346\u0345\3\2\2\2\u0347\u034a\3\2\2\2\u0348\u0346\3\2"+
		"\2\2\u0348\u0349\3\2\2\2\u0349\u034b\3\2\2\2\u034a\u0348\3\2\2\2\u034b"+
		"\u034c\7e\2\2\u034c\u034d\7c\2\2\u034d\u034e\7u\2\2\u034e\u034f\7g\2\2"+
		"\u034f\u0094\3\2\2\2\u0350\u0353\5\u0135\u009b\2\u0351\u0353\5\u0137\u009c"+
		"\2\u0352\u0350\3\2\2\2\u0352\u0351\3\2\2\2\u0353\u0096\3\2\2\2\u0354\u0355"+
		"\7?\2\2\u0355\u0356\7@\2\2\u0356\u0098\3\2\2\2\u0357\u0358\7<\2\2\u0358"+
		"\u0359\7<\2\2\u0359\u009a\3\2\2\2\u035a\u035b\7/\2\2\u035b\u035c\7@\2"+
		"\2\u035c\u009c\3\2\2\2\u035d\u035e\7>\2\2\u035e\u035f\7/\2\2\u035f\u009e"+
		"\3\2\2\2\u0360\u0361\7/\2\2\u0361\u0362\7>\2\2\u0362\u00a0\3\2\2\2\u0363"+
		"\u0364\7@\2\2\u0364\u0365\7/\2\2\u0365\u00a2\3\2\2\2\u0366\u0367\7/\2"+
		"\2\u0367\u0368\7>\2\2\u0368\u0369\7>\2\2\u0369\u00a4\3\2\2\2\u036a\u036b"+
		"\7@\2\2\u036b\u036c\7@\2\2\u036c\u036d\7/\2\2\u036d\u00a6\3\2\2\2\u036e"+
		"\u036f\7%\2\2\u036f\u00a8\3\2\2\2\u0370\u0371\7>\2\2\u0371\u00aa\3\2\2"+
		"\2\u0372\u0373\7@\2\2\u0373\u00ac\3\2\2\2\u0374\u0375\7(\2\2\u0375\u00ae"+
		"\3\2\2\2\u0376\u0377\7~\2\2\u0377\u00b0\3\2\2\2\u0378\u0379\7#\2\2\u0379"+
		"\u00b2\3\2\2\2\u037a\u037b\7`\2\2\u037b\u00b4\3\2\2\2\u037c\u037d\7-\2"+
		"\2\u037d\u00b6\3\2\2\2\u037e\u037f\7/\2\2\u037f\u00b8\3\2\2\2\u0380\u0381"+
		"\7,\2\2\u0381\u00ba\3\2\2\2\u0382\u0383\7\'\2\2\u0383\u00bc\3\2\2\2\u0384"+
		"\u0385\7\61\2\2\u0385\u00be\3\2\2\2\u0386\u0387\7\u0080\2\2\u0387\u00c0"+
		"\3\2\2\2\u0388\u0389\7B\2\2\u0389\u00c2\3\2\2\2\u038a\u038b\7&\2\2\u038b"+
		"\u038c\7&\2\2\u038c\u00c4\3\2\2\2\u038d\u038e\7&\2\2\u038e\u00c6\3\2\2"+
		"\2\u038f\u0390\7\60\2\2\u0390\u0391\7\60\2\2\u0391\u00c8\3\2\2\2\u0392"+
		"\u0393\7\60\2\2\u0393\u00ca\3\2\2\2\u0394\u0395\7=\2\2\u0395\u00cc\3\2"+
		"\2\2\u0396\u0397\7A\2\2\u0397\u00ce\3\2\2\2\u0398\u0399\7.\2\2\u0399\u00d0"+
		"\3\2\2\2\u039a\u039b\7<\2\2\u039b\u00d2\3\2\2\2\u039c\u039d\7?\2\2\u039d"+
		"\u00d4\3\2\2\2\u039e\u039f\7)\2\2\u039f\u00d6\3\2\2\2\u03a0\u03a1\7)\2"+
		"\2\u03a1\u03a2\7)\2\2\u03a2\u00d8\3\2\2\2\u03a3\u03a4\7^\2\2\u03a4\u00da"+
		"\3\2\2\2\u03a5\u03a6\7b\2\2\u03a6\u00dc\3\2\2\2\u03a7\u03a8\7*\2\2\u03a8"+
		"\u03a9\7~\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ab\5\7\4\2\u03ab\u00de\3\2"+
		"\2\2\u03ac\u03ad\5\7\4\2\u03ad\u03ae\7~\2\2\u03ae\u03af\7+\2\2\u03af\u00e0"+
		"\3\2\2\2\u03b0\u03b1\7]\2\2\u03b1\u03b2\7~\2\2\u03b2\u03b3\7~\2\2\u03b3"+
		"\u00e2\3\2\2\2\u03b4\u03b5\7~\2\2\u03b5\u03b6\7~\2\2\u03b6\u03b7\7_\2"+
		"\2\u03b7\u00e4\3\2\2\2\u03b8\u03b9\7]\2\2\u03b9\u03ba\7~\2\2\u03ba\u00e6"+
		"\3\2\2\2\u03bb\u03bc\7]\2\2\u03bc\u03bd\7r\2\2\u03bd\u03be\7~\2\2\u03be"+
		"\u00e8\3\2\2\2\u03bf\u03c0\7]\2\2\u03c0\u03c1\7v\2\2\u03c1\u03c2\7~\2"+
		"\2\u03c2\u00ea\3\2\2\2\u03c3\u03c4\7]\2\2\u03c4\u03c5\7f\2\2\u03c5\u03c6"+
		"\7~\2\2\u03c6\u00ec\3\2\2\2\u03c7\u03c8\7~\2\2\u03c8\u03c9\7_\2\2\u03c9"+
		"\u00ee\3\2\2\2\u03ca\u03cb\7*\2\2\u03cb\u03cc\7%\2\2\u03cc\u00f0\3\2\2"+
		"\2\u03cd\u03ce\7%\2\2\u03ce\u03cf\7+\2\2\u03cf\u00f2\3\2\2\2\u03d0\u03d1"+
		"\7*\2\2\u03d1\u00f4\3\2\2\2\u03d2\u03d3\7+\2\2\u03d3\u00f6\3\2\2\2\u03d4"+
		"\u03d5\7]\2\2\u03d5\u00f8\3\2\2\2\u03d6\u03d7\7_\2\2\u03d7\u00fa\3\2\2"+
		"\2\u03d8\u03e0\7)\2\2\u03d9\u03e1\7\"\2\2\u03da\u03e1\5\u0115\u008b\2"+
		"\u03db\u03e1\5\u012f\u0098\2\u03dc\u03e1\5\u0129\u0095\2\u03dd\u03e1\5"+
		"\u0095K\2\u03de\u03e1\5\u011b\u008e\2\u03df\u03e1\t\4\2\2\u03e0\u03d9"+
		"\3\2\2\2\u03e0\u03da\3\2\2\2\u03e0\u03db\3\2\2\2\u03e0\u03dc\3\2\2\2\u03e0"+
		"\u03dd\3\2\2\2\u03e0\u03de\3\2\2\2\u03e0\u03df\3\2\2\2\u03e1\u03e2\3\2"+
		"\2\2\u03e2\u03e3\7)\2\2\u03e3\u00fc\3\2\2\2\u03e4\u03ee\7$\2\2\u03e5\u03ed"+
		"\7\"\2\2\u03e6\u03ed\5\u0115\u008b\2\u03e7\u03ed\5\u012f\u0098\2\u03e8"+
		"\u03ed\5\u0129\u0095\2\u03e9\u03ed\5\u0095K\2\u03ea\u03ed\5\u011b\u008e"+
		"\2\u03eb\u03ed\t\5\2\2\u03ec\u03e5\3\2\2\2\u03ec\u03e6\3\2\2\2\u03ec\u03e7"+
		"\3\2\2\2\u03ec\u03e8\3\2\2\2\u03ec\u03e9\3\2\2\2\u03ec\u03ea\3\2\2\2\u03ec"+
		"\u03eb\3\2\2\2\u03ed\u03f0\3\2\2\2\u03ee\u03ec\3\2\2\2\u03ee\u03ef\3\2"+
		"\2\2\u03ef\u03f1\3\2\2\2\u03f0\u03ee\3\2\2\2\u03f1\u03f2\7$\2\2\u03f2"+
		"\u00fe\3\2\2\2\u03f3\u03fa\5\u012f\u0098\2\u03f4\u03f9\5\u012f\u0098\2"+
		"\u03f5\u03f9\5\u0129\u0095\2\u03f6\u03f9\5\u011b\u008e\2\u03f7\u03f9\7"+
		")\2\2\u03f8\u03f4\3\2\2\2\u03f8\u03f5\3\2\2\2\u03f8\u03f6\3\2\2\2\u03f8"+
		"\u03f7\3\2\2\2\u03f9\u03fc\3\2\2\2\u03fa\u03f8\3\2\2\2\u03fa\u03fb\3\2"+
		"\2\2\u03fb\u0400\3\2\2\2\u03fc\u03fa\3\2\2\2\u03fd\u03ff\7%\2\2\u03fe"+
		"\u03fd\3\2\2\2\u03ff\u0402\3\2\2\2\u0400\u03fe\3\2\2\2\u0400\u0401\3\2"+
		"\2\2\u0401\u0100\3\2\2\2\u0402\u0400\3\2\2\2\u0403\u040a\5\u0129\u0095"+
		"\2\u0404\u0409\5\u012f\u0098\2\u0405\u0409\5\u0129\u0095\2\u0406\u0409"+
		"\5\u011b\u008e\2\u0407\u0409\7)\2\2\u0408\u0404\3\2\2\2\u0408\u0405\3"+
		"\2\2\2\u0408\u0406\3\2\2\2\u0408\u0407\3\2\2\2\u0409\u040c\3\2\2\2\u040a"+
		"\u0408\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u0410\3\2\2\2\u040c\u040a\3\2"+
		"\2\2\u040d\u040f\7%\2\2\u040e\u040d\3\2\2\2\u040f\u0412\3\2\2\2\u0410"+
		"\u040e\3\2\2\2\u0410\u0411\3\2\2\2\u0411\u0102\3\2\2\2\u0412\u0410\3\2"+
		"\2\2\u0413\u0414\7}\2\2\u0414\u0415\7/\2\2\u0415\u0416\7%\2\2\u0416\u0104"+
		"\3\2\2\2\u0417\u0418\7%\2\2\u0418\u0419\7/\2\2\u0419\u041a\7\177\2\2\u041a"+
		"\u0106\3\2\2\2\u041b\u041c\7/\2\2\u041c\u041d\7/\2\2\u041d\u0421\3\2\2"+
		"\2\u041e\u0420\n\6\2\2\u041f\u041e\3\2\2\2\u0420\u0423\3\2\2\2\u0421\u041f"+
		"\3\2\2\2\u0421\u0422\3\2\2\2\u0422\u0424\3\2\2\2\u0423\u0421\3\2\2\2\u0424"+
		"\u0425\b\u0084\5\2\u0425\u0108\3\2\2\2\u0426\u0427\7}\2\2\u0427\u0428"+
		"\7/\2\2\u0428\u0429\3\2\2\2\u0429\u042d\n\7\2\2\u042a\u042c\13\2\2\2\u042b"+
		"\u042a\3\2\2\2\u042c\u042f\3\2\2\2\u042d\u042e\3\2\2\2\u042d\u042b\3\2"+
		"\2\2\u042e\u0430\3\2\2\2\u042f\u042d\3\2\2\2\u0430\u0431\7/\2\2\u0431"+
		"\u0432\7\177\2\2\u0432\u0433\3\2\2\2\u0433\u0434\b\u0085\5\2\u0434\u010a"+
		"\3\2\2\2\u0435\u0436\7}\2\2\u0436\u010c\3\2\2\2\u0437\u0438\7\177\2\2"+
		"\u0438\u010e\3\2\2\2\u0439\u043a\7X\2\2\u043a\u043b\7Q\2\2\u043b\u043c"+
		"\7E\2\2\u043c\u043d\7W\2\2\u043d\u043e\7T\2\2\u043e\u043f\7N\2\2\u043f"+
		"\u0440\7[\2\2\u0440\u0441\3\2\2\2\u0441\u0442\b\u0088\6\2\u0442\u0110"+
		"\3\2\2\2\u0443\u0444\7X\2\2\u0444\u0445\7E\2\2\u0445\u0446\7E\2\2\u0446"+
		"\u0447\7W\2\2\u0447\u0448\7T\2\2\u0448\u0449\7N\2\2\u0449\u044a\7[\2\2"+
		"\u044a\u044b\3\2\2\2\u044b\u044c\b\u0089\7\2\u044c\u0112\3\2\2\2\u044d"+
		"\u044e\7U\2\2\u044e\u044f\7G\2\2\u044f\u0450\7O\2\2\u0450\u0451\7K\2\2"+
		"\u0451\u0452\3\2\2\2\u0452\u0453\b\u008a\b\2\u0453\u0114\3\2\2\2\u0454"+
		"\u0456\5\u011b\u008e\2\u0455\u0454\3\2\2\2\u0456\u0457\3\2\2\2\u0457\u0455"+
		"\3\2\2\2\u0457\u0458\3\2\2\2\u0458\u0116\3\2\2\2\u0459\u045a\7\62\2\2"+
		"\u045a\u045c\t\b\2\2\u045b\u045d\5\u0121\u0091\2\u045c\u045b\3\2\2\2\u045d"+
		"\u045e\3\2\2\2\u045e\u045c\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0118\3\2"+
		"\2\2\u0460\u0461\7\62\2\2\u0461\u0463\t\t\2\2\u0462\u0464\5\u0123\u0092"+
		"\2\u0463\u0462\3\2\2\2\u0464\u0465\3\2\2\2\u0465\u0463\3\2\2\2\u0465\u0466"+
		"\3\2\2\2\u0466\u011a\3\2\2\2\u0467\u046a\5\u011d\u008f\2\u0468\u046a\5"+
		"\u011f\u0090\2\u0469\u0467\3\2\2\2\u0469\u0468\3\2\2\2\u046a\u011c\3\2"+
		"\2\2\u046b\u046c\t\n\2\2\u046c\u011e\3\2\2\2\u046d\u046e\t\13\2\2\u046e"+
		"\u0120\3\2\2\2\u046f\u0470\t\f\2\2\u0470\u0122\3\2\2\2\u0471\u0473\t\r"+
		"\2\2\u0472\u0471\3\2\2\2\u0473\u0124\3\2\2\2\u0474\u0475\5\u0115\u008b"+
		"\2\u0475\u0476\7\60\2\2\u0476\u0478\5\u0115\u008b\2\u0477\u0479\5\u0127"+
		"\u0094\2\u0478\u0477\3\2\2\2\u0478\u0479\3\2\2\2\u0479\u047e\3\2\2\2\u047a"+
		"\u047b\5\u0115\u008b\2\u047b\u047c\5\u0127\u0094\2\u047c\u047e\3\2\2\2"+
		"\u047d\u0474\3\2\2\2\u047d\u047a\3\2\2\2\u047e\u0126\3\2\2\2\u047f\u0481"+
		"\t\16\2\2\u0480\u0482\t\17\2\2\u0481\u0480\3\2\2\2\u0481\u0482\3\2\2\2"+
		"\u0482\u0483\3\2\2\2\u0483\u0484\5\u0115\u008b\2\u0484\u0128\3\2\2\2\u0485"+
		"\u0488\5\u012b\u0096\2\u0486\u0488\5\u012d\u0097\2\u0487\u0485\3\2\2\2"+
		"\u0487\u0486\3\2\2\2\u0488\u012a\3\2\2\2\u0489\u048a\t\20\2\2\u048a\u012c"+
		"\3\2\2\2\u048b\u048c\t\21\2\2\u048c\u012e\3\2\2\2\u048d\u0490\5\u0131"+
		"\u0099\2\u048e\u0490\5\u0133\u009a\2\u048f\u048d\3\2\2\2\u048f\u048e\3"+
		"\2\2\2\u0490\u0130\3\2\2\2\u0491\u0492\t\22\2\2\u0492\u0132\3\2\2\2\u0493"+
		"\u0494\t\23\2\2\u0494\u0134\3\2\2\2\u0495\u0496\t\24\2\2\u0496\u0136\3"+
		"\2\2\2\u0497\u049c\5\u0139\u009d\2\u0498\u049c\5\u013b\u009e\2\u0499\u049c"+
		"\5\u013d\u009f\2\u049a\u049c\5\u013f\u00a0\2\u049b\u0497\3\2\2\2\u049b"+
		"\u0498\3\2\2\2\u049b\u0499\3\2\2\2\u049b\u049a\3\2\2\2\u049c\u0138\3\2"+
		"\2\2\u049d\u049e\t\25\2\2\u049e\u013a\3\2\2\2\u049f\u04a0\t\26\2\2\u04a0"+
		"\u013c\3\2\2\2\u04a1\u04a2\t\27\2\2\u04a2\u013e\3\2\2\2\u04a3\u04a4\t"+
		"\30\2\2\u04a4\u0140\3\2\2\2 \2\u0142\u0146\u014d\u0154\u0346\u0348\u0352"+
		"\u03e0\u03ec\u03ee\u03f8\u03fa\u0400\u0408\u040a\u0410\u0421\u042d\u0457"+
		"\u045e\u0465\u0469\u0472\u0478\u047d\u0481\u0487\u048f\u049b\t\3\2\2\3"+
		"\3\3\3\4\4\b\2\2\3\u0088\5\3\u0089\6\3\u008a\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}