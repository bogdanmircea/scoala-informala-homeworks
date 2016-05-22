package ro.sit.bankaccounts;

import java.util.Calendar;
import java.util.Date;

public class SavingAccount extends BankAccount {

	private double commission;
	private double interest;

	public SavingAccount(Date accountCreationDate, double monthlyFee, double commission, double interest) {
		super(accountCreationDate, monthlyFee);
		this.commission = commission;
		this.interest = interest;
	}

	public void addFunds(double amount) {
		super.addFunds(amount);
	}

	public void withdrawFunds(double amount) {
		super.withdrawFunds(amount + (amount * commission));
	}

	public double calculateInterest(Date balanceDate) {

		Calendar accountCreationTime = Calendar.getInstance();
		accountCreationTime.setTime(getAccountCreationDate());
		Calendar balanceTime = Calendar.getInstance();
		balanceTime.setTime(balanceDate);
		int yearDiff = (balanceTime.get(Calendar.YEAR) - accountCreationTime.get(Calendar.YEAR));

		balance = getBalance(balanceDate) + (getBalance(balanceDate) * (interest * yearDiff));
		return balance;

	}
}
