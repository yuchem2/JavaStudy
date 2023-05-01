import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Sort 8 integers in ascending order.
 * 
 * @author Jaehyun Yoon
 * @since 04-17-2023
 * @version 1.0
 */
public class Q4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[8];

		// Input UI
		for (int i = 0; i < intArray.length; i++) {
			System.out.print("정수 입력 : ");
			try {
				intArray[i] = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Input value is not Integer. Please try it again!");
				scanner.next();
				i--;
				continue;
			}

		}
		// sorting
		selectSort(intArray);

		// Output UI
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

		scanner.close();
	}

	/**
	 * Sort integer array in ascending order. Use selection sort algorithm.
	 * 
	 * @param array want to sort
	 */
	public static void selectSort(int[] array) {
		int idx, temp;
		for (int i = 0; i < array.length - 1; i++) {
			idx = i;
			for (int j = i; j < array.length; j++) {
				if (array[idx] > array[j]) {
					idx = j;
				}
			}
			if (idx != i) {
				temp = array[idx];
				array[idx] = array[i];
				array[i] = temp;
			}
		}
	}

}
