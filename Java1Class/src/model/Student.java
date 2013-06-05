package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * This class contains constructor for student inputs, and methods for getting student information
 */
public class Student {

	//instance variables
	private int id;
	private Name name;
	private String username;
	private ContactInfo contactInfo;
	private List<String> courses;

	//Constructor to take inputs
	public Student (int id, Name name, String username, ContactInfo contactInfo) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.contactInfo = contactInfo;
		
		courses = new ArrayList<String>();//Initialize array
	}
	//get student id
	public int getStudentId() {
		return id;
	}
	//get first name
	public String getFirstName() {
		return name.getFirstName();
	}
	//get last name
	public String getLastName() {
		return name.getLastName();
	}
	//get login
	public String getUsername() {
		return username;
	}
	//get email
	public String getEmailAddress() {
		return contactInfo.getEmail();
	}
	//get phone number
	public long getPhoneNumber() {
		return contactInfo.getPhoneNumber();
	}
	//get fullname
	public String getFullName() {
		return name.getFullName();
	}
	/**
	 * @return List of Course Ids for courses student is registered
	 */
	public List<String> getCourseList(){
		return Collections.unmodifiableList(courses);
	}
	/**
	 * Register a student for a course.
	 * @param courseId The course's id
	 * @return true for success
	 */
	public boolean addCourse(String courseId){
		return courses.add(courseId);
	}
	/**
	 * Unregister a student for a course.
	 * @param courseId The course's id
	 * @return true for success
	 */
	public boolean removeCourse(String courseId){
		return courses.remove(courseId);
	}
	@Override
	public String toString() {
		//Build output string
		StringBuilder output = new StringBuilder();
		output.append(id + "| ");
		output.append(name.toString() + "| ");
		output.append(username + "| ");
		output.append(contactInfo.toString() + "| ");
		//Add courses
		for(String courseId: courses)
			output.append(courseId + "| ");
		//Create string without final "| "
		return output.substring(0, output.length() - 2);
	}

}