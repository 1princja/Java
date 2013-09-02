/********************************************************
 *  Project :  Assignment 03- Distance Class
 *  File    :  DistanceTest.java
 *  Name    :  Anthony Browness
 *  Date    :  06 Feb 2013
 *
 *  Description 	: Tests the functions of the Distance Class	
 *
 *	Data Structures	: Distance objects	
 *
 *  Implementation	: Create distance objects and use the Distance class to create new
 *						objects and compare those objects
 *
 *  Methods			: createDistance - 	enables easy creation of a distance object with some
 *										error correction.
 *					  addDistance - allows easy use of the add method from the Distance class
 *					  subDistance - allows easy use of the sub method from the Distance class
 *
 *  Changes 		: 	None 
 *
 ********************************************************/
 public class DistanceTest
 {
	public static void main(String[] args)
	{
		Distance d1 = createDistance(4, 14);
		Distance d2 = createDistance(2, 2);
		
		System.out.printf("%s%s\n", "Distance 1: ", d1.toString() );
		System.out.printf("%s%s\n", "Distance 2: ", d2.toString() );
		Distance d3 = addDistances(d1, d2);
		System.out.println("Distance 1 + Distance 2 = Distance 3");
		System.out.printf("%s%s\n", "Distance 3: ", d3.toString() );
		Distance d4 = subDistances(d3, d2);
		System.out.printf("%s\n", "Distance 3 - Distance 2 = Distance 4");
		System.out.printf("%s%s\n", "Distance 4: ", d4.toString() );
		boolean equalsTest = d4.equals(d1);
		if(equalsTest == true)
		{
			System.out.printf("%s\n", "Distance 4 equals Distance 1");
		}
		equalsTest = d4.equals(d2);
		if(equalsTest == false)
		{
			System.out.printf("%s\n", "Distance 4 does not equal Distance 2");
		}
	}

	public static Distance createDistance(int feet, int inches)
	{
		if(inches > 12)
		{
			int addedFeet = inches/12;
			int newInches = inches%12;
			feet += addedFeet;
			inches = newInches;
		}
		
		Distance d = new Distance(feet, inches);
		return d;
	}
	
	public static Distance addDistances(Distance d1, Distance d2)
	{
		Distance d = d1.add(d2);
		return d;
	}
	
	public static Distance subDistances(Distance d1, Distance d2)
	{
		Distance d = d1.sub(d2);
		return d;
	}
}	
	
	