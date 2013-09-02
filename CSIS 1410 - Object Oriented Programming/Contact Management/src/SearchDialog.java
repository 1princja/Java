import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SearchDialog extends JDialog
{
	private static JPanel viewPane = new JPanel();
	private static JTextField firstField;
	private static JTextField lastField;
	private static String first = null;
	private static String last = null;
	ArrayList<Contact> contacts;
	ContactFrame contactsFrame = new ContactFrame();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try 
		{
			SearchDialog dialog = new SearchDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchDialog()
	{
		loadFrame();
	}
	
	/**
	 * create the dialog.
	 */
	public void loadFrame()
	{
		contacts = contactsFrame.getContacts();
		setBounds(100, 100, 439, 403);
		SearchHandler handleSearch = new SearchHandler();
		getContentPane().setLayout(null);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 332, 423, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton closeButton = new JButton("Close");
				closeButton.addActionListener
				(
					new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							dispose();
						}
					}
				);
				closeButton.setActionCommand("Cancel");
				buttonPane.add(closeButton);
			}
		}
		
		JPanel searchPane = new JPanel();
		searchPane.setBounds(0, 0, 423, 60);
		getContentPane().add(searchPane);
		searchPane.setLayout(null);
		
		JLabel lastLabel = new JLabel("Last Name:");
		lastLabel.setBounds(10, 34, 86, 14);
		searchPane.add(lastLabel);
		
		JLabel firstLabel = new JLabel("First Name:");
		firstLabel.setBounds(10, 9, 86, 14);
		searchPane.add(firstLabel);
						
		firstField = new JTextField();
		firstField.setBounds(106, 6, 190, 20);
		searchPane.add(firstField);
		firstField.setColumns(10);
						
		lastField = new JTextField();
		lastField.setBounds(106, 31, 190, 20);
		searchPane.add(lastField);
		lastField.setColumns(10);
						
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(305, 5, 118, 23);
		searchPane.add(searchButton);
								
		viewPane = new JPanel();
		viewPane.setBounds(0, 60, 423, 272);
		getContentPane().add(viewPane);
		GridBagLayout gbl_viewPane = new GridBagLayout();
		gbl_viewPane.columnWidths = new int[] {20};
		gbl_viewPane.rowHeights = new int[]{0};
		gbl_viewPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_viewPane.rowWeights = new double[]{Double.MIN_VALUE};
		viewPane.setLayout(gbl_viewPane);
		
		searchButton.addActionListener(handleSearch);
	}
	
	/**
	 * Innerclass handles the search Button
	 *
	 */
	private class SearchHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent event )
		{
			doSearch();
			printAll(getGraphics());
	//		repaint();
		}
	}

	/**
	 * searches for the specified person and lists them
	 */
	public void doSearch()
	{
		viewPane = new JPanel();
		viewPane.setBounds(0, 60, 434, 170);
		getContentPane().add(viewPane);
			
		first = firstField.getText();
		last = lastField.getText();
		
		try
		{
			String fullName = first.concat(" ");
			fullName = fullName.concat(last);
			
			
			int index = contactsFrame.getArrayIndex(fullName);
			Contact person = contacts.get(index);
			
			JLabel blankLabel = new JLabel();
			blankLabel.setText(" ");
			GridBagConstraints gbc_blankLabel = new GridBagConstraints();
			gbc_blankLabel.insets = new Insets(0, 0, 5, 15);

			if(person instanceof Contact)
			{
				JLabel label = new JLabel("First");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 0, 5);
				gbc_label.gridx = 0;
				gbc_label.gridy = 0;
				viewPane.add(label, gbc_label);
				
				JLabel firstLabel = new JLabel();
				firstLabel.setText(person.getFirstName());
				GridBagConstraints gbc_firstLabel = new GridBagConstraints();
				gbc_firstLabel.insets = new Insets(0, 0, 0, 15);
				gbc_firstLabel.anchor = GridBagConstraints.WEST;
				gbc_firstLabel.gridx = 1;
				gbc_firstLabel.gridy = 0;
				viewPane.add(firstLabel, gbc_firstLabel);

				JLabel label_1 = new JLabel("Last");
				label_1.setHorizontalAlignment(SwingConstants.CENTER);
				label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label_1 = new GridBagConstraints();
				gbc_label_1.insets = new Insets(0, 0, 0, 5);
				gbc_label_1.gridx = 0;
				gbc_label_1.gridy = 1;
				viewPane.add(label_1, gbc_label_1);
			
				JLabel lastLabel = new JLabel();
				lastLabel.setText(person.getLastName());
				GridBagConstraints gbc_lastLabel = new GridBagConstraints();
				gbc_lastLabel.insets = new Insets(0, 0, 0, 15);
				gbc_lastLabel.anchor = GridBagConstraints.WEST;
				gbc_lastLabel.gridx = 1;
				gbc_lastLabel.gridy = 1;
				viewPane.add(lastLabel, gbc_lastLabel);

				JLabel label_2 = new JLabel("Address");
				label_2.setHorizontalAlignment(SwingConstants.CENTER);
				label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label_2 = new GridBagConstraints();
				gbc_label_2.insets = new Insets(0, 0, 0, 5);
				gbc_label_2.gridx = 0;
				gbc_label_2.gridy = 2;
				viewPane.add(label_2, gbc_label_2);
			
				JLabel addressLabel = new JLabel();
				addressLabel.setText(person.getAddress());
				GridBagConstraints gbc_addressLabel = new GridBagConstraints();
				gbc_addressLabel.insets = new Insets(0, 0, 0, 15);
				gbc_addressLabel.anchor = GridBagConstraints.WEST;
				gbc_addressLabel.gridx = 1;
				gbc_addressLabel.gridy = 2;
				viewPane.add(addressLabel, gbc_addressLabel);
		
				JLabel label_3 = new JLabel("City");
				label_3.setHorizontalAlignment(SwingConstants.CENTER);
				label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label_3 = new GridBagConstraints();
				gbc_label_3.insets = new Insets(0, 0, 0, 5);
				gbc_label_3.gridx = 0;
				gbc_label_3.gridy = 3;
				viewPane.add(label_3, gbc_label_3);
			
				JLabel cityLabel = new JLabel();
				cityLabel.setText(person.getCity());
				GridBagConstraints gbc_cityLabel = new GridBagConstraints();
				gbc_cityLabel.insets = new Insets(0, 0, 0, 15);
				gbc_cityLabel.anchor = GridBagConstraints.WEST;
				gbc_cityLabel.gridx = 1;
				gbc_cityLabel.gridy = 3;
				viewPane.add(cityLabel, gbc_cityLabel);
			
				JLabel label_4 = new JLabel("State");
				label_4.setHorizontalAlignment(SwingConstants.CENTER);
				label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label_4 = new GridBagConstraints();
				gbc_label_4.insets = new Insets(0, 0, 0, 5);
				gbc_label_4.gridx = 0;
				gbc_label_4.gridy = 4;
				viewPane.add(label_4, gbc_label_4);
			
				JLabel stateLabel = new JLabel();
				stateLabel.setText(person.getState());
				GridBagConstraints gbc_stateLabel = new GridBagConstraints();
				gbc_stateLabel.insets = new Insets(0, 0, 0, 15);
				gbc_stateLabel.anchor = GridBagConstraints.WEST;
				gbc_stateLabel.gridx = 1;
				gbc_stateLabel.gridy = 4;
				viewPane.add(stateLabel, gbc_stateLabel);

				JLabel label_5 = new JLabel("Zip Code");
				label_5.setHorizontalAlignment(SwingConstants.CENTER);
				label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label_5 = new GridBagConstraints();
				gbc_label_5.insets = new Insets(0, 0, 0, 5);
				gbc_label_5.gridx = 0;
				gbc_label_5.gridy = 5;
				viewPane.add(label_5, gbc_label_5);
			
				JLabel zipLabel = new JLabel();
				zipLabel.setText(person.getZipCode());
				GridBagConstraints gbc_zipLabel = new GridBagConstraints();
				gbc_zipLabel.insets = new Insets(0, 0, 0, 15);
				gbc_zipLabel.anchor = GridBagConstraints.WEST;
				gbc_zipLabel.gridx = 1;
				gbc_zipLabel.gridy = 5;
				viewPane.add(zipLabel, gbc_zipLabel);

				JLabel label_6 = new JLabel("Phone");
				label_6.setHorizontalAlignment(SwingConstants.CENTER);
				label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label_6 = new GridBagConstraints();
				gbc_label_6.insets = new Insets(0, 0, 0, 5);
				gbc_label_6.gridx = 0;
				gbc_label_6.gridy = 6;
				viewPane.add(label_6, gbc_label_6);
			
				JLabel phoneLabel = new JLabel();
				phoneLabel.setText(person.getPhoneNumber());
				GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
				gbc_phoneLabel.insets = new Insets(0, 0, 0, 15);
				gbc_phoneLabel.anchor = GridBagConstraints.WEST;
				gbc_phoneLabel.gridx = 1;
				gbc_phoneLabel.gridy = 6;
				viewPane.add(phoneLabel, gbc_phoneLabel);
				
				JLabel label_7 = new JLabel("Email");
				label_7.setHorizontalAlignment(SwingConstants.CENTER);
				label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label_7 = new GridBagConstraints();
				gbc_label_7.insets = new Insets(0, 0, 0, 5);
				gbc_label_7.gridx = 0;
				gbc_label_7.gridy = 7;
				viewPane.add(label_7, gbc_label_7);

				JLabel emailLabel = new JLabel();
				emailLabel.setText(person.getEmailAddress());
				GridBagConstraints gbc_emailLabel = new GridBagConstraints();
				gbc_emailLabel.insets = new Insets(0, 0, 0, 15);
				gbc_emailLabel.anchor = GridBagConstraints.WEST;
				gbc_emailLabel.gridx = 1;
				gbc_emailLabel.gridy = 7;
				viewPane.add(emailLabel, gbc_emailLabel);
			}
			if(person instanceof FamilyContact)
			{
				JLabel label_8 = new JLabel("Relationship");
				label_8.setHorizontalAlignment(SwingConstants.CENTER);
				label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label_8 = new GridBagConstraints();
				gbc_label_8.insets = new Insets(0, 0, 0, 5);
				gbc_label_8.gridx = 0;
				gbc_label_8.gridy = 8;
				viewPane.add(label_8, gbc_label_8);
				
				JLabel relationshipLabel = new JLabel();
				relationshipLabel.setText(((FamilyContact) person).getRelationship());
				GridBagConstraints gbc_relationshipLabel = new GridBagConstraints();
				gbc_relationshipLabel.insets = new Insets(0, 0, 0, 15);
				gbc_relationshipLabel.anchor = GridBagConstraints.WEST;
				gbc_relationshipLabel.gridx = 1;
				gbc_relationshipLabel.gridy = 8;
				viewPane.add(relationshipLabel, gbc_relationshipLabel);
			}
			if(person instanceof FriendContact)
			{
				JLabel label_9 = new JLabel("Birthday");
				label_9.setHorizontalAlignment(SwingConstants.CENTER);
				label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label_9 = new GridBagConstraints();
				gbc_label_9.insets = new Insets(0, 0, 0, 5);
				gbc_label_9.gridx = 0;
				gbc_label_9.gridy = 8;
				viewPane.add(label_9, gbc_label_9);

				JLabel birthdayLabel = new JLabel();
				birthdayLabel.setText(((FriendContact) person).getBirthday());
				GridBagConstraints gbc_birthdayLabel = new GridBagConstraints();
				gbc_birthdayLabel.insets = new Insets(0, 0, 0, 15);
				gbc_birthdayLabel.anchor = GridBagConstraints.WEST;
				gbc_birthdayLabel.gridx = 1;
				gbc_birthdayLabel.gridy = 8;
				viewPane.add(birthdayLabel, gbc_birthdayLabel);
			}
			if(person instanceof BusinessContact)
			{
				JLabel label_10 = new JLabel("Company");
				label_10.setHorizontalAlignment(SwingConstants.CENTER);
				label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
				GridBagConstraints gbc_label_10 = new GridBagConstraints();
				gbc_label_10.gridx = 0;
				gbc_label_10.gridy = 8;
				viewPane.add(label_10, gbc_label_10);

				JLabel companyLabel = new JLabel();
				companyLabel.setText(((BusinessContact) person).getCompany());
				GridBagConstraints gbc_companyLabel = new GridBagConstraints();
				gbc_companyLabel.insets = new Insets(0, 0, 0, 15);
				gbc_companyLabel.anchor = GridBagConstraints.WEST;
				gbc_companyLabel.gridx = 1;
				gbc_companyLabel.gridy = 8;
				viewPane.add(companyLabel, gbc_companyLabel);
			}
		}
		catch(IndexOutOfBoundsException indexOutOfBoundsException)
		{
			JOptionPane.showMessageDialog(null, "Contact Not Found, Please enter both First and Last name", "Contact Not Found", JOptionPane.ERROR_MESSAGE);
		}
	}
}
