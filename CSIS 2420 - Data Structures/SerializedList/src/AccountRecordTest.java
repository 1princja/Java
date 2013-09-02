/********************************************************
*  Project :  Assignment 06 - Serialized List
*  File    :  AccountRecordTest.java
*  Name    :  Anthony Browness
*  Date    :  6/26/2013
*
*  Description : 
*
*    1) Test class that demonstrates the use of a Doubly Linked List and serialization.
*     
*    2) LinkedList
*
*    3) N/A
*
*    4) Main, AccountRecordTest, writeClientsSer, readClientsSer
*
*  Changes : N/A
********************************************************/
import java.io.*;
import java.util.ListIterator;

public class AccountRecordTest 
{
	LinkedList<AccountRecordSerializable> list = new LinkedList();
	
	 /****************************************************
     * Method     : main
     *
     * Purpose    : Launch the program, Demonstrate the AcccountRecordTest class.
     *
     * Parameters : @param args
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public static void main(String[] args) {
		AccountRecordTest test = new AccountRecordTest();
	}
	
	 /****************************************************
     * Method     : AccountRecordTest
     *
     * Purpose    : Demonstrate the capabilities of the AccountRecordSerializable, and LinkedList classes.  
     * 				Writes the serializable records from disk and reads them from disk.
     *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public AccountRecordTest() {
		AccountRecordSerializable a1 = new AccountRecordSerializable(1, "Anthony", "Browness", 100.00);
		AccountRecordSerializable a2 = new AccountRecordSerializable(2, "Emily", "Browness", 200.00);
		AccountRecordSerializable a3 = new AccountRecordSerializable(3, "Lance", "Buttarson", 300.00);
		AccountRecordSerializable a4 = new AccountRecordSerializable(4, "Jake", "Brinkerhoff", 400.00);
		AccountRecordSerializable a5 = new AccountRecordSerializable(5, "Carly", "Jefferson", 500.00);
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		ListIterator<AccountRecordSerializable> iter = (ListIterator<AccountRecordSerializable>) list.iterator();
		System.out.println("Display Head to Tail");
		System.out.printf("Account\tFirst Name\tLast Name\tBalance\n");
		while(iter.hasNext())
		{
			AccountRecordSerializable record = iter.next();
			int account = record.getAccount();
			String first = record.getFirstName();
			String last = record.getLastName();
			double balance = record.getBalance();
			System.out.printf("%d\t%s\t\t%s\t%.02f\n", account, first, last, balance);
		}
		System.out.println("");
		System.out.println("Display Tail to Head");
		System.out.printf("Account\tFirst Name\tLast Name\tBalance\n");
		while(iter.hasPrevious())
		{
			AccountRecordSerializable record = iter.previous();
			int account = record.getAccount();
			String first = record.getFirstName();
			String last = record.getLastName();
			double balance = record.getBalance();
			System.out.printf("%d\t%s\t\t%s\t%.02f\n", account, first, last, balance);
		}
		System.out.println("Writing to disk");
		writeClientsSer();
		
		System.out.println("");
		System.out.println("Creating new list");
		LinkedList<AccountRecordSerializable> newList = null;
		newList = readClientsSer();
		
		System.out.println("Reading from disk");
		ListIterator<AccountRecordSerializable> newIter = (ListIterator<AccountRecordSerializable>) list.iterator();

		System.out.println("");
		System.out.println("Display Head to Tail");
		System.out.printf("Account\tFirst Name\tLast Name\tBalance\n");
		while(newIter.hasNext())
		{
			AccountRecordSerializable record = newIter.next();
			int account = record.getAccount();
			String first = record.getFirstName();
			String last = record.getLastName();
			double balance = record.getBalance();
			System.out.printf("%d\t%s\t\t%s\t%.02f\n", account, first, last, balance);
		}
	}

	
	 /****************************************************
     * Method     : writeClientsSer
     *
     * Purpose    : Writes to the file clients.ser
     *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void writeClientsSer()
	{
		ObjectOutputStream output = null;
		try
		{
			output = new ObjectOutputStream(new FileOutputStream("clients.ser"));
			output.writeObject(list);
			
		if(output != null)
			{
				output.close();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	 /****************************************************
     * Method     : readClientsSer
     *
     * Purpose    : Reads the file clients.ser and returns a LinkedList 
     *
     * Parameters : This method does not require parameters.
     *
     * Returns    : LinkedList a LinkedList of the clients read from disk.
     *
     ****************************************************/
	private LinkedList<AccountRecordSerializable> readClientsSer()
	{
		ObjectInputStream input = null;
		LinkedList<AccountRecordSerializable> newList = null;
		try
		{
			input = new ObjectInputStream(new FileInputStream("clients.ser"));
			newList = (LinkedList<AccountRecordSerializable>) input.readObject();
		}
		
		catch(ClassNotFoundException classNotFound)
		{	
			System.err.print("Object not created");
		}
		
		catch(IOException e)
		{
			System.err.println("Error During File Read");
			writeClientsSer();
		}
		return newList;
	}
}
