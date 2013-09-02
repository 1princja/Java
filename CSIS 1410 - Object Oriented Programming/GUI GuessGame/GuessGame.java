/********************************************************
 *  Project :  Assignment 09- GUI Lab
 *  File    :  GuessGame.java
 *  Name    :  Anthony Browness
 *  Date    :  12 March 2013
 *
 *  Description 	: A game that generates a random number and allows the user to guess, it 
 *					  uses Java graphical components.
 *
 ********************************************************/
// Guess the number
import javax.swing.JFrame;

public class GuessGame
{
   public static void main( String args[] )
   {
      GuessGameFrame guessGameFrame = new GuessGameFrame(); 
      guessGameFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      guessGameFrame.setSize( 300, 150 ); // set frame size
      guessGameFrame.setVisible( true ); // display frame
   } // end main
} // end class GuessGame

/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/