/********************************************************
 *  Project :  Assignment 10- Pig Latin
 *  File    :  PigLatin.java
 *  Name    :  Anthony Browness
 *  Date    :  27 March 2013
 *
 *  Description 	: 
 *
 *	Data Structures	: 
 *
 *  Implementation	: 
 *
 *  Methods			: 
 *
 *  Changes 		: 
 *
 ********************************************************/
public class PigLatinTest
{   
	public static void main( String args[] )
	{
		String sentence = "Hello there you little kitty.";
		PigLatin go = new PigLatin(sentence);
		sentence = "Why does this thing not work well!";
		PigLatin hi = new PigLatin(sentence);
	}
}