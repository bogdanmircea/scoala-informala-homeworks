package ro.sit.electionaplication2016;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		List<Mayor> congresmans = new ArrayList<Mayor>();
		List<Candidate> candidates = new ArrayList<Candidate>();
		ElectionBooth votingSeasion = new ElectionBooth();

		Mayor pnl = new Mayor("Hitler");
		Mayor pdl = new Mayor("Stalin");
		Mayor pp = new Mayor("Mussolini");
		Mayor psd = new Mayor("Ceausescu");

		congresmans.add(pnl);
		congresmans.add(pdl);
		congresmans.add(psd);
		congresmans.add(pp);

		Candidate cj05 = new Candidate(new Citizen("Andreea", "1111111111100"), congresmans, pnl);
		Candidate cj06 = new Candidate(new Citizen("Anda", "1111111111101"), congresmans, pdl);
		Candidate cj07 = new Candidate(new Citizen("Cipri", "1111111111102"), congresmans, pdl);
		Candidate cj08 = new Candidate(new Citizen("Soseta", "1111111111103"), congresmans, pdl);
		Candidate cj09 = new Candidate(new Citizen("Femeie", "1111111111104"), congresmans, pdl);
		Candidate cj01 = new Candidate(new Citizen("Miki", "1111111111105"), congresmans, pnl);
		Candidate cj02 = new Candidate(new Citizen("Mihai", "1111111111106"), congresmans, pnl);
		Candidate cj03 = new Candidate(new Citizen("Bogdan", "1111111111107"), congresmans, pnl);
		Candidate cj04 = new Candidate(new Citizen("Ana", "1111111111108"), congresmans, pnl);
		Candidate cj10 = new Candidate(new Citizen("Arpi", "1111111110911"), congresmans, psd);
		Candidate cj11 = new Candidate(new Citizen("Aluinelu", "1111111111110"), congresmans, psd);
		Candidate cj12 = new Candidate(new Citizen("Piscot", "1111111111111"), congresmans, pp);
		Candidate cj13 = new Candidate(new Citizen("Canicula", "1111111111112"), congresmans, pp);
		Candidate cj15 = new Candidate(new Citizen("Pepsi", "1111111111113"), congresmans, pp);
		Candidate cj14 = new Candidate(new Citizen("DrDre", "1111111111114"), congresmans, pp);
		Candidate cj16 = new Candidate(new Citizen("Andreea", "111111111115"), congresmans, pnl);
		Candidate cj17 = new Candidate(new Citizen("Anda", "1111111111116"), congresmans, pdl);
		Candidate cj18 = new Candidate(new Citizen("Cipri", "1111111111117"), congresmans, pdl);
		Candidate cj19 = new Candidate(new Citizen("Soseta", "1111111111118"), congresmans, pdl);
		Candidate cj20 = new Candidate(new Citizen("Femeie", "1111111111119"), congresmans, pdl);
		Candidate cj21 = new Candidate(new Citizen("Mishu", "1111111111120"), congresmans, pnl);
		Candidate cj22 = new Candidate(new Citizen("Mihai", "1111111111121"), congresmans, pnl);
		Candidate cj23 = new Candidate(new Citizen("Bogdan", "1111111111122"), congresmans, pnl);
		Candidate cj24 = new Candidate(new Citizen("Ana", "1111111111123"), congresmans, pnl);
		Candidate cj25 = new Candidate(new Citizen("Arpi", "1111111111124"), congresmans, psd);
		Candidate cj26 = new Candidate(new Citizen("Aluinelu", "1111111111125"), congresmans, psd);
		Candidate cj27 = new Candidate(new Citizen("Piscot", "1111111111126"), congresmans, pp);
		Candidate cj28 = new Candidate(new Citizen("Canicula", "1111111111127"), congresmans, pp);
		Candidate cj29 = new Candidate(new Citizen("Pepsi", "1111111111128"), congresmans, pp);
		Candidate cj30 = new Candidate(new Citizen("DrDre", "1111111111128"), congresmans, pp);
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
		candidates.add(cj16);
		candidates.add(cj17);
		candidates.add(cj18);
		candidates.add(cj19);
		candidates.add(cj20);
		candidates.add(cj21);
		candidates.add(cj22);
		candidates.add(cj23);
		candidates.add(cj24);
		candidates.add(cj25);
		candidates.add(cj26);
		candidates.add(cj27);
		candidates.add(cj28);
		candidates.add(cj29);
		candidates.add(cj30);
		candidates.add(cj30);

		votingSeasion.vote(candidates);

		votingSeasion.validateVotes(congresmans);

	}
}
