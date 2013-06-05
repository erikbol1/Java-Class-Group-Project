package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import view.MainMenu;
import view.Menu;


/**
 * 
 * @author Erik Bollinger
 *
 */
public class RegistrationSystem {

	/**
	 * @param args Not used at this time.
	 */
	public static void main(String[] args)  {
		Menu menu = MainMenu.getInstance();
		while (true){
			menu.displayMenu();
			try {
				menu = menu.parseInput(new BufferedReader(new InputStreamReader(System.in)).readLine());
			} catch (IOException e) {
				//e.printStackTrace(); //Uncomment if needed for debugging purposes
				System.out.println("Invalid Input.");
			}
		}
		
	}

}
