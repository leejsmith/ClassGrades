/**
 * 
 */

package model;

/**
 * @author Lee John Smith
 *
 */
public class Group {

	private int			groupID;
	private String		groupName;
	private StudentList	students;

	/**
	 * 
	 * @param groupID
	 * @param groupName
	 * @param students
	 */
	public Group(int groupID, String groupName, StudentList students) {
		this.groupID = groupID;
		this.groupName = groupName;
		this.students = students;
	}

	/**
	 * 
	 * @param groupID
	 * @param groupName
	 */
	public Group(int groupID, String groupName) {
		this.groupID = groupID;
		this.groupName = groupName;
		this.students = new StudentList();
	}

	/**
	 * @return the groupID
	 */
	public int getGroupID() {
		return groupID;
	}

	/**
	 * @param groupID
	 *            the groupID to set
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
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the students
	 */
	public StudentList getStudents() {
		return students;
	}

	/**
	 * @param students
	 *            the students to set
	 */
	public void setStudents(StudentList students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public StudentList compare(StudentList tmpList) {
		StudentList retList = new StudentList();

		for (Student b : tmpList.getStudentsList()) {
			if (!retList.studentExists(b)) {
				if (!retList.studentExists(b)) {
					retList.add(b);
				}
			}
		}
		return retList;
	}

	@Override
	public String toString() {
		return "GroupID: " + groupID + " NAME: " + groupName;
	}
}
