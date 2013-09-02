/********************************************************
*  Project :  Assignment 03 - Custom Array Class 
*  File    :  MyArray.java
*  Name    :  Anthony Browness
*  Date    :  6/05/2013
*
*  Description : 
*
*    1) A custom array class which allows advanced manipulation of arrays using
*    	generic data types.
*     
*    2) array
*
*    3) N/A
*
*    4) default and paramaterized constructors, getValue, getSize, length, 
*    	printArray, checkCapacity, findElement, resize, overloaded resize,
*    	replace, overloaded replace, insert, overloaded insert, delete,
*    	overloaded delete. 
*
*  Changes : N/A
*  
*  Specification #3:
*  
*  I found when testing this class that I have actually grown to like JUnit a lot.
*  I can understand not needing a comprehensive test suite to test a relatively small class
*  that does not do a lot or very many complicated operations, in which case a test class 
*  like this would be fine, but I feel that JUnit would have been the correct tool for this
*  class, namely because there are lots of ways to break the methods and the correct output
*  to alert the user should be tested.  It's hard to do negative testing using this form of test
*  class without causing the testcase to stop working.  Validation is the same story, this test
*  class cannot negative test validation easily, and the output of the values must be designed
*  and reviewed closely in order to ensure reliability.
*
********************************************************/
import javax.swing.JOptionPane;

public class MyArray<E> {
	
	private E[] elements;
	private int size = 0;
	private int DEFAULT_CAP = 5;
	
    /****************************************************
     * Method     : MyArray- Default Constructor
     *
     * Purpose    : Construct a <tt>MyArray</tt> object using the
     * 				default capacity.
     *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public MyArray()
	{
		elements = (E[]) new Object[DEFAULT_CAP];
	}
	
	 /****************************************************
     * Method     : MyArray - Overloaded Constructor
     *
     * Purpose    : Construct a <tt>MyArray</tt> object using the
     * 				a user defined capacity.
     *
     * Parameters : @param capacity of this <tt>MyArray</tt>;
	 *				must be > 0
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public MyArray(int capacity)
	{
		if(capacity < 1)
		{
			JOptionPane.showMessageDialog(null, "Array must contain atleast one index", "Item not found", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			elements = (E[]) new Object[capacity];
		}	
	}
	
	 /****************************************************
     * Method     : getValue
     *
     * Purpose    : Get the value of at the specified index of
     * 				this <tt>MyArray</tt>.
     * 
     * Parameters : @param int index, the index of the value to be returned.
     *
     * Returns    : @return int index, the value in the index specified
     * 				 of this <tt>MyArray</tt>
     *
     ****************************************************/
	public E getValue(int index)
	{
		E value = elements[index];
		return value;
	}
	
	 /****************************************************
     * Method     : getSize
     *
     * Purpose    : Get the size of this <tt>MyArray</tt>.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return int size, the size of this <tt>MyArray</tt>
     *
     ****************************************************/
	public int getSize()
	{
		return size;
	}

	 /****************************************************
     * Method     : length
     *
     * Purpose    : Get the current capacity of this <tt>MyArray</tt>.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return int length, the capacity of this <tt>MyArray</tt>
     *
     ****************************************************/
	public int length()
	{
		return elements.length;
	}

	 /****************************************************
     * Method     : printArray
     *
     * Purpose    : Print out the current values of this <tt>MyArray</tt>.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void printArray()
	{
		for(int i = 0; i < elements.length; i++)
		{
			if(elements[i] != null)
			{
				System.out.println(elements[i]);
			}
		}
	}
	
	 /****************************************************
     * Method     : checkCapacity
     *
     * Purpose    : Determine if this <tt>MyArray</tt> is full.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return boolean isFull, the capacity state of this <tt>MyArray</tt>
     *
     ****************************************************/
	public boolean checkCapacity()
	{
		boolean isFull = false;
		if(size == elements.length)
		{
			isFull = true;
		}
		return isFull;
	}

	 /****************************************************
     * Method     : findElement
     *
     * Purpose    : Find the index of a specified value in this <tt>MyArray</tt>.
     * 				If duplicate values exist in the array only the first element found
     * 				will be returned
     * 
     * Parameters : @param E value, the value to be found.
     *
     * Returns    : @return int index, the index found in this <tt>MyArray</tt>
     *
     ****************************************************/
	public int findElement(E value)
	{
		boolean found = false;
		int index = -1;
			for(int i = 0; i < elements.length; i++)
			{
				if(elements[i].equals(value) || elements[i] == value)
				{
					found = true;
					index = i;
					i = elements.length; //if duplicate values exist, will only modify the first
				}
			}
			if(found == false)
			{
				JOptionPane.showMessageDialog(null, "Specified item is not in the Array", "Item not found", JOptionPane.ERROR_MESSAGE);
			}
		return index;
	}
	
	 /****************************************************
     * Method     : resize- Default
     *
     * Purpose    : When called, will increase the capacity of this <tt>MyArray</tt>
     * 				by 1 1/2 of its current capacity
	 *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void resize()
	{
		int newSize = (elements.length / 2) + elements.length;
		E[] tempElements = elements;
		
		if(checkCapacity() == true)
		{
			this.elements = (E[]) new Object[newSize];
			for(int i = 0; i < size; i++)
			{
				elements[i] = tempElements[i];
			}
		}
	}
	
	 /****************************************************
     * Method     : resize- Overloaded
     *
     * Purpose    : Increase the capacity of this <tt>MyArray</tt>
     * 				to the value specified
	 *
     * Parameters : @param int newSize, the requested capacity.
     * 				Must be > the current size of the array.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void resize(int newSize)
	{
		if(newSize < size)
		{
			JOptionPane.showMessageDialog(null, "Specified size will result in loss of data", "Invalid Size", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			E[] tempElements = elements;
			elements = (E[]) new Object[newSize];
			for(int i = 0; i < size; i++)
			{
				elements[i] = tempElements[i];
			}
		}
	}

	 /****************************************************
     * Method     : replace
     *
     * Purpose    : Replace the specified index of this <tt>MyArray</tt> with the provided value
	 *
     * Parameters : @param int index, the the index to be replaced
     * 				@param E newValue, the value to be inserted.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void replace(int index, E newValue)
	{
		elements[index] = newValue;
	}
	
	 /****************************************************
     * Method     : replace - Overloaded
     *
     * Purpose    : Replace the requested value of this <tt>MyArray</tt> with the provided value
	 *
     * Parameters : @param E oldValue, the value to be replaced
     * 				@param E newValue, the value to be inserted.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void replace(E oldValue, E newValue)
	{
		int replaceIndex = findElement(oldValue);
		if(replaceIndex != -1)
		{
			replace(replaceIndex,  newValue);
		}
	}
	
	 /****************************************************
     * Method     : insert
     *
     * Purpose    : Insert a value on the end of this <tt>MyArray</tt>
	 *
     * Parameters : @param E value, the value to be inserted.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void insert(E value)
	{
		if(checkCapacity() == true)
		{
			resize();
		}
		elements[size] = value;
		size++;
	}
	
	 /****************************************************
     * Method     : insert - Overloaded
     *
     * Purpose    : Insert a value at the specified index of this <tt>MyArray</tt>
	 *
     * Parameters : @param int index, the index to insert the value.
     * 				The index cannot be larger than the size of the array to avoid
     * 				an value being out of sequence.
     * 				@param E value, the value to be inserted.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void insert(int index, E value)
	{
		if(checkCapacity() == true)
		{
			resize();
		}
		if(index > size)
		{
			JOptionPane.showMessageDialog(null, "Specificed index is out of bounds", "Invalid Size", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			for(int i = size; i >= index; i--)
			{
				E oldElement = elements[i];
				elements[i+1] = oldElement; 
			}
			elements[index] = value;
			size++;
		}
	}
	
	 /****************************************************
     * Method     : delete
     *
     * Purpose    : Delete the value at the specified index of this <tt>MyArray</tt>
	 *
     * Parameters : @param int index, the index to delete.
     * 				The index must be > than the size of the array
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void delete(int index)
	{
		if(index > size)
		{
			JOptionPane.showMessageDialog(null, "Specificed index is out of bounds", "Invalid Size", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			for(int i = index; i <= size -1; i++)
			{
				elements[i] = elements[i+1];
			}
			size--;
		}
	}
	
	 /****************************************************
     * Method     : delete - Overloaded
     *
     * Purpose    : Delete the requested value in this <tt>MyArray</tt>
	 *
     * Parameters : @param E value, the value to delete.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void delete(E value)
	{
		int valueIndex = findElement(value);
		delete(valueIndex);
	}
}
