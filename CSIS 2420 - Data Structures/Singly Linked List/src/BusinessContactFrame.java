/********************************************************
*  Project :  Assignment 04 - Singly Linked List
*  File    :  BusinessContactFrame.java
*  Name    :  Anthony Browness
*  Date    :  6/12/2013
*
*  Description : 
*
*    1) Create and display the GUI with various elements to the user.  Uses a JComboBox
*    	to display all contacts the the user and select a contact to delete.  The user
*    	can add a contact or delete a contact to the list which will then be displayed in the
*    	JComboBox.  If the user has a contact loaded into the fields from selecting out of the box
*    	but wants to add a new contact they can use the Clear button to clear the fields and activate
*    	the Add button.  All information is stored using the SinglyLinkedList class.
*     
*    2) Singly Linked List
*
*    3) N/A
*
*    4) BusinessContactFrame, clearFields, populateContacts, buttonHandler, fieldHandler
*
*  Changes : N/A
********************************************************/

import javax.swing.*;
import java.awt.event.*;

public class BusinessContactFrame extends JFrame
{
	private String first;
	private String last;
	private String phone;
	private String email;
	private String company;
	private int selectedNode = -1;
	private SinglyLinkedList<BusinessContact> contacts = new SinglyLinkedList();
	private boolean selectedOnce = false;
	
	private JPanel contactPanel;
	private JButton addButton;
	private JButton deleteButton;
	private JButton clearButton;
	private JLabel firstLabel;
	private JLabel lastLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel;
	private JLabel companyLabel;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField firstField;
	private JTextField lastField;
	private JTextField companyField;
	private JComboBox findComboBox;
	
	 /****************************************************
     * Method     : BusinessContactFrame - Constructor
     *
     * Purpose    : Instantiates the values for the GUI and
     * 				presents the first state to the user.
	 *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public BusinessContactFrame() {
		setTitle("Business Contacts");
		getContentPane().setLayout(null);
		
		contactPanel = new JPanel();
		contactPanel.setBounds(0, 0, 583, 262);
		getContentPane().add(contactPanel);
		
		ButtonHandler handleButton = new ButtonHandler();
		
		addButton = new JButton("Add Contact");
		addButton.setBounds(10, 5, 121, 23);
		addButton.addActionListener(handleButton);
		addButton.setVisible(true);
		contactPanel.setLayout(null);
		contactPanel.add(addButton);
		
		deleteButton = new JButton("Delete Contact");
		deleteButton.setBounds(10, 32, 121, 23);
		deleteButton.addActionListener(handleButton);
		contactPanel.add(deleteButton);

		clearButton = new JButton("Clear Fields");
		clearButton.setBounds(10, 5, 121, 23);
		clearButton.addActionListener(handleButton);
		clearButton.setVisible(false);
		contactPanel.add(clearButton);
		
		firstLabel = new JLabel("First Name:");
		firstLabel.setBounds(141, 9, 71, 14);
		contactPanel.add(firstLabel);
		
		lastLabel = new JLabel("Last Name:");
		lastLabel.setBounds(141, 36, 54, 14);
		contactPanel.add(lastLabel);
		
		emailLabel = new JLabel("Email:");
		emailLabel.setBounds(353, 32, 71, 14);
		contactPanel.add(emailLabel);
		
		companyLabel = new JLabel("Company:");
		companyLabel.setBounds(141, 61, 66, 14);
		contactPanel.add(companyLabel);
		
		phoneField = new JTextField();
		phoneField.setBounds(415, 6, 156, 20);
		phoneField.setColumns(10);
		contactPanel.add(phoneField);
		
		emailField = new JTextField();
		emailField.setBounds(415, 33, 156, 20);
		emailField.setColumns(10);
		contactPanel.add(emailField);
		
		firstField = new JTextField();
		firstField.setBounds(222, 6, 121, 20);
		firstField.setColumns(10);
		contactPanel.add(firstField);
		
		lastField = new JTextField();
		lastField.setBounds(222, 33, 121, 20);
		lastField.setColumns(10);
		contactPanel.add(lastField);
		
		companyField = new JTextField();
		companyField.setBounds(222, 58, 121, 20);
		companyField.setColumns(10);
		contactPanel.add(companyField);
		
		
		phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(353, 9, 71, 14);
		contactPanel.add(phoneLabel);

		//add 5 objects
		BusinessContact c1 = new BusinessContact("Anthony", "Browness", "385-242-3824", "abrowness@email.com", "Candy Mountian");
		BusinessContact c2 = new BusinessContact("Ted", "Mosbey", "552-758-8486", "tmosbey@email.com" ,"Architectual Designs");
		BusinessContact c3 = new BusinessContact("Barny", "Stintson", "555-555-5555", "bstinson@email.com" ,"Suit Wearers United");
		BusinessContact c4 = new BusinessContact("Sheldon", "Cooper", "123-456-7890", "scooper@email.com" ,"UCLA");
		BusinessContact c5 = new BusinessContact("Lance", "Buttars", "785-458-4578", "lbuttars@email.com" ,"Fuze Network");
		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		contacts.add(c4);
		contacts.add(c5);

		findComboBox = new JComboBox();
		findComboBox.setBounds(10, 86, 561, 30);
		findComboBox.setMaximumRowCount(7);
		FindHandler handleFind = new FindHandler();
		findComboBox.addItemListener(handleFind);
		contactPanel.add(findComboBox);
	
		populateContacts();
		clearFields();

	}

	 /****************************************************
     * Method     : clearFields 
     *
     * Purpose    : Clears any data out of the editable JTextFields
     * 				and repaints the GUI.
	 *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	private void clearFields(){
		firstField.setText(null);
		lastField.setText(null);
		phoneField.setText(null);
		emailField.setText(null);
		companyField.setText(null);
		repaint();
		printAll(getGraphics());
	}

	 /****************************************************
     * Method     : populateContacts 
     *
     * Purpose    : Keeps the findComboBox up to date. Clears
     * 				the combobox and then repopulates it according to
     * 				the data stored in the SinglyLinkedList. 
	 *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void populateContacts()
	{
		findComboBox.removeAllItems();
		
		for(int i = 0; i < contacts.getLength(); i++)
		{
			BusinessContact person = contacts.getElementAt(i);
			String locFirst = person.getFirstName();
			String locLast = person.getLastName();
			String locEmail = person.getEmailAddress();
			String locPhone = person.getPhoneNumber();
			String locCompany = person.getCompany();
			String row = locFirst +  "     " + locLast + "     " + locEmail + "     " + locPhone + "     " + locCompany;
			findComboBox.addItem(row);
		}
		findComboBox.setSelectedIndex(-1);
		
		repaint();
		printAll(getGraphics());
	}
	
	 /****************************************************
     * Anonymous Inner Class: ButtonHandler 
     *
     * Purpose    : Handles the actions performed by the various buttons.
     * 				Allows the user to Add a contact, Delete a contact, or
     * 				revert back to a cleared state if fields are populated via
     * 				the combobox.
	 *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			Object source = event.getSource();
			try
			{
				if(source == addButton)
				{
					first = firstField.getText();
					last = lastField.getText();
					phone = phoneField.getText();
					email = emailField.getText();
					company = companyField.getText();
					BusinessContact contact = new  BusinessContact(first, last, phone, email, company);

					contacts.add(contact);
					clearFields();
					populateContacts();
					event.getActionCommand();
				}

				if(source == deleteButton)
				{
					if(selectedNode != -1 && selectedOnce == true){
						contacts.remove(selectedNode);
						selectedNode = -1;
						clearButton.setVisible(false);
						addButton.setVisible(true);
						populateContacts();
					}
					else{
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
			}	
			catch(RuntimeException rutimeException)
			{	
				JOptionPane.showMessageDialog(null, "Invalid Input", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	 /****************************************************
     * Anonymous Inner Class: FindHandler 
     *
     * Purpose    : Handles the selections made in the JComboBox.
     * 				Finds the node selected, loads the element into
     * 				the fields and prepares the element to be deleted
     * 				if the user wishes.
	 *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
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
				
				BusinessContact contact = contacts.getElementAt(selectedNode);
				firstField.setText(contact.getFirstName());
				lastField.setText(contact.getLastName());
				phoneField.setText(contact.getPhoneNumber());
				emailField.setText(contact.getEmailAddress());
				companyField.setText(contact.getCompany());
	
				repaint();
				printAll(getGraphics());
			}
		}
	}
}
