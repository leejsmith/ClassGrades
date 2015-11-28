/**
 * 
 */

package model;

/**
 * @author Lee John Smith
 *
 */
public class Module {

	private int		moduleID;
	private String	moduleName;

	public Module(int moduleID, String moduleName) {
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

}
