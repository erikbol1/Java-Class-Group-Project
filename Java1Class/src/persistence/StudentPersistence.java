package persistence;

import java.util.List;

import model.Student;

public interface StudentPersistence {
	
	public List<Student> getStudents();
	public boolean persistStudent(Student student);

}
