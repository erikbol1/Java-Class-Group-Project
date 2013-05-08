package model;
import language.ILanguage;

/**
 * 
 * @author Erik Bollinger
 *
 */
public class Person implements Comparable<Person>{

	//Encapulsate the variables
	private String firstName;
	private String lastName;
	private int age;
	private Gender gender;//enum
	private int socialSecurityNumber;//No formatting or digit requirement implemented
	private ILanguage language;//Interface allowing us to change language at runtime
	
	public Person(ILanguage language){
		if (language == null){
			throw new NullPointerException("language");
		}
		this.language = language;
	}
	/**
	 * 
	 * @return The person's first and last name.
	 */
	public String getFullName(){
		return firstName + " " + lastName;
	}
	/**
	 * 
	 * @param firstName The person's first name.
	 */
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	/**
	 * 
	 * @param lastName The person's last name. Compound names allowed.
	 */
	public void setLastName(String lastName){
		this.lastName = lastName;
	}  
	/**
	 * 
	 * @return The person's age in years.
	 */
	public int getAge(){
		return age;
	}
	/**
	 * 
	 * @param age The person's age in years.
	 */
	public void setAge(int age){
		this.age = age;
	}
	/**
	 * 
	 * @return The person's gender.
	 */
	public Gender getGender(){
		return gender;
	}
	/**
	 * 
	 * @param gender The person's gender.
	 */
	public void setGender(Gender gender){
		this.gender = gender;
	}
	/**
	 * 
	 * @return The person's social security number.
	 */
	public int getSSN(){
		return socialSecurityNumber;
	}
	/**
	 * 
	 * @param socialSecurityNumber The person's social security number.
	 */
	public void setSSN(int ssn){
		if (ssn < 1000000000 && ssn >= 0)
			socialSecurityNumber = ssn;
		else
			throw new IndexOutOfBoundsException("SSN must be between 0 and 999999999");
	}
	/**
	 * 
	 * @param language The language the person speaks. English is default.
	 */
	public void setLanguage(ILanguage language){
		if (language == null){
			throw new NullPointerException("language");
		}
		this.language = language;
	}
	/**
	 * 
	 * @return A phrase in the person's language.
	 */
	public String talk(){
		return language.introduction(getFullName(), age, gender, socialSecurityNumber);
	}
	/**
	 * Comparable implementation based on age, then last name, 
	 * then first name, and finally ssn. Oldest bubbles up, and 
	 * name is sorted according to standard alphabetization rules.
	 */
	@Override
	public int compareTo(Person other) {
		if (other.age == age)
			if (!other.lastName.equals(lastName))
				return lastName.compareToIgnoreCase(other.lastName);
			else if (!other.firstName.equals(firstName))
				return firstName.compareToIgnoreCase(other.firstName);
			else if(other.socialSecurityNumber == socialSecurityNumber)
				return 0;
			else if (other.socialSecurityNumber > socialSecurityNumber)
				return 1;
			else
				return -1;

		if (other.age > age)
			return 1;
		else
			return -1;
	}
}
