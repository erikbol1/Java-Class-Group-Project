package tests;

import java.util.ArrayList;
import java.util.List;

import model.StudentUser;

/**
 * This is mainly just test code to make sure that the StudentUser class is working.
 */
public class AddStudent {

	public static void main (String[] args) {
		//Create an ArrayList of type StudentUser to store list of students
		List<StudentUser> studentList = new ArrayList<StudentUser>();

		StudentUser student1 = new StudentUser(123098, "Jane","Wu","janewu", "janewu@uci.edu","555-555-5551");
		System.out.println("Student: " + student1.toString());
		System.out.println();

		//Add each of the student objects to the array list.
		studentList.add(student1);
		System.out.println("Students in array: " + studentList.size());
		System.out.println();

	}
}
