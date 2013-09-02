import java.io.Serializable;

/**
 * concrete class using abstract class Contact 
 * @author Anthony Browness
 */
public class FriendContact extends Contact implements Serializable{

	private String birthday;

	/**
	 * constructor
	 * @param firstNameParam
	 * @param lastNameParam
	 * @param addressParam
	 * @param cityParam
	 * @param stateParam
	 * @param zipCodeParam
	 * @param phoneNumberParam
	 * @param emailAddressParam
	 * @param birthdayParam
	 */
	public FriendContact(	String firstNameParam, 
							String lastNameParam, 
							String addressParam,
							String cityParam,
							String stateParam,
							String zipCodeParam,
							String phoneNumberParam, 
							String emailAddressParam,
							String birthdayParam)
	{
		super(	firstNameParam, 
				lastNameParam, 
				addressParam,
				cityParam,
				stateParam,
				zipCodeParam,
				phoneNumberParam, 
				emailAddressParam);
		setBirthday(birthdayParam);
	}
	
	/**
	 * Mutator
	 * @param companyParam
	 */
	public void setBirthday(String birthdayParam)
	{
		birthday = birthdayParam;
	}
	
	/**
	 * Accessor
	 * @return
	 */
	public String getBirthday()
	{
		return birthday;
	}
	
	/**
	 * returns a string representation of the object
	 */
	@Override
	public String toString()
	{
		String str = super.toString() + " " + getBirthday() + "\n";
		return str;
	} 
}
