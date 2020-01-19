package bankapp.bank;

public class Customer {

	private Account[] accounts = new Account[MAX_ACCOUNTS];

	private static int MAX_ACCOUNTS = 100;

	private String name;
	private int nr;
	private int numAccounts = 0;
	private String password;

	protected Customer(int nr, String name, String password) {
		this.nr = nr;
		this.name = name;
		this.password = password;
	}

	/**
	 * 
	 * @param password
	 * @return
	 */
	protected boolean checkPaswort(String password) {
		return this.password.equals(password);
	}

	/**
	 * 
	 * @param account
	 * @return
	 */
	protected boolean addAccount(Account account) {
		if (numAccounts == MAX_ACCOUNTS || account.equals(null)) {
			return false;
		}

		numAccounts++;
		accounts[numAccounts - 1] = account;

		return true;
	}

	/**
	 * 
	 * @param nr
	 * @return
	 */
	public Account findAccount(int nr) {
		Account acc = null;
		for (int i = 0; i < numAccounts; i++) {
			if (accounts[i].getNr() == nr) {
				acc = accounts[i];
			}
		}

		return acc;
	}

	/**
	 * 
	 * @return
	 */
	public Account[] getAccounts() {
		return accounts;
	}

	public double getTotalBalance() {
		double totalBalance = 0.00;
		for (int i = 0; i < numAccounts; i++) {
			totalBalance += accounts[i].getBalance();
		}
		return totalBalance;
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

	public int countElements(Account[] obj) {
		int counter = 0;
		for (Account el : obj) {
			if (el != null) {
				counter++;
			}
		}
		return counter;
	}

	public String toString() {
		return "Name: " + getName() + "\nID: " + getNr() + "\nNum Accounts: " + countElements(accounts);

	}

}
