// Fig. 10.15: PayableInterfaceTest.java
// Tests interface Payable.

public class PayableInterfaceTest 
{
   public static void main( String args[] )
   {
      // create four-element Payable array
      Payable payableObjects[] = new Payable[ 6 ];
      
      // populate array with objects that implement Payable
      payableObjects[ 0 ] = new Invoice( "01234", "seat", 2, 375.00 );
      payableObjects[ 1 ] = new Invoice( "56789", "tire", 4, 79.95 );
      payableObjects[ 2 ] = 
         new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
      payableObjects[ 3 ] = 
         new HourlyEmployee( "Lisa", "Barnes", "888-88-8888", 16.65, 40.0 );
	  payableObjects[ 4 ] = 
		 new CommissionEmployee( "James", "Lent", "777-77-7777", 9000.00, .09);
      payableObjects[ 5 ] =
		 new BasePlusCommissionEmployee( "Todd", "Davis", "666-66-6666", 6000.00, .08, 500.00);
	  System.out.println( 
         "Invoices and Employees processed polymorphically:\n" ); 

      // generically process each element in array payableObjects
      for ( Payable currentPayable : payableObjects )
      {
         // output currentPayable and its appropriate payment amount
         System.out.printf( "%s \n", 
            currentPayable.toString()); 
		 if( currentPayable instanceof BasePlusCommissionEmployee )
		 {
			BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee)currentPayable;
			employee.setBaseSalary(1.15 * employee.getBaseSalary());
			System.out.printf("%s %,.2f\n", "Base salary with 15% increase is: $",  employee.getBaseSalary() );
			System.out.printf("%s: $%,.2f\n\n", "payment due", employee.getPaymentAmount());
		 }else
		 {
			System.out.printf("%s: $%,.2f\n\n", "payment due", currentPayable.getPaymentAmount());
		 }
	  } // end for
	  for (int i = 0; i < payableObjects.length; i++)
	  {
		  System.out.printf("Payable Object %d is a %s\n", i, payableObjects[i].getClass().getName() );
	  }
   } // end main
} // end class PayableInterfaceTest


/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
