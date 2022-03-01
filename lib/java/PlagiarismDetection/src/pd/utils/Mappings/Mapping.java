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

import java.util.List;

public class Mapping {

	private int startIndex1, endIndex1, startIndex2, endIndex2;
	private int startLine1, endLine1, startLine2, endLine2;
	private boolean isPlagMapping;

	private int mappedCountableStatement, mappedNonCountableStatement;

	private List<SkeletonMapping> skeletonMappings;

	public boolean isPlagMapping() {
		return isPlagMapping;
	}

	public int getStartIndex1() {
		return startIndex1;
	}

	public void setStartIndex1(int startIndex1) {
		this.startIndex1 = startIndex1;
	}

	public int getEndIndex1() {
		return endIndex1;
	}

	public void setEndIndex1(int endIndex1) {
		this.endIndex1 = endIndex1;
	}

	public int getStartIndex2() {
		return startIndex2;
	}

	public void setStartIndex2(int startIndex2) {
		this.startIndex2 = startIndex2;
	}

	public int getEndIndex2() {
		return endIndex2;
	}

	public void setEndIndex2(int endIndex2) {
		this.endIndex2 = endIndex2;
	}

	public int getStartLine1() {
		return startLine1;
	}

	public void setStartLine1(int startLine1) {
		this.startLine1 = startLine1;
	}

	public int getEndLine1() {
		return endLine1;
	}

	public void setEndLine1(int endLine1) {
		this.endLine1 = endLine1;
	}

	public int getStartLine2() {
		return startLine2;
	}

	public void setStartLine2(int startLine2) {
		this.startLine2 = startLine2;
	}

	public int getEndLine2() {
		return endLine2;
	}

	public void setEndLine2(int endLine2) {
		this.endLine2 = endLine2;
	}

	public int getMappedCountableStmtCount() {
		return mappedCountableStatement;
	}

	public void setMappedCountableStmtCount(int mappedCountableStatement) {
		this.mappedCountableStatement = mappedCountableStatement;
	}	

	public int getMappedNonCountableStmtCount() {
		return mappedNonCountableStatement;
	}

	public void setIsPlagMapping(boolean value) {
		isPlagMapping = value;
	}

	public List<SkeletonMapping> getSkeletonMappings() {
		return skeletonMappings;
	}

	public void setSkeletonMappings(List<SkeletonMapping> skeletonMappings) {
		this.skeletonMappings = skeletonMappings;
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

	@Override
	public String toString() {
		String mapping = "";
		mapping = mapping + String.format("Start idx 1: %d, end idx 1: %d || Start idx 2: %d, end idx 2: %d %n ", startIndex1, endIndex1, startIndex2, endIndex2);
		mapping = mapping + String.format("Start line 1: %d, End line 1: %d || Start line 2: %d, end line 2: %d %n ", startLine1, endLine1, startLine2, endLine2);
		mapping = mapping + String.format("Mapped countable stmt: %d %n", mappedCountableStatement);
		mapping = mapping + String.format("Mapped NON-countable stmt: %d %n", mappedNonCountableStatement);
		mapping = mapping + String.format("isPlagMapping: %s %n", isPlagMapping);
		return mapping;
	}

	
}
