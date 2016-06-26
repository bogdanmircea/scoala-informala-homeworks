package ro.sit.electionaplication2016;

import java.util.ArrayList;
import java.util.List;

public class Candidate {

	private Citizen citizen;
	private List<Mayor> mayors;
	private Mayor mayor;

	List<Candidate> candidates = new ArrayList<Candidate>();

	public Candidate(Citizen citizen, List<Mayor> mayors, Mayor mayor) {
		this.citizen = citizen;
		this.mayors = mayors;
		this.mayor = mayor;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public List<Mayor> getMayors() {
		return mayors;
	}

	public Mayor getMayor() {
		return mayor;
	}

	public void add(Candidate c) {
		candidates.add(c);
	}
}
