/**
 * 
 */

package model;

import java.util.ArrayList;

import controller.GeneralDAO;
import controller.StudentDAO;

/**
 * @author Lee John Smith
 *
 */
public class DataStore {

	private ArrayList<Student>	studentList;
	private SenList				senList;
	private AllergyList			allergyList;

	public DataStore() {
		senList = GeneralDAO.getSenList();
		allergyList = GeneralDAO.getAllergyList();
		studentList = StudentDAO.getStudents(senList, allergyList);

	}
}
