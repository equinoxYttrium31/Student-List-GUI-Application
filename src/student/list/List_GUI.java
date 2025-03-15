package student.list;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class List_GUI extends JFrame {

	DefaultTableModel tableModel;

	public List_GUI() {
		setSize(850, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode("#c7ced6"));
		setLayout(null);
		setResizable(false);
		setTitle("Student List (CRUD Practice)");

		JLabel header = new JLabel("List of Students");

		header.setBounds(10, 10, 550, 30);
		header.setFont(new Font("Porza Libre", Font.BOLD, 24));
		header.setForeground(Color.decode("#0A2342"));
		header.setVisible(true);

		String[] columnNameStrings = { "Student ID", "Name", "Email", "Gender", "Birthdate" };
		tableModel = new DefaultTableModel(columnNameStrings, 0);
		JTable listStudenTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(listStudenTable);
		scrollPane.setBounds(10, 50, 800, 300);

		loadStudentData();

		add(header);
		add(scrollPane);
		setVisible(true);
	}

	private void loadStudentData() {
		List<Project_Functions.Student> students = Project_Functions.getStudents();
		tableModel.setRowCount(0);

		for (Project_Functions.Student student : students) {
			Object[] row = { student.getStudentIDString(), student.getNameString(), student.getEmailString(),
					student.getGenderString(), student.getBirthDateString() };
			tableModel.addRow(row);
		}
	}
}
