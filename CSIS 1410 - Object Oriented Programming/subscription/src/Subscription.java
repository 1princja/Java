//CS1410
//Junit

public class Subscription 
{
   private int price ; // subscription total price in euro-cent
   private int length ; // length of subscription in months

   // constructor
   public Subscription(int p, int n) 
	{
     price = p ;
     length = n ;
   }

  /**
   * Calculate the monthly subscription price in euro,
   * rounded up to the nearest cent.
   */
   public double pricePerMonth() 
	{
     double r = (double) price / (double) length;
     r = Math.ceil(r)/100;
     return r ;
   }

  /**
   * Call this to cancel/nulify this subscription.
   */
   public void cancel() 
	{ 
		length = 0 ; 
	}

}