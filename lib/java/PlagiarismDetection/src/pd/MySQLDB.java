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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MySQLDB {

	private static String USER_ID;
	private static String USER_PASSWORD;
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String MYSQL_URL;
	private static final String STUDENT_INSERT = "INSERT IGNORE INTO users(name, created_at, updated_at) VALUES (?, ?, ?)";
  private static final String STUDENT_MEMBERSHIP_INSERT = "INSERT INTO user_course_memberships(user_id, course_id, role, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
  private static final String STUDENT_MEMBERSHIP_SELECT = "SELECT id FROM user_course_memberships WHERE user_id = ? AND course_id = ? AND role = ?";
  private static final String COURSE_ID_SELECT = "SELECT course_id FROM assignments WHERE id = ?";
	private static final String STUDENT_SELECT = "SELECT id FROM users WHERE name = ?";
	private static final String RESULT_INSERT = "INSERT INTO submission_similarities(assignment_id, submission1_id, submission2_id, similarity_1_to_2, similarity_2_to_1, similarity, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String CODE_INSERT = "INSERT INTO submissions(`lines`, assignment_id, student_id, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
	private static final String MAPPING_INSERT = "INSERT INTO submission_similarity_mappings(id, submission_similarity_id, start_index1, end_index1, start_index2, end_index2, start_line1, end_line1, start_line2, end_line2, statement_count, is_plagiarism, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String MAPPING_MAX_ID_SELECT = "SELECT max(id) FROM submission_similarity_mappings";
	private static final String SKELETON_MAPPING_INSERT = "INSERT INTO submission_similarity_skeleton_mappings(submission_similarity_mapping_id, start_line1, end_line1, start_line2, end_line2, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final int BATCH_SIZE = 65536; 
	
	private static Logger logger = LogManager.getLogger();
	private static MySQLDB instance = new MySQLDB();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Connection con;
	private HashMap<String, Integer> submissionDBIds = new HashMap<String, Integer>();

    public static void setProperties(String dbAddr, String dbName, String user, String pwd) {    	
    	USER_ID = user;
    	USER_PASSWORD = pwd;
    	MYSQL_URL = "jdbc:mysql://" + dbAddr + ":3306/" + dbName + "?rewriteBatchedStatements=true";
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
			insertHTMLs(aId, submissions);
			insertResults(aId, results);
		} catch (Exception ex) {
			con.rollback();
			throw ex;
		}
		disconnectionDB();
	}

	private void insertHTMLs(String aIdString, ArrayList<Submission> submissions)
			throws Exception {
		String dateTime = dateFormat.format(new java.util.Date());

		HashMap<String, Integer> students = new HashMap<String, Integer>();

    // Find course id
		PreparedStatement stmt = con.prepareStatement(COURSE_ID_SELECT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		stmt.setString(1, aIdString);
		ResultSet rs = stmt.executeQuery();
		rs.first();
		int courseId = rs.getInt(1);
		rs.close();
		stmt.close();

		for (Submission s : submissions) {
			if (s.isSkeletonCode()) {
				continue;
			}
			students.put(s.getID(), insertStudent(s.getID(), courseId));
		}

		stmt = con.prepareStatement(CODE_INSERT,
				Statement.RETURN_GENERATED_KEYS);
		for (Submission s : submissions) {
			if (s.isSkeletonCode()) {
				continue;
			}
			stmt.setString(1, HTMLCreator.genSubmissionInYAML(s));
			stmt.setString(2, aIdString);
			stmt.setInt(3, students.get(s.getID()));
			stmt.setString(4, dateTime);
			stmt.setString(5, dateTime);
			stmt.addBatch();
		}

		stmt.executeBatch();
		rs = stmt.getGeneratedKeys();

		int dbId;

		for (Submission s : submissions) {
			if (s.isSkeletonCode()) {
				continue;
			}
			rs.next();
			dbId = rs.getInt(1);
			submissionDBIds.put(s.getID(), dbId);
		}
		rs.close();
		stmt.close();
	}

	private int insertStudent(String matric, int courseId) throws Exception {
		String dateTime = dateFormat.format(new java.util.Date());
		PreparedStatement stmt = null;
		ResultSet rs = null;

    // Find student in db
		stmt = con.prepareStatement(STUDENT_SELECT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		stmt.setString(1, matric);
		rs = stmt.executeQuery();
		int userId;
    
    // If no results, we need to insert student into the db
    if (rs.first() == false) {
      rs.close();
      stmt.close();
      try {
        stmt = con.prepareStatement(STUDENT_INSERT, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, matric);
        stmt.setString(2, dateTime);
        stmt.setString(3, dateTime);
        stmt.executeUpdate();
        rs = stmt.getGeneratedKeys();
        rs.first();
      } catch (Exception ex) {
        System.err.println(ex);
      } finally {
		userId = rs.getInt(1);
		rs.close();
		stmt.close();
	  }
    } else {
		// Get new or existing student id
		userId = rs.getInt(1);
		rs.close();
		stmt.close();
	}

    

    // Find course membership
    stmt = con.prepareStatement(STUDENT_MEMBERSHIP_SELECT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    stmt.setInt(1, userId);
    stmt.setInt(2, courseId);
    stmt.setInt(3, 2); // 2 = ROLE_STUDENT; See UserCourseMembership model file for details
    rs = stmt.executeQuery();

    // If no results, we need to create a membership row
    if (rs.isBeforeFirst() == false) {
      try {
        rs.close();
        stmt.close();
        stmt = con.prepareStatement(STUDENT_MEMBERSHIP_INSERT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        stmt.setInt(1, userId);
        stmt.setInt(2, courseId);
        stmt.setInt(3, 2); // 2 = ROLE_STUDENT; See UserCourseMembership model file for details
        stmt.setString(4, dateTime);
        stmt.setString(5, dateTime);
        stmt.execute();
      } catch (Exception ex) {
        System.err.println(ex);
      }
    }
    rs.close();
    stmt.close();

		return userId;
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

			// System.out.println("SQL query: " + stmt.toString());
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
		String dateTime = dateFormat.format(new java.util.Date());
		PreparedStatement stmt = con.prepareStatement(MAPPING_INSERT);
		PreparedStatement bMappingStatement = con.prepareStatement(SKELETON_MAPPING_INSERT);

		Iterator<Integer> idIterator = genIds.iterator();
		Iterator<Result> resultIterator = results.iterator();

		ArrayList<Mapping> mappings;
		long mappingId = getCurrentMaxMappingId();
		int submissionSimilarityId;;
		int count = 1;
		while (idIterator.hasNext() || resultIterator.hasNext()) {

			submissionSimilarityId = idIterator.next();
			mappings = resultIterator.next().getCodeIndexMappings();
			mappingId += 1;

			for (Mapping m : mappings) {
				if (count % BATCH_SIZE == 0) {
					processBatchInsert("MAPPING_INSERT", stmt, count);
					processBatchInsert("SKELETON_MAPPING_INSERT", bMappingStatement, count);
				}
				stmt.setLong(1, mappingId);
				stmt.setInt(2, submissionSimilarityId);
				stmt.setInt(3, m.getStartIndex1());
				stmt.setInt(4, m.getEndIndex1());
				stmt.setInt(5, m.getStartIndex2());
				stmt.setInt(6, m.getEndIndex2());
				stmt.setInt(7, m.getStartLine1());
				stmt.setInt(8, m.getEndLine1());
				stmt.setInt(9, m.getStartLine2());
				stmt.setInt(10, m.getEndLine2());
				stmt.setInt(11, m.getMappedCountableStmtCount());
				stmt.setBoolean(12, m.isPlagMapping());
        stmt.setString(13, dateTime);
        stmt.setString(14, dateTime);
				stmt.addBatch();

				// Update submissionSimilarityMappingId in skeleton mappings
				List<SkeletonMapping> skeletonMappings = m.getSkeletonMappings();
				if (skeletonMappings != null && skeletonMappings.size() > 0) {
					for (SkeletonMapping bMapping : skeletonMappings) {
						bMappingStatement.setLong(1, mappingId);
						bMappingStatement.setInt(2, bMapping.getStartLine1());
						bMappingStatement.setInt(3, bMapping.getEndLine1());
						bMappingStatement.setInt(4, bMapping.getStartLine2());
						bMappingStatement.setInt(5, bMapping.getEndLine2());
						bMappingStatement.setString(6, dateTime);
						bMappingStatement.setString(7, dateTime);

						bMappingStatement.addBatch();
					}	
				}

				mappingId += 1;
				count += 1;
			}
		}
		processBatchInsert("MAPPING_INSERT", stmt, count);
		stmt.close();

		processBatchInsert("SKELETON_MAPPING_INSERT", bMappingStatement, count);
		bMappingStatement.close();
	}

	private void processBatchInsert(String statementType, PreparedStatement statement, int count) throws Exception {
		int[] executionStatuses = statement.executeBatch();
		int round = (int) Math.round(count * 1.0 / BATCH_SIZE);
		for (int i = 0; i < executionStatuses.length; i++) {
			if (executionStatuses[i] == Statement.EXECUTE_FAILED) {
				logger.error("Failed to execute statement: type = {}, index = {}, round = {} ", statementType, i, round);
			}
		}
		statement.clearBatch();
	}

	private long getCurrentMaxMappingId() throws Exception {
		long maxMappingId = 1L;
		PreparedStatement statement = con.prepareStatement(MAPPING_MAX_ID_SELECT);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet != null && resultSet.next()) {
			maxMappingId = resultSet.getLong(1);
		}

		statement.close();
		return maxMappingId;
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
