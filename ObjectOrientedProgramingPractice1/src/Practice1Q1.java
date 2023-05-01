
/*
 * Filename: Practicce1Q1.java
 * Input: User name and id 
 * Output: User name and sum of the digits of the id
 * 2023-03-28
 * Jaehyun Yoon
 */

import javax.swing.JOptionPane;

public class Practice1Q1 {

	public static void main(String[] args) {
		// Input 
		String inStr = JOptionPane.showInputDialog(null, "Enter your name & student ID (i.e. Minseok Seo / 12345678: ");
		
		// Calculate
		String userName = inStr.substring(0, inStr.indexOf("/"));
		String userId = inStr.substring(inStr.indexOf("/")+2);
		
		int sum = 0;
		for(int i=0; i<userId.length(); i++)
			sum += Character.getNumericValue(userId.charAt(i));
		
		// Output
		System.out.println("Hello OOP World! " + userName);
		System.out.println("The sum of each number of your student number entered is " + sum);
	}
}
