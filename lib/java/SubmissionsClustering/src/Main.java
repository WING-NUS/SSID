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
import dbscan.util.*;
import dbscan.*;

public class Main {

	private static final int MIN_PTS = 1;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws Exception {
		// args[0] = assignemnt id, asgs[1] = clustering id, args[2] = limit
		// TODO code application logic here
		if (args.length != 7) {
			throw new Exception(
					"Usage: SubmissionsClustering <assignment id> <clustering id> <limit> <database host> <database name> <database username> <database password>");
		}

		try {

			int aId = Integer.parseInt(args[0]);
			int cId = Integer.parseInt(args[1]);
			float limit = Float.parseFloat(args[2]);
			String dbAddr = args[3];
			String dbName = args[4];
			String dbUser = args[5];
			String dbPwd = args[6];

			MySQLDB.setProperties(dbAddr, dbName, dbUser, dbPwd);

			PointManager pm = new PointManager();

			SetOfPoints setOfPoints = pm.retrievePoints(aId, limit);
			DBSCAN dbscan = new DBSCAN();
			dbscan.buildClusters(setOfPoints, MIN_PTS);

			MySQLDB.insertIntoDB(cId, limit, setOfPoints);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}
}
