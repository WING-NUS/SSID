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
import java.io.*;
import java.util.*;

public final class SubmissionRetriever {

	private static final String MAP_FILE_NAME = "mapfile.csv";

	/**
	 * To retrieve submissions into Submission instances. All line terminals are
	 * replaced with \n (Linux format)
	 * 
	 * @param compareFolderPath
	 *            The compare folder path
	 * @return An array list of submissions, with the submission name (based on
	 *         the file name in compare folder) and modified code filled
	 * @throws Exception
	 *             File reading errors
	 */
	public static ArrayList<Submission> retrieveSubmissions(
			String compareFolderPath, boolean isMapEnabled) throws Exception {


		ArrayList<Submission> reply = new ArrayList<Submission>();
		File[] files = new File(compareFolderPath).listFiles();
		ArrayList<String> lines;
		Hashtable<String, String> mappedNames = new Hashtable<String, String>();
		mappedNames = getExtractedMappedNames(compareFolderPath, isMapEnabled);
		int codeLength;
		String studentName;
		for (File f : files) {
			if (f.getName() != MAP_FILE_NAME) {
				lines = new ArrayList<String>();
				codeLength = getFileContents(f, lines);
				studentName = getStudentName(mappedNames, f.getName());
				reply.add(new Submission(studentName, f.getPath(), lines, codeLength));
			}
		}
		return reply;
	}

	private static Hashtable<String, String> getExtractedMappedNames(String compareFolderPath, boolean isMapEnabled) {
		// Read tokenNames
		String mapNamesPath = compareFolderPath.substring(0, compareFolderPath.length() - 8) + MAP_FILE_NAME;
		Hashtable<String, String> mappedNames = new Hashtable<String, String>();
		if (isMapEnabled) {
			try {
			File mapNamesFile = new File(mapNamesPath);
			Scanner scanner = new Scanner(mapNamesFile);
			while (scanner.hasNext()) {
				String[] cols = scanner.nextLine().split(",");
				System.out.println("hi");
				System.out.println(cols[0]);
				System.out.println(cols[1]);
				mappedNames.put(cols[0], cols[1]);
			}
			scanner.close();
			} catch (Exception ex) {
			System.err.println(ex);
			System.exit(1);
			}
		}
		return mappedNames;
	}

	private static String getStudentName(Hashtable<String, String> mappedNames, String studentName) {
		System.out.println(studentName);
		String mappedStudentName = mappedNames.get(studentName);
        if (mappedStudentName == null) {
			System.out.println("why da?");
			return studentName;
        } else {
			System.out.println("working da");
			System.out.println(mappedStudentName);
			return (mappedStudentName + " (" + studentName + ")");
		}
	}

	private static int getFileContents(File f, ArrayList<String> lines)
			throws Exception {
		int codeLength = 0;
		BufferedReader br = new BufferedReader(new FileReader(f));

		String line;
		while (br.ready()) {
			line = br.readLine();
			if (line == null) {
				break;
			}

			lines.add(line);
			codeLength += line.length() + 1;
		}
		return codeLength;

	}
}
