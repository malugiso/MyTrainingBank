package bankapp;

import bankapp.bank.Bank;
import bankapp.cli.BankCLI;

public class Main {

	private static final String BANK_NAME = "PoloBank";

	public static void main(String[] args) {
		Bank poloBank = new Bank(BANK_NAME);
		BankCLI cli = new BankCLI(poloBank);
		cli.run();

		/*
		 * System.out.println(poloBank.getName());
		 * 
		 * System.out.println(poloBank.registerCustomer("cust1", "123")); Customer cust1
		 * = poloBank.authenticateCustomer(1, "123");
		 * 
		 * System.out.println(poloBank.openAccount(cust1, "123"));
		 */

		// System.out.println(poloBank.);

	}

}
