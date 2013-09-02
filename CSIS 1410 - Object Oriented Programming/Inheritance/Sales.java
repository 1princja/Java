public class Sales extends Employee
{
	private double salesVolume;
	private double commissionRate;
	
	public Sales()
	{
		super();
		salesVolume = 0.0;
		commissionRate = 0.0;
	}
	
	public Sales(String firstName, String lastName, int idNumber, double volume, double commission)
	{
		super(firstName, lastName, 0.0, idNumber); //the third value "0.0" needs to be there to 
												//utilize the Employee abstract class properly
												//the Employee class has a pay field which is not
												//something the Sales class would actually use.
		this.salesVolume = volume;
		this.commissionRate = commission;
	}

	
	public void setSalesVolume(double sales)
	{
		salesVolume = sales;
	}
	
	public void setCommissionRate(double commission)
	{
		commissionRate = commission;
	}
	
	public double getSalesVolume()
	{
		return salesVolume;
	}
	
	public double getCommissionRate()
	{
		return commissionRate;
	}
	
	//The pay was initialized to 0.0, so we're calculating the pay based on sales
	//we then use the super.setPay() method to modify that value in the abstract
	//class
	@Override
	public double calcPay()
	{
		double pay = commissionRate * salesVolume;
		super.setPay(pay);
		return super.getPay();  //apparently super.getPay() is optional here, but it makes sense to me,
								//you can do it like the Manager class which is just "return getPay();"
								//which the instructor says is fine.
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %.2f %.2f", super.toString(), salesVolume, commissionRate);
	}
}