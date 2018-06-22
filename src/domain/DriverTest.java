package domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import utils.BadParameterException;
import utils.NullParameterException;

public class DriverTest {


	@Test
	public void testDriver() {
		Driver begin = new Driver();
	}
	
	@Test
	public void testMain(){
		Driver begin = new Driver();
		String[] args = null;
		begin.main(args);
	}


}
