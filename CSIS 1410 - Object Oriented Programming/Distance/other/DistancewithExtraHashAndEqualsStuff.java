/********************************************************
 *  Project :  Assignment 03- Distance Class
 *  File    :  Distance.java
 *  Name    :  Anthony Browness
 *  Date    :  06 Feb 2013
 *
 *  Description 	: 	
 *
 *	Data Structures	: 	
 *
 *  Implementation	:	
 *
 *
 *  Methods			: 	
 *
 *  Changes 		: 	None 
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

	public Distance add(Distance d)
	{
		int totalIn = (this.feet*12) + this.inches + (d.feet*12) + d.inches;
		int ft = totalIn/12;
		int in = totalIn%12;
		return new Distance(ft, in);
	}
		
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
/*
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} 
		else if (!name.equals(other.name))
			return false;
		return true;
	}
*/	
}	