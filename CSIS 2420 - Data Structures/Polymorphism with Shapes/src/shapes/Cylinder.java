package shapes;

/********************************************************
*
*  Project :  Assignment 01 - Polymorphism with Shapes 
*  File    :  Cylinder.java
*  Name    :  Anthony Browness
*  Date    :  5/27/2013
*
*  Description : 
*
*    1) Create a Cylinder shape that extends Circle shape implementing interfaces ThreeD and Cloneable.
*
*    2) Single Dimensional Array
*
*    3) Polymorphism via the Shapes abstract class
*
*    4) All methods in Circle shape plus getVolume(), getSurfaceArea(), getDepth(), setDepth(), and
*    	Overiden methods for toString(), and equals().
*
*  Changes : N/A
*
********************************************************/

/**
 * A <tt>Cylinder</tt> has three dimensions: radius(2 Dimensions), and
 * depth.
 */
public final class Cylinder extends Circle
implements Cloneable, ThreeD
{

    private double depth;

    /****************************************************
     * Method     : Cylinder - Default Constructor
     *
     * Purpose    : Construct a <tt>Cylinder</tt> object using the
     * 				default size for its dimensions.
     *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
    public Cylinder() 
    {
    	this(Shape.DEFAULT_SIZE, 
    			Shape.DEFAULT_SIZE);
    }

    /****************************************************
     * Method     : Cylinder - Overloaded Constructor
     *
     * Purpose    : Construct a <tt>Cylinder</tt> object using the
     * 				arguments. If an argument is <= 0, the default size
     * 				specified in <tt>Shape</tt> is used instead.
     *
     * Parameters : @param theRadius radius of this <tt>Cylinder</tt>;
     *         		must be > 0
     * 				@param theDepth depth of this <tt>Cylinder</tt>;
     *        		must be > 0
     * Returns    : This method does not return a value.
     *
     ****************************************************/
    public Cylinder( double theRadius, double theDepth) 
    {
        setShapeName( "Cylinder" );
        if ( theRadius <= 0.0 )
        {
          setRadius( Shape.DEFAULT_SIZE );
        }
        else
        {
          setRadius( theRadius );
        }
        if ( theDepth <= 0.0 )
        {
        	setDepth( Shape.DEFAULT_SIZE );
        }
        else
        {
        	setDepth( theDepth );
        }
    }

    /****************************************************
     * Method     : Cylinder - Overloaded Constructor
     *
     * Purpose    : Construct a <tt>Cylinder</tt> object using the
     * 				arguments. If an argument is <= 0, the default size
     * 				specified in <tt>Shape</tt> is used instead.
     *
     * Parameters : @param theCircle contains radius; cannot be null
     * 				@param theDepth double the depth should be > 0.0
     * 				
     * Exceptions : @throws NullPointerException if <tt>r</tt> is <tt>null</tt>
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
    public Cylinder( Circle theCircle, double theDepth )
    {
    	if ( theCircle == null )
    	{
             throw new NullPointerException();
    	}
        setRadius( theCircle.getRadius() );
        if ( theDepth <= 0.0 )
        {
        	setDepth( Shape.DEFAULT_SIZE );
        }
        else
        {
           setDepth( theDepth );
        }
    }

    /****************************************************
     * Method     : getSurfaceArea
     *
     * Purpose    : Get the surface area of this <tt>Cylinder</tt>.
     * 				Overridden method inherited from Circle.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return the surface area of this <tt>Cylinder</tt>
     *
     ****************************************************/
    @Override
    public double getSurfaceArea() 
    {
        return super.getSurfaceArea() * 2 
        		+ 2* Math.PI * super.getRadius() * this.getDepth(); 
    }

    /****************************************************
     * Method     : getPerimeter
     *
     * Purpose    : Get the perimeter of this <tt>Cylinder</tt>.
     * 				Overridden method inherited from Circle.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    :  @return the perimeter of this <tt>Cylinder</tt>
     *
     ****************************************************/
    @Override
    public double getPerimeter() 
    {
        return 2 * super.getPerimeter() + (getDepth() * 2);
    }

    /* methods unique to Cylinder */

    /****************************************************
     * Method     : getVolume
     *
     * Purpose    : Get the Volume of this <tt>Cylinder</tt>.
     * 				Implemented via the ThreeD interface
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return the volume of this <tt>Cylinder</tt>
     *
     ****************************************************/
    public double getVolume() 
    {
        return this.depth * (getRadius() * 2);
    }

    /****************************************************
     * Method     : toString
     *
     * Purpose    : Returns a <tt>String</tt> object representing this
     * 				<tt>Cylinder</tt>'s value. 
     * 				Overridden from <tt>Object</tt>.
     * 
     * Parameters : This method does not require parameters.
     *
     * Returns    : @return a string representation of this object
     *
     ****************************************************/
    @Override
    public String toString() 
    {
    	return super.toString() + ", depth = " + getDepth();
    }

    /****************************************************
     * Method     : equals
     *
     * Purpose    : Returns <tt>true</tt> if and only if the argument is not
     * 				<tt>null</tt> and is a <tt>Cylinder</tt> object that
     * 				represents the same cylinder value as this object.
     * 				The comparison is done based on the dimensions radius,
     * 				and depth.
     * 				Overridden from <tt>Object</tt>.
     * 
     * Parameters : @param o the object to compare with
     *
     * Returns    : @return <tt>true</tt> if the <tt>RectangularPrism</tt>
     * 				objects represent the same value; <tt>false</tt> otherwise.
     *
     ****************************************************/
    @Override
    public boolean equals( Object o ) 
    {
       if ( ( o == null ) || ( !( o instanceof Cylinder ) ) )
       {
           return false;
       }
       return super.equals( o ) && ((Cylinder)o).getDepth() == this.getDepth();
    }

    /****************************************************
     * Method     : clone
     *
     * Purpose    : Make a clone of this <tt>Cylinder</tt>. 
     * 				Overridden from <tt>Object</tt>.
     * 
     * Parameters : @param o the object to compare with
     *
     * Returns    : @return Object a copy of this <tt>Cylinder</tt>.
     *
     ****************************************************/
     @Override
    public Object clone() throws java.lang.CloneNotSupportedException 
    {
        return super.clone();
    }

     /****************************************************
      * Method     : getDepth
      *
      * Purpose    : Get the depth of this <tt>Cylinder</tt>.
      * 			 Overridden from <tt>ThreeD</tt>.
      * 
      * Parameters : @param o the object to compare with
      *
      * Returns    : @return the depth of this <tt>RectangularPrism</tt>
      *
      ****************************************************/
	@Override
	public double getDepth() 
	{
		return this.depth;
	}

	 /****************************************************
     * Method     : setDepth
     *
     * Purpose    : Reset the depth of this <tt>RectangularPrism</tt>.
     * 				If <tt>theDepth</tt> is <= 0, the dimension is unchanged.
     * 
     * Parameters : @param theDepth the new depth of this
     *       		 <tt>Cylinder</tt>; 
     *       		must be > 0
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	@Override
	public void setDepth(double theDepth) 
	{
		if ( theDepth <= 0 )
		{
			return;
		}
		this.depth = theDepth;
	}
}
