public abstract class Employee
{
	private String firstName;
	private String lastName;
	private double pay;
	private int idNumber;
		
	public Employee()//Constructor
	{
		this("","", 0.0, -1);
	}
		
	public Employee(String firstName, String lastName, double pay, int idNumber)//Constructor
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.pay = pay;
		this.idNumber = idNumber;
	}
	
	public void setFirstName(String fName)
	{
		firstName = fName;
	}
	
	public void setLastName(String lName)
	{
		lastName = lName;
	}
	
	public void setPay(double dollabillzyo)
	{
		pay = dollabillzyo;
	}
	
	public void setIdNumber(int id)
	{
		idNumber = id;
	}

	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	public double getPay()
	{
		return pay;
	}
	public int getIdNumber()
	{
		return idNumber;
	}

	/*any class inheriting the abstract class HAS to use the calcPay() method or it needs to
	be abstract also and one of its children needs to use the calcPay() method or it will
	generate an error.
	*/
	public abstract double calcPay();
	
	@Override
	public String toString()
	{
		return String.format("%s %s %.2f %d", getFirstName(), getLastName(), getPay(), getIdNumber());
	}

	
}

