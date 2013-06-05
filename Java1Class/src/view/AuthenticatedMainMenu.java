package view;


public class AuthenticatedMainMenu implements Menu{
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
	}

	@Override
	public Menu parseInput(String input) {

		//Ensure input is present
		if (input == null || input.length() < 1){
			System.out.println("Invalid input.");
			return authenticatedMainMenu;
		}
		
		//Process user input
		String userInput = input.toUpperCase().substring(0, 1);

		//Switch on input
		switch (userInput){
		case "M": return ManageAccountMenu.getInstance(currentUser);
		case "V": return AvailableCoursesMenu.getInstance(currentUser);
		case "L": return MainMenu.getInstance();
		case "R": return RegisterCourseMenu.getInstance(currentUser);
		}
		
		//Input not found in switch statement so it is invalid
		System.out.println("Invalid input.");
		return authenticatedMainMenu;
	}

}
