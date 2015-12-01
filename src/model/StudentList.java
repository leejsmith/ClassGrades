/**
 * 
 */

package model;

import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class StudentList {

	ArrayList<Student> studentList;

	public StudentList() {
		this.studentList = new ArrayList<Student>();
	}

	public StudentList(ArrayList<Student> list) {
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

	public StudentList getStudentByName(String surname, String forename) throws StudentNotFoundException {
		StudentList tmp = new StudentList();
		for (Student s : studentList) {
			if (s.getForname().contains(forename) && !contains(s)) {
				tmp.add(s);
			}
			if (s.getSurname().contains(surname) && !contains(s)) {
				tmp.add(s);
			}
		}
		if (tmp.size() == 0)
			throw new StudentNotFoundException();
		return tmp;
	}

	public Student getStudentByExamNumber(int examNumber) throws UnknownStudentException {
		for (Student s : studentList) {
			if (s.getExamNumber() == examNumber) {
				return s;
			}
		}
		throw new UnknownStudentException("Student Not Found");
	}

	public boolean contains(Student student) {
		for (Student s : studentList) {
			if (s.equals(student)) {
				return true;
			}
		}
		return false;
	}

	public Student get(int index) {
		return studentList.get(index);
	}

	public ArrayList<Student> getStudentsList() {
		return studentList;
	}

	public int size() {
		return studentList.size();
	}

	public void add(Student student) {
		this.studentList.add(student);
	}

	public void add(int studentID, String surname, String forname, String regGroup, Gender gender, int examNumber, boolean pupilPremiun, boolean eal, int catMean, int catVerbal, int catNonVerbal,
			int catQuantative, int catAverage) {
		this.studentList.add(new Student(studentID, surname, forname, regGroup, gender, examNumber, pupilPremiun, eal, catMean, catVerbal, catNonVerbal, catQuantative, catAverage));

	}

	public StudentList compare(StudentList tmpList) {
		StudentList retList = new StudentList();

		for (Student b : tmpList.getStudentsList()) {
			if (!studentExists(b)) {
				if (!retList.studentExists(b)) {
					retList.add(b);
				}
			}
		}
		return retList;
	}

	public boolean studentExists(Student s) {
		for (Student list : studentList) {
			if (list.getStudentID() == s.getStudentID()) {
				System.out.println("Exists");
				return true;
			}
		}
		return false;
	}
}
