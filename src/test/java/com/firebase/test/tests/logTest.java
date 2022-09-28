package com.firebase.test.tests;



import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

public class logTest {
	private static Logger Logger =  LogManager.getLogger(logTest.class);
	@Test
	
	public void performanceTask() {
		Logger.debug("This is debug message");
		Logger.info("This is info message");
		Logger.warn("This is warn message");
		Logger.error("This is error message");
		Logger.fatal("This is fatal message");
		
	}
	@Test
	
	public void performanceTask2() {
		Logger.debug("This is debug message");
		Logger.info("This is info message");
		Logger.warn("This is warn message");
		Logger.error("This is error message");
		Logger.fatal("This is fatal message");
		
	}
	

}
