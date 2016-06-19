package ro.sit.electionapp;

import java.io.File;
import java.util.Formatter;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * The ElectionReport is the class that we use to create files, write to files
 * and read from files.
 * 
 * 
 * @author Bobo
 *
 */
public class ElectionReport {

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

	public void readFile() {
		while (readFile.hasNext()) {
			String citizenName = readFile.next();
			int CNP = readFile.nextInt();
			String mayorName = readFile.next();
			System.out.printf("%s, %s, %s.\n", CNP, citizenName, mayorName);
		}
	}

	/**
	 * For our application we only need to write to the file we've created the
	 * name, the CNP of our citizens and the mayor they have voted.
	 * 
	 * @param voted
	 *            - is a Map<Citizen, Mayor> from were we can get all the info
	 *            that we need two write to file
	 */
	public void addRecords(Map<Citizen, Mayor> voted) {
		for (Entry<Citizen, Mayor> electioninfo : voted.entrySet()) {
			String name = electioninfo.getKey().getName();
			int CNP = electioninfo.getKey().getCNP();
			String mayorName = electioninfo.getValue().getName();
			file.format("%s %s %s %n", name, CNP, mayorName);
		}

	}

	public void closeFile() {
		file.close();
	}

	public void closeReadFile() {
		readFile.close();
	}
}
