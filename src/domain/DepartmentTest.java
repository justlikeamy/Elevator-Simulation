

package domain;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import utils.BadParameterException;
import utils.NullParameterException;


public class DepartmentTest {

	public String testName = "Department Name";
	private ArrayList<Employee> employeeList = new ArrayList<>(0);
	private Department testDepartment = null;
	private Employee testEmployee = null;
	private SalesEmployee testSalesEmployee = null;
	
	@Before
	public void setUp() throws Exception {
		testDepartment = new Department(testName); //test setDepartmentName
		int[] testDays = {5,5,6,5,5};
		testEmployee = new Employee("Jane", "Doe", 1001, 10.25, testDays);
		testSalesEmployee = new SalesEmployee("Joe", "Deer", 1002, 12.00, testDays, 200, 300);
	}

	@After
	public void tearDown() throws Exception {
		testDepartment = null;
		testEmployee = null;
	}
	
	@Test (expected = NullParameterException.class)
	public void testSetNameNull() throws NullParameterException, BadParameterException {
		Department nullDepartment = new Department(null);
		assertEquals(nullDepartment.getDepartmentName(), null);
		
	}
	@Test (expected = BadParameterException.class)
	public void testSetNameEmpty() throws NullParameterException, BadParameterException {
		Department nullDepartment = new Department("");
		assertEquals(nullDepartment.getDepartmentName(), "");
		
	}

	@Test
	public void testGetName() {
		assertEquals(testDepartment.getDepartmentName(), testName);
		
	}
	
	@Test
	public void testToString() {
		testDepartment.toString();
	}
	
	
	 @Test
	 public void testAddEmployee() throws NullParameterException, BadParameterException {
		testDepartment.addEmployee(testEmployee);
	 }
	 
	 @Test (expected = NullParameterException.class)
	 public void testAddEmployeeNull() throws NullParameterException, BadParameterException{
		 Employee nullEmp = null;
		 testDepartment.addEmployee(nullEmp);
	 }
	 
	 @Test (expected = BadParameterException.class)
	 public void testAddEmployeeMax() throws NullParameterException, BadParameterException{
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee); //5
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee); //10
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee); //15
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.addEmployee(testEmployee); //20
		 testDepartment.addEmployee(testEmployee); //crash here
	 }
	 
	 @Test
	 public void addEmployeeSales() throws NullParameterException, BadParameterException{
		 testDepartment.addEmployee(testSalesEmployee);
	 }
	 
	 @Test(expected = NullParameterException.class)
	 public void addEmployeeSalesNull() throws NullParameterException, BadParameterException{
		 SalesEmployee nullSe = null;
		 testDepartment.addEmployee(nullSe);
	 }
	 
	 @Test (expected = BadParameterException.class)
	 public void addEmployeeSalesMax() throws NullParameterException, BadParameterException{
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee); //5
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee); //10
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee); //15
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee);
		 testDepartment.addEmployee(testSalesEmployee); //20
		 testDepartment.addEmployee(testSalesEmployee); //crash here
	 }
	 
	 @Test
	 public void testRemoveEmployee() throws NullParameterException, BadParameterException{
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.removeEmployee(1001);
	 }
	 
	 @Test
	 public void testRemoveInvisibleEmployee(){
		 testDepartment.removeEmployee(1003);
	 }
	 
	 @Test
	 public void testIsInDepartment() throws NullParameterException, BadParameterException{
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.isInDepartment(1001);
	 }
	 
	 @Test
	 public void testIsNotInDepartment() throws NullParameterException, BadParameterException{
		 testDepartment.addEmployee(testEmployee);
		 testDepartment.isInDepartment(1005);
	 }
	 
	 @Test
	 public void testGetNumInDepartment() {
	        testDepartment.getNumInDepartment();
	    }
	 
	 
}
