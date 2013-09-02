//package components;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class BusinessContactFrame extends JFrame
{

	/**
	 * 
	 */
	//JTextFields
	private JTextField 	inputFirstName,
						inputLastName,
						inputPhoneNumber,
						inputEmailAddress,
						inputCompany;
	//JComboBoxes
	private JComboBox deleteComboBox,
					  viewComboBox;
	//JLabels
	private JLabel 	retrieveFirstName,
					retrieveLastName,
					retrievePhoneNumber,
					retrieveEmailAddress,
					retrieveCompany;
	//Button
	private JButton addButton, //.setEnabled()
					deleteButton,
					viewButton,
					displayButton,
					saveAddButton,
					cancelAddButton,
					cancelViewButton,
					saveDeleteButton,
					cancelDeleteButton,
					cancelDisplayButton;
	
	//JPanels
    private JPanel 	menuPanel,
					addPanel,
					deletePanel,
					viewPanel,
					viewContactPanel,
					displayPanel,
    				displayListPanel;
	//Class variables
	private String 	first,
					last,
					phone,		
					email,
					comp;
	private int index;
	ArrayList<BusinessContact> contacts = new ArrayList<BusinessContact>();
	//layout
	private FlowLayout layout;
	private Container container;

	//Creates the JFrame and adds panels to it. Constructor.
	public BusinessContactFrame()
	{
		super("Business Contact List");
		layout = new FlowLayout();
		container = getContentPane();
		setLayout(layout);
		layout.setAlignment(FlowLayout.LEFT);
		layout.layoutContainer(container);
		readContactsSer();
		
		//Input Fields, 
		inputFirstName = new JTextField(10);
		inputLastName = new JTextField(10);
		inputPhoneNumber = new JTextField(10);
		inputEmailAddress = new JTextField(10);
		inputCompany = new JTextField(10);

		//Retrieve Fields
		retrieveFirstName 		= new JLabel(" ");
		retrieveLastName 		= new JLabel(" ");
		retrievePhoneNumber  	= new JLabel(" ");
		retrieveEmailAddress   	= new JLabel(" ");
		retrieveCompany    		= new JLabel(" ");
		
		menuPanel = menuJPanel();
		addPanel = addJPanel();
		deletePanel = deleteJPanel();
		viewContactPanel = viewContactJPanel();
		viewPanel = viewJPanel();
		displayPanel = displayJPanel();
		
		menuPanel.setVisible(true);
		addPanel.setVisible(true);
		deletePanel.setVisible(true);
		viewPanel.setVisible(true);
		viewContactPanel.setVisible(true);
		displayPanel.setVisible(true);
		
		add(menuPanel);
//		layout.layoutContainer(getContentPane());

	}
	
	public JPanel menuJPanel()
	{
		JPanel menuJPanel = new JPanel(new GridLayout(5,1,20,20));
		
		addButton = new JButton("Add Contact");
		deleteButton = new JButton("Delete Contact");
		viewButton = new JButton("View Contact");
		displayButton = new JButton("Display Contact List");
		
		ButtonHandler handleButton = new ButtonHandler();
		
		addButton.addActionListener(handleButton);
		deleteButton.addActionListener(handleButton);
		viewButton.addActionListener(handleButton);
		displayButton.addActionListener(handleButton);
		
		menuJPanel.add(addButton);
		menuJPanel.add(deleteButton);
		menuJPanel.add(viewButton);
		menuJPanel.add(displayButton);
		
		return menuJPanel;
	}
	
	public JPanel addJPanel()
	{
		//Create Panel and set visiblity to false
		JPanel addJPanel = new JPanel(new GridLayout(6,2,5,5));
//		addPanel.setVisible(false);//set to true when selected from menu

		//Buttons
		saveAddButton = new JButton("Save");
		cancelAddButton = new JButton("Return to Menu");
		
		//Add Buttons and Fields to the Panel
		addJPanel.add(saveAddButton);
		addJPanel.add(cancelAddButton);
		addJPanel.add( new JLabel("First Name:") );
		addJPanel.add(inputFirstName);
		addJPanel.add( new JLabel("Last Name:") );
		addJPanel.add(inputLastName);
		addJPanel.add( new JLabel("Phone Number:") );
		addJPanel.add(inputPhoneNumber);
		addJPanel.add( new JLabel("Email Address:") );
		addJPanel.add(inputEmailAddress);
		addJPanel.add( new JLabel("Company:") );
		addJPanel.add(inputCompany);

		//Create handler object, add listeners to the Buttons and Input Fields
		TextHandler handleText = new TextHandler();
		
		inputFirstName.addActionListener(handleText);
		inputLastName.addActionListener(handleText);
		inputPhoneNumber.addActionListener(handleText);
		inputEmailAddress.addActionListener(handleText);
		inputCompany.addActionListener(handleText);
		saveAddButton.addActionListener(handleText);
		cancelAddButton.addActionListener(handleText);
		
		return addJPanel;
	}
	
	public JPanel deleteJPanel()
	{
		//Create panel and set visibiity to false
		JPanel deleteJPanel = new JPanel(new BorderLayout(5,5));

		//call the names method to return a workable array of First and Last names
		String[] names = namesMethod();

//		String[] namestest = {"test1","test2", "test3", "test4", "test5", "test6", "test7", "test8"};
		//create a combobox to hold the First and Last names
		deleteComboBox = new JComboBox(names);
		deleteComboBox.setMaximumRowCount(10);
		deleteComboBox.setEditable(false);
		
		deleteComboBox.addItemListener
		(
			new ItemListener()
			{
				public void itemStateChanged(ItemEvent event)
				{
					if(event.getStateChange() == ItemEvent.SELECTED)
					{
						int i = deleteComboBox.getSelectedIndex();
//todo delete this
						System.out.println(i);
//						event.getActionCommand();
					}
				}
			}
		);
	
		//Button that deletes the selected index.
		saveDeleteButton = new JButton("Delete Selected Contact");
		saveDeleteButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
//					Object source = event.getSource();
					contacts.remove(index);
					writeContactsSer();
					displaySequence(menuPanel);
					event.getActionCommand();
				}
			}
		);
		
		//Button that returns to menu.
		cancelDeleteButton = new JButton("Return to Menu");
		cancelDeleteButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					displaySequence(menuPanel);
					event.getActionCommand();
				}
			}
		);
		
		deleteJPanel.add(deleteComboBox, BorderLayout.WEST);
		deleteJPanel.add(saveDeleteButton, BorderLayout.EAST);
		deleteJPanel.add(cancelDeleteButton, BorderLayout.NORTH);
		
		return deleteJPanel;
	}

	public JPanel viewJPanel()
	{
		JPanel viewJPanel = new JPanel(new BorderLayout(5,5));

		String[] names = namesMethod();

		//create a combobox to hold the First and Last names
		viewComboBox = new JComboBox(names);
		viewComboBox.setMaximumRowCount(10);
		viewComboBox.setEditable(false);
//		viewPanel.add( new JScrollPane(contactList));

		viewComboBox.addItemListener
		(
			new ItemListener()
			{
				public void itemStateChanged(ItemEvent event)
				{
					if(event.getStateChange() == ItemEvent.SELECTED)
					{
						int i = viewComboBox.getSelectedIndex();
						
						//messing around trying to just get the value of the selected
						//item instead of the index.
						Object selectedItem = viewComboBox.getSelectedItem();
						String selectedItemStr = selectedItem.toString();
						System.out.println(selectedItemStr);
						
						retrieveFirstName.setText(contacts.get(i).getFirstName());
						retrieveLastName.setText(contacts.get(i).getLastName());
						retrievePhoneNumber.setText(contacts.get(i).getPhoneNumber());
						retrieveEmailAddress.setText(contacts.get(i).getEmailAddress());
						retrieveCompany.setText(contacts.get(i).getCompany());
	//					viewContactPanel = viewContactJPanel();
						repaint();
						printAll(getGraphics());
//todo delete this
						System.out.println(i);
					}
				}
			}
		);

//		ViewHandler handleView = new ViewHandler();

		cancelViewButton = new JButton("Return to Menu");
//		cancelViewButton.addActionListener(handleView);
		cancelViewButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					displaySequence(menuPanel);
					event.getActionCommand();
				}
			}
		);
		
		viewJPanel.add(viewComboBox, BorderLayout.WEST);
		viewJPanel.add(cancelViewButton, BorderLayout.NORTH);
		viewContactPanel = viewContactJPanel();
		viewJPanel.add(viewContactPanel, BorderLayout.EAST);
		return viewJPanel;
	}
	
	public JPanel viewContactJPanel()
	{
		JPanel viewContactJPanel = new JPanel(new GridLayout(5,3,10,10));

		viewContactJPanel.add( new JLabel("First Name:") );
		viewContactJPanel.add(retrieveFirstName);
		viewContactJPanel.add( new JLabel("Last Name:") );
		viewContactJPanel.add(retrieveLastName);
		viewContactJPanel.add( new JLabel("Phone Number:") );
		viewContactJPanel.add(retrievePhoneNumber);
		viewContactJPanel.add( new JLabel("Email Address:") );
		viewContactJPanel.add(retrieveEmailAddress);
		viewContactJPanel.add( new JLabel("Company:") );
		viewContactJPanel.add(retrieveCompany);

		return viewContactJPanel;
	}

	public JPanel displayJPanel()
	{
		JPanel displayJPanel = new JPanel(new BorderLayout(5,5));
		cancelDisplayButton = new JButton("Return to Menu");
		displayListPanel = displayListJPanel();
		JScrollPane scroller = new JScrollPane(displayListPanel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		displayJPanel.add(scroller, BorderLayout.WEST);
		displayJPanel.add(cancelDisplayButton, BorderLayout.NORTH);
//		displayJPanel.add(displayListPanel, BorderLayout.WEST);
 		
		cancelDisplayButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					displaySequence(menuPanel);
					event.getActionCommand();
				}
			}
		);
		
		return displayJPanel;
	
	}
		
	public JPanel displayListJPanel()
	{
		JPanel displayListJPanel = new JPanel(new GridLayout(contacts.size()+1,5,5,5));
		Font header = new Font("Serif", Font.BOLD, 16);
		JLabel fir = new JLabel("First Name");
		JLabel las = new JLabel("Last Name");
		JLabel pho = new JLabel("Phone Number");
		JLabel ema = new JLabel("Email Address");
		JLabel com = new JLabel("Company");
		fir.setFont(header);
		las.setFont(header);
		pho.setFont(header);
		ema.setFont(header);
		com.setFont(header);
		displayListJPanel.add(fir);
		displayListJPanel.add(las);
		displayListJPanel.add(pho);
		displayListJPanel.add(ema);
		displayListJPanel.add(com);
		
		for(int i = 0; i < contacts.size(); i++)
		{
			BusinessContact person = contacts.get(i);
			retrieveFirstName 		= new JLabel(" ");
			retrieveLastName 		= new JLabel(" ");
			retrievePhoneNumber  	= new JLabel(" ");
			retrieveEmailAddress   	= new JLabel(" ");
			retrieveCompany    		= new JLabel(" ");
			
			JLabel firstNameLabel = new JLabel(person.getFirstName());
			JLabel lastNameLabel = new JLabel(person.getLastName());
			JLabel phoneNumberLabel = new JLabel(person.getPhoneNumber());
			JLabel emailAddressLabel = new JLabel(person.getEmailAddress());
			JLabel companyLabel = new JLabel(person.getCompany());
			
			displayListJPanel.add(firstNameLabel);
			displayListJPanel.add(lastNameLabel);
			displayListJPanel.add(phoneNumberLabel);
			displayListJPanel.add(emailAddressLabel);
			displayListJPanel.add(companyLabel);
		}
				
		return displayListJPanel;
	}
		
	public String[] namesMethod()
	{
		String[] nameArray = new String[contacts.size()];

		for(int i = 0; i < contacts.size(); i++)
		{
			BusinessContact person = contacts.get(i);
			String fName = person.getFirstName();
			String lName = person.getLastName();
			fName = fName.concat(" ");
			String name = fName.concat(lName);
			nameArray[i] = name;
		}
		return nameArray;
	}
	
	private void writeContactsSer()
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
	
	private void readContactsSer()
	{
		ObjectInputStream input = null;
		System.out.println("Reading...");
		try
		{
			input = new ObjectInputStream(new FileInputStream("contacts.ser"));
			while(true)
			{
				contacts = (ArrayList<BusinessContact>) input.readObject();
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
			e.printStackTrace();
		}
	}

	private void displaySequence(JPanel panel)
	{
		getContentPane().removeAll();
		getContentPane().add(panel);
		repaint();
		printAll(getGraphics());
	}
	
	//inner class for button event handling
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			Object source = event.getSource();

					
			if(source == addButton)
			{
				readContactsSer();
				//I can do this because they were instantiated in the constructor.
				inputFirstName.setText("");
				inputLastName.setText("");
				inputPhoneNumber.setText("");
				inputEmailAddress.setText("");
				inputCompany.setText("");

				displaySequence(addPanel);
				event.getActionCommand();
			}
				
			if(source == deleteButton)
			{
				
				deletePanel = deleteJPanel();				
				displaySequence(deletePanel);
				event.getActionCommand();
			}
				
			if(source == viewButton)
			{
				try
				{
					viewPanel = viewJPanel();
					retrieveFirstName.setText(contacts.get(0).getFirstName());
					retrieveLastName.setText(contacts.get(0).getLastName());
					retrievePhoneNumber.setText(contacts.get(0).getPhoneNumber());
					retrieveEmailAddress.setText(contacts.get(0).getEmailAddress());
					retrieveCompany.setText(contacts.get(0).getCompany());

					getContentPane().removeAll();
					getContentPane().add(viewPanel);
					repaint();
					printAll(getGraphics());
					event.getActionCommand();
				}
				catch(IndexOutOfBoundsException indexOutOfBoundsException)
				{	
					JOptionPane.showMessageDialog(null, "Please add a contact first", "Please add a contact first", JOptionPane.ERROR_MESSAGE);
				}
			}
				
			if(source == displayButton)
			{
				displayListPanel = displayListJPanel();
				displayPanel = displayJPanel();
				displaySequence(displayPanel);
				event.getActionCommand();
			}
		}
	}
	
	//inner class for TextField event handling
	private class TextHandler implements ActionListener
	{
					
		public void actionPerformed( ActionEvent event )
		{
			Object source = event.getSource();
			try
			{

				if(source == saveAddButton)
				{
					first = inputFirstName.getText();
					last = inputLastName.getText();
					phone = inputPhoneNumber.getText();
					email = inputEmailAddress.getText();
					comp = inputCompany.getText();
					BusinessContact contact = new  BusinessContact(first, last, phone, email, comp);

					contacts.add(contact);
					
					writeContactsSer();
					displaySequence(menuPanel);
					event.getActionCommand();
				}

				if(source == cancelAddButton)
				{
					displaySequence(menuPanel);
					event.getActionCommand();
				}
			}	
			catch(RuntimeException rutimeException)
			{	
				JOptionPane.showMessageDialog(null, "Invalid Input", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}