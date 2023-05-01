import java.util.Scanner;

/**
 * Rock-scissors-paper game. User can input rock, scissors, paper.
 * 
 * @author Jaehyun Yoon
 * @since 04-17-2023
 * @version 1.0
 */
public class Q7 {
	static final String[] SCISSORS_ROCK_PAPER = { "scissors", "rock", "paper" };
	static final String[] RESULT = { "draw", "win", "loss" };

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int com, user, result;
		user = 0;
		com = (int) (Math.random() * 3);

		// Input UI
		System.out.print("Rock-Paper-Scissors game! Please enter your input: ");
		String inputStr = scanner.next();

		// Calculate
		for (int i = 0; i < 3; i++) {
			if (SCISSORS_ROCK_PAPER[i].equalsIgnoreCase(inputStr)) {
				user = i;
			}
		}

		// Output UI
		if (user == 0) {
			System.out.println("Your input is wrong.\nPlease enter rock, papaer, and sicissors.");
		} else {
			if (user == com)
				result = 0;
			else if ((user + 1) % 3 == com) {
				result = 2;
			} else {
				result = 1;
			}
			System.out.println("User: " + SCISSORS_ROCK_PAPER[user] + " Com: " + SCISSORS_ROCK_PAPER[com]);
			System.out.println("User " + RESULT[result] + " the game.");
		}

		scanner.close();
	}

}
