package com.firebase.test.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.firebase.tests.pages.base.BasePage;

public class ForgotPassword extends BasePage {
	
	public ForgotPassword(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "un")WebElement username;
	@FindBy(name ="cancel")WebElement cancel;
	@FindBy(id = "continue")WebElement Continue;
	@FindBy(className = "primary")WebElement Returntologin;
	
	
	public void enterusername(String usrname) {
		// waitUntilVisible(username,"username");
	        enterText(username,usrname,"User name field");
		 
	}
	public void clickContinue() {
		 clickElement(Continue,"Continue");
	
	}
	public void clickCancel() {
		clickElement(cancel,"cancel");
	}
	
	public void clickReturntologin() {
		clickElement(Returntologin,"Return To Login");
		
	}
     public void forgotPassword(String usrname) {
    	 enterusername( usrname) ;
    	 clickContinue();
    	 
     }
	
}
