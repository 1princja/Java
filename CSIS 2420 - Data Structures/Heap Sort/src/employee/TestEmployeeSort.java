package employee;

import java.util.*;

public class TestEmployeeSort 
{

	public static void main(String[] args) 
	{     
		List<Employee> coll = Util.getEmployees();
		
		// sort - natural order - Compare.compareTo()
		Collections.sort(coll); 
		Util.printList(coll, "\"Natural\" order");
		System.out.println();
		
		//use comparator - sort by age
		Collections.sort( coll, new EmpSortByAge() );
		Util.printList(coll,"Sort by \"age\"");
		System.out.println();
		
		//use comparator - sort by name
		Collections.sort( coll, new EmpSortByName() );
		Util.printList(coll,"Sort by \"name\"");
		System.out.println();

		//use comparator - sort by empId
		Collections.sort( coll, new EmpSortByEmpId() );
		Util.printList(coll,"Sort by \"Employee ID\"");
		System.out.println();

		//use comparator - sort by salary
		Collections.sort( coll, new EmpSortBySalary() );
		Util.printList(coll,"Sort by \"Employee Salary\"");
	}//end main()
		
}//end TestEmployees