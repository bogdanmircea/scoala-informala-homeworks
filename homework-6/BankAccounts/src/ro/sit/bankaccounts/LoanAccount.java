package ro.sit.bankaccounts;

import java.util.Date;

public class LoanAccount extends BankAccount {

	private double interestLoan;
	private int installments;
	private double loan;
	private double deadlinePenalty;

	public LoanAccount(Date accountCreationDate, double monthlyFee, double interestLoan, int installments, double loan, double deadlinePenalty) {
		super(accountCreationDate, 0);
		this.interestLoan = interestLoan;
		this.installments = installments;
		this.loan = loan;
		this.deadlinePenalty = deadlinePenalty;
	}

	public void addFunds(double amount) {
		super.addFunds(amount + (amount * interestLoan));
	}

	public double monthlyPayment() {
		return (loan / installments) * interestLoan;
	}

	public double getBalance(Date balanceDate) {
		double balance = super.getBalance(balanceDate);
		return applyDeadlinePenalties(balance);
	}

	private double applyDeadlinePenalties(double balance) {
		if (loan <= balance) {
			return balance;
		}
		else {
			return balance - (loan - balance) * deadlinePenalty;
		}
	}
}
