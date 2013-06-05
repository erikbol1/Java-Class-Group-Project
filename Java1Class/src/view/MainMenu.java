package view;

public class MainMenu implements Menu{
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
	}
	@Override
	public Menu parseInput(String input){
		//Ensure input is present
		if (input == null || input.length() < 1){
			System.out.println("Invalid input.");
			return mainMenu;
		}
		
		//Process user input
		String userInput = input.toUpperCase().substring(0, 1);

		//Switch on input
		switch (userInput){
		case "X": System.exit(0);
		case "V": return AvailableCoursesMenu.getInstance(null);
		}
		
		//Input not found in switch statement so it is invalid
		System.out.println("Invalid input.");
		return mainMenu;
	}
}
