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
