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
		T__17=18, T__18=19, ARRAYMUL=20, ARRAYDIV=21, ARRAYRDIV=22, ARRAYPOW=23, 
		BREAK=24, RETURN=25, FUNCTION=26, FOR=27, WHILE=28, END=29, GLOBAL=30, 
		IF=31, CLEAR=32, ELSE=33, ELSEIF=34, LE_OP=35, GE_OP=36, EQ_OP=37, NE_OP=38, 
		TRANSPOSE=39, NCTRANSPOSE=40, STRING_LITERAL=41, IDENTIFIER=42, CONSTANT=43, 
		CR=44, WS=45;
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
			"T__17", "T__18", "ARRAYMUL", "ARRAYDIV", "ARRAYRDIV", "ARRAYPOW", "BREAK", 
			"RETURN", "FUNCTION", "FOR", "WHILE", "END", "GLOBAL", "IF", "CLEAR", 
			"ELSE", "ELSEIF", "LE_OP", "GE_OP", "EQ_OP", "NE_OP", "TRANSPOSE", "NCTRANSPOSE", 
			"STRING_LITERAL", "IDENTIFIER", "CONSTANT", "NUMBER", "E", "SIGN", "CR", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "':'", "','", "'+'", "'-'", "'~'", 
			"'*'", "'/'", "'\\'", "'^'", "'<'", "'>'", "'&'", "'|'", "'='", "';'", 
			"'.*'", "'.\\'", "'./'", "'.^'", "'break'", "'return'", "'function'", 
			"'for'", "'while'", "'end'", "'global'", "'if'", "'clear'", "'else'", 
			"'elseif'", "'<='", "'>='", "'=='", "'~='", "'transpose'", "'.''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "ARRAYMUL", "ARRAYDIV", 
			"ARRAYRDIV", "ARRAYPOW", "BREAK", "RETURN", "FUNCTION", "FOR", "WHILE", 
			"END", "GLOBAL", "IF", "CLEAR", "ELSE", "ELSEIF", "LE_OP", "GE_OP", "EQ_OP", 
			"NE_OP", "TRANSPOSE", "NCTRANSPOSE", "STRING_LITERAL", "IDENTIFIER", 
			"CONSTANT", "CR", "WS"
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0126\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$"+
		"\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)"+
		"\3)\3*\3*\3*\3*\7*\u00f3\n*\f*\16*\u00f6\13*\3*\3*\3+\3+\7+\u00fc\n+\f"+
		"+\16+\u00ff\13+\3,\3,\3,\5,\u0104\n,\3,\3,\5,\u0108\n,\3-\6-\u010b\n-"+
		"\r-\16-\u010c\3-\3-\6-\u0111\n-\r-\16-\u0112\5-\u0115\n-\3.\3.\3/\3/\3"+
		"\60\6\60\u011c\n\60\r\60\16\60\u011d\3\61\6\61\u0121\n\61\r\61\16\61\u0122"+
		"\3\61\3\61\2\2\62\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y\2[\2]\2_.a/\3\2\t\3\2"+
		"))\4\2C\\c|\6\2\62;C\\aac|\4\2GGgg\4\2--//\4\2\f\f\17\17\4\2\13\13\"\""+
		"\2\u012c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5e\3\2"+
		"\2\2\7g\3\2\2\2\ti\3\2\2\2\13k\3\2\2\2\rm\3\2\2\2\17o\3\2\2\2\21q\3\2"+
		"\2\2\23s\3\2\2\2\25u\3\2\2\2\27w\3\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35}\3"+
		"\2\2\2\37\177\3\2\2\2!\u0081\3\2\2\2#\u0083\3\2\2\2%\u0085\3\2\2\2\'\u0087"+
		"\3\2\2\2)\u0089\3\2\2\2+\u008c\3\2\2\2-\u008f\3\2\2\2/\u0092\3\2\2\2\61"+
		"\u0095\3\2\2\2\63\u009b\3\2\2\2\65\u00a2\3\2\2\2\67\u00ab\3\2\2\29\u00af"+
		"\3\2\2\2;\u00b5\3\2\2\2=\u00b9\3\2\2\2?\u00c0\3\2\2\2A\u00c3\3\2\2\2C"+
		"\u00c9\3\2\2\2E\u00ce\3\2\2\2G\u00d5\3\2\2\2I\u00d8\3\2\2\2K\u00db\3\2"+
		"\2\2M\u00de\3\2\2\2O\u00e1\3\2\2\2Q\u00eb\3\2\2\2S\u00ee\3\2\2\2U\u00f9"+
		"\3\2\2\2W\u0100\3\2\2\2Y\u010a\3\2\2\2[\u0116\3\2\2\2]\u0118\3\2\2\2_"+
		"\u011b\3\2\2\2a\u0120\3\2\2\2cd\7*\2\2d\4\3\2\2\2ef\7+\2\2f\6\3\2\2\2"+
		"gh\7]\2\2h\b\3\2\2\2ij\7_\2\2j\n\3\2\2\2kl\7<\2\2l\f\3\2\2\2mn\7.\2\2"+
		"n\16\3\2\2\2op\7-\2\2p\20\3\2\2\2qr\7/\2\2r\22\3\2\2\2st\7\u0080\2\2t"+
		"\24\3\2\2\2uv\7,\2\2v\26\3\2\2\2wx\7\61\2\2x\30\3\2\2\2yz\7^\2\2z\32\3"+
		"\2\2\2{|\7`\2\2|\34\3\2\2\2}~\7>\2\2~\36\3\2\2\2\177\u0080\7@\2\2\u0080"+
		" \3\2\2\2\u0081\u0082\7(\2\2\u0082\"\3\2\2\2\u0083\u0084\7~\2\2\u0084"+
		"$\3\2\2\2\u0085\u0086\7?\2\2\u0086&\3\2\2\2\u0087\u0088\7=\2\2\u0088("+
		"\3\2\2\2\u0089\u008a\7\60\2\2\u008a\u008b\7,\2\2\u008b*\3\2\2\2\u008c"+
		"\u008d\7\60\2\2\u008d\u008e\7^\2\2\u008e,\3\2\2\2\u008f\u0090\7\60\2\2"+
		"\u0090\u0091\7\61\2\2\u0091.\3\2\2\2\u0092\u0093\7\60\2\2\u0093\u0094"+
		"\7`\2\2\u0094\60\3\2\2\2\u0095\u0096\7d\2\2\u0096\u0097\7t\2\2\u0097\u0098"+
		"\7g\2\2\u0098\u0099\7c\2\2\u0099\u009a\7m\2\2\u009a\62\3\2\2\2\u009b\u009c"+
		"\7t\2\2\u009c\u009d\7g\2\2\u009d\u009e\7v\2\2\u009e\u009f\7w\2\2\u009f"+
		"\u00a0\7t\2\2\u00a0\u00a1\7p\2\2\u00a1\64\3\2\2\2\u00a2\u00a3\7h\2\2\u00a3"+
		"\u00a4\7w\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7e\2\2\u00a6\u00a7\7v\2\2"+
		"\u00a7\u00a8\7k\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7p\2\2\u00aa\66\3\2"+
		"\2\2\u00ab\u00ac\7h\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7t\2\2\u00ae8\3"+
		"\2\2\2\u00af\u00b0\7y\2\2\u00b0\u00b1\7j\2\2\u00b1\u00b2\7k\2\2\u00b2"+
		"\u00b3\7n\2\2\u00b3\u00b4\7g\2\2\u00b4:\3\2\2\2\u00b5\u00b6\7g\2\2\u00b6"+
		"\u00b7\7p\2\2\u00b7\u00b8\7f\2\2\u00b8<\3\2\2\2\u00b9\u00ba\7i\2\2\u00ba"+
		"\u00bb\7n\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7d\2\2\u00bd\u00be\7c\2\2"+
		"\u00be\u00bf\7n\2\2\u00bf>\3\2\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7h\2"+
		"\2\u00c2@\3\2\2\2\u00c3\u00c4\7e\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7"+
		"g\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7t\2\2\u00c8B\3\2\2\2\u00c9\u00ca"+
		"\7g\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7u\2\2\u00cc\u00cd\7g\2\2\u00cd"+
		"D\3\2\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7u\2\2\u00d1"+
		"\u00d2\7g\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7h\2\2\u00d4F\3\2\2\2\u00d5"+
		"\u00d6\7>\2\2\u00d6\u00d7\7?\2\2\u00d7H\3\2\2\2\u00d8\u00d9\7@\2\2\u00d9"+
		"\u00da\7?\2\2\u00daJ\3\2\2\2\u00db\u00dc\7?\2\2\u00dc\u00dd\7?\2\2\u00dd"+
		"L\3\2\2\2\u00de\u00df\7\u0080\2\2\u00df\u00e0\7?\2\2\u00e0N\3\2\2\2\u00e1"+
		"\u00e2\7v\2\2\u00e2\u00e3\7t\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7p\2\2"+
		"\u00e5\u00e6\7u\2\2\u00e6\u00e7\7r\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9"+
		"\7u\2\2\u00e9\u00ea\7g\2\2\u00eaP\3\2\2\2\u00eb\u00ec\7\60\2\2\u00ec\u00ed"+
		"\7)\2\2\u00edR\3\2\2\2\u00ee\u00f4\7)\2\2\u00ef\u00f3\n\2\2\2\u00f0\u00f1"+
		"\7)\2\2\u00f1\u00f3\7)\2\2\u00f2\u00ef\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2"+
		"\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\7)\2\2\u00f8T\3\2\2\2\u00f9\u00fd"+
		"\t\3\2\2\u00fa\u00fc\t\4\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00feV\3\2\2\2\u00ff\u00fd\3\2\2\2"+
		"\u0100\u0107\5Y-\2\u0101\u0103\5[.\2\u0102\u0104\5]/\2\u0103\u0102\3\2"+
		"\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\5Y-\2\u0106\u0108"+
		"\3\2\2\2\u0107\u0101\3\2\2\2\u0107\u0108\3\2\2\2\u0108X\3\2\2\2\u0109"+
		"\u010b\4\62;\2\u010a\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2"+
		"\2\2\u010c\u010d\3\2\2\2\u010d\u0114\3\2\2\2\u010e\u0110\7\60\2\2\u010f"+
		"\u0111\4\62;\2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u010e\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115Z\3\2\2\2\u0116\u0117\t\5\2\2\u0117\\\3\2\2\2\u0118"+
		"\u0119\t\6\2\2\u0119^\3\2\2\2\u011a\u011c\t\7\2\2\u011b\u011a\3\2\2\2"+
		"\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e`\3"+
		"\2\2\2\u011f\u0121\t\b\2\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\b\61"+
		"\2\2\u0125b\3\2\2\2\r\2\u00f2\u00f4\u00fd\u0103\u0107\u010c\u0112\u0114"+
		"\u011d\u0122\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}