package language.format;

/**
 * 
 * @author Erik B
 *
 */
public class HyphenSSNFormatter implements ISSNFormatter{
	/**
	 * Returns a well formatted ssn with hyphens.
	 */
	public String format(int ssn) {
		//Use a string builder to build the string
		StringBuilder sb = new StringBuilder();
		sb.append(ssn);//set the ssn
		
		while (sb.length() != 9){//expand to 9 digits if needed
			sb.insert(0, 0);//Insert leading zeros if needed
		}
		sb.insert(3, "-");//Insert first hyphen
		sb.insert(7, "-");//Insert second hyphen
		return sb.toString();
	}

}
