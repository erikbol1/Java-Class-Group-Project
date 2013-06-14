package persistence;

import java.util.List;

import model.Student;

public class AbstractStudentRepository implements StudentRepository{

	private List<Student> students;
	private StudentPersistence studentPersistance;
	
	public AbstractStudentRepository(StudentPersistence studentPersistance){
		this.studentPersistance = studentPersistance;
		students = studentPersistance.getStudents();
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
		
		//Save student
		return studentPersistance.persistStudent(newStudent);
	}
	
	@Override
	public int nextStudentID() {
		int nextId = 1;
		for(Student student: students)
			if (student.getStudentId() > nextId)
				nextId = student.getStudentId() + 1;
		
		return nextId;
	}
}
