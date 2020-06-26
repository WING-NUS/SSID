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

package dbscan.util;

public class Point {

	public static final int UNCLASSIFIED = -2;
	public static final int NOISE = -1;
	private int pointId;
	private SetOfPoints epsNeighbour = new SetOfPoints();
	private int clusterId = UNCLASSIFIED;

	public Point(int pointId) {
		this.pointId = pointId;
	}

	public int getId() {
		return pointId;
	}

	public SetOfPoints getEpsNeighbour() {
		return epsNeighbour;
	}

	public int getClusterId() {
		return clusterId;
	}

	public void setClusterId(int id) {
		this.clusterId = id;
	}

	@Override
	public int hashCode() {
		return pointId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;

		return ((Point) obj).pointId == pointId;
	}
}
