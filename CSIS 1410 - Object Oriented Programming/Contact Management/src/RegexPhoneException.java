import javax.swing.JOptionPane;

/**
 * custom exception class to handle phone regex exceptions from the RegexValidator class
 * @author Anthony Browness
 */
public class RegexPhoneException extends Exception {
	
	/**
	 * constructor
	 */
	public RegexPhoneException()
	{
		super("Regex Exception Caught");
		JOptionPane.showMessageDialog(null, "Please ensure phone matches the format \"(555)555-5555\"", "Invalid Input", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * overloaded constructor that allows for passing in a custom message.
	 * @param message
	 */
	public RegexPhoneException(String message)
	{
		super(message);
		JOptionPane.showMessageDialog(null, message, "Invalid Input", JOptionPane.ERROR_MESSAGE);
	}
}
