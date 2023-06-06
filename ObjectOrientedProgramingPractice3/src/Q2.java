import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Q2: Can add student and Display Student list for GUI
 * 
 * @author JaeHyun Yoon
 * @since 06-06-2023
 * @see CollegeStudent
 */
public class Q2 extends JFrame {

	public DefaultTableModel tableModel;
	public JTable table;
	public JComboBox<String> cmbDepartment;
	public JComboBox<String> cmbGender;
	public JTextField txtGPA;
	public JTextField txtHeight;
	public JTextField txtWeight;

	public Vector<CollegeStudent> studentList = new Vector<CollegeStudent>();

	public static final String[] DEPARTMENTS = { "CS", "Philosophy", "History", "Law" };
	public static final String[] GENDERS = { "Male", "Female" };

	public Q2() {
		setTitle("Manage Stutdent List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLayout(new BorderLayout());

		tableModel = new DefaultTableModel();
		tableModel.addColumn("Student ID");
		tableModel.addColumn("Department");
		tableModel.addColumn("Gender");
		tableModel.addColumn("GPA");
		tableModel.addColumn("Height (cm)");
		tableModel.addColumn("Weight (kg)");

		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);

		JPanel inputPanel = new JPanel(new GridLayout(6, 2));
		JLabel lblDepartment = new JLabel("Department:");
		JLabel lblGender = new JLabel("Gender:");
		JLabel lblHeight = new JLabel("Height (cm):");
		JLabel lblWeight = new JLabel("Weight (kg):");
		JLabel lblGPA = new JLabel("GPA (0.0-4.5): ");
		cmbDepartment = new JComboBox<>(DEPARTMENTS);
		cmbGender = new JComboBox<>(GENDERS);
		txtGPA = new JTextField();
		txtHeight = new JTextField();
		txtWeight = new JTextField();
		JButton btnAdd = new JButton("Add");

		inputPanel.add(lblDepartment);
		inputPanel.add(cmbDepartment);
		inputPanel.add(lblGender);
		inputPanel.add(cmbGender);
		inputPanel.add(lblGPA);
		inputPanel.add(txtGPA);
		inputPanel.add(lblHeight);
		inputPanel.add(txtHeight);
		inputPanel.add(lblWeight);
		inputPanel.add(txtWeight);
		inputPanel.add(btnAdd, BorderLayout.SOUTH);

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addStudent(true);
			}
		});

		for (int i = 0; i < 100; i++) {
			addStudent(false);
		}

		Container mainContainer = getContentPane();
		mainContainer.add(scrollPane, BorderLayout.CENTER);
		mainContainer.add(inputPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	public void addStudent(boolean user) {
		if (user == true) {
			try {
				String department = (String) cmbDepartment.getSelectedItem();
				String gender = (String) cmbGender.getSelectedItem();
				double GPA = Double.parseDouble(txtGPA.getText());
				double height = Double.parseDouble(txtHeight.getText());
				double weight = Double.parseDouble(txtWeight.getText());

				CollegeStudent student = new CollegeStudent(department, gender, height, weight, GPA);
				studentList.add(student);

				Object[] rowData = { student.getStudentId(), student.getDepartment(), student.getGender(), student.getGPA(),
						student.getHeight(), student.getWeight() };
				tableModel.addRow(rowData);

				// Clear the input fields
				cmbDepartment.setSelectedIndex(0);
				cmbGender.setSelectedIndex(0);
				txtHeight.setText("");
				txtWeight.setText("");
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return;
			}
		} else {
			CollegeStudent student = new CollegeStudent();
			studentList.add(student);
			Object[] rowData = { student.getStudentId(), student.getDepartment(), student.getGender(), student.getGPA(),
					student.getHeight(), student.getWeight() };
			tableModel.addRow(rowData);
		}

	}

	public static void main(String[] args) {
		new Q2();

	}

}
