package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class DashboardPageTableTest {

	LoginPage loginPage;

	@BeforeMethod
	public void setUpDriverAndNavigateToUrl() {
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage = new LoginPage();
	}

	@BeforeMethod
	public void testLoginWithValidCredentials() {

		loginPage.loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
		Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders", "Actual title is not equal to expected title");

	}

	@Test
	public void rows() {
		int rows = Driver.getDriver().findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr"))
				.size();
		System.out.println("Number of rows are:" + rows);
		
//	List<WebElement> names  =Driver.getDriver().findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]"));
//		for(int i =1; i<names.size(); i++) {
//		
//			System.out.println(names);
		}
	
		
		
	

	@AfterMethod
	public void closeDriver() {
		Driver.closeDriver();
	}
}