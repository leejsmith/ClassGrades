/**
 * 
 */
package model;


/**
 * @author Lee John Smith
 *
 */
public class HomeworkResult {
	private int homeworkID;
	private int homeworkResult;
	private boolean homeworkHanded;
	/**
	 * @param homeworkID
	 * @param homeworkResult
	 * @param homeworkHanded
	 */
	public HomeworkResult(int homeworkID, int homeworkResult, boolean homeworkHanded) {
		super();
		this.homeworkID = homeworkID;
		this.homeworkResult = homeworkResult;
		this.homeworkHanded = homeworkHanded;
	}
	
	/**
	 * @return the homeworkID
	 */
	public int getHomeworkID() {
		return homeworkID;
	}
	
	/**
	 * @param homeworkID the homeworkID to set
	 */
	public void setHomeworkID(int homeworkID) {
		this.homeworkID = homeworkID;
	}
	
	/**
	 * @return the homeworkResult
	 */
	public int getHomeworkResult() {
		return homeworkResult;
	}
	
	/**
	 * @param homeworkResult the homeworkResult to set
	 */
	public void setHomeworkResult(int homeworkResult) {
		this.homeworkResult = homeworkResult;
	}
	
	/**
	 * @return the homeworkHanded
	 */
	public boolean isHomeworkHanded() {
		return homeworkHanded;
	}
	
	/**
	 * @param homeworkHanded the homeworkHanded to set
	 */
	public void setHomeworkHanded(boolean homeworkHanded) {
		this.homeworkHanded = homeworkHanded;
	};
	
	
	
}
