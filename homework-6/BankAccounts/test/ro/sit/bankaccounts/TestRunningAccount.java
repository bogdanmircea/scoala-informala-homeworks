package ro.sit.bankaccounts;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

public class TestRunningAccount {

	@Test
	public void addFunds() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		BankAccount runningAccount = new RunningAccount(accountCreationTime, 10d);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		runningAccount.addFunds(1000);
		assertEquals(960, runningAccount.getBalance(balanceInterogationTime), 0);
		assertThat(runningAccount, instanceOf(BankAccount.class));
	}

	@Test
	public void withDrawFunds() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		BankAccount runningAccount = new RunningAccount(accountCreationTime, 10d);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		runningAccount.addFunds(1000);
		runningAccount.withdrawFunds(200);
		assertEquals(760, runningAccount.getBalance(balanceInterogationTime), 0);
	}
}
