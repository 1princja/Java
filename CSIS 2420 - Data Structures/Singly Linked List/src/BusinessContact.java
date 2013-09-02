/********************************************************
*  Project :  Assignment 04 - Singly Linked List
*  File    :  BusinessContactFrame.java
*  Name    :  Anthony Browness
*  Date    :  6/12/2013
*
*  Description : 
*
*    1) Creates a BusinessContact Object with various fields.
*     
*    2) N/A
*
*    3) N/A
*
*    4) BusinessContact, setFirstName, setLastName, setPhoneNumber, setEmailAddress, setCompany, 
*    	getFirstName, getLastName, getPhoneNumber, getEmailAddress, getCompany, toString
*
*  Changes : N/A
********************************************************/
public class BusinessContact
{
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private String company;
	
	 /****************************************************
     * Method     : BusinessContact- Parameterized Constructor
     *
     * Purpose    : Construct a <tt>BusinessContact</tt> object using the
     * 				required values.
     *
     * Parameters : @param String first - the contacts first name
     * 				@param String last - the contacts last name
     *				@param String phone - the contact phone number
     *				@param String email - the contacts email address
     *				@param String comp - the contacts company
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public BusinessContact(String first, String last, String phone, String email, String comp)
	{
		super();
		setFirstName(first);
		setLastName(last);
		setPhoneNumber(phone);
		setEmailAddress(email);
		setCompany(comp);
	}
	
	 /****************************************************
     * Method     : setFirstName
     *
     * Purpose    : Mutates the first name of this <tt>BusinessContact</tt>.
     * 
     * Parameters : @param String first - the contacts first name
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void setFirstName(String first)
	{
		this.firstName = first;
	}
	
	 /****************************************************
     * Method     : setLastName
     *
     * Purpose    : Mutates the last name of this <tt>BusinessContact</tt>.
     * 
     * Parameters : @param String last - the contacts last name
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void setLastName(String last)
	{
		this.lastName = last;
	}

	 /****************************************************
     * Method     : setPhoneNumber
     *
     * Purpose    : Mutates the phone number of this <tt>BusinessContact</tt>.
     * 
     * Parameters : @param String phone - the contacts phone number
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void setPhoneNumber(String phone)
	{
		this.phoneNumber = phone;
	}
	
	 /****************************************************
     * Method     : setEmailAddress
     *
     * Purpose    : Mutates the email address of this <tt>BusinessContact</tt>.
     * 
     * Parameters : @param String email - the contacts email address
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void setEmailAddress(String email)
	{
		//regex validation here, try catch exception
		this.emailAddress = email;
	}

	 /****************************************************
     * Method     : setCompany
     *
     * Purpose    : Mutates the company address of this <tt>BusinessContact</tt>.
     * 
     * Parameters : @param String company - the contacts company
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void setCompany(String comp)
	{
		this.company = comp;
	}
	
	 /****************************************************
     * Method     : getFirstName
     *
     * Purpose    : Accesses the first name of this <tt>BusinessContact</tt>.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return String firstName, the first name of this <tt>BusinessContact</tt>
     *
     ****************************************************/
	public String getFirstName()
	{
		return firstName;
	}
	
	 /****************************************************
     * Method     : getLastName
     *
     * Purpose    : Accesses the last name of this <tt>BusinessContact</tt>.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return String lastName, the last name of this <tt>BusinessContact</tt>
     *
     ****************************************************/
	public String getLastName()
	{
		return lastName;
	}
	
	 /****************************************************
     * Method     : getPhoneNumber
     *
     * Purpose    : Accesses the phone number of this <tt>BusinessContact</tt>.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return String phoneNumber, the phone number of this <tt>BusinessContact</tt>
     *
     ****************************************************/
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	 /****************************************************
     * Method     : getEmailAddress
     *
     * Purpose    : Accesses the email address of this <tt>BusinessContact</tt>.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return String emailAddress, the emailAddress of this <tt>BusinessContact</tt>
     *
     ****************************************************/
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	 /****************************************************
     * Method     : getCompany
     *
     * Purpose    : Accesses the company of this <tt>BusinessContact</tt>.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return String company, the company of this <tt>BusinessContact</tt>
     *
     ****************************************************/
	public String getCompany()
	{
		return company;
	}
	
	/****************************************************
     * Method     : toString
     *
     * Purpose    : Accesses the company of this <tt>BusinessContact</tt>.
     * 				@Override from the Object class
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return a string representation of this <tt>BusinessContact</tt>
     *
     ****************************************************/
	@Override
	public String toString() 
	{
		return String.format("%s %s", firstName, lastName);	
	}
}
	