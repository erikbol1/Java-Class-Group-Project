package persistance;

import model.Course;
import model.Student;

public class Registrar implements RegisterCourse{
	
	private CourseRepository courseRepository;
	private StudentRepository studentRepository;
	
	public Registrar(CourseRepository courseRepository, StudentRepository studentRepository){
		this.courseRepository = courseRepository;
		this.studentRepository = studentRepository;
	}

	@Override
	public boolean enrollStudentInCourse(String username, Course course) {
		//Protect against nulls
		if (username == null || course == null)
			return false;

		//Try to incrementEnrollment
		if (course.getCurrentEnrollment() < course.getEnrollmentLimit()){
			Student student = studentRepository.getStudent(username);
			//Try to add the course
			if (student.addCourse(course.getCourseId()))
				if (studentRepository.saveStudent(student)){
					course.incrementEnrollment();
					return courseRepository.updateCourse(course);
				}
		}
		
		return false;
	}

}
