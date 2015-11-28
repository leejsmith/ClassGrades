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
		if (senList.length != 1) {
			Sen[] tmp = senList;
			senList = new Sen[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				senList[i] = tmp[i];
			}
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
		if (senList.length != 1) {
			Sen[] tmp = senList;
			senList = new Sen[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				senList[i] = tmp[i];
			}
		}
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
		boolean exists = false;
		for (Sen classSen : this.senList) {
			for (Sen tmpSen : tmpList) {
				if (tmpSen.getSenID() == classSen.getSenID()) {
					exists = true;
				}
			}
			if (!exists) {
				tmp.add(classSen);
			}
			exists = false;
		}

		return tmp;
	}

}
