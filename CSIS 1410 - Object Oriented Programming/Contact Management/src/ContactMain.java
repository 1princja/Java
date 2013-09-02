import javax.swing.JFrame;
import java.awt.event.*;

/**
 * Runs the program, contains method main 
 * @author Anthony Browness
 */
public class ContactMain {

	public static ContactFrame contactsFrame = new ContactFrame();

	/**
	 * main instantiates the ContactFrame object and sets up the Frame attributes.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		contactsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contactsFrame.setSize(440,480);
//		contactsFrame.pack();
		contactsFrame.setVisible(true);
		contactsFrame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		       contactsFrame.writeContactsSer();
		    }
		});
	}
	
	
}
