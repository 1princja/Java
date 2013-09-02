/********************************************************
*  Project :  Assignment 08 - Recursion
*  File    :  RecursionTest.java
*  Name    :  Anthony Browness
*  Date    :  7/08/2013
*
*  Description : 
*  
*    1) Purpose: Test the printReverse method using Integers, Strings, and Persons. 
*         
*    2) Data-structures: Singly Linked List
*
*    3) Data-structure- Algorithms, Techniques, Implementations: N/A
*
*    4) Methods: testInteger, testString, testPerson, main
*
*  Changes : N/A
*
********************************************************/
public class RecursionTest 
{
	SinglyLinkedList list;
	Recursion recursion = new Recursion();

	/****************************************************
     * Method     : main
     *
     * Purpose    : Launch the program and run the tests.
     *
     * Parameters : @param args
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public static void main(String[] args) {
		RecursionTest test = new RecursionTest();
		test.testInteger();
		test.testString();
		test.testPerson();
	}

	/****************************************************
     * Method     : testString
     *
     * Purpose    : Test the printReverse method using Strings.
     *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void testString()
	{
		list = new SinglyLinkedList();
		System.out.println("String");
		System.out.println("______");
		list.add("seven");
		list.add("six");
		list.add("five");
		list.add("four");
		list.add("three");
		list.add("two");
		list.add("one");
		for(int i = 0; i < list.getLength(); i++)
		{
			System.out.println(list.getElementAt(i).toString());
		}
		System.out.println();
		recursion.printReverse(list);
		System.out.println();
	}

	/****************************************************
     * Method     : testInteger
     *
     * Purpose    : Test the printReverse method using Integers.
     *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void testInteger()
	{
		System.out.println("Integer");
		System.out.println("______");
		list = new SinglyLinkedList();
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		for(int i = 0; i < list.getLength(); i++)
		{
			System.out.println(list.getElementAt(i).toString());
		}
		System.out.println();
		recursion.printReverse(list);
		System.out.println();
	}
	
	/****************************************************
     * Method     : testPerson
     *
     * Purpose    : Test the printReverse method using Persons.
     *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void testPerson()
	{
		list = new SinglyLinkedList();
		System.out.println("People");
		System.out.println("______");
		Person p1 = new Person("Anthony", 28);
		Person p2 = new Person("Carly", 27 );
		Person p3 = new Person("Bronson", 21);
		Person p4 = new Person("Bri", 20);
		Person p5 = new Person("Greg", 30);
		Person p6 = new Person("Sophie", 25);
		Person p7 = new Person("Phoebe", 24);
		list.add(p7);
		list.add(p6);
		list.add(p5);
		list.add(p4);
		list.add(p3);
		list.add(p2);
		list.add(p1);
		for(int i = 0; i < list.getLength(); i++)
		{
			System.out.println(list.getElementAt(i).toString());
		}
		System.out.println();
		recursion.printReverse(list);
		System.out.println();
	}


}
