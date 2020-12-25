// Generated from Ocaml.g4 by ANTLR 4.8
package Antlr4Grammars.ocaml;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OcamlParser extends Parser {
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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, Assert=45, 
		Class=46, Do=47, Else=48, False=49, For=50, If=51, New=52, Private=53, 
		True=54, Try=55, While=56, Ident=57, CapitalizedIdent=58, LowercaseIdent=59, 
		WS=60, NEWLINE=61, IntegerLiteral=62, FloatLiteral=63, CharacterLiteral=64, 
		StringLiteral=65, NL=66, LabelName=67, Label=68, OptLabel=69, InfixSymbol=70, 
		PrefixSymbol=71, OperatorChar=72;
	public static final int
		RULE_and = 0, RULE_as = 1, RULE_asr = 2, RULE_begin = 3, RULE_constraint = 4, 
		RULE_done = 5, RULE_downto = 6, RULE_end = 7, RULE_exception = 8, RULE_external = 9, 
		RULE_fun = 10, RULE_function = 11, RULE_functor = 12, RULE_in = 13, RULE_include = 14, 
		RULE_inherit = 15, RULE_initializer = 16, RULE_land = 17, RULE_lazy = 18, 
		RULE_let = 19, RULE_lor = 20, RULE_lsl = 21, RULE_lsr = 22, RULE_lxor = 23, 
		RULE_match = 24, RULE_method = 25, RULE_mod = 26, RULE_module = 27, RULE_mutable = 28, 
		RULE_nonrec = 29, RULE_object = 30, RULE_of = 31, RULE_open = 32, RULE_or = 33, 
		RULE_rec = 34, RULE_sig = 35, RULE_struct = 36, RULE_then = 37, RULE_to = 38, 
		RULE_type = 39, RULE_val = 40, RULE_virtual = 41, RULE_when = 42, RULE_with = 43;
	private static String[] makeRuleNames() {
		return new String[] {
			"and", "as", "asr", "begin", "constraint", "done", "downto", "end", "exception", 
			"external", "fun", "function", "functor", "in", "include", "inherit", 
			"initializer", "land", "lazy", "let", "lor", "lsl", "lsr", "lxor", "match", 
			"method", "mod", "module", "mutable", "nonrec", "object", "of", "open", 
			"or", "rec", "sig", "struct", "then", "to", "type", "val", "virtual", 
			"when", "with"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'and'", "'as'", "'asr'", "'begin'", "'constraint'", "'done'", 
			"'downto'", "'end'", "'Exception'", "'external'", "'fun'", "'function'", 
			"'functor'", "'in'", "'include'", "'inherit'", "'initializer'", "'land'", 
			"'lazy'", "'let'", "'lor'", "'lsl'", "'lsr'", "'lxor'", "'match'", "'method'", 
			"'mod'", "'module'", "'mutable'", "'nonrec'", "'object'", "'of'", "'open'", 
			"'or'", "'rec'", "'sig'", "'struct'", "'then'", "'to'", "'type'", "'val'", 
			"'virtual'", "'when'", "'with'", "'assert'", "'class'", "'do'", "'else'", 
			"'false'", "'for'", "'if'", "'new'", "'private'", "'true'", "'try'", 
			"'while'", null, null, null, null, null, null, null, null, null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "Assert", "Class", 
			"Do", "Else", "False", "For", "If", "New", "Private", "True", "Try", 
			"While", "Ident", "CapitalizedIdent", "LowercaseIdent", "WS", "NEWLINE", 
			"IntegerLiteral", "FloatLiteral", "CharacterLiteral", "StringLiteral", 
			"NL", "LabelName", "Label", "OptLabel", "InfixSymbol", "PrefixSymbol", 
			"OperatorChar"
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
	public String getGrammarFileName() { return "Ocaml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OcamlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class AndContext extends ParserRuleContext {
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__0);
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

	public static class AsContext extends ParserRuleContext {
		public AsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as; }
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__1);
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

	public static class AsrContext extends ParserRuleContext {
		public AsrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asr; }
	}

	public final AsrContext asr() throws RecognitionException {
		AsrContext _localctx = new AsrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_asr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__2);
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

	public static class BeginContext extends ParserRuleContext {
		public BeginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin; }
	}

	public final BeginContext begin() throws RecognitionException {
		BeginContext _localctx = new BeginContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_begin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__3);
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

	public static class ConstraintContext extends ParserRuleContext {
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__4);
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

	public static class DoneContext extends ParserRuleContext {
		public DoneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_done; }
	}

	public final DoneContext done() throws RecognitionException {
		DoneContext _localctx = new DoneContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_done);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__5);
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

	public static class DowntoContext extends ParserRuleContext {
		public DowntoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_downto; }
	}

	public final DowntoContext downto() throws RecognitionException {
		DowntoContext _localctx = new DowntoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_downto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__6);
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

	public static class EndContext extends ParserRuleContext {
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__7);
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

	public static class ExceptionContext extends ParserRuleContext {
		public ExceptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exception; }
	}

	public final ExceptionContext exception() throws RecognitionException {
		ExceptionContext _localctx = new ExceptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_exception);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__8);
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

	public static class ExternalContext extends ParserRuleContext {
		public ExternalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_external; }
	}

	public final ExternalContext external() throws RecognitionException {
		ExternalContext _localctx = new ExternalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_external);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__9);
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

	public static class FunContext extends ParserRuleContext {
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__10);
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

	public static class FunctionContext extends ParserRuleContext {
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__11);
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

	public static class FunctorContext extends ParserRuleContext {
		public FunctorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functor; }
	}

	public final FunctorContext functor() throws RecognitionException {
		FunctorContext _localctx = new FunctorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__12);
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

	public static class InContext extends ParserRuleContext {
		public InContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in; }
	}

	public final InContext in() throws RecognitionException {
		InContext _localctx = new InContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_in);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__13);
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

	public static class IncludeContext extends ParserRuleContext {
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__14);
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

	public static class InheritContext extends ParserRuleContext {
		public InheritContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inherit; }
	}

	public final InheritContext inherit() throws RecognitionException {
		InheritContext _localctx = new InheritContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_inherit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__15);
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

	public static class InitializerContext extends ParserRuleContext {
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__16);
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

	public static class LandContext extends ParserRuleContext {
		public LandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_land; }
	}

	public final LandContext land() throws RecognitionException {
		LandContext _localctx = new LandContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_land);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__17);
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

	public static class LazyContext extends ParserRuleContext {
		public LazyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lazy; }
	}

	public final LazyContext lazy() throws RecognitionException {
		LazyContext _localctx = new LazyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_lazy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__18);
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

	public static class LetContext extends ParserRuleContext {
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_let);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__19);
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

	public static class LorContext extends ParserRuleContext {
		public LorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lor; }
	}

	public final LorContext lor() throws RecognitionException {
		LorContext _localctx = new LorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_lor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__20);
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

	public static class LslContext extends ParserRuleContext {
		public LslContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lsl; }
	}

	public final LslContext lsl() throws RecognitionException {
		LslContext _localctx = new LslContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_lsl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__21);
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

	public static class LsrContext extends ParserRuleContext {
		public LsrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lsr; }
	}

	public final LsrContext lsr() throws RecognitionException {
		LsrContext _localctx = new LsrContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_lsr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__22);
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

	public static class LxorContext extends ParserRuleContext {
		public LxorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lxor; }
	}

	public final LxorContext lxor() throws RecognitionException {
		LxorContext _localctx = new LxorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_lxor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__23);
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

	public static class MatchContext extends ParserRuleContext {
		public MatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match; }
	}

	public final MatchContext match() throws RecognitionException {
		MatchContext _localctx = new MatchContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_match);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__24);
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

	public static class MethodContext extends ParserRuleContext {
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_method);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__25);
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

	public static class ModContext extends ParserRuleContext {
		public ModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mod; }
	}

	public final ModContext mod() throws RecognitionException {
		ModContext _localctx = new ModContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_mod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__26);
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

	public static class ModuleContext extends ParserRuleContext {
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_module);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__27);
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

	public static class MutableContext extends ParserRuleContext {
		public MutableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mutable; }
	}

	public final MutableContext mutable() throws RecognitionException {
		MutableContext _localctx = new MutableContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_mutable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__28);
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

	public static class NonrecContext extends ParserRuleContext {
		public NonrecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonrec; }
	}

	public final NonrecContext nonrec() throws RecognitionException {
		NonrecContext _localctx = new NonrecContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_nonrec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__29);
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

	public static class ObjectContext extends ParserRuleContext {
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__30);
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

	public static class OfContext extends ParserRuleContext {
		public OfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_of; }
	}

	public final OfContext of() throws RecognitionException {
		OfContext _localctx = new OfContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_of);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__31);
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

	public static class OpenContext extends ParserRuleContext {
		public OpenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open; }
	}

	public final OpenContext open() throws RecognitionException {
		OpenContext _localctx = new OpenContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_open);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__32);
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

	public static class OrContext extends ParserRuleContext {
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__33);
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

	public static class RecContext extends ParserRuleContext {
		public RecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rec; }
	}

	public final RecContext rec() throws RecognitionException {
		RecContext _localctx = new RecContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_rec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__34);
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

	public static class SigContext extends ParserRuleContext {
		public SigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sig; }
	}

	public final SigContext sig() throws RecognitionException {
		SigContext _localctx = new SigContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_sig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__35);
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

	public static class StructContext extends ParserRuleContext {
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__36);
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

	public static class ThenContext extends ParserRuleContext {
		public ThenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_then; }
	}

	public final ThenContext then() throws RecognitionException {
		ThenContext _localctx = new ThenContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_then);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__37);
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

	public static class ToContext extends ParserRuleContext {
		public ToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_to; }
	}

	public final ToContext to() throws RecognitionException {
		ToContext _localctx = new ToContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__38);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__39);
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

	public static class ValContext extends ParserRuleContext {
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_val);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__40);
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

	public static class VirtualContext extends ParserRuleContext {
		public VirtualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_virtual; }
	}

	public final VirtualContext virtual() throws RecognitionException {
		VirtualContext _localctx = new VirtualContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_virtual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(T__41);
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

	public static class WhenContext extends ParserRuleContext {
		public WhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_when; }
	}

	public final WhenContext when() throws RecognitionException {
		WhenContext _localctx = new WhenContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_when);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__42);
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

	public static class WithContext extends ParserRuleContext {
		public WithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with; }
	}

	public final WithContext with() throws RecognitionException {
		WithContext _localctx = new WithContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_with);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__43);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3J\u00b3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)"+
		"\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\2\2.\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX\2\2\2\u0086\2Z\3\2\2\2\4\\\3"+
		"\2\2\2\6^\3\2\2\2\b`\3\2\2\2\nb\3\2\2\2\fd\3\2\2\2\16f\3\2\2\2\20h\3\2"+
		"\2\2\22j\3\2\2\2\24l\3\2\2\2\26n\3\2\2\2\30p\3\2\2\2\32r\3\2\2\2\34t\3"+
		"\2\2\2\36v\3\2\2\2 x\3\2\2\2\"z\3\2\2\2$|\3\2\2\2&~\3\2\2\2(\u0080\3\2"+
		"\2\2*\u0082\3\2\2\2,\u0084\3\2\2\2.\u0086\3\2\2\2\60\u0088\3\2\2\2\62"+
		"\u008a\3\2\2\2\64\u008c\3\2\2\2\66\u008e\3\2\2\28\u0090\3\2\2\2:\u0092"+
		"\3\2\2\2<\u0094\3\2\2\2>\u0096\3\2\2\2@\u0098\3\2\2\2B\u009a\3\2\2\2D"+
		"\u009c\3\2\2\2F\u009e\3\2\2\2H\u00a0\3\2\2\2J\u00a2\3\2\2\2L\u00a4\3\2"+
		"\2\2N\u00a6\3\2\2\2P\u00a8\3\2\2\2R\u00aa\3\2\2\2T\u00ac\3\2\2\2V\u00ae"+
		"\3\2\2\2X\u00b0\3\2\2\2Z[\7\3\2\2[\3\3\2\2\2\\]\7\4\2\2]\5\3\2\2\2^_\7"+
		"\5\2\2_\7\3\2\2\2`a\7\6\2\2a\t\3\2\2\2bc\7\7\2\2c\13\3\2\2\2de\7\b\2\2"+
		"e\r\3\2\2\2fg\7\t\2\2g\17\3\2\2\2hi\7\n\2\2i\21\3\2\2\2jk\7\13\2\2k\23"+
		"\3\2\2\2lm\7\f\2\2m\25\3\2\2\2no\7\r\2\2o\27\3\2\2\2pq\7\16\2\2q\31\3"+
		"\2\2\2rs\7\17\2\2s\33\3\2\2\2tu\7\20\2\2u\35\3\2\2\2vw\7\21\2\2w\37\3"+
		"\2\2\2xy\7\22\2\2y!\3\2\2\2z{\7\23\2\2{#\3\2\2\2|}\7\24\2\2}%\3\2\2\2"+
		"~\177\7\25\2\2\177\'\3\2\2\2\u0080\u0081\7\26\2\2\u0081)\3\2\2\2\u0082"+
		"\u0083\7\27\2\2\u0083+\3\2\2\2\u0084\u0085\7\30\2\2\u0085-\3\2\2\2\u0086"+
		"\u0087\7\31\2\2\u0087/\3\2\2\2\u0088\u0089\7\32\2\2\u0089\61\3\2\2\2\u008a"+
		"\u008b\7\33\2\2\u008b\63\3\2\2\2\u008c\u008d\7\34\2\2\u008d\65\3\2\2\2"+
		"\u008e\u008f\7\35\2\2\u008f\67\3\2\2\2\u0090\u0091\7\36\2\2\u00919\3\2"+
		"\2\2\u0092\u0093\7\37\2\2\u0093;\3\2\2\2\u0094\u0095\7 \2\2\u0095=\3\2"+
		"\2\2\u0096\u0097\7!\2\2\u0097?\3\2\2\2\u0098\u0099\7\"\2\2\u0099A\3\2"+
		"\2\2\u009a\u009b\7#\2\2\u009bC\3\2\2\2\u009c\u009d\7$\2\2\u009dE\3\2\2"+
		"\2\u009e\u009f\7%\2\2\u009fG\3\2\2\2\u00a0\u00a1\7&\2\2\u00a1I\3\2\2\2"+
		"\u00a2\u00a3\7\'\2\2\u00a3K\3\2\2\2\u00a4\u00a5\7(\2\2\u00a5M\3\2\2\2"+
		"\u00a6\u00a7\7)\2\2\u00a7O\3\2\2\2\u00a8\u00a9\7*\2\2\u00a9Q\3\2\2\2\u00aa"+
		"\u00ab\7+\2\2\u00abS\3\2\2\2\u00ac\u00ad\7,\2\2\u00adU\3\2\2\2\u00ae\u00af"+
		"\7-\2\2\u00afW\3\2\2\2\u00b0\u00b1\7.\2\2\u00b1Y\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}