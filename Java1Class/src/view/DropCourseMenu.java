package view;

import persistance.CourseRepository;
import persistance.DataRepository;
import persistance.StudentRepository;

import main.AuthenticationService;
import model.Course;
import model.Student;

public class DropCourseMenu implements Menu{

	private static final Menu dropCourseMenu = new DropCourseMenu();
	private static String currentUser;
	private CourseRepository courseRepository;
	private StudentRepository studentRepository;

	private DropCourseMenu(){
		courseRepository = DataRepository.INSTANCE;
		studentRepository = DataRepository.INSTANCE;
	}

	public static Menu getInstance(String username){
		currentUser = username;
		return dropCourseMenu;
	}
	@Override
	public void displayMenu() {
		//Build header
		System.out.println(Decoration.DIVIDER);
		System.out.println("Drop Course");
		System.out.println(Decoration.DIVIDER);
		System.out.println("M = Main Menu");
		System.out.println("Enter course ID.");	
	}

	@Override
	public Menu parseInput(String input) {
		//Ensure input is present
		if (input == null || input.length() < 1){
			System.out.println("Invalid input.");
			return dropCourseMenu;
		}
		
		//Process user input
		String selection;
		if (dropCourse(input.toUpperCase()))
			selection = "M";
		else
			selection = input.toUpperCase().substring(0, 1);

		//Return to main menu
		if (selection.equals("M") && AuthenticationService.INSTANCE.validate(currentUser))
			return AuthenticatedMainMenu.getInstance(currentUser);

		//Input not found so it is invalid
		System.out.println("Invalid input.");
		return dropCourseMenu;
	}
	/**
	 * 
	 * @param input - from user
	 * @return "M" if 
	 */
	private boolean dropCourse(String input){
		
		//Get the student
		Student student = studentRepository.getStudent(currentUser);
		if (student.getCourseList().contains(input)){
			//If they are enrolled in course drop them and update course enrollment.
			student.removeCourse(input);
			Course course = courseRepository.getCourse(input);
			course.decrementEnrollment();
			courseRepository.updateCourse(course);
			System.out.println("Course dropped successfully.");
			return true;
		}
		//Otherwise return false
		return false;
	}
}
