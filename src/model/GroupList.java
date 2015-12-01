/**
 * 
 */

package model;

import java.rmi.activation.UnknownGroupException;
import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class GroupList {

	ArrayList<Group> groupList;

	public GroupList() {
		groupList = new ArrayList<Group>();
	}

	public GroupList(ArrayList<Group> list) {
		this.groupList = list;
	}

	public Group getGroupByID(int id) throws UnknownGroupException {
		for (Group s : groupList) {
			if (s.getGroupID() == id) {
				return s;
			}
		}
		throw new UnknownGroupException("Unknown Group");
	}

	public Group get(int index) {
		return groupList.get(index);
	}

	public int size() {
		return groupList.size();
	}

	public boolean add(Group group) {
		this.groupList.add(group);
		return groupList.contains(group);
	}

	public boolean add(int groupID, String groupName) {
		Group g = new Group(groupID, groupName);
		this.groupList.add(g);
		return groupList.contains(g);
	}

}
