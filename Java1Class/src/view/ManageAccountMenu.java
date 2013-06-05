package view;

import model.Course;
import persistance.CourseRepository;
import persistance.DataRepository;
import persistance.StudentRepository;

public class ManageAccountMenu implements Menu{

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
		if (studentRepository.getStudent(currentUser).getCourseList().isEmpty())
			System.out.println("You are not currently registered for any courses.");
		else {
			System.out.println("D = Drop Course");
			System.out.println("V = View Schedule");
		}
		
	}

	@Override
	public Menu parseInput(String input) {		
		//Ensure input is present
		if (input == null || input.length() < 1){
			System.out.println("Invalid input.");
			return manageAccountMenu;
		}

		//Process user input
		String userInput = input.toUpperCase().substring(0, 1);

		//Switch on input
		switch (userInput){
		case "D": 
			if (studentRepository.getStudent(currentUser).getCourseList().isEmpty())
				break;
			else
				return DropCourseMenu.getInstance(currentUser);
		case "V": 
			if (studentRepository.getStudent(currentUser).getCourseList().isEmpty())
				break;
			else {
				displaySchedule();
				return manageAccountMenu;
			}
		case "M": return AuthenticatedMainMenu.getInstance(currentUser);
		}

		//Input not found in switch statement so it is invalid
		System.out.println("Invalid input.");
		return manageAccountMenu;
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
