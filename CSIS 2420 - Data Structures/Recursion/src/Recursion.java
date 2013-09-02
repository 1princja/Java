/********************************************************
*  Project :  Assignment 08 - Recursion
*  File    :  Recursion.java
*  Name    :  Anthony Browness
*  Date    :  7/08/2013
*
*  Description : 
*  
*    1) Purpose: Recursivly prints the elements in a Singly Linked List in reverse. 
*         
*    2) Data-structures: Singly Linked List
*
*    3) Data-structure- Algorithms, Techniques, Implementations: Recursion
*
*    4) Methods: printReverse
*
*  Changes : N/A
*
********************************************************/
public class Recursion 
{
	
	/****************************************************
	 * Method     : printReverse
     *
     * Purpose    : Prints a Singly Linked List in reverse using recursion
	 *
     * Parameters : @param list , the singly linked list to be printed in reverse
     *
     * Returns    : This method does not return a value.
     * 
     * Recursion: The process of breaking down a problem into simpler versions of itself
     *				until the most simple version(base case) is reached.
     *				
     * Recursive Process: remove an element to be printed, then pass the shortened list
     * 					recursivly to do the same until the base case is reached, then print
     * 					the element.
     * 
     * Base Case: When the length of the list is 0
     *
     ****************************************************/
	public <E> void printReverse(SinglyLinkedList<E> list) 
	{
		if(list == null) //ensures empty list passed to the method does not error
		{
			return;
		}
		if(list.getLength() == 0) //base case
		{
			return;
		}
		E element = list.remove(0);
		printReverse(list);
		System.out.println(element.toString());
	}
}
