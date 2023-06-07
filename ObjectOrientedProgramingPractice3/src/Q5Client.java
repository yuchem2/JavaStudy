import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;

import javax.swing.*;

/**
 * Q5Client: Management Student Database System - Client
 * 
 * @author JaeHyun Yoon
 * @since 06-07-2023
 * @see Q3
 */

public class Q5Client extends Q3 {

	private Socket socket = null;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private JLabel lblAverage = new JLabel("");

	public Q5Client() {
		studentList = null; // not used
		setSize(600, 600);
		JButton btnCal = new JButton("Calculate Avaerage GPA");
		JButton btnTermination = new JButton("Terminate");

		btnCal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();
			}
		});

		btnTermination.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				terminate();
			}
		});

		Container calContainer = new Container();
		calContainer.setLayout(new GridLayout(3, 1));
		calContainer.add(btnCal);
		calContainer.add(lblAverage);
		calContainer.add(btnTermination);

		Container superContainer = getContentPane();
		superContainer.add(calContainer, BorderLayout.EAST);

		if (JOptionPane.showConfirmDialog(this, "Connect?") == 0) {
			setupConnection();
		} else {
			JOptionPane.showMessageDialog(this, "Quit program!");
			System.exit(0);
		}
	}

	@Override
	public void addStudent(boolean user) {
		try {
			out.writeObject("Add");
			out.flush();

			String department = (String) cmbDepartment.getSelectedItem();
			String gender = (String) cmbGender.getSelectedItem();
			double GPA = Double.parseDouble(txtGPA.getText());
			double height = Double.parseDouble(txtHeight.getText());
			double weight = Double.parseDouble(txtWeight.getText());

			CollegeStudent student = new CollegeStudent(department, gender, height, weight, GPA);
			out.writeObject(student);
			out.flush();

			student = (CollegeStudent) in.readObject();
			Object[] rowData = { student.getStudentId(), student.getDepartment(), student.getGender(), student.getGPA(),
					student.getHeight(), student.getWeight() };
			tableModel.addRow(rowData);

			String result = (String) in.readObject();
			JOptionPane.showMessageDialog(this, result);
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Fail to add student");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Plase input correct instance!");
			e.printStackTrace();
		}
	}

	@Override
	public void load() {
		try {
			out.writeObject("Load");
			out.flush();

			for (int i = 0; i < tableModel.getRowCount(); i++) {
				tableModel.removeRow(0);
			}

			int len = in.read();
			for (int i = 0; i < len; i++) {
				CollegeStudent student = (CollegeStudent) in.readObject();
				Object[] rowData = { student.getStudentId(), student.getDepartment(), student.getGender(),
						student.getGPA(), student.getHeight(), student.getWeight() };
				tableModel.addRow(rowData);
			}
			String result = (String) in.readObject();
			JOptionPane.showMessageDialog(this, result);
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Fail to load data");
			e.printStackTrace();
		}

	}

	@Override
	public void save() {
		try {
			out.writeObject("Save");
			out.flush();

			String result = (String) in.readObject();
			JOptionPane.showMessageDialog(this, result);
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Fail to save data");
			e.printStackTrace();
		}

	}

	public void calculate() {
		try {
			out.writeObject("Calculate");
			out.flush();

			double average = in.readDouble();
			lblAverage.setText("Average GPA : " + (Math.round(average * 100) / 100.0));
			String result = (String) in.readObject();
			JOptionPane.showMessageDialog(this, result);

		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Fail to calculate avaerage GPA");
			e.printStackTrace();
		}

	}

	public void terminate() {
		try {
			out.writeObject("Terminate");
			out.flush();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Fail to Terminate");
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				if (socket != null)
					socket.close();
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void setupConnection() {
		try {
			socket = new Socket("localhost", 9998);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Q5Client();
	}

}
