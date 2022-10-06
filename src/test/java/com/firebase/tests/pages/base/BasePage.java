package com.firebase.tests.pages.base;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.firebase.test.tests.logTest;
import com.firebase.test.utility.*;
 
 
  
public class BasePage  {
	
	public static WebDriver driver;
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	

	//public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static Logger Logger =  LogManager.getLogger(BasePage.class);
	
	public static GenerateReports report = GenerateReports.getInstance();
	   
public static void clearElement(WebElement element, String objname) {
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
			try {
			Thread.sleep(2000);
			}catch(Exception e) {
				report.logFail("Thread.sleep error");
			}
			element.click();
			Logger.info("pass" + objname + "element is clicked");
		
			
			Logger.error("Fail" + objname +"element is not displayed ");
		
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
			return text;
	}
	public static void loginToSalesforceMethod() {
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
    	clickElement(loginbutton,"login button");
		
	}
	public static void waitUntilPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	

	}	
