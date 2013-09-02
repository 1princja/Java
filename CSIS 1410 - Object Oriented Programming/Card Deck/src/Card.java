/********************************************************
 *  Project :  Assignment 16 - Enums
 *  File    :  Card.java
 *  Name    :  Anthony Browness
 *  Date    :  29 April 2013
 *
 *  Description 	: A program that creates and displays a deck of cards using enumeration
 *  
 *	Data Structures	: card[][] array
 *
 *  Implementation	: The program uses two sets of enumerations Rank and Suit to manipulate the values of a card in a deck.
 * 
 *  Methods			: 	Card
 *  				  	getSuit
 *  					getRank
 *  					isValidRank
 *  					isValidSuit
 *  					rankToString
 *  					suitToString
 *  					main
 *  
 *  					Deck
 *  					getCard
 *  
 *  					DisplayDeck
 *  					main
 *  
 *  					Rank
 *  					Rank-Overloaded
 *  					value
 *  					toString	
 *
 *  					Suit
 *  					Suit-Overloaded
 *  					value
 *  					toString
 *  
 *  Changes 		: N/A
 *
 ********************************************************/
public class Card
{

    private static Rank rank;
    private static Suit suit;
 
	/****************************************************
	* Method     : Card
	*
	* Purpose    : 	Constructor, builds the card using the values given, runs assertion that the rank and suite generated
	* 				for the card are viable.
	* 
	* Parameters : 	rank- the cards rank
	* 				int suit -  the cards suite
	*
	* Returns    : N/A					
	****************************************************/	
    public Card(int rank, int suit) 
    {
        assert isValidRank(rank);
        assert isValidSuit(suit);
        Card.rank = Rank.values()[rank];
        Card.suit = Suit.values()[suit];
    }

	/****************************************************
	* Method     : getSuit
	*
	* Purpose    : 	Accessor, returns the suit of the card. 
	* 
	* Parameters : N/A
	*
	* Returns    : Suit suit					
	****************************************************/	
    public Suit getSuit() 
    {
        return suit;
    }

	/****************************************************
	* Method     : getRank
	*
	* Purpose    : 	Accessor, returns the rank fo the card. 
	* 
	* Parameters : N/A
	*
	* Returns    : Rank rank					
	****************************************************/	
    public Rank getRank() 
    {
        return rank;
    }

	/****************************************************
	* Method     : isValidRank
	*
	* Purpose    : 	Checks to see if the rank passed is a valid enum
	* 
	* Parameters : int rank
	*
	* Returns    : N/A					
	****************************************************/	
    public static boolean isValidRank(int rank) 
    {
        return Rank.ACE.value() <= rank && rank <= Rank.KING.value();
    }

	/****************************************************
	* Method     : isValidSuit
	*
	* Purpose    : 	Checks to see if the rank passed is a valid enum
	* 
	* Parameters : int suit
	*
	* Returns    : N/A					
	****************************************************/	
    public static boolean isValidSuit(int suit) 
    {
        return Suit.DIAMONDS.value() <= suit && suit <= Suit.SPADES.value();
    }

	/****************************************************
	* Method     : rankToString
	*
	* Purpose    : Accessor, returns the toString value of the cards rank
	* 
	* Parameters : N/A
	*
	* Returns    : Rank.toString					
	****************************************************/	
    public static String rankToString(int rank) 
    {
    	return Rank.values()[rank].toString();	
    }

	/****************************************************
	* Method     : suitToString
	*
	* Purpose    : Accessor, returns the toString value of the cards suit
	* 
	* Parameters : N/A
	*
	* Returns    : Suit.toString					
	****************************************************/	
    public static String suitToString(int suit) 
    {
    	return Suit.values()[suit].toString();	
    }


	/****************************************************
	* Method     : main
	*
	* Purpose    : Runs the assertion portion of the program if run directly
	* 				from this file using the java -ea flags.
	* 
	* Parameters : N/A
	*
	* Returns    : N/A					
	****************************************************/	
    public static void main(String[] args) {
    	
    	// must run program with -ea flag (java -ea ..) to
    	// use assert statements
        assert rankToString(1) == "Ace";
        assert rankToString(2) == "Deuce";
        assert rankToString(3) == "Three";
        assert rankToString(4) == "Four";
        assert rankToString(5) == "Five";
        assert rankToString(6) == "Six";
        assert rankToString(7) == "Seven";
        assert rankToString(8) == "Eight";
        assert rankToString(9) == "Nine";
        assert rankToString(10) == "Ten";
        assert rankToString(11) == "Jack";
        assert rankToString(12) == "Queen";
        assert rankToString(13) == "King";

        assert suitToString(1) == "Diamonds";
        assert suitToString(2) == "Clubs";
        assert suitToString(3) == "Hearts";
        assert suitToString(4) == "Spades";
    }
}

