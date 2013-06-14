package persistance;

import java.util.ArrayList;
import java.util.List;

import model.ContactInfo;
import model.Name;
import model.Student;

public class StaticStudentPersistance implements StudentPersistance{

	private List<Student> students;

	public StaticStudentPersistance(){
		students = getStudents();
	}

	@Override
	public List<Student> getStudents() {

		if (students != null)
			return students;

		List<Student> output = new ArrayList<Student>();

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
