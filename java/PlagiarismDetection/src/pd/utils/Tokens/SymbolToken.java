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
 
package pd.utils.Tokens;

public final class SymbolToken extends Token {

	private String value;

	public SymbolToken(String value, int startLoc, int endLoc, int line,
			boolean startOfStatement, EndOfStatementType endOfStatement) {
		super(startLoc, endLoc, line, startOfStatement, endOfStatement);
		this.value = value;
		reg = getReg(value);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return obj != null && getClass() == obj.getClass()
				&& reg == ((SymbolToken) obj).reg;
	}

	@Override
	public String toString() {
		return value;
	}
}
