/**
 * 
 */

package model;

import java.util.AbstractList;

/**
 * @author Lee John Smith
 *
 */
public class ModuleList extends AbstractList<Module> {

	Module[] moduleList;

	public ModuleList() {
		moduleList = new Module[1];
	}

	public ModuleList(int size) {
		moduleList = new Module[size];
	}

	public ModuleList(Module[] list) {
		this.moduleList = list;
	}

	public Module getModuleByID(int id) throws UnknownModuleException {
		for (Module s : moduleList) {
			if (s.getModuleID() == id) {
				return s;
			}
		}
		throw new UnknownModuleException("Unknown Module");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public Module get(int index) {
		return moduleList[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return moduleList.length;
	}

	@Override
	public boolean add(Module module) {
		if (moduleList.length != 1) {
			Module[] tmp = moduleList;
			moduleList = new Module[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				moduleList[i] = tmp[i];
			}
		}
		moduleList[moduleList.length - 1] = module;

		if (moduleList[moduleList.length - 1].getModuleID() == module.getModuleID()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean add(int moduleID, String moduleName) {
		if (moduleList.length != 1) {
			Module[] tmp = moduleList;
			moduleList = new Module[tmp.length + 1];
			for (int i = 0; i < tmp.length; i++) {
				moduleList[i] = tmp[i];
			}
		}
		moduleList[moduleList.length - 1] = new Module(moduleID, moduleName);
		if (moduleList[moduleList.length - 1].getModuleID() == moduleID) {
			return true;
		}
		else {
			return false;
		}
	}

}
