/********************************************************
*  Project :  Assignment 05 - Basic Linked Collection
*  File    :  BasicLinkedCollection.java
*  Name    :  Anthony Browness
*  Date    :  6/19/2013
*
*  Description : 
*
*    1) Creates a collection using the SinglyLinkedList as a backing store.
*     
*    2) N/A
*
*    3) N/A
*
*    4) Default Constructor, Constructor, add, addAll, remove, removeAll, find, iterator, size.
*
*  Changes : N/A
********************************************************/
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class BasicLinkedCollection<E> extends AbstractCollection<E> 
{

	private SinglyLinkedList<E> collection = new SinglyLinkedList();
	protected transient int modCount;

	/****************************************************
	* Method     : BasicLinkedCollection (Default Constructor)
	*
	* Purpose    : Construct a default BasicLinkedCollection 
	* 			   and initialize the modifications tracker to 0.
	*
	* Parameters : This method does not require parameters.
	*
	* Returns    : This method does not return a value.
	*
	****************************************************/
	public BasicLinkedCollection() 
	{
		collection = new SinglyLinkedList();
		modCount = 0;
	}

	/****************************************************
	* Method     : BasicLinkedCollection (Overloaded Constructor)
	*
	* Purpose    : Construct a BasicLinkedCollection using another collection
	* 			   and initialize the modifications tracker to 0.  Uses the addAll
	* 			   method 
	*
	* Parameters : @param c the collection whose elements are to be placed
    *       	   into this collection.
	*
	* Exceptions:  @throws IllegalArgumentException - if <code>c</code>
    *              is <code>null</code>
	*
	* Returns    : This method does not return a value.
	*
	****************************************************/
	public BasicLinkedCollection( Collection<? extends E> c ) 
	{
		if ( c == null ) 
		{
			throw new java.lang.IllegalArgumentException();
		}
		collection = new SinglyLinkedList();
		modCount = 0;
		addAll(c);
	}

	/****************************************************
	* Method     : add
	*
	* Purpose    : Add an element to the collection 
	*
	* Parameters : @param element the element whose presence in this collection
    *        	   is to be ensured.
	*
	* Exceptions : @throws IllegalArgumentException - if <code>o</code>
    *              is <code>null</code>
	*
	* Returns    : @return <code>true</code> if the collection changed as a
    *  		       result of the call.
	*
	****************************************************/	
	public boolean add( E o ) 
	{
		if ( o == null ) 
		{
			throw new java.lang.IllegalArgumentException();
		}
		collection.add(o);
		modCount++;
		return true;
	}

	/****************************************************
	* Method     : addAll
	*
	* Purpose    : Add a collection of elements into the collection.
	*
	* Parameters : @param c the collection whose elements are to be placed
	* 	           into this collection.
	*
	* Exceptions : @throws IllegalArgumentException - if <code>c</code>
    *              is <code>null</code>
	*
	* Returns    : @return <code>true</code> if the collection changed as a
    *  		       result of the call.
	*
	****************************************************/	
	public boolean addAll(Collection<? extends E> c)
	{
		if ( c == null ) 
		{
			throw new java.lang.IllegalArgumentException();
		}
		int prevSize = collection.getLength();
	
		Iterator iter = c.iterator();
		
		while(iter.hasNext())
		{
			E element = (E) iter.next();
			collection.add(element);
			modCount++;
		}
		if(prevSize + c.size() == collection.getLength())
		{
			return true;
		}
		return false;
	}
 
	/****************************************************
	* Method     : remove
	*
	* Purpose    : Remove the specified object from the collection
	*
	* Parameters : @param <code>o</code> the element to be removed from
    *  			   the collection.
	*
	* Exceptions : @throws IllegalArgumentException - if <code>o</code>
    *              is <code>null</code> or <code>-1</code>
	*
	* Returns    : @return <code>true</code> if this collection changed as a
    *         	   result of the call (this can only be true if there
    *         	   was at least one instance of <code>element</code>
    *         	   in this collection).
    *         
	****************************************************/	
 	public boolean remove( Object o ) 
 	{
 		if ( o == null ) 
 		{
 			throw new IllegalArgumentException();
 		}
  		int loc = find(o);
  		if(loc == -1)
  		{
 			throw new IllegalArgumentException();
  		}
  		E element = collection.getElementAt(loc);
  		if(element.equals(o))
  		{
  			collection.remove(loc);
  			modCount++;
  			return true;
  		}
  		return false;
 	}
   
	/****************************************************
	* Method     : removeAll
	*
	* Purpose    : Removes a collection of elements from the collection.
	*
	* Parameters : @param c the collection whose elements are to be removed
	* 			   from this collection.
	*
	* Exceptions : @throws IllegalArgumentException - if <code>c</code>
    *              is <code>null</code>
	*
	* Returns    : @return <code>true</code> if the collection changed as a
    *  		       result of the call.
	*
	****************************************************/	
 	public boolean removeAll(Collection<?> c)
 	{
 		if ( c == null ) 
		{
			throw new java.lang.IllegalArgumentException();
		}
 		Iterator iter = c.iterator();
 		boolean removed = false;
 		while(iter.hasNext())
 		{
 			Object element = iter.next();
 			removed = remove(element); //returns true from method
 		}
 		return removed;
 	}	
 	
	/****************************************************
	* Method     : iterator
	*
	* Purpose    : Provide an iterator to the collection via the 
	* 			   BasicLinkedIterator Anonymous Inner Class. 
	*
	* Parameters : This method does not require parameters.
	*
	* Returns    :  @return an iterator over the elements contained in
    *         		this collection.
	*
	****************************************************/
 	public Iterator<E> iterator() 
 	{
 		return new BasicLinkedIterator();
 	}

	/****************************************************
	* Method     : find
	*
	* Purpose    : Finds the location of the specified object.
	*
	* Parameters : @param <code>element</code> the element to be found in
    *  			   the collection.
	*
    * Exceptions : @throws IllegalArgumentException - if <code>element</code>
    *              is <code>null</code>
    *  
	* Returns    :  @return the location of the element in the collection. 
	*
	****************************************************/
 	private int find( Object element ) 
 	{
 		for(int i = 0; i < collection.getLength(); i++)
 		{
 			if ( element == null ) 
 			{
 				throw new java.lang.IllegalArgumentException();
 			}
 			E temp = collection.getElementAt(i);
 			if(element.equals(temp))
 			{
 				return i;
 			}
 		}
 		return -1; // failure
 	}
 	
 	/****************************************************
	* Method     : size
	*
	* Purpose    : Returns the size of the BasicLinkedCollection
	*
	* Parameters : This method does not require parameters.
	*
	* Returns    : @return the size of the collection. 
	*
	****************************************************/
 	@Override
	public int size() 
  	{
  		return collection.getLength();
  	}

	/****************************************************
	* Anonymous Inner Class : BasicLinkedIterator
	*
	* Purpose    : Iterate over the BasicLinkedCollection, provides a remove method.
	*
	****************************************************/
 	private class BasicLinkedIterator implements Iterator<E> 
 	{
 		/**
 		* cursor is used to access the next element in the
 		* sequence. In its implementation, cursor is always
 		* the index of the next element to return. So cursor
 		* should be incremented _after_ retrieving the next
 		* element in the sequence.
 		*/
 		private int cursor;

 		/**
 		* Provides fail-fast operation of the iterator. For each
 		* call to an iterator method, expectedModcount should be
 		* equal to the collection's modCount, otherwise an
 		* intervening change (concurrent modification) to the
 		* collection has been made and we cannot guarantee that
 		* the iterator will behave correctly.
 		*/
 		private int expectedModcount;

 		/**
 		* the contract of remove() says that each call to
 		* remove() must have been preceded by a call to next()
 		* (they are paired). So if there has been NO call to
 		* next() prior to a remove() or if there were two remove()
 		* calls without an intervening next() call, it is NOT ok
 		* to try to remove an item.
 		*/
 		private boolean okToRemove;

 		/****************************************************
 		* Method     : BasicLinkedIterator (Constructor)
 		*
 		* Purpose    : Constructs the BasicLinkedIterator object and
 		* 			   initializes variables.
 		*
 		* Parameters : This method does not require parameters.
 		*
 		* Returns    : This method does not return a value. 
 		*
 		****************************************************/
 		public BasicLinkedIterator() 
 		{
 			cursor = 0;
 			expectedModcount = modCount;
 			okToRemove = false;
 		}

 		/****************************************************
 		* Method     : hasNext
 		*
 		* Purpose    : Determine if there are more elements in the iteration
 		* 			   sequence.
 		*
 		* Parameters : This method does not require parameters.
 		*
 		* Returns    : @returns boolean <code>true</code> if there are more
 		*              elements in the iteration sequence.
 		*
 		****************************************************/
 		public boolean hasNext() 
 		{
 			return cursor != collection.getLength();
 		}

 		/****************************************************
 		* Method     : next
 		*
 		* Purpose    : Returns the next element in the iteration sequence.
 		* 
 		* Parameters : This method does not require parameters.
 		*
 		* Exceptions : @throws ConcurrentModificationException if this
 		*         	   collection has been modified by a method outside
 		*       	   of this iterator.
 		*        	   @throws NoSuchElementException if hasNext() is false
 		*              
 		* Returns    : @returns Object next element in the iteration sequence
 		*
 		****************************************************/ 		
 		public E next() 
 		{
 			// check for concurrent modification
 			if ( expectedModcount != modCount ) 
 			{
 				throw new java.util.ConcurrentModificationException();
 			}

 			// check that there are more elements in the iterator sequence
 			if ( !hasNext() ) 
 			{
 				throw new java.util.NoSuchElementException();
 			}

 			// indicate that we have met the contract
 			// requirements for remove()
 			okToRemove = true;

 			// there are more elements to retrieve, so
 			// 1. get the element in cursor's position
 			// 2. advance the cursor to the next element
 			E element = collection.getElementAt(cursor);
 			cursor++;
 			return element;
 		}

 		/****************************************************
 		* Method     : remove
 		*
 		* Purpose    : Remove the element returned by the last call to
 		* 			   <code>next()</code>
 		* 
 		* Parameters : This method does not require parameters.
 		*
 		* Exceptions : @throws ConcurrentModificationException if this
 		*         	   collection has been modified by a method
 		*         	   outside of this iterator.
 		* 			   @throws IllegalStateException if there has been no
 		*         	   call to next() for this iteration or if two
 		*        	   calls to remove() have been made with no
 		*        	   intervening call to next().
 		*              
 		* Returns    : This method does not return a value.
 		*
 		****************************************************/ 	
 		public void remove() 
 		{
 			// check for concurrent modification
 			if ( expectedModcount != modCount ) 
 			{
 				throw new java.util.ConcurrentModificationException();
 			}

 			// check that there has been a next() message to
 			// provide an element to remove
 			if ( !okToRemove ) 
 			{
 				throw new IllegalStateException();
 			}

 			okToRemove = false;

 			// Use BasicCollection's remove() method to do the
 			// actual removal. Need to predecrement cursor to
 			// get to the LAST element returned by next(). After
 			// the removal, this will be the value cursor should
 			// have for the next call to next().
 			--cursor;
 			BasicLinkedCollection.this.remove( collection.remove(cursor) );

 			// increment expectedModcount since the remove()
 			// message above to the collection object will
 			// have incremented modCount
 			expectedModcount++;
 		}
 	}
}
