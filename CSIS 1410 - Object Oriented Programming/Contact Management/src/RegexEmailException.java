import javax.swing.JOptionPane;

/**
 * custom exception class to handle email regex exceptions from the RegexValidator class
 * @author Anthony Browness
 */
public class RegexEmailException extends Exception
{
	/**
	 * constructor
	 */
	public RegexEmailException()
	{
		super("Regex Exception Caught");
		JOptionPane.showMessageDialog(null, "Please ensure e-mail matches the format \"name@domain.com\"", "Invalid Input", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * overloaded constructor that allows for passing in a custom message.
	 * @param message
	 */
	public RegexEmailException(String message)
	{
		super(message);
		JOptionPane.showMessageDialog(null, message, "Invalid Input", JOptionPane.ERROR_MESSAGE);
	}
}
