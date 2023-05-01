/**
 * Find the person with the largest balance out of 1,000 banks
 * @see BankAccount
 * @author Jaehyun Yoon
 * @since 04-17-2023
 * @version 1.0
 */
public class Q6 {

	public static void main(String[] args) {

		BankAccount[] bank = new BankAccount[1000];
		int idx = 0;

		for (int i = 0; i < bank.length; i++) {
			bank[i] = new BankAccount();
			bank[i].setOwnerName("Owner_" + (i + 1));
			bank[i].setInitialBalance((int) (Math.random() * 50000));
		}

		for (int i = 0; i < bank.length; i++) {
			bank[i].addBalance(10000);
		}

		for (int i = 0; i < bank.length; i++) {
			if (bank[idx].getBalance() < bank[i].getBalance()) {
				idx = i;
			}
		}
		System.out.format(bank[idx].getOwnerName() + " has the largest balance. The balance is $%.0f\n",
				bank[idx].getBalance());

	}

}
