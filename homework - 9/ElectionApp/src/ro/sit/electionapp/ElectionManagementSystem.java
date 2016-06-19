package ro.sit.electionapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The ElectionManagementSystem class is the class where the methods that manage
 * the election are created.
 * 
 * @author Bobo
 *
 */
public class ElectionManagementSystem {

	Map<Citizen, Mayor> report = new HashMap<Citizen, Mayor>();
	ElectionReport fileReport = new ElectionReport();
	int totalVotes = 0;

	/**
	 * The vote method allows the citizens to vote. A citizen can only vote
	 * once. If he tries to vote more than once or they fail to vote their vote
	 * will not be considered.
	 * 
	 * @param citizen
	 *            - is the citizen that will vote
	 * @param mayors
	 *            - is the list of mayors from were the citizens will choose
	 *            their mayor
	 * @param mayorToVote
	 *            - is the name of the mayor they want to vote.
	 */
	public void vote(Citizen citizen, List<Mayor> mayors, String mayorToVote) {
		for (Mayor counter : mayors)
			if (counter.getName().equals(mayorToVote) && !report.containsKey(citizen)) {
				counter.addVote();
				report.put(citizen, counter);
				totalVotes++;
			}
	}

	/**
	 * This method will check to see which mayor will have the biggest number of
	 * votes.
	 * 
	 * @param mayors
	 */
	public void voteValidate(List<Mayor> mayors) {
		int number = 0;
		String electedMayor = null;
		for (int i = 0; i <= mayors.size() - 1; i++) {
			if (mayors.get(i).getNumberOfVotes() > number) {
				number = mayors.get(i).getNumberOfVotes();
				electedMayor = mayors.get(i).getName();
			}
		}
		System.out.println("The new mayor in town is: " + electedMayor + " with: " + number + " votes\n");
	}

	/**
	 * This method will simply calculate each mayors percentage.
	 * 
	 * @param mayors
	 */
	public void showStatistics(List<Mayor> mayors) {
		System.out.println("Statistics: ");
		for (Mayor counter : mayors)
			System.out.println("\t"+counter.getName() + " has: " + counter.getNumberOfVotes() * 100 / totalVotes + "%");
	}

	/**
	 * This method will create the file were the citizens with their name and
	 * CNP will be printed to and the mayor that they have chosen.
	 */
	public void createReport() {
		fileReport.createFile();
		fileReport.addRecords(report);
		fileReport.closeFile();
	}

	/**
	 * This method allows us to read the file that we created before.
	 */
	public void manageReport() {
		fileReport.openFile();
		fileReport.readFile();
		fileReport.closeReadFile();
	}
}