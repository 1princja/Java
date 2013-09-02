/********************************************************
 *  Project :  Assignment 12- Unit Testing
 *  File    :  ParkingCharges.java
 *  Name    :  Anthony Browness
 *  Date    :  15 April 2013
 *
 *  Description 	: A menu based program that Calculates the charges for parking, stores total charges and displays them to a user upon request.  
 *
 *	Data Structures	: n/a
 *
 *  Implementation	: The program prompts the user from a menu to either input the amount of hours parked or display the total amount of hours charged and total
 *  				  amount of money collected.  The calculateCharges() method will round the hours charged up to the first whole number using math.ceil() 
 *  				  and calculate charges based on this calculation. If statements handle the dollar amount logic based on the time parked and will set the
 *  				  charge back to $10.00 if the charge exceeds $10.00.
 * 
 *  Methods			: 	menu() - Prompts the user to either choose to enter the number of hours parked or show the total reciepts.
 *  						input.nextInt(): gathers input from the user in Int form.
 *
 *  					runCharges() - Prompts the user for the amount of hours parked. Passes the hours into calculateCharges().
 *  						input.nextDouble(): gathers the input from the user in Double form.						
 *
 *  					calculateCharges() - rounds up the hours entered to the nearest whole hour and calculates the charges using if logic.
 *  						Math.ceil() : rounds the hours up to the nearest whole hour.
 *
 *						displayCharges() - prints the total amount of hours parked and money gathered. 
 *
 *  Changes 		: N/A
 *
 ********************************************************/
import java.util.Scanner;
import java.lang.Math;

public class ParkingCharges {
	private double totalCharges = 0.00;
	private double totalHours = 0;
	private double currentCharge = 2.00;
	Scanner input = new Scanner(System.in);

	/****************************************************
	* Method     : menu
	*
	* Purpose    : 	Prompts the user for input to either enter the amount of hours to calculate
	* 				or show the daily reciepts 
	* 
	* Parameters : N/A
	*
	* Returns    : N/A					
	****************************************************/	
	public void menu()
	{
		System.out.printf(	"%s\n%s\n%s\n\n",
							"Please enter an option",
							"1. Enter hours parked ",
							"2. Show days reciepts");
		
		int choice = input.nextInt();
		switch(choice)
		{
			case 1: runCharges();
					break;
			case 2: displayReciepts();
					break;
			default: System.out.println("Invalid option");
					menu();
					break;
		}
	}

	/****************************************************
	* Method     : runCharges
	*
	* Purpose    :  Prompts the user for the amount of hours parked and
	* 				passes the hours in to calculateCharges().
	* 
	* Parameters : N/A
	*
	* Returns    : N/A					
	****************************************************/	
	public void runCharges()
	{
		System.out.printf("Enter hours parked");
		double hours = input.nextDouble();
		calculateCharges(hours);
		menu();
	}
	
	/****************************************************
	* Method     : calculateCharges
	*
	* Purpose    : rounds the hours input to the nearest whole hour, calculates the charges
	* 				depending on the amount of hours input.
	* 
	* Parameters : double hours: The hours parked input from either the runCharges() method
	* 			   or the test-suite. 
	*
	* Returns    : double currentCharge: The amount due for the hours input.
	* 				This is mainly here for the test-suite implementation.					
	****************************************************/	
	public double calculateCharges(double hours)
	{
		currentCharge = 2.00;
		
		int roundedHours = (int) Math.ceil( ((double)hours));
		
		double chargedHours = roundedHours - 3;
		
		if(hours > 3 && hours < 24)
		{
			currentCharge += .50 * chargedHours; 
		}
		if(hours >= 24)
		{
			currentCharge = 10.00;
		}
		if(currentCharge >= 10.00)
		{
			currentCharge = 10.00;
		}
		
		totalCharges += currentCharge;
		totalHours += hours;
		System.out.printf(	"%s%.02f%s%.02f\n\n",
							"Charges for ", 
							hours, 
							" hours is $", 
							currentCharge);
		return currentCharge;
	}
	
	/****************************************************
	* Method     : displayReciepts
	*
	* Purpose    : Display the total hours charged and total fees charged for the day.
	* 
	* Parameters : N/A
	*
	* Returns    : N/A					
	****************************************************/	
	public void displayReciepts()
	{
		System.out.printf(	"%s%.02f\n%s%.02f\n\n",
							"Total hours charged: ", 
							totalHours, 
							"Total fees charged: $", 
							totalCharges);
		menu();
	}
}
