package ro.sit.electionaplication2016;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class ElectionRecords {

	private List<Mayor> mayors = new ArrayList<Mayor>();
	private List<Citizen> citzens = new ArrayList<Citizen>();
	private Formatter file = null;
	private Scanner readFile;

	public void createFile() {

		try {
			file = new Formatter("Reports.txt");
		}
		catch (Exception e) {
			System.out.println("Error while creating the file.");
		}
	}

	public void openFile() {

		try {
			readFile = new Scanner(new File("Reports.txt"));
		}
		catch (Exception e) {
			System.out.println("File not found");
		}
	}

	public void getInfo() {
		while (readFile.hasNext()) {
			String citizenName = readFile.next();
			String CNP = readFile.next();
			String mayorName = readFile.next();
			Mayor mayor = new Mayor(mayorName);
			Citizen citizen = new Citizen(citizenName, CNP);
			citzens.add(citizen);
			mayors.add(mayor);
			System.out.printf("%s, %s, %s.\n", CNP, citizenName, mayorName);
		}
	}

	public void addInfo(Candidate candidate) {
		int numberOfVotes = candidate.getMayor().getNumberOfVotes();
		String mayorName = candidate.getMayor().getName();
		file.format("%s, %s. %n", numberOfVotes, mayorName);

	}

	public void closeFile() {
		file.close();
	}
}
