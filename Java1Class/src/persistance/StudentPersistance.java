package persistance;

import java.util.List;

import model.Student;

public interface StudentPersistance {
	
	public List<Student> getStudents();
	public boolean persistStudent(Student student);

}
