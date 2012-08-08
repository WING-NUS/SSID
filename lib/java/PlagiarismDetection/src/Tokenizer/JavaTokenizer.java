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

public final class JavaTokenizer extends Tokenizer {

	private static JavaTokenizer instance = new JavaTokenizer();
	public static final String language = "java";

	private JavaTokenizer() {
		insertKeywords();
	}

	public static Tokenizer getTokenizer() {
		return instance;
	}

	public void TokenizeSubmissions(ArrayList<Submission> submissions) {
		for (Submission s : submissions) {
			tokenize(s);
		}
	}

	private void insertKeywords() {
		String[] keys = { "abstract", "continue", "for", "new", "switch",
				"assert", "default", "goto", "package", "synchronized",
				"boolean", "do", "if", "private", "this", "break", "double",
				"implements", "protected", "throw", "byte", "else", "import",
				"public", "throws", "case", "enum", "instanceof", "return",
				"transient", "catch", "extends", "int", "short", "try", "char",
				"final", "interface", "static", "void", "class", "finally",
				"long", "strictfp", "volatile", "const", "float", "native",
				"super", "while" };
		keywords.addAll(Arrays.asList(keys));

		String[] variableKeys = { "double", "byte", "int", "short", "char",
				"long", "float", "boolean" };
		variableKeywords.addAll(Arrays.asList(variableKeys));

		String[] ignorableKeys = { "public", "private", "protected", "final",
				"const", "static" };
		ignorableKeywords.addAll(Arrays.asList(ignorableKeys));

		String[] preprocessDirectiveKeys = { "import", "package" };
		preprocessDirectiveKeywords = new HashSet<String>();
		preprocessDirectiveKeywords.addAll(Arrays
				.asList(preprocessDirectiveKeys));

		String[] constantKeys = { "true", "false" };
		constantKeywords = new HashSet<String>();
		constantKeywords.addAll(Arrays.asList(constantKeys));
	}

	private void tokenize(Submission s) {

		TokenList result = new TokenList();

		ArrayList<String> lines = s.getCombinedCode();
		int linesNo = lines.size();

		boolean[] commentTypes = { false, false };

		int gPos = 0;
		LineReader lr; // Line Reader
		String line;

		int brackets = 0;

		// ignorableToken, record prev token is ignorable
		boolean nextTokenIsStartOfStatement = true, ignorePrevToken = false;
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

			boolean preprocessDirective;
			preprocessDirective = false;

			while (lr.peek() != -1) {
				curChar = (char) lr.read();
				if (commentTypes[SINGLE_LINE_COMMENT]) {
					lr.moveEnd();
				} else if (commentTypes[MULTI_LINE_COMMENT]) {
					removeMultiLineComment(lr, curChar, commentTypes);
				} else if (Character.isJavaIdentifierStart(curChar)) {

					if (preBlock && brackets == 0) {
						preBlock = false;
						addOpenBlockBracket(result);
						blockDeclared.push(false);
						nextTokenIsStartOfStatement = true;
					} else if (postBlock) {
						postBlock = false;
						addOpenBlockBracket(result);
						blockDeclared.push(false);
						nextTokenIsStartOfStatement = true;
					}

					String word = digestWord(result, lr, curChar, i,
							nextTokenIsStartOfStatement);

					if (preprocessDirectiveKeywords.contains(word)) {
						preprocessDirective = true;
					}
					nextTokenIsStartOfStatement = false;

					if (ignorePrevToken) {
						Token last = result.get(result.size() - 1);
						Token prev = result.get(result.size() - 2);

						result.remove(result.size() - 2);
						last.setStartOfStatement(prev.isStartOfStatement());
						last.setLine(prev.getCodeLine());
						last.setCodeStartIndex(prev.getCodeStartIndex());

						ignorePrevToken = false;
					}

					Token lastToken = result.get(result.size() - 1), typeToken, curToken;
					if (lastToken instanceof VariableToken) {
						int arrayOpened = 0, specOpened = 0;
						boolean safe = true;
						int index = result.size() - 2;
						String tokenString;
						for (; index >= 0 && safe; index--) {
							curToken = result.get(index);
							tokenString = curToken.toString();
							if (arrayOpened > 0) {
								if (curToken instanceof SymbolToken
										&& tokenString.equals("[")) {
									arrayOpened--;
								} else {
									safe = false;
								}
							} else if (specOpened > 0) {

								if (curToken instanceof SymbolToken) {
									if (tokenString.equals("<")) {
										specOpened--;
									} else if (tokenString.equals("]")) {
										arrayOpened++;
									} else if (tokenString.equals(">")) {
										specOpened++;
									}
								} else if (!(curToken instanceof VariableToken)) {
									safe = false;
								}

							} else {
								// Array
								if (curToken instanceof SymbolToken) {
									if (tokenString.equals("]")) {
										arrayOpened++;
									} else if (tokenString.equals(">")) {
										specOpened++;
									} else {
										safe = false;
									}
								} else if (curToken instanceof VariableToken) {
									break;
								} else if (curToken instanceof KeywordToken
										&& variableKeywords.contains(curToken
												.toString())) {
									break;
								} else {
									safe = false;
								}
							}
						} // end for (; index >= 0 && safe; index--)

						if (arrayOpened == 0
								&& specOpened == 0
								&& index >= 0
								&& safe
								&& ((typeToken = result.get(index)) instanceof VariableToken || (typeToken instanceof KeywordToken && variableKeywords
										.contains(typeToken.toString())))) {
							lastToken.setStartOfStatement(typeToken
									.isStartOfStatement());
							lastToken.setCodeStartIndex(typeToken
									.getCodeStartIndex());
							lastToken.setLine(typeToken.getCodeLine());

							// while (index < result.size() - 1) {
							// result.remove(index);
							// }
						}
					}

					if (word.equals("for") || word.equals("while")
							|| word.equals("if") || word.equals("else")) {
						preBlock = true;
					} else if (word.equals("do")) {
						postBlock = true;
					} else if (ignorableKeywords.contains(word)) {
						ignorePrevToken = true;
					}

				} else if (Character.isDigit(curChar)) {

					if (preBlock && brackets == 0) {
						preBlock = false;
						addOpenBlockBracket(result);
						blockDeclared.push(false);
						nextTokenIsStartOfStatement = true;
					} else if (postBlock) {
						postBlock = false;
						addOpenBlockBracket(result);
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
									Token.EndOfStatementType.NON_COUNTABLE);
							nextTokenIsStartOfStatement = true;
							if (preprocessDirective) {
								preprocessDirective = false;
							} else {
								result.get(result.size() - 1)
										.setEndOfStatement(
												Token.EndOfStatementType.COUNTABLE);
							}

							while (!blockDeclared.empty()
									&& !blockDeclared.peek()) {
								addCloseBlockBracket(result);
								blockDeclared.pop();
							}
						}
						break;

					case '{':
						preBlock = false;
						postBlock = false;
						blockDeclared.push(true);
						nextTokenIsStartOfStatement = true;
						break;

					case '}':
						if (!blockDeclared.isEmpty()) {
							blockDeclared.pop();
						}
						while (!blockDeclared.empty() && !blockDeclared.peek()) {
							addCloseBlockBracket(result);
							blockDeclared.pop();
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
				nextTokenIsStartOfStatement = true;
			}

			gPos = lr.getGPos() + 1; // + 1 for the line breaker character
		}

		s.setCodeTokens(result);
	}

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
					thisIsStartOfStatement, Token.EndOfStatementType.FALSE));
			break;

		case '"':
			startLoc = lr.getGPos() - 1;
			next = lr.peek();
			while (next != -1 && next != '"') {
				next = lr.read();
			}

			if (lr.peek() == '"') {
				lr.read();
			}

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
				result.add(new SymbolToken(Character.toString(curChar), pos,
						pos, line, thisIsStartOfStatement,
						Token.EndOfStatementType.FALSE));
				break;
			}
			break;
		}
	}

	private void digestNum(TokenList result, LineReader lr, int line,
			boolean thisIsStartOfStatement) {
		int startLoc = lr.getGPos() - 1, next;

		next = lr.peek();

		while (next != -1 && (Character.isDigit(next) || next == '.')) {
			lr.read();
			next = lr.peek();
		}
		result.add(new ConstantToken(startLoc, lr.getGPos() - 1, line,
				thisIsStartOfStatement ? true : false,
				Token.EndOfStatementType.FALSE));
	}

	private String digestWord(TokenList result, LineReader lr, char curChar,
			int line, boolean thisIsStartOfStatement) {

		int startLoc = lr.getGPos() - 1, next, endLoc;
		StringBuilder sb = new StringBuilder();
		sb.append(curChar);

		next = lr.peek();
		while (next != -1 && Character.isJavaIdentifierPart(next)) {
			sb.append((char) lr.read());
			next = lr.peek();
		}

		String string = sb.toString();
		endLoc = lr.getGPos() - 1;
		if (constantKeywords.contains(string)) {
			result.add(new ConstantToken(startLoc, endLoc, line,
					thisIsStartOfStatement, Token.EndOfStatementType.FALSE));
		} else if (!keywords.contains(string)) {
			result.add(new VariableToken(string, startLoc, endLoc, line,
					thisIsStartOfStatement, Token.EndOfStatementType.FALSE));
		} else {
			result.add(new KeywordToken(string, startLoc, endLoc, line,
					thisIsStartOfStatement, Token.EndOfStatementType.FALSE));
		}

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
		Token lastToken = result.get(result.size() - 1);
		result.add(new SymbolToken("{", lastToken.getCodeStartIndex(),
				lastToken.getCodeEndIndex(), lastToken.getCodeLine(), false,
				Token.EndOfStatementType.FALSE));
	}

	private void addCloseBlockBracket(TokenList result) {
		Token lastToken = result.get(result.size() - 1);
		result.add(new SymbolToken("}", lastToken.getCodeStartIndex(),
				lastToken.getCodeEndIndex(), lastToken.getCodeLine(), false,
				Token.EndOfStatementType.FALSE));
	}
}
