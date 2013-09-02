/********************************************************
*  Project :  Assignment 10 - Student BST
*  File    :  StudentListMain.java
*  Name    :  @author Anthony Browness
*  Date    :  7/24/2013
********************************************************/
import javax.swing.JFrame;

public class StudentListMain 
{
	/**
	 * main
	 * Creates the frame and instantiates the StudentListClass
	 * @param args
	 */
	public static void main(String[] args) 
	{
		StudentListFrame studentFrame = new StudentListFrame();
		studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentFrame.setSize(570, 280);
		studentFrame.setVisible(true);
	}

}
