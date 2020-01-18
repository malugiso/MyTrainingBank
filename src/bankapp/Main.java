package bankapp;

import bankapp.bank.Bank;

public class Main {

	private static final String BANK_NAME = "PoloBank";

	public static void main(String[] args) {
		Bank poloBank = new Bank(BANK_NAME);

		System.out.println(poloBank.getName());

		poloBank.registerCustomer("cust1", "123");

	}

}
