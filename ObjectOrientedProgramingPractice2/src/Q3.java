import java.util.List;
import java.util.ArrayList;

/**
 * Simple compiler that can decipher simple arithmetic expressions.
 * 
 * @author Jaehyun Yoon
 * @since 04-17-2023
 * @version 1.0
 */
public class Q3 {
	/**
	 * This is the system program
	 * 
	 * @param args arithmetic expression.
	 * @throws ScriptException
	 */
	public static void main(String[] args) {
		if (isInteger(args[args.length - 1])) {
			List<Integer> argument = new ArrayList<Integer>();
			List<Character> operator = new ArrayList<Character>();

			// Extract numbers and operators
			for (int i = 0; i < args.length; i++) {
				if (i % 2 == 0) {
					argument.add(Integer.parseInt(args[i]));
				} else {
					char buffer = args[i].charAt(0);
					if (buffer == '+' || buffer == '-' || buffer == '/')
						operator.add(buffer);
					else {
						operator.add('*');
						while (isInteger(args[i + 1]) == false) {
							i++;
						}
					}
				}
			}
			// Calculation & Output UI
			System.out.print("Entered formula: " + argument.get(0));
			for (int i = 0; i < operator.size(); i++) {
				System.out.print(" " + operator.get(i) + " " + argument.get(i + 1));
			}
			System.out.println("\n");
			calculate(argument, operator);
			javaCalculate(argument, operator);
		} else {
			System.out.println("Arithmetic expression is worng. It must end with a number");
		}
	}

	/**
	 * Check whether string is integer or not
	 * 
	 * @param str
	 * @return true or false
	 */
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Calculating by parameters
	 * 
	 * @param a    right value
	 * @param b    left value
	 * @param oper operator
	 * @return a oper (+, -, /, *) b
	 */
	public static int calculater(int a, int b, char oper) {
		int result = 0;
		if (oper == '+') {
			result = a + b;
		} else if (oper == '-') {
			result = a - b;
		} else if (oper == '/') {
			result = a / b;
		} else {
			result = a * b;
		}

		return result;
	}

	/**
	 * Execute calculation with left-to-right decoding
	 * 
	 * @param args integer List(integer numbers)
	 * @param oper Character List(Operators)
	 */
	public static void calculate(List<Integer> args, List<Character> oper) {
		int result = 0;

		result = calculater(args.get(0), args.get(1), oper.get(0));
		System.out.println("Operation1: " + args.get(0) + " " + oper.get(0) + " " + args.get(1) + " = " + result);
		for (int i = 1; i < oper.size(); i++) {
			System.out.print("Operation" + (i + 1) + ": " + result + " " + oper.get(i) + " " + args.get(i + 1));
			result = calculater(result, args.get(i + 1), oper.get(i));
			System.out.println(" = " + result);
		}

		System.out.println("\nThe result of the entered formula is " + result);
	}

	/**
	 * Execute calculation with operator precedence
	 * 
	 * @param args integer List(integer numbers)
	 * @param oper Character List(Operators)
	 */
	public static void javaCalculate(List<Integer> args, List<Character> oper) {
		int result, calcNum, idx;
		calcNum = oper.size();

		while (calcNum > 0) {
			idx = 0;
			for (int i = 0; i < oper.size(); i++) {
				if (oper.get(i) == '*' || oper.get(i) == '/') {
					idx = i;
					break;
				}
			}
			result = calculater(args.get(idx), args.get(idx + 1), oper.get(idx));
			oper.remove(idx);
			args.set(idx, result);
			args.remove(idx + 1);

			calcNum--;
		}
		result = args.get(0);
		System.out.println("\nThe actual result of the compiiler opertion in Java is " + result);
	}

}
