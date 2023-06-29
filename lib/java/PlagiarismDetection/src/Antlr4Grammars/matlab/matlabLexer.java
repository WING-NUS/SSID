// Generated from matlab.g4 by ANTLR 4.8
package Antlr4Grammars.matlab;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class matlabLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, NL=24, BLOCKCOMMENT=25, 
		COMMENT=26, WS=27, ELLIPSIS=28, BREAK=29, CASE=30, CATCH=31, CLASSDEF=32, 
		CONTINUE=33, ELSE=34, ELSEIF=35, END=36, FOR=37, FUNCTION=38, GET=39, 
		GLOBAL=40, IF=41, OTHERWISE=42, PERSISTENT=43, PROPERTIES=44, RETURN=45, 
		SET=46, SWITCH=47, TRY=48, WHILE=49, STATIC=50, ELMENT_WISE_LEFT_DIVIDE=51, 
		ELMENT_WISE_POWER=52, ELMENT_WISE_RIGHT_DIVIDE=53, ELMENT_WISE_TIMES=54, 
		ELMENT_WISE_TRANSPOSE=55, EQUALS=56, GREATER_THAN_OR_EQUAL=57, LESS_THAN_OR_EQUAL=58, 
		LOGICAL_AND=59, LOGICAL_OR=60, NOT_EQUAL=61, ASSIGN=62, BINARY_AND=63, 
		BINARY_OR=64, COLON=65, GREATER_THAN=66, LEFT_DIVIDE=67, LESS_THAN=68, 
		MINUS=69, NOT=70, PLUS=71, POWER=72, RIGHT_DIVIDE=73, TIMES=74, TRANSPOSE=75, 
		AT=76, COMMA=77, DOT=78, SEMI_COLON=79, LEFT_BRACE=80, LEFT_PARENTHESIS=81, 
		LEFT_SQUARE_BRACKET=82, QUESTION=83, RIGHT_BRACE=84, RIGHT_PARENTHESIS=85, 
		RIGHT_SQUARE_BRACKET=86, ID=87, IMAGINARY=88, INT=89, FLOAT=90, STRING=91;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "NL", "BLOCKCOMMENT", 
			"COMMENT", "WS", "ELLIPSIS", "BREAK", "CASE", "CATCH", "CLASSDEF", "CONTINUE", 
			"ELSE", "ELSEIF", "END", "FOR", "FUNCTION", "GET", "GLOBAL", "IF", "OTHERWISE", 
			"PERSISTENT", "PROPERTIES", "RETURN", "SET", "SWITCH", "TRY", "WHILE", 
			"STATIC", "ELMENT_WISE_LEFT_DIVIDE", "ELMENT_WISE_POWER", "ELMENT_WISE_RIGHT_DIVIDE", 
			"ELMENT_WISE_TIMES", "ELMENT_WISE_TRANSPOSE", "EQUALS", "GREATER_THAN_OR_EQUAL", 
			"LESS_THAN_OR_EQUAL", "LOGICAL_AND", "LOGICAL_OR", "NOT_EQUAL", "ASSIGN", 
			"BINARY_AND", "BINARY_OR", "COLON", "GREATER_THAN", "LEFT_DIVIDE", "LESS_THAN", 
			"MINUS", "NOT", "PLUS", "POWER", "RIGHT_DIVIDE", "TIMES", "TRANSPOSE", 
			"AT", "COMMA", "DOT", "SEMI_COLON", "LEFT_BRACE", "LEFT_PARENTHESIS", 
			"LEFT_SQUARE_BRACKET", "QUESTION", "RIGHT_BRACE", "RIGHT_PARENTHESIS", 
			"RIGHT_SQUARE_BRACKET", "ID", "IMAGINARY", "INT", "FLOAT", "EXPONENT", 
			"DIGIT", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'true'", "'false'", "'methods'", "'Abstract'", "'ConstructOnLoad'", 
			"'HandleCompatible'", "'Hidden'", "'Sealed'", "'AllowedSubclasses'", 
			"'InferiorClasses'", "'AbortSet'", "'Constant'", "'Dependent'", "'GetObservable'", 
			"'NonCopyable'", "'SetObservable'", "'Transient'", "'Access'", "'GetAccess'", 
			"'SetAccess'", "'public'", "'protected'", "'private'", null, null, null, 
			null, "'...'", "'break'", "'case'", "'catch'", "'classdef'", "'continue'", 
			"'else'", "'elseif'", "'end'", "'for'", "'function'", "'get'", "'global'", 
			"'if'", "'otherwise'", "'persistent'", "'properties'", "'return'", "'set'", 
			"'switch'", "'try'", "'while'", "'Static'", "'./'", "'.^'", "'.\\'", 
			"'.*'", "'.''", "'=='", "'>='", "'<='", "'&&'", "'||'", "'~='", "'='", 
			"'&'", "'|'", "':'", "'>'", "'/'", "'<'", "'-'", "'~'", "'+'", "'^'", 
			"'\\'", "'*'", "'''", "'@'", "','", "'.'", "';'", "'{'", "'('", "'['", 
			"'?'", "'}'", "')'", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"NL", "BLOCKCOMMENT", "COMMENT", "WS", "ELLIPSIS", "BREAK", "CASE", "CATCH", 
			"CLASSDEF", "CONTINUE", "ELSE", "ELSEIF", "END", "FOR", "FUNCTION", "GET", 
			"GLOBAL", "IF", "OTHERWISE", "PERSISTENT", "PROPERTIES", "RETURN", "SET", 
			"SWITCH", "TRY", "WHILE", "STATIC", "ELMENT_WISE_LEFT_DIVIDE", "ELMENT_WISE_POWER", 
			"ELMENT_WISE_RIGHT_DIVIDE", "ELMENT_WISE_TIMES", "ELMENT_WISE_TRANSPOSE", 
			"EQUALS", "GREATER_THAN_OR_EQUAL", "LESS_THAN_OR_EQUAL", "LOGICAL_AND", 
			"LOGICAL_OR", "NOT_EQUAL", "ASSIGN", "BINARY_AND", "BINARY_OR", "COLON", 
			"GREATER_THAN", "LEFT_DIVIDE", "LESS_THAN", "MINUS", "NOT", "PLUS", "POWER", 
			"RIGHT_DIVIDE", "TIMES", "TRANSPOSE", "AT", "COMMA", "DOT", "SEMI_COLON", 
			"LEFT_BRACE", "LEFT_PARENTHESIS", "LEFT_SQUARE_BRACKET", "QUESTION", 
			"RIGHT_BRACE", "RIGHT_PARENTHESIS", "RIGHT_SQUARE_BRACKET", "ID", "IMAGINARY", 
			"INT", "FLOAT", "STRING"
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


		boolean maybeString = false;


	public matlabLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "matlab.g4"; }

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
		case 26:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 55:
			EQUALS_action((RuleContext)_localctx, actionIndex);
			break;
		case 61:
			ASSIGN_action((RuleContext)_localctx, actionIndex);
			break;
		case 65:
			GREATER_THAN_action((RuleContext)_localctx, actionIndex);
			break;
		case 67:
			LESS_THAN_action((RuleContext)_localctx, actionIndex);
			break;
		case 76:
			COMMA_action((RuleContext)_localctx, actionIndex);
			break;
		case 78:
			SEMI_COLON_action((RuleContext)_localctx, actionIndex);
			break;
		case 79:
			LEFT_BRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 80:
			LEFT_PARENTHESIS_action((RuleContext)_localctx, actionIndex);
			break;
		case 81:
			LEFT_SQUARE_BRACKET_action((RuleContext)_localctx, actionIndex);
			break;
		case 83:
			RIGHT_BRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 84:
			RIGHT_PARENTHESIS_action((RuleContext)_localctx, actionIndex);
			break;
		case 85:
			RIGHT_SQUARE_BRACKET_action((RuleContext)_localctx, actionIndex);
			break;
		case 86:
			ID_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 maybeString = true; 
			break;
		}
	}
	private void EQUALS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			maybeString = true;
			break;
		}
	}
	private void ASSIGN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 maybeString = true; 
			break;
		}
	}
	private void GREATER_THAN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 maybeString = true; 
			break;
		}
	}
	private void LESS_THAN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 maybeString = true; 
			break;
		}
	}
	private void COMMA_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			maybeString = true;
			break;
		}
	}
	private void SEMI_COLON_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			maybeString = true;
			break;
		}
	}
	private void LEFT_BRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			maybeString = true;
			break;
		}
	}
	private void LEFT_PARENTHESIS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			maybeString = true;
			break;
		}
	}
	private void LEFT_SQUARE_BRACKET_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			maybeString = true;
			break;
		}
	}
	private void RIGHT_BRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:
			maybeString = false;
			break;
		}
	}
	private void RIGHT_PARENTHESIS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:
			maybeString = false;
			break;
		}
	}
	private void RIGHT_SQUARE_BRACKET_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:
			maybeString = false;
			break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:
			 maybeString = false; 
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 92:
			return STRING_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean STRING_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return maybeString;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2]\u0316\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\5\31\u01b0\n\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\7\32\u01b8\n\32\f\32\16\32\u01bb\13\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\7\33\u01c4\n\33\f\33\16\33\u01c7\13\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3+"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-"+
		"\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3"+
		"\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\39\39\39\3:\3:\3:\3;\3;\3"+
		";\3<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3C\3D\3"+
		"D\3E\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3N\3"+
		"O\3O\3P\3P\3P\3Q\3Q\3Q\3R\3R\3R\3S\3S\3S\3T\3T\3U\3U\3U\3V\3V\3V\3W\3"+
		"W\3W\3X\3X\7X\u02cb\nX\fX\16X\u02ce\13X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u02d8"+
		"\nY\3Z\6Z\u02db\nZ\rZ\16Z\u02dc\3[\6[\u02e0\n[\r[\16[\u02e1\3[\3[\7[\u02e6"+
		"\n[\f[\16[\u02e9\13[\3[\5[\u02ec\n[\3[\6[\u02ef\n[\r[\16[\u02f0\3[\3["+
		"\3[\3[\6[\u02f7\n[\r[\16[\u02f8\3[\5[\u02fc\n[\5[\u02fe\n[\3\\\3\\\5\\"+
		"\u0302\n\\\3\\\6\\\u0305\n\\\r\\\16\\\u0306\3]\3]\3^\3^\3^\3^\3^\7^\u0310"+
		"\n^\f^\16^\u0313\13^\3^\3^\4\u01b9\u01c5\2_\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081"+
		"B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095"+
		"L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9"+
		"V\u00abW\u00adX\u00afY\u00b1Z\u00b3[\u00b5\\\u00b7\2\u00b9\2\u00bb]\3"+
		"\2\n\4\2\f\f\17\17\4\2\13\13\"\"\4\2C\\c|\6\2\62;C\\aac|\4\2GGgg\4\2-"+
		"-//\3\2\62;\5\2\f\f\17\17))\2\u0325\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2"+
		"\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2"+
		"\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2"+
		"\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b"+
		"\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2"+
		"\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad"+
		"\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2"+
		"\2\2\u00bb\3\2\2\2\3\u00bd\3\2\2\2\5\u00c2\3\2\2\2\7\u00c8\3\2\2\2\t\u00d0"+
		"\3\2\2\2\13\u00d9\3\2\2\2\r\u00e9\3\2\2\2\17\u00fa\3\2\2\2\21\u0101\3"+
		"\2\2\2\23\u0108\3\2\2\2\25\u011a\3\2\2\2\27\u012a\3\2\2\2\31\u0133\3\2"+
		"\2\2\33\u013c\3\2\2\2\35\u0146\3\2\2\2\37\u0154\3\2\2\2!\u0160\3\2\2\2"+
		"#\u016e\3\2\2\2%\u0178\3\2\2\2\'\u017f\3\2\2\2)\u0189\3\2\2\2+\u0193\3"+
		"\2\2\2-\u019a\3\2\2\2/\u01a4\3\2\2\2\61\u01af\3\2\2\2\63\u01b3\3\2\2\2"+
		"\65\u01c1\3\2\2\2\67\u01cc\3\2\2\29\u01d1\3\2\2\2;\u01d7\3\2\2\2=\u01dd"+
		"\3\2\2\2?\u01e2\3\2\2\2A\u01e8\3\2\2\2C\u01f1\3\2\2\2E\u01fa\3\2\2\2G"+
		"\u01ff\3\2\2\2I\u0206\3\2\2\2K\u020a\3\2\2\2M\u020e\3\2\2\2O\u0217\3\2"+
		"\2\2Q\u021b\3\2\2\2S\u0222\3\2\2\2U\u0225\3\2\2\2W\u022f\3\2\2\2Y\u023a"+
		"\3\2\2\2[\u0245\3\2\2\2]\u024c\3\2\2\2_\u0250\3\2\2\2a\u0257\3\2\2\2c"+
		"\u025b\3\2\2\2e\u0261\3\2\2\2g\u0268\3\2\2\2i\u026b\3\2\2\2k\u026e\3\2"+
		"\2\2m\u0271\3\2\2\2o\u0274\3\2\2\2q\u0277\3\2\2\2s\u027c\3\2\2\2u\u027f"+
		"\3\2\2\2w\u0282\3\2\2\2y\u0285\3\2\2\2{\u0288\3\2\2\2}\u028b\3\2\2\2\177"+
		"\u028e\3\2\2\2\u0081\u0290\3\2\2\2\u0083\u0292\3\2\2\2\u0085\u0294\3\2"+
		"\2\2\u0087\u0297\3\2\2\2\u0089\u0299\3\2\2\2\u008b\u029c\3\2\2\2\u008d"+
		"\u029e\3\2\2\2\u008f\u02a0\3\2\2\2\u0091\u02a2\3\2\2\2\u0093\u02a4\3\2"+
		"\2\2\u0095\u02a6\3\2\2\2\u0097\u02a8\3\2\2\2\u0099\u02aa\3\2\2\2\u009b"+
		"\u02ac\3\2\2\2\u009d\u02af\3\2\2\2\u009f\u02b1\3\2\2\2\u00a1\u02b4\3\2"+
		"\2\2\u00a3\u02b7\3\2\2\2\u00a5\u02ba\3\2\2\2\u00a7\u02bd\3\2\2\2\u00a9"+
		"\u02bf\3\2\2\2\u00ab\u02c2\3\2\2\2\u00ad\u02c5\3\2\2\2\u00af\u02c8\3\2"+
		"\2\2\u00b1\u02d7\3\2\2\2\u00b3\u02da\3\2\2\2\u00b5\u02fd\3\2\2\2\u00b7"+
		"\u02ff\3\2\2\2\u00b9\u0308\3\2\2\2\u00bb\u030a\3\2\2\2\u00bd\u00be\7v"+
		"\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7g\2\2\u00c1\4"+
		"\3\2\2\2\u00c2\u00c3\7h\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7n\2\2\u00c5"+
		"\u00c6\7u\2\2\u00c6\u00c7\7g\2\2\u00c7\6\3\2\2\2\u00c8\u00c9\7o\2\2\u00c9"+
		"\u00ca\7g\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7j\2\2\u00cc\u00cd\7q\2\2"+
		"\u00cd\u00ce\7f\2\2\u00ce\u00cf\7u\2\2\u00cf\b\3\2\2\2\u00d0\u00d1\7C"+
		"\2\2\u00d1\u00d2\7d\2\2\u00d2\u00d3\7u\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5"+
		"\7t\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7e\2\2\u00d7\u00d8\7v\2\2\u00d8"+
		"\n\3\2\2\2\u00d9\u00da\7E\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7p\2\2\u00dc"+
		"\u00dd\7u\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7t\2\2\u00df\u00e0\7w\2\2"+
		"\u00e0\u00e1\7e\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7Q\2\2\u00e3\u00e4"+
		"\7p\2\2\u00e4\u00e5\7N\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7\7c\2\2\u00e7"+
		"\u00e8\7f\2\2\u00e8\f\3\2\2\2\u00e9\u00ea\7J\2\2\u00ea\u00eb\7c\2\2\u00eb"+
		"\u00ec\7p\2\2\u00ec\u00ed\7f\2\2\u00ed\u00ee\7n\2\2\u00ee\u00ef\7g\2\2"+
		"\u00ef\u00f0\7E\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7o\2\2\u00f2\u00f3"+
		"\7r\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6\7k\2\2\u00f6"+
		"\u00f7\7d\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7g\2\2\u00f9\16\3\2\2\2\u00fa"+
		"\u00fb\7J\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7f\2\2\u00fd\u00fe\7f\2\2"+
		"\u00fe\u00ff\7g\2\2\u00ff\u0100\7p\2\2\u0100\20\3\2\2\2\u0101\u0102\7"+
		"U\2\2\u0102\u0103\7g\2\2\u0103\u0104\7c\2\2\u0104\u0105\7n\2\2\u0105\u0106"+
		"\7g\2\2\u0106\u0107\7f\2\2\u0107\22\3\2\2\2\u0108\u0109\7C\2\2\u0109\u010a"+
		"\7n\2\2\u010a\u010b\7n\2\2\u010b\u010c\7q\2\2\u010c\u010d\7y\2\2\u010d"+
		"\u010e\7g\2\2\u010e\u010f\7f\2\2\u010f\u0110\7U\2\2\u0110\u0111\7w\2\2"+
		"\u0111\u0112\7d\2\2\u0112\u0113\7e\2\2\u0113\u0114\7n\2\2\u0114\u0115"+
		"\7c\2\2\u0115\u0116\7u\2\2\u0116\u0117\7u\2\2\u0117\u0118\7g\2\2\u0118"+
		"\u0119\7u\2\2\u0119\24\3\2\2\2\u011a\u011b\7K\2\2\u011b\u011c\7p\2\2\u011c"+
		"\u011d\7h\2\2\u011d\u011e\7g\2\2\u011e\u011f\7t\2\2\u011f\u0120\7k\2\2"+
		"\u0120\u0121\7q\2\2\u0121\u0122\7t\2\2\u0122\u0123\7E\2\2\u0123\u0124"+
		"\7n\2\2\u0124\u0125\7c\2\2\u0125\u0126\7u\2\2\u0126\u0127\7u\2\2\u0127"+
		"\u0128\7g\2\2\u0128\u0129\7u\2\2\u0129\26\3\2\2\2\u012a\u012b\7C\2\2\u012b"+
		"\u012c\7d\2\2\u012c\u012d\7q\2\2\u012d\u012e\7t\2\2\u012e\u012f\7v\2\2"+
		"\u012f\u0130\7U\2\2\u0130\u0131\7g\2\2\u0131\u0132\7v\2\2\u0132\30\3\2"+
		"\2\2\u0133\u0134\7E\2\2\u0134\u0135\7q\2\2\u0135\u0136\7p\2\2\u0136\u0137"+
		"\7u\2\2\u0137\u0138\7v\2\2\u0138\u0139\7c\2\2\u0139\u013a\7p\2\2\u013a"+
		"\u013b\7v\2\2\u013b\32\3\2\2\2\u013c\u013d\7F\2\2\u013d\u013e\7g\2\2\u013e"+
		"\u013f\7r\2\2\u013f\u0140\7g\2\2\u0140\u0141\7p\2\2\u0141\u0142\7f\2\2"+
		"\u0142\u0143\7g\2\2\u0143\u0144\7p\2\2\u0144\u0145\7v\2\2\u0145\34\3\2"+
		"\2\2\u0146\u0147\7I\2\2\u0147\u0148\7g\2\2\u0148\u0149\7v\2\2\u0149\u014a"+
		"\7Q\2\2\u014a\u014b\7d\2\2\u014b\u014c\7u\2\2\u014c\u014d\7g\2\2\u014d"+
		"\u014e\7t\2\2\u014e\u014f\7x\2\2\u014f\u0150\7c\2\2\u0150\u0151\7d\2\2"+
		"\u0151\u0152\7n\2\2\u0152\u0153\7g\2\2\u0153\36\3\2\2\2\u0154\u0155\7"+
		"P\2\2\u0155\u0156\7q\2\2\u0156\u0157\7p\2\2\u0157\u0158\7E\2\2\u0158\u0159"+
		"\7q\2\2\u0159\u015a\7r\2\2\u015a\u015b\7{\2\2\u015b\u015c\7c\2\2\u015c"+
		"\u015d\7d\2\2\u015d\u015e\7n\2\2\u015e\u015f\7g\2\2\u015f \3\2\2\2\u0160"+
		"\u0161\7U\2\2\u0161\u0162\7g\2\2\u0162\u0163\7v\2\2\u0163\u0164\7Q\2\2"+
		"\u0164\u0165\7d\2\2\u0165\u0166\7u\2\2\u0166\u0167\7g\2\2\u0167\u0168"+
		"\7t\2\2\u0168\u0169\7x\2\2\u0169\u016a\7c\2\2\u016a\u016b\7d\2\2\u016b"+
		"\u016c\7n\2\2\u016c\u016d\7g\2\2\u016d\"\3\2\2\2\u016e\u016f\7V\2\2\u016f"+
		"\u0170\7t\2\2\u0170\u0171\7c\2\2\u0171\u0172\7p\2\2\u0172\u0173\7u\2\2"+
		"\u0173\u0174\7k\2\2\u0174\u0175\7g\2\2\u0175\u0176\7p\2\2\u0176\u0177"+
		"\7v\2\2\u0177$\3\2\2\2\u0178\u0179\7C\2\2\u0179\u017a\7e\2\2\u017a\u017b"+
		"\7e\2\2\u017b\u017c\7g\2\2\u017c\u017d\7u\2\2\u017d\u017e\7u\2\2\u017e"+
		"&\3\2\2\2\u017f\u0180\7I\2\2\u0180\u0181\7g\2\2\u0181\u0182\7v\2\2\u0182"+
		"\u0183\7C\2\2\u0183\u0184\7e\2\2\u0184\u0185\7e\2\2\u0185\u0186\7g\2\2"+
		"\u0186\u0187\7u\2\2\u0187\u0188\7u\2\2\u0188(\3\2\2\2\u0189\u018a\7U\2"+
		"\2\u018a\u018b\7g\2\2\u018b\u018c\7v\2\2\u018c\u018d\7C\2\2\u018d\u018e"+
		"\7e\2\2\u018e\u018f\7e\2\2\u018f\u0190\7g\2\2\u0190\u0191\7u\2\2\u0191"+
		"\u0192\7u\2\2\u0192*\3\2\2\2\u0193\u0194\7r\2\2\u0194\u0195\7w\2\2\u0195"+
		"\u0196\7d\2\2\u0196\u0197\7n\2\2\u0197\u0198\7k\2\2\u0198\u0199\7e\2\2"+
		"\u0199,\3\2\2\2\u019a\u019b\7r\2\2\u019b\u019c\7t\2\2\u019c\u019d\7q\2"+
		"\2\u019d\u019e\7v\2\2\u019e\u019f\7g\2\2\u019f\u01a0\7e\2\2\u01a0\u01a1"+
		"\7v\2\2\u01a1\u01a2\7g\2\2\u01a2\u01a3\7f\2\2\u01a3.\3\2\2\2\u01a4\u01a5"+
		"\7r\2\2\u01a5\u01a6\7t\2\2\u01a6\u01a7\7k\2\2\u01a7\u01a8\7x\2\2\u01a8"+
		"\u01a9\7c\2\2\u01a9\u01aa\7v\2\2\u01aa\u01ab\7g\2\2\u01ab\60\3\2\2\2\u01ac"+
		"\u01ad\7\17\2\2\u01ad\u01b0\7\f\2\2\u01ae\u01b0\t\2\2\2\u01af\u01ac\3"+
		"\2\2\2\u01af\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\b\31\2\2\u01b2"+
		"\62\3\2\2\2\u01b3\u01b4\7\'\2\2\u01b4\u01b5\7}\2\2\u01b5\u01b9\3\2\2\2"+
		"\u01b6\u01b8\13\2\2\2\u01b7\u01b6\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01ba"+
		"\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba\u01bc\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc"+
		"\u01bd\7\'\2\2\u01bd\u01be\7\177\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\b"+
		"\32\2\2\u01c0\64\3\2\2\2\u01c1\u01c5\7\'\2\2\u01c2\u01c4\13\2\2\2\u01c3"+
		"\u01c2\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c5\u01c3\3\2"+
		"\2\2\u01c6\u01c8\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01c9\5\61\31\2\u01c9"+
		"\u01ca\3\2\2\2\u01ca\u01cb\b\33\2\2\u01cb\66\3\2\2\2\u01cc\u01cd\t\3\2"+
		"\2\u01cd\u01ce\b\34\3\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\b\34\4\2\u01d0"+
		"8\3\2\2\2\u01d1\u01d2\7\60\2\2\u01d2\u01d3\7\60\2\2\u01d3\u01d4\7\60\2"+
		"\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\b\35\4\2\u01d6:\3\2\2\2\u01d7\u01d8"+
		"\7d\2\2\u01d8\u01d9\7t\2\2\u01d9\u01da\7g\2\2\u01da\u01db\7c\2\2\u01db"+
		"\u01dc\7m\2\2\u01dc<\3\2\2\2\u01dd\u01de\7e\2\2\u01de\u01df\7c\2\2\u01df"+
		"\u01e0\7u\2\2\u01e0\u01e1\7g\2\2\u01e1>\3\2\2\2\u01e2\u01e3\7e\2\2\u01e3"+
		"\u01e4\7c\2\2\u01e4\u01e5\7v\2\2\u01e5\u01e6\7e\2\2\u01e6\u01e7\7j\2\2"+
		"\u01e7@\3\2\2\2\u01e8\u01e9\7e\2\2\u01e9\u01ea\7n\2\2\u01ea\u01eb\7c\2"+
		"\2\u01eb\u01ec\7u\2\2\u01ec\u01ed\7u\2\2\u01ed\u01ee\7f\2\2\u01ee\u01ef"+
		"\7g\2\2\u01ef\u01f0\7h\2\2\u01f0B\3\2\2\2\u01f1\u01f2\7e\2\2\u01f2\u01f3"+
		"\7q\2\2\u01f3\u01f4\7p\2\2\u01f4\u01f5\7v\2\2\u01f5\u01f6\7k\2\2\u01f6"+
		"\u01f7\7p\2\2\u01f7\u01f8\7w\2\2\u01f8\u01f9\7g\2\2\u01f9D\3\2\2\2\u01fa"+
		"\u01fb\7g\2\2\u01fb\u01fc\7n\2\2\u01fc\u01fd\7u\2\2\u01fd\u01fe\7g\2\2"+
		"\u01feF\3\2\2\2\u01ff\u0200\7g\2\2\u0200\u0201\7n\2\2\u0201\u0202\7u\2"+
		"\2\u0202\u0203\7g\2\2\u0203\u0204\7k\2\2\u0204\u0205\7h\2\2\u0205H\3\2"+
		"\2\2\u0206\u0207\7g\2\2\u0207\u0208\7p\2\2\u0208\u0209\7f\2\2\u0209J\3"+
		"\2\2\2\u020a\u020b\7h\2\2\u020b\u020c\7q\2\2\u020c\u020d\7t\2\2\u020d"+
		"L\3\2\2\2\u020e\u020f\7h\2\2\u020f\u0210\7w\2\2\u0210\u0211\7p\2\2\u0211"+
		"\u0212\7e\2\2\u0212\u0213\7v\2\2\u0213\u0214\7k\2\2\u0214\u0215\7q\2\2"+
		"\u0215\u0216\7p\2\2\u0216N\3\2\2\2\u0217\u0218\7i\2\2\u0218\u0219\7g\2"+
		"\2\u0219\u021a\7v\2\2\u021aP\3\2\2\2\u021b\u021c\7i\2\2\u021c\u021d\7"+
		"n\2\2\u021d\u021e\7q\2\2\u021e\u021f\7d\2\2\u021f\u0220\7c\2\2\u0220\u0221"+
		"\7n\2\2\u0221R\3\2\2\2\u0222\u0223\7k\2\2\u0223\u0224\7h\2\2\u0224T\3"+
		"\2\2\2\u0225\u0226\7q\2\2\u0226\u0227\7v\2\2\u0227\u0228\7j\2\2\u0228"+
		"\u0229\7g\2\2\u0229\u022a\7t\2\2\u022a\u022b\7y\2\2\u022b\u022c\7k\2\2"+
		"\u022c\u022d\7u\2\2\u022d\u022e\7g\2\2\u022eV\3\2\2\2\u022f\u0230\7r\2"+
		"\2\u0230\u0231\7g\2\2\u0231\u0232\7t\2\2\u0232\u0233\7u\2\2\u0233\u0234"+
		"\7k\2\2\u0234\u0235\7u\2\2\u0235\u0236\7v\2\2\u0236\u0237\7g\2\2\u0237"+
		"\u0238\7p\2\2\u0238\u0239\7v\2\2\u0239X\3\2\2\2\u023a\u023b\7r\2\2\u023b"+
		"\u023c\7t\2\2\u023c\u023d\7q\2\2\u023d\u023e\7r\2\2\u023e\u023f\7g\2\2"+
		"\u023f\u0240\7t\2\2\u0240\u0241\7v\2\2\u0241\u0242\7k\2\2\u0242\u0243"+
		"\7g\2\2\u0243\u0244\7u\2\2\u0244Z\3\2\2\2\u0245\u0246\7t\2\2\u0246\u0247"+
		"\7g\2\2\u0247\u0248\7v\2\2\u0248\u0249\7w\2\2\u0249\u024a\7t\2\2\u024a"+
		"\u024b\7p\2\2\u024b\\\3\2\2\2\u024c\u024d\7u\2\2\u024d\u024e\7g\2\2\u024e"+
		"\u024f\7v\2\2\u024f^\3\2\2\2\u0250\u0251\7u\2\2\u0251\u0252\7y\2\2\u0252"+
		"\u0253\7k\2\2\u0253\u0254\7v\2\2\u0254\u0255\7e\2\2\u0255\u0256\7j\2\2"+
		"\u0256`\3\2\2\2\u0257\u0258\7v\2\2\u0258\u0259\7t\2\2\u0259\u025a\7{\2"+
		"\2\u025ab\3\2\2\2\u025b\u025c\7y\2\2\u025c\u025d\7j\2\2\u025d\u025e\7"+
		"k\2\2\u025e\u025f\7n\2\2\u025f\u0260\7g\2\2\u0260d\3\2\2\2\u0261\u0262"+
		"\7U\2\2\u0262\u0263\7v\2\2\u0263\u0264\7c\2\2\u0264\u0265\7v\2\2\u0265"+
		"\u0266\7k\2\2\u0266\u0267\7e\2\2\u0267f\3\2\2\2\u0268\u0269\7\60\2\2\u0269"+
		"\u026a\7\61\2\2\u026ah\3\2\2\2\u026b\u026c\7\60\2\2\u026c\u026d\7`\2\2"+
		"\u026dj\3\2\2\2\u026e\u026f\7\60\2\2\u026f\u0270\7^\2\2\u0270l\3\2\2\2"+
		"\u0271\u0272\7\60\2\2\u0272\u0273\7,\2\2\u0273n\3\2\2\2\u0274\u0275\7"+
		"\60\2\2\u0275\u0276\7)\2\2\u0276p\3\2\2\2\u0277\u0278\7?\2\2\u0278\u0279"+
		"\7?\2\2\u0279\u027a\3\2\2\2\u027a\u027b\b9\5\2\u027br\3\2\2\2\u027c\u027d"+
		"\7@\2\2\u027d\u027e\7?\2\2\u027et\3\2\2\2\u027f\u0280\7>\2\2\u0280\u0281"+
		"\7?\2\2\u0281v\3\2\2\2\u0282\u0283\7(\2\2\u0283\u0284\7(\2\2\u0284x\3"+
		"\2\2\2\u0285\u0286\7~\2\2\u0286\u0287\7~\2\2\u0287z\3\2\2\2\u0288\u0289"+
		"\7\u0080\2\2\u0289\u028a\7?\2\2\u028a|\3\2\2\2\u028b\u028c\7?\2\2\u028c"+
		"\u028d\b?\6\2\u028d~\3\2\2\2\u028e\u028f\7(\2\2\u028f\u0080\3\2\2\2\u0290"+
		"\u0291\7~\2\2\u0291\u0082\3\2\2\2\u0292\u0293\7<\2\2\u0293\u0084\3\2\2"+
		"\2\u0294\u0295\7@\2\2\u0295\u0296\bC\7\2\u0296\u0086\3\2\2\2\u0297\u0298"+
		"\7\61\2\2\u0298\u0088\3\2\2\2\u0299\u029a\7>\2\2\u029a\u029b\bE\b\2\u029b"+
		"\u008a\3\2\2\2\u029c\u029d\7/\2\2\u029d\u008c\3\2\2\2\u029e\u029f\7\u0080"+
		"\2\2\u029f\u008e\3\2\2\2\u02a0\u02a1\7-\2\2\u02a1\u0090\3\2\2\2\u02a2"+
		"\u02a3\7`\2\2\u02a3\u0092\3\2\2\2\u02a4\u02a5\7^\2\2\u02a5\u0094\3\2\2"+
		"\2\u02a6\u02a7\7,\2\2\u02a7\u0096\3\2\2\2\u02a8\u02a9\7)\2\2\u02a9\u0098"+
		"\3\2\2\2\u02aa\u02ab\7B\2\2\u02ab\u009a\3\2\2\2\u02ac\u02ad\7.\2\2\u02ad"+
		"\u02ae\bN\t\2\u02ae\u009c\3\2\2\2\u02af\u02b0\7\60\2\2\u02b0\u009e\3\2"+
		"\2\2\u02b1\u02b2\7=\2\2\u02b2\u02b3\bP\n\2\u02b3\u00a0\3\2\2\2\u02b4\u02b5"+
		"\7}\2\2\u02b5\u02b6\bQ\13\2\u02b6\u00a2\3\2\2\2\u02b7\u02b8\7*\2\2\u02b8"+
		"\u02b9\bR\f\2\u02b9\u00a4\3\2\2\2\u02ba\u02bb\7]\2\2\u02bb\u02bc\bS\r"+
		"\2\u02bc\u00a6\3\2\2\2\u02bd\u02be\7A\2\2\u02be\u00a8\3\2\2\2\u02bf\u02c0"+
		"\7\177\2\2\u02c0\u02c1\bU\16\2\u02c1\u00aa\3\2\2\2\u02c2\u02c3\7+\2\2"+
		"\u02c3\u02c4\bV\17\2\u02c4\u00ac\3\2\2\2\u02c5\u02c6\7_\2\2\u02c6\u02c7"+
		"\bW\20\2\u02c7\u00ae\3\2\2\2\u02c8\u02cc\t\4\2\2\u02c9\u02cb\t\5\2\2\u02ca"+
		"\u02c9\3\2\2\2\u02cb\u02ce\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cc\u02cd\3\2"+
		"\2\2\u02cd\u02cf\3\2\2\2\u02ce\u02cc\3\2\2\2\u02cf\u02d0\bX\21\2\u02d0"+
		"\u00b0\3\2\2\2\u02d1\u02d2\5\u00b3Z\2\u02d2\u02d3\7k\2\2\u02d3\u02d8\3"+
		"\2\2\2\u02d4\u02d5\5\u00b5[\2\u02d5\u02d6\7k\2\2\u02d6\u02d8\3\2\2\2\u02d7"+
		"\u02d1\3\2\2\2\u02d7\u02d4\3\2\2\2\u02d8\u00b2\3\2\2\2\u02d9\u02db\5\u00b9"+
		"]\2\u02da\u02d9\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02da\3\2\2\2\u02dc"+
		"\u02dd\3\2\2\2\u02dd\u00b4\3\2\2\2\u02de\u02e0\5\u00b9]\2\u02df\u02de"+
		"\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2"+
		"\u02e3\3\2\2\2\u02e3\u02e7\7\60\2\2\u02e4\u02e6\5\u00b9]\2\u02e5\u02e4"+
		"\3\2\2\2\u02e6\u02e9\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8"+
		"\u02eb\3\2\2\2\u02e9\u02e7\3\2\2\2\u02ea\u02ec\5\u00b7\\\2\u02eb\u02ea"+
		"\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02fe\3\2\2\2\u02ed\u02ef\5\u00b9]"+
		"\2\u02ee\u02ed\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f0\u02f1"+
		"\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02f3\5\u00b7\\\2\u02f3\u02fe\3\2\2"+
		"\2\u02f4\u02f6\7\60\2\2\u02f5\u02f7\5\u00b9]\2\u02f6\u02f5\3\2\2\2\u02f7"+
		"\u02f8\3\2\2\2\u02f8\u02f6\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fb\3\2"+
		"\2\2\u02fa\u02fc\5\u00b7\\\2\u02fb\u02fa\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc"+
		"\u02fe\3\2\2\2\u02fd\u02df\3\2\2\2\u02fd\u02ee\3\2\2\2\u02fd\u02f4\3\2"+
		"\2\2\u02fe\u00b6\3\2\2\2\u02ff\u0301\t\6\2\2\u0300\u0302\t\7\2\2\u0301"+
		"\u0300\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0304\3\2\2\2\u0303\u0305\5\u00b9"+
		"]\2\u0304\u0303\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u0304\3\2\2\2\u0306"+
		"\u0307\3\2\2\2\u0307\u00b8\3\2\2\2\u0308\u0309\t\b\2\2\u0309\u00ba\3\2"+
		"\2\2\u030a\u030b\6^\2\2\u030b\u0311\7)\2\2\u030c\u0310\n\t\2\2\u030d\u030e"+
		"\7)\2\2\u030e\u0310\7)\2\2\u030f\u030c\3\2\2\2\u030f\u030d\3\2\2\2\u0310"+
		"\u0313\3\2\2\2\u0311\u030f\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0314\3\2"+
		"\2\2\u0313\u0311\3\2\2\2\u0314\u0315\7)\2\2\u0315\u00bc\3\2\2\2\24\2\u01af"+
		"\u01b9\u01c5\u02cc\u02d7\u02dc\u02e1\u02e7\u02eb\u02f0\u02f8\u02fb\u02fd"+
		"\u0301\u0306\u030f\u0311\22\2\3\2\3\34\2\b\2\2\39\3\3?\4\3C\5\3E\6\3N"+
		"\7\3P\b\3Q\t\3R\n\3S\13\3U\f\3V\r\3W\16\3X\17";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}