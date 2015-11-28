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
	private StudentList	students;

	/**
	 * 
	 * @param courseID
	 * @param courseName
	 * @param students
	 */
	public Course(int courseID, String courseName, StudentList students) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.students = students;
	}

	/**
	 * 
	 * @param courseID
	 * @param courseName
	 */
	public Course(int courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.students = new StudentList(1);
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
	public StudentList getStudents() {
		return students;
	}
}
