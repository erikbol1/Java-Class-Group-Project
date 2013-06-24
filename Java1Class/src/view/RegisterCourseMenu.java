package view;

import java.util.List;

import model.Course;

import persistence.CourseRepository;
import persistence.DataRepository;
import persistence.RegisterCourse;

public class RegisterCourseMenu extends Menu{
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
		
		super.displayMenu();	
	}

	@Override
	public void parseInput(String input) {
		//Ensure input is present
		if (nullOrEmpty(input))
			return;
		
		List<Course> courses = courseRepository.getAvailableCourses();
		//Search for course
		for (Course course: courses)
			if (input.equalsIgnoreCase(course.getCourseId())){
				System.out.println(Decoration.SEPARATOR);
				if (administration.enrollStudentInCourse(currentUser, course)){
					System.out.println(Prompt.REGISTRATION_SUCCESS); //Display confirmation
					setInputNeeded(false);
					setNextMenu(AuthenticatedMainMenu.getInstance(currentUser)); //Return to main menu
					return;
				}
				else {
					setInputNeeded(true);
					setPrompt(Prompt.REGISTRATION_FAIL);
					return;
				}
			}

		if (input.equalsIgnoreCase("M")){
			setInputNeeded(false);
			setNextMenu(AuthenticatedMainMenu.getInstance(currentUser)); //Return to main menu
			return;
		}
		
		//Input not found so it is invalid
		setPrompt(Prompt.INVALID_INPUT);
		setInputNeeded(true);
	}

}
