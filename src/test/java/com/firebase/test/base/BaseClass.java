package com.firebase.test.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.firebase.test.tests.logTest;
import com.firebase.test.utility.*;
 
 
  
public class BaseClass  {

	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static Logger Logger =  LogManager.getLogger(BaseClass.class);
	public static GenerateReports report = GenerateReports.getInstance();
	@BeforeTest
	public static void setupBeforeTest(){
		report.startExtentReport();
	}
	
	@Parameters({"browsername"})
	@BeforeMethod
	public static void setUp(String browsername, Method m) {
		System.out.println("Before method execution has started");
		report.startsSingleTestReport(m.getName());
		getdriver(browsername);
		 CommonUtilities CU = new CommonUtilities();
	        Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
 		String url = CU.getApplicationProperty("url",applicationPropertiesFile);
 	    
 		goToUrl(url);
 		waitUntilPageLoads();
	 		driver.manage().window().maximize();
		}
		
		@AfterMethod
		public static void tearDown() {
			Logger.info("After method execution has started");
			String path = fullScreenshot();
			try {
				report.addScreenshot(path,"Full page screenshot");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeBrowser();
	
		}
	@AfterTest
	public static void tearDownAfterTest() {
		report.endReport();
	}
	
	public static void getdriver(String browser) {
		
		switch(browser) {
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		                  break;
		case "chrome"  : 
			System.out.println("I am in Chrome Browser");
			WebDriverManager.chromedriver().setup();
		                driver = new ChromeDriver(); 
		                break;
		default :   break;
		}
	}
		public static void closeBrowser(){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.close();
		}
		public static void goToUrl(String url) {
			driver.get(url);
			driver.manage().window().maximize();
		}
		
		
		
		

	
/*public static void clearElement(WebElement element, String objname) {
	if(element.isDisplayed()) {
		element.clear();
		report.logPass("pass:" + objname +"element cleared");
	}
	else {
		report.logFail("fail:" + objname + "element not displayed");
	}
}
	public static void enterText(WebElement element,String text,String objname) {
		if(element.isDisplayed()) {
			clearElement(element,objname);
			element.sendKeys(text);
			report.logPass("text entered in" + objname + "field");;
		}
		else {
			report.logFail("Fail" + objname +"element is not displayed ");
		
		}
	}
	public static void clickElement(WebElement element,String objname) {
		if(element.isDisplayed()) {
			
			element.click();
			report.logPass("pass" + objname + "element is clicked");
		}
		else {
			report.logFail("Fail" + objname +"element is not displayed ");
		}
	}
	public static void closeBrowser(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	public static void closeAllBrowser() {
		driver.quit();
	}
	public static void goToUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	public static void waitUntilVisibilityOf(WebElement locator,String objname)
	{
	     wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.visibilityOf(locator));
	     
	}
	public static void waitUntil(Duration dur) {
	     wait = new WebDriverWait(driver, dur);

	}
	public static void waitUntilVisible(WebElement element,String objname)
	{
	     wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.visibilityOf(element));
	     
	}
	public static void waitUntilAlertIsPresent()
	{
	     wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.alertIsPresent());
	     
	}
	public static String readText(WebElement element,String objname) {
	waitUntilVisible(element,objname);
	String text = element.getText();
			return text;*/
	
	/*public static void loginToSalesforceMethod() {
		CommonUtilities CU = new CommonUtilities();
        Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
		
		String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
		String passwrd = CU.getApplicationProperty("passwrd",applicationPropertiesFile);
        
		WebElement username = driver.findElement(By.id("username"));
		waitUntilVisible(username,"username");
    	enterText(username,usrname,"user name");
    	WebElement password = driver.findElement(By.id("password"));
    	waitUntilVisible(password,"password");
    	enterText(password,passwrd,"pass word");
    	 WebElement rememberme = driver.findElement(By.name("rememberUn"));
 	    clickElement(rememberme,"remember me");
    	WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
    	waitUntilVisible(loginbutton,"loginbutton");
    	clickElement(loginbutton,"login button");*/
		
	
	public static void waitUntilPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	public static void assertEquals(Object one, Object two) {
		try {
		Assert.assertEquals(one, two);
		report.logPass("Validation Passed");
		}catch(Exception e) {
			report.logFail("Validation failed");

		}
	}
	public static String fullScreenshot() {
		 WebElement screenshotElement = driver.findElement(By.tagName("body"));
		  File screenshotBase = screenshotElement.getScreenshotAs(OutputType.FILE);
	      Date date = new Date();
		  File screenshot = new File("src/test/resources/screenshots/screenshot" + date.getTime() + ".png");
		  try {
		  FileUtils.copyFile(screenshotBase,screenshot);
		  }catch(Exception e) {
			  e.printStackTrace();
			  report.logFail("Screenshot error");

		  }

		  report.logPass("Screenshot done");
		  return screenshot.getAbsolutePath();

	}

	public static void screenshot(WebElement element) {
		  File screenshotBase = element.getScreenshotAs(OutputType.FILE);
	      Date date = new Date();
		  File screenshot = new File("src/test/resources/screenshots/screenshot" + date.getTime() + ".png");
		  try {
		  FileUtils.copyFile(screenshotBase,screenshot);
		  }catch(Exception e) {
			  e.printStackTrace();
			  report.logFail("Screenshot error");

		  }
		  
		  report.logPass("Screenshot done");
	}
	public static void addScreenshot() {
		String path = fullScreenshot();
		try {
		report.addScreenshot(path, "ss");
		}catch(Exception e) {
			report.logFail("Screenshot failed");
		}
	}

	}	
