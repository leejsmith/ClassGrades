/**
 * 
 */

package model;

/**
 * @author Lee John Smith
 *
 */
public class Allergy {

	private int		allergyID;
	private String	allergyName;

	/**
	 * @param allergyID
	 * @param allergyName
	 */
	public Allergy(int allergyID, String allergyName) {
		super();
		this.allergyID = allergyID;
		this.allergyName = allergyName;
	}

	/**
	 * @return the allergyID
	 */
	public int getAllergyID() {
		return allergyID;
	}

	/**
	 * @param allergyID
	 *            the allergyID to set
	 */
	public void setAllergyID(int allergyID) {
		this.allergyID = allergyID;
	}

	/**
	 * @return the allergyName
	 */
	public String getAllergyName() {
		return allergyName;
	}

	/**
	 * @param allergyName
	 *            the allergyName to set
	 */
	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}

}
