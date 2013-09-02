/********************************************************
*  Project :  Assignment 07 - Palindromes
*  File    :  PalindromesMain.java
*  Name    :  Anthony Browness
*  Date    :  7/03/2013
*
*  Description : 
*
*    1) Purpose: Instantiates the PalindromesFrame class and displays the UI to the user
*     
*    2) Data-structures: N/A
*
*    3) Data-structure- Algorithms, Techniques, Implementations: N/A
*
*    4) Methods: main 
*
*  Changes : N/A
********************************************************/
import javax.swing.JFrame;

public class PalindromesMain 
{
	 /****************************************************
     * Method     : main
     *
     * Purpose    : Launch the program
     *
     * Parameters : @param args
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public static void main(String[] args) 
	{
		PalindromesFrame palindromesFrame = new PalindromesFrame();
		palindromesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		palindromesFrame.setSize(345, 165);
		palindromesFrame.setVisible(true);
	}

}
