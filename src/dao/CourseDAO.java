/**
 * 
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;
import model.Course;

/**
 * @author Lee John Smith
 *
 */
public class CourseDAO {

	public static Statement query;

	public static ResultSet select() {
		try {
			query = Database.getConnection().createStatement();
			ResultSet rs;
			String sql = "SELECT * FROM tbl_Course";
			rs = query.executeQuery(sql);
			query.close();
			return rs;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static boolean insert(Course c) {
		try {
			query = Database.getConnection().createStatement();
			boolean ret = query.execute("INSERT INTO tbl_Course(courseName) VALUES (" + c.getCourseName() + ")");
			query.close();
			return ret;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static boolean update(Course c) {
		try {
			query = Database.getConnection().createStatement();
			String sql = "UPDATE tbl_Courses SET courseName='" + c.getCourseName() + "' WHERE courseID=" + c.getCourseID();
			boolean retVal = query.execute(sql);
			query.close();
			return retVal;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static boolean delete(Course c) {
		try {
			query = Database.getConnection().createStatement();
			String sql = "DELETE FROM tbl_Course WHERE courseID=" + c.getCourseID() + ";";
			boolean ret = query.execute(sql);
			query.close();
			return ret;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
