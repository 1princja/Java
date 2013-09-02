import javax.swing.border.Border;
import java.io.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

enum Tab
{
	FAMILY, FRIEND, BUSINESS
}

/**
 * This class sets up and runs the GUI Interface
 * @author Anthony Browness
 */
public class ContactFrame extends JFrame {
	Tab tab = Tab.FAMILY;
	
	private JTabbedPane tabbedPane; 
	
	private JPanel 	labelPanel,
					viewEditPanel;

	private JLabel 	firstNameLabel,
					lastNameLabel,
					relationshipLabel,
					addressLabel,
					cityLabel,
					stateLabel,
					zipLabel,
					phoneLabel,
					emailLabel,
					birthdayLabel,
					companyLabel;
	
	private JComboBox comboBox; 

	private JTextField 	stateTextField,
						cityTextField,
						emailTextField,
						lastNameTextField,
						firstNameTextField,
						phoneTextField,
						relationshipTextField,
						birthdayTextField,
						companyTextField,
						zipTextField;

	private JTextPane addressTextPane;
	
	private JButton backButton,
					addButton;

	private static JButton deleteButton;

	private JButton displayButton;

	private JButton saveButton;

	private JButton searchButton;

	private JButton editButton;

	private String 	first,
					last, 
					address,
					city,
					state,
					zip,
					phone, 
					email,
					relationship,
					birthday,
					company;
	
	private int contactIndex;
	private boolean edit = false;
	
	RegexValidator validate = new RegexValidator();

	
	ArrayList<Contact> contacts = new ArrayList<Contact>();

	/**
	 * ContactFrame constructor
	 */
	public ContactFrame() {
		super("Contact Management System");
		getContentPane().setLayout(null);
		readContactsSer();
		
//		String test = "test1";
//		FamilyContact contact = new  FamilyContact(	
//				test, //first
//				test, //last
//				test, //relationship
//				test, //phone
//				test, //email
//				test, //address
//				test, //city
//				test, //state
//				test); //zip
//		contacts.add(contact);
//		writeContactsSer();
		
		//Panes
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 32, 396, 364);
		layeredPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 11, 361, 341);
		layeredPane.setLayer(tabbedPane, 0);
		
		//Panels
		labelPanel = new JPanel();
		labelPanel.setBounds(20, 35, 351, 317);
		labelPanel.setBackground(Color.LIGHT_GRAY);
		labelPanel.setOpaque(false);
		layeredPane.setLayer(labelPanel, 1);

		viewEditPanel = new JPanel();
		viewEditPanel.setBounds(10, 6, 196, 54);
		viewEditPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "View/Edit Contact", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		viewEditPanel.setLayout(null);
		
		JPanel familyPanel = new JPanel();
		familyPanel.setLayout(null);
		familyPanel.setName("family");
		
		JPanel friendPanel = new JPanel();
		friendPanel.setLayout(null);
		friendPanel.setName("friend");
		
		JPanel businessPanel = new JPanel();
		businessPanel.setLayout(null);
		businessPanel.setName("business");
		
		//Tabbed Panes
		tabbedPane.addTab("Family Contacts", null, familyPanel, null);
		tabbedPane.addTab("Friend Contacts", null, friendPanel, null);
		tabbedPane.addTab("Business Contacts", null, businessPanel, null);

		tabbedPane.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
		    {
				processTabChange();
		    }
		});

		//Buttons
		ButtonHandler handleButton = new ButtonHandler();
		
		addButton = new JButton("Add Contact");	
		addButton.setBounds(31, 400, 115, 23);
		addButton.addActionListener(handleButton);
		
		backButton = new JButton("Back");	
		backButton.setBounds(31, 400, 115, 23);
		backButton.addActionListener(handleButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(150, 400, 115, 23);
		saveButton.addActionListener(handleButton);
		
		deleteButton = new JButton("Delete Contact");
		deleteButton.setEnabled(false);
		deleteButton.setBounds(270, 400, 120, 23);
		deleteButton.addActionListener(handleButton);

		editButton = new JButton("Edit Contact");
		editButton.setBounds(207, 23, 134, 23);
		editButton.addActionListener(handleButton);
		
		displayButton = new JButton("Display All Contacts");
		displayButton.setBounds(31, 11, 161, 23);
		displayButton.addActionListener(handleButton);
		
		searchButton = new JButton("Search All Contacts");
		searchButton.setBounds(229, 11, 161, 23);
		searchButton.addActionListener(handleButton);
		
		//Labels
		birthdayLabel = new JLabel("Birthday:");
		birthdayLabel.setBounds(8, 120, 91, 14);

		companyLabel = new JLabel("Company:");
		companyLabel.setBounds(8, 120, 91, 14);

		relationshipLabel = new JLabel("Relationship:");
		relationshipLabel.setBounds(8, 120, 91, 14);
		
		firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBounds(10, 71, 97, 14);
		labelPanel.setLayout(null);
																		
		lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBounds(10, 96, 97, 14);
																		
		addressLabel = new JLabel("Address:");
		addressLabel.setBounds(11, 196, 96, 14);
																		
		cityLabel = new JLabel("City:");
		cityLabel.setBounds(10, 239, 97, 14);
																		
		stateLabel = new JLabel("State:");
		stateLabel.setBounds(10, 264, 97, 14);
																		
		zipLabel = new JLabel("Zip Code:");
		zipLabel.setBounds(10, 289, 97, 14);
																		
		phoneLabel = new JLabel("Phone Number:");
		phoneLabel.setBounds(10, 146, 97, 14);
																		
		emailLabel = new JLabel("E-mail Address:");
		emailLabel.setBounds(10, 171, 97, 14);

		//Text Fields
		companyTextField = new JTextField();
		companyTextField.setBounds(109, 117, 230, 20);
		companyTextField.setText("");
		companyTextField.setColumns(10);
		
		birthdayTextField = new JTextField();
		birthdayTextField.setBounds(109, 117, 230, 20);
		birthdayTextField.setText("");
		birthdayTextField.setColumns(10);

		relationshipTextField = new JTextField();
		relationshipTextField.setBounds(109, 117, 230, 20);
		relationshipTextField.setText("");
		relationshipTextField.setColumns(10);
		
		zipTextField = new JTextField();
		zipTextField.setBounds(111, 286, 230, 20);
		zipTextField.setColumns(10);
																		
		stateTextField = new JTextField();
		stateTextField.setColumns(10);
		stateTextField.setBounds(111, 261, 230, 20);
																		
		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(111, 236, 230, 20);
																		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(111, 168, 230, 20);
																		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(111, 93, 230, 20);
																		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(111, 68, 230, 20);
																		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(111, 143, 230, 20);
		
		
		addressTextPane = new JTextPane();
		//this needs to be implemented by button presses
		addressTextPane.setBackground(firstNameTextField.getBackground());
		addressTextPane.setBounds(111, 192, 230, 40);
		Border border = firstNameTextField.getBorder();
		addressTextPane.setBorder(border);

		comboBox = new JComboBox();
		firstState();
		comboBox.setBounds(10, 18, 176, 20);
		comboBox.setToolTipText("Select Family Contact");
		comboBox.setMaximumRowCount(10);
		comboBox.setEditable(false);
		comboBox.addItemListener
		(
			new ItemListener()
			{
				public void itemStateChanged(ItemEvent event)
				{
					if(event.getStateChange() == ItemEvent.SELECTED)
					{
						if(comboBox.getSelectedIndex() != 0)
						{
							editButton.setEnabled(true);
							Object selectedItem = comboBox.getSelectedItem();
							String selectedItemStr = selectedItem.toString();
							contactIndex = getArrayIndex(selectedItemStr);
							int i = contactIndex;
							//polymorphism
							if(tab == Tab.FAMILY)
							{
								if(contacts.get(i) instanceof FamilyContact)
								{
									FamilyContact contact = (FamilyContact) contacts.get(i);
									relationship = contact.getRelationship();
									first = contact.getFirstName();
									last = contact.getLastName();
									address = contact.getAddress();
									city = contact.getCity();
									state = contact.getState();
									zip = contact.getZipCode();
									phone = contact.getPhoneNumber();
									email = contact.getEmailAddress();
									setTextFields();
								}
							}
							if(tab == Tab.FRIEND)
							{
								if(contacts.get(i) instanceof FriendContact)
								{
									FriendContact contact = (FriendContact) contacts.get(i);
									birthday = contact.getBirthday();
									first = contact.getFirstName();
									last = contact.getLastName();
									address = contact.getAddress();
									city = contact.getCity();
									state = contact.getState();
									zip = contact.getZipCode();
									phone = contact.getPhoneNumber();
									email = contact.getEmailAddress();
									setTextFields();
								}
							}
							
							if(tab == Tab.BUSINESS)
							{
								if(contacts.get(i) instanceof BusinessContact)
								{
									BusinessContact contact = (BusinessContact) contacts.get(i);
									company = contact.getCompany();
									first = contact.getFirstName();
									last = contact.getLastName();
									address = contact.getAddress();
									city = contact.getCity();
									state = contact.getState();
									zip = contact.getZipCode();
									phone = contact.getPhoneNumber();
									email = contact.getEmailAddress();
									setTextFields();
								}
							}
							firstNameTextField.setVisible(true);
							repaint();
							printAll(getGraphics());
						}
					}
				}
			}
		);
		
		
		//adding stuff to the panels
		familyPanel.add(relationshipLabel);
		familyPanel.add(relationshipTextField);

		friendPanel.add(birthdayLabel);
		friendPanel.add(birthdayTextField);

		businessPanel.add(companyLabel);
		businessPanel.add(companyTextField);

		viewEditPanel.add(comboBox);
		
		labelPanel.add(viewEditPanel);
		labelPanel.add(editButton);
		labelPanel.add(firstNameLabel);
		labelPanel.add(firstNameTextField);
		labelPanel.add(lastNameLabel);
		labelPanel.add(lastNameTextField);
		labelPanel.add(addressLabel);
		labelPanel.add(addressTextPane);
		labelPanel.add(cityLabel);
		labelPanel.add(cityTextField);
		labelPanel.add(stateLabel);
		labelPanel.add(stateTextField);
		labelPanel.add(zipLabel);
		labelPanel.add(zipTextField);
		labelPanel.add(phoneLabel);
		labelPanel.add(phoneTextField);
		labelPanel.add(emailLabel);
		labelPanel.add(emailTextField);
		
		layeredPane.add(tabbedPane);
		layeredPane.add(labelPanel);

		//adding stuff to the content pane
		getContentPane().add(layeredPane);
		getContentPane().add(addButton);
		getContentPane().add(backButton);
		getContentPane().add(deleteButton);
		getContentPane().add(displayButton);
		getContentPane().add(saveButton);
		getContentPane().add(searchButton);
	}
	
	/**
	 * Creates an array from the contacts ArrayList
	 */
	private void JComboBox() {
		String[] names = namesMethod();
		comboBox.removeAllItems();
		for(int i = 0; i < names.length; i++)
		{
			comboBox.addItem(names[i]);
		}
		comboBox.setSelectedIndex(0);
	}


	/**
	 * Inner class Action Listener for the buttons on the ContactFrame
	 * @author Anthony Browness
	 */
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			Object source = event.getSource();

			if(source == addButton)
			{
				//turn on all the fields
				firstState();
				zipTextField.setEditable(true);
				stateTextField.setEditable(true);
				cityTextField.setEditable(true);
				emailTextField.setEditable(true);
				lastNameTextField.setEditable(true);
				firstNameTextField.setEditable(true);
				phoneTextField.setEditable(true);
				addressTextPane.setEditable(true);
				addressTextPane.setBackground(firstNameTextField.getBackground());

				if(tab == Tab.FAMILY)
				{
					relationshipTextField.setEditable(true);
				}
				if(tab == Tab.FRIEND)
				{
					birthdayTextField.setEditable(true);
				}
				if(tab == Tab.BUSINESS)
				{
					companyTextField.setEditable(true);
				}
				
				//set the button states
				saveButton.setEnabled(true);
				backButton.setEnabled(true);
				backButton.setVisible(true);
				addButton.setVisible(false);
				addButton.setEnabled(false);
				editButton.setEnabled(false);
				displayButton.setEnabled(false);
				searchButton.setEnabled(false);
				deleteButton.setEnabled(false);
				comboBox.setVisible(false);
				
				event.getActionCommand();
			}
			
			if(source == backButton)
			{
				firstState();
			}
			
			if(source == saveButton)
			{
				try
				{
					first 	= firstNameTextField.getText();
					last 	= lastNameTextField.getText();
					address = addressTextPane.getText();
					city 	= cityTextField.getText();
					state 	= stateTextField.getText();
					zip 	= zipTextField.getText();
					phone 	= phoneTextField.getText();
					email 	= emailTextField.getText();
				
					relationship = relationshipTextField.getText();
					birthday = birthdayTextField.getText();
					company = companyTextField.getText();

					if(validate.validateEmail(email) == false)
					{
						emailTextField.setText("");
						repaint();
						printAll(getGraphics());
						throw new RegexEmailException();
					}
					if(validate.validatePhone(phone) == false)
					{
						phoneTextField.setText("");
						repaint();
						printAll(getGraphics());
						throw new RegexPhoneException();
					}
				
				
					if(edit == true)
					{
						contacts.remove(contactIndex);
					}
					
					if(tab == Tab.FAMILY)
					{
						FamilyContact contact = new  FamilyContact(	first,
																	last, 
																	address,
																	city,
																	state,
																	zip,
																	phone, 
																	email,
																	relationship);
						contacts.add(contact);
					}
					if(tab == Tab.FRIEND)
					{
						birthday = birthdayTextField.getText();
						
						FriendContact contact = new  FriendContact(	first,
																	last, 
																	address,
																	city,	
																	state,
																	zip,
																	phone, 
																	email,
																	birthday);
						contacts.add(contact);
					}

					if(tab == Tab.BUSINESS)
					{
						company = companyTextField.getText();
					
						BusinessContact contact = new BusinessContact(	first,
																		last, 
																		address,
																		city,
																		state,
																		zip,
																		phone, 
																		email,
																		company);
						contacts.add(contact);
					}
				
					writeContactsSer();
					firstState();
					event.getActionCommand();
				}
				catch(RegexEmailException e)
				{
					e.printStackTrace();
				} 
				catch (RegexPhoneException e) 
				{
					e.printStackTrace();
				}
				catch(RuntimeException runtimeException)
				{	
					runtimeException.printStackTrace();
					JOptionPane.showMessageDialog(null, "Invalid Input", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}
			
			}
			
			if(source == deleteButton)
			{
				contacts.remove(contactIndex);
				writeContactsSer();
				firstState();
			}
				
			if(source == displayButton)
			{
				try
				{
					DisplayDialog.main(null);
					DisplayDialog.displayContacts(contacts);
				}
				catch(IndexOutOfBoundsException indexOutOfBoundsException)
				{	
					JOptionPane.showMessageDialog(null, "Please add a contact first", "Please add a contact first", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(source == searchButton)
			{
				try
				{
					SearchDialog.main(null);

				}
				catch(IndexOutOfBoundsException indexOutOfBoundsException)
				{	
					JOptionPane.showMessageDialog(null, "Please add a contact first", "Please add a contact first", JOptionPane.ERROR_MESSAGE);
				}
			}
				
			if(source == editButton)
			{
				edit = true;
				companyTextField.setEditable(true);
				birthdayTextField.setEditable(true);
				relationshipTextField.setEditable(true);
				zipTextField.setEditable(true);
				stateTextField.setEditable(true);
				cityTextField.setEditable(true);
				emailTextField.setEditable(true);
				lastNameTextField.setEditable(true);
				firstNameTextField.setEditable(true);
				phoneTextField.setEditable(true);
				addressTextPane.setEditable(true);
				addressTextPane.setBackground(firstNameTextField.getBackground());

				//set the button states
				saveButton.setEnabled(true);
				backButton.setEnabled(true);
				backButton.setVisible(true);
				addButton.setVisible(false);
				addButton.setEnabled(false);
				editButton.setEnabled(false);
				displayButton.setEnabled(false);
				searchButton.setEnabled(false);
				deleteButton.setEnabled(false);
				comboBox.setVisible(false);
			}
		}
	}
	
	/**
	 * sets the program state via modifying enumerations depending on the
	 * tabbedPane tab selected
	 */
	private void processTabChange()
	{
	    Component c = tabbedPane.getSelectedComponent();
	    switch(c.getName())
	    {
	    	case "family": 	tab = Tab.FAMILY;
	    					break;
	    	case "friend": 	tab = Tab.FRIEND;
	    					break;
	    	case "business": tab = Tab.BUSINESS;
	    					break;
	    }
	    firstState();
	}
	
	/**
	 * pulls the first and last names from the ArrayList and concatenates them.
	 * @return a <code>String[]</code> holding a list of first and last names
	 */
	public String[] namesMethod()
	{
		String[] nameArray = new String[contacts.size()+1];

		nameArray[0] = "Select Contact";
		int index = 1;
		
		for(int i = 0; i < contacts.size(); i++)
		{ 
			if(tab == Tab.FAMILY)
			{
				if(contacts.get(i) instanceof FamilyContact)
				{
					FamilyContact contact = (FamilyContact) contacts.get(i);
					String fName = contact.getFirstName();
					String lName = contact.getLastName();
					fName = fName.concat(" ");
					String name = fName.concat(lName);
					nameArray[index] = name;
					index++;
				}
			}
			if(tab == Tab.FRIEND)
			{
				if(contacts.get(i) instanceof FriendContact)
				{
					FriendContact contact = (FriendContact) contacts.get(i);
					String fName = contact.getFirstName();
					String lName = contact.getLastName();
					fName = fName.concat(" ");
					String name = fName.concat(lName);
					nameArray[index] = name;
					index++;
				}
			}

			if(tab == Tab.BUSINESS)
			{
				if(contacts.get(i) instanceof BusinessContact)
				{
					BusinessContact contact = (BusinessContact) contacts.get(i);
					String fName = contact.getFirstName();
					String lName = contact.getLastName();
					fName = fName.concat(" ");
					String name = fName.concat(lName);
					nameArray[index] = name;
					index++;
				}
			}
		}
		return nameArray;
	}
	
	/**
	 * Breaks apart the concatenated full name and finds the ArrayList index it belongs to 
	 * @param fullName a concatenated first and last name
	 * @return <code>integer</code> value of the ArrayList index
	 */
	public int getArrayIndex(String fullName)
	{
		String[] namesArray = fullName.split(" ");
		String fName = namesArray[0];
		String lName = namesArray[1];
		
		int index = 0;
		for(int i = 0; i < contacts.size(); i++)
		{
			if(contacts.get(i) instanceof FamilyContact)
			{
				FamilyContact person = (FamilyContact) contacts.get(i);
				if(person.getFirstName().equals(fName) && person.getLastName().equals(lName))
				{
					index = i;
				}
			}
			if(contacts.get(i) instanceof FriendContact)
			{
				FriendContact person = (FriendContact) contacts.get(i);
				if(person.getFirstName().equals(fName) && person.getLastName().equals(lName))
				{
					index = i;
				}
			}
			if(contacts.get(i) instanceof BusinessContact)
			{
				BusinessContact person = (BusinessContact) contacts.get(i);
				if(person.getFirstName().equals(fName) && person.getLastName().equals(lName))
				{
					index = i;
				}
			}
		}
		deleteButton.setEnabled(true);
		return index;
	}
	
	/**
	 * sets the text fields
	 */
	private void setTextFields()
	{
		relationshipTextField.setText(relationship);
		birthdayTextField.setText(birthday);
		companyTextField.setText(company);
		firstNameTextField.setText(first);
		lastNameTextField.setText(last);
		addressTextPane.setText(address);
		cityTextField.setText(city);
		stateTextField.setText(state);
		zipTextField.setText(zip);
		phoneTextField.setText(phone);
		emailTextField.setText(email);
	}
	
	/**
	 * returns the program to its initial state
	 */
	private void firstState()
	{
		edit = false;
		displayButton.setEnabled(true);
		searchButton.setEnabled(true);
		editButton.setEnabled(false);
		addButton.setEnabled(true);
		addButton.setVisible(true);
		backButton.setEnabled(false);
		backButton.setVisible(false);
		saveButton.setEnabled(false);
		deleteButton.setEnabled(false);
		
		//Text Fields
		companyTextField.setEditable(false);
		birthdayTextField.setEditable(false);
		relationshipTextField.setEditable(false);
		zipTextField.setEditable(false);
		stateTextField.setEditable(false);
		cityTextField.setEditable(false);
		emailTextField.setEditable(false);
		lastNameTextField.setEditable(false);
		firstNameTextField.setEditable(false);
		phoneTextField.setEditable(false);
		addressTextPane.setEditable(false);
		addressTextPane.setBackground(firstNameTextField.getBackground());

		JComboBox();

		companyTextField.setText("");
		birthdayTextField.setText("");
		relationshipTextField.setText("");
		zipTextField.setText("");
		stateTextField.setText("");
		cityTextField.setText("");
		emailTextField.setText("");
		lastNameTextField.setText("");
		firstNameTextField.setText("");
		phoneTextField.setText("");
		addressTextPane.setText("");
		comboBox.setVisible(true);
		
		repaint();
		printAll(getGraphics());
	}
	
	/**
	 * reads the file contacts.ser and adds the ArrayList to memory
	 */
	private void readContactsSer()
	{
		ObjectInputStream input = null;
		System.out.println("Reading...");
		try
		{
			input = new ObjectInputStream(new FileInputStream("contacts.ser"));
			while(true)
			{
				contacts = (ArrayList<Contact>) input.readObject();
			}
		}
		catch(EOFException eof)
		{
			return;
		}
		
		catch(ClassNotFoundException classNotFound)
		{	
			System.err.print("Object not created");
		}
		
		catch(IOException e)
		{
			System.err.println("Error During File Read");
			writeContactsSer();
		}
	}
	
	public ArrayList<Contact> getContacts(){
		return contacts;
	}
	
	/**
	 * Writes the ArrayList to contacts.ser
	 */
	public void writeContactsSer()
	{
		ObjectOutputStream output = null;
		System.out.println("Writing...");
		try
		{
			output = new ObjectOutputStream(new FileOutputStream("contacts.ser"));
			output.writeObject(contacts);
			
		if(output != null)
			{
				output.close();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
