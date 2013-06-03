package model;


/**
 * This class contains constructors for student inputs, and methods for getting student information
 */
public class StudentUser {

	//instance variables
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private long phoneNumber;

	//Constructor to take inputs
	public StudentUser (int id, String firstName, String lastName, String username, String email, long phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	//Methods (getters & setters) to View Account Details

	//get student id
	public int getStudentId() {
		return id;
	}

	//get first name
	public String getFirstName() {
		return firstName;
	}

	//get last name
	public String getLastName() {
		return lastName;
	}

	//get login
	public String getUsername() {
		return username;
	}

	//get email
	public String getEmailAddress() {
		return email;
	}

	//get phone number
	public long getPhoneNumber() {
		return phoneNumber;
	}

	//get fullname
	public String getFullName() {
		return firstName + " " + lastName;
	}

	//print string
	@Override
	public String toString() {
		return "[studentId: " + id + "firstName:" + firstName + ", lastName:" + lastName + ", studentLogin:" + username + ", studentEmail:" + email + ", studentPhone:" + phoneNumber + "]";
	}

}
//View Registered Courses


//Register for Courses


//View Available Courses
