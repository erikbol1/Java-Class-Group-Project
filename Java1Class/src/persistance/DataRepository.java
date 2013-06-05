package persistance;

import java.util.List;

import model.Course;
import model.Student;


public enum DataRepository implements CourseRepository, StudentRepository{

	INSTANCE;//Single item enum to enforce Singleton.  Effective Java item 3.
	private final CourseRepository courseRepository; //Reference by interface
	private final StudentRepository studentRepository; //As above
	
	DataRepository(){//Swap out new implementations here.
		courseRepository = new StaticCourseRepository();
		studentRepository = new StaticStudentRepository();//Used for convenience. This implementation does not complete requirements.
	}
	//We might need to move this to a different spot.
	public boolean enrollStudentInCourse(String username, Course course){
		//Try to incrementEnrollment
		if (course.incrementEnrollment()){
			Student temp = getStudent(username);
			//Try to add the course
			if (temp.addCourse(course.getCourseId()))
				//Try to save the student
				return saveStudent(temp);
			else
				return false;
		}
		else
			return false;
	}
	@Override
	public Student getStudent(String username) {
		return studentRepository.getStudent(username);
	}

	@Override
	public boolean saveStudent(Student student) {
		return studentRepository.saveStudent(student);
	}

	@Override
	public List<Course> getAvailableCourses() {
		return courseRepository.getAvailableCourses();
	}

	@Override
	public Course getCourse(String courseId) {
		return courseRepository.getCourse(courseId);
	}

	@Override
	public boolean saveNewCourse(Course course) {
		return courseRepository.saveNewCourse(course);
	}

	@Override
	public boolean updateCourse(Course course) {
		return courseRepository.updateCourse(course);
	}
}
