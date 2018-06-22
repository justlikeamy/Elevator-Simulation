
package domain;

import java.util.ArrayList;
import java.util.Collections;
import utils.BadParameterException;
import utils.NullParameterException;
/**
 * The Department class contains all the Employees in any 
 * given Department. <br> The types of Employees are Sales and regular.
 * @author hieldc
 *
 */
public class Department {
	/**
	 * Give descriptive names to departments
	 * @see #setDepartmentName(String)
	 * @see #getDepartmentName()
	 */
    private String departmentName;
    
    /** 
     * Final variable for the maximum number of employees in each department
     */
    public static final int MAX_EMP = 20;
    
    /**
     * Keep a list of the employees in each department
     * @see #addEmployee(Employee)
     * @see #addEmployee(SalesEmployee)
     * @see #removeEmployee(int)
     */
    private final ArrayList<Employee> employeeList = new ArrayList<>(0);

    /**
     * Constructor for Department 
     * 
     * @param dName the name of the department
     * @throws NullParameterException if the value is null
     * @throws BadParameterException if the value is empty
     */
    public Department(String dName) throws NullParameterException, BadParameterException {
        setDepartmentName(dName);
    }
    
    /**
     * Getter for Department Name
     * @return String department name
     */
    public String getDepartmentName() {
        return departmentName;
    }
    
    /**
     * Sets the department name from the constructor
     * 
     * @param dNameIn department name
     * @throws NullParameterException if the value is null
     * @throws BadParameterException if the value is empty
     */
    private void setDepartmentName(String dNameIn) throws NullParameterException, BadParameterException {
        if (dNameIn == null) {
            throw new NullParameterException("Null value passed in for departmentName");
        }

        if (dNameIn.isEmpty()) {
            throw new BadParameterException("Invalid Department Name: " + dNameIn);
        }
        departmentName = dNameIn;
    }

    /**
     * Getter for the Employees in a Department
     * @return Array List of type Employee
     */
    private ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * Adds Employee to the Department Array List<br>
     * sorts by ID number
     * @param e object of type Employee
     * @throws NullParameterException if Employee is null
     * @throws BadParameterException if trying to add Employee to a Department that has hit MAX_EMP
     */
    public void addEmployee(Employee e) throws NullParameterException, BadParameterException {
        if (e == null) {
            throw new NullParameterException("Null Employee sent to addEmployee!");
        }
        if (getEmployeeList().size() >= MAX_EMP) {
            throw new BadParameterException("This Department is already at the max. number of employees: " + MAX_EMP);
        }
        getEmployeeList().add(new Employee(e));
        Collections.sort(getEmployeeList());
    }

    /**
     * Adds Sales Employee to the Employee List for a department<br>
     * sorts the list by ID number <br> creates a salesEmployee copy
     * @param e object of type SalesEmployee
     * @throws NullParameterException if SalesEmployee is null
     * @throws BadParameterException if trying to add SalesEmployee to a Department that has hit MAX_EMP
     */
    public void addEmployee(SalesEmployee e) throws NullParameterException, BadParameterException {
        if (e == null) {
            throw new NullParameterException("Null Employee sent to addEmployee!");
        }
        if (getEmployeeList().size() > MAX_EMP) {
            throw new BadParameterException("This Department is already at the max. number of employees: " + MAX_EMP);
        }

        SalesEmployee ee = new SalesEmployee(e); // Create a SalesEmployee copy
        getEmployeeList().add(ee);
        Collections.sort(getEmployeeList());

    }

    /**
     * removed an Employee from its department list
     * @param id Employee ID between 1000 and 9999, inclusive
     * @return the removed Employee ID, if found in the list, otherwise return null
     */
    public Employee removeEmployee(int id) {
        for (Employee e : getEmployeeList()) {
            if (e.getEmployeeId() == id) {
                Employee emp = e;
                getEmployeeList().remove(e);
                return emp;
            }
        }
        return null;
    }

    /** 
     * Find if the Employee with this ID is in this Department
     * @param id of the Employee
     * @return true if Employee is in the department, false otherwise
     */
    public boolean isInDepartment(int id) {
        for (Employee e : getEmployeeList()) {
            if (e.getEmployeeId() == id) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Getter for the number of people in the Department
     * @return the size of the Employee Array List
     */
    public int getNumInDepartment() {
        return getEmployeeList().size();
    }
    
    /**
     * toString method to build output of a list of employees in each apartment
     * @see #getDepartmentName()
     * @see #getEmployeeList()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Department: %s\n", getDepartmentName()));
        for (int i = 0; i < ("Department: " + getDepartmentName()).length(); i++) {
            sb.append("-");
        }
        sb.append("\nEmployees:\n");
        for (Employee e : getEmployeeList()) {
            sb.append(e + "\n");
        }

        return sb.toString();

    }
}
