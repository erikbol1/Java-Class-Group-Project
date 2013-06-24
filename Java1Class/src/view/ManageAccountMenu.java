package view;

import model.Course;
import persistence.CourseRepository;
import persistence.DataRepository;
import persistence.StudentRepository;

public class ManageAccountMenu extends Menu{

	private static final Menu manageAccountMenu = new ManageAccountMenu();
	private static String currentUser;
	private StudentRepository studentRepository;
	private CourseRepository courseRepository;

	private ManageAccountMenu(){
		studentRepository = DataRepository.INSTANCE;
		courseRepository = DataRepository.INSTANCE;
	}
	public static Menu getInstance(String username){
		currentUser = username;
		return manageAccountMenu;
	}
	@Override
	public void displayMenu() {
		System.out.println(Decoration.DIVIDER);
		System.out.println("Manage Account");
		System.out.println(Decoration.DIVIDER);
		System.out.println("M = Main Menu");
		if (studentRepository.getStudent(currentUser).getCourseList().isEmpty()){
			System.out.println("You are not currently registered for any courses.");
			setInputNeeded(false);
			setNextMenu(AuthenticatedMainMenu.getInstance(currentUser));
		}
		else {
			System.out.println("D = Drop Course");
			System.out.println("V = View Schedule");
			
			super.displayMenu();
		}
		
	}

	@Override
	public void parseInput(String input) {		
		//Ensure input is present
		if (nullOrEmpty(input))
			return;

		//Process user input
		String userInput = input.toUpperCase().substring(0, 1);

		//Switch on input
		switch (userInput){
		case "D": 
			setInputNeeded(false);
			setNextMenu(DropCourseMenu.getInstance(currentUser));
			return;
		case "V": 
			displaySchedule();
			setInputNeeded(false);
			setNextMenu(ManageAccountMenu.getInstance(currentUser));
			return;
		case "M": 
			setInputNeeded(false);
			setNextMenu(AuthenticatedMainMenu.getInstance(currentUser));
			return;
		}

		//Input not found in switch statement so it is invalid
		setPrompt(Prompt.INVALID_INPUT);
		setInputNeeded(true);
	}

	private void displaySchedule(){

		System.out.println(Decoration.SEPARATOR);
		
		//Output all courses student is currently registered in.
		for (String courseId: studentRepository.getStudent(currentUser).getCourseList()){
			Course course = courseRepository.getCourse(courseId);
			System.out.println("ID: " + course.getCourseId());
			System.out.println("Name: " + course.getName());
			System.out.println("Start Date: " + course.getStartDate());
			System.out.println("End Date: " + course.getEndDate());
			System.out.println(Decoration.SEPARATOR);
		}
	}

}
