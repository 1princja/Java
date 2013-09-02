import java.io.Serializable;

/**
 * concrete class using abstract class Contact 
 * @author Anthony Browness
 */
public class BusinessContact extends Contact implements Serializable{

	private String company;

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
	 * @param companyParam
	 */
	public BusinessContact(	String firstNameParam, 
							String lastNameParam, 
							String addressParam,
							String cityParam,
							String stateParam,
							String zipCodeParam,
							String phoneNumberParam, 
							String emailAddressParam,
							String companyParam)
	{
		super(	firstNameParam, 
				lastNameParam, 
				addressParam,
				cityParam,
				stateParam,
				zipCodeParam,
				phoneNumberParam, 
				emailAddressParam);
		setCompany(companyParam);
	}
	
	/**
	 * Mutator
	 * @param companyParam
	 */
	public void setCompany(String companyParam)
	{
		company = companyParam;
	}
	
	/**
	 * Accessor
	 * @return
	 */
	public String getCompany()
	{
		return company;
	}

	/**
	 * returns a string representation of the object
	 */
	@Override
	public String toString()
	{
		String str = super.toString() + " " + getCompany() + "\n";
		return str;
	}
}
