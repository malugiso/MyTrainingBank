package bankapp.bank;

public class Customer {

	private Account[] accounts;

	private static int MAX_ACCOUNTS;

	private String name;
	private int nr;
	private int numAccounts;
	private String password;

	protected Customer(int nr, String name, String password) {
		this.nr = nr;
		this.name = name;
		this.password = password;
	}

	/**
	 * @return the account
	 */
	public Account[] getAccount() {
		return accounts;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the nr
	 */
	public int getNr() {
		return nr;
	}

}
