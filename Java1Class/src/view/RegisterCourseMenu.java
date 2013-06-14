package view;

import java.util.List;

import model.Course;

import persistence.CourseRepository;
import persistence.DataRepository;
import persistence.RegisterCourse;

public class RegisterCourseMenu implements Menu{
	//Singleton instance
	private static final Menu registerCourseMenu = new RegisterCourseMenu();
	//Method variables
	private static String currentUser;
	private CourseRepository courseRepository;
	private RegisterCourse administration;

	private RegisterCourseMenu(){//Initialize dependencies
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
		
		List<Course> courses = courseRepository.getAvailableCourses();
		//Search for course
		for (Course course: courses)
			if (input.equalsIgnoreCase(course.getCourseId())){
				System.out.println(Decoration.SEPARATOR);
				if (administration.enrollStudentInCourse(currentUser, course)){
					System.out.println("Registration Successful."); //Display confirmation
					return AuthenticatedMainMenu.getInstance(currentUser); //Return to main menu
				}
				else {
					System.out.println("Registration unsuccessful.  You may already be enrolled in this course.");
					return registerCourseMenu;
				}
			}

		if (input.equalsIgnoreCase("M"))
			return AuthenticatedMainMenu.getInstance(currentUser); //Return to main menu
			
		//Input not found so it is invalid
		System.out.println("Invalid input.");
		return registerCourseMenu;
	}

}
