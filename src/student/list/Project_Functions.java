package student.list;

import java.util.ArrayList;
import java.util.List;

public class Project_Functions {

	public static class Student {
		private String studentIDString;
		private String nameString;
		private String genderString;
		private String birthDateString;
		private String emailString;

		public Student(String studentIDString, String nameString, String genderString, String birthDateString,
				String emailString) {
			this.studentIDString = studentIDString;
			this.nameString = nameString;
			this.genderString = genderString;
			this.birthDateString = birthDateString;
			this.emailString = emailString;
		}

		public String getStudentIDString() {
			return studentIDString;
		}

		public void setStudentIDString(String studentIDString) {
			this.studentIDString = studentIDString;
		}

		public String getNameString() {
			return nameString;
		}

		public void setNameString(String nameString) {
			this.nameString = nameString;
		}

		public String getGenderString() {
			return genderString;
		}

		public void setGenderString(String genderString) {
			this.genderString = genderString;
		}

		public String getEmailString() {
			return emailString;
		}

		public void setEmailString(String emailString) {
			this.emailString = emailString;
		}

		public String getBirthDateString() {
			return birthDateString;
		}

		public void setBirthDateString(String birthDateString) {
			this.birthDateString = birthDateString;
		}

		@Override
		public String toString() {
			return "Student [ID=" + studentIDString + ", Name=" + nameString + ", Gender=" + genderString
					+ ", Birthdate=" + birthDateString + ", Email=" + emailString + "]";
		}

	}

	private static List<Student> studentsList = new ArrayList<>();

	public static void addStudent(String studentIDString, String nameString, String genderString,
			String birthDateString, String emailString) {
		Student newStudent = new Student(studentIDString, nameString, genderString, birthDateString, emailString);
		studentsList.add(newStudent);
		System.out.println("Student added: " + newStudent);
	}

	public static List<Student> getStudents() {
		return studentsList;
	}

}
