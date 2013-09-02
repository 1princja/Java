/********************************************************
*  Project :  Assignment 10 - Student BST
*  File    :  StudentListFrame.java
*  Name    :  @author Anthony Browness
*  Date    :  7/24/2013
********************************************************/

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * StudentListFrame class
 * Creates and displays the GUI with various elements to the user.  
 * Uses a JComboBox to display all students the the user and select a contact to delete.  
 * Various search functions such as by major, above a specified GPA or below a specified 
 * GPA manipulate the JComboBox to display the results to the user. The user can add a 
 * contact or delete a contact to the list which will then be displayed in the JComboBox.  
 * If the user has a contact loaded into the fields from selecting out of the box but wants 
 * to add a new contact they can use the Clear button to clear the fields and activate
 * the Add button.  All information is stored using the LinkedBST class.  An ArrayList maintains
 * the searched student objects for retrieval if needed.
 */
public class StudentListFrame extends JFrame
{
	private int sn;
	private String first;
	private String last;
	private String major;
	private double gpa;
	private int selectedNode = -1;
	private boolean selectedOnce = false;
	
	private JPanel studentPanel;
	private JButton addButton;
	private JButton deleteButton;
	private JButton clearButton;
	private JButton listAllButton;
	private JButton listMajorButton;
	private JButton listAboveButton;
	private JButton listBelowButton;
	private JLabel statusLabel;
	private JLabel snLabel;
	private JLabel firstLabel;
	private JLabel majorLabel;
	private JLabel gpaLabel;
	private JLabel lastLabel;
	private JTextField majorField;
	private JTextField gpaField;
	private JTextField snField;
	private JTextField firstField;
	private JTextField lastField;
	private JTextField listMajorField;
	private JTextField listAboveField;
	private JTextField listBelowField;
	private JComboBox<String> findComboBox;
	
	private BSTNode<Student> root;
	private LinkedBST<Student> tree = new LinkedBST<Student>(); 
	private ArrayList<Student> selectionList;
	private Student selectedPerson;
	
	/**
	 * addStudents
	 * Adds some sample students to the program if a read file is not found
	 */
	public void addStudents() 
	{
		Student s1 = new Student(11111, "Browness", "Anthony", "CSIS", 3.1);
		Student s2 = new Student(22222, "Mosbey", "Ted", "ARCH", 3.2);
		Student s3 = new Student(33333, "Stintson", "Barny", "BUIS", 3.3);
		Student s4 = new Student(44444, "Cooper", "Sheldon", "PHYS", 3.4);
		Student s5 = new Student(55555, "Johnson", "Carly", "HIST", 3.5);
		Student s6 = new Student(66666, "Peto", "Bronson", "CSIS", 3.6);
		Student s7 = new Student(77777, "George", "William", "SCI", 3.7);
		Student s8 = new Student(88888, "Bob", "Billy", "CSIS", 3.8);
		root = new BSTNode<Student>(s4);
		tree.setRoot(root);
		tree.add(s2);
		tree.add(s6);
		tree.add(s1);
		tree.add(s3);
		tree.add(s5);
		tree.add(s7);
		tree.add(s8);
	}

	/**
	 * StudentListFrame constructor
	 * Initializes variables and sets up the GUI
	 */
	public StudentListFrame()
	{	
		readStudentsSer();
		if(tree.size <= 0)
		{
			addStudents();
		}
		setTitle("Student List");
		getContentPane().setLayout(null);
		
		studentPanel = new JPanel();
		studentPanel.setBounds(0, 0, 550, 229);
		getContentPane().add(studentPanel);
		
		ButtonHandler handleButton = new ButtonHandler();
		
		addButton = new JButton("Add Record");
		addButton.setBounds(10, 5, 121, 23);
		addButton.addActionListener(handleButton);
		addButton.setVisible(true);
		studentPanel.setLayout(null);
		studentPanel.add(addButton);
		
		deleteButton = new JButton("Delete Record");
		deleteButton.setBounds(10, 32, 121, 23);
		deleteButton.addActionListener(handleButton);
		studentPanel.add(deleteButton);

		clearButton = new JButton("Clear Fields");
		clearButton.setBounds(10, 5, 121, 23);
		clearButton.addActionListener(handleButton);
		clearButton.setVisible(false);
		studentPanel.add(clearButton);
		
		listAllButton = new JButton("List All Students");
		listAllButton.setBounds(10, 163, 263, 23);
		listAllButton.addActionListener(handleButton);
		studentPanel.add(listAllButton);
		
		listMajorButton = new JButton("List By Major");
		listMajorButton.setBounds(10, 194, 144, 23);
		listMajorButton.addActionListener(handleButton);
		studentPanel.add(listMajorButton);
		
		listAboveButton = new JButton("List all Above GPA");
		listAboveButton.setBounds(296, 194, 144, 23);
		listAboveButton.addActionListener(handleButton);
		studentPanel.add(listAboveButton);

		listBelowButton = new JButton("List all Below GPA");
		listBelowButton.setBounds(297, 163, 144, 23);
		listBelowButton.addActionListener(handleButton);
		studentPanel.add(listBelowButton);
				
		snLabel = new JLabel("Student Number:");
		snLabel.setBounds(139, 9, 98, 14);
		studentPanel.add(snLabel);
		
		firstLabel = new JLabel("First Name:");
		firstLabel.setBounds(141, 36, 96, 14);
		studentPanel.add(firstLabel);
		
		gpaLabel = new JLabel("GPA:");
		gpaLabel.setBounds(369, 36, 71, 14);
		studentPanel.add(gpaLabel);
		
		lastLabel = new JLabel("Last Name:");
		lastLabel.setBounds(141, 64, 66, 14);
		studentPanel.add(lastLabel);
		
		majorField = new JTextField();
		majorField.setBounds(428, 6, 112, 20);
		majorField.setColumns(10);
		studentPanel.add(majorField);
		
		gpaField = new JTextField();
		gpaField.setBounds(428, 33, 112, 20);
		gpaField.setColumns(10);
		studentPanel.add(gpaField);
		
		snField = new JTextField();
		snField.setBounds(247, 6, 112, 20);
		snField.setColumns(10);
		studentPanel.add(snField);
		
		firstField = new JTextField();
		firstField.setBounds(247, 33, 112, 20);
		firstField.setColumns(10);
		studentPanel.add(firstField);
		
		lastField = new JTextField();
		lastField.setBounds(247, 61, 112, 20);
		lastField.setColumns(10);
		studentPanel.add(lastField);
		
		majorLabel = new JLabel("Major:");
		majorLabel.setBounds(369, 9, 71, 14);
		studentPanel.add(majorLabel);
		
		listMajorField = new JTextField();
		listMajorField.setText(null);
		listMajorField.setBounds(164, 197, 109, 20);
		studentPanel.add(listMajorField);
		listMajorField.setColumns(10);
		
		listAboveField = new JTextField();
		listAboveField.setText(null);
		listAboveField.setColumns(10);
		listAboveField.setBounds(450, 195, 90, 20);
		studentPanel.add(listAboveField);
		
		listBelowField = new JTextField();
		listBelowField.setText(null);
		listBelowField.setColumns(10);
		listBelowField.setBounds(450, 164, 90, 20);
		studentPanel.add(listBelowField);
		
		findComboBox = new JComboBox<String>();
		findComboBox.setBounds(10, 118, 530, 23);
		FindHandler handleFind = new FindHandler();
		findComboBox.addItemListener(handleFind);
		studentPanel.add(findComboBox);
		
		statusLabel = new JLabel("Listing All Students");
		statusLabel.setForeground(new Color(0, 191, 255));
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setBounds(178, 96, 223, 20);
		studentPanel.add(statusLabel);

		populateAll();
		clearFields();

	}

	/**
	 * clearFields
	 * Returns the program to its initial state.
	 */
	private void clearFields()
	{
		snField.setText(null);
		firstField.setText(null);
		majorField.setText(null);
		gpaField.setText(null);
		lastField.setText(null);
		listMajorField.setText(" ");
		listAboveField.setText(" ");
		listBelowField.setText(" ");
		clearButton.setVisible(false);
		addButton.setVisible(true);
		repaint();
		printAll(getGraphics());
	}

	/**
	 * populateAll
	 * Lists all students stored in the BST
	 */
	public void populateAll()
	{
		findComboBox.removeAllItems();
		populateAllVisitor<Student> allVisitor = new populateAllVisitor<Student>();
		tree.doInOrderTraversal(tree.root(), allVisitor);
		selectionList = allVisitor.list();
		for(int i = 0; i < selectionList.size(); i++)
		{
			findComboBox.addItem(selectionList.get(i).toString());
		}
		findComboBox.setSelectedIndex(-1);
		repaint();
		printAll(getGraphics());
	}
	
	/**
	 * populateMajor
	 * Lists all students by specified major
	 */
	public void populateMajor()
	{
		findComboBox.removeAllItems();
		statusLabel.setText("Listing By Selected Major: " + listMajorField.getText());
		System.out.println(listMajorField.getText());
		populateMajorVisitor<Student> majorVisitor = new populateMajorVisitor<Student>(listMajorField.getText());
		tree.doInOrderTraversal(tree.root(), majorVisitor);
		selectionList = majorVisitor.list();

		for(int i = 0; i < selectionList.size(); i++)
		{
			findComboBox.addItem(selectionList.get(i).toString());
		}
		findComboBox.setSelectedIndex(-1);
		listMajorField.setText(" ");
		repaint();
		printAll(getGraphics());
	}
	
	/**
	 * populateAbove
	 * Lists all students above the specified GPA
	 */
	public void populateAbove()
	{
		findComboBox.removeAllItems();
		statusLabel.setText("Listing By GPAs Above: " + listAboveField.getText());
		populateAboveVisitor<Student> aboveVisitor = new populateAboveVisitor<Student>(Double.parseDouble(listAboveField.getText()));
		tree.doInOrderTraversal(tree.root(), aboveVisitor);
		selectionList = aboveVisitor.list();

		for(int i = 0; i < selectionList.size(); i++)
		{
			findComboBox.addItem(selectionList.get(i).toString());
		}
		findComboBox.setSelectedIndex(-1);
		listAboveField.setText(" ");
		repaint();
		printAll(getGraphics());
	}
	
	/**
	 * populateBelow
	 * Lists all students below the specified GPA
	 */
	public void populateBelow()
	{
		findComboBox.removeAllItems();
		statusLabel.setText("Listing By GPAs Below: " + listBelowField.getText());
		populateBelowVisitor<Student> belowVisitor = new populateBelowVisitor<Student>(Double.parseDouble(listBelowField.getText()));
		tree.doInOrderTraversal(tree.root(), belowVisitor);
		selectionList = belowVisitor.list();

		for(int i = 0; i < selectionList.size(); i++)
		{
			findComboBox.addItem(selectionList.get(i).toString());
		}
		findComboBox.setSelectedIndex(-1);
		listBelowField.setText(" ");
		repaint();
		printAll(getGraphics());
	}
	
	/**
	 * readStudentsSer
	 * reads the file students.ser and adds each Student object to the BST
	 * @throws EOFException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void readStudentsSer()
	{
		try
		{
			ObjectInputStream input = null;
			input = new ObjectInputStream(new FileInputStream("students.ser"));
			while(true)
			{
				Student person = (Student) input.readObject();
				if(tree.root() == null)
				{
					root = new BSTNode<Student>(person);
					tree.setRoot(root);
				}
				else
				{
					tree.add(person);
				}
			}
		}
		catch(EOFException eof)
		{
			return;
		}
		
		catch(ClassNotFoundException classNotFound)
		{	
			JOptionPane.showMessageDialog(null, "ClassNotFoundException", "Object not created", JOptionPane.ERROR_MESSAGE);
		}
		
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "IOException", "Error During File Read", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * ButtonHandler anonymous inner class
	 * Handles the various actions for the buttons in the program
	 * @throws RunTimeException
	 */
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			Object source = event.getSource();
			try
			{
				if(source == addButton)
				{
					sn = Integer.parseInt(snField.getText());
					first = firstField.getText();
					last = lastField.getText();
					major = majorField.getText();
					gpa = Double.parseDouble(gpaField.getText());
					Student person = new  Student(sn, last, first, major, gpa);
					tree.add(person);
					WriteVisitor v = new WriteVisitor();
					tree.doPreOrderTraversal(tree.root(), v);
					clearFields();
					populateAll();
					event.getActionCommand();
				}

				if(source == deleteButton)
				{
					if(selectedNode != -1 && selectedOnce == true)
					{
						Student person = selectionList.get(selectedNode);
						tree.remove(person);
						selectedNode = -1;
						clearButton.setVisible(false);
						addButton.setVisible(true);
						WriteVisitor v = new WriteVisitor();
						tree.doPreOrderTraversal(tree.root(), v);
						populateAll();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Index", "Contact must be selected from the list", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(source == clearButton)
				{
					clearFields();
					clearButton.setVisible(false);
					addButton.setVisible(true);
					findComboBox.setSelectedIndex(-1);
					repaint();
					printAll(getGraphics());
				}
				
				if(source == listAllButton)
				{
					populateAll();
				}
				
				if(source == listMajorButton)
				{
					if(listMajorField.getText().equals(" "))
					{
						JOptionPane.showMessageDialog(null, "Missing Input", "Please specify a major.", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						populateMajor();
					}
				}
				
				if(source == listAboveButton)
				{
					if(listAboveField.getText() == " ")
					{
						JOptionPane.showMessageDialog(null, "Missing Input", "Please specify a GPA", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						populateAbove();
					}
				}
				
				if(source == listBelowButton)
				{
					if(listBelowField.getText() == " ")
					{
						JOptionPane.showMessageDialog(null, "Missing Input", "Please specify a GPA", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						populateBelow();
					}
				}
			}	
			catch(RuntimeException rutimeException)
			{	
				JOptionPane.showMessageDialog(null, "Runtime Exception", "Runtime Exception", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * FindHandler anonymous inner class
	 * Populates the text boxes with the selected Student values
	 */
	private class FindHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			if(event.getStateChange() == ItemEvent.SELECTED)
			{
				addButton.setVisible(false);
				clearButton.setVisible(true);

				selectedNode = findComboBox.getSelectedIndex();
				selectedOnce = true;
				
				selectedPerson = selectionList.get(selectedNode);
				snField.setText(Integer.toString(selectedPerson.getStudentNumber()));
				firstField.setText(selectedPerson.getFirstName());
				lastField.setText(selectedPerson.getLastName());
				majorField.setText(selectedPerson.getMajor());
				gpaField.setText(Double.toString(selectedPerson.getGpa()));
	
				repaint();
				printAll(getGraphics());
			}
		}
	}
}



