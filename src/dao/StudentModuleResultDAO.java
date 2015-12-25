package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;

public class StudentModuleResultDAO {
	private static Statement query;

	public static ResultSet select(int student) throws SQLException {
		ResultSet ret = null;
		query = Database.getConnection().createStatement();
		String sql = "SELECT * FROM tbl_StudentModuleResult WHERE studentID=" + student;
		ret = query.executeQuery(sql);
		query.close();
		return ret;
	}

	public static boolean insert(int student, int module, int result) throws SQLException {
		boolean ret = false;

		query = Database.getConnection().createStatement();
		String sql = "INSERT INTO tbl_StudentModuleResult (studentID,moduleID,results) VALUES (" + student + ","
				+ module + "," + result + ")";
		ret = query.execute(sql);
		query.close();
		return ret;

	}

	public static boolean delete(int id, boolean isStudent) throws SQLException {
		String sql = "";
		boolean ret = false;
		query = Database.getConnection().createStatement();
		if (isStudent) {
			sql = "DELETE FROM tbl_StudentModuleResult WHERE studentID=" + id;
		} else {
			sql = "DELETE FROM tbl_StudentModuleResult WHERE moduleID=" + id;
		}
		ret = query.execute(sql);
		query.close();
		return ret;

	}
}
