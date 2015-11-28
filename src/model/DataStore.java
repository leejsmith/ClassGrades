/**
 * 
 */

package model;

import controller.GeneralDAO;
import controller.StudentDAO;

/**
 * @author Lee John Smith
 *
 */
public class DataStore {

	private StudentList	studentList;
	private SenList		senList;
	private AllergyList	allergyList;

	public DataStore() {
		senList = GeneralDAO.getSenList();
		allergyList = GeneralDAO.getAllergyList();
		studentList = StudentDAO.getStudents(senList, allergyList);
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

}
