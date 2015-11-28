/**
 * 
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Group;
import model.GroupList;
import model.StudentList;
import model.UnknownStudentException;

/**
 * @author Lee John Smith
 *
 */
public class GroupDAO {

	private static Statement query;

	public static GroupList getGroups(StudentList students) {
		GroupList groups = new GroupList();

		String groupSQL = "SELECT * FROM tbl_Groups";
		String studentGroupSQL = "";
		try {
			query = getConnection().createStatement();

			ResultSet groupRS = query.executeQuery(groupSQL);
			ResultSet studentsRS = null;

			while (groupRS.next()) {
				int groupID = groupRS.getInt("groupID");
				String groupName = groupRS.getString("groupName");

				Group g = new Group(groupID, groupName);

				studentGroupSQL = "SELECT studentID FROM tbl_StudentGroup WHERE groupID=" + groupID;

				studentsRS = query.executeQuery(studentGroupSQL);

				while (studentsRS.next()) {
					int studentID = studentsRS.getInt("studentID");
					g.addStudent(students.getStudentByID(studentID));
				}
				groups.add(g);
			}
		}
		catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		}
		catch (UnknownStudentException use) {
			// TODO Auto-generated catch block
			use.printStackTrace();
		}

		return groups;

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
