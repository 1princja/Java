package demo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AboutCS1410 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutCS1410 dialog = new AboutCS1410();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutCS1410() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(AboutCS1410.class.getResource("/images/quiz4.JPG")));
			lblNewLabel.setBounds(32, 11, 392, 101);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblLittleFellerIcon = new JLabel("little feller icon");
			lblLittleFellerIcon.setIcon(new ImageIcon("C:\\Users\\Demos\\Desktop\\Umlet\\img\\umlet_logo.png"));
			lblLittleFellerIcon.setBounds(42, 123, 201, 137);
			contentPanel.add(lblLittleFellerIcon);
		}
		{
			JLabel lblWelcomeToCs = new JLabel("Welcome to CS1410");
			lblWelcomeToCs.setBounds(231, 169, 172, 36);
			contentPanel.add(lblWelcomeToCs);
		}
	}

}
