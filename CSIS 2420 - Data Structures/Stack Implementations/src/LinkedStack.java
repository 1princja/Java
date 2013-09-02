/**
 * Project: Assignment 3b - Stack Implementations
 * Authors: Anthony Browness, Jake Brinkerhoff
 */

import java.lang.annotation.Target;

public class LinkedStack<E> implements Stack<E>{
	private int length; // # elements in the linked list
	private StackNode<E> head; // access point to the linked list
	private StackNode<E> tail;

	public LinkedStack() {
		this.length = 0;
		this.tail = new StackNode<E> (); // the tail dummy node
		this.head = new StackNode<E> ( null, this.tail ); // the head dummy node
	}

	public int getLength() {
		return this.length;
	}

	public void push( E element ) {
		StackNode<E> newnode = new StackNode<E> ( element, null );
		newnode.setSuccessor( this.head.getSuccessor() );
		this.head.setSuccessor( newnode );
		this.length++;
	}

	@Override
	public E pop() 
	{
	    StackNode<E> target = head.getSuccessor(); // get the node to remove
		E element = target.getElement(); //get target element
	    // link target to cursor's successor
	    head.setSuccessor( target.getSuccessor() );
		target.setElement( null);
	    target.setSuccessor( null );
	    this.length--;
	    return element;
  }
	
	@Override
	public E peek() 
	{
	    StackNode<E> node = head.getSuccessor();
	    return node.getElement();
	}
	
	@Override
	public void clear() 
	{
		int tempLength = length;
		for(int i = 0; i < tempLength; i++)
		{
			StackNode<E> target = head.getSuccessor();
			target.setElement(null);
			StackNode<E> next = target.getSuccessor();
			target.setSuccessor(null);
			head.setSuccessor(next);
			length--;
		}
	}
	
	@Override
	public int size() 
	{
		return length;
	}
}
