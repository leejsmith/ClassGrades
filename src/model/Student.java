/**
 * 
 */
package model;

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
	private int pupilPremium;
	private SENStatus senStatus;
	private int catMean;
	private int average;
	private int catVerbal;
	private int catNonVerbal;

	/**
	 * @param studentID
	 * @param examNumber
	 * @param surname
	 * @param forenames
	 * @param gender
	 * @param regGroup
	 * @param pupilPremium
	 * @param senStatus
	 * @param catMean
	 * @param average
	 * @param catVerbal
	 * @param catNonVerbal
	 */
	public Student(int studentID, int examNumber, String surname, String forenames, Gender gender, String regGroup,
			int pupilPremium, SENStatus senStatus, int catMean, int average, int catVerbal, int catNonVerbal) {
		super();
		this.studentID = studentID;
		this.examNumber = examNumber;
		this.surname = surname;
		this.forenames = forenames;
		this.gender = gender;
		this.regGroup = regGroup;
		this.pupilPremium = pupilPremium;
		this.senStatus = senStatus;
		this.catMean = catMean;
		this.average = average;
		this.catVerbal = catVerbal;
		this.catNonVerbal = catNonVerbal;
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
	 * @return the pupilPremium
	 */
	public int getPupilPremium() {
		return pupilPremium;
	}

	/**
	 * @param pupilPremium
	 *            the pupilPremium to set
	 */
	public void setPupilPremium(int pupilPremium) {
		this.pupilPremium = pupilPremium;
	}

	/**
	 * @return the senStatus
	 */
	public SENStatus getSenStatus() {
		return senStatus;
	}

	/**
	 * @param senStatus
	 *            the senStatus to set
	 */
	public void setSenStatus(SENStatus senStatus) {
		this.senStatus = senStatus;
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
	 * @return the average
	 */
	public int getAverage() {
		return average;
	}

	/**
	 * @param average
	 *            the average to set
	 */
	public void setAverage(int average) {
		this.average = average;
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

}
