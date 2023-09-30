package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	//Declaration
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement AddNewDropDown;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement NewCustomerButton;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement EnterCustomerNameTF;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement EnterCustomerDescriptionTF;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement CreateCustomerButton;
	
	@FindBy(xpath = "//div[@class='greyButton cancelBtn']")
	private WebElement CancelButton;
	
	//Initialization
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//Utilization

	public WebElement getAddNewDropDown() {
		return AddNewDropDown;
	}

	public WebElement getNewCustomerButton() {
		return NewCustomerButton;
	}

	public WebElement getEnterCustomerNameTF() {
		return EnterCustomerNameTF;
	}

	public WebElement getEnterCustomerDescriptionTF() {
		return EnterCustomerDescriptionTF;
	}

	public WebElement getCreateCustomerButton() {
		return CreateCustomerButton;
	}

	public WebElement getCancelButton() {
		return CancelButton;
	}
	

}
