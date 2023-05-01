/**
 * BankAccount Class Simple bank account
 * 
 * @see Q6
 * @author Jaehyun Yoon
 * @since 04-17-2023
 * @version 1.0
 */
public class BankAccount {
	/**
	 * data members
	 */
	private String ownerName;
	private double balance;

	/**
	 * Constructor of BankAacount. Initialize data members
	 */
	public BankAccount() {
		ownerName = "None";
		balance = 0.0;
	}

	/**
	 * Update ownerName
	 * 
	 * @param name will be ownerName of this object
	 */
	public void setOwnerName(String name) {
		ownerName = name;
	}

	/**
	 * Set initial Balance
	 * 
	 * @param balance will be initial balance of this object
	 */
	public void setInitialBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Deposit into the account
	 * 
	 * @param amount you want to deposit into the account
	 */
	public void addBalance(double amount) {
		balance += amount;
	}

	/**
	 * Deduct from the account
	 * 
	 * @param amount you want to deduct from the account
	 */
	public void deductBalance(double amount) {
		balance -= amount;
	}

	/**
	 * Return the owenerName of the account
	 * 
	 * @return ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * Return the balance of the account
	 * 
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}

}
