/*
 * filename: Practic1Q2.java
 * Calculate D-day
 * 2023-03-29
 * Jaehyun Yoon
 */
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Practice1Q2 {

	public static void main(String[] args) {
		
		// input
		String inStr = JOptionPane.showInputDialog(null, "Please enter anniversary(i.e. Christmas / 2023-12-25): ");
		String[] inStrList = divideStr(inStr);
		Date anniversary = makeDate(inStrList[1]);
		
		Date today = new Date();
		
		// calculate & output
		long days;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Today: " + sdf.format(today));
		
		// same
		if(today.equals(anniversary))			
			System.out.println("Today is" + inStrList[0] + "(" + inStrList[1] + ")");
		// left
		else if(today.before(anniversary)) {	
			days = calculate(anniversary, today) + 1;
			System.out.print("There are " + days + " days left until " + inStrList[0] + "(" + inStrList[1] + ")");
		}
		// passed
		else {		
			days = calculate(today, anniversary) - 1;
			System.out.println(days + " days have passed since " + inStrList[0] + "(" + inStrList[1] + ")");
		}
		
	}
	
	// divide input to anniversary and date of anniversary
	public static String[] divideStr(String str) {
		String[] strList = new String[2];
		strList[0] = str.substring(0, str.indexOf('/')-1);
		strList[1] = str.substring(str.indexOf('/')+2);
		
		return strList;
	}
	
	// string to integer array(year, month, day)
	public static Date makeDate(String str) { 
		String buffer; 
		int year, month, day;

		year = Integer.valueOf(str.substring(0, str.indexOf('-')));
		buffer = str.substring(str.indexOf('-')+1);
		month = Integer.valueOf(buffer.substring(0, buffer.indexOf('-')));
		day = Integer.valueOf(buffer.substring(buffer.indexOf('-')+1));		
		
		Calendar dateCalendar = new GregorianCalendar(year, month-1, day, 0, 0, 0);
		Date date = dateCalendar.getTime();
		
		return date;
	}
	
	// calculate the days
	public static long calculate(Date start, Date end) {
		long result = start.getTime() - end.getTime();
		result = (result / (24 * 60 * 60  * 1000L));
		return result;
	}
}
