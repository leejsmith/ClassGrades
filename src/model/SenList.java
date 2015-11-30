/**
 * 
 */

package model;

import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class SenList extends ArrayList<Sen> {

	Sen[] senList;

	public SenList() {
		senList = new Sen[1];
	}

	public SenList(int size) {
		senList = new Sen[size];
	}

	public SenList(Sen[] list) {
		this.senList = list;
	}

	public Sen getSenByID(int id) throws UnknownSenException {
		for (Sen s : senList) {
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
		return senList[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return senList.length;
	}

	@Override
	public boolean add(Sen sen) {
		Sen[] tmp = this.senList;
		this.senList = new Sen[tmp.length + 1];
		for (int i = 0; i < tmp.length; i++) {
			this.senList[i] = tmp[i];
		}

		senList[senList.length - 1] = sen;

		if (senList[senList.length - 1].getSenID() == sen.getSenID()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean add(int senID, String senName, String senShort) {

		Sen[] tmp = this.senList;
		senList = new Sen[tmp.length + 1];
		for (int i = 0; i < tmp.length; i++) {
			senList[i] = tmp[i];
		}

		senList[0] = new Sen(senID, senName, senShort);

		senList[senList.length - 1] = new Sen(senID, senName, senShort);
		if (senList[senList.length - 1].getSenID() == senID) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Compares 2 Lists of SEN status's, returns a List of SENs that are not
	 * within the classlist.
	 * 
	 * @param tmpList
	 * @return
	 */
	public SenList compare(SenList tmpList) {
		SenList tmp = new SenList();
		System.out.println("SenList Size: " + senList.length + "     tmpList Size: " + tmpList.size());
		boolean exists = false;
		for (int i = 0; i < senList.length; i++) {
			for (int j = 0; j < tmpList.size(); i++) {
				if (tmpList.get(j).getSenID() == senList[i].getSenID()) {
					exists = true;
					System.out.println("tmp: " + tmpList.get(j).getSenID() + "   class:" + senList[i].getSenID());
				}
			}
			if (!exists) {
				tmp.add(senList[i]);
			}
			exists = false;
		}

		return tmp;
	}
}
