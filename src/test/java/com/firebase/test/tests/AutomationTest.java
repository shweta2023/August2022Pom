package com.firebase.test.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.firebase.test.base.BaseClass;
import com.firebase.test.homepage.HomePage;
import com.firebase.test.loginpage.LoginPage;
import com.firebase.test.utility.CommonUtilities;


public class AutomationTest extends BaseClass{

	
		// TODO Auto-generated method stub
        
	@Test
	public static void loginSalesforce1() {
	
	LoginPage login=new LoginPage(driver);
	login.login();
	report.logPass("testscript execution is completed");
	}
	
	

	 @Test
     public static void loginErrorMessage()throws InterruptedException, IOException   {
	   
		 CommonUtilities CU = new CommonUtilities();
	        Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
		//String url = CU.getApplicationProperty("url",applicationPropertiesFile);
		String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
		CU.getApplicationProperty("passwrd",applicationPropertiesFile);
		System.out.println("Inside loginErrorMessage test case");
		WebElement username = driver.findElement(By.id("username"));
       waitUntilVisible(username,"username");
		enterText(username,usrname,"user name");
		WebElement password = driver.findElement(By.id("password"));
		clearElement(password,"password Field");
		WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		waitUntilVisible(loginbutton,"Loginbutton");
	    clickElement(loginbutton,"login button");
	   report.logPass("testscript execution completed");
  		
  		
    		
    		}
 
	

	@Test
    public static void loginToSalesforce1()throws InterruptedException, IOException   {
		  
    loginToSalesforceMethod();
    	
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
public static void ForgotPassword4A( )throws InterruptedException, IOException   {

	CommonUtilities CU = new CommonUtilities();
    Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
	//String url = CU.getApplicationProperty("url",applicationPropertiesFile);
	String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
	//String passwrd = CU.getApplicationProperty("passwrd",applicationPropertiesFile);
	//goToUrl(url);
	//waitUntilPageLoads();
	WebElement forgotpassword = driver.findElement(By.id("forgot_password_link"));
    forgotpassword.click();
    waitUntilVisible(forgotpassword,"forgotpassword");
    System.out.println("Inside ForgotPassword4A");
    WebElement username = driver.findElement(By.xpath("//*[@id=\"un\"]"));
 	username.clear();
 	username.sendKeys(usrname);
 	waitUntilVisible(username,"username");
 	WebElement continueb = driver.findElement(By.id("continue"));
 	continueb.click();
 	waitUntilVisible(continueb,"continueb");
 	
 	
 		
 	
     
}
     @Test
public static void ForgotPassword4B()throws InterruptedException, IOException   {
    	CommonUtilities CU = new CommonUtilities();
	    Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
		//String url = CU.getApplicationProperty("url",applicationPropertiesFile);
		String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
		String invalid_passwrd = CU.getApplicationProperty("invalid-passwrd",applicationPropertiesFile);
	WebElement username = driver.findElement(By.id("username"));
	waitUntilVisible(username,"username");
	enterText(username,usrname,"user name");
	WebElement password = driver.findElement(By.id("password"));
	waitUntilVisible(password,"password");
	clearElement(password, "password");
	password.sendKeys(invalid_passwrd);
	WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
    clickElement(loginbutton,"loginbutton");
    waitUntilVisible(loginbutton,"loginbutton");
    
     }
    
     @Test
 public static void chromeTC05() throws IOException, InterruptedException {
	 
	

	    
		loginToSalesforceMethod();
		WebElement shradha= driver.findElement(By.id("userNav"));
		System.out.println("Inside chromeTC05");
		clickElement(shradha,"shradha");
		waitUntilVisible(shradha,"shradha");	
		
		
 }	
}   
