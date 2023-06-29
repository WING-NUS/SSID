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
import java.sql.*;
import java.util.*;
import java.text.*;

public final class MySQLDB {

	static String USER_ID;
	static String USER_PASSWORD;
	static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static String MYSQL_URL;
	private static final String INSERT_CLUSTERS_QUERY = "INSERT INTO submission_clusters(submission_cluster_group_id, created_at, updated_at) VALUES (?, ?, ?)";
	private static final String INSERT_CLUSTER_MEMBERS_QUERY = "INSERT INTO submission_cluster_memberships(submission_cluster_id, submission_id, created_at, updated_at) VALUES (?, ?, ?, ?)";

	public static void setProperties(String dbAddr, String dbName, String user,
			String pwd) {
		USER_ID = user;
		USER_PASSWORD = pwd;
		MYSQL_URL = "jdbc:mysql://" + dbAddr + ":3306/" + dbName;
	}

	public static void insertIntoDB(int clusteringId, float limit,
			SetOfPoints sop) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = dateFormat.format(new java.util.Date());
		Connection con = connectDB();
		insertClusters(con, clusteringId, sop, dateTime);
		disconnectDB(con);
	}

	private static void insertClusters(Connection con, int clusteringId,
			SetOfPoints sop, String dateTime) throws Exception {
		Hashtable<Integer, ArrayList<Integer>> clusters = buildDBClusters(sop);
		Set<Map.Entry<Integer, ArrayList<Integer>>> clusterSet = clusters
				.entrySet();

    if (clusterSet.size() > 0) {
      PreparedStatement stmt = con.prepareStatement(INSERT_CLUSTER_MEMBERS_QUERY);
      for (Map.Entry<Integer, ArrayList<Integer>> entry : clusterSet) {
        ArrayList<Integer> codeIds = entry.getValue();
        int clusterId = insertCluster(con, clusteringId, dateTime);

        for (Integer codeId : codeIds) {
          stmt.setInt(1, clusterId);
          stmt.setInt(2, codeId.intValue());
          stmt.setString(3, dateTime);
          stmt.setString(4, dateTime);
          stmt.addBatch();
        }
      }
      stmt.executeBatch();
      stmt.close();
    }
	}

	private static Hashtable<Integer, ArrayList<Integer>> buildDBClusters(
			SetOfPoints sop) throws Exception {
		Hashtable<Integer, ArrayList<Integer>> clusters = new Hashtable<Integer, ArrayList<Integer>>();

		// Point p;
		int clusterId;
		ArrayList<Integer> pointIds;
		for (Point p : sop) {
			clusterId = p.getClusterId();
			if (clusterId >= 0) {
				if (clusters.containsKey(clusterId)) {
					pointIds = clusters.get(clusterId);
				} else {
					pointIds = new ArrayList<Integer>();
					clusters.put(clusterId, pointIds);
				}
				pointIds.add(p.getId());
			}
		}
		return clusters;
	}

	private static int insertCluster(Connection con, int clustering_id,
			String dateTime) throws Exception {
		PreparedStatement stmt = con.prepareStatement(INSERT_CLUSTERS_QUERY,
				Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, clustering_id);
		stmt.setString(2, dateTime);
		stmt.setString(3, dateTime);
		stmt.execute();

		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		return rs.getInt(1);
	}

	private static Connection connectDB() throws Exception {
		Class.forName(MySQLDB.JDBC_DRIVER);
		return DriverManager.getConnection(MySQLDB.MYSQL_URL, MySQLDB.USER_ID,
				MySQLDB.USER_PASSWORD);
	}

	private static void disconnectDB(Connection con) throws Exception {
		if (!con.getAutoCommit()) {
			con.commit();
		}
		con.close();
	}
}
