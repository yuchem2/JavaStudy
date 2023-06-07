import java.net.*;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import java.io.*;

/**
 * ServerThread: Management Student Database System - ServerThread
 * 
 * @author JaeHyun Yoon
 * @since 06-07-2023
 */

class ServerThread extends Thread {
	private JTextArea log = null;
	private String fileName;
	private Vector<CollegeStudent> studentList;
	private DefaultTableModel tableModel;

	public ServerThread(JTextArea log, String fileName, Vector<CollegeStudent> studentList,
			DefaultTableModel tableModel) {
		this.log = log;
		this.fileName = fileName;
		this.studentList = studentList;
		this.tableModel = tableModel;
	}

	@Override
	public void run() {
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9998);
			while (true) {
				socket = listener.accept();
				log.append("Conneted client.\n");
				new ServiceThread(socket, log, fileName, studentList, tableModel).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			if (listener != null)
				listener.close();
			if (socket != null)
				socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
