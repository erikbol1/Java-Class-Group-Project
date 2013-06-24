package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import model.ContactInfo;
import model.Name;
import model.Student;

public class FileStudentPersistence implements StudentPersistence{

	private Set<Student> students;
	private String fileName;

	public FileStudentPersistence(String fileName){
		this.fileName = fileName;
		students = pullFromFile(fileName);
	}

	@Override
	public Set<Student> getStudents() {
		return Collections.unmodifiableSet(students);
	}

	@Override
	public boolean persistStudent(Student newStudent) {
		if (newStudent == null)
			return false;

		students = pullFromFile(fileName);
		for (Student oldStudent: students)
			if (oldStudent.getUsername().equalsIgnoreCase(newStudent.getUsername())){
				students.remove(oldStudent);
				break;
			}

		students.add(newStudent);
		
		return (persistInFile(students, fileName) == students.size()) ? true: false;
	}

	private Set<Student> pullFromFile(String file){
		Set<Student> output = new HashSet<Student>();
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

	private int persistInFile(Set<Student> studentList, String file){
		File output = new File(file);
		PrintWriter printer;
		int count = 0;
		try {
			printer = new PrintWriter(output);
			for (Student student: studentList){
				//Write to file
				printer.println(student.toString());
				count++;
			}
			//Close file
			printer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return count;
	}
}
