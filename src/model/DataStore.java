/**
 * 
 */

package model;

import controller.CourseDAO;
import controller.GeneralDAO;
import controller.GroupDAO;
import controller.StudentDAO;

/**
 * @author Lee John Smith
 *
 */
public class DataStore {

	private StudentList	studentList;
	private SenList		senList;
	private AllergyList	allergyList;
	private GroupList	groupList;
	private CourseList	courseList;
	private ModuleList	moduleList;

	public DataStore() {
		this.updateDatastore();
	}

	public void updateDatastore() {
		senList = GeneralDAO.getSenList();
		allergyList = GeneralDAO.getAllergyList();
		studentList = StudentDAO.getStudents(senList, allergyList);
		groupList = GroupDAO.getGroups(studentList);
		moduleList = GeneralDAO.getModuleList();
		courseList = CourseDAO.getCourses(groupList, moduleList);
		StudentDAO.getStudentResults(studentList, moduleList);

		System.out.println("SEN LIST");
		System.out.println("Count: " + senList.size());

		for (Sen s : senList.getList()) {
			System.out.println(s.toString());
		}

		System.out.println();
		System.out.println("ALLERGY LIST");
		System.out.println("Count: " + allergyList.size());

		for (Allergy s : allergyList.getList()) {
			System.out.println(s.toString());
		}

		System.out.println();
		System.out.println("STUDENT LIST");
		System.out.println("Count: " + studentList.size());

		for (Student s : studentList.getStudentsList()) {
			System.out.println(s.toString());
		}

		System.out.println();
		System.out.println("GROUP LIST");
		System.out.println("Count: " + groupList.size());

		for (Group s : groupList.getList()) {
			System.out.println(s.toString());
		}

		System.out.println();
		System.out.println("MODULE LIST");
		System.out.println("Count: " + moduleList.size());

		for (Module s : moduleList.getList()) {
			System.out.println(s.toString());
		}

		System.out.println();
		System.out.println("COURSE LIST");
		System.out.println("Count: " + courseList.size());

		for (Course s : courseList.getList()) {
			System.out.println(s.toString());
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

	/**
	 * @return the moduleList
	 */
	public ModuleList getModuleList() {
		return moduleList;
	}

	/**
	 * @param moduleList
	 *            the moduleList to set
	 */
	public void setModuleList(ModuleList moduleList) {
		this.moduleList = moduleList;
	}

}
