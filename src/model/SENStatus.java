/**
 * 
 */
package model;

/**
 * @author Lee John Smith
 *
 */
public class SENStatus {
	private int senID;
	private String senStatus;

	public SENStatus(int senID, String status) {
		this.senID = senID;
		this.senStatus = status;
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
	 * @return the senStatus
	 */
	public String getSenStatus() {
		return senStatus;
	}

	/**
	 * @param senStatus
	 *            the senStatus to set
	 */
	public void setSenStatus(String senStatus) {
		this.senStatus = senStatus;
	}

}
