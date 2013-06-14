package tests;

import java.util.ArrayList;
import java.util.List;

import model.ContactInfo;
import model.Name;
import model.Student;

/**
 * This is mainly just test code to make sure that the Student class is working.
 */
public class AddStudent {

	public static void main (String[] args) {
		//Create an ArrayList of type StudentUser to store list of students
		List<Student> studentList = new ArrayList<Student>();

		Student student1 = new Student(123098, new Name("Jane", "Wu"), "janewu", new ContactInfo("janewu@uci.edu", 5555555551L));
		System.out.println("Student: " + student1.toString());
		System.out.println();

		//Add each of the student objects to the array list.
		studentList.add(student1);
		System.out.println("Students in array: " + studentList.size());
		System.out.println();

	}
}
