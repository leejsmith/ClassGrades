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

	public static ResultSet select() {
		ResultSet ret = null;
		try {
			query = Database.getConnection().createStatement();
			String sql = "SELECT * FROM tbl_StudentSen";
			ret = query.executeQuery(sql);
			query.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet select(int student) {
		ResultSet ret = null;
		try {
			query = Database.getConnection().createStatement();
			String sql = "SELECT * FROM tbl_StudentSen WHERE studentID=" + student;
			ret = query.executeQuery(sql);
			query.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean insert(int student, int sen) {
		boolean ret = false;
		try {
			query = Database.getConnection().createStatement();
			String sql = "INSERT INTO tbl_StudentSen (studentID, senID) VALUES (" + student + "," + sen + ");";
			ret = query.execute(sql);
			query.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static boolean delete(int id, boolean isStudent) {
		boolean ret = false;
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
}
