/**
 * 
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Lee John Smith
 *
 */
final class Database {

	static Connection getConnection() {
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
