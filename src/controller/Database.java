/**
 * 
 */

package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Lee John Smith
 *
 */
public final class Database {

	public static Connection getConnection() {
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
	
	public static Connection getConnection(String path) {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+path);
		}
		catch (Exception e) {
			System.err.println("Failed to connect to database, System will now exit");
		}

		return c;
	}
	
	public static void resetDatabase(){
		try {
			Statement query = getConnection().createStatement();
			String path = "./files/classgradesnew.sqlite3";
			File f = new File(path);
			File newF = new File("./files/class.sqlite3");
			newF.createNewFile();
			boolean deleted = new File(path).delete();
			System.out.println(f.exists() + " - " + deleted);
			f.createNewFile();
			
			BufferedReader br = new BufferedReader(new FileReader("./files/classgrades.sql"));
			String line="";
			query = getConnection("./files/class.sqlite3").createStatement();
			while((line = br.readLine())!=null){
				query.execute(line);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
