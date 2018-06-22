package domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import utils.BadParameterException;
import utils.NullParameterException;

public class SalesEmployeeTest {

	SalesEmployee testSE = null;

	@Before
	public void setUp() throws Exception {
		int[] days = {6, 5, 4, 2, 4};
		testSE = new SalesEmployee("Amy", "Edwards", 9355, 15,  days, 400, 450);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSalesEmployee() throws NullParameterException, BadParameterException{
		SalesEmployee testCopy = new SalesEmployee(testSE);
	}
	
	
	@Test
	public void testGetWeeklyPay() {
		testSE.getWeeklyPay();
	}
	
	@Test
	public void testGetWeeklyPaySalesNotMet() throws NullParameterException, BadParameterException {
		int[] days = {6, 5, 4, 2, 4};
		SalesEmployee underAchiever = new SalesEmployee("Too", "Bad", 9999, 15, days, 500, 300);
		testSE.getWeeklyPay();
	} 
	
	@Test
	public void testToString() {
		testSE.toString();
	}
	
	@Test (expected = BadParameterException.class)
	public void testSetSalesAmountNeeded() throws NullParameterException, BadParameterException{
		int[] days = {6, 5, 4, 2, 4};
		SalesEmployee newSE = new SalesEmployee("Too", "Bad", 9999, 15, days, 0, 300);
	}
	
	@Test (expected = BadParameterException.class)
	public void testSetWeeklySalesGoal() throws NullParameterException, BadParameterException{
		int[] days = {6, 5, 4, 2, 4};
		SalesEmployee newSE = new SalesEmployee("Too", "Bad", 9999, 15, days, 300, 0);
	}

}
