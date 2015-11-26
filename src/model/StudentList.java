/**
 * 
 */

package model;

import java.util.AbstractList;

/**
 * @author Lee John Smith
 *
 */
public class StudentList extends AbstractList<Student> {

	Student[] studentList;

	public StudentList() {
		studentList = new Student[1];
	}

	public StudentList(int size) {
		studentList = new Student[size];
	}

	public StudentList(Student[] list) {
		this.studentList = list;
	}

	public Student getStudentByID(int id) throws UnknownStudentException {
		for (Student s : studentList) {
			if (s.getStudentID() == id) {
				return s;
			}
		}
		throw new UnknownStudentException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public Student get(int index) {
		return studentList[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return studentList.length;
	}

	@Override
	public boolean add(Student student) {
		if (studentList.length != 1) {
			Student[] tmp = studentList;
			studentList = new Student[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				studentList[i] = tmp[i];
			}
		}
		studentList[studentList.length - 1] = student;

		if (studentList[studentList.length - 1].getStudentID() == student.getStudentID()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean add(int studentID, String surname, String forname, String regGroup, Gender gender, int examNumber, boolean pupilPremiun, boolean eal, int catMean, int catVerbal, int catNonVerbal,
			int catQuantative) {
		if (studentList.length != 1) {
			Student[] tmp = studentList;
			studentList = new Student[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				studentList[i] = tmp[i];
			}
		}
		studentList[studentList.length - 1] = new Student(studentID, surname, forname, regGroup, gender, examNumber, pupilPremiun, eal, catMean, catVerbal, catNonVerbal, catQuantative);
		if (studentList[studentList.length - 1].getStudentID() == studentID) {
			return true;
		}
		else {
			return false;
		}
	}

}
