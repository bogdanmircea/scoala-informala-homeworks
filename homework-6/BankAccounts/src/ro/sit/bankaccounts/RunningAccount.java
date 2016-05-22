package ro.sit.bankaccounts;

import java.util.Date;

public class RunningAccount extends BankAccount {

	public RunningAccount(Date accountCreationDate, double monthlyFee) {
		super(accountCreationDate, monthlyFee);

	}

	public void withdrawfunds(double amount) {
		super.withdrawFunds(amount);
	}

	public void addFunds(double amount) {
		super.addFunds(amount);
	}
}
