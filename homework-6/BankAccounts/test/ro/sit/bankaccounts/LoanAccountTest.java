package ro.sit.bankaccounts;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

public class LoanAccountTest {

	@Test
	public void addFunds() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		BankAccount loanAccount = new LoanAccount(accountCreationTime, 0, 0.1d, 12, 0.005d, 0.2d);
		Date balanceInterogationTime = TestUtils.getDate(2016, 1, 1);
		loanAccount.addFunds(1000);
		assertEquals(1100, loanAccount.getBalance(balanceInterogationTime), 0);
		assertThat(loanAccount, instanceOf(BankAccount.class));
	}
}
