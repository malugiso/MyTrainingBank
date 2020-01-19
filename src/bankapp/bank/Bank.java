package bankapp.bank;

public class Bank {

	private Account[] accounts = new Account[MAX_ACCOUNTS];
	private Customer[] customers = new Customer[MAX_CUSTOMERS];

	private static int MAX_ACCOUNTS = 100;
	private static int MAX_CUSTOMERS = 100;

	private String name;
	private int numAccounts = 0;
	private int numCustomers = 0;

	/**
	 * 
	 * @param name
	 */
	public Bank(String name) {
		this.name = name;

	}

	/**
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public Customer registerCustomer(String name, String password) {

		if (numCustomers == MAX_CUSTOMERS) {
			System.out.println("Toot many customers");
			return null;
		}
		numCustomers += 1;
		Customer customer = new Customer(numCustomers, name, password);
		customers[numCustomers - 1] = customer;

		return customer;
	}

	/**
	 * 
	 * @param customerNr
	 * @param password
	 * @return
	 */
	public Customer authenticateCustomer(int customerNr, String password) {
		Customer cust = findCustomer(customerNr);

		if (!cust.checkPaswort(password)) {
			cust = null;
		}

		return cust;
	}

	/**
	 * 
	 * @param customerNr
	 * @return
	 */
	public Customer findCustomer(int customerNr) {
		Customer cust = null;
		for (int i = 0; i < numCustomers; i++) {
			if (customers[i].getNr() == customerNr) {
				cust = customers[i];
			}
		}
		return cust;
	}

	private Account findAccount(int accountNr) {
		Account acc = null;
		for (int i = 0; i < numAccounts; i++) {
			if (accounts[i].getNr() == accountNr) {
				acc = accounts[i];
			}
		}
		return acc;
	}

	public Account openAccount(Customer customer, String pin) {
		Account acc = null;
		Customer cust = customer;

		if (numAccounts == MAX_ACCOUNTS) {
			return acc;
		}

		numAccounts++;
		acc = new Account(numAccounts, pin);

		cust.addAccount(acc);

		return acc;
	}

	/**
	 * get Balance of an account
	 * 
	 * @param accountNr
	 * @param pin
	 * @return
	 */
	public Double getBalance(int accountNr, String pin) {
		Account acc = findAccount(accountNr);
		if (acc.checkPin(pin) == false) {
			System.out.println("Pin wrong");
			return null;
		}
		return acc.getBalance();

	}

	/**
	 * 
	 * @param accountNr
	 * @param amount
	 * @return
	 */
	public boolean deposit(int accountNr, double amount) {
		Account acc = findAccount(accountNr);
		return acc.deposit(amount);
	}

	public boolean withdraw(int accountNr, String pin, double amount) {
		Account acc = findAccount(accountNr);

		if (!acc.checkPin(pin)) {
			return false;
		}

		acc.withdraw(amount);

		return true;
	}

	public boolean transfer(int debitAccountNr, String pin, int creditAccountNr, double amount) {

		if (!withdraw(debitAccountNr, pin, amount)) {
			return false;
		}

		deposit(creditAccountNr, amount);

		return true;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

}
