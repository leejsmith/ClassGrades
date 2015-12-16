/**
 * 
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;
import model.Allergy;

/**
 * @author Lee John Smith
 *
 */
public class AllegyDAO {

	private static Statement query;

	public static ResultSet select() throws SQLException {
		query = Database.getConnection().createStatement();

		String sql = "SELECT * FROM tbl_Allergy";

		ResultSet rs = query.executeQuery(sql);
		query.close();
		return rs;
	}

	public static boolean insert(Allergy allergy) throws SQLException {
		query = Database.getConnection().createStatement();

		String sql = "INSERT INTO tbl_Allergy(allergyName) VALUES ('" + allergy.getAllergyName() + "')";
		boolean ret = query.execute(sql);
		query.close();
		return ret;
	}

	public static boolean update(Allergy allergy) throws SQLException {
		query = Database.getConnection().createStatement();

		String sql = "UPDATE tbl_Allergy SET allergyName='" + allergy.getAllergyName() + "' WHERE allergyID=" + allergy.getAllergyID() + ";";
		boolean ret = query.execute(sql);
		query.close();
		return ret;
	}

	public static boolean delete(Allergy allergy) throws SQLException {
		query = Database.getConnection().createStatement();

		String sql = "DELETE FROM tbl_Allergy WHERE allergyID=" + allergy.getAllergyID() + ";";
		boolean ret = query.execute(sql);
		query.close();
		return ret;
	}
}
