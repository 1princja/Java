public class Manager extends Employee
{
	private String title;
	private double golfClubDues;

/*default constructor, calls the super constructor to initialize all the fields 
in the abstract class, it also adds the two fields that are part of the manager
class. 
*/	
	public Manager()
	{
		super();
		title = "";
		golfClubDues = 0.0;
	}

	public Manager(String firstName, String lastName, double pay, int idNumber, String title, double golfClubDues)
	{
		super(firstName, lastName, pay, idNumber);
		this.title = title;
		this.golfClubDues = golfClubDues;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setGolfClubDues(double dues)
	{
		golfClubDues = dues;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public double getGolfClubDues()
	{
		return golfClubDues;
	}
	
	@Override
	public double calcPay()
	{
		return getPay();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s %.2f", super.toString(), title, golfClubDues);
	}
}