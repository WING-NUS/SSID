/*
This file is part of SSID.

SSID is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SSID is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with SSID.  If not, see <http://www.gnu.org/licenses/>.
 */
 
package Tokenizer;

import java.util.*;
import pd.utils.*;
import pd.utils.Tokens.*;

public final class CTokenizer extends Tokenizer {

	private static CTokenizer instance = new CTokenizer();
	public static final String language = "c";

	private CTokenizer() {
		insertCKeywords();
	}

	public static Tokenizer getTokenizer() {
		return instance;
	}

	public void TokenizeSubmissions(ArrayList<Submission> submissions) {

		for (Submission s : submissions) {
			tokenize(s);
		}
	}

	private void insertCKeywords() {
		String[] c_keys = { "asm", "auto", "__align", "__alignof__", "__asm",
				"__asm__", "__attribute__", "bool", "_Bool", "break", "case",
				"catch", "char", "class", "_Complex", "__complex__", "const",
				"__const__", "const_cast", "continue", "default", "delete",
				"do", "double", "dynamic_cast", "else", "enum", "explicit",
				"extern", "__extension__", "export", "false", "float", "for",
				"friend", "goto", "if", "_Imaginary", "__imag__", "inline",
				"__inline__", "int", "__label__", "long", "mutable",
				"namespace", "new", "operator", "private", "protected",
				"public", "__real__", "register", "reinterpret_cast",
				"restrict", "__restrict", "__restrict__", "return", "short",
				"signed", "__signed__", "sizeof", "static", "static_cast",
				"struct", "switch", "template", "this", "throw", "true", "try",
				"typeof", "__typeof__", "typedef", "typeid", "typename",
				"uint_least16_t", "uint_least32_t", "union", "unsigned",
				"using", "virtual", "void", "volatile", "__volatile__",
				"wchar_t", "while" };

		String[] c_ignorable_keys = { "private", "protected", "public", "const" };

		for (String s : c_keys) {
			keywords.add(s);
		}

		for (String s : c_ignorable_keys) {
			ignorableKeywords.add(s);
		}

		String[] constantKeys = { "true", "false" };
		constantKeywords = new HashSet<String>();
		for (String s : constantKeys) {
			constantKeywords.add(s);
		}
	}

	private void tokenize(Submission s) {

		// ArrayList<KGramChar> result = new ArrayList<KGramChar>();
		// TokenList result = new TokenList();
		TokenList result = new TokenList();

		ArrayList<String> lines = s.getCombinedCode();
		int linesNo = lines.size();

		boolean[] commentTypes = { false, false };

		int gPos = 0;
		LineReader lr; // Line Reader
		String line;

		int blocks = 0, brackets = 0;

		boolean nextTokenIsStartOfStatement = true, ignorableToken = false; // ignorableToken,
																			// record
																			// prev
																			// TokenSSID
																			// is
																			// ignorable
		boolean preBlock = false; // For recording if current in if, while
		boolean postBlock = false; // For recording if current in do
		Stack<Boolean> blockDeclared = new Stack<Boolean>(); // for keep
																// tracking of
																// auto added -
																// true = in
																// code, false =
																// auto

		for (int i = 0; i < linesNo; i++) {
			line = lines.get(i);

			lr = new LineReader(line, gPos);
			commentTypes[SINGLE_LINE_COMMENT] = false;

			char curChar;

			// take care of preprocess directive, based on c has preprocess
			// directives with # and must be the first char
			boolean preprocessDirective;
			if (blocks == 0 && lr.peek() == '#'
					&& !commentTypes[MULTI_LINE_COMMENT]) {
				preprocessDirective = true;
			} else {
				preprocessDirective = false;
			}

			while (lr.peek() != -1) {
				curChar = (char) lr.read();
				if (commentTypes[SINGLE_LINE_COMMENT]) {
					lr.moveEnd();
				} else if (commentTypes[MULTI_LINE_COMMENT]) {
					removeMultiLineComment(lr, curChar, commentTypes);
				} else if (Character.isLetter(curChar) || curChar == '_') {

					if (preBlock && brackets == 0) {
						preBlock = false;
						addOpenBlockBracket(result);
						blocks++;
						blockDeclared.push(false);
						nextTokenIsStartOfStatement = true;
					} else if (postBlock) {
						postBlock = false;
						addOpenBlockBracket(result);
						blocks++;
						blockDeclared.push(false);
						nextTokenIsStartOfStatement = true;
					}

					String word = digestWord(result, lr, curChar, i,
							nextTokenIsStartOfStatement);
					nextTokenIsStartOfStatement = false;

					if (ignorableToken) {
						TokenSSID last = result.get(result.size() - 1);
						TokenSSID prev = result.get(result.size() - 2);

						result.remove(result.size() - 2);
						last.setStartOfStatement(prev.isStartOfStatement());
						last.setLine(prev.getCodeLine());
						last.setCodeStartIndex(prev.getCodeStartIndex());

						ignorableToken = false;
					}

					if (word.equals("for") || word.equals("while")
							|| word.equals("if") || word.equals("else")) {
						preBlock = true;
					} else if (word.equals("do")) {
						postBlock = true;
					} else if (ignorableKeywords.contains(word)) {
						ignorableToken = true;
					}

				} else if (Character.isDigit(curChar)) {

					if (preBlock && brackets == 0) {
						preBlock = false;
						addOpenBlockBracket(result);
						blocks++;
						blockDeclared.push(false);
						nextTokenIsStartOfStatement = true;
					} else if (postBlock) {
						postBlock = false;
						addOpenBlockBracket(result);
						blocks++;
						blockDeclared.push(false);
						nextTokenIsStartOfStatement = true;
					}

					digestNum(result, lr, i, nextTokenIsStartOfStatement);
					nextTokenIsStartOfStatement = false;

				} else {
					digestSymbol(result, lr, curChar, commentTypes, i,
							(preprocessDirective) ? nextTokenIsStartOfStatement
									: false);
					switch (curChar) {
					case '(':
						brackets++;
						nextTokenIsStartOfStatement = false;
						break;

					case ')':
						brackets--;
						nextTokenIsStartOfStatement = false;

						// Ignore continuous '(' ')' tokens
						int resultSize = result.size();
						if (resultSize > 1
								&& result.get(resultSize - 2).toString()
										.equals("(")) {
							result.remove(--resultSize);
							result.remove(--resultSize);
						}

						break;

					case ';':
						if (brackets == 0) {
							result.get(result.size() - 1).setEndOfStatement(
									TokenSSID.EndOfStatementType.COUNTABLE);
							nextTokenIsStartOfStatement = true;

							while (!blockDeclared.empty()
									&& !blockDeclared.peek()) {
								addCloseBlockBracket(result);
								blocks--;
								try {
									blockDeclared.pop();
								} catch (Exception ex) {
									System.out.println("Student " + s.getID()
											+ ": " + ex.getMessage());
								}
							}
						}
						break;

					case '{':
						blocks++;
						preBlock = false;
						postBlock = false;
						blockDeclared.push(true);
						nextTokenIsStartOfStatement = true;
						break;

					case '}':
						blocks--;
						try {
							blockDeclared.pop();
						} catch (Exception ex) {
							System.out.println("Student " + s.getID() + ": "
									+ ex.getMessage());
						}
						while (!blockDeclared.empty() && !blockDeclared.peek()) {
							addCloseBlockBracket(result);
							blocks--;
							try {
								blockDeclared.pop();
							} catch (Exception ex) {
								System.out.println("Student " + s.getID()
										+ ": " + ex.getMessage());
							}
						}
						nextTokenIsStartOfStatement = true;
						break;
					default:
						if (!commentTypes[SINGLE_LINE_COMMENT]
								&& !commentTypes[MULTI_LINE_COMMENT]
								&& !Character.isWhitespace(curChar)) {
							nextTokenIsStartOfStatement = false;
						}
						break;
					}
				}
			}
			if (preprocessDirective) {
				result.get(result.size() - 1).setEndOfStatement(
						TokenSSID.EndOfStatementType.NON_COUNTABLE);
				nextTokenIsStartOfStatement = true;
			}

			gPos = lr.getGPos() + 1; // + 1 for the line breaker character
		}

		// String checkId = "U0605243";
		// if (s.getID().equals(checkId)) {
		// for (KGramChar k : result) {
		// System.out.println(k.getValue() + ":" + k.getType());
		// }
		// }

		s.setCodeTokens(result);
	}

	// private void digestSymbol(ArrayList<KGramChar> result, LineReader lr,
	// char curChar, boolean[] commentTypes, int line, boolean
	// thisIsStartOfStatement) {
	private void digestSymbol(TokenList result, LineReader lr, char curChar,
			boolean[] commentTypes, int line, boolean thisIsStartOfStatement) {
		int next, startLoc, endLoc;
		switch (curChar) {

		case '\'':
			startLoc = lr.getGPos() - 1;
			next = lr.peek();
			while (next != -1 && next != '\'') {
				next = lr.read();
			}
			if (lr.peek() == '\'') {
				lr.read();
			}

			endLoc = lr.getGPos() - 1;
			result.add(new ConstantToken(startLoc, endLoc, line,
					thisIsStartOfStatement, TokenSSID.EndOfStatementType.FALSE));
			break;

		case '"':
			startLoc = lr.getGPos() - 1;
			next = lr.peek();
			StringBuilder string = new StringBuilder();
			while (next != -1 && next != '"') {
				string.append((char) lr.read());
				next = lr.peek();
			}

			if (lr.peek() == '"') {
				string.append((char) lr.read());
			}

			endLoc = lr.getGPos() - 1;
			// result.add(new KGramChar(STRING, startLoc, endLoc, line,
			// thisIsStartOfStatement ? KGramChar.TokenType.START_OF_STATEMENT :
			// KGramChar.TokenType.UNDEFINED));
			result.add(new ConstantToken(startLoc, endLoc, line,
					thisIsStartOfStatement, TokenSSID.EndOfStatementType.FALSE));
			break;

		case '/':
			next = lr.peek();
			if (next == '*') {
				lr.read();
				commentTypes[MULTI_LINE_COMMENT] = true;
				break;
			} else if (next == '/') {
				lr.read();
				commentTypes[SINGLE_LINE_COMMENT] = true;
				break;
			}

		default:
			if (!Character.isWhitespace(curChar)) {
				int pos = lr.getGPos() - 1;
				// result.add(new KGramChar(curChar, pos, pos, line,
				// thisIsStartOfStatement ?
				// KGramChar.TokenType.START_OF_STATEMENT :
				// KGramChar.TokenType.UNDEFINED));
				result.add(new SymbolToken(Character.toString(curChar), pos,
						pos, line, thisIsStartOfStatement,
						TokenSSID.EndOfStatementType.FALSE));
				break;
			}
			break;
		}
	}

	// private void digestNum(ArrayList<KGramChar> result, LineReader lr, int
	// line, boolean thisIsStartOfStatement) {
	private void digestNum(TokenList result, LineReader lr, int line,
			boolean thisIsStartOfStatement) {
		int startLoc = lr.getGPos() - 1, next;

		next = lr.peek();

		while (next != -1 && (Character.isDigit(next) || next == '.')) {
			lr.read();
			next = lr.peek();
		}
		// result.add(new KGramChar(CONSTANT, startLoc, lr.getGPos() - 1, line,
		// thisIsStartOfStatement ? KGramChar.TokenType.START_OF_STATEMENT :
		// KGramChar.TokenType.UNDEFINED));
		result.add(new ConstantToken(startLoc, lr.getGPos() - 1, line,
				thisIsStartOfStatement, TokenSSID.EndOfStatementType.FALSE));
	}

	// private static String digestWord(ArrayList<KGramChar> result, LineReader
	// lr, char curChar, HashSet<String> keywords, int line, boolean
	// thisIsStartOfStatement) {
	private String digestWord(TokenList result, LineReader lr, char curChar,
			int line, boolean thisIsStartOfStatement) {

		int startLoc = lr.getGPos() - 1, next, endLoc;
		StringBuilder sb = new StringBuilder();
		sb.append(curChar);

		next = lr.peek();
		while (next != -1 && (Character.isLetterOrDigit(next) || next == '_')) {
			sb.append((char) lr.read());
			next = lr.peek();
		}

		String string = sb.toString();
		endLoc = lr.getGPos() - 1;
		// char filter;
		if (constantKeywords.contains(string)) {
			result.add(new ConstantToken(startLoc, endLoc, line,
					thisIsStartOfStatement, TokenSSID.EndOfStatementType.FALSE));
		} else if (!keywords.contains(string)) {
			result.add(new VariableToken(string, startLoc, endLoc, line,
					thisIsStartOfStatement, TokenSSID.EndOfStatementType.FALSE));
			// filter = VARIABLE;
		} else {
			result.add(new KeywordToken(string, startLoc, endLoc, line,
					thisIsStartOfStatement, TokenSSID.EndOfStatementType.FALSE));
			// filter = KEYWORD;
		}

		// result.add(new KGramChar(filter, startLoc, endLoc, line,
		// thisIsStartOfStatement ? KGramChar.TokenType.START_OF_STATEMENT :
		// KGramChar.TokenType.UNDEFINED));
		return string;
	}

	private void removeMultiLineComment(LineReader lr, char curChar,
			boolean[] commentTypes) {
		while (true) {
			if (lr.peek() == -1) {
				break;
			} else if (curChar == '*' && lr.peek() != -1 && lr.peek() == '/') {
				lr.read();
				commentTypes[MULTI_LINE_COMMENT] = false;
			} else {
				curChar = (char) lr.read();
			}
		}
	}

	private void addOpenBlockBracket(TokenList result) {
		TokenSSID lastToken = result.get(result.size() - 1);
		result.add(new SymbolToken("{", lastToken.getCodeStartIndex(),
				lastToken.getCodeEndIndex(), lastToken.getCodeLine(), false,
				TokenSSID.EndOfStatementType.FALSE));
	}

	private void addCloseBlockBracket(TokenList result) {
		TokenSSID lastToken = result.get(result.size() - 1);
		result.add(new SymbolToken("}", lastToken.getCodeStartIndex(),
				lastToken.getCodeEndIndex(), lastToken.getCodeLine(), false,
				TokenSSID.EndOfStatementType.FALSE));
	}
}
