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
import java.util.*;
import java.sql.*;

public final class PointManager {

	private static final String SQL_QUERY = "SELECT submission1_id, submission2_id FROM submission_similarities WHERE assignment_id = ? AND similarity >= ?";
	private Connection con;

	public PointManager() {
	}

	public SetOfPoints retrievePoints(int assignmentId, float limit)
			throws Exception {
		connectDB();
		SetOfPoints sop = constructPoints(assignmentId, limit);
		disconnectDB();
		return sop;
	}

	private SetOfPoints constructPoints(int assignmentId, float limit)
			throws Exception {

		HashMap<Integer, Point> pointDB = new HashMap<Integer, Point>();

		PreparedStatement stmt = con.prepareStatement(SQL_QUERY);
		stmt.setInt(1, assignmentId);
		stmt.setFloat(2, limit);

		ResultSet rs = stmt.executeQuery();
		SetOfPoints sop = new SetOfPoints();

		int s1Id, s2Id;

		while (rs.next()) {
			// asr.id1, asr.id2
			s1Id = rs.getInt(1);
			s2Id = rs.getInt(2);

			Point p1, p2;

			if (pointDB.containsKey(s1Id)) {
				p1 = pointDB.get(s1Id);
			} else {
				p1 = new Point(s1Id);
				pointDB.put(s1Id, p1);
				sop.append(p1);
			}

			if (pointDB.containsKey(s2Id)) {
				p2 = pointDB.get(s2Id);
			} else {
				p2 = new Point(s2Id);
				pointDB.put(s2Id, p2);
				sop.append(p2);
			}

			p1.getEpsNeighbour().append(p2);
			p2.getEpsNeighbour().append(p1);
		}
		return sop;
	}

	private void connectDB() throws Exception {
		Class.forName(MySQLDB.JDBC_DRIVER);
		con = DriverManager.getConnection(MySQLDB.MYSQL_URL, MySQLDB.USER_ID,
				MySQLDB.USER_PASSWORD);
	}

	private void disconnectDB() throws Exception {
		if (!con.getAutoCommit()) {
			con.commit();
		}
		con.close();
	}
}
