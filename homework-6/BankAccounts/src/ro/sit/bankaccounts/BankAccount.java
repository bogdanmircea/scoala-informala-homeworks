package ro.sit.bankaccounts;

import java.util.Calendar;
import java.util.Date;

public abstract class BankAccount {
	protected double balance;
	private Date accountCreationDate;
	private double monthlyFee;

	public BankAccount(Date accountCreationDate, double monthlyFee) {
		this.accountCreationDate = accountCreationDate;
		this.monthlyFee = monthlyFee;
	}

	public void addFunds(double amount) {
		balance = balance + amount;
	}

	public void withdrawFunds(double amount) {
		if (amount > balance) {
			System.out.println("whenNotEnoughFunds: Insufficient Funds");
		}
		else
			balance = balance - amount;
	}

	public double getBalance(Date balanceDate) {
		return getBalanceWithMonthlyFeesApplied(balanceDate);

	}

	private double getBalanceWithMonthlyFeesApplied(Date balanceDate) {
		Calendar accountCreationTime = Calendar.getInstance();
		accountCreationTime.setTime(accountCreationDate);
		int accountCreationMonth = accountCreationTime.get(Calendar.MONTH);
		Calendar balanceTime = Calendar.getInstance();
		balanceTime.setTime(balanceDate);
		int currentMonth = balanceTime.get(Calendar.MONTH);
		int passedYears = balanceTime.get(Calendar.YEAR) - accountCreationTime.get(Calendar.YEAR);
		return balance - monthlyFee * (currentMonth - accountCreationMonth + passedYears * 12);
	}

	public Date getAccountCreationDate() {
		return accountCreationDate;
	}

}
