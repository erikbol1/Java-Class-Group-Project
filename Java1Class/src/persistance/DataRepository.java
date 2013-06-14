package persistance;

import java.util.List;


import model.Course;
import model.Student;


public enum DataRepository implements CourseRepository, StudentRepository, RegisterCourse{

	INSTANCE;//Single item enum to enforce Singleton.  Effective Java item 3.
	private final RegisterCourse registrar;
	private final CourseRepository courseRepository; //Reference by interface
	private final StudentRepository studentRepository; //As above
	
	DataRepository(){//Swap out new implementations here.
		courseRepository = new AbstractCourseRepository(new FileCoursePersistance("courses.txt"));
		studentRepository = new AbstractStudentRepository(new StaticStudentPersistance());//Used for convenience. This implementation does not complete requirements.
		registrar = new Registrar(courseRepository, studentRepository);
	}
	@Override
	public boolean enrollStudentInCourse(String username, Course course){
		return registrar.enrollStudentInCourse(username, course);
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
