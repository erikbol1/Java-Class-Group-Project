package model;


/**
 * This class contains constructors for student inputs, and methods for getting student information
 */
public class StudentUser {

	//instance variables
	private int studentId;
	private String studentFirstName;
	private String studentLastName;
	private String studentLogin;
	private String studentEmail;
	private String studentPhone;
	private String studentFullName;

	//Constructor to take inputs
	public StudentUser (int id, String firstName, String lastName, String login, String email, String phone) {
		studentId = id;
		studentFirstName = firstName;
		studentLastName = lastName;
		studentLogin = login;
		studentEmail = email;
		studentPhone = phone;
	}

	//Methods (getters & setters) to View Account Details

	//get student id
	public int getStudentId() {
		return studentId;
	}

	//get first name
	public String getStudentFirstName() {
		return studentFirstName;
	}

	//get last name
	public String getStudentLastName() {
		return studentLastName;
	}

	//get login
	public String getStudentLogin() {
		return studentLogin;
	}

	//get email
	public String getStudentEmail() {
		return studentEmail;
	}

	//get phone number
	public String getStudentPhone() {
		return studentPhone;
	}

	//get fullname
	public String getStudentFullName() {
		studentFullName = studentFirstName + " " + studentLastName;
		return studentFullName;
	}

	//print string
	public String toString() {
		return "[studentId: " + studentId + "firstName:" + studentFirstName + ", lastName:" + studentLastName + ", studentLogin:" + studentLogin + ", studentEmail:" + studentEmail + ", studentPhone:" + studentPhone + "]";
	}

}
//View Registered Courses


//Register for Courses


//View Available Courses
