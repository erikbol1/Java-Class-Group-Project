package persistence;

import model.Student;

public interface StudentRepository {

	public Student getStudent(String username);
	public boolean saveStudent(Student student);
	public int nextStudentID();
}
