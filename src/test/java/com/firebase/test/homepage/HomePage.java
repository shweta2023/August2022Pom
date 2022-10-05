package com.firebase.test.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.firebase.tests.pages.base.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(id = "userNav")WebElement name;
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[1]")WebElement myprofile;
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[2]")WebElement mysettings;
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[5]")WebElement logout;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickName() {
		 waitUntilVisible(name,"Name");	
		 clickElement(name,"Name");
			
	 }
	public void clickMyProfile() {
		 waitUntilVisible(myprofile,"myprofile");	
		 clickElement(myprofile,"myProfile");
	}
	public void logout() {
		clickName() ;
		clickElement(logout,"logout");
		waitUntilVisible(logout,"logout");	
	}
	/*public void dropdownselect() {
	
		clickLogout();		
	*/}
	
	
	
	
	


