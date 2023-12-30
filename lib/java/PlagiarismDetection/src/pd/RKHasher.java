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

package pd;


import java.util.ArrayList;
import java.util.List;
import pd.utils.NGrams.NGramList;

// This class allows pre-computing and querying of hash values of the windows [i..i + windowSize - 1] for all i within 
// bound for a given NGramList, using a modified version of Rabin-Karp algorithm as described in 
// https://brilliant.org/wiki/rabin-karp-algorithm/.
public class RKHasher {
	private int windowSize; 
	private List<Integer> precomputedHashes;
	private int base = 100007;

	 /**
     * Constructor.
     *
     * @param windowSize size of window
     */
	public RKHasher(int windowSize, NGramList ngList) {
		this.windowSize = windowSize; 
		precomputeHashesForNGramList(ngList);
	}

	/**
	 * 
	 * Calculates hash values of the windows ngList[i..i + windowSize - 1] for all i within bound.
	 * 
	 */
	public void precomputeHashesForNGramList(NGramList ngList) {
		if (ngList.size() == 0) return;

		precomputedHashes = new ArrayList<Integer>();

		int currentHash = 0;
		int windowStart = 0;
		int windowEnd = windowSize - 1;

		// Computes first hash value for ngList[0,..,windowSize - 1]
		for (int i = windowStart; i <= windowEnd; i++) {
			int ngHashValue = ngList.get(i).nGramHash().intValue() % base;
			currentHash += ngHashValue * Math.pow(base, windowSize - i);
		}
		precomputedHashes.add(currentHash);

		// Moves window forward and calculate the rest of the desired hash values
		for (windowStart = 1, windowEnd = windowSize; windowEnd < ngList.size(); windowStart++, windowEnd++) {
			int toRemove = ngList.get(windowStart - 1).nGramHash().intValue() % base;
			int toAdd = ngList.get(windowEnd).nGramHash().intValue() % base;

			currentHash -= toRemove;
			currentHash *= base;
			currentHash += toAdd*Math.pow(base, windowSize);
			precomputedHashes.add(currentHash);
		}
	}
	
	// Returns hash value of window starting from ngIndex.
	public int getHashStartingFrom(int ngIndex) {
		return precomputedHashes.get(ngIndex);
	}
}