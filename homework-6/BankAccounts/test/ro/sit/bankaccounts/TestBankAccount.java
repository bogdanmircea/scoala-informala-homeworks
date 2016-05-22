package ro.sit.bankaccounts;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class TestBankAccount {

	@Test
	public void whenMonthlyFeeIs0() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SimpleAccount simpleBankAccount = new SimpleAccount(accountCreationTime, 0);
		simpleBankAccount.addFunds(1000);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		System.out.println("whenMonthlyFeeIs0: When you add: " + simpleBankAccount.getBalance(balanceInterogationTime)
				+ "$, and there is no fee, your balance will be: " + simpleBankAccount.getBalance(balanceInterogationTime) + "$");
		assertEquals(1000, simpleBankAccount.getBalance(balanceInterogationTime), 0);
	}

	@Test
	public void whenMonthlyFeeIsSet() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SimpleAccount simpleBankAccount = new SimpleAccount(accountCreationTime, 5);
		simpleBankAccount.addFunds(1000);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		assertEquals("4 months worth of fees should have been deducted.", 980, simpleBankAccount.getBalance(balanceInterogationTime), 0);
		System.out.println("whenMonthlyFeeIsSet: When you add: " + simpleBankAccount.getBalance(accountCreationTime)
				+ "$, and the fee is 5$/month, your balance after 4 months will be: " + simpleBankAccount.getBalance(balanceInterogationTime) + "$");

	}

	@Test
	public void multipleOperation_BalancePositive() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SimpleAccount simpleBankAccount = new SimpleAccount(accountCreationTime, 5);
		double moneyToAdd = 100;
		simpleBankAccount.addFunds(moneyToAdd);
		double moneyTowithdraw = 20;
		simpleBankAccount.withdrawFunds(moneyTowithdraw);
		Date balanceInterogationTime = TestUtils.getDate(2016, 2, 10);
		assertEquals(75, simpleBankAccount.getBalance(balanceInterogationTime), 0);
		System.out.println("multipleOperation_BalancePositive: When you add: " + moneyToAdd + "$ and you withdraw: " + moneyTowithdraw
				+ "$, and the fee is 5$/month, your balance after one  month will be: " + simpleBankAccount.getBalance(balanceInterogationTime)
				+ "$");

	}

	@Test
	public void whenNotEnoughFunds() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SimpleAccount simpleBankAccount = new SimpleAccount(accountCreationTime, 5);
		double moneyToAdd = 100;
		simpleBankAccount.addFunds(moneyToAdd);
		double moneyTowithdraw = 101;
		simpleBankAccount.withdrawFunds(moneyTowithdraw);
		Date balanceInterogationTime = TestUtils.getDate(2016, 2, 10);
		if (moneyToAdd >= moneyTowithdraw) {
			assertEquals(5, simpleBankAccount.getBalance(balanceInterogationTime), 0);
			System.out.println("When you add: " + moneyToAdd + "$ and you withdraw: " + moneyTowithdraw
					+ "$, and the fee is 5$/month, your balance after one  month will be: " + simpleBankAccount.getBalance(balanceInterogationTime)
					+ "$");
		}

	}

	class SimpleAccount extends BankAccount {

		public SimpleAccount(Date accountCreationDate, float monthlyFee) {
			super(accountCreationDate, monthlyFee);

		}
	}
}