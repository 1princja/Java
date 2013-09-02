enum Rank
{
	ACE(1, "Ace"),
	DEUCE(2, "Deuce"),
	THREE(3, "Three"),
	FOUR(4, "Four"),
	FIVE(5, "Five"),
	SIX(6, "Six"),
	SEVEN(7, "Seven"),
	EIGHT(8, "Eight"),
	NINE(9, "Nine"),
	TEN(10, "Ten"),
	JACK(11, "Jack"),
	QUEEN(12, "Queen"),
	KING(13, "King");
	
	private int value_;
	private String name_;
	
	/****************************************************
	* Method     : Rank
	*
	* Purpose    : Constructor, casts the proper enum value
	* 
	* Parameters : int v - value
	*
	* Returns    : N/A					
	****************************************************/	
	Rank(int v) 
	{ 
		value_ = v; 
	}
	
	/****************************************************
	* Method     : Rank
	*
	* Purpose    : Overloaded Constructor, casts the proper enum value
	* 
	* Parameters : 	int v - value
	* 			  	String n - name
	*
	* Returns    : N/A					
	****************************************************/	
	Rank(int v, String n) 
	{ 
		value_ = v; 
		name_ = n; 
	}
	
	/****************************************************
	* Method     : value
	*
	* Purpose    : returns the numerical value of the rank
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
	* Purpose    : returns the toString representation of the rank
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