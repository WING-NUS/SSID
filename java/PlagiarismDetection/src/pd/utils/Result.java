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

import pd.utils.Mappings.Mapping;
import java.util.ArrayList;

public final class Result {

	private Submission s1, s2;
	private float sim1To2, sim2To1;
	private ArrayList<Mapping> codeIndexMappings;
	private ArrayList<Mapping> tokenIndexMappings;

	// public Result reverseMappings() {
	//
	// ArrayList<Mapping> tokenMappings = new
	// ArrayList<Mapping>(tokenIndexMappings.size()),
	// codeMappings = new ArrayList<Mapping>(codeIndexMappings.size());
	//
	// for (Mapping m : tokenIndexMappings) {
	// tokenMappings.add(m.reverseMapping());
	// }
	// for (Mapping m : codeIndexMappings) {
	// codeMappings.add(m.reverseMapping());
	// }
	//
	// return new Result(s2, s1, sim2To1, sim1To2, codeMappings, tokenMappings);
	// }

	public Submission getS1() {
		return s1;
	}

	public Submission getS2() {
		return s2;
	}

	public float getSim1To2() {
		return sim1To2;
	}

	public float getSim2To1() {
		return sim2To1;
	}

	public void setSim1To2(float sim1To2) {
		this.sim1To2 = sim1To2;
	}

	public void setSim2To1(float sim2To1) {
		this.sim2To1 = sim2To1;
	}

	public ArrayList<Mapping> getTokenIndexMappings() {
		return tokenIndexMappings;
	}

	public ArrayList<Mapping> getCodeIndexMappings() {
		return codeIndexMappings;
	}

	public Result(Submission s1, Submission s2) {
		this(s1, s2, new ArrayList<Mapping>(), new ArrayList<Mapping>());
	}

	public Result(Submission s1, Submission s2,
			ArrayList<Mapping> codeIndexMappings,
			ArrayList<Mapping> tokenIndexMappings) {
		this(s1, s2, 0F, 0F, codeIndexMappings, tokenIndexMappings);
	}

	public Result(Submission s1, Submission s2, float sim1To2, float sim2To1,
			ArrayList<Mapping> codeIndexMappings,
			ArrayList<Mapping> tokenIndexMappings) {
		this.s1 = s1;
		this.s2 = s2;
		this.sim1To2 = sim1To2;
		this.sim2To1 = sim2To1;
		this.codeIndexMappings = codeIndexMappings;
		this.tokenIndexMappings = tokenIndexMappings;
	}
}
