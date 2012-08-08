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

final class MySQLDB {

	static String USER_ID;
	static String USER_PASSWORD;
	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String MYSQL_URL;
	private static final String INSERT_CLUSTERS_QUERY = "INSERT INTO assignment_clusters(assignment_clustering_id, created_at, updated_at) VALUES (?, ?, ?)";
	private static final String INSERT_CLUSTER_MEMBERS_QUERY = "INSERT INTO assignment_cluster_members(assignment_cluster_id, assignment_code_id, created_at, updated_at) VALUES ";
	private static final String COMMA = ",";
	private static final String OPEN_BRACKET = "(";
	private static final String CLOSE_BRACKET = ")";
	private static final String QUOT = "'";

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

		int clusterId;
		ArrayList<Integer> codeIds;
		Set<Map.Entry<Integer, ArrayList<Integer>>> clusterSet = clusters
				.entrySet();

		Statement stmt;
		ArrayList<String> values = new ArrayList<String>();

		for (Map.Entry<Integer, ArrayList<Integer>> entry : clusterSet) {
			codeIds = entry.getValue();
			clusterId = insertCluster(con, clusteringId, dateTime);
			values.add(prepareQuery(clusterId, codeIds, dateTime));
		}

		if (values.size() > 0) {
			StringBuilder sb = new StringBuilder(INSERT_CLUSTER_MEMBERS_QUERY);
			boolean start = true;
			for (String value : values) {
				if (start) {
					start = false;
				} else {
					sb.append(COMMA);
				}
				sb.append(value);
			}
			stmt = con.createStatement();
			stmt.execute(sb.toString());
		}
	}

	private static String prepareQuery(int clusterId,
			ArrayList<Integer> codeIds, String dateTime) throws Exception {
		StringBuilder sb = new StringBuilder();

		boolean start = true;
		for (Integer i : codeIds) {
			if (start) {
				start = false;
			} else {
				sb.append(COMMA);
			}
			sb.append(OPEN_BRACKET);
			sb.append(clusterId);
			sb.append(COMMA);
			sb.append(i);
			sb.append(COMMA);
			sb.append(QUOT);
			sb.append(dateTime);
			sb.append(QUOT);
			sb.append(COMMA);
			sb.append(QUOT);
			sb.append(dateTime);
			sb.append(QUOT);
			sb.append(CLOSE_BRACKET);
		}
		return sb.toString();
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
