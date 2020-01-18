package bankapp.bank;

public class Account {

	private double balance;
	private int nr;
	private String pin;

	/**
	 * 
	 * @param balance
	 * @param nr
	 * @param pin
	 */

	protected Account(double balance, int nr, String pin) {
		this.balance = balance;
		this.nr = nr;
		this.pin = pin;
	}

	/**
	 * 
	 * @param nr
	 * @param pin
	 */

	protected Account(int nr, String pin) {
		this(0.00, nr, pin);
	}

	/**
	 * 
	 * @param pin
	 * @return
	 */
	public boolean checkPin(String pin) {
		return pin.equals(this.pin);
	}

	/**
	 * Add the amount to the account balance
	 * 
	 * @param amount
	 * @return
	 */
	protected boolean deposit(double amount) {
		if (amount <= 0) {
			return false;
		}

		this.balance += amount;

		return true;
	}

	protected boolean withdraw(double amount) {
		if (amount < 0) {
			return false;
		}

		return true;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the nr
	 */
	public int getNr() {
		return nr;
	}

	public String toString() {
		return "Account Num: " + this.nr + "\nAccount Balance: " + this.balance;
	}

}
