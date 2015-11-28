/**
 * 
 */

package controller;

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

		String groupSQL = "SELECT * FROM tbl_Group";
		String studentGroupSQL = "";
		try {
			query = Database.getConnection().createStatement();

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
}
