package language.format;

/**
 * 
 * @author Erik B
 *
 */
public interface ISSNFormatter {
	/**
	 * 
	 * @param ssn a social security number
	 * @return a well formatted human readable ssn
	 */
	public String format(int ssn);
}
