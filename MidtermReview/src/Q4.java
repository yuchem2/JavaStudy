import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

/**
 * Q4: Calculate real-time age
 * 
 * @author Jaehyun Yoon
 * @since 06-18-2023
 */

public class Q4 {

	public static String getTimeString(Calendar calendar) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		return timeFormat.format(calendar.getTime());
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inStr = JOptionPane.showInputDialog(null,
				"Please enter your name and date of birth (i.e. Minseok Seo / 1987-12-11)");
		String name = inStr.substring(0, inStr.indexOf("/") - 1);
		String birthDay = inStr.substring(inStr.indexOf("/") + 2, inStr.length());

		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("Current time: " + dateFormat.format(currentDate) + " " + getTimeString(calendar));
		System.out.println("Your date of birth: " + birthDay + " 00:00:00");
		System.out.println("===================================");
		System.out.println("Therefore, your current real-time age is: ");
		
		int year = currentDate.getYear() - Integer.parseInt(birthDay.substring(0, birthDay.indexOf("-"))) + 1900 - 1;
		
		System.out.println(year + " Yrs " + currentDate.getHours() + " hrs " + currentDate.getMinutes() + " min " + currentDate.getSeconds() + " sec");

	}

}