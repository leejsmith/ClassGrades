/**
 * 
 */

package datastore;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Database;
import dao.GroupDAO;
import model.Group;
import model.GroupList;
import model.StudentList;
import model.UnknownStudentException;

/**
 * @author Lee John Smith
 *
 */
public class GroupData {

	private GroupList groups;

	public GroupData(StudentList students) {
		groups = new GroupList();

		ResultSet groupRS = GroupDAO.select();

		try {
			while (groupRS.next()) {
				int groupID = groupRS.getInt("groupID");
				String groupName = groupRS.getString("groupName");
				System.out.println(groupName);
				Group g = new Group(groupID, groupName);

				g.setStudents(getGroupStudents(groupID, students));
				groups.add(g);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private StudentList getGroupStudents(int groupID, StudentList students) {
		ResultSet studentsRS = null;
		StudentList s = new StudentList();
		String studentGroupSQL = "SELECT studentID FROM tbl_StudentGroup WHERE groupID=" + groupID;
		try {
			query = Database.getConnection().createStatement();
			studentsRS = query.executeQuery(studentGroupSQL);

			while (studentsRS.next()) {
				int studentID = studentsRS.getInt("studentID");
				s.add(students.getStudentByID(studentID));
			}
		}
		catch (SQLException sqle) {

		}
		catch (UnknownStudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}
