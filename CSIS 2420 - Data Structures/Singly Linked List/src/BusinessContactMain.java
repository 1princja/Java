/********************************************************
*  Project :  Assignment 04 - Singly Linked List
*  File    :  BusinessContactMain.java
*  Name    :  Anthony Browness
*  Date    :  6/12/2013
*
*  Description : 
*
*    1) Instantiates the BusinessContactFrame class and displays the UI to the user
*     
*    2) N/A
*
*    3) N/A
*
*    4) main 
*
*  Changes : N/A
********************************************************/
import javax.swing.JFrame;

public class BusinessContactMain 
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
		BusinessContactFrame contactsFrame = new BusinessContactFrame();
		contactsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contactsFrame.setSize(605, 320);
		contactsFrame.setVisible(true);
	}

}
