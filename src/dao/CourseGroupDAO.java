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

	private Statement query;

	public ResultSet select() {
		ResultSet ret;
		String sql = "SELECT * FROM tbl_CourseGroup";
		try {
			query = Database.getConnection().createStatement();

			ret = query.executeQuery(sql);
			query.close();
			return ret;

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public boolean insert(int course, int group) {
		boolean ret = false;

		try {
			String sql = "INSERT INTO tbl_CourseGroup (courseID, groupID) VALUES (" + course + "," + group + ");";
			query = Database.getConnection().createStatement();
			ret = query.execute(sql);
			query.close();
			return ret;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean delete(int id, boolean isCourse) {
		String sql = "";
		boolean ret = false;
		try {
			query = Database.getConnection().createStatement();
			if (isCourse) {
				sql = "DELETE FROM tbl_CourseGroup WHERE courseID = " + id + "";
			}
			else {
				sql = "DELETE FROM tbl_CourseGroup WHERE groupID = " + id + "";
			}
			ret = query.execute(sql);
			return ret;

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;

	}
}
