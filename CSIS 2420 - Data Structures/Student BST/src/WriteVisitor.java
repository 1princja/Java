import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * A Visitor class for writing the BST to a file.
 *
 * The order in which the elements of the tree are written to
 * file is determined by the tree traversal used. This
 * class implements the Visitor Design Pattern.
 */
public class WriteVisitor<E extends Comparable<? super E>>
    implements Visitor<E> 
{
	
	ObjectOutputStream output = null;

	/**
	 * Opens the output file for writing
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public WriteVisitor() 
	{
		try {
			output = new ObjectOutputStream(new FileOutputStream("students.ser"));
		} 
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "FileNotFoundException", "Please create file students.ser", JOptionPane.ERROR_MESSAGE);
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "IOException", "IO Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Writes the element in the node to file
	 * @param node the node from the BST we are visiting
	 */
	public void visit( BSTNode<E> node ) 
	{
		Student person = (Student) node.element;
		writeStudentsSer(person);
	}
	
	/**
	 * Writes the Student object to file
	 * @param person the Student to be written
	 * @throws IOException
	 */
	public void writeStudentsSer(Student person)
	{
		try
		{
			output.writeObject(person);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "IOException", "IO Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
