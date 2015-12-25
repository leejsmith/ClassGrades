package model;

public class StudentCourse {
	private Course course;
	private Grades predicted;

	public StudentCourse(Course c, char p) {
		this.course = c;
		this.setPredicted(p);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Grades getPredicted() {
		return predicted;
	}

	public void setPredicted(Grades predicted) {
		this.predicted = predicted;
	}

	public void setPredicted(char p) {
		switch (p) {
		case 'S':
			predicted = Grades.S;
			break;
		case 'A':
			predicted = Grades.A;
			break;
		case 'B':
			predicted = Grades.B;
			break;
		case 'C':
			predicted = Grades.C;
			break;
		case 'D':
			predicted = Grades.D;
			break;
		case 'E':
			predicted = Grades.E;
			break;
		case 'F':
			predicted = Grades.F;
			break;
		case 'G':
			predicted = Grades.G;
			break;
		default:
			predicted = Grades.U;
		}
	}

	public String toString() {
		return course.getCourseName() + " " + predicted.getNumVal();
	}
}
