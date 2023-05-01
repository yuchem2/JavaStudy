import javax.swing.JOptionPane;

/**
 * Calculate a person's ideal weight.(GUI)
 * 
 * @author Jaehyun yoon
 * @since 04-17-2023
 * @version 1.0
 */
public class Q5 {

	public static void main(String[] args) {
		String[] sex = { "Male", "Female" };
		int num, height;
		double idealWeight = 0.0;

		// Input UI
		num = JOptionPane.showOptionDialog(null, "What is your gender?", "Calculate idael weight",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, sex, "Male");
		while (true) {
			try {

				height = Integer.parseInt(JOptionPane.showInputDialog(null, "How tall are you?(cm)", "Input",
						JOptionPane.QUESTION_MESSAGE));
				if (height < 0) {
					JOptionPane.showMessageDialog(null, "Height must be positive digits", "Warning",
							JOptionPane.ERROR_MESSAGE);
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter digits only", "Warning", JOptionPane.ERROR_MESSAGE);
			}
		}

		// Calculate
		idealWeight = calculateIdealWeight(num, height);

		// Output UI
		JOptionPane.showMessageDialog(null, String.format("Your ideal wieght is %.1fkg", idealWeight), "Message",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Calculate the ideal weight
	 * 
	 * @param sex    will be only 1 or 0. (0: male, 1: female)
	 * @param height
	 * @return ideal weight
	 */
	public static double calculateIdealWeight(int sex, double height) {
		if (sex == 0) {
			if (height < 150) {
				return 40.0;
			} else {
				return (40 + 0.89 * (height - 150));
			}
		} else {
			if (height < 150) {
				return 37.8;
			} else {
				return (37.8 + 0.75 * (height - 150));
			}
		}

	}
}
