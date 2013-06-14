package view;

import java.util.List;

import persistance.RegisterCourse;
import persistance.CourseRepository;
import persistance.DataRepository;

import main.AuthenticationService;
import model.Course;

public class AvailableCoursesMenu implements Menu{

	private static final Menu availableCoursesMenu = new AvailableCoursesMenu();
	private static String currentUser;
	private static CourseRepository courseRepository;
	private static RegisterCourse administration;
	
	private AvailableCoursesMenu(){
		courseRepository = DataRepository.INSTANCE;
		administration = DataRepository.INSTANCE;
	}
	
	public static Menu getInstance(String username){
		currentUser = username;
		return availableCoursesMenu;
	}
	@Override
	public void displayMenu() {
		//Build header
		System.out.println(Decoration.DIVIDER);
		System.out.println("Available Courses");
		System.out.println(Decoration.DIVIDER);

		//Print available courses
		for(Course course: courseRepository.getAvailableCourses()){
			System.out.println("ID: " + course.getCourseId());
			System.out.println("Name: " + course.getName());
			System.out.println("Description: " + course.getSummary());
			System.out.println("Start Date: " + course.getStartDate());
			System.out.println("End Date: " + course.getEndDate());
			System.out.println("Seats Available: " + (course.getEnrollmentLimit() - course.getCurrentEnrollment()));
			System.out.println(Decoration.SEPARATOR);
		}
		//Instructions for authenticated users
		if (AuthenticationService.INSTANCE.validate(currentUser))
			System.out.println("Enter course ID to enroll.");
		//Instructions for all users
		System.out.println("M = Main Menu");
	}

	@Override
	public Menu parseInput(String input) {
		//Ensure input is present
		if (input == null || input.length() < 1){
			System.out.println("Invalid input.");
			return availableCoursesMenu;
		}

		//Process user input to see if they want to go to the main menu
		String selection = input.toUpperCase().substring(0, 1);

		//If user is authenticated try to enroll in course
		if (AuthenticationService.INSTANCE.validate(currentUser)){
			List<Course> courses = courseRepository.getAvailableCourses();
			//Search for course
			for (Course course: courses)
				if (input.equalsIgnoreCase(course.getCourseId())){
					if (administration.enrollStudentInCourse(currentUser, course)){
						selection = "M"; //Return user to appropriate main menu
						System.out.println("Registration Successful."); //Display confirmation
					}
					else
						System.out.println("Registration unsuccessful.  You may already be enrolled in this course.");
				}
		}
		
		if (selection.equals("M"))
			//Return to appropriate main menu
			if (AuthenticationService.INSTANCE.validate(currentUser)) 
				return AuthenticatedMainMenu.getInstance(currentUser);
			else
				return MainMenu.getInstance();
			
		//Input not found so it is invalid
		System.out.println("Invalid input.");
		return availableCoursesMenu;
	}

}
