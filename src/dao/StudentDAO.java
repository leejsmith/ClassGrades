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

	public static ResultSet select() {
		ResultSet ret = null;
		try {
			query = Database.getConnection().createStatement();
			String sql = "SELECT * FROM tbl_Student";
			ret = query.executeQuery(sql);
			query.close();
			return ret;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public static boolean insert(Student s) {
		try {
			boolean ret = false;
			query = Database.getConnection().createStatement();
			String sql = "INSERT INTO tbl_Student(surname, forename, regGroup, gender,examNumber,pupilPremium,eal,catMean,catVerbal,catNonVerbal,catQuant,catAverage) VALUES ('"
					+ s.getSurname() + "','" + s.getForname() + "','" + s.getRegGroup() + "','"
					+ s.getGender().toString() + "'," + s.getExamNumber() + (s.isPupilPremiun() ? 1 : 0) + ","
					+ (s.isEal() ? 1 : 0) + "," + s.getCatMean() + "," + s.getCatVerbal() + "," + s.getCatNonVerbal()
					+ "," + s.getCatQuantative() + "," + s.getCatAverage() + ")";

			ret = query.execute(sql);
			query.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean update(Student s) {
		try {
			boolean retVal = false;
			query = Database.getConnection().createStatement();
			String sql;
			String update = "UPDATE tbl_Student ";
			String set = "SET (" + "surname='" + s.getSurname() + "', forname='" + s.getForname() + "', regGroup="
					+ s.getRegGroup() + "', gender=" + s.getGender().name() + ", examNumber=" + s.getExamNumber()
					+ ", pupilPremiun=" + (s.isPupilPremiun() ? 1 : 0) + ", eal=" + (s.isEal() ? 1 : 0) + ", catMean="
					+ s.getCatMean() + ", catVerbal=" + s.getCatVerbal() + ", catNonVerbal=" + s.getCatNonVerbal()
					+ ", catQuant=" + s.getCatQuantative() + ", catAverage=" + s.getCatAverage() + ") ";
			String where = " WHERE studentID=" + s.getStudentID();
			sql = update + set + where;
			retVal = query.execute(sql);
			return retVal;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean delete(Student s) {
		boolean sen = false;
		boolean allergy = false;
		boolean group = false;
		boolean course = false;
		boolean result = false;
		boolean student = false;

		sen = StudentSenDAO.delete(s.getStudentID(), true);
		allergy = StudentAllergyDAO.delete(s.getStudentID(), true);
		group = StudentGroupDAO.delete(s.getStudentID(), true);
		course = StudentCourseDAO.delete(s.getStudentID(), true);
		result = StudentModuleResultDAO.delete(s.getStudentID(), true);
		try {
			student = query.execute("DELETE FROM tbl_Student WHERE studentID=" + s.getStudentID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sen && allergy && group && result && student && course;
	}
}
