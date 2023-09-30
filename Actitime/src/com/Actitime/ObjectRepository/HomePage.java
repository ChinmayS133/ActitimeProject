package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Declaration
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement TaskTab;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement ReportTab;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement UserTab;
	
	@FindBy(id = "logoutLink")
	private WebElement LogoutLink;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getTaskTab() {
		return TaskTab;
	}
	
	public WebElement getReportTab() {
		return ReportTab;
		
	}

	public WebElement getUserTab() {
		return UserTab;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}
	
	

}
