package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import view.MainMenu;
import view.Menu;
import view.Prompt;


/**
 * @author Erik Bollinger
 */
public class RegistrationSystem {

	/**
	 * @param args Not used at this time.
	 */
	public static void main(String[] args)  {
		//Initialize menu variable
		Menu menu = MainMenu.getInstance();
		while (true){
			//Display current menu
			menu.displayMenu();
			while (menu.moreInputNeeded()){
				menu.displayPrompt();
				try {
					//Process user input.
					menu.parseInput(new BufferedReader(new InputStreamReader(System.in)).readLine());
				} catch (IOException e) {
					//e.printStackTrace(); //Uncomment if needed for debugging purposes
					System.out.println(Prompt.INVALID_INPUT);
				}
			}
			
			menu = menu.getNextMenu();
		}
		
	}

}
