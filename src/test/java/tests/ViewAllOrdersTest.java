package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.github.javafaker.Faker;

import pages.LoginPage;
import pages.OrderPage;
import pages.ViewAllOrdersPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ViewAllOrdersTest {

	LoginPageTest loginpage = new LoginPageTest();

	@AfterMethod
	public void closeDriver() {
		Driver.closeDriver();
	}

	@Test(description = "Verify if name <Paul> still in our table after editing it or not")
//	public void isPaulStillThere() throws InterruptedException {
//		ViewAllOrdersPage allOrdersPage = new ViewAllOrdersPage();
//		OrderPage orderpage = new OrderPage();
//		
//		loginpage.testLoginWithValidCredentials();


	
	@BeforeMethod
	public void setUpDriverAndNavigateToUrl() {
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    LoginPage loginpage = new LoginPage();
		loginpage.loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
	}
	@Test
	public void isPaulStillThere() {
		ViewAllOrdersPage  allOrdersPage = new ViewAllOrdersPage() ;
		OrderPage orderpage = new OrderPage() ;
		SoftAssert softAssert = new SoftAssert();
		
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    LoginPage loginpage = new LoginPage();
		loginpage.loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
		
		String actualPaulBrown = allOrdersPage.paulBrown.getText();

		allOrdersPage.firstRowEditOrder.click();

		orderpage.custName.clear();
		String fakename = "John Doe";
		orderpage.custName.sendKeys(fakename);

		allOrdersPage.updateButton.click();


		
	
		softAssert.assertEquals(actualPaulBrown, ConfigReader.getPropertyValue(fakename),
				"Test is passing if Paul Brown is not Equal to John Doe");
		BrowserUtils.getScreenshot("test_Screenshot1");

		Driver.closeDriver();
	
		
		Assert.assertNotEquals(actualPaulBrown, fakename,"Test is passing if Paul Brown is not Equal to John Doe");
		Driver.closeDriver();
		
		}
		
		
	}


