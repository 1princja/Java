/********************************************************
*  Project :  Assignment 07 - Palindromes
*  File    :  PalindromesFrame.java
*  Name    :  Anthony Browness
*  Date    :  7/03/2013
*
*  Description : 
*
*    1) Purpose: Loads and displays the various GUI components to the user
*     
*    2) Data-structures: array 
*
*    3) Data-structure- Algorithms, Techniques, Implementations: 
*    	Basic for-loops for array manipulation.
*
*    4) Methods: PalindromesFrame, prefMenu, testPalindrome, trueTest, falseTest, 
*    	reset, ButtonHandler, ColorHandler
*
*  Changes : N/A
********************************************************/
import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;


public class PalindromesFrame extends JFrame
{
	private JPanel aboutPanel;
	private JTextField textField;
	private JLabel trueLbl;
	private JLabel falseLbl;
	private JLabel imageLbl;
	private JButton testButton;
	private JButton clearButton;
	private final Color[] colorValue = 
	{ 	
			Color.LIGHT_GRAY, 
			Color.WHITE, 
			Color.BLACK, 
			Color.BLUE, 
			Color.GREEN, 
			Color.ORANGE
	};
	
	private JRadioButtonMenuItem[] 	colorItems;
	private ButtonGroup colorButtonGroup;
	
	/****************************************************
    * Method     : PalindromesFrame-Constructor 
    *
    * Purpose    : Instantiates and displays various GUI components.
    *
    * Parameters : This method does not require parameters.
    *
    * Returns    : This method does not return a value.
    *
    ****************************************************/
	public PalindromesFrame() 
	{
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		
		exitItem.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					System.exit(0);
				}	
			}
		);
		
		JMenu prefMenu = prefMenu();
		menuBar.add(prefMenu);
		
		JMenu aboutMenu = new JMenu("About");
		menuBar.add(aboutMenu);

		Icon slccImg = new ImageIcon(getClass().getResource("slcc.jpg"));
		imageLbl = new JLabel(slccImg);
		
		aboutPanel = new JPanel();
		aboutPanel.setLayout(new BorderLayout(0, 0));
		aboutPanel.add(imageLbl, BorderLayout.WEST );

		JLabel infoLbl = new JLabel("<html>Programmer: Anthony Browness" +
									"<br><br>Assignment 07 - Palindromes<br>" +
									"<br>A Program presented using a Graphical User Interface" +
									"<br>which tests if the word entered by the user is or is not" +
									"<br>a Palindrome.");
		
		aboutPanel.add(infoLbl, BorderLayout.CENTER);
		
		JMenuItem aboutItem = new JMenuItem("CS2420");
		aboutMenu.add(aboutItem);
		aboutItem.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					JOptionPane.showMessageDialog(null,	aboutPanel);
				}	
			}
		);
		getContentPane().setLayout(null);
		
		JLabel lblEnterYourPalindrome = new JLabel("Enter your palindrome:");
		lblEnterYourPalindrome.setBounds(10, 11, 173, 14);
		getContentPane().add(lblEnterYourPalindrome);
		
		textField = new JTextField();
		textField.setBounds(10, 32, 309, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		trueLbl = new JLabel("is a palindrome.");
		trueLbl.setBounds(10, 63, 112, 14);
		getContentPane().add(trueLbl);
		
		falseLbl = new JLabel("Is not a palindrome.");
		falseLbl.setBounds(10, 63, 147, 14);
		getContentPane().add(falseLbl);
		
		ButtonHandler handleButton = new ButtonHandler();
		
		testButton = new JButton("Test");
		testButton.setBounds(131, 59, 89, 23);
		testButton.addActionListener(handleButton);
		getContentPane().add(testButton);
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(230, 59, 89, 23);
		clearButton.addActionListener(handleButton);
		getContentPane().add(clearButton);
		
		reset();
	}

	/****************************************************
	* Method     : prefMenu
	*
	* Purpose    : 	Allows the user to choose different background colors or
	* 				change the look and feel of the program window.
	* 
	* Parameters : N/A
	*
	* Returns    : @return JMenu prefMenu, a JMenu Object.		
	****************************************************/	
	public JMenu prefMenu()
	{
		JMenu prefMenu = new JMenu("Preferences");
		prefMenu.setMnemonic('P');
		
		//Background menu
		JMenuItem bgMenu = new JMenu("Background Color");
		bgMenu.setMnemonic('c');

		String[] colors = 
		{	
			"Grey", 
			"White", 
			"Black", 
			"Blue", 
			"Green", 
			"Orange"
		};
		colorItems = new JRadioButtonMenuItem[colors.length];
		colorButtonGroup = new ButtonGroup();
		ColorHandler handleColor = new ColorHandler();
		
		for(int c = 0; c < colors.length; c++)
		{
			colorItems[c] = new JRadioButtonMenuItem(colors[c]);
			bgMenu.add(colorItems[c]);
			colorButtonGroup.add(colorItems[c]);
			colorItems[c].addActionListener(handleColor);
		}
		
		colorItems[1].setSelected(true);
		prefMenu.add(bgMenu);
		
		return prefMenu;
	}
	
	/****************************************************
	* Method     : testPalindrome
	*
	* Purpose    : Determines if the provided text is a palindrome,
	* 				progresses the program on to the appropriate display
	* 				method.
	*
	* Parameters : @param testText, the text to test if it 
	* 				is or if is not	a palindrome.
	*
	* Returns    : This method does not return a value.
	*
	****************************************************/
	public void testPalindrome(String testText)
	{
		Palindrome test = new Palindrome(testText);
		boolean bool = test.testPalindrome();
		if(bool == true)
		{
			trueText();	
		}
		if(bool == false)
		{
			falseText();
		}
	}
	
	/****************************************************
	* Method     : trueText
	*
	* Purpose    : Provides a visual queue to the user if the
	* 				text is a palindrome.
	*
	* Parameters : This method does not require parameters.
	*
	* Returns    : This method does not return a value.
	*
	****************************************************/
	public void trueText()
	{
		textField.setBackground(Color.GREEN);
		trueLbl.setVisible(true);
		falseLbl.setVisible(false);
		repaint();
	}

	/****************************************************
	* Method     : falseText
	*
	* Purpose    : Provides a visual queue to the user if the
	* 				text is not a palindrome.
	*
	* Parameters : This method does not require parameters.
	*
	* Returns    : This method does not return a value.
	*
	****************************************************/
	public void falseText()
	{
		textField.setBackground(Color.RED);
		trueLbl.setVisible(false);
		falseLbl.setVisible(true);
		repaint();
	}
	
	/****************************************************
	* Method     : reset
	*
	* Purpose    : Reset the GUI to its original state
	*
	* Parameters : This method does not require parameters.
	*
	* Returns    : This method does not return a value.
	*
	****************************************************/
	public void reset()
	{
		textField.setBackground(Color.WHITE);
		trueLbl.setVisible(false);
		falseLbl.setVisible(false);
		textField.setText(null);
		repaint();
	}
	
	/****************************************************
	* Method     : Anonymous Inner Class- ButtonHandler
	*
	* Purpose    : Manage the GUI's buttons.
	*
	* Parameters : This method does not require parameters.
	*
	* Returns    : This method does not return a value.
	*
	****************************************************/
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			if(source == testButton)
			{
				String testText = textField.getText();
				Palindrome testEquals = new Palindrome(testText);
				boolean test = testEquals.testPalindrome();
				if(test == true)
				{
					trueText();
				}
				if(test == false)
				{
					falseText();
				}
			}
			if(source == clearButton)
			{
				textField.setText(null);
				reset();
				repaint();
			}
		}
	}
	
	/****************************************************
	* Method     : Anonymous Inner Class- ColorHandler
	*
	* Purpose    : Manage the GUI's backgrounds.
	*
	* Parameters : This method does not require parameters.
	*
	* Returns    : This method does not return a value.
	*
	****************************************************/
	private class ColorHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			for(int count = 0; count< colorItems.length; count++)
			{
				if(colorItems[count].isSelected())
				{
					getContentPane().setBackground(colorValue[count]);
					break;
				}
			}
			repaint();
		}
	}
}
