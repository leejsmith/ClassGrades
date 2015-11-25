/**
 * 
 */

package model;

import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class Module {

	private int		moduleID;
	private String	moduleName;
	private ArrayList<Homework> homeworkList;

	/**
	 * @param moduleID
	 * @param moduleName
	 */
	public Module(int moduleID, String moduleName) {
		super();
		this.moduleID = moduleID;
		this.moduleName = moduleName;
	}

	/**
	 * @return the moduleID
	 */
	public int getModuleID() {

		return moduleID;
	}

	/**
	 * @param moduleID
	 *            the moduleID to set
	 */
	public void setModuleID(int moduleID) {

		this.moduleID = moduleID;
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {

		return moduleName;
	}

	/**
	 * @param moduleName
	 *            the moduleName to set
	 */
	public void setModuleName(String moduleName) {

		this.moduleName = moduleName;
	}

	
	/**
	 * @return the homeworkList
	 */
	public ArrayList<Homework> getHomeworkList() {
		return homeworkList;
	}

	
	/**
	 * @param homeworkList the homeworkList to set
	 */
	public void setHomeworkList(ArrayList<Homework> homeworkList) {
		this.homeworkList = homeworkList;
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean add(Homework e) {
		return homeworkList.add(e);
	}

	
}
