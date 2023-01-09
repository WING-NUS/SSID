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
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
			ArrayList<FingerPrint> subFingerPrints = computeDocumentFingerPrints(s);
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
			ArrayList<FingerPrint> submissionFingerPrints = computeDocumentFingerPrints(s);
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

		// for(BigInteger hash : invertedIndexesOfAssignmentFingerPrints.keySet()) {
		// 	logger.debug("DEBUG POINT 02: Investigate inverted indexes of assignment fingerprints");
		// 	logger.debug("Hash: {}", hash);
		// 	String mds = "";
		// 	for (MatchingDocument md : invertedIndexesOfAssignmentFingerPrints.get(hash)) {
		// 		mds = mds + md.toString() + "\t";
		// 	}
		// 	logger.debug("Related document: {}", mds);
		// 	logger.debug("*********");
		// }

		for (Submission s : submissions) {
			computePossibleRelatedDocuments(s, invertedIndexesOfAssignmentFingerPrints);
		}

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

				if (!s1.getPossibleRelatedDocuments().contains(s2.getID())) {
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

	private void computePossibleRelatedDocuments(Submission s, HashMap<BigInteger, ArrayList<MatchingDocument>> invertedIndexesOfAssignmentFingerPrints) {
		ArrayList<FingerPrint> currentSubmissionFingerPrints = computeDocumentFingerPrints(s);

		// Each entry is: key=submissionId and value=the list of fingerprints that s and the submissionId share. 
		HashMap<String, ArrayList<FingerPrint>> matchingFingerPrintsMap = new HashMap<String, ArrayList<FingerPrint>>();

		for (FingerPrint fingerPrint : currentSubmissionFingerPrints) {
			BigInteger hash = fingerPrint.getHash();

			// Each entry is: key=hash and value=the list of documents that contain this hash.
			ArrayList<MatchingDocument> relatedDocuments = invertedIndexesOfAssignmentFingerPrints.get(hash);
			if (relatedDocuments != null) {
				for (MatchingDocument document : relatedDocuments) {
					String documentId = document.getSubmissionId();
					
					ArrayList<FingerPrint> matchingFingerPrints = new ArrayList<FingerPrint>();					
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

		// for (String submissionId : matchingFingerPrintsMap.keySet()) {
		// 	logger.debug("DEBUG POINT 03: Investigate map of similar fingerprints");
		// 	String fps = "";
		// 	for (FingerPrint fp : matchingFingerPrintsMap.get(submissionId)) {
		// 		fps = fps + fp.toString() + "\t";
		// 	}
		// 	logger.debug("Sub: {}, sub: {}, similar fps (position based on nbr #1): {}", s.getID(), submissionId, fps);
		// }



		int sizeThreshold = (int) Math.floor(currentSubmissionFingerPrints.size() * 0.6);
		for (String submissionId : matchingFingerPrintsMap.keySet()) {
			ArrayList<FingerPrint> matchingFingerPrints = matchingFingerPrintsMap.get(submissionId);
			
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

	private void printSubmissionsInfo(Submission s) {

		logger.debug("Comparing time using string vs big int to get min nGram hashes of submission {}:", s.getID());
		/* Printing NGramIndexingTable
		HashMap<NGram, ArrayList<Integer>> nGramIndexingTableOfS = s.getNGramIndexingTable();
		logger.debug("Printing nGram indexing table of submission {}:", s.getID());
		Set<NGram> keysInS = nGramIndexingTableOfS.keySet();
		for (NGram key : keysInS) {
			
			ArrayList<Integer> values = nGramIndexingTableOfS.get(key);
			String valuesInString = "";
			for(Integer i : values) {
				valuesInString = valuesInString + i + " ";
			}
			logger.debug("S, ngram = {}, value = {}", key.getTokenList().toString(), valuesInString);


		}		

		*/

	}

	private ArrayList<FingerPrint> computeDocumentFingerPrints (Submission s) {
		logger.debug("Compute fingerprints of submission {}:", s.getID());

		NGramList nGramList = s.getNGramList();
		ArrayList<FingerPrint> documentFingerprints = new ArrayList<FingerPrint>();

		

		try {
			FingerPrint lastMinGram = minGram(nGramList.get(0), nGramList.get(1), nGramList.get(2), nGramList.get(3), 0);
			BigInteger lastMinHash = lastMinGram.getHash();
			int lastSelectedPosition = 0 + lastMinGram.getIndexWithinWindow();

			documentFingerprints.add(lastMinGram);
			for (int window = 1; window < nGramList.size()- WINDOW_SIZE; window++) {
			
				NGram currentGram = nGramList.get(window + WINDOW_SIZE-1);
				BigInteger hashOfTheCurrentGram = currentGram.nGramHash();
				int currentPosition = window+3;

				if (hashOfTheCurrentGram.compareTo(lastMinHash) <= 0 && (currentPosition - lastSelectedPosition) < WINDOW_SIZE) {
					lastMinHash = hashOfTheCurrentGram;
					lastSelectedPosition = currentPosition;
					documentFingerprints.add(new FingerPrint(hashOfTheCurrentGram, currentGram, window, 3));
				} else if (hashOfTheCurrentGram.compareTo(lastMinHash) > 0 && (currentPosition - lastSelectedPosition) < WINDOW_SIZE) {
					// skip
				} else {
					NGram one = nGramList.get(window);
					NGram two = nGramList.get(window+1);
					NGram three = nGramList.get(window+2);
					NGram four = nGramList.get(window+3);		
					FingerPrint fingerPrint = minGram(one, two, three, four, window);

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

	private FingerPrint minGram(NGram one, NGram two, NGram three, NGram four, int window) throws NoSuchAlgorithmException {
		BigInteger i1 = one.nGramHash();
		BigInteger i2 = two.nGramHash();
		BigInteger i3 = three.nGramHash();
		BigInteger i4 = four.nGramHash();

		FingerPrint minGram = new FingerPrint(i4, four, window, 3);

		if (i4.compareTo(i1) <= 0 && i4.compareTo(i2) <= 0 && i4.compareTo(i3) <= 0) {
			// skip
		} else if (i3.compareTo(i1) <= 0 && i3.compareTo(i2) <= 0 && i3.compareTo(i4) <= 0) {
			minGram.setHash(i3);
			minGram.setnGram(three);
			minGram.setIndexWithinWindow(2);
		} else if (i2.compareTo(i1) <= 0 && i2.compareTo(i3) <= 0 && i2.compareTo(i4) <= 0) {
			minGram.setHash(i2);
			minGram.setnGram(two);
			minGram.setIndexWithinWindow(1);
		} else {
			minGram.setHash(i1);
			minGram.setnGram(one);
			minGram.setIndexWithinWindow(0);
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
	private void gst(NGramList s1NGrams,
			HashMap<NGram, ArrayList<Integer>> s2NGramIndices,
			HashMap<NGram, ArrayList<Integer>> bNGramIndices,
			TokenList s1Tokens, TokenList s2Tokens, TokenList bTokens,
			int minMatch, ArrayList<Mapping> tokenMappings) {

		int nGramSize = s1NGrams.size() > 0 ? NGram.getNGramSize() : 0;

		ArrayList<Mapping> mappings;

		int[] maxMatch = new int[1];

		do {
			maxMatch[0] = minMatch;
			mappings = new ArrayList<Mapping>();
			mappings = gstPhase1(s1Tokens, s1NGrams, s2NGramIndices, s2Tokens,
					maxMatch, mappings);
			gstPhase2(mappings, s1Tokens, nGramSize, s1NGrams, s2Tokens,
					bTokens, bNGramIndices, minMatch, tokenMappings);

		} while (maxMatch[0] > minMatch);
	}

	private ArrayList<Mapping> gstPhase1(TokenList s1Tokens,
			NGramList s1NGrams,
			HashMap<NGram, ArrayList<Integer>> s2NGramIndices,
			TokenList s2Tokens, int[] maxMatch, ArrayList<Mapping> mappings) {

		// curCSMapped = current countable statement mapped
		// curNCSMapped = current non-countable statement mapped
		int s1EndIndex, s2EndIndex, curCSMapped, curNCSMapped, curTotalStatementMapped, s1EndOfStmtIndex, s2StartIndex, s2EndOfStmtIndex;
		TokenSSID s1Token, s2Token;
		HashMap<Integer, Integer> s2Matches;
		ArrayList<Integer> s2Indices;
		NGram s1NGram;

		for (int s1StartIndex : s1Tokens.getStartOfStmtTokenIndices()) {
			if (s1NGrams.size() <= s1StartIndex
					|| s1Tokens.isTokenMarked(s1StartIndex)) {
				continue;
			}

			s1NGram = s1NGrams.get(s1StartIndex);
			// logger.debug("The n-gram is: {} ", s1NGram.getTokenList().toString());
			
			if (s2NGramIndices.containsKey(s1NGram)) {
				// logger.debug("The similar n-gram is: {} ", s1NGram.getTokenList().toString());	
				s2Indices = s2NGramIndices.get(s1NGram);
				s2Matches = new HashMap<Integer, Integer>();
				for (int index : s2Indices) {
					if (s2Tokens.isTokenMarked(index)) {
						continue;
					}
					s2Matches.put(index, index);
				}
				for (Map.Entry<Integer, Integer> s2Match : s2Matches.entrySet()) {
					s1EndIndex = s1StartIndex;
					curCSMapped = 0;
					curNCSMapped = 0;
					s2EndIndex = s2Match.getValue();
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
					if (curTotalStatementMapped >= maxMatch[0]) {
						s1Token = s1Tokens.get(s1EndOfStmtIndex);
						s2StartIndex = s2Match.getKey();
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
			ArrayList<Mapping> tokenMappings) {

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
						bTokens, null, minMatch, bMappings);
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
