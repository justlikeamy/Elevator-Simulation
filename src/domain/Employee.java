/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import utils.BadParameterException;
import utils.NullParameterException;

/**
 * Employees work in departments
 * <br> they work for a specified days per week, for a certain amount of time, at a certain rate
 * <br> they are identified by an employee ID number, and have a first and last name
 * @author hieldc
 *
 */

public class Employee implements Comparable<Employee> {
	
    private String firstName;
    private String lastName;
    /**
     * employee identifier between 1000 and 9999, inclusive
     */
    private int employeeId;
    private double hourlyRate;
    /**
     * Reference to object timecard, which holds the hours that the employee has worked per day
     */
    private Timecard timecard;

    /**
     * Employee constructor using a set of parameters
     * @param fName first name {@link #setFirstName(String)}
     * @param lName last name {@link #setLastName(String)}
     * @param eId employee ID {@link #setEmployeeId(int)}
     * @param hRate hourly rate {@link #getHourlyRate()}
     * @param daysIn array where index is the day that they worked and value is how many hours
     * @throws NullParameterException for {@link #setTimecard(Timecard)}
     * @throws BadParameterException for {@link #setTimecard(Timecard)}
     */
    public Employee(String fName, String lName, int eId, double hRate, int[] daysIn) throws NullParameterException, BadParameterException {
        setFirstName(fName);
        setLastName(lName);
        setEmployeeId(eId);
        setHourlyRate(hRate);
        setTimecard(new Timecard(daysIn));
    }
    
    /**
     * Employee constructor using another employee object
     * @param e an object of type employee
     * @throws NullParameterException for {@link #setTimecard(Timecard)}
     * @throws BadParameterException for {@link #setTimecard(Timecard)}
     */
    public Employee(Employee e) throws NullParameterException, BadParameterException {
        setFirstName(e.getFirstName());
        setLastName(e.getLastName());
        setEmployeeId(e.getEmployeeId());
        setHourlyRate(e.getHourlyRate());
        setTimecard(new Timecard(e.getTimecard()));
    }

    /**
     * Override object method compareTo
     * compare employees using employee ID
     * @param eIn employee object
     * @return -1 if eID is less than eIn, 0 if equal and 1 elsewise
     */
    @Override
    public int compareTo(Employee eIn) {
        if (getEmployeeId() < eIn.getEmployeeId()) {
            return -1;
        } else if (getEmployeeId() == eIn.getEmployeeId()) {
            return 0;
        } else {
            return 1;
        }
    }
    
    /**
     * Short method to calculate the pay in a week using {@link #getTimecard()}, {@link #getWeeklyPay()}, and {@link #getHourlyRate()}
     * @return total pay for the week
     */
    public double getWeeklyPay() {
        return getTimecard().getWeeklyHours() * getHourlyRate();
    }
    
    /**
     * Getter method for first name
     * @return String of first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of an employee
     * @param fName String of first name
     * @throws NullParameterException if first name is null
     * @throws BadParameterException if the string is 0 or less character or more than 20 characters
     */
    public final void setFirstName(String fName) throws NullParameterException, BadParameterException {
        if (fName == null) {
            throw new NullParameterException("Null value passed in for firstName");
        }

        if (fName.length() <= 0 || fName.length() > 20) {
            throw new BadParameterException("Bad value passed in for firstName: " + fName);
        }
        firstName = fName;
    }
    
    /**
     * Getter method for last name
     * @return String last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Set the last name of an employee
     * @param lName String last name
     * @throws NullParameterException if the String lName is null
     * @throws BadParameterException if lName length is 0 or less or over 20
     */
    public final void setLastName(String lName) throws NullParameterException, BadParameterException {
        if (lName == null) {
            throw new NullParameterException("Null value passed in for lastName");
        }

        if (lName.length() <= 0 || lName.length() > 20) {
            throw new BadParameterException("Bad value passed in for lastName: " + lName);
        }
        lastName = lName;
    }
    
    /**
     * Getter for employee ID
     * @return int employee ID
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /** 
     * Set the ID value of an employee
     * @param eId int employee id
     * @throws BadParameterException if the id value is not in the range (1000, 9999) inclusive
     */
    public final void setEmployeeId(int eId) throws BadParameterException {
        if (eId < 1000 || eId > 9999) {
            throw new BadParameterException("Bad value passed in for employeeId: " + eId);
        }
        employeeId = eId;
    }

    /**
     * Getter for hourly rate of pay
     * @return double hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }
    /**
     * Set the hourly rate of pay for an employee
     * @param hRate hourly rate
     * @throws BadParameterException if the rate is not greater than $0
     */
    public final void setHourlyRate(double hRate) throws BadParameterException {
        if (hRate <= 0.0) {
            throw new BadParameterException("Bad value passed in for hourlyRate: " + hRate);
        }
        hourlyRate = hRate;
    }
    
    /**
     * Getter for the timecard of an employee
     * @return timecard object
     */
    private Timecard getTimecard() {
        return timecard;
    }

    /**
     * Set the timecard of an employee
     * @param tCard timecard object
     * @throws NullParameterException if the timecard is null
     */
    private void setTimecard(Timecard tCard) throws NullParameterException {
        if (tCard == null) {
            throw new NullParameterException("Null Timecard passed to setTimecard");
        }
        timecard = tCard;
    }
    
    /**
     * Method to build string of employee details
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-20s %s %s%n", "Name:", getFirstName(), getLastName()));
        sb.append(String.format("%-20s %d%n", "Id:", getEmployeeId()));
        sb.append(String.format("%-20s $%.2f%n", "Hourly Rate:", getHourlyRate()));
        sb.append(String.format("%s", getTimecard()));
        sb.append(String.format("%-20s $%.2f%n", "Weekly Pay:", getWeeklyPay()));

        return sb.toString();
    }
}
