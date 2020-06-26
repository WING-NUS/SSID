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

public class DBResult {
	private String s1Id, s2Id;
	private float sim1To2, sim2To1;
	private ArrayList<Mapping> map1To2;
	private ArrayList<Mapping> map2To1;

	public DBResult(String s1Id, String s2Id, float sim1To2,
			ArrayList<Mapping> map1To2) {
		this.s1Id = s1Id;
		this.s2Id = s2Id;
		this.sim1To2 = sim1To2;
		this.map1To2 = map1To2;
	}

	public String getS1Id() {
		return s1Id;
	}

	public String getS2Id() {
		return s2Id;
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

	public void setMap1To2(ArrayList<Mapping> map1To2) {
		this.map1To2 = map1To2;
	}

	public ArrayList<Mapping> getMap1To2() {
		return map1To2;
	}

	public void setMap2To1(ArrayList<Mapping> map2To1) {
		this.map2To1 = map2To1;
	}

	public ArrayList<Mapping> getMap2To1() {
		return map2To1;
	}
}
