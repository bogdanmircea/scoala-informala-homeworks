package ro.sit.bankaccounts;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class TestCreditAccount {
	@Test
	public void monthlyFeesAreNotApplied() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		CreditAccount creditAccount = new CreditAccount(accountCreationTime, 1000d, 0.02d, 0.01d);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		assertEquals(1000, creditAccount.getBalance(balanceInterogationTime), 0);
	}

	@Test
	public void whenMultipleOperationsCalled_balanceIsCorrect() {
		// given
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		double withdrawalCommision = 0.02d;
		double creditPayBackPenalty = 0.01d;
		double credit = 1000d;
		CreditAccount creditAccount = new CreditAccount(accountCreationTime, credit, withdrawalCommision, creditPayBackPenalty);

		// when
		creditAccount.withdrawFunds(100);
		creditAccount.withdrawFunds(200);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		double actualBalance = creditAccount.getBalance(balanceInterogationTime);

		// then
		double withdrawals = (100d + 100d * withdrawalCommision) + (200d + 200d * withdrawalCommision);
		double expectedBalanceWithoutPenalties = credit - withdrawals;
		double expectedPenalty = (credit - expectedBalanceWithoutPenalties) * creditPayBackPenalty;
		double expectedBalanceWithPenalties = expectedBalanceWithoutPenalties - expectedPenalty;

		assertEquals("4 months worth of fees and the penalty should have been deducted.", expectedBalanceWithPenalties, actualBalance, 0);
	}

	@Test
	public void whenCreditsAreCovered_balanceIsCorrect() {
		// given
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		double withdrawalCommision = 0.02d;
		double creditPayBackPenalty = 0.01d;
		double credit = 1000d;
		CreditAccount creditAccount = new CreditAccount(accountCreationTime, credit, withdrawalCommision, creditPayBackPenalty);

		// when
		creditAccount.withdrawFunds(100);
		creditAccount.withdrawFunds(200);
		creditAccount.addFunds(350);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		double actualBalance = creditAccount.getBalance(balanceInterogationTime);

		// then
		double withdrawals = (100d + 100d * withdrawalCommision) + (200d + 200d * withdrawalCommision);
		double expectedBalance = credit - withdrawals + 350;
		System.out.println(expectedBalance + " " + actualBalance);
		assertEquals("4 months worth of fees and no penalty should have been deducted.", expectedBalance, actualBalance, 0);
	}
}
