package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.Person;
import model.builders.RandomPersonBuilder;

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
		//Instantiate my builder and arraylist.
		RandomPersonBuilder rpb = new RandomPersonBuilder();
		ArrayList<Person> people = new ArrayList<Person>();
		Random picker = new Random();//Random number generator
		
		int target = picker.nextInt(50) + 1;//Number of random people desired.
		
		do{//Populate the list
			people.add(rpb.build());
		} while (people.size() != target);
		
		//Sort the array for easy viewing.
		Collections.sort(people);
		
		//Display the data.
		for (Person p: people)
			System.out.println(p.talk());

		System.out.println("The oldest person is " + getOldestPerson(people) + ".");
		System.out.println("Collection has " + people.size() + " members.");
		
	}

	/**
	 * Implementation of method required by homework.
	 * @param people 
	 * @return Full name of oldest person.  If ages are equal returns 
	 * the individual with the name closest to 'a' alphabetically.
	 */
	private static String getOldestPerson(ArrayList<Person> people){
		Collections.sort(people);
		return people.get(0).getFullName();
	}
}
