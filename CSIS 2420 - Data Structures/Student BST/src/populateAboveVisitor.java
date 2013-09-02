import java.util.List;
import java.util.ArrayList;

import javax.swing.JComboBox;

/**
 * A Visitor class for converting a tree into a <tt>List</tt> by any GPA above
 * or equal to the specified value.
 *
 * The order in which the elements of the tree are placed
 * in the list is determined by the tree traversal used. This
 *  class implements the Visitor Design Pattern.
 */
public class populateAboveVisitor<E extends Comparable<? super E>>
    implements Visitor<E> 
{
	// The list type is mandated by the type stored in each
	// BSTNode, which is <Comparable<? super E>
	private ArrayList<E> list;
	private double above;
	
	/**
	 * Create an empty list into which <tt>visit</tt> will
	 * append the tree's elements.
	 * @param above the value to search above
	 */
	public populateAboveVisitor(double above) 
	{
		this.above = above;
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
		if(person.getGpa() >= this.above)
		{
			list.add((E)person);
		}	
	}
}
