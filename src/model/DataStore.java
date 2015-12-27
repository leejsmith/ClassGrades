/**
 * 
 */

package model;

import java.rmi.activation.UnknownGroupException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.AllergyDAO;
import dao.CourseDAO;
import dao.CourseGroupDAO;
import dao.GroupDAO;
import dao.ModuleDAO;
import dao.SenDAO;
import dao.StudentAllergyDAO;
import dao.StudentCourseDAO;
import dao.StudentDAO;
import dao.StudentGroupDAO;
import dao.StudentModuleResultDAO;
import dao.StudentSenDAO;

/**
 * @author Lee John Smith
 *
 */
public class DataStore {

	private StudentList studentList;
	private SenList senList;
	private AllergyList allergyList;
	private GroupList groupList;
	private CourseList courseList;

	public DataStore() {
		this.updateDatastore();
	}

	public void updateDatastore() {
		senList = getSenListDB();
		allergyList = getAllergyListDB();
		studentList = getStudentListDB();
		groupList = getGroupListDB();
		courseList = getCourseListDB();
		getStudentResults();
		getStudentPredicted();

		// System.out.println("Student Count: " + StudentDAO.getStudentCount());

		System.out.println("STUDENT LIST: \r");
		for (Student s : studentList.getStudentsList()) {
			System.out.println(s.toString());
			System.out.println(s.getResults().size());
			for (ModuleResult mr : s.getResults()) {
				System.out.println(mr.toString());
			}
		}

		System.out.println("\rSEN List:\r");
		for (Sen s : senList.getList()) {
			System.out.println(s.toString());
		}

		System.out.println("\rAllergyList\r");
		for (Allergy a : allergyList.getList()) {
			System.out.println(a.toString());
		}

		System.out.println("\rGroup List\r");
		for (Group g : groupList.getList()) {
			System.out.println(g.toString());
			for (Student s : g.getStudents().getStudentsList()) {
				System.out.println("Student: " + s.getStudentID());
			}
		}

		System.out.println("\rCourse List:\r");
		for (Course c : courseList.getList()) {
			System.out.println(c.toString());
			System.out.println(c.getGroups().size());
			for (Group g : c.getGroups().getList()) {
				System.out.println(g.toString());
			}
		}

	}

	private SenList getSenListDB() {
		SenList s = new SenList();

		try {
			ResultSet rs = SenDAO.select();

			while (rs.next()) {
				int senID = rs.getInt("senID");
				String senName = rs.getString("senName");
				String senShort = rs.getString("senShort");

				s.add(senID, senName, senShort);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	private AllergyList getAllergyListDB() {
		AllergyList allergyList = new AllergyList();

		try {

			ResultSet rs = AllergyDAO.select();

			while (rs.next()) {
				int allergyID = rs.getInt("allergyID");
				String allergyName = rs.getString("allergyName");

				allergyList.add(allergyID, allergyName);
			}
		} catch (SQLException e) {

		}
		return allergyList;
	}

	private StudentList getStudentListDB() {
		StudentList studentList = new StudentList();

		try {
			ResultSet studentSet = StudentDAO.select();
			while (studentSet.next()) {
				int studentID = studentSet.getInt("studentID");
				String surname = studentSet.getString("surname");
				String forename = studentSet.getString("forename");
				String regGroup = studentSet.getString("regGroup");
				String genderIn = studentSet.getString("gender");
				int examNumber = studentSet.getInt("examNumber");
				boolean pupilPremium = studentSet.getInt("pupilPremium") == 1 ? true : false;
				boolean eal = studentSet.getInt("eal") == 1 ? true : false;
				String catMeanIn = studentSet.getString("catMean");
				String catVerbalIn = studentSet.getString("catVerbal");
				String catNonVerbalIn = studentSet.getString("catNonVerbal");
				String catQuantIn = studentSet.getString("catQuant");
				String catAverageIn = studentSet.getString("catAverage");
				Gender gender;
				switch (genderIn) {
				case "MALE":
					gender = Gender.MALE;
					break;
				case "FEMALE":
					gender = Gender.FEMALE;
					break;
				default:
					gender = Gender.OTHER;
				}
				int catMean = catMeanIn.equals("") ? 0 : Integer.parseInt(catMeanIn);
				int catVerbal = catVerbalIn.equals("") ? 0 : Integer.parseInt(catVerbalIn);
				int catNonVerbal = catNonVerbalIn.equals("") ? 0 : Integer.parseInt(catNonVerbalIn);
				int catQuant = catQuantIn.equals("") ? 0 : Integer.parseInt(catQuantIn);
				int catAverage = catAverageIn.equals("") ? 0 : Integer.parseInt(catAverageIn);

				Student newStudent = new Student(studentID, surname, forename, regGroup, gender, examNumber,
						pupilPremium, eal, catMean, catVerbal, catNonVerbal, catQuant, catAverage);

				ResultSet senRS = StudentSenDAO.select(studentID);

				int senID;
				while (senRS.next()) {
					senID = senRS.getInt("senID");
					try {
						newStudent.addSenStatus(senList.getSenByID(senID));
					} catch (UnknownSenException e) {
						JOptionPane.showMessageDialog(null,
								"Error importing Student SEN Information. Speak to System Administrator. Quote the Following \"Student SEN Import Error - Student"
										+ studentID + "\" ");

					}
				}

				ResultSet allergyRS = StudentAllergyDAO.select(studentID);

				int allergyID;
				while (allergyRS.next()) {
					allergyID = allergyRS.getInt("allergyID");
					try {
						newStudent.addAllergy(allergyList.getAllergyByID(allergyID));
					} catch (UnknownAllergyException e) {
						JOptionPane.showMessageDialog(null,
								"Error importing Student Allergy Information. Speak to System Administrator. Quote the Following \"Student Allergy Import Error - Student"
										+ studentID + "\" ");
					}
				}
				// System.out.println(newStudent.getStudentID());
				studentList.add(newStudent);
			}
			return studentList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	private GroupList getGroupListDB() {
		GroupList groups = new GroupList();

		try {
			ResultSet groupsRS = GroupDAO.select();
			ResultSet groupStudents = null;
			while (groupsRS.next()) {
				int groupID = groupsRS.getInt("groupID");
				String groupName = groupsRS.getString("groupName");
				Group g = new Group(groupID, groupName);
				groupStudents = StudentGroupDAO.select(groupID);
				while (groupStudents.next()) {
					int student = groupStudents.getInt("studentID");
					g.addStudent(studentList.getStudentByID(student));
				}
				groups.add(g);
			}
			return groups;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (UnknownStudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private CourseList getCourseListDB() {
		CourseList courses = new CourseList();

		try {
			ResultSet courseRS = CourseDAO.select();
			ResultSet groupsRS = null;

			while (courseRS.next()) {
				int courseID = courseRS.getInt("courseID");
				String courseName = courseRS.getString("courseName");

				Course c = new Course(courseID, courseName);

				groupsRS = CourseGroupDAO.select(courseID, true);
				int groupID = 0;
				while (groupsRS.next()) {
					groupID = groupsRS.getInt("groupID");
					c.addGroup(groupList.getGroupByID(groupID));
				}

				ResultSet courseMods = ModuleDAO.select(courseID, true);
				Module module = null;
				while (courseMods.next()) {
					int moduleID = courseMods.getInt("moduleID");
					String moduleName = courseMods.getString("moduleName");
					module = new Module(moduleID, moduleName);
					c.addModule(module);
				}

				courses.add(c);
			}
			return courses;
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			return courses;
		} catch (UnknownGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return courses;
		}
	}

	private void getStudentResults() {
		try {

			for (Student s : studentList.getStudentsList()) {
				ResultSet studentResults = StudentModuleResultDAO.select(s.getStudentID());

				while (studentResults.next()) {
					int moduleID = studentResults.getInt("moduleID");
					int result = studentResults.getInt("results");
					Module m = null;
					for (Course c : courseList.getList()) {
						for (Module mod : c.getModules().getList()) {
							if (mod.getModuleID() == moduleID) {
								m = mod;
								break;
							}
						}
						if (m != null) {
							break;
						}
					}
					s.addResult(new ModuleResult(m, result));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getStudentPredicted() {
		try {
			ResultSet pred = null;

			pred = StudentCourseDAO.select();

			while (pred.next()) {
				int studentID = pred.getInt("studentID");
				int courseID = pred.getInt("courseID");
				char predictedScore = pred.getString("targetGrade").charAt(0);
				studentList.getStudentByID(studentID).addCoursePredicted(courseList.getCourseByID(courseID),
						predictedScore);
			}

		} catch (SQLException e) {

		} catch (UnknownStudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownCourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return the studentList
	 */
	public StudentList getStudentList() {
		return studentList;
	}

	/**
	 * @param studentList
	 *            the studentList to set
	 */
	public void setStudentList(StudentList studentList) {
		this.studentList = studentList;
	}

	/**
	 * @return the senList
	 */
	public SenList getSenList() {
		return senList;
	}

	/**
	 * @param senList
	 *            the senList to set
	 */
	public void setSenList(SenList senList) {
		this.senList = senList;
	}

	/**
	 * @return the allergyList
	 */
	public AllergyList getAllergyList() {
		return allergyList;
	}

	/**
	 * @param allergyList
	 *            the allergyList to set
	 */
	public void setAllergyList(AllergyList allergyList) {
		this.allergyList = allergyList;
	}

	/**
	 * @return the groupList
	 */
	public GroupList getGroupList() {
		return groupList;
	}

	/**
	 * @param groupList
	 *            the groupList to set
	 */
	public void setGroupList(GroupList groupList) {
		this.groupList = groupList;
	}

	/**
	 * @return the courseList
	 */
	public CourseList getCourseList() {
		return courseList;
	}

	/**
	 * @param courseList
	 *            the courseList to set
	 */
	public void setCourseList(CourseList courseList) {
		this.courseList = courseList;
	}

}
