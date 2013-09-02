import java.io.Serializable;

/**
 * abstract class containing the information for the Contact
 * @author Anthony Browness
 */
public abstract class Contact implements Serializable 
{
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String emailAddress;

	/**
	 * Contact constructor
	 * @param firstName persons first name
	 * @param lastName persons last name
	 * @param address persons address
	 * @param city persons city
	 * @param state persons state
	 * @param zipCode persons zipcode
	 * @param phoneNumber persons phone number
	 * @param emailAddress persons email address
	 */
	public Contact(	String firstName, 
					String lastName, 
					String address,
					String city,
					String state,
					String zipCode,
					String phoneNumber, 
					String emailAddress)
	{
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
		setPhoneNumber(phoneNumber);
		setEmailAddress(emailAddress);
	}

	/**
	 * Mutator
	 * @param firstParam first name
	 */
	 public void setFirstName(String firstParam)
	 {
		//todo data validation, Capitalize
		firstName = firstParam;
	}
	
	/**
	 * Mutator
	 * @param lastParam last name
	 */
	public void setLastName(String lastParam)
	{
		//todo data validation, Capitalize
		lastName = lastParam;
	}
	
	/**
	 * Mutator
	 * @param addressParam
	 */
	public void setAddress(String addressParam)
	{
		address = addressParam;
	}
	
	/**
	 * Mutator
	 * @param cityParam
	 */
	public void setCity(String cityParam)
	{
		city = cityParam;
	}
	
	/**
	 * Mutator
	 * @param stateParam
	 */
	public void setState(String stateParam)
	{	
		//todo capitalize, regex 2 letters
		state = stateParam;
	}
	
	/**
	 * Mutator
	 * @param zipParam
	 */
	public void setZipCode(String zipParam)
	{
		zipCode = zipParam;
	}
	
	/**
	 * Mutator
	 * @param phoneParam
	 */
	public void setPhoneNumber(String phoneParam)
	{
		//todo regex data validation
		phoneNumber = phoneParam;
	}
	
	/**
	 * Mutator
	 * @param emailParam
	 */
	public void setEmailAddress(String emailParam)
	{
		//todo regex data validation
		emailAddress = emailParam;
	}
	
	/**
	 * Accessor
	 * @return first name
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * Accessor
	 * @return last name
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Accessor
	 * @return address
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * Accessor
	 * @return city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * Accessor
	 * @return state
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * Accessor
	 * @return zipcode
	 */
	public String getZipCode()
	{
		return zipCode;
	}

	/**
	 * Accessor
	 * @return phone number
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Accessor
	 * @return email address
	 */
	public String getEmailAddress()	
	{
		return emailAddress;
	}
	
	/**
	 * @return a string representation of the object  
	 */
	@Override
	public String toString()
	{
		String str = getFirstName() + " "
					+getLastName() + " "
					+getAddress() + " "
					+getCity() + " "
					+getState() + " "
					+getZipCode() + " "
					+getPhoneNumber() + " "
					+getEmailAddress() + " ";
		return str;
	}
}
