package bankapp.bank;

public class Bank {

	private Account[] accounts;
	private Customer[] customer;

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

	public Customer registerCustomer(String name, String password) {

		numCustomers += 1;
		Customer customer = new Customer(numCustomers, name, password);

		return customer;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

}
