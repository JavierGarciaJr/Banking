import java.util.*;

public class Account implements Comparable<Account> {
	public final double MINIMUM = 500.00;
	private String firstName;
	String lastName;
	int accountNumber;
	double balance;
    
	public Account() {

	}
	/**
	 * this is the constructor class for BankAccount
	 * @param firstName
	 * @param lastName
	 * @param accountNumber
	 * @param balance
	 */
	Account(String firstName, String lastName, int accountNumber, double balance) {
		// regular constructor
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	/**
	 * the method converts the bank account into a String
	 */
	public String toString() {

		String output = firstName + " " + lastName + " " + accountNumber + " " + balance;

		// return firstName + " "+ lastName+ ": Account Number "+accountNumber+ "
		// Balance: "+balance;
		return output;
	}
	/**
	 * this method deposits money into the account
	 * @param amount
	 */
	public void deposit(double amount) {
		// deposit amount
		// if amount is negative throw InputMismatch Exception
		if (amount < 0) {
			System.out.println("Cannot deposit a negative number");
			throw new InputMismatchException();
		}
		balance += amount;

	}
	/**
	 * this method returns the account Number
	 * @return
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * this method sets the account number
	 * @param accountNumber
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * this method compares the bank accounts
	 */
	public int compareTo(Account other) {
		// implement this method to compare two bank account numbers, from this and
		// other
		if (this.accountNumber == other.getAccountNumber()) {
			return 0;
		} else if (this.accountNumber < other.getAccountNumber()) {
			return -1;
		} else {
			return -1;
		}
	}
	/**
	 * this method returns the firstName
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * this method sets the first Name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * this method returns the last name
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * this method sets the last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * this method withdraws money from the bank account
	 * @param amount
	 */
	public void withdraw(double amount) {
		// if amount withdrawn leaves less than minimum throw InputMismatch exeption
		if (amount < MINIMUM) {
			System.out.println("Cannot wirthdraw: Balance under minimum");
			throw new InputMismatchException();
		} else {
			balance -= amount;
		}

	}
	/**
	 * this method returns the balance
	 * @return
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * this method sets the balance
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}