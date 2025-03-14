package student.list;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Students_GUI extends JFrame {

	private String[] genderSelect = { "Male", "Female", "Other" };
	private String studID, studName, birthDate, genderString, email;

	public Students_GUI() {
		setSize(550, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode("#c7ced6"));
		setLayout(null);
		setResizable(false);
		setTitle("Student List (CRUD Practice)");

		// Initializations
		JLabel titleJLabel = new JLabel("Student List (CRUD Practice)");
		JLabel studIDJLabel = new JLabel("Student ID: ");
		JLabel nameJLabel = new JLabel("Student Name: ");
		JLabel birthdateJLabel = new JLabel("Birthdate: [mmm/dd/yyyy]");
		JLabel genderJLabel = new JLabel("Gender: ");
		JLabel emaiJLabel = new JLabel("Email: ");

		JTextField studJTextField = new JTextField();
		JTextField nameJTextField = new JTextField();
		JTextField emailJTextField = new JTextField();
		JTextField birthDJTextField = new JTextField();

		JComboBox gender = new JComboBox<>(genderSelect);

		JButton submitButton = new JButton("Add Student");
		JButton showListButton = new JButton();

		MatteBorder underlineBorder = new MatteBorder(2, 2, 2, 2, Color.decode("#0A2342"));
		EmptyBorder paddingBorder = new EmptyBorder(0, 10, 0, 0);

		// Label Configurations
		titleJLabel.setBounds(10, 10, 550, 30);
		titleJLabel.setFont(new Font("Porza Libre", Font.BOLD, 24));
		titleJLabel.setForeground(Color.decode("#0A2342"));
		titleJLabel.setVisible(true);

		studIDJLabel.setBounds(40, 55, 150, 30);
		studIDJLabel.setFont(new Font("Porza Libre", Font.BOLD, 16));
		studIDJLabel.setForeground(Color.decode("#0A2342"));

		nameJLabel.setBounds(40, 125, 150, 30);
		nameJLabel.setFont(new Font("Porza Libre", Font.BOLD, 16));
		nameJLabel.setForeground(Color.decode("#0A2342"));

		birthdateJLabel.setBounds(40, 195, 250, 30);
		birthdateJLabel.setFont(new Font("Porza Libre", Font.BOLD, 16));
		birthdateJLabel.setForeground(Color.decode("#0A2342"));

		genderJLabel.setBounds(40, 265, 250, 30);
		genderJLabel.setFont(new Font("Porza Libre", Font.BOLD, 16));
		genderJLabel.setForeground(Color.decode("#0A2342"));

		emaiJLabel.setBounds(40, 335, 250, 30);
		emaiJLabel.setFont(new Font("Porza Libre", Font.BOLD, 16));
		emaiJLabel.setForeground(Color.decode("#0A2342"));

		// Input Configurations
		studJTextField.setBounds(40, 85, 450, 30);
		studJTextField.setFont(new Font("Porza Libre", Font.BOLD, 16));
		studJTextField.setForeground(Color.decode("#0A2342"));
		studJTextField.setBackground(new Color(0, 0, 0, 0));
		studJTextField.setOpaque(false);
		studJTextField.setBorder(new CompoundBorder(underlineBorder, paddingBorder));

		nameJTextField.setBounds(40, 155, 450, 30);
		nameJTextField.setFont(new Font("Porza Libre", Font.BOLD, 16));
		nameJTextField.setForeground(Color.decode("#0A2342"));
		nameJTextField.setBackground(new Color(0, 0, 0, 0));
		nameJTextField.setOpaque(false);
		nameJTextField.setBorder(new CompoundBorder(underlineBorder, paddingBorder));

		birthDJTextField.setBounds(40, 225, 450, 30);
		birthDJTextField.setFont(new Font("Porza Libre", Font.BOLD, 16));
		birthDJTextField.setForeground(Color.decode("#0A2342"));
		birthDJTextField.setBackground(new Color(0, 0, 0, 0));
		birthDJTextField.setOpaque(false);
		birthDJTextField.setBorder(new CompoundBorder(underlineBorder, paddingBorder));

		gender.setBounds(40, 295, 450, 30);
		gender.setFont(new Font("Porza Libre", Font.BOLD, 16));
		gender.setForeground(Color.decode("#0A2342"));
		gender.setBackground(Color.decode("#c7ced6"));
		gender.setBorder(underlineBorder);

		emailJTextField.setBounds(40, 365, 450, 30);
		emailJTextField.setFont(new Font("Porza Libre", Font.BOLD, 16));
		emailJTextField.setForeground(Color.decode("#0A2342"));
		emailJTextField.setBackground(new Color(0, 0, 0, 0));
		emailJTextField.setOpaque(false);
		emailJTextField.setBorder(new CompoundBorder(underlineBorder, paddingBorder));

		submitButton.setBounds(340, 425, 120, 35);
		submitButton.setBackground(new Color(0, 0, 0, 0));
		submitButton.setOpaque(false);
		submitButton.setFocusable(false);
		submitButton.setFont(new Font("Porza Libre", Font.BOLD, 14));
		submitButton.setForeground(Color.decode("#0A2342"));
		submitButton.setBorder(underlineBorder);
		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitButton.addActionListener(e -> {
			studID = studJTextField.getText();
			studName = nameJTextField.getText();
			email = emailJTextField.getText();
			birthDate = birthDJTextField.getText();
			genderString = (String) gender.getSelectedItem();

			Project_Functions.addStudent(studID, studName, genderString, birthDate, email);
		});

		add(titleJLabel);
		add(studIDJLabel);
		add(studJTextField);
		add(nameJLabel);
		add(nameJTextField);
		add(birthdateJLabel);
		add(birthDJTextField);
		add(genderJLabel);
		add(gender);
		add(emaiJLabel);
		add(emailJTextField);
		add(submitButton);

		setVisible(true);
	}

}
