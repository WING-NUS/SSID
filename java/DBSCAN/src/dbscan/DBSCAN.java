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
 
package dbscan;

import dbscan.util.*;

final class DBSCAN {

	public void buildClusters(SetOfPoints setOfPoints, int minPts) {
		int clusterId = nextId(Point.NOISE);

		for (Point point : setOfPoints) {
			if (point.getClusterId() == Point.UNCLASSIFIED) {
				if (expandCluster(setOfPoints, point, clusterId, minPts))
					clusterId = nextId(clusterId);
			}
		}
	}

	private boolean expandCluster(SetOfPoints setOfPoints, Point point,
			int clusterId, int minPts) {

		SetOfPoints seeds = setOfPoints.regionQuery(point);

		if (seeds.size() < minPts) { // no core point
			SetOfPoints.changeClId(point, Point.NOISE);
			return false;
		}

		// All points in seeds are density-reachable from Point
		SetOfPoints.changeClIds(seeds, clusterId);
		seeds.delete(point);

		Point currentP;// , resultP;
		SetOfPoints result;
		while (seeds.size() > 0) {
			currentP = seeds.first();
			result = setOfPoints.regionQuery(currentP);

			if (result.size() >= minPts) {
				for (Point resultP : result) {
					int resultPClId = resultP.getClusterId();
					if (resultPClId == Point.UNCLASSIFIED
							|| resultPClId == Point.NOISE) {
						if (resultPClId == Point.UNCLASSIFIED) {
							seeds.append(resultP);
						}
						SetOfPoints.changeClId(resultP, clusterId);
					} // UNCLASSIFIED OR NOISE
				}
			} // result.size >= MinPts
			seeds.delete(currentP);
		} // seeds != Empty

		return true;
	}

	private int nextId(int id) {
		return id + 1;
	}
}
