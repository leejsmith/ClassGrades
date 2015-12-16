/**
 * 
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;
import model.Sen;

/**
 * @author Lee John Smith
 *
 */
public class SenDAO {

	private static Statement query;

	public static ResultSet select() throws SQLException {
		query = Database.getConnection().createStatement();

		String sql = "SELECT * FROM tbl_Sen";

		return query.executeQuery(sql);
	}

	public static boolean insert(Sen sen) throws SQLException {
		query = Database.getConnection().createStatement();

		String sql = "INSERT INTO tbl_Sen(senName) VALUES ('" + sen.getSenName() + "')";
		return query.execute(sql);
	}

	public static boolean update(Sen sen) throws SQLException {
		query = Database.getConnection().createStatement();

		String sql = "UPDATE tbl_Sen SET senName='" + sen.getSenName() + "' WHERE senID=" + sen.getSenID() + ";";
		return query.execute(sql);
	}

	public static boolean delete(Sen sen) throws SQLException {
		query = Database.getConnection().createStatement();

		String sql = "DELETE FROM tbl_Sen WHERE senID=" + sen.getSenID() + ";";
		return query.execute(sql);
	}
}
