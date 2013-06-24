package view;

public class MainMenu extends Menu{
	private static final MainMenu mainMenu = new MainMenu();

	private MainMenu(){//Prevent subclassing		
	}

	public static Menu getInstance(){
		return mainMenu;
	}

	@Override
	public void displayMenu(){
		System.out.println(Decoration.DIVIDER);
		System.out.println("Main Menu");
		System.out.println(Decoration.DIVIDER);
		System.out.println("V = View Available Courses");
		System.out.println("L = Login");
		System.out.println("C = Create Account");
		System.out.println("X = Exit");
		
		super.displayMenu();
	}
	@Override
	public void parseInput(String input){
		//Ensure input is present
		if (nullOrEmpty(input))
			return;
		//Process user input
		String userInput = input.toUpperCase().substring(0, 1);

		//Switch on input
		switch (userInput){
		case "X": System.exit(0);
		case "V": setInputNeeded(false);
			setNextMenu(AvailableCoursesMenu.getInstance(null));
			return;
		case "L": setInputNeeded(false);
			setNextMenu(LoginMenu.getInstance());
			return;
		case "C": setInputNeeded(false);
			setNextMenu(CreateAccountMenu.getInstance());
			return;
		}

		//Input not found in switch statement so it is invalid
		setPrompt(Prompt.INVALID_INPUT);
		setInputNeeded(true);
	}
}
