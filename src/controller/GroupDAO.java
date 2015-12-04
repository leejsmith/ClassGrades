/**
 * 
 */

package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Group;
import model.GroupList;
import model.Student;
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

		try {
			query = Database.getConnection().createStatement();

			ResultSet groupRS = query.executeQuery(groupSQL);

			while (groupRS.next()) {
				int groupID = groupRS.getInt("groupID");
				String groupName = groupRS.getString("groupName");

				Group g = new Group(groupID, groupName);

				g.setStudents(getGroupStudents(groupID, students));
			}

		}
		catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		}
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
		boolean retVal = false;

		try {
			query = Database.getConnection().createStatement();

			String sql = "";

			sql = "INSERT INTO tbl_Group(groupName) VALUES (" + g.getGroupID() + ")";

			query.execute(sql);

			sql = " SELECT * FROM tbl_Group ORDER BY groupID DESC LIMIT 1";

			ResultSet rs = query.executeQuery(sql);

			int newGroupID = rs.getInt("groupID");

			for (Student s : students.getStudentsList()) {
				sql = "INSERT INTO tbl_StudentGroup(groupID,studentID) VALUES (" + newGroupID + "," + s.getStudentID() + ")";
				retVal = query.execute(sql);
				if (!retVal) {
					throw new DatabaseQueryException("ERROR inserting new students into groups");
				}
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

	public static boolean updateGroups(Group g, StudentList students) {
		boolean retVal = false;

		try {
			query = Database.getConnection().createStatement();

			String updateSQL = "UPDATE tbl_Group SET (groupName='" + g.getGroupName() + "') WHERE groupID=" + g.getGroupID();

			StudentList dbStudent = getGroupStudents(g.getGroupID(), students);

			StudentList deleteStudent = g.getStudents().compare(dbStudent);
			StudentList insertStudent = dbStudent.compare(g.getStudents());

			String sql = "";

			for (Student s : deleteStudent.getStudentsList()) {
				sql = "DELETE FROM tbl_StudentGroup WHERE studentID=" + s.getStudentID() + " AND groupID=" + g.getGroupID();
				retVal = query.execute(sql);
				if (!retVal) {
					throw new DatabaseQueryException("Error Removing Students from Student Group table");
				}
			}

			for (Student s : insertStudent.getStudentsList()) {
				sql = "INSERT INTO tbl_StudentGroup (groupID, studentID) VALUES (" + g.getGroupID() + "," + s.getStudentID() + ")";
				retVal = query.execute(sql);
				if (!retVal) {
					throw new DatabaseQueryException("Error Inserting Student into Student Group table");
				}
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

	public static boolean deleteGroup(Group g) {
		boolean retVal = false;

		try {
			query = Database.getConnection().createStatement();

			String sql = "";

			sql = "DELETE FROM tbl_StudentGroup WHERE groupID=" + g.getGroupID();

			retVal = query.execute(sql);

			if (!retVal) {
				throw new DatabaseQueryException("ERROR removing group - students");
			}

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
