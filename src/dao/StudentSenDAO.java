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
public class StudentSenDAO {

	private static Statement query;

	public static ResultSet select() throws SQLException {
		ResultSet ret = null;
		query = Database.getConnection().createStatement();
		String sql = "SELECT * FROM tbl_StudentSen";
		ret = query.executeQuery(sql);
		query.close();
		return ret;
	}

	public static ResultSet select(int student) throws SQLException {
		ResultSet ret = null;

		query = Database.getConnection().createStatement();
		String sql = "SELECT * FROM tbl_StudentSen WHERE studentID=" + student;
		ret = query.executeQuery(sql);
		query.close();
		return ret;

	}

	public static boolean insert(int student, int sen) throws SQLException {
		boolean ret = false;
		query = Database.getConnection().createStatement();
		String sql = "INSERT INTO tbl_StudentSen (studentID, senID) VALUES (" + student + "," + sen + ");";
		ret = query.execute(sql);
		query.close();
		return ret;
	}

	public static boolean delete(int id, boolean isStudent) throws SQLException {
		boolean ret = false;
		query = Database.getConnection().createStatement();
		String sql;
		if (isStudent) {
			sql = "DELETE FROM tbl_StudentSen WHERE studentID=" + id;
		} else {
			sql = "DELETE FROM tbl_StudentSen WHERE senID=" + id;
		}
		ret = query.execute(sql);
		query.close();
		return ret;

	}
}
