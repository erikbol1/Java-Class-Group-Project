package persistence;

import java.util.HashSet;
import java.util.Set;

import model.ContactInfo;
import model.Name;
import model.Student;

public class StaticStudentPersistence implements StudentPersistence{

	private Set<Student> students;

	public StaticStudentPersistence(){
		students = getStudents();
	}

	@Override
	public Set<Student> getStudents() {

		if (students != null)
			return students;

		Set<Student> output = new HashSet<Student>();

		//Create students
		Student student1 = new Student(123098, new Name("Jane", "Wu"), "janewu", new ContactInfo("janewu@uci.edu", 5555555551L));

		//Add students to output list
		output.add(student1);

		return output;
	}

	@Override
	public boolean persistStudent(Student student) {
		//Protect against null student
		if (student == null)
			return false;

		//Update student
		for (Student oldStudent: students)
			if (oldStudent.getUsername().equalsIgnoreCase(student.getUsername())){
				students.remove(oldStudent);
				break;
			}

		//Save new student
		return students.add(student);
	}

}
