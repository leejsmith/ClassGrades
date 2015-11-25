/**
 * 
 */

package model;

/**
 * @author Lee John Smith
 *
 */
public class Homework {

	private int		homeworkID;
	private String	homeworkName;
	private int		homeworkMax;

	/**
	 * @param homeworkID
	 * @param homeworkName
	 * @param homeworkMax
	 */
	public Homework(int homeworkID, String homeworkName, int homeworkMax) {
		super();
		this.homeworkID = homeworkID;
		this.homeworkName = homeworkName;
		this.homeworkMax = homeworkMax;
	}

	/**
	 * @return the homeworkID
	 */
	public int getHomeworkID() {

		return homeworkID;
	}

	/**
	 * @param homeworkID
	 *            the homeworkID to set
	 */
	public void setHomeworkID(int homeworkID) {

		this.homeworkID = homeworkID;
	}

	/**
	 * @return the homeworkName
	 */
	public String getHomeworkName() {

		return homeworkName;
	}

	/**
	 * @param homeworkName
	 *            the homeworkName to set
	 */
	public void setHomeworkName(String homeworkName) {

		this.homeworkName = homeworkName;
	}

	/**
	 * @return the homeworkMax
	 */
	public int getHomeworkMax() {

		return homeworkMax;
	}

	/**
	 * @param homeworkMax
	 *            the homeworkMax to set
	 */
	public void setHomeworkMax(int homeworkMax) {

		this.homeworkMax = homeworkMax;
	}

}
