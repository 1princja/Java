enum Suit
{
	DIAMONDS(1,"Diamonds"),
	CLUBS(2,"Clubs"),
	HEARTS(3,"Hearts"),
	SPADES(4,"Spades");

	private int value_;
	private String name_;
	
	/****************************************************
	* Method     : Suit
	*
	* Purpose    : Constructor, casts the proper enum value
	* 
	* Parameters : int v - value
	*
	* Returns    : N/A					
	****************************************************/
	Suit(int v) 
	{ 
		value_ = v; 
	}
	
	/****************************************************
	* Method     : Suit
	*
	* Purpose    : Overloaded Constructor, casts the proper enum value
	* 
	* Parameters : 	int v - value
	* 			  	String n - name
	*
	* Returns    : N/A					
	****************************************************/
	Suit(int v, String n) 
	{ 
		value_ = v; 
		name_ = n; 
	}
	
	/****************************************************
	* Method     : value
	*
	* Purpose    : returns the numerical value of the suit
	* 
	* Parameters : N/A
	*
	* Returns    : int value_					
	****************************************************/	
	public int value() 
	{ 
		return value_; 
	}
	
	/****************************************************
	* Method     : toString
	*
	* Purpose    : returns the toString representation of the suit
	* 
	* Parameters : N/A
	*
	* Returns    : String name_			
	****************************************************/
	public String toString()
	{
		return name_;
	}
	
}