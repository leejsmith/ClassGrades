/**
 * 
 */

package model;

/**
 * @author Lee John Smith
 *
 */
public class InvalidUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6612836660298805467L;

	public InvalidUserException() {
		super();
	}

	public InvalidUserException(String message) {
		super(message);
	}
}
