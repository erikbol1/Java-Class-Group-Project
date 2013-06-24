package view;

import java.util.List;

import persistence.AuthenticationService;
import persistence.CourseRepository;
import persistence.DataRepository;
import persistence.RegisterCourse;

import model.Course;

public class AvailableCoursesMenu extends Menu{

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
			printSummary(course.getSummary());
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
		
		super.displayMenu();
	}

	@Override
	public void parseInput(String input) {
		//Ensure input is present
		if (nullOrEmpty(input))
			return;

		//If user is authenticated try to enroll in course
		if (AuthenticationService.INSTANCE.validate(currentUser)){
			List<Course> courses = courseRepository.getAvailableCourses();
			//Search for course
			for (Course course: courses)
				if (input.equalsIgnoreCase(course.getCourseId())){
					if (administration.enrollStudentInCourse(currentUser, course)){
						input = "M"; //Return user to appropriate main menu
						setPrompt(Prompt.REGISTRATION_SUCCESS); //Display confirmation
						setInputNeeded(false);
					}
					else{
						setPrompt(Prompt.REGISTRATION_FAIL);
						setInputNeeded(true);
						return;
					}
				}
		}
		
		if (input.equalsIgnoreCase("M"))
			//Return to appropriate main menu
			if (AuthenticationService.INSTANCE.validate(currentUser)) {
				setInputNeeded(false);
				setNextMenu(AuthenticatedMainMenu.getInstance(currentUser));
				return;
			}
			else{
				setInputNeeded(false);
				setNextMenu(MainMenu.getInstance());
				return;
			}
			
		//Input not found so it is invalid
		setPrompt(Prompt.INVALID_INPUT);
		setInputNeeded(true);
	}
	
	private void printSummary(String summary){
		String[] words = summary.split(" ");//Break it up into words
		int start = 0;//index of first word to pull
		int wordCount = words.length;//Number of words
		int wordsPerLine = 12;//Print this number of words per line
		boolean done = false;//Flag to break loop
		
		do{
			int limit;//Limit for the for loop
			if ((start + wordsPerLine) > wordCount)
				limit = wordCount;//last line < wordsPerLine
			else
				limit = start + wordsPerLine;
			
			StringBuilder sb = new StringBuilder();
			if (start == 0)
				sb.append("Description:");//First line
			else
				sb.append(Decoration.INDENT);//Subsequent lines
			
			for (int index = start; index < limit; index++)
				sb.append(" " + words[index]);//Build the line
			
			System.out.println(sb.toString());//Print the line
			
			if (limit == wordCount)
				done = true;//We're done
			else
				start += wordsPerLine;//increment starting point
		} while (!done);
	}

}
