package com.firebase.test.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
 
 public void login(String usrname, String passwrd) {
	 enterusername(usrname);
	 enterPassword(passwrd);
	 clickRememberme();
	 clickLoginbutton();
 }
public String getUserName() {
		String text =  username.getText();
		return text;
	}
}
	 
 
 







