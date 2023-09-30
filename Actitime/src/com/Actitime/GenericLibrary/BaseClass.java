package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("DataBase connected",true);
	}
	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.actitime.com/login.do");
		Reporter.log("Launched browser",true);
	}
	@BeforeMethod
	public void logintoActitime() throws IOException {
		LoginPage lp = new LoginPage(driver);
		FileLibrary f = new FileLibrary();
		String UN = f.readDataFromProperty("Username");
		lp.getUsernameTF().sendKeys(UN);
		String PWD = f.readDataFromProperty("Password");
		lp.getPasswordTF().sendKeys(PWD);
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Reporter.log("Logged in",true);
	}
	
	@AfterMethod
	public void logoutfromActitime() {
		HomePage hp = new HomePage(driver);
		hp.getLogoutLink().click();
		Reporter.log("Logged out",true);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Broswer Closed",true);
	}
	@AfterSuite
	public void disconnectDataBase() {
		Reporter.log("DataBase disconnected");
	}
}
