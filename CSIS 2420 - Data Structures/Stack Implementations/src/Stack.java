/**
 * CSIS2420
 * Generic stack interface
 */

public interface Stack<E>
{
  /**
   * Examine the top element of the stack.
   * @return topmost element of the stack
   * @throws EmptyStackException if the stack is empty
   */
  public E peek(); 

  /**
   * pop the top element from the stack and return it.
   * @return topmost element of the stack
   * @throws EmptyStackException if the stack is empty
   */
  public E pop();
  
  /**
   * Push element on top of the stack.
   * @param element the element to be pushed on the stack.
   * @throws FullStackException if the stack is full
   */
  public void push( E element );
  
  /**
   * Clear (empty) the stack.
   * @throws EmptyStackException if the stack is empty
   */
  public void clear();

	/**
   * Get the number of elements stored in the stack.
   * @return the number of elements stored in the stack
   */
  public int size();
  
}