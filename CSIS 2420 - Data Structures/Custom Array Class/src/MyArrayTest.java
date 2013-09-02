/********************************************************
*  Project :  Assignment 03 - Custom Array Class 
*  File    :  MyArrayTest.java
*  Name    :  Anthony Browness
*  Date    :  6/05/2013
*
*  Description : 
*
*    1) A Test class that exercises the methods in the MyArray Class
*     
*    2) MyArray<E>
*
*    3) N/A
*
*    4) main  
*
*  Changes : N/A
*  
*  
*
********************************************************/
public class MyArrayTest 
{

    /****************************************************
     * Method     : main
     *
     * Purpose    : Exercise the methods in MyArray Class and provide output
     * 				validation of two data types.
     *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public static void main(String[] args) 
	{ 
		//INTEGER ARRAY
		System.out.println("Instantiate an Integer array with default constructor(5 capacity)");
		MyArray<Integer> intArray = new MyArray<Integer>();
		System.out.println("Verify Capacity");
		int length = intArray.length();
		System.out.println("Length: " + length);

		System.out.println(" ");
		System.out.println("Instantiate an Integer array with paramterized constructor(10 capacity)");
		intArray = new MyArray<Integer>(10);
		System.out.println("Verify Capacity");
		length = intArray.length();
		System.out.println("Length: " + length);

		System.out.println(" ");
		System.out.println("Testing default insert(end of array)");
		System.out.println("Inserting 10 integers into the array");
		intArray.insert(0);
		intArray.insert(1);
		intArray.insert(2);
		intArray.insert(3);
		intArray.insert(4);
		intArray.insert(5);
		intArray.insert(6);
		intArray.insert(7);
		intArray.insert(8);
		intArray.insert(9);

		System.out.println(" ");
		intArray.printArray();
		System.out.println(" ");

		
		System.out.println("Verify Size is 10 and Length is 10");
		int size = intArray.getSize();
		length = intArray.length();
		System.out.println("Size: " + size + " Length: " + length);
	
		System.out.println(" ");
		System.out.println("Testing automatic resize");
		System.out.println("Inserting one more integer into the array");
		intArray.insert(10);
		System.out.println("Verify Size is 11 and Length is 15");
		size = intArray.getSize();
		length = intArray.length();
		System.out.println("Size: " + size + " Length: " + length);
		
		System.out.println(" ");
		System.out.println("Testing user resize");
		System.out.println("Setting capacity to 20");
		intArray.resize(20);
		System.out.println("Verify Size is 11 and Length is 20");
		size = intArray.getSize();
		length = intArray.length();
		System.out.println("Size: " + size + " Length: " + length);
		
		System.out.println("");
		System.out.println("Setting capacity back to 15");
		intArray.resize(15);
		System.out.println("Verify Size is 11 and Length is 15");
		size = intArray.getSize();
		length = intArray.length();
		System.out.println("Size: " + size + " Length: " + length);
		
		System.out.println(" ");
		System.out.println("Testing replace at specified index");
		System.out.println("Verify Value at index 5 is 5");
		int value = intArray.getValue(5);
		System.out.println("Value: " + value);
		System.out.println("Replacing value at index 5(int 5) with value int 20");
		intArray.replace(5, (Integer)20);
		System.out.println("Verify Value at index 5 is 20");
		value = intArray.getValue(5);
		System.out.println("Value: " + value);
		
		System.out.println(" ");
		System.out.println("Testing replace by finding a value");
		System.out.println("Verify Value at index 5 is 20");
		value = intArray.getValue(5);
		System.out.println("Value: " + value);
		System.out.println("Replacing int 20 in the array with int 5");
		intArray.replace((Integer)20, (Integer)5);
		System.out.println("Verify Value at index 5 is 5");
		value = intArray.getValue(5);
		System.out.println("Value: " + value);

		System.out.println(" ");
		System.out.println("Testing insert by index");
		System.out.println("Inserting int 19 at index 4");
		intArray.insert(4, (Integer)19);
		System.out.println("Verify Value at index 4 is 19");
		value = intArray.getValue(4);
		System.out.println("Value: " + value);

		System.out.println(" ");
		System.out.println("Testing delete by index");
		System.out.println("Deleting index 4");
		intArray.delete(4);
		System.out.println("Verify Value at index 4 is 4");
		value = intArray.getValue(4);
		System.out.println("Value: " + value);
		
		System.out.println(" ");
		System.out.println("Testing delete by value");
		System.out.println("Deleting int 0 in the array");
		intArray.delete((Integer)0);
		System.out.println("Verify Value at index 0 is 1");
		value = intArray.getValue(0);
		System.out.println("Value: " + value);

		System.out.println(" ");
		intArray.printArray();
		System.out.println(" ");

		//STRING ARRAY

		System.out.println(" ");
		System.out.println("Instantiate a String array with default constructor(5 capacity)");
		MyArray<String> strArray = new MyArray<String>();
		System.out.println("Verify Capacity");
		length = strArray.length();
		System.out.println("Length: " + length);

		System.out.println(" ");
		System.out.println("Instantiate a String array with paramterized constructor(10 capacity)");
		strArray = new MyArray<String>(10);
		System.out.println("Verify Capacity");
		length = strArray.length();
		System.out.println("Length: " + length);

		System.out.println(" ");
		System.out.println("Testing default insert(end of array)");
		System.out.println("Inserting 10 strings into the array");
		strArray.insert("The");
		strArray.insert("quick");
		strArray.insert("brown");
		strArray.insert("fox");
		strArray.insert("jumps");
		strArray.insert("over");
		strArray.insert("the");
		strArray.insert("lazy");
		strArray.insert("dog");
		strArray.insert("woof");

		System.out.println(" ");
		strArray.printArray();
		System.out.println(" ");
		
		System.out.println("Verify Size is 10 and Length is 10");
		size = strArray.getSize();
		length = strArray.length();
		System.out.println("Size: " + size + " Length: " + length);
	
		System.out.println(" ");
		System.out.println("Testing automatic resize");
		System.out.println("Inserting one more string \"meow\" into the array");
		strArray.insert("meow");
		System.out.println("Verify Size is 11 and Length is 15");
		size = strArray.getSize();
		length = strArray.length();
		System.out.println("Size: " + size + " Length: " + length);
		
		System.out.println(" ");
		System.out.println("Testing user resize");
		System.out.println("Setting capacity to 20");
		strArray.resize(20);
		System.out.println("Verify Size is 11 and Length is 20");
		size = strArray.getSize();
		length = strArray.length();
		System.out.println("Size: " + size + " Length: " + length);

		System.out.println("");
		System.out.println("Setting capacity back to 15");
		strArray.resize(15);
		System.out.println("Verify Size is 11 and Length is 15");
		size = strArray.getSize();
		length = strArray.length();
		System.out.println("Size: " + size + " Length: " + length);

		System.out.println(" ");
		System.out.println("Testing replace at specified index");
		System.out.println("Verify Value at index 5 is \"over\"");
		String strVal = strArray.getValue(6);
		System.out.println("Value: " + strVal);
		System.out.println("Replacing value at index 5(\"over\") with value string \"HELLO\"");
		strArray.replace(5, (String)"HELLO");
		System.out.println("Verify Value at index 5 is \"HELLO\"");
		strVal = strArray.getValue(5);
		System.out.println("Value: " + strVal);
		
		System.out.println(" ");
		System.out.println("Testing replace by finding a value");
		System.out.println("Verify Value at index 5 is \"HELLO\"");
		strVal = strArray.getValue(5);
		System.out.println("Value: " + strVal);
		System.out.println("Replacing \"HELLO\" in the array with \"over\"");
		strArray.replace((String)"HELLO", (String)"over");
		System.out.println("Verify Value at index 5 is \"over\"");
		strVal = strArray.getValue(5);
		System.out.println("Value: " + strVal);

		System.out.println(" ");
		System.out.println("Testing insert by index");
		System.out.println("Inserting \"WORLD\" at index 4");
		strArray.insert(4, (String)"WORLD");
		System.out.println("Verify Value at index 4 is \"WORLD\"");
		strVal = strArray.getValue(4);
		System.out.println("Value: " + strVal);

		System.out.println(" ");
		System.out.println("Testing delete by index");
		System.out.println("Deleting index 4");
		strArray.delete(4);
		System.out.println("Verify Value at index 4 is \"jumps\"");
		strVal = strArray.getValue(4);
		System.out.println("Value: " + strVal);
		
		System.out.println(" ");
		System.out.println("Testing delete by value");
		System.out.println("Deleting \"The\" in the array");
		strArray.delete((String)"The");
		System.out.println("Verify Value at index 0 is \"quick\"");
		strVal = strArray.getValue(0);
		System.out.println("Value: " + strVal);

		System.out.println(" ");
		strArray.printArray();
		System.out.println(" ");
		
	} 
	
}
