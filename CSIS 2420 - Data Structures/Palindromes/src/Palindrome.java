/********************************************************
*  Project :  Assignment 07 - Palindromes
*  File    :  Palindrome.java
*  Name    :  Anthony Browness
*  Date    :  7/03/2013
*
*  Description : 
*
*    1) Purpose: Test if the word is a palindrome via a queue and stack
*    			 by running a comparison operation on each letter.
*     
*    2) Data-structures: Stack- linked list backing store
*    					 Queue- linked list backing store
*
*    3) Data-structure- Algorithms, Techniques, Implementations:
*		Basic for-loops to enqueue and push letters
*		Basic for-loops to dequeue and pop letters
*
*    4) Methods: Palindrome, testPalindrome
*
*  Changes : N/A
********************************************************/
public class Palindrome 
{

	private String modText;
	private int size;
	LinkedStack stack = new LinkedStack();
	CircularQueue queue;

	/****************************************************
	* Method     : Palindrome-Constructor 
	*
	* Purpose    : Initialize Variables, remove all whitespace and
	* 				special characters from the string and load them
	* 				into the queue and stack.
	*
	* Parameters : @param String text , the text to be tested
	*
	* Returns    : This method does not return a value.
	*
	****************************************************/
	public Palindrome(String text) 
	{
		modText = text.toLowerCase();
		modText = modText.replaceAll("\\s","");
		modText = modText.replaceAll("[^A-Za-z]", "");
		size = modText.length();
		queue = new CircularQueue(size+1);
		for(int i = 0; i < size; i++)
		{
			stack.push(modText.charAt(i));
			queue.enqueue(modText.charAt(i));
		}
	}
	
	/****************************************************
	* Method     : testPalindrome
	*
	* Purpose    : Compare each letter in the Data structures to deduce
	* 				wether it is or is not a palindrome.
	*
	* Parameters : This method does not require parameters.
	*
	* Returns    : @return boolean , if the test is a palindrome or 
	* 				not a palindrome.
	*
	****************************************************/
	public boolean testPalindrome()
	{
		for(int i = 0; i < size; i++)
		{
			char testStack = (char) stack.pop();
			char testQueue = (char) queue.dequeue();
			if(testStack != testQueue)
			{
				return false;
			}
		}
		return true;
	}
}
