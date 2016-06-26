package ro.sit.electionaplication2016test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ro.sit.electionaplication2016.Candidate;
import ro.sit.electionaplication2016.Citizen;
import ro.sit.electionaplication2016.ElectionBooth;
import ro.sit.electionaplication2016.Mayor;

public class TestElection {

	@Test
	public void TestApp() throws InterruptedException {
		List<Mayor> congresmans = new ArrayList<Mayor>();
		List<Candidate> candidates = new ArrayList<Candidate>();
		ElectionBooth votingSeasion = new ElectionBooth();

		Mayor pnl = new Mayor("Messi");
		Mayor pdl = new Mayor("Ronaldo");
		Mayor pp = new Mayor("Ibracadabra");
		Mayor psd = new Mayor("Putin");

		congresmans.add(pnl);
		congresmans.add(pdl);
		congresmans.add(psd);
		congresmans.add(pp);

		Candidate cj05 = new Candidate(new Citizen("Andreea", "11"), congresmans, pnl);
		Candidate cj06 = new Candidate(new Citizen("Anda", "12"), congresmans, pdl);
		Candidate cj07 = new Candidate(new Citizen("Cipri", "21"), congresmans, pdl);
		Candidate cj08 = new Candidate(new Citizen("Soseta", "13"), congresmans, pdl);
		Candidate cj09 = new Candidate(new Citizen("Femeie", "11"), congresmans, pdl);
		Candidate cj01 = new Candidate(new Citizen("Mishu", "12"), congresmans, pnl);
		Candidate cj02 = new Candidate(new Citizen("Mihai", "21"), congresmans, pnl);
		Candidate cj03 = new Candidate(new Citizen("Bogdan", "13"), congresmans, pnl);
		Candidate cj04 = new Candidate(new Citizen("Ana", "31"), congresmans, pnl);
		Candidate cj10 = new Candidate(new Citizen("Arpi", "12"), congresmans, psd);
		Candidate cj11 = new Candidate(new Citizen("Aluinelu", "21"), congresmans, psd);
		Candidate cj12 = new Candidate(new Citizen("Piscot", "13"), congresmans, pp);
		Candidate cj13 = new Candidate(new Citizen("Canicula", "11"), congresmans, pp);
		Candidate cj15 = new Candidate(new Citizen("Pepsi", "31"), congresmans, pp);
		Candidate cj14 = new Candidate(new Citizen("DrDre", "31"), congresmans, pp);

		candidates.add(cj05);
		candidates.add(cj06);
		candidates.add(cj07);
		candidates.add(cj08);
		candidates.add(cj09);
		candidates.add(cj10);
		candidates.add(cj11);
		candidates.add(cj12);
		candidates.add(cj13);
		candidates.add(cj14);
		candidates.add(cj15);
		candidates.add(cj01);
		candidates.add(cj02);
		candidates.add(cj03);
		candidates.add(cj04);
		candidates.add(cj04);

		votingSeasion.vote(candidates);

		votingSeasion.validateVotes(congresmans);
	}

}
