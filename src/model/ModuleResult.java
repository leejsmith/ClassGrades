/**
 * 
 */

package model;

/**
 * @author Lee John Smith
 *
 */
public class ModuleResult {

	private Module	module;
	private int		result;

	/**
	 * @param module
	 * @param result
	 */
	public ModuleResult(Module module, int result) {
		super();
		this.module = module;
		this.result = result;
	}

	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * @param module
	 *            the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}

}
