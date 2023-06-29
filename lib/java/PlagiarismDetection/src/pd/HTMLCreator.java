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

import pd.utils.Mappings.Mapping;
import pd.utils.*;
import java.util.*;
import java.text.DecimalFormat;
import org.yaml.snakeyaml.*;

final class HTMLCreator {

	private static DecimalFormat percentageFormat = new DecimalFormat("00%");

	public static String genSubmissionHtmlView(Submission s) {
		// output =>
		// "012345678901234567890123456789","012345  ","/////  LogName: u0800500","/////  FullName: Ang Shao Mei"
		StringBuilder sb = new StringBuilder(s.getCodeLength() << 1);

		ArrayList<String> lines = s.getCombinedCode();

		boolean start = true;

		for (String line : lines) {
			if (!start) {
				sb.append(",");
			}
			sb.append("'");

			char[] chars = line.toCharArray();
			for (char c : chars) {
				if (c == '\'') {
					sb.append("\\\'");
				} else {
					sb.append(c);
				}
			}

			sb.append("'");
			start = false;
		}

		return sb.toString();
	}

	public static String genSubmissionInYAML(Submission s) {
		ArrayList<String> lines = s.getCombinedCode();
    Yaml yaml = new Yaml();

		return yaml.dump(lines);
	}

	// public static String genMappingView(DBResult dbr) {
	public static String genMappingView(Result result) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html><body>");
		sb.append("<table id='maptable' border='1' align='center' style='table-layout:fixed' width='350'><col width=100><col width=100><col width=150>");
		sb.append("<tr>");
		sb.append("<th>");
		sb.append(result.getS1().getID().replaceAll("\"", "&quot;")
				.replaceAll("'", "&#39;"));
		sb.append(" (");
		sb.append(percentageFormat.format(result.getSim1To2()));
		sb.append(")");
		sb.append("</th>");
		sb.append("<th>");
		sb.append(result.getS2().getID().replaceAll("\"", "&quot;")
				.replaceAll("'", "&#39;"));
		sb.append(" (");
		sb.append(percentageFormat.format(result.getSim2To1()));
		sb.append(")");
		sb.append("</th>");
		sb.append("<th>Statement Matched</th>");
		sb.append("</tr>");

		ArrayList<Mapping> mappings = result.getCodeIndexMappings();
		String onClick;
		for (Mapping m : mappings) {

			onClick = "parent.setLeftText(" + m.getStartIndex1() + ","
					+ m.getEndIndex1() + ");parent.setRightText("
					+ m.getStartIndex2() + "," + m.getEndIndex2()
					+ "); return false;";

			sb.append("<tr>");
			sb.append("<td align='center'>");

			sb.append("<a href='' onclick='");
			sb.append(onClick);
			sb.append("'>");

			sb.append(m.getStartLine1() + 1);
			sb.append(" - ");
			sb.append(m.getEndLine1() + 1);

			sb.append("</a>");

			sb.append("</td>");
			sb.append("<td align='center'>");

			sb.append("<a href='' onclick='");
			sb.append(onClick);
			sb.append("'>");

			sb.append(m.getStartLine2() + 1);
			sb.append(" - ");
			sb.append(m.getEndLine2() + 1);
			sb.append("</a>");
			sb.append("</td>");

			sb.append("<td align='center'>");
			sb.append(m.getMappedCountableStmtCount());
			sb.append("</td>");

			sb.append("</tr>");
		}
		sb.append("</table>");
		sb.append("</body></html>");
		return sb.toString();
	}
}
