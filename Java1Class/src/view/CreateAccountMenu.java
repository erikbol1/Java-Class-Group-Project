package view;

import model.ContactInfo;
import model.Name;
import model.Student;

import persistence.DataRepository;
import persistence.StudentRepository;

public class CreateAccountMenu extends Menu{

	//Class variables
	private static final Menu createAccountMenu = new CreateAccountMenu();
	private final StudentRepository studentRepository;
	private Prompt currentPrompt;
	private Prompt previousPrompt;
	
	//Variables for building new student
	private String firstName = null;
	private String lastName = null;
	private String username = null;
	private String email = null;
	private long phoneNumber = 0L;

	private CreateAccountMenu(){
		studentRepository = DataRepository.INSTANCE;
	}

	public static Menu getInstance(){
		return createAccountMenu;
	}
	@Override
	public void displayMenu() {
			//Print Header
			System.out.println(Decoration.DIVIDER);
			System.out.println("Create Account");
			System.out.println(Decoration.DIVIDER);
			System.out.println("M = Main Menu");
			System.out.println(Decoration.SEPARATOR);

			setInputNeeded(true);
			setPrompt(Prompt.ENTER_FIRST_NAME);
	}

	/**
	 * Returns null for an invalid input during create user loop.
	 */
	@Override
	public void parseInput(String input) {
		if (currentPrompt == Prompt.NEW_ACCOUNT){
			setInputNeeded(false);
			setNextMenu(AuthenticatedMainMenu.getInstance(username));
			return;
		}

		//Ensure input is present
		if (nullOrEmpty(input))
			return;

		//Check escape clause
		String menuCheck = input.toUpperCase();
		if (currentPrompt == Prompt.ABORT)
			if (menuCheck == "Y"){
				setInputNeeded(false);
				setNextMenu(MainMenu.getInstance());
				return;
			}
			else {
				setInputNeeded(true);
				setPrompt(previousPrompt);
				return;
			}

		switch (menuCheck){
		case "M": 
			setInputNeeded(true);
			setPrompt(Prompt.ABORT);
			return;
		}

		//Switch to populate student attributes
		switch (currentPrompt){
		case ENTER_FIRST_NAME: 
			firstName = input;
			setInputNeeded(true);
			setPrompt(Prompt.ENTER_LAST_NAME);
			return;

		case ENTER_LAST_NAME: 
			lastName = input;
			setInputNeeded(true);
			setPrompt(Prompt.ENTER_USERNAME);
			return;

		case DUPLICATE_USERNAME:
		case ENTER_USERNAME: //usernames must be unique
			if (usernameAvailable(input)){
				username = input;
				setPrompt(Prompt.ENTER_EMAIL);
			}
			else
				setPrompt(Prompt.DUPLICATE_USERNAME);

			setInputNeeded(true);
			return;

		case ENTER_EMAIL: 
			email = input;
			setInputNeeded(true);
			setPrompt(Prompt.ENTER_PHONE_NUMBER);
			return;

		case INVALID_PHONE_NUMBER:
		case ENTER_PHONE_NUMBER: 
			try {
			phoneNumber = Long.parseLong(input);
			createStudent();
			setPrompt(Prompt.NEW_ACCOUNT);
			}
			catch (NumberFormatException e) {
				setPrompt(Prompt.INVALID_PHONE_NUMBER);
			}
			setInputNeeded(true);
			return;
		default:
			break;
		}
		
		//This should never be reached
		setPrompt(Prompt.INVALID_INPUT);
		setInputNeeded(true);
	}
	
	private boolean usernameAvailable(String input){
		
		return studentRepository.getStudent(input) == null;
	}
	
	private void createStudent(){
		//Build newStudent
		Student newStudent = new Student(studentRepository.nextStudentID(), new Name(firstName, lastName), username.toUpperCase(), new ContactInfo(email, phoneNumber));
		//Save student
		System.out.println(studentRepository.saveStudent(newStudent));
	}
	
	@Override
	protected void setPrompt(Prompt prompt){
		super.setPrompt(prompt);
		if (prompt == Prompt.ABORT)
			previousPrompt = currentPrompt;
			
		currentPrompt = prompt;
	}
	@Override
	public void displayPrompt(){
		super.displayPrompt();
		
		if (currentPrompt == Prompt.ABORT){
			System.out.println("Y = Exit to Main Menu");
			System.out.println("N = Return to Create Account");
			System.out.println(Decoration.SEPARATOR);
		}
		
		if (currentPrompt == Prompt.NEW_ACCOUNT){
			System.out.println("Please use the username " + username + " to login in the future.");
			System.out.println("Press enter to continue.");
		}
	}
}
