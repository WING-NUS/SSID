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

import pd.utils.Submission;
import java.util.*;
import pd.utils.NGrams.*;
import pd.utils.Tokens.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;	
public final class NGramizer {

	private static NGramizer instance = new NGramizer();
	private static Logger logger = LogManager.getLogger();

	private NGramizer() {

	}

	public static NGramizer getNGramizer() {
		return instance;
	}

	public void constructSubmissionsNGrams(ArrayList<Submission> submissions,
			int nGramSize) {
		NGram.setNGramSize(nGramSize);
		for (Submission s : submissions) {
			constructNGrams(s, nGramSize);
		}
	}

	private void constructNGrams(Submission s, int nGramSize) {
		// ArrayList<KGramChar> norCode = s.getNormalizedCode();
		TokenList tokens = s.getCodeTokens();
		// logger.debug("Submission: {}, token list: {} ", s.getID(), tokens.toString());
		int tokenSize = tokens.size();
		NGramList nGramList;

		if (nGramSize <= tokenSize) {
			NGram[] tmpList = new NGram[nGramSize];
			nGramList = new NGramList(tokenSize - nGramSize + 1);

			int[] offset_list = new int[nGramSize];

			for (int i = 0; i < nGramSize; i++) {
				tmpList[i] = new NGram();
				offset_list[i] = 0 - i;
			}
			// int hashCode = 0;
			TokenSSID t;
			NGram nGram;

			// int b = TokenSSID.getRegCount();
			// int bk = ((int) Math.pow(b, nGramSize) % Integer.MAX_VALUE);
			// int cbk = 0;
			// Queue<Integer> cs = new LinkedList<Integer>();
			for (int index = 0; index < tokenSize; index++) {
				t = tokens.get(index);

				// cs.add(t.hashCode());

				// if (index >= nGramSize) {
				// cbk = cs.poll() * bk;
				// }

				// hashCode = (hashCode - cbk + t.hashCode()) * b;

				for (int nGramCount = 0; nGramCount < nGramSize; nGramCount++) {
					nGram = tmpList[nGramCount];
					if (offset_list[nGramCount] >= 0) {
						nGram.append(index, t);
						if (nGram.getCurrentTokenCount() == nGramSize) {
							nGramList.add(nGram);
							// nGram.setHashCode(hashCode);
							tmpList[nGramCount] = new NGram();
							offset_list[nGramCount] = -1;
						}
					}
					offset_list[nGramCount]++;
				}
			}
		} else {
			nGramList = new NGramList();
		}

		// String checkId = "u0800046";
		// if (s.getID().equals(checkId)) {
		// for (KGramString ks : kGramList) {
		// System.out.println(ks.toString() + ": Start?" +
		// ks.isStartOfStatement() + " End?" + ks.isEndOfStatement());
		// }
		// }

		logger.debug("Constructing list of n-grams for submission: {} ", s.getID());
		String nGrams = "";
		// for(int i = 0; i < nGramList.size(); i++) {
		// 	nGrams += nGramList.get(i).getTokenList().toString() + " -- ";
		// }
		// logger.debug("n-grams: {} ", nGrams);
		
		for (int i = 0; i < nGramList.size(); i++) {
			logger.debug("index: {}, ngram: {}, line nbr: {}", i, nGramList.get(i).getTokenList().toString(), nGramList.get(i).getCodeStartLine());
		}
		s.setNGramList(nGramList);
	}
}
