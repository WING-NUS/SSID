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
			String compareFolderPath) throws Exception {

		ArrayList<Submission> reply = new ArrayList<Submission>();
		File[] files = new File(compareFolderPath).listFiles();
		ArrayList<String> lines;
		int codeLength;
		for (File f : files) {
			lines = new ArrayList<String>();
			codeLength = getFileContents(f, lines);
			reply.add(new Submission(f.getName(), f.getPath(), lines, codeLength));
		}
		return reply;
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
