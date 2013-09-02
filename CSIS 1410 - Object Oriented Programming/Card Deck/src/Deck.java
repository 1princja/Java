import java.util.*;
public class Deck 
{

    public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private Card[][] cards;

	/****************************************************
	* Method     : Deck
	*
	* Purpose    : 	Constructor, builds the deck of cards.
	* 
	* Parameters : N/A
	*
	* Returns    : N/A					
	****************************************************/	
    public Deck()
    {
        cards = new Card[numSuits][numRanks];
        for (int suit = Suit.DIAMONDS.value(); Suit.SPADES.value() <= 1; suit++) 
        {
            for (int rank = Rank.ACE.value(); rank <= Rank.KING.value(); rank++) 
            {
                cards[suit-1][rank-1] = new Card(rank, suit); //-1
            }
        }
    }

	/****************************************************
	* Method     : getCard
	*
	* Purpose    : 	Accessor, returns a single card from the deck.
	* 
	* Parameters :	int suit
	* 				int rank
	*
	* Returns    : a single card from the deck, Card cards[][]					
	****************************************************/	
    public Card getCard(int suit, int rank) 
    {
        return cards[suit-1][rank-1];//-1
    }
}