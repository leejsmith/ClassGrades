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

	public static ResultSet select(int id, boolean isStudent) throws SQLException {
		String SQL;

		if (isStudent) {
			SQL = "SELECT * FROM tbl_StudentCourse WHERE studentID=" + id;
		} else {
			SQL = "SELECT * FROM tbl_StudentCourse WHERE courseID=" + id;
		}

		ResultSet studentsRS = null;

		query = Database.getConnection().createStatement();
		query.close();
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
		query.close();
		return ret;

	}
}
