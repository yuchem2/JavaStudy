import javax.swing.*;

/**
 * Q2: Print Reverse
 * 
 * @author Jaehyun Yoon
 * @since 06-18-2023
 */

public class Q2 {

	public static String reverseWords(String sentence) {
		String[] words = sentence.split(" ");
		StringBuilder reversed = new StringBuilder();
		for (String word : words) {
			String reversedWord = reverseWord(word);
			reversed.append(reversedWord).append(" ");
		}
		return reversed.toString().trim();
	}

	public static String reverseWord(String word) {
		StringBuilder reversed = new StringBuilder();
		for (int i = word.length() - 1; i >= 0; i--) {
			reversed.append(word.charAt(i));
		}
		return capitalizeFirstLetter(reversed.toString());
	}

	public static String capitalizeFirstLetter(String word) {
		if (word.isEmpty()) {
			return word;
		}
		char firstChar = Character.toUpperCase(word.charAt(0));
		String str = String.valueOf(firstChar);
		for (int i = 1; i < word.length(); i++) {
			char letter = Character.toLowerCase(word.charAt(i));
			str += letter;
		}
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inStr = JOptionPane.showInputDialog(null, "Please write any English sentence: ");
		String reverseStr = reverseWords(inStr);
		System.out.println(reverseStr);

	}

}
