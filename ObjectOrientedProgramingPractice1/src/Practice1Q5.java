/*
 * Filename: Practicce1Q5.java
 * Find optimal number of bills by inputting a specific amount
 * 2023-03-26
 * Jaehyun Yoon
 */
import java.util.Scanner;

public class Practice1Q5 {
	
	static final int[] UNIT_BILLS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Input
		System.out.print("Please enter the amount: ");
		int inNum = scanner.nextInt();
		int temp = inNum;
		
		// calculate
		int[] billCnt = new int[10];
		for(int i=0; i<10; i++) {
			while(inNum >= UNIT_BILLS[i]) {
				billCnt[i] = inNum / UNIT_BILLS[i];
				inNum = inNum % UNIT_BILLS[i];
			}
		}
		
		// Output
		System.out.println("Entered amount: " + temp);
		for(int i=0; i<10; i++) {
			if (billCnt[i] != 0)
				System.out.format("%5d won: %2d\n", UNIT_BILLS[i], billCnt[i]);
			
		}
		scanner.close();
	}

}
