import java.io.Serializable;


public class BusinessContact implements Serializable
{
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private String company;
	
	public BusinessContact(String first, String last, String phone, String email, String comp)
	{
		super();
		setFirstName(first);
		setLastName(last);
		setPhoneNumber(phone);
		setEmailAddress(email);
		setCompany(comp);
	}
	
	public void setFirstName(String first)
	{
		this.firstName = first;
	}
	
	public void setLastName(String last)
	{
		this.lastName = last;
	}
	
	public void setPhoneNumber(String phone)
	{
//		try
//		{
//			phone.matches("[1-9]\d{2}-[1-9]\d{2}-\d{4}");
//		}
		//regex validation here try catch exception
		this.phoneNumber = phone;
	}
	
	public void setEmailAddress(String email)
	{
		//regex validation here, try catch exception
		this.emailAddress = email;
	}
	
	public void setCompany(String comp)
	{
		this.company = comp;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public String getCompany()
	{
		return company;
	}
	
	//Override toString to only show first and last names for JList.
	@Override
	public String toString() 
	{
		return String.format("%s %s", firstName, lastName);	
	}
}
	