/**
 * 
 */

package controller;

import java.rmi.activation.UnknownGroupException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Course;
import model.CourseList;
import model.GroupList;

/**
 * @author Lee John Smith
 *
 */
public class CourseDAO {

	private static Statement query;

	public static CourseList getCourses(GroupList groups) {
		CourseList courses = new CourseList();

		String courseSQL = "SELECT * FROM tbl_Courses";
		String groupCourseSQL = "";
		try {
			query = getConnection().createStatement();

			ResultSet courseRS = query.executeQuery(courseSQL);
			ResultSet groupsRS = null;

			while (courseRS.next()) {
				int courseID = courseRS.getInt("courseID");
				String courseName = courseRS.getString("courseName");

				Course c = new Course(courseID, courseName);

				groupCourseSQL = "SELECT groupID FROM tbl_CourseGroup WHERE courseID=" + courseID;

				groupsRS = query.executeQuery(groupCourseSQL);

				while (groupsRS.next()) {
					int groupID = groupsRS.getInt("groupID");
					c.addGroup(groups.getGroupByID(groupID));
				}
				courses.add(c);
			}
		}
		catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		}
		catch (UnknownGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return courses;

	}

	private static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./files/classgrades.sqlite3");
		}
		catch (Exception e) {
			System.err.println("Failed to connect to database, System will now exit");
		}

		return c;
	}
}
