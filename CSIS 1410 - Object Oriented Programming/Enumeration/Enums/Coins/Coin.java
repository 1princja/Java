
enum Coin
{
	PENNY(1, "Lincoln"),
	NICKEL(5, "Jefferson"),
	DIME(10),
	QUARTER(25);
	
	private int value_;
	private String president_ = "?";
	
	Coin(int v) 
	{ 
		value_ = v; 
	}
	
	Coin(int v, String p) 
	{ 
		value_ = v; 
		president_ = p; 
	}
	
	public int value() 
	{ 
		return value_; 
	}
	
	public String toString()
	{
		return "This " + president_ + " is worth " + value_;
	}
	
}//end enum coin

