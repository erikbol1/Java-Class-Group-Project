//add Students -- this is mainly just test code to make sure that the StudentUser class is working

//import java API's
import java.io.*;
import java.util.*;
import org.apache.commons.lang3.*;

class AddStudent {

  public static void main (String[] args) {
	//Create an ArrayList of type StudentUser to store list of students
		ArrayList<StudentUser> studentList = new ArrayList<StudentUser>();
			System.out.println("Initial size of array: " + studentList.size());
			System.out.println();

	StudentUser student1 = new StudentUser(123098, "Jane","Wu","janewu", "janewu@uci.edu","555-555-5551");
			System.out.println("Student: " + student1.toString());
			System.out.println();

	//Add each of the student objects to the array list.
		studentList.add(student1);
		System.out.println("Initial size of array: " + studentList.size());
		System.out.println();

	}
}
