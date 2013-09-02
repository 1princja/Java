import java.io.Serializable;

/**
 * concrete class using abstract class Contact 
 * @author Anthony Browness
 */
public class FamilyContact extends Contact implements Serializable{

	private String relationship;
	
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
	 * @param relationshipParam
	 */
	public FamilyContact(	String firstNameParam, 
							String lastNameParam, 
							String addressParam,
							String cityParam,
							String stateParam,
							String zipCodeParam,
							String phoneNumberParam, 
							String emailAddressParam,
							String relationshipParam)
	{
		super(	firstNameParam, 
				lastNameParam, 
				addressParam,
				cityParam,
				stateParam,
				zipCodeParam,
				phoneNumberParam, 
				emailAddressParam);
		setRelationship(relationshipParam);
	}
	
	/**
	 * Mutator
	 * @param companyParam
	 */
	public void setRelationship(String relationshipParam)
	{
		relationship = relationshipParam;
	}
	
	/**
	 * Accessor
	 * @return
	 */
	public String getRelationship()
	{
		return relationship;
	}
	
	/**
	 * returns a string representation of the object
	 */
	@Override
	public String toString()
	{
		String str = super.toString() + " " + getRelationship() + "\n";
		return str;
	} 
}
