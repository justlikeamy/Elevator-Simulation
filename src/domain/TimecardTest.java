package domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import utils.BadParameterException;
import utils.NullParameterException;

public class TimecardTest {
	Timecard forAmy = null;
	Timecard testTimecard = null;

	@Before
	public void setUp() throws Exception {
		
		int[] num = {1,1,1,1,1};
		testTimecard = new Timecard(num);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTimecard() throws NullParameterException, BadParameterException {
		int[] days = {2,3,4,5,6};
		forAmy = new Timecard(days);
	}
	
	@Test 
	public void testTimecardT() throws BadParameterException{
		Timecard newTimecard = new Timecard(testTimecard);
	}
	
	@Test (expected = BadParameterException.class)
	public void testTimecardTestException() throws BadParameterException, NullParameterException{
		int[] badVals = {25,3,4,1,1,-1,88};
		Timecard newTimecard = new Timecard(badVals);
	}
	
	
	@Test (expected = NullParameterException.class)
	public void testTimecardNull() throws NullParameterException, BadParameterException {
		int[] days = null;
		forAmy = new Timecard(days);
	}
	
	@Test (expected = BadParameterException.class)
	public void testTimecardWrongLength() throws NullParameterException, BadParameterException {
		int[] days = {1,2};
		forAmy = new Timecard(days);
	}
	
	@Test
	public void testGetWeeklyHours(){
		testTimecard.getWeeklyHours();
	}
	
	@Test (expected = BadParameterException.class)
	public void testGetWeeklyHoursException() throws NullParameterException, BadParameterException{
		int[] neg = {-8,26,-1,16,30,35};
		Timecard testNew = new Timecard(neg);
		testNew.getWeeklyHours();
	}
	
	@Test
	public void testGetHoursByDay() throws BadParameterException{
		testTimecard.getHoursByDay(2);
	}
	
	@Test (expected = BadParameterException.class)
	public void testGetHoursByDayErrorNeg() throws BadParameterException{
		testTimecard.getHoursByDay(-1);
	}
	
	@Test (expected = BadParameterException.class)
	public void testSetHoursByDayNeg() throws NullParameterException, BadParameterException{
		int[] neg = {-8,26,-1,16,30,35};
		Timecard testNew = new Timecard(neg);
	}
	
	@Test (expected = BadParameterException.class)
	public void testSetHoursByDayExtra() throws NullParameterException, BadParameterException{
		int[] extra = {8,3,6,6,7,10};
		Timecard testNew = new Timecard(extra);
	}
	
	@Test
	public void testToString(){
		testTimecard.toString();
	}
	
	@Test (expected = BadParameterException.class)
	public void testTimecardHours() throws NullParameterException, BadParameterException{
		int[] neg = {-8,26,-1,16,30};
		Timecard testNew = new Timecard(neg);
		testNew.toString();
	}
	
	@Test (expected = BadParameterException.class)
	public void testTimecardHours2() throws NullParameterException, BadParameterException{
		int[] neg = {1,1,1,1,1,1,1,1};
		Timecard testNew = new Timecard(neg);
		testNew.toString();
	}
	

}
