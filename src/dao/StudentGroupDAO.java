/**
 * 
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;
import controller.DatabaseQueryException;

/**
 * @author Lee John Smith
 *
 */
public class StudentGroupDAO {

	private static Statement query;

	public static ResultSet select(int groupID) {
		String SQL = "SELECT studentID FROM tbl_StudentGroup WHERE groupID=" + groupID;
		ResultSet studentsRS = null;
		try {
			query = Database.getConnection().createStatement();
			studentsRS = query.executeQuery(SQL);
			query.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return studentsRS;
	}

	public static boolean insert(int studentID, int groupID) {
		boolean retVal = false;

		try {
			query = Database.getConnection().createStatement();

			String sql = "";

			sql = "INSERT INTO tbl_StudentGroup(groupID,studentID) VALUES (" + groupID + "," + studentID + ")";
			retVal = query.execute(sql);
			if (!retVal) {
				throw new DatabaseQueryException("ERROR inserting new students into groups");
			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (DatabaseQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retVal;
	}

	public static boolean delete(int id, boolean isStudent) {
		String sql = "";
		if (isStudent) {
			sql = "DELETE FROM tbl_StudentGroup WHERE studentID=" + id;
		}
		else {
			sql = "DELETE FROM tbl_StudentGroup WHERE groupID=" + id;
		}
		try {
			if (!query.execute(sql)) {
				throw new DatabaseQueryException("ERROR removing group - students");
			}
			return true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (DatabaseQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
}
