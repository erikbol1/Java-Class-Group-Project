package persistance;

import model.Course;

public interface Administration {

	public boolean enrollStudentInCourse(String username, Course course);
}
