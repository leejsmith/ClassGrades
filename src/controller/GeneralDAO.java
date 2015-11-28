/**
 * 
 */

package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AllergyList;
import model.ModuleList;
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
			query = Database.getConnection().createStatement();

			ResultSet rs = query.executeQuery(allergySQL);

			while (rs.next()) {
				int allergyID = rs.getInt("allergyID");
				String allergyName = rs.getString("allergyName");

				allergyList.add(allergyID, allergyName);
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
			query = Database.getConnection().createStatement();

			ResultSet rs = query.executeQuery(senSQL);

			while (rs.next()) {
				int senID = rs.getInt("senID");
				String senName = rs.getString("senName");
				String senShort = rs.getString("senShort");

				senList.add(senID, senName, senShort);
			}
		}
		catch (SQLException e) {

		}
		return senList;
	}

	public static ModuleList getModuleList() {
		ModuleList moduleList = new ModuleList();

		String moduleSQL = "SELECT * FROM tbl_Module";

		try {
			query = Database.getConnection().createStatement();

			ResultSet rs = query.executeQuery(moduleSQL);

			while (rs.next()) {
				int moduleID = rs.getInt("moduleID");
				String moduleName = rs.getString("moduleName");

				moduleList.add(moduleID, moduleName);
			}
		}
		catch (SQLException e) {

		}
		return moduleList;
	}
}
