/*
 * Filename: Practicce1Q4.java
 * Input: 9 integers
 * Output: make it to 3x3 matrix and calculate sum of each rows, columns and all elements.
 * 2023-03-26
 * Jaehyun Yoon
 */
import java.util.Scanner;

public class Practice1Q4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Input and calculate
		System.out.print("Please input the 9 integer values: ");	
		int[][] intArray = new int[4][4];

		for(int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				intArray[i][j] = scanner.nextInt(); // input
				// calculate
				intArray[i][3] += intArray[i][j];
				intArray[3][j] += intArray[i][j];
			}	
			intArray[3][3] += intArray[i][3];
		}
		
		// Output
		System.out.println("\t\t\t\tRow");
		System.out.println("\t\t\t\tSum");
		for(int i=0; i<3; i++) {
			System.out.print("\t\t");
			for(int j=0; j<4; j++)
				System.out.format("%4d ", intArray[i][j]);
			System.out.println();
		}
		System.out.print("Column Sum\t");
		for(int i=0; i<4; i++)
			System.out.format("%4d ", intArray[3][i]);
		
		scanner.close();
	}
}