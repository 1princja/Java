import javax.swing.JFrame;

public class BusinessContactMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BusinessContactFrame contactsFrame = new BusinessContactFrame();
		contactsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contactsFrame.setSize(800,300);
//		contactsFrame.pack();
		contactsFrame.setVisible(true);
	}

}
