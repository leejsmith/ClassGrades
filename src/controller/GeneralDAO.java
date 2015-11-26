/**
 * 
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AllergyList;
import model.SenList;

/**
 * @author Lee John Smith
 *
 */
public class GeneralDAO {

	private static Statement query;

	public static AllergyList getAllergyList() {
		AllergyList allergyList = new AllergyList();

		String allergySQL = "SELECT * FROM tbl_Allergy";

		try {
			query = getConnection().createStatement();

			ResultSet rs = query.executeQuery(allergySQL);

			while (rs.next()) {
				int allergyID = rs.getInt("allergyID");
				String allergyName = rs.getString("allergyName");

				allergyList.addAllergy(allergyID, allergyName);
			}
		}
		catch (SQLException e) {

		}
		return allergyList;
	}

	public static SenList getSenList() {
		SenList senList = new SenList();

		String senSQL = "SELECT * FROM tbl_Sen";

		try {
			query = getConnection().createStatement();

			ResultSet rs = query.executeQuery(senSQL);

			while (rs.next()) {
				int senID = rs.getInt("senID");
				String senName = rs.getString("senName");

				senList.addSen(senID, senName);
			}
		}
		catch (SQLException e) {

		}
		return senList;
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
