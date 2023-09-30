package com.Actitime.TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListnerImplementation;
import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.TaskPage;
@Listeners(ListnerImplementation.class)
public class CreateCustomer extends BaseClass {
	
	@Test
	public void CreateCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getTaskTab().click();
		TaskPage tp = new TaskPage(driver);
		tp.getAddNewDropDown().click();
		tp.getNewCustomerButton().click();
		FileLibrary f = new FileLibrary();
		String CustomerName = f.readFromExcel("Customer Details", 3, 1);
		tp.getEnterCustomerNameTF().sendKeys(CustomerName);
		String CustomerDescription = f.readFromExcel("Customer Details", 3, 2);
		tp.getEnterCustomerDescriptionTF().sendKeys(CustomerDescription);
		tp.getCreateCustomerButton().click();
		String ExpectedResult = CustomerName;
	    String ActualResult = driver.findElement(By.xpath("(//div[.='"+CustomerName+"'])[2]")).getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(ExpectedResult, ActualResult);
		s.assertAll();
		}
	}
