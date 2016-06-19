package ro.sit.electionapp;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the mayor class. This class allows us to add votes, remove votes,
 * count the votes of the mayors created. The mayor class extends the Person
 * class. The class contains a list of mayors so you can add the mayors to the
 * list for further use.
 * 
 * @author Bobo
 *
 */
public class Mayor extends Person {

	private int numberOfVotes = 0;

	public Mayor(String name) {
		super(name);
	}

	List<Mayor> mayors = new ArrayList<Mayor>();

	public void add(Mayor mayor) {
		mayors.add(mayor);
	}

	public int getNumberOfVotes() {
		return numberOfVotes;
	}

	public int addVote() {
		return numberOfVotes++;

	}

	public int removeVote() {
		return numberOfVotes--;

	}

}
