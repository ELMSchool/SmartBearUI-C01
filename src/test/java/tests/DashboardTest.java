package tests;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class DashboardTest {
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
	public static void verifyDashBoardPage() {

		String expectedMessage = "Web Orders";
		
		Assert.assertEquals("Web Orders", expectedMessage);
		
	}

	
	@Test
	public static void verifyviewAllOrderButton() {
		DashboardPage dashBoardChoices = new DashboardPage();

		dashBoardChoices.viewAllOrderButton.click();

	}

	@Test
	public static void verifyviewAllProductsButton() {
		DashboardPage dashBoardChoices = new DashboardPage();

		dashBoardChoices.viewAllProductsButton.click();

	}

	@Test
	public static void verifyorderButton() {
		DashboardPage dashBoardChoices = new DashboardPage();

		dashBoardChoices.orderButton.click();

	}

	@Test
	public static void verifylogoutButton() {
		DashboardPage dashBoardChoices = new DashboardPage();

		dashBoardChoices.logoutButton.click();

	}

	@AfterMethod
	public void closeDriver() {
		Driver.closeDriver();
	}

}