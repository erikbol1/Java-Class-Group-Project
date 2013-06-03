package main;

import java.text.ParseException;

import tests.AddStudent;
import tests.CourseListing;

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
		AddStudent.main(null);
		try {
			CourseListing.main(null);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
