/**
 * 
 */

package model;

/**
 * @author Lee John Smith
 *
 */
public class Sen {

	private int		senID;
	private String	senName;
	private String	senShort;

	/**
	 * @param senID
	 * @param senName
	 */
	public Sen(int senID, String senName, String senShort) {
		super();
		this.senID = senID;
		this.senName = senName;
		this.senShort = senShort;
	}

	/**
	 * @return the senID
	 */
	public int getSenID() {
		return senID;
	}

	/**
	 * @param senID
	 *            the senID to set
	 */
	public void setSenID(int senID) {
		this.senID = senID;
	}

	/**
	 * @return the senName
	 */
	public String getSenName() {
		return senName;
	}

	/**
	 * @param senName
	 *            the senName to set
	 */
	public void setSenName(String senName) {
		this.senName = senName;
	}

	/**
	 * @return the senShort
	 */
	public String getSenShort() {
		return senShort;
	}

	/**
	 * @param senShort
	 *            the senShort to set
	 */
	public void setSenShort(String senShort) {
		this.senShort = senShort;
	}

}
