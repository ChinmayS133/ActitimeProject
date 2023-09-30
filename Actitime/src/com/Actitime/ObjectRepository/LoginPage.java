package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declaration
	@FindBy(id = "username")
	private WebElement UsernameTF;
	
	@FindBy(name = "pwd")
	private WebElement PasswordTF;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement LoginButon;
	
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getUsernameTF() {
		return UsernameTF;
	}

	public WebElement getPasswordTF() {
		return PasswordTF;
	}

	public WebElement getLoginButon() {
		return LoginButon;
	}	

}
