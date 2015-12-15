/**
 * 
 */

package model;

/**
 * @author Lee John Smith
 *
 */
public class User {

	private String	username, forename, surname;
	private boolean	admin;

	/**
	 * @param username
	 * @param forename
	 * @param surname
	 * @param admin
	 */
	public User(String username, String forename, String surname, boolean admin) {
		this.username = username;
		this.forename = forename;
		this.surname = surname;
		this.admin = admin;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the forename
	 */
	public String getForename() {
		return forename;
	}

	/**
	 * @param forename
	 *            the forename to set
	 */
	public void setForename(String forename) {
		this.forename = forename;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
