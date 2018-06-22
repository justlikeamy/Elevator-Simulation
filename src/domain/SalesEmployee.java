
package domain;

import utils.BadParameterException;
import utils.NullParameterException;
/**
 * This class manages the Employees that are type Sales Employee
 * <br> Sales employees in particular have a needed sales quota and a total weekly sales
 * <br> they get bonus pay if their sales exceed their quota
 * @author hieldc
 *
 */
public class SalesEmployee extends Employee {
	
	/**
	 * Sales quota for the employee
	 */
    private double salesAmountNeeded;
    /** 
     * actual amount sold by employee
     */
    private double weeklySalesTotal;
    /**
     * Constant variable for the bonus pay an employee gets based on having more sales than their quota
     */
    public static final double BONUS_MULTIPLIER = 0.25;

    /**
     * Sales Employee constructor
     * @param fName String first name of employee
     * @param lName String last name of employee
     * @param eId employee ID
     * @param hRate Hourly rate of pay
     * @param daysIn hours that the employee worked per indexed day
     * @param salesNeeded sales quota 
     * @param weeklyTotal total sales achieved
     * @throws NullParameterException for super @Employee.setTimecard
     * @throws BadParameterException for super @Employee.setTimecard
     */
    public SalesEmployee(String fName, String lName, int eId, double hRate, int[] daysIn, double salesNeeded, double weeklyTotal) throws NullParameterException, BadParameterException {
        super(fName, lName, eId, hRate, daysIn);
        setSalesAmountNeeded(salesNeeded);
        setWeeklySalesTotal(weeklyTotal);
    }

    /**
     * Constructor for Sales Employee using another Sales employee
     * @param se sales employee object
     * @throws NullParameterException for @see Employee#setTimeCard(Timecard)
     * @throws BadParameterException for @see Employee#setTimeCard(Timecard)
     */
    public SalesEmployee(SalesEmployee se) throws NullParameterException, BadParameterException {
        super(se);
        setSalesAmountNeeded(se.getSalesAmountNeeded());
        setWeeklySalesTotal(se.getWeeklySalesTotal());
    }
    
    /** 
     * getter for the sales amount needed by the employee
     * @return salesAmountNeeded
     */
    public double getSalesAmountNeeded() {
        return salesAmountNeeded;
    }

    /**
     * Getter for the Weekly Sales gained by the employee
     * @return weeklySalesTotal
     */
    public double getWeeklySalesTotal() {
        return weeklySalesTotal;
    }

    /** 
     * Set the sales amount needed from outside the constructor
     * @param d the amount of money needed to sell
     * @throws BadParameterException if the sales needed are 0 or less
     */
    private void setSalesAmountNeeded(double d) throws BadParameterException {
        if (d <= 0.0) {
            throw new BadParameterException("Invalid sales amount needed: " + d);
        }
        salesAmountNeeded = d;
    }

    /**
     * Set the Weekly Total Sales from outside the constructor
     * @param totalIn amount of sales totaled
     * @throws BadParameterException if the weekly sales are 0 or less
     */
    private void setWeeklySalesTotal(double totalIn) throws BadParameterException {
        if (totalIn <= 0.0) {
            throw new BadParameterException("Invalid weekly sales total: " + totalIn);
        }
        weeklySalesTotal = totalIn;
    }
    
    /**
     * Getter for the weekly pay of a sales employee
     * <br> depends on bonus applied if weekly sales are greater then or equal to the sales quota
     * <br> {@link #getWeeklySalesTotal()} {@link #getSalesAmountNeeded()}
     * <br> If the sales did not meet the quota, then weekly pay is calculated the same as in the parent Employee class 
     * @return Weekly Pay 
     */
    @Override
    public double getWeeklyPay() {

        if (getWeeklySalesTotal() >= getSalesAmountNeeded()) {
            return getWeeklySalesTotal() * BONUS_MULTIPLIER;
        }

        return super.getWeeklyPay();
    }
    /**
     * Method to build a string of Sales Employee data
     * @return the formatted string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(String.format("%-20s $%.2f%n", "Sales Amount Needed:", getSalesAmountNeeded()));
        sb.append(String.format("%-20s $%.2f%n", "Weekly Sales Total:", getWeeklySalesTotal()));

        return sb.toString();
    }
}
