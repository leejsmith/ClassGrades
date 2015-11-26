/**
 * 
 */

package model;

import java.util.AbstractList;

/**
 * @author Lee John Smith
 *
 */
public class SenList extends AbstractList<Sen> {

	public SenList() {
		super();
	}

	public Sen getSenByID(int id) throws UnknownSenException {
		for (Sen s : this) {
			if (s.getSenID() == id) {
				return s;
			}
		}
		throw new UnknownSenException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public Sen get(int index) {
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

	public void addSen(Sen sen) {
		this.add(sen);
	}

	public void addSen(int senID, String senName) {
		this.add(new Sen(senID, senName));
	}

}
