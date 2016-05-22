package ro.sit.bankaccounts;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.Date;
import org.junit.Test;

public class SavingAccountTest {

	@Test
	public void addFunds() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		BankAccount savingAccount = new SavingAccount(accountCreationTime, 10d, 0.066d, 0.005);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		savingAccount.addFunds(1000);
		assertEquals(960, savingAccount.getBalance(balanceInterogationTime), 0);
		assertThat(savingAccount, instanceOf(BankAccount.class));
	}

	@Test
	public void withDrawFunds() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingAccount savingsAccount = new SavingAccount(accountCreationTime, 10f, 0.06d, 0.06d);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		savingsAccount.addFunds(1000);
		savingsAccount.withdrawFunds(500);
		assertEquals(430, savingsAccount.getBalance(balanceInterogationTime), 0);
	}

	@Test
	public void interestPerYear() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingAccount savingsAccount = new SavingAccount(accountCreationTime, 10d, 0.02d, 0.06d);
		savingsAccount.addFunds(10000);
		Date balanceInterogationTime = TestUtils.getDate(2017, 5, 1);
		assertEquals(10430.4d, savingsAccount.calculateInterest(balanceInterogationTime), 0);

	}
}
