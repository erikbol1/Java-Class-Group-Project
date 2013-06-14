package persistance;

import java.util.List;

import model.Course;

public interface CoursePersistance {

	public boolean updateCourse(Course course);
	public List<Course> getCourses();
	public boolean persistNewCourse(Course course);
}
