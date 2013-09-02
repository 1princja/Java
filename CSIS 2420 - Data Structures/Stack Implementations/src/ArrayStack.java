/**
 * Project: Assignment 3b - Stack Implementations
 * Authors: Anthony Browness, Jake Brinkerhoff
 */


public class ArrayStack<E> implements Stack<E>{
	
	private E[] elements;
	private final static int DEFAULT_CAP = 10;
	private int capacity;
	private int size;
	
	public ArrayStack() {
		this(DEFAULT_CAP);
		//elements = (E[]) new Object[DEFAULT_CAP];
		//capacity = DEFAULT_CAP;
	}

	public ArrayStack(int cap){
		elements = (E[]) new Object[cap];
		capacity = cap;
	}
	
	@Override
	public E peek() {
		E element = elements[size -1];
		return element;
	}

	@Override
	public E pop() 
	{
		E element = elements[size -1];
		elements[size -1] = null;
		size--;
		return element;
	}

	@Override
	public void push(Object element) 
	{
		checkCapacity();
		elements[size] = (E) element;
		size++;
	}

	public void checkCapacity()
	{
		if(size >= capacity)
		{
			int newCap = (capacity/2) + capacity;
			E[] newElements = (E[]) new Object[newCap];
			for(int i = 0; i < size; i++)
			{
				newElements[i] = elements[i];
			}
			elements = newElements;
			capacity = newCap;
		}
	}
	
	@Override
	public void clear() {
		int tempSize = size;
		for(int i = 0; i < tempSize; i++)
		{
			elements[i] = null;
			size--;
		}
	}

	@Override
	public int size() {
		return size;
	}
	
	public int getCapacity(){
		return capacity;
	}
}