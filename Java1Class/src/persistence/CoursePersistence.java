package persistence;

import java.util.List;

import model.Course;

public interface CoursePersistence {

	public boolean updateCourse(Course course);
	public List<Course> getCourses();
	public boolean persistNewCourse(Course course);
}
