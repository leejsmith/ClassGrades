/**
 * 
 */

package controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import model.InvalidUserException;

/**
 * @author Lee John Smith
 *
 */
public class GeneralDAO {

	private static Statement query;

	private static boolean checkPassword(String salt, String password, String dbPass) {
		String checkPass = getSecurePassword(password, salt);
		System.out.println(checkPass);
		System.out.println(dbPass);
		return checkPass.equals(dbPass);
	}

	public static void createNewUser(String username, String forename, String surname, String password, boolean admin) {
		try {
			query = Database.getConnection().createStatement();
			String userCheck = "SELECT COUNT(*) AS count FROM tbl_Users WHERE userName='" + username + "'";

			ResultSet userCount = query.executeQuery(userCheck);

			userCount.next();
			int count = userCount.getInt("count");

			if (count != 0) {
				throw new InvalidUserException();
			} else {

				String salt = getSalt();
				String encryptedPass = getSecurePassword(password, salt);

				String sql = "INSERT INTO tbl_Users (userName, salt, passwordSec, admin, forename, surname) VALUES ('"
						+ username + "','" + salt + "','" + encryptedPass + "'," + (admin ? 1 : 0) + ",'" + forename
						+ "','" + surname + "')";
				System.out.println(sql);

				query = Database.getConnection().createStatement();
				query.execute(sql);
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String getSalt() throws NoSuchAlgorithmException {

		Random sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[32];
		sr.nextBytes(salt);
		return toHex(salt);
	}

	private static String getSecurePassword(String passwordToHash, String salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes());
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	/**
	 * Converts a byte array into a hexadecimal string.
	 *
	 * @param array
	 *            the byte array to convert
	 * @return a length*2 character string encoding the byte array
	 */
	private static String toHex(byte[] array) {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0)
			return String.format("%0" + paddingLength + "d", 0) + hex;
		else
			return hex;
	}

}
