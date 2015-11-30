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
		SenList one = new SenList();
		SenList two = new SenList();

		one.add(1, "SenOne", "S1");
		one.add(3, "SenThree", "S3");
		one.add(4, "SenFour", "S4");

		two.add(1, "SenOne", "S1");
		two.add(2, "SenTwo", "S2");
		two.add(3, "SenThree", "S3");
		two.add(5, "SenFive", "S5");

		System.out.println(one.size());
		System.out.println(two.size());

		SenList delete = one.compare(two);
		SenList insert = two.compare(one);

		for (Sen s : one) {
			System.out.println("DELETE SEN:" + s.getSenID());
		}

		for (Sen s : two) {
			System.out.println("INSERT SEN:" + s.getSenID());
		}
	}

}
