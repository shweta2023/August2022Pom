package com.firebase.test.loginpage;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.firebase.test.utility.CommonUtilities;
import com.firebase.tests.pages.base.BasePage;

public class LoginPage extends BasePage{
	

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//@FindBy(id = "username")
WebElement username = driver.findElement(By.id("username"));
@FindBy(id = "password")WebElement password;
@FindBy(name ="rememberUn")WebElement rememberme;
@FindBy(name = "Login")WebElement loginbutton;
@FindBy(id = "forgot_password_link")WebElement forgotpassword;

/*public LoginPage(WebDriver driver) {
	super(driver);
	
	
}
*/
 public void enterusername(String usrname) {
	// waitUntilVisible(username,"username");
        enterText(username,usrname,"User name field");
	 
	 
 }
 public void enterPassword(String passwrd) {
     enterText(password,passwrd,"Password field");
 }
 public void clickRememberme() {
	 clickElement(rememberme,"remember me");
 }
 public void clickLoginbutton() {
	 clickElement(loginbutton,"Login button");
 }
 public void clickForgotpassword() {
	 clickElement(forgotpassword,"ForgotPassword");
 }
 
 public void login() {
	 CommonUtilities CU = new CommonUtilities();
     Properties applicationPropertiesFile = CU.loadfile("applicationProperties");
		String username = CU.getApplicationProperty("usrname",applicationPropertiesFile);
		String password = CU.getApplicationProperty("passwrd",applicationPropertiesFile);
	 enterusername(username);
	 enterPassword(password);
	 clickRememberme();
	 clickLoginbutton();
 }
public String getUserName() {
	WebElement username = driver.findElement(By.xpath("//*[@id=\"idcard-identity\"]"));

	waitUntilPageLoads();
		String text =  username.getText();
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





}
	 
 
 







