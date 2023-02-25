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

import pd.utils.Mappings.*;
import pd.utils.NGrams.*;
import java.util.*;
import pd.utils.*;
import pd.utils.Tokens.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public final class SimComparer {

	private static SimComparer instance = new SimComparer();
	private static final String SKELETON = "skeleton";
	private static Logger logger = LogManager.getLogger();

	@SuppressWarnings("unused")
	private boolean debugMode = false;

	public static SimComparer getComparer() {
		return instance;
	}

	public ArrayList<Result> compareSubmissions(
			ArrayList<Submission> submissions, int nGramSize, int minMatch) {

		Submission skeleton = getSkeletonCode(submissions);
    	assert(skeleton != null);
		ArrayList<Result> results = new ArrayList<Result>();

		int noOfSub = submissions.size();
		Submission s1, s2;
		TokenList s1Tokens, s2Tokens, bTokens = skeleton.getCodeTokens();
		Result result;

		for (int i = 0; i < noOfSub; i++) {
			s1 = submissions.get(i);
			if (s1.isSkeletonCode()) {
				continue;
			}
			for (int j = i + 1; j < noOfSub; j++) {
				s2 = submissions.get(j);
				if (s2.isSkeletonCode()) {
					continue;
				}

				logger.info("Start comparing submissions: {} vs {}", s1.getID(), s2.getID());
				s1Tokens = s1.getCodeTokens();
				s2Tokens = s2.getCodeTokens();
				if (s1Tokens.size() < s2Tokens.size()) {
					result = compareSubmissions(s1, s2, skeleton, nGramSize,
							minMatch);
					computeSims(s1Tokens, s2Tokens, result);
				} else {
					result = compareSubmissions(s2, s1, skeleton, nGramSize,
							minMatch);
					computeSims(s2Tokens, s1Tokens, result);
				}

				results.add(result);

				unmarkTokens(s1Tokens, s2Tokens, bTokens);

			}
		}

		return results;
	}

	private void unmarkTokens(TokenList s1Tokens, TokenList s2Tokens,
			TokenList bTokens) {
		s1Tokens.unmarkAll();
		s2Tokens.unmarkAll();
		bTokens.unmarkAll();
	}

	private void computeSims(TokenList s1Tokens, TokenList s2Tokens,
			Result result) {
		logger.debug("S1: {} {} {}, S2: {} {} {}", s1Tokens.size(), s1Tokens.getMarkCount(), s1Tokens.getBaseCount(), s2Tokens.size(), s2Tokens.getMarkCount(), s2Tokens.getBaseCount());	

		result.setSim2To1((float) s2Tokens.getMarkCount() / s2Tokens.size());
		result.setSim1To2((float) s1Tokens.getMarkCount() / s1Tokens.size());

	}

	private Submission getSkeletonCode(ArrayList<Submission> submissions) {
		Submission reply = null;
		for (Submission s : submissions) {
			if (s.getID().equals(SKELETON)) {
				reply = s;
				s.setIsSkeletonCode(true);
			}
		}

		if (reply == null) {
			reply = new Submission();
			reply.setIsSkeletonCode(true);
		}

		return reply;
	}

	NGramList s1NGrams;
	NGramList s2NGrams;
	NGramList skeletonNGrams;
	private Result compareSubmissions(Submission s1, Submission s2,
			Submission skeleton, int nGramSize, int minMatch) {

		s1NGrams = s1.getNGramList();
		s2NGrams = s2.getNGramList();

		skeletonNGrams = skeleton.getNGramList();

		if (s1NGrams.size() > 0 && s2NGrams.size() > 0) {
			Result result = new Result(s1, s2);

			gst(s1NGrams, s2NGrams, skeletonNGrams, s1.getCodeTokens(), 
					s2.getCodeTokens(),
					skeleton.getCodeTokens(),
					minMatch,
					result.getTokenIndexMappings());

			getCodeMapping(s1.getCodeTokens(), s2.getCodeTokens(), result);

			return result;
		}

		// No k-gram or no match at all
		return new Result(s1, s2);

	}

	private void getCodeMapping(TokenList s1Tokens, TokenList s2Tokens,
			Result result) {
		ArrayList<Mapping> codeMappings = result.getCodeIndexMappings();

		ArrayList<Mapping> tokenMappings = result.getTokenIndexMappings();

		TokenSSID s1StartToken, s2StartToken, s1EndToken, s2EndToken;
		for (Mapping m : tokenMappings) {
			s1StartToken = s1Tokens.get(m.getStartIndex1());
			s1EndToken = s1Tokens.get(m.getEndIndex1());
			s2StartToken = s2Tokens.get(m.getStartIndex2());
			s2EndToken = s2Tokens.get(m.getEndIndex2());

			Mapping mapping = new Mapping(s1StartToken.getCodeStartIndex(),
			s1EndToken.getCodeEndIndex(), s2StartToken
					.getCodeStartIndex(), s2EndToken.getCodeEndIndex(),
			s1StartToken.getCodeLine(), s1EndToken.getCodeLine(),
			s2StartToken.getCodeLine(), s2EndToken.getCodeLine(), m
					.getMappedCountableStmtCount(), m
					.getMappedNonCountableStmtCount(), m
					.isPlagMapping());
					
			mapping.setSkeletonMappings(m.getSkeletonMappings());

			codeMappings.add(mapping);
		}

		Collections.sort(codeMappings, MappingComparator.getInstance());
	}

	/***
	 * Return the TokenSSID mappings using GST
	 *
	 * @param s1NGrams
	 * @param s2NGramIndices
	 * @param s1Tokens
	 * @param s2Tokens
	 * @param minMatch
	 * @return
	 */
	private void gst(NGramList s1NGrams, NGramList s2NGrams, NGramList skeletonNGrams,
			TokenList s1Tokens, TokenList s2Tokens, TokenList bTokens,
			int minMatch, ArrayList<Mapping> tokenMappings) {
		int nGramSize = s1NGrams.size() > 0 ? NGram.getNGramSize() : 0;

		ArrayList<Mapping> mappings;

		int[] maxMatch = new int[1];

		do {
			maxMatch[0] = minMatch;
			mappings = new ArrayList<Mapping>();
			mappings = gstPhase1(s1Tokens, s1NGrams, null, s2Tokens,
					maxMatch, mappings);
			gstPhase2(mappings, nGramSize, s1Tokens, s1NGrams, s2Tokens, s2NGrams,
					bTokens, skeletonNGrams, minMatch, tokenMappings);

		} while (maxMatch[0] > minMatch);
	}
	
    private NGramList l1 = new NGramList(); // List of NGrams in s1 that are start of statements
	private NGramList l2 = new NGramList(); // List of NGrams in s2 that are start of statements
	private ArrayList<Boolean> l1_marks = new ArrayList<>(); // Keeps track of markings for list l1
	private ArrayList<Boolean> l2_marks = new ArrayList<>(); // Keeps track of markings for list l2

	// Iterates over l and check if all Ngrams between start and end are marked
    private boolean all_is_unmarked(NGramList l, int start, int end) {
		boolean ans = true;

		if (l.equals(l1) ) {
			for (int i = start; i < end; i++) {
				if (l1_marks.get(i) == true) {
					ans = false;
				}
			}
		} else if (l.equals(l2)) {
			for (int i = start; i < end; i++) {
				if (l2_marks.get(i) == true) {
					ans = false;
				}
			}
		}

		return ans;
	}

	// Mark all NGrams in l1 between tokenStartIndex and tokenEndIndex
	private void marknGramsStartOfStmtsInS1NGrams(int tokenStartIndex, int tokenEndIndex) {
		for (int i=0; i< l1.size(); i++) {
			if (l1.get(i).codeStartIndex() >= tokenStartIndex
				&& l1.get(i).codeEndIndex() <= tokenEndIndex) {
					l2_marks.set(i, true);
			};
		}
	}

	// Mark all NGrams in l2 between tokenStartIndex and tokenEndIndex
	private void marknGramsStartOfStmtsInS2NGrams(int tokenStartIndex, int tokenEndIndex) {
		for (int i=0; i< l2.size(); i++) {
			if (l2.get(i).codeStartIndex() >= tokenStartIndex
				&& l2.get(i).codeEndIndex() <= tokenEndIndex) {
					l2_marks.set(i, true);
			};
		}
	}

	// Checks if Ngrams at index idx1 of l1 and idx2 of l2 matches
	private boolean check_match(int idx1, int idx2) {
		// Out of bounds
		if (idx1 < 0 || idx1 >= l1_marks.size() - 1
			|| idx2 < 0|| idx2 >= l2_marks.size() - 1) return false;

		return !l1_marks.get(idx1)
			   && !l2_marks.get(idx1)
			   && (l1.get(idx1) ==
				   l2.get(idx2));
	}

	// Returns starting index of statement that contains token at index tokenIndex
    int findStmtStartIndex(TokenList tokenList, int index) {
		int ans = 0;
		for (int idx1 : tokenList.getStartOfStmtTokenIndices()) {
			if (idx1 > index) {
				break;
			} else {
				ans = idx1;
			}
		}
		return ans;
	}

	// Returns ending index of statement that contains token at index
    int findStmtEndIndex(TokenList tokenList, int index) {
		int ans = 0;
		for (int i = index; i < tokenList.size(); i++) {
			if (tokenList.get(i).isEndOfStatement() != null) {
				ans = i;
				break;
			}
		}
		return ans;
	}

	int countCSMapped(TokenList tokenList, int startIndex, int endIndex) {
		int curCSMapped = 0;
		for (int i = startIndex; i <= endIndex; i++) {
			if (tokenList.get(i).isEndOfStatement() == TokenSSID.EndOfStatementType.COUNTABLE) {
				curCSMapped++;
			}
		}
		return curCSMapped;
	}

	int countNCSMapped(TokenList tokenList, int startIndex, int endIndex) {
		int curNCSMapped = 0;
		for (int i = startIndex; i <= endIndex; i++) {
			if (tokenList.get(i).isEndOfStatement() == TokenSSID.EndOfStatementType.NON_COUNTABLE) {
				curNCSMapped++;
			}
		}
		return curNCSMapped;
	}


	private ArrayList<Mapping> gstPhase1(TokenList s1Tokens,
			NGramList s1NGrams,
			HashMap<NGram, ArrayList<Integer>> s2NGramIndices,
			TokenList s2Tokens, int[] maxMatch, ArrayList<Mapping> mappings) {

		for (NGram n: s1NGrams) {
			if (n.isFirstTokenStartOfStmt()) {
				l1.add(n);
			}
		}

		for (NGram n: s2NGrams) {
			if (n.isFirstTokenStartOfStmt()) {
				l2.add(n);
			}
		}

		

		for (int i=0; i < this.l1.size(); i++) {
			l1_marks.add(false);
		}

		for (int i=0; i < this.l2.size(); i++) {
			l2_marks.add(false);
		}

		NGramHasher hasher1 = new NGramHasher(maxMatch[0]);
		NGramHasher hasher2 = new NGramHasher(maxMatch[0]);

		Map<Integer, ArrayList<Integer>> s2_hash_to_positions = new HashMap<Integer, ArrayList<Integer>>();

		int idx2_begin = -1;
		for (int i = 0; i < l2.size(); i++) {
			if (l2_marks.get(i) == false) {
				idx2_begin = i;
				break;
			}
		}

		if (idx2_begin + maxMatch[0] > l2.size() - 1) {
			return mappings;
		}

		for (int idx2 = idx2_begin; idx2 < l2.size() - maxMatch[0]; idx2++) {
			if (idx2 == idx2_begin) {
				for (int it = idx2; it != idx2 + maxMatch[0]; it++) {
					hasher2.eat(l2.get(it).nGramHash());
				}
			} else {
				hasher2.update(l2.get(idx2 - 1).nGramHash(), l2.get(idx2 + maxMatch[0] - 1).nGramHash());
			}

			if (!all_is_unmarked(l2, idx2, idx2 + maxMatch[0])) {
				continue;
			}

			if (!s2_hash_to_positions.containsKey(hasher2.hashvalue)) {
				ArrayList<Integer> x = new ArrayList<>();
				x.add(idx2);
				s2_hash_to_positions.put(hasher2.hashvalue, x);
			} else {
				s2_hash_to_positions.get(hasher2.hashvalue).add(idx2);
			}
		}

		int idx1_begin = -1;
		for (int i=0; i < l1.size(); i++) {
			if (l1_marks.get(i) == false) {
				idx1_begin = i;
				break;
			}
		}

		if (idx1_begin + maxMatch[0] > l1.size() - 1) {
			return mappings;
		}

		for (int idx1 = idx1_begin; idx1 < l1.size() - maxMatch[0]; idx1++) {
			if (idx1 == idx1_begin) {
				for (int it = idx1; it != idx1 + maxMatch[0]; it++) {
					hasher1.eat(l1.get(it).nGramHash());
				}
			} else {
				hasher1.update(l1.get(idx1 - 1).nGramHash(), l1.get(idx1 + maxMatch[0] - 1).nGramHash());
			}

			if (!all_is_unmarked(l1, idx1, idx1 + maxMatch[0])) {
				continue;
			}

			if (!s2_hash_to_positions.containsKey(hasher1.hashvalue)) {
				continue;
			}
			int match_s1_end = -1;
			int match_s2_end = -1;
			

			for (int idx2 : s2_hash_to_positions.get(hasher1.hashvalue)) {
				match_s1_end = idx1 + maxMatch[0];
				match_s2_end = idx2 + maxMatch[0];

				while (match_s1_end != l1.size()-1 && match_s2_end != l2.size()-1
					   && l1.get(match_s1_end).nGramHash() == l2.get(match_s2_end).nGramHash()
					   && check_match(match_s1_end, match_s2_end)) {  
					match_s1_end++;
					match_s2_end++;
				}


				int s1StartMatchTokenIndex = l1.get(idx1).codeStartIndex();
				int s1EndMatchTokenIndex = findStmtEndIndex(s1Tokens, l1.get(match_s1_end).codeStartIndex());
				int s2StartMatchTokenIndex = l2.get(idx2).codeStartIndex();
				int s2EndMatchTokenIndex = findStmtEndIndex(s2Tokens, l2.get(match_s2_end).codeStartIndex());
				int startLine1 = l1.get(idx1).getCodeStartLine();
				int endLine1 = l1.get(match_s1_end).getCodeStartLine();
				int startLine2 = l2.get(idx2).getCodeStartLine();
				int endLine2 = l2.get(match_s2_end).getCodeStartLine();
				int mappedCountableStatement = countCSMapped(s1Tokens, s1StartMatchTokenIndex, s1EndMatchTokenIndex);
				int mappedNonCountableStatement = countNCSMapped(s1Tokens, s1StartMatchTokenIndex, s1EndMatchTokenIndex);
		
				Mapping m = new Mapping(
					s1StartMatchTokenIndex, 
					s1EndMatchTokenIndex,
					s2StartMatchTokenIndex,
					s2EndMatchTokenIndex,
					startLine1,
					endLine1,
					startLine2,
					endLine2,
					mappedCountableStatement,
					mappedNonCountableStatement
					);

				mappings.add(m);
			}
		}

		return mappings;

	}

	private void gstPhase2(ArrayList<Mapping> mappings, 
			int nGramSize,
			TokenList s1Tokens,
			NGramList s1NGrams,
			TokenList s2Tokens,
			NGramList s2NGrams,
			TokenList skeletonTokens,
			NGramList skeletonNGrams,
			int minMatch,
			ArrayList<Mapping> tokenMappings) {

		NGramList s1RegionNGrams;
		TokenList s1RegionTokens;
		boolean markedFound;
		ArrayList<Mapping> bMappings = new ArrayList<>();
		int mappedCountableStmt;

		Collections.sort(mappings, MappingComparator.getInstance());
		for (Mapping m : mappings) {
			markedFound = false;
			s1RegionTokens = new TokenList();
			s1RegionNGrams = new NGramList();

			int idx1 = m.getStartIndex1();
			int match_s1_end = m.getEndIndex1();

			for (int i = idx1; !markedFound && i <= match_s1_end; i++) {
				if (s1Tokens.isTokenMarked(i)) {
					markedFound = true;
					break;
				}
				s1RegionTokens.add(s1Tokens.get(i));
				if (i <= match_s1_end - nGramSize + 1) {
					s1RegionNGrams.add(NGram.clone(s1RegionNGrams.size(),
							s1NGrams.get(i)));
				}
			}

			int idx2 = m.getStartIndex2();
			int match_s2_end = m.getEndIndex2();

			for (int i = idx2; !markedFound && i <= match_s2_end; i++) {
				if (s2Tokens.isTokenMarked(i)) {
					markedFound = true;
					break;
				}
			}

			if (markedFound) {
				continue;
			}

			if (skeletonTokens != null) {
				gst(s1RegionNGrams, skeletonNGrams, null, 
						s1RegionTokens, skeletonTokens, null, 
						minMatch, bMappings
						);
				mappedCountableStmt = m.getMappedCountableStmtCount();
				logger.debug("Mapping is: {} ", m.toString());

				List<SkeletonMapping> skeletonMappings = new ArrayList<>();
				for (Mapping b : bMappings) {
					mappedCountableStmt -= b.getMappedCountableStmtCount();
					logger.debug("Skeleton mapping is: {} ", b.toString());					

					int startIdxOfSkeletonInS1 = b.getStartIndex1() + m.getStartIndex1();
					int endIdxOfSkeletonInS1 = b.getEndIndex1() + m.getStartIndex1();
					int startIdxOfSkeletonInS2 = b.getStartIndex1() + m.getStartIndex2();
					int endIdxOfSkeletonInS2 = b.getEndIndex1() + m.getStartIndex2();

					// To exclude tokens found in skeleton code from similarity percentage later on
					s1Tokens.baseMarkRange(startIdxOfSkeletonInS1, endIdxOfSkeletonInS1);
					s2Tokens.baseMarkRange(startIdxOfSkeletonInS2, endIdxOfSkeletonInS2);
					marknGramsStartOfStmtsInS1NGrams(startIdxOfSkeletonInS1, endIdxOfSkeletonInS1);
					marknGramsStartOfStmtsInS2NGrams(startIdxOfSkeletonInS2, endIdxOfSkeletonInS2);

					SkeletonMapping skeletonMapping = new SkeletonMapping();
					skeletonMapping.setStartLine1(s1Tokens.get(startIdxOfSkeletonInS1).getCodeLine());
					skeletonMapping.setStartLine2(s2Tokens.get(startIdxOfSkeletonInS2).getCodeLine());
					skeletonMapping.setEndLine1(s1Tokens.get(endIdxOfSkeletonInS1).getCodeLine());
					skeletonMapping.setEndLine2(s2Tokens.get(endIdxOfSkeletonInS2).getCodeLine());

					skeletonMappings.add(skeletonMapping);

				}

				m.setMappedCountableStmtCount(mappedCountableStmt);
				m.setSkeletonMappings(skeletonMappings);

				s1Tokens.markRange(idx1, match_s1_end);
				s2Tokens.markRange(idx2, match_s2_end);
				marknGramsStartOfStmtsInS1NGrams(idx1, match_s1_end);
				marknGramsStartOfStmtsInS2NGrams(idx2, idx2);

				boolean isPlagMapping = (mappedCountableStmt >= minMatch) ? true : false;
				m.setIsPlagMapping(isPlagMapping);

			} else { // No skeleton, directly treated as plag matching
				s1Tokens.markRange(idx1, match_s1_end);
				s2Tokens.markRange(idx2, match_s2_end);
				marknGramsStartOfStmtsInS1NGrams(idx1, match_s1_end);
				marknGramsStartOfStmtsInS2NGrams(idx2, idx2);

				m.setIsPlagMapping(true);
			}

			tokenMappings.add(m);
		}
	}
}