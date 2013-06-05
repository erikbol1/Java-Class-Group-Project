package persistance;

import java.util.ArrayList;
import java.util.List;

import model.ContactInfo;
import model.Name;
import model.Student;

public class StaticStudentRepository implements StudentRepository{

	List<Student> students;
	
	public StaticStudentRepository(){
		students = initializeStudentList();
	}
	@Override
	public Student getStudent(String username) {
		for (Student student: students)
			if (student.getUsername().equalsIgnoreCase(username))
				return student;
		
		return null;
	}

	@Override
	public boolean saveStudent(Student newStudent) {
		//Protect against null student
		if (newStudent == null)
			return false;
		
		//Update student
		for (Student oldStudent: students)
			if (oldStudent.getUsername().equalsIgnoreCase(newStudent.getUsername())){
				students.remove(oldStudent);
				return students.add(newStudent);
			}
			
		//Save new student
		return students.add(newStudent);
	}

	/**
	 * Build our static list of students
	 * @return our students
	 */
	private List<Student> initializeStudentList(){
		List<Student> output = new ArrayList<Student>();
		
		//Create students
		Student student1 = new Student(123098, new Name("Jane", "Wu"), "janewu", new ContactInfo("janewu@uci.edu", 5555555551L));
		
		//Add students to output list
		output.add(student1);
		
		return output;
	}
}
