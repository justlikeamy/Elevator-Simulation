package domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import utils.BadParameterException;
import utils.NullParameterException;

public class EmployeeTest {
	private Employee testEmployee = null;
	private Employee nullEmployee = null;
	int[] testDays = {5,5,6,5,5};
	

	@Before
	public void setUp() throws Exception {
		testEmployee = new Employee("Jane", "Doe", 1001, 10.25, testDays);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmployeeWithParams() throws NullParameterException, BadParameterException {
		Employee newEmployee = new Employee("John", "Deer", 1001, 10.25, testDays);
	}
	
	public void testEmployee() throws NullParameterException, BadParameterException {
		Employee newEmployee = new Employee("John", "Deer", 1001, 10.25, testDays);
		Employee newEmployeeCopy = new Employee(newEmployee);
	}
	
	@Test
	public void testCompareTo() throws NullParameterException, BadParameterException{
		Employee newEmployee = new Employee("John", "Deer", 1001, 10.25, testDays);
		testEmployee.compareTo(newEmployee);
		
	}
	@Test
	public void testCompareToGreater() throws NullParameterException, BadParameterException{
		Employee newEmployee = new Employee("John", "Deer", 1000, 10.25, testDays);
		testEmployee.compareTo(newEmployee);
		
	}
	
	@Test
	public void testCompareToLess() throws NullParameterException, BadParameterException{
		Employee newEmployee = new Employee("John", "Deer", 1000, 10.25, testDays);
		Employee otherEmployee = new Employee("John", "Deer", 1005, 10.25, testDays);
		
		newEmployee.compareTo(otherEmployee);
		
	}
	
	@Test 
	public void testGetWeeklyPay(){
		testEmployee.getWeeklyPay();
	}
	
	@Test 
	public void testGetLastName(){
		testEmployee.getLastName();
	}
	@Test 
	public void testSetFirstName() throws NullParameterException, BadParameterException{
		testEmployee.setFirstName("Amy");
	}
	
	@Test (expected = NullParameterException.class)
	public void testSetFirstNameNull() throws NullParameterException, BadParameterException{
		testEmployee.setFirstName(null);
	}
	
	@Test (expected = BadParameterException.class)
	public void testSetFirsttNameTooShort() throws NullParameterException, BadParameterException{
		testEmployee.setFirstName("");
	}
	@Test (expected = BadParameterException.class)
	public void testSetFirstNameTooLong() throws NullParameterException, BadParameterException{
		testEmployee.setFirstName("Abcdefghijklmnopqurtuvwyxz");
	}
	
	@Test 
	public void testSetLastName() throws NullParameterException, BadParameterException{
		testEmployee.setLastName("Edwards");
	}
	
	@Test (expected = NullParameterException.class)
	public void testSetLastNameNull() throws NullParameterException, BadParameterException{
		testEmployee.setLastName(null);
	}
	
	@Test (expected = BadParameterException.class)
	public void testSetLastNameTooShort() throws NullParameterException, BadParameterException{
		testEmployee.setLastName("");
	}
	@Test (expected = BadParameterException.class)
	public void testSetLastNameTooLong() throws NullParameterException, BadParameterException{
		testEmployee.setLastName("Abcdefghijklmnopqurtuvwyxz");
	}
	
	@Test 
	public void testSetEmployeeId() throws BadParameterException {
		testEmployee.setEmployeeId(1090);
	}
	
	@Test (expected = BadParameterException.class)
	public void testSetEmployeeIdLessThan1000() throws BadParameterException{
		testEmployee.setEmployeeId(800);
	}
	
	@Test (expected = BadParameterException.class)
	public void testSetEmployeeIdGreaterThan9999() throws BadParameterException{
		testEmployee.setEmployeeId(50500);
	}
	
	@Test
	public void testSetHourlyRate() throws BadParameterException {
		testEmployee.setHourlyRate(12.50);
	}
	
	@Test (expected = BadParameterException.class)
	public void testSetHourlyRateLessThan0() throws BadParameterException{
		testEmployee.setHourlyRate(-12);
	}
	
	
	@Test (expected = NullParameterException.class)
	public void testSetTimecard() throws NullParameterException, BadParameterException {
		int[] nulldays = null;
		nullEmployee = new Employee("John", "Deer", 1001, 10.25, nulldays);
	}
	
	@Test
	public void testToString(){
		testEmployee.toString();
	}
}
