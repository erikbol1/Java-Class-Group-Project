package language;

import model.Gender;

/**
 * 
 * @author Erik Bollinger
 *
 */
public interface ILanguage {
	/**
	 * 
	 * @param fullName
	 * @param age in years
	 * @param gender
	 * @param SSN
	 * @return Intro text incorporating the above info.
	 */
	public String introduction(String fullName, int age, Gender gender, int SSN);
}
