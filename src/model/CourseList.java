/**
 * 
 */

package model;

import java.util.AbstractList;

/**
 * @author Lee John Smith
 *
 */
public class CourseList extends AbstractList<Course> {

	Course[] courseList;

	public CourseList() {
		courseList = new Course[1];
	}

	public CourseList(int size) {
		courseList = new Course[size];
	}

	public CourseList(Course[] list) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public Course get(int index) {
		return courseList[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return courseList.length;
	}

	@Override
	public boolean add(Course course) {
		if (courseList.length != 1) {
			Course[] tmp = courseList;
			courseList = new Course[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				courseList[i] = tmp[i];
			}
		}
		courseList[courseList.length - 1] = course;

		if (courseList[courseList.length - 1].getCourseID() == course.getCourseID()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean add(int courseID, String courseName) {
		if (courseList.length != 1) {
			Course[] tmp = courseList;
			courseList = new Course[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				courseList[i] = tmp[i];
			}
		}
		courseList[courseList.length - 1] = new Course(courseID, courseName);
		if (courseList[courseList.length - 1].getCourseID() == courseID) {
			return true;
		}
		else {
			return false;
		}
	}

}
