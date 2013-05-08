package language;

import language.format.ISSNFormatter;
import model.Gender;

/**
 * 
 * @author Erik Bollinger
 *
 */
public class English implements ILanguage{
	private ISSNFormatter ssnFormatter; //Formats the SSN
	
	public English(ISSNFormatter ssnFormatter){//Use constructor injection
		this.ssnFormatter = ssnFormatter;
	}
	
	/**
	 * Introduction in English.
	 */
	public String introduction(String fullName, int age, Gender gender, int ssn){
		String sex = (gender == Gender.MALE) ? "male" : "female";
		return "Hello, my name is " + fullName + ". I am a " + age +
				" year old " + sex + ". My SSN is " + ssnFormatter.format(ssn) + ".";
	}
}
