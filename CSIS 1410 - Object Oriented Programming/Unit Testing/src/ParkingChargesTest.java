import junit.framework.TestCase; 

public class ParkingChargesTest extends TestCase {
	ParkingCharges test = new ParkingCharges();
	
	/****************************************************
	* Method     : test_if_calc_returns_min_less
	*
	* Purpose    : test if the program returns $2.00 for just under 3 hours parked
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_returns_min_less()
	{
		double amount = test.calculateCharges(2.9);
		assertEquals(amount, 2.00);
	}
	
	/****************************************************
	* Method     : test_if_calc_returns_min_exact
	*
	* Purpose    : test if the program returns $2.00 for exactly 3 hours parked
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_returns_min_exact()
	{
		double amount = test.calculateCharges(3.0);
		assertEquals(amount, 2.00);
	}
	
	/****************************************************
	* Method     : test_if_calc_returns_min_greater
	*
	* Purpose    : test if the program returns more than $2.00 for any time over 3 hours parked
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_returns_min_greater()
	{
		double amount = test.calculateCharges(3.1);
		boolean test = false;
		if(amount > 2.00)
		{
			test = true;
		}
		assertTrue(test);
	}
	
	/****************************************************
	* Method     : test_if_calc_rounds_up_returns_charge
	*
	* Purpose    : test if the program returns $2.00 for exactly 3 hours parked
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_rounds_up_returns_charge()
	{
		double amount = test.calculateCharges(3.1);
		assertEquals(amount, 2.50);
	}	

	/****************************************************
	* Method     : test_if_calc_rounds_up_more_returns_charge
	*
	* Purpose    : test if the program returns $2.50 for slightly more than 3 hours parked
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_rounds_up_more_returns_charge()
	{
		double amount = test.calculateCharges(3.6);
		assertEquals(amount, 2.50);
	}
	
	/****************************************************
	* Method     : test_if_calc_gets_max_charge_false
	*
	* Purpose    : test if the program returns $9.50 for 18 hours parked
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_gets_max_charge_false()
	{
		double amount = test.calculateCharges(18.0);
		assertEquals(amount, 9.50);
	}

	/****************************************************
	* Method     : test_if_calc_gets_max_charge_true
	*
	* Purpose    : test if the program returns $10.00 for over 18 hours parked
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_gets_max_charge_true()
	{
		double amount = test.calculateCharges(18.1);
		assertEquals(amount, 10.00);
	}
	
	/****************************************************
	* Method     : test_if_calc_gets_max_charge_min
	*
	* Purpose    : test if the program returns $10.00 for 19 hours parked
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_gets_max_charge_min()
	{
		double amount = test.calculateCharges(19.0);
		assertEquals(amount, 10.00);
	}
	
	/****************************************************
	* Method     : test_if_calc_gets_max_charge_rounds
	*
	* Purpose    : test if the program returns $10.00 for a rounded number above 19 hours
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_gets_max_charge_rounds()
	{
		double amount = test.calculateCharges(19.1);
		assertEquals(amount, 10.00);
	}
	
	/****************************************************
	* Method     : test_if_calc_gets_max_charge_over24
	*
	* Purpose    : test if the program returns $10.00 for over 24 hours parked
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_gets_max_charge_over24()
	{
		double amount = test.calculateCharges(24.1);
		assertEquals(amount, 10.00);
	}
	
	/****************************************************
	* Method     : test_if_calc_gets_max_charge_exact24
	*
	* Purpose    : test if the program returns $10.00 for exactly 24 hours parked
	* 
	* Parameters : N/A
	*
	* Returns    : quasi-return: Assertion statement generated for test suite					
	****************************************************/	
	public void test_if_calc_gets_max_charge_exact24()
	{
		double amount = test.calculateCharges(24.0);
		assertEquals(amount, 10.00);
	}

}
