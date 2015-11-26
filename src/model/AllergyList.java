/**
 * 
 */

package model;

import java.util.AbstractList;

/**
 * @author Lee John Smith
 *
 */
public class AllergyList extends AbstractList<Allergy> {

	Allergy[] allergyList;

	public AllergyList() {
		allergyList = new Allergy[1];
	}

	public AllergyList(int size) {
		allergyList = new Allergy[size];
	}

	public AllergyList(Allergy[] list) {
		this.allergyList = list;
	}

	public Allergy getAllergyByID(int id) throws UnknownAllergyException {
		for (Allergy s : allergyList) {
			if (s.getAllergyID() == id) {
				return s;
			}
		}
		throw new UnknownAllergyException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public Allergy get(int index) {
		return allergyList[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return allergyList.length;
	}

	@Override
	public boolean add(Allergy allergy) {
		if (allergyList.length != 1) {
			Allergy[] tmp = allergyList;
			allergyList = new Allergy[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				allergyList[i] = tmp[i];
			}
		}
		allergyList[allergyList.length - 1] = allergy;

		if (allergyList[allergyList.length - 1].getAllergyID() == allergy.getAllergyID()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean add(int allergyID, String allergyName) {
		if (allergyList.length != 1) {
			Allergy[] tmp = allergyList;
			allergyList = new Allergy[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				allergyList[i] = tmp[i];
			}
		}
		allergyList[allergyList.length - 1] = new Allergy(allergyID, allergyName);
		if (allergyList[allergyList.length - 1].getAllergyID() == allergyID) {
			return true;
		}
		else {
			return false;
		}
	}

}
