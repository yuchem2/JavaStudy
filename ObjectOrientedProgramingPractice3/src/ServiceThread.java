import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import java.net.*;
import java.util.Vector;
import java.io.*;

/**
 * ServiceThread: Management Student Database System - ServiceThread
 * 
 * @author JaeHyun Yoon
 * @since 06-07-2023
 */

class ServiceThread extends Thread {
	private Socket socket = null;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private JTextArea log = null;
	private String fileName;
	private Vector<CollegeStudent> studentList;
	private DefaultTableModel tableModel;

	public ServiceThread(Socket socket, JTextArea log, String fileName, Vector<CollegeStudent> studentList,
			DefaultTableModel tableModel) {
		this.socket = socket;
		this.log = log;
		this.fileName = fileName;
		this.studentList = studentList;
		this.tableModel = tableModel;
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void add() {
		try {
			CollegeStudent student = (CollegeStudent) in.readObject();
			student = new CollegeStudent(student.getDepartment(), student.getGender(), student.getHeight(),
					student.getWeight(), student.getGPA());
			studentList.add(student);
			Object[] rowData = { student.getStudentId(), student.getDepartment(), student.getGender(), student.getGPA(),
					student.getHeight(), student.getWeight() };
			out.writeObject(student);
			tableModel.addRow(rowData);
			out.writeObject("Add successfully!");
			out.flush();
			log.append("Add student in database\n");

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	public void load() {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			int len = tableModel.getRowCount();
			for (int i = 0; i < len; i++) {
				tableModel.removeRow(0);
			}
			studentList.clear();

			len = objectIn.readInt();
			CollegeStudent.setGlobalStudentId(len + 1);
			out.write(len);
			for (int i = 0; i < len; i++) {
				CollegeStudent student = (CollegeStudent) objectIn.readObject();
				Object[] rowData = { student.getStudentId(), student.getDepartment(), student.getGender(),
						student.getGPA(), student.getHeight(), student.getWeight() };
				studentList.add(student);
				out.writeObject(student);
				tableModel.addRow(rowData);
			}

			objectIn.close();
			fileIn.close();

			out.writeObject("Load successfully!");
			out.flush();
			log.append("Load database in [" + fileName + "]\n");
		} catch (IOException | ClassNotFoundException e) {
			try {
				out.writeObject("Error! Try again!");
				out.flush();
				log.append("Fail to load database in [" + fileName + "]\n");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

			objectOut.writeInt(studentList.size());
			for (int i = 0; i < studentList.size(); i++) {
				objectOut.writeObject(studentList.get(i));
			}
			objectOut.close();
			fileOut.close();

			out.writeObject("Saved successfully!");
			out.flush();
			log.append("Save database in [" + fileName + "]\n");

		} catch (IOException e) {
			try {
				out.writeObject("Error! Try again!");
				out.flush();
				log.append("Fail to save database in [" + fileName + "]\n");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	public void calculate() {
		try {
			double average = 0.0;
			for (CollegeStudent student : studentList) {
				average += student.getGPA();
			}
			average /= studentList.size();
			out.writeDouble(average);
			out.writeObject("Calculate successfully!");
			out.flush();
			log.append("Calculate average GPA: " + average + "\n");
		} catch (IOException e) {
			try {
				out.writeObject("Error! Try again!");
				out.flush();
				log.append("Fail to calculate average GPA among database in [" + fileName + "]\n");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	public void remove() {
		log.append("Connection terminated...\n");
		int len = tableModel.getRowCount();
		for (int i = 0; i < len; i++) {
			tableModel.removeRow(0);
		}
		studentList.clear();
		CollegeStudent.setGlobalStudentId(1);

		try {
			in.close();
			out.close();
			if (socket != null)
				socket.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				String command = (String) in.readObject();
				if (command.equals("Load")) {
					load();
				} else if (command.equals("Save")) {
					save();
				} else if (command.equals("Add")) {
					add();
				} else if (command.equals("Calculate")) {
					calculate();
				} else if (command.equals("Terminate")) {
					remove();
					return;
				}
			} catch (IOException | ClassNotFoundException e) {
				remove();
				return;
			}
		}

	}

}
