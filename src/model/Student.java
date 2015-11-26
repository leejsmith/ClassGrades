/**
 * 
 */

package model;

import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class Student {

	private int studentID;
	private int examNumber;
	private String surname;
	private String forenames;
	private Gender gender;
	private String regGroup;
	private ArrayList<SENStatus> senStatus;
	private boolean pupilPremium;
	private boolean eal;
	private int catMean;
	private int catVerbal;
	private int catNonVerbal;
	private int catQuantitative;
	private int averagePts;
	private ArrayList<Allergy> allergys;

	/**
	 * @param studentID
	 * @param examNumber
	 * @param surname
	 * @param forenames
	 * @param gender
	 * @param regGroup
	 * @param senStatus
	 * @param pupilPremium
	 * @param catMean
	 * @param catVerbal
	 * @param catNonVerbal
	 * @param averagePts
	 * @param allergys
	 */
	public Student(int studentID, int examNumber, String surname,
			String forenames, Gender gender, String regGroup,
			ArrayList<SENStatus> senStatus, boolean pupilPremium, boolean eal,
			int catMean, int catVerbal, int catNonVerbal, int catQuantitative,
			int averagePts) {
		super();
		this.studentID = studentID;
		this.examNumber = examNumber;
		this.surname = surname;
		this.forenames = forenames;
		this.gender = gender;
		this.regGroup = regGroup;
		this.senStatus = senStatus;
		this.pupilPremium = pupilPremium;
		this.catMean = catMean;
		this.catVerbal = catVerbal;
		this.catQuantitative = catQuantitative;
		this.catNonVerbal = catNonVerbal;
		this.averagePts = averagePts;
	}
	
	/**
	 * @param examNumber
	 * @param surname
	 * @param forenames
	 * @param gender
	 * @param regGroup
	 * @param pupilPremium
	 * @param eal
	 * @param catMean
	 * @param catVerbal
	 * @param catNonVerbal
	 * @param catQuantitative
	 * @param averagePts
	 */
	public Student(int examNumber, String surname, String forenames,
			Gender gender, String regGroup, boolean pupilPremium, boolean eal,
			int catMean, int catVerbal, int catNonVerbal, int catQuantitative,
			int averagePts) {
		super();
		this.examNumber = examNumber;
		this.surname = surname;
		this.forenames = forenames;
		this.gender = gender;
		this.regGroup = regGroup;
		this.pupilPremium = pupilPremium;
		this.eal = eal;
		this.catMean = catMean;
		this.catVerbal = catVerbal;
		this.catNonVerbal = catNonVerbal;
		this.catQuantitative = catQuantitative;
		this.averagePts = averagePts;
	}



	/**
	 * @return the studentID
	 */
	public int getStudentID() {

		return studentID;
	}

	/**
	 * @param studentID
	 *            the studentID to set
	 */
	public void setStudentID(int studentID) {

		this.studentID = studentID;
	}

	/**
	 * @return the examNumber
	 */
	public int getExamNumber() {

		return examNumber;
	}

	/**
	 * @param examNumber
	 *            the examNumber to set
	 */
	public void setExamNumber(int examNumber) {

		this.examNumber = examNumber;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {

		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {

		this.surname = surname;
	}

	/**
	 * @return the forenames
	 */
	public String getForenames() {

		return forenames;
	}

	/**
	 * @param forenames
	 *            the forenames to set
	 */
	public void setForenames(String forenames) {

		this.forenames = forenames;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {

		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {

		this.gender = gender;
	}

	/**
	 * @return the regGroup
	 */
	public String getRegGroup() {

		return regGroup;
	}

	/**
	 * @param regGroup
	 *            the regGroup to set
	 */
	public void setRegGroup(String regGroup) {

		this.regGroup = regGroup;
	}

	/**
	 * @return the senStatus
	 */
	public ArrayList<SENStatus> getSenStatus() {

		return senStatus;
	}

	/**
	 * @param senStatus
	 *            the senStatus to set
	 */
	public void setSenStatus(ArrayList<SENStatus> senStatus) {

		this.senStatus = senStatus;
	}

	/**
	 * @return the pupilPremium
	 */
	public boolean isPupilPremium() {

		return pupilPremium;
	}

	/**
	 * @param pupilPremium
	 *            the pupilPremium to set
	 */
	public void setPupilPremium(boolean pupilPremium) {

		this.pupilPremium = pupilPremium;
	}

	/**
	 * @return the eal
	 */
	public boolean isEal() {
		return eal;
	}

	/**
	 * @param eal
	 *            the eal to set
	 */
	public void setEal(boolean eal) {
		this.eal = eal;
	}

	/**
	 * @return the catMean
	 */
	public int getCatMean() {

		return catMean;
	}

	/**
	 * @param catMean
	 *            the catMean to set
	 */
	public void setCatMean(int catMean) {

		this.catMean = catMean;
	}

	/**
	 * @return the catVerbal
	 */
	public int getCatVerbal() {

		return catVerbal;
	}

	/**
	 * @param catVerbal
	 *            the catVerbal to set
	 */
	public void setCatVerbal(int catVerbal) {

		this.catVerbal = catVerbal;
	}

	/**
	 * @return the catNonVerbal
	 */
	public int getCatNonVerbal() {

		return catNonVerbal;
	}

	/**
	 * @param catNonVerbal
	 *            the catNonVerbal to set
	 */
	public void setCatNonVerbal(int catNonVerbal) {

		this.catNonVerbal = catNonVerbal;
	}

	/**
	 * @return the catQuantitative
	 */
	public int getCatQuantitative() {
		return catQuantitative;
	}

	/**
	 * @param catQuantitative
	 *            the catQuantitative to set
	 */
	public void setCatQuantitative(int catQuantitative) {
		this.catQuantitative = catQuantitative;
	}

	/**
	 * @return the averagePts
	 */
	public int getAveragePts() {

		return averagePts;
	}

	/**
	 * @param averagePts
	 *            the averagePts to set
	 */
	public void setAveragePts(int averagePts) {

		this.averagePts = averagePts;
	}

	/**
	 * @return the allergys
	 */
	public ArrayList<Allergy> getAllergys() {

		return allergys;
	}

	/**
	 * @param allergys
	 *            the allergys to set
	 */
	public void setAllergys(ArrayList<Allergy> allergys) {

		this.allergys = allergys;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "studentID=" + studentID + ", examNumber=" + examNumber
				+ ", surname=" + surname + ", forenames=" + forenames
				+ ", gender=" + gender + ", regGroup=" + regGroup
				+ ", senStatus=" + senStatus + ", pupilPremium=" + pupilPremium
				+ ", catMean=" + catMean + ", catVerbal=" + catVerbal
				+ ", catNonVerbal=" + catNonVerbal + ", averagePts="
				+ averagePts + ", allergys=" + allergys;
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean add(Allergy e) {

		return allergys.add(e);
	}

	/**
	 * @return
	 * @see java.util.ArrayList#isEmpty()
	 */
	public boolean isEmpty() {

		return allergys.isEmpty();
	}

}
