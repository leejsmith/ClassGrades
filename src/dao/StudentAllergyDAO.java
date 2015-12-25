/**
 * 
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;

/**
 * @author Lee John Smith
 *
 */
public class StudentAllergyDAO {

	private static Statement query;

	public static ResultSet select() throws SQLException {
		ResultSet ret = null;

		query = Database.getConnection().createStatement();
		String sql = "SELECT * FROM tbl_StudentAllergy";
		ret = query.executeQuery(sql);
		
		return ret;

	}

	public static ResultSet select(int student) throws SQLException {
		ResultSet ret = null;

		query = Database.getConnection().createStatement();
		String sql = "SELECT * FROM tbl_StudentAllergy WHERE studentID=" + student;
		ret = query.executeQuery(sql);
		
		return ret;

	}

	public static boolean insert(int student, int allergy) throws SQLException {
		boolean ret = false;

		query = Database.getConnection().createStatement();
		String sql = "INSERT INTO tbl_StudentAllergy (studentID, allergyID) VALUES (" + student + "," + allergy + ");";
		ret = query.execute(sql);
		
		return ret;

	}

	public static boolean delete(int id, boolean isStudent) throws SQLException {
		boolean ret = false;
		query = Database.getConnection().createStatement();
		String sql;
		if (isStudent) {
			sql = "DELETE FROM tbl_StudentAllergy WHERE studentID=" + id;
		} else {
			sql = "DELETE FROM tbl_StudentAllergy WHERE allergyID=" + id;
		}
		ret = query.execute(sql);
		
		return ret;

	}
}
