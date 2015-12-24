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

	public static ResultSet select(int courseID) {
		String SQL = "SELECT studentID FROM tbl_StudentCourse WHERE courseID=" + courseID;
		ResultSet studentsRS = null;
		try {
			query = Database.getConnection().createStatement();
			studentsRS = query.executeQuery(SQL);
			query.close();
			return studentsRS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentsRS;
	}

	public static boolean insert(int studentID, int courseID) {
		boolean retVal = false;
		try {
			query = Database.getConnection().createStatement();
			String sql = "INSERT INTO tbl_StudentCourse(courseID,studentID) VALUES (" + courseID + "," + studentID
					+ ")";
			retVal = query.execute(sql);
			return retVal;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}

	public static boolean delete(int id, boolean isStudent) {
		boolean ret = false;
		String sql = "";
		try {
			if (isStudent) {
				sql = "DELETE FROM tbl_StudentCourse WHERE studentID=" + id;
			} else {
				sql = "DELETE FROM tbl_StudentCourse WHERE courseID=" + id;
			}
			ret = query.execute(sql);
			query.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
