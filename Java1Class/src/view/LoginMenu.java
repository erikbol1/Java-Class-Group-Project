package view;

import main.AuthenticationService;

public class LoginMenu implements Menu{

	private static final Menu loginMenu = new LoginMenu();

	private LoginMenu(){}

	public static Menu getInstance(){
		return loginMenu;
	}
	@Override
	public void displayMenu() {
		System.out.println(Decoration.DIVIDER);
		System.out.println("Login");
		System.out.println(Decoration.DIVIDER);
		System.out.println("M = Main Menu");
		System.out.println(Decoration.SEPARATOR);
		System.out.println("Enter your username to login.");
	}

	@Override
	public Menu parseInput(String input) {
		//Ensure input is present
		if (input == null || input.length() < 1){
			System.out.println("Invalid input.");
			return loginMenu;
		}

		//Process user input
		String userInput = input.toUpperCase().substring(0, 1);		
		if (userInput.equals("M")) //Return to main menu
			return MainMenu.getInstance();

		//If valid go to authenicated main menu
		if (AuthenticationService.INSTANCE.validate(input))
			return AuthenticatedMainMenu.getInstance(input);

		System.out.println("Invalid input.");
		return loginMenu;

	}

}
