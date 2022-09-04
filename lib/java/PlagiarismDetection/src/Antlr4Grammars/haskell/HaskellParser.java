// Generated from /Users/sibinhho99/SSID/lib/antlr/grammars/src/haskell/HaskellParser.g4 by ANTLR 4.8
package Antlr4Grammars.lang;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HaskellParser extends Parser {
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
	public static final int
		RULE_module = 0, RULE_module_content = 1, RULE_where_module = 2, RULE_module_body = 3, 
		RULE_pragmas = 4, RULE_pragma = 5, RULE_language_pragma = 6, RULE_options_ghc = 7, 
		RULE_simple_options = 8, RULE_extension_ = 9, RULE_body = 10, RULE_impdecls = 11, 
		RULE_exports = 12, RULE_exprt = 13, RULE_impdecl = 14, RULE_impspec = 15, 
		RULE_himport = 16, RULE_cname = 17, RULE_fixity = 18, RULE_ops = 19, RULE_topdecls = 20, 
		RULE_topdecl = 21, RULE_cl_decl = 22, RULE_ty_decl = 23, RULE_standalone_kind_sig = 24, 
		RULE_sks_vars = 25, RULE_inst_decl = 26, RULE_overlap_pragma = 27, RULE_deriv_strategy_no_via = 28, 
		RULE_deriv_strategy_via = 29, RULE_deriv_standalone_strategy = 30, RULE_opt_injective_info = 31, 
		RULE_injectivity_cond = 32, RULE_inj_varids = 33, RULE_where_type_family = 34, 
		RULE_ty_fam_inst_eqn_list = 35, RULE_ty_fam_inst_eqns = 36, RULE_ty_fam_inst_eqn = 37, 
		RULE_at_decl_cls = 38, RULE_at_decl_inst = 39, RULE_opt_kind_sig = 40, 
		RULE_opt_datafam_kind_sig = 41, RULE_opt_tyfam_kind_sig = 42, RULE_opt_at_kind_inj_sig = 43, 
		RULE_tycl_hdr = 44, RULE_tycl_hdr_inst = 45, RULE_capi_ctype = 46, RULE_standalone_deriving = 47, 
		RULE_role_annot = 48, RULE_roles = 49, RULE_role = 50, RULE_pattern_synonym_decl = 51, 
		RULE_pattern_synonym_lhs = 52, RULE_vars_ = 53, RULE_cvars = 54, RULE_where_decls = 55, 
		RULE_pattern_synonym_sig = 56, RULE_decl_cls = 57, RULE_decls_cls = 58, 
		RULE_decllist_cls = 59, RULE_where_cls = 60, RULE_decl_inst = 61, RULE_decls_inst = 62, 
		RULE_decllist_inst = 63, RULE_where_inst = 64, RULE_decls = 65, RULE_decllist = 66, 
		RULE_binds = 67, RULE_wherebinds = 68, RULE_rules = 69, RULE_pragma_rule = 70, 
		RULE_rule_activation_marker = 71, RULE_rule_activation = 72, RULE_rule_foralls = 73, 
		RULE_rule_vars = 74, RULE_rule_var = 75, RULE_warnings = 76, RULE_pragma_warning = 77, 
		RULE_deprecations = 78, RULE_pragma_deprecation = 79, RULE_strings = 80, 
		RULE_stringlist = 81, RULE_annotation = 82, RULE_fdecl = 83, RULE_callconv = 84, 
		RULE_safety = 85, RULE_fspec = 86, RULE_opt_sig = 87, RULE_opt_tyconsig = 88, 
		RULE_sigtype = 89, RULE_sigtypedoc = 90, RULE_sig_vars = 91, RULE_sigtypes1 = 92, 
		RULE_unpackedness = 93, RULE_forall_vis_flag = 94, RULE_ktype = 95, RULE_ktypedoc = 96, 
		RULE_ctype = 97, RULE_ctypedoc = 98, RULE_tycl_context = 99, RULE_constr_context = 100, 
		RULE_type_ = 101, RULE_typedoc = 102, RULE_constr_btype = 103, RULE_constr_tyapps = 104, 
		RULE_constr_tyapp = 105, RULE_btype = 106, RULE_tyapps = 107, RULE_tyapp = 108, 
		RULE_atype = 109, RULE_inst_type = 110, RULE_deriv_types = 111, RULE_comma_types = 112, 
		RULE_bar_types2 = 113, RULE_tv_bndrs = 114, RULE_tv_bndr = 115, RULE_tv_bndr_no_braces = 116, 
		RULE_fds = 117, RULE_fds1 = 118, RULE_fd = 119, RULE_varids0 = 120, RULE_kind = 121, 
		RULE_gadt_constrlist = 122, RULE_gadt_constrs = 123, RULE_gadt_constr_with_doc = 124, 
		RULE_gadt_constr = 125, RULE_constrs = 126, RULE_constrs1 = 127, RULE_constr = 128, 
		RULE_forall = 129, RULE_constr_stuff = 130, RULE_fielddecls = 131, RULE_fielddecl = 132, 
		RULE_derivings = 133, RULE_deriving = 134, RULE_deriv_clause_types = 135, 
		RULE_decl_no_th = 136, RULE_decl = 137, RULE_rhs = 138, RULE_gdrhs = 139, 
		RULE_gdrh = 140, RULE_sigdecl = 141, RULE_activation = 142, RULE_th_quasiquote = 143, 
		RULE_th_qquasiquote = 144, RULE_quasiquote = 145, RULE_exp = 146, RULE_infixexp = 147, 
		RULE_exp10p = 148, RULE_exp10 = 149, RULE_fexp = 150, RULE_aexp = 151, 
		RULE_aexp1 = 152, RULE_aexp2 = 153, RULE_splice_exp = 154, RULE_splice_untyped = 155, 
		RULE_splice_typed = 156, RULE_cmdargs = 157, RULE_acmd = 158, RULE_cvtopbody = 159, 
		RULE_cvtopdecls0 = 160, RULE_texp = 161, RULE_tup_exprs = 162, RULE_commas_tup_tail = 163, 
		RULE_tup_tail = 164, RULE_list_ = 165, RULE_lexps = 166, RULE_flattenedpquals = 167, 
		RULE_pquals = 168, RULE_squals = 169, RULE_transformqual = 170, RULE_guards = 171, 
		RULE_guard_ = 172, RULE_alts = 173, RULE_alt = 174, RULE_alt_rhs = 175, 
		RULE_ralt = 176, RULE_gdpats = 177, RULE_ifgdpats = 178, RULE_gdpat = 179, 
		RULE_pat = 180, RULE_bindpat = 181, RULE_apat = 182, RULE_apats = 183, 
		RULE_fpat = 184, RULE_stmtlist = 185, RULE_stmts = 186, RULE_stmt = 187, 
		RULE_qual = 188, RULE_fbinds = 189, RULE_fbind = 190, RULE_dbinds = 191, 
		RULE_dbind = 192, RULE_name_boolformula_opt = 193, RULE_name_boolformula_and = 194, 
		RULE_name_boolformula_and_list = 195, RULE_name_boolformula_atom = 196, 
		RULE_namelist = 197, RULE_name_var = 198, RULE_qcon_nowiredlist = 199, 
		RULE_qcon = 200, RULE_gen_qcon = 201, RULE_con = 202, RULE_con_list = 203, 
		RULE_sysdcon_nolist = 204, RULE_sysdcon = 205, RULE_conop = 206, RULE_qconop = 207, 
		RULE_gconsym = 208, RULE_gtycon = 209, RULE_ntgtycon = 210, RULE_oqtycon = 211, 
		RULE_qtyconop = 212, RULE_qtycon = 213, RULE_tycon = 214, RULE_qtyconsym = 215, 
		RULE_tyconsym = 216, RULE_op = 217, RULE_varop = 218, RULE_qop = 219, 
		RULE_qopm = 220, RULE_hole_op = 221, RULE_qvarop = 222, RULE_qvaropm = 223, 
		RULE_tyvar = 224, RULE_tyvarop = 225, RULE_tyvarid = 226, RULE_tycls = 227, 
		RULE_qtycls = 228, RULE_var_ = 229, RULE_qvar = 230, RULE_qvarid = 231, 
		RULE_varid = 232, RULE_qvarsym = 233, RULE_qvarsym_no_minus = 234, RULE_varsym = 235, 
		RULE_varsym_no_minus = 236, RULE_special_id = 237, RULE_qconid = 238, 
		RULE_conid = 239, RULE_qconsym = 240, RULE_consym = 241, RULE_literal = 242, 
		RULE_open_ = 243, RULE_close = 244, RULE_semi = 245, RULE_modid = 246, 
		RULE_commas = 247, RULE_bars = 248, RULE_special = 249, RULE_symbol = 250, 
		RULE_ascSymbol = 251, RULE_integer = 252, RULE_pfloat = 253, RULE_pchar = 254, 
		RULE_pstring = 255;
	private static String[] makeRuleNames() {
		return new String[] {
			"module", "module_content", "where_module", "module_body", "pragmas", 
			"pragma", "language_pragma", "options_ghc", "simple_options", "extension_", 
			"body", "impdecls", "exports", "exprt", "impdecl", "impspec", "himport", 
			"cname", "fixity", "ops", "topdecls", "topdecl", "cl_decl", "ty_decl", 
			"standalone_kind_sig", "sks_vars", "inst_decl", "overlap_pragma", "deriv_strategy_no_via", 
			"deriv_strategy_via", "deriv_standalone_strategy", "opt_injective_info", 
			"injectivity_cond", "inj_varids", "where_type_family", "ty_fam_inst_eqn_list", 
			"ty_fam_inst_eqns", "ty_fam_inst_eqn", "at_decl_cls", "at_decl_inst", 
			"opt_kind_sig", "opt_datafam_kind_sig", "opt_tyfam_kind_sig", "opt_at_kind_inj_sig", 
			"tycl_hdr", "tycl_hdr_inst", "capi_ctype", "standalone_deriving", "role_annot", 
			"roles", "role", "pattern_synonym_decl", "pattern_synonym_lhs", "vars_", 
			"cvars", "where_decls", "pattern_synonym_sig", "decl_cls", "decls_cls", 
			"decllist_cls", "where_cls", "decl_inst", "decls_inst", "decllist_inst", 
			"where_inst", "decls", "decllist", "binds", "wherebinds", "rules", "pragma_rule", 
			"rule_activation_marker", "rule_activation", "rule_foralls", "rule_vars", 
			"rule_var", "warnings", "pragma_warning", "deprecations", "pragma_deprecation", 
			"strings", "stringlist", "annotation", "fdecl", "callconv", "safety", 
			"fspec", "opt_sig", "opt_tyconsig", "sigtype", "sigtypedoc", "sig_vars", 
			"sigtypes1", "unpackedness", "forall_vis_flag", "ktype", "ktypedoc", 
			"ctype", "ctypedoc", "tycl_context", "constr_context", "type_", "typedoc", 
			"constr_btype", "constr_tyapps", "constr_tyapp", "btype", "tyapps", "tyapp", 
			"atype", "inst_type", "deriv_types", "comma_types", "bar_types2", "tv_bndrs", 
			"tv_bndr", "tv_bndr_no_braces", "fds", "fds1", "fd", "varids0", "kind", 
			"gadt_constrlist", "gadt_constrs", "gadt_constr_with_doc", "gadt_constr", 
			"constrs", "constrs1", "constr", "forall", "constr_stuff", "fielddecls", 
			"fielddecl", "derivings", "deriving", "deriv_clause_types", "decl_no_th", 
			"decl", "rhs", "gdrhs", "gdrh", "sigdecl", "activation", "th_quasiquote", 
			"th_qquasiquote", "quasiquote", "exp", "infixexp", "exp10p", "exp10", 
			"fexp", "aexp", "aexp1", "aexp2", "splice_exp", "splice_untyped", "splice_typed", 
			"cmdargs", "acmd", "cvtopbody", "cvtopdecls0", "texp", "tup_exprs", "commas_tup_tail", 
			"tup_tail", "list_", "lexps", "flattenedpquals", "pquals", "squals", 
			"transformqual", "guards", "guard_", "alts", "alt", "alt_rhs", "ralt", 
			"gdpats", "ifgdpats", "gdpat", "pat", "bindpat", "apat", "apats", "fpat", 
			"stmtlist", "stmts", "stmt", "qual", "fbinds", "fbind", "dbinds", "dbind", 
			"name_boolformula_opt", "name_boolformula_and", "name_boolformula_and_list", 
			"name_boolformula_atom", "namelist", "name_var", "qcon_nowiredlist", 
			"qcon", "gen_qcon", "con", "con_list", "sysdcon_nolist", "sysdcon", "conop", 
			"qconop", "gconsym", "gtycon", "ntgtycon", "oqtycon", "qtyconop", "qtycon", 
			"tycon", "qtyconsym", "tyconsym", "op", "varop", "qop", "qopm", "hole_op", 
			"qvarop", "qvaropm", "tyvar", "tyvarop", "tyvarid", "tycls", "qtycls", 
			"var_", "qvar", "qvarid", "varid", "qvarsym", "qvarsym_no_minus", "varsym", 
			"varsym_no_minus", "special_id", "qconid", "conid", "qconsym", "consym", 
			"literal", "open_", "close", "semi", "modid", "commas", "bars", "special", 
			"symbol", "ascSymbol", "integer", "pfloat", "pchar", "pstring"
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

	@Override
	public String getGrammarFileName() { return "HaskellParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HaskellParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(HaskellParser.EOF, 0); }
		public Module_contentContext module_content() {
			return getRuleContext(Module_contentContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode OCURLY() { return getToken(HaskellParser.OCURLY, 0); }
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public PragmasContext pragmas() {
			return getRuleContext(PragmasContext.class,0);
		}
		public TerminalNode CCURLY() { return getToken(HaskellParser.CCURLY, 0); }
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_module);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OCURLY) {
				{
				setState(512);
				match(OCURLY);
				}
			}

			setState(518);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(515);
					semi();
					}
					} 
				}
				setState(520);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(521);
				pragmas();
				}
				break;
			}
			setState(527);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(524);
					semi();
					}
					} 
				}
				setState(529);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(532);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
				{
				setState(530);
				module_content();
				}
				break;
			case NEWLINE:
			case AS:
			case CASE:
			case CLASS:
			case DATA:
			case DEFAULT:
			case DERIVING:
			case DO:
			case HIDING:
			case IF:
			case IMPORT:
			case INFIX:
			case INFIXL:
			case INFIXR:
			case INSTANCE:
			case LET:
			case NEWTYPE:
			case QUALIFIED:
			case TYPE:
			case WILDCARD:
			case FOREIGN:
			case EXPORT:
			case MDO:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case PATTERN:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case LCASE:
			case Bang:
			case Minus:
			case Tilde:
			case DDollar:
			case Dollar:
			case Semi:
			case Quote:
			case DoubleQuote:
			case ReverseSlash:
			case AopenParen:
			case TopenTexpQuote:
			case TopenExpQuote:
			case TopenPatQuote:
			case TopenTypQoute:
			case TopenDecQoute:
			case OpenBoxParen:
			case OpenRoundBracket:
			case OpenSquareBracket:
			case CHAR:
			case STRING:
			case VARID:
			case CONID:
			case OpenPragmaBracket:
			case SEMI:
			case DECIMAL:
			case OCTAL:
			case HEXADECIMAL:
			case FLOAT:
				{
				setState(531);
				body();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CCURLY) {
				{
				setState(534);
				match(CCURLY);
				}
			}

			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Semi || _la==SEMI) {
				{
				setState(537);
				semi();
				}
			}

			setState(540);
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

	public static class Module_contentContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(HaskellParser.MODULE, 0); }
		public ModidContext modid() {
			return getRuleContext(ModidContext.class,0);
		}
		public Where_moduleContext where_module() {
			return getRuleContext(Where_moduleContext.class,0);
		}
		public ExportsContext exports() {
			return getRuleContext(ExportsContext.class,0);
		}
		public Module_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_content; }
	}

	public final Module_contentContext module_content() throws RecognitionException {
		Module_contentContext _localctx = new Module_contentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_module_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			match(MODULE);
			setState(543);
			modid();
			setState(545);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OpenRoundBracket) {
				{
				setState(544);
				exports();
				}
			}

			setState(547);
			where_module();
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

	public static class Where_moduleContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(HaskellParser.WHERE, 0); }
		public Module_bodyContext module_body() {
			return getRuleContext(Module_bodyContext.class,0);
		}
		public Where_moduleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_module; }
	}

	public final Where_moduleContext where_module() throws RecognitionException {
		Where_moduleContext _localctx = new Where_moduleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_where_module);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			match(WHERE);
			setState(550);
			module_body();
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

	public static class Module_bodyContext extends ParserRuleContext {
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public Module_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_body; }
	}

	public final Module_bodyContext module_body() throws RecognitionException {
		Module_bodyContext _localctx = new Module_bodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_module_body);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			open_();
			setState(553);
			body();
			setState(554);
			close();
			setState(558);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(555);
					semi();
					}
					} 
				}
				setState(560);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class PragmasContext extends ParserRuleContext {
		public List<PragmaContext> pragma() {
			return getRuleContexts(PragmaContext.class);
		}
		public PragmaContext pragma(int i) {
			return getRuleContext(PragmaContext.class,i);
		}
		public PragmasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmas; }
	}

	public final PragmasContext pragmas() throws RecognitionException {
		PragmasContext _localctx = new PragmasContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pragmas);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(562); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(561);
					pragma();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(564); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class PragmaContext extends ParserRuleContext {
		public Language_pragmaContext language_pragma() {
			return getRuleContext(Language_pragmaContext.class,0);
		}
		public Options_ghcContext options_ghc() {
			return getRuleContext(Options_ghcContext.class,0);
		}
		public Simple_optionsContext simple_options() {
			return getRuleContext(Simple_optionsContext.class,0);
		}
		public PragmaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma; }
	}

	public final PragmaContext pragma() throws RecognitionException {
		PragmaContext _localctx = new PragmaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pragma);
		try {
			setState(569);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(566);
				language_pragma();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(567);
				options_ghc();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(568);
				simple_options();
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

	public static class Language_pragmaContext extends ParserRuleContext {
		public TerminalNode OpenPragmaBracket() { return getToken(HaskellParser.OpenPragmaBracket, 0); }
		public TerminalNode LANGUAGE() { return getToken(HaskellParser.LANGUAGE, 0); }
		public List<Extension_Context> extension_() {
			return getRuleContexts(Extension_Context.class);
		}
		public Extension_Context extension_(int i) {
			return getRuleContext(Extension_Context.class,i);
		}
		public TerminalNode ClosePragmaBracket() { return getToken(HaskellParser.ClosePragmaBracket, 0); }
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public Language_pragmaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_language_pragma; }
	}

	public final Language_pragmaContext language_pragma() throws RecognitionException {
		Language_pragmaContext _localctx = new Language_pragmaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_language_pragma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(OpenPragmaBracket);
			setState(572);
			match(LANGUAGE);
			setState(573);
			extension_();
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(574);
				match(Comma);
				setState(575);
				extension_();
				}
				}
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(581);
			match(ClosePragmaBracket);
			setState(583);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(582);
				semi();
				}
				break;
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

	public static class Options_ghcContext extends ParserRuleContext {
		public TerminalNode OpenPragmaBracket() { return getToken(HaskellParser.OpenPragmaBracket, 0); }
		public TerminalNode OPTIONS_GHC() { return getToken(HaskellParser.OPTIONS_GHC, 0); }
		public TerminalNode ClosePragmaBracket() { return getToken(HaskellParser.ClosePragmaBracket, 0); }
		public List<TerminalNode> Minus() { return getTokens(HaskellParser.Minus); }
		public TerminalNode Minus(int i) {
			return getToken(HaskellParser.Minus, i);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public List<VaridContext> varid() {
			return getRuleContexts(VaridContext.class);
		}
		public VaridContext varid(int i) {
			return getRuleContext(VaridContext.class,i);
		}
		public List<ConidContext> conid() {
			return getRuleContexts(ConidContext.class);
		}
		public ConidContext conid(int i) {
			return getRuleContext(ConidContext.class,i);
		}
		public Options_ghcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_options_ghc; }
	}

	public final Options_ghcContext options_ghc() throws RecognitionException {
		Options_ghcContext _localctx = new Options_ghcContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_options_ghc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			match(OpenPragmaBracket);
			setState(586);
			match(OPTIONS_GHC);
			setState(594);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Minus) {
				{
				{
				setState(587);
				match(Minus);
				setState(590);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AS:
				case HIDING:
				case QUALIFIED:
				case EXPORT:
				case STDCALL:
				case CCALL:
				case CAPI:
				case JSCALL:
				case STOCK:
				case ANYCLASS:
				case VIA:
				case VARID:
					{
					setState(588);
					varid();
					}
					break;
				case CONID:
					{
					setState(589);
					conid();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(596);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(597);
			match(ClosePragmaBracket);
			setState(599);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(598);
				semi();
				}
				break;
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

	public static class Simple_optionsContext extends ParserRuleContext {
		public TerminalNode OpenPragmaBracket() { return getToken(HaskellParser.OpenPragmaBracket, 0); }
		public TerminalNode OPTIONS() { return getToken(HaskellParser.OPTIONS, 0); }
		public TerminalNode ClosePragmaBracket() { return getToken(HaskellParser.ClosePragmaBracket, 0); }
		public List<TerminalNode> Minus() { return getTokens(HaskellParser.Minus); }
		public TerminalNode Minus(int i) {
			return getToken(HaskellParser.Minus, i);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public List<VaridContext> varid() {
			return getRuleContexts(VaridContext.class);
		}
		public VaridContext varid(int i) {
			return getRuleContext(VaridContext.class,i);
		}
		public List<ConidContext> conid() {
			return getRuleContexts(ConidContext.class);
		}
		public ConidContext conid(int i) {
			return getRuleContext(ConidContext.class,i);
		}
		public Simple_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_options; }
	}

	public final Simple_optionsContext simple_options() throws RecognitionException {
		Simple_optionsContext _localctx = new Simple_optionsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_simple_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			match(OpenPragmaBracket);
			setState(602);
			match(OPTIONS);
			setState(610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Minus) {
				{
				{
				setState(603);
				match(Minus);
				setState(606);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AS:
				case HIDING:
				case QUALIFIED:
				case EXPORT:
				case STDCALL:
				case CCALL:
				case CAPI:
				case JSCALL:
				case STOCK:
				case ANYCLASS:
				case VIA:
				case VARID:
					{
					setState(604);
					varid();
					}
					break;
				case CONID:
					{
					setState(605);
					conid();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(612);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(613);
			match(ClosePragmaBracket);
			setState(615);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(614);
				semi();
				}
				break;
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

	public static class Extension_Context extends ParserRuleContext {
		public TerminalNode CONID() { return getToken(HaskellParser.CONID, 0); }
		public Extension_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extension_; }
	}

	public final Extension_Context extension_() throws RecognitionException {
		Extension_Context _localctx = new Extension_Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_extension_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(CONID);
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

	public static class BodyContext extends ParserRuleContext {
		public ImpdeclsContext impdecls() {
			return getRuleContext(ImpdeclsContext.class,0);
		}
		public TopdeclsContext topdecls() {
			return getRuleContext(TopdeclsContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_body);
		try {
			setState(624);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(619);
				impdecls();
				setState(620);
				topdecls();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(622);
				impdecls();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(623);
				topdecls();
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

	public static class ImpdeclsContext extends ParserRuleContext {
		public List<ImpdeclContext> impdecl() {
			return getRuleContexts(ImpdeclContext.class);
		}
		public ImpdeclContext impdecl(int i) {
			return getRuleContext(ImpdeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(HaskellParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(HaskellParser.NEWLINE, i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public ImpdeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impdecls; }
	}

	public final ImpdeclsContext impdecls() throws RecognitionException {
		ImpdeclsContext _localctx = new ImpdeclsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_impdecls);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(629); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(629);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case IMPORT:
						{
						setState(626);
						impdecl();
						}
						break;
					case NEWLINE:
						{
						setState(627);
						match(NEWLINE);
						}
						break;
					case Semi:
					case SEMI:
						{
						setState(628);
						semi();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(631); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ExportsContext extends ParserRuleContext {
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public List<ExprtContext> exprt() {
			return getRuleContexts(ExprtContext.class);
		}
		public ExprtContext exprt(int i) {
			return getRuleContext(ExprtContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public ExportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exports; }
	}

	public final ExportsContext exports() throws RecognitionException {
		ExportsContext _localctx = new ExportsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exports);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			match(OpenRoundBracket);
			setState(642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << MODULE) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (CONID - 120)))) != 0)) {
				{
				setState(634);
				exprt();
				setState(639);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(635);
						match(Comma);
						setState(636);
						exprt();
						}
						} 
					}
					setState(641);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				}
			}

			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(644);
				match(Comma);
				}
			}

			setState(647);
			match(CloseRoundBracket);
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

	public static class ExprtContext extends ParserRuleContext {
		public List<QvarContext> qvar() {
			return getRuleContexts(QvarContext.class);
		}
		public QvarContext qvar(int i) {
			return getRuleContext(QvarContext.class,i);
		}
		public QtyconContext qtycon() {
			return getRuleContext(QtyconContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode DoubleDot() { return getToken(HaskellParser.DoubleDot, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public List<CnameContext> cname() {
			return getRuleContexts(CnameContext.class);
		}
		public CnameContext cname(int i) {
			return getRuleContext(CnameContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public QtyclsContext qtycls() {
			return getRuleContext(QtyclsContext.class,0);
		}
		public TerminalNode MODULE() { return getToken(HaskellParser.MODULE, 0); }
		public ModidContext modid() {
			return getRuleContext(ModidContext.class,0);
		}
		public ExprtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprt; }
	}

	public final ExprtContext exprt() throws RecognitionException {
		ExprtContext _localctx = new ExprtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exprt);
		int _la;
		try {
			setState(688);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(649);
				qvar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(650);
				qtycon();
				setState(666);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					{
					setState(651);
					match(OpenRoundBracket);
					setState(652);
					match(DoubleDot);
					setState(653);
					match(CloseRoundBracket);
					}
					}
					break;
				case 2:
					{
					{
					setState(654);
					match(OpenRoundBracket);
					setState(663);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (OpenBoxParen - 118)) | (1L << (OpenRoundBracket - 118)) | (1L << (OpenSquareBracket - 118)) | (1L << (VARID - 118)) | (1L << (CONID - 118)))) != 0)) {
						{
						setState(655);
						cname();
						setState(660);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(656);
							match(Comma);
							setState(657);
							cname();
							}
							}
							setState(662);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(665);
					match(CloseRoundBracket);
					}
					}
					break;
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(668);
				qtycls();
				setState(684);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					{
					setState(669);
					match(OpenRoundBracket);
					setState(670);
					match(DoubleDot);
					setState(671);
					match(CloseRoundBracket);
					}
					}
					break;
				case 2:
					{
					{
					setState(672);
					match(OpenRoundBracket);
					setState(681);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (CONID - 120)))) != 0)) {
						{
						setState(673);
						qvar();
						setState(678);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(674);
							match(Comma);
							setState(675);
							qvar();
							}
							}
							setState(680);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(683);
					match(CloseRoundBracket);
					}
					}
					break;
				}
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(686);
				match(MODULE);
				setState(687);
				modid();
				}
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

	public static class ImpdeclContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(HaskellParser.IMPORT, 0); }
		public List<ModidContext> modid() {
			return getRuleContexts(ModidContext.class);
		}
		public ModidContext modid(int i) {
			return getRuleContext(ModidContext.class,i);
		}
		public TerminalNode QUALIFIED() { return getToken(HaskellParser.QUALIFIED, 0); }
		public TerminalNode AS() { return getToken(HaskellParser.AS, 0); }
		public ImpspecContext impspec() {
			return getRuleContext(ImpspecContext.class,0);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public ImpdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impdecl; }
	}

	public final ImpdeclContext impdecl() throws RecognitionException {
		ImpdeclContext _localctx = new ImpdeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_impdecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			match(IMPORT);
			setState(692);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUALIFIED) {
				{
				setState(691);
				match(QUALIFIED);
				}
			}

			setState(694);
			modid();
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(695);
				match(AS);
				setState(696);
				modid();
				}
			}

			setState(700);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HIDING || _la==OpenRoundBracket) {
				{
				setState(699);
				impspec();
				}
			}

			setState(703); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(702);
					semi();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(705); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ImpspecContext extends ParserRuleContext {
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public List<HimportContext> himport() {
			return getRuleContexts(HimportContext.class);
		}
		public HimportContext himport(int i) {
			return getRuleContext(HimportContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public TerminalNode HIDING() { return getToken(HaskellParser.HIDING, 0); }
		public ImpspecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impspec; }
	}

	public final ImpspecContext impspec() throws RecognitionException {
		ImpspecContext _localctx = new ImpspecContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_impspec);
		int _la;
		try {
			int _alt;
			setState(738);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenRoundBracket:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(707);
				match(OpenRoundBracket);
				setState(719);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (CONID - 120)))) != 0)) {
					{
					setState(708);
					himport();
					setState(713);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(709);
							match(Comma);
							setState(710);
							himport();
							}
							} 
						}
						setState(715);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					}
					setState(717);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(716);
						match(Comma);
						}
					}

					}
				}

				setState(721);
				match(CloseRoundBracket);
				}
				}
				break;
			case HIDING:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(722);
				match(HIDING);
				setState(723);
				match(OpenRoundBracket);
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (CONID - 120)))) != 0)) {
					{
					setState(724);
					himport();
					setState(729);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(725);
							match(Comma);
							setState(726);
							himport();
							}
							} 
						}
						setState(731);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
					}
					setState(733);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(732);
						match(Comma);
						}
					}

					}
				}

				setState(737);
				match(CloseRoundBracket);
				}
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

	public static class HimportContext extends ParserRuleContext {
		public Var_Context var_() {
			return getRuleContext(Var_Context.class,0);
		}
		public TyconContext tycon() {
			return getRuleContext(TyconContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode DoubleDot() { return getToken(HaskellParser.DoubleDot, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public List<CnameContext> cname() {
			return getRuleContexts(CnameContext.class);
		}
		public CnameContext cname(int i) {
			return getRuleContext(CnameContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public TyclsContext tycls() {
			return getRuleContext(TyclsContext.class,0);
		}
		public Sig_varsContext sig_vars() {
			return getRuleContext(Sig_varsContext.class,0);
		}
		public HimportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_himport; }
	}

	public final HimportContext himport() throws RecognitionException {
		HimportContext _localctx = new HimportContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_himport);
		int _la;
		try {
			setState(770);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(740);
				var_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(741);
				tycon();
				setState(757);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					{
					setState(742);
					match(OpenRoundBracket);
					setState(743);
					match(DoubleDot);
					setState(744);
					match(CloseRoundBracket);
					}
					}
					break;
				case 2:
					{
					{
					setState(745);
					match(OpenRoundBracket);
					setState(754);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (OpenBoxParen - 118)) | (1L << (OpenRoundBracket - 118)) | (1L << (OpenSquareBracket - 118)) | (1L << (VARID - 118)) | (1L << (CONID - 118)))) != 0)) {
						{
						setState(746);
						cname();
						setState(751);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(747);
							match(Comma);
							setState(748);
							cname();
							}
							}
							setState(753);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(756);
					match(CloseRoundBracket);
					}
					}
					break;
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(759);
				tycls();
				setState(768);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					{
					setState(760);
					match(OpenRoundBracket);
					setState(761);
					match(DoubleDot);
					setState(762);
					match(CloseRoundBracket);
					}
					}
					break;
				case 2:
					{
					{
					setState(763);
					match(OpenRoundBracket);
					setState(765);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==OpenRoundBracket || _la==VARID) {
						{
						setState(764);
						sig_vars();
						}
					}

					setState(767);
					match(CloseRoundBracket);
					}
					}
					break;
				}
				}
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

	public static class CnameContext extends ParserRuleContext {
		public Var_Context var_() {
			return getRuleContext(Var_Context.class,0);
		}
		public ConContext con() {
			return getRuleContext(ConContext.class,0);
		}
		public CnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cname; }
	}

	public final CnameContext cname() throws RecognitionException {
		CnameContext _localctx = new CnameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_cname);
		try {
			setState(774);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(772);
				var_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(773);
				con();
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

	public static class FixityContext extends ParserRuleContext {
		public TerminalNode INFIX() { return getToken(HaskellParser.INFIX, 0); }
		public TerminalNode INFIXL() { return getToken(HaskellParser.INFIXL, 0); }
		public TerminalNode INFIXR() { return getToken(HaskellParser.INFIXR, 0); }
		public FixityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixity; }
	}

	public final FixityContext fixity() throws RecognitionException {
		FixityContext _localctx = new FixityContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fixity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INFIX) | (1L << INFIXL) | (1L << INFIXR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class OpsContext extends ParserRuleContext {
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public OpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ops; }
	}

	public final OpsContext ops() throws RecognitionException {
		OpsContext _localctx = new OpsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ops);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			op();
			setState(783);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(779);
				match(Comma);
				setState(780);
				op();
				}
				}
				setState(785);
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

	public static class TopdeclsContext extends ParserRuleContext {
		public List<TopdeclContext> topdecl() {
			return getRuleContexts(TopdeclContext.class);
		}
		public TopdeclContext topdecl(int i) {
			return getRuleContext(TopdeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(HaskellParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(HaskellParser.NEWLINE, i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public TopdeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topdecls; }
	}

	public final TopdeclsContext topdecls() throws RecognitionException {
		TopdeclsContext _localctx = new TopdeclsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_topdecls);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(794); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(794);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
					case 1:
						{
						setState(786);
						topdecl();
						setState(788); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(787);
								semi();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(790); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 2:
						{
						setState(792);
						match(NEWLINE);
						}
						break;
					case 3:
						{
						setState(793);
						semi();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(796); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class TopdeclContext extends ParserRuleContext {
		public Cl_declContext cl_decl() {
			return getRuleContext(Cl_declContext.class,0);
		}
		public Ty_declContext ty_decl() {
			return getRuleContext(Ty_declContext.class,0);
		}
		public Standalone_kind_sigContext standalone_kind_sig() {
			return getRuleContext(Standalone_kind_sigContext.class,0);
		}
		public Inst_declContext inst_decl() {
			return getRuleContext(Inst_declContext.class,0);
		}
		public Standalone_derivingContext standalone_deriving() {
			return getRuleContext(Standalone_derivingContext.class,0);
		}
		public Role_annotContext role_annot() {
			return getRuleContext(Role_annotContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(HaskellParser.DEFAULT, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public Comma_typesContext comma_types() {
			return getRuleContext(Comma_typesContext.class,0);
		}
		public TerminalNode FOREIGN() { return getToken(HaskellParser.FOREIGN, 0); }
		public FdeclContext fdecl() {
			return getRuleContext(FdeclContext.class,0);
		}
		public TerminalNode OpenPragmaBracket() { return getToken(HaskellParser.OpenPragmaBracket, 0); }
		public TerminalNode DEPRECATED() { return getToken(HaskellParser.DEPRECATED, 0); }
		public TerminalNode ClosePragmaBracket() { return getToken(HaskellParser.ClosePragmaBracket, 0); }
		public DeprecationsContext deprecations() {
			return getRuleContext(DeprecationsContext.class,0);
		}
		public TerminalNode WARNING() { return getToken(HaskellParser.WARNING, 0); }
		public WarningsContext warnings() {
			return getRuleContext(WarningsContext.class,0);
		}
		public TerminalNode RULES() { return getToken(HaskellParser.RULES, 0); }
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public Decl_no_thContext decl_no_th() {
			return getRuleContext(Decl_no_thContext.class,0);
		}
		public InfixexpContext infixexp() {
			return getRuleContext(InfixexpContext.class,0);
		}
		public TopdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topdecl; }
	}

	public final TopdeclContext topdecl() throws RecognitionException {
		TopdeclContext _localctx = new TopdeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_topdecl);
		int _la;
		try {
			setState(833);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(798);
				cl_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(799);
				ty_decl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(800);
				standalone_kind_sig();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(801);
				inst_decl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(802);
				standalone_deriving();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(803);
				role_annot();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(804);
				match(DEFAULT);
				setState(805);
				match(OpenRoundBracket);
				setState(807);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << FORALL) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (Hash - 82)) | (1L << (Less - 82)) | (1L << (Greater - 82)) | (1L << (Ampersand - 82)) | (1L << (Pipe - 82)) | (1L << (Bang - 82)) | (1L << (Caret - 82)) | (1L << (Plus - 82)) | (1L << (Minus - 82)) | (1L << (Asterisk - 82)) | (1L << (Percent - 82)) | (1L << (Divide - 82)) | (1L << (Tilde - 82)) | (1L << (Atsign - 82)) | (1L << (Dollar - 82)) | (1L << (Dot - 82)) | (1L << (QuestionMark - 82)) | (1L << (Colon - 82)) | (1L << (Eq - 82)) | (1L << (Quote - 82)) | (1L << (ReverseSlash - 82)) | (1L << (BackQuote - 82)) | (1L << (OpenBoxParen - 82)) | (1L << (OpenRoundBracket - 82)) | (1L << (OpenSquareBracket - 82)) | (1L << (STRING - 82)) | (1L << (VARID - 82)) | (1L << (CONID - 82)) | (1L << (OpenPragmaBracket - 82)) | (1L << (OCURLY - 82)) | (1L << (DECIMAL - 82)) | (1L << (OCTAL - 82)) | (1L << (HEXADECIMAL - 82)))) != 0)) {
					{
					setState(806);
					comma_types();
					}
				}

				setState(809);
				match(CloseRoundBracket);
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(810);
				match(FOREIGN);
				setState(811);
				fdecl();
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(812);
				match(OpenPragmaBracket);
				setState(813);
				match(DEPRECATED);
				setState(815);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (OpenBoxParen - 118)) | (1L << (OpenRoundBracket - 118)) | (1L << (OpenSquareBracket - 118)) | (1L << (VARID - 118)) | (1L << (CONID - 118)))) != 0)) {
					{
					setState(814);
					deprecations();
					}
				}

				setState(817);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(818);
				match(OpenPragmaBracket);
				setState(819);
				match(WARNING);
				setState(821);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (OpenBoxParen - 118)) | (1L << (OpenRoundBracket - 118)) | (1L << (OpenSquareBracket - 118)) | (1L << (VARID - 118)) | (1L << (CONID - 118)))) != 0)) {
					{
					setState(820);
					warnings();
					}
				}

				setState(823);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(824);
				match(OpenPragmaBracket);
				setState(825);
				match(RULES);
				setState(827);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(826);
					rules();
					}
				}

				setState(829);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(830);
				annotation();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(831);
				decl_no_th();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(832);
				infixexp();
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

	public static class Cl_declContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(HaskellParser.CLASS, 0); }
		public Tycl_hdrContext tycl_hdr() {
			return getRuleContext(Tycl_hdrContext.class,0);
		}
		public FdsContext fds() {
			return getRuleContext(FdsContext.class,0);
		}
		public Where_clsContext where_cls() {
			return getRuleContext(Where_clsContext.class,0);
		}
		public Cl_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cl_decl; }
	}

	public final Cl_declContext cl_decl() throws RecognitionException {
		Cl_declContext _localctx = new Cl_declContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cl_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(835);
			match(CLASS);
			setState(836);
			tycl_hdr();
			setState(838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Pipe) {
				{
				setState(837);
				fds();
				}
			}

			setState(841);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(840);
				where_cls();
				}
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

	public static class Ty_declContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(HaskellParser.TYPE, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public KtypedocContext ktypedoc() {
			return getRuleContext(KtypedocContext.class,0);
		}
		public TerminalNode FAMILY() { return getToken(HaskellParser.FAMILY, 0); }
		public Opt_tyfam_kind_sigContext opt_tyfam_kind_sig() {
			return getRuleContext(Opt_tyfam_kind_sigContext.class,0);
		}
		public Opt_injective_infoContext opt_injective_info() {
			return getRuleContext(Opt_injective_infoContext.class,0);
		}
		public Where_type_familyContext where_type_family() {
			return getRuleContext(Where_type_familyContext.class,0);
		}
		public TerminalNode DATA() { return getToken(HaskellParser.DATA, 0); }
		public Tycl_hdrContext tycl_hdr() {
			return getRuleContext(Tycl_hdrContext.class,0);
		}
		public ConstrsContext constrs() {
			return getRuleContext(ConstrsContext.class,0);
		}
		public Capi_ctypeContext capi_ctype() {
			return getRuleContext(Capi_ctypeContext.class,0);
		}
		public DerivingsContext derivings() {
			return getRuleContext(DerivingsContext.class,0);
		}
		public TerminalNode NEWTYPE() { return getToken(HaskellParser.NEWTYPE, 0); }
		public Opt_kind_sigContext opt_kind_sig() {
			return getRuleContext(Opt_kind_sigContext.class,0);
		}
		public Gadt_constrlistContext gadt_constrlist() {
			return getRuleContext(Gadt_constrlistContext.class,0);
		}
		public Opt_datafam_kind_sigContext opt_datafam_kind_sig() {
			return getRuleContext(Opt_datafam_kind_sigContext.class,0);
		}
		public Ty_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ty_decl; }
	}

	public final Ty_declContext ty_decl() throws RecognitionException {
		Ty_declContext _localctx = new Ty_declContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_ty_decl);
		int _la;
		try {
			setState(912);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(843);
				match(TYPE);
				setState(844);
				type_();
				setState(845);
				match(Eq);
				setState(846);
				ktypedoc();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(848);
				match(TYPE);
				setState(849);
				match(FAMILY);
				setState(850);
				type_();
				setState(852);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon || _la==Eq) {
					{
					setState(851);
					opt_tyfam_kind_sig();
					}
				}

				setState(855);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(854);
					opt_injective_info();
					}
				}

				setState(858);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(857);
					where_type_family();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(860);
				match(DATA);
				setState(862);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(861);
					capi_ctype();
					}
					break;
				}
				setState(864);
				tycl_hdr();
				setState(865);
				constrs();
				setState(867);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(866);
					derivings();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(869);
				match(NEWTYPE);
				setState(871);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(870);
					capi_ctype();
					}
					break;
				}
				setState(873);
				tycl_hdr();
				setState(874);
				constrs();
				setState(876);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(875);
					derivings();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(878);
				match(DATA);
				setState(880);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(879);
					capi_ctype();
					}
					break;
				}
				setState(882);
				tycl_hdr();
				setState(884);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon) {
					{
					setState(883);
					opt_kind_sig();
					}
				}

				setState(887);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(886);
					gadt_constrlist();
					}
				}

				setState(890);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(889);
					derivings();
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(892);
				match(NEWTYPE);
				setState(894);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(893);
					capi_ctype();
					}
					break;
				}
				setState(896);
				tycl_hdr();
				setState(898);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon) {
					{
					setState(897);
					opt_kind_sig();
					}
				}

				setState(901);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(900);
					gadt_constrlist();
					}
				}

				setState(904);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(903);
					derivings();
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(906);
				match(DATA);
				setState(907);
				match(FAMILY);
				setState(908);
				type_();
				setState(910);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon) {
					{
					setState(909);
					opt_datafam_kind_sig();
					}
				}

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

	public static class Standalone_kind_sigContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(HaskellParser.TYPE, 0); }
		public Sks_varsContext sks_vars() {
			return getRuleContext(Sks_varsContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public KtypedocContext ktypedoc() {
			return getRuleContext(KtypedocContext.class,0);
		}
		public Standalone_kind_sigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standalone_kind_sig; }
	}

	public final Standalone_kind_sigContext standalone_kind_sig() throws RecognitionException {
		Standalone_kind_sigContext _localctx = new Standalone_kind_sigContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_standalone_kind_sig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			match(TYPE);
			setState(915);
			sks_vars();
			setState(916);
			match(DoubleColon);
			setState(917);
			ktypedoc();
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

	public static class Sks_varsContext extends ParserRuleContext {
		public List<OqtyconContext> oqtycon() {
			return getRuleContexts(OqtyconContext.class);
		}
		public OqtyconContext oqtycon(int i) {
			return getRuleContext(OqtyconContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public Sks_varsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sks_vars; }
	}

	public final Sks_varsContext sks_vars() throws RecognitionException {
		Sks_varsContext _localctx = new Sks_varsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_sks_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(919);
			oqtycon();
			setState(924);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(920);
				match(Comma);
				setState(921);
				oqtycon();
				}
				}
				setState(926);
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

	public static class Inst_declContext extends ParserRuleContext {
		public TerminalNode INSTANCE() { return getToken(HaskellParser.INSTANCE, 0); }
		public Inst_typeContext inst_type() {
			return getRuleContext(Inst_typeContext.class,0);
		}
		public Overlap_pragmaContext overlap_pragma() {
			return getRuleContext(Overlap_pragmaContext.class,0);
		}
		public Where_instContext where_inst() {
			return getRuleContext(Where_instContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(HaskellParser.TYPE, 0); }
		public Ty_fam_inst_eqnContext ty_fam_inst_eqn() {
			return getRuleContext(Ty_fam_inst_eqnContext.class,0);
		}
		public TerminalNode DATA() { return getToken(HaskellParser.DATA, 0); }
		public Tycl_hdr_instContext tycl_hdr_inst() {
			return getRuleContext(Tycl_hdr_instContext.class,0);
		}
		public Capi_ctypeContext capi_ctype() {
			return getRuleContext(Capi_ctypeContext.class,0);
		}
		public DerivingsContext derivings() {
			return getRuleContext(DerivingsContext.class,0);
		}
		public TerminalNode NEWTYPE() { return getToken(HaskellParser.NEWTYPE, 0); }
		public Opt_kind_sigContext opt_kind_sig() {
			return getRuleContext(Opt_kind_sigContext.class,0);
		}
		public Gadt_constrlistContext gadt_constrlist() {
			return getRuleContext(Gadt_constrlistContext.class,0);
		}
		public Inst_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst_decl; }
	}

	public final Inst_declContext inst_decl() throws RecognitionException {
		Inst_declContext _localctx = new Inst_declContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_inst_decl);
		int _la;
		try {
			setState(986);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(927);
				match(INSTANCE);
				setState(929);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
				case 1:
					{
					setState(928);
					overlap_pragma();
					}
					break;
				}
				setState(931);
				inst_type();
				setState(933);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(932);
					where_inst();
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(935);
				match(TYPE);
				setState(936);
				match(INSTANCE);
				setState(937);
				ty_fam_inst_eqn();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(938);
				match(DATA);
				setState(939);
				match(INSTANCE);
				setState(941);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(940);
					capi_ctype();
					}
					break;
				}
				setState(943);
				tycl_hdr_inst();
				setState(945);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(944);
					derivings();
					}
				}

				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(947);
				match(NEWTYPE);
				setState(948);
				match(INSTANCE);
				setState(950);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(949);
					capi_ctype();
					}
					break;
				}
				setState(952);
				tycl_hdr_inst();
				setState(954);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(953);
					derivings();
					}
				}

				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(956);
				match(DATA);
				setState(957);
				match(INSTANCE);
				setState(959);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(958);
					capi_ctype();
					}
					break;
				}
				setState(961);
				tycl_hdr_inst();
				setState(963);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon) {
					{
					setState(962);
					opt_kind_sig();
					}
				}

				setState(966);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(965);
					gadt_constrlist();
					}
				}

				setState(969);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(968);
					derivings();
					}
				}

				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(971);
				match(NEWTYPE);
				setState(972);
				match(INSTANCE);
				setState(974);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
				case 1:
					{
					setState(973);
					capi_ctype();
					}
					break;
				}
				setState(976);
				tycl_hdr_inst();
				setState(978);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon) {
					{
					setState(977);
					opt_kind_sig();
					}
				}

				setState(981);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(980);
					gadt_constrlist();
					}
				}

				setState(984);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(983);
					derivings();
					}
				}

				}
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

	public static class Overlap_pragmaContext extends ParserRuleContext {
		public TerminalNode OpenPragmaBracket() { return getToken(HaskellParser.OpenPragmaBracket, 0); }
		public TerminalNode OVERLAPPABLE() { return getToken(HaskellParser.OVERLAPPABLE, 0); }
		public TerminalNode ClosePragmaBracket() { return getToken(HaskellParser.ClosePragmaBracket, 0); }
		public TerminalNode OVERLAPPING() { return getToken(HaskellParser.OVERLAPPING, 0); }
		public TerminalNode OVERLAPS() { return getToken(HaskellParser.OVERLAPS, 0); }
		public TerminalNode INCOHERENT() { return getToken(HaskellParser.INCOHERENT, 0); }
		public Overlap_pragmaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overlap_pragma; }
	}

	public final Overlap_pragmaContext overlap_pragma() throws RecognitionException {
		Overlap_pragmaContext _localctx = new Overlap_pragmaContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_overlap_pragma);
		try {
			setState(1000);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(988);
				match(OpenPragmaBracket);
				setState(989);
				match(OVERLAPPABLE);
				setState(990);
				match(ClosePragmaBracket);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(991);
				match(OpenPragmaBracket);
				setState(992);
				match(OVERLAPPING);
				setState(993);
				match(ClosePragmaBracket);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(994);
				match(OpenPragmaBracket);
				setState(995);
				match(OVERLAPS);
				setState(996);
				match(ClosePragmaBracket);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(997);
				match(OpenPragmaBracket);
				setState(998);
				match(INCOHERENT);
				setState(999);
				match(ClosePragmaBracket);
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

	public static class Deriv_strategy_no_viaContext extends ParserRuleContext {
		public TerminalNode STOCK() { return getToken(HaskellParser.STOCK, 0); }
		public TerminalNode ANYCLASS() { return getToken(HaskellParser.ANYCLASS, 0); }
		public TerminalNode NEWTYPE() { return getToken(HaskellParser.NEWTYPE, 0); }
		public Deriv_strategy_no_viaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deriv_strategy_no_via; }
	}

	public final Deriv_strategy_no_viaContext deriv_strategy_no_via() throws RecognitionException {
		Deriv_strategy_no_viaContext _localctx = new Deriv_strategy_no_viaContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_deriv_strategy_no_via);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1002);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWTYPE) | (1L << STOCK) | (1L << ANYCLASS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Deriv_strategy_viaContext extends ParserRuleContext {
		public TerminalNode VIA() { return getToken(HaskellParser.VIA, 0); }
		public KtypeContext ktype() {
			return getRuleContext(KtypeContext.class,0);
		}
		public Deriv_strategy_viaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deriv_strategy_via; }
	}

	public final Deriv_strategy_viaContext deriv_strategy_via() throws RecognitionException {
		Deriv_strategy_viaContext _localctx = new Deriv_strategy_viaContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_deriv_strategy_via);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1004);
			match(VIA);
			setState(1005);
			ktype();
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

	public static class Deriv_standalone_strategyContext extends ParserRuleContext {
		public TerminalNode STOCK() { return getToken(HaskellParser.STOCK, 0); }
		public TerminalNode ANYCLASS() { return getToken(HaskellParser.ANYCLASS, 0); }
		public TerminalNode NEWTYPE() { return getToken(HaskellParser.NEWTYPE, 0); }
		public Deriv_strategy_viaContext deriv_strategy_via() {
			return getRuleContext(Deriv_strategy_viaContext.class,0);
		}
		public Deriv_standalone_strategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deriv_standalone_strategy; }
	}

	public final Deriv_standalone_strategyContext deriv_standalone_strategy() throws RecognitionException {
		Deriv_standalone_strategyContext _localctx = new Deriv_standalone_strategyContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_deriv_standalone_strategy);
		try {
			setState(1011);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STOCK:
				enterOuterAlt(_localctx, 1);
				{
				setState(1007);
				match(STOCK);
				}
				break;
			case ANYCLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1008);
				match(ANYCLASS);
				}
				break;
			case NEWTYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1009);
				match(NEWTYPE);
				}
				break;
			case VIA:
				enterOuterAlt(_localctx, 4);
				{
				setState(1010);
				deriv_strategy_via();
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

	public static class Opt_injective_infoContext extends ParserRuleContext {
		public TerminalNode Pipe() { return getToken(HaskellParser.Pipe, 0); }
		public Injectivity_condContext injectivity_cond() {
			return getRuleContext(Injectivity_condContext.class,0);
		}
		public Opt_injective_infoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_injective_info; }
	}

	public final Opt_injective_infoContext opt_injective_info() throws RecognitionException {
		Opt_injective_infoContext _localctx = new Opt_injective_infoContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_opt_injective_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1013);
			match(Pipe);
			setState(1014);
			injectivity_cond();
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

	public static class Injectivity_condContext extends ParserRuleContext {
		public TyvaridContext tyvarid() {
			return getRuleContext(TyvaridContext.class,0);
		}
		public TerminalNode Arrow() { return getToken(HaskellParser.Arrow, 0); }
		public Inj_varidsContext inj_varids() {
			return getRuleContext(Inj_varidsContext.class,0);
		}
		public Injectivity_condContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_injectivity_cond; }
	}

	public final Injectivity_condContext injectivity_cond() throws RecognitionException {
		Injectivity_condContext _localctx = new Injectivity_condContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_injectivity_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1016);
			tyvarid();
			setState(1017);
			match(Arrow);
			setState(1018);
			inj_varids();
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

	public static class Inj_varidsContext extends ParserRuleContext {
		public List<TyvaridContext> tyvarid() {
			return getRuleContexts(TyvaridContext.class);
		}
		public TyvaridContext tyvarid(int i) {
			return getRuleContext(TyvaridContext.class,i);
		}
		public Inj_varidsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inj_varids; }
	}

	public final Inj_varidsContext inj_varids() throws RecognitionException {
		Inj_varidsContext _localctx = new Inj_varidsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_inj_varids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1021); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1020);
				tyvarid();
				}
				}
				setState(1023); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << SAFE) | (1L << INTERRUPTIBLE) | (1L << UNSAFE) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==VARID );
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

	public static class Where_type_familyContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(HaskellParser.WHERE, 0); }
		public Ty_fam_inst_eqn_listContext ty_fam_inst_eqn_list() {
			return getRuleContext(Ty_fam_inst_eqn_listContext.class,0);
		}
		public Where_type_familyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_type_family; }
	}

	public final Where_type_familyContext where_type_family() throws RecognitionException {
		Where_type_familyContext _localctx = new Where_type_familyContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_where_type_family);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1025);
			match(WHERE);
			setState(1026);
			ty_fam_inst_eqn_list();
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

	public static class Ty_fam_inst_eqn_listContext extends ParserRuleContext {
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public Ty_fam_inst_eqnsContext ty_fam_inst_eqns() {
			return getRuleContext(Ty_fam_inst_eqnsContext.class,0);
		}
		public TerminalNode OCURLY() { return getToken(HaskellParser.OCURLY, 0); }
		public TerminalNode DoubleDot() { return getToken(HaskellParser.DoubleDot, 0); }
		public TerminalNode CCURLY() { return getToken(HaskellParser.CCURLY, 0); }
		public Ty_fam_inst_eqn_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ty_fam_inst_eqn_list; }
	}

	public final Ty_fam_inst_eqn_listContext ty_fam_inst_eqn_list() throws RecognitionException {
		Ty_fam_inst_eqn_listContext _localctx = new Ty_fam_inst_eqn_listContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_ty_fam_inst_eqn_list);
		int _la;
		try {
			setState(1041);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1028);
				open_();
				setState(1030);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << FORALL) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (Hash - 82)) | (1L << (Less - 82)) | (1L << (Greater - 82)) | (1L << (Ampersand - 82)) | (1L << (Pipe - 82)) | (1L << (Bang - 82)) | (1L << (Caret - 82)) | (1L << (Plus - 82)) | (1L << (Minus - 82)) | (1L << (Asterisk - 82)) | (1L << (Percent - 82)) | (1L << (Divide - 82)) | (1L << (Tilde - 82)) | (1L << (Atsign - 82)) | (1L << (Dollar - 82)) | (1L << (Dot - 82)) | (1L << (QuestionMark - 82)) | (1L << (Colon - 82)) | (1L << (Eq - 82)) | (1L << (Quote - 82)) | (1L << (ReverseSlash - 82)) | (1L << (BackQuote - 82)) | (1L << (OpenBoxParen - 82)) | (1L << (OpenRoundBracket - 82)) | (1L << (OpenSquareBracket - 82)) | (1L << (STRING - 82)) | (1L << (VARID - 82)) | (1L << (CONID - 82)) | (1L << (OpenPragmaBracket - 82)) | (1L << (OCURLY - 82)) | (1L << (DECIMAL - 82)) | (1L << (OCTAL - 82)) | (1L << (HEXADECIMAL - 82)))) != 0)) {
					{
					setState(1029);
					ty_fam_inst_eqns();
					}
				}

				setState(1032);
				close();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1034);
				match(OCURLY);
				setState(1035);
				match(DoubleDot);
				setState(1036);
				match(CCURLY);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1037);
				open_();
				setState(1038);
				match(DoubleDot);
				setState(1039);
				close();
				}
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

	public static class Ty_fam_inst_eqnsContext extends ParserRuleContext {
		public List<Ty_fam_inst_eqnContext> ty_fam_inst_eqn() {
			return getRuleContexts(Ty_fam_inst_eqnContext.class);
		}
		public Ty_fam_inst_eqnContext ty_fam_inst_eqn(int i) {
			return getRuleContext(Ty_fam_inst_eqnContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public Ty_fam_inst_eqnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ty_fam_inst_eqns; }
	}

	public final Ty_fam_inst_eqnsContext ty_fam_inst_eqns() throws RecognitionException {
		Ty_fam_inst_eqnsContext _localctx = new Ty_fam_inst_eqnsContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_ty_fam_inst_eqns);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1043);
			ty_fam_inst_eqn();
			setState(1053);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1045); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1044);
						semi();
						}
						}
						setState(1047); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==Semi || _la==SEMI );
					setState(1049);
					ty_fam_inst_eqn();
					}
					} 
				}
				setState(1055);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
			}
			setState(1059);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semi || _la==SEMI) {
				{
				{
				setState(1056);
				semi();
				}
				}
				setState(1061);
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

	public static class Ty_fam_inst_eqnContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(HaskellParser.FORALL, 0); }
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public KtypeContext ktype() {
			return getRuleContext(KtypeContext.class,0);
		}
		public Tv_bndrsContext tv_bndrs() {
			return getRuleContext(Tv_bndrsContext.class,0);
		}
		public Ty_fam_inst_eqnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ty_fam_inst_eqn; }
	}

	public final Ty_fam_inst_eqnContext ty_fam_inst_eqn() throws RecognitionException {
		Ty_fam_inst_eqnContext _localctx = new Ty_fam_inst_eqnContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_ty_fam_inst_eqn);
		int _la;
		try {
			setState(1075);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FORALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1062);
				match(FORALL);
				setState(1064);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (OCURLY - 120)))) != 0)) {
					{
					setState(1063);
					tv_bndrs();
					}
				}

				setState(1066);
				match(Dot);
				setState(1067);
				type_();
				setState(1068);
				match(Eq);
				setState(1069);
				ktype();
				}
				break;
			case AS:
			case HIDING:
			case QUALIFIED:
			case WILDCARD:
			case EXPORT:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case Hash:
			case Less:
			case Greater:
			case Ampersand:
			case Pipe:
			case Bang:
			case Caret:
			case Plus:
			case Minus:
			case Asterisk:
			case Percent:
			case Divide:
			case Tilde:
			case Atsign:
			case Dollar:
			case Dot:
			case QuestionMark:
			case Colon:
			case Eq:
			case Quote:
			case ReverseSlash:
			case BackQuote:
			case OpenBoxParen:
			case OpenRoundBracket:
			case OpenSquareBracket:
			case STRING:
			case VARID:
			case CONID:
			case OpenPragmaBracket:
			case OCURLY:
			case DECIMAL:
			case OCTAL:
			case HEXADECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1071);
				type_();
				setState(1072);
				match(Eq);
				setState(1073);
				ktype();
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

	public static class At_decl_clsContext extends ParserRuleContext {
		public TerminalNode DATA() { return getToken(HaskellParser.DATA, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode FAMILY() { return getToken(HaskellParser.FAMILY, 0); }
		public Opt_datafam_kind_sigContext opt_datafam_kind_sig() {
			return getRuleContext(Opt_datafam_kind_sigContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(HaskellParser.TYPE, 0); }
		public Opt_at_kind_inj_sigContext opt_at_kind_inj_sig() {
			return getRuleContext(Opt_at_kind_inj_sigContext.class,0);
		}
		public Ty_fam_inst_eqnContext ty_fam_inst_eqn() {
			return getRuleContext(Ty_fam_inst_eqnContext.class,0);
		}
		public TerminalNode INSTANCE() { return getToken(HaskellParser.INSTANCE, 0); }
		public At_decl_clsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_decl_cls; }
	}

	public final At_decl_clsContext at_decl_cls() throws RecognitionException {
		At_decl_clsContext _localctx = new At_decl_clsContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_at_decl_cls);
		int _la;
		try {
			setState(1098);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1077);
				match(DATA);
				setState(1079);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FAMILY) {
					{
					setState(1078);
					match(FAMILY);
					}
				}

				setState(1081);
				type_();
				setState(1083);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon) {
					{
					setState(1082);
					opt_datafam_kind_sig();
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1085);
				match(TYPE);
				setState(1087);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FAMILY) {
					{
					setState(1086);
					match(FAMILY);
					}
				}

				setState(1089);
				type_();
				setState(1091);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon || _la==Eq) {
					{
					setState(1090);
					opt_at_kind_inj_sig();
					}
				}

				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1093);
				match(TYPE);
				setState(1095);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INSTANCE) {
					{
					setState(1094);
					match(INSTANCE);
					}
				}

				setState(1097);
				ty_fam_inst_eqn();
				}
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

	public static class At_decl_instContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(HaskellParser.TYPE, 0); }
		public Ty_fam_inst_eqnContext ty_fam_inst_eqn() {
			return getRuleContext(Ty_fam_inst_eqnContext.class,0);
		}
		public TerminalNode INSTANCE() { return getToken(HaskellParser.INSTANCE, 0); }
		public TerminalNode DATA() { return getToken(HaskellParser.DATA, 0); }
		public Tycl_hdr_instContext tycl_hdr_inst() {
			return getRuleContext(Tycl_hdr_instContext.class,0);
		}
		public ConstrsContext constrs() {
			return getRuleContext(ConstrsContext.class,0);
		}
		public Capi_ctypeContext capi_ctype() {
			return getRuleContext(Capi_ctypeContext.class,0);
		}
		public DerivingsContext derivings() {
			return getRuleContext(DerivingsContext.class,0);
		}
		public TerminalNode NEWTYPE() { return getToken(HaskellParser.NEWTYPE, 0); }
		public Opt_kind_sigContext opt_kind_sig() {
			return getRuleContext(Opt_kind_sigContext.class,0);
		}
		public Gadt_constrlistContext gadt_constrlist() {
			return getRuleContext(Gadt_constrlistContext.class,0);
		}
		public At_decl_instContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_at_decl_inst; }
	}

	public final At_decl_instContext at_decl_inst() throws RecognitionException {
		At_decl_instContext _localctx = new At_decl_instContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_at_decl_inst);
		int _la;
		try {
			setState(1163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1100);
				match(TYPE);
				setState(1102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INSTANCE) {
					{
					setState(1101);
					match(INSTANCE);
					}
				}

				setState(1104);
				ty_fam_inst_eqn();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1105);
				match(DATA);
				setState(1107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INSTANCE) {
					{
					setState(1106);
					match(INSTANCE);
					}
				}

				setState(1110);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					{
					setState(1109);
					capi_ctype();
					}
					break;
				}
				setState(1112);
				tycl_hdr_inst();
				setState(1113);
				constrs();
				setState(1115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(1114);
					derivings();
					}
				}

				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1117);
				match(NEWTYPE);
				setState(1119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INSTANCE) {
					{
					setState(1118);
					match(INSTANCE);
					}
				}

				setState(1122);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
				case 1:
					{
					setState(1121);
					capi_ctype();
					}
					break;
				}
				setState(1124);
				tycl_hdr_inst();
				setState(1125);
				constrs();
				setState(1127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(1126);
					derivings();
					}
				}

				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(1129);
				match(DATA);
				setState(1131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INSTANCE) {
					{
					setState(1130);
					match(INSTANCE);
					}
				}

				setState(1134);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
				case 1:
					{
					setState(1133);
					capi_ctype();
					}
					break;
				}
				setState(1136);
				tycl_hdr_inst();
				setState(1138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon) {
					{
					setState(1137);
					opt_kind_sig();
					}
				}

				setState(1141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1140);
					gadt_constrlist();
					}
				}

				setState(1144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(1143);
					derivings();
					}
				}

				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(1146);
				match(NEWTYPE);
				setState(1148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INSTANCE) {
					{
					setState(1147);
					match(INSTANCE);
					}
				}

				setState(1151);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
				case 1:
					{
					setState(1150);
					capi_ctype();
					}
					break;
				}
				setState(1153);
				tycl_hdr_inst();
				setState(1155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon) {
					{
					setState(1154);
					opt_kind_sig();
					}
				}

				setState(1158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1157);
					gadt_constrlist();
					}
				}

				setState(1161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DERIVING) {
					{
					setState(1160);
					derivings();
					}
				}

				}
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

	public static class Opt_kind_sigContext extends ParserRuleContext {
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public KindContext kind() {
			return getRuleContext(KindContext.class,0);
		}
		public Opt_kind_sigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_kind_sig; }
	}

	public final Opt_kind_sigContext opt_kind_sig() throws RecognitionException {
		Opt_kind_sigContext _localctx = new Opt_kind_sigContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_opt_kind_sig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1165);
			match(DoubleColon);
			setState(1166);
			kind();
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

	public static class Opt_datafam_kind_sigContext extends ParserRuleContext {
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public KindContext kind() {
			return getRuleContext(KindContext.class,0);
		}
		public Opt_datafam_kind_sigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_datafam_kind_sig; }
	}

	public final Opt_datafam_kind_sigContext opt_datafam_kind_sig() throws RecognitionException {
		Opt_datafam_kind_sigContext _localctx = new Opt_datafam_kind_sigContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_opt_datafam_kind_sig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1168);
			match(DoubleColon);
			setState(1169);
			kind();
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

	public static class Opt_tyfam_kind_sigContext extends ParserRuleContext {
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public KindContext kind() {
			return getRuleContext(KindContext.class,0);
		}
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public Tv_bndrContext tv_bndr() {
			return getRuleContext(Tv_bndrContext.class,0);
		}
		public Opt_tyfam_kind_sigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_tyfam_kind_sig; }
	}

	public final Opt_tyfam_kind_sigContext opt_tyfam_kind_sig() throws RecognitionException {
		Opt_tyfam_kind_sigContext _localctx = new Opt_tyfam_kind_sigContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_opt_tyfam_kind_sig);
		try {
			setState(1175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DoubleColon:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1171);
				match(DoubleColon);
				setState(1172);
				kind();
				}
				}
				break;
			case Eq:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1173);
				match(Eq);
				setState(1174);
				tv_bndr();
				}
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

	public static class Opt_at_kind_inj_sigContext extends ParserRuleContext {
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public KindContext kind() {
			return getRuleContext(KindContext.class,0);
		}
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public Tv_bndr_no_bracesContext tv_bndr_no_braces() {
			return getRuleContext(Tv_bndr_no_bracesContext.class,0);
		}
		public TerminalNode Pipe() { return getToken(HaskellParser.Pipe, 0); }
		public Injectivity_condContext injectivity_cond() {
			return getRuleContext(Injectivity_condContext.class,0);
		}
		public Opt_at_kind_inj_sigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_at_kind_inj_sig; }
	}

	public final Opt_at_kind_inj_sigContext opt_at_kind_inj_sig() throws RecognitionException {
		Opt_at_kind_inj_sigContext _localctx = new Opt_at_kind_inj_sigContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_opt_at_kind_inj_sig);
		try {
			setState(1184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DoubleColon:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1177);
				match(DoubleColon);
				setState(1178);
				kind();
				}
				}
				break;
			case Eq:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1179);
				match(Eq);
				setState(1180);
				tv_bndr_no_braces();
				setState(1181);
				match(Pipe);
				setState(1182);
				injectivity_cond();
				}
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

	public static class Tycl_hdrContext extends ParserRuleContext {
		public Tycl_contextContext tycl_context() {
			return getRuleContext(Tycl_contextContext.class,0);
		}
		public TerminalNode DoubleArrow() { return getToken(HaskellParser.DoubleArrow, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public Tycl_hdrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tycl_hdr; }
	}

	public final Tycl_hdrContext tycl_hdr() throws RecognitionException {
		Tycl_hdrContext _localctx = new Tycl_hdrContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_tycl_hdr);
		try {
			setState(1191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1186);
				tycl_context();
				setState(1187);
				match(DoubleArrow);
				setState(1188);
				type_();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1190);
				type_();
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

	public static class Tycl_hdr_instContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(HaskellParser.FORALL, 0); }
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public Tycl_contextContext tycl_context() {
			return getRuleContext(Tycl_contextContext.class,0);
		}
		public TerminalNode DoubleArrow() { return getToken(HaskellParser.DoubleArrow, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public Tv_bndrsContext tv_bndrs() {
			return getRuleContext(Tv_bndrsContext.class,0);
		}
		public Tycl_hdr_instContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tycl_hdr_inst; }
	}

	public final Tycl_hdr_instContext tycl_hdr_inst() throws RecognitionException {
		Tycl_hdr_instContext _localctx = new Tycl_hdr_instContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_tycl_hdr_inst);
		int _la;
		try {
			setState(1213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1193);
				match(FORALL);
				setState(1195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (OCURLY - 120)))) != 0)) {
					{
					setState(1194);
					tv_bndrs();
					}
				}

				setState(1197);
				match(Dot);
				setState(1198);
				tycl_context();
				setState(1199);
				match(DoubleArrow);
				setState(1200);
				type_();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1202);
				match(FORALL);
				setState(1204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (OCURLY - 120)))) != 0)) {
					{
					setState(1203);
					tv_bndrs();
					}
				}

				setState(1206);
				match(Dot);
				setState(1207);
				type_();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1208);
				tycl_context();
				setState(1209);
				match(DoubleArrow);
				setState(1210);
				type_();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1212);
				type_();
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

	public static class Capi_ctypeContext extends ParserRuleContext {
		public TerminalNode OpenPragmaBracket() { return getToken(HaskellParser.OpenPragmaBracket, 0); }
		public TerminalNode CTYPE() { return getToken(HaskellParser.CTYPE, 0); }
		public List<TerminalNode> STRING() { return getTokens(HaskellParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(HaskellParser.STRING, i);
		}
		public TerminalNode ClosePragmaBracket() { return getToken(HaskellParser.ClosePragmaBracket, 0); }
		public Capi_ctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capi_ctype; }
	}

	public final Capi_ctypeContext capi_ctype() throws RecognitionException {
		Capi_ctypeContext _localctx = new Capi_ctypeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_capi_ctype);
		try {
			setState(1224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1215);
				match(OpenPragmaBracket);
				setState(1216);
				match(CTYPE);
				setState(1217);
				match(STRING);
				setState(1218);
				match(STRING);
				setState(1219);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1220);
				match(OpenPragmaBracket);
				setState(1221);
				match(CTYPE);
				setState(1222);
				match(STRING);
				setState(1223);
				match(ClosePragmaBracket);
				}
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

	public static class Standalone_derivingContext extends ParserRuleContext {
		public TerminalNode DERIVING() { return getToken(HaskellParser.DERIVING, 0); }
		public TerminalNode INSTANCE() { return getToken(HaskellParser.INSTANCE, 0); }
		public Inst_typeContext inst_type() {
			return getRuleContext(Inst_typeContext.class,0);
		}
		public Deriv_standalone_strategyContext deriv_standalone_strategy() {
			return getRuleContext(Deriv_standalone_strategyContext.class,0);
		}
		public Overlap_pragmaContext overlap_pragma() {
			return getRuleContext(Overlap_pragmaContext.class,0);
		}
		public Standalone_derivingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standalone_deriving; }
	}

	public final Standalone_derivingContext standalone_deriving() throws RecognitionException {
		Standalone_derivingContext _localctx = new Standalone_derivingContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_standalone_deriving);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1226);
			match(DERIVING);
			setState(1228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWTYPE) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0)) {
				{
				setState(1227);
				deriv_standalone_strategy();
				}
			}

			setState(1230);
			match(INSTANCE);
			setState(1232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				{
				setState(1231);
				overlap_pragma();
				}
				break;
			}
			setState(1234);
			inst_type();
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

	public static class Role_annotContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(HaskellParser.TYPE, 0); }
		public TerminalNode ROLE() { return getToken(HaskellParser.ROLE, 0); }
		public OqtyconContext oqtycon() {
			return getRuleContext(OqtyconContext.class,0);
		}
		public RolesContext roles() {
			return getRuleContext(RolesContext.class,0);
		}
		public Role_annotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role_annot; }
	}

	public final Role_annotContext role_annot() throws RecognitionException {
		Role_annotContext _localctx = new Role_annotContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_role_annot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1236);
			match(TYPE);
			setState(1237);
			match(ROLE);
			setState(1238);
			oqtycon();
			setState(1240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==VARID) {
				{
				setState(1239);
				roles();
				}
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

	public static class RolesContext extends ParserRuleContext {
		public List<RoleContext> role() {
			return getRuleContexts(RoleContext.class);
		}
		public RoleContext role(int i) {
			return getRuleContext(RoleContext.class,i);
		}
		public RolesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roles; }
	}

	public final RolesContext roles() throws RecognitionException {
		RolesContext _localctx = new RolesContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_roles);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1243); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1242);
				role();
				}
				}
				setState(1245); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==VARID );
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

	public static class RoleContext extends ParserRuleContext {
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public TerminalNode WILDCARD() { return getToken(HaskellParser.WILDCARD, 0); }
		public RoleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role; }
	}

	public final RoleContext role() throws RecognitionException {
		RoleContext _localctx = new RoleContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_role);
		try {
			setState(1249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AS:
			case HIDING:
			case QUALIFIED:
			case EXPORT:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case VARID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1247);
				varid();
				}
				break;
			case WILDCARD:
				enterOuterAlt(_localctx, 2);
				{
				setState(1248);
				match(WILDCARD);
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

	public static class Pattern_synonym_declContext extends ParserRuleContext {
		public TerminalNode PATTERN() { return getToken(HaskellParser.PATTERN, 0); }
		public Pattern_synonym_lhsContext pattern_synonym_lhs() {
			return getRuleContext(Pattern_synonym_lhsContext.class,0);
		}
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public PatContext pat() {
			return getRuleContext(PatContext.class,0);
		}
		public TerminalNode Revarrow() { return getToken(HaskellParser.Revarrow, 0); }
		public Where_declsContext where_decls() {
			return getRuleContext(Where_declsContext.class,0);
		}
		public Pattern_synonym_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_synonym_decl; }
	}

	public final Pattern_synonym_declContext pattern_synonym_decl() throws RecognitionException {
		Pattern_synonym_declContext _localctx = new Pattern_synonym_declContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_pattern_synonym_decl);
		int _la;
		try {
			setState(1263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1251);
				match(PATTERN);
				setState(1252);
				pattern_synonym_lhs();
				setState(1253);
				match(Eq);
				setState(1254);
				pat();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1256);
				match(PATTERN);
				setState(1257);
				pattern_synonym_lhs();
				setState(1258);
				match(Revarrow);
				setState(1259);
				pat();
				setState(1261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1260);
					where_decls();
					}
				}

				}
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

	public static class Pattern_synonym_lhsContext extends ParserRuleContext {
		public ConContext con() {
			return getRuleContext(ConContext.class,0);
		}
		public Vars_Context vars_() {
			return getRuleContext(Vars_Context.class,0);
		}
		public List<VaridContext> varid() {
			return getRuleContexts(VaridContext.class);
		}
		public VaridContext varid(int i) {
			return getRuleContext(VaridContext.class,i);
		}
		public ConopContext conop() {
			return getRuleContext(ConopContext.class,0);
		}
		public TerminalNode OCURLY() { return getToken(HaskellParser.OCURLY, 0); }
		public CvarsContext cvars() {
			return getRuleContext(CvarsContext.class,0);
		}
		public TerminalNode CCURLY() { return getToken(HaskellParser.CCURLY, 0); }
		public Pattern_synonym_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_synonym_lhs; }
	}

	public final Pattern_synonym_lhsContext pattern_synonym_lhs() throws RecognitionException {
		Pattern_synonym_lhsContext _localctx = new Pattern_synonym_lhsContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_pattern_synonym_lhs);
		int _la;
		try {
			setState(1278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1265);
				con();
				setState(1267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==VARID) {
					{
					setState(1266);
					vars_();
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1269);
				varid();
				setState(1270);
				conop();
				setState(1271);
				varid();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1273);
				con();
				setState(1274);
				match(OCURLY);
				setState(1275);
				cvars();
				setState(1276);
				match(CCURLY);
				}
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

	public static class Vars_Context extends ParserRuleContext {
		public List<VaridContext> varid() {
			return getRuleContexts(VaridContext.class);
		}
		public VaridContext varid(int i) {
			return getRuleContext(VaridContext.class,i);
		}
		public Vars_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars_; }
	}

	public final Vars_Context vars_() throws RecognitionException {
		Vars_Context _localctx = new Vars_Context(_ctx, getState());
		enterRule(_localctx, 106, RULE_vars_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1281); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1280);
				varid();
				}
				}
				setState(1283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==VARID );
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

	public static class CvarsContext extends ParserRuleContext {
		public List<Var_Context> var_() {
			return getRuleContexts(Var_Context.class);
		}
		public Var_Context var_(int i) {
			return getRuleContext(Var_Context.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public CvarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cvars; }
	}

	public final CvarsContext cvars() throws RecognitionException {
		CvarsContext _localctx = new CvarsContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_cvars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1285);
			var_();
			setState(1290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1286);
				match(Comma);
				setState(1287);
				var_();
				}
				}
				setState(1292);
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

	public static class Where_declsContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(HaskellParser.WHERE, 0); }
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public Where_declsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_decls; }
	}

	public final Where_declsContext where_decls() throws RecognitionException {
		Where_declsContext _localctx = new Where_declsContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_where_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1293);
			match(WHERE);
			setState(1294);
			open_();
			setState(1296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << CASE) | (1L << DO) | (1L << HIDING) | (1L << IF) | (1L << INFIX) | (1L << INFIXL) | (1L << INFIXR) | (1L << LET) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << EXPORT) | (1L << MDO) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << PATTERN) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LCASE - 73)) | (1L << (Bang - 73)) | (1L << (Minus - 73)) | (1L << (Tilde - 73)) | (1L << (DDollar - 73)) | (1L << (Dollar - 73)) | (1L << (Semi - 73)) | (1L << (Quote - 73)) | (1L << (DoubleQuote - 73)) | (1L << (ReverseSlash - 73)) | (1L << (AopenParen - 73)) | (1L << (TopenTexpQuote - 73)) | (1L << (TopenExpQuote - 73)) | (1L << (TopenPatQuote - 73)) | (1L << (TopenTypQoute - 73)) | (1L << (TopenDecQoute - 73)) | (1L << (OpenBoxParen - 73)) | (1L << (OpenRoundBracket - 73)) | (1L << (OpenSquareBracket - 73)) | (1L << (CHAR - 73)) | (1L << (STRING - 73)) | (1L << (VARID - 73)) | (1L << (CONID - 73)) | (1L << (OpenPragmaBracket - 73)) | (1L << (SEMI - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)) | (1L << (FLOAT - 137)))) != 0)) {
				{
				setState(1295);
				decls();
				}
			}

			setState(1298);
			close();
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

	public static class Pattern_synonym_sigContext extends ParserRuleContext {
		public TerminalNode PATTERN() { return getToken(HaskellParser.PATTERN, 0); }
		public Con_listContext con_list() {
			return getRuleContext(Con_listContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public SigtypedocContext sigtypedoc() {
			return getRuleContext(SigtypedocContext.class,0);
		}
		public Pattern_synonym_sigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_synonym_sig; }
	}

	public final Pattern_synonym_sigContext pattern_synonym_sig() throws RecognitionException {
		Pattern_synonym_sigContext _localctx = new Pattern_synonym_sigContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_pattern_synonym_sig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1300);
			match(PATTERN);
			setState(1301);
			con_list();
			setState(1302);
			match(DoubleColon);
			setState(1303);
			sigtypedoc();
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

	public static class Decl_clsContext extends ParserRuleContext {
		public At_decl_clsContext at_decl_cls() {
			return getRuleContext(At_decl_clsContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(HaskellParser.DEFAULT, 0); }
		public InfixexpContext infixexp() {
			return getRuleContext(InfixexpContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public SigtypedocContext sigtypedoc() {
			return getRuleContext(SigtypedocContext.class,0);
		}
		public Decl_clsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_cls; }
	}

	public final Decl_clsContext decl_cls() throws RecognitionException {
		Decl_clsContext _localctx = new Decl_clsContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_decl_cls);
		try {
			setState(1312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA:
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1305);
				at_decl_cls();
				}
				break;
			case AS:
			case CASE:
			case DO:
			case HIDING:
			case IF:
			case INFIX:
			case INFIXL:
			case INFIXR:
			case LET:
			case QUALIFIED:
			case WILDCARD:
			case EXPORT:
			case MDO:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case PATTERN:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case LCASE:
			case Bang:
			case Minus:
			case Tilde:
			case DDollar:
			case Dollar:
			case Semi:
			case Quote:
			case DoubleQuote:
			case ReverseSlash:
			case AopenParen:
			case TopenTexpQuote:
			case TopenExpQuote:
			case TopenPatQuote:
			case TopenTypQoute:
			case TopenDecQoute:
			case OpenBoxParen:
			case OpenRoundBracket:
			case OpenSquareBracket:
			case CHAR:
			case STRING:
			case VARID:
			case CONID:
			case OpenPragmaBracket:
			case SEMI:
			case DECIMAL:
			case OCTAL:
			case HEXADECIMAL:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1306);
				decl();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1307);
				match(DEFAULT);
				setState(1308);
				infixexp();
				setState(1309);
				match(DoubleColon);
				setState(1310);
				sigtypedoc();
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

	public static class Decls_clsContext extends ParserRuleContext {
		public List<Decl_clsContext> decl_cls() {
			return getRuleContexts(Decl_clsContext.class);
		}
		public Decl_clsContext decl_cls(int i) {
			return getRuleContext(Decl_clsContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public Decls_clsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls_cls; }
	}

	public final Decls_clsContext decls_cls() throws RecognitionException {
		Decls_clsContext _localctx = new Decls_clsContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_decls_cls);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1314);
			decl_cls();
			setState(1324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1316); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1315);
							semi();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1318); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,148,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(1320);
					decl_cls();
					}
					} 
				}
				setState(1326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
			}
			setState(1330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semi || _la==SEMI) {
				{
				{
				setState(1327);
				semi();
				}
				}
				setState(1332);
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

	public static class Decllist_clsContext extends ParserRuleContext {
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public Decls_clsContext decls_cls() {
			return getRuleContext(Decls_clsContext.class,0);
		}
		public Decllist_clsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decllist_cls; }
	}

	public final Decllist_clsContext decllist_cls() throws RecognitionException {
		Decllist_clsContext _localctx = new Decllist_clsContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_decllist_cls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1333);
			open_();
			setState(1335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << CASE) | (1L << DATA) | (1L << DEFAULT) | (1L << DO) | (1L << HIDING) | (1L << IF) | (1L << INFIX) | (1L << INFIXL) | (1L << INFIXR) | (1L << LET) | (1L << QUALIFIED) | (1L << TYPE) | (1L << WILDCARD) | (1L << EXPORT) | (1L << MDO) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << PATTERN) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LCASE - 73)) | (1L << (Bang - 73)) | (1L << (Minus - 73)) | (1L << (Tilde - 73)) | (1L << (DDollar - 73)) | (1L << (Dollar - 73)) | (1L << (Semi - 73)) | (1L << (Quote - 73)) | (1L << (DoubleQuote - 73)) | (1L << (ReverseSlash - 73)) | (1L << (AopenParen - 73)) | (1L << (TopenTexpQuote - 73)) | (1L << (TopenExpQuote - 73)) | (1L << (TopenPatQuote - 73)) | (1L << (TopenTypQoute - 73)) | (1L << (TopenDecQoute - 73)) | (1L << (OpenBoxParen - 73)) | (1L << (OpenRoundBracket - 73)) | (1L << (OpenSquareBracket - 73)) | (1L << (CHAR - 73)) | (1L << (STRING - 73)) | (1L << (VARID - 73)) | (1L << (CONID - 73)) | (1L << (OpenPragmaBracket - 73)) | (1L << (SEMI - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)) | (1L << (FLOAT - 137)))) != 0)) {
				{
				setState(1334);
				decls_cls();
				}
			}

			setState(1337);
			close();
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

	public static class Where_clsContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(HaskellParser.WHERE, 0); }
		public Decllist_clsContext decllist_cls() {
			return getRuleContext(Decllist_clsContext.class,0);
		}
		public Where_clsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_cls; }
	}

	public final Where_clsContext where_cls() throws RecognitionException {
		Where_clsContext _localctx = new Where_clsContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_where_cls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1339);
			match(WHERE);
			setState(1340);
			decllist_cls();
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

	public static class Decl_instContext extends ParserRuleContext {
		public At_decl_instContext at_decl_inst() {
			return getRuleContext(At_decl_instContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Decl_instContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_inst; }
	}

	public final Decl_instContext decl_inst() throws RecognitionException {
		Decl_instContext _localctx = new Decl_instContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_decl_inst);
		try {
			setState(1344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA:
			case NEWTYPE:
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1342);
				at_decl_inst();
				}
				break;
			case AS:
			case CASE:
			case DO:
			case HIDING:
			case IF:
			case INFIX:
			case INFIXL:
			case INFIXR:
			case LET:
			case QUALIFIED:
			case WILDCARD:
			case EXPORT:
			case MDO:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case PATTERN:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case LCASE:
			case Bang:
			case Minus:
			case Tilde:
			case DDollar:
			case Dollar:
			case Semi:
			case Quote:
			case DoubleQuote:
			case ReverseSlash:
			case AopenParen:
			case TopenTexpQuote:
			case TopenExpQuote:
			case TopenPatQuote:
			case TopenTypQoute:
			case TopenDecQoute:
			case OpenBoxParen:
			case OpenRoundBracket:
			case OpenSquareBracket:
			case CHAR:
			case STRING:
			case VARID:
			case CONID:
			case OpenPragmaBracket:
			case SEMI:
			case DECIMAL:
			case OCTAL:
			case HEXADECIMAL:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1343);
				decl();
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

	public static class Decls_instContext extends ParserRuleContext {
		public List<Decl_instContext> decl_inst() {
			return getRuleContexts(Decl_instContext.class);
		}
		public Decl_instContext decl_inst(int i) {
			return getRuleContext(Decl_instContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public Decls_instContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls_inst; }
	}

	public final Decls_instContext decls_inst() throws RecognitionException {
		Decls_instContext _localctx = new Decls_instContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_decls_inst);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1346);
			decl_inst();
			setState(1356);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1348); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1347);
							semi();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1350); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(1352);
					decl_inst();
					}
					} 
				}
				setState(1358);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
			}
			setState(1362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semi || _la==SEMI) {
				{
				{
				setState(1359);
				semi();
				}
				}
				setState(1364);
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

	public static class Decllist_instContext extends ParserRuleContext {
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public Decls_instContext decls_inst() {
			return getRuleContext(Decls_instContext.class,0);
		}
		public Decllist_instContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decllist_inst; }
	}

	public final Decllist_instContext decllist_inst() throws RecognitionException {
		Decllist_instContext _localctx = new Decllist_instContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_decllist_inst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1365);
			open_();
			setState(1367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << CASE) | (1L << DATA) | (1L << DO) | (1L << HIDING) | (1L << IF) | (1L << INFIX) | (1L << INFIXL) | (1L << INFIXR) | (1L << LET) | (1L << NEWTYPE) | (1L << QUALIFIED) | (1L << TYPE) | (1L << WILDCARD) | (1L << EXPORT) | (1L << MDO) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << PATTERN) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LCASE - 73)) | (1L << (Bang - 73)) | (1L << (Minus - 73)) | (1L << (Tilde - 73)) | (1L << (DDollar - 73)) | (1L << (Dollar - 73)) | (1L << (Semi - 73)) | (1L << (Quote - 73)) | (1L << (DoubleQuote - 73)) | (1L << (ReverseSlash - 73)) | (1L << (AopenParen - 73)) | (1L << (TopenTexpQuote - 73)) | (1L << (TopenExpQuote - 73)) | (1L << (TopenPatQuote - 73)) | (1L << (TopenTypQoute - 73)) | (1L << (TopenDecQoute - 73)) | (1L << (OpenBoxParen - 73)) | (1L << (OpenRoundBracket - 73)) | (1L << (OpenSquareBracket - 73)) | (1L << (CHAR - 73)) | (1L << (STRING - 73)) | (1L << (VARID - 73)) | (1L << (CONID - 73)) | (1L << (OpenPragmaBracket - 73)) | (1L << (SEMI - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)) | (1L << (FLOAT - 137)))) != 0)) {
				{
				setState(1366);
				decls_inst();
				}
			}

			setState(1369);
			close();
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

	public static class Where_instContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(HaskellParser.WHERE, 0); }
		public Decllist_instContext decllist_inst() {
			return getRuleContext(Decllist_instContext.class,0);
		}
		public Where_instContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_inst; }
	}

	public final Where_instContext where_inst() throws RecognitionException {
		Where_instContext _localctx = new Where_instContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_where_inst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1371);
			match(WHERE);
			setState(1372);
			decllist_inst();
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

	public static class DeclsContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_decls);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1374);
			decl();
			setState(1384);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,158,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1376); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1375);
							semi();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1378); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(1380);
					decl();
					}
					} 
				}
				setState(1386);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,158,_ctx);
			}
			setState(1390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semi || _la==SEMI) {
				{
				{
				setState(1387);
				semi();
				}
				}
				setState(1392);
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

	public static class DecllistContext extends ParserRuleContext {
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public DecllistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decllist; }
	}

	public final DecllistContext decllist() throws RecognitionException {
		DecllistContext _localctx = new DecllistContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_decllist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1393);
			open_();
			setState(1395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << CASE) | (1L << DO) | (1L << HIDING) | (1L << IF) | (1L << INFIX) | (1L << INFIXL) | (1L << INFIXR) | (1L << LET) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << EXPORT) | (1L << MDO) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << PATTERN) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LCASE - 73)) | (1L << (Bang - 73)) | (1L << (Minus - 73)) | (1L << (Tilde - 73)) | (1L << (DDollar - 73)) | (1L << (Dollar - 73)) | (1L << (Semi - 73)) | (1L << (Quote - 73)) | (1L << (DoubleQuote - 73)) | (1L << (ReverseSlash - 73)) | (1L << (AopenParen - 73)) | (1L << (TopenTexpQuote - 73)) | (1L << (TopenExpQuote - 73)) | (1L << (TopenPatQuote - 73)) | (1L << (TopenTypQoute - 73)) | (1L << (TopenDecQoute - 73)) | (1L << (OpenBoxParen - 73)) | (1L << (OpenRoundBracket - 73)) | (1L << (OpenSquareBracket - 73)) | (1L << (CHAR - 73)) | (1L << (STRING - 73)) | (1L << (VARID - 73)) | (1L << (CONID - 73)) | (1L << (OpenPragmaBracket - 73)) | (1L << (SEMI - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)) | (1L << (FLOAT - 137)))) != 0)) {
				{
				setState(1394);
				decls();
				}
			}

			setState(1397);
			close();
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

	public static class BindsContext extends ParserRuleContext {
		public DecllistContext decllist() {
			return getRuleContext(DecllistContext.class,0);
		}
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public DbindsContext dbinds() {
			return getRuleContext(DbindsContext.class,0);
		}
		public BindsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binds; }
	}

	public final BindsContext binds() throws RecognitionException {
		BindsContext _localctx = new BindsContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_binds);
		int _la;
		try {
			setState(1406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1399);
				decllist();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1400);
				open_();
				setState(1402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==VARID) {
					{
					setState(1401);
					dbinds();
					}
				}

				setState(1404);
				close();
				}
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

	public static class WherebindsContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(HaskellParser.WHERE, 0); }
		public BindsContext binds() {
			return getRuleContext(BindsContext.class,0);
		}
		public WherebindsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wherebinds; }
	}

	public final WherebindsContext wherebinds() throws RecognitionException {
		WherebindsContext _localctx = new WherebindsContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_wherebinds);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1408);
			match(WHERE);
			setState(1409);
			binds();
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

	public static class RulesContext extends ParserRuleContext {
		public List<Pragma_ruleContext> pragma_rule() {
			return getRuleContexts(Pragma_ruleContext.class);
		}
		public Pragma_ruleContext pragma_rule(int i) {
			return getRuleContext(Pragma_ruleContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_rules);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1411);
			pragma_rule();
			setState(1417);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1412);
					semi();
					setState(1413);
					pragma_rule();
					}
					} 
				}
				setState(1419);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			}
			setState(1421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Semi || _la==SEMI) {
				{
				setState(1420);
				semi();
				}
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

	public static class Pragma_ruleContext extends ParserRuleContext {
		public PstringContext pstring() {
			return getRuleContext(PstringContext.class,0);
		}
		public InfixexpContext infixexp() {
			return getRuleContext(InfixexpContext.class,0);
		}
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public Rule_activationContext rule_activation() {
			return getRuleContext(Rule_activationContext.class,0);
		}
		public Rule_forallsContext rule_foralls() {
			return getRuleContext(Rule_forallsContext.class,0);
		}
		public Pragma_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_rule; }
	}

	public final Pragma_ruleContext pragma_rule() throws RecognitionException {
		Pragma_ruleContext _localctx = new Pragma_ruleContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_pragma_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1423);
			pstring();
			setState(1425);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
			case 1:
				{
				setState(1424);
				rule_activation();
				}
				break;
			}
			setState(1428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FORALL) {
				{
				setState(1427);
				rule_foralls();
				}
			}

			setState(1430);
			infixexp();
			setState(1431);
			match(Eq);
			setState(1432);
			exp();
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

	public static class Rule_activation_markerContext extends ParserRuleContext {
		public TerminalNode Tilde() { return getToken(HaskellParser.Tilde, 0); }
		public VarsymContext varsym() {
			return getRuleContext(VarsymContext.class,0);
		}
		public Rule_activation_markerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_activation_marker; }
	}

	public final Rule_activation_markerContext rule_activation_marker() throws RecognitionException {
		Rule_activation_markerContext _localctx = new Rule_activation_markerContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_rule_activation_marker);
		try {
			setState(1436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1434);
				match(Tilde);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1435);
				varsym();
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

	public static class Rule_activationContext extends ParserRuleContext {
		public TerminalNode OpenSquareBracket() { return getToken(HaskellParser.OpenSquareBracket, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode CloseSquareBracket() { return getToken(HaskellParser.CloseSquareBracket, 0); }
		public Rule_activation_markerContext rule_activation_marker() {
			return getRuleContext(Rule_activation_markerContext.class,0);
		}
		public Rule_activationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_activation; }
	}

	public final Rule_activationContext rule_activation() throws RecognitionException {
		Rule_activationContext _localctx = new Rule_activationContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_rule_activation);
		try {
			setState(1451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1438);
				match(OpenSquareBracket);
				setState(1439);
				integer();
				setState(1440);
				match(CloseSquareBracket);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1442);
				match(OpenSquareBracket);
				setState(1443);
				rule_activation_marker();
				setState(1444);
				integer();
				setState(1445);
				match(CloseSquareBracket);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1447);
				match(OpenSquareBracket);
				setState(1448);
				rule_activation_marker();
				setState(1449);
				match(CloseSquareBracket);
				}
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

	public static class Rule_forallsContext extends ParserRuleContext {
		public List<TerminalNode> FORALL() { return getTokens(HaskellParser.FORALL); }
		public TerminalNode FORALL(int i) {
			return getToken(HaskellParser.FORALL, i);
		}
		public List<TerminalNode> Dot() { return getTokens(HaskellParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(HaskellParser.Dot, i);
		}
		public List<Rule_varsContext> rule_vars() {
			return getRuleContexts(Rule_varsContext.class);
		}
		public Rule_varsContext rule_vars(int i) {
			return getRuleContext(Rule_varsContext.class,i);
		}
		public Rule_forallsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_foralls; }
	}

	public final Rule_forallsContext rule_foralls() throws RecognitionException {
		Rule_forallsContext _localctx = new Rule_forallsContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_rule_foralls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1453);
			match(FORALL);
			setState(1455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==OpenRoundBracket || _la==VARID) {
				{
				setState(1454);
				rule_vars();
				}
			}

			setState(1457);
			match(Dot);
			setState(1463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FORALL) {
				{
				setState(1458);
				match(FORALL);
				setState(1460);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==OpenRoundBracket || _la==VARID) {
					{
					setState(1459);
					rule_vars();
					}
				}

				setState(1462);
				match(Dot);
				}
			}

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

	public static class Rule_varsContext extends ParserRuleContext {
		public List<Rule_varContext> rule_var() {
			return getRuleContexts(Rule_varContext.class);
		}
		public Rule_varContext rule_var(int i) {
			return getRuleContext(Rule_varContext.class,i);
		}
		public Rule_varsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_vars; }
	}

	public final Rule_varsContext rule_vars() throws RecognitionException {
		Rule_varsContext _localctx = new Rule_varsContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_rule_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1466); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1465);
				rule_var();
				}
				}
				setState(1468); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==OpenRoundBracket || _la==VARID );
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

	public static class Rule_varContext extends ParserRuleContext {
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public CtypeContext ctype() {
			return getRuleContext(CtypeContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public Rule_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_var; }
	}

	public final Rule_varContext rule_var() throws RecognitionException {
		Rule_varContext _localctx = new Rule_varContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_rule_var);
		try {
			setState(1477);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AS:
			case HIDING:
			case QUALIFIED:
			case EXPORT:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case VARID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1470);
				varid();
				}
				break;
			case OpenRoundBracket:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1471);
				match(OpenRoundBracket);
				setState(1472);
				varid();
				setState(1473);
				match(DoubleColon);
				setState(1474);
				ctype();
				setState(1475);
				match(CloseRoundBracket);
				}
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

	public static class WarningsContext extends ParserRuleContext {
		public List<Pragma_warningContext> pragma_warning() {
			return getRuleContexts(Pragma_warningContext.class);
		}
		public Pragma_warningContext pragma_warning(int i) {
			return getRuleContext(Pragma_warningContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public WarningsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_warnings; }
	}

	public final WarningsContext warnings() throws RecognitionException {
		WarningsContext _localctx = new WarningsContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_warnings);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1479);
			pragma_warning();
			setState(1485);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1480);
					semi();
					setState(1481);
					pragma_warning();
					}
					} 
				}
				setState(1487);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
			}
			setState(1489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Semi || _la==SEMI) {
				{
				setState(1488);
				semi();
				}
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

	public static class Pragma_warningContext extends ParserRuleContext {
		public NamelistContext namelist() {
			return getRuleContext(NamelistContext.class,0);
		}
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public Pragma_warningContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_warning; }
	}

	public final Pragma_warningContext pragma_warning() throws RecognitionException {
		Pragma_warningContext _localctx = new Pragma_warningContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_pragma_warning);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1491);
			namelist();
			setState(1492);
			strings();
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

	public static class DeprecationsContext extends ParserRuleContext {
		public List<Pragma_deprecationContext> pragma_deprecation() {
			return getRuleContexts(Pragma_deprecationContext.class);
		}
		public Pragma_deprecationContext pragma_deprecation(int i) {
			return getRuleContext(Pragma_deprecationContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public DeprecationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deprecations; }
	}

	public final DeprecationsContext deprecations() throws RecognitionException {
		DeprecationsContext _localctx = new DeprecationsContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_deprecations);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1494);
			pragma_deprecation();
			setState(1500);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1495);
					semi();
					setState(1496);
					pragma_deprecation();
					}
					} 
				}
				setState(1502);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
			}
			setState(1504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Semi || _la==SEMI) {
				{
				setState(1503);
				semi();
				}
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

	public static class Pragma_deprecationContext extends ParserRuleContext {
		public NamelistContext namelist() {
			return getRuleContext(NamelistContext.class,0);
		}
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public Pragma_deprecationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_deprecation; }
	}

	public final Pragma_deprecationContext pragma_deprecation() throws RecognitionException {
		Pragma_deprecationContext _localctx = new Pragma_deprecationContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_pragma_deprecation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1506);
			namelist();
			setState(1507);
			strings();
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

	public static class StringsContext extends ParserRuleContext {
		public PstringContext pstring() {
			return getRuleContext(PstringContext.class,0);
		}
		public TerminalNode OpenSquareBracket() { return getToken(HaskellParser.OpenSquareBracket, 0); }
		public TerminalNode CloseSquareBracket() { return getToken(HaskellParser.CloseSquareBracket, 0); }
		public StringlistContext stringlist() {
			return getRuleContext(StringlistContext.class,0);
		}
		public StringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strings; }
	}

	public final StringsContext strings() throws RecognitionException {
		StringsContext _localctx = new StringsContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_strings);
		int _la;
		try {
			setState(1515);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(1509);
				pstring();
				}
				break;
			case OpenSquareBracket:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1510);
				match(OpenSquareBracket);
				setState(1512);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(1511);
					stringlist();
					}
				}

				setState(1514);
				match(CloseSquareBracket);
				}
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

	public static class StringlistContext extends ParserRuleContext {
		public List<PstringContext> pstring() {
			return getRuleContexts(PstringContext.class);
		}
		public PstringContext pstring(int i) {
			return getRuleContext(PstringContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public StringlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringlist; }
	}

	public final StringlistContext stringlist() throws RecognitionException {
		StringlistContext _localctx = new StringlistContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_stringlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1517);
			pstring();
			setState(1522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1518);
				match(Comma);
				setState(1519);
				pstring();
				}
				}
				setState(1524);
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

	public static class AnnotationContext extends ParserRuleContext {
		public TerminalNode OpenPragmaBracket() { return getToken(HaskellParser.OpenPragmaBracket, 0); }
		public TerminalNode ANN() { return getToken(HaskellParser.ANN, 0); }
		public Name_varContext name_var() {
			return getRuleContext(Name_varContext.class,0);
		}
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public TerminalNode ClosePragmaBracket() { return getToken(HaskellParser.ClosePragmaBracket, 0); }
		public TyconContext tycon() {
			return getRuleContext(TyconContext.class,0);
		}
		public TerminalNode MODULE() { return getToken(HaskellParser.MODULE, 0); }
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_annotation);
		try {
			setState(1543);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1525);
				match(OpenPragmaBracket);
				setState(1526);
				match(ANN);
				setState(1527);
				name_var();
				setState(1528);
				aexp();
				setState(1529);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1531);
				match(OpenPragmaBracket);
				setState(1532);
				match(ANN);
				setState(1533);
				tycon();
				setState(1534);
				aexp();
				setState(1535);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1537);
				match(OpenPragmaBracket);
				setState(1538);
				match(ANN);
				setState(1539);
				match(MODULE);
				setState(1540);
				aexp();
				setState(1541);
				match(ClosePragmaBracket);
				}
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

	public static class FdeclContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(HaskellParser.IMPORT, 0); }
		public CallconvContext callconv() {
			return getRuleContext(CallconvContext.class,0);
		}
		public FspecContext fspec() {
			return getRuleContext(FspecContext.class,0);
		}
		public SafetyContext safety() {
			return getRuleContext(SafetyContext.class,0);
		}
		public TerminalNode EXPORT() { return getToken(HaskellParser.EXPORT, 0); }
		public FdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fdecl; }
	}

	public final FdeclContext fdecl() throws RecognitionException {
		FdeclContext _localctx = new FdeclContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_fdecl);
		int _la;
		try {
			setState(1556);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1545);
				match(IMPORT);
				setState(1546);
				callconv();
				setState(1548);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SAFE) | (1L << INTERRUPTIBLE) | (1L << UNSAFE))) != 0)) {
					{
					setState(1547);
					safety();
					}
				}

				setState(1550);
				fspec();
				}
				}
				break;
			case EXPORT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1552);
				match(EXPORT);
				setState(1553);
				callconv();
				setState(1554);
				fspec();
				}
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

	public static class CallconvContext extends ParserRuleContext {
		public TerminalNode CCALL() { return getToken(HaskellParser.CCALL, 0); }
		public TerminalNode STDCALL() { return getToken(HaskellParser.STDCALL, 0); }
		public TerminalNode CPPCALL() { return getToken(HaskellParser.CPPCALL, 0); }
		public TerminalNode JSCALL() { return getToken(HaskellParser.JSCALL, 0); }
		public CallconvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callconv; }
	}

	public final CallconvContext callconv() throws RecognitionException {
		CallconvContext _localctx = new CallconvContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_callconv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1558);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STDCALL) | (1L << CCALL) | (1L << CPPCALL) | (1L << JSCALL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class SafetyContext extends ParserRuleContext {
		public TerminalNode UNSAFE() { return getToken(HaskellParser.UNSAFE, 0); }
		public TerminalNode SAFE() { return getToken(HaskellParser.SAFE, 0); }
		public TerminalNode INTERRUPTIBLE() { return getToken(HaskellParser.INTERRUPTIBLE, 0); }
		public SafetyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_safety; }
	}

	public final SafetyContext safety() throws RecognitionException {
		SafetyContext _localctx = new SafetyContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_safety);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1560);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SAFE) | (1L << INTERRUPTIBLE) | (1L << UNSAFE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class FspecContext extends ParserRuleContext {
		public Var_Context var_() {
			return getRuleContext(Var_Context.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public SigtypedocContext sigtypedoc() {
			return getRuleContext(SigtypedocContext.class,0);
		}
		public PstringContext pstring() {
			return getRuleContext(PstringContext.class,0);
		}
		public FspecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fspec; }
	}

	public final FspecContext fspec() throws RecognitionException {
		FspecContext _localctx = new FspecContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_fspec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(1562);
				pstring();
				}
			}

			setState(1565);
			var_();
			setState(1566);
			match(DoubleColon);
			setState(1567);
			sigtypedoc();
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

	public static class Opt_sigContext extends ParserRuleContext {
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public SigtypeContext sigtype() {
			return getRuleContext(SigtypeContext.class,0);
		}
		public Opt_sigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_sig; }
	}

	public final Opt_sigContext opt_sig() throws RecognitionException {
		Opt_sigContext _localctx = new Opt_sigContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_opt_sig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1569);
			match(DoubleColon);
			setState(1570);
			sigtype();
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

	public static class Opt_tyconsigContext extends ParserRuleContext {
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public GtyconContext gtycon() {
			return getRuleContext(GtyconContext.class,0);
		}
		public Opt_tyconsigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_tyconsig; }
	}

	public final Opt_tyconsigContext opt_tyconsig() throws RecognitionException {
		Opt_tyconsigContext _localctx = new Opt_tyconsigContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_opt_tyconsig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1572);
			match(DoubleColon);
			setState(1573);
			gtycon();
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

	public static class SigtypeContext extends ParserRuleContext {
		public CtypeContext ctype() {
			return getRuleContext(CtypeContext.class,0);
		}
		public SigtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sigtype; }
	}

	public final SigtypeContext sigtype() throws RecognitionException {
		SigtypeContext _localctx = new SigtypeContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_sigtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1575);
			ctype();
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

	public static class SigtypedocContext extends ParserRuleContext {
		public CtypedocContext ctypedoc() {
			return getRuleContext(CtypedocContext.class,0);
		}
		public SigtypedocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sigtypedoc; }
	}

	public final SigtypedocContext sigtypedoc() throws RecognitionException {
		SigtypedocContext _localctx = new SigtypedocContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_sigtypedoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1577);
			ctypedoc();
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

	public static class Sig_varsContext extends ParserRuleContext {
		public List<Var_Context> var_() {
			return getRuleContexts(Var_Context.class);
		}
		public Var_Context var_(int i) {
			return getRuleContext(Var_Context.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public Sig_varsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sig_vars; }
	}

	public final Sig_varsContext sig_vars() throws RecognitionException {
		Sig_varsContext _localctx = new Sig_varsContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_sig_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1579);
			var_();
			setState(1584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1580);
				match(Comma);
				setState(1581);
				var_();
				}
				}
				setState(1586);
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

	public static class Sigtypes1Context extends ParserRuleContext {
		public List<SigtypeContext> sigtype() {
			return getRuleContexts(SigtypeContext.class);
		}
		public SigtypeContext sigtype(int i) {
			return getRuleContext(SigtypeContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public Sigtypes1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sigtypes1; }
	}

	public final Sigtypes1Context sigtypes1() throws RecognitionException {
		Sigtypes1Context _localctx = new Sigtypes1Context(_ctx, getState());
		enterRule(_localctx, 184, RULE_sigtypes1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1587);
			sigtype();
			setState(1592);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1588);
				match(Comma);
				setState(1589);
				sigtype();
				}
				}
				setState(1594);
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

	public static class UnpackednessContext extends ParserRuleContext {
		public TerminalNode OpenPragmaBracket() { return getToken(HaskellParser.OpenPragmaBracket, 0); }
		public TerminalNode UNPACK() { return getToken(HaskellParser.UNPACK, 0); }
		public TerminalNode ClosePragmaBracket() { return getToken(HaskellParser.ClosePragmaBracket, 0); }
		public TerminalNode NOUNPACK() { return getToken(HaskellParser.NOUNPACK, 0); }
		public UnpackednessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unpackedness; }
	}

	public final UnpackednessContext unpackedness() throws RecognitionException {
		UnpackednessContext _localctx = new UnpackednessContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_unpackedness);
		try {
			setState(1601);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1595);
				match(OpenPragmaBracket);
				setState(1596);
				match(UNPACK);
				setState(1597);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1598);
				match(OpenPragmaBracket);
				setState(1599);
				match(NOUNPACK);
				setState(1600);
				match(ClosePragmaBracket);
				}
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

	public static class Forall_vis_flagContext extends ParserRuleContext {
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public TerminalNode Arrow() { return getToken(HaskellParser.Arrow, 0); }
		public Forall_vis_flagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forall_vis_flag; }
	}

	public final Forall_vis_flagContext forall_vis_flag() throws RecognitionException {
		Forall_vis_flagContext _localctx = new Forall_vis_flagContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_forall_vis_flag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1603);
			_la = _input.LA(1);
			if ( !(_la==Arrow || _la==Dot) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class KtypeContext extends ParserRuleContext {
		public CtypeContext ctype() {
			return getRuleContext(CtypeContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public KindContext kind() {
			return getRuleContext(KindContext.class,0);
		}
		public KtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ktype; }
	}

	public final KtypeContext ktype() throws RecognitionException {
		KtypeContext _localctx = new KtypeContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_ktype);
		try {
			setState(1610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1605);
				ctype();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1606);
				ctype();
				setState(1607);
				match(DoubleColon);
				setState(1608);
				kind();
				}
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

	public static class KtypedocContext extends ParserRuleContext {
		public CtypedocContext ctypedoc() {
			return getRuleContext(CtypedocContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public KindContext kind() {
			return getRuleContext(KindContext.class,0);
		}
		public KtypedocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ktypedoc; }
	}

	public final KtypedocContext ktypedoc() throws RecognitionException {
		KtypedocContext _localctx = new KtypedocContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_ktypedoc);
		try {
			setState(1617);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1612);
				ctypedoc();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1613);
				ctypedoc();
				setState(1614);
				match(DoubleColon);
				setState(1615);
				kind();
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

	public static class CtypeContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(HaskellParser.FORALL, 0); }
		public Forall_vis_flagContext forall_vis_flag() {
			return getRuleContext(Forall_vis_flagContext.class,0);
		}
		public CtypeContext ctype() {
			return getRuleContext(CtypeContext.class,0);
		}
		public Tv_bndrsContext tv_bndrs() {
			return getRuleContext(Tv_bndrsContext.class,0);
		}
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public TerminalNode DoubleArrow() { return getToken(HaskellParser.DoubleArrow, 0); }
		public Var_Context var_() {
			return getRuleContext(Var_Context.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public CtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctype; }
	}

	public final CtypeContext ctype() throws RecognitionException {
		CtypeContext _localctx = new CtypeContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_ctype);
		int _la;
		try {
			setState(1635);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1619);
				match(FORALL);
				setState(1621);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (OCURLY - 120)))) != 0)) {
					{
					setState(1620);
					tv_bndrs();
					}
				}

				setState(1623);
				forall_vis_flag();
				setState(1624);
				ctype();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1626);
				btype();
				setState(1627);
				match(DoubleArrow);
				setState(1628);
				ctype();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1630);
				var_();
				setState(1631);
				match(DoubleColon);
				setState(1632);
				type_();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1634);
				type_();
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

	public static class CtypedocContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(HaskellParser.FORALL, 0); }
		public Forall_vis_flagContext forall_vis_flag() {
			return getRuleContext(Forall_vis_flagContext.class,0);
		}
		public CtypedocContext ctypedoc() {
			return getRuleContext(CtypedocContext.class,0);
		}
		public Tv_bndrsContext tv_bndrs() {
			return getRuleContext(Tv_bndrsContext.class,0);
		}
		public Tycl_contextContext tycl_context() {
			return getRuleContext(Tycl_contextContext.class,0);
		}
		public TerminalNode DoubleArrow() { return getToken(HaskellParser.DoubleArrow, 0); }
		public Var_Context var_() {
			return getRuleContext(Var_Context.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TypedocContext typedoc() {
			return getRuleContext(TypedocContext.class,0);
		}
		public CtypedocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctypedoc; }
	}

	public final CtypedocContext ctypedoc() throws RecognitionException {
		CtypedocContext _localctx = new CtypedocContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_ctypedoc);
		int _la;
		try {
			setState(1653);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1637);
				match(FORALL);
				setState(1639);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (OCURLY - 120)))) != 0)) {
					{
					setState(1638);
					tv_bndrs();
					}
				}

				setState(1641);
				forall_vis_flag();
				setState(1642);
				ctypedoc();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1644);
				tycl_context();
				setState(1645);
				match(DoubleArrow);
				setState(1646);
				ctypedoc();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1648);
				var_();
				setState(1649);
				match(DoubleColon);
				setState(1650);
				type_();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1652);
				typedoc();
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

	public static class Tycl_contextContext extends ParserRuleContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public Tycl_contextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tycl_context; }
	}

	public final Tycl_contextContext tycl_context() throws RecognitionException {
		Tycl_contextContext _localctx = new Tycl_contextContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_tycl_context);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1655);
			btype();
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

	public static class Constr_contextContext extends ParserRuleContext {
		public Constr_btypeContext constr_btype() {
			return getRuleContext(Constr_btypeContext.class,0);
		}
		public Constr_contextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr_context; }
	}

	public final Constr_contextContext constr_context() throws RecognitionException {
		Constr_contextContext _localctx = new Constr_contextContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_constr_context);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1657);
			constr_btype();
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

	public static class Type_Context extends ParserRuleContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public TerminalNode Arrow() { return getToken(HaskellParser.Arrow, 0); }
		public CtypeContext ctype() {
			return getRuleContext(CtypeContext.class,0);
		}
		public Type_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_; }
	}

	public final Type_Context type_() throws RecognitionException {
		Type_Context _localctx = new Type_Context(_ctx, getState());
		enterRule(_localctx, 202, RULE_type_);
		try {
			setState(1664);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1659);
				btype();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1660);
				btype();
				setState(1661);
				match(Arrow);
				setState(1662);
				ctype();
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

	public static class TypedocContext extends ParserRuleContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public TerminalNode Arrow() { return getToken(HaskellParser.Arrow, 0); }
		public CtypedocContext ctypedoc() {
			return getRuleContext(CtypedocContext.class,0);
		}
		public TypedocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedoc; }
	}

	public final TypedocContext typedoc() throws RecognitionException {
		TypedocContext _localctx = new TypedocContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_typedoc);
		try {
			setState(1671);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1666);
				btype();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1667);
				btype();
				setState(1668);
				match(Arrow);
				setState(1669);
				ctypedoc();
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

	public static class Constr_btypeContext extends ParserRuleContext {
		public Constr_tyappsContext constr_tyapps() {
			return getRuleContext(Constr_tyappsContext.class,0);
		}
		public Constr_btypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr_btype; }
	}

	public final Constr_btypeContext constr_btype() throws RecognitionException {
		Constr_btypeContext _localctx = new Constr_btypeContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_constr_btype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1673);
			constr_tyapps();
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

	public static class Constr_tyappsContext extends ParserRuleContext {
		public List<Constr_tyappContext> constr_tyapp() {
			return getRuleContexts(Constr_tyappContext.class);
		}
		public Constr_tyappContext constr_tyapp(int i) {
			return getRuleContext(Constr_tyappContext.class,i);
		}
		public Constr_tyappsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr_tyapps; }
	}

	public final Constr_tyappsContext constr_tyapps() throws RecognitionException {
		Constr_tyappsContext _localctx = new Constr_tyappsContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_constr_tyapps);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1676); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1675);
					constr_tyapp();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1678); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,196,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Constr_tyappContext extends ParserRuleContext {
		public TyappContext tyapp() {
			return getRuleContext(TyappContext.class,0);
		}
		public Constr_tyappContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr_tyapp; }
	}

	public final Constr_tyappContext constr_tyapp() throws RecognitionException {
		Constr_tyappContext _localctx = new Constr_tyappContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_constr_tyapp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1680);
			tyapp();
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

	public static class BtypeContext extends ParserRuleContext {
		public TyappsContext tyapps() {
			return getRuleContext(TyappsContext.class,0);
		}
		public BtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_btype; }
	}

	public final BtypeContext btype() throws RecognitionException {
		BtypeContext _localctx = new BtypeContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_btype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1682);
			tyapps();
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

	public static class TyappsContext extends ParserRuleContext {
		public List<TyappContext> tyapp() {
			return getRuleContexts(TyappContext.class);
		}
		public TyappContext tyapp(int i) {
			return getRuleContext(TyappContext.class,i);
		}
		public TyappsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tyapps; }
	}

	public final TyappsContext tyapps() throws RecognitionException {
		TyappsContext _localctx = new TyappsContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_tyapps);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1685); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1684);
					tyapp();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1687); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class TyappContext extends ParserRuleContext {
		public AtypeContext atype() {
			return getRuleContext(AtypeContext.class,0);
		}
		public TerminalNode Atsign() { return getToken(HaskellParser.Atsign, 0); }
		public QtyconopContext qtyconop() {
			return getRuleContext(QtyconopContext.class,0);
		}
		public TyvaropContext tyvarop() {
			return getRuleContext(TyvaropContext.class,0);
		}
		public TerminalNode Quote() { return getToken(HaskellParser.Quote, 0); }
		public QconopContext qconop() {
			return getRuleContext(QconopContext.class,0);
		}
		public VaropContext varop() {
			return getRuleContext(VaropContext.class,0);
		}
		public UnpackednessContext unpackedness() {
			return getRuleContext(UnpackednessContext.class,0);
		}
		public TyappContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tyapp; }
	}

	public final TyappContext tyapp() throws RecognitionException {
		TyappContext _localctx = new TyappContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_tyapp);
		try {
			setState(1699);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1689);
				atype();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1690);
				match(Atsign);
				setState(1691);
				atype();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1692);
				qtyconop();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1693);
				tyvarop();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(1694);
				match(Quote);
				setState(1695);
				qconop();
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(1696);
				match(Quote);
				setState(1697);
				varop();
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1698);
				unpackedness();
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

	public static class AtypeContext extends ParserRuleContext {
		public NtgtyconContext ntgtycon() {
			return getRuleContext(NtgtyconContext.class,0);
		}
		public TyvarContext tyvar() {
			return getRuleContext(TyvarContext.class,0);
		}
		public TerminalNode Asterisk() { return getToken(HaskellParser.Asterisk, 0); }
		public TerminalNode Tilde() { return getToken(HaskellParser.Tilde, 0); }
		public AtypeContext atype() {
			return getRuleContext(AtypeContext.class,0);
		}
		public TerminalNode Bang() { return getToken(HaskellParser.Bang, 0); }
		public TerminalNode OCURLY() { return getToken(HaskellParser.OCURLY, 0); }
		public TerminalNode CCURLY() { return getToken(HaskellParser.CCURLY, 0); }
		public FielddeclsContext fielddecls() {
			return getRuleContext(FielddeclsContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public KtypeContext ktype() {
			return getRuleContext(KtypeContext.class,0);
		}
		public TerminalNode Comma() { return getToken(HaskellParser.Comma, 0); }
		public Comma_typesContext comma_types() {
			return getRuleContext(Comma_typesContext.class,0);
		}
		public TerminalNode OpenBoxParen() { return getToken(HaskellParser.OpenBoxParen, 0); }
		public TerminalNode CloseBoxParen() { return getToken(HaskellParser.CloseBoxParen, 0); }
		public Bar_types2Context bar_types2() {
			return getRuleContext(Bar_types2Context.class,0);
		}
		public TerminalNode OpenSquareBracket() { return getToken(HaskellParser.OpenSquareBracket, 0); }
		public TerminalNode CloseSquareBracket() { return getToken(HaskellParser.CloseSquareBracket, 0); }
		public QuasiquoteContext quasiquote() {
			return getRuleContext(QuasiquoteContext.class,0);
		}
		public Splice_untypedContext splice_untyped() {
			return getRuleContext(Splice_untypedContext.class,0);
		}
		public TerminalNode Quote() { return getToken(HaskellParser.Quote, 0); }
		public Qcon_nowiredlistContext qcon_nowiredlist() {
			return getRuleContext(Qcon_nowiredlistContext.class,0);
		}
		public Var_Context var_() {
			return getRuleContext(Var_Context.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public PstringContext pstring() {
			return getRuleContext(PstringContext.class,0);
		}
		public TerminalNode WILDCARD() { return getToken(HaskellParser.WILDCARD, 0); }
		public AtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atype; }
	}

	public final AtypeContext atype() throws RecognitionException {
		AtypeContext _localctx = new AtypeContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_atype);
		int _la;
		try {
			setState(1767);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1701);
				ntgtycon();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1702);
				tyvar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1703);
				match(Asterisk);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(1704);
				match(Tilde);
				setState(1705);
				atype();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(1706);
				match(Bang);
				setState(1707);
				atype();
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(1708);
				match(OCURLY);
				setState(1710);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==OpenRoundBracket || _la==VARID) {
					{
					setState(1709);
					fielddecls();
					}
				}

				setState(1712);
				match(CCURLY);
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(1713);
				match(OpenRoundBracket);
				setState(1714);
				match(CloseRoundBracket);
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(1715);
				match(OpenRoundBracket);
				setState(1716);
				ktype();
				setState(1717);
				match(Comma);
				setState(1718);
				comma_types();
				setState(1719);
				match(CloseRoundBracket);
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(1721);
				match(OpenBoxParen);
				setState(1722);
				match(CloseBoxParen);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(1723);
				match(OpenBoxParen);
				setState(1724);
				comma_types();
				setState(1725);
				match(CloseBoxParen);
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(1727);
				match(OpenBoxParen);
				setState(1728);
				bar_types2();
				setState(1729);
				match(CloseBoxParen);
				}
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				{
				setState(1731);
				match(OpenSquareBracket);
				setState(1732);
				ktype();
				setState(1733);
				match(CloseSquareBracket);
				}
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				{
				setState(1735);
				match(OpenRoundBracket);
				setState(1736);
				ktype();
				setState(1737);
				match(CloseRoundBracket);
				}
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1739);
				quasiquote();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1740);
				splice_untyped();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				{
				setState(1741);
				match(Quote);
				setState(1742);
				qcon_nowiredlist();
				}
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				{
				setState(1743);
				match(Quote);
				setState(1744);
				match(OpenRoundBracket);
				setState(1745);
				ktype();
				setState(1746);
				match(Comma);
				setState(1747);
				comma_types();
				setState(1748);
				match(CloseRoundBracket);
				}
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				{
				setState(1750);
				match(Quote);
				setState(1751);
				match(OpenSquareBracket);
				setState(1753);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << FORALL) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (Hash - 82)) | (1L << (Less - 82)) | (1L << (Greater - 82)) | (1L << (Ampersand - 82)) | (1L << (Pipe - 82)) | (1L << (Bang - 82)) | (1L << (Caret - 82)) | (1L << (Plus - 82)) | (1L << (Minus - 82)) | (1L << (Asterisk - 82)) | (1L << (Percent - 82)) | (1L << (Divide - 82)) | (1L << (Tilde - 82)) | (1L << (Atsign - 82)) | (1L << (Dollar - 82)) | (1L << (Dot - 82)) | (1L << (QuestionMark - 82)) | (1L << (Colon - 82)) | (1L << (Eq - 82)) | (1L << (Quote - 82)) | (1L << (ReverseSlash - 82)) | (1L << (BackQuote - 82)) | (1L << (OpenBoxParen - 82)) | (1L << (OpenRoundBracket - 82)) | (1L << (OpenSquareBracket - 82)) | (1L << (STRING - 82)) | (1L << (VARID - 82)) | (1L << (CONID - 82)) | (1L << (OpenPragmaBracket - 82)) | (1L << (OCURLY - 82)) | (1L << (DECIMAL - 82)) | (1L << (OCTAL - 82)) | (1L << (HEXADECIMAL - 82)))) != 0)) {
					{
					setState(1752);
					comma_types();
					}
				}

				setState(1755);
				match(CloseSquareBracket);
				}
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				{
				setState(1756);
				match(Quote);
				setState(1757);
				var_();
				}
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				{
				setState(1758);
				match(OpenSquareBracket);
				setState(1759);
				ktype();
				setState(1760);
				match(Comma);
				setState(1761);
				comma_types();
				setState(1762);
				match(CloseSquareBracket);
				}
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(1764);
				integer();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(1765);
				pstring();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(1766);
				match(WILDCARD);
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

	public static class Inst_typeContext extends ParserRuleContext {
		public SigtypeContext sigtype() {
			return getRuleContext(SigtypeContext.class,0);
		}
		public Inst_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst_type; }
	}

	public final Inst_typeContext inst_type() throws RecognitionException {
		Inst_typeContext _localctx = new Inst_typeContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_inst_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1769);
			sigtype();
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

	public static class Deriv_typesContext extends ParserRuleContext {
		public List<KtypedocContext> ktypedoc() {
			return getRuleContexts(KtypedocContext.class);
		}
		public KtypedocContext ktypedoc(int i) {
			return getRuleContext(KtypedocContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public Deriv_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deriv_types; }
	}

	public final Deriv_typesContext deriv_types() throws RecognitionException {
		Deriv_typesContext _localctx = new Deriv_typesContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_deriv_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1771);
			ktypedoc();
			setState(1776);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1772);
				match(Comma);
				setState(1773);
				ktypedoc();
				}
				}
				setState(1778);
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

	public static class Comma_typesContext extends ParserRuleContext {
		public List<KtypeContext> ktype() {
			return getRuleContexts(KtypeContext.class);
		}
		public KtypeContext ktype(int i) {
			return getRuleContext(KtypeContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public Comma_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comma_types; }
	}

	public final Comma_typesContext comma_types() throws RecognitionException {
		Comma_typesContext _localctx = new Comma_typesContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_comma_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1779);
			ktype();
			setState(1784);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1780);
				match(Comma);
				setState(1781);
				ktype();
				}
				}
				setState(1786);
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

	public static class Bar_types2Context extends ParserRuleContext {
		public List<KtypeContext> ktype() {
			return getRuleContexts(KtypeContext.class);
		}
		public KtypeContext ktype(int i) {
			return getRuleContext(KtypeContext.class,i);
		}
		public List<TerminalNode> Pipe() { return getTokens(HaskellParser.Pipe); }
		public TerminalNode Pipe(int i) {
			return getToken(HaskellParser.Pipe, i);
		}
		public Bar_types2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bar_types2; }
	}

	public final Bar_types2Context bar_types2() throws RecognitionException {
		Bar_types2Context _localctx = new Bar_types2Context(_ctx, getState());
		enterRule(_localctx, 226, RULE_bar_types2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1787);
			ktype();
			setState(1788);
			match(Pipe);
			setState(1789);
			ktype();
			setState(1794);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Pipe) {
				{
				{
				setState(1790);
				match(Pipe);
				setState(1791);
				ktype();
				}
				}
				setState(1796);
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

	public static class Tv_bndrsContext extends ParserRuleContext {
		public List<Tv_bndrContext> tv_bndr() {
			return getRuleContexts(Tv_bndrContext.class);
		}
		public Tv_bndrContext tv_bndr(int i) {
			return getRuleContext(Tv_bndrContext.class,i);
		}
		public Tv_bndrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tv_bndrs; }
	}

	public final Tv_bndrsContext tv_bndrs() throws RecognitionException {
		Tv_bndrsContext _localctx = new Tv_bndrsContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_tv_bndrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1798); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1797);
				tv_bndr();
				}
				}
				setState(1800); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (OCURLY - 120)))) != 0) );
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

	public static class Tv_bndrContext extends ParserRuleContext {
		public Tv_bndr_no_bracesContext tv_bndr_no_braces() {
			return getRuleContext(Tv_bndr_no_bracesContext.class,0);
		}
		public TerminalNode OCURLY() { return getToken(HaskellParser.OCURLY, 0); }
		public TyvarContext tyvar() {
			return getRuleContext(TyvarContext.class,0);
		}
		public TerminalNode CCURLY() { return getToken(HaskellParser.CCURLY, 0); }
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public KindContext kind() {
			return getRuleContext(KindContext.class,0);
		}
		public Tv_bndrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tv_bndr; }
	}

	public final Tv_bndrContext tv_bndr() throws RecognitionException {
		Tv_bndrContext _localctx = new Tv_bndrContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_tv_bndr);
		try {
			setState(1813);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1802);
				tv_bndr_no_braces();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1803);
				match(OCURLY);
				setState(1804);
				tyvar();
				setState(1805);
				match(CCURLY);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1807);
				match(OCURLY);
				setState(1808);
				tyvar();
				setState(1809);
				match(DoubleColon);
				setState(1810);
				kind();
				setState(1811);
				match(CCURLY);
				}
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

	public static class Tv_bndr_no_bracesContext extends ParserRuleContext {
		public TyvarContext tyvar() {
			return getRuleContext(TyvarContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public KindContext kind() {
			return getRuleContext(KindContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public Tv_bndr_no_bracesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tv_bndr_no_braces; }
	}

	public final Tv_bndr_no_bracesContext tv_bndr_no_braces() throws RecognitionException {
		Tv_bndr_no_bracesContext _localctx = new Tv_bndr_no_bracesContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_tv_bndr_no_braces);
		try {
			setState(1822);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AS:
			case HIDING:
			case QUALIFIED:
			case EXPORT:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case VARID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1815);
				tyvar();
				}
				break;
			case OpenRoundBracket:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1816);
				match(OpenRoundBracket);
				setState(1817);
				tyvar();
				setState(1818);
				match(DoubleColon);
				setState(1819);
				kind();
				setState(1820);
				match(CloseRoundBracket);
				}
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

	public static class FdsContext extends ParserRuleContext {
		public TerminalNode Pipe() { return getToken(HaskellParser.Pipe, 0); }
		public Fds1Context fds1() {
			return getRuleContext(Fds1Context.class,0);
		}
		public FdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fds; }
	}

	public final FdsContext fds() throws RecognitionException {
		FdsContext _localctx = new FdsContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_fds);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1824);
			match(Pipe);
			setState(1825);
			fds1();
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

	public static class Fds1Context extends ParserRuleContext {
		public List<FdContext> fd() {
			return getRuleContexts(FdContext.class);
		}
		public FdContext fd(int i) {
			return getRuleContext(FdContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public Fds1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fds1; }
	}

	public final Fds1Context fds1() throws RecognitionException {
		Fds1Context _localctx = new Fds1Context(_ctx, getState());
		enterRule(_localctx, 236, RULE_fds1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1827);
			fd();
			setState(1832);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1828);
				match(Comma);
				setState(1829);
				fd();
				}
				}
				setState(1834);
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

	public static class FdContext extends ParserRuleContext {
		public TerminalNode Arrow() { return getToken(HaskellParser.Arrow, 0); }
		public List<Varids0Context> varids0() {
			return getRuleContexts(Varids0Context.class);
		}
		public Varids0Context varids0(int i) {
			return getRuleContext(Varids0Context.class,i);
		}
		public FdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fd; }
	}

	public final FdContext fd() throws RecognitionException {
		FdContext _localctx = new FdContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_fd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1836);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==VARID) {
				{
				setState(1835);
				varids0();
				}
			}

			setState(1838);
			match(Arrow);
			setState(1840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==VARID) {
				{
				setState(1839);
				varids0();
				}
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

	public static class Varids0Context extends ParserRuleContext {
		public List<TyvarContext> tyvar() {
			return getRuleContexts(TyvarContext.class);
		}
		public TyvarContext tyvar(int i) {
			return getRuleContext(TyvarContext.class,i);
		}
		public Varids0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varids0; }
	}

	public final Varids0Context varids0() throws RecognitionException {
		Varids0Context _localctx = new Varids0Context(_ctx, getState());
		enterRule(_localctx, 240, RULE_varids0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1843); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1842);
				tyvar();
				}
				}
				setState(1845); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || _la==VARID );
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

	public static class KindContext extends ParserRuleContext {
		public CtypeContext ctype() {
			return getRuleContext(CtypeContext.class,0);
		}
		public KindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kind; }
	}

	public final KindContext kind() throws RecognitionException {
		KindContext _localctx = new KindContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_kind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1847);
			ctype();
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

	public static class Gadt_constrlistContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(HaskellParser.WHERE, 0); }
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public Gadt_constrsContext gadt_constrs() {
			return getRuleContext(Gadt_constrsContext.class,0);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public Gadt_constrlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gadt_constrlist; }
	}

	public final Gadt_constrlistContext gadt_constrlist() throws RecognitionException {
		Gadt_constrlistContext _localctx = new Gadt_constrlistContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_gadt_constrlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1849);
			match(WHERE);
			setState(1850);
			open_();
			setState(1852);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (OpenBoxParen - 118)) | (1L << (OpenRoundBracket - 118)) | (1L << (OpenSquareBracket - 118)) | (1L << (CONID - 118)))) != 0)) {
				{
				setState(1851);
				gadt_constrs();
				}
			}

			setState(1857);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semi || _la==SEMI) {
				{
				{
				setState(1854);
				semi();
				}
				}
				setState(1859);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1860);
			close();
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

	public static class Gadt_constrsContext extends ParserRuleContext {
		public List<Gadt_constr_with_docContext> gadt_constr_with_doc() {
			return getRuleContexts(Gadt_constr_with_docContext.class);
		}
		public Gadt_constr_with_docContext gadt_constr_with_doc(int i) {
			return getRuleContext(Gadt_constr_with_docContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public Gadt_constrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gadt_constrs; }
	}

	public final Gadt_constrsContext gadt_constrs() throws RecognitionException {
		Gadt_constrsContext _localctx = new Gadt_constrsContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_gadt_constrs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1862);
			gadt_constr_with_doc();
			setState(1868);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1863);
					semi();
					setState(1864);
					gadt_constr_with_doc();
					}
					} 
				}
				setState(1870);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
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

	public static class Gadt_constr_with_docContext extends ParserRuleContext {
		public Gadt_constrContext gadt_constr() {
			return getRuleContext(Gadt_constrContext.class,0);
		}
		public Gadt_constr_with_docContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gadt_constr_with_doc; }
	}

	public final Gadt_constr_with_docContext gadt_constr_with_doc() throws RecognitionException {
		Gadt_constr_with_docContext _localctx = new Gadt_constr_with_docContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_gadt_constr_with_doc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1871);
			gadt_constr();
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

	public static class Gadt_constrContext extends ParserRuleContext {
		public Con_listContext con_list() {
			return getRuleContext(Con_listContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public SigtypedocContext sigtypedoc() {
			return getRuleContext(SigtypedocContext.class,0);
		}
		public Gadt_constrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gadt_constr; }
	}

	public final Gadt_constrContext gadt_constr() throws RecognitionException {
		Gadt_constrContext _localctx = new Gadt_constrContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_gadt_constr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1873);
			con_list();
			setState(1874);
			match(DoubleColon);
			setState(1875);
			sigtypedoc();
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

	public static class ConstrsContext extends ParserRuleContext {
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public Constrs1Context constrs1() {
			return getRuleContext(Constrs1Context.class,0);
		}
		public ConstrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constrs; }
	}

	public final ConstrsContext constrs() throws RecognitionException {
		ConstrsContext _localctx = new ConstrsContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_constrs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1877);
			match(Eq);
			setState(1878);
			constrs1();
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

	public static class Constrs1Context extends ParserRuleContext {
		public List<ConstrContext> constr() {
			return getRuleContexts(ConstrContext.class);
		}
		public ConstrContext constr(int i) {
			return getRuleContext(ConstrContext.class,i);
		}
		public List<TerminalNode> Pipe() { return getTokens(HaskellParser.Pipe); }
		public TerminalNode Pipe(int i) {
			return getToken(HaskellParser.Pipe, i);
		}
		public Constrs1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constrs1; }
	}

	public final Constrs1Context constrs1() throws RecognitionException {
		Constrs1Context _localctx = new Constrs1Context(_ctx, getState());
		enterRule(_localctx, 254, RULE_constrs1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1880);
			constr();
			setState(1885);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Pipe) {
				{
				{
				setState(1881);
				match(Pipe);
				setState(1882);
				constr();
				}
				}
				setState(1887);
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

	public static class ConstrContext extends ParserRuleContext {
		public Constr_stuffContext constr_stuff() {
			return getRuleContext(Constr_stuffContext.class,0);
		}
		public ForallContext forall() {
			return getRuleContext(ForallContext.class,0);
		}
		public Constr_contextContext constr_context() {
			return getRuleContext(Constr_contextContext.class,0);
		}
		public TerminalNode DoubleArrow() { return getToken(HaskellParser.DoubleArrow, 0); }
		public ConstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr; }
	}

	public final ConstrContext constr() throws RecognitionException {
		ConstrContext _localctx = new ConstrContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_constr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1889);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FORALL) {
				{
				setState(1888);
				forall();
				}
			}

			setState(1894);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				{
				setState(1891);
				constr_context();
				setState(1892);
				match(DoubleArrow);
				}
				break;
			}
			setState(1896);
			constr_stuff();
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

	public static class ForallContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(HaskellParser.FORALL, 0); }
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public Tv_bndrsContext tv_bndrs() {
			return getRuleContext(Tv_bndrsContext.class,0);
		}
		public ForallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forall; }
	}

	public final ForallContext forall() throws RecognitionException {
		ForallContext _localctx = new ForallContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_forall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1898);
			match(FORALL);
			setState(1900);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (OpenRoundBracket - 120)) | (1L << (VARID - 120)) | (1L << (OCURLY - 120)))) != 0)) {
				{
				setState(1899);
				tv_bndrs();
				}
			}

			setState(1902);
			match(Dot);
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

	public static class Constr_stuffContext extends ParserRuleContext {
		public Constr_tyappsContext constr_tyapps() {
			return getRuleContext(Constr_tyappsContext.class,0);
		}
		public Constr_stuffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr_stuff; }
	}

	public final Constr_stuffContext constr_stuff() throws RecognitionException {
		Constr_stuffContext _localctx = new Constr_stuffContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_constr_stuff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1904);
			constr_tyapps();
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

	public static class FielddeclsContext extends ParserRuleContext {
		public List<FielddeclContext> fielddecl() {
			return getRuleContexts(FielddeclContext.class);
		}
		public FielddeclContext fielddecl(int i) {
			return getRuleContext(FielddeclContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public FielddeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fielddecls; }
	}

	public final FielddeclsContext fielddecls() throws RecognitionException {
		FielddeclsContext _localctx = new FielddeclsContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_fielddecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1906);
			fielddecl();
			setState(1911);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1907);
				match(Comma);
				setState(1908);
				fielddecl();
				}
				}
				setState(1913);
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

	public static class FielddeclContext extends ParserRuleContext {
		public Sig_varsContext sig_vars() {
			return getRuleContext(Sig_varsContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public CtypeContext ctype() {
			return getRuleContext(CtypeContext.class,0);
		}
		public FielddeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fielddecl; }
	}

	public final FielddeclContext fielddecl() throws RecognitionException {
		FielddeclContext _localctx = new FielddeclContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_fielddecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1914);
			sig_vars();
			setState(1915);
			match(DoubleColon);
			setState(1916);
			ctype();
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

	public static class DerivingsContext extends ParserRuleContext {
		public List<DerivingContext> deriving() {
			return getRuleContexts(DerivingContext.class);
		}
		public DerivingContext deriving(int i) {
			return getRuleContext(DerivingContext.class,i);
		}
		public DerivingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derivings; }
	}

	public final DerivingsContext derivings() throws RecognitionException {
		DerivingsContext _localctx = new DerivingsContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_derivings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1919); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1918);
				deriving();
				}
				}
				setState(1921); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DERIVING );
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

	public static class DerivingContext extends ParserRuleContext {
		public TerminalNode DERIVING() { return getToken(HaskellParser.DERIVING, 0); }
		public Deriv_clause_typesContext deriv_clause_types() {
			return getRuleContext(Deriv_clause_typesContext.class,0);
		}
		public Deriv_strategy_no_viaContext deriv_strategy_no_via() {
			return getRuleContext(Deriv_strategy_no_viaContext.class,0);
		}
		public Deriv_strategy_viaContext deriv_strategy_via() {
			return getRuleContext(Deriv_strategy_viaContext.class,0);
		}
		public DerivingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deriving; }
	}

	public final DerivingContext deriving() throws RecognitionException {
		DerivingContext _localctx = new DerivingContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_deriving);
		try {
			setState(1933);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1923);
				match(DERIVING);
				setState(1924);
				deriv_clause_types();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1925);
				match(DERIVING);
				setState(1926);
				deriv_strategy_no_via();
				setState(1927);
				deriv_clause_types();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1929);
				match(DERIVING);
				setState(1930);
				deriv_clause_types();
				setState(1931);
				deriv_strategy_via();
				}
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

	public static class Deriv_clause_typesContext extends ParserRuleContext {
		public QtyconContext qtycon() {
			return getRuleContext(QtyconContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public Deriv_typesContext deriv_types() {
			return getRuleContext(Deriv_typesContext.class,0);
		}
		public Deriv_clause_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deriv_clause_types; }
	}

	public final Deriv_clause_typesContext deriv_clause_types() throws RecognitionException {
		Deriv_clause_typesContext _localctx = new Deriv_clause_typesContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_deriv_clause_types);
		try {
			setState(1942);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1935);
				qtycon();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1936);
				match(OpenRoundBracket);
				setState(1937);
				match(CloseRoundBracket);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1938);
				match(OpenRoundBracket);
				setState(1939);
				deriv_types();
				setState(1940);
				match(CloseRoundBracket);
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

	public static class Decl_no_thContext extends ParserRuleContext {
		public SigdeclContext sigdecl() {
			return getRuleContext(SigdeclContext.class,0);
		}
		public InfixexpContext infixexp() {
			return getRuleContext(InfixexpContext.class,0);
		}
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public Opt_sigContext opt_sig() {
			return getRuleContext(Opt_sigContext.class,0);
		}
		public Pattern_synonym_declContext pattern_synonym_decl() {
			return getRuleContext(Pattern_synonym_declContext.class,0);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public Decl_no_thContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_no_th; }
	}

	public final Decl_no_thContext decl_no_th() throws RecognitionException {
		Decl_no_thContext _localctx = new Decl_no_thContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_decl_no_th);
		int _la;
		try {
			int _alt;
			setState(1957);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1944);
				sigdecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1945);
				infixexp();
				setState(1947);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon) {
					{
					setState(1946);
					opt_sig();
					}
				}

				setState(1949);
				rhs();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1951);
				pattern_synonym_decl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1953); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1952);
						semi();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1955); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,224,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class DeclContext extends ParserRuleContext {
		public Decl_no_thContext decl_no_th() {
			return getRuleContext(Decl_no_thContext.class,0);
		}
		public Splice_expContext splice_exp() {
			return getRuleContext(Splice_expContext.class,0);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_decl);
		try {
			int _alt;
			setState(1966);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,227,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1959);
				decl_no_th();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1960);
				splice_exp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1962); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1961);
						semi();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1964); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,226,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class RhsContext extends ParserRuleContext {
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public WherebindsContext wherebinds() {
			return getRuleContext(WherebindsContext.class,0);
		}
		public GdrhsContext gdrhs() {
			return getRuleContext(GdrhsContext.class,0);
		}
		public RhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhs; }
	}

	public final RhsContext rhs() throws RecognitionException {
		RhsContext _localctx = new RhsContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_rhs);
		int _la;
		try {
			setState(1977);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Eq:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1968);
				match(Eq);
				setState(1969);
				exp();
				setState(1971);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1970);
					wherebinds();
					}
				}

				}
				}
				break;
			case Pipe:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1973);
				gdrhs();
				setState(1975);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(1974);
					wherebinds();
					}
				}

				}
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

	public static class GdrhsContext extends ParserRuleContext {
		public List<GdrhContext> gdrh() {
			return getRuleContexts(GdrhContext.class);
		}
		public GdrhContext gdrh(int i) {
			return getRuleContext(GdrhContext.class,i);
		}
		public GdrhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gdrhs; }
	}

	public final GdrhsContext gdrhs() throws RecognitionException {
		GdrhsContext _localctx = new GdrhsContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_gdrhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1980); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1979);
				gdrh();
				}
				}
				setState(1982); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Pipe );
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

	public static class GdrhContext extends ParserRuleContext {
		public TerminalNode Pipe() { return getToken(HaskellParser.Pipe, 0); }
		public GuardsContext guards() {
			return getRuleContext(GuardsContext.class,0);
		}
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public GdrhContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gdrh; }
	}

	public final GdrhContext gdrh() throws RecognitionException {
		GdrhContext _localctx = new GdrhContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_gdrh);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1984);
			match(Pipe);
			setState(1985);
			guards();
			setState(1986);
			match(Eq);
			setState(1987);
			exp();
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

	public static class SigdeclContext extends ParserRuleContext {
		public InfixexpContext infixexp() {
			return getRuleContext(InfixexpContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public SigtypedocContext sigtypedoc() {
			return getRuleContext(SigtypedocContext.class,0);
		}
		public Var_Context var_() {
			return getRuleContext(Var_Context.class,0);
		}
		public TerminalNode Comma() { return getToken(HaskellParser.Comma, 0); }
		public Sig_varsContext sig_vars() {
			return getRuleContext(Sig_varsContext.class,0);
		}
		public FixityContext fixity() {
			return getRuleContext(FixityContext.class,0);
		}
		public OpsContext ops() {
			return getRuleContext(OpsContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public Pattern_synonym_sigContext pattern_synonym_sig() {
			return getRuleContext(Pattern_synonym_sigContext.class,0);
		}
		public TerminalNode OpenPragmaBracket() { return getToken(HaskellParser.OpenPragmaBracket, 0); }
		public TerminalNode COMPLETE() { return getToken(HaskellParser.COMPLETE, 0); }
		public Con_listContext con_list() {
			return getRuleContext(Con_listContext.class,0);
		}
		public List<TerminalNode> ClosePragmaBracket() { return getTokens(HaskellParser.ClosePragmaBracket); }
		public TerminalNode ClosePragmaBracket(int i) {
			return getToken(HaskellParser.ClosePragmaBracket, i);
		}
		public Opt_tyconsigContext opt_tyconsig() {
			return getRuleContext(Opt_tyconsigContext.class,0);
		}
		public TerminalNode INLINE() { return getToken(HaskellParser.INLINE, 0); }
		public QvarContext qvar() {
			return getRuleContext(QvarContext.class,0);
		}
		public ActivationContext activation() {
			return getRuleContext(ActivationContext.class,0);
		}
		public TerminalNode SCC() { return getToken(HaskellParser.SCC, 0); }
		public PstringContext pstring() {
			return getRuleContext(PstringContext.class,0);
		}
		public TerminalNode SPECIALISE() { return getToken(HaskellParser.SPECIALISE, 0); }
		public Sigtypes1Context sigtypes1() {
			return getRuleContext(Sigtypes1Context.class,0);
		}
		public TerminalNode SPECINLINE() { return getToken(HaskellParser.SPECINLINE, 0); }
		public TerminalNode INSTANCE() { return getToken(HaskellParser.INSTANCE, 0); }
		public Inst_typeContext inst_type() {
			return getRuleContext(Inst_typeContext.class,0);
		}
		public TerminalNode MINIMAL() { return getToken(HaskellParser.MINIMAL, 0); }
		public Name_boolformula_optContext name_boolformula_opt() {
			return getRuleContext(Name_boolformula_optContext.class,0);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public SigdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sigdecl; }
	}

	public final SigdeclContext sigdecl() throws RecognitionException {
		SigdeclContext _localctx = new SigdeclContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_sigdecl);
		int _la;
		try {
			int _alt;
			setState(2068);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1989);
				infixexp();
				setState(1990);
				match(DoubleColon);
				setState(1991);
				sigtypedoc();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1993);
				var_();
				setState(1994);
				match(Comma);
				setState(1995);
				sig_vars();
				setState(1996);
				match(DoubleColon);
				setState(1997);
				sigtypedoc();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1999);
				fixity();
				setState(2001);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)))) != 0)) {
					{
					setState(2000);
					integer();
					}
				}

				setState(2003);
				ops();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(2005);
				pattern_synonym_sig();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(2006);
				match(OpenPragmaBracket);
				setState(2007);
				match(COMPLETE);
				setState(2008);
				con_list();
				setState(2010);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleColon) {
					{
					setState(2009);
					opt_tyconsig();
					}
				}

				setState(2012);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(2014);
				match(OpenPragmaBracket);
				setState(2015);
				match(INLINE);
				setState(2017);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OpenSquareBracket) {
					{
					setState(2016);
					activation();
					}
				}

				setState(2019);
				qvar();
				setState(2020);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(2022);
				match(OpenPragmaBracket);
				setState(2023);
				match(SCC);
				setState(2024);
				qvar();
				setState(2026);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(2025);
					pstring();
					}
				}

				setState(2028);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(2030);
				match(OpenPragmaBracket);
				setState(2031);
				match(SPECIALISE);
				setState(2033);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OpenSquareBracket) {
					{
					setState(2032);
					activation();
					}
				}

				setState(2035);
				qvar();
				setState(2036);
				match(DoubleColon);
				setState(2037);
				sigtypes1();
				setState(2038);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(2040);
				match(OpenPragmaBracket);
				setState(2041);
				match(SPECINLINE);
				setState(2043);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OpenSquareBracket) {
					{
					setState(2042);
					activation();
					}
				}

				setState(2045);
				qvar();
				setState(2046);
				match(DoubleColon);
				setState(2047);
				sigtypes1();
				setState(2048);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(2050);
				match(OpenPragmaBracket);
				setState(2051);
				match(SPECIALISE);
				setState(2052);
				match(INSTANCE);
				setState(2053);
				inst_type();
				setState(2054);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(2056);
				match(OpenPragmaBracket);
				setState(2057);
				match(MINIMAL);
				setState(2058);
				match(ClosePragmaBracket);
				setState(2060);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (OpenBoxParen - 118)) | (1L << (OpenRoundBracket - 118)) | (1L << (OpenSquareBracket - 118)) | (1L << (VARID - 118)) | (1L << (CONID - 118)))) != 0)) {
					{
					setState(2059);
					name_boolformula_opt();
					}
				}

				setState(2062);
				match(ClosePragmaBracket);
				}
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				{
				setState(2064); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2063);
						semi();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2066); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
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

	public static class ActivationContext extends ParserRuleContext {
		public TerminalNode OpenSquareBracket() { return getToken(HaskellParser.OpenSquareBracket, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode CloseSquareBracket() { return getToken(HaskellParser.CloseSquareBracket, 0); }
		public Rule_activation_markerContext rule_activation_marker() {
			return getRuleContext(Rule_activation_markerContext.class,0);
		}
		public ActivationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_activation; }
	}

	public final ActivationContext activation() throws RecognitionException {
		ActivationContext _localctx = new ActivationContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_activation);
		try {
			setState(2079);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,241,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(2070);
				match(OpenSquareBracket);
				setState(2071);
				integer();
				setState(2072);
				match(CloseSquareBracket);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2074);
				match(OpenSquareBracket);
				setState(2075);
				rule_activation_marker();
				setState(2076);
				integer();
				setState(2077);
				match(CloseSquareBracket);
				}
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

	public static class Th_quasiquoteContext extends ParserRuleContext {
		public TerminalNode OpenSquareBracket() { return getToken(HaskellParser.OpenSquareBracket, 0); }
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public TerminalNode Pipe() { return getToken(HaskellParser.Pipe, 0); }
		public Th_quasiquoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_th_quasiquote; }
	}

	public final Th_quasiquoteContext th_quasiquote() throws RecognitionException {
		Th_quasiquoteContext _localctx = new Th_quasiquoteContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_th_quasiquote);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2081);
			match(OpenSquareBracket);
			setState(2082);
			varid();
			setState(2083);
			match(Pipe);
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

	public static class Th_qquasiquoteContext extends ParserRuleContext {
		public TerminalNode OpenSquareBracket() { return getToken(HaskellParser.OpenSquareBracket, 0); }
		public QvaridContext qvarid() {
			return getRuleContext(QvaridContext.class,0);
		}
		public TerminalNode Pipe() { return getToken(HaskellParser.Pipe, 0); }
		public Th_qquasiquoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_th_qquasiquote; }
	}

	public final Th_qquasiquoteContext th_qquasiquote() throws RecognitionException {
		Th_qquasiquoteContext _localctx = new Th_qquasiquoteContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_th_qquasiquote);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2085);
			match(OpenSquareBracket);
			setState(2086);
			qvarid();
			setState(2087);
			match(Pipe);
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

	public static class QuasiquoteContext extends ParserRuleContext {
		public Th_quasiquoteContext th_quasiquote() {
			return getRuleContext(Th_quasiquoteContext.class,0);
		}
		public Th_qquasiquoteContext th_qquasiquote() {
			return getRuleContext(Th_qquasiquoteContext.class,0);
		}
		public QuasiquoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quasiquote; }
	}

	public final QuasiquoteContext quasiquote() throws RecognitionException {
		QuasiquoteContext _localctx = new QuasiquoteContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_quasiquote);
		try {
			setState(2091);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2089);
				th_quasiquote();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2090);
				th_qquasiquote();
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

	public static class ExpContext extends ParserRuleContext {
		public InfixexpContext infixexp() {
			return getRuleContext(InfixexpContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(HaskellParser.DoubleColon, 0); }
		public SigtypeContext sigtype() {
			return getRuleContext(SigtypeContext.class,0);
		}
		public TerminalNode LarrowTail() { return getToken(HaskellParser.LarrowTail, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RarrowTail() { return getToken(HaskellParser.RarrowTail, 0); }
		public TerminalNode LLarrowTail() { return getToken(HaskellParser.LLarrowTail, 0); }
		public TerminalNode RRarrowTail() { return getToken(HaskellParser.RRarrowTail, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_exp);
		try {
			setState(2114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,243,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(2093);
				infixexp();
				setState(2094);
				match(DoubleColon);
				setState(2095);
				sigtype();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2097);
				infixexp();
				setState(2098);
				match(LarrowTail);
				setState(2099);
				exp();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(2101);
				infixexp();
				setState(2102);
				match(RarrowTail);
				setState(2103);
				exp();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(2105);
				infixexp();
				setState(2106);
				match(LLarrowTail);
				setState(2107);
				exp();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(2109);
				infixexp();
				setState(2110);
				match(RRarrowTail);
				setState(2111);
				exp();
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2113);
				infixexp();
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

	public static class InfixexpContext extends ParserRuleContext {
		public Exp10Context exp10() {
			return getRuleContext(Exp10Context.class,0);
		}
		public List<QopContext> qop() {
			return getRuleContexts(QopContext.class);
		}
		public QopContext qop(int i) {
			return getRuleContext(QopContext.class,i);
		}
		public List<Exp10pContext> exp10p() {
			return getRuleContexts(Exp10pContext.class);
		}
		public Exp10pContext exp10p(int i) {
			return getRuleContext(Exp10pContext.class,i);
		}
		public InfixexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixexp; }
	}

	public final InfixexpContext infixexp() throws RecognitionException {
		InfixexpContext _localctx = new InfixexpContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_infixexp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2116);
			exp10();
			setState(2122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,244,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2117);
					qop();
					setState(2118);
					exp10p();
					}
					} 
				}
				setState(2124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,244,_ctx);
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

	public static class Exp10pContext extends ParserRuleContext {
		public Exp10Context exp10() {
			return getRuleContext(Exp10Context.class,0);
		}
		public Exp10pContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp10p; }
	}

	public final Exp10pContext exp10p() throws RecognitionException {
		Exp10pContext _localctx = new Exp10pContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_exp10p);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2125);
			exp10();
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

	public static class Exp10Context extends ParserRuleContext {
		public FexpContext fexp() {
			return getRuleContext(FexpContext.class,0);
		}
		public TerminalNode Minus() { return getToken(HaskellParser.Minus, 0); }
		public Exp10Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp10; }
	}

	public final Exp10Context exp10() throws RecognitionException {
		Exp10Context _localctx = new Exp10Context(_ctx, getState());
		enterRule(_localctx, 298, RULE_exp10);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Minus) {
				{
				setState(2127);
				match(Minus);
				}
			}

			setState(2130);
			fexp();
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

	public static class FexpContext extends ParserRuleContext {
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public TerminalNode Atsign() { return getToken(HaskellParser.Atsign, 0); }
		public AtypeContext atype() {
			return getRuleContext(AtypeContext.class,0);
		}
		public FexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fexp; }
	}

	public final FexpContext fexp() throws RecognitionException {
		FexpContext _localctx = new FexpContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_fexp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2133); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2132);
					aexp();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2135); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,246,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(2139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,247,_ctx) ) {
			case 1:
				{
				setState(2137);
				match(Atsign);
				setState(2138);
				atype();
				}
				break;
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

	public static class AexpContext extends ParserRuleContext {
		public QvarContext qvar() {
			return getRuleContext(QvarContext.class,0);
		}
		public TerminalNode Atsign() { return getToken(HaskellParser.Atsign, 0); }
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public TerminalNode Tilde() { return getToken(HaskellParser.Tilde, 0); }
		public TerminalNode Bang() { return getToken(HaskellParser.Bang, 0); }
		public TerminalNode ReverseSlash() { return getToken(HaskellParser.ReverseSlash, 0); }
		public ApatsContext apats() {
			return getRuleContext(ApatsContext.class,0);
		}
		public TerminalNode Arrow() { return getToken(HaskellParser.Arrow, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LET() { return getToken(HaskellParser.LET, 0); }
		public DecllistContext decllist() {
			return getRuleContext(DecllistContext.class,0);
		}
		public TerminalNode IN() { return getToken(HaskellParser.IN, 0); }
		public TerminalNode LCASE() { return getToken(HaskellParser.LCASE, 0); }
		public AltsContext alts() {
			return getRuleContext(AltsContext.class,0);
		}
		public TerminalNode IF() { return getToken(HaskellParser.IF, 0); }
		public TerminalNode THEN() { return getToken(HaskellParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(HaskellParser.ELSE, 0); }
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public IfgdpatsContext ifgdpats() {
			return getRuleContext(IfgdpatsContext.class,0);
		}
		public TerminalNode CASE() { return getToken(HaskellParser.CASE, 0); }
		public TerminalNode OF() { return getToken(HaskellParser.OF, 0); }
		public TerminalNode DO() { return getToken(HaskellParser.DO, 0); }
		public StmtlistContext stmtlist() {
			return getRuleContext(StmtlistContext.class,0);
		}
		public TerminalNode MDO() { return getToken(HaskellParser.MDO, 0); }
		public Aexp1Context aexp1() {
			return getRuleContext(Aexp1Context.class,0);
		}
		public AexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexp; }
	}

	public final AexpContext aexp() throws RecognitionException {
		AexpContext _localctx = new AexpContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_aexp);
		int _la;
		try {
			setState(2186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(2141);
				qvar();
				setState(2142);
				match(Atsign);
				setState(2143);
				aexp();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2145);
				match(Tilde);
				setState(2146);
				aexp();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(2147);
				match(Bang);
				setState(2148);
				aexp();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(2149);
				match(ReverseSlash);
				setState(2150);
				apats();
				setState(2151);
				match(Arrow);
				setState(2152);
				exp();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(2154);
				match(LET);
				setState(2155);
				decllist();
				setState(2156);
				match(IN);
				setState(2157);
				exp();
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(2159);
				match(LCASE);
				setState(2160);
				alts();
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(2161);
				match(IF);
				setState(2162);
				exp();
				setState(2164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Semi || _la==SEMI) {
					{
					setState(2163);
					semi();
					}
				}

				setState(2166);
				match(THEN);
				setState(2167);
				exp();
				setState(2169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Semi || _la==SEMI) {
					{
					setState(2168);
					semi();
					}
				}

				setState(2171);
				match(ELSE);
				setState(2172);
				exp();
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(2174);
				match(IF);
				setState(2175);
				ifgdpats();
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(2176);
				match(CASE);
				setState(2177);
				exp();
				setState(2178);
				match(OF);
				setState(2179);
				alts();
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(2181);
				match(DO);
				setState(2182);
				stmtlist();
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(2183);
				match(MDO);
				setState(2184);
				stmtlist();
				}
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2185);
				aexp1();
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

	public static class Aexp1Context extends ParserRuleContext {
		public Aexp2Context aexp2() {
			return getRuleContext(Aexp2Context.class,0);
		}
		public List<TerminalNode> OCURLY() { return getTokens(HaskellParser.OCURLY); }
		public TerminalNode OCURLY(int i) {
			return getToken(HaskellParser.OCURLY, i);
		}
		public List<TerminalNode> CCURLY() { return getTokens(HaskellParser.CCURLY); }
		public TerminalNode CCURLY(int i) {
			return getToken(HaskellParser.CCURLY, i);
		}
		public List<FbindsContext> fbinds() {
			return getRuleContexts(FbindsContext.class);
		}
		public FbindsContext fbinds(int i) {
			return getRuleContext(FbindsContext.class,i);
		}
		public Aexp1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexp1; }
	}

	public final Aexp1Context aexp1() throws RecognitionException {
		Aexp1Context _localctx = new Aexp1Context(_ctx, getState());
		enterRule(_localctx, 304, RULE_aexp1);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2188);
			aexp2();
			setState(2196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,252,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2189);
					match(OCURLY);
					setState(2191);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (DoubleDot - 98)) | (1L << (OpenRoundBracket - 98)) | (1L << (VARID - 98)) | (1L << (CONID - 98)))) != 0)) {
						{
						setState(2190);
						fbinds();
						}
					}

					setState(2193);
					match(CCURLY);
					}
					} 
				}
				setState(2198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,252,_ctx);
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

	public static class Aexp2Context extends ParserRuleContext {
		public QvarContext qvar() {
			return getRuleContext(QvarContext.class,0);
		}
		public QconContext qcon() {
			return getRuleContext(QconContext.class,0);
		}
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PstringContext pstring() {
			return getRuleContext(PstringContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public PfloatContext pfloat() {
			return getRuleContext(PfloatContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TexpContext texp() {
			return getRuleContext(TexpContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public Tup_exprsContext tup_exprs() {
			return getRuleContext(Tup_exprsContext.class,0);
		}
		public TerminalNode OpenBoxParen() { return getToken(HaskellParser.OpenBoxParen, 0); }
		public TerminalNode CloseBoxParen() { return getToken(HaskellParser.CloseBoxParen, 0); }
		public TerminalNode OpenSquareBracket() { return getToken(HaskellParser.OpenSquareBracket, 0); }
		public List_Context list_() {
			return getRuleContext(List_Context.class,0);
		}
		public TerminalNode CloseSquareBracket() { return getToken(HaskellParser.CloseSquareBracket, 0); }
		public TerminalNode WILDCARD() { return getToken(HaskellParser.WILDCARD, 0); }
		public Splice_untypedContext splice_untyped() {
			return getRuleContext(Splice_untypedContext.class,0);
		}
		public Splice_typedContext splice_typed() {
			return getRuleContext(Splice_typedContext.class,0);
		}
		public TerminalNode Quote() { return getToken(HaskellParser.Quote, 0); }
		public TerminalNode DoubleQuote() { return getToken(HaskellParser.DoubleQuote, 0); }
		public TyvarContext tyvar() {
			return getRuleContext(TyvarContext.class,0);
		}
		public GtyconContext gtycon() {
			return getRuleContext(GtyconContext.class,0);
		}
		public TerminalNode TopenExpQuote() { return getToken(HaskellParser.TopenExpQuote, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TcloseQoute() { return getToken(HaskellParser.TcloseQoute, 0); }
		public TerminalNode TopenTexpQuote() { return getToken(HaskellParser.TopenTexpQuote, 0); }
		public TerminalNode TcloseTExpQoute() { return getToken(HaskellParser.TcloseTExpQoute, 0); }
		public TerminalNode TopenTypQoute() { return getToken(HaskellParser.TopenTypQoute, 0); }
		public KtypeContext ktype() {
			return getRuleContext(KtypeContext.class,0);
		}
		public TerminalNode TopenPatQuote() { return getToken(HaskellParser.TopenPatQuote, 0); }
		public InfixexpContext infixexp() {
			return getRuleContext(InfixexpContext.class,0);
		}
		public TerminalNode TopenDecQoute() { return getToken(HaskellParser.TopenDecQoute, 0); }
		public CvtopbodyContext cvtopbody() {
			return getRuleContext(CvtopbodyContext.class,0);
		}
		public QuasiquoteContext quasiquote() {
			return getRuleContext(QuasiquoteContext.class,0);
		}
		public List<TerminalNode> AopenParen() { return getTokens(HaskellParser.AopenParen); }
		public TerminalNode AopenParen(int i) {
			return getToken(HaskellParser.AopenParen, i);
		}
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public CmdargsContext cmdargs() {
			return getRuleContext(CmdargsContext.class,0);
		}
		public Aexp2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexp2; }
	}

	public final Aexp2Context aexp2() throws RecognitionException {
		Aexp2Context _localctx = new Aexp2Context(_ctx, getState());
		enterRule(_localctx, 306, RULE_aexp2);
		try {
			setState(2266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,254,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2199);
				qvar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2200);
				qcon();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2201);
				varid();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2202);
				literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2203);
				pstring();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2204);
				integer();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2205);
				pfloat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(2206);
				match(OpenRoundBracket);
				setState(2207);
				texp();
				setState(2208);
				match(CloseRoundBracket);
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(2210);
				match(OpenRoundBracket);
				setState(2211);
				tup_exprs();
				setState(2212);
				match(CloseRoundBracket);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(2214);
				match(OpenBoxParen);
				setState(2215);
				texp();
				setState(2216);
				match(CloseBoxParen);
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(2218);
				match(OpenBoxParen);
				setState(2219);
				tup_exprs();
				setState(2220);
				match(CloseBoxParen);
				}
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				{
				setState(2222);
				match(OpenSquareBracket);
				setState(2223);
				list_();
				setState(2224);
				match(CloseSquareBracket);
				}
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(2226);
				match(WILDCARD);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(2227);
				splice_untyped();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(2228);
				splice_typed();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				{
				setState(2229);
				match(Quote);
				setState(2230);
				qvar();
				}
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				{
				setState(2231);
				match(Quote);
				setState(2232);
				qcon();
				}
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				{
				setState(2233);
				match(DoubleQuote);
				setState(2234);
				tyvar();
				}
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				{
				setState(2235);
				match(DoubleQuote);
				setState(2236);
				gtycon();
				}
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(2237);
				match(DoubleQuote);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(2238);
				match(TopenExpQuote);
				setState(2239);
				exp();
				setState(2240);
				match(TcloseQoute);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(2242);
				match(TopenTexpQuote);
				setState(2243);
				exp();
				setState(2244);
				match(TcloseTExpQoute);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(2246);
				match(TopenTypQoute);
				setState(2247);
				ktype();
				setState(2248);
				match(TcloseQoute);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(2250);
				match(TopenPatQuote);
				setState(2251);
				infixexp();
				setState(2252);
				match(TcloseQoute);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(2254);
				match(TopenDecQoute);
				setState(2255);
				cvtopbody();
				setState(2256);
				match(TcloseQoute);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(2258);
				quasiquote();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				{
				setState(2259);
				match(AopenParen);
				setState(2260);
				aexp();
				setState(2262);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
				case 1:
					{
					setState(2261);
					cmdargs();
					}
					break;
				}
				setState(2264);
				match(AopenParen);
				}
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

	public static class Splice_expContext extends ParserRuleContext {
		public Splice_typedContext splice_typed() {
			return getRuleContext(Splice_typedContext.class,0);
		}
		public Splice_untypedContext splice_untyped() {
			return getRuleContext(Splice_untypedContext.class,0);
		}
		public Splice_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splice_exp; }
	}

	public final Splice_expContext splice_exp() throws RecognitionException {
		Splice_expContext _localctx = new Splice_expContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_splice_exp);
		try {
			setState(2270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DDollar:
				enterOuterAlt(_localctx, 1);
				{
				setState(2268);
				splice_typed();
				}
				break;
			case Dollar:
				enterOuterAlt(_localctx, 2);
				{
				setState(2269);
				splice_untyped();
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

	public static class Splice_untypedContext extends ParserRuleContext {
		public TerminalNode Dollar() { return getToken(HaskellParser.Dollar, 0); }
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public Splice_untypedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splice_untyped; }
	}

	public final Splice_untypedContext splice_untyped() throws RecognitionException {
		Splice_untypedContext _localctx = new Splice_untypedContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_splice_untyped);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2272);
			match(Dollar);
			setState(2273);
			aexp();
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

	public static class Splice_typedContext extends ParserRuleContext {
		public TerminalNode DDollar() { return getToken(HaskellParser.DDollar, 0); }
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public Splice_typedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_splice_typed; }
	}

	public final Splice_typedContext splice_typed() throws RecognitionException {
		Splice_typedContext _localctx = new Splice_typedContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_splice_typed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2275);
			match(DDollar);
			setState(2276);
			aexp();
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

	public static class CmdargsContext extends ParserRuleContext {
		public List<AcmdContext> acmd() {
			return getRuleContexts(AcmdContext.class);
		}
		public AcmdContext acmd(int i) {
			return getRuleContext(AcmdContext.class,i);
		}
		public CmdargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdargs; }
	}

	public final CmdargsContext cmdargs() throws RecognitionException {
		CmdargsContext _localctx = new CmdargsContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_cmdargs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2279); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2278);
					acmd();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2281); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,256,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class AcmdContext extends ParserRuleContext {
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public AcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acmd; }
	}

	public final AcmdContext acmd() throws RecognitionException {
		AcmdContext _localctx = new AcmdContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_acmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2283);
			aexp();
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

	public static class CvtopbodyContext extends ParserRuleContext {
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public Cvtopdecls0Context cvtopdecls0() {
			return getRuleContext(Cvtopdecls0Context.class,0);
		}
		public CvtopbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cvtopbody; }
	}

	public final CvtopbodyContext cvtopbody() throws RecognitionException {
		CvtopbodyContext _localctx = new CvtopbodyContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_cvtopbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2285);
			open_();
			setState(2287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << AS) | (1L << CASE) | (1L << CLASS) | (1L << DATA) | (1L << DEFAULT) | (1L << DERIVING) | (1L << DO) | (1L << HIDING) | (1L << IF) | (1L << INFIX) | (1L << INFIXL) | (1L << INFIXR) | (1L << INSTANCE) | (1L << LET) | (1L << NEWTYPE) | (1L << QUALIFIED) | (1L << TYPE) | (1L << WILDCARD) | (1L << FOREIGN) | (1L << EXPORT) | (1L << MDO) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << PATTERN) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LCASE - 73)) | (1L << (Bang - 73)) | (1L << (Minus - 73)) | (1L << (Tilde - 73)) | (1L << (DDollar - 73)) | (1L << (Dollar - 73)) | (1L << (Semi - 73)) | (1L << (Quote - 73)) | (1L << (DoubleQuote - 73)) | (1L << (ReverseSlash - 73)) | (1L << (AopenParen - 73)) | (1L << (TopenTexpQuote - 73)) | (1L << (TopenExpQuote - 73)) | (1L << (TopenPatQuote - 73)) | (1L << (TopenTypQoute - 73)) | (1L << (TopenDecQoute - 73)) | (1L << (OpenBoxParen - 73)) | (1L << (OpenRoundBracket - 73)) | (1L << (OpenSquareBracket - 73)) | (1L << (CHAR - 73)) | (1L << (STRING - 73)) | (1L << (VARID - 73)) | (1L << (CONID - 73)) | (1L << (OpenPragmaBracket - 73)) | (1L << (SEMI - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)) | (1L << (FLOAT - 137)))) != 0)) {
				{
				setState(2286);
				cvtopdecls0();
				}
			}

			setState(2289);
			close();
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

	public static class Cvtopdecls0Context extends ParserRuleContext {
		public TopdeclsContext topdecls() {
			return getRuleContext(TopdeclsContext.class,0);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public Cvtopdecls0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cvtopdecls0; }
	}

	public final Cvtopdecls0Context cvtopdecls0() throws RecognitionException {
		Cvtopdecls0Context _localctx = new Cvtopdecls0Context(_ctx, getState());
		enterRule(_localctx, 320, RULE_cvtopdecls0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2291);
			topdecls();
			setState(2295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semi || _la==SEMI) {
				{
				{
				setState(2292);
				semi();
				}
				}
				setState(2297);
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

	public static class TexpContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public InfixexpContext infixexp() {
			return getRuleContext(InfixexpContext.class,0);
		}
		public QopContext qop() {
			return getRuleContext(QopContext.class,0);
		}
		public QopmContext qopm() {
			return getRuleContext(QopmContext.class,0);
		}
		public TerminalNode Arrow() { return getToken(HaskellParser.Arrow, 0); }
		public TexpContext texp() {
			return getRuleContext(TexpContext.class,0);
		}
		public TexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_texp; }
	}

	public final TexpContext texp() throws RecognitionException {
		TexpContext _localctx = new TexpContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_texp);
		try {
			setState(2309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,259,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2298);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2299);
				infixexp();
				setState(2300);
				qop();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(2302);
				qopm();
				setState(2303);
				infixexp();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(2305);
				exp();
				setState(2306);
				match(Arrow);
				setState(2307);
				texp();
				}
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

	public static class Tup_exprsContext extends ParserRuleContext {
		public TexpContext texp() {
			return getRuleContext(TexpContext.class,0);
		}
		public Commas_tup_tailContext commas_tup_tail() {
			return getRuleContext(Commas_tup_tailContext.class,0);
		}
		public List<BarsContext> bars() {
			return getRuleContexts(BarsContext.class);
		}
		public BarsContext bars(int i) {
			return getRuleContext(BarsContext.class,i);
		}
		public CommasContext commas() {
			return getRuleContext(CommasContext.class,0);
		}
		public Tup_tailContext tup_tail() {
			return getRuleContext(Tup_tailContext.class,0);
		}
		public Tup_exprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tup_exprs; }
	}

	public final Tup_exprsContext tup_exprs() throws RecognitionException {
		Tup_exprsContext _localctx = new Tup_exprsContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_tup_exprs);
		int _la;
		try {
			setState(2326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,262,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(2311);
				texp();
				setState(2312);
				commas_tup_tail();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2314);
				texp();
				setState(2315);
				bars();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(2317);
				commas();
				setState(2319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << CASE) | (1L << DO) | (1L << HIDING) | (1L << IF) | (1L << LET) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << EXPORT) | (1L << MDO) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LCASE - 73)) | (1L << (Hash - 73)) | (1L << (Less - 73)) | (1L << (Greater - 73)) | (1L << (Ampersand - 73)) | (1L << (Pipe - 73)) | (1L << (Bang - 73)) | (1L << (Caret - 73)) | (1L << (Plus - 73)) | (1L << (Minus - 73)) | (1L << (Asterisk - 73)) | (1L << (Percent - 73)) | (1L << (Divide - 73)) | (1L << (Tilde - 73)) | (1L << (Atsign - 73)) | (1L << (DDollar - 73)) | (1L << (Dollar - 73)) | (1L << (Dot - 73)) | (1L << (QuestionMark - 73)) | (1L << (Colon - 73)) | (1L << (Eq - 73)) | (1L << (Quote - 73)) | (1L << (DoubleQuote - 73)) | (1L << (ReverseSlash - 73)) | (1L << (BackQuote - 73)) | (1L << (AopenParen - 73)) | (1L << (TopenTexpQuote - 73)) | (1L << (TopenExpQuote - 73)) | (1L << (TopenPatQuote - 73)) | (1L << (TopenTypQoute - 73)) | (1L << (TopenDecQoute - 73)) | (1L << (OpenBoxParen - 73)) | (1L << (OpenRoundBracket - 73)) | (1L << (OpenSquareBracket - 73)) | (1L << (CHAR - 73)) | (1L << (STRING - 73)) | (1L << (VARID - 73)) | (1L << (CONID - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)) | (1L << (FLOAT - 137)))) != 0)) {
					{
					setState(2318);
					tup_tail();
					}
				}

				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(2321);
				bars();
				setState(2322);
				texp();
				setState(2324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Pipe) {
					{
					setState(2323);
					bars();
					}
				}

				}
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

	public static class Commas_tup_tailContext extends ParserRuleContext {
		public CommasContext commas() {
			return getRuleContext(CommasContext.class,0);
		}
		public Tup_tailContext tup_tail() {
			return getRuleContext(Tup_tailContext.class,0);
		}
		public Commas_tup_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commas_tup_tail; }
	}

	public final Commas_tup_tailContext commas_tup_tail() throws RecognitionException {
		Commas_tup_tailContext _localctx = new Commas_tup_tailContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_commas_tup_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2328);
			commas();
			setState(2330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << CASE) | (1L << DO) | (1L << HIDING) | (1L << IF) | (1L << LET) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << EXPORT) | (1L << MDO) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LCASE - 73)) | (1L << (Hash - 73)) | (1L << (Less - 73)) | (1L << (Greater - 73)) | (1L << (Ampersand - 73)) | (1L << (Pipe - 73)) | (1L << (Bang - 73)) | (1L << (Caret - 73)) | (1L << (Plus - 73)) | (1L << (Minus - 73)) | (1L << (Asterisk - 73)) | (1L << (Percent - 73)) | (1L << (Divide - 73)) | (1L << (Tilde - 73)) | (1L << (Atsign - 73)) | (1L << (DDollar - 73)) | (1L << (Dollar - 73)) | (1L << (Dot - 73)) | (1L << (QuestionMark - 73)) | (1L << (Colon - 73)) | (1L << (Eq - 73)) | (1L << (Quote - 73)) | (1L << (DoubleQuote - 73)) | (1L << (ReverseSlash - 73)) | (1L << (BackQuote - 73)) | (1L << (AopenParen - 73)) | (1L << (TopenTexpQuote - 73)) | (1L << (TopenExpQuote - 73)) | (1L << (TopenPatQuote - 73)) | (1L << (TopenTypQoute - 73)) | (1L << (TopenDecQoute - 73)) | (1L << (OpenBoxParen - 73)) | (1L << (OpenRoundBracket - 73)) | (1L << (OpenSquareBracket - 73)) | (1L << (CHAR - 73)) | (1L << (STRING - 73)) | (1L << (VARID - 73)) | (1L << (CONID - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)) | (1L << (FLOAT - 137)))) != 0)) {
				{
				setState(2329);
				tup_tail();
				}
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

	public static class Tup_tailContext extends ParserRuleContext {
		public TexpContext texp() {
			return getRuleContext(TexpContext.class,0);
		}
		public Commas_tup_tailContext commas_tup_tail() {
			return getRuleContext(Commas_tup_tailContext.class,0);
		}
		public Tup_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tup_tail; }
	}

	public final Tup_tailContext tup_tail() throws RecognitionException {
		Tup_tailContext _localctx = new Tup_tailContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_tup_tail);
		try {
			setState(2336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,264,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2332);
				texp();
				setState(2333);
				commas_tup_tail();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2335);
				texp();
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

	public static class List_Context extends ParserRuleContext {
		public TexpContext texp() {
			return getRuleContext(TexpContext.class,0);
		}
		public LexpsContext lexps() {
			return getRuleContext(LexpsContext.class,0);
		}
		public TerminalNode DoubleDot() { return getToken(HaskellParser.DoubleDot, 0); }
		public TerminalNode Comma() { return getToken(HaskellParser.Comma, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode Pipe() { return getToken(HaskellParser.Pipe, 0); }
		public FlattenedpqualsContext flattenedpquals() {
			return getRuleContext(FlattenedpqualsContext.class,0);
		}
		public List_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_; }
	}

	public final List_Context list_() throws RecognitionException {
		List_Context _localctx = new List_Context(_ctx, getState());
		enterRule(_localctx, 330, RULE_list_);
		try {
			setState(2362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,265,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2338);
				texp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2339);
				lexps();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2340);
				texp();
				setState(2341);
				match(DoubleDot);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2343);
				texp();
				setState(2344);
				match(Comma);
				setState(2345);
				exp();
				setState(2346);
				match(DoubleDot);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2348);
				texp();
				setState(2349);
				match(DoubleDot);
				setState(2350);
				exp();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2352);
				texp();
				setState(2353);
				match(Comma);
				setState(2354);
				exp();
				setState(2355);
				match(DoubleDot);
				setState(2356);
				exp();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2358);
				texp();
				setState(2359);
				match(Pipe);
				setState(2360);
				flattenedpquals();
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

	public static class LexpsContext extends ParserRuleContext {
		public List<TexpContext> texp() {
			return getRuleContexts(TexpContext.class);
		}
		public TexpContext texp(int i) {
			return getRuleContext(TexpContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public LexpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexps; }
	}

	public final LexpsContext lexps() throws RecognitionException {
		LexpsContext _localctx = new LexpsContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_lexps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2364);
			texp();
			setState(2365);
			match(Comma);
			setState(2366);
			texp();
			setState(2371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(2367);
				match(Comma);
				setState(2368);
				texp();
				}
				}
				setState(2373);
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

	public static class FlattenedpqualsContext extends ParserRuleContext {
		public PqualsContext pquals() {
			return getRuleContext(PqualsContext.class,0);
		}
		public FlattenedpqualsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flattenedpquals; }
	}

	public final FlattenedpqualsContext flattenedpquals() throws RecognitionException {
		FlattenedpqualsContext _localctx = new FlattenedpqualsContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_flattenedpquals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2374);
			pquals();
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

	public static class PqualsContext extends ParserRuleContext {
		public List<SqualsContext> squals() {
			return getRuleContexts(SqualsContext.class);
		}
		public SqualsContext squals(int i) {
			return getRuleContext(SqualsContext.class,i);
		}
		public List<TerminalNode> Pipe() { return getTokens(HaskellParser.Pipe); }
		public TerminalNode Pipe(int i) {
			return getToken(HaskellParser.Pipe, i);
		}
		public PqualsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pquals; }
	}

	public final PqualsContext pquals() throws RecognitionException {
		PqualsContext _localctx = new PqualsContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_pquals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2376);
			squals();
			setState(2381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Pipe) {
				{
				{
				setState(2377);
				match(Pipe);
				setState(2378);
				squals();
				}
				}
				setState(2383);
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

	public static class SqualsContext extends ParserRuleContext {
		public List<TransformqualContext> transformqual() {
			return getRuleContexts(TransformqualContext.class);
		}
		public TransformqualContext transformqual(int i) {
			return getRuleContext(TransformqualContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public List<QualContext> qual() {
			return getRuleContexts(QualContext.class);
		}
		public QualContext qual(int i) {
			return getRuleContext(QualContext.class,i);
		}
		public SqualsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squals; }
	}

	public final SqualsContext squals() throws RecognitionException {
		SqualsContext _localctx = new SqualsContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_squals);
		int _la;
		try {
			setState(2416);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,272,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2384);
				transformqual();
				setState(2389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(2385);
					match(Comma);
					setState(2386);
					transformqual();
					}
					}
					setState(2391);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2392);
				transformqual();
				setState(2397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(2393);
					match(Comma);
					setState(2394);
					qual();
					}
					}
					setState(2399);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2400);
				qual();
				setState(2405);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(2401);
					match(Comma);
					setState(2402);
					transformqual();
					}
					}
					setState(2407);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2408);
				qual();
				setState(2413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(2409);
					match(Comma);
					setState(2410);
					qual();
					}
					}
					setState(2415);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class TransformqualContext extends ParserRuleContext {
		public TerminalNode THEN() { return getToken(HaskellParser.THEN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode BY() { return getToken(HaskellParser.BY, 0); }
		public TerminalNode GROUP() { return getToken(HaskellParser.GROUP, 0); }
		public TerminalNode USING() { return getToken(HaskellParser.USING, 0); }
		public TransformqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transformqual; }
	}

	public final TransformqualContext transformqual() throws RecognitionException {
		TransformqualContext _localctx = new TransformqualContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_transformqual);
		try {
			setState(2436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2418);
				match(THEN);
				setState(2419);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2420);
				match(THEN);
				setState(2421);
				exp();
				setState(2422);
				match(BY);
				setState(2423);
				exp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2425);
				match(THEN);
				setState(2426);
				match(GROUP);
				setState(2427);
				match(USING);
				setState(2428);
				exp();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2429);
				match(THEN);
				setState(2430);
				match(GROUP);
				setState(2431);
				match(BY);
				setState(2432);
				exp();
				setState(2433);
				match(USING);
				setState(2434);
				exp();
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

	public static class GuardsContext extends ParserRuleContext {
		public List<Guard_Context> guard_() {
			return getRuleContexts(Guard_Context.class);
		}
		public Guard_Context guard_(int i) {
			return getRuleContext(Guard_Context.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public GuardsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guards; }
	}

	public final GuardsContext guards() throws RecognitionException {
		GuardsContext _localctx = new GuardsContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_guards);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2438);
			guard_();
			setState(2443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(2439);
				match(Comma);
				setState(2440);
				guard_();
				}
				}
				setState(2445);
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

	public static class Guard_Context extends ParserRuleContext {
		public PatContext pat() {
			return getRuleContext(PatContext.class,0);
		}
		public TerminalNode Revarrow() { return getToken(HaskellParser.Revarrow, 0); }
		public InfixexpContext infixexp() {
			return getRuleContext(InfixexpContext.class,0);
		}
		public TerminalNode LET() { return getToken(HaskellParser.LET, 0); }
		public DecllistContext decllist() {
			return getRuleContext(DecllistContext.class,0);
		}
		public Guard_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard_; }
	}

	public final Guard_Context guard_() throws RecognitionException {
		Guard_Context _localctx = new Guard_Context(_ctx, getState());
		enterRule(_localctx, 344, RULE_guard_);
		try {
			setState(2453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2446);
				pat();
				setState(2447);
				match(Revarrow);
				setState(2448);
				infixexp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2450);
				match(LET);
				setState(2451);
				decllist();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2452);
				infixexp();
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

	public static class AltsContext extends ParserRuleContext {
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public List<AltContext> alt() {
			return getRuleContexts(AltContext.class);
		}
		public AltContext alt(int i) {
			return getRuleContext(AltContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public AltsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alts; }
	}

	public final AltsContext alts() throws RecognitionException {
		AltsContext _localctx = new AltsContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_alts);
		int _la;
		try {
			setState(2472);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,278,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(2455);
				open_();
				setState(2463); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2456);
					alt();
					setState(2460);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Semi || _la==SEMI) {
						{
						{
						setState(2457);
						semi();
						}
						}
						setState(2462);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(2465); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << CASE) | (1L << DO) | (1L << HIDING) | (1L << IF) | (1L << LET) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << EXPORT) | (1L << MDO) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LCASE - 73)) | (1L << (Bang - 73)) | (1L << (Minus - 73)) | (1L << (Tilde - 73)) | (1L << (DDollar - 73)) | (1L << (Dollar - 73)) | (1L << (Quote - 73)) | (1L << (DoubleQuote - 73)) | (1L << (ReverseSlash - 73)) | (1L << (AopenParen - 73)) | (1L << (TopenTexpQuote - 73)) | (1L << (TopenExpQuote - 73)) | (1L << (TopenPatQuote - 73)) | (1L << (TopenTypQoute - 73)) | (1L << (TopenDecQoute - 73)) | (1L << (OpenBoxParen - 73)) | (1L << (OpenRoundBracket - 73)) | (1L << (OpenSquareBracket - 73)) | (1L << (CHAR - 73)) | (1L << (STRING - 73)) | (1L << (VARID - 73)) | (1L << (CONID - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)) | (1L << (FLOAT - 137)))) != 0) );
				setState(2467);
				close();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2469);
				open_();
				setState(2470);
				close();
				}
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

	public static class AltContext extends ParserRuleContext {
		public PatContext pat() {
			return getRuleContext(PatContext.class,0);
		}
		public Alt_rhsContext alt_rhs() {
			return getRuleContext(Alt_rhsContext.class,0);
		}
		public AltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alt; }
	}

	public final AltContext alt() throws RecognitionException {
		AltContext _localctx = new AltContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_alt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2474);
			pat();
			setState(2475);
			alt_rhs();
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

	public static class Alt_rhsContext extends ParserRuleContext {
		public RaltContext ralt() {
			return getRuleContext(RaltContext.class,0);
		}
		public WherebindsContext wherebinds() {
			return getRuleContext(WherebindsContext.class,0);
		}
		public Alt_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alt_rhs; }
	}

	public final Alt_rhsContext alt_rhs() throws RecognitionException {
		Alt_rhsContext _localctx = new Alt_rhsContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_alt_rhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2477);
			ralt();
			setState(2479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(2478);
				wherebinds();
				}
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

	public static class RaltContext extends ParserRuleContext {
		public TerminalNode Arrow() { return getToken(HaskellParser.Arrow, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public GdpatsContext gdpats() {
			return getRuleContext(GdpatsContext.class,0);
		}
		public RaltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ralt; }
	}

	public final RaltContext ralt() throws RecognitionException {
		RaltContext _localctx = new RaltContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_ralt);
		try {
			setState(2484);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Arrow:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(2481);
				match(Arrow);
				setState(2482);
				exp();
				}
				}
				break;
			case Pipe:
				enterOuterAlt(_localctx, 2);
				{
				setState(2483);
				gdpats();
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

	public static class GdpatsContext extends ParserRuleContext {
		public List<GdpatContext> gdpat() {
			return getRuleContexts(GdpatContext.class);
		}
		public GdpatContext gdpat(int i) {
			return getRuleContext(GdpatContext.class,i);
		}
		public GdpatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gdpats; }
	}

	public final GdpatsContext gdpats() throws RecognitionException {
		GdpatsContext _localctx = new GdpatsContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_gdpats);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2487); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2486);
					gdpat();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2489); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,281,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class IfgdpatsContext extends ParserRuleContext {
		public TerminalNode OCURLY() { return getToken(HaskellParser.OCURLY, 0); }
		public GdpatsContext gdpats() {
			return getRuleContext(GdpatsContext.class,0);
		}
		public TerminalNode CCURLY() { return getToken(HaskellParser.CCURLY, 0); }
		public IfgdpatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifgdpats; }
	}

	public final IfgdpatsContext ifgdpats() throws RecognitionException {
		IfgdpatsContext _localctx = new IfgdpatsContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_ifgdpats);
		try {
			setState(2496);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OCURLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(2491);
				match(OCURLY);
				setState(2492);
				gdpats();
				setState(2493);
				match(CCURLY);
				}
				break;
			case Pipe:
				enterOuterAlt(_localctx, 2);
				{
				setState(2495);
				gdpats();
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

	public static class GdpatContext extends ParserRuleContext {
		public TerminalNode Pipe() { return getToken(HaskellParser.Pipe, 0); }
		public GuardsContext guards() {
			return getRuleContext(GuardsContext.class,0);
		}
		public TerminalNode Arrow() { return getToken(HaskellParser.Arrow, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public GdpatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gdpat; }
	}

	public final GdpatContext gdpat() throws RecognitionException {
		GdpatContext _localctx = new GdpatContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_gdpat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2498);
			match(Pipe);
			setState(2499);
			guards();
			setState(2500);
			match(Arrow);
			setState(2501);
			exp();
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

	public static class PatContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pat; }
	}

	public final PatContext pat() throws RecognitionException {
		PatContext _localctx = new PatContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_pat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2503);
			exp();
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

	public static class BindpatContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BindpatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindpat; }
	}

	public final BindpatContext bindpat() throws RecognitionException {
		BindpatContext _localctx = new BindpatContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_bindpat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2505);
			exp();
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

	public static class ApatContext extends ParserRuleContext {
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public ApatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apat; }
	}

	public final ApatContext apat() throws RecognitionException {
		ApatContext _localctx = new ApatContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_apat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2507);
			aexp();
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

	public static class ApatsContext extends ParserRuleContext {
		public List<ApatContext> apat() {
			return getRuleContexts(ApatContext.class);
		}
		public ApatContext apat(int i) {
			return getRuleContext(ApatContext.class,i);
		}
		public ApatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apats; }
	}

	public final ApatsContext apats() throws RecognitionException {
		ApatsContext _localctx = new ApatsContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_apats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2510); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2509);
				apat();
				}
				}
				setState(2512); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << CASE) | (1L << DO) | (1L << HIDING) | (1L << IF) | (1L << LET) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << EXPORT) | (1L << MDO) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LCASE - 73)) | (1L << (Bang - 73)) | (1L << (Tilde - 73)) | (1L << (DDollar - 73)) | (1L << (Dollar - 73)) | (1L << (Quote - 73)) | (1L << (DoubleQuote - 73)) | (1L << (ReverseSlash - 73)) | (1L << (AopenParen - 73)) | (1L << (TopenTexpQuote - 73)) | (1L << (TopenExpQuote - 73)) | (1L << (TopenPatQuote - 73)) | (1L << (TopenTypQoute - 73)) | (1L << (TopenDecQoute - 73)) | (1L << (OpenBoxParen - 73)) | (1L << (OpenRoundBracket - 73)) | (1L << (OpenSquareBracket - 73)) | (1L << (CHAR - 73)) | (1L << (STRING - 73)) | (1L << (VARID - 73)) | (1L << (CONID - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)) | (1L << (FLOAT - 137)))) != 0) );
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

	public static class FpatContext extends ParserRuleContext {
		public QvarContext qvar() {
			return getRuleContext(QvarContext.class,0);
		}
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public PatContext pat() {
			return getRuleContext(PatContext.class,0);
		}
		public FpatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fpat; }
	}

	public final FpatContext fpat() throws RecognitionException {
		FpatContext _localctx = new FpatContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_fpat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2514);
			qvar();
			setState(2515);
			match(Eq);
			setState(2516);
			pat();
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

	public static class StmtlistContext extends ParserRuleContext {
		public Open_Context open_() {
			return getRuleContext(Open_Context.class,0);
		}
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public StmtlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtlist; }
	}

	public final StmtlistContext stmtlist() throws RecognitionException {
		StmtlistContext _localctx = new StmtlistContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_stmtlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2518);
			open_();
			setState(2520);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << CASE) | (1L << DO) | (1L << HIDING) | (1L << IF) | (1L << LET) | (1L << QUALIFIED) | (1L << WILDCARD) | (1L << EXPORT) | (1L << MDO) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << REC) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LCASE - 73)) | (1L << (Bang - 73)) | (1L << (Minus - 73)) | (1L << (Tilde - 73)) | (1L << (DDollar - 73)) | (1L << (Dollar - 73)) | (1L << (Semi - 73)) | (1L << (Quote - 73)) | (1L << (DoubleQuote - 73)) | (1L << (ReverseSlash - 73)) | (1L << (AopenParen - 73)) | (1L << (TopenTexpQuote - 73)) | (1L << (TopenExpQuote - 73)) | (1L << (TopenPatQuote - 73)) | (1L << (TopenTypQoute - 73)) | (1L << (TopenDecQoute - 73)) | (1L << (OpenBoxParen - 73)) | (1L << (OpenRoundBracket - 73)) | (1L << (OpenSquareBracket - 73)) | (1L << (CHAR - 73)) | (1L << (STRING - 73)) | (1L << (VARID - 73)) | (1L << (CONID - 73)) | (1L << (SEMI - 73)))) != 0) || ((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)) | (1L << (FLOAT - 137)))) != 0)) {
				{
				setState(2519);
				stmts();
				}
			}

			setState(2522);
			close();
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

	public static class StmtsContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2524);
			stmt();
			setState(2534);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2526); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(2525);
							semi();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(2528); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,285,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(2530);
					stmt();
					}
					} 
				}
				setState(2536);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
			}
			setState(2540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semi || _la==SEMI) {
				{
				{
				setState(2537);
				semi();
				}
				}
				setState(2542);
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

	public static class StmtContext extends ParserRuleContext {
		public QualContext qual() {
			return getRuleContext(QualContext.class,0);
		}
		public TerminalNode REC() { return getToken(HaskellParser.REC, 0); }
		public StmtlistContext stmtlist() {
			return getRuleContext(StmtlistContext.class,0);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_stmt);
		try {
			int _alt;
			setState(2551);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AS:
			case CASE:
			case DO:
			case HIDING:
			case IF:
			case LET:
			case QUALIFIED:
			case WILDCARD:
			case EXPORT:
			case MDO:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case LCASE:
			case Bang:
			case Minus:
			case Tilde:
			case DDollar:
			case Dollar:
			case Quote:
			case DoubleQuote:
			case ReverseSlash:
			case AopenParen:
			case TopenTexpQuote:
			case TopenExpQuote:
			case TopenPatQuote:
			case TopenTypQoute:
			case TopenDecQoute:
			case OpenBoxParen:
			case OpenRoundBracket:
			case OpenSquareBracket:
			case CHAR:
			case STRING:
			case VARID:
			case CONID:
			case DECIMAL:
			case OCTAL:
			case HEXADECIMAL:
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2543);
				qual();
				}
				break;
			case REC:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2544);
				match(REC);
				setState(2545);
				stmtlist();
				}
				}
				break;
			case Semi:
			case SEMI:
				enterOuterAlt(_localctx, 3);
				{
				setState(2547); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2546);
						semi();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2549); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,288,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class QualContext extends ParserRuleContext {
		public BindpatContext bindpat() {
			return getRuleContext(BindpatContext.class,0);
		}
		public TerminalNode Revarrow() { return getToken(HaskellParser.Revarrow, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode LET() { return getToken(HaskellParser.LET, 0); }
		public BindsContext binds() {
			return getRuleContext(BindsContext.class,0);
		}
		public QualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qual; }
	}

	public final QualContext qual() throws RecognitionException {
		QualContext _localctx = new QualContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_qual);
		try {
			setState(2560);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2553);
				bindpat();
				setState(2554);
				match(Revarrow);
				setState(2555);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2557);
				exp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2558);
				match(LET);
				setState(2559);
				binds();
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

	public static class FbindsContext extends ParserRuleContext {
		public List<FbindContext> fbind() {
			return getRuleContexts(FbindContext.class);
		}
		public FbindContext fbind(int i) {
			return getRuleContext(FbindContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public TerminalNode DoubleDot() { return getToken(HaskellParser.DoubleDot, 0); }
		public FbindsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fbinds; }
	}

	public final FbindsContext fbinds() throws RecognitionException {
		FbindsContext _localctx = new FbindsContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_fbinds);
		int _la;
		try {
			setState(2571);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AS:
			case HIDING:
			case QUALIFIED:
			case EXPORT:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case OpenRoundBracket:
			case VARID:
			case CONID:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(2562);
				fbind();
				setState(2567);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(2563);
					match(Comma);
					setState(2564);
					fbind();
					}
					}
					setState(2569);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case DoubleDot:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2570);
				match(DoubleDot);
				}
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

	public static class FbindContext extends ParserRuleContext {
		public QvarContext qvar() {
			return getRuleContext(QvarContext.class,0);
		}
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public FbindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fbind; }
	}

	public final FbindContext fbind() throws RecognitionException {
		FbindContext _localctx = new FbindContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_fbind);
		try {
			setState(2578);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(2573);
				qvar();
				setState(2574);
				match(Eq);
				setState(2575);
				exp();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2577);
				qvar();
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

	public static class DbindsContext extends ParserRuleContext {
		public List<DbindContext> dbind() {
			return getRuleContexts(DbindContext.class);
		}
		public DbindContext dbind(int i) {
			return getRuleContext(DbindContext.class,i);
		}
		public List<SemiContext> semi() {
			return getRuleContexts(SemiContext.class);
		}
		public SemiContext semi(int i) {
			return getRuleContext(SemiContext.class,i);
		}
		public DbindsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbinds; }
	}

	public final DbindsContext dbinds() throws RecognitionException {
		DbindsContext _localctx = new DbindsContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_dbinds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2580);
			dbind();
			{
			setState(2582); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2581);
				semi();
				}
				}
				setState(2584); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Semi || _la==SEMI );
			setState(2586);
			dbind();
			}
			setState(2591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semi || _la==SEMI) {
				{
				{
				setState(2588);
				semi();
				}
				}
				setState(2593);
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

	public static class DbindContext extends ParserRuleContext {
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DbindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbind; }
	}

	public final DbindContext dbind() throws RecognitionException {
		DbindContext _localctx = new DbindContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_dbind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2594);
			varid();
			setState(2595);
			match(Eq);
			setState(2596);
			exp();
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

	public static class Name_boolformula_optContext extends ParserRuleContext {
		public List<Name_boolformula_andContext> name_boolformula_and() {
			return getRuleContexts(Name_boolformula_andContext.class);
		}
		public Name_boolformula_andContext name_boolformula_and(int i) {
			return getRuleContext(Name_boolformula_andContext.class,i);
		}
		public List<TerminalNode> Pipe() { return getTokens(HaskellParser.Pipe); }
		public TerminalNode Pipe(int i) {
			return getToken(HaskellParser.Pipe, i);
		}
		public Name_boolformula_optContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_boolformula_opt; }
	}

	public final Name_boolformula_optContext name_boolformula_opt() throws RecognitionException {
		Name_boolformula_optContext _localctx = new Name_boolformula_optContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_name_boolformula_opt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2598);
			name_boolformula_and();
			setState(2603);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Pipe) {
				{
				{
				setState(2599);
				match(Pipe);
				setState(2600);
				name_boolformula_and();
				}
				}
				setState(2605);
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

	public static class Name_boolformula_andContext extends ParserRuleContext {
		public Name_boolformula_and_listContext name_boolformula_and_list() {
			return getRuleContext(Name_boolformula_and_listContext.class,0);
		}
		public Name_boolformula_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_boolformula_and; }
	}

	public final Name_boolformula_andContext name_boolformula_and() throws RecognitionException {
		Name_boolformula_andContext _localctx = new Name_boolformula_andContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_name_boolformula_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2606);
			name_boolformula_and_list();
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

	public static class Name_boolformula_and_listContext extends ParserRuleContext {
		public List<Name_boolformula_atomContext> name_boolformula_atom() {
			return getRuleContexts(Name_boolformula_atomContext.class);
		}
		public Name_boolformula_atomContext name_boolformula_atom(int i) {
			return getRuleContext(Name_boolformula_atomContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public Name_boolformula_and_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_boolformula_and_list; }
	}

	public final Name_boolformula_and_listContext name_boolformula_and_list() throws RecognitionException {
		Name_boolformula_and_listContext _localctx = new Name_boolformula_and_listContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_name_boolformula_and_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2608);
			name_boolformula_atom();
			setState(2613);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(2609);
				match(Comma);
				setState(2610);
				name_boolformula_atom();
				}
				}
				setState(2615);
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

	public static class Name_boolformula_atomContext extends ParserRuleContext {
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public Name_boolformula_optContext name_boolformula_opt() {
			return getRuleContext(Name_boolformula_optContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public Name_varContext name_var() {
			return getRuleContext(Name_varContext.class,0);
		}
		public Name_boolformula_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_boolformula_atom; }
	}

	public final Name_boolformula_atomContext name_boolformula_atom() throws RecognitionException {
		Name_boolformula_atomContext _localctx = new Name_boolformula_atomContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_name_boolformula_atom);
		try {
			setState(2621);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,298,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(2616);
				match(OpenRoundBracket);
				setState(2617);
				name_boolformula_opt();
				setState(2618);
				match(CloseRoundBracket);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2620);
				name_var();
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

	public static class NamelistContext extends ParserRuleContext {
		public List<Name_varContext> name_var() {
			return getRuleContexts(Name_varContext.class);
		}
		public Name_varContext name_var(int i) {
			return getRuleContext(Name_varContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public NamelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namelist; }
	}

	public final NamelistContext namelist() throws RecognitionException {
		NamelistContext _localctx = new NamelistContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_namelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2623);
			name_var();
			setState(2628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(2624);
				match(Comma);
				setState(2625);
				name_var();
				}
				}
				setState(2630);
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

	public static class Name_varContext extends ParserRuleContext {
		public Var_Context var_() {
			return getRuleContext(Var_Context.class,0);
		}
		public ConContext con() {
			return getRuleContext(ConContext.class,0);
		}
		public Name_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_var; }
	}

	public final Name_varContext name_var() throws RecognitionException {
		Name_varContext _localctx = new Name_varContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_name_var);
		try {
			setState(2633);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,300,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2631);
				var_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2632);
				con();
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

	public static class Qcon_nowiredlistContext extends ParserRuleContext {
		public Gen_qconContext gen_qcon() {
			return getRuleContext(Gen_qconContext.class,0);
		}
		public Sysdcon_nolistContext sysdcon_nolist() {
			return getRuleContext(Sysdcon_nolistContext.class,0);
		}
		public Qcon_nowiredlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qcon_nowiredlist; }
	}

	public final Qcon_nowiredlistContext qcon_nowiredlist() throws RecognitionException {
		Qcon_nowiredlistContext _localctx = new Qcon_nowiredlistContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_qcon_nowiredlist);
		try {
			setState(2637);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,301,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2635);
				gen_qcon();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2636);
				sysdcon_nolist();
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

	public static class QconContext extends ParserRuleContext {
		public Gen_qconContext gen_qcon() {
			return getRuleContext(Gen_qconContext.class,0);
		}
		public SysdconContext sysdcon() {
			return getRuleContext(SysdconContext.class,0);
		}
		public QconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qcon; }
	}

	public final QconContext qcon() throws RecognitionException {
		QconContext _localctx = new QconContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_qcon);
		try {
			setState(2641);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,302,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2639);
				gen_qcon();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2640);
				sysdcon();
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

	public static class Gen_qconContext extends ParserRuleContext {
		public QconidContext qconid() {
			return getRuleContext(QconidContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public QconsymContext qconsym() {
			return getRuleContext(QconsymContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public Gen_qconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gen_qcon; }
	}

	public final Gen_qconContext gen_qcon() throws RecognitionException {
		Gen_qconContext _localctx = new Gen_qconContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_gen_qcon);
		try {
			setState(2648);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONID:
				enterOuterAlt(_localctx, 1);
				{
				setState(2643);
				qconid();
				}
				break;
			case OpenRoundBracket:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2644);
				match(OpenRoundBracket);
				setState(2645);
				qconsym();
				setState(2646);
				match(CloseRoundBracket);
				}
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

	public static class ConContext extends ParserRuleContext {
		public ConidContext conid() {
			return getRuleContext(ConidContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public ConsymContext consym() {
			return getRuleContext(ConsymContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public SysdconContext sysdcon() {
			return getRuleContext(SysdconContext.class,0);
		}
		public ConContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_con; }
	}

	public final ConContext con() throws RecognitionException {
		ConContext _localctx = new ConContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_con);
		try {
			setState(2656);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2650);
				conid();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2651);
				match(OpenRoundBracket);
				setState(2652);
				consym();
				setState(2653);
				match(CloseRoundBracket);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2655);
				sysdcon();
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

	public static class Con_listContext extends ParserRuleContext {
		public List<ConContext> con() {
			return getRuleContexts(ConContext.class);
		}
		public ConContext con(int i) {
			return getRuleContext(ConContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public Con_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_con_list; }
	}

	public final Con_listContext con_list() throws RecognitionException {
		Con_listContext _localctx = new Con_listContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_con_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2658);
			con();
			setState(2663);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(2659);
				match(Comma);
				setState(2660);
				con();
				}
				}
				setState(2665);
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

	public static class Sysdcon_nolistContext extends ParserRuleContext {
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public CommasContext commas() {
			return getRuleContext(CommasContext.class,0);
		}
		public TerminalNode OpenBoxParen() { return getToken(HaskellParser.OpenBoxParen, 0); }
		public TerminalNode CloseBoxParen() { return getToken(HaskellParser.CloseBoxParen, 0); }
		public Sysdcon_nolistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sysdcon_nolist; }
	}

	public final Sysdcon_nolistContext sysdcon_nolist() throws RecognitionException {
		Sysdcon_nolistContext _localctx = new Sysdcon_nolistContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_sysdcon_nolist);
		try {
			setState(2678);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,306,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(2666);
				match(OpenRoundBracket);
				setState(2667);
				match(CloseRoundBracket);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2668);
				match(OpenRoundBracket);
				setState(2669);
				commas();
				setState(2670);
				match(CloseRoundBracket);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(2672);
				match(OpenBoxParen);
				setState(2673);
				match(CloseBoxParen);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(2674);
				match(OpenBoxParen);
				setState(2675);
				commas();
				setState(2676);
				match(CloseBoxParen);
				}
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

	public static class SysdconContext extends ParserRuleContext {
		public Sysdcon_nolistContext sysdcon_nolist() {
			return getRuleContext(Sysdcon_nolistContext.class,0);
		}
		public TerminalNode OpenSquareBracket() { return getToken(HaskellParser.OpenSquareBracket, 0); }
		public TerminalNode CloseSquareBracket() { return getToken(HaskellParser.CloseSquareBracket, 0); }
		public SysdconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sysdcon; }
	}

	public final SysdconContext sysdcon() throws RecognitionException {
		SysdconContext _localctx = new SysdconContext(_ctx, getState());
		enterRule(_localctx, 410, RULE_sysdcon);
		try {
			setState(2683);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenBoxParen:
			case OpenRoundBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(2680);
				sysdcon_nolist();
				}
				break;
			case OpenSquareBracket:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2681);
				match(OpenSquareBracket);
				setState(2682);
				match(CloseSquareBracket);
				}
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

	public static class ConopContext extends ParserRuleContext {
		public ConsymContext consym() {
			return getRuleContext(ConsymContext.class,0);
		}
		public List<TerminalNode> BackQuote() { return getTokens(HaskellParser.BackQuote); }
		public TerminalNode BackQuote(int i) {
			return getToken(HaskellParser.BackQuote, i);
		}
		public ConidContext conid() {
			return getRuleContext(ConidContext.class,0);
		}
		public ConopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conop; }
	}

	public final ConopContext conop() throws RecognitionException {
		ConopContext _localctx = new ConopContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_conop);
		try {
			setState(2690);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Colon:
				enterOuterAlt(_localctx, 1);
				{
				setState(2685);
				consym();
				}
				break;
			case BackQuote:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2686);
				match(BackQuote);
				setState(2687);
				conid();
				setState(2688);
				match(BackQuote);
				}
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

	public static class QconopContext extends ParserRuleContext {
		public GconsymContext gconsym() {
			return getRuleContext(GconsymContext.class,0);
		}
		public List<TerminalNode> BackQuote() { return getTokens(HaskellParser.BackQuote); }
		public TerminalNode BackQuote(int i) {
			return getToken(HaskellParser.BackQuote, i);
		}
		public QconidContext qconid() {
			return getRuleContext(QconidContext.class,0);
		}
		public QconopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qconop; }
	}

	public final QconopContext qconop() throws RecognitionException {
		QconopContext _localctx = new QconopContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_qconop);
		try {
			setState(2697);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Colon:
			case CONID:
				enterOuterAlt(_localctx, 1);
				{
				setState(2692);
				gconsym();
				}
				break;
			case BackQuote:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2693);
				match(BackQuote);
				setState(2694);
				qconid();
				setState(2695);
				match(BackQuote);
				}
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

	public static class GconsymContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(HaskellParser.Colon, 0); }
		public QconsymContext qconsym() {
			return getRuleContext(QconsymContext.class,0);
		}
		public GconsymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gconsym; }
	}

	public final GconsymContext gconsym() throws RecognitionException {
		GconsymContext _localctx = new GconsymContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_gconsym);
		try {
			setState(2701);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,310,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2699);
				match(Colon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2700);
				qconsym();
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

	public static class GtyconContext extends ParserRuleContext {
		public NtgtyconContext ntgtycon() {
			return getRuleContext(NtgtyconContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public TerminalNode OpenBoxParen() { return getToken(HaskellParser.OpenBoxParen, 0); }
		public TerminalNode CloseBoxParen() { return getToken(HaskellParser.CloseBoxParen, 0); }
		public GtyconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gtycon; }
	}

	public final GtyconContext gtycon() throws RecognitionException {
		GtyconContext _localctx = new GtyconContext(_ctx, getState());
		enterRule(_localctx, 418, RULE_gtycon);
		try {
			setState(2708);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,311,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2703);
				ntgtycon();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2704);
				match(OpenRoundBracket);
				setState(2705);
				match(CloseRoundBracket);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(2706);
				match(OpenBoxParen);
				setState(2707);
				match(CloseBoxParen);
				}
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

	public static class NtgtyconContext extends ParserRuleContext {
		public OqtyconContext oqtycon() {
			return getRuleContext(OqtyconContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public CommasContext commas() {
			return getRuleContext(CommasContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public TerminalNode OpenBoxParen() { return getToken(HaskellParser.OpenBoxParen, 0); }
		public TerminalNode CloseBoxParen() { return getToken(HaskellParser.CloseBoxParen, 0); }
		public TerminalNode Arrow() { return getToken(HaskellParser.Arrow, 0); }
		public TerminalNode OpenSquareBracket() { return getToken(HaskellParser.OpenSquareBracket, 0); }
		public TerminalNode CloseSquareBracket() { return getToken(HaskellParser.CloseSquareBracket, 0); }
		public NtgtyconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ntgtycon; }
	}

	public final NtgtyconContext ntgtycon() throws RecognitionException {
		NtgtyconContext _localctx = new NtgtyconContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_ntgtycon);
		try {
			setState(2724);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,312,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2710);
				oqtycon();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2711);
				match(OpenRoundBracket);
				setState(2712);
				commas();
				setState(2713);
				match(CloseRoundBracket);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(2715);
				match(OpenBoxParen);
				setState(2716);
				commas();
				setState(2717);
				match(CloseBoxParen);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(2719);
				match(OpenRoundBracket);
				setState(2720);
				match(Arrow);
				setState(2721);
				match(CloseRoundBracket);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(2722);
				match(OpenSquareBracket);
				setState(2723);
				match(CloseSquareBracket);
				}
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

	public static class OqtyconContext extends ParserRuleContext {
		public QtyconContext qtycon() {
			return getRuleContext(QtyconContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public QtyconsymContext qtyconsym() {
			return getRuleContext(QtyconsymContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public OqtyconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oqtycon; }
	}

	public final OqtyconContext oqtycon() throws RecognitionException {
		OqtyconContext _localctx = new OqtyconContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_oqtycon);
		try {
			setState(2731);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONID:
				enterOuterAlt(_localctx, 1);
				{
				setState(2726);
				qtycon();
				}
				break;
			case OpenRoundBracket:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2727);
				match(OpenRoundBracket);
				setState(2728);
				qtyconsym();
				setState(2729);
				match(CloseRoundBracket);
				}
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

	public static class QtyconopContext extends ParserRuleContext {
		public QtyconsymContext qtyconsym() {
			return getRuleContext(QtyconsymContext.class,0);
		}
		public List<TerminalNode> BackQuote() { return getTokens(HaskellParser.BackQuote); }
		public TerminalNode BackQuote(int i) {
			return getToken(HaskellParser.BackQuote, i);
		}
		public QtyconContext qtycon() {
			return getRuleContext(QtyconContext.class,0);
		}
		public QtyconopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qtyconop; }
	}

	public final QtyconopContext qtyconop() throws RecognitionException {
		QtyconopContext _localctx = new QtyconopContext(_ctx, getState());
		enterRule(_localctx, 424, RULE_qtyconop);
		try {
			setState(2738);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Hash:
			case Less:
			case Greater:
			case Ampersand:
			case Pipe:
			case Bang:
			case Caret:
			case Plus:
			case Minus:
			case Asterisk:
			case Percent:
			case Divide:
			case Tilde:
			case Atsign:
			case Dollar:
			case Dot:
			case QuestionMark:
			case Colon:
			case Eq:
			case ReverseSlash:
			case CONID:
				enterOuterAlt(_localctx, 1);
				{
				setState(2733);
				qtyconsym();
				}
				break;
			case BackQuote:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2734);
				match(BackQuote);
				setState(2735);
				qtycon();
				setState(2736);
				match(BackQuote);
				}
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

	public static class QtyconContext extends ParserRuleContext {
		public TyconContext tycon() {
			return getRuleContext(TyconContext.class,0);
		}
		public ModidContext modid() {
			return getRuleContext(ModidContext.class,0);
		}
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public QtyconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qtycon; }
	}

	public final QtyconContext qtycon() throws RecognitionException {
		QtyconContext _localctx = new QtyconContext(_ctx, getState());
		enterRule(_localctx, 426, RULE_qtycon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2743);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,315,_ctx) ) {
			case 1:
				{
				setState(2740);
				modid();
				setState(2741);
				match(Dot);
				}
				break;
			}
			setState(2745);
			tycon();
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

	public static class TyconContext extends ParserRuleContext {
		public ConidContext conid() {
			return getRuleContext(ConidContext.class,0);
		}
		public TyconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tycon; }
	}

	public final TyconContext tycon() throws RecognitionException {
		TyconContext _localctx = new TyconContext(_ctx, getState());
		enterRule(_localctx, 428, RULE_tycon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2747);
			conid();
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

	public static class QtyconsymContext extends ParserRuleContext {
		public QconsymContext qconsym() {
			return getRuleContext(QconsymContext.class,0);
		}
		public QvarsymContext qvarsym() {
			return getRuleContext(QvarsymContext.class,0);
		}
		public TyconsymContext tyconsym() {
			return getRuleContext(TyconsymContext.class,0);
		}
		public QtyconsymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qtyconsym; }
	}

	public final QtyconsymContext qtyconsym() throws RecognitionException {
		QtyconsymContext _localctx = new QtyconsymContext(_ctx, getState());
		enterRule(_localctx, 430, RULE_qtyconsym);
		try {
			setState(2752);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,316,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2749);
				qconsym();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2750);
				qvarsym();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2751);
				tyconsym();
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

	public static class TyconsymContext extends ParserRuleContext {
		public ConsymContext consym() {
			return getRuleContext(ConsymContext.class,0);
		}
		public VarsymContext varsym() {
			return getRuleContext(VarsymContext.class,0);
		}
		public TerminalNode Colon() { return getToken(HaskellParser.Colon, 0); }
		public TerminalNode Minus() { return getToken(HaskellParser.Minus, 0); }
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public TyconsymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tyconsym; }
	}

	public final TyconsymContext tyconsym() throws RecognitionException {
		TyconsymContext _localctx = new TyconsymContext(_ctx, getState());
		enterRule(_localctx, 432, RULE_tyconsym);
		try {
			setState(2759);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,317,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2754);
				consym();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2755);
				varsym();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2756);
				match(Colon);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2757);
				match(Minus);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2758);
				match(Dot);
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

	public static class OpContext extends ParserRuleContext {
		public VaropContext varop() {
			return getRuleContext(VaropContext.class,0);
		}
		public ConopContext conop() {
			return getRuleContext(ConopContext.class,0);
		}
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 434, RULE_op);
		try {
			setState(2763);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,318,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2761);
				varop();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2762);
				conop();
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

	public static class VaropContext extends ParserRuleContext {
		public VarsymContext varsym() {
			return getRuleContext(VarsymContext.class,0);
		}
		public List<TerminalNode> BackQuote() { return getTokens(HaskellParser.BackQuote); }
		public TerminalNode BackQuote(int i) {
			return getToken(HaskellParser.BackQuote, i);
		}
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public VaropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varop; }
	}

	public final VaropContext varop() throws RecognitionException {
		VaropContext _localctx = new VaropContext(_ctx, getState());
		enterRule(_localctx, 436, RULE_varop);
		try {
			setState(2770);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Hash:
			case Less:
			case Greater:
			case Ampersand:
			case Pipe:
			case Bang:
			case Caret:
			case Plus:
			case Minus:
			case Asterisk:
			case Percent:
			case Divide:
			case Tilde:
			case Atsign:
			case Dollar:
			case Dot:
			case QuestionMark:
			case Colon:
			case Eq:
			case ReverseSlash:
				enterOuterAlt(_localctx, 1);
				{
				setState(2765);
				varsym();
				}
				break;
			case BackQuote:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2766);
				match(BackQuote);
				setState(2767);
				varid();
				setState(2768);
				match(BackQuote);
				}
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

	public static class QopContext extends ParserRuleContext {
		public QvaropContext qvarop() {
			return getRuleContext(QvaropContext.class,0);
		}
		public QconopContext qconop() {
			return getRuleContext(QconopContext.class,0);
		}
		public QopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qop; }
	}

	public final QopContext qop() throws RecognitionException {
		QopContext _localctx = new QopContext(_ctx, getState());
		enterRule(_localctx, 438, RULE_qop);
		try {
			setState(2774);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,320,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2772);
				qvarop();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2773);
				qconop();
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

	public static class QopmContext extends ParserRuleContext {
		public QvaropmContext qvaropm() {
			return getRuleContext(QvaropmContext.class,0);
		}
		public QconopContext qconop() {
			return getRuleContext(QconopContext.class,0);
		}
		public Hole_opContext hole_op() {
			return getRuleContext(Hole_opContext.class,0);
		}
		public QopmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qopm; }
	}

	public final QopmContext qopm() throws RecognitionException {
		QopmContext _localctx = new QopmContext(_ctx, getState());
		enterRule(_localctx, 440, RULE_qopm);
		try {
			setState(2779);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,321,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2776);
				qvaropm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2777);
				qconop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2778);
				hole_op();
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

	public static class Hole_opContext extends ParserRuleContext {
		public List<TerminalNode> BackQuote() { return getTokens(HaskellParser.BackQuote); }
		public TerminalNode BackQuote(int i) {
			return getToken(HaskellParser.BackQuote, i);
		}
		public TerminalNode WILDCARD() { return getToken(HaskellParser.WILDCARD, 0); }
		public Hole_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hole_op; }
	}

	public final Hole_opContext hole_op() throws RecognitionException {
		Hole_opContext _localctx = new Hole_opContext(_ctx, getState());
		enterRule(_localctx, 442, RULE_hole_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2781);
			match(BackQuote);
			setState(2782);
			match(WILDCARD);
			setState(2783);
			match(BackQuote);
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

	public static class QvaropContext extends ParserRuleContext {
		public QvarsymContext qvarsym() {
			return getRuleContext(QvarsymContext.class,0);
		}
		public List<TerminalNode> BackQuote() { return getTokens(HaskellParser.BackQuote); }
		public TerminalNode BackQuote(int i) {
			return getToken(HaskellParser.BackQuote, i);
		}
		public QvaridContext qvarid() {
			return getRuleContext(QvaridContext.class,0);
		}
		public QvaropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qvarop; }
	}

	public final QvaropContext qvarop() throws RecognitionException {
		QvaropContext _localctx = new QvaropContext(_ctx, getState());
		enterRule(_localctx, 444, RULE_qvarop);
		try {
			setState(2790);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Hash:
			case Less:
			case Greater:
			case Ampersand:
			case Pipe:
			case Bang:
			case Caret:
			case Plus:
			case Minus:
			case Asterisk:
			case Percent:
			case Divide:
			case Tilde:
			case Atsign:
			case Dollar:
			case Dot:
			case QuestionMark:
			case Colon:
			case Eq:
			case ReverseSlash:
			case CONID:
				enterOuterAlt(_localctx, 1);
				{
				setState(2785);
				qvarsym();
				}
				break;
			case BackQuote:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2786);
				match(BackQuote);
				setState(2787);
				qvarid();
				setState(2788);
				match(BackQuote);
				}
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

	public static class QvaropmContext extends ParserRuleContext {
		public Qvarsym_no_minusContext qvarsym_no_minus() {
			return getRuleContext(Qvarsym_no_minusContext.class,0);
		}
		public List<TerminalNode> BackQuote() { return getTokens(HaskellParser.BackQuote); }
		public TerminalNode BackQuote(int i) {
			return getToken(HaskellParser.BackQuote, i);
		}
		public QvaridContext qvarid() {
			return getRuleContext(QvaridContext.class,0);
		}
		public QvaropmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qvaropm; }
	}

	public final QvaropmContext qvaropm() throws RecognitionException {
		QvaropmContext _localctx = new QvaropmContext(_ctx, getState());
		enterRule(_localctx, 446, RULE_qvaropm);
		try {
			setState(2797);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Hash:
			case Less:
			case Greater:
			case Ampersand:
			case Pipe:
			case Bang:
			case Caret:
			case Plus:
			case Minus:
			case Asterisk:
			case Percent:
			case Divide:
			case Tilde:
			case Atsign:
			case Dollar:
			case Dot:
			case QuestionMark:
			case Colon:
			case Eq:
			case ReverseSlash:
			case CONID:
				enterOuterAlt(_localctx, 1);
				{
				setState(2792);
				qvarsym_no_minus();
				}
				break;
			case BackQuote:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2793);
				match(BackQuote);
				setState(2794);
				qvarid();
				setState(2795);
				match(BackQuote);
				}
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

	public static class TyvarContext extends ParserRuleContext {
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public TyvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tyvar; }
	}

	public final TyvarContext tyvar() throws RecognitionException {
		TyvarContext _localctx = new TyvarContext(_ctx, getState());
		enterRule(_localctx, 448, RULE_tyvar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2799);
			varid();
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

	public static class TyvaropContext extends ParserRuleContext {
		public List<TerminalNode> BackQuote() { return getTokens(HaskellParser.BackQuote); }
		public TerminalNode BackQuote(int i) {
			return getToken(HaskellParser.BackQuote, i);
		}
		public TyvaridContext tyvarid() {
			return getRuleContext(TyvaridContext.class,0);
		}
		public TyvaropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tyvarop; }
	}

	public final TyvaropContext tyvarop() throws RecognitionException {
		TyvaropContext _localctx = new TyvaropContext(_ctx, getState());
		enterRule(_localctx, 450, RULE_tyvarop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2801);
			match(BackQuote);
			setState(2802);
			tyvarid();
			setState(2803);
			match(BackQuote);
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

	public static class TyvaridContext extends ParserRuleContext {
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public Special_idContext special_id() {
			return getRuleContext(Special_idContext.class,0);
		}
		public TerminalNode UNSAFE() { return getToken(HaskellParser.UNSAFE, 0); }
		public TerminalNode SAFE() { return getToken(HaskellParser.SAFE, 0); }
		public TerminalNode INTERRUPTIBLE() { return getToken(HaskellParser.INTERRUPTIBLE, 0); }
		public TyvaridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tyvarid; }
	}

	public final TyvaridContext tyvarid() throws RecognitionException {
		TyvaridContext _localctx = new TyvaridContext(_ctx, getState());
		enterRule(_localctx, 452, RULE_tyvarid);
		try {
			setState(2810);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,324,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2805);
				varid();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2806);
				special_id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2807);
				match(UNSAFE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2808);
				match(SAFE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2809);
				match(INTERRUPTIBLE);
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

	public static class TyclsContext extends ParserRuleContext {
		public ConidContext conid() {
			return getRuleContext(ConidContext.class,0);
		}
		public TyclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tycls; }
	}

	public final TyclsContext tycls() throws RecognitionException {
		TyclsContext _localctx = new TyclsContext(_ctx, getState());
		enterRule(_localctx, 454, RULE_tycls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2812);
			conid();
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

	public static class QtyclsContext extends ParserRuleContext {
		public TyclsContext tycls() {
			return getRuleContext(TyclsContext.class,0);
		}
		public ModidContext modid() {
			return getRuleContext(ModidContext.class,0);
		}
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public QtyclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qtycls; }
	}

	public final QtyclsContext qtycls() throws RecognitionException {
		QtyclsContext _localctx = new QtyclsContext(_ctx, getState());
		enterRule(_localctx, 456, RULE_qtycls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2817);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,325,_ctx) ) {
			case 1:
				{
				setState(2814);
				modid();
				setState(2815);
				match(Dot);
				}
				break;
			}
			setState(2819);
			tycls();
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

	public static class Var_Context extends ParserRuleContext {
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public VarsymContext varsym() {
			return getRuleContext(VarsymContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public Var_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_; }
	}

	public final Var_Context var_() throws RecognitionException {
		Var_Context _localctx = new Var_Context(_ctx, getState());
		enterRule(_localctx, 458, RULE_var_);
		try {
			setState(2826);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AS:
			case HIDING:
			case QUALIFIED:
			case EXPORT:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case VARID:
				enterOuterAlt(_localctx, 1);
				{
				setState(2821);
				varid();
				}
				break;
			case OpenRoundBracket:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2822);
				match(OpenRoundBracket);
				setState(2823);
				varsym();
				setState(2824);
				match(CloseRoundBracket);
				}
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

	public static class QvarContext extends ParserRuleContext {
		public QvaridContext qvarid() {
			return getRuleContext(QvaridContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public QvarsymContext qvarsym() {
			return getRuleContext(QvarsymContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public QvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qvar; }
	}

	public final QvarContext qvar() throws RecognitionException {
		QvarContext _localctx = new QvarContext(_ctx, getState());
		enterRule(_localctx, 460, RULE_qvar);
		try {
			setState(2833);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AS:
			case HIDING:
			case QUALIFIED:
			case EXPORT:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case STOCK:
			case ANYCLASS:
			case VIA:
			case VARID:
			case CONID:
				enterOuterAlt(_localctx, 1);
				{
				setState(2828);
				qvarid();
				}
				break;
			case OpenRoundBracket:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(2829);
				match(OpenRoundBracket);
				setState(2830);
				qvarsym();
				setState(2831);
				match(CloseRoundBracket);
				}
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

	public static class QvaridContext extends ParserRuleContext {
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public ModidContext modid() {
			return getRuleContext(ModidContext.class,0);
		}
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public QvaridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qvarid; }
	}

	public final QvaridContext qvarid() throws RecognitionException {
		QvaridContext _localctx = new QvaridContext(_ctx, getState());
		enterRule(_localctx, 462, RULE_qvarid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONID) {
				{
				setState(2835);
				modid();
				setState(2836);
				match(Dot);
				}
			}

			setState(2840);
			varid();
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

	public static class VaridContext extends ParserRuleContext {
		public TerminalNode VARID() { return getToken(HaskellParser.VARID, 0); }
		public Special_idContext special_id() {
			return getRuleContext(Special_idContext.class,0);
		}
		public List<TerminalNode> Hash() { return getTokens(HaskellParser.Hash); }
		public TerminalNode Hash(int i) {
			return getToken(HaskellParser.Hash, i);
		}
		public VaridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varid; }
	}

	public final VaridContext varid() throws RecognitionException {
		VaridContext _localctx = new VaridContext(_ctx, getState());
		enterRule(_localctx, 464, RULE_varid);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2844);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARID:
				{
				setState(2842);
				match(VARID);
				}
				break;
			case AS:
			case HIDING:
			case QUALIFIED:
			case EXPORT:
			case STDCALL:
			case CCALL:
			case CAPI:
			case JSCALL:
			case STOCK:
			case ANYCLASS:
			case VIA:
				{
				setState(2843);
				special_id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2849);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,330,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2846);
					match(Hash);
					}
					} 
				}
				setState(2851);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,330,_ctx);
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

	public static class QvarsymContext extends ParserRuleContext {
		public VarsymContext varsym() {
			return getRuleContext(VarsymContext.class,0);
		}
		public ModidContext modid() {
			return getRuleContext(ModidContext.class,0);
		}
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public QvarsymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qvarsym; }
	}

	public final QvarsymContext qvarsym() throws RecognitionException {
		QvarsymContext _localctx = new QvarsymContext(_ctx, getState());
		enterRule(_localctx, 466, RULE_qvarsym);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2855);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONID) {
				{
				setState(2852);
				modid();
				setState(2853);
				match(Dot);
				}
			}

			setState(2857);
			varsym();
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

	public static class Qvarsym_no_minusContext extends ParserRuleContext {
		public Varsym_no_minusContext varsym_no_minus() {
			return getRuleContext(Varsym_no_minusContext.class,0);
		}
		public QvarsymContext qvarsym() {
			return getRuleContext(QvarsymContext.class,0);
		}
		public Qvarsym_no_minusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qvarsym_no_minus; }
	}

	public final Qvarsym_no_minusContext qvarsym_no_minus() throws RecognitionException {
		Qvarsym_no_minusContext _localctx = new Qvarsym_no_minusContext(_ctx, getState());
		enterRule(_localctx, 468, RULE_qvarsym_no_minus);
		try {
			setState(2861);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,332,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2859);
				varsym_no_minus();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2860);
				qvarsym();
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

	public static class VarsymContext extends ParserRuleContext {
		public Varsym_no_minusContext varsym_no_minus() {
			return getRuleContext(Varsym_no_minusContext.class,0);
		}
		public TerminalNode Minus() { return getToken(HaskellParser.Minus, 0); }
		public VarsymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varsym; }
	}

	public final VarsymContext varsym() throws RecognitionException {
		VarsymContext _localctx = new VarsymContext(_ctx, getState());
		enterRule(_localctx, 470, RULE_varsym);
		try {
			setState(2865);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Hash:
			case Less:
			case Greater:
			case Ampersand:
			case Pipe:
			case Bang:
			case Caret:
			case Plus:
			case Asterisk:
			case Percent:
			case Divide:
			case Tilde:
			case Atsign:
			case Dollar:
			case Dot:
			case QuestionMark:
			case Colon:
			case Eq:
			case ReverseSlash:
				enterOuterAlt(_localctx, 1);
				{
				setState(2863);
				varsym_no_minus();
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 2);
				{
				setState(2864);
				match(Minus);
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

	public static class Varsym_no_minusContext extends ParserRuleContext {
		public List<AscSymbolContext> ascSymbol() {
			return getRuleContexts(AscSymbolContext.class);
		}
		public AscSymbolContext ascSymbol(int i) {
			return getRuleContext(AscSymbolContext.class,i);
		}
		public Varsym_no_minusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varsym_no_minus; }
	}

	public final Varsym_no_minusContext varsym_no_minus() throws RecognitionException {
		Varsym_no_minusContext _localctx = new Varsym_no_minusContext(_ctx, getState());
		enterRule(_localctx, 472, RULE_varsym_no_minus);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2868); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2867);
					ascSymbol();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2870); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,334,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Special_idContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(HaskellParser.AS, 0); }
		public TerminalNode QUALIFIED() { return getToken(HaskellParser.QUALIFIED, 0); }
		public TerminalNode HIDING() { return getToken(HaskellParser.HIDING, 0); }
		public TerminalNode EXPORT() { return getToken(HaskellParser.EXPORT, 0); }
		public TerminalNode STDCALL() { return getToken(HaskellParser.STDCALL, 0); }
		public TerminalNode CCALL() { return getToken(HaskellParser.CCALL, 0); }
		public TerminalNode CAPI() { return getToken(HaskellParser.CAPI, 0); }
		public TerminalNode JSCALL() { return getToken(HaskellParser.JSCALL, 0); }
		public TerminalNode STOCK() { return getToken(HaskellParser.STOCK, 0); }
		public TerminalNode ANYCLASS() { return getToken(HaskellParser.ANYCLASS, 0); }
		public TerminalNode VIA() { return getToken(HaskellParser.VIA, 0); }
		public Special_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_special_id; }
	}

	public final Special_idContext special_id() throws RecognitionException {
		Special_idContext _localctx = new Special_idContext(_ctx, getState());
		enterRule(_localctx, 474, RULE_special_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2872);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << HIDING) | (1L << QUALIFIED) | (1L << EXPORT) | (1L << STDCALL) | (1L << CCALL) | (1L << CAPI) | (1L << JSCALL) | (1L << STOCK) | (1L << ANYCLASS) | (1L << VIA))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class QconidContext extends ParserRuleContext {
		public ConidContext conid() {
			return getRuleContext(ConidContext.class,0);
		}
		public ModidContext modid() {
			return getRuleContext(ModidContext.class,0);
		}
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public QconidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qconid; }
	}

	public final QconidContext qconid() throws RecognitionException {
		QconidContext _localctx = new QconidContext(_ctx, getState());
		enterRule(_localctx, 476, RULE_qconid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2877);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
			case 1:
				{
				setState(2874);
				modid();
				setState(2875);
				match(Dot);
				}
				break;
			}
			setState(2879);
			conid();
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

	public static class ConidContext extends ParserRuleContext {
		public TerminalNode CONID() { return getToken(HaskellParser.CONID, 0); }
		public List<TerminalNode> Hash() { return getTokens(HaskellParser.Hash); }
		public TerminalNode Hash(int i) {
			return getToken(HaskellParser.Hash, i);
		}
		public ConidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conid; }
	}

	public final ConidContext conid() throws RecognitionException {
		ConidContext _localctx = new ConidContext(_ctx, getState());
		enterRule(_localctx, 478, RULE_conid);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2881);
			match(CONID);
			setState(2885);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,336,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2882);
					match(Hash);
					}
					} 
				}
				setState(2887);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,336,_ctx);
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

	public static class QconsymContext extends ParserRuleContext {
		public ConsymContext consym() {
			return getRuleContext(ConsymContext.class,0);
		}
		public ModidContext modid() {
			return getRuleContext(ModidContext.class,0);
		}
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public QconsymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qconsym; }
	}

	public final QconsymContext qconsym() throws RecognitionException {
		QconsymContext _localctx = new QconsymContext(_ctx, getState());
		enterRule(_localctx, 480, RULE_qconsym);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2891);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONID) {
				{
				setState(2888);
				modid();
				setState(2889);
				match(Dot);
				}
			}

			setState(2893);
			consym();
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

	public static class ConsymContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(HaskellParser.Colon, 0); }
		public List<AscSymbolContext> ascSymbol() {
			return getRuleContexts(AscSymbolContext.class);
		}
		public AscSymbolContext ascSymbol(int i) {
			return getRuleContext(AscSymbolContext.class,i);
		}
		public ConsymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consym; }
	}

	public final ConsymContext consym() throws RecognitionException {
		ConsymContext _localctx = new ConsymContext(_ctx, getState());
		enterRule(_localctx, 482, RULE_consym);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2895);
			match(Colon);
			setState(2899);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,338,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2896);
					ascSymbol();
					}
					} 
				}
				setState(2901);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,338,_ctx);
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

	public static class LiteralContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public PfloatContext pfloat() {
			return getRuleContext(PfloatContext.class,0);
		}
		public PcharContext pchar() {
			return getRuleContext(PcharContext.class,0);
		}
		public PstringContext pstring() {
			return getRuleContext(PstringContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 484, RULE_literal);
		try {
			setState(2906);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL:
			case OCTAL:
			case HEXADECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(2902);
				integer();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2903);
				pfloat();
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(2904);
				pchar();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(2905);
				pstring();
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

	public static class Open_Context extends ParserRuleContext {
		public TerminalNode VOCURLY() { return getToken(HaskellParser.VOCURLY, 0); }
		public TerminalNode OCURLY() { return getToken(HaskellParser.OCURLY, 0); }
		public Open_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_; }
	}

	public final Open_Context open_() throws RecognitionException {
		Open_Context _localctx = new Open_Context(_ctx, getState());
		enterRule(_localctx, 486, RULE_open_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2908);
			_la = _input.LA(1);
			if ( !(_la==OCURLY || _la==VOCURLY) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class CloseContext extends ParserRuleContext {
		public TerminalNode VCCURLY() { return getToken(HaskellParser.VCCURLY, 0); }
		public TerminalNode CCURLY() { return getToken(HaskellParser.CCURLY, 0); }
		public CloseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_close; }
	}

	public final CloseContext close() throws RecognitionException {
		CloseContext _localctx = new CloseContext(_ctx, getState());
		enterRule(_localctx, 488, RULE_close);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2910);
			_la = _input.LA(1);
			if ( !(_la==CCURLY || _la==VCCURLY) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class SemiContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(HaskellParser.Semi, 0); }
		public TerminalNode SEMI() { return getToken(HaskellParser.SEMI, 0); }
		public SemiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semi; }
	}

	public final SemiContext semi() throws RecognitionException {
		SemiContext _localctx = new SemiContext(_ctx, getState());
		enterRule(_localctx, 490, RULE_semi);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2912);
			_la = _input.LA(1);
			if ( !(_la==Semi || _la==SEMI) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ModidContext extends ParserRuleContext {
		public List<ConidContext> conid() {
			return getRuleContexts(ConidContext.class);
		}
		public ConidContext conid(int i) {
			return getRuleContext(ConidContext.class,i);
		}
		public List<TerminalNode> Dot() { return getTokens(HaskellParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(HaskellParser.Dot, i);
		}
		public ModidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modid; }
	}

	public final ModidContext modid() throws RecognitionException {
		ModidContext _localctx = new ModidContext(_ctx, getState());
		enterRule(_localctx, 492, RULE_modid);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2919);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,340,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2914);
					conid();
					setState(2915);
					match(Dot);
					}
					} 
				}
				setState(2921);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,340,_ctx);
			}
			setState(2922);
			conid();
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

	public static class CommasContext extends ParserRuleContext {
		public List<TerminalNode> Comma() { return getTokens(HaskellParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HaskellParser.Comma, i);
		}
		public CommasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commas; }
	}

	public final CommasContext commas() throws RecognitionException {
		CommasContext _localctx = new CommasContext(_ctx, getState());
		enterRule(_localctx, 494, RULE_commas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2925); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2924);
				match(Comma);
				}
				}
				setState(2927); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Comma );
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

	public static class BarsContext extends ParserRuleContext {
		public List<TerminalNode> Pipe() { return getTokens(HaskellParser.Pipe); }
		public TerminalNode Pipe(int i) {
			return getToken(HaskellParser.Pipe, i);
		}
		public BarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bars; }
	}

	public final BarsContext bars() throws RecognitionException {
		BarsContext _localctx = new BarsContext(_ctx, getState());
		enterRule(_localctx, 496, RULE_bars);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2930); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2929);
					match(Pipe);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2932); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,342,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class SpecialContext extends ParserRuleContext {
		public TerminalNode OpenRoundBracket() { return getToken(HaskellParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(HaskellParser.CloseRoundBracket, 0); }
		public TerminalNode Comma() { return getToken(HaskellParser.Comma, 0); }
		public TerminalNode Semi() { return getToken(HaskellParser.Semi, 0); }
		public TerminalNode OpenSquareBracket() { return getToken(HaskellParser.OpenSquareBracket, 0); }
		public TerminalNode CloseSquareBracket() { return getToken(HaskellParser.CloseSquareBracket, 0); }
		public TerminalNode BackQuote() { return getToken(HaskellParser.BackQuote, 0); }
		public TerminalNode OCURLY() { return getToken(HaskellParser.OCURLY, 0); }
		public TerminalNode CCURLY() { return getToken(HaskellParser.CCURLY, 0); }
		public SpecialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_special; }
	}

	public final SpecialContext special() throws RecognitionException {
		SpecialContext _localctx = new SpecialContext(_ctx, getState());
		enterRule(_localctx, 498, RULE_special);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2934);
			_la = _input.LA(1);
			if ( !(((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (Semi - 100)) | (1L << (Comma - 100)) | (1L << (BackQuote - 100)) | (1L << (OpenRoundBracket - 100)) | (1L << (CloseRoundBracket - 100)) | (1L << (OpenSquareBracket - 100)) | (1L << (CloseSquareBracket - 100)) | (1L << (OCURLY - 100)) | (1L << (CCURLY - 100)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class SymbolContext extends ParserRuleContext {
		public AscSymbolContext ascSymbol() {
			return getRuleContext(AscSymbolContext.class,0);
		}
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 500, RULE_symbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2936);
			ascSymbol();
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

	public static class AscSymbolContext extends ParserRuleContext {
		public TerminalNode Bang() { return getToken(HaskellParser.Bang, 0); }
		public TerminalNode Hash() { return getToken(HaskellParser.Hash, 0); }
		public TerminalNode Dollar() { return getToken(HaskellParser.Dollar, 0); }
		public TerminalNode Percent() { return getToken(HaskellParser.Percent, 0); }
		public TerminalNode Ampersand() { return getToken(HaskellParser.Ampersand, 0); }
		public TerminalNode Asterisk() { return getToken(HaskellParser.Asterisk, 0); }
		public TerminalNode Plus() { return getToken(HaskellParser.Plus, 0); }
		public TerminalNode Dot() { return getToken(HaskellParser.Dot, 0); }
		public TerminalNode Divide() { return getToken(HaskellParser.Divide, 0); }
		public TerminalNode Less() { return getToken(HaskellParser.Less, 0); }
		public TerminalNode Eq() { return getToken(HaskellParser.Eq, 0); }
		public TerminalNode Greater() { return getToken(HaskellParser.Greater, 0); }
		public TerminalNode QuestionMark() { return getToken(HaskellParser.QuestionMark, 0); }
		public TerminalNode Atsign() { return getToken(HaskellParser.Atsign, 0); }
		public TerminalNode ReverseSlash() { return getToken(HaskellParser.ReverseSlash, 0); }
		public TerminalNode Caret() { return getToken(HaskellParser.Caret, 0); }
		public TerminalNode Pipe() { return getToken(HaskellParser.Pipe, 0); }
		public TerminalNode Tilde() { return getToken(HaskellParser.Tilde, 0); }
		public TerminalNode Colon() { return getToken(HaskellParser.Colon, 0); }
		public AscSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ascSymbol; }
	}

	public final AscSymbolContext ascSymbol() throws RecognitionException {
		AscSymbolContext _localctx = new AscSymbolContext(_ctx, getState());
		enterRule(_localctx, 502, RULE_ascSymbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2938);
			_la = _input.LA(1);
			if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (Hash - 82)) | (1L << (Less - 82)) | (1L << (Greater - 82)) | (1L << (Ampersand - 82)) | (1L << (Pipe - 82)) | (1L << (Bang - 82)) | (1L << (Caret - 82)) | (1L << (Plus - 82)) | (1L << (Asterisk - 82)) | (1L << (Percent - 82)) | (1L << (Divide - 82)) | (1L << (Tilde - 82)) | (1L << (Atsign - 82)) | (1L << (Dollar - 82)) | (1L << (Dot - 82)) | (1L << (QuestionMark - 82)) | (1L << (Colon - 82)) | (1L << (Eq - 82)) | (1L << (ReverseSlash - 82)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(HaskellParser.DECIMAL, 0); }
		public TerminalNode OCTAL() { return getToken(HaskellParser.OCTAL, 0); }
		public TerminalNode HEXADECIMAL() { return getToken(HaskellParser.HEXADECIMAL, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 504, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2940);
			_la = _input.LA(1);
			if ( !(((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (DECIMAL - 137)) | (1L << (OCTAL - 137)) | (1L << (HEXADECIMAL - 137)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class PfloatContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(HaskellParser.FLOAT, 0); }
		public PfloatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pfloat; }
	}

	public final PfloatContext pfloat() throws RecognitionException {
		PfloatContext _localctx = new PfloatContext(_ctx, getState());
		enterRule(_localctx, 506, RULE_pfloat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2942);
			match(FLOAT);
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

	public static class PcharContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(HaskellParser.CHAR, 0); }
		public PcharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pchar; }
	}

	public final PcharContext pchar() throws RecognitionException {
		PcharContext _localctx = new PcharContext(_ctx, getState());
		enterRule(_localctx, 508, RULE_pchar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2944);
			match(CHAR);
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

	public static class PstringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(HaskellParser.STRING, 0); }
		public PstringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pstring; }
	}

	public final PstringContext pstring() throws RecognitionException {
		PstringContext _localctx = new PstringContext(_ctx, getState());
		enterRule(_localctx, 510, RULE_pstring);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2946);
			match(STRING);
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

	private static final int _serializedATNSegments = 2;
	private static final String _serializedATNSegment0 =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u008f\u0b87\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"+
		"\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"+
		"\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"+
		"\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"+
		"\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\4\u00bb"+
		"\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf\t\u00bf"+
		"\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3\4\u00c4"+
		"\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7\t\u00c7\4\u00c8\t\u00c8"+
		"\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\4\u00cc\t\u00cc\4\u00cd"+
		"\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf\4\u00d0\t\u00d0\4\u00d1\t\u00d1"+
		"\4\u00d2\t\u00d2\4\u00d3\t\u00d3\4\u00d4\t\u00d4\4\u00d5\t\u00d5\4\u00d6"+
		"\t\u00d6\4\u00d7\t\u00d7\4\u00d8\t\u00d8\4\u00d9\t\u00d9\4\u00da\t\u00da"+
		"\4\u00db\t\u00db\4\u00dc\t\u00dc\4\u00dd\t\u00dd\4\u00de\t\u00de\4\u00df"+
		"\t\u00df\4\u00e0\t\u00e0\4\u00e1\t\u00e1\4\u00e2\t\u00e2\4\u00e3\t\u00e3"+
		"\4\u00e4\t\u00e4\4\u00e5\t\u00e5\4\u00e6\t\u00e6\4\u00e7\t\u00e7\4\u00e8"+
		"\t\u00e8\4\u00e9\t\u00e9\4\u00ea\t\u00ea\4\u00eb\t\u00eb\4\u00ec\t\u00ec"+
		"\4\u00ed\t\u00ed\4\u00ee\t\u00ee\4\u00ef\t\u00ef\4\u00f0\t\u00f0\4\u00f1"+
		"\t\u00f1\4\u00f2\t\u00f2\4\u00f3\t\u00f3\4\u00f4\t\u00f4\4\u00f5\t\u00f5"+
		"\4\u00f6\t\u00f6\4\u00f7\t\u00f7\4\u00f8\t\u00f8\4\u00f9\t\u00f9\4\u00fa"+
		"\t\u00fa\4\u00fb\t\u00fb\4\u00fc\t\u00fc\4\u00fd\t\u00fd\4\u00fe\t\u00fe"+
		"\4\u00ff\t\u00ff\4\u0100\t\u0100\4\u0101\t\u0101\3\2\5\2\u0204\n\2\3\2"+
		"\7\2\u0207\n\2\f\2\16\2\u020a\13\2\3\2\5\2\u020d\n\2\3\2\7\2\u0210\n\2"+
		"\f\2\16\2\u0213\13\2\3\2\3\2\5\2\u0217\n\2\3\2\5\2\u021a\n\2\3\2\5\2\u021d"+
		"\n\2\3\2\3\2\3\3\3\3\3\3\5\3\u0224\n\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\7\5\u022f\n\5\f\5\16\5\u0232\13\5\3\6\6\6\u0235\n\6\r\6\16\6\u0236"+
		"\3\7\3\7\3\7\5\7\u023c\n\7\3\b\3\b\3\b\3\b\3\b\7\b\u0243\n\b\f\b\16\b"+
		"\u0246\13\b\3\b\3\b\5\b\u024a\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u0251\n\t\7"+
		"\t\u0253\n\t\f\t\16\t\u0256\13\t\3\t\3\t\5\t\u025a\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u0261\n\n\7\n\u0263\n\n\f\n\16\n\u0266\13\n\3\n\3\n\5\n\u026a"+
		"\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u0273\n\f\3\r\3\r\3\r\6\r\u0278"+
		"\n\r\r\r\16\r\u0279\3\16\3\16\3\16\3\16\7\16\u0280\n\16\f\16\16\16\u0283"+
		"\13\16\5\16\u0285\n\16\3\16\5\16\u0288\n\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\7\17\u0295\n\17\f\17\16\17\u0298\13\17\5"+
		"\17\u029a\n\17\3\17\5\17\u029d\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u02a7\n\17\f\17\16\17\u02aa\13\17\5\17\u02ac\n\17\3\17\5\17"+
		"\u02af\n\17\3\17\3\17\5\17\u02b3\n\17\3\20\3\20\5\20\u02b7\n\20\3\20\3"+
		"\20\3\20\5\20\u02bc\n\20\3\20\5\20\u02bf\n\20\3\20\6\20\u02c2\n\20\r\20"+
		"\16\20\u02c3\3\21\3\21\3\21\3\21\7\21\u02ca\n\21\f\21\16\21\u02cd\13\21"+
		"\3\21\5\21\u02d0\n\21\5\21\u02d2\n\21\3\21\3\21\3\21\3\21\3\21\3\21\7"+
		"\21\u02da\n\21\f\21\16\21\u02dd\13\21\3\21\5\21\u02e0\n\21\5\21\u02e2"+
		"\n\21\3\21\5\21\u02e5\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\7\22\u02f0\n\22\f\22\16\22\u02f3\13\22\5\22\u02f5\n\22\3\22\5\22\u02f8"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0300\n\22\3\22\5\22\u0303\n"+
		"\22\5\22\u0305\n\22\3\23\3\23\5\23\u0309\n\23\3\24\3\24\3\25\3\25\3\25"+
		"\7\25\u0310\n\25\f\25\16\25\u0313\13\25\3\26\3\26\6\26\u0317\n\26\r\26"+
		"\16\26\u0318\3\26\3\26\6\26\u031d\n\26\r\26\16\26\u031e\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u032a\n\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u0332\n\27\3\27\3\27\3\27\3\27\5\27\u0338\n\27\3\27\3\27\3"+
		"\27\3\27\5\27\u033e\n\27\3\27\3\27\3\27\3\27\5\27\u0344\n\27\3\30\3\30"+
		"\3\30\5\30\u0349\n\30\3\30\5\30\u034c\n\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\5\31\u0357\n\31\3\31\5\31\u035a\n\31\3\31\5\31\u035d"+
		"\n\31\3\31\3\31\5\31\u0361\n\31\3\31\3\31\3\31\5\31\u0366\n\31\3\31\3"+
		"\31\5\31\u036a\n\31\3\31\3\31\3\31\5\31\u036f\n\31\3\31\3\31\5\31\u0373"+
		"\n\31\3\31\3\31\5\31\u0377\n\31\3\31\5\31\u037a\n\31\3\31\5\31\u037d\n"+
		"\31\3\31\3\31\5\31\u0381\n\31\3\31\3\31\5\31\u0385\n\31\3\31\5\31\u0388"+
		"\n\31\3\31\5\31\u038b\n\31\3\31\3\31\3\31\3\31\5\31\u0391\n\31\5\31\u0393"+
		"\n\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\7\33\u039d\n\33\f\33\16"+
		"\33\u03a0\13\33\3\34\3\34\5\34\u03a4\n\34\3\34\3\34\5\34\u03a8\n\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\5\34\u03b0\n\34\3\34\3\34\5\34\u03b4\n\34"+
		"\3\34\3\34\3\34\5\34\u03b9\n\34\3\34\3\34\5\34\u03bd\n\34\3\34\3\34\3"+
		"\34\5\34\u03c2\n\34\3\34\3\34\5\34\u03c6\n\34\3\34\5\34\u03c9\n\34\3\34"+
		"\5\34\u03cc\n\34\3\34\3\34\3\34\5\34\u03d1\n\34\3\34\3\34\5\34\u03d5\n"+
		"\34\3\34\5\34\u03d8\n\34\3\34\5\34\u03db\n\34\5\34\u03dd\n\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u03eb\n\35\3\36"+
		"\3\36\3\37\3\37\3\37\3 \3 \3 \3 \5 \u03f6\n \3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3#\6#\u0400\n#\r#\16#\u0401\3$\3$\3$\3%\3%\5%\u0409\n%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\5%\u0414\n%\3&\3&\6&\u0418\n&\r&\16&\u0419\3&\3&\7&\u041e"+
		"\n&\f&\16&\u0421\13&\3&\7&\u0424\n&\f&\16&\u0427\13&\3\'\3\'\5\'\u042b"+
		"\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0436\n\'\3(\3(\5(\u043a"+
		"\n(\3(\3(\5(\u043e\n(\3(\3(\5(\u0442\n(\3(\3(\5(\u0446\n(\3(\3(\5(\u044a"+
		"\n(\3(\5(\u044d\n(\3)\3)\5)\u0451\n)\3)\3)\3)\5)\u0456\n)\3)\5)\u0459"+
		"\n)\3)\3)\3)\5)\u045e\n)\3)\3)\5)\u0462\n)\3)\5)\u0465\n)\3)\3)\3)\5)"+
		"\u046a\n)\3)\3)\5)\u046e\n)\3)\5)\u0471\n)\3)\3)\5)\u0475\n)\3)\5)\u0478"+
		"\n)\3)\5)\u047b\n)\3)\3)\5)\u047f\n)\3)\5)\u0482\n)\3)\3)\5)\u0486\n)"+
		"\3)\5)\u0489\n)\3)\5)\u048c\n)\5)\u048e\n)\3*\3*\3*\3+\3+\3+\3,\3,\3,"+
		"\3,\5,\u049a\n,\3-\3-\3-\3-\3-\3-\3-\5-\u04a3\n-\3.\3.\3.\3.\3.\5.\u04aa"+
		"\n.\3/\3/\5/\u04ae\n/\3/\3/\3/\3/\3/\3/\3/\5/\u04b7\n/\3/\3/\3/\3/\3/"+
		"\3/\3/\5/\u04c0\n/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u04cb"+
		"\n\60\3\61\3\61\5\61\u04cf\n\61\3\61\3\61\5\61\u04d3\n\61\3\61\3\61\3"+
		"\62\3\62\3\62\3\62\5\62\u04db\n\62\3\63\6\63\u04de\n\63\r\63\16\63\u04df"+
		"\3\64\3\64\5\64\u04e4\n\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\5\65\u04f0\n\65\5\65\u04f2\n\65\3\66\3\66\5\66\u04f6\n\66\3\66\3"+
		"\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0501\n\66\3\67\6\67\u0504"+
		"\n\67\r\67\16\67\u0505\38\38\38\78\u050b\n8\f8\168\u050e\138\39\39\39"+
		"\59\u0513\n9\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\5;\u0523\n;\3<"+
		"\3<\6<\u0527\n<\r<\16<\u0528\3<\3<\7<\u052d\n<\f<\16<\u0530\13<\3<\7<"+
		"\u0533\n<\f<\16<\u0536\13<\3=\3=\5=\u053a\n=\3=\3=\3>\3>\3>\3?\3?\5?\u0543"+
		"\n?\3@\3@\6@\u0547\n@\r@\16@\u0548\3@\3@\7@\u054d\n@\f@\16@\u0550\13@"+
		"\3@\7@\u0553\n@\f@\16@\u0556\13@\3A\3A\5A\u055a\nA\3A\3A\3B\3B\3B\3C\3"+
		"C\6C\u0563\nC\rC\16C\u0564\3C\3C\7C\u0569\nC\fC\16C\u056c\13C\3C\7C\u056f"+
		"\nC\fC\16C\u0572\13C\3D\3D\5D\u0576\nD\3D\3D\3E\3E\3E\5E\u057d\nE\3E\3"+
		"E\5E\u0581\nE\3F\3F\3F\3G\3G\3G\3G\7G\u058a\nG\fG\16G\u058d\13G\3G\5G"+
		"\u0590\nG\3H\3H\5H\u0594\nH\3H\5H\u0597\nH\3H\3H\3H\3H\3I\3I\5I\u059f"+
		"\nI\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\5J\u05ae\nJ\3K\3K\5K\u05b2"+
		"\nK\3K\3K\3K\5K\u05b7\nK\3K\5K\u05ba\nK\3L\6L\u05bd\nL\rL\16L\u05be\3"+
		"M\3M\3M\3M\3M\3M\3M\5M\u05c8\nM\3N\3N\3N\3N\7N\u05ce\nN\fN\16N\u05d1\13"+
		"N\3N\5N\u05d4\nN\3O\3O\3O\3P\3P\3P\3P\7P\u05dd\nP\fP\16P\u05e0\13P\3P"+
		"\5P\u05e3\nP\3Q\3Q\3Q\3R\3R\3R\5R\u05eb\nR\3R\5R\u05ee\nR\3S\3S\3S\7S"+
		"\u05f3\nS\fS\16S\u05f6\13S\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3"+
		"T\3T\3T\3T\5T\u060a\nT\3U\3U\3U\5U\u060f\nU\3U\3U\3U\3U\3U\3U\5U\u0617"+
		"\nU\3V\3V\3W\3W\3X\5X\u061e\nX\3X\3X\3X\3X\3Y\3Y\3Y\3Z\3Z\3Z\3[\3[\3\\"+
		"\3\\\3]\3]\3]\7]\u0631\n]\f]\16]\u0634\13]\3^\3^\3^\7^\u0639\n^\f^\16"+
		"^\u063c\13^\3_\3_\3_\3_\3_\3_\5_\u0644\n_\3`\3`\3a\3a\3a\3a\3a\5a\u064d"+
		"\na\3b\3b\3b\3b\3b\5b\u0654\nb\3c\3c\5c\u0658\nc\3c\3c\3c\3c\3c\3c\3c"+
		"\3c\3c\3c\3c\3c\5c\u0666\nc\3d\3d\5d\u066a\nd\3d\3d\3d\3d\3d\3d\3d\3d"+
		"\3d\3d\3d\3d\5d\u0678\nd\3e\3e\3f\3f\3g\3g\3g\3g\3g\5g\u0683\ng\3h\3h"+
		"\3h\3h\3h\5h\u068a\nh\3i\3i\3j\6j\u068f\nj\rj\16j\u0690\3k\3k\3l\3l\3"+
		"m\6m\u0698\nm\rm\16m\u0699\3n\3n\3n\3n\3n\3n\3n\3n\3n\3n\5n\u06a6\nn\3"+
		"o\3o\3o\3o\3o\3o\3o\3o\3o\5o\u06b1\no\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3"+
		"o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3"+
		"o\3o\3o\3o\3o\3o\3o\3o\5o\u06dc\no\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3"+
		"o\5o\u06ea\no\3p\3p\3q\3q\3q\7q\u06f1\nq\fq\16q\u06f4\13q\3r\3r\3r\7r"+
		"\u06f9\nr\fr\16r\u06fc\13r\3s\3s\3s\3s\3s\7s\u0703\ns\fs\16s\u0706\13"+
		"s\3t\6t\u0709\nt\rt\16t\u070a\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\5u\u0718"+
		"\nu\3v\3v\3v\3v\3v\3v\3v\5v\u0721\nv\3w\3w\3w\3x\3x\3x\7x\u0729\nx\fx"+
		"\16x\u072c\13x\3y\5y\u072f\ny\3y\3y\5y\u0733\ny\3z\6z\u0736\nz\rz\16z"+
		"\u0737\3{\3{\3|\3|\3|\5|\u073f\n|\3|\7|\u0742\n|\f|\16|\u0745\13|\3|\3"+
		"|\3}\3}\3}\3}\7}\u074d\n}\f}\16}\u0750\13}\3~\3~\3\177\3\177\3\177\3\177"+
		"\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081\3\u0081\7\u0081\u075e\n\u0081"+
		"\f\u0081\16\u0081\u0761\13\u0081\3\u0082\5\u0082\u0764\n\u0082\3\u0082"+
		"\3\u0082\3\u0082\5\u0082\u0769\n\u0082\3\u0082\3\u0082\3\u0083\3\u0083"+
		"\5\u0083\u076f\n\u0083\3\u0083\3\u0083\3\u0084\3\u0084\3\u0085\3\u0085"+
		"\3\u0085\7\u0085\u0778\n\u0085\f\u0085\16\u0085\u077b\13\u0085\3\u0086"+
		"\3\u0086\3\u0086\3\u0086\3\u0087\6\u0087\u0782\n\u0087\r\u0087\16\u0087"+
		"\u0783\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088"+
		"\3\u0088\3\u0088\5\u0088\u0790\n\u0088\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\5\u0089\u0799\n\u0089\3\u008a\3\u008a\3\u008a"+
		"\5\u008a\u079e\n\u008a\3\u008a\3\u008a\3\u008a\3\u008a\6\u008a\u07a4\n"+
		"\u008a\r\u008a\16\u008a\u07a5\5\u008a\u07a8\n\u008a\3\u008b\3\u008b\3"+
		"\u008b\6\u008b\u07ad\n\u008b\r\u008b\16\u008b\u07ae\5\u008b\u07b1\n\u008b"+
		"\3\u008c\3\u008c\3\u008c\5\u008c\u07b6\n\u008c\3\u008c\3\u008c\5\u008c"+
		"\u07ba\n\u008c\5\u008c\u07bc\n\u008c\3\u008d\6\u008d\u07bf\n\u008d\r\u008d"+
		"\16\u008d\u07c0\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\5\u008f\u07d4\n\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\5\u008f\u07dd\n\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\5\u008f\u07e4\n\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\5\u008f\u07ed\n\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\5\u008f\u07f4\n\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\3\u008f\5\u008f\u07fe\n\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\3\u008f\5\u008f\u080f\n\u008f\3\u008f\3\u008f\6\u008f"+
		"\u0813\n\u008f\r\u008f\16\u008f\u0814\5\u008f\u0817\n\u008f\3\u0090\3"+
		"\u0090\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090\5\u0090"+
		"\u0822\n\u0090\3\u0091\3\u0091\3\u0091\3\u0091\3\u0092\3\u0092\3\u0092"+
		"\3\u0092\3\u0093\3\u0093\5\u0093\u082e\n\u0093\3\u0094\3\u0094\3\u0094"+
		"\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094"+
		"\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094"+
		"\5\u0094\u0845\n\u0094\3\u0095\3\u0095\3\u0095\3\u0095\7\u0095\u084b\n"+
		"\u0095\f\u0095\16\u0095\u084e\13\u0095\3\u0096\3\u0096\3\u0097\5\u0097"+
		"\u0853\n\u0097\3\u0097\3\u0097\3\u0098\6\u0098\u0858\n\u0098\r\u0098\16"+
		"\u0098\u0859\3\u0098\3\u0098\5\u0098\u085e\n\u0098\3\u0099\3\u0099\3\u0099"+
		"\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099"+
		"\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099"+
		"\3\u0099\3\u0099\5\u0099\u0877\n\u0099\3\u0099\3\u0099\3\u0099\5\u0099"+
		"\u087c\n\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099"+
		"\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\5\u0099"+
		"\u088d\n\u0099\3\u009a\3\u009a\3\u009a\5\u009a\u0892\n\u009a\3\u009a\7"+
		"\u009a\u0895\n\u009a\f\u009a\16\u009a\u0898\13\u009a\3\u009b\3\u009b\3"+
		"\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\5\u009b\u08d9"+
		"\n\u009b\3\u009b\3\u009b\5\u009b\u08dd\n\u009b\3\u009c\3\u009c\5\u009c"+
		"\u08e1\n\u009c\3\u009d\3\u009d\3\u009d\3\u009e\3\u009e\3\u009e\3\u009f"+
		"\6\u009f\u08ea\n\u009f\r\u009f\16\u009f\u08eb\3\u00a0\3\u00a0\3\u00a1"+
		"\3\u00a1\5\u00a1\u08f2\n\u00a1\3\u00a1\3\u00a1\3\u00a2\3\u00a2\7\u00a2"+
		"\u08f8\n\u00a2\f\u00a2\16\u00a2\u08fb\13\u00a2\3\u00a3\3\u00a3\3\u00a3"+
		"\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3\5\u00a3"+
		"\u0908\n\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4"+
		"\3\u00a4\5\u00a4\u0912\n\u00a4\3\u00a4\3\u00a4\3\u00a4\5\u00a4\u0917\n"+
		"\u00a4\5\u00a4\u0919\n\u00a4\3\u00a5\3\u00a5\5\u00a5\u091d\n\u00a5\3\u00a6"+
		"\3\u00a6\3\u00a6\3\u00a6\5\u00a6\u0923\n\u00a6\3\u00a7\3\u00a7\3\u00a7"+
		"\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7"+
		"\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3\u00a7"+
		"\3\u00a7\3\u00a7\3\u00a7\5\u00a7\u093d\n\u00a7\3\u00a8\3\u00a8\3\u00a8"+
		"\3\u00a8\3\u00a8\7\u00a8\u0944\n\u00a8\f\u00a8\16\u00a8\u0947\13\u00a8"+
		"\3\u00a9\3\u00a9\3\u00aa\3\u00aa\3\u00aa\7\u00aa\u094e\n\u00aa\f\u00aa"+
		"\16\u00aa\u0951\13\u00aa\3\u00ab\3\u00ab\3\u00ab\7\u00ab\u0956\n\u00ab"+
		"\f\u00ab\16\u00ab\u0959\13\u00ab\3\u00ab\3\u00ab\3\u00ab\7\u00ab\u095e"+
		"\n\u00ab\f\u00ab\16\u00ab\u0961\13\u00ab\3\u00ab\3\u00ab\3\u00ab\7\u00ab"+
		"\u0966\n\u00ab\f\u00ab\16\u00ab\u0969\13\u00ab\3\u00ab\3\u00ab\3\u00ab"+
		"\7\u00ab\u096e\n\u00ab\f\u00ab\16\u00ab\u0971\13\u00ab\5\u00ab\u0973\n"+
		"\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ac\5\u00ac\u0987\n\u00ac\3\u00ad\3\u00ad\3\u00ad\7\u00ad\u098c\n"+
		"\u00ad\f\u00ad\16\u00ad\u098f\13\u00ad\3\u00ae\3\u00ae\3\u00ae\3\u00ae"+
		"\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u0998\n\u00ae\3\u00af\3\u00af\3\u00af"+
		"\7\u00af\u099d\n\u00af\f\u00af\16\u00af\u09a0\13\u00af\6\u00af\u09a2\n"+
		"\u00af\r\u00af\16\u00af\u09a3\3\u00af\3\u00af\3\u00af\3\u00af\3\u00af"+
		"\5\u00af\u09ab\n\u00af\3\u00b0\3\u00b0\3\u00b0\3\u00b1\3\u00b1\5\u00b1"+
		"\u09b2\n\u00b1\3\u00b2\3\u00b2\3\u00b2\5\u00b2\u09b7\n\u00b2\3\u00b3\6"+
		"\u00b3\u09ba\n\u00b3\r\u00b3\16\u00b3\u09bb\3\u00b4\3\u00b4\3\u00b4\3"+
		"\u00b4\3\u00b4\5\u00b4\u09c3\n\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3"+
		"\u00b5\3\u00b6\3\u00b6\3\u00b7\3\u00b7\3\u00b8\3\u00b8\3\u00b9\6\u00b9"+
		"\u09d1\n\u00b9\r\u00b9\16\u00b9\u09d2\3\u00ba\3\u00ba\3\u00ba\3\u00ba"+
		"\3\u00bb\3\u00bb\5\u00bb\u09db\n\u00bb\3\u00bb\3\u00bb\3\u00bc\3\u00bc"+
		"\6\u00bc\u09e1\n\u00bc\r\u00bc\16\u00bc\u09e2\3\u00bc\3\u00bc\7\u00bc"+
		"\u09e7\n\u00bc\f\u00bc\16\u00bc\u09ea\13\u00bc\3\u00bc\7\u00bc\u09ed\n"+
		"\u00bc\f\u00bc\16\u00bc\u09f0\13\u00bc\3\u00bd\3\u00bd\3\u00bd\3\u00bd"+
		"\6\u00bd\u09f6\n\u00bd\r\u00bd\16\u00bd\u09f7\5\u00bd\u09fa\n\u00bd\3"+
		"\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\5\u00be\u0a03\n"+
		"\u00be\3\u00bf\3\u00bf\3\u00bf\7\u00bf\u0a08\n\u00bf\f\u00bf\16\u00bf"+
		"\u0a0b\13\u00bf\3\u00bf\5\u00bf\u0a0e\n\u00bf\3\u00c0\3\u00c0\3\u00c0"+
		"\3\u00c0\3\u00c0\5\u00c0\u0a15\n\u00c0\3\u00c1\3\u00c1\6\u00c1\u0a19\n"+
		"\u00c1\r\u00c1\16\u00c1\u0a1a\3\u00c1\3\u00c1\3\u00c1\7\u00c1\u0a20\n"+
		"\u00c1\f\u00c1\16\u00c1\u0a23\13\u00c1\3\u00c2\3\u00c2\3\u00c2\3\u00c2"+
		"\3\u00c3\3\u00c3\3\u00c3\7\u00c3\u0a2c\n\u00c3\f\u00c3\16\u00c3\u0a2f"+
		"\13\u00c3\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c5\7\u00c5\u0a36\n\u00c5"+
		"\f\u00c5\16\u00c5\u0a39\13\u00c5\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6"+
		"\5\u00c6\u0a40\n\u00c6\3\u00c7\3\u00c7\3\u00c7\7\u00c7\u0a45\n\u00c7\f"+
		"\u00c7\16\u00c7\u0a48\13\u00c7\3\u00c8\3\u00c8\5\u00c8\u0a4c\n\u00c8\3"+
		"\u00c9\3\u00c9\5\u00c9\u0a50\n\u00c9\3\u00ca\3\u00ca\5\u00ca\u0a54\n\u00ca"+
		"\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb\5\u00cb\u0a5b\n\u00cb\3\u00cc"+
		"\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc\5\u00cc\u0a63\n\u00cc\3\u00cd"+
		"\3\u00cd\3\u00cd\7\u00cd\u0a68\n\u00cd\f\u00cd\16\u00cd\u0a6b\13\u00cd"+
		"\3\u00ce\3\u00ce\3\u00ce\3\u00ce\3\u00ce\3\u00ce\3\u00ce\3\u00ce\3\u00ce"+
		"\3\u00ce\3\u00ce\3\u00ce\5\u00ce\u0a79\n\u00ce\3\u00cf\3\u00cf\3\u00cf"+
		"\5\u00cf\u0a7e\n\u00cf\3\u00d0\3\u00d0\3\u00d0\3\u00d0\3\u00d0\5\u00d0"+
		"\u0a85\n\u00d0\3\u00d1\3\u00d1\3\u00d1\3\u00d1\3\u00d1\5\u00d1\u0a8c\n"+
		"\u00d1\3\u00d2\3\u00d2\5\u00d2\u0a90\n\u00d2\3\u00d3\3\u00d3\3\u00d3\3"+
		"\u00d3\3\u00d3\5\u00d3\u0a97\n\u00d3\3\u00d4\3\u00d4\3\u00d4\3\u00d4\3"+
		"\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4"+
		"\3\u00d4\5\u00d4\u0aa7\n\u00d4\3\u00d5\3\u00d5\3\u00d5\3\u00d5\3\u00d5"+
		"\5\u00d5\u0aae\n\u00d5\3\u00d6\3\u00d6\3\u00d6\3\u00d6\3\u00d6\5\u00d6"+
		"\u0ab5\n\u00d6\3\u00d7\3\u00d7\3\u00d7\5\u00d7\u0aba\n\u00d7\3\u00d7\3"+
		"\u00d7\3\u00d8\3\u00d8\3\u00d9\3\u00d9\3\u00d9\5\u00d9\u0ac3\n\u00d9\3"+
		"\u00da\3\u00da\3\u00da\3\u00da\3\u00da\5\u00da\u0aca\n\u00da\3\u00db\3"+
		"\u00db\5\u00db\u0ace\n\u00db\3\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dc\5"+
		"\u00dc\u0ad5\n\u00dc\3\u00dd\3\u00dd\5\u00dd\u0ad9\n\u00dd\3\u00de\3\u00de"+
		"\3\u00de\5\u00de\u0ade\n\u00de\3\u00df\3\u00df\3\u00df\3\u00df\3\u00e0"+
		"\3\u00e0\3\u00e0\3\u00e0\3\u00e0\5\u00e0\u0ae9\n\u00e0\3\u00e1\3\u00e1"+
		"\3\u00e1\3\u00e1\3\u00e1\5\u00e1\u0af0\n\u00e1\3\u00e2\3\u00e2\3\u00e3"+
		"\3\u00e3\3\u00e3\3\u00e3\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\5\u00e4"+
		"\u0afd\n\u00e4\3\u00e5\3\u00e5\3\u00e6\3\u00e6\3\u00e6\5\u00e6\u0b04\n"+
		"\u00e6\3\u00e6\3\u00e6\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7\5\u00e7"+
		"\u0b0d\n\u00e7\3\u00e8\3\u00e8\3\u00e8\3\u00e8\3\u00e8\5\u00e8\u0b14\n"+
		"\u00e8\3\u00e9\3\u00e9\3\u00e9\5\u00e9\u0b19\n\u00e9\3\u00e9\3\u00e9\3"+
		"\u00ea\3\u00ea\5\u00ea\u0b1f\n\u00ea\3\u00ea\7\u00ea\u0b22\n\u00ea\f\u00ea"+
		"\16\u00ea\u0b25\13\u00ea\3\u00eb\3\u00eb\3\u00eb\5\u00eb\u0b2a\n\u00eb"+
		"\3\u00eb\3\u00eb\3\u00ec\3\u00ec\5\u00ec\u0b30\n\u00ec\3\u00ed\3\u00ed"+
		"\5\u00ed\u0b34\n\u00ed\3\u00ee\6\u00ee\u0b37\n\u00ee\r\u00ee\16\u00ee"+
		"\u0b38\3\u00ef\3\u00ef\3\u00f0\3\u00f0\3\u00f0\5\u00f0\u0b40\n\u00f0\3"+
		"\u00f0\3\u00f0\3\u00f1\3\u00f1\7\u00f1\u0b46\n\u00f1\f\u00f1\16\u00f1"+
		"\u0b49\13\u00f1\3\u00f2\3\u00f2\3\u00f2\5\u00f2\u0b4e\n\u00f2\3\u00f2"+
		"\3\u00f2\3\u00f3\3\u00f3\7\u00f3\u0b54\n\u00f3\f\u00f3\16\u00f3\u0b57"+
		"\13\u00f3\3\u00f4\3\u00f4\3\u00f4\3\u00f4\5\u00f4\u0b5d\n\u00f4\3\u00f5"+
		"\3\u00f5\3\u00f6\3\u00f6\3\u00f7\3\u00f7\3\u00f8\3\u00f8\3\u00f8\7\u00f8"+
		"\u0b68\n\u00f8\f\u00f8\16\u00f8\u0b6b\13\u00f8\3\u00f8\3\u00f8\3\u00f9"+
		"\6\u00f9\u0b70\n\u00f9\r\u00f9\16\u00f9\u0b71\3\u00fa\6\u00fa\u0b75\n"+
		"\u00fa\r\u00fa\16\u00fa\u0b76\3\u00fb\3\u00fb\3\u00fc\3\u00fc\3\u00fd"+
		"\3\u00fd\3\u00fe\3\u00fe\3\u00ff\3\u00ff\3\u0100\3\u0100\3\u0101\3\u0101"+
		"\3\u0101\2\2\u0102\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce"+
		"\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6"+
		"\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe"+
		"\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116"+
		"\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e"+
		"\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146"+
		"\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e"+
		"\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174\u0176"+
		"\u0178\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188\u018a\u018c\u018e"+
		"\u0190\u0192\u0194\u0196\u0198\u019a\u019c\u019e\u01a0\u01a2\u01a4\u01a6"+
		"\u01a8\u01aa\u01ac\u01ae\u01b0\u01b2\u01b4\u01b6\u01b8\u01ba\u01bc\u01be"+
		"\u01c0\u01c2\u01c4\u01c6\u01c8\u01ca\u01cc\u01ce\u01d0\u01d2\u01d4\u01d6"+
		"\u01d8\u01da\u01dc\u01de\u01e0\u01e2\u01e4\u01e6\u01e8\u01ea\u01ec\u01ee"+
		"\u01f0\u01f2\u01f4\u01f6\u01f8\u01fa\u01fc\u01fe\u0200\2\16\3\2\22\24"+
		"\4\2\30\30\62\63\4\2()+,\3\2\"$\4\2NNee\t\2\6\6\16\16\32\32!!(*,,\62\64"+
		"\4\2\u0086\u0086\u0088\u0088\4\2\u0087\u0087\u0089\u0089\4\2ff\u008a\u008a"+
		"\7\2ffhhnnz}\u0086\u0087\t\2T[]acceeggijmm\3\2\u008b\u008d\2\u0c82\2\u0203"+
		"\3\2\2\2\4\u0220\3\2\2\2\6\u0227\3\2\2\2\b\u022a\3\2\2\2\n\u0234\3\2\2"+
		"\2\f\u023b\3\2\2\2\16\u023d\3\2\2\2\20\u024b\3\2\2\2\22\u025b\3\2\2\2"+
		"\24\u026b\3\2\2\2\26\u0272\3\2\2\2\30\u0277\3\2\2\2\32\u027b\3\2\2\2\34"+
		"\u02b2\3\2\2\2\36\u02b4\3\2\2\2 \u02e4\3\2\2\2\"\u0304\3\2\2\2$\u0308"+
		"\3\2\2\2&\u030a\3\2\2\2(\u030c\3\2\2\2*\u031c\3\2\2\2,\u0343\3\2\2\2."+
		"\u0345\3\2\2\2\60\u0392\3\2\2\2\62\u0394\3\2\2\2\64\u0399\3\2\2\2\66\u03dc"+
		"\3\2\2\28\u03ea\3\2\2\2:\u03ec\3\2\2\2<\u03ee\3\2\2\2>\u03f5\3\2\2\2@"+
		"\u03f7\3\2\2\2B\u03fa\3\2\2\2D\u03ff\3\2\2\2F\u0403\3\2\2\2H\u0413\3\2"+
		"\2\2J\u0415\3\2\2\2L\u0435\3\2\2\2N\u044c\3\2\2\2P\u048d\3\2\2\2R\u048f"+
		"\3\2\2\2T\u0492\3\2\2\2V\u0499\3\2\2\2X\u04a2\3\2\2\2Z\u04a9\3\2\2\2\\"+
		"\u04bf\3\2\2\2^\u04ca\3\2\2\2`\u04cc\3\2\2\2b\u04d6\3\2\2\2d\u04dd\3\2"+
		"\2\2f\u04e3\3\2\2\2h\u04f1\3\2\2\2j\u0500\3\2\2\2l\u0503\3\2\2\2n\u0507"+
		"\3\2\2\2p\u050f\3\2\2\2r\u0516\3\2\2\2t\u0522\3\2\2\2v\u0524\3\2\2\2x"+
		"\u0537\3\2\2\2z\u053d\3\2\2\2|\u0542\3\2\2\2~\u0544\3\2\2\2\u0080\u0557"+
		"\3\2\2\2\u0082\u055d\3\2\2\2\u0084\u0560\3\2\2\2\u0086\u0573\3\2\2\2\u0088"+
		"\u0580\3\2\2\2\u008a\u0582\3\2\2\2\u008c\u0585\3\2\2\2\u008e\u0591\3\2"+
		"\2\2\u0090\u059e\3\2\2\2\u0092\u05ad\3\2\2\2\u0094\u05af\3\2\2\2\u0096"+
		"\u05bc\3\2\2\2\u0098\u05c7\3\2\2\2\u009a\u05c9\3\2\2\2\u009c\u05d5\3\2"+
		"\2\2\u009e\u05d8\3\2\2\2\u00a0\u05e4\3\2\2\2\u00a2\u05ed\3\2\2\2\u00a4"+
		"\u05ef\3\2\2\2\u00a6\u0609\3\2\2\2\u00a8\u0616\3\2\2\2\u00aa\u0618\3\2"+
		"\2\2\u00ac\u061a\3\2\2\2\u00ae\u061d\3\2\2\2\u00b0\u0623\3\2\2\2\u00b2"+
		"\u0626\3\2\2\2\u00b4\u0629\3\2\2\2\u00b6\u062b\3\2\2\2\u00b8\u062d\3\2"+
		"\2\2\u00ba\u0635\3\2\2\2\u00bc\u0643\3\2\2\2\u00be\u0645\3\2\2\2\u00c0"+
		"\u064c\3\2\2\2\u00c2\u0653\3\2\2\2\u00c4\u0665\3\2\2\2\u00c6\u0677\3\2"+
		"\2\2\u00c8\u0679\3\2\2\2\u00ca\u067b\3\2\2\2\u00cc\u0682\3\2\2\2\u00ce"+
		"\u0689\3\2\2\2\u00d0\u068b\3\2\2\2\u00d2\u068e\3\2\2\2\u00d4\u0692\3\2"+
		"\2\2\u00d6\u0694\3\2\2\2\u00d8\u0697\3\2\2\2\u00da\u06a5\3\2\2\2\u00dc"+
		"\u06e9\3\2\2\2\u00de\u06eb\3\2\2\2\u00e0\u06ed\3\2\2\2\u00e2\u06f5\3\2"+
		"\2\2\u00e4\u06fd\3\2\2\2\u00e6\u0708\3\2\2\2\u00e8\u0717\3\2\2\2\u00ea"+
		"\u0720\3\2\2\2\u00ec\u0722\3\2\2\2\u00ee\u0725\3\2\2\2\u00f0\u072e\3\2"+
		"\2\2\u00f2\u0735\3\2\2\2\u00f4\u0739\3\2\2\2\u00f6\u073b\3\2\2\2\u00f8"+
		"\u0748\3\2\2\2\u00fa\u0751\3\2\2\2\u00fc\u0753\3\2\2\2\u00fe\u0757\3\2"+
		"\2\2\u0100\u075a\3\2\2\2\u0102\u0763\3\2\2\2\u0104\u076c\3\2\2\2\u0106"+
		"\u0772\3\2\2\2\u0108\u0774\3\2\2\2\u010a\u077c\3\2\2\2\u010c\u0781\3\2"+
		"\2\2\u010e\u078f\3\2\2\2\u0110\u0798\3\2\2\2\u0112\u07a7\3\2\2\2\u0114"+
		"\u07b0\3\2\2\2\u0116\u07bb\3\2\2\2\u0118\u07be\3\2\2\2\u011a\u07c2\3\2"+
		"\2\2\u011c\u0816\3\2\2\2\u011e\u0821\3\2\2\2\u0120\u0823\3\2\2\2\u0122"+
		"\u0827\3\2\2\2\u0124\u082d\3\2\2\2\u0126\u0844\3\2\2\2\u0128\u0846\3\2"+
		"\2\2\u012a\u084f\3\2\2\2\u012c\u0852\3\2\2\2\u012e\u0857\3\2\2\2\u0130"+
		"\u088c\3\2\2\2\u0132\u088e\3\2\2\2\u0134\u08dc\3\2\2\2\u0136\u08e0\3\2"+
		"\2\2\u0138\u08e2\3\2\2\2\u013a\u08e5\3\2\2\2\u013c\u08e9\3\2\2\2\u013e"+
		"\u08ed\3\2\2\2\u0140\u08ef\3\2\2\2\u0142\u08f5\3\2\2\2\u0144\u0907\3\2"+
		"\2\2\u0146\u0918\3\2\2\2\u0148\u091a\3\2\2\2\u014a\u0922\3\2\2\2\u014c"+
		"\u093c\3\2\2\2\u014e\u093e\3\2\2\2\u0150\u0948\3\2\2\2\u0152\u094a\3\2"+
		"\2\2\u0154\u0972\3\2\2\2\u0156\u0986\3\2\2\2\u0158\u0988\3\2\2\2\u015a"+
		"\u0997\3\2\2\2\u015c\u09aa\3\2\2\2\u015e\u09ac\3\2\2\2\u0160\u09af\3\2"+
		"\2\2\u0162\u09b6\3\2\2\2\u0164\u09b9\3\2\2\2\u0166\u09c2\3\2\2\2\u0168"+
		"\u09c4\3\2\2\2\u016a\u09c9\3\2\2\2\u016c\u09cb\3\2\2\2\u016e\u09cd\3\2"+
		"\2\2\u0170\u09d0\3\2\2\2\u0172\u09d4\3\2\2\2\u0174\u09d8\3\2\2\2\u0176"+
		"\u09de\3\2\2\2\u0178\u09f9\3\2\2\2\u017a\u0a02\3\2\2\2\u017c\u0a0d\3\2"+
		"\2\2\u017e\u0a14\3\2\2\2\u0180\u0a16\3\2\2\2\u0182\u0a24\3\2\2\2\u0184"+
		"\u0a28\3\2\2\2\u0186\u0a30\3\2\2\2\u0188\u0a32\3\2\2\2\u018a\u0a3f\3\2"+
		"\2\2\u018c\u0a41\3\2\2\2\u018e\u0a4b\3\2\2\2\u0190\u0a4f\3\2\2\2\u0192"+
		"\u0a53\3\2\2\2\u0194\u0a5a\3\2\2\2\u0196\u0a62\3\2\2\2\u0198\u0a64\3\2"+
		"\2\2\u019a\u0a78\3\2\2\2\u019c\u0a7d\3\2\2\2\u019e\u0a84\3\2\2\2\u01a0"+
		"\u0a8b\3\2\2\2\u01a2\u0a8f\3\2\2\2\u01a4\u0a96\3\2\2\2\u01a6\u0aa6\3\2"+
		"\2\2\u01a8\u0aad\3\2\2\2\u01aa\u0ab4\3\2\2\2\u01ac\u0ab9\3\2\2\2\u01ae"+
		"\u0abd\3\2\2\2\u01b0\u0ac2\3\2\2\2\u01b2\u0ac9\3\2\2\2\u01b4\u0acd\3\2"+
		"\2\2\u01b6\u0ad4\3\2\2\2\u01b8\u0ad8\3\2\2\2\u01ba\u0add\3\2\2\2\u01bc"+
		"\u0adf\3\2\2\2\u01be\u0ae8\3\2\2\2\u01c0\u0aef\3\2\2\2\u01c2\u0af1\3\2"+
		"\2\2\u01c4\u0af3\3\2\2\2\u01c6\u0afc\3\2\2\2\u01c8\u0afe\3\2\2\2\u01ca"+
		"\u0b03\3\2\2\2\u01cc\u0b0c\3\2\2\2\u01ce\u0b13\3\2\2\2\u01d0\u0b18\3\2"+
		"\2\2\u01d2\u0b1e\3\2\2\2\u01d4\u0b29\3\2\2\2\u01d6\u0b2f\3\2\2\2\u01d8"+
		"\u0b33\3\2\2\2\u01da\u0b36\3\2\2\2\u01dc\u0b3a\3\2\2\2\u01de\u0b3f\3\2"+
		"\2\2\u01e0\u0b43\3\2\2\2\u01e2\u0b4d\3\2\2\2\u01e4\u0b51\3\2\2\2\u01e6"+
		"\u0b5c\3\2\2\2\u01e8\u0b5e\3\2\2\2\u01ea\u0b60\3\2\2\2\u01ec\u0b62\3\2"+
		"\2\2\u01ee\u0b69\3\2\2\2\u01f0\u0b6f\3\2\2\2\u01f2\u0b74\3\2\2\2\u01f4"+
		"\u0b78\3\2\2\2\u01f6\u0b7a\3\2\2\2\u01f8\u0b7c\3\2\2\2\u01fa\u0b7e\3\2"+
		"\2\2\u01fc\u0b80\3\2\2\2\u01fe\u0b82\3\2\2\2\u0200\u0b84\3\2\2\2\u0202"+
		"\u0204\7\u0086\2\2\u0203\u0202\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0208"+
		"\3\2\2\2\u0205\u0207\5\u01ec\u00f7\2\u0206\u0205\3\2\2\2\u0207\u020a\3"+
		"\2\2\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020c\3\2\2\2\u020a"+
		"\u0208\3\2\2\2\u020b\u020d\5\n\6\2\u020c\u020b\3\2\2\2\u020c\u020d\3\2"+
		"\2\2\u020d\u0211\3\2\2\2\u020e\u0210\5\u01ec\u00f7\2\u020f\u020e\3\2\2"+
		"\2\u0210\u0213\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0216"+
		"\3\2\2\2\u0213\u0211\3\2\2\2\u0214\u0217\5\4\3\2\u0215\u0217\5\26\f\2"+
		"\u0216\u0214\3\2\2\2\u0216\u0215\3\2\2\2\u0217\u0219\3\2\2\2\u0218\u021a"+
		"\7\u0087\2\2\u0219\u0218\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021c\3\2\2"+
		"\2\u021b\u021d\5\u01ec\u00f7\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2\2"+
		"\u021d\u021e\3\2\2\2\u021e\u021f\7\2\2\3\u021f\3\3\2\2\2\u0220\u0221\7"+
		"\27\2\2\u0221\u0223\5\u01ee\u00f8\2\u0222\u0224\5\32\16\2\u0223\u0222"+
		"\3\2\2\2\u0223\u0224\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0226\5\6\4\2\u0226"+
		"\5\3\2\2\2\u0227\u0228\7\35\2\2\u0228\u0229\5\b\5\2\u0229\7\3\2\2\2\u022a"+
		"\u022b\5\u01e8\u00f5\2\u022b\u022c\5\26\f\2\u022c\u0230\5\u01ea\u00f6"+
		"\2\u022d\u022f\5\u01ec\u00f7\2\u022e\u022d\3\2\2\2\u022f\u0232\3\2\2\2"+
		"\u0230\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231\t\3\2\2\2\u0232\u0230\3"+
		"\2\2\2\u0233\u0235\5\f\7\2\u0234\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236"+
		"\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237\13\3\2\2\2\u0238\u023c\5\16\b"+
		"\2\u0239\u023c\5\20\t\2\u023a\u023c\5\22\n\2\u023b\u0238\3\2\2\2\u023b"+
		"\u0239\3\2\2\2\u023b\u023a\3\2\2\2\u023c\r\3\2\2\2\u023d\u023e\7\u0082"+
		"\2\2\u023e\u023f\7\65\2\2\u023f\u0244\5\24\13\2\u0240\u0241\7h\2\2\u0241"+
		"\u0243\5\24\13\2\u0242\u0240\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3"+
		"\2\2\2\u0244\u0245\3\2\2\2\u0245\u0247\3\2\2\2\u0246\u0244\3\2\2\2\u0247"+
		"\u0249\7\u0083\2\2\u0248\u024a\5\u01ec\u00f7\2\u0249\u0248\3\2\2\2\u0249"+
		"\u024a\3\2\2\2\u024a\17\3\2\2\2\u024b\u024c\7\u0082\2\2\u024c\u0254\7"+
		"\66\2\2\u024d\u0250\7\\\2\2\u024e\u0251\5\u01d2\u00ea\2\u024f\u0251\5"+
		"\u01e0\u00f1\2\u0250\u024e\3\2\2\2\u0250\u024f\3\2\2\2\u0251\u0253\3\2"+
		"\2\2\u0252\u024d\3\2\2\2\u0253\u0256\3\2\2\2\u0254\u0252\3\2\2\2\u0254"+
		"\u0255\3\2\2\2\u0255\u0257\3\2\2\2\u0256\u0254\3\2\2\2\u0257\u0259\7\u0083"+
		"\2\2\u0258\u025a\5\u01ec\u00f7\2\u0259\u0258\3\2\2\2\u0259\u025a\3\2\2"+
		"\2\u025a\21\3\2\2\2\u025b\u025c\7\u0082\2\2\u025c\u0264\7\67\2\2\u025d"+
		"\u0260\7\\\2\2\u025e\u0261\5\u01d2\u00ea\2\u025f\u0261\5\u01e0\u00f1\2"+
		"\u0260\u025e\3\2\2\2\u0260\u025f\3\2\2\2\u0261\u0263\3\2\2\2\u0262\u025d"+
		"\3\2\2\2\u0263\u0266\3\2\2\2\u0264\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265"+
		"\u0267\3\2\2\2\u0266\u0264\3\2\2\2\u0267\u0269\7\u0083\2\2\u0268\u026a"+
		"\5\u01ec\u00f7\2\u0269\u0268\3\2\2\2\u0269\u026a\3\2\2\2\u026a\23\3\2"+
		"\2\2\u026b\u026c\7\u0081\2\2\u026c\25\3\2\2\2\u026d\u026e\5\30\r\2\u026e"+
		"\u026f\5*\26\2\u026f\u0273\3\2\2\2\u0270\u0273\5\30\r\2\u0271\u0273\5"+
		"*\26\2\u0272\u026d\3\2\2\2\u0272\u0270\3\2\2\2\u0272\u0271\3\2\2\2\u0273"+
		"\27\3\2\2\2\u0274\u0278\5\36\20\2\u0275\u0278\7\3\2\2\u0276\u0278\5\u01ec"+
		"\u00f7\2\u0277\u0274\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0276\3\2\2\2\u0278"+
		"\u0279\3\2\2\2\u0279\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a\31\3\2\2"+
		"\2\u027b\u0284\7z\2\2\u027c\u0281\5\34\17\2\u027d\u027e\7h\2\2\u027e\u0280"+
		"\5\34\17\2\u027f\u027d\3\2\2\2\u0280\u0283\3\2\2\2\u0281\u027f\3\2\2\2"+
		"\u0281\u0282\3\2\2\2\u0282\u0285\3\2\2\2\u0283\u0281\3\2\2\2\u0284\u027c"+
		"\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0287\3\2\2\2\u0286\u0288\7h\2\2\u0287"+
		"\u0286\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a\7{"+
		"\2\2\u028a\33\3\2\2\2\u028b\u02b3\5\u01ce\u00e8\2\u028c\u029c\5\u01ac"+
		"\u00d7\2\u028d\u028e\7z\2\2\u028e\u028f\7d\2\2\u028f\u029d\7{\2\2\u0290"+
		"\u0299\7z\2\2\u0291\u0296\5$\23\2\u0292\u0293\7h\2\2\u0293\u0295\5$\23"+
		"\2\u0294\u0292\3\2\2\2\u0295\u0298\3\2\2\2\u0296\u0294\3\2\2\2\u0296\u0297"+
		"\3\2\2\2\u0297\u029a\3\2\2\2\u0298\u0296\3\2\2\2\u0299\u0291\3\2\2\2\u0299"+
		"\u029a\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029d\7{\2\2\u029c\u028d\3\2"+
		"\2\2\u029c\u0290\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u02b3\3\2\2\2\u029e"+
		"\u02ae\5\u01ca\u00e6\2\u029f\u02a0\7z\2\2\u02a0\u02a1\7d\2\2\u02a1\u02af"+
		"\7{\2\2\u02a2\u02ab\7z\2\2\u02a3\u02a8\5\u01ce\u00e8\2\u02a4\u02a5\7h"+
		"\2\2\u02a5\u02a7\5\u01ce\u00e8\2\u02a6\u02a4\3\2\2\2\u02a7\u02aa\3\2\2"+
		"\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02ac\3\2\2\2\u02aa\u02a8"+
		"\3\2\2\2\u02ab\u02a3\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad"+
		"\u02af\7{\2\2\u02ae\u029f\3\2\2\2\u02ae\u02a2\3\2\2\2\u02ae\u02af\3\2"+
		"\2\2\u02af\u02b3\3\2\2\2\u02b0\u02b1\7\27\2\2\u02b1\u02b3\5\u01ee\u00f8"+
		"\2\u02b2\u028b\3\2\2\2\u02b2\u028c\3\2\2\2\u02b2\u029e\3\2\2\2\u02b2\u02b0"+
		"\3\2\2\2\u02b3\35\3\2\2\2\u02b4\u02b6\7\20\2\2\u02b5\u02b7\7\32\2\2\u02b6"+
		"\u02b5\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02bb\5\u01ee"+
		"\u00f8\2\u02b9\u02ba\7\6\2\2\u02ba\u02bc\5\u01ee\u00f8\2\u02bb\u02b9\3"+
		"\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02be\3\2\2\2\u02bd\u02bf\5 \21\2\u02be"+
		"\u02bd\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf\u02c1\3\2\2\2\u02c0\u02c2\5\u01ec"+
		"\u00f7\2\u02c1\u02c0\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3"+
		"\u02c4\3\2\2\2\u02c4\37\3\2\2\2\u02c5\u02d1\7z\2\2\u02c6\u02cb\5\"\22"+
		"\2\u02c7\u02c8\7h\2\2\u02c8\u02ca\5\"\22\2\u02c9\u02c7\3\2\2\2\u02ca\u02cd"+
		"\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cf\3\2\2\2\u02cd"+
		"\u02cb\3\2\2\2\u02ce\u02d0\7h\2\2\u02cf\u02ce\3\2\2\2\u02cf\u02d0\3\2"+
		"\2\2\u02d0\u02d2\3\2\2\2\u02d1\u02c6\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2"+
		"\u02d3\3\2\2\2\u02d3\u02e5\7{\2\2\u02d4\u02d5\7\16\2\2\u02d5\u02e1\7z"+
		"\2\2\u02d6\u02db\5\"\22\2\u02d7\u02d8\7h\2\2\u02d8\u02da\5\"\22\2\u02d9"+
		"\u02d7\3\2\2\2\u02da\u02dd\3\2\2\2\u02db\u02d9\3\2\2\2\u02db\u02dc\3\2"+
		"\2\2\u02dc\u02df\3\2\2\2\u02dd\u02db\3\2\2\2\u02de\u02e0\7h\2\2\u02df"+
		"\u02de\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e2\3\2\2\2\u02e1\u02d6\3\2"+
		"\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e5\7{\2\2\u02e4"+
		"\u02c5\3\2\2\2\u02e4\u02d4\3\2\2\2\u02e5!\3\2\2\2\u02e6\u0305\5\u01cc"+
		"\u00e7\2\u02e7\u02f7\5\u01ae\u00d8\2\u02e8\u02e9\7z\2\2\u02e9\u02ea\7"+
		"d\2\2\u02ea\u02f8\7{\2\2\u02eb\u02f4\7z\2\2\u02ec\u02f1\5$\23\2\u02ed"+
		"\u02ee\7h\2\2\u02ee\u02f0\5$\23\2\u02ef\u02ed\3\2\2\2\u02f0\u02f3\3\2"+
		"\2\2\u02f1\u02ef\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02f5\3\2\2\2\u02f3"+
		"\u02f1\3\2\2\2\u02f4\u02ec\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f6\3\2"+
		"\2\2\u02f6\u02f8\7{\2\2\u02f7\u02e8\3\2\2\2\u02f7\u02eb\3\2\2\2\u02f7"+
		"\u02f8\3\2\2\2\u02f8\u0305\3\2\2\2\u02f9\u0302\5\u01c8\u00e5\2\u02fa\u02fb"+
		"\7z\2\2\u02fb\u02fc\7d\2\2\u02fc\u0303\7{\2\2\u02fd\u02ff\7z\2\2\u02fe"+
		"\u0300\5\u00b8]\2\u02ff\u02fe\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u0301"+
		"\3\2\2\2\u0301\u0303\7{\2\2\u0302\u02fa\3\2\2\2\u0302\u02fd\3\2\2\2\u0302"+
		"\u0303\3\2\2\2\u0303\u0305\3\2\2\2\u0304\u02e6\3\2\2\2\u0304\u02e7\3\2"+
		"\2\2\u0304\u02f9\3\2\2\2\u0305#\3\2\2\2\u0306\u0309\5\u01cc\u00e7\2\u0307"+
		"\u0309\5\u0196\u00cc\2\u0308\u0306\3\2\2\2\u0308\u0307\3\2\2\2\u0309%"+
		"\3\2\2\2\u030a\u030b\t\2\2\2\u030b\'\3\2\2\2\u030c\u0311\5\u01b4\u00db"+
		"\2\u030d\u030e\7h\2\2\u030e\u0310\5\u01b4\u00db\2\u030f\u030d\3\2\2\2"+
		"\u0310\u0313\3\2\2\2\u0311\u030f\3\2\2\2\u0311\u0312\3\2\2\2\u0312)\3"+
		"\2\2\2\u0313\u0311\3\2\2\2\u0314\u0316\5,\27\2\u0315\u0317\5\u01ec\u00f7"+
		"\2\u0316\u0315\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0316\3\2\2\2\u0318\u0319"+
		"\3\2\2\2\u0319\u031d\3\2\2\2\u031a\u031d\7\3\2\2\u031b\u031d\5\u01ec\u00f7"+
		"\2\u031c\u0314\3\2\2\2\u031c\u031a\3\2\2\2\u031c\u031b\3\2\2\2\u031d\u031e"+
		"\3\2\2\2\u031e\u031c\3\2\2\2\u031e\u031f\3\2\2\2\u031f+\3\2\2\2\u0320"+
		"\u0344\5.\30\2\u0321\u0344\5\60\31\2\u0322\u0344\5\62\32\2\u0323\u0344"+
		"\5\66\34\2\u0324\u0344\5`\61\2\u0325\u0344\5b\62\2\u0326\u0327\7\n\2\2"+
		"\u0327\u0329\7z\2\2\u0328\u032a\5\u00e2r\2\u0329\u0328\3\2\2\2\u0329\u032a"+
		"\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u0344\7{\2\2\u032c\u032d\7 \2\2\u032d"+
		"\u0344\5\u00a8U\2\u032e\u032f\7\u0082\2\2\u032f\u0331\7?\2\2\u0330\u0332"+
		"\5\u009eP\2\u0331\u0330\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0333\3\2\2"+
		"\2\u0333\u0344\7\u0083\2\2\u0334\u0335\7\u0082\2\2\u0335\u0337\7@\2\2"+
		"\u0336\u0338\5\u009aN\2\u0337\u0336\3\2\2\2\u0337\u0338\3\2\2\2\u0338"+
		"\u0339\3\2\2\2\u0339\u0344\7\u0083\2\2\u033a\u033b\7\u0082\2\2\u033b\u033d"+
		"\7=\2\2\u033c\u033e\5\u008cG\2\u033d\u033c\3\2\2\2\u033d\u033e\3\2\2\2"+
		"\u033e\u033f\3\2\2\2\u033f\u0344\7\u0083\2\2\u0340\u0344\5\u00a6T\2\u0341"+
		"\u0344\5\u0112\u008a\2\u0342\u0344\5\u0128\u0095\2\u0343\u0320\3\2\2\2"+
		"\u0343\u0321\3\2\2\2\u0343\u0322\3\2\2\2\u0343\u0323\3\2\2\2\u0343\u0324"+
		"\3\2\2\2\u0343\u0325\3\2\2\2\u0343\u0326\3\2\2\2\u0343\u032c\3\2\2\2\u0343"+
		"\u032e\3\2\2\2\u0343\u0334\3\2\2\2\u0343\u033a\3\2\2\2\u0343\u0340\3\2"+
		"\2\2\u0343\u0341\3\2\2\2\u0343\u0342\3\2\2\2\u0344-\3\2\2\2\u0345\u0346"+
		"\7\b\2\2\u0346\u0348\5Z.\2\u0347\u0349\5\u00ecw\2\u0348\u0347\3\2\2\2"+
		"\u0348\u0349\3\2\2\2\u0349\u034b\3\2\2\2\u034a\u034c\5z>\2\u034b\u034a"+
		"\3\2\2\2\u034b\u034c\3\2\2\2\u034c/\3\2\2\2\u034d\u034e\7\34\2\2\u034e"+
		"\u034f\5\u00ccg\2\u034f\u0350\7j\2\2\u0350\u0351\5\u00c2b\2\u0351\u0393"+
		"\3\2\2\2\u0352\u0353\7\34\2\2\u0353\u0354\7&\2\2\u0354\u0356\5\u00ccg"+
		"\2\u0355\u0357\5V,\2\u0356\u0355\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u0359"+
		"\3\2\2\2\u0358\u035a\5@!\2\u0359\u0358\3\2\2\2\u0359\u035a\3\2\2\2\u035a"+
		"\u035c\3\2\2\2\u035b\u035d\5F$\2\u035c\u035b\3\2\2\2\u035c\u035d\3\2\2"+
		"\2\u035d\u0393\3\2\2\2\u035e\u0360\7\t\2\2\u035f\u0361\5^\60\2\u0360\u035f"+
		"\3\2\2\2\u0360\u0361\3\2\2\2\u0361\u0362\3\2\2\2\u0362\u0363\5Z.\2\u0363"+
		"\u0365\5\u00fe\u0080\2\u0364\u0366\5\u010c\u0087\2\u0365\u0364\3\2\2\2"+
		"\u0365\u0366\3\2\2\2\u0366\u0393\3\2\2\2\u0367\u0369\7\30\2\2\u0368\u036a"+
		"\5^\60\2\u0369\u0368\3\2\2\2\u0369\u036a\3\2\2\2\u036a\u036b\3\2\2\2\u036b"+
		"\u036c\5Z.\2\u036c\u036e\5\u00fe\u0080\2\u036d\u036f\5\u010c\u0087\2\u036e"+
		"\u036d\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0393\3\2\2\2\u0370\u0372\7\t"+
		"\2\2\u0371\u0373\5^\60\2\u0372\u0371\3\2\2\2\u0372\u0373\3\2\2\2\u0373"+
		"\u0374\3\2\2\2\u0374\u0376\5Z.\2\u0375\u0377\5R*\2\u0376\u0375\3\2\2\2"+
		"\u0376\u0377\3\2\2\2\u0377\u0379\3\2\2\2\u0378\u037a\5\u00f6|\2\u0379"+
		"\u0378\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u037c\3\2\2\2\u037b\u037d\5\u010c"+
		"\u0087\2\u037c\u037b\3\2\2\2\u037c\u037d\3\2\2\2\u037d\u0393\3\2\2\2\u037e"+
		"\u0380\7\30\2\2\u037f\u0381\5^\60\2\u0380\u037f\3\2\2\2\u0380\u0381\3"+
		"\2\2\2\u0381\u0382\3\2\2\2\u0382\u0384\5Z.\2\u0383\u0385\5R*\2\u0384\u0383"+
		"\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u0387\3\2\2\2\u0386\u0388\5\u00f6|"+
		"\2\u0387\u0386\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u038a\3\2\2\2\u0389\u038b"+
		"\5\u010c\u0087\2\u038a\u0389\3\2\2\2\u038a\u038b\3\2\2\2\u038b\u0393\3"+
		"\2\2\2\u038c\u038d\7\t\2\2\u038d\u038e\7&\2\2\u038e\u0390\5\u00ccg\2\u038f"+
		"\u0391\5T+\2\u0390\u038f\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u0393\3\2\2"+
		"\2\u0392\u034d\3\2\2\2\u0392\u0352\3\2\2\2\u0392\u035e\3\2\2\2\u0392\u0367"+
		"\3\2\2\2\u0392\u0370\3\2\2\2\u0392\u037e\3\2\2\2\u0392\u038c\3\2\2\2\u0393"+
		"\61\3\2\2\2\u0394\u0395\7\34\2\2\u0395\u0396\5\64\33\2\u0396\u0397\7M"+
		"\2\2\u0397\u0398\5\u00c2b\2\u0398\63\3\2\2\2\u0399\u039e\5\u01a8\u00d5"+
		"\2\u039a\u039b\7h\2\2\u039b\u039d\5\u01a8\u00d5\2\u039c\u039a\3\2\2\2"+
		"\u039d\u03a0\3\2\2\2\u039e\u039c\3\2\2\2\u039e\u039f\3\2\2\2\u039f\65"+
		"\3\2\2\2\u03a0\u039e\3\2\2\2\u03a1\u03a3\7\25\2\2\u03a2\u03a4\58\35\2"+
		"\u03a3\u03a2\3\2\2\2\u03a3\u03a4\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a7"+
		"\5\u00dep\2\u03a6\u03a8\5\u0082B\2\u03a7\u03a6\3\2\2\2\u03a7\u03a8\3\2"+
		"\2\2\u03a8\u03dd\3\2\2\2\u03a9\u03aa\7\34\2\2\u03aa\u03ab\7\25\2\2\u03ab"+
		"\u03dd\5L\'\2\u03ac\u03ad\7\t\2\2\u03ad\u03af\7\25\2\2\u03ae\u03b0\5^"+
		"\60\2\u03af\u03ae\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1"+
		"\u03b3\5\\/\2\u03b2\u03b4\5\u010c\u0087\2\u03b3\u03b2\3\2\2\2\u03b3\u03b4"+
		"\3\2\2\2\u03b4\u03dd\3\2\2\2\u03b5\u03b6\7\30\2\2\u03b6\u03b8\7\25\2\2"+
		"\u03b7\u03b9\5^\60\2\u03b8\u03b7\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03ba"+
		"\3\2\2\2\u03ba\u03bc\5\\/\2\u03bb\u03bd\5\u010c\u0087\2\u03bc\u03bb\3"+
		"\2\2\2\u03bc\u03bd\3\2\2\2\u03bd\u03dd\3\2\2\2\u03be\u03bf\7\t\2\2\u03bf"+
		"\u03c1\7\25\2\2\u03c0\u03c2\5^\60\2\u03c1\u03c0\3\2\2\2\u03c1\u03c2\3"+
		"\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c5\5\\/\2\u03c4\u03c6\5R*\2\u03c5"+
		"\u03c4\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03c8\3\2\2\2\u03c7\u03c9\5\u00f6"+
		"|\2\u03c8\u03c7\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9\u03cb\3\2\2\2\u03ca"+
		"\u03cc\5\u010c\u0087\2\u03cb\u03ca\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc\u03dd"+
		"\3\2\2\2\u03cd\u03ce\7\30\2\2\u03ce\u03d0\7\25\2\2\u03cf\u03d1\5^\60\2"+
		"\u03d0\u03cf\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d4"+
		"\5\\/\2\u03d3\u03d5\5R*\2\u03d4\u03d3\3\2\2\2\u03d4\u03d5\3\2\2\2\u03d5"+
		"\u03d7\3\2\2\2\u03d6\u03d8\5\u00f6|\2\u03d7\u03d6\3\2\2\2\u03d7\u03d8"+
		"\3\2\2\2\u03d8\u03da\3\2\2\2\u03d9\u03db\5\u010c\u0087\2\u03da\u03d9\3"+
		"\2\2\2\u03da\u03db\3\2\2\2\u03db\u03dd\3\2\2\2\u03dc\u03a1\3\2\2\2\u03dc"+
		"\u03a9\3\2\2\2\u03dc\u03ac\3\2\2\2\u03dc\u03b5\3\2\2\2\u03dc\u03be\3\2"+
		"\2\2\u03dc\u03cd\3\2\2\2\u03dd\67\3\2\2\2\u03de\u03df\7\u0082\2\2\u03df"+
		"\u03e0\7G\2\2\u03e0\u03eb\7\u0083\2\2\u03e1\u03e2\7\u0082\2\2\u03e2\u03e3"+
		"\7F\2\2\u03e3\u03eb\7\u0083\2\2\u03e4\u03e5\7\u0082\2\2\u03e5\u03e6\7"+
		"H\2\2\u03e6\u03eb\7\u0083\2\2\u03e7\u03e8\7\u0082\2\2\u03e8\u03e9\7I\2"+
		"\2\u03e9\u03eb\7\u0083\2\2\u03ea\u03de\3\2\2\2\u03ea\u03e1\3\2\2\2\u03ea"+
		"\u03e4\3\2\2\2\u03ea\u03e7\3\2\2\2\u03eb9\3\2\2\2\u03ec\u03ed\t\3\2\2"+
		"\u03ed;\3\2\2\2\u03ee\u03ef\7\64\2\2\u03ef\u03f0\5\u00c0a\2\u03f0=\3\2"+
		"\2\2\u03f1\u03f6\7\62\2\2\u03f2\u03f6\7\63\2\2\u03f3\u03f6\7\30\2\2\u03f4"+
		"\u03f6\5<\37\2\u03f5\u03f1\3\2\2\2\u03f5\u03f2\3\2\2\2\u03f5\u03f3\3\2"+
		"\2\2\u03f5\u03f4\3\2\2\2\u03f6?\3\2\2\2\u03f7\u03f8\7X\2\2\u03f8\u03f9"+
		"\5B\"\2\u03f9A\3\2\2\2\u03fa\u03fb\5\u01c6\u00e4\2\u03fb\u03fc\7N\2\2"+
		"\u03fc\u03fd\5D#\2\u03fdC\3\2\2\2\u03fe\u0400\5\u01c6\u00e4\2\u03ff\u03fe"+
		"\3\2\2\2\u0400\u0401\3\2\2\2\u0401\u03ff\3\2\2\2\u0401\u0402\3\2\2\2\u0402"+
		"E\3\2\2\2\u0403\u0404\7\35\2\2\u0404\u0405\5H%\2\u0405G\3\2\2\2\u0406"+
		"\u0408\5\u01e8\u00f5\2\u0407\u0409\5J&\2\u0408\u0407\3\2\2\2\u0408\u0409"+
		"\3\2\2\2\u0409\u040a\3\2\2\2\u040a\u040b\5\u01ea\u00f6\2\u040b\u0414\3"+
		"\2\2\2\u040c\u040d\7\u0086\2\2\u040d\u040e\7d\2\2\u040e\u0414\7\u0087"+
		"\2\2\u040f\u0410\5\u01e8\u00f5\2\u0410\u0411\7d\2\2\u0411\u0412\5\u01ea"+
		"\u00f6\2\u0412\u0414\3\2\2\2\u0413\u0406\3\2\2\2\u0413\u040c\3\2\2\2\u0413"+
		"\u040f\3\2\2\2\u0414I\3\2\2\2\u0415\u041f\5L\'\2\u0416\u0418\5\u01ec\u00f7"+
		"\2\u0417\u0416\3\2\2\2\u0418\u0419\3\2\2\2\u0419\u0417\3\2\2\2\u0419\u041a"+
		"\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u041c\5L\'\2\u041c\u041e\3\2\2\2\u041d"+
		"\u0417\3\2\2\2\u041e\u0421\3\2\2\2\u041f\u041d\3\2\2\2\u041f\u0420\3\2"+
		"\2\2\u0420\u0425\3\2\2\2\u0421\u041f\3\2\2\2\u0422\u0424\5\u01ec\u00f7"+
		"\2\u0423\u0422\3\2\2\2\u0424\u0427\3\2\2\2\u0425\u0423\3\2\2\2\u0425\u0426"+
		"\3\2\2\2\u0426K\3\2\2\2\u0427\u0425\3\2\2\2\u0428\u042a\7\37\2\2\u0429"+
		"\u042b\5\u00e6t\2\u042a\u0429\3\2\2\2\u042a\u042b\3\2\2\2\u042b\u042c"+
		"\3\2\2\2\u042c\u042d\7e\2\2\u042d\u042e\5\u00ccg\2\u042e\u042f\7j\2\2"+
		"\u042f\u0430\5\u00c0a\2\u0430\u0436\3\2\2\2\u0431\u0432\5\u00ccg\2\u0432"+
		"\u0433\7j\2\2\u0433\u0434\5\u00c0a\2\u0434\u0436\3\2\2\2\u0435\u0428\3"+
		"\2\2\2\u0435\u0431\3\2\2\2\u0436M\3\2\2\2\u0437\u0439\7\t\2\2\u0438\u043a"+
		"\7&\2\2\u0439\u0438\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u043b\3\2\2\2\u043b"+
		"\u043d\5\u00ccg\2\u043c\u043e\5T+\2\u043d\u043c\3\2\2\2\u043d\u043e\3"+
		"\2\2\2\u043e\u044d\3\2\2\2\u043f\u0441\7\34\2\2\u0440\u0442\7&\2\2\u0441"+
		"\u0440\3\2\2\2\u0441\u0442\3\2\2\2\u0442\u0443\3\2\2\2\u0443\u0445\5\u00cc"+
		"g\2\u0444\u0446\5X-\2\u0445\u0444\3\2\2\2\u0445\u0446\3\2\2\2\u0446\u044d"+
		"\3\2\2\2\u0447\u0449\7\34\2\2\u0448\u044a\7\25\2\2\u0449\u0448\3\2\2\2"+
		"\u0449\u044a\3\2\2\2\u044a\u044b\3\2\2\2\u044b\u044d\5L\'\2\u044c\u0437"+
		"\3\2\2\2\u044c\u043f\3\2\2\2\u044c\u0447\3\2\2\2\u044dO\3\2\2\2\u044e"+
		"\u0450\7\34\2\2\u044f\u0451\7\25\2\2\u0450\u044f\3\2\2\2\u0450\u0451\3"+
		"\2\2\2\u0451\u0452\3\2\2\2\u0452\u048e\5L\'\2\u0453\u0455\7\t\2\2\u0454"+
		"\u0456\7\25\2\2\u0455\u0454\3\2\2\2\u0455\u0456\3\2\2\2\u0456\u0458\3"+
		"\2\2\2\u0457\u0459\5^\60\2\u0458\u0457\3\2\2\2\u0458\u0459\3\2\2\2\u0459"+
		"\u045a\3\2\2\2\u045a\u045b\5\\/\2\u045b\u045d\5\u00fe\u0080\2\u045c\u045e"+
		"\5\u010c\u0087\2\u045d\u045c\3\2\2\2\u045d\u045e\3\2\2\2\u045e\u048e\3"+
		"\2\2\2\u045f\u0461\7\30\2\2\u0460\u0462\7\25\2\2\u0461\u0460\3\2\2\2\u0461"+
		"\u0462\3\2\2\2\u0462\u0464\3\2\2\2\u0463\u0465\5^\60\2\u0464\u0463\3\2"+
		"\2\2\u0464\u0465\3\2\2\2\u0465\u0466\3\2\2\2\u0466\u0467\5\\/\2\u0467"+
		"\u0469\5\u00fe\u0080\2\u0468\u046a\5\u010c\u0087\2\u0469\u0468\3\2\2\2"+
		"\u0469\u046a\3\2\2\2\u046a\u048e\3\2\2\2\u046b\u046d\7\t\2\2\u046c\u046e"+
		"\7\25\2\2\u046d\u046c\3\2\2\2\u046d\u046e\3\2\2\2\u046e\u0470\3\2\2\2"+
		"\u046f\u0471\5^\60\2\u0470\u046f\3\2\2\2\u0470\u0471\3\2\2\2\u0471\u0472"+
		"\3\2\2\2\u0472\u0474\5\\/\2\u0473\u0475\5R*\2\u0474\u0473\3\2\2\2\u0474"+
		"\u0475\3\2\2\2\u0475\u0477\3\2\2\2\u0476\u0478\5\u00f6|\2\u0477\u0476"+
		"\3\2\2\2\u0477\u0478\3\2\2\2\u0478\u047a\3\2\2\2\u0479\u047b\5\u010c\u0087"+
		"\2\u047a\u0479\3\2\2\2\u047a\u047b\3\2\2\2\u047b\u048e\3\2\2\2\u047c\u047e"+
		"\7\30\2\2\u047d\u047f\7\25\2\2\u047e\u047d\3\2\2\2\u047e\u047f\3\2\2\2"+
		"\u047f\u0481\3\2\2\2\u0480\u0482\5^\60\2\u0481\u0480\3\2\2\2\u0481\u0482"+
		"\3\2\2\2\u0482\u0483\3\2\2\2\u0483\u0485\5\\/\2\u0484\u0486\5R*\2\u0485"+
		"\u0484\3\2\2\2\u0485\u0486\3\2\2\2\u0486\u0488\3\2\2\2\u0487\u0489\5\u00f6"+
		"|\2\u0488\u0487\3\2\2\2\u0488\u0489\3\2\2\2\u0489\u048b\3\2\2\2\u048a"+
		"\u048c\5\u010c\u0087\2\u048b\u048a\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u048e"+
		"\3\2\2\2\u048d\u044e\3\2\2\2\u048d\u0453\3\2\2\2\u048d\u045f\3\2\2\2\u048d"+
		"\u046b\3\2\2\2\u048d\u047c\3\2\2\2\u048eQ\3\2\2\2\u048f\u0490\7M\2\2\u0490"+
		"\u0491\5\u00f4{\2\u0491S\3\2\2\2\u0492\u0493\7M\2\2\u0493\u0494\5\u00f4"+
		"{\2\u0494U\3\2\2\2\u0495\u0496\7M\2\2\u0496\u049a\5\u00f4{\2\u0497\u0498"+
		"\7j\2\2\u0498\u049a\5\u00e8u\2\u0499\u0495\3\2\2\2\u0499\u0497\3\2\2\2"+
		"\u049aW\3\2\2\2\u049b\u049c\7M\2\2\u049c\u04a3\5\u00f4{\2\u049d\u049e"+
		"\7j\2\2\u049e\u049f\5\u00eav\2\u049f\u04a0\7X\2\2\u04a0\u04a1\5B\"\2\u04a1"+
		"\u04a3\3\2\2\2\u04a2\u049b\3\2\2\2\u04a2\u049d\3\2\2\2\u04a3Y\3\2\2\2"+
		"\u04a4\u04a5\5\u00c8e\2\u04a5\u04a6\7L\2\2\u04a6\u04a7\5\u00ccg\2\u04a7"+
		"\u04aa\3\2\2\2\u04a8\u04aa\5\u00ccg\2\u04a9\u04a4\3\2\2\2\u04a9\u04a8"+
		"\3\2\2\2\u04aa[\3\2\2\2\u04ab\u04ad\7\37\2\2\u04ac\u04ae\5\u00e6t\2\u04ad"+
		"\u04ac\3\2\2\2\u04ad\u04ae\3\2\2\2\u04ae\u04af\3\2\2\2\u04af\u04b0\7e"+
		"\2\2\u04b0\u04b1\5\u00c8e\2\u04b1\u04b2\7L\2\2\u04b2\u04b3\5\u00ccg\2"+
		"\u04b3\u04c0\3\2\2\2\u04b4\u04b6\7\37\2\2\u04b5\u04b7\5\u00e6t\2\u04b6"+
		"\u04b5\3\2\2\2\u04b6\u04b7\3\2\2\2\u04b7\u04b8\3\2\2\2\u04b8\u04b9\7e"+
		"\2\2\u04b9\u04c0\5\u00ccg\2\u04ba\u04bb\5\u00c8e\2\u04bb\u04bc\7L\2\2"+
		"\u04bc\u04bd\5\u00ccg\2\u04bd\u04c0\3\2\2\2\u04be\u04c0\5\u00ccg\2\u04bf"+
		"\u04ab\3\2\2\2\u04bf\u04b4\3\2\2\2\u04bf\u04ba\3\2\2\2\u04bf\u04be\3\2"+
		"\2\2\u04c0]\3\2\2\2\u04c1\u04c2\7\u0082\2\2\u04c2\u04c3\7E\2\2\u04c3\u04c4"+
		"\7\177\2\2\u04c4\u04c5\7\177\2\2\u04c5\u04cb\7\u0083\2\2\u04c6\u04c7\7"+
		"\u0082\2\2\u04c7\u04c8\7E\2\2\u04c8\u04c9\7\177\2\2\u04c9\u04cb\7\u0083"+
		"\2\2\u04ca\u04c1\3\2\2\2\u04ca\u04c6\3\2\2\2\u04cb_\3\2\2\2\u04cc\u04ce"+
		"\7\13\2\2\u04cd\u04cf\5> \2\u04ce\u04cd\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf"+
		"\u04d0\3\2\2\2\u04d0\u04d2\7\25\2\2\u04d1\u04d3\58\35\2\u04d2\u04d1\3"+
		"\2\2\2\u04d2\u04d3\3\2\2\2\u04d3\u04d4\3\2\2\2\u04d4\u04d5\5\u00dep\2"+
		"\u04d5a\3\2\2\2\u04d6\u04d7\7\34\2\2\u04d7\u04d8\7\'\2\2\u04d8\u04da\5"+
		"\u01a8\u00d5\2\u04d9\u04db\5d\63\2\u04da\u04d9\3\2\2\2\u04da\u04db\3\2"+
		"\2\2\u04dbc\3\2\2\2\u04dc\u04de\5f\64\2\u04dd\u04dc\3\2\2\2\u04de\u04df"+
		"\3\2\2\2\u04df\u04dd\3\2\2\2\u04df\u04e0\3\2\2\2\u04e0e\3\2\2\2\u04e1"+
		"\u04e4\5\u01d2\u00ea\2\u04e2\u04e4\7\36\2\2\u04e3\u04e1\3\2\2\2\u04e3"+
		"\u04e2\3\2\2\2\u04e4g\3\2\2\2\u04e5\u04e6\7\61\2\2\u04e6\u04e7\5j\66\2"+
		"\u04e7\u04e8\7j\2\2\u04e8\u04e9\5\u016a\u00b6\2\u04e9\u04f2\3\2\2\2\u04ea"+
		"\u04eb\7\61\2\2\u04eb\u04ec\5j\66\2\u04ec\u04ed\7O\2\2\u04ed\u04ef\5\u016a"+
		"\u00b6\2\u04ee\u04f0\5p9\2\u04ef\u04ee\3\2\2\2\u04ef\u04f0\3\2\2\2\u04f0"+
		"\u04f2\3\2\2\2\u04f1\u04e5\3\2\2\2\u04f1\u04ea\3\2\2\2\u04f2i\3\2\2\2"+
		"\u04f3\u04f5\5\u0196\u00cc\2\u04f4\u04f6\5l\67\2\u04f5\u04f4\3\2\2\2\u04f5"+
		"\u04f6\3\2\2\2\u04f6\u0501\3\2\2\2\u04f7\u04f8\5\u01d2\u00ea\2\u04f8\u04f9"+
		"\5\u019e\u00d0\2\u04f9\u04fa\5\u01d2\u00ea\2\u04fa\u0501\3\2\2\2\u04fb"+
		"\u04fc\5\u0196\u00cc\2\u04fc\u04fd\7\u0086\2\2\u04fd\u04fe\5n8\2\u04fe"+
		"\u04ff\7\u0087\2\2\u04ff\u0501\3\2\2\2\u0500\u04f3\3\2\2\2\u0500\u04f7"+
		"\3\2\2\2\u0500\u04fb\3\2\2\2\u0501k\3\2\2\2\u0502\u0504\5\u01d2\u00ea"+
		"\2\u0503\u0502\3\2\2\2\u0504\u0505\3\2\2\2\u0505\u0503\3\2\2\2\u0505\u0506"+
		"\3\2\2\2\u0506m\3\2\2\2\u0507\u050c\5\u01cc\u00e7\2\u0508\u0509\7h\2\2"+
		"\u0509\u050b\5\u01cc\u00e7\2\u050a\u0508\3\2\2\2\u050b\u050e\3\2\2\2\u050c"+
		"\u050a\3\2\2\2\u050c\u050d\3\2\2\2\u050do\3\2\2\2\u050e\u050c\3\2\2\2"+
		"\u050f\u0510\7\35\2\2\u0510\u0512\5\u01e8\u00f5\2\u0511\u0513\5\u0084"+
		"C\2\u0512\u0511\3\2\2\2\u0512\u0513\3\2\2\2\u0513\u0514\3\2\2\2\u0514"+
		"\u0515\5\u01ea\u00f6\2\u0515q\3\2\2\2\u0516\u0517\7\61\2\2\u0517\u0518"+
		"\5\u0198\u00cd\2\u0518\u0519\7M\2\2\u0519\u051a\5\u00b6\\\2\u051as\3\2"+
		"\2\2\u051b\u0523\5N(\2\u051c\u0523\5\u0114\u008b\2\u051d\u051e\7\n\2\2"+
		"\u051e\u051f\5\u0128\u0095\2\u051f\u0520\7M\2\2\u0520\u0521\5\u00b6\\"+
		"\2\u0521\u0523\3\2\2\2\u0522\u051b\3\2\2\2\u0522\u051c\3\2\2\2\u0522\u051d"+
		"\3\2\2\2\u0523u\3\2\2\2\u0524\u052e\5t;\2\u0525\u0527\5\u01ec\u00f7\2"+
		"\u0526\u0525\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u0526\3\2\2\2\u0528\u0529"+
		"\3\2\2\2\u0529\u052a\3\2\2\2\u052a\u052b\5t;\2\u052b\u052d\3\2\2\2\u052c"+
		"\u0526\3\2\2\2\u052d\u0530\3\2\2\2\u052e\u052c\3\2\2\2\u052e\u052f\3\2"+
		"\2\2\u052f\u0534\3\2\2\2\u0530\u052e\3\2\2\2\u0531\u0533\5\u01ec\u00f7"+
		"\2\u0532\u0531\3\2\2\2\u0533\u0536\3\2\2\2\u0534\u0532\3\2\2\2\u0534\u0535"+
		"\3\2\2\2\u0535w\3\2\2\2\u0536\u0534\3\2\2\2\u0537\u0539\5\u01e8\u00f5"+
		"\2\u0538\u053a\5v<\2\u0539\u0538\3\2\2\2\u0539\u053a\3\2\2\2\u053a\u053b"+
		"\3\2\2\2\u053b\u053c\5\u01ea\u00f6\2\u053cy\3\2\2\2\u053d\u053e\7\35\2"+
		"\2\u053e\u053f\5x=\2\u053f{\3\2\2\2\u0540\u0543\5P)\2\u0541\u0543\5\u0114"+
		"\u008b\2\u0542\u0540\3\2\2\2\u0542\u0541\3\2\2\2\u0543}\3\2\2\2\u0544"+
		"\u054e\5|?\2\u0545\u0547\5\u01ec\u00f7\2\u0546\u0545\3\2\2\2\u0547\u0548"+
		"\3\2\2\2\u0548\u0546\3\2\2\2\u0548\u0549\3\2\2\2\u0549\u054a\3\2\2\2\u054a"+
		"\u054b\5|?\2\u054b\u054d\3\2\2\2\u054c\u0546\3\2\2\2\u054d\u0550\3\2\2"+
		"\2\u054e\u054c\3\2\2\2\u054e\u054f\3\2\2\2\u054f\u0554\3\2\2\2\u0550\u054e"+
		"\3\2\2\2\u0551\u0553\5\u01ec\u00f7\2\u0552\u0551\3\2\2\2\u0553\u0556\3"+
		"\2\2\2\u0554\u0552\3\2\2\2\u0554\u0555\3\2\2\2\u0555\177\3\2\2\2\u0556"+
		"\u0554\3\2\2\2\u0557\u0559\5\u01e8\u00f5\2\u0558\u055a\5~@\2\u0559\u0558"+
		"\3\2\2\2\u0559\u055a\3\2\2\2\u055a\u055b\3\2\2\2\u055b\u055c\5\u01ea\u00f6"+
		"\2\u055c\u0081\3\2\2\2\u055d\u055e\7\35\2\2\u055e\u055f\5\u0080A\2\u055f"+
		"\u0083\3\2\2\2\u0560\u056a\5\u0114\u008b\2\u0561\u0563\5\u01ec\u00f7\2"+
		"\u0562\u0561\3\2\2\2\u0563\u0564\3\2\2\2\u0564\u0562\3\2\2\2\u0564\u0565"+
		"\3\2\2\2\u0565\u0566\3\2\2\2\u0566\u0567\5\u0114\u008b\2\u0567\u0569\3"+
		"\2\2\2\u0568\u0562\3\2\2\2\u0569\u056c\3\2\2\2\u056a\u0568\3\2\2\2\u056a"+
		"\u056b\3\2\2\2\u056b\u0570\3\2\2\2\u056c\u056a\3\2\2\2\u056d\u056f\5\u01ec"+
		"\u00f7\2\u056e\u056d\3\2\2\2\u056f\u0572\3\2\2\2\u0570\u056e\3\2\2\2\u0570"+
		"\u0571\3\2\2\2\u0571\u0085\3\2\2\2\u0572\u0570\3\2\2\2\u0573\u0575\5\u01e8"+
		"\u00f5\2\u0574\u0576\5\u0084C\2\u0575\u0574\3\2\2\2\u0575\u0576\3\2\2"+
		"\2\u0576\u0577\3\2\2\2\u0577\u0578\5\u01ea\u00f6\2\u0578\u0087\3\2\2\2"+
		"\u0579\u0581\5\u0086D\2\u057a\u057c\5\u01e8\u00f5\2\u057b\u057d\5\u0180"+
		"\u00c1\2\u057c\u057b\3\2\2\2\u057c\u057d\3\2\2\2\u057d\u057e\3\2\2\2\u057e"+
		"\u057f\5\u01ea\u00f6\2\u057f\u0581\3\2\2\2\u0580\u0579\3\2\2\2\u0580\u057a"+
		"\3\2\2\2\u0581\u0089\3\2\2\2\u0582\u0583\7\35\2\2\u0583\u0584\5\u0088"+
		"E\2\u0584\u008b\3\2\2\2\u0585\u058b\5\u008eH\2\u0586\u0587\5\u01ec\u00f7"+
		"\2\u0587\u0588\5\u008eH\2\u0588\u058a\3\2\2\2\u0589\u0586\3\2\2\2\u058a"+
		"\u058d\3\2\2\2\u058b\u0589\3\2\2\2\u058b\u058c\3\2\2\2\u058c\u058f\3\2"+
		"\2\2\u058d\u058b\3\2\2\2\u058e\u0590\5\u01ec\u00f7\2\u058f\u058e\3\2\2"+
		"\2\u058f\u0590\3\2\2\2\u0590\u008d\3\2\2\2\u0591\u0593\5\u0200\u0101\2"+
		"\u0592\u0594\5\u0092J\2\u0593\u0592\3\2\2\2\u0593\u0594\3\2\2\2\u0594"+
		"\u0596\3\2\2\2\u0595\u0597\5\u0094K\2\u0596\u0595\3\2\2\2\u0596\u0597"+
		"\3\2\2\2\u0597\u0598\3\2\2\2\u0598\u0599\5\u0128\u0095\2\u0599\u059a\7"+
		"j\2\2\u059a\u059b\5\u0126\u0094\2\u059b\u008f\3\2\2\2\u059c\u059f\7`\2"+
		"\2\u059d\u059f\5\u01d8\u00ed\2\u059e\u059c\3\2\2\2\u059e\u059d\3\2\2\2"+
		"\u059f\u0091\3\2\2\2\u05a0\u05a1\7|\2\2\u05a1\u05a2\5\u01fa\u00fe\2\u05a2"+
		"\u05a3\7}\2\2\u05a3\u05ae\3\2\2\2\u05a4\u05a5\7|\2\2\u05a5\u05a6\5\u0090"+
		"I\2\u05a6\u05a7\5\u01fa\u00fe\2\u05a7\u05a8\7}\2\2\u05a8\u05ae\3\2\2\2"+
		"\u05a9\u05aa\7|\2\2\u05aa\u05ab\5\u0090I\2\u05ab\u05ac\7}\2\2\u05ac\u05ae"+
		"\3\2\2\2\u05ad\u05a0\3\2\2\2\u05ad\u05a4\3\2\2\2\u05ad\u05a9\3\2\2\2\u05ae"+
		"\u0093\3\2\2\2\u05af\u05b1\7\37\2\2\u05b0\u05b2\5\u0096L\2\u05b1\u05b0"+
		"\3\2\2\2\u05b1\u05b2\3\2\2\2\u05b2\u05b3\3\2\2\2\u05b3\u05b9\7e\2\2\u05b4"+
		"\u05b6\7\37\2\2\u05b5\u05b7\5\u0096L\2\u05b6\u05b5\3\2\2\2\u05b6\u05b7"+
		"\3\2\2\2\u05b7\u05b8\3\2\2\2\u05b8\u05ba\7e\2\2\u05b9\u05b4\3\2\2\2\u05b9"+
		"\u05ba\3\2\2\2\u05ba\u0095\3\2\2\2\u05bb\u05bd\5\u0098M\2\u05bc\u05bb"+
		"\3\2\2\2\u05bd\u05be\3\2\2\2\u05be\u05bc\3\2\2\2\u05be\u05bf\3\2\2\2\u05bf"+
		"\u0097\3\2\2\2\u05c0\u05c8\5\u01d2\u00ea\2\u05c1\u05c2\7z\2\2\u05c2\u05c3"+
		"\5\u01d2\u00ea\2\u05c3\u05c4\7M\2\2\u05c4\u05c5\5\u00c4c\2\u05c5\u05c6"+
		"\7{\2\2\u05c6\u05c8\3\2\2\2\u05c7\u05c0\3\2\2\2\u05c7\u05c1\3\2\2\2\u05c8"+
		"\u0099\3\2\2\2\u05c9\u05cf\5\u009cO\2\u05ca\u05cb\5\u01ec\u00f7\2\u05cb"+
		"\u05cc\5\u009cO\2\u05cc\u05ce\3\2\2\2\u05cd\u05ca\3\2\2\2\u05ce\u05d1"+
		"\3\2\2\2\u05cf\u05cd\3\2\2\2\u05cf\u05d0\3\2\2\2\u05d0\u05d3\3\2\2\2\u05d1"+
		"\u05cf\3\2\2\2\u05d2\u05d4\5\u01ec\u00f7\2\u05d3\u05d2\3\2\2\2\u05d3\u05d4"+
		"\3\2\2\2\u05d4\u009b\3\2\2\2\u05d5\u05d6\5\u018c\u00c7\2\u05d6\u05d7\5"+
		"\u00a2R\2\u05d7\u009d\3\2\2\2\u05d8\u05de\5\u00a0Q\2\u05d9\u05da\5\u01ec"+
		"\u00f7\2\u05da\u05db\5\u00a0Q\2\u05db\u05dd\3\2\2\2\u05dc\u05d9\3\2\2"+
		"\2\u05dd\u05e0\3\2\2\2\u05de\u05dc\3\2\2\2\u05de\u05df\3\2\2\2\u05df\u05e2"+
		"\3\2\2\2\u05e0\u05de\3\2\2\2\u05e1\u05e3\5\u01ec\u00f7\2\u05e2\u05e1\3"+
		"\2\2\2\u05e2\u05e3\3\2\2\2\u05e3\u009f\3\2\2\2\u05e4\u05e5\5\u018c\u00c7"+
		"\2\u05e5\u05e6\5\u00a2R\2\u05e6\u00a1\3\2\2\2\u05e7\u05ee\5\u0200\u0101"+
		"\2\u05e8\u05ea\7|\2\2\u05e9\u05eb\5\u00a4S\2\u05ea\u05e9\3\2\2\2\u05ea"+
		"\u05eb\3\2\2\2\u05eb\u05ec\3\2\2\2\u05ec\u05ee\7}\2\2\u05ed\u05e7\3\2"+
		"\2\2\u05ed\u05e8\3\2\2\2\u05ee\u00a3\3\2\2\2\u05ef\u05f4\5\u0200\u0101"+
		"\2\u05f0\u05f1\7h\2\2\u05f1\u05f3\5\u0200\u0101\2\u05f2\u05f0\3\2\2\2"+
		"\u05f3\u05f6\3\2\2\2\u05f4\u05f2\3\2\2\2\u05f4\u05f5\3\2\2\2\u05f5\u00a5"+
		"\3\2\2\2\u05f6\u05f4\3\2\2\2\u05f7\u05f8\7\u0082\2\2\u05f8\u05f9\7C\2"+
		"\2\u05f9\u05fa\5\u018e\u00c8\2\u05fa\u05fb\5\u0130\u0099\2\u05fb\u05fc"+
		"\7\u0083\2\2\u05fc\u060a\3\2\2\2\u05fd\u05fe\7\u0082\2\2\u05fe\u05ff\7"+
		"C\2\2\u05ff\u0600\5\u01ae\u00d8\2\u0600\u0601\5\u0130\u0099\2\u0601\u0602"+
		"\7\u0083\2\2\u0602\u060a\3\2\2\2\u0603\u0604\7\u0082\2\2\u0604\u0605\7"+
		"C\2\2\u0605\u0606\7\27\2\2\u0606\u0607\5\u0130\u0099\2\u0607\u0608\7\u0083"+
		"\2\2\u0608\u060a\3\2\2\2\u0609\u05f7\3\2\2\2\u0609\u05fd\3\2\2\2\u0609"+
		"\u0603\3\2\2\2\u060a\u00a7\3\2\2\2\u060b\u060c\7\20\2\2\u060c\u060e\5"+
		"\u00aaV\2\u060d\u060f\5\u00acW\2\u060e\u060d\3\2\2\2\u060e\u060f\3\2\2"+
		"\2\u060f\u0610\3\2\2\2\u0610\u0611\5\u00aeX\2\u0611\u0617\3\2\2\2\u0612"+
		"\u0613\7!\2\2\u0613\u0614\5\u00aaV\2\u0614\u0615\5\u00aeX\2\u0615\u0617"+
		"\3\2\2\2\u0616\u060b\3\2\2\2\u0616\u0612\3\2\2\2\u0617\u00a9\3\2\2\2\u0618"+
		"\u0619\t\4\2\2\u0619\u00ab\3\2\2\2\u061a\u061b\t\5\2\2\u061b\u00ad\3\2"+
		"\2\2\u061c\u061e\5\u0200\u0101\2\u061d\u061c\3\2\2\2\u061d\u061e\3\2\2"+
		"\2\u061e\u061f\3\2\2\2\u061f\u0620\5\u01cc\u00e7\2\u0620\u0621\7M\2\2"+
		"\u0621\u0622\5\u00b6\\\2\u0622\u00af\3\2\2\2\u0623\u0624\7M\2\2\u0624"+
		"\u0625\5\u00b4[\2\u0625\u00b1\3\2\2\2\u0626\u0627\7M\2\2\u0627\u0628\5"+
		"\u01a4\u00d3\2\u0628\u00b3\3\2\2\2\u0629\u062a\5\u00c4c\2\u062a\u00b5"+
		"\3\2\2\2\u062b\u062c\5\u00c6d\2\u062c\u00b7\3\2\2\2\u062d\u0632\5\u01cc"+
		"\u00e7\2\u062e\u062f\7h\2\2\u062f\u0631\5\u01cc\u00e7\2\u0630\u062e\3"+
		"\2\2\2\u0631\u0634\3\2\2\2\u0632\u0630\3\2\2\2\u0632\u0633\3\2\2\2\u0633"+
		"\u00b9\3\2\2\2\u0634\u0632\3\2\2\2\u0635\u063a\5\u00b4[\2\u0636\u0637"+
		"\7h\2\2\u0637\u0639\5\u00b4[\2\u0638\u0636\3\2\2\2\u0639\u063c\3\2\2\2"+
		"\u063a\u0638\3\2\2\2\u063a\u063b\3\2\2\2\u063b\u00bb\3\2\2\2\u063c\u063a"+
		"\3\2\2\2\u063d\u063e\7\u0082\2\2\u063e\u063f\7A\2\2\u063f\u0644\7\u0083"+
		"\2\2\u0640\u0641\7\u0082\2\2\u0641\u0642\7B\2\2\u0642\u0644\7\u0083\2"+
		"\2\u0643\u063d\3\2\2\2\u0643\u0640\3\2\2\2\u0644\u00bd\3\2\2\2\u0645\u0646"+
		"\t\6\2\2\u0646\u00bf\3\2\2\2\u0647\u064d\5\u00c4c\2\u0648\u0649\5\u00c4"+
		"c\2\u0649\u064a\7M\2\2\u064a\u064b\5\u00f4{\2\u064b\u064d\3\2\2\2\u064c"+
		"\u0647\3\2\2\2\u064c\u0648\3\2\2\2\u064d\u00c1\3\2\2\2\u064e\u0654\5\u00c6"+
		"d\2\u064f\u0650\5\u00c6d\2\u0650\u0651\7M\2\2\u0651\u0652\5\u00f4{\2\u0652"+
		"\u0654\3\2\2\2\u0653\u064e\3\2\2\2\u0653\u064f\3\2\2\2\u0654\u00c3\3\2"+
		"\2\2\u0655\u0657\7\37\2\2\u0656\u0658\5\u00e6t\2\u0657\u0656\3\2\2\2\u0657"+
		"\u0658\3\2\2\2\u0658\u0659\3\2\2\2\u0659\u065a\5\u00be`\2\u065a\u065b"+
		"\5\u00c4c\2\u065b\u0666\3\2\2\2\u065c\u065d\5\u00d6l\2\u065d\u065e\7L"+
		"\2\2\u065e\u065f\5\u00c4c\2\u065f\u0666\3\2\2\2\u0660\u0661\5\u01cc\u00e7"+
		"\2\u0661\u0662\7M\2\2\u0662\u0663\5\u00ccg\2\u0663\u0666\3\2\2\2\u0664"+
		"\u0666\5\u00ccg\2\u0665\u0655\3\2\2\2\u0665\u065c\3\2\2\2\u0665\u0660"+
		"\3\2\2\2\u0665\u0664\3\2\2\2\u0666\u00c5\3\2\2\2\u0667\u0669\7\37\2\2"+
		"\u0668\u066a\5\u00e6t\2\u0669\u0668\3\2\2\2\u0669\u066a\3\2\2\2\u066a"+
		"\u066b\3\2\2\2\u066b\u066c\5\u00be`\2\u066c\u066d\5\u00c6d\2\u066d\u0678"+
		"\3\2\2\2\u066e\u066f\5\u00c8e\2\u066f\u0670\7L\2\2\u0670\u0671\5\u00c6"+
		"d\2\u0671\u0678\3\2\2\2\u0672\u0673\5\u01cc\u00e7\2\u0673\u0674\7M\2\2"+
		"\u0674\u0675\5\u00ccg\2\u0675\u0678\3\2\2\2\u0676\u0678\5\u00ceh\2\u0677"+
		"\u0667\3\2\2\2\u0677\u066e\3\2\2\2\u0677\u0672\3\2\2\2\u0677\u0676\3\2"+
		"\2\2\u0678\u00c7\3\2\2\2\u0679\u067a\5\u00d6l\2\u067a\u00c9\3\2\2\2\u067b"+
		"\u067c\5\u00d0i\2\u067c\u00cb\3\2\2\2\u067d\u0683\5\u00d6l\2\u067e\u067f"+
		"\5\u00d6l\2\u067f\u0680\7N\2\2\u0680\u0681\5\u00c4c\2\u0681\u0683\3\2"+
		"\2\2\u0682\u067d\3\2\2\2\u0682\u067e\3\2\2\2\u0683\u00cd\3\2\2\2\u0684"+
		"\u068a\5\u00d6l\2\u0685\u0686\5\u00d6l\2\u0686\u0687\7N\2\2\u0687\u0688"+
		"\5\u00c6d\2\u0688\u068a\3\2\2\2\u0689\u0684\3\2\2\2\u0689\u0685\3\2\2"+
		"\2\u068a\u00cf\3\2\2\2\u068b\u068c\5\u00d2j\2\u068c\u00d1\3\2\2\2\u068d"+
		"\u068f\5\u00d4k\2\u068e\u068d\3\2\2\2\u068f\u0690\3\2\2\2\u0690\u068e"+
		"\3\2\2\2\u0690\u0691\3\2\2\2\u0691\u00d3\3\2\2\2\u0692\u0693\5\u00dan"+
		"\2\u0693\u00d5\3\2\2\2\u0694\u0695\5\u00d8m\2\u0695\u00d7\3\2\2\2\u0696"+
		"\u0698\5\u00dan\2\u0697\u0696\3\2\2\2\u0698\u0699\3\2\2\2\u0699\u0697"+
		"\3\2\2\2\u0699\u069a\3\2\2\2\u069a\u00d9\3\2\2\2\u069b\u06a6\5\u00dco"+
		"\2\u069c\u069d\7a\2\2\u069d\u06a6\5\u00dco\2\u069e\u06a6\5\u01aa\u00d6"+
		"\2\u069f\u06a6\5\u01c4\u00e3\2\u06a0\u06a1\7k\2\2\u06a1\u06a6\5\u01a0"+
		"\u00d1\2\u06a2\u06a3\7k\2\2\u06a3\u06a6\5\u01b6\u00dc\2\u06a4\u06a6\5"+
		"\u00bc_\2\u06a5\u069b\3\2\2\2\u06a5\u069c\3\2\2\2\u06a5\u069e\3\2\2\2"+
		"\u06a5\u069f\3\2\2\2\u06a5\u06a0\3\2\2\2\u06a5\u06a2\3\2\2\2\u06a5\u06a4"+
		"\3\2\2\2\u06a6\u00db\3\2\2\2\u06a7\u06ea\5\u01a6\u00d4\2\u06a8\u06ea\5"+
		"\u01c2\u00e2\2\u06a9\u06ea\7]\2\2\u06aa\u06ab\7`\2\2\u06ab\u06ea\5\u00dc"+
		"o\2\u06ac\u06ad\7Y\2\2\u06ad\u06ea\5\u00dco\2\u06ae\u06b0\7\u0086\2\2"+
		"\u06af\u06b1\5\u0108\u0085\2\u06b0\u06af\3\2\2\2\u06b0\u06b1\3\2\2\2\u06b1"+
		"\u06b2\3\2\2\2\u06b2\u06ea\7\u0087\2\2\u06b3\u06b4\7z\2\2\u06b4\u06ea"+
		"\7{\2\2\u06b5\u06b6\7z\2\2\u06b6\u06b7\5\u00c0a\2\u06b7\u06b8\7h\2\2\u06b8"+
		"\u06b9\5\u00e2r\2\u06b9\u06ba\7{\2\2\u06ba\u06ea\3\2\2\2\u06bb\u06bc\7"+
		"x\2\2\u06bc\u06ea\7y\2\2\u06bd\u06be\7x\2\2\u06be\u06bf\5\u00e2r\2\u06bf"+
		"\u06c0\7y\2\2\u06c0\u06ea\3\2\2\2\u06c1\u06c2\7x\2\2\u06c2\u06c3\5\u00e4"+
		"s\2\u06c3\u06c4\7y\2\2\u06c4\u06ea\3\2\2\2\u06c5\u06c6\7|\2\2\u06c6\u06c7"+
		"\5\u00c0a\2\u06c7\u06c8\7}\2\2\u06c8\u06ea\3\2\2\2\u06c9\u06ca\7z\2\2"+
		"\u06ca\u06cb\5\u00c0a\2\u06cb\u06cc\7{\2\2\u06cc\u06ea\3\2\2\2\u06cd\u06ea"+
		"\5\u0124\u0093\2\u06ce\u06ea\5\u0138\u009d\2\u06cf\u06d0\7k\2\2\u06d0"+
		"\u06ea\5\u0190\u00c9\2\u06d1\u06d2\7k\2\2\u06d2\u06d3\7z\2\2\u06d3\u06d4"+
		"\5\u00c0a\2\u06d4\u06d5\7h\2\2\u06d5\u06d6\5\u00e2r\2\u06d6\u06d7\7{\2"+
		"\2\u06d7\u06ea\3\2\2\2\u06d8\u06d9\7k\2\2\u06d9\u06db\7|\2\2\u06da\u06dc"+
		"\5\u00e2r\2\u06db\u06da\3\2\2\2\u06db\u06dc\3\2\2\2\u06dc\u06dd\3\2\2"+
		"\2\u06dd\u06ea\7}\2\2\u06de\u06df\7k\2\2\u06df\u06ea\5\u01cc\u00e7\2\u06e0"+
		"\u06e1\7|\2\2\u06e1\u06e2\5\u00c0a\2\u06e2\u06e3\7h\2\2\u06e3\u06e4\5"+
		"\u00e2r\2\u06e4\u06e5\7}\2\2\u06e5\u06ea\3\2\2\2\u06e6\u06ea\5\u01fa\u00fe"+
		"\2\u06e7\u06ea\5\u0200\u0101\2\u06e8\u06ea\7\36\2\2\u06e9\u06a7\3\2\2"+
		"\2\u06e9\u06a8\3\2\2\2\u06e9\u06a9\3\2\2\2\u06e9\u06aa\3\2\2\2\u06e9\u06ac"+
		"\3\2\2\2\u06e9\u06ae\3\2\2\2\u06e9\u06b3\3\2\2\2\u06e9\u06b5\3\2\2\2\u06e9"+
		"\u06bb\3\2\2\2\u06e9\u06bd\3\2\2\2\u06e9\u06c1\3\2\2\2\u06e9\u06c5\3\2"+
		"\2\2\u06e9\u06c9\3\2\2\2\u06e9\u06cd\3\2\2\2\u06e9\u06ce\3\2\2\2\u06e9"+
		"\u06cf\3\2\2\2\u06e9\u06d1\3\2\2\2\u06e9\u06d8\3\2\2\2\u06e9\u06de\3\2"+
		"\2\2\u06e9\u06e0\3\2\2\2\u06e9\u06e6\3\2\2\2\u06e9\u06e7\3\2\2\2\u06e9"+
		"\u06e8\3\2\2\2\u06ea\u00dd\3\2\2\2\u06eb\u06ec\5\u00b4[\2\u06ec\u00df"+
		"\3\2\2\2\u06ed\u06f2\5\u00c2b\2\u06ee\u06ef\7h\2\2\u06ef\u06f1\5\u00c2"+
		"b\2\u06f0\u06ee\3\2\2\2\u06f1\u06f4\3\2\2\2\u06f2\u06f0\3\2\2\2\u06f2"+
		"\u06f3\3\2\2\2\u06f3\u00e1\3\2\2\2\u06f4\u06f2\3\2\2\2\u06f5\u06fa\5\u00c0"+
		"a\2\u06f6\u06f7\7h\2\2\u06f7\u06f9\5\u00c0a\2\u06f8\u06f6\3\2\2\2\u06f9"+
		"\u06fc\3\2\2\2\u06fa\u06f8\3\2\2\2\u06fa\u06fb\3\2\2\2\u06fb\u00e3\3\2"+
		"\2\2\u06fc\u06fa\3\2\2\2\u06fd\u06fe\5\u00c0a\2\u06fe\u06ff\7X\2\2\u06ff"+
		"\u0704\5\u00c0a\2\u0700\u0701\7X\2\2\u0701\u0703\5\u00c0a\2\u0702\u0700"+
		"\3\2\2\2\u0703\u0706\3\2\2\2\u0704\u0702\3\2\2\2\u0704\u0705\3\2\2\2\u0705"+
		"\u00e5\3\2\2\2\u0706\u0704\3\2\2\2\u0707\u0709\5\u00e8u\2\u0708\u0707"+
		"\3\2\2\2\u0709\u070a\3\2\2\2\u070a\u0708\3\2\2\2\u070a\u070b\3\2\2\2\u070b"+
		"\u00e7\3\2\2\2\u070c\u0718\5\u00eav\2\u070d\u070e\7\u0086\2\2\u070e\u070f"+
		"\5\u01c2\u00e2\2\u070f\u0710\7\u0087\2\2\u0710\u0718\3\2\2\2\u0711\u0712"+
		"\7\u0086\2\2\u0712\u0713\5\u01c2\u00e2\2\u0713\u0714\7M\2\2\u0714\u0715"+
		"\5\u00f4{\2\u0715\u0716\7\u0087\2\2\u0716\u0718\3\2\2\2\u0717\u070c\3"+
		"\2\2\2\u0717\u070d\3\2\2\2\u0717\u0711\3\2\2\2\u0718\u00e9\3\2\2\2\u0719"+
		"\u0721\5\u01c2\u00e2\2\u071a\u071b\7z\2\2\u071b\u071c\5\u01c2\u00e2\2"+
		"\u071c\u071d\7M\2\2\u071d\u071e\5\u00f4{\2\u071e\u071f\7{\2\2\u071f\u0721"+
		"\3\2\2\2\u0720\u0719\3\2\2\2\u0720\u071a\3\2\2\2\u0721\u00eb\3\2\2\2\u0722"+
		"\u0723\7X\2\2\u0723\u0724\5\u00eex\2\u0724\u00ed\3\2\2\2\u0725\u072a\5"+
		"\u00f0y\2\u0726\u0727\7h\2\2\u0727\u0729\5\u00f0y\2\u0728\u0726\3\2\2"+
		"\2\u0729\u072c\3\2\2\2\u072a\u0728\3\2\2\2\u072a\u072b\3\2\2\2\u072b\u00ef"+
		"\3\2\2\2\u072c\u072a\3\2\2\2\u072d\u072f\5\u00f2z\2\u072e\u072d\3\2\2"+
		"\2\u072e\u072f\3\2\2\2\u072f\u0730\3\2\2\2\u0730\u0732\7N\2\2\u0731\u0733"+
		"\5\u00f2z\2\u0732\u0731\3\2\2\2\u0732\u0733\3\2\2\2\u0733\u00f1\3\2\2"+
		"\2\u0734\u0736\5\u01c2\u00e2\2\u0735\u0734\3\2\2\2\u0736\u0737\3\2\2\2"+
		"\u0737\u0735\3\2\2\2\u0737\u0738\3\2\2\2\u0738\u00f3\3\2\2\2\u0739\u073a"+
		"\5\u00c4c\2\u073a\u00f5\3\2\2\2\u073b\u073c\7\35\2\2\u073c\u073e\5\u01e8"+
		"\u00f5\2\u073d\u073f\5\u00f8}\2\u073e\u073d\3\2\2\2\u073e\u073f\3\2\2"+
		"\2\u073f\u0743\3\2\2\2\u0740\u0742\5\u01ec\u00f7\2\u0741\u0740\3\2\2\2"+
		"\u0742\u0745\3\2\2\2\u0743\u0741\3\2\2\2\u0743\u0744\3\2\2\2\u0744\u0746"+
		"\3\2\2\2\u0745\u0743\3\2\2\2\u0746\u0747\5\u01ea\u00f6\2\u0747\u00f7\3"+
		"\2\2\2\u0748\u074e\5\u00fa~\2\u0749\u074a\5\u01ec\u00f7\2\u074a\u074b"+
		"\5\u00fa~\2\u074b\u074d\3\2\2\2\u074c\u0749\3\2\2\2\u074d\u0750\3\2\2"+
		"\2\u074e\u074c\3\2\2\2\u074e\u074f\3\2\2\2\u074f\u00f9\3\2\2\2\u0750\u074e"+
		"\3\2\2\2\u0751\u0752\5\u00fc\177\2\u0752\u00fb\3\2\2\2\u0753\u0754\5\u0198"+
		"\u00cd\2\u0754\u0755\7M\2\2\u0755\u0756\5\u00b6\\\2\u0756\u00fd\3\2\2"+
		"\2\u0757\u0758\7j\2\2\u0758\u0759\5\u0100\u0081\2\u0759\u00ff\3\2\2\2"+
		"\u075a\u075f\5\u0102\u0082\2\u075b\u075c\7X\2\2\u075c\u075e\5\u0102\u0082"+
		"\2\u075d\u075b\3\2\2\2\u075e\u0761\3\2\2\2\u075f\u075d\3\2\2\2\u075f\u0760"+
		"\3\2\2\2\u0760\u0101\3\2\2\2\u0761\u075f\3\2\2\2\u0762\u0764\5\u0104\u0083"+
		"\2\u0763\u0762\3\2\2\2\u0763\u0764\3\2\2\2\u0764\u0768\3\2\2\2\u0765\u0766"+
		"\5\u00caf\2\u0766\u0767\7L\2\2\u0767\u0769\3\2\2\2\u0768\u0765\3\2\2\2"+
		"\u0768\u0769\3\2\2\2\u0769\u076a\3\2\2\2\u076a\u076b\5\u0106\u0084\2\u076b"+
		"\u0103\3\2\2\2\u076c\u076e\7\37\2\2\u076d\u076f\5\u00e6t\2\u076e\u076d"+
		"\3\2\2\2\u076e\u076f\3\2\2\2\u076f\u0770\3\2\2\2\u0770\u0771\7e\2\2\u0771"+
		"\u0105\3\2\2\2\u0772\u0773\5\u00d2j\2\u0773\u0107\3\2\2\2\u0774\u0779"+
		"\5\u010a\u0086\2\u0775\u0776\7h\2\2\u0776\u0778\5\u010a\u0086\2\u0777"+
		"\u0775\3\2\2\2\u0778\u077b\3\2\2\2\u0779\u0777\3\2\2\2\u0779\u077a\3\2"+
		"\2\2\u077a\u0109\3\2\2\2\u077b\u0779\3\2\2\2\u077c\u077d\5\u00b8]\2\u077d"+
		"\u077e\7M\2\2\u077e\u077f\5\u00c4c\2\u077f\u010b\3\2\2\2\u0780\u0782\5"+
		"\u010e\u0088\2\u0781\u0780\3\2\2\2\u0782\u0783\3\2\2\2\u0783\u0781\3\2"+
		"\2\2\u0783\u0784\3\2\2\2\u0784\u010d\3\2\2\2\u0785\u0786\7\13\2\2\u0786"+
		"\u0790\5\u0110\u0089\2\u0787\u0788\7\13\2\2\u0788\u0789\5:\36\2\u0789"+
		"\u078a\5\u0110\u0089\2\u078a\u0790\3\2\2\2\u078b\u078c\7\13\2\2\u078c"+
		"\u078d\5\u0110\u0089\2\u078d\u078e\5<\37\2\u078e\u0790\3\2\2\2\u078f\u0785"+
		"\3\2\2\2\u078f\u0787\3\2\2\2\u078f\u078b\3\2\2\2\u0790\u010f\3\2\2\2\u0791"+
		"\u0799\5\u01ac\u00d7\2\u0792\u0793\7z\2\2\u0793\u0799\7{\2\2\u0794\u0795"+
		"\7z\2\2\u0795\u0796\5\u00e0q\2\u0796\u0797\7{\2\2\u0797\u0799\3\2\2\2"+
		"\u0798\u0791\3\2\2\2\u0798\u0792\3\2\2\2\u0798\u0794\3\2\2\2\u0799\u0111"+
		"\3\2\2\2\u079a\u07a8\5\u011c\u008f\2\u079b\u079d\5\u0128\u0095\2\u079c"+
		"\u079e\5\u00b0Y\2\u079d\u079c\3\2\2\2\u079d\u079e\3\2\2\2\u079e\u079f"+
		"\3\2\2\2\u079f\u07a0\5\u0116\u008c\2\u07a0\u07a8\3\2\2\2\u07a1\u07a8\5"+
		"h\65\2\u07a2\u07a4\5\u01ec\u00f7\2\u07a3\u07a2\3\2\2\2\u07a4\u07a5\3\2"+
		"\2\2\u07a5\u07a3\3\2\2\2\u07a5\u07a6\3\2\2\2\u07a6\u07a8\3\2\2\2\u07a7"+
		"\u079a\3\2\2\2\u07a7\u079b\3\2\2\2\u07a7\u07a1\3\2\2\2\u07a7\u07a3\3\2"+
		"\2\2\u07a8\u0113\3\2\2\2\u07a9\u07b1\5\u0112\u008a\2\u07aa\u07b1\5\u0136"+
		"\u009c\2\u07ab\u07ad\5\u01ec\u00f7\2\u07ac\u07ab\3\2\2\2\u07ad\u07ae\3"+
		"\2\2\2\u07ae\u07ac\3\2\2\2\u07ae\u07af\3\2\2\2\u07af\u07b1\3\2\2\2\u07b0"+
		"\u07a9\3\2\2\2\u07b0\u07aa\3\2\2\2\u07b0\u07ac\3\2\2\2\u07b1\u0115\3\2"+
		"\2\2\u07b2\u07b3\7j\2\2\u07b3\u07b5\5\u0126\u0094\2\u07b4\u07b6\5\u008a"+
		"F\2\u07b5\u07b4\3\2\2\2\u07b5\u07b6\3\2\2\2\u07b6\u07bc\3\2\2\2\u07b7"+
		"\u07b9\5\u0118\u008d\2\u07b8\u07ba\5\u008aF\2\u07b9\u07b8\3\2\2\2\u07b9"+
		"\u07ba\3\2\2\2\u07ba\u07bc\3\2\2\2\u07bb\u07b2\3\2\2\2\u07bb\u07b7\3\2"+
		"\2\2\u07bc\u0117\3\2\2\2\u07bd\u07bf\5\u011a\u008e\2\u07be\u07bd\3\2\2"+
		"\2\u07bf\u07c0\3\2\2\2\u07c0\u07be\3\2\2\2\u07c0\u07c1\3\2\2\2\u07c1\u0119"+
		"\3\2\2\2\u07c2\u07c3\7X\2\2\u07c3\u07c4\5\u0158\u00ad\2\u07c4\u07c5\7"+
		"j\2\2\u07c5\u07c6\5\u0126\u0094\2\u07c6\u011b\3\2\2\2\u07c7\u07c8\5\u0128"+
		"\u0095\2\u07c8\u07c9\7M\2\2\u07c9\u07ca\5\u00b6\\\2\u07ca\u0817\3\2\2"+
		"\2\u07cb\u07cc\5\u01cc\u00e7\2\u07cc\u07cd\7h\2\2\u07cd\u07ce\5\u00b8"+
		"]\2\u07ce\u07cf\7M\2\2\u07cf\u07d0\5\u00b6\\\2\u07d0\u0817\3\2\2\2\u07d1"+
		"\u07d3\5&\24\2\u07d2\u07d4\5\u01fa\u00fe\2\u07d3\u07d2\3\2\2\2\u07d3\u07d4"+
		"\3\2\2\2\u07d4\u07d5\3\2\2\2\u07d5\u07d6\5(\25\2\u07d6\u0817\3\2\2\2\u07d7"+
		"\u0817\5r:\2\u07d8\u07d9\7\u0082\2\2\u07d9\u07da\7J\2\2\u07da\u07dc\5"+
		"\u0198\u00cd\2\u07db\u07dd\5\u00b2Z\2\u07dc\u07db\3\2\2\2\u07dc\u07dd"+
		"\3\2\2\2\u07dd\u07de\3\2\2\2\u07de\u07df\7\u0083\2\2\u07df\u0817\3\2\2"+
		"\2\u07e0\u07e1\7\u0082\2\2\u07e1\u07e3\78\2\2\u07e2\u07e4\5\u011e\u0090"+
		"\2\u07e3\u07e2\3\2\2\2\u07e3\u07e4\3\2\2\2\u07e4\u07e5\3\2\2\2\u07e5\u07e6"+
		"\5\u01ce\u00e8\2\u07e6\u07e7\7\u0083\2\2\u07e7\u0817\3\2\2\2\u07e8\u07e9"+
		"\7\u0082\2\2\u07e9\u07ea\7>\2\2\u07ea\u07ec\5\u01ce\u00e8\2\u07eb\u07ed"+
		"\5\u0200\u0101\2\u07ec\u07eb\3\2\2\2\u07ec\u07ed\3\2\2\2\u07ed\u07ee\3"+
		"\2\2\2\u07ee\u07ef\7\u0083\2\2\u07ef\u0817\3\2\2\2\u07f0\u07f1\7\u0082"+
		"\2\2\u07f1\u07f3\7:\2\2\u07f2\u07f4\5\u011e\u0090\2\u07f3\u07f2\3\2\2"+
		"\2\u07f3\u07f4\3\2\2\2\u07f4\u07f5\3\2\2\2\u07f5\u07f6\5\u01ce\u00e8\2"+
		"\u07f6\u07f7\7M\2\2\u07f7\u07f8\5\u00ba^\2\u07f8\u07f9\7\u0083\2\2\u07f9"+
		"\u0817\3\2\2\2\u07fa\u07fb\7\u0082\2\2\u07fb\u07fd\7;\2\2\u07fc\u07fe"+
		"\5\u011e\u0090\2\u07fd\u07fc\3\2\2\2\u07fd\u07fe\3\2\2\2\u07fe\u07ff\3"+
		"\2\2\2\u07ff\u0800\5\u01ce\u00e8\2\u0800\u0801\7M\2\2\u0801\u0802\5\u00ba"+
		"^\2\u0802\u0803\7\u0083\2\2\u0803\u0817\3\2\2\2\u0804\u0805\7\u0082\2"+
		"\2\u0805\u0806\7:\2\2\u0806\u0807\7\25\2\2\u0807\u0808\5\u00dep\2\u0808"+
		"\u0809\7\u0083\2\2\u0809\u0817\3\2\2\2\u080a\u080b\7\u0082\2\2\u080b\u080c"+
		"\7D\2\2\u080c\u080e\7\u0083\2\2\u080d\u080f\5\u0184\u00c3\2\u080e\u080d"+
		"\3\2\2\2\u080e\u080f\3\2\2\2\u080f\u0810\3\2\2\2\u0810\u0817\7\u0083\2"+
		"\2\u0811\u0813\5\u01ec\u00f7\2\u0812\u0811\3\2\2\2\u0813\u0814\3\2\2\2"+
		"\u0814\u0812\3\2\2\2\u0814\u0815\3\2\2\2\u0815\u0817\3\2\2\2\u0816\u07c7"+
		"\3\2\2\2\u0816\u07cb\3\2\2\2\u0816\u07d1\3\2\2\2\u0816\u07d7\3\2\2\2\u0816"+
		"\u07d8\3\2\2\2\u0816\u07e0\3\2\2\2\u0816\u07e8\3\2\2\2\u0816\u07f0\3\2"+
		"\2\2\u0816\u07fa\3\2\2\2\u0816\u0804\3\2\2\2\u0816\u080a\3\2\2\2\u0816"+
		"\u0812\3\2\2\2\u0817\u011d\3\2\2\2\u0818\u0819\7|\2\2\u0819\u081a\5\u01fa"+
		"\u00fe\2\u081a\u081b\7}\2\2\u081b\u0822\3\2\2\2\u081c\u081d\7|\2\2\u081d"+
		"\u081e\5\u0090I\2\u081e\u081f\5\u01fa\u00fe\2\u081f\u0820\7}\2\2\u0820"+
		"\u0822\3\2\2\2\u0821\u0818\3\2\2\2\u0821\u081c\3\2\2\2\u0822\u011f\3\2"+
		"\2\2\u0823\u0824\7|\2\2\u0824\u0825\5\u01d2\u00ea\2\u0825\u0826\7X\2\2"+
		"\u0826\u0121\3\2\2\2\u0827\u0828\7|\2\2\u0828\u0829\5\u01d0\u00e9\2\u0829"+
		"\u082a\7X\2\2\u082a\u0123\3\2\2\2\u082b\u082e\5\u0120\u0091\2\u082c\u082e"+
		"\5\u0122\u0092\2\u082d\u082b\3\2\2\2\u082d\u082c\3\2\2\2\u082e\u0125\3"+
		"\2\2\2\u082f\u0830\5\u0128\u0095\2\u0830\u0831\7M\2\2\u0831\u0832\5\u00b4"+
		"[\2\u0832\u0845\3\2\2\2\u0833\u0834\5\u0128\u0095\2\u0834\u0835\7P\2\2"+
		"\u0835\u0836\5\u0126\u0094\2\u0836\u0845\3\2\2\2\u0837\u0838\5\u0128\u0095"+
		"\2\u0838\u0839\7Q\2\2\u0839\u083a\5\u0126\u0094\2\u083a\u0845\3\2\2\2"+
		"\u083b\u083c\5\u0128\u0095\2\u083c\u083d\7R\2\2\u083d\u083e\5\u0126\u0094"+
		"\2\u083e\u0845\3\2\2\2\u083f\u0840\5\u0128\u0095\2\u0840\u0841\7S\2\2"+
		"\u0841\u0842\5\u0126\u0094\2\u0842\u0845\3\2\2\2\u0843\u0845\5\u0128\u0095"+
		"\2\u0844\u082f\3\2\2\2\u0844\u0833\3\2\2\2\u0844\u0837\3\2\2\2\u0844\u083b"+
		"\3\2\2\2\u0844\u083f\3\2\2\2\u0844\u0843\3\2\2\2\u0845\u0127\3\2\2\2\u0846"+
		"\u084c\5\u012c\u0097\2\u0847\u0848\5\u01b8\u00dd\2\u0848\u0849\5\u012a"+
		"\u0096\2\u0849\u084b\3\2\2\2\u084a\u0847\3\2\2\2\u084b\u084e\3\2\2\2\u084c"+
		"\u084a\3\2\2\2\u084c\u084d\3\2\2\2\u084d\u0129\3\2\2\2\u084e\u084c\3\2"+
		"\2\2\u084f\u0850\5\u012c\u0097\2\u0850\u012b\3\2\2\2\u0851\u0853\7\\\2"+
		"\2\u0852\u0851\3\2\2\2\u0852\u0853\3\2\2\2\u0853\u0854\3\2\2\2\u0854\u0855"+
		"\5\u012e\u0098\2\u0855\u012d\3\2\2\2\u0856\u0858\5\u0130\u0099\2\u0857"+
		"\u0856\3\2\2\2\u0858\u0859\3\2\2\2\u0859\u0857\3\2\2\2\u0859\u085a\3\2"+
		"\2\2\u085a\u085d\3\2\2\2\u085b\u085c\7a\2\2\u085c\u085e\5\u00dco\2\u085d"+
		"\u085b\3\2\2\2\u085d\u085e\3\2\2\2\u085e\u012f\3\2\2\2\u085f\u0860\5\u01ce"+
		"\u00e8\2\u0860\u0861\7a\2\2\u0861\u0862\5\u0130\u0099\2\u0862\u088d\3"+
		"\2\2\2\u0863\u0864\7`\2\2\u0864\u088d\5\u0130\u0099\2\u0865\u0866\7Y\2"+
		"\2\u0866\u088d\5\u0130\u0099\2\u0867\u0868\7m\2\2\u0868\u0869\5\u0170"+
		"\u00b9\2\u0869\u086a\7N\2\2\u086a\u086b\5\u0126\u0094\2\u086b\u088d\3"+
		"\2\2\2\u086c\u086d\7\26\2\2\u086d\u086e\5\u0086D\2\u086e\u086f\7\21\2"+
		"\2\u086f\u0870\5\u0126\u0094\2\u0870\u088d\3\2\2\2\u0871\u0872\7K\2\2"+
		"\u0872\u088d\5\u015c\u00af\2\u0873\u0874\7\17\2\2\u0874\u0876\5\u0126"+
		"\u0094\2\u0875\u0877\5\u01ec\u00f7\2\u0876\u0875\3\2\2\2\u0876\u0877\3"+
		"\2\2\2\u0877\u0878\3\2\2\2\u0878\u0879\7\33\2\2\u0879\u087b\5\u0126\u0094"+
		"\2\u087a\u087c\5\u01ec\u00f7\2\u087b\u087a\3\2\2\2\u087b\u087c\3\2\2\2"+
		"\u087c\u087d\3\2\2\2\u087d\u087e\7\r\2\2\u087e\u087f\5\u0126\u0094\2\u087f"+
		"\u088d\3\2\2\2\u0880\u0881\7\17\2\2\u0881\u088d\5\u0166\u00b4\2\u0882"+
		"\u0883\7\7\2\2\u0883\u0884\5\u0126\u0094\2\u0884\u0885\7\31\2\2\u0885"+
		"\u0886\5\u015c\u00af\2\u0886\u088d\3\2\2\2\u0887\u0888\7\f\2\2\u0888\u088d"+
		"\5\u0174\u00bb\2\u0889\u088a\7%\2\2\u088a\u088d\5\u0174\u00bb\2\u088b"+
		"\u088d\5\u0132\u009a\2\u088c\u085f\3\2\2\2\u088c\u0863\3\2\2\2\u088c\u0865"+
		"\3\2\2\2\u088c\u0867\3\2\2\2\u088c\u086c\3\2\2\2\u088c\u0871\3\2\2\2\u088c"+
		"\u0873\3\2\2\2\u088c\u0880\3\2\2\2\u088c\u0882\3\2\2\2\u088c\u0887\3\2"+
		"\2\2\u088c\u0889\3\2\2\2\u088c\u088b\3\2\2\2\u088d\u0131\3\2\2\2\u088e"+
		"\u0896\5\u0134\u009b\2\u088f\u0891\7\u0086\2\2\u0890\u0892\5\u017c\u00bf"+
		"\2\u0891\u0890\3\2\2\2\u0891\u0892\3\2\2\2\u0892\u0893\3\2\2\2\u0893\u0895"+
		"\7\u0087\2\2\u0894\u088f\3\2\2\2\u0895\u0898\3\2\2\2\u0896\u0894\3\2\2"+
		"\2\u0896\u0897\3\2\2\2\u0897\u0133\3\2\2\2\u0898\u0896\3\2\2\2\u0899\u08dd"+
		"\5\u01ce\u00e8\2\u089a\u08dd\5\u0192\u00ca\2\u089b\u08dd\5\u01d2\u00ea"+
		"\2\u089c\u08dd\5\u01e6\u00f4\2\u089d\u08dd\5\u0200\u0101\2\u089e\u08dd"+
		"\5\u01fa\u00fe\2\u089f\u08dd\5\u01fc\u00ff\2\u08a0\u08a1\7z\2\2\u08a1"+
		"\u08a2\5\u0144\u00a3\2\u08a2\u08a3\7{\2\2\u08a3\u08dd\3\2\2\2\u08a4\u08a5"+
		"\7z\2\2\u08a5\u08a6\5\u0146\u00a4\2\u08a6\u08a7\7{\2\2\u08a7\u08dd\3\2"+
		"\2\2\u08a8\u08a9\7x\2\2\u08a9\u08aa\5\u0144\u00a3\2\u08aa\u08ab\7y\2\2"+
		"\u08ab\u08dd\3\2\2\2\u08ac\u08ad\7x\2\2\u08ad\u08ae\5\u0146\u00a4\2\u08ae"+
		"\u08af\7y\2\2\u08af\u08dd\3\2\2\2\u08b0\u08b1\7|\2\2\u08b1\u08b2\5\u014c"+
		"\u00a7\2\u08b2\u08b3\7}\2\2\u08b3\u08dd\3\2\2\2\u08b4\u08dd\7\36\2\2\u08b5"+
		"\u08dd\5\u0138\u009d\2\u08b6\u08dd\5\u013a\u009e\2\u08b7\u08b8\7k\2\2"+
		"\u08b8\u08dd\5\u01ce\u00e8\2\u08b9\u08ba\7k\2\2\u08ba\u08dd\5\u0192\u00ca"+
		"\2\u08bb\u08bc\7l\2\2\u08bc\u08dd\5\u01c2\u00e2\2\u08bd\u08be\7l\2\2\u08be"+
		"\u08dd\5\u01a4\u00d3\2\u08bf\u08dd\7l\2\2\u08c0\u08c1\7s\2\2\u08c1\u08c2"+
		"\5\u0126\u0094\2\u08c2\u08c3\7w\2\2\u08c3\u08dd\3\2\2\2\u08c4\u08c5\7"+
		"q\2\2\u08c5\u08c6\5\u0126\u0094\2\u08c6\u08c7\7r\2\2\u08c7\u08dd\3\2\2"+
		"\2\u08c8\u08c9\7u\2\2\u08c9\u08ca\5\u00c0a\2\u08ca\u08cb\7w\2\2\u08cb"+
		"\u08dd\3\2\2\2\u08cc\u08cd\7t\2\2\u08cd\u08ce\5\u0128\u0095\2\u08ce\u08cf"+
		"\7w\2\2\u08cf\u08dd\3\2\2\2\u08d0\u08d1\7v\2\2\u08d1\u08d2\5\u0140\u00a1"+
		"\2\u08d2\u08d3\7w\2\2\u08d3\u08dd\3\2\2\2\u08d4\u08dd\5\u0124\u0093\2"+
		"\u08d5\u08d6\7o\2\2\u08d6\u08d8\5\u0130\u0099\2\u08d7\u08d9\5\u013c\u009f"+
		"\2\u08d8\u08d7\3\2\2\2\u08d8\u08d9\3\2\2\2\u08d9\u08da\3\2\2\2\u08da\u08db"+
		"\7o\2\2\u08db\u08dd\3\2\2\2\u08dc\u0899\3\2\2\2\u08dc\u089a\3\2\2\2\u08dc"+
		"\u089b\3\2\2\2\u08dc\u089c\3\2\2\2\u08dc\u089d\3\2\2\2\u08dc\u089e\3\2"+
		"\2\2\u08dc\u089f\3\2\2\2\u08dc\u08a0\3\2\2\2\u08dc\u08a4\3\2\2\2\u08dc"+
		"\u08a8\3\2\2\2\u08dc\u08ac\3\2\2\2\u08dc\u08b0\3\2\2\2\u08dc\u08b4\3\2"+
		"\2\2\u08dc\u08b5\3\2\2\2\u08dc\u08b6\3\2\2\2\u08dc\u08b7\3\2\2\2\u08dc"+
		"\u08b9\3\2\2\2\u08dc\u08bb\3\2\2\2\u08dc\u08bd\3\2\2\2\u08dc\u08bf\3\2"+
		"\2\2\u08dc\u08c0\3\2\2\2\u08dc\u08c4\3\2\2\2\u08dc\u08c8\3\2\2\2\u08dc"+
		"\u08cc\3\2\2\2\u08dc\u08d0\3\2\2\2\u08dc\u08d4\3\2\2\2\u08dc\u08d5\3\2"+
		"\2\2\u08dd\u0135\3\2\2\2\u08de\u08e1\5\u013a\u009e\2\u08df\u08e1\5\u0138"+
		"\u009d\2\u08e0\u08de\3\2\2\2\u08e0\u08df\3\2\2\2\u08e1\u0137\3\2\2\2\u08e2"+
		"\u08e3\7c\2\2\u08e3\u08e4\5\u0130\u0099\2\u08e4\u0139\3\2\2\2\u08e5\u08e6"+
		"\7b\2\2\u08e6\u08e7\5\u0130\u0099\2\u08e7\u013b\3\2\2\2\u08e8\u08ea\5"+
		"\u013e\u00a0\2\u08e9\u08e8\3\2\2\2\u08ea\u08eb\3\2\2\2\u08eb\u08e9\3\2"+
		"\2\2\u08eb\u08ec\3\2\2\2\u08ec\u013d\3\2\2\2\u08ed\u08ee\5\u0130\u0099"+
		"\2\u08ee\u013f\3\2\2\2\u08ef\u08f1\5\u01e8\u00f5\2\u08f0\u08f2\5\u0142"+
		"\u00a2\2\u08f1\u08f0\3\2\2\2\u08f1\u08f2\3\2\2\2\u08f2\u08f3\3\2\2\2\u08f3"+
		"\u08f4\5\u01ea\u00f6\2\u08f4\u0141\3\2\2\2\u08f5\u08f9\5*\26\2\u08f6\u08f8"+
		"\5\u01ec\u00f7\2\u08f7\u08f6\3\2\2\2\u08f8\u08fb\3\2\2\2\u08f9\u08f7\3"+
		"\2\2\2\u08f9\u08fa\3\2\2\2\u08fa\u0143\3\2\2\2\u08fb\u08f9\3\2\2\2\u08fc"+
		"\u0908\5\u0126\u0094\2\u08fd\u08fe\5\u0128\u0095\2\u08fe\u08ff\5\u01b8"+
		"\u00dd\2\u08ff\u0908\3\2\2\2\u0900\u0901\5\u01ba\u00de\2\u0901\u0902\5"+
		"\u0128\u0095\2\u0902\u0908\3\2\2\2\u0903\u0904\5\u0126\u0094\2\u0904\u0905"+
		"\7N\2\2\u0905\u0906\5\u0144\u00a3\2\u0906\u0908\3\2\2\2\u0907\u08fc\3"+
		"\2\2\2\u0907\u08fd\3\2\2\2\u0907\u0900\3\2\2\2\u0907\u0903\3\2\2\2\u0908"+
		"\u0145\3\2\2\2\u0909\u090a\5\u0144\u00a3\2\u090a\u090b\5\u0148\u00a5\2"+
		"\u090b\u0919\3\2\2\2\u090c\u090d\5\u0144\u00a3\2\u090d\u090e\5\u01f2\u00fa"+
		"\2\u090e\u0919\3\2\2\2\u090f\u0911\5\u01f0\u00f9\2\u0910\u0912\5\u014a"+
		"\u00a6\2\u0911\u0910\3\2\2\2\u0911\u0912\3\2\2\2\u0912\u0919\3\2\2\2\u0913"+
		"\u0914\5\u01f2\u00fa\2\u0914\u0916\5\u0144\u00a3\2\u0915\u0917\5\u01f2"+
		"\u00fa\2\u0916\u0915\3\2\2\2\u0916\u0917\3\2\2\2\u0917\u0919\3\2\2\2\u0918"+
		"\u0909\3\2\2\2\u0918\u090c\3\2\2\2\u0918\u090f\3\2\2\2\u0918\u0913\3\2"+
		"\2\2\u0919\u0147\3\2\2\2\u091a\u091c\5\u01f0\u00f9\2\u091b\u091d\5\u014a"+
		"\u00a6\2\u091c\u091b\3\2\2\2\u091c\u091d\3\2\2\2\u091d\u0149\3\2\2\2\u091e"+
		"\u091f\5\u0144\u00a3\2\u091f\u0920\5\u0148\u00a5\2\u0920\u0923\3\2\2\2"+
		"\u0921\u0923\5\u0144\u00a3\2\u0922\u091e\3\2\2\2\u0922\u0921\3\2\2\2\u0923"+
		"\u014b\3\2\2\2\u0924\u093d\5\u0144\u00a3\2\u0925\u093d\5\u014e\u00a8\2"+
		"\u0926\u0927\5\u0144\u00a3\2\u0927\u0928\7d\2\2\u0928\u093d\3\2\2\2\u0929"+
		"\u092a\5\u0144\u00a3\2\u092a\u092b\7h\2\2\u092b\u092c\5\u0126\u0094\2"+
		"\u092c\u092d\7d\2\2\u092d\u093d\3\2\2\2\u092e\u092f\5\u0144\u00a3\2\u092f"+
		"\u0930\7d\2\2\u0930\u0931\5\u0126\u0094\2\u0931\u093d\3\2\2\2\u0932\u0933"+
		"\5\u0144\u00a3\2\u0933\u0934\7h\2\2\u0934\u0935\5\u0126\u0094\2\u0935"+
		"\u0936\7d\2\2\u0936\u0937\5\u0126\u0094\2\u0937\u093d\3\2\2\2\u0938\u0939"+
		"\5\u0144\u00a3\2\u0939\u093a\7X\2\2\u093a\u093b\5\u0150\u00a9\2\u093b"+
		"\u093d\3\2\2\2\u093c\u0924\3\2\2\2\u093c\u0925\3\2\2\2\u093c\u0926\3\2"+
		"\2\2\u093c\u0929\3\2\2\2\u093c\u092e\3\2\2\2\u093c\u0932\3\2\2\2\u093c"+
		"\u0938\3\2\2\2\u093d\u014d\3\2\2\2\u093e\u093f\5\u0144\u00a3\2\u093f\u0940"+
		"\7h\2\2\u0940\u0945\5\u0144\u00a3\2\u0941\u0942\7h\2\2\u0942\u0944\5\u0144"+
		"\u00a3\2\u0943\u0941\3\2\2\2\u0944\u0947\3\2\2\2\u0945\u0943\3\2\2\2\u0945"+
		"\u0946\3\2\2\2\u0946\u014f";
	private static final String _serializedATNSegment1 =
		"\3\2\2\2\u0947\u0945\3\2\2\2\u0948\u0949\5\u0152\u00aa\2\u0949\u0151\3"+
		"\2\2\2\u094a\u094f\5\u0154\u00ab\2\u094b\u094c\7X\2\2\u094c\u094e\5\u0154"+
		"\u00ab\2\u094d\u094b\3\2\2\2\u094e\u0951\3\2\2\2\u094f\u094d\3\2\2\2\u094f"+
		"\u0950\3\2\2\2\u0950\u0153\3\2\2\2\u0951\u094f\3\2\2\2\u0952\u0957\5\u0156"+
		"\u00ac\2\u0953\u0954\7h\2\2\u0954\u0956\5\u0156\u00ac\2\u0955\u0953\3"+
		"\2\2\2\u0956\u0959\3\2\2\2\u0957\u0955\3\2\2\2\u0957\u0958\3\2\2\2\u0958"+
		"\u0973\3\2\2\2\u0959\u0957\3\2\2\2\u095a\u095f\5\u0156\u00ac\2\u095b\u095c"+
		"\7h\2\2\u095c\u095e\5\u017a\u00be\2\u095d\u095b\3\2\2\2\u095e\u0961\3"+
		"\2\2\2\u095f\u095d\3\2\2\2\u095f\u0960\3\2\2\2\u0960\u0973\3\2\2\2\u0961"+
		"\u095f\3\2\2\2\u0962\u0967\5\u017a\u00be\2\u0963\u0964\7h\2\2\u0964\u0966"+
		"\5\u0156\u00ac\2\u0965\u0963\3\2\2\2\u0966\u0969\3\2\2\2\u0967\u0965\3"+
		"\2\2\2\u0967\u0968\3\2\2\2\u0968\u0973\3\2\2\2\u0969\u0967\3\2\2\2\u096a"+
		"\u096f\5\u017a\u00be\2\u096b\u096c\7h\2\2\u096c\u096e\5\u017a\u00be\2"+
		"\u096d\u096b\3\2\2\2\u096e\u0971\3\2\2\2\u096f\u096d\3\2\2\2\u096f\u0970"+
		"\3\2\2\2\u0970\u0973\3\2\2\2\u0971\u096f\3\2\2\2\u0972\u0952\3\2\2\2\u0972"+
		"\u095a\3\2\2\2\u0972\u0962\3\2\2\2\u0972\u096a\3\2\2\2\u0973\u0155\3\2"+
		"\2\2\u0974\u0975\7\33\2\2\u0975\u0987\5\u0126\u0094\2\u0976\u0977\7\33"+
		"\2\2\u0977\u0978\5\u0126\u0094\2\u0978\u0979\7/\2\2\u0979\u097a\5\u0126"+
		"\u0094\2\u097a\u0987\3\2\2\2\u097b\u097c\7\33\2\2\u097c\u097d\7.\2\2\u097d"+
		"\u097e\7\60\2\2\u097e\u0987\5\u0126\u0094\2\u097f\u0980\7\33\2\2\u0980"+
		"\u0981\7.\2\2\u0981\u0982\7/\2\2\u0982\u0983\5\u0126\u0094\2\u0983\u0984"+
		"\7\60\2\2\u0984\u0985\5\u0126\u0094\2\u0985\u0987\3\2\2\2\u0986\u0974"+
		"\3\2\2\2\u0986\u0976\3\2\2\2\u0986\u097b\3\2\2\2\u0986\u097f\3\2\2\2\u0987"+
		"\u0157\3\2\2\2\u0988\u098d\5\u015a\u00ae\2\u0989\u098a\7h\2\2\u098a\u098c"+
		"\5\u015a\u00ae\2\u098b\u0989\3\2\2\2\u098c\u098f\3\2\2\2\u098d\u098b\3"+
		"\2\2\2\u098d\u098e\3\2\2\2\u098e\u0159\3\2\2\2\u098f\u098d\3\2\2\2\u0990"+
		"\u0991\5\u016a\u00b6\2\u0991\u0992\7O\2\2\u0992\u0993\5\u0128\u0095\2"+
		"\u0993\u0998\3\2\2\2\u0994\u0995\7\26\2\2\u0995\u0998\5\u0086D\2\u0996"+
		"\u0998\5\u0128\u0095\2\u0997\u0990\3\2\2\2\u0997\u0994\3\2\2\2\u0997\u0996"+
		"\3\2\2\2\u0998\u015b\3\2\2\2\u0999\u09a1\5\u01e8\u00f5\2\u099a\u099e\5"+
		"\u015e\u00b0\2\u099b\u099d\5\u01ec\u00f7\2\u099c\u099b\3\2\2\2\u099d\u09a0"+
		"\3\2\2\2\u099e\u099c\3\2\2\2\u099e\u099f\3\2\2\2\u099f\u09a2\3\2\2\2\u09a0"+
		"\u099e\3\2\2\2\u09a1\u099a\3\2\2\2\u09a2\u09a3\3\2\2\2\u09a3\u09a1\3\2"+
		"\2\2\u09a3\u09a4\3\2\2\2\u09a4\u09a5\3\2\2\2\u09a5\u09a6\5\u01ea\u00f6"+
		"\2\u09a6\u09ab\3\2\2\2\u09a7\u09a8\5\u01e8\u00f5\2\u09a8\u09a9\5\u01ea"+
		"\u00f6\2\u09a9\u09ab\3\2\2\2\u09aa\u0999\3\2\2\2\u09aa\u09a7\3\2\2\2\u09ab"+
		"\u015d\3\2\2\2\u09ac\u09ad\5\u016a\u00b6\2\u09ad\u09ae\5\u0160\u00b1\2"+
		"\u09ae\u015f\3\2\2\2\u09af\u09b1\5\u0162\u00b2\2\u09b0\u09b2\5\u008aF"+
		"\2\u09b1\u09b0\3\2\2\2\u09b1\u09b2\3\2\2\2\u09b2\u0161\3\2\2\2\u09b3\u09b4"+
		"\7N\2\2\u09b4\u09b7\5\u0126\u0094\2\u09b5\u09b7\5\u0164\u00b3\2\u09b6"+
		"\u09b3\3\2\2\2\u09b6\u09b5\3\2\2\2\u09b7\u0163\3\2\2\2\u09b8\u09ba\5\u0168"+
		"\u00b5\2\u09b9\u09b8\3\2\2\2\u09ba\u09bb\3\2\2\2\u09bb\u09b9\3\2\2\2\u09bb"+
		"\u09bc\3\2\2\2\u09bc\u0165\3\2\2\2\u09bd\u09be\7\u0086\2\2\u09be\u09bf"+
		"\5\u0164\u00b3\2\u09bf\u09c0\7\u0087\2\2\u09c0\u09c3\3\2\2\2\u09c1\u09c3"+
		"\5\u0164\u00b3\2\u09c2\u09bd\3\2\2\2\u09c2\u09c1\3\2\2\2\u09c3\u0167\3"+
		"\2\2\2\u09c4\u09c5\7X\2\2\u09c5\u09c6\5\u0158\u00ad\2\u09c6\u09c7\7N\2"+
		"\2\u09c7\u09c8\5\u0126\u0094\2\u09c8\u0169\3\2\2\2\u09c9\u09ca\5\u0126"+
		"\u0094\2\u09ca\u016b\3\2\2\2\u09cb\u09cc\5\u0126\u0094\2\u09cc\u016d\3"+
		"\2\2\2\u09cd\u09ce\5\u0130\u0099\2\u09ce\u016f\3\2\2\2\u09cf\u09d1\5\u016e"+
		"\u00b8\2\u09d0\u09cf\3\2\2\2\u09d1\u09d2\3\2\2\2\u09d2\u09d0\3\2\2\2\u09d2"+
		"\u09d3\3\2\2\2\u09d3\u0171\3\2\2\2\u09d4\u09d5\5\u01ce\u00e8\2\u09d5\u09d6"+
		"\7j\2\2\u09d6\u09d7\5\u016a\u00b6\2\u09d7\u0173\3\2\2\2\u09d8\u09da\5"+
		"\u01e8\u00f5\2\u09d9\u09db\5\u0176\u00bc\2\u09da\u09d9\3\2\2\2\u09da\u09db"+
		"\3\2\2\2\u09db\u09dc\3\2\2\2\u09dc\u09dd\5\u01ea\u00f6\2\u09dd\u0175\3"+
		"\2\2\2\u09de\u09e8\5\u0178\u00bd\2\u09df\u09e1\5\u01ec\u00f7\2\u09e0\u09df"+
		"\3\2\2\2\u09e1\u09e2\3\2\2\2\u09e2\u09e0\3\2\2\2\u09e2\u09e3\3\2\2\2\u09e3"+
		"\u09e4\3\2\2\2\u09e4\u09e5\5\u0178\u00bd\2\u09e5\u09e7\3\2\2\2\u09e6\u09e0"+
		"\3\2\2\2\u09e7\u09ea\3\2\2\2\u09e8\u09e6\3\2\2\2\u09e8\u09e9\3\2\2\2\u09e9"+
		"\u09ee\3\2\2\2\u09ea\u09e8\3\2\2\2\u09eb\u09ed\5\u01ec\u00f7\2\u09ec\u09eb"+
		"\3\2\2\2\u09ed\u09f0\3\2\2\2\u09ee\u09ec\3\2\2\2\u09ee\u09ef\3\2\2\2\u09ef"+
		"\u0177\3\2\2\2\u09f0\u09ee\3\2\2\2\u09f1\u09fa\5\u017a\u00be\2\u09f2\u09f3"+
		"\7-\2\2\u09f3\u09fa\5\u0174\u00bb\2\u09f4\u09f6\5\u01ec\u00f7\2\u09f5"+
		"\u09f4\3\2\2\2\u09f6\u09f7\3\2\2\2\u09f7\u09f5\3\2\2\2\u09f7\u09f8\3\2"+
		"\2\2\u09f8\u09fa\3\2\2\2\u09f9\u09f1\3\2\2\2\u09f9\u09f2\3\2\2\2\u09f9"+
		"\u09f5\3\2\2\2\u09fa\u0179\3\2\2\2\u09fb\u09fc\5\u016c\u00b7\2\u09fc\u09fd"+
		"\7O\2\2\u09fd\u09fe\5\u0126\u0094\2\u09fe\u0a03\3\2\2\2\u09ff\u0a03\5"+
		"\u0126\u0094\2\u0a00\u0a01\7\26\2\2\u0a01\u0a03\5\u0088E\2\u0a02\u09fb"+
		"\3\2\2\2\u0a02\u09ff\3\2\2\2\u0a02\u0a00\3\2\2\2\u0a03\u017b\3\2\2\2\u0a04"+
		"\u0a09\5\u017e\u00c0\2\u0a05\u0a06\7h\2\2\u0a06\u0a08\5\u017e\u00c0\2"+
		"\u0a07\u0a05\3\2\2\2\u0a08\u0a0b\3\2\2\2\u0a09\u0a07\3\2\2\2\u0a09\u0a0a"+
		"\3\2\2\2\u0a0a\u0a0e\3\2\2\2\u0a0b\u0a09\3\2\2\2\u0a0c\u0a0e\7d\2\2\u0a0d"+
		"\u0a04\3\2\2\2\u0a0d\u0a0c\3\2\2\2\u0a0e\u017d\3\2\2\2\u0a0f\u0a10\5\u01ce"+
		"\u00e8\2\u0a10\u0a11\7j\2\2\u0a11\u0a12\5\u0126\u0094\2\u0a12\u0a15\3"+
		"\2\2\2\u0a13\u0a15\5\u01ce\u00e8\2\u0a14\u0a0f\3\2\2\2\u0a14\u0a13\3\2"+
		"\2\2\u0a15\u017f\3\2\2\2\u0a16\u0a18\5\u0182\u00c2\2\u0a17\u0a19\5\u01ec"+
		"\u00f7\2\u0a18\u0a17\3\2\2\2\u0a19\u0a1a\3\2\2\2\u0a1a\u0a18\3\2\2\2\u0a1a"+
		"\u0a1b\3\2\2\2\u0a1b\u0a1c\3\2\2\2\u0a1c\u0a1d\5\u0182\u00c2\2\u0a1d\u0a21"+
		"\3\2\2\2\u0a1e\u0a20\5\u01ec\u00f7\2\u0a1f\u0a1e\3\2\2\2\u0a20\u0a23\3"+
		"\2\2\2\u0a21\u0a1f\3\2\2\2\u0a21\u0a22\3\2\2\2\u0a22\u0181\3\2\2\2\u0a23"+
		"\u0a21\3\2\2\2\u0a24\u0a25\5\u01d2\u00ea\2\u0a25\u0a26\7j\2\2\u0a26\u0a27"+
		"\5\u0126\u0094\2\u0a27\u0183\3\2\2\2\u0a28\u0a2d\5\u0186\u00c4\2\u0a29"+
		"\u0a2a\7X\2\2\u0a2a\u0a2c\5\u0186\u00c4\2\u0a2b\u0a29\3\2\2\2\u0a2c\u0a2f"+
		"\3\2\2\2\u0a2d\u0a2b\3\2\2\2\u0a2d\u0a2e\3\2\2\2\u0a2e\u0185\3\2\2\2\u0a2f"+
		"\u0a2d\3\2\2\2\u0a30\u0a31\5\u0188\u00c5\2\u0a31\u0187\3\2\2\2\u0a32\u0a37"+
		"\5\u018a\u00c6\2\u0a33\u0a34\7h\2\2\u0a34\u0a36\5\u018a\u00c6\2\u0a35"+
		"\u0a33\3\2\2\2\u0a36\u0a39\3\2\2\2\u0a37\u0a35\3\2\2\2\u0a37\u0a38\3\2"+
		"\2\2\u0a38\u0189\3\2\2\2\u0a39\u0a37\3\2\2\2\u0a3a\u0a3b\7z\2\2\u0a3b"+
		"\u0a3c\5\u0184\u00c3\2\u0a3c\u0a3d\7{\2\2\u0a3d\u0a40\3\2\2\2\u0a3e\u0a40"+
		"\5\u018e\u00c8\2\u0a3f\u0a3a\3\2\2\2\u0a3f\u0a3e\3\2\2\2\u0a40\u018b\3"+
		"\2\2\2\u0a41\u0a46\5\u018e\u00c8\2\u0a42\u0a43\7h\2\2\u0a43\u0a45\5\u018e"+
		"\u00c8\2\u0a44\u0a42\3\2\2\2\u0a45\u0a48\3\2\2\2\u0a46\u0a44\3\2\2\2\u0a46"+
		"\u0a47\3\2\2\2\u0a47\u018d\3\2\2\2\u0a48\u0a46\3\2\2\2\u0a49\u0a4c\5\u01cc"+
		"\u00e7\2\u0a4a\u0a4c\5\u0196\u00cc\2\u0a4b\u0a49\3\2\2\2\u0a4b\u0a4a\3"+
		"\2\2\2\u0a4c\u018f\3\2\2\2\u0a4d\u0a50\5\u0194\u00cb\2\u0a4e\u0a50\5\u019a"+
		"\u00ce\2\u0a4f\u0a4d\3\2\2\2\u0a4f\u0a4e\3\2\2\2\u0a50\u0191\3\2\2\2\u0a51"+
		"\u0a54\5\u0194\u00cb\2\u0a52\u0a54\5\u019c\u00cf\2\u0a53\u0a51\3\2\2\2"+
		"\u0a53\u0a52\3\2\2\2\u0a54\u0193\3\2\2\2\u0a55\u0a5b\5\u01de\u00f0\2\u0a56"+
		"\u0a57\7z\2\2\u0a57\u0a58\5\u01e2\u00f2\2\u0a58\u0a59\7{\2\2\u0a59\u0a5b"+
		"\3\2\2\2\u0a5a\u0a55\3\2\2\2\u0a5a\u0a56\3\2\2\2\u0a5b\u0195\3\2\2\2\u0a5c"+
		"\u0a63\5\u01e0\u00f1\2\u0a5d\u0a5e\7z\2\2\u0a5e\u0a5f\5\u01e4\u00f3\2"+
		"\u0a5f\u0a60\7{\2\2\u0a60\u0a63\3\2\2\2\u0a61\u0a63\5\u019c\u00cf\2\u0a62"+
		"\u0a5c\3\2\2\2\u0a62\u0a5d\3\2\2\2\u0a62\u0a61\3\2\2\2\u0a63\u0197\3\2"+
		"\2\2\u0a64\u0a69\5\u0196\u00cc\2\u0a65\u0a66\7h\2\2\u0a66\u0a68\5\u0196"+
		"\u00cc\2\u0a67\u0a65\3\2\2\2\u0a68\u0a6b\3\2\2\2\u0a69\u0a67\3\2\2\2\u0a69"+
		"\u0a6a\3\2\2\2\u0a6a\u0199\3\2\2\2\u0a6b\u0a69\3\2\2\2\u0a6c\u0a6d\7z"+
		"\2\2\u0a6d\u0a79\7{\2\2\u0a6e\u0a6f\7z\2\2\u0a6f\u0a70\5\u01f0\u00f9\2"+
		"\u0a70\u0a71\7{\2\2\u0a71\u0a79\3\2\2\2\u0a72\u0a73\7x\2\2\u0a73\u0a79"+
		"\7y\2\2\u0a74\u0a75\7x\2\2\u0a75\u0a76\5\u01f0\u00f9\2\u0a76\u0a77\7y"+
		"\2\2\u0a77\u0a79\3\2\2\2\u0a78\u0a6c\3\2\2\2\u0a78\u0a6e\3\2\2\2\u0a78"+
		"\u0a72\3\2\2\2\u0a78\u0a74\3\2\2\2\u0a79\u019b\3\2\2\2\u0a7a\u0a7e\5\u019a"+
		"\u00ce\2\u0a7b\u0a7c\7|\2\2\u0a7c\u0a7e\7}\2\2\u0a7d\u0a7a\3\2\2\2\u0a7d"+
		"\u0a7b\3\2\2\2\u0a7e\u019d\3\2\2\2\u0a7f\u0a85\5\u01e4\u00f3\2\u0a80\u0a81"+
		"\7n\2\2\u0a81\u0a82\5\u01e0\u00f1\2\u0a82\u0a83\7n\2\2\u0a83\u0a85\3\2"+
		"\2\2\u0a84\u0a7f\3\2\2\2\u0a84\u0a80\3\2\2\2\u0a85\u019f\3\2\2\2\u0a86"+
		"\u0a8c\5\u01a2\u00d2\2\u0a87\u0a88\7n\2\2\u0a88\u0a89\5\u01de\u00f0\2"+
		"\u0a89\u0a8a\7n\2\2\u0a8a\u0a8c\3\2\2\2\u0a8b\u0a86\3\2\2\2\u0a8b\u0a87"+
		"\3\2\2\2\u0a8c\u01a1\3\2\2\2\u0a8d\u0a90\7i\2\2\u0a8e\u0a90\5\u01e2\u00f2"+
		"\2\u0a8f\u0a8d\3\2\2\2\u0a8f\u0a8e\3\2\2\2\u0a90\u01a3\3\2\2\2\u0a91\u0a97"+
		"\5\u01a6\u00d4\2\u0a92\u0a93\7z\2\2\u0a93\u0a97\7{\2\2\u0a94\u0a95\7x"+
		"\2\2\u0a95\u0a97\7y\2\2\u0a96\u0a91\3\2\2\2\u0a96\u0a92\3\2\2\2\u0a96"+
		"\u0a94\3\2\2\2\u0a97\u01a5\3\2\2\2\u0a98\u0aa7\5\u01a8\u00d5\2\u0a99\u0a9a"+
		"\7z\2\2\u0a9a\u0a9b\5\u01f0\u00f9\2\u0a9b\u0a9c\7{\2\2\u0a9c\u0aa7\3\2"+
		"\2\2\u0a9d\u0a9e\7x\2\2\u0a9e\u0a9f\5\u01f0\u00f9\2\u0a9f\u0aa0\7y\2\2"+
		"\u0aa0\u0aa7\3\2\2\2\u0aa1\u0aa2\7z\2\2\u0aa2\u0aa3\7N\2\2\u0aa3\u0aa7"+
		"\7{\2\2\u0aa4\u0aa5\7|\2\2\u0aa5\u0aa7\7}\2\2\u0aa6\u0a98\3\2\2\2\u0aa6"+
		"\u0a99\3\2\2\2\u0aa6\u0a9d\3\2\2\2\u0aa6\u0aa1\3\2\2\2\u0aa6\u0aa4\3\2"+
		"\2\2\u0aa7\u01a7\3\2\2\2\u0aa8\u0aae\5\u01ac\u00d7\2\u0aa9\u0aaa\7z\2"+
		"\2\u0aaa\u0aab\5\u01b0\u00d9\2\u0aab\u0aac\7{\2\2\u0aac\u0aae\3\2\2\2"+
		"\u0aad\u0aa8\3\2\2\2\u0aad\u0aa9\3\2\2\2\u0aae\u01a9\3\2\2\2\u0aaf\u0ab5"+
		"\5\u01b0\u00d9\2\u0ab0\u0ab1\7n\2\2\u0ab1\u0ab2\5\u01ac\u00d7\2\u0ab2"+
		"\u0ab3\7n\2\2\u0ab3\u0ab5\3\2\2\2\u0ab4\u0aaf\3\2\2\2\u0ab4\u0ab0\3\2"+
		"\2\2\u0ab5\u01ab\3\2\2\2\u0ab6\u0ab7\5\u01ee\u00f8\2\u0ab7\u0ab8\7e\2"+
		"\2\u0ab8\u0aba\3\2\2\2\u0ab9\u0ab6\3\2\2\2\u0ab9\u0aba\3\2\2\2\u0aba\u0abb"+
		"\3\2\2\2\u0abb\u0abc\5\u01ae\u00d8\2\u0abc\u01ad\3\2\2\2\u0abd\u0abe\5"+
		"\u01e0\u00f1\2\u0abe\u01af\3\2\2\2\u0abf\u0ac3\5\u01e2\u00f2\2\u0ac0\u0ac3"+
		"\5\u01d4\u00eb\2\u0ac1\u0ac3\5\u01b2\u00da\2\u0ac2\u0abf\3\2\2\2\u0ac2"+
		"\u0ac0\3\2\2\2\u0ac2\u0ac1\3\2\2\2\u0ac3\u01b1\3\2\2\2\u0ac4\u0aca\5\u01e4"+
		"\u00f3\2\u0ac5\u0aca\5\u01d8\u00ed\2\u0ac6\u0aca\7i\2\2\u0ac7\u0aca\7"+
		"\\\2\2\u0ac8\u0aca\7e\2\2\u0ac9\u0ac4\3\2\2\2\u0ac9\u0ac5\3\2\2\2\u0ac9"+
		"\u0ac6\3\2\2\2\u0ac9\u0ac7\3\2\2\2\u0ac9\u0ac8\3\2\2\2\u0aca\u01b3\3\2"+
		"\2\2\u0acb\u0ace\5\u01b6\u00dc\2\u0acc\u0ace\5\u019e\u00d0\2\u0acd\u0acb"+
		"\3\2\2\2\u0acd\u0acc\3\2\2\2\u0ace\u01b5\3\2\2\2\u0acf\u0ad5\5\u01d8\u00ed"+
		"\2\u0ad0\u0ad1\7n\2\2\u0ad1\u0ad2\5\u01d2\u00ea\2\u0ad2\u0ad3\7n\2\2\u0ad3"+
		"\u0ad5\3\2\2\2\u0ad4\u0acf\3\2\2\2\u0ad4\u0ad0\3\2\2\2\u0ad5\u01b7\3\2"+
		"\2\2\u0ad6\u0ad9\5\u01be\u00e0\2\u0ad7\u0ad9\5\u01a0\u00d1\2\u0ad8\u0ad6"+
		"\3\2\2\2\u0ad8\u0ad7\3\2\2\2\u0ad9\u01b9\3\2\2\2\u0ada\u0ade\5\u01c0\u00e1"+
		"\2\u0adb\u0ade\5\u01a0\u00d1\2\u0adc\u0ade\5\u01bc\u00df\2\u0add\u0ada"+
		"\3\2\2\2\u0add\u0adb\3\2\2\2\u0add\u0adc\3\2\2\2\u0ade\u01bb\3\2\2\2\u0adf"+
		"\u0ae0\7n\2\2\u0ae0\u0ae1\7\36\2\2\u0ae1\u0ae2\7n\2\2\u0ae2\u01bd\3\2"+
		"\2\2\u0ae3\u0ae9\5\u01d4\u00eb\2\u0ae4\u0ae5\7n\2\2\u0ae5\u0ae6\5\u01d0"+
		"\u00e9\2\u0ae6\u0ae7\7n\2\2\u0ae7\u0ae9\3\2\2\2\u0ae8\u0ae3\3\2\2\2\u0ae8"+
		"\u0ae4\3\2\2\2\u0ae9\u01bf\3\2\2\2\u0aea\u0af0\5\u01d6\u00ec\2\u0aeb\u0aec"+
		"\7n\2\2\u0aec\u0aed\5\u01d0\u00e9\2\u0aed\u0aee\7n\2\2\u0aee\u0af0\3\2"+
		"\2\2\u0aef\u0aea\3\2\2\2\u0aef\u0aeb\3\2\2\2\u0af0\u01c1\3\2\2\2\u0af1"+
		"\u0af2\5\u01d2\u00ea\2\u0af2\u01c3\3\2\2\2\u0af3\u0af4\7n\2\2\u0af4\u0af5"+
		"\5\u01c6\u00e4\2\u0af5\u0af6\7n\2\2\u0af6\u01c5\3\2\2\2\u0af7\u0afd\5"+
		"\u01d2\u00ea\2\u0af8\u0afd\5\u01dc\u00ef\2\u0af9\u0afd\7$\2\2\u0afa\u0afd"+
		"\7\"\2\2\u0afb\u0afd\7#\2\2\u0afc\u0af7\3\2\2\2\u0afc\u0af8\3\2\2\2\u0afc"+
		"\u0af9\3\2\2\2\u0afc\u0afa\3\2\2\2\u0afc\u0afb\3\2\2\2\u0afd\u01c7\3\2"+
		"\2\2\u0afe\u0aff\5\u01e0\u00f1\2\u0aff\u01c9\3\2\2\2\u0b00\u0b01\5\u01ee"+
		"\u00f8\2\u0b01\u0b02\7e\2\2\u0b02\u0b04\3\2\2\2\u0b03\u0b00\3\2\2\2\u0b03"+
		"\u0b04\3\2\2\2\u0b04\u0b05\3\2\2\2\u0b05\u0b06\5\u01c8\u00e5\2\u0b06\u01cb"+
		"\3\2\2\2\u0b07\u0b0d\5\u01d2\u00ea\2\u0b08\u0b09\7z\2\2\u0b09\u0b0a\5"+
		"\u01d8\u00ed\2\u0b0a\u0b0b\7{\2\2\u0b0b\u0b0d\3\2\2\2\u0b0c\u0b07\3\2"+
		"\2\2\u0b0c\u0b08\3\2\2\2\u0b0d\u01cd\3\2\2\2\u0b0e\u0b14\5\u01d0\u00e9"+
		"\2\u0b0f\u0b10\7z\2\2\u0b10\u0b11\5\u01d4\u00eb\2\u0b11\u0b12\7{\2\2\u0b12"+
		"\u0b14\3\2\2\2\u0b13\u0b0e\3\2\2\2\u0b13\u0b0f\3\2\2\2\u0b14\u01cf\3\2"+
		"\2\2\u0b15\u0b16\5\u01ee\u00f8\2\u0b16\u0b17\7e\2\2\u0b17\u0b19\3\2\2"+
		"\2\u0b18\u0b15\3\2\2\2\u0b18\u0b19\3\2\2\2\u0b19\u0b1a\3\2\2\2\u0b1a\u0b1b"+
		"\5\u01d2\u00ea\2\u0b1b\u01d1\3\2\2\2\u0b1c\u0b1f\7\u0080\2\2\u0b1d\u0b1f"+
		"\5\u01dc\u00ef\2\u0b1e\u0b1c\3\2\2\2\u0b1e\u0b1d\3\2\2\2\u0b1f\u0b23\3"+
		"\2\2\2\u0b20\u0b22\7T\2\2\u0b21\u0b20\3\2\2\2\u0b22\u0b25\3\2\2\2\u0b23"+
		"\u0b21\3\2\2\2\u0b23\u0b24\3\2\2\2\u0b24\u01d3\3\2\2\2\u0b25\u0b23\3\2"+
		"\2\2\u0b26\u0b27\5\u01ee\u00f8\2\u0b27\u0b28\7e\2\2\u0b28\u0b2a\3\2\2"+
		"\2\u0b29\u0b26\3\2\2\2\u0b29\u0b2a\3\2\2\2\u0b2a\u0b2b\3\2\2\2\u0b2b\u0b2c"+
		"\5\u01d8\u00ed\2\u0b2c\u01d5\3\2\2\2\u0b2d\u0b30\5\u01da\u00ee\2\u0b2e"+
		"\u0b30\5\u01d4\u00eb\2\u0b2f\u0b2d\3\2\2\2\u0b2f\u0b2e\3\2\2\2\u0b30\u01d7"+
		"\3\2\2\2\u0b31\u0b34\5\u01da\u00ee\2\u0b32\u0b34\7\\\2\2\u0b33\u0b31\3"+
		"\2\2\2\u0b33\u0b32\3\2\2\2\u0b34\u01d9\3\2\2\2\u0b35\u0b37\5\u01f8\u00fd"+
		"\2\u0b36\u0b35\3\2\2\2\u0b37\u0b38\3\2\2\2\u0b38\u0b36\3\2\2\2\u0b38\u0b39"+
		"\3\2\2\2\u0b39\u01db\3\2\2\2\u0b3a\u0b3b\t\7\2\2\u0b3b\u01dd\3\2\2\2\u0b3c"+
		"\u0b3d\5\u01ee\u00f8\2\u0b3d\u0b3e\7e\2\2\u0b3e\u0b40\3\2\2\2\u0b3f\u0b3c"+
		"\3\2\2\2\u0b3f\u0b40\3\2\2\2\u0b40\u0b41\3\2\2\2\u0b41\u0b42\5\u01e0\u00f1"+
		"\2\u0b42\u01df\3\2\2\2\u0b43\u0b47\7\u0081\2\2\u0b44\u0b46\7T\2\2\u0b45"+
		"\u0b44\3\2\2\2\u0b46\u0b49\3\2\2\2\u0b47\u0b45\3\2\2\2\u0b47\u0b48\3\2"+
		"\2\2\u0b48\u01e1\3\2\2\2\u0b49\u0b47\3\2\2\2\u0b4a\u0b4b\5\u01ee\u00f8"+
		"\2\u0b4b\u0b4c\7e\2\2\u0b4c\u0b4e\3\2\2\2\u0b4d\u0b4a\3\2\2\2\u0b4d\u0b4e"+
		"\3\2\2\2\u0b4e\u0b4f\3\2\2\2\u0b4f\u0b50\5\u01e4\u00f3\2\u0b50\u01e3\3"+
		"\2\2\2\u0b51\u0b55\7i\2\2\u0b52\u0b54\5\u01f8\u00fd\2\u0b53\u0b52\3\2"+
		"\2\2\u0b54\u0b57\3\2\2\2\u0b55\u0b53\3\2\2\2\u0b55\u0b56\3\2\2\2\u0b56"+
		"\u01e5\3\2\2\2\u0b57\u0b55\3\2\2\2\u0b58\u0b5d\5\u01fa\u00fe\2\u0b59\u0b5d"+
		"\5\u01fc\u00ff\2\u0b5a\u0b5d\5\u01fe\u0100\2\u0b5b\u0b5d\5\u0200\u0101"+
		"\2\u0b5c\u0b58\3\2\2\2\u0b5c\u0b59\3\2\2\2\u0b5c\u0b5a\3\2\2\2\u0b5c\u0b5b"+
		"\3\2\2\2\u0b5d\u01e7\3\2\2\2\u0b5e\u0b5f\t\b\2\2\u0b5f\u01e9\3\2\2\2\u0b60"+
		"\u0b61\t\t\2\2\u0b61\u01eb\3\2\2\2\u0b62\u0b63\t\n\2\2\u0b63\u01ed\3\2"+
		"\2\2\u0b64\u0b65\5\u01e0\u00f1\2\u0b65\u0b66\7e\2\2\u0b66\u0b68\3\2\2"+
		"\2\u0b67\u0b64\3\2\2\2\u0b68\u0b6b\3\2\2\2\u0b69\u0b67\3\2\2\2\u0b69\u0b6a"+
		"\3\2\2\2\u0b6a\u0b6c\3\2\2\2\u0b6b\u0b69\3\2\2\2\u0b6c\u0b6d\5\u01e0\u00f1"+
		"\2\u0b6d\u01ef\3\2\2\2\u0b6e\u0b70\7h\2\2\u0b6f\u0b6e\3\2\2\2\u0b70\u0b71"+
		"\3\2\2\2\u0b71\u0b6f\3\2\2\2\u0b71\u0b72\3\2\2\2\u0b72\u01f1\3\2\2\2\u0b73"+
		"\u0b75\7X\2\2\u0b74\u0b73\3\2\2\2\u0b75\u0b76\3\2\2\2\u0b76\u0b74\3\2"+
		"\2\2\u0b76\u0b77\3\2\2\2\u0b77\u01f3\3\2\2\2\u0b78\u0b79\t\13\2\2\u0b79"+
		"\u01f5\3\2\2\2\u0b7a\u0b7b\5\u01f8\u00fd\2\u0b7b\u01f7\3\2\2\2\u0b7c\u0b7d"+
		"\t\f\2\2\u0b7d\u01f9\3\2\2\2\u0b7e\u0b7f\t\r\2\2\u0b7f\u01fb\3\2\2\2\u0b80"+
		"\u0b81\7\u008e\2\2\u0b81\u01fd\3\2\2\2\u0b82\u0b83\7~\2\2\u0b83\u01ff"+
		"\3\2\2\2\u0b84\u0b85\7\177\2\2\u0b85\u0201\3\2\2\2\u0159\u0203\u0208\u020c"+
		"\u0211\u0216\u0219\u021c\u0223\u0230\u0236\u023b\u0244\u0249\u0250\u0254"+
		"\u0259\u0260\u0264\u0269\u0272\u0277\u0279\u0281\u0284\u0287\u0296\u0299"+
		"\u029c\u02a8\u02ab\u02ae\u02b2\u02b6\u02bb\u02be\u02c3\u02cb\u02cf\u02d1"+
		"\u02db\u02df\u02e1\u02e4\u02f1\u02f4\u02f7\u02ff\u0302\u0304\u0308\u0311"+
		"\u0318\u031c\u031e\u0329\u0331\u0337\u033d\u0343\u0348\u034b\u0356\u0359"+
		"\u035c\u0360\u0365\u0369\u036e\u0372\u0376\u0379\u037c\u0380\u0384\u0387"+
		"\u038a\u0390\u0392\u039e\u03a3\u03a7\u03af\u03b3\u03b8\u03bc\u03c1\u03c5"+
		"\u03c8\u03cb\u03d0\u03d4\u03d7\u03da\u03dc\u03ea\u03f5\u0401\u0408\u0413"+
		"\u0419\u041f\u0425\u042a\u0435\u0439\u043d\u0441\u0445\u0449\u044c\u0450"+
		"\u0455\u0458\u045d\u0461\u0464\u0469\u046d\u0470\u0474\u0477\u047a\u047e"+
		"\u0481\u0485\u0488\u048b\u048d\u0499\u04a2\u04a9\u04ad\u04b6\u04bf\u04ca"+
		"\u04ce\u04d2\u04da\u04df\u04e3\u04ef\u04f1\u04f5\u0500\u0505\u050c\u0512"+
		"\u0522\u0528\u052e\u0534\u0539\u0542\u0548\u054e\u0554\u0559\u0564\u056a"+
		"\u0570\u0575\u057c\u0580\u058b\u058f\u0593\u0596\u059e\u05ad\u05b1\u05b6"+
		"\u05b9\u05be\u05c7\u05cf\u05d3\u05de\u05e2\u05ea\u05ed\u05f4\u0609\u060e"+
		"\u0616\u061d\u0632\u063a\u0643\u064c\u0653\u0657\u0665\u0669\u0677\u0682"+
		"\u0689\u0690\u0699\u06a5\u06b0\u06db\u06e9\u06f2\u06fa\u0704\u070a\u0717"+
		"\u0720\u072a\u072e\u0732\u0737\u073e\u0743\u074e\u075f\u0763\u0768\u076e"+
		"\u0779\u0783\u078f\u0798\u079d\u07a5\u07a7\u07ae\u07b0\u07b5\u07b9\u07bb"+
		"\u07c0\u07d3\u07dc\u07e3\u07ec\u07f3\u07fd\u080e\u0814\u0816\u0821\u082d"+
		"\u0844\u084c\u0852\u0859\u085d\u0876\u087b\u088c\u0891\u0896\u08d8\u08dc"+
		"\u08e0\u08eb\u08f1\u08f9\u0907\u0911\u0916\u0918\u091c\u0922\u093c\u0945"+
		"\u094f\u0957\u095f\u0967\u096f\u0972\u0986\u098d\u0997\u099e\u09a3\u09aa"+
		"\u09b1\u09b6\u09bb\u09c2\u09d2\u09da\u09e2\u09e8\u09ee\u09f7\u09f9\u0a02"+
		"\u0a09\u0a0d\u0a14\u0a1a\u0a21\u0a2d\u0a37\u0a3f\u0a46\u0a4b\u0a4f\u0a53"+
		"\u0a5a\u0a62\u0a69\u0a78\u0a7d\u0a84\u0a8b\u0a8f\u0a96\u0aa6\u0aad\u0ab4"+
		"\u0ab9\u0ac2\u0ac9\u0acd\u0ad4\u0ad8\u0add\u0ae8\u0aef\u0afc\u0b03\u0b0c"+
		"\u0b13\u0b18\u0b1e\u0b23\u0b29\u0b2f\u0b33\u0b38\u0b3f\u0b47\u0b4d\u0b55"+
		"\u0b5c\u0b69\u0b71\u0b76";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}