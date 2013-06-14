package persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ContactInfo;
import model.Name;
import model.Student;

public class FileStudentPersistance implements StudentPersistance{

	List<Student> students;
	String fileName;

	public FileStudentPersistance(String fileName){
		this.fileName = fileName;
		students = pullFromFile(fileName);
	}

	@Override
	public List<Student> getStudents() {
		return students;
	}

	@Override
	public boolean persistStudent(Student student) {
		if (student == null)
			return false;

		return persistInFile(students, fileName);
	}

	private List<Student> pullFromFile(String file){
		List<Student> output = new ArrayList<Student>();
		File input = new File(file);
		Scanner scanner;

		try {
			scanner = new Scanner(input);
			while (scanner.hasNext()){
				//Read a line and break it into parts
				String[] studentParts = scanner.nextLine().split(", ");

				//Assign the attributes
				int studentId = Integer.parseInt(studentParts[0]);
				String firstName = studentParts[1];
				String lastName = studentParts[2];
				String username = studentParts[3];
				String email = studentParts[4];
				long phoneNumber = Long.parseLong(studentParts[5]);

				//Build the student
				Student temp = new Student(studentId, 
						new Name(firstName, lastName), 
						username, 
						new ContactInfo(email, phoneNumber));

				if (studentParts.length != 6){//Add the courses
					int limit = studentParts.length;
					for (int index = 6; index < limit; index++)
						temp.addCourse(studentParts[index]);
				}

				//Add the student to the output
				output.add(temp);
			}
			//Close the file
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return output;
	}

	private boolean persistInFile(List<Student> courseList, String file){
		File output = new File(file);
		PrintWriter printer;
		try {
			printer = new PrintWriter(output);
			for (Student student: students){
				//Write to file
				printer.println(student.toString());
			}
			//Close file
			printer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return true;
	}
}
