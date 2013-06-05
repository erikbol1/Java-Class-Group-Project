package persistance;

import java.util.List;


import model.Course;
import model.Student;


public enum DataRepository implements CourseRepository, StudentRepository, Administration{

	INSTANCE;//Single item enum to enforce Singleton.  Effective Java item 3.
	private final CourseRepository courseRepository; //Reference by interface
	private final StudentRepository studentRepository; //As above
	
	DataRepository(){//Swap out new implementations here.
		courseRepository = new StaticCourseRepository();
		studentRepository = new StaticStudentRepository();//Used for convenience. This implementation does not complete requirements.
	}
	@Override//We might want to move this to a different spot.
	public boolean enrollStudentInCourse(String username, Course course){
		//Protect against nulls
		if (username == null || course == null)
			return false;
		
		//Try to incrementEnrollment
		if (course.getCurrentEnrollment() < course.getEnrollmentLimit()){
			Student student = getStudent(username);
			//Try to add the course
			if (student.addCourse(course.getCourseId())){
				course.incrementEnrollment();
				if (saveStudent(student))
					return true;
				else {
					course.decrementEnrollment();
					return false;
				}
			}
			else//Can not add course
				return false;
		}
		else//Max enrollment reached
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
	public int nextStudentID() {
		return studentRepository.nextStudentID();
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
