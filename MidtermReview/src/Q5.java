import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/**
 * Q5: Calculate all real-number
 * 
 * @author Jaehyun Yoon
 * @since 06-18-2023
 */

public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = JOptionPane
				.showInputDialog("Please Enter a sentence with a mix of alphabets/spcial characters/real numbers:");

		System.out.print("The result of adding all the real numbers in the input text is: ");
		System.out.print(calculateFloatingPoints(input));
	}

	public static double calculateFloatingPoints(String input) {
		double result = 0.0;

		// 실수를 찾는 정규식 패턴
		String pattern = "-?\\d+(\\.\\d+)?";

		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(input);

		String resultStr = "";

		while (matcher.find()) {
			String match = matcher.group();
			double number = Double.parseDouble(match);
			resultStr += String.valueOf(number) + " + ";
			result += number;
		}
		if (result != 0.0) {
			resultStr = resultStr.substring(0, resultStr.length() - 3) + " = ";
			System.out.print(resultStr);
		}

		return result;
	}

}
