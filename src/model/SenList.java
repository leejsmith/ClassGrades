/**
 * 
 */

package model;

import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class SenList {

	private ArrayList<Sen> senList;

	public SenList() {
		this.senList = new ArrayList<Sen>();
	}

	public SenList(ArrayList<Sen> list) {
		this.senList = list;
	}

	public ArrayList<Sen> getList() {
		return senList;
	}

	public Sen getSenByID(int id) throws UnknownSenException {
		for (Sen s : senList) {
			if (s.getSenID() == id) {
				return s;
			}
		}
		throw new UnknownSenException("No Sen Found");
	}

	public Sen get(int index) {
		return senList.get(index);
	}

	public void add(Sen sen) {
		this.senList.add(sen);
	}

	public void add(int id, String name, String shortName) {
		this.senList.add(new Sen(id, name, shortName));
	}

	public int size() {
		return this.senList.size();
	}

	public SenList compare(SenList tmpList) {
		SenList retList = new SenList();

		for (Sen b : tmpList.getList()) {
			if (!senExists(b)) {
				if (!retList.senExists(b)) {
					retList.add(b);
				}
			}
		}
		return retList;
	}

	public boolean senExists(Sen s) {
		for (Sen list : senList) {
			if (list.getSenID() == s.getSenID()) {
				System.out.println("Exists");
				return true;
			}
		}
		return false;
	}
}
