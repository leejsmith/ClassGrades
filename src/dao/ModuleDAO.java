/**
 * 
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;
import model.Module;

/**
 * @author Lee John Smith
 *
 */
public class ModuleDAO {

	private static Statement query;

	public static ResultSet select() throws SQLException {
		ResultSet ret = null;
		query = Database.getConnection().createStatement();
		String sql = "SELECT * FROM tbl_Module";
		ret = query.executeQuery(sql);
		query.close();
		return ret;
	}

	public static boolean insert(Module m, int courseID) throws SQLException {
		boolean ret = false;
		query = Database.getConnection().createStatement();
		String sql = "INSERT INTO tbl_Module (moduleName, courseID) VALUES ('" + m.getModuleName() + "'," + courseID + ")";
		ret = query.execute(sql);
		query.close();
		return ret;
	}

	public static boolean update(Module m) throws SQLException {
		boolean ret = false;
		query = Database.getConnection().createStatement();
		String sql = "UPDATE tbl_Module " + "SET (moduleName='" + m.getModuleName() + "') WHERE moduleID=" + m.getModuleID() + ");";
		ret = query.execute(sql);
		query.close();
		return ret;
	}

	public static boolean delete(Module m) throws SQLException {
		boolean ret = false;
		query = Database.getConnection().createStatement();
		String sql = "DELETE FROM tbl_Module WHERE moduleID=" + m.getModuleID() + ";";
		ret = query.execute(sql);
		return ret;
	}
}
