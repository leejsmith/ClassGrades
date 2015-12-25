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
public class StudentGroupDAO {

	private static Statement query;

	public static ResultSet select(int groupID) throws SQLException {
		String SQL = "SELECT studentID FROM tbl_StudentGroup WHERE groupID=" + groupID;
		ResultSet studentsRS = null;

		query = Database.getConnection().createStatement();
		studentsRS = query.executeQuery(SQL);
		query.close();

		return studentsRS;
	}

	public static boolean insert(int studentID, int groupID) throws SQLException {
		boolean retVal = false;

		query = Database.getConnection().createStatement();
		String sql = "INSERT INTO tbl_StudentGroup(groupID,studentID) VALUES (" + groupID + "," + studentID + ")";
		retVal = query.execute(sql);
		return retVal;
	}

	public static boolean delete(int id, boolean isStudent) throws SQLException {
		boolean ret = false;
		String sql = "";

		if (isStudent) {
			sql = "DELETE FROM tbl_StudentGroup WHERE studentID=" + id;
		} else {
			sql = "DELETE FROM tbl_StudentGroup WHERE groupID=" + id;
		}
		ret = query.execute(sql);
		return ret;
	}
}
