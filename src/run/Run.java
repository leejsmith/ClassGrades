/**
 * 
 */
package run;

import javax.swing.JFileChooser;

import controller.StudentDAO;

/**
 * @author Lee John Smith
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(null);
		String path = fc.getSelectedFile().getAbsolutePath();
		StudentDAO.importStudentCSV(path);
	}

}
