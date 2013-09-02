import java.util.*;
public class DisplayDeck
{
	/****************************************************
	* Method     : main
	*
	* Purpose    : Builds the deck of cards and displays all the cards to the user.
	* 
	* Parameters : N/A
	*
	* Returns    : N/A					
	****************************************************/	
    public static void main(String[] args) 
    {
        Deck deck = new Deck();
        for (int suit = Suit.DIAMONDS.value()-1; suit <= Suit.SPADES.value()-1; suit++) 
        {
            for (int rank = Rank.ACE.value()-1; rank <= Rank.KING.value()-1; rank++) 
            {
                System.out.format("%s of %s%n",
                	Card.rankToString(rank),
                	Card.suitToString(suit)
                );
           }
        }
    }
}