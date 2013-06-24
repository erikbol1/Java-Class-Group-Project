package view;

import persistence.AuthenticationService;

public class LoginMenu extends Menu{

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

		super.displayMenu();
	}

	@Override
	public void parseInput(String input) {
		//Ensure input is present
		if (nullOrEmpty(input))
			return;
		
		//Make sure username is consistent
		input = input.toUpperCase();
		
		//Process user input
		if (input.equals("M")){ //Return to main menu
			setInputNeeded(false);
			setNextMenu(MainMenu.getInstance());
			return;
		}

		//If valid go to authenticated main menu
		if (AuthenticationService.INSTANCE.validate(input)){
			setInputNeeded(false);
			setNextMenu(AuthenticatedMainMenu.getInstance(input));
			return;
		}

		//Input not found in switch statement so it is invalid
		setPrompt(Prompt.INVALID_INPUT);
		setInputNeeded(true);

	}

}
