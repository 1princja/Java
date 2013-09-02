/**
 * Project: Assignment 3b - Stack Implementations
 * Authors: Anthony Browness, Jake Brinkerhoff
 */

import junit.framework.TestCase;

public class StackTest extends TestCase
{
	private ArrayStack shapesArray;
	private LinkedStack shapesLinked;
	Circle c1;
	Circle c2;
	Circle c3;
	Circle c4;
	
	
	public void setUp()
	{
		shapesArray = new ArrayStack();
		shapesLinked = new LinkedStack();
		c1 = new Circle(1);
		c2 = new Circle(2);
		c3 = new Circle(3);
		c4 = new Circle(4);
	}
	
	public void test_array_default_constructor()
	{
		shapesArray = new ArrayStack();
		int capacity = shapesArray.getCapacity();
		int size = shapesArray.size();

		assertEquals(10, capacity);
		assertEquals(0, size);
	}
	
	public void test_array_paramterized_constructor()
	{
		shapesArray = new ArrayStack(15);
		int capacity = shapesArray.getCapacity();
		int size = shapesArray.size();

		assertEquals(15, capacity);
		assertEquals(0, size);
	}
	
	public void test_array_push()
	{
		shapesArray.push(c1);
		shapesArray.push(c2);
		shapesArray.push(c3);
		shapesArray.push(c4);
		int size = shapesArray.size();
		assertEquals(4, size);
	}

	public void test_array_peek()
	{
		shapesArray.push(c1);
		shapesArray.push(c2);
		Circle testCircle = (Circle) shapesArray.peek();
		double rad = testCircle.getRadius();
		assertEquals((double)2, rad);
	}

	public void test_array_pop()
	{
		shapesArray.push(c1);
		shapesArray.push(c2);
		shapesArray.pop();
		Circle testCircle = (Circle) shapesArray.peek();
		double rad = testCircle.getRadius();
		assertEquals((double)1, rad);

		int size = shapesArray.size();
		assertEquals(1, size);
	}

	public void test_array_pop_returns_element()
	{
		shapesArray.push(c1);
		shapesArray.push(c2);
		Circle testCircle = (Circle) shapesArray.pop();
		double rad = testCircle.getRadius();
		assertEquals(2.0, rad);
	}
	
	public void test_array_clear()
	{
		shapesArray.push(c1);
		shapesArray.push(c2);
		shapesArray.push(c3);
		shapesArray.push(c4);
		int size = shapesArray.size();
		assertEquals(4, size);
		
		shapesArray.clear();
		size = shapesArray.size();
		assertEquals(0, size);
	}

	public void test_array_check_capacity()
	{
		shapesArray = new ArrayStack(2);
		int capacity = shapesArray.getCapacity();
		assertEquals(2, capacity);
		shapesArray.push(c1);
		shapesArray.push(c2);
		shapesArray.push(c3);
		capacity = shapesArray.getCapacity();
		assertEquals(3, capacity);
	}
	
	public void test_linked_constructor()
	{
		shapesLinked = new LinkedStack();
		int size = shapesLinked.size();
		assertEquals(0, size);
	}

	public void test_linked_push()
	{
		shapesLinked.push(c1);
		shapesLinked.push(c2);
		shapesLinked.push(c3);
		shapesLinked.push(c4);
		int size = shapesLinked.size();
		assertEquals(4, size);
		
	}
	
	public void test_linked_peek()
	{
		shapesLinked.push(c1);
		shapesLinked.push(c2);
		shapesLinked.push(c3);
		Circle tempCircle = (Circle) shapesLinked.peek();
		double rad = tempCircle.getRadius();
		assertEquals((double)3, rad);
	}

	public void test_linked_pop()
	{
		shapesLinked.push(c1);
		shapesLinked.push(c2);
		shapesLinked.pop();
		Circle testCircle = (Circle) shapesLinked.peek();
		double rad = testCircle.getRadius();
		assertEquals((double)1, rad);

		int size = shapesLinked.size();
		assertEquals(1, size);
	}

	public void test_linked_pop_returns_element()
	{
		shapesLinked.push(c1);
		shapesLinked.push(c2);
		Circle testCircle = (Circle) shapesLinked.pop();
		double rad = testCircle.getRadius();
		assertEquals(2.0, rad);
	}

	public void test_linked_clear()
	{
		shapesLinked.push(c1);
		shapesLinked.push(c2);
		shapesLinked.push(c3);
		shapesLinked.push(c4);
		int size = shapesLinked.size();
		assertEquals(4, size);
		
		shapesLinked.clear();
		size = shapesLinked.size();
		assertEquals(0, size);
	}

}
