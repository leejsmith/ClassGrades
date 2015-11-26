/**
 * 
 */

package run;

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
		SenList list = new SenList();

		list.add(new Sen(1, "Test SEN"));
		System.out.println(list.size());
	}

}
