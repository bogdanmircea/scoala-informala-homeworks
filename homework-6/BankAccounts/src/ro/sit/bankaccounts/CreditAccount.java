package ro.sit.bankaccounts;

import java.util.Date;

public class CreditAccount extends BankAccount {

	private double credit;
	private double withdrawalCommision;
	private double payBackPenalty;

	public CreditAccount(Date accountCreationDate, double credit, double withdrawalCommision, double payBackPenalty) {
		super(accountCreationDate, 0);
		this.credit = credit;
		balance = credit;
		this.withdrawalCommision = withdrawalCommision;
		this.payBackPenalty = payBackPenalty;
	}

	public void withdrawFunds(double amount) {
		super.withdrawFunds(amount + amount * withdrawalCommision);
	}

	public double getBalance(Date balanceDate) {

		double balance = super.getBalance(balanceDate);
		return applyPenalties(balance);
	}

	private double applyPenalties(double balance) {
		if (credit <= balance) {
			return balance;
		}
		else {
			return balance - (credit - balance) * payBackPenalty;
		}
	}

}
