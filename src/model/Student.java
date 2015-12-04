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

	private int						studentID;
	private String					surname;
	private String					forname;
	private String					regGroup;
	private Gender					gender;
	private int						examNumber;
	private boolean					pupilPremiun;
	private boolean					eal;
	private int						catMean;
	private int						catVerbal;
	private int						catNonVerbal;
	private int						catQuantative;
	private int						catAverage;

	private SenList					senStatus;
	private AllergyList				allergyList;
	private ArrayList<ModuleResult>	results;

	/**
	 * @param studentID
	 * @param surname
	 * @param forname
	 * @param regGroup
	 * @param gender
	 * @param examNumber
	 * @param pupilPremiun
	 * @param eal
	 * @param catMean
	 * @param catVerbal
	 * @param catNonVerbal
	 * @param catQuantative
	 */
	public Student(int studentID, String surname, String forname, String regGroup, Gender gender, int examNumber, boolean pupilPremiun, boolean eal, int catMean, int catVerbal, int catNonVerbal,
			int catQuantative, int catAverage) {
		super();
		this.studentID = studentID;
		this.surname = surname;
		this.forname = forname;
		this.regGroup = regGroup;
		this.gender = gender;
		this.examNumber = examNumber;
		this.pupilPremiun = pupilPremiun;
		this.eal = eal;
		this.catMean = catMean;
		this.catVerbal = catVerbal;
		this.catNonVerbal = catNonVerbal;
		this.catQuantative = catQuantative;
		this.catAverage = catAverage;
		this.results = new ArrayList<ModuleResult>();
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
	 * @return the forname
	 */
	public String getForname() {
		return forname;
	}

	/**
	 * @param forname
	 *            the forname to set
	 */
	public void setForname(String forname) {
		this.forname = forname;
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
	 * @return the pupilPremiun
	 */
	public boolean isPupilPremiun() {
		return pupilPremiun;
	}

	/**
	 * @param pupilPremiun
	 *            the pupilPremiun to set
	 */
	public void setPupilPremiun(boolean pupilPremiun) {
		this.pupilPremiun = pupilPremiun;
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
	 * @return the catQuantative
	 */
	public int getCatQuantative() {
		return catQuantative;
	}

	/**
	 * @param catQuantative
	 *            the catQuantative to set
	 */
	public void setCatQuantative(int catQuantative) {
		this.catQuantative = catQuantative;
	}

	/**
	 * @return the catAverage
	 */
	public int getCatAverage() {
		return catAverage;
	}

	/**
	 * @param catAverage
	 *            the catAverage to set
	 */
	public void setCatAverage(int catAverage) {
		this.catAverage = catAverage;
	}

	/**
	 * @return the senStatus
	 */
	public SenList getSenStatus() {
		return senStatus;
	}

	/**
	 * @param senStatus
	 *            the senStatus to set
	 */
	public void setSenStatus(SenList senStatus) {
		this.senStatus = senStatus;
	}

	/**
	 * 
	 * @param sen
	 */
	public void addSenStatus(Sen sen) {
		this.senStatus.add(sen);
	}

	/**
	 * @return the allergyList
	 */
	public AllergyList getAllergyList() {
		return allergyList;
	}

	/**
	 * @param allergyList
	 *            the allergyList to set
	 */
	public void setAllergyList(AllergyList allergyList) {
		this.allergyList = allergyList;
	}

	public void addAllergy(Allergy allergy) {
		this.allergyList.add(allergy);
	}

	/**
	 * @return the results
	 */
	public ArrayList<ModuleResult> getResults() {
		return results;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	public void setResults(ArrayList<ModuleResult> results) {
		this.results = results;
	}

	public void addResult(ModuleResult mr) {
		this.results.add(mr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentID=" + studentID + " Surname: " + surname + " Forname: " + forname + " regGroup: " + regGroup + " gender: " + gender + " examNumber: " + examNumber + ", pupilPremiun: "
				+ pupilPremiun + " eal: " + eal + " catMean: " + catMean + " catVerbal: " + catVerbal + " catNonVerbal: " + catNonVerbal + " catQuantative: " + catQuantative + " catAverage: "
				+ catAverage;
	}

}
