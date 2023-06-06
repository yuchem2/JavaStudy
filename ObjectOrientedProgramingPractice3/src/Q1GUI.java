import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Q1GUI: It is GUI window for Q1.java
 * 
 * @author JaeHyun Yoon
 * @since 06-06-2023
 */

class Q1GUI extends JFrame {
	private ButtonGroup departmentGroup;
	private ButtonGroup genderGroup;
	private JLabel lblHeight;
	private JTextField txtHeight;
	private JLabel lblWeight;
	private JTextField txtWeight;
	private JButton btnCalculate;
	private JLabel lblResult;

	public Q1GUI(double heightAverage, double weightAverage) {

		setTitle("User Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 250);
		setLayout(new GridLayout(4, 1));

		departmentGroup = new ButtonGroup();
		genderGroup = new ButtonGroup();
		lblHeight = new JLabel("Height (cm):");
		txtHeight = new JTextField(10);
		lblWeight = new JLabel("Weight (kg):");
		txtWeight = new JTextField(10);
		btnCalculate = new JButton("Calculate");
		lblResult = new JLabel();

		JRadioButton rbtnCS = new JRadioButton("CS");
		JRadioButton rbtnPhilosophy = new JRadioButton("Philosophy");
		JRadioButton rbtnHistory = new JRadioButton("History");
		JRadioButton rbtnLaw = new JRadioButton("Law");
		rbtnCS.setSelected(true);

		JRadioButton rbtnMale = new JRadioButton("Male");
		JRadioButton rbtnFemale = new JRadioButton("Female");
		rbtnMale.setSelected(true);

		departmentGroup.add(rbtnCS);
		departmentGroup.add(rbtnPhilosophy);
		departmentGroup.add(rbtnHistory);
		departmentGroup.add(rbtnLaw);

		genderGroup.add(rbtnMale);
		genderGroup.add(rbtnFemale);

		Container departmentContainer = new Container();
		departmentContainer.setLayout(new FlowLayout());
		departmentContainer.add(new JLabel("Department:"));
		departmentContainer.add(rbtnCS);
		departmentContainer.add(rbtnPhilosophy);
		departmentContainer.add(rbtnHistory);
		departmentContainer.add(rbtnLaw);

		Container genderContainer = new Container();
		genderContainer.setLayout(new FlowLayout());
		genderContainer.add(new JLabel("Gender:"));
		genderContainer.add(rbtnMale);
		genderContainer.add(rbtnFemale);

		Container textContainer = new Container();
		textContainer.setLayout(new FlowLayout());
		textContainer.add(lblHeight);
		textContainer.add(txtHeight);
		textContainer.add(lblWeight);
		textContainer.add(txtWeight);

		Container resultContainer = new Container();
		resultContainer.setLayout(new FlowLayout());
		resultContainer.add(btnCalculate);
		resultContainer.add(lblResult);

		btnCalculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateDifference(heightAverage, weightAverage);
			}
		});

		Container mainContainer = getContentPane();
		mainContainer.add(departmentContainer);
		mainContainer.add(genderContainer);
		mainContainer.add(textContainer);
		mainContainer.add(resultContainer);

		setVisible(true);
	}

	private void calculateDifference(double heightAverage, double weightAverage) {
		try {
			double userHeight = Double.parseDouble(txtHeight.getText());
			double userWeight = Double.parseDouble(txtWeight.getText());

			double heightDifference = Math.round(userHeight - heightAverage);
			double weightDifference = Math.round(userWeight - weightAverage);

			lblResult.setText(
					"Height difference: " + heightDifference + " cm | Weight difference: " + weightDifference + " kg");
		} catch (NumberFormatException e) {
			lblResult.setText("Invalid input!");
		}
	}

}
