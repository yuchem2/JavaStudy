import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Assignment2 Q9.java The summation calculator <br>
 * Input UI <br>
 * 1. Input the number of digits want to enter. The number of digits must be
 * greater than 1. </br>
 * <br>
 * 2. Input the type of digits (Integer or real number)</br>
 * <br>
 * 3. Input the digits.</br>
 * </br>
 * 
 * @author Jaehyun Yoon
 * @since 04-17-2023
 * @version 1.0
 */
public class Q9 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int digitNum;
		String digitType;

		// Input UI(1, 2)
		digitNum = inputDigitsNumber(scanner);
		digitType = inputDigitsType(scanner);

		// Input UI 3 & calculate
		if (digitType.equalsIgnoreCase("integer")) {
			int[] array = new int[digitNum];

			for (int i = 0; i < digitNum; i++) {
				try {
					System.out.print((i + 1) + "th number >>");
					array[i] = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Please enter only integer.");
					scanner.next();
					i--;
				}
			}
			// Output
			System.out.println("The result is " + getSum(array));

		} else {
			double[] array = new double[digitNum];
			for (int i = 0; i < digitNum; i++) {
				try {
					System.out.print((i + 1) + "th number >>");
					array[i] = scanner.nextDouble();
				} catch (InputMismatchException e) {
					System.out.println("Please enter only real number.");
					scanner.next();
					i--;
				}
			}
			// Output
			System.out.println("The result is " + getSum(array));
		}

	}

	/**
	 * Calculate a + b
	 * 
	 * @param a integer value
	 * @param b integer value
	 * @return a+b
	 */
	public static int getSum(int a, int b) {
		return a + b;
	}

	/**
	 * Calculate a + b + c
	 * 
	 * @param a integer value
	 * @param b integer value
	 * @param c integer value
	 * @return a+b+c
	 */
	public static int getSum(int a, int b, int c) {
		return a + b + c;
	}

	/**
	 * Calculate sum of the array.
	 * 
	 * @param array integer list
	 * @return sum of the array
	 */
	public static int getSum(int array[]) {
		int sum = 0;
		if (array.length == 2) {
			return getSum(array[0], array[1]);
		} else if (array.length == 3) {
			return getSum(array[0], array[1], array[2]);
		} else {
			for (int i = 0; i < array.length; i++) {
				sum += array[i];
			}
			return sum;
		}

	}

	/**
	 * Calculate a + b
	 * 
	 * @param a real number(double)
	 * @param b real number(double)
	 * @return a + b
	 */
	public static double getSum(double a, double b) {
		return a + b;
	}

	/**
	 * Calculate a + b + c
	 * 
	 * @param a real number(double)
	 * @param b real number(double)
	 * @param c real number(double)
	 * @return
	 */
	public static double getSum(double a, double b, double c) {
		return a + b + c;
	}

	/**
	 * Calculate sum of the array(double)
	 * 
	 * @param array real number list(double)
	 * @return sum of the array
	 */
	public static double getSum(double array[]) {
		double sum = 0;
		if (array.length == 2) {
			return getSum(array[0], array[1]);
		} else if (array.length == 3) {
			return getSum(array[0], array[1], array[2]);
		} else {
			for (int i = 0; i < array.length; i++) {
				sum += array[i];
			}
			return sum;
		}
	}

	/**
	 * Input the number of digits. Exception Handling: non-integer value and integer
	 * must be greater than 1.
	 * @param scan the Scanner
	 * @return User input value(integer)
	 */
	public static int inputDigitsNumber(Scanner scan) {
		int num;
		System.out.println("This is a summation calculator!");
		while (true) {
			System.out.print("Pleae enter the number of digits: ");
			try {
				num = scan.nextInt();
				if (num < 2) {
					System.out.println("The number of digits must be greater than 1. Please try again.");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("The number of digits must be positive integer. Please try again.");
				scan.next();
			}

		}
		return num;
	}

	/**
	 * Input the type of digits. User input will be only 'real' or 'integer'.
	 * 
	 * @param scan the Scanner
	 * @return User input type: real or integer (String)
	 */
	public static String inputDigitsType(Scanner scan) {
		String type;
		while (true) {
			System.out.print("\nPlease enter the type of digits(real or integer): ");
			type = scan.next();
			if (type.equalsIgnoreCase("real") || type.equalsIgnoreCase("integer")) {
				break;
			} else {
				System.out.println("The type of digits must be integer or real. Please try again.");
			}
		}
		return type;
	}

}
