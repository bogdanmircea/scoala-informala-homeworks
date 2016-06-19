package electionapptest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ro.sit.electionapp.Citizen;
import ro.sit.electionapp.ElectionManagementSystem;
import ro.sit.electionapp.Mayor;

/**
 * This is the Test for our application.
 * 
 * @author Bobo
 *
 */
public class TestElectionApp {

	@Test
	public void testCampaigin() {

		List<Citizen> citizens = new ArrayList<Citizen>();
		List<Mayor> mayors = new ArrayList<Mayor>();
		ElectionManagementSystem comunity = new ElectionManagementSystem();

		Citizen basescu = new Citizen("basescu", 123456789);
		Citizen bogdan = new Citizen("bogdan", 111111111);
		Citizen carlos = new Citizen("carlos", 333333333);
		Citizen dickinson = new Citizen("dickinson", 999999999);
		Citizen elf = new Citizen("elf", 888888888);
		Citizen sisu = new Citizen("sisu", 777777777);
		Citizen rihana = new Citizen("rihana", 222222222);
		Citizen snoop = new Citizen("snoop", 444444444);
		Citizen ronaldo = new Citizen("ronaldo", 555555555);
		Citizen billa = new Citizen("billa", 666666666);

		Mayor funar = new Mayor("funar");
		Mayor tarzan = new Mayor("tarzan");
		Mayor superman = new Mayor("superman");
		Mayor robocop = new Mayor("robocop");

		citizens.add(basescu);
		citizens.add(bogdan);
		citizens.add(carlos);
		citizens.add(dickinson);
		citizens.add(elf);
		citizens.add(sisu);
		citizens.add(rihana);
		citizens.add(snoop);
		citizens.add(ronaldo);
		citizens.add(billa);

		assertEquals(10, citizens.size(), 0);

		mayors.add(funar);
		mayors.add(tarzan);
		mayors.add(superman);
		mayors.add(robocop);

		assertEquals(4, mayors.size(), 0);

		comunity.vote(basescu, mayors, "funar");
		comunity.vote(bogdan, mayors, "robocop");
		comunity.vote(carlos, mayors, "tarzan");
		comunity.vote(dickinson, mayors, "robocop");
		comunity.vote(elf, mayors, "robocop");
		comunity.vote(billa, mayors, "funar");
		comunity.vote(snoop, mayors, "robocop");
		comunity.vote(sisu, mayors, "robocop");
		comunity.vote(rihana, mayors, "tarzan");
		comunity.vote(ronaldo, mayors, "superman");

		assertEquals(2, funar.getNumberOfVotes(), 0);
		assertEquals(2, tarzan.getNumberOfVotes(), 0);
		assertEquals(5, robocop.getNumberOfVotes(), 0);
		assertEquals(1, superman.getNumberOfVotes(), 0);

		comunity.voteValidate(mayors);
		comunity.showStatistics(mayors);
		comunity.createReport();
		comunity.manageReport();

	}

}
