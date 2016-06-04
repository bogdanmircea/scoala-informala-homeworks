package ro.sci.companymanagementsystem;

/**
 * The WrongRoleException is thrown when an employee is given a role that is
 * different from "manager" and "junior" or if one of this two is misspelled.
 * 
 * @author Bobo
 *
 */
public class WrongRoleException extends Exception {

	private static final long serialVersionUID = 1708720499293314543L;

	public WrongRoleException(String s) {
		super(s);
	}

}
