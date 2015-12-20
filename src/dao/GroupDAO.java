/**
 * 
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Database;
import model.Group;

/**
 * @author Lee John Smith{
 * 
 *
 */
public class GroupDAO {

	private static Statement query;

	public static ResultSet select() throws SQLException {
		ResultSet ret = null;
		query = Database.getConnection().createStatement();
		String sql = "SELECT * FROM tbl_Group";
		ret = query.executeQuery(sql);
		return ret;
	}

	public static boolean insert(Group g) throws SQLException {
		query = Database.getConnection().createStatement();
		String sql = "INSERT INTO tbl_Group (groupName) VALUES ('" + g.getGroupName() + "');";
		boolean ret = query.execute(sql);
		query.close();
		return ret;
	}

	public static boolean update(Group g) throws SQLException {
		query = Database.getConnection().createStatement();
		String sql = "UPDATE tbl_Group SET groupName='" + g.getGroupName() + "' WHERE groupID=" + g.getGroupID() + ";";
		boolean ret = query.execute(sql);
		query.close();
		return ret;
	}

	public static boolean delete(Group g) throws SQLException {
		query = Database.getConnection().createStatement();
		String sql = "DELETE FROM tbl_Group WHERE groupID=" + g.getGroupID() + ";";
		boolean ret = query.execute(sql);
		ret = query.execute(sql);
		query.close();
		return ret;
	}
}
