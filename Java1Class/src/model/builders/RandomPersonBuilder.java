package model.builders;

import java.util.Random;

import language.ILanguage;
import language.English;
import language.Spanish;
import language.format.HyphenSSNFormatter;

import model.Gender;
import model.Person;
/**
 * 
 * Used as convenience class for homework assignment. 
 * @author Erik B
 *
 */
public class RandomPersonBuilder{

	//Class variables
	private Random picker;
	private final static ILanguage[] language = {new English(new HyphenSSNFormatter()), 
		new Spanish(new HyphenSSNFormatter())};
	private final static String[] firstNames = {"Justice", "Jessie", "Casey", "Quinn", "Phoenix", "Pat", "Sam"};
	private final static String[] lastNames = {"Smith", "Jones", "Johnson", "Williams", "Brown", "Anderson",
		"Wilson", "Davis", "Miller", "Moore", "Taylor"};
	
	public RandomPersonBuilder(){
		//Seed random generator
		picker = new Random(System.currentTimeMillis());
	}
	
	/**
	 * Builds a random person object based on internal data.
	 */
	public Person build(){
		Person temp = new Person(getLanguage());
		temp.setFirstName(getName(firstNames));
		temp.setLastName(getName(lastNames));
		temp.setAge(getAge());
		temp.setGender(getGender());
		temp.setSSN(getSSN());
		return temp;
	}
	/**
	 * @return A Random Language
	 */
	private ILanguage getLanguage(){
		return language[picker.nextInt(language.length)];
	}
	/**
	 * 
	 * @param names array of names to choose from.
	 * @return random name
	 */
	private String getName(String[] names){
		return names[picker.nextInt(names.length)];
	}
	/**
	 * @return Random age between 1 and 100.
	 */
	private int getAge(){
		return picker.nextInt(100) + 1;
	}
	/**
	 * @return Random gender
	 */
	private Gender getGender(){
		if (picker.nextBoolean())
			return Gender.MALE;
		else
			return Gender.FEMALE;
	}
	/**
	 * @return Random int
	 */
	private int getSSN(){
		return picker.nextInt(1000000000);
	}
}
