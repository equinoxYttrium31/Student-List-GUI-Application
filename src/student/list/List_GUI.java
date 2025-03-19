package student.list;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class List_GUI extends JFrame {

	DefaultTableModel tableModel;
	JTextField search;
	JTable listStudentTable;

	public List_GUI() {
		setSize(850, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode("#c7ced6"));
		setLayout(null);
		setResizable(false);
		setTitle("Student List (CRUD Practice)");

		MatteBorder underlineBorder = new MatteBorder(2, 2, 2, 2, Color.decode("#0A2342"));
		EmptyBorder paddingBorder = new EmptyBorder(0, 10, 0, 0);

		JLabel header = new JLabel("List of Students");
		header.setBounds(10, 10, 550, 30);
		header.setFont(new Font("Porza Libre", Font.BOLD, 24));
		header.setForeground(Color.decode("#0A2342"));
		header.setVisible(true);

		String[] columnNameStrings = { "Student ID", "Name", "Email", "Gender", "Birthdate" };
		tableModel = new DefaultTableModel(columnNameStrings, 0);
		listStudentTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(listStudentTable);
		scrollPane.setBounds(10, 50, 800, 300);

		JLabel searchJLabel = new JLabel("Search By Student ID:");
		searchJLabel.setBounds(10, 380, 550, 30);
		searchJLabel.setFont(new Font("Porza Libre", Font.BOLD, 16));
		searchJLabel.setForeground(Color.decode("#0A2342"));

		search = new JTextField();
		search.setBounds(10, 410, 550, 30);
		search.setFont(new Font("Porza Libre", Font.PLAIN, 16));
		search.setForeground(Color.decode("#0A2342"));
		search.setBackground(new Color(0, 0, 0, 0));
		search.setOpaque(false);
		search.setBorder(new CompoundBorder(underlineBorder, paddingBorder));

		JButton searchButton = new JButton("Search");
		searchButton.setBounds(590, 410, 100, 30);
		searchButton.setBackground(new Color(0, 0, 0, 0));
		searchButton.setOpaque(false);
		searchButton.setFocusable(false);
		searchButton.setFont(new Font("Porza Libre", Font.BOLD, 14));
		searchButton.setForeground(Color.decode("#0A2342"));
		searchButton.setBorder(underlineBorder);
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchStudent();
			}
		});

		JButton backButton = new JButton("Back");
		backButton.setBounds(710, 410, 100, 30);
		backButton.setBackground(new Color(0, 0, 0, 0));
		backButton.setOpaque(false);
		backButton.setFocusable(false);
		backButton.setFont(new Font("Porza Libre", Font.BOLD, 14));
		backButton.setForeground(Color.decode("#0A2342"));
		backButton.setBorder(underlineBorder);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.addActionListener(e -> {
			this.hide();
			new Students_GUI();
		});

		loadStudentData();

		add(header);
		add(scrollPane);
		add(searchJLabel);
		add(search);
		add(searchButton);
		add(backButton);
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

	private void searchStudent() {
		String searchID = search.getText().trim();
		if (searchID.isEmpty()) {
			loadStudentData();
			return;
		}

		List<Project_Functions.Student> students = Project_Functions.getStudents();
		tableModel.setRowCount(0);

		for (Project_Functions.Student student : students) {
			if (student.getStudentIDString().equalsIgnoreCase(searchID)) {
				Object[] row = { student.getStudentIDString(), student.getNameString(), student.getEmailString(),
						student.getGenderString(), student.getBirthDateString() };
				tableModel.addRow(row);
				break;
			}
		}
	}
}
