package ro.sit.electionapp;

/**
 * This is an abstract class.
 * 
 * @author Bobo
 *
 */
public abstract class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
