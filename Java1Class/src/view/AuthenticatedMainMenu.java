package view;


public class AuthenticatedMainMenu extends Menu{
	private static final Menu authenticatedMainMenu = new AuthenticatedMainMenu();
	private static String currentUser;
	
	private AuthenticatedMainMenu(){}
	
	public static Menu getInstance(String username){
		currentUser = username;
		return authenticatedMainMenu;
	}
	@Override
	public void displayMenu() {
		System.out.println(Decoration.DIVIDER);
		System.out.println("Main Menu");
		System.out.println(Decoration.DIVIDER);
		System.out.println("V = View Available Courses");
		System.out.println("R = Register for Course");
		System.out.println("M = Manage Account");
		System.out.println("L = Logout");
		
		super.displayMenu();
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
		case "M": setInputNeeded(false);
			setNextMenu(ManageAccountMenu.getInstance(currentUser));
			return;
		case "V": setInputNeeded(false);
			setNextMenu(AvailableCoursesMenu.getInstance(currentUser));
			return;
		case "L": setInputNeeded(false);
			setNextMenu(MainMenu.getInstance());
			return;
		case "R": setInputNeeded(false);
			setNextMenu(RegisterCourseMenu.getInstance(currentUser));
			return;
		}
		
		//Input not found in switch statement so it is invalid
		setPrompt(Prompt.INVALID_INPUT);
		setInputNeeded(true);
	}

}
