package view;

import java.util.List;

import main.AuthenticationService;
import model.Course;
import persistance.Administration;
import persistance.CourseRepository;
import persistance.DataRepository;

public class RegisterCourseMenu implements Menu{

	private static final Menu registerCourseMenu = new RegisterCourseMenu();
	private static String currentUser;
	private CourseRepository courseRepository;
	private Administration administration;

	private RegisterCourseMenu(){
		courseRepository = DataRepository.INSTANCE;
		administration = DataRepository.INSTANCE;
	}
	public static Menu getInstance(String username){
		currentUser = username;
		return registerCourseMenu;
	}
	@Override
	public void displayMenu() {
		//Build header
		System.out.println(Decoration.DIVIDER);
		System.out.println("Register for Course");
		System.out.println(Decoration.DIVIDER);
		System.out.println("M = Main Menu");
		System.out.println("Enter course ID.");		
	}

	@Override
	public Menu parseInput(String input) {
		//Ensure input is present
		if (input == null || input.length() < 1){
			System.out.println("Invalid input.");
			return registerCourseMenu;
		}
		//Process user input to see if they want to go to the main menu
		String selection = input.toUpperCase().substring(0, 1);

		List<Course> courses = courseRepository.getAvailableCourses();
		//Search for course
		for (Course course: courses)
			if (input.equalsIgnoreCase(course.getCourseId())){
				System.out.println(Decoration.SEPARATOR);
				if (administration.enrollStudentInCourse(currentUser, course)){
					selection = "M"; //Return user to appropriate main menu
					System.out.println("Registration Successful."); //Display confirmation
				}
				else
					System.out.println("Registration unsuccessful.  You may already be enrolled in this course.");
			}
		
		//Return to main menu
		if (selection.equals("M") && AuthenticationService.INSTANCE.validate(currentUser))
			return AuthenticatedMainMenu.getInstance(currentUser);

		//Input not found so it is invalid
		System.out.println("Invalid input.");
		return registerCourseMenu;
	}

}
