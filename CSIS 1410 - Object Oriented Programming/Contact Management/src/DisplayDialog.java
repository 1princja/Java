import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;

/**
 * Creates a JDialog pop-up window to view all contacts
 * @author Anthony Browness
 */
public class DisplayDialog extends JDialog {

	private static JPanel contentPanel = new JPanel();
	private static GridBagLayout gbl_contentPanel = new GridBagLayout();

	private static DisplayDialog dialog = new DisplayDialog();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DisplayDialog() {
		setBounds(100, 100, 1106, 386);
		getContentPane().setLayout(new BorderLayout());
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel lblFirst = new JLabel("First");
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblFirst = new GridBagConstraints();
		gbc_lblFirst.anchor = GridBagConstraints.WEST;
		gbc_lblFirst.insets = new Insets(0, 0, 5, 15);
		gbc_lblFirst.gridx = 0;
		gbc_lblFirst.gridy = 0;
		contentPanel.add(lblFirst, gbc_lblFirst);
		
		JLabel lblLast = new JLabel("Last");
		lblLast.setHorizontalAlignment(SwingConstants.CENTER);
		lblLast.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblLast = new GridBagConstraints();
		gbc_lblLast.anchor = GridBagConstraints.WEST;
		gbc_lblLast.insets = new Insets(0, 0, 5, 15);
		gbc_lblLast.gridx = 1;
		gbc_lblLast.gridy = 0;
		contentPanel.add(lblLast, gbc_lblLast);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 15);
		gbc_lblAddress.gridx = 2;
		gbc_lblAddress.gridy = 0;
		contentPanel.add(lblAddress, gbc_lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.WEST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 15);
		gbc_lblCity.gridx = 3;
		gbc_lblCity.gridy = 0;
		contentPanel.add(lblCity, gbc_lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.anchor = GridBagConstraints.WEST;
		gbc_lblState.insets = new Insets(0, 0, 5, 15);
		gbc_lblState.gridx = 4;
		gbc_lblState.gridy = 0;
		contentPanel.add(lblState, gbc_lblState);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblZipCode = new GridBagConstraints();
		gbc_lblZipCode.anchor = GridBagConstraints.WEST;
		gbc_lblZipCode.insets = new Insets(0, 0, 5, 15);
		gbc_lblZipCode.gridx = 5;
		gbc_lblZipCode.gridy = 0;
		contentPanel.add(lblZipCode, gbc_lblZipCode);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 15);
		gbc_lblPhone.gridx = 6;
		gbc_lblPhone.gridy = 0;
		contentPanel.add(lblPhone, gbc_lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 15);
		gbc_lblEmail.gridx = 7;
		gbc_lblEmail.gridy = 0;
		contentPanel.add(lblEmail, gbc_lblEmail);
		
		JLabel lblRelationship = new JLabel("Relationship");
		lblRelationship.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelationship.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblRelationship = new GridBagConstraints();
		gbc_lblRelationship.anchor = GridBagConstraints.WEST;
		gbc_lblRelationship.insets = new Insets(0, 0, 5, 15);
		gbc_lblRelationship.gridx = 8;
		gbc_lblRelationship.gridy = 0;
		contentPanel.add(lblRelationship, gbc_lblRelationship);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.WEST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 15);
		gbc_lblBirthday.gridx = 9;
		gbc_lblBirthday.gridy = 0;
		contentPanel.add(lblBirthday, gbc_lblBirthday);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompany.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.anchor = GridBagConstraints.WEST;
		gbc_lblCompany.insets = new Insets(0, 0, 5, 15);
		gbc_lblCompany.gridx = 10;
		gbc_lblCompany.gridy = 0;
		contentPanel.add(lblCompany, gbc_lblCompany);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener
				(
					new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							dispose();
						}
					}
				);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * adds a single contact to the display list for each element in the ArrayList
	 * @param contacts ArrayList of contacts stored in memory
	 */
	public static void displayContacts(ArrayList<Contact> contacts)
	{
		int y = 1;
		contacts.trimToSize();

		JLabel blankLabel = new JLabel();
		blankLabel.setText(" ");
		GridBagConstraints gbc_blankLabel = new GridBagConstraints();
		gbc_blankLabel.insets = new Insets(0, 0, 5, 15);

		
		for(Contact person : contacts)
		{
			if(person instanceof Contact)
			{
				JLabel firstLabel = new JLabel();
				firstLabel.setText(person.getFirstName());
				GridBagConstraints gbc_firstLabel = new GridBagConstraints();
				gbc_firstLabel.insets = new Insets(0, 0, 0, 15);
				gbc_firstLabel.anchor = GridBagConstraints.WEST;
				gbc_firstLabel.gridx = 0;
				gbc_firstLabel.gridy = y;
				contentPanel.add(firstLabel, gbc_firstLabel);

				JLabel lastLabel = new JLabel();
				lastLabel.setText(person.getLastName());
				GridBagConstraints gbc_lastLabel = new GridBagConstraints();
				gbc_lastLabel.insets = new Insets(0, 0, 0, 15);
				gbc_lastLabel.anchor = GridBagConstraints.WEST;
				gbc_lastLabel.gridx = 1;
				gbc_lastLabel.gridy = y;
				contentPanel.add(lastLabel, gbc_lastLabel);

				JLabel addressLabel = new JLabel();
				addressLabel.setText(person.getAddress());
				GridBagConstraints gbc_addressLabel = new GridBagConstraints();
				gbc_addressLabel.insets = new Insets(0, 0, 0, 15);
				gbc_addressLabel.anchor = GridBagConstraints.WEST;
				gbc_addressLabel.gridx = 2;
				gbc_addressLabel.gridy = y;
				contentPanel.add(addressLabel, gbc_addressLabel);
				
				JLabel cityLabel = new JLabel();
				cityLabel.setText(person.getCity());
				GridBagConstraints gbc_cityLabel = new GridBagConstraints();
				gbc_cityLabel.insets = new Insets(0, 0, 0, 15);
				gbc_cityLabel.anchor = GridBagConstraints.WEST;
				gbc_cityLabel.gridx = 3;
				gbc_cityLabel.gridy = y;
				contentPanel.add(cityLabel, gbc_cityLabel);

				JLabel stateLabel = new JLabel();
				stateLabel.setText(person.getState());
				GridBagConstraints gbc_stateLabel = new GridBagConstraints();
				gbc_stateLabel.insets = new Insets(0, 0, 0, 15);
				gbc_stateLabel.anchor = GridBagConstraints.WEST;
				gbc_stateLabel.gridx = 4;
				gbc_stateLabel.gridy = y;
				contentPanel.add(stateLabel, gbc_stateLabel);

				JLabel zipLabel = new JLabel();
				zipLabel.setText(person.getZipCode());
				GridBagConstraints gbc_zipLabel = new GridBagConstraints();
				gbc_zipLabel.insets = new Insets(0, 0, 0, 15);
				gbc_zipLabel.anchor = GridBagConstraints.WEST;
				gbc_zipLabel.gridx = 5;
				gbc_zipLabel.gridy = y;
				contentPanel.add(zipLabel, gbc_zipLabel);

				JLabel phoneLabel = new JLabel();
				phoneLabel.setText(person.getPhoneNumber());
				GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
				gbc_phoneLabel.insets = new Insets(0, 0, 0, 15);
				gbc_phoneLabel.anchor = GridBagConstraints.WEST;
				gbc_phoneLabel.gridx = 6;
				gbc_phoneLabel.gridy = y;
				contentPanel.add(phoneLabel, gbc_phoneLabel);

				JLabel emailLabel = new JLabel();
				emailLabel.setText(person.getEmailAddress());
				GridBagConstraints gbc_emailLabel = new GridBagConstraints();
				gbc_emailLabel.insets = new Insets(0, 0, 0, 15);
				gbc_emailLabel.anchor = GridBagConstraints.WEST;
				gbc_emailLabel.gridx = 7;
				gbc_emailLabel.gridy = y;
				contentPanel.add(emailLabel, gbc_emailLabel);
			}
			if(person instanceof FamilyContact)
			{
				JLabel relationshipLabel = new JLabel();
				relationshipLabel.setText(((FamilyContact) person).getRelationship());
				GridBagConstraints gbc_relationshipLabel = new GridBagConstraints();
				gbc_relationshipLabel.insets = new Insets(0, 0, 0, 15);
				gbc_relationshipLabel.anchor = GridBagConstraints.WEST;
				gbc_relationshipLabel.gridx = 8;
				gbc_relationshipLabel.gridy = y;
				contentPanel.add(relationshipLabel, gbc_relationshipLabel);
				
				gbc_blankLabel.gridx = 9;
				gbc_blankLabel.gridy = y;
				contentPanel.add(blankLabel, gbc_blankLabel);
				
				gbc_blankLabel.gridx = 10;
				gbc_blankLabel.gridy = y;
				contentPanel.add(blankLabel, gbc_blankLabel);
			}
			if(person instanceof FriendContact)
			{
				gbc_blankLabel.gridx = 8;
				gbc_blankLabel.gridy = y;
				contentPanel.add(blankLabel, gbc_blankLabel);
				
				JLabel birthdayLabel = new JLabel();
				birthdayLabel.setText(((FriendContact) person).getBirthday());
				GridBagConstraints gbc_birthdayLabel = new GridBagConstraints();
				gbc_birthdayLabel.insets = new Insets(0, 0, 0, 15);
				gbc_birthdayLabel.anchor = GridBagConstraints.WEST;
				gbc_birthdayLabel.gridx = 9;
				gbc_birthdayLabel.gridy = y;
				contentPanel.add(birthdayLabel, gbc_birthdayLabel);

				gbc_blankLabel.gridx = 10;
				gbc_blankLabel.gridy = y;
				contentPanel.add(blankLabel, gbc_blankLabel);
			}
			if(person instanceof BusinessContact)
			{
				gbc_blankLabel.gridx = 8;
				gbc_blankLabel.gridy = y;
				contentPanel.add(blankLabel, gbc_blankLabel);

				gbc_blankLabel.gridx = 9;
				gbc_blankLabel.gridy = y;
				contentPanel.add(blankLabel, gbc_blankLabel);

				JLabel companyLabel = new JLabel();
				companyLabel.setText(((BusinessContact) person).getCompany());
				GridBagConstraints gbc_companyLabel = new GridBagConstraints();
				gbc_companyLabel.insets = new Insets(0, 0, 0, 15);
				gbc_companyLabel.anchor = GridBagConstraints.WEST;
				gbc_companyLabel.gridx = 10;
				gbc_companyLabel.gridy = y;
				contentPanel.add(companyLabel, gbc_companyLabel);
			}
			y++;
		}
	}
}
