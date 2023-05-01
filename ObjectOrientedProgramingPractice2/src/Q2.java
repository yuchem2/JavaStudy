import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Calculate maximum and average value for received 10 integer numbers.
 * @author Jaehyun Yoon
 * @since 04-17-2023
 * @version 1.0
 */
public class Q2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int max, sum, buff;
		
		// Input UI & calculate
		System.out.println("Please enter ten intergerts:");
		sum = 0;
		max = 0;
		for (int i = 0; i < 10; i++) {
			System.out.format("%dth value >>", i + 1);
			try {
				buff = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Input value is not integer. Pleas try it again!");
				scanner.next();
				i--;
				continue;
			}
			if (buff > max) {
				max = buff;
			}
			sum += buff;

		}
		
		// Output UI
		System.out.println("Maximum value: " + max);
		System.out.format("Average value: %.2f", (double) sum / 10);

		scanner.close();
	}
}
