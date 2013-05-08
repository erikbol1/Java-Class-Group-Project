package language;

import language.format.ISSNFormatter;
import model.Gender;

public class Spanish implements ILanguage{
	private ISSNFormatter ssnFormatter;//Formats ssn
	
	public Spanish(ISSNFormatter ssnFormatter){//Use constructor injection
		this.ssnFormatter = ssnFormatter;
	}
	/**
	 * Introduction in Spanish.
	 */
	public String introduction(String fullName, int age, Gender gender, int ssn) {
		String sex = (gender == Gender.MALE) ? "un hombre" : "una mujer";
		return "Hola, me llamo " + fullName + ". Tengo " + age +
				" anos y soy " + sex + ". Mi SSN es " + ssnFormatter.format(ssn) + ".";
	}

}
