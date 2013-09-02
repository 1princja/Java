/********************************************************
*  Project :  Assignment 05 - Basic Linked Collection
*  File    :  BasicLinkedCollectionTest.java
*  Name    :  Anthony Browness
*  Date    :  6/19/2013
*
*  Description : 
*
*    1) Test class for the BasicLinkedCollection Class, Demonstrates the capabilities of the
*    	BasicLinkedCollection using the Abstract Shape class and two of its concrete classes: Circle
*    	and Rectangle.
*     
*    2) N/A
*
*    3) N/A
*
*    4) Main
*
*  Changes : N/A
********************************************************/
public class BasicLinkedCollectionTest 
{

	 /****************************************************
     * Method     : main
     *
     * Purpose    : Launch the program, Demonstrate the capabilities of the BasicLinkedCollection
     * 				Class.
     *
     * Parameters : @param args
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public static void main(String[] args) 
	{
		System.out.println("Demonstrate default constructor: ");
		System.out.println(" Instantiate Collections, collection1(Circle), collection2(Rectangle)");
		BasicLinkedCollection<Circle> collection1 = new BasicLinkedCollection();
		BasicLinkedCollection<Rectangle> collection2 = new BasicLinkedCollection();

		System.out.println("");
		System.out.println("Instantiate 3 circle objects: c1, c2, c3");
		Circle c1 = new Circle(1);
		Circle c2 = new Circle(2);
		Circle c3 = new Circle(3);

		System.out.println("");
		System.out.println("Demonstrate add() method");
		System.out.println(" adding c1 to collection1(circle)");
		collection1.add(c1);
		System.out.println(" adding c2 to collection1(circle)");
		collection1.add(c2);
		System.out.println(" adding c3 to collection1(circle)");
		collection1.add(c3);

		System.out.println("");
		System.out.println("Demonstrate overloaded constructor");
		System.out.println(" instantiate collection3(Shape) with argument collection1(circle)");
		BasicLinkedCollection<Shape> collection3 = new BasicLinkedCollection(collection1);
		System.out.println(" collection1 size: " + collection1.size());
		System.out.println(" collection3 size: " + collection3.size());

		System.out.println("");
		System.out.println("Instantiate 3 rectangle objects: r1, r2, r3");
		Rectangle r1 =  new Rectangle(1, 1);
		Rectangle r2 =  new Rectangle(2, 2);
		Rectangle r3 =  new Rectangle(3, 3);

		System.out.println(" adding r1 to collection2(rectangle)");
		collection2.add(r1);
		System.out.println(" adding r2 to collection2(rectangle)");
		collection2.add(r2);
		System.out.println(" adding r3 to collection2(rectangle)");
		collection2.add(r3);

		System.out.println("");
		System.out.println("Demonstrate addAll() method");
		System.out.println(" adding collection2(rectangle) to collection3(shape)");
		collection3.addAll(collection2);
		System.out.println(" collection3 size: " + collection3.size());

		System.out.println("");
		System.out.println("Demonstrate remove() method");
		System.out.println(" removing r1 from collection3(shape)");
		collection3.remove(r1);
		System.out.println(" collection3 size: " + collection3.size());
		
		System.out.println("");
		System.out.println("Demonstrate removeAll() method");
		System.out.println(" removing all collection1(circle) from collection3(shape)");
		collection3.removeAll(collection1);
		System.out.println(" collection3 size: " + collection3.size());
	}
}
