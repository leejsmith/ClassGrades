/**
 * 
 */

package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Allergy;
import model.AllergyList;
import model.Gender;
import model.Module;
import model.ModuleList;
import model.ModuleResult;
import model.Sen;
import model.SenList;
import model.Student;
import model.StudentList;
import model.UnknownAllergyException;
import model.UnknownModuleException;
import model.UnknownSenException;

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
	public static StudentList getStudents(SenList senList, AllergyList allergyList) {
		StudentList studentList = new StudentList(1);

		query = null;

		String studentSQL = "SELECT * FROM tbl_Student";
		String senSQL;
		String allergySQL;

		try {
			query = Database.getConnection().createStatement();

			ResultSet studentSet = query.executeQuery(studentSQL);

			while (studentSet.next()) {
				int studentID = studentSet.getInt("studentID");
				String surname = studentSet.getString("surname");
				String forname = studentSet.getString("forename");
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
				default:
					gender = Gender.OTHER;
				}

				int catMean = catMeanIn.equals("") ? 0 : Integer.parseInt(catMeanIn);
				int catVerbal = catVerbalIn.equals("") ? 0 : Integer.parseInt(catVerbalIn);
				int catNonVerbal = catNonVerbalIn.equals("") ? 0 : Integer.parseInt(catNonVerbalIn);
				int catQuant = catQuantIn.equals("") ? 0 : Integer.parseInt(catQuantIn);
				int catAverage = catAverageIn.equals("") ? 0 : Integer.parseInt(catAverageIn);

				Student newStudent = new Student(studentID, surname, forname, regGroup, gender, examNumber, pupilPremium, eal, catMean, catVerbal, catNonVerbal, catQuant, catAverage);

				newStudent.setSenStatus(getStudentSenList(newStudent, senList));

				allergySQL = "SELECT * FROM tbl_StudentAllergy WHERE studentID=" + studentID;

				ResultSet allergySet = query.executeQuery(allergySQL);
				int allergyID;
				while (allergySet.next()) {
					allergyID = allergySet.getInt("allergyID");
					try {
						newStudent.addAllergy(allergyList.getAllergyByID(allergyID));
					}
					catch (UnknownAllergyException e) {
						JOptionPane.showMessageDialog(null,
								"Error importing Student Allergy Information. Speak to System Administrator. Quote the Following \"Student Allergy Import Error - Student" + studentID + "\" ");
					}
				}

				studentList.add(newStudent);
			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	public static void getStudentResults(StudentList students, ModuleList modules) {
		try {
			query = Database.getConnection().createStatement();

			String sql = "";
			ResultSet studentResults = null;
			for (Student s : students.getStudentsList()) {
				sql = "SELECT moduleID, result FROM tbl_StudentModuleResult WHERE studentID=" + s.getStudentID();
				System.out.println(sql);
				studentResults = query.executeQuery(sql);

				while (studentResults.next()) {
					int moduleID = studentResults.getInt("moduleID");
					int result = studentResults.getInt("result");
					Module m = modules.getModuleByID(moduleID);

					s.addResult(new ModuleResult(m, result));
				}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (UnknownModuleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static SenList getStudentSenList(Student s, SenList fullSenList) {
		String senSQL = "SELECT * FROM tbl_StudentSen WHERE studentID=" + s.getStudentID();
		SenList senList = new SenList();

		ResultSet senSet;
		try {
			senSet = query.executeQuery(senSQL);

			int senID;
			while (senSet.next()) {
				senID = senSet.getInt("senID");
				try {
					senList.add(fullSenList.getSenByID(senID));
				}
				catch (UnknownSenException e) {
					JOptionPane.showMessageDialog(null,
							"Error importing Student SEN Information. Speak to System Administrator. Quote the Following \"Student SEN Import Error - Student" + s.getStudentID() + "\" ");
				}
			}
			return senList;
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}

	private static AllergyList getStudentAllergyList(Student s, AllergyList fullAllergyList) {
		String allergySQL = "SELECT * FROM tbl_StudentAllergy WHERE studentID=" + s.getStudentID();
		AllergyList allergyList = new AllergyList();

		ResultSet allergySet;
		try {
			allergySet = query.executeQuery(allergySQL);

			int allergyID;
			while (allergySet.next()) {
				allergyID = allergySet.getInt("allergyID");
				try {
					allergyList.add(fullAllergyList.getAllergyByID(allergyID));
				}
				catch (UnknownAllergyException e) {
					JOptionPane.showMessageDialog(null,
							"Error importing Student Allergy Information. Speak to System Administrator. Quote the Following \"Student Allergy Import Error - Student" + s.getStudentID() + "\" ");
				}
			}
			return allergyList;
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}

	public static boolean updateStudentInformation(Student s) {
		boolean retVal = false;

		try {
			query = Database.getConnection().createStatement();

			String sql;
			String update = "UPDATE tbl_Student ";
			String set = "SET (" + "surname='" + s.getSurname() + "', forname='" + s.getForname() + "', regGroup=" + s.getRegGroup() + "', gender=" + s.getGender().name() + ", examNumber="
					+ s.getExamNumber() + ", pupilPremiun=" + (s.isPupilPremiun() ? 1 : 0) + ", eal=" + (s.isEal() ? 1 : 0) + ", catMean=" + s.getCatMean() + ", catVerbal=" + s.getCatVerbal()
					+ ", catNonVerbal=" + s.getCatNonVerbal() + ", catQuant=" + s.getCatQuantative() + ", catAverage=" + s.getCatAverage() + ") ";
			String where = " WHERE studentID=" + s.getStudentID();
			sql = update + set + where;
			retVal = query.execute(sql);

			updateSENStatus(s);
			updateAllergyStatus(s);

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retVal;

	}

	private static void updateSENStatus(Student s) {
		boolean retVal;

		SenList tmpDBCompare = getStudentSenList(s, GeneralDAO.getSenList());

		SenList deleteSEN = new SenList();
		SenList insertSEN = new SenList();

		// TEST FOR DELETE SENS
		deleteSEN = tmpDBCompare.compare(s.getSenStatus());

		// TEST FOR INSERT SENS
		insertSEN = s.getSenStatus().compare(tmpDBCompare);

		try {
			query = Database.getConnection().createStatement();
			String sql;

			for (Sen senDel : deleteSEN) {
				sql = "DELETE FROM tbl_StudentSEN WHERE studentID=" + s.getStudentID() + " AND senID=" + senDel.getSenID();
				retVal = query.execute(sql);
				if (!retVal) {
					throw new DatabaseQueryException("Error on Removing SEN: " + senDel.getSenName() + " for Student: " + s.getStudentID());
				}
			}

			for (Sen senIns : insertSEN) {
				sql = "INSERT INTO tbl_StudentSen (studentID, senID) VALUES (" + s.getStudentID() + "," + senIns.getSenID() + ")";
				retVal = query.execute(sql);
				if (!retVal) {
					throw new DatabaseQueryException("Error on Removing SEN: " + senIns.getSenName() + " for Student: " + s.getStudentID());
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
	}

	private static void updateAllergyStatus(Student s) {
		boolean retVal;

		AllergyList tmpDBCompare = getStudentAllergyList(s, GeneralDAO.getAllergyList());

		AllergyList deleteAllergy = new AllergyList();
		AllergyList insertAllergy = new AllergyList();

		// TEST FOR DELETE AllergyS
		deleteAllergy = tmpDBCompare.compare(s.getAllergyList());

		// TEST FOR INSERT AllergyS
		insertAllergy = s.getAllergyList().compare(tmpDBCompare);

		try {
			query = Database.getConnection().createStatement();
			String sql;

			for (Allergy allergyDel : deleteAllergy) {
				sql = "DELETE FROM tbl_StudentAllergy WHERE studentID=" + s.getStudentID() + " AND allergyID=" + allergyDel.getAllergyID();
				retVal = query.execute(sql);
				if (!retVal) {
					throw new DatabaseQueryException("Error on Removing Allergy: " + allergyDel.getAllergyName() + " for Student: " + s.getStudentID());
				}
			}

			for (Allergy allergyIns : insertAllergy) {
				sql = "INSERT INTO tbl_StudentAllergy (studentID, allergyID) VALUES (" + s.getStudentID() + "," + allergyIns.getAllergyID() + ")";
				retVal = query.execute(sql);
				if (!retVal) {
					throw new DatabaseQueryException("Error on Removing Allergy: " + allergyIns.getAllergyName() + " for Student: " + s.getStudentID());
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
	}

	public static boolean deleteStudent(Student s) {
		boolean sen = false;
		boolean allergy = false;
		boolean group = false;
		boolean result = false;
		boolean student = false;

		try {
			query = Database.getConnection().createStatement();

			String senSQL = "DELETE FROM tbl_StudentSen WHERE studentID=" + s.getStudentID();
			String allergySQL = "DELETE FROM tbl_StudentAllergy WHERE studentID=" + s.getStudentID();
			String groupSQL = "DELETE FROM tbl_StudentGroup WHERE studentID=" + s.getStudentID();
			String resultSQL = "DELETE FROM tbl_StudentModuleResult WHERE studentID=" + s.getStudentID();
			String studentSQL = "DELETE FROM tbl_Student WHERE studentID=" + s.getStudentID();

			sen = query.execute(senSQL);
			allergy = query.execute(allergySQL);
			group = query.execute(groupSQL);
			result = query.execute(resultSQL);
			student = query.execute(studentSQL);

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sen && allergy && group && result && student;
	}
}
