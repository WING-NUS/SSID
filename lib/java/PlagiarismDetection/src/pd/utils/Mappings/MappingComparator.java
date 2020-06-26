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

import java.util.*;

public class MappingComparator implements Comparator<Mapping> {

	private static MappingComparator instance = new MappingComparator();

	private MappingComparator() {

	}

	public static MappingComparator getInstance() {
		return instance;
	}

	/**
	 * Compare two mappings. Comparison is done by giving the priority to the
	 * number of statements matched then to the number of tokens matched.
	 * 
	 * @param m1
	 *            Mapping 1
	 * @param m2
	 *            Mapping 2
	 * @return If both have the same number of statements and tokens matched,
	 *         return 0. If not, return 1 if m1 has less number of statements
	 *         than m2, -1 if not. If both have the same number of statements,
	 *         return 1 if m1 has less token matched, -1 if not.
	 */
	@Override
	public int compare(Mapping m1, Mapping m2) {

		int s1Count = m1.getMappedCountableStmtCount();
		int s2Count = m2.getMappedCountableStmtCount();

		if (s1Count < s2Count) {
			return 1;
		} else if (s1Count > s2Count) {
			return -1;
		}

		s1Count = m1.getEndIndex1() - m1.getStartIndex1();
		s2Count = m2.getEndIndex1() - m2.getStartIndex1();

		if (s1Count < s2Count) {
			return 1;
		} else if (s1Count > s2Count) {
			return -1;
		}

		return 0;
	}
}
