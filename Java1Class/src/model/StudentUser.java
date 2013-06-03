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
		//System.out.println("My name is " + studentFirstName + " " + studentLastName);
	}

	//Default constructor if no inputs
	public StudentUser () {
		System.out.println("Please enter your student information.");
	}

	//Methods (getters & setters) to View Account Details

	//get student id
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int id) {
		studentId = id;
	}

	//get first name
	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String firstName) {
		studentFirstName = firstName;
	}

	//get last name
	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String lastName) {
		studentLastName = lastName;
	}

	//get login
	public String getStudentLogin() {
		return studentLogin;
	}

	public void setStudentLogin(String login) {
		studentLogin = login;
	}

	//get email
	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String email) {
		studentEmail = email;
	}

	//get phone number
	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String phone) {
		studentPhone = phone;
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
