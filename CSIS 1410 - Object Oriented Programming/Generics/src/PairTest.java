/********************************************************
 * 
 * Project : Generics File : PairTest.java Name : Crystal McDaniels and Anthony
 * Browness Date : 4/22/2013
 * 
 * Description :
 * 
 * 1) This contains the main method and creates objects from the Pair class to
 * be tested for equality.
 * 
 * 2) There are two other methods here compare and compareInt. One compare the
 * Strings the other compare the integer values as explained below.
 * 
 ********************************************************/

public class PairTest
{

	/****************************************************
	 * Method : main
	 * 
	 * Purpose : To run start the PairTest app. This creates some Pair objects
	 * and calls to the below methods to compare them.
	 * 
	 * Parameters : array - of String arguments
	 * 
	 * Returns : This method does not return a value.
	 * 
	 ****************************************************/

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Pair p1 = new Pair("Test", 1);
		Pair p2 = new Pair("Hello", 2);
		Pair p3 = new Pair("Test", 3);
		Pair p4 = new Pair("Hello", 1);

		System.out.println(p1.compareTo(p2));
		System.out.println(p1.compareTo(p3));

		compare(p1, p2);
		compare(p1, p3);
		compare(p3, p2);
		compare(p4, p1);

		compareInt(p1, p2);
		compareInt(p1, p3);
		compareInt(p3, p2);
		compareInt(p4, p1);

	}

	/****************************************************
	 * Method : compare
	 * 
	 * Purpose : To compare the String values in our Pair objects.
	 * 
	 * Parameters : Pair - two pair objects
	 * 
	 * Returns : This method does not return a value.
	 * 
	 ****************************************************/

	public static void compare(Pair obj1, Pair obj2)
	{

		if (obj1.compareTo(obj2) == 0)
			System.out.printf("%s == %s\n", obj1.toString(), obj2.toString());

		else
			System.out.printf("%s != %s\n", obj1.toString(), obj2.toString());
	}

	/****************************************************
	 * Method : compareInt
	 * 
	 * Purpose : To compare the integer values of our Pair objects.
	 * 
	 * Parameters : Pair - two pair objects
	 * 
	 * Returns : This method does not return a value.
	 * 
	 ****************************************************/

	public static void compareInt(Pair obj1, Pair obj2)
	{

		if (obj1.compareToInt(obj2) == 0)
			System.out.printf("%s == %s\n", obj1.toString(), obj2.toString());

		else
			System.out.printf("%s != %s\n", obj1.toString(), obj2.toString());
	}

}
