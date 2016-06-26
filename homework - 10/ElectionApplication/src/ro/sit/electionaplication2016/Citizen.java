package ro.sit.electionaplication2016;

public class Citizen extends Person {

	private String CNP;

	public Citizen(String name, String CNP) {
		super(name);
		this.CNP = CNP;
	}

	public String getCNP() {
		return CNP;
	}

}
