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

	public AllergyList() {
		super();
	}

	public Allergy getAllergyByID(int id) throws UnknownAllergyException {
		for (Allergy a : this) {
			if (a.getAllergyID() == id) {
				return a;
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
		return this.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return this.size();
	}

	public void addAllergy(Allergy allergy) {
		this.add(allergy);
	}

	public void addAllergy(int allergyID, String allergyName) {
		this.add(new Allergy(allergyID, allergyName));
	}

}
