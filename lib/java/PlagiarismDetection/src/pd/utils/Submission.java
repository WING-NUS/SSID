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
 
package pd.utils;

import pd.utils.NGrams.*;
import java.util.*;
import pd.utils.Tokens.*;

public final class Submission {

	private String id = "";
  private String path = null;
	private ArrayList<String> combinedCode = new ArrayList<String>();
	private int codeLength = 0;
	private TokenList codeTokens = new TokenList();
	private NGramList nGramList = new NGramList();
	private NGramList nGramsStartingStmtsList = new NGramList();
	private HashMap<NGram, ArrayList<Integer>> nGramIndexingTable = new HashMap<NGram, ArrayList<Integer>>();
	private boolean isSkeletonCode = false;

	private ArrayList<FingerPrint> submissionFingerPrints = new ArrayList<FingerPrint>();
	private ArrayList<String> possibleRelatedDocuments = new ArrayList<String>();

	public Submission() {
	}

	public Submission(String id, String path, ArrayList<String> combinedCode, int codeLength) {
    this(id, combinedCode, codeLength);
    this.path = path;
  }

	public Submission(String id, ArrayList<String> combinedCode, int codeLength) {
		this.id = id;
		this.combinedCode = combinedCode;
		this.codeLength = codeLength;
	}

	public void setCodeTokens(TokenList tokens) {
		codeTokens = tokens;
	}

	public TokenList getCodeTokens() {
		return codeTokens;
	}

	public boolean isSkeletonCode() {
		return isSkeletonCode;
	}

	public void setIsSkeletonCode(boolean value) {
		isSkeletonCode = value;
	}

	public String getID() {
		return id;
	}
  
  public String getPath() {
    return path;
  }

	public ArrayList<String> getCombinedCode() {
		return combinedCode;
	}

	public int getCodeLength() {
		return codeLength;
	}

	public int getCodeTotalLine() {
		return combinedCode.size();
	}

	public NGramList getNGramList() {
		return this.nGramList;
	}

	public NGramList getNGramsStartingStmtsList() {
		return this.nGramsStartingStmtsList;
	}

	public void setNGramList(NGramList list) {
		this.nGramList = list;

		nGramIndexingTable = new HashMap<NGram, ArrayList<Integer>>();

		ArrayList<Integer> indices;

		int i = 0;
		for (NGram n : list) {
			if (n.isFirstTokenStartOfStmt()) {
				if (nGramIndexingTable.containsKey(n)) {
					indices = nGramIndexingTable.get(n);
				} else {
					indices = new ArrayList<Integer>();
					nGramIndexingTable.put(n, indices);
				}
				indices.add(i);
				nGramsStartingStmtsList.add(n);
			}
			i++;
		}
	}

	public int getTokenIndexOfLoc(int loc) {
		for (int i=0; i< codeTokens.size(); i++) {
			if (this.codeTokens.get(i).getCodeStartIndex() == loc) {
				return i;
			}
		}
		return -1;
	}

	public HashMap<NGram, ArrayList<Integer>> getNGramIndexingTable() {
		return this.nGramIndexingTable;
	}

	@Override
	public String toString() {
		return id;
	}

	public ArrayList<String> getPossibleRelatedDocuments() {
		return possibleRelatedDocuments;
	}

	public void setPossibleRelatedDocuments(ArrayList<String> possibleRelatedDocuments) {
		this.possibleRelatedDocuments = possibleRelatedDocuments;
	}

	public ArrayList<FingerPrint> getSubmissionFingerPrints() {
		return submissionFingerPrints;
	}

	public void setSubmissionFingerPrints(ArrayList<FingerPrint> submissionFingerPrints) {
		this.submissionFingerPrints = submissionFingerPrints;
	}	
	
}
