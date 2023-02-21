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
 
package pd.utils.Tokens;

import java.util.HashMap;

public abstract class TokenSSID {

	/**
	 * With effect from year 2011, we have 3 types of end of statement FALSE
	 * defines this TokenSSID is NOT the end of a statement COUNTABLE defines this
	 * TokenSSID is the end of a countable statement (example: statement in method
	 * body) NON_COUNTABLE defines this TokenSSID is the end of a statement but
	 * should not consider for plagiarism (example: statement in preprocess
	 * directives)
	 */
	public enum EndOfStatementType {
		FALSE, COUNTABLE, NON_COUNTABLE
	}

	// StartLoc and EndLoc define the location of the value this TokenSSID
	// represents in the submission
	private int startLoc, endLoc;
	// Line of the value this TokenSSID represents in the submission
	private int line;
	// Defines if this TokenSSID is the beginning of a statement
	private boolean startOfStatement;
	// Define if this TokenSSID is the terminal of a statement
	private EndOfStatementType endOfStatement = EndOfStatementType.FALSE;

	// Define the register of each different TokenSSID type (note: may or may not be
	// the same as child classes), use for indexing
	protected static int classReg = 2; // Constant is 0, Variable is 1
	protected static HashMap<String, Integer> registers = new HashMap<String, Integer>();

	// Represents the registered id of this TokenSSID, use for indexing. Registered
	// id may not be unique, this is to be decided by the programmer.
	protected int reg;
	private static final int BIT_SIZE = 2;
	private static int bitRequired, bitRequiredCheckpoint = -1;

	/***
	 * Constructor
	 * 
	 * @param startLoc
	 *            The starting location of the value represented by this TokenSSID
	 *            in the submission
	 * @param endLoc
	 *            The ending location of the value represented by this TokenSSID in
	 *            the submission
	 * @param line
	 *            The line of the value represented by this TokenSSID in the
	 *            submission
	 * @param startOfStatement
	 *            Define if this TokenSSID is the beginning of a statement
	 * @param endOfStatement
	 *            Define if this TokenSSID is the terminal of a statement
	 */
	public TokenSSID(int startLoc, int endLoc, int line, boolean startOfStatement,
			EndOfStatementType endOfStatement) {
		this.startLoc = startLoc;
		this.endLoc = endLoc;
		this.line = line;
		this.startOfStatement = startOfStatement;
		this.endOfStatement = endOfStatement;
	}

	/***
	 * Get the number of registered id
	 * 
	 * @return The number of registered id
	 */
	public static int getRegCount() {
		return classReg;
	}

	/***
	 * Get the number of bits required to represent the number of registered id
	 * 
	 * @return The number of bits required to represent the number of registered
	 *         id
	 */
	public static int getBitRequired() {
		if (bitRequiredCheckpoint != classReg) {
			bitRequiredCheckpoint = classReg;
			bitRequired = (int) Math.ceil(Math.log(classReg)
					/ Math.log(BIT_SIZE));
		}
		return bitRequired;
	}

	/***
	 * Return the register id for a given string value. Identical strings will
	 * return the same register id
	 * 
	 * @param strValue
	 *            The string value
	 * @return The register id
	 */
	protected int getReg(String strValue) {
		if (registers.containsKey(strValue)) {
			return registers.get(strValue);
		}
		registers.put(strValue, classReg);
		return classReg++;
	}

	/***
	 * Get the starting location of this TokenSSID in the submission
	 * 
	 * @return The starting location of this TokenSSID in the submission
	 */
	public int getCodeStartIndex() {
		return startLoc;
	}

	/***
	 * Set the starting location (index) of this TokenSSID in the submission
	 * 
	 * @param start
	 *            The starting location (index) in the submission
	 */
	public void setCodeStartIndex(int start) {
		startLoc = start;
	}

	/***
	 * Get the line of this TokenSSID in the submission
	 * 
	 * @return The line of this TokenSSID in the submission
	 */
	public int getCodeLine() {
		return line;
	}

	/***
	 * Set the line of this TokenSSID in the submission
	 * 
	 * @param line
	 *            The line of this TokenSSID in the submission
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/***
	 * Get the ending location of this TokenSSID in the submission
	 * 
	 * @return The ending location of this TokenSSID in the submission
	 */
	public int getCodeEndIndex() {
		return endLoc;
	}

	/***
	 * Set the ending location of this TokenSSID in the submission
	 * 
	 * @param end
	 */
	public void setCodeEndIndex(int end) {
		endLoc = end;
	}

	/***
	 * Determine if this TokenSSID is the beginning of a statement
	 * 
	 * @return True if this TokenSSID is the beginning of a statement, else False
	 */
	public boolean isStartOfStatement() {
		return startOfStatement;
	}

	/***
	 * Determine if this TokenSSID is the terminal of a statement
	 * 
	 * @return True if this TokenSSID is the terminal of a statement, else False
	 */
	public EndOfStatementType isEndOfStatement() {
		return endOfStatement;
	}

	/***
	 * Set if this TokenSSID is the beginning of a statement
	 * 
	 * @param value
	 *            True if this TokenSSID is the beginning of a statement, else False
	 */
	public void setStartOfStatement(boolean value) {
		startOfStatement = value;
	}

	/***
	 * Set if this TokenSSID is the terminal of a statement
	 * 
	 * @param value
	 *            True if this TokenSSID is the beginning of a statement, else False
	 */
	public void setEndOfStatement(EndOfStatementType value) {
		endOfStatement = value;
	}

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public int hashCode() {
		return reg;
	}

	@Override
	public abstract String toString();

	public abstract String getValue();
}
