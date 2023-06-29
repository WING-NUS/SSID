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
 
package pd.utils;

public class LineReader {

	private String string;
	private int lPos = 0, gPos;

	public LineReader(String string, int gPos) {
		this.string = string;
		this.gPos = gPos;
	}

	public int peek() {
		if (lPos == string.length())
			return -1;
		return string.charAt(lPos);
	}

	public int read() {
		if (lPos == string.length())
			return -1;
		gPos++;
		return string.charAt(lPos++);
	}

	public void moveEnd() {
		gPos += string.length() - lPos;
		lPos = string.length();
	}

	public int getGPos() {
		return gPos;
	}
}
