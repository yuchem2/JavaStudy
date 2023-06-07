import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * Q5Server: Management Student Database System - ServerUI
 * 
 * @author JaeHyun Yoon
 * @since 06-07-2023
 * @see ServerThread
 * @see ServiceThread
 */

public class Q5Server extends JFrame {

	private DefaultTableModel tableModel;
	private JTable table;
	private JTextArea log = new JTextArea();
	private String fileName = "backup2019270664_윤재현.data";
	private Vector<CollegeStudent> studentList = new Vector<CollegeStudent>();

	public Q5Server() {
		super("Manage Student - database");
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

		Container mainContainer = getContentPane();
		mainContainer.add(scrollPane, BorderLayout.NORTH);
		mainContainer.add(new JScrollPane(log), BorderLayout.CENTER);

		new ServerThread(log, fileName, studentList, tableModel).start();
		log.setText("Manmage Student Program\n");

		setVisible(true);
	}

	public static void main(String[] args) {
		new Q5Server();
	}

}
