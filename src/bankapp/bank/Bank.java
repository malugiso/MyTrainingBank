package bankapp.bank;

public class Bank {

	private Account[] accounts = new Account[MAX_ACCOUNTS];
	private Customer[] customer = new Customer[MAX_CUSTOMERS];

	private static int MAX_ACCOUNTS;
	private static int MAX_CUSTOMERS;

	private String name;
	private int numAccounts;
	private int numCustomers;

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
			if (customer[i].getNr() == customerNr) {
				cust = customer[i];
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

	public boolean deposit(int accountNr, double amount) {
		Account acc = findAccount(accountNr);
		return acc.deposit(amount);
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

}
