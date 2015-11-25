/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class Group {
	private int groupID;
	private String groupName;
	private ArrayList<Student> students;
	
	/**
	 * @param groupID
	 * @param groupName
	 */
	public Group(int groupID, String groupName) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
	}

	/**
	 * @return the groupID
	 */
	public int getGroupID() {
	
		return groupID;
	}
	
	/**
	 * @param groupID the groupID to set
	 */
	public void setGroupID(int groupID) {
	
		this.groupID = groupID;
	}
	
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
	
		return groupName;
	}
	
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
	
		this.groupName = groupName;
	}

	
	/**
	 * @return the students
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}

	
	/**
	 * @param students the students to set
	 */
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	/**
	 * Add new student to the group
	 * 
	 * @param index
	 * @param element
	 * @see java.util.ArrayList#add(int, java.lang.Object)
	 */
	public void add(int index, Student element) {
		students.add(index, element);
	}
	
	
	
}
