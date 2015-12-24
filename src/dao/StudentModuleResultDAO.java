package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;

public class StudentModuleResultDAO {
	private static Statement query;

	public static ResultSet select(int student) {
		ResultSet ret = null;
		try {
			query = Database.getConnection().createStatement();
			String sql = "SELECT * FROM tbl_StudentModuleResult WHERE studentID=" + student;
			ret = query.executeQuery(sql);
			query.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;

	}

	public static boolean insert(int student, int module, int result) {
		boolean ret = false;

		try {
			query = Database.getConnection().createStatement();
			String sql = "INSERT INTO tbl_StudentModuleResult (studentID,moduleID,results) VALUES (" + student + ","
					+ module + "," + result + ")";
			ret = query.execute(sql);
			query.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public static boolean delete(int id, boolean isStudent) {
		String sql = "";
		boolean ret = false;
		try {
			query = Database.getConnection().createStatement();
			if (isStudent) {
				sql = "DELETE FROM tbl_StudentModuleResult WHERE studentID=" + id;
			} else {
				sql = "DELETE FROM tbl_StudentModuleResult WHERE moduleID=" + id;
			}
			ret = query.execute(sql);
			query.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
