package persistence;

import java.util.List;

import model.Course;

public interface CourseRepository {
	
	public List<Course> getAvailableCourses();
	public Course getCourse(String courseId);
	public boolean saveNewCourse(Course course);
	public boolean updateCourse(Course course);
}
