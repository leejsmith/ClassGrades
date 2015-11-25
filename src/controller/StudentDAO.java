/**
 * 
 */

package controller;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.Gender;
import model.SENStatus;
import model.Student;

/**
 * @author Lee John Smith
 *
 */
public class StudentDAO {

	private static Statement query;

	public static ArrayList<Student> getStudentData() {
		query = null;

		ArrayList<Student> students = new ArrayList<Student>();
		String sql = "SELECT * FROM tbl_Student";
		String sql2;
		try {
			query = getConnection().createStatement();
			try {
				ResultSet rs = query.executeQuery(sql);

				while (rs.next()) {
					int studentID = rs.getInt("studentID");
					int examNumber = rs.getInt("examNumber");
					String surname = rs.getString("surname");
					String fornames = rs.getString("forenames");
					Gender gender = null;
					switch (rs.getString("gender")) {
						case "MALE" :
							gender = Gender.MALE;
							break;
						case "FEMALE" :
							gender = Gender.FEMALE;
							break;
						default :
							gender = Gender.OTHER;
					}
					String regGroup = rs.getString("regGroup");
					sql2 = "SELECT * FROM tbl_StudentSEN WHERE studentID="
							+ studentID;
					ResultSet rs2 = query.executeQuery(sql2);
					SENStatus senStatus = SENStatus.NONE;
					ArrayList<SENStatus> sen = new ArrayList<SENStatus>();
					while (rs2.next()) {
						switch (rs.getString("senStatus")) {
							case "DYSLEXIA" :
								senStatus = SENStatus.DYSLEXIA;
								break;
							case "DYSPRAXIA" :
								senStatus = SENStatus.DYSPRAXIA;
								break;
							case "VISUAL" :
								senStatus = SENStatus.VISUAL;
								break;
							case "HEARING" :
								senStatus = SENStatus.HEARING;
								break;
							case "MILD_LEARNING" :
								senStatus = SENStatus.MILD_LEARNING;
								break;
							case "MODERATE_LEARNING" :
								senStatus = SENStatus.MODERATE_LEARNING;
								break;
							case "SEVERE_LEARNING" :
								senStatus = SENStatus.SEVERE_LEARNING;
								break;
							case "EMOTIONAL_BEHAVIOURAL" :
								senStatus = SENStatus.EMOTIONAL_BEHAVIOURAL;
								break;
							case "SOCIAL_EMOTIONAL_MENTAL" :
								senStatus = SENStatus.SOCIAL_EMOTIONAL_MENTAL;
								break;
							case "SPEECH_LANGUAGE_COMMUNICATION" :
								senStatus = SENStatus.SPEECH_LANGAUGE_COMMUNICATION;
								break;
							case "AUTISM" :
								senStatus = SENStatus.AUTISM;
								break;
							default :
								senStatus = SENStatus.NONE;
						}
						sen.add(senStatus);
					}
					sen = sen.size() == 0 ? null : sen;
					boolean pupilPremium = rs.getBoolean("pupilPremium");
					boolean eal = rs.getBoolean("eal");
					int catMean = rs.getInt("catMean");
					int catVerbal = rs.getInt("catVerbal");
					int catNonVerbal = rs.getInt("catNonVerbal");
					int catQuantitative = rs.getInt("catQuantitative");
					int averagePts = rs.getInt("averagePts");

					students.add(new Student(studentID, examNumber, surname,
							fornames, gender, regGroup, sen, pupilPremium, eal,
							catMean, catVerbal, catNonVerbal, catQuantitative,
							averagePts));
				}
			} catch (SQLException e) {
				System.out.println("ERROR: Incorrect SQL Statement: " + sql);
			}

		} catch (SQLException e1) {

		}

		return students;
	}

	public static boolean createStudent(int examNumber, String surname,
			String fornames, Gender gender, String regGroup,
			boolean pupilPremium, boolean eal, int catMean, int catVerbal,
			int catNonVerbal, int catQuantitative, int averagePts) {
		boolean retVal = true;
		query = null;
		String sql = "";
		try {
			query = getConnection().createStatement();

			sql = "INSERT INTO tbl_Student (examNumber, surname, forenames, "
					+ "gender, regGroup, pupilPremium, eal, catMean, "
					+ "catVerbal, catNonVerbal, catQuantitative, averagePts)"
					+ "VALUES (" + examNumber + ", '" + surname + "', '"
					+ fornames + "', '" + gender.toString() + "', '" + regGroup
					+ "', " + (pupilPremium ? 1 : 0) + ", " + (eal ? 1 : 0)
					+ ", " + catMean + ", " + catVerbal + ", " + catNonVerbal
					+ ", " + catQuantitative + ", " + averagePts + ")";

			retVal = query.execute(sql);

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,
					"Error In Create Student :" + sql);
			System.out.println(sql);
			return retVal;
		}

		return retVal;

	}

	public static boolean deleteStudent(int studentID) {
		boolean retVal = false;
		query = null;
		try {
			query = getConnection().createStatement();

			// DELETE ALL ENTRIES FROM SEN TABLE WITH STUDENTID
			String sql = "DELETE FROM tbl_StudentSEN WHERE studentID="
					+ studentID;
			retVal = query.execute(sql);

			// DELETE ALL ENTRIES FROM GROUP TABLE WITH STUDENTID
			sql = "DELETE FROM tbl_Group WHERE studentID=" + studentID;
			retVal = query.execute(sql);

			// DELETE ALL ENTRIES FROM MODULE RESULT WITH STUDENTID
			sql = "DELETE FROM tbl_ModuleResult WHERE studentID=" + studentID;
			retVal = query.execute(sql);

			// DELETE ALL ENTRIES FROM HOMEWORK RESULT WITH STUDENTID
			sql = "DELETE FROM tbl_HomeworkResult WHERE studentID=" + studentID;
			retVal = query.execute(sql);

			// DELETE ALL ENTRIES FROM STUDENT ALLERGY WITH STUDENTID
			sql = "DELETE FROM tbl_StudentAllergy WHERE studentID=" + studentID;
			retVal = query.execute(sql);

		} catch (SQLException e) {
			return retVal;
		}

		return retVal;
	}

	public static boolean updateStudent(Student student) {
		int studentID = student.getStudentID();
		query = null;
		boolean retVal = true;

		try {
			String sql = "DELETE FROM tbl_StudentAllergy WHERE studentID="
					+ studentID;
			query = getConnection().createStatement();
			retVal = query.execute(sql);

			sql = "UPDATE tbl_Student " + "SET (" + "examNumber="
					+ student.getExamNumber() + ", " + "surname='"
					+ student.getSurname() + "', " + "forenames='"
					+ student.getForenames() + "', " + "gender='"
					+ student.getGender().toString() + "', " + "regGroup='"
					+ student.getRegGroup() + "', " + "pupilPremium="
					+ (student.isPupilPremium() == true ? 1 : 0) + ",'" + "eal="
					+ "catMean=" + student.getCatMean() + ", " + "catVerbal="
					+ student.getCatVerbal() + ", " + "catNonVerbal="
					+ student.getCatNonVerbal() + ", " + "catQuantitative="
					+ student.getCatQuantitative() + ", " + "averagePts="
					+ student.getAveragePts() + ") " + "WHERE studentID="
					+ student.getStudentID();

			retVal = query.execute(sql);

			for (int i = 0; i < student.getAllergys().size(); i++) {
				sql = "INSERT INTO tbl_StudentAllergy (studentID, alleryID) VALUES ("
						+ student.getStudentID() + ", "
						+ student.getAllergys().get(i).getAllergyID() + ")";
				retVal = query.execute(sql);
				if (!retVal) {
					return retVal;
				}
			}
		} catch (SQLException e) {
			return false;
		}
		return retVal;
	}
	
	public static boolean addaStudentSEN(Student student){
		return false;
	}

	public static boolean importStudentCSV(String filePath) {
		boolean retVal = false;

		BufferedReader br = null;
		String line = "";
		String[] readLine = null;
		String separator = ",";
		int index = 1;
		try {
			br = new BufferedReader(new FileReader(filePath));
			boolean header = true;
			while ((line = br.readLine()) != null) {
				if (!header) {
					readLine = line.split(separator);

					String surname = readLine[0];
					String forename = readLine[1];
					String regGroup = readLine[2];
					int examNumber = Integer.parseInt(readLine[3]);
					Gender gender = null;
					switch (readLine[4]) {
						case "M" :
							gender = Gender.MALE;
							break;
						case "F" :
							gender = Gender.FEMALE;
							break;
						default :
							gender = Gender.OTHER;
					}
					boolean pupilPremium = readLine[5].equals("Y")
							? true
							: false;
					boolean eal = readLine[6].equals("Y") ? true : false;
					int catMean = !readLine[7].trim().equals("")
							? Integer.parseInt(readLine[7])
							: 0;
					int catVerbal = !readLine[8].trim().equals("")
							? Integer.parseInt(readLine[8])
							: 0;
					int catNonVerbal = !readLine[9].trim().equals("")
							? Integer.parseInt(readLine[9])
							: 0;
					int catQuantitive = !readLine[10].trim().equals("")
							? Integer.parseInt(readLine[10])
							: 0;
					int averagePts = !readLine[11].trim().equals("")
							? Integer.parseInt(readLine[11])
							: 0;
					System.out.println(catMean + "," + catVerbal + ","
							+ catNonVerbal + "," + catQuantitive);
					createStudent(examNumber, surname, forename, gender,
							regGroup, pupilPremium, eal, catMean, catVerbal,
							catNonVerbal, catQuantitive, averagePts);
				}
				header = false;
				index++;
			}

		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Error in file Read");

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "");
			System.out.println("Error in Number Parse, Check Row: " + index
					+ " ROW CONTENTS: '" + readLine[7] + "', '" + readLine[8]
					+ "', '" + readLine[9] + "', '" + readLine[10] + "', '"
					+ readLine[11] + "'");

		}

		return true;
	}

	private static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager
					.getConnection("jdbc:sqlite:./files/classgrades.sqlite3");
		} catch (Exception e) {
			System.err.println(
					"Failed to connect to database, System will now exit");
		}

		return c;
	}
}
