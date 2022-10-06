package com.firebase.test.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.firebase.test.base.BaseClass;
import com.firebase.test.homepage.HomePage;
import com.firebase.test.loginpage.ForgotPassword;
import com.firebase.test.loginpage.LoginPage;
import com.firebase.test.utility.CommonUtilities;
import com.firebase.tests.pages.base.BasePage;


public class AutomationTest extends BaseClass{

	
		// TODO Auto-generated method stub
        
	
	
	

	 @Test
     public static void loginErrorMessage()throws InterruptedException, IOException   {
			LoginPage login=new LoginPage(driver);
		
		 CommonUtilities CU = new CommonUtilities();
	        Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
		String expected ="Please enter your password.";
		String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
		CU.getApplicationProperty("passwrd",applicationPropertiesFile);
		System.out.println("Inside loginErrorMessage test case");
		WebElement username = driver.findElement(By.id("username"));
      login.waitUntilVisible(username,"username");
		login.enterText(username,usrname,"user name");
		WebElement password = driver.findElement(By.id("password"));
		login.clearElement(password,"password Field");
		WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		login.waitUntilVisible(loginbutton,"Loginbutton");
	    login.clickElement(loginbutton,"login button");
	    WebElement actuala = driver.findElement(By.id("error"));
	    String actual = actuala.getText();
	    assertEquals(actual, expected);		
	   report.logPass("testscript execution completed");
  		
  		
    		
    		}
 
	

	@Test
    public static void loginToSalesforce1()throws InterruptedException, IOException   {
		LoginPage login=new LoginPage(driver);
		 login.loginToSalesforceMethod();
    	
    }	
      @Test
public static void checkRememberMe3()throws InterruptedException, IOException   {
	
    LoginPage login=new LoginPage(driver);
    login.login();
    String expected = "mail2raju2001@gmail.com";
	HomePage page = new HomePage(driver);
	page.logout();
	Thread.sleep(5000);
	String actual = login.getUserName();
	assertEquals(actual, expected);		
	
}	
      @Test
public static void ForgotPassword4A()throws InterruptedException, IOException   {
  
    LoginPage login=new LoginPage(driver);	  
    ForgotPassword fp = new ForgotPassword(driver);
	CommonUtilities CU = new CommonUtilities();
    Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
	String expected = "We’ve sent you an email with a link to finish resetting your password.";
	String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
	WebElement username = driver.findElement(By.id("username"));
 	username.clear();
 	username.sendKeys(usrname);
 	login.waitUntilVisible(username,"username");
 	login.clickForgotpassword();
    fp.forgotPassword(usrname);
    WebElement actuala = driver.findElements(By.className("senttext")).get(0);
    String actual = actuala.getText();
	fp.clickReturntologin();
    assertEquals(expected,actual);
    report.logPass("testscript execution completed");
    
 		
 	
     
}
     @Test
public static void ForgotPassword4B()throws InterruptedException, IOException   {
    	 LoginPage login=new LoginPage(driver);
    	
    	CommonUtilities CU = new CommonUtilities();
	    Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
		
		String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
		String invalid_passwrd = CU.getApplicationProperty("invalid-passwrd",applicationPropertiesFile);
	WebElement username = driver.findElement(By.id("username"));
	login.waitUntilVisible(username,"username");
	login.enterText(username,usrname,"user name");
	WebElement password = driver.findElement(By.id("password"));
	login.clearElement(password, "password");
	login.waitUntilVisible(password,"password");
	password.sendKeys(invalid_passwrd);
	WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
    login.waitUntilVisible(loginbutton,"loginbutton");
	login.clickElement(loginbutton,"loginbutton");
    
     }
    
     @Test
 public static void chromeTC05() throws IOException, InterruptedException {
	 
    	 LoginPage login=new LoginPage(driver);
    	    login.login();
    	 
	   login.loginToSalesforceMethod();
		WebElement shradha= driver.findElement(By.id("userNav"));
		System.out.println("Inside chromeTC05");
		login.clickElement(shradha,"shradha");
		login.waitUntilVisible(shradha,"shradha");	
		
		
 }	
}   
