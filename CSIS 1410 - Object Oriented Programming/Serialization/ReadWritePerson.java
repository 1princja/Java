import java.util.Scanner;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Formatter;

public class ReadWritePerson 
{

	//ArrayList< Person > people = new ArrayList< Person >();
	Scanner input = new Scanner(System.in);
	private Formatter output;
	
	public ReadWritePerson()
	{
		ArrayList<Person> people = writePerson();
		writePersonSer(people);
/*		
		readPersonSer();
		for( Person per : people )
		{
			System.out.printf( "%s %s\n", per.getName(), per.getAge() );
		}
*/
	}
	
	public ArrayList<Person> writePerson()
	{
		ArrayList< Person > people = new ArrayList< Person >();
		
		Person personGuy = new Person( "Jack", 30 );
		Person personGuy2 = new Person( "Bill", 20 );
		Person personGuy3 = new Person( "Joe", 34 );
		Person personGuy4 = new Person( "Bob", 76 );
		Person personGuy5 = new Person( "Lady Luck", 21 );
		
		people.add( personGuy );
		people.add( personGuy2 );
		people.add( personGuy3 );
		people.add( personGuy4 );
		people.add( personGuy5 );
		
		return people;
	}
	
	public void writePersonSer(ArrayList<Person> peopleList)
	{
		ObjectOutputStream output = null;
		
		System.out.println("Writing...");
		
		try 
		{
			output = new ObjectOutputStream( new FileOutputStream( "peopleList.ser ") );
			
			output.writeObject(peopleList);
			
			if( output != null )
				output.close();
		
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void readPersonSer()
	{
		ObjectInputStream input = null;
		
		System.out.println("Reading...");
		
		try 
		{
			input = new ObjectInputStream( new FileInputStream( "peopleList.ser "));
			
			ArrayList< Person > people = null;
			
			while( true )
			{
				people = (ArrayList< Person >)input.readObject();
			}
		}
		
		catch( EOFException eof )
		{
			return;
		}
		
		catch( ClassNotFoundException classNotFound )
		{
			System.err.print("Object not created");
		}
		
		catch( IOException e )
		{ 
			e.printStackTrace();
		}
	}
	
	
//	public void writePerson()
//	{
//		Person personGuy = new Person( "Jack", 30 );
//		Person personGuy2 = new Person( "Bill", 20 );
//		Person personGuy3 = new Person( "Joe", 34 );
//		Person personGuy4 = new Person( "Bob", 76 );
//		Person personGuy5 = new Person( "Lady Luck", 21 );
//		
//		people.add( personGuy );
//		people.add( personGuy2 );
//		people.add( personGuy3 );
//		people.add( personGuy4 );
//		people.add( personGuy5 );
//		
//		
//		try 
//		{
//			output = new Formatter( "C:\\Users\\Paul\\Documents\\CS 1410\\Record.txt" );
//		} 
//		
//		catch (FileNotFoundException e) 
//		{
//			e.printStackTrace();
//		}
//		
//		for( Person per : people )
//		{
//			output.format( "%s %s\n", per.getName(), per.getAge() );
//		}
//		output.close();
//		
//		}
}
