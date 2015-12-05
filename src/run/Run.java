/**
 * 
 */

package run;

import model.DataStore;
import controller.*;
import model.Sen;
import model.SenList;

/**
 * @author Lee John Smith
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//DataStore ds = new DataStore();
		Database.resetDatabase();
	}

	private static void senStudentDBCheck() {
		SenList old = new SenList();
		SenList newL = new SenList();

		old.add(1, "SenOne", "S1");
		old.add(3, "SenThree", "S3");
		old.add(4, "SenFour", "S4");

		newL.add(1, "SenOne", "S1");
		newL.add(2, "SenTwo", "S2");
		newL.add(3, "SenThree", "S3");
		newL.add(5, "SenFive", "S5");

		for (Sen a : old.getList()) {
			System.out.println("OLD: " + a.getSenID());
		}

		for (Sen b : newL.getList()) {
			System.out.println("NEW: " + b.getSenID());
		}

		SenList delete = newL.compare(old);
		SenList insert = old.compare(newL);

		for (Sen a : delete.getList()) {
			System.out.println("DELETE SEN:" + a.getSenID());
		}

		for (Sen b : insert.getList()) {
			System.out.println("INSERT SEN:" + b.getSenID());
		}
	}
}
