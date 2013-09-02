//CoinTest - enum example

public class CoinTest
{
	public static void main(String[] args)
	{
		Coin penny = Coin.PENNY;
		Coin nickel = Coin.NICKEL;
		
		System.out.println("penny = " + penny.value());
		System.out.println("penny's ordinality = " + penny.ordinal());
		System.out.println("quarter's ordinality = " + Coin.QUARTER.ordinal());
		System.out.println("nickel =  " + nickel);
		
		Coin piggyBank[] = Coin.values();
		
		System.out.println("\nMy piggy bank:");
		for( Coin c : piggyBank )
			System.out.printf("%s\n", c );
			
		if( penny == nickel )
			System.out.println("I love JGrasp");
		else
			System.out.println("I hate JGrasp");
	}
}//end CoinTest