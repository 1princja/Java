import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates the input of email and phone fields
 * @author Anthony Browness
 *
 */
public class RegexValidator 
{

	public final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public final Pattern VALID_PHONE_REGEX =	
			Pattern.compile("^\\(\\d{3}\\)\\d{3}\\-\\d{4}$");

	/**
	 * validates the input of the email field
	 * @param emailStr
	 * @return a true or false boolean of the validation result
	 */
	public boolean validateEmail(String emailStr)
	{
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	/**
	 * validates the input of the phone field
	 * @param phoneStr
	 * @return a true or false boolean of the validation result
	 */
	public boolean validatePhone(String phoneStr)
	{
		Matcher matcher = VALID_PHONE_REGEX.matcher(phoneStr);
		return matcher.find();
	}
}
