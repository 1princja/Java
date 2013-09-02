/********************************************************
 *  Project :  Assignment 03- Distance Class
 *  File    :  Distance.java
 *  Name    :  Anthony Browness
 *  Date    :  06 Feb 2013
 *
 *  Description 	: Creates distance objects that contain feet and inches.	
 *
 *	Data Structures	: Objects
 *
 *  Implementation	: Objects are created and modified within the class, also capable
 *						of spawing new objects depening on the method.
 *
 *  Methods			: Mutators
 *					  Accessors
 *					  add		-add two Distance objects, returns a third object of the sum
 *					  sub		-subtracts two Distance objects, returns a third object of the difference
 *					  hashCode 	-creates a integer representation of the object
 *					  equals	-compares the hashCodes of the methods
 *					  toString	-returns a String representation of the object
 *
 *  Changes 		: None 
 *
 ********************************************************/
 public class Distance
 {
 
	private int feet;
	private int inches;
	
	public Distance()
	{
		
	}
	
	public Distance(int ft, int in)
	{
		setFeet(ft);
		setInches(in);
	}
	
	public void setFeet(int ft)
	{
		feet = ft;
	}
	
	public void setInches(int in)
	{
		inches = in;
	}
	
	public int getFeet()
	{
		return feet;
	}
	
	public int getInches()
	{
		return inches;
	}

	/****************************************************
	* Method     : add
	*
	* Purpose    : Return a String representation of the object.  
	* 
	* Paramaters : Distance object
	*
	* Returns    :  A Distance object with the value of the added Objects
	*					
	****************************************************/
	public Distance add(Distance d)
	{
		int totalIn = (this.feet*12) + this.inches + (d.feet*12) + d.inches;
		int ft = totalIn/12;
		int in = totalIn%12;
		return new Distance(ft, in);
	}

	/****************************************************
	* Method     : sub
	*
	* Purpose    : Subtract two distances.  
	*
	* Paramaters : Distance object
	*
	* Returns    : A Distance object with the value of the subtracted Objects.
	*					
	****************************************************/	
	public Distance sub(Distance d)
	{
		int totalIn = ((this.feet*12) + this.inches) - ((d.feet*12) + d.inches);
		int ft = totalIn/12;
		int in = totalIn%12;
		return new Distance(ft, in);
	}
	
	/****************************************************
	* Method     : toString @Override
	*
	* Purpose    : Return a String representation of the object.  
	*
	* Returns    :  String.format - A String representation of the
	*				object formatted for output with feet and inches.
	*					
	****************************************************/
	@Override
	public String toString()
	{
		return String.format("%s%s %s%s", feet, "'", inches,"\"");
	}

	/****************************************************
	* Method     : hashCode @Override
	*
	* Purpose    : Create an integer representation of the object  
	*
	* Returns    : Integer representation of an object
	*					
	****************************************************/
	@Override
	public int hashCode()
	{
		int prime = 31;
		int result = ((feet*12) + inches) * prime;
		return result;
	}

	/****************************************************
	* Method     : equals @Override
	*
	* Purpose    : Compare two objects  
	*
	* Paramaters : Distance object
	*
	* Returns    : A Boolean value depending on if the objects are 
	*				equal.
	*					
	****************************************************/	
	@Override
	public boolean equals(Object obj)
	{
		if(this.hashCode() == obj.hashCode())
		{
			return true;
		}
		return false;
	}
}	