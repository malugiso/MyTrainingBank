package bankapp.cli;

import bankapp.bank.Bank;
import bankapp.bank.Customer;

/**
 * The class BankCLI implements the command-line interface of a bank.
 */
public class BankCLI {

	/**
	 * The bank of the command-line interface.
	 */
	private Bank bank;

	/**
	 * The logged in customer.
	 */
	private Customer customer;

	/**
	 * Constructor BankCLI
	 * 
	 * @param bank
	 */
	public BankCLI(Bank bank) {
		this.bank = bank;
	}

	/**
	 * Runs the command-line interface.
	 */
	public void run() {
		while (true) {
			int choice = ConsoleHelper.displayMenu(bank.getName(), "Register", "Login", "Exit");
			switch (choice) {
			case 1:
				registerCustomer();
				break;
			case 2:
				logonCustomer();
				break;
			default:
				return;
			}
			if (customer != null)
				runSession();
		}
	}

	/**
	 * Registers a bank customer.
	 */
	private void registerCustomer() {
		String name = ConsoleHelper.readString("Enter Name: ");
		String pw = ConsoleHelper.readString("Please enter a Password: ");
		this.customer = bank.registerCustomer(name, pw);
		ConsoleHelper.writeMessage("Customer successful registrated");

		// TODO Implement method
	}

	/**
	 * Logs on a bank customer.
	 */
	private void logonCustomer() {
		int customerNr = ConsoleHelper.readInteger("Enter Customer Number: ");
		String password = ConsoleHelper.readString("Enter your Password: ");
		this.customer = bank.authenticateCustomer(customerNr, password);
		ConsoleHelper.writeMessage(customer != null ? "Customer logged in" : "Login failed");
	}

	/**
	 * Runs a session for the logged in customer.
	 */
	private void runSession() {
		while (true) {
			ConsoleHelper.writeData(customer);
			int choice = ConsoleHelper.displayMenu(bank.getName(), "Open Account", "Deposit", "Withdraw", "Transfer",
					"Logout");
			switch (choice) {
			case 1:
				openAccount();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				transfer();
				break;
			default:
				return;
			}
		}
	}

	/**
	 * Opens a bank account.
	 */
	private void openAccount() {
		String pin = ConsoleHelper.readString("Please Enter a pin: ");
		bank.openAccount(this.customer, pin);
	}

	/**
	 * Deposits money to a bank account.
	 */
	private void deposit() {
		int accountNr = ConsoleHelper.readInteger("Please enter your accountNr: ");
		int amount = ConsoleHelper.readInteger("Please Enter an amount: ");
		bank.deposit(accountNr, amount);
	}

	/**
	 * Withdraws money from a bank account.
	 */
	private void withdraw() {
		int accountNr = ConsoleHelper.readInteger("Please enter your accountNr: ");
		String pin = ConsoleHelper.readString("Please enter your pin: ");
		double amount = ConsoleHelper.readDecimal("Please enter an valid amount");

		bank.withdraw(accountNr, pin, amount);
	}

	/**
	 * Transfers money from a bank account to an other account.
	 */
	private void transfer() {
		int debitAccountNr = ConsoleHelper.readInteger("Please enter your debitAccountNr: ");
		String pin = ConsoleHelper.readString("Please enter your pin: ");
		int creditAccountNr = ConsoleHelper.readInteger("Please enter your creditAccountNr: ");
		double amount = ConsoleHelper.readDecimal("Please enter an valid amount");

		bank.transfer(debitAccountNr, pin, creditAccountNr, amount);
	}
}
