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

import Tokenizer.*;
import java.util.*;
import java.text.*;

import pd.utils.*;
import pd.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main {

	public static final String SKELETON = "skeleton";

	private static Logger logger = LogManager.getLogger();

	// static final int KGRAM_SIZE = 3;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws Exception {

		long start = System.nanoTime();

		if (args.length != 10) {
			System.out.println("Your input arguments:" + Arrays.toString(args));
			throw new Exception(
					"Usage: jPDS <Assignment Id> <Compare Folder path> <Language> <minMatch> <N-Gram> <database host> <database name> <database username> <database password>");
		}

		String aId = args[0];
		String compareFolderPath = args[1];
		boolean isMapEnabled = Boolean.parseBoolean(args[9]);  
		System.out.println(compareFolderPath);
		String language = args[2];
		int minMatch = Integer.parseInt(args[3]);
		if (minMatch <= 0) {
			throw new Exception("MinMatch must be > 0");
		}
		int nGramSize = Integer.parseInt(args[4]);
		if (nGramSize <= 0) {
			throw new Exception("N-Gram size must be > 0");
		}
		String dbAddr = args[5];
		String dbName = args[6];
		String dbUser = args[7];
		String dbPwd = args[8];

    // Setup ANTLRDynamicTokenizer
		String antlrGrammarsBinDir = args[1] + "/../../../lib/antlr/grammars/bin/";
    ANTLRDynamicTokenizer.setGrammarsBinDir(antlrGrammarsBinDir);

		MySQLDB.setProperties(dbAddr, dbName, dbUser, dbPwd);

		ArrayList<Submission> submissions = SubmissionRetriever
				.retrieveSubmissions(compareFolderPath, isMapEnabled);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

		// if (language.equals(CTokenizer.language)) {
		// 	CTokenizer.getTokenizer().TokenizeSubmissions(submissions);
		// } 
		// else if (language.equals(JavaTokenizer.language)) {
		// 	JavaTokenizer.getTokenizer().TokenizeSubmissions(submissions);
		// } 
		if (ANTLRDynamicTokenizer.understandsLanguage(language)) {
			System.out.println("[" + dateFormat.format(new java.util.Date()) + "] ANTLR tokenizer started run: " + language);
			ANTLRDynamicTokenizer.getTokenizer(language).TokenizeSubmissions(submissions);
		} else {
			throw new Exception("Grammar for language \""+ language + "\" not found");
		}

		System.out.println("[" + dateFormat.format(new java.util.Date()) + "] ANTLR tokenizer completed");

		try {
			System.out.println("[" + dateFormat.format(new java.util.Date()) + "] Converting to submission tokens started run");
			NGramizer.getNGramizer().constructSubmissionsNGrams(submissions,
					nGramSize);

			ArrayList<Result> simResults = SimComparer.getComparer()
					.compareSubmissions(submissions, nGramSize, minMatch);

			System.out.println("[" + dateFormat.format(new java.util.Date()) 
          + "] Plagarism detection completed with duration = "
					+ new java.text.DecimalFormat("0.000").format((System
							.nanoTime() - start) / Math.pow(10, 9)) + "s");
			
			System.out.println("[" + dateFormat.format(new java.util.Date()) + "] Starting upload to database...");

			long beforeInsertDB = System.nanoTime();

			long countCodeMappings = 0L;
			for (Result result : simResults) {
			  long nbrOfCodeMappings = result.getCodeIndexMappings().size();
				countCodeMappings += nbrOfCodeMappings;
			}
			logger.info("Before saving result to db: assignmentId = {}, nbr of submissions = {}, nbr of code mappings = {}", aId, submissions.size(), countCodeMappings);

			MySQLDB.getMySQLDB().insertIntoDB(aId, submissions, simResults);
			
			System.out.println("[" + dateFormat.format(new java.util.Date()) 
          + "] Plagarism detection completed upload to database");

			long afterInsertDB = System.nanoTime();
			logger.info("Saving to DB took: {}s", (afterInsertDB - beforeInsertDB) / Math.pow(10, 9)); 
		  
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			for (StackTraceElement f : ex.getStackTrace()) {
				System.out.println(f.toString());
			}
			throw ex;
		}

	}
}
