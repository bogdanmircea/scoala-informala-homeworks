package ro.sit.electionaplication2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionBooth {

	private Map<Citizen, Mayor> report = new HashMap<Citizen, Mayor>();
	// private ElectionRecords fileReport = new ElectionRecords();
	private int totalVotes = 0;
	private List<Candidate> candidates = new ArrayList<Candidate>();

	public synchronized void vote(List<Candidate> candidates) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (Candidate candidate : candidates) {

					checkCandidatesForFraud(candidate);
					checkCNP(candidate);
					try {
						Thread.sleep((long) ((Math.random()) * 1000));
						selectMayorToVote(candidate);

					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			private void checkCNP(Candidate candidate) {
				int validCNP = candidate.getCitizen().getCNP().length();
				if (validCNP != 13) {
					try {
						throw new InvalidCNPException(candidate.getCitizen().getName());
					}
					catch (InvalidCNPException e) {

						System.out.println(
								"\nCitizen: " + candidate.getCitizen().getName() + " - you're CNP is invalid. You're vote will be canceled!\n");
						report.remove(candidate.getCitizen(), candidate.getMayor());
						candidate.getMayor().removeVote();
						totalVotes--;
					}
				}
			}

			private void selectMayorToVote(Candidate candidate) {
				for (Mayor counter : candidate.getMayors())
					if (counter.getName().equals(candidate.getMayor().getName())) {
						counter.addVote();
						report.put(candidate.getCitizen(), counter);
						totalVotes++;
						// fileReport.createFile();
						// fileReport.addInfo(candidate);
						// fileReport.closeFile();
					}
			}

			private void checkCandidatesForFraud(Candidate candidate) {

				if (report.containsKey(candidate.getCitizen())) {
					try {
						throw new IllegalNumberOfVotesException(candidate.getCitizen().getName());
					}
					catch (IllegalNumberOfVotesException e) {

						System.out.println("\nCitizen: " + candidate.getCitizen().getName()
								+ " - you are busted for illegal activites. You're vote will be canceled!\n");
						report.remove(candidate.getCitizen(), candidate.getMayor());
						candidate.getMayor().removeVote();
						totalVotes -= 2;
					}
				}
			}
		});
		t1.start();
	}

	public synchronized void validateVotes(List<Mayor> mayors) throws InterruptedException {
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				int count = 0;
				while (count < 10)
					try {
						Thread.sleep((long) (1000 + Math.random() * 2000));
						for (Mayor m : mayors) {
							System.out.println("\t" + m.getName() + " has: " + m.getNumberOfVotes() + " votes, and the percentage is: "
									+ m.getNumberOfVotes() * 100 / totalVotes + "%.");
						}
						System.out.println("Participants until now: " + totalVotes);
						// fileReport.openFile();
						// fileReport.getInfo();
						// fileReport.closeFile();
						count++;
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				int number = 0;
				String electedMayor = null;
				for (int i = 0; i <= mayors.size() - 1; i++) {
					if (mayors.get(i).getNumberOfVotes() > number) {
						number = mayors.get(i).getNumberOfVotes();
						electedMayor = mayors.get(i).getName();
					}
				}
				printStatiscticsToConsole(mayors, number, electedMayor);
			}

			private void printStatiscticsToConsole(List<Mayor> mayors, int number, String electedMayor) {
				System.out.println("\nFinal Statistics: ");
				for (Mayor counter : mayors)
					System.out.println("\t" + counter.getName() + " has: " + counter.getNumberOfVotes() * 100 / totalVotes + "%");
				System.out.println("The new mayor in town is: " + electedMayor + " with: " + number + " votes\n");
				System.out.println("Total number of participants: " + totalVotes);
			}
		});
		t2.start();
	}

	public void add(Candidate e) {
		candidates.add(e);
	}
}
