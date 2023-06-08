import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

/**
 * Q3: Save & Load Student Table
 * 
 * @author JaeHyun Yoon
 * @since 06-06-2023
 * @see Q2
 * @see CollegeStudent
 */
public class Q3 extends Q2 {

	public Q3() {
		super();
		setSize(500, 600);
		JButton btnSave = new JButton("Save");
		JButton btnLoad = new JButton("Load");

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});

		btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});

		Container btnContainer = new Container();
		btnContainer.setLayout(new GridLayout(1, 2));
		btnContainer.add(btnSave);
		btnContainer.add(btnLoad);
		Container buff = (Container) getContentPane().getComponent(1);
		buff.add(btnContainer);

		setVisible(true);
	}

	public void save() {
		String fileName = "backup2019270664_윤재현.data";
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

			objectOut.writeInt(studentList.size());
			for (int i = 0; i < studentList.size(); i++) {
				objectOut.writeObject(studentList.get(i));
			}
			objectOut.close();
			fileOut.close();

			JOptionPane.showMessageDialog(this, "Saved successfully!");

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error! Try again!");
		}

	}

	public void load() {
		String fileName = "backup2019270664_윤재현.data";
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			int len = tableModel.getRowCount();
			for (int i = 0; i < len; i++) {
				tableModel.removeRow(0);
			}
			studentList.clear();

			len = objectIn.readInt();
			for (int i = 0; i < len; i++) {
				CollegeStudent student = (CollegeStudent) objectIn.readObject();
				Object[] rowData = { student.getStudentId(), student.getDepartment(), student.getGender(),
						student.getGPA(), student.getHeight(), student.getWeight() };
				studentList.add(student);
				tableModel.addRow(rowData);
			}

			objectIn.close();
			fileIn.close();

			JOptionPane.showMessageDialog(this, "Load successfully!");

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Eror! Try again!");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Save File Error!");
		}

	}

	public static void main(String[] args) {
		Q3 window = new Q3();

	}

}
