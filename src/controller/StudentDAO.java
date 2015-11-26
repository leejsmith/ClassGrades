/**
 * 
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.AllergyList;
import model.SenList;
import model.Student;

/**
 * Controls Access to the sqlite database for management of the Student data and
 * associated classes.
 * 
 * @author Lee John Smith
 *
 */
public class StudentDAO {

	private static Statement query;

	/**
	 * Retrieves data from the database for the students table. It also connects
	 * to the StudentSEN and StudentAllergy tables to gather the information
	 * that connects a student with their associated information
	 * 
	 * @return Complete list of Students and associated information.
	 */
	public static ArrayList<Student> getStudents(SenList senList, AllergyList allergyList) {
		ArrayList<Student> studentList = new ArrayList<Student>();

		query = null;

		String studentSQL = "SELECT * FROM tbl_Student";
		String senSQL;
		String allerySQL;

		try {
			query = getConnection().createStatement();

			ResultSet studentSet = query.executeQuery(studentSQL);

			while (studentSet.next()) {
				int studentID = studentSet.getInt("studentID");
				String surname = studentSet.getString("surname");
				String forname = studentSet.getString("forname");
				String regGroup = studentSet.getString("regGroup");
				String genderIn = studentSet.getString("gender");
				int examNumber = studentSet.getInt("examNumber");
				boolean pupilPremium = studentSet.getInt("pupilPremium") == 1 ? true : false;
				boolean eal = studentSet.getInt("eal") == 1 ? true : false;
				int catMean = studentSet.getInt("catMean");
				int catVerbal = studentSet.getInt("catVerbal");
				int catNonVerbal = studentSet.getInt("catNonVerbal");
				int catQuant = studentSet.getInt("catQuant");
				senSQL = "SELECT * FROM tbl_StudentSen WHERE studentID=" + studentID;

				ResultSet senSet = query.executeQuery(senSQL);

				while (senSet.next()) {

				}
			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	private static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./files/classgrades.sqlite3");
		}
		catch (Exception e) {
			System.err.println("Failed to connect to database, System will now exit");
		}

		return c;
	}
}
