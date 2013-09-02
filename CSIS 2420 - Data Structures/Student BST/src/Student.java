/********************************************************
*  Project :  Assignment 10 - Student BST
*  File    :  Student.java
*  Name    :  @author Anthony Browness
*  Date    :  7/24/2013
********************************************************/
import java.io.Serializable;

/**
 * Student class
 * A Comparable class that creates a Student object, implements
 * Serializable 
 */
public class Student implements Comparable<Student>, Serializable{

	private int studentNumber;
	private String lastName;
	private String firstName;
	private String major;
	private double gpa;
	
	/**
	 * Student constructor
	 * Instantiates class variables
	 * @param stuNum
	 * @param last
	 * @param first
	 * @param maj
	 * @param avg
	 */
	public Student(int stuNum, String last, String first, String maj, double avg){
		setStudentNumber(stuNum);
		setLastName(last);
		setFirstName(first);
		setMajor(maj);
		setGpa(avg);
	}
	
	/**
	 * getStudentNumber accessor
	 * Allows access to the studentNumber variable
	 * @return the studentNumber
	 */
	public int getStudentNumber() {
		return studentNumber;
	}

	/**
	 * setStudentNumber mutator
	 * Allows access to the studentNumber variable
	 * @param studentNumber the studentNumber to set
	 */
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	/**
	 * getLastName accessor
	 * Allows access to the lastName variable
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * setLastName mutator
	 * Allows access to the lastName variable
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * getFirstName accessor
	 * Allows access to the firstName variable
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * setFristName mutator
	 * Allows access to the firstName variable
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * getMajor accessor
	 * Allows access to the major variable
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * setMajor mutator
	 * Allows acces to the major variable
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * getGpa accessor
	 * Allows access to the gpa variable
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * setGpa mutator
	 * Allows access to the gpa variable
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * compareTo
	 * Compares two Student objects using the studentNumber
	 * @param other the Student object to compare against
	 * @throws RunTimeException
	 */
	public int compareTo(Student other )
	{
		if( other == null )
			throw new RuntimeException("compareTo() requires valid Student object.");
		
		if( this.studentNumber == other.studentNumber )
			return 0;
		else
			return this.studentNumber < other.studentNumber ? -1 : 1 ;
	}
	
	/**
	 * toString
	 * Provides a string representation of the Student object
	 */
	@Override
	public String toString()
	{
		return String.format("SN: %-6d %-15s Major: %-10s GPA: %3.1f", 
			studentNumber, firstName + " " + lastName, major, gpa );
	}


}
