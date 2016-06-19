package ro.sit.electionapp;
/**
 * This is the citizen class were we create the citizens.
 * @author Bobo
 *
 */
public class Citizen extends Person {

	private int CNP;

	public Citizen(String name, int CNP) {
		super(name);
		this.CNP = CNP;
	}

	public int getCNP() {
		return CNP;
	}

}
