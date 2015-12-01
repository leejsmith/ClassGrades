/**
 * 
 */

package model;

import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class AllergyList {

	private ArrayList<Allergy> allergyList;

	public AllergyList() {
		this.allergyList = new ArrayList<Allergy>();
	}

	public AllergyList(ArrayList<Allergy> list) {
		this.allergyList = list;
	}

	public ArrayList<Allergy> getList() {
		return allergyList;
	}

	public Allergy getAllergyByID(int id) throws UnknownAllergyException {
		for (Allergy s : allergyList) {
			if (s.getAllergyID() == id) {
				return s;
			}
		}
		throw new UnknownAllergyException("No Allergy Found");
	}

	public Allergy get(int index) {
		return allergyList.get(index);
	}

	public void add(Allergy allergy) {
		this.allergyList.add(allergy);
	}

	public void add(int id, String name) {
		this.allergyList.add(new Allergy(id, name));
	}

	public int size() {
		return this.allergyList.size();
	}

	public AllergyList compare(AllergyList tmpList) {
		AllergyList retList = new AllergyList();

		for (Allergy b : tmpList.getList()) {
			if (!allergyExists(b)) {
				if (!retList.allergyExists(b)) {
					retList.add(b);
				}
			}
		}
		return retList;
	}

	public boolean allergyExists(Allergy s) {
		for (Allergy list : allergyList) {
			if (list.getAllergyID() == s.getAllergyID()) {
				System.out.println("Exists");
				return true;
			}
		}
		return false;
	}
}
