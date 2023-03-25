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
		int rows = Driver.getDriver().findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr")).size();
		System.out.println("Number of rows are:" + rows);
	}

	@Test
	public void listOfNames() {

		List<WebElement> nameWebelement = Driver.getDriver()
				.findElements(By.cssSelector("table[class='SampleTable']>tbody>tr>td:nth-of-type(2)"));
		List<String> nameOfCustomers = new ArrayList<>();
		for (WebElement each : nameWebelement) {
			nameOfCustomers.add(each.getText());

		}
		System.out.println(nameOfCustomers);

	}

	@Test
	public void listOfProducts() {

		List<WebElement> productWebelement = Driver.getDriver()
				.findElements(By.cssSelector("table[class='SampleTable']>tbody>tr>td:nth-of-type(3)"));
		List<String> nameOfProducts = new ArrayList<>();
		for (WebElement each : productWebelement) {
			nameOfProducts.add(each.getText());
		}
		System.out.println(nameOfProducts);

	}

	@AfterMethod
	public void closeDriver() {
		Driver.closeDriver();
	}
}