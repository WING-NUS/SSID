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

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pd.utils.Pair;
import pd.utils.Result;
import pd.utils.Submission;
import pd.utils.Mappings.Mapping;
import pd.utils.Mappings.MappingComparator;
import pd.utils.Mappings.MatchingDocument;
import pd.utils.Mappings.SkeletonMapping;
import pd.utils.NGrams.FingerPrint;
import pd.utils.NGrams.NGram;
import pd.utils.NGrams.NGramList;
import pd.utils.Tokens.TokenList;
import pd.utils.Tokens.TokenSSID;
public final class SimComparer {

	private static SimComparer instance = new SimComparer();
	private static final String SKELETON = "skeleton";
	private static Logger logger = LogManager.getLogger();
	private static final int WINDOW_SIZE = 4;

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

		long wholeAssFingerprintsNbr = 0;
		HashMap<BigInteger, ArrayList<FingerPrint>> invertedIndexesOfAssignmentFingerPrints = new HashMap<BigInteger, ArrayList<FingerPrint>>();
		for (Submission s : submissions) {
			ArrayList<FingerPrint> subFingerPrints = computeDocumentFingerPrints(s, nGramSize-1);

			for (FingerPrint fPrint : subFingerPrints) {
				BigInteger hash = fPrint.getHash();
				if (invertedIndexesOfAssignmentFingerPrints.containsKey(hash)) {
					ArrayList<FingerPrint> listOFingerPrints = invertedIndexesOfAssignmentFingerPrints.get(hash);
					listOFingerPrints.add(fPrint);
				} else {
					ArrayList<FingerPrint> listOFingerPrints = new ArrayList<FingerPrint>();
					listOFingerPrints.add(fPrint);
					invertedIndexesOfAssignmentFingerPrints.put(hash, listOFingerPrints);
				}
			}

			long nbrOfFingerprints = subFingerPrints.size();
			wholeAssFingerprintsNbr += nbrOfFingerprints; 
		}

		logger.debug("Assignment fingerprints: {}", wholeAssFingerprintsNbr);

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

	public ArrayList<Result> compareSubmissionsWithFingerPrints(
			ArrayList<Submission> submissions, int nGramSize, int minMatch) {

		Submission skeleton = getSkeletonCode(submissions);
    assert(skeleton != null);
		ArrayList<Result> results = new ArrayList<Result>();

		int noOfSub = submissions.size();
		Submission s1, s2;
		TokenList s1Tokens, s2Tokens, bTokens = skeleton.getCodeTokens();
		Result result;

		long wholeAssFingerprintsNbr = 0;
		HashMap<BigInteger, ArrayList<MatchingDocument>> invertedIndexesOfAssignmentFingerPrints = new HashMap<BigInteger, ArrayList<MatchingDocument>>();
		for (Submission s : submissions) {
			ArrayList<FingerPrint> submissionFingerPrints = computeDocumentFingerPrints(s, nGramSize-1);
			s.setSubmissionFingerPrints(submissionFingerPrints);

			for (FingerPrint fingerPrint : submissionFingerPrints) {
				
				BigInteger hash = fingerPrint.getHash();
				
				ArrayList<MatchingDocument> listOMatchingDocuments = new ArrayList<MatchingDocument>();
				if (invertedIndexesOfAssignmentFingerPrints.containsKey(hash)) {
				  listOMatchingDocuments = invertedIndexesOfAssignmentFingerPrints.get(hash);
				} 

				MatchingDocument match = new MatchingDocument(s.getID(), fingerPrint);
				listOMatchingDocuments.add(match);
				invertedIndexesOfAssignmentFingerPrints.put(hash, listOMatchingDocuments);
			}

			long nbrOfFingerprints = submissionFingerPrints.size();
			wholeAssFingerprintsNbr += nbrOfFingerprints; 

		}

		logger.debug("Assignment fingerprints: {}", wholeAssFingerprintsNbr);

		for (Submission s : submissions) {
			computePossibleRelatedDocuments(s, invertedIndexesOfAssignmentFingerPrints);
		}


    HashSet<Pair> processedPairs = new HashSet<Pair>();
		for (int i = 0; i < noOfSub; i++) {
			s1 = submissions.get(i);
			if (s1.isSkeletonCode()) {
				continue;
			}
			for (int j = 0; j < noOfSub; j++) {
				s2 = submissions.get(j);
				if (s2.getID().equals(s1.getID()) || s2.isSkeletonCode()) {
					continue;
				}

				if (!s1.getPossibleRelatedDocuments().contains(s2.getID())) {
					continue;
				}

				Pair pair = new Pair(i, j);
				if (processedPairs.contains(pair)) {
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
				processedPairs.add(pair);


			}
		}

		return results;
	}	

	private void computePossibleRelatedDocuments(Submission s, HashMap<BigInteger, ArrayList<MatchingDocument>> invertedIndexesOfAssignmentFingerPrints) {
		ArrayList<FingerPrint> currentSubmissionFingerPrints = s.getSubmissionFingerPrints();

		// Each entry is: key=submissionId and value=the list of fingerprints that s and the submissionId share. 
		HashMap<String, HashSet<FingerPrint>> matchingFingerPrintsMap = new HashMap<String, HashSet<FingerPrint>>();

		for (FingerPrint fingerPrint : currentSubmissionFingerPrints) {
			BigInteger hash = fingerPrint.getHash();

			// Each entry is: key=hash and value=the list of documents that contain this hash.
			ArrayList<MatchingDocument> relatedDocuments = invertedIndexesOfAssignmentFingerPrints.get(hash);
			if (relatedDocuments != null) {
				for (MatchingDocument document : relatedDocuments) {
					String documentId = document.getSubmissionId();
					
					HashSet<FingerPrint> matchingFingerPrints = new HashSet<FingerPrint>();					
					if (matchingFingerPrintsMap.containsKey(documentId)) {
						matchingFingerPrints = matchingFingerPrintsMap.get(documentId);
					}

					if (!matchingFingerPrints.contains(fingerPrint)) {
						matchingFingerPrints.add(fingerPrint);
					}

					if (!matchingFingerPrintsMap.containsKey(documentId)) {
						matchingFingerPrintsMap.put(documentId, matchingFingerPrints);
					}

				} 


			} else {
				logger.debug("Submission {} has fingerprint {} not found in the universal set of fingerprints", s.getID(), fingerPrint.toString());
			}

		}

		int sizeThreshold = (int) Math.floor(currentSubmissionFingerPrints.size() * 0.6);
		for (String submissionId : matchingFingerPrintsMap.keySet()) {
			HashSet<FingerPrint> matchingFingerPrints = matchingFingerPrintsMap.get(submissionId);
			
			logger.debug("Current sub: {}, the other sub: {}, current sub size: {}, match size: {}, size threshold: {}", s.getID(), submissionId, currentSubmissionFingerPrints.size(), matchingFingerPrints.size(), sizeThreshold);

			if (matchingFingerPrints.size() >= sizeThreshold) {
				s.getPossibleRelatedDocuments().add(submissionId);
			}
		}

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

	private ArrayList<FingerPrint> computeDocumentFingerPrints (Submission s, int windowSize) {
		logger.debug("Compute fingerprints of submission {}:", s.getID());

		NGramList nGramList = s.getNGramList();
		ArrayList<FingerPrint> documentFingerprints = new ArrayList<FingerPrint>();

		

		try {
			NGram[] firstNGrams = new NGram[windowSize];
			for(int i = 0; i < firstNGrams.length; i++) {
				firstNGrams[i] = nGramList.get(i);
			}
			FingerPrint lastMinGram = minGram(firstNGrams, 0);
			BigInteger lastMinHash = lastMinGram.getHash();
			int lastSelectedPosition = 0 + lastMinGram.getIndexWithinWindow();

			documentFingerprints.add(lastMinGram);
			for (int window = 1; window < nGramList.size()- windowSize; window++) {
			
				NGram currentGram = nGramList.get(window + windowSize-1);
				BigInteger hashOfTheCurrentGram = currentGram.nGramHash();
				int currentPosition = window + windowSize-1;

				if (hashOfTheCurrentGram.compareTo(lastMinHash) <= 0 && (currentPosition - lastSelectedPosition) < windowSize) {
					lastMinHash = hashOfTheCurrentGram;
					lastSelectedPosition = currentPosition;
					documentFingerprints.add(new FingerPrint(hashOfTheCurrentGram, currentGram, window, windowSize-1));
				} else if (hashOfTheCurrentGram.compareTo(lastMinHash) > 0 && (currentPosition - lastSelectedPosition) < windowSize) {
					// skip
				} else {
					NGram[] currentNGrams = new NGram[windowSize];
					for (int i=window; i <= window+windowSize-1; i++) {
						currentNGrams[i-window] = nGramList.get(i);
					}
					FingerPrint fingerPrint = minGram(currentNGrams, window);

					lastMinHash = fingerPrint.getHash();
					lastSelectedPosition = window + fingerPrint.getIndexWithinWindow();
					documentFingerprints.add(fingerPrint);
				}
				
			}

			// for (FingerPrint fingerPrint : documentFingerprints) {
			// 	logger.debug("Fingerprint: {}", fingerPrint.toString());
			// }


		} catch (Exception e) {
			e.printStackTrace();
		}
		return documentFingerprints;

	}	


	private FingerPrint minGram(NGram[] arrayOfNGrams, int window) throws NoSuchAlgorithmException {
		BigInteger[] hashes = new BigInteger[arrayOfNGrams.length];
		for (int i = 0; i < hashes.length; i++) {
			hashes[i] = arrayOfNGrams[i].nGramHash();
		}

		int lastIdx = arrayOfNGrams.length-1;
		FingerPrint minGram = new FingerPrint(hashes[lastIdx], arrayOfNGrams[lastIdx], window, lastIdx);
		for (int j = hashes.length-1; j>=0; j--) {
			BigInteger currentHash = hashes[j];
			if (currentHash.compareTo(minGram.getHash()) < 0) {
				minGram.setHash(currentHash);
				minGram.setnGram(arrayOfNGrams[j]);
				minGram.setIndexWithinWindow(j);
			}
		}
		return minGram;
	}
	

	private Result compareSubmissions(Submission s1, Submission s2,
			Submission skeleton, int nGramSize, int minMatch) {

		NGramList s1NGrams = s1.getNGramList(), s2NGrams = s2.getNGramList();

		if (s1NGrams.size() > 0 && s2NGrams.size() > 0) {
			Result result = new Result(s1, s2);

			gst(s1NGrams, s2.getNGramIndexingTable(),
					skeleton.getNGramIndexingTable(), s1.getCodeTokens(),
					s2.getCodeTokens(), skeleton.getCodeTokens(), minMatch,
					result.getTokenIndexMappings(), s1, s2, skeleton);

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
	private void gst(NGramList s1NGrams,
			HashMap<NGram, ArrayList<Integer>> s2NGramIndices,
			HashMap<NGram, ArrayList<Integer>> bNGramIndices,
			TokenList s1Tokens, TokenList s2Tokens, TokenList bTokens,
			int minMatch, ArrayList<Mapping> tokenMappings, Submission s1, Submission s2,
			Submission skeleton) {

		int nGramSize = s1NGrams.size() > 0 ? NGram.getNGramSize() : 0;

		ArrayList<Mapping> mappings;

		// Use int[1] instead of int so that we can use maxMatch as a global object that can be passed around
		int[] maxMatch = new int[1];

		do {
			maxMatch[0] = minMatch;
			mappings = new ArrayList<Mapping>();
			mappings = gstPhase1(s1Tokens, s1NGrams, s2NGramIndices, s2Tokens,
					maxMatch, mappings, s1, s2, skeleton, minMatch);

			gstPhase2(mappings, s1Tokens, nGramSize, s1NGrams, s2Tokens,
					bTokens, bNGramIndices, minMatch, tokenMappings, s1, s2, skeleton);

		} while (maxMatch[0] > minMatch);
	}

	private ArrayList<Mapping> gstPhase1(TokenList s1Tokens,
			NGramList s1NGrams,
			HashMap<NGram, ArrayList<Integer>> s2NGramIndices,
			TokenList s2Tokens, int[] maxMatch, ArrayList<Mapping> mappings,
			Submission s1, Submission s2, Submission skeleton, int minMatch) {

		NGramList s1NGramsStartingStmtsList;
		NGramList s2NGramsStartingStmtsList;
		s1NGramsStartingStmtsList = s1.getNGramsStartingStmtsList();
		s2NGramsStartingStmtsList = s2.getNGramsStartingStmtsList();
		 
		int s1EndIndex, s2EndIndex, curCSMapped, curNCSMapped, curTotalStatementMapped, 
			s1EndOfStmtIndex, s2StartIndex, s2EndOfStmtIndex;
		TokenSSID s1Token, s2Token;

		RKHasher RKHasher1 = new RKHasher(minMatch, s1NGramsStartingStmtsList);
		RKHasher RKHasher2 = new RKHasher(minMatch, s2NGramsStartingStmtsList);
		Map<Integer, ArrayList<Integer>> precomputedHashMap = new HashMap<Integer, ArrayList<Integer>>();


		// Get index of first unmarked NGram in s2NGramsStartingStmtsList.
		// This is done by checking first token of the NGram under consideration to determine whether or not that NGram 
		// is marked. We are keeping track of markings using TokenList and each statement (whose the Ngram under 
		// consideration belongs to) is marked as a whole, so that is sufficient.
		int firstUnmarkedNGramIdxS2NGramsStartingStmtsList = 0;
		for (int i = 0; i < s2NGramsStartingStmtsList.size(); i++) {
			int tokenIdx = s2.getTokenIndexOfLoc(s2NGramsStartingStmtsList.get(i).codeStartIndex());

			if (!s2Tokens.isTokenMarked(tokenIdx)) {
				firstUnmarkedNGramIdxS2NGramsStartingStmtsList = i;
				break;
			}
		}

		// Terminates if unmarked index found is too close to end of list and thus we can't find any more match
		if (firstUnmarkedNGramIdxS2NGramsStartingStmtsList + minMatch > s2NGramsStartingStmtsList.size() - 1) {
			return mappings;
		}

		for (int s2NGramIndex = firstUnmarkedNGramIdxS2NGramsStartingStmtsList; s2NGramIndex < s2NGramsStartingStmtsList.size() - minMatch; s2NGramIndex++) {
			boolean isMMLRangeAllUnmarked = true;
			for (int i = s2NGramIndex; i < s2NGramIndex + minMatch; i++) {
				int codeStartIndex = s2.getTokenIndexOfLoc(s2NGramsStartingStmtsList.get(i).codeStartIndex());
				if (s1Tokens.isTokenMarked(codeStartIndex)) {
					isMMLRangeAllUnmarked = false;
					break;
				}
			}
			if (!isMMLRangeAllUnmarked) continue;
			
			int hashStartFromIdx2 = RKHasher2.getHashStartingFrom(s2NGramIndex);

			if (!precomputedHashMap.containsKey(hashStartFromIdx2)) {
				ArrayList<Integer> positions = new ArrayList<>();
				positions.add(s2.getTokenIndexOfLoc(s2NGramsStartingStmtsList.get(s2NGramIndex).codeStartIndex()));
				precomputedHashMap.put(hashStartFromIdx2, positions);
			} else {
				precomputedHashMap.get(hashStartFromIdx2).add(s2.getTokenIndexOfLoc(s2NGramsStartingStmtsList.get(s2NGramIndex).codeStartIndex()));
			}
		}
	
		// Get index of first unmarked NGram in s1NGramsStartingStmtsList.
		// This is done by checking first token of the NGram under consideration to determine whether or not that NGram 
		// is marked. We are keeping track of markings using TokenList and each statement (whose the Ngram under 
		// consideration belongs to) is marked as a whole, so that is sufficient.
		int firstUnmarkedNGramIdxS1NGramsStartingStmtsList = 0;
		for (int i = 0; i < s1NGramsStartingStmtsList.size(); i++) {
			int tokenIdx = s1.getTokenIndexOfLoc(s1NGramsStartingStmtsList.get(i).codeStartIndex());
			if (!s1Tokens.isTokenMarked(tokenIdx)) {
				firstUnmarkedNGramIdxS1NGramsStartingStmtsList = i;
				break;
			}
		}

		// Terminates if unmarked index found is too close to end of list and thus we can't find any more match
		if (firstUnmarkedNGramIdxS1NGramsStartingStmtsList + maxMatch[0] > s1NGramsStartingStmtsList.size() - 1) {
			return mappings;
		}

		for (int s1NGramIndex = firstUnmarkedNGramIdxS1NGramsStartingStmtsList; s1NGramIndex < s1NGramsStartingStmtsList.size(); s1NGramIndex++) {
			int s1StartIndex = s1.getTokenIndexOfLoc(s1NGramsStartingStmtsList.get(s1NGramIndex).codeStartIndex());

			if (s1NGramsStartingStmtsList.size() <= s1NGramIndex
					|| s1NGramIndex + maxMatch[0] > s1NGramsStartingStmtsList.size() - 1
					|| s1Tokens.isTokenMarked(s1StartIndex)) {
				continue;
			}

			int hashStartingFromS1NGramIndex = RKHasher1.getHashStartingFrom(s1NGramIndex);
					
			if (precomputedHashMap.containsKey(hashStartingFromS1NGramIndex)) {	
				for (int s2Match: precomputedHashMap.get(hashStartingFromS1NGramIndex)) {
					s1EndIndex = s1StartIndex;
					curCSMapped = 0;
					curNCSMapped = 0;
					s2EndIndex = s2Match;
					s1EndOfStmtIndex = -1;
					while (s1Tokens.size() > s1EndIndex
							&& s2Tokens.size() > s2EndIndex
							&& (s1Token = s1Tokens.get(s1EndIndex))
									.equals(s2Token = s2Tokens.get(s2EndIndex))
							&& !s1Tokens.isTokenMarked(s1EndIndex)
							&& !s2Tokens.isTokenMarked(s2EndIndex)) {
						if (s1Token.isEndOfStatement() == TokenSSID.EndOfStatementType.COUNTABLE) {
							// logger.debug("s1 token end of Countable: {} ", s1Token.toString());	
							curCSMapped++;
							s1EndOfStmtIndex = s1EndIndex;
						} else if (s1Token.isEndOfStatement() == TokenSSID.EndOfStatementType.NON_COUNTABLE) {
							// logger.debug("s1 token end of Non-Countable: {} ", s1Token.toString());	
							curNCSMapped++;
							s1EndOfStmtIndex = s1EndIndex;
						}
						s1EndIndex++;
						s2EndIndex++;
					}

					curTotalStatementMapped = curCSMapped + curNCSMapped;
					
					NGram s1NGram = s1NGramsStartingStmtsList.get(s1NGramIndex);
					if (curTotalStatementMapped >= maxMatch[0]) {
						s1Token = s1Tokens.get(s1EndOfStmtIndex);
						s2StartIndex = s2Match;
						s2EndOfStmtIndex = s1EndOfStmtIndex - s1StartIndex
								+ s2StartIndex;
						s2Token = s2Tokens.get(s2EndOfStmtIndex);

						// CurStmtMapped is large the maxMatch found, override
						// the maxMatch
						if (curTotalStatementMapped > maxMatch[0]) {
							mappings = new ArrayList<Mapping>();
							mappings.add(new Mapping(s1StartIndex,
									s1EndOfStmtIndex, s2StartIndex,
									s2EndOfStmtIndex, s1NGram
											.getCodeStartLine(), s1Token
											.getCodeLine(), s2Tokens.get(
											s2StartIndex).getCodeLine(),
									s2Token.getCodeLine(), curCSMapped,
									curNCSMapped));

							maxMatch[0] = curTotalStatementMapped;
						} else {
							mappings.add(new Mapping(s1StartIndex,
									s1EndOfStmtIndex, s2StartIndex,
									s2EndOfStmtIndex, s1NGram
											.getCodeStartLine(), s1Token
											.getCodeLine(), s2Tokens.get(
											s2StartIndex).getCodeLine(),
									s2Token.getCodeLine(), curCSMapped,
									curNCSMapped));

						}
					}
				}
			}
		}
		return mappings;
	}

	private void gstPhase2(ArrayList<Mapping> mappings, TokenList s1Tokens,
			int nGramSize, NGramList s1NGrams, TokenList s2Tokens,
			TokenList bTokens,
			HashMap<NGram, ArrayList<Integer>> bNGramIndices, int minMatch,
			ArrayList<Mapping> tokenMappings, Submission s1, Submission s2, Submission skeleton) {

		NGramList s1RegionNGrams;
		TokenList s1RegionTokens;
		boolean markedFound;
		ArrayList<Mapping> bMappings;
		int mappedCountableStmt;
		int s1StartIndex, s1EndIndex, s2StartIndex, s2EndIndex;

		Collections.sort(mappings, MappingComparator.getInstance());
		for (Mapping m : mappings) {
			markedFound = false;
			s1RegionTokens = new TokenList();
			s1RegionNGrams = new NGramList();

			s1StartIndex = m.getStartIndex1();
			s1EndIndex = m.getEndIndex1();

			for (int i = s1StartIndex; !markedFound && i <= s1EndIndex; i++) {
				if (s1Tokens.isTokenMarked(i)) {
					markedFound = true;
					break;
				}
				s1RegionTokens.add(s1Tokens.get(i));
				if (i <= s1EndIndex - nGramSize + 1) {
					s1RegionNGrams.add(NGram.clone(s1RegionNGrams.size(),
							s1NGrams.get(i)));
				}
			}

			s2StartIndex = m.getStartIndex2();
			s2EndIndex = m.getEndIndex2();

			for (int i = s2StartIndex; !markedFound && i <= s2EndIndex; i++) {
				if (s2Tokens.isTokenMarked(i)) {
					markedFound = true;
					break;
				}
			}

			if (markedFound) {
				continue;
			}

			bMappings = new ArrayList<Mapping>();
			if (bTokens != null) {
				gst(s1RegionNGrams, bNGramIndices, null, s1RegionTokens,
						bTokens, null, minMatch, bMappings, s1, skeleton, null);
				mappedCountableStmt = m.getMappedCountableStmtCount();
				// logger.debug("Mapping is: {} ", m.toString());

				List<SkeletonMapping> skeletonMappings = new ArrayList<>();
				for (Mapping b : bMappings) {
					mappedCountableStmt -= b.getMappedCountableStmtCount();
					// logger.debug("Skeleton mapping is: {} ", b.toString());					

					int startIdxOfSkeletonInS1 = b.getStartIndex1() + m.getStartIndex1();
					int endIdxOfSkeletonInS1 = b.getEndIndex1() + m.getStartIndex1();
					int startIdxOfSkeletonInS2 = b.getStartIndex1() + m.getStartIndex2();
					int endIdxOfSkeletonInS2 = b.getEndIndex1() + m.getStartIndex2();

					// To exclude tokens found in skeleton code from similarity percentage later on
					s1Tokens.baseMarkRange(startIdxOfSkeletonInS1, endIdxOfSkeletonInS1);
					s2Tokens.baseMarkRange(startIdxOfSkeletonInS2, endIdxOfSkeletonInS2);

					SkeletonMapping skeletonMapping = new SkeletonMapping();
					skeletonMapping.setStartLine1(s1Tokens.get(startIdxOfSkeletonInS1).getCodeLine());
					skeletonMapping.setStartLine2(s2Tokens.get(startIdxOfSkeletonInS2).getCodeLine());
					skeletonMapping.setEndLine1(s1Tokens.get(endIdxOfSkeletonInS1).getCodeLine());
					skeletonMapping.setEndLine2(s2Tokens.get(endIdxOfSkeletonInS2).getCodeLine());

					skeletonMappings.add(skeletonMapping);

				}

				m.setMappedCountableStmtCount(mappedCountableStmt);
				m.setSkeletonMappings(skeletonMappings);

				s1Tokens.markRange(s1StartIndex, s1EndIndex);
				s2Tokens.markRange(s2StartIndex, s2EndIndex);
				
				boolean isPlagMapping = (mappedCountableStmt >= minMatch) ? true : false;
				m.setIsPlagMapping(isPlagMapping);

			} else { // No skeleton, directly treated as plag matching
				s1Tokens.markRange(s1StartIndex, s1EndIndex);
				s2Tokens.markRange(s2StartIndex, s2EndIndex);
				m.setIsPlagMapping(true);
			}

			tokenMappings.add(m);
		}
	}
}
