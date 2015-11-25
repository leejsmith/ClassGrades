/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class Unit {
	private int unitID;
	private String unitName;
	private ArrayList<Group> groups;
	private ArrayList<Module> modules;
	
	/**
	 * @param unitID
	 * @param unitName
	 */
	public Unit(int unitID, String unitName) {
		super();
		this.unitID = unitID;
		this.unitName = unitName;
	}
	
	/**
	 * @return the unitID
	 */
	public int getUnitID() {
		return unitID;
	}
	
	/**
	 * @param unitID the unitID to set
	 */
	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}
	
	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}
	
	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	
	/**
	 * @return the groups
	 */
	public ArrayList<Group> getGroups() {
		return groups;
	}

	
	/**
	 * @param groups the groups to set
	 */
	public void setGroups(ArrayList<Group> groups) {
		this.groups = groups;
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean add(Group e) {
		return groups.add(e);
	}

	
	/**
	 * @return the modules
	 */
	public ArrayList<Module> getModules() {
		return modules;
	}

	
	/**
	 * @param modules the modules to set
	 */
	public void setModules(ArrayList<Module> modules) {
		this.modules = modules;
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean add(Module e) {
		return modules.add(e);
	}
	
	
	
	
}
