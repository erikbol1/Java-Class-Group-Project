package persistance;

import model.Course;

public interface RegisterCourse {

	public boolean enrollStudentInCourse(String username, Course course);
}
