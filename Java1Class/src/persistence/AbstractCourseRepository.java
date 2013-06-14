package persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Course;

public class AbstractCourseRepository implements CourseRepository{

	private List<Course> courses;
	private CoursePersistence coursePersistance;
	
	public AbstractCourseRepository(CoursePersistence coursePersistance){
		this.coursePersistance = coursePersistance;
		courses = coursePersistance.getCourses();
	}
	@Override
	public List<Course> getAvailableCourses() {
		List<Course> output = new ArrayList<Course>();

		//Find the courses with openings and add them to the output.
		for (Course course: courses)
			if (course.getCurrentEnrollment() < course.getEnrollmentLimit())
				output.add(course);
		
		//Return immutable list of courses.
		return Collections.unmodifiableList(output);
	}

	@Override
	public Course getCourse(String courseId) {

		//Search the collection for course
		for (Course course: courses)
			if (course.getCourseId().equals(courseId))
				return course;
		//If no course matches found return null
		return null;
	}

	@Override
	public boolean saveNewCourse(Course course) {
		
		if (course == null)
			return false;

		if (!courses.contains(course))
			if (coursePersistance.persistNewCourse(course)){
				courses = coursePersistance.getCourses();
				return true;
			}
		
		return false;
	}

	@Override
	public boolean updateCourse(Course updatedCourse) {
		//Protect against nulls
		if (updatedCourse == null)
			return false;
		
		return (courses.contains(updatedCourse)) ? coursePersistance.updateCourse(updatedCourse): false;
	}
	
}
