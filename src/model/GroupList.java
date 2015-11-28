/**
 * 
 */

package model;

import java.rmi.activation.UnknownGroupException;
import java.util.AbstractList;

/**
 * @author Lee John Smith
 *
 */
public class GroupList extends AbstractList<Group> {

	Group[] groupList;

	public GroupList() {
		groupList = new Group[1];
	}

	public GroupList(int size) {
		groupList = new Group[size];
	}

	public GroupList(Group[] list) {
		this.groupList = list;
	}

	public Group getGroupByID(int id) throws UnknownGroupException {
		for (Group s : groupList) {
			if (s.getGroupID() == id) {
				return s;
			}
		}
		throw new UnknownGroupException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public Group get(int index) {
		return groupList[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return groupList.length;
	}

	@Override
	public boolean add(Group group) {
		if (groupList.length != 1) {
			Group[] tmp = groupList;
			groupList = new Group[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				groupList[i] = tmp[i];
			}
		}
		groupList[groupList.length - 1] = group;

		if (groupList[groupList.length - 1].getGroupID() == group.getGroupID()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean add(int groupID, String groupName) {
		if (groupList.length != 1) {
			Group[] tmp = groupList;
			groupList = new Group[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				groupList[i] = tmp[i];
			}
		}
		groupList[groupList.length - 1] = new Group(groupID, groupName);
		if (groupList[groupList.length - 1].getGroupID() == groupID) {
			return true;
		}
		else {
			return false;
		}
	}

}
