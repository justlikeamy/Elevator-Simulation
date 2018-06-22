package domain;

import utils.BadParameterException;
import utils.NullParameterException;
/**
 * The timecard class calculated how much the employees are earning on a weekly basis<br>
 * It keeps track of the days worked in a week and of how many hours worked each day
 * @author hieldc
 *
 */
public class Timecard {
	/**
	 * Final int for the days an employee will work in a week
	 */
    public static final int NUM_DAYS = 5;
    /**
     * An int array for storing the days of the week, based on how many work days there are
     */
    private final int[] daysOfTheWeek = new int[NUM_DAYS];

    /**
     * The Timecard constructor, given the array of hours worked per day for a given week, uses
     * {@link #setHoursByDay(int, int)}
     * @param daysIn int array of hours worked per day
     * @throws NullParameterException if the daysIn array is empty
     * @throws BadParameterException if the length of daysIn does not equal the number of days an employee should work
     */
    public Timecard(int[] daysIn) throws NullParameterException, BadParameterException {
        if (daysIn == null) {
            throw new NullParameterException("Null int array passed to Timecard c'tor");
        }
        if (daysIn.length != NUM_DAYS) {
            throw new BadParameterException("Invalid int array passed to Timecard c'tor, length: " + daysIn.length);
        }
        for (int i = 0; i < NUM_DAYS; i++) {
            setHoursByDay(i, daysIn[i]);
        }
    }
    
    /**
     * Timecard constructor if given another timecard object
     * @param t a timecard object
     * @throws BadParameterException for {@link #setHoursByDay(int, int)}
     */
    public Timecard(Timecard t) throws BadParameterException {
        for (int i = 0; i < NUM_DAYS; i++) {
            setHoursByDay(i, t.getHoursByDay(i));
        }
    }

    /**
     * Method to sum the number of hours an employee has worked in a week
     * Uses {@link #getHoursByDay(int)} to iterate
     * @return the total hours worked in a week
     */
    public int getWeeklyHours() {
        int count = 0;
        for (int i = 0; i < NUM_DAYS; i++) {
            try {
                count += getHoursByDay(i);
            } catch (BadParameterException e) {
                System.err.println("Invalid day " + i + " skipped in summing weekly hours");
            }
        }
        return count;
    }

    /**
     * Getter for the hours an employee worked on a given day
     * @param day int counter for the days worked
     * @return hours worked on a day
     * @throws BadParameterException if the day is not in the range of days
     */
    public int getHoursByDay(int day) throws BadParameterException {
        if (day < 0 || day >= NUM_DAYS) {
            throw new BadParameterException("Bad day value passed to getHoursByDay: " + day);
        }

        return daysOfTheWeek[day];
    }
    
    /**
     * This method allows setting of the hours worked on a day
     * @param day day of the week
     * @param hours hours worked on that day
     * @throws BadParameterException if the day is less than 0 or greater than max days, and if hours are less than 0 or over 24
     */
    private void setHoursByDay(int day, int hours) throws BadParameterException {
        if (day < 0 || day >= NUM_DAYS) {
            throw new BadParameterException("Bad day value passed to setHoursByDay: " + day);
        }
        if (hours < 0 || hours > 24) {
            throw new BadParameterException("Bad hours value passed to setHoursByDay: " + hours);
        }
        daysOfTheWeek[day] = hours;
    }
    /**
     * toString method for Timecard<br>
     * formats builds a string of Total Weekly Hours and hours worked per day
     * @return the built string
     * 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %d%n", "Weekly Hours:", getWeeklyHours()));
        for (int i = 0; i < NUM_DAYS; i++) {
            try {
                sb.append(String.format("%7s %d: %11d%n", "Day", (i + 1), getHoursByDay(i)));
            } catch (BadParameterException e) {
                sb.append(String.format("%7s %d: %s %d%n", "Day", (i + 1), "Error Accessing Hours for Day", i));
            }
        }
        return sb.toString();
    }
}
