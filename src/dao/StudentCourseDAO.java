/**
 * 
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;

/**
 * @author Lee John Smith
 *
 */
public class StudentCourseDAO {

	private static Statement query;

	public static ResultSet select() {
		String sql = "";
		ResultSet studentRS = null;
		try {
			query = Database.getConnection().createStatement();
			sql = "SELECT * FROM tbl_StudentCourse";

			studentRS = query.executeQuery(sql);
			return studentRS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentRS;
	}

	public static ResultSet select(int id, boolean isStudent) throws SQLException {
		String sql;

		if (isStudent) {
			sql = "SELECT * FROM tbl_StudentCourse WHERE studentID=" + id;
		} else {
			sql = "SELECT * FROM tbl_StudentCourse WHERE courseID=" + id;
		}

		ResultSet studentsRS = null;

		query = Database.getConnection().createStatement();

		studentsRS = query.executeQuery(sql);

		return studentsRS;
	}

	public static boolean insert(int studentID, int courseID, int target) throws SQLException {
		boolean retVal = false;

		query = Database.getConnection().createStatement();
		String sql = "INSERT INTO tbl_StudentCourse(courseID,studentID, targetGrade) VALUES (" + courseID + ","
				+ studentID + "," + target + ")";
		retVal = query.execute(sql);
		return retVal;

	}

	public static boolean delete(int id, boolean isStudent) throws SQLException {
		boolean ret = false;
		String sql = "";

		if (isStudent) {
			sql = "DELETE FROM tbl_StudentCourse WHERE studentID=" + id;
		} else {
			sql = "DELETE FROM tbl_StudentCourse WHERE courseID=" + id;
		}
		ret = query.execute(sql);

		return ret;

	}
}
