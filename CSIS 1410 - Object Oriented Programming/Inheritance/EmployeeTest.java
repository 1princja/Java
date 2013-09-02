public class EmployeeTest
{
	public static void main(String[] args)
	{
		//Employee e1 = new Employee(); does not work because using abstract to try and instanciate an object.
		Manager mgr1 = new Manager("Jack", "Smith", 5000.00, 1234, "The Boss", 300.0);
		System.out.println(mgr1);//calls toString()
		
		Sales sales1 = new Sales("Jenny", "Jones",  2345, 25000.0, 0.10);
		
		//This shows that the pay values on sales is initialized to 0.0 then after the calcPay() method is
		//called it changes the value correctly.
		System.out.println(sales1);
		sales1.calcPay();
		System.out.println(sales1);
		
		Employee[] workers = new Employee[5];
		workers[0] = mgr1;
		workers[1] = sales1;
		workers[2] = new Manager("Suzi", "Queue", 6000.0, 3456, "The Real Boss", 300);
		workers[3] = new Sales("Tom", "White", 4567, 20000.0, 0.12);
		workers[4] = new Sales("Anne", "Greene", 5678, 35000.0, 0.15);
		//he had this one commented out, I'm guessing next week we'll implement a Labor Class...
		//workers[4] = new Laborer("Jerry", "Black", 3000, 3333);
		
		//enhanced for loop that calculates the pay for every worker in the array
		for( Employee emp : workers)
		{
			System.out.printf("%s makes $%.2f\n", emp, emp.calcPay());
		}	
	}
}