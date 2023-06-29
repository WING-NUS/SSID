// Generated from R.g4 by ANTLR 4.8
package Antlr4Grammars.r;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, HEX=56, INT=57, FLOAT=58, COMPLEX=59, STRING=60, 
		ID=61, USER_OP=62, NL=63, WS=64;
	public static final int
		RULE_prog = 0, RULE_expr = 1, RULE_exprlist = 2, RULE_formlist = 3, RULE_form = 4, 
		RULE_sublist = 5, RULE_sub = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "expr", "exprlist", "formlist", "form", "sublist", "sub"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'[['", "']'", "'['", "'::'", "':::'", "'$'", "'@'", "'^'", 
			"'-'", "'+'", "':'", "'*'", "'/'", "'>'", "'>='", "'<'", "'<='", "'=='", 
			"'!='", "'!'", "'&'", "'&&'", "'|'", "'||'", "'~'", "'<-'", "'<<-'", 
			"'='", "'->'", "'->>'", "':='", "'function'", "'('", "')'", "'{'", "'}'", 
			"'if'", "'else'", "'for'", "'in'", "'while'", "'repeat'", "'?'", "'next'", 
			"'break'", "'NULL'", "'NA'", "'Inf'", "'NaN'", "'TRUE'", "'FALSE'", "','", 
			"'...'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "HEX", "INT", "FLOAT", 
			"COMPLEX", "STRING", "ID", "USER_OP", "NL", "WS"
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

	@Override
	public String getGrammarFileName() { return "R.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RParser.EOF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(RParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(RParser.NL, i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__20) | (1L << T__25) | (1L << T__32) | (1L << T__33) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << HEX) | (1L << INT) | (1L << FLOAT) | (1L << COMPLEX) | (1L << STRING) | (1L << ID) | (1L << NL))) != 0)) {
				{
				setState(22);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
				case T__10:
				case T__20:
				case T__25:
				case T__32:
				case T__33:
				case T__35:
				case T__37:
				case T__39:
				case T__41:
				case T__42:
				case T__43:
				case T__44:
				case T__45:
				case T__46:
				case T__47:
				case T__48:
				case T__49:
				case T__50:
				case T__51:
				case HEX:
				case INT:
				case FLOAT:
				case COMPLEX:
				case STRING:
				case ID:
					{
					setState(14);
					expr(0);
					setState(18);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(15);
							_la = _input.LA(1);
							if ( !(_la==T__0 || _la==NL) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
							} 
						}
						setState(20);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					}
					}
					break;
				case NL:
					{
					setState(21);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FormlistContext formlist() {
			return getRuleContext(FormlistContext.class,0);
		}
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public TerminalNode STRING() { return getToken(RParser.STRING, 0); }
		public TerminalNode HEX() { return getToken(RParser.HEX, 0); }
		public TerminalNode INT() { return getToken(RParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(RParser.FLOAT, 0); }
		public TerminalNode COMPLEX() { return getToken(RParser.COMPLEX, 0); }
		public TerminalNode USER_OP() { return getToken(RParser.USER_OP, 0); }
		public SublistContext sublist() {
			return getRuleContext(SublistContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(30);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(31);
				expr(36);
				}
				break;
			case 2:
				{
				setState(32);
				match(T__20);
				setState(33);
				expr(30);
				}
				break;
			case 3:
				{
				setState(34);
				match(T__25);
				setState(35);
				expr(27);
				}
				break;
			case 4:
				{
				setState(36);
				match(T__32);
				setState(37);
				match(T__33);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__53) | (1L << T__54) | (1L << ID))) != 0)) {
					{
					setState(38);
					formlist();
					}
				}

				setState(41);
				match(T__34);
				setState(42);
				expr(24);
				}
				break;
			case 5:
				{
				setState(43);
				match(T__35);
				setState(44);
				exprlist();
				setState(45);
				match(T__36);
				}
				break;
			case 6:
				{
				setState(47);
				match(T__37);
				setState(48);
				match(T__33);
				setState(49);
				expr(0);
				setState(50);
				match(T__34);
				setState(51);
				expr(21);
				}
				break;
			case 7:
				{
				setState(53);
				match(T__37);
				setState(54);
				match(T__33);
				setState(55);
				expr(0);
				setState(56);
				match(T__34);
				setState(57);
				expr(0);
				setState(58);
				match(T__38);
				setState(59);
				expr(20);
				}
				break;
			case 8:
				{
				setState(61);
				match(T__39);
				setState(62);
				match(T__33);
				setState(63);
				match(ID);
				setState(64);
				match(T__40);
				setState(65);
				expr(0);
				setState(66);
				match(T__34);
				setState(67);
				expr(19);
				}
				break;
			case 9:
				{
				setState(69);
				match(T__41);
				setState(70);
				match(T__33);
				setState(71);
				expr(0);
				setState(72);
				match(T__34);
				setState(73);
				expr(18);
				}
				break;
			case 10:
				{
				setState(75);
				match(T__42);
				setState(76);
				expr(17);
				}
				break;
			case 11:
				{
				setState(77);
				match(T__43);
				setState(78);
				expr(16);
				}
				break;
			case 12:
				{
				setState(79);
				match(T__44);
				}
				break;
			case 13:
				{
				setState(80);
				match(T__45);
				}
				break;
			case 14:
				{
				setState(81);
				match(T__33);
				setState(82);
				expr(0);
				setState(83);
				match(T__34);
				}
				break;
			case 15:
				{
				setState(85);
				match(ID);
				}
				break;
			case 16:
				{
				setState(86);
				match(STRING);
				}
				break;
			case 17:
				{
				setState(87);
				match(HEX);
				}
				break;
			case 18:
				{
				setState(88);
				match(INT);
				}
				break;
			case 19:
				{
				setState(89);
				match(FLOAT);
				}
				break;
			case 20:
				{
				setState(90);
				match(COMPLEX);
				}
				break;
			case 21:
				{
				setState(91);
				match(T__46);
				}
				break;
			case 22:
				{
				setState(92);
				match(T__47);
				}
				break;
			case 23:
				{
				setState(93);
				match(T__48);
				}
				break;
			case 24:
				{
				setState(94);
				match(T__49);
				}
				break;
			case 25:
				{
				setState(95);
				match(T__50);
				}
				break;
			case 26:
				{
				setState(96);
				match(T__51);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(151);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 39))) throw new FailedPredicateException(this, "precpred(_ctx, 39)");
						setState(100);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(101);
						expr(40);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(102);
						if (!(precpred(_ctx, 38))) throw new FailedPredicateException(this, "precpred(_ctx, 38)");
						setState(103);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(104);
						expr(39);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(106);
						match(T__8);
						setState(107);
						expr(37);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(108);
						if (!(precpred(_ctx, 35))) throw new FailedPredicateException(this, "precpred(_ctx, 35)");
						setState(109);
						match(T__11);
						setState(110);
						expr(36);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(111);
						if (!(precpred(_ctx, 34))) throw new FailedPredicateException(this, "precpred(_ctx, 34)");
						setState(112);
						match(USER_OP);
						setState(113);
						expr(35);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(114);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(115);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(116);
						expr(34);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(117);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(118);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__10) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(119);
						expr(33);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(120);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(121);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(122);
						expr(32);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(124);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(125);
						expr(30);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(127);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(128);
						expr(29);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(130);
						match(T__25);
						setState(131);
						expr(27);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(132);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(133);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(134);
						expr(26);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 41))) throw new FailedPredicateException(this, "precpred(_ctx, 41)");
						setState(136);
						match(T__1);
						setState(137);
						sublist();
						setState(138);
						match(T__2);
						setState(139);
						match(T__2);
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(141);
						if (!(precpred(_ctx, 40))) throw new FailedPredicateException(this, "precpred(_ctx, 40)");
						setState(142);
						match(T__3);
						setState(143);
						sublist();
						setState(144);
						match(T__2);
						}
						break;
					case 15:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(147);
						match(T__33);
						setState(148);
						sublist();
						setState(149);
						match(T__34);
						}
						break;
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprlistContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(RParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(RParser.NL, i);
		}
		public ExprlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprlist; }
	}

	public final ExprlistContext exprlist() throws RecognitionException {
		ExprlistContext _localctx = new ExprlistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exprlist);
		int _la;
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__20:
			case T__25:
			case T__32:
			case T__33:
			case T__35:
			case T__37:
			case T__39:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case HEX:
			case INT:
			case FLOAT:
			case COMPLEX:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				expr(0);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0 || _la==NL) {
					{
					{
					setState(157);
					_la = _input.LA(1);
					if ( !(_la==T__0 || _la==NL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__20) | (1L << T__25) | (1L << T__32) | (1L << T__33) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << HEX) | (1L << INT) | (1L << FLOAT) | (1L << COMPLEX) | (1L << STRING) | (1L << ID))) != 0)) {
						{
						setState(158);
						expr(0);
						}
					}

					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormlistContext extends ParserRuleContext {
		public List<FormContext> form() {
			return getRuleContexts(FormContext.class);
		}
		public FormContext form(int i) {
			return getRuleContext(FormContext.class,i);
		}
		public FormlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formlist; }
	}

	public final FormlistContext formlist() throws RecognitionException {
		FormlistContext _localctx = new FormlistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			form();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__52) {
				{
				{
				setState(170);
				match(T__52);
				setState(171);
				form();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_form);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(ID);
				setState(179);
				match(T__28);
				setState(180);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				match(T__53);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				match(T__54);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SublistContext extends ParserRuleContext {
		public List<SubContext> sub() {
			return getRuleContexts(SubContext.class);
		}
		public SubContext sub(int i) {
			return getRuleContext(SubContext.class,i);
		}
		public SublistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sublist; }
	}

	public final SublistContext sublist() throws RecognitionException {
		SublistContext _localctx = new SublistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sublist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			sub();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__52) {
				{
				{
				setState(186);
				match(T__52);
				setState(187);
				sub();
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public TerminalNode STRING() { return getToken(RParser.STRING, 0); }
		public SubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub; }
	}

	public final SubContext sub() throws RecognitionException {
		SubContext _localctx = new SubContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sub);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(ID);
				setState(195);
				match(T__28);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(ID);
				setState(197);
				match(T__28);
				setState(198);
				expr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				match(STRING);
				setState(200);
				match(T__28);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				match(STRING);
				setState(202);
				match(T__28);
				setState(203);
				expr(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(204);
				match(T__46);
				setState(205);
				match(T__28);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(206);
				match(T__46);
				setState(207);
				match(T__28);
				setState(208);
				expr(0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(209);
				match(T__53);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(210);
				match(T__54);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 39);
		case 1:
			return precpred(_ctx, 38);
		case 2:
			return precpred(_ctx, 37);
		case 3:
			return precpred(_ctx, 35);
		case 4:
			return precpred(_ctx, 34);
		case 5:
			return precpred(_ctx, 33);
		case 6:
			return precpred(_ctx, 32);
		case 7:
			return precpred(_ctx, 31);
		case 8:
			return precpred(_ctx, 29);
		case 9:
			return precpred(_ctx, 28);
		case 10:
			return precpred(_ctx, 26);
		case 11:
			return precpred(_ctx, 25);
		case 12:
			return precpred(_ctx, 41);
		case 13:
			return precpred(_ctx, 40);
		case 14:
			return precpred(_ctx, 23);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u00d9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\7\2\23\n\2\f\2"+
		"\16\2\26\13\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3*\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3d\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u009a\n\3"+
		"\f\3\16\3\u009d\13\3\3\4\3\4\3\4\5\4\u00a2\n\4\7\4\u00a4\n\4\f\4\16\4"+
		"\u00a7\13\4\3\4\5\4\u00aa\n\4\3\5\3\5\3\5\7\5\u00af\n\5\f\5\16\5\u00b2"+
		"\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00ba\n\6\3\7\3\7\3\7\7\7\u00bf\n\7"+
		"\f\7\16\7\u00c2\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00d7\n\b\3\b\2\3\4\t\2\4\6\b\n\f\16\2"+
		"\13\4\2\3\3AA\3\2\f\r\3\2\7\b\3\2\t\n\3\2\17\20\3\2\21\26\3\2\30\31\3"+
		"\2\32\33\3\2\35\"\2\u010e\2\32\3\2\2\2\4c\3\2\2\2\6\u00a9\3\2\2\2\b\u00ab"+
		"\3\2\2\2\n\u00b9\3\2\2\2\f\u00bb\3\2\2\2\16\u00d6\3\2\2\2\20\24\5\4\3"+
		"\2\21\23\t\2\2\2\22\21\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2"+
		"\2\25\31\3\2\2\2\26\24\3\2\2\2\27\31\7A\2\2\30\20\3\2\2\2\30\27\3\2\2"+
		"\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\32\3\2\2"+
		"\2\35\36\7\2\2\3\36\3\3\2\2\2\37 \b\3\1\2 !\t\3\2\2!d\5\4\3&\"#\7\27\2"+
		"\2#d\5\4\3 $%\7\34\2\2%d\5\4\3\35&\'\7#\2\2\')\7$\2\2(*\5\b\5\2)(\3\2"+
		"\2\2)*\3\2\2\2*+\3\2\2\2+,\7%\2\2,d\5\4\3\32-.\7&\2\2./\5\6\4\2/\60\7"+
		"\'\2\2\60d\3\2\2\2\61\62\7(\2\2\62\63\7$\2\2\63\64\5\4\3\2\64\65\7%\2"+
		"\2\65\66\5\4\3\27\66d\3\2\2\2\678\7(\2\289\7$\2\29:\5\4\3\2:;\7%\2\2;"+
		"<\5\4\3\2<=\7)\2\2=>\5\4\3\26>d\3\2\2\2?@\7*\2\2@A\7$\2\2AB\7?\2\2BC\7"+
		"+\2\2CD\5\4\3\2DE\7%\2\2EF\5\4\3\25Fd\3\2\2\2GH\7,\2\2HI\7$\2\2IJ\5\4"+
		"\3\2JK\7%\2\2KL\5\4\3\24Ld\3\2\2\2MN\7-\2\2Nd\5\4\3\23OP\7.\2\2Pd\5\4"+
		"\3\22Qd\7/\2\2Rd\7\60\2\2ST\7$\2\2TU\5\4\3\2UV\7%\2\2Vd\3\2\2\2Wd\7?\2"+
		"\2Xd\7>\2\2Yd\7:\2\2Zd\7;\2\2[d\7<\2\2\\d\7=\2\2]d\7\61\2\2^d\7\62\2\2"+
		"_d\7\63\2\2`d\7\64\2\2ad\7\65\2\2bd\7\66\2\2c\37\3\2\2\2c\"\3\2\2\2c$"+
		"\3\2\2\2c&\3\2\2\2c-\3\2\2\2c\61\3\2\2\2c\67\3\2\2\2c?\3\2\2\2cG\3\2\2"+
		"\2cM\3\2\2\2cO\3\2\2\2cQ\3\2\2\2cR\3\2\2\2cS\3\2\2\2cW\3\2\2\2cX\3\2\2"+
		"\2cY\3\2\2\2cZ\3\2\2\2c[\3\2\2\2c\\\3\2\2\2c]\3\2\2\2c^\3\2\2\2c_\3\2"+
		"\2\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2d\u009b\3\2\2\2ef\f)\2\2fg\t\4\2\2g"+
		"\u009a\5\4\3*hi\f(\2\2ij\t\5\2\2j\u009a\5\4\3)kl\f\'\2\2lm\7\13\2\2m\u009a"+
		"\5\4\3\'no\f%\2\2op\7\16\2\2p\u009a\5\4\3&qr\f$\2\2rs\7@\2\2s\u009a\5"+
		"\4\3%tu\f#\2\2uv\t\6\2\2v\u009a\5\4\3$wx\f\"\2\2xy\t\3\2\2y\u009a\5\4"+
		"\3#z{\f!\2\2{|\t\7\2\2|\u009a\5\4\3\"}~\f\37\2\2~\177\t\b\2\2\177\u009a"+
		"\5\4\3 \u0080\u0081\f\36\2\2\u0081\u0082\t\t\2\2\u0082\u009a\5\4\3\37"+
		"\u0083\u0084\f\34\2\2\u0084\u0085\7\34\2\2\u0085\u009a\5\4\3\35\u0086"+
		"\u0087\f\33\2\2\u0087\u0088\t\n\2\2\u0088\u009a\5\4\3\34\u0089\u008a\f"+
		"+\2\2\u008a\u008b\7\4\2\2\u008b\u008c\5\f\7\2\u008c\u008d\7\5\2\2\u008d"+
		"\u008e\7\5\2\2\u008e\u009a\3\2\2\2\u008f\u0090\f*\2\2\u0090\u0091\7\6"+
		"\2\2\u0091\u0092\5\f\7\2\u0092\u0093\7\5\2\2\u0093\u009a\3\2\2\2\u0094"+
		"\u0095\f\31\2\2\u0095\u0096\7$\2\2\u0096\u0097\5\f\7\2\u0097\u0098\7%"+
		"\2\2\u0098\u009a\3\2\2\2\u0099e\3\2\2\2\u0099h\3\2\2\2\u0099k\3\2\2\2"+
		"\u0099n\3\2\2\2\u0099q\3\2\2\2\u0099t\3\2\2\2\u0099w\3\2\2\2\u0099z\3"+
		"\2\2\2\u0099}\3\2\2\2\u0099\u0080\3\2\2\2\u0099\u0083\3\2\2\2\u0099\u0086"+
		"\3\2\2\2\u0099\u0089\3\2\2\2\u0099\u008f\3\2\2\2\u0099\u0094\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\5\3\2\2\2"+
		"\u009d\u009b\3\2\2\2\u009e\u00a5\5\4\3\2\u009f\u00a1\t\2\2\2\u00a0\u00a2"+
		"\5\4\3\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3"+
		"\u009f\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00aa\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9"+
		"\u009e\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\7\3\2\2\2\u00ab\u00b0\5\n\6\2"+
		"\u00ac\u00ad\7\67\2\2\u00ad\u00af\5\n\6\2\u00ae\u00ac\3\2\2\2\u00af\u00b2"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\t\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00ba\7?\2\2\u00b4\u00b5\7?\2\2\u00b5\u00b6\7\37"+
		"\2\2\u00b6\u00ba\5\4\3\2\u00b7\u00ba\78\2\2\u00b8\u00ba\79\2\2\u00b9\u00b3"+
		"\3\2\2\2\u00b9\u00b4\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba"+
		"\13\3\2\2\2\u00bb\u00c0\5\16\b\2\u00bc\u00bd\7\67\2\2\u00bd\u00bf\5\16"+
		"\b\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\r\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00d7\5\4\3\2"+
		"\u00c4\u00c5\7?\2\2\u00c5\u00d7\7\37\2\2\u00c6\u00c7\7?\2\2\u00c7\u00c8"+
		"\7\37\2\2\u00c8\u00d7\5\4\3\2\u00c9\u00ca\7>\2\2\u00ca\u00d7\7\37\2\2"+
		"\u00cb\u00cc\7>\2\2\u00cc\u00cd\7\37\2\2\u00cd\u00d7\5\4\3\2\u00ce\u00cf"+
		"\7\61\2\2\u00cf\u00d7\7\37\2\2\u00d0\u00d1\7\61\2\2\u00d1\u00d2\7\37\2"+
		"\2\u00d2\u00d7\5\4\3\2\u00d3\u00d7\78\2\2\u00d4\u00d7\79\2\2\u00d5\u00d7"+
		"\3\2\2\2\u00d6\u00c3\3\2\2\2\u00d6\u00c4\3\2\2\2\u00d6\u00c6\3\2\2\2\u00d6"+
		"\u00c9\3\2\2\2\u00d6\u00cb\3\2\2\2\u00d6\u00ce\3\2\2\2\u00d6\u00d0\3\2"+
		"\2\2\u00d6\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7"+
		"\17\3\2\2\2\20\24\30\32)c\u0099\u009b\u00a1\u00a5\u00a9\u00b0\u00b9\u00c0"+
		"\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}