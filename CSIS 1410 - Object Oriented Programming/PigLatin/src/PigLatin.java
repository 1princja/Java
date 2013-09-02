/********************************************************
 *  Project :  Assignment 10- Pig Latin
 *  File    :  PigLatin.java
 *  Name    :  Anthony Browness
 *  Date    :  27 March 2013
 *
 *  Description 	: Translates a sentence into Pig Latin, corrects the 
 *
 *	Data Structures	: String[] wordsArray, an array that contains the words	as they are being translated.
 *
 *  Implementation	: The program prompts and stores a sentence input by the user, it then tokenizes the sentence
 *					  with method split(" ") which is space delimited " ". It stores the tokenized words in an  	
 *					  array which is looped through and sent into the convertToLatin() method to convert the words.
 *					  Additionally a counter is kept to keep track of which word is currently being converted so
 *					  that method convertToLatin() can properly capatalize the first letter of the first word, and
 *					  pull punctiation out of the last word to apply to the end of the word.  Method convertToLatin()
 *					  uses method substring() in order to split up the words and method concat() to properly put the
 *					  word back together in Pig Latin, the word is returned to the constructor which uses method concat()
 *					  to put the words back into a sentence and outputs it to the user.
 * 
 *  Methods			: Main			-	Prompts and stores sentence from the user, passes the sentence into the constructor.  
 *					  Constructor	- 	Tokenizes users sentence into words, uses convertToLatin() to convert
 *										each word into Pig Latin overwrites the sentences place in the array and then 
 *										reconstructs the sentence and prints it.
 *											length() or length
 *											concat()
 *											split()
 *					  Accessors					
 *					  Mutators
 *					  convertToLatin-   Converts the tokenized words into Pig Latin, uses field count to keep track of words to
 *										properly capatalize the first tokenized word and pull/replace punctuation in the last word.
 *											substring()
 *											toUpperCase()
 *											toLowerCase()
 *											concat()
 *					  incCount		-	Increments the count field in order to keep track of the current word being translated.	
 *
 *  Changes 		: N/A
 *
 ********************************************************/
import java.util.Scanner;

public class PigLatin
{   
	private int count = 1;
	private int last;

	/****************************************************
	* Method     : Main
	*
	* Purpose    : Prompt and retrieve/store input from the user, 
	*				pass input into	constructor.
	* 
	* Paramaters : N/A
	*
	* Returns    : N/A					
	****************************************************/	
	public static void main( String args[] )
	{
		Scanner input = new Scanner( System.in );
		System.out.println("Enter a sentence to translate into Pig Latin:");
		String sentence = input.nextLine();
		PigLatin latinize = new PigLatin(sentence);
	}

	/****************************************************
	* Method     : Constructor
	*
	* Purpose    : Tokenizes the sentence, then passes the sentence into
	*			   method convertToLatin(), after it gets the converted word
	*			   returned it overwrites the old word with the convereted word in the
	*			   array, it then increments field count.  After all words are converted it
	*			   concatenates the words together and prints them.
	* 
	* Paramaters : String sentence - passed by method Main
	*
	* Returns    : N/A					
	****************************************************/	
	public PigLatin(String sentence)
	{
		String[] wordsArray = sentence.split(" ");
		setLast(wordsArray.length);
		for(int i = 0; i < wordsArray.length; i++)
		{	
			String convertedWord = convertToLatin(wordsArray[i]);
			wordsArray[i] = convertedWord;
			incCount();
		}
				
		String latinSentence = "";
		
		for(int i = 0; i < wordsArray.length; i++)
		{
			latinSentence = latinSentence.concat(wordsArray[i]);
		}
		System.out.println(latinSentence);
	}
	
	/****************************************************
	* Method     : convertToLatin
	*
	* Purpose    : Converts the tokenized word into Pig Lating by removing the first
	*			   letter, and contatenating it at the end of the word then adds "ay".
	*			   If statements detect the first and last words of the sentence using 
	*			   field count, which lowercase the first letter then uppercase the new
	*			   first letter, and remove/store and replace the punctuation respectivly.
	* Paramaters : String word
	*
	* Returns    : String latinWord					
	****************************************************/		
	public String convertToLatin(String word)
	{
		String otherLetters;
		String firstLetter = word.substring(0,1);
		firstLetter = firstLetter.toLowerCase();
		String latinWord = "";
		
		if(getCount() == getLast())
		{
			String punctuation = word.substring(word.length()-1);
			otherLetters = word.substring(1, (word.length()-1));
			latinWord = otherLetters.concat(firstLetter);
			latinWord = latinWord.concat("ay");
			latinWord = latinWord.concat(punctuation);
		}

		else
		{	
			otherLetters = word.substring(1, word.length());
			latinWord = otherLetters.concat(firstLetter);
			latinWord = latinWord.concat("ay ");
		}
		
		if(getCount() == 1)
		{
			firstLetter = latinWord.substring(0,1);
			otherLetters = latinWord.substring(1, (latinWord.length()));
			firstLetter = firstLetter.toUpperCase();
			latinWord = firstLetter.concat(otherLetters);
		}
		
		return latinWord;
	}
	
	/****************************************************
	* Method     : incCount
	*
	* Purpose    : Increment field count in order to track the current
	*			   word being passed into method convertToLatin()
	* 
	* Paramaters : N/A
	*
	* Returns    : N/A					
	****************************************************/	
	public void incCount()
	{
		count++;
	}
	
	//Mutator methods
	public void setCount(int num)
	{
		count = num;
	}
	
	public void setLast(int num)
	{
		last = num;
	}
	
	//Accessor Methods
	public int getCount()
	{
		return count;
	}
	
	public int getLast()
	{
		return last;
	}
}
	
	