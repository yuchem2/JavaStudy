/*
 * Filename: Practicce1Q6.java
 * Decide seasons for the input date.
 * 2023-03-26
 * Jaehyun Yoon
 */
import javax.swing.JOptionPane;

public class Practice1Q6 {

	static final String[] SEASON = {"Spring", "Summer", "Fall", "Winter"};
	
	public static void main(String[] args) {
		
		String year, month, dash;
		dash = "-";
		
		// input
		String dateStr = JOptionPane.showInputDialog(null, "Please enter the date(format: YYYY-MM-DD)");
		
		year = dateStr.substring(0, dateStr.indexOf(dash));
		dateStr = dateStr.substring(dateStr.indexOf(dash) + 1);
		
		month = dateStr.substring(0, dateStr.indexOf(dash));
		
		int monthInt = Integer.valueOf(month);
		if (monthInt >= 3 && monthInt <= 5)
			monthInt = 0;
		else if (monthInt >= 6 && monthInt <= 8)
			monthInt = 1;
		else if (monthInt >= 9 && monthInt <= 11)
			monthInt = 2;
		else 
			monthInt = 3;
		
		// output
		dateStr = year + dash + dateStr;
		JOptionPane.showMessageDialog(null, dateStr + " is " + SEASON[monthInt]);
	}
}
