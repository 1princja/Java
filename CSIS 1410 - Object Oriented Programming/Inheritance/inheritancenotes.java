think of biology and classes or hirearchy

Object -- superclass
	Math				}subclasses
	Scanner
	Student Class
		"is a" inheritance relationship to Object superclass "Inheritance Mechanism"

	specific class EMPLOYEE
		salary
		title
		employee ID
		benefits
		contact info
		name
	
	methods
		calcPay()
		toString()
		
	types
		EMPLOYEE
salary		Commission		Hourly
				rate			hours
				salary			rate

public class CommissionEmployee extends Object (everything automatically extends Object class)
what if you add a BasePlusCommissionEmployee class?
everything is the same but add base salary? so extend the ComissionEmployee class

public class BasePlusComissionEmployee extends ComissionEmployee
and just add the single addition to it.
	CONSTRUCTORS are not inherited.
		so pass the fields held by the extended class called the super class 
		super(first, last, ssn, sales, rate);
		setBaseSalary(salary)
		
		return stuff from super
			super.getSales();
		
SUPER toString method

@Override
public String toString(){
	return Sring.format("yadayada", super.toString());
}

PROTECTED
subclasses can access access protected members AND other classes in the package can access protected.
level of access between public and private

	earnings()
	{
		return baseSalary + super.earnings();
	}

ABSTRACT
can only be called by reference, not instanciated as an object. is an abstraction of traits many specific things have in common
the thing itself does not exist, like mammal, but all mammals have trait "alive", so platypus can use the abstraciton of anaimal to be
built as a specific object.

RECURSION
a method that calls itself, a special type of iteration	
	
		
ILLEGAL EXCEPTIONS, COOL!		
public void setCommissionRate(double rate)
{
	if (rate <= 0)
		commission = rate;
	else 
		throw new IllegalArgumentException("Commission rate must be yadayada")
}					

