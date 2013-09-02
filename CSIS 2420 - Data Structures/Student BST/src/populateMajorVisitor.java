import java.util.List;
import java.util.ArrayList;

import javax.swing.JComboBox;

/**
 * A Visitor class for converting a tree into a searched <tt>List</tt> from
 * the provided major.
 *
 * The order in which the elements of the tree are placed
 * in the list is determined by the tree traversal used. This
 * class implements the Visitor Design Pattern.
 */
public class populateMajorVisitor<E extends Comparable<? super E>>
    implements Visitor<E> 
{
	// The list type is mandated by the type stored in each
	// BSTNode, which is <Comparable<? super E>
	private ArrayList<E> list;
	private String major;
	
	/**
	 * Create an empty list into which <tt>visit</tt> will
	 * append the tree's elements.
	 * @param major the major to find
	 */
	public populateMajorVisitor(String major) 
	{
		this.major = major.replaceAll("\\s","");
		list = new ArrayList<E>();
	}

	/**
	 * Return the list of elements.
	 * @return A list of the elements from a tree.
	 */
	public ArrayList<E> list() 
	{
		return this.list;
	}

	/**
	 * Appends the specified node element to the end of the list.
	 * @param node the node from the BST we are visiting
	 */
	public void visit( BSTNode<E> node ) 
	{
		Student person = (Student) node.element;
		System.out.println(person.getMajor());
		if(this.major.equalsIgnoreCase(person.getMajor()))
		{
			list.add((E)person);
		}
	}
}
