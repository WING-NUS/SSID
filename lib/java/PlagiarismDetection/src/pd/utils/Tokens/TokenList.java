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

import java.util.*;

public class TokenList extends ArrayList<TokenSSID> {

	private static final long serialVersionUID = 1791998687760639392L;
	private boolean[] markedTokens = null;
	private ArrayList<Integer> startOfStmtTokenIndices = new ArrayList<Integer>();
	private int markedTokenCount = 0;

	public void markRange(int start, int end) {
		if (start >= size()) {
			return;
		}

		if (size() <= end) {
			end = size() - 1;
		}

		if (markedTokens == null) {
			markedTokens = new boolean[size()];
		}

		for (int i = start; i <= end; i++) {
			if (!markedTokens[i]) {
				markedTokens[i] = true;
				markedTokenCount++;
			}
		}
	}

	public void baseMarkRange(int start, int end) {

		if (start >= size()) {
			return;
		}

		if (size() <= end) {
			end = size() - 1;
		}

		if (markedTokens == null) {
			markedTokens = new boolean[size()];
		}

		for (int i = start; i <= end; i++) {
			markedTokens[i] = true;
		}
	}

	public ArrayList<Integer> getStartOfStmtTokenIndices() {
		return startOfStmtTokenIndices;
	}

	@Override
	public boolean add(TokenSSID t) {

		if (t.isStartOfStatement()) {
			startOfStmtTokenIndices.add(size());
		}

		return super.add(t);
	}

	public int getMarkCount() {
		return markedTokenCount;
	}

	public boolean isTokenMarked(int index) {
		if (markedTokens == null) {
			return false;
		}
		return index < markedTokens.length ? markedTokens[index] : false;
	}

	public void unmarkAll() {
		markedTokens = null;
		markedTokenCount = 0;
	}
}
