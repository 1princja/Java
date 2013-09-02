package payable;

import java.util.Collection;
import java.util.Iterator;

public class IteratorPayable extends Employee implements Payable
{
	public IteratorPayable(String first, String last, String ssn) {
		super(first, last, ssn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Collection<Payable> employees = new BasicCollection<Payable>();
		SalariedEmployee e1 = new SalariedEmployee("Anthony", "Browness", "525-545-5448", 15.00);
		SalariedEmployee e2 = new SalariedEmployee("Jake", "Brinkerhoff", "525-545-5449", 20.00);
		SalariedEmployee e3 = new SalariedEmployee("Lance", "Buttars", "595-335-2458", 75.00);
		SalariedEmployee e4 = new SalariedEmployee("Preston", "Hughes", "123-456-7890", 35.00);
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		
		System.out.println("Here are the Salaried Employees in the collection: ");
		
		Iterator<Payable> iter;
		for(iter = employees.iterator(); iter.hasNext(); )
		{
			System.out.println(iter.next().toString());
			System.out.println();
		}
		
		iter = employees.iterator();
		while(iter.hasNext())
		{
			SalariedEmployee e = (SalariedEmployee)iter.next();
			if(e.getWeeklySalary() == 15.00)
			{
				iter.remove();
			}
		}
		
		System.out.println("Here are the Salaried Employees in the collection after removing people with $15.00 weekly salary: ");
		
		for(Payable employee: employees)
		{
			SalariedEmployee emp = (SalariedEmployee)employee;
			System.out.println(emp.toString());
			System.out.println();
		}
	}

	public double getPaymentAmount(Payable employee) {
		double payment = employee.getPaymentAmount();
		return payment;
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
