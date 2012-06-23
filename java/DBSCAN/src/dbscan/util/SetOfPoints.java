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

import java.util.HashSet;
import java.util.LinkedList;

public class SetOfPoints extends LinkedList<Point> {

	private static final long serialVersionUID = 3803617230532724490L;
	private HashSet<Point> hashSet = new HashSet<Point>();

	// private ArrayList<Point> list = new ArrayList<Point>();

	/**
	 * Returns the Eps-Neighbourhood of target in this PointSet as a PointSet
	 * 
	 * @param target
	 *            The target point
	 * @return A new PointSet containing the Eps-Neighbourhood of target in this
	 *         PointSet
	 */
	public SetOfPoints regionQuery(Point target) {
		SetOfPoints result = new SetOfPoints();

		LinkedList<Point> targetEpsNeighbours = target.getEpsNeighbour()
				.getPoints();

		for (Point p : targetEpsNeighbours) {
			if (hashSet.contains(p)) {
				result.append(p);
			}
		}

		return result;
	}

	public static void changeClId(Point p, int clusterId) {
		p.setClusterId(clusterId);
	}

	public static void changeClIds(SetOfPoints seeds, int clusterId) {
		for (Point p : seeds) {
			changeClId(p, clusterId);
		}
	}

	public boolean append(Point p) {
		if (hashSet.contains(p)) {
			return false;
		}
		hashSet.add(p);
		add(p);
		return true;
	}

	public boolean delete(Point p) {
		if (hashSet.contains(p)) {
			hashSet.remove(p);
			remove(p);
			return true;
		}
		return false;
	}

	public Point first() throws IndexOutOfBoundsException {
		return get(0);
	}

	public boolean contains(Point p) {
		return hashSet.contains(p);
	}

	private LinkedList<Point> getPoints() {
		return new LinkedList<Point>(this);
	}
}
