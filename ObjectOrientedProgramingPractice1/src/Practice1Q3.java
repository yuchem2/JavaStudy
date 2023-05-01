/*
 * Filename: Practicce1Q3.java
 * Convert Korean won into dollar through the dialog
 * 2023-03-26
 * Jaehyun Yoon
 */
import javax.swing.JOptionPane;

public class Practice1Q3 {
	
	static final double EXCHANGE_RATE = 1295.83;
	
	public static void main(String[] args) {
		double inNum = Double.valueOf(JOptionPane.showInputDialog(null, "Please enter the Korean won you want to convert into dollars."));
		
		double outNum = inNum / EXCHANGE_RATE;
		JOptionPane.showMessageDialog(null, String.format("The result of the exchange: %.2f $", outNum));
	}
}
