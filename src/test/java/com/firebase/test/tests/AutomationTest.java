package com.firebase.test.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.firebase.test.utility.CommonUtilities;
import com.firsebase.test.base.BaseClass;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class AutomationTest extends BaseClass{

	
		// TODO Auto-generated method stub
        
		
	

   @Test
       public static void loginErrorMessage()throws InterruptedException, IOException   {
	   
		 CommonUtilities CU = new CommonUtilities();
	        Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
		String url = CU.getApplicationProperty("url",applicationPropertiesFile);
		String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
		String passwrd = CU.getApplicationProperty("passwrd",applicationPropertiesFile);
	    //getdriver("browsername");
		//goToUrl(url);
		//waitUntilPageLoads();
		System.out.println("Inside loginErrorMessage test case");
		WebElement username = driver.findElement(By.id("username"));
         waitUntilVisible(username,"username");
		enterText(username,usrname,"user name");
		WebElement password = driver.findElement(By.id("password"));
		clearElement(password,"password Field");
		Thread.sleep(1000);
		WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		//waitUntilVisible(loginbutton,"Loginbutton");
	    clickElement(loginbutton,"login button");
	    Thread.sleep(2000);
	   
    		closeBrowser();
    		
    		}
 
	

	@Test(enabled = false)
    public static void loginToSalesforce1()throws InterruptedException, IOException   {
		  
    
		waitUntilPageLoads();
		loginToSalesforceMethod();
    	closeBrowser();
    }	
      @Test
public static void checkRememberMe3()throws InterruptedException, IOException   {
	

	loginToSalesforceMethod();
	WebElement shradha= driver.findElement(By.id("userNav"));
	clickElement(shradha,"shradha");
	WebElement logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
	waitUntilVisible(logout,"logout");
	System.out.println("Inside checkRememberMe3");
	clickElement(logout,"log out");
	closeBrowser();
	
	
}	
      @Test
public static void ForgotPassword4A( )throws InterruptedException, IOException   {

	CommonUtilities CU = new CommonUtilities();
    Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
	String url = CU.getApplicationProperty("url",applicationPropertiesFile);
	String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
	String passwrd = CU.getApplicationProperty("passwrd",applicationPropertiesFile);
	goToUrl(url);
	waitUntilPageLoads();
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
 	
 	closeBrowser();
 		
 	
     
}
     @Test(enabled = false)
public static void ForgotPassword4B()throws InterruptedException, IOException   {
    	CommonUtilities CU = new CommonUtilities();
	    Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
		String url = CU.getApplicationProperty("url",applicationPropertiesFile);
		String usrname = CU.getApplicationProperty("usrname",applicationPropertiesFile);
		String passwrd = CU.getApplicationProperty("passwrd",applicationPropertiesFile);
	WebElement username = driver.findElement(By.id("username"));
	waitUntilVisible(username,"username");
	enterText(username,usrname,"user name");
	WebElement password = driver.findElement(By.id("password"));
	clearElement(password, "password");
	password.sendKeys(CU.getApplicationProperty("inavlid-password",applicationPropertiesFile));
	WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
    clickElement(loginbutton,"loginbutton");
    waitUntilVisible(loginbutton,"loginbutton");
    closeBrowser();
     }
    
     @Test(enabled=false)
 public static void chromeTC05(String browsername) throws IOException, InterruptedException {
	 
	
		getdriver(browsername);
	    goToUrl(("url"));
		loginToSalesforceMethod();
		WebElement shradha= driver.findElement(By.id("userNav"));
		System.out.println("Inside chromeTC05");
		clickElement(shradha,"shradha");
		waitUntilVisible(shradha,"shradha");	
		closeBrowser();
		
 }	
      @Test	
public static void chromeTC06() throws IOException, InterruptedException {
	 
	 	//Set Up WebDriver
	
		
		loginToSalesforceMethod();
	    //Go to My profile
		CommonUtilities CU = new CommonUtilities();
	    Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
	    WebElement shradha= driver.findElement(By.id("userNav"));
		clickElement(shradha,"shradha");
		waitUntilVisible(shradha,"shradha");
		WebElement myprofile = driver.findElement(By.xpath("//a[@title='My Profile']"));
		//Actions action = new Actions(driver);
		//action.moveToElement(myprofile).build().perform();
		clickElement(myprofile,"my profile");
		waitUntilVisible(myprofile,"my profile");

		//Edit Profile
		System.out.println("Inside chromeTC06");
		WebElement editprofile = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a"));
		waitUntilVisible(editprofile,"editprofile");
		clickElement(editprofile,"edit profile");
		driver.switchTo().frame(2);
		Thread.sleep(2000);
		WebElement about = driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
		clickElement(about,"About");
		WebElement fname = driver.findElement(By.id("firstName"));
		fname.clear();
		fname.sendKeys( CU.getApplicationProperty("fname",applicationPropertiesFile));
		WebElement lname= driver.findElement(By.id("lastName"));
		lname.clear();
		lname.sendKeys(CU.getApplicationProperty("lname",applicationPropertiesFile));
		WebElement saveAll = driver.findElements(By.className("zen-primaryBtn")).get(0);
		saveAll.click();

		//Send Post
		
		Thread.sleep(2000);
		WebElement post = driver.findElement(By.id("publisherAttachTextPost"));
		clickElement(post,"post");
		driver.switchTo().frame(0);
		WebElement textArea = driver.findElements(By.className("chatterPublisherRTE")).get(0);
		textArea.click();
		textArea.sendKeys(CU.getApplicationProperty("post",applicationPropertiesFile));
		driver.switchTo().defaultContent();
		WebElement share = driver.findElement(By.id("publishersharebutton"));
		share.click();
		
		//Upload File
		
		WebElement File = driver.findElement(By.id("publisherAttachContentPost"));
		Thread.sleep(1000);
		clickElement(File,"File");
		Thread.sleep(1000);
		WebElement upload = driver.findElement(By.id("chatterUploadFileAction"));
		Thread.sleep(1000);
		upload.click();
		WebElement choose = driver.findElement(By.id("chatterFile"));
		Thread.sleep(1000);
		File image = new File("C:\\Users\\shwet\\eclipse-workspace\\SeleniumAutomationProjects\\src\\test\\resources\\gg.jpg");
		choose.sendKeys(image.getAbsolutePath());
		WebElement shareFile = driver.findElement(By.id("publishersharebutton"));
		clickElement(shareFile, "Share");
		Thread.sleep(3000);
		
		//Update profile pic
		
		WebElement pic = driver.findElements(By.className("chatter-photo")).get(0);
		Actions action = new Actions(driver);
		action.moveToElement(pic).build().perform();
		WebElement update = driver.findElement(By.id("uploadLink"));
		Thread.sleep(1000);
		update.click();
		driver.switchTo().frame(1);
		WebElement picu = driver.findElements(By.className("fileInput")).get(0);
		picu.sendKeys("C:\\Users\\shwet\\eclipse-workspace\\SeleniumAutomationProjects\\src\\test\\resources\\gg.jpg");
		WebElement saven = driver.findElements(By.className("saveButton")).get(1);
		saven.click();
		Thread.sleep(8500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		saven = driver.findElements(By.className("saveButton")).get(0);
		saven.click();
		Thread.sleep(2000);
		closeBrowser();
		
}

}







