/********************************************************
 * 
 * Project : Generics File : Pair.java Name : Crystal McDaniels and Anthony
 * Browness Date : 4/22/2013
 * 
 * Description :
 * 
 * 1) This is a Generic class that implements the Comparable interface.
 * 
 * 2) It creates a comparable object to be tested by the main method.
 * 
 * 3) toString, hashCode and equals are overridden.
 * 
 ********************************************************/

public class Pair<F extends Comparable<F>, S extends Comparable<S>> implements
		Comparable<Pair<F, S>>
{

	private F first;
	private S second;

	public Pair()
	{

	}

	public Pair(F first, S second)
	{
		super();
		this.first = first;
		this.second = second;
	}

	/****************************************************
	 * Method : getFirst
	 * 
	 * Purpose : To return the value of first.
	 * 
	 * Parameters : none
	 * 
	 * Returns : F
	 * 
	 ****************************************************/

	public F getFirst()
	{
		return first;
	}

	/****************************************************
	 * Method : setFirst
	 * 
	 * Purpose : This initializes the first variable.
	 * 
	 * Parameters : F - a variable of an F object
	 * 
	 * Returns : This method does not return a value.
	 * 
	 ****************************************************/
	public void setFirst(F first)
	{
		this.first = first;
	}

	/****************************************************
	 * Method : getSecond
	 * 
	 * Purpose : Returns the value of second.
	 * 
	 * Parameters : none
	 * 
	 * Returns : S
	 * 
	 ****************************************************/
	public S getSecond()
	{
		return second;
	}

	/****************************************************
	 * Method : setSecond
	 * 
	 * Purpose : To initialize the second variable.
	 * 
	 * Parameters : S - a variable of an S object.
	 * 
	 * Returns : This method does not return a value.
	 * 
	 ****************************************************/

	public void setSecond(S second)
	{
		this.second = second;
	}

	/****************************************************
	 * Method : compareTo
	 * 
	 * Purpose : Since Comparable is implemented this method must be defined.
	 * This compares the first variables of Pair<F, S> object.
	 * 
	 * Parameters : Pair<F, S> - an object of Pair
	 * 
	 * Returns : int
	 * 
	 ****************************************************/

	@Override
	public int compareTo(Pair<F, S> other)
	{
		int result = getFirst().compareTo(other.getFirst());
		return result;

	}

	/****************************************************
	 * Method : compareToInt
	 * 
	 * Purpose : This method compares the second variable of a Pair<F, S>
	 * object.
	 * 
	 * Parameters : Pair<F, S> - an object of Pair.
	 * 
	 * Returns : int
	 * 
	 ****************************************************/

	public int compareToInt(Pair<F, S> other2)
	{
		int result = getSecond().compareTo(other2.getSecond());
		return result;
	}

	/****************************************************
	 * Method : hashCode
	 * 
	 * Purpose : To override super class hashCode.
	 * 
	 * Parameters : none
	 * 
	 * Returns : int
	 * 
	 ****************************************************/
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	/****************************************************
	 * Method : equals
	 * 
	 * Purpose : To override superclass equals
	 * 
	 * Parameters : Object - takes and object argument.
	 * 
	 * Returns : boolean
	 * 
	 ****************************************************/
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pair))
			return false;
		Pair<F, S> other = (Pair<F, S>) obj;
		if (first == null)
		{
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null)
		{
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}

	/****************************************************
	 * Method : toString
	 * 
	 * Purpose : To override superclass toString
	 * 
	 * Parameters : none
	 * 
	 * Returns : String
	 * 
	 ****************************************************/
	@Override
	public String toString()
	{
		return String.format("[%s, %s]", first, second);
	}

}
