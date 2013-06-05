package view;

public class AuthenticatedMainMenu implements Menu{
	private static final Menu authenticatedMainMenu = new AuthenticatedMainMenu();
	private static String currentUser;
	
	private AuthenticatedMainMenu(){}//Prevent subclassing	
	
	public static Menu getInstance(String username){
		currentUser = username;
		return authenticatedMainMenu;
	}
	@Override
	public void displayMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Menu parseInput(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
