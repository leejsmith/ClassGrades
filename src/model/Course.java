/**
 * 
 */

package model;

/**
 * @author Lee John Smith
 *
 */
public class Course {

	private int			courseID;
	private String		courseName;
	private GroupList	groups;
	private ModuleList	modules;

	/**
	 * 
	 * @param courseID
	 * @param courseName
	 * @param students
	 */
	public Course(int courseID, String courseName, GroupList groups, ModuleList modules) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.groups = groups;
		this.modules = modules;
	}

	/**
	 * 
	 * @param courseID
	 * @param courseName
	 */
	public Course(int courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.groups = new GroupList();
		this.modules = new ModuleList();
	}

	/**
	 * @return the courseID
	 */
	public int getCourseID() {
		return courseID;
	}

	/**
	 * @param courseID
	 *            the courseID to set
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName
	 *            the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the students
	 */
	public GroupList getGroups() {
		return groups;
	}

	public void addGroup(Group g) {
		this.groups.add(g);
	}

	public ModuleList getModules() {
		return modules;
	}

	public void addModule(Module m) {
		this.modules.add(m);
	}

	@Override
	public String toString() {
		return "CourseID: " + courseID + " NAME: " + courseName;
	}
}
