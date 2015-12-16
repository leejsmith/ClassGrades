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
public class GroupDAO_OLD {

	private static Statement query;

	public GroupList getGroups(StudentList students) {
		GroupList groups = new GroupList();

		return groups;
	}

	private static StudentList getGroupStudents(int groupID, StudentList students) {
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

	public static boolean insertGroup(Group g, StudentList students) {

	}

	public static boolean updateGroups(Group g, StudentList students) {

	}

	public static boolean deleteGroup(Group g) {

		try {
			query = Database.getConnection().createStatement();

			String sql = "";

			sql = "DELETE FROM tbl_Group WHERE groupID=" + g.getGroupID();

			retVal = query.execute(sql);

			if (!retVal) {
				throw new DatabaseQueryException("ERROR removing group - group");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (DatabaseQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retVal;
	}

}
