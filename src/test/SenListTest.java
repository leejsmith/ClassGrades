/**
 * 
 */

package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Sen;
import model.SenList;
import model.UnknownSenException;

/**
 * @author Lee John Smith
 *
 */
public class SenListTest {

	@Test
	public void testAddSEN() {
		SenList senList = new SenList();
		Sen testAdd = new Sen(1, "Test SEN", "SEN");
		senList.add(testAdd);
		try {
			Sen test = senList.getSenByID(1);
		}
		catch (UnknownSenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(senList.getSenByID(1), testAdd);
		}
		catch (UnknownSenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
