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
 
 package pd;

import java.util.*;
import pd.utils.*;
import pd.utils.Mappings.*;
import java.sql.*;
import java.text.*;

public final class MySQLDB {

	private static String USER_ID;
	private static String USER_PASSWORD;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String MYSQL_URL;
	private static final String STUDENT_INSERT = "INSERT IGNORE INTO students(matric) VALUES (?)";
	private static final String STUDENT_SELECT = "SELECT id FROM students WHERE matric = ?";
	private static final String RESULT_INSERT = "INSERT INTO assignment_sim_results(assignment_id, id1, id2, sim1To2, sim2To1, sim, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String CODE_INSERT = "INSERT INTO assignment_codes(student_id, code_line, code_array, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
	private static final String MAPPING_INSERT = "INSERT INTO sim_mappings(result_id, startIndex1, endIndex1, startIndex2, endIndex2, startLine1, endLine1, startLine2, endLine2, stmtMappedCount, isPlagMapping) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static MySQLDB instance = new MySQLDB();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Connection con;
	private HashMap<String, Integer> submissionDBIds = new HashMap<String, Integer>();

    public static void setProperties(String dbAddr, String dbName, String user, String pwd) {    	
    	USER_ID = user;
    	USER_PASSWORD = pwd;
    	MYSQL_URL = "jdbc:mysql://" + dbAddr + ":3306/" + dbName;
    }
	
	public static MySQLDB getMySQLDB() {
		return instance;
	}

	private MySQLDB() {
	}

	public void insertIntoDB(String aId, ArrayList<Submission> submissions,
			ArrayList<Result> results) throws Exception {
		if (results.size() == 0) {
			return;
		}

		connectionDB();
		try {
			insertHTMLs(submissions);
			insertResults(aId, results);
		} catch (Exception ex) {
			con.rollback();
			throw ex;
		}
		disconnectionDB();
	}

	private void insertHTMLs(ArrayList<Submission> submissions)
			throws Exception {
		String dateTime = dateFormat.format(new java.util.Date());

		HashMap<String, Integer> students = new HashMap<String, Integer>();

		for (Submission s : submissions) {
			if (s.isBaseline()) {
				continue;
			}
			students.put(s.getID(), insertStudent(s.getID()));
		}

		PreparedStatement stmt = con.prepareStatement(CODE_INSERT,
				Statement.RETURN_GENERATED_KEYS);
		for (Submission s : submissions) {
			if (s.isBaseline()) {
				continue;
			}
			stmt.setInt(1, students.get(s.getID()));
			stmt.setInt(2, s.getCodeTotalLine());
			stmt.setString(3, HTMLCreator.genSubmissionHtmlView(s));
			stmt.setString(4, dateTime);
			stmt.setString(5, dateTime);
			stmt.addBatch();
		}

		stmt.executeBatch();
		ResultSet rs = stmt.getGeneratedKeys();

		int dbId;

		for (Submission s : submissions) {
			if (s.isBaseline()) {
				continue;
			}
			rs.next();
			dbId = rs.getInt(1);
			submissionDBIds.put(s.getID(), dbId);
		}
		rs.close();
		stmt.close();
	}

	private int insertStudent(String matric) throws Exception {

		PreparedStatement stmt = con.prepareStatement(STUDENT_INSERT);
		stmt.setString(1, matric);

		stmt.execute();
		stmt.close();

		stmt = con.prepareStatement(STUDENT_SELECT);
		stmt.setString(1, matric);

		ResultSet rs = stmt.executeQuery();

		rs.next();
		int reply = rs.getInt(1);
		rs.close();
		stmt.close();

		return reply;
	}

	private void insertResults(String aIdString, ArrayList<Result> results)
			throws Exception {
		String dateTime = dateFormat.format(new java.util.Date());
		int aId = Integer.parseInt(aIdString);
		PreparedStatement stmt = con.prepareStatement(RESULT_INSERT,
				Statement.RETURN_GENERATED_KEYS);

		float sim1To2, sim2To1;

		for (Result result : results) {
			// (assignment_id, id1, id2, headFrame, sim1To2, sim2To1,
			// created_at, updated_at)
			stmt.setInt(1, aId);
			stmt.setInt(2, submissionDBIds.get(result.getS1().getID()));

			stmt.setInt(3, submissionDBIds.get(result.getS2().getID()));

			sim1To2 = result.getSim1To2() * 100;
			sim2To1 = result.getSim2To1() * 100;

			stmt.setFloat(4, sim1To2);
			stmt.setFloat(5, sim2To1);
			stmt.setFloat(6, Math.max(sim1To2, sim2To1));
			stmt.setString(7, dateTime);
			stmt.setString(8, dateTime);
			stmt.addBatch();
		}
		stmt.executeBatch();

		ResultSet rs = stmt.getGeneratedKeys();
		LinkedList<Integer> genIds = new LinkedList<Integer>();

		while (rs.next()) {
			genIds.add(rs.getInt(1));
		}

		stmt.close();

		insertMappings(genIds, results);
	}

	private void insertMappings(LinkedList<Integer> genIds,
			ArrayList<Result> results) throws Exception {
		PreparedStatement stmt = con.prepareStatement(MAPPING_INSERT);

		Iterator<Integer> idIterator = genIds.iterator();
		Iterator<Result> resultIterator = results.iterator();

		ArrayList<Mapping> mappings;
		int id;
		while (idIterator.hasNext() || resultIterator.hasNext()) {

			id = idIterator.next();
			mappings = resultIterator.next().getCodeIndexMappings();

			for (Mapping m : mappings) {
				stmt.setInt(1, id);
				stmt.setInt(2, m.getStartIndex1());
				stmt.setInt(3, m.getEndIndex1());
				stmt.setInt(4, m.getStartIndex2());
				stmt.setInt(5, m.getEndIndex2());
				stmt.setInt(6, m.getStartLine1());
				stmt.setInt(7, m.getEndLine1());
				stmt.setInt(8, m.getStartLine2());
				stmt.setInt(9, m.getEndLine2());
				stmt.setInt(10, m.getMappedCountableStmtCount());
				stmt.setBoolean(11, m.isPlagMapping());
				stmt.addBatch();
			}
		}
		stmt.executeBatch();
		stmt.close();
	}

	private void connectionDB() throws Exception {
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(MYSQL_URL, USER_ID, USER_PASSWORD);
		con.setAutoCommit(false);
	}

	private void disconnectionDB() throws Exception {
		if (!con.getAutoCommit()) {
			con.commit();
		}
		con.close();
	}
}
