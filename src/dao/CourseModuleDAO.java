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
public class CourseModuleDAO {

	private static Statement query;

	public static ResultSet select() throws SQLException {
		ResultSet ret;
		String sql = "SELECT * FROM tbl_CourseModule";
		query = Database.getConnection().createStatement();
		ret = query.executeQuery(sql);

		return ret;
	}

	public static ResultSet select(int id, boolean isCourse) throws SQLException {
		query = Database.getConnection().createStatement();
		ResultSet ret = null;
		String sql;
		if (isCourse) {
			sql = "SELECT moduleID FROM tbl_CourseModule WHERE courseID=" + id;
		} else {
			sql = "SELECT courseID FROM tbl_CourseModule WHERE moduleID=" + id;
		}
		ret = query.executeQuery(sql);

		return ret;
	}

	public static boolean insert(int course, int module) throws SQLException {
		boolean ret = false;
		String sql = "INSERT INTO tbl_CourseModule (courseID, moduleID) VALUES (" + course + "," + module + ");";
		query = Database.getConnection().createStatement();
		ret = query.execute(sql);

		return ret;
	}

	public static boolean delete(int id, boolean isCourse) throws SQLException {
		String sql = "";
		boolean ret = false;
		query = Database.getConnection().createStatement();
		if (isCourse) {
			sql = "DELETE FROM tbl_CourseModule WHERE courseID = " + id + "";
		} else {
			sql = "DELETE FROM tbl_CourseModule WHERE moduleID = " + id + "";
		}
		ret = query.execute(sql);
		return ret;

	}
}
