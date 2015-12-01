/**
 * 
 */

package model;

import java.util.ArrayList;

/**
 * @author Lee John Smith
 *
 */
public class ModuleList {

	private ArrayList<Module> moduleList;

	public ModuleList() {
		moduleList = new ArrayList<Module>();
	}

	public ModuleList(ArrayList<Module> list) {
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

	public Module get(int index) {
		return moduleList.get(index);
	}

	public int size() {
		return moduleList.size();
	}

	public boolean add(Module module) {
		this.moduleList.add(module);

		return moduleList.contains(module);
	}

	public boolean add(int moduleID, String moduleName) {
		Module m = new Module(moduleID, moduleName);
		this.moduleList.add(m);
		return moduleList.contains(m);
	}

}
