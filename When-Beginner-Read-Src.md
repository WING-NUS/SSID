# When a beginner read the source code of SSID

This document marks down the process of a beginner read the source code of SSID and tries to resolve some issues (e.g. Issue [74](https://github.com/WING-NUS/SSID/issues/74)) in early 2021. 



- From a high level view:
  - [SSID/app](https://github.com/WING-NUS/SSID/tree/master/app) contains the ruby files for the web service.
  - [SSID/lib](https://github.com/WING-NUS/SSID/tree/master/lib) contains the java files that serve as the computation engine for plagiarism detection.



## [SSID/app](https://github.com/WING-NUS/SSID/tree/master/app) 

TODO.



## [SSID/lib](https://github.com/WING-NUS/SSID/tree/master/lib) 

The structure of `lib` is as followed:

- [SSID/lib/antlr](https://github.com/WING-NUS/SSID/tree/master/lib/antlr): Support different languages to be detected by SSID. Please refer to Riyas' note on adding a new language [[link](https://github.com/WING-NUS/SSID/blob/master/doc/add_support_for_new_language.md)].
- [SSID/lib/assets](https://github.com/WING-NUS/SSID/tree/master/lib/assets): Not important?
- **[SSID/lib/java](https://github.com/WING-NUS/SSID/tree/master/lib/java):** The main functions and logic for plagiarism detection are implemented here.
  - [SSID/lib/java/PlagiarismDetection](https://github.com/WING-NUS/SSID/tree/master/lib/java/PlagiarismDetection): Core functions of plagiarism detection.
  - [SSID/lib/java/SubmissionsClustering](https://github.com/WING-NUS/SSID/tree/master/lib/java/SubmissionsClustering): Core functions of Submission Clustering. 
- [SSID/lib/tasks](https://github.com/WING-NUS/SSID/tree/master/lib/tasks): Not important?



## The workflow of SSID.

We use the `Test Upload Log` to probe the workflow of SSID. 

```
Courses > CS3245 Assignments > Assignment: Test Upload Log
Assignment: Test Upload Log

[2021-04-08 11:35:49 +0800] Received file: ssid-3245-min-test.zip 
[2021-04-08 11:35:49 +0800] Checking for empty directories

[2021-04-08 11:35:49 +0800] Unzip complete 
upload/133/_compare 
[2021-04-08 11:35:49 SGT] ANTLR tokenizer started run: python3 
Preparing temp file... 
Temp file prepared 
Preparing to run lexer 
Lexer completed 
Converting to PD readable Tokens 
Convert completed 
Empty file detected & would be removed from Plagiarism Detection 
Preparing temp file... 
Temp file prepared 
Preparing to run lexer 
Lexer completed 
Converting to PD readable Tokens 
Convert completed 
[2021-04-08 11:35:51 SGT] ANTLR tokenizer completed 
[2021-04-08 11:35:51 SGT] Converting to submission tokens started run 
[2021-04-08 11:35:51 SGT] Plagarism detection completed with duration = 1.716s 
[2021-04-08 11:35:51 SGT] Starting upload to database... 
[2021-04-08 11:35:51 SGT] Plagarism detection completed upload to database
```

**Code Snippet 1:** Workflow of SSID. Interestingly this update log is exactly what we get in Issue [74](https://github.com/WING-NUS/SSID/issues/74). As we can see in the snippet, SSID was not able to inform the user that his uploaded file structure was not correct. 



Code Snippet 1 helps me to locate [SSID/lib/java/PlagiarismDetection/src/Main.java](https://github.com/WING-NUS/SSID/blob/master/lib/java/PlagiarismDetection/src/Main.java) which explicitly describes the workflow of SSID. 

In a nutshell, the workflow of SSID includes following steps:

- Step 1: Receive a submission.
- Step 2: Check key metadata and reject invalid submissions. 
- Step 3: Load ANTLR tokenizer for the programming language specified, using this method: `ANTLRDynamicTokenizer.getTokenizer(language).TokenizeSubmissions(submissions);`
- Step 4: Convert raw submissions to tokens, using this method: `NGramizer.getNGramizer().constructSubmissionsNGrams(submissions, nGramSize);`
- Step 5: Do the similarity comparison, using this method: `ArrayList<Result> simResults = SimComparer.getComparer().compareSubmissions(submissions, nGramSize, minMatch);`
- Step 6: Insert the detection result to database, using this method: `MySQLDB.getMySQLDB().insertIntoDB(aId, submissions, simResults);`.

Please refer to the Appendix of this document for **Code Snippet 2**. 



## A lazy solution for Issue [74](https://github.com/WING-NUS/SSID/issues/74)

Since we have understood the workflow of SSID, we have come up with a lazy solution for Issue 74. 
In Step 4, we can add a checkpoint to see if the length of token == 0. If this is the case, we can inform the user the submission format is incorrect. One possible reason is the zip process is incorrect. 



## Appendix

```java
    // Setup ANTLRDynamicTokenizer
		String antlrGrammarsBinDir = args[1] + "/../../../lib/antlr/grammars/bin/";
    ANTLRDynamicTokenizer.setGrammarsBinDir(antlrGrammarsBinDir);

		MySQLDB.setProperties(dbAddr, dbName, dbUser, dbPwd);

		ArrayList<Submission> submissions = SubmissionRetriever
				.retrieveSubmissions(compareFolderPath);

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

			MySQLDB.getMySQLDB().insertIntoDB(aId, submissions, simResults);
			
			System.out.println("[" + dateFormat.format(new java.util.Date()) 
          + "] Plagarism detection completed upload to database");

```

**Code Snippet 2:** the workflow of SSID. 

