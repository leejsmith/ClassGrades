/**
 * 
 */

package controller;

import java.rmi.activation.UnknownGroupException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Course;
import model.CourseList;
import model.Group;
import model.GroupList;
import model.Module;
import model.ModuleList;
import model.Student;

/**
 * @author Lee John Smith
 *
 */
public class CourseDAO_OLD {

	private static Statement query;

	public static CourseList getCourses(GroupList groups) {
		CourseList courses = new CourseList();

		String courseSQL = "SELECT * FROM tbl_Course";
		String groupCourseSQL = "";

		try {
			query = Database.getConnection().createStatement();

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

	public static void getCourseModules(Course c) {
		String moduleSQL = "";
		moduleSQL = "SELECT * FROM tbl_Module WHERE courseID=" + c.getCourseID();

		ResultSet moduleRS;
		try {
			moduleRS = query.executeQuery(moduleSQL);

			while (moduleRS.next()) {
				int moduleID = moduleRS.getInt("moduleID");
				String moduleName = moduleRS.getString("moduleName");
				c.addModule(new Module(moduleID, moduleName));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean updateCourses(Course c) {
		boolean retVal = false;
		try {

			String courseGroups = "SELECT groupID FROM tbl_CourseGroup WHERE courseID=" + c.getCourseID();

			ArrayList<Integer> groupIDs = new ArrayList<Integer>();

			ResultSet groups = query.executeQuery(courseGroups);

			while (groups.next()) {
				groupIDs.add(groups.getInt("groupID"));
			}
			boolean exists = false;
			for (Group g : c.getGroups().getList()) {
				exists = false;
				for (int i = 0; i < groupIDs.size(); i++) {
					if (groupIDs.get(i) == g.getGroupID()) {
						exists = true;
						break;
					}
				}
				if (!exists) {
					query.execute("INSERT INTO tbl_CourseGroup (courseID, groupID) VALUES (" + c.getCourseID() + "," + g.getGroupID() + ")");
				}
			}
			query.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retVal;
	}

	public static void insertCourse(Course c) {
		try {
			query = Database.getConnection().createStatement();

			ResultSet rs = query.executeQuery("SELECT courseID FROM tbl_Course ORDER BY courseID DESC LIMIT 1");
			int newCourseID = rs.getInt("courseID");

			for (Module m : c.getModules().getList()) {

				ResultSet moduleIDRet = query.executeQuery("SELECT moduleID FROM tbl_Module ORDER BY moduleID DESC LIMIT 1");
				int newModuleID = moduleIDRet.getInt("moduleID");

				for (Group g : c.getGroups().getList()) {
					for (Student s : g.getStudents().getStudentsList()) {
						query.executeQuery("INSERT INTO tbl_StudentModule(studentID,moduleID,result) VALUES (" + s.getStudentID() + "," + newModuleID + "," + 0);
					}
				}

			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteCourse(Course c) {
		try {
			query = Database.getConnection().createStatement();

			query.executeQuery("DELETE FROM tbl_CourseGroup WHERE courseID=" + c.getCourseID());
			for (Module m : c.getModules().getList()) {
				query.executeQuery("DELETE FROM tbl_StudentModuleResult WHERE moduleID=" + m.getModuleID());
			}
			query.executeQuery("DELETE FROM tbl_Module WHERE courseID=" + c.getCourseID());
			query.executeQuery("DELETE FROM tbl_Course WHERE courseID=" + c.getCourseID());

			query.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ModuleList getModuleList(Course c) {
		ModuleList moduleList = new ModuleList();

		String moduleSQL = "SELECT * FROM tbl_Module WHERE courseID=" + c.getCourseID();

		try {
			query = Database.getConnection().createStatement();

			ResultSet rs = query.executeQuery(moduleSQL);

			while (rs.next()) {
				int moduleID = rs.getInt("moduleID");
				String moduleName = rs.getString("moduleName");

				moduleList.add(moduleID, moduleName);
			}
		}
		catch (SQLException e) {

		}
		return moduleList;
	}

}
