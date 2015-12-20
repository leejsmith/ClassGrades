/**
 * 
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;
import model.Student;

/**
 * @author Lee John Smith
 *
 */
public class StudentDAO {

	private static Statement query;

	public static ResultSet select() throws SQLException {
		ResultSet ret = null;
		query = Database.getConnection().createStatement();
		String sql = "SELECT * FROM tbl_Student";
		ret = query.executeQuery(sql);
		query.close();
		return ret;
	}

	public static boolean insert(Student s) throws SQLException {
		boolean ret = false;
		query = Database.getConnection().createStatement();
		String sql = "INSERT INTO tbl_Student(surname, forename, regGroup, gender,examNumber,pupilPremium,eal,catMean,catVerbal,catNonVerbal,catQuant,catAverage) VALUES ('" + s.getSurname() + "','"
				+ s.getForname() + "','" + s.getRegGroup() + "','" + s.getGender().toString() + "'," + s.getExamNumber() + (s.isPupilPremiun() ? 1 : 0) + "," + (s.isEal() ? 1 : 0) + ","
				+ s.getCatMean() + "," + s.getCatVerbal() + "," + s.getCatNonVerbal() + "," + s.getCatQuantative() + "," + s.getCatAverage() + ")";

		ret = query.execute(sql);
		query.close();
		return ret;
	}

	public static boolean update(Student s) throws SQLException {
		boolean retVal = false;
		query = Database.getConnection().createStatement();
		String sql;
		String update = "UPDATE tbl_Student ";
		String set = "SET (" + "surname='" + s.getSurname() + "', forname='" + s.getForname() + "', regGroup=" + s.getRegGroup() + "', gender=" + s.getGender().name() + ", examNumber="
				+ s.getExamNumber() + ", pupilPremiun=" + (s.isPupilPremiun() ? 1 : 0) + ", eal=" + (s.isEal() ? 1 : 0) + ", catMean=" + s.getCatMean() + ", catVerbal=" + s.getCatVerbal()
				+ ", catNonVerbal=" + s.getCatNonVerbal() + ", catQuant=" + s.getCatQuantative() + ", catAverage=" + s.getCatAverage() + ") ";
		String where = " WHERE studentID=" + s.getStudentID();
		sql = update + set + where;
		retVal = query.execute(sql);
		return retVal;
	}

	public static boolean delete(Student s) throws SQLException {
		boolean sen = false;
		boolean allergy = false;
		boolean group = false;
		boolean course = false;
		boolean result = false;
		boolean student = false;

		try {
			query = Database.getConnection().createStatement();

			String senSQL = "DELETE FROM tbl_StudentSen WHERE studentID=" + s.getStudentID();
			String allergySQL = "DELETE FROM tbl_StudentAllergy WHERE studentID=" + s.getStudentID();
			String groupSQL = "DELETE FROM tbl_StudentGroup WHERE studentID=" + s.getStudentID();
			String courseSQL = "DELETE FROM tbl_StudentCourse WHERE studentID=" + s.getStudentID();
			String resultSQL = "DELETE FROM tbl_StudentModuleResult WHERE studentID=" + s.getStudentID();
			String studentSQL = "DELETE FROM tbl_Student WHERE studentID=" + s.getStudentID();

			sen = query.execute(senSQL);
			allergy = query.execute(allergySQL);
			group = query.execute(groupSQL);
			course = query.execute(courseSQL);
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
