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
 
package Tokenizer;

import java.util.*;
import pd.utils.Submission;

public abstract class Tokenizer {

	// Define the comment type
	protected static final int SINGLE_LINE_COMMENT = 0, MULTI_LINE_COMMENT = 1;

	// Define those keywords which are ignorable during plagirism detection
	// (example: accessibilty keywords in java)
	protected HashSet<String> ignorableKeywords = new HashSet<String>(),
	// Define those keywords which are used in preprocess directive (example:
	// import in java)
			preprocessDirectiveKeywords = new HashSet<String>(),
			// Define those keywords which are constant (example: true and
			// false)
			constantKeywords = new HashSet<String>(),
			// Define all keywords
			keywords = new HashSet<String>(),
			// Define those keywords which serves as data structures (examples:
			// byte, int, double in java)
			variableKeywords = new HashSet<String>();

	/***
	 * Tokenize submissions
	 * 
	 * @param submissions
	 *            The list of submissions
	 */
	public abstract void TokenizeSubmissions(ArrayList<Submission> submissions);
}
