package persistence;

import java.util.Set;

import model.Student;

public interface StudentPersistence {
	
	public Set<Student> getStudents();
	public boolean persistStudent(Student student);

}
