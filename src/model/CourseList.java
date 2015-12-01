/**
 * 
 */

package model;

import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class CourseList {

	private ArrayList<Course> courseList;

	public CourseList() {
		courseList = new ArrayList<Course>();
	}

	public CourseList(ArrayList<Course> list) {
		this.courseList = list;
	}

	public Course getCourseByID(int id) throws UnknownCourseException {
		for (Course s : courseList) {
			if (s.getCourseID() == id) {
				return s;
			}
		}
		throw new UnknownCourseException("Unknown Course");
	}

	public Course get(int index) {
		return courseList.get(index);
	}

	public int size() {
		return courseList.size();
	}

	public boolean add(Course course) {
		this.courseList.add(course);

		return this.courseList.contains(course);
	}

	public boolean add(int courseID, String courseName) {
		Course c = new Course(courseID, courseName);
		this.courseList.add(c);
		return courseList.contains(c);
	}

}
