package ro.sit.electionaplication2016;

import java.util.ArrayList;
import java.util.List;

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
		return numberOfVotes -= 2;

	}

}
