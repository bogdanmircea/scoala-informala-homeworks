package ro.sci.companymanagementsystem;

/**
 * The WrongYearsOfWorkException is thrown when the years of working are 0 or
 * below.
 * 
 * @author Bobo
 *
 */
public class WrongYearsOfWorkException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongYearsOfWorkException(String s) {
		super(s);
	}

}
