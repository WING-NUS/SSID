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
 
package pd.utils.Mappings;

public class Mapping {

	private int startIndex1, endIndex1, startIndex2, endIndex2;
	private int startLine1, endLine1, startLine2, endLine2;
	private boolean isPlagMapping;

	private int mappedCountableStatement, mappedNonCountableStatement;

	public boolean isPlagMapping() {
		return isPlagMapping;
	}

	public int getStartIndex1() {
		return startIndex1;
	}

	public int getEndIndex1() {
		return endIndex1;
	}

	public int getStartIndex2() {
		return startIndex2;
	}

	public int getEndIndex2() {
		return endIndex2;
	}

	public int getStartLine1() {
		return startLine1;
	}

	public int getEndLine1() {
		return endLine1;
	}

	public int getStartLine2() {
		return startLine2;
	}

	public int getEndLine2() {
		return endLine2;
	}

	public int getMappedCountableStmtCount() {
		return mappedCountableStatement;
	}

	public int getMappedNonCountableStmtCount() {
		return mappedNonCountableStatement;
	}

	public void setIsPlagMapping(boolean value) {
		isPlagMapping = value;
	}

	public Mapping(int startIndex1, int endIndex1, int startIndex2,
			int endIndex2, int startLine1, int endLine1, int startLine2,
			int endLine2, int mappedCountableStatement,
			int mappedNonCountableStatement) {
		this(startIndex1, endIndex1, startIndex2, endIndex2, startLine1,
				endLine1, startLine2, endLine2, mappedCountableStatement,
				mappedNonCountableStatement, true);
	}

	public Mapping(int startIndex1, int endIndex1, int startIndex2,
			int endIndex2, int startLine1, int endLine1, int startLine2,
			int endLine2, int mappedStmtCount, int mappedNonCountableStatement,
			boolean isPlagMapping) {
		this.startIndex1 = startIndex1;
		this.endIndex1 = endIndex1;
		this.startIndex2 = startIndex2;
		this.endIndex2 = endIndex2;
		this.startLine1 = startLine1;
		this.endLine1 = endLine1;
		this.startLine2 = startLine2;
		this.endLine2 = endLine2;
		this.mappedCountableStatement = mappedStmtCount;
		this.mappedNonCountableStatement = mappedNonCountableStatement;
		this.isPlagMapping = isPlagMapping;
	}
}
