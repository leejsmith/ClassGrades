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
public class CourseGroupDAO {

	private static Statement query;

	public static ResultSet select() throws SQLException {
		ResultSet ret;
		String sql = "SELECT * FROM tbl_CourseGroup";
		query = Database.getConnection().createStatement();
		ret = query.executeQuery(sql);
		query.close();
		return ret;
	}

	public static ResultSet select(int id, boolean isCourse) throws SQLException {
		ResultSet ret = null;
		String sql;
		if (isCourse) {
			sql = "SELECT groupID FROM tbl_CourseGroup WHERE courseID=" + id;
		} else {
			sql = "SELECT courseID FROM tbl_CourseGroup WHERE groupID=" + id;
		}
		ret = query.executeQuery(sql);
		query.close();
		return ret;
	}

	public static boolean insert(int course, int group) throws SQLException {
		boolean ret = false;
		String sql = "INSERT INTO tbl_CourseGroup (courseID, groupID) VALUES (" + course + "," + group + ");";
		query = Database.getConnection().createStatement();
		ret = query.execute(sql);
		query.close();
		return ret;
	}

	public static boolean delete(int id, boolean isCourse) throws SQLException {
		String sql = "";
		boolean ret = false;
		query = Database.getConnection().createStatement();
		if (isCourse) {
			sql = "DELETE FROM tbl_CourseGroup WHERE courseID = " + id + "";
		} else {
			sql = "DELETE FROM tbl_CourseGroup WHERE groupID = " + id + "";
		}
		ret = query.execute(sql);
		return ret;

	}
}
