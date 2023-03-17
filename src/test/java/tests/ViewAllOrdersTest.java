package tests;

<<<<<<< HEAD
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
=======
import java.util.concurrent.TimeUnit;
>>>>>>> c2f226c30aa0e10f71691bc79510cdcae9dc7ec7

import org.testng.Assert;

import com.github.javafaker.Faker;

import pages.LoginPage;
import pages.OrderPage;
import pages.ViewAllOrdersPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

<<<<<<< HEAD
import org.testng.annotations.AfterMethod;
=======
import org.testng.annotations.BeforeMethod;
>>>>>>> c2f226c30aa0e10f71691bc79510cdcae9dc7ec7
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ViewAllOrdersTest {
<<<<<<< HEAD
	LoginPageTest loginpage = new LoginPageTest();

	@AfterMethod
	public void closeDriver() {
		Driver.closeDriver();
	}
	
	@Test(description = "Verify if name <Paul> still in our table after editing it or not")
	public void isPaulStillThere() throws InterruptedException {
		ViewAllOrdersPage allOrdersPage = new ViewAllOrdersPage();
		OrderPage orderpage = new OrderPage();
		SoftAssert softAssert = new SoftAssert();

		loginpage.testLoginWithValidCredentials();

=======
	LoginPage loginpage;
	@BeforeMethod
	public void setUpDriverAndNavigateToUrl() {
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage = new LoginPage();
		loginpage.loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
	}
	@Test
	public void isPaulStillThere() throws InterruptedException {
		ViewAllOrdersPage  allOrdersPage = new ViewAllOrdersPage() ;
		OrderPage orderpage = new OrderPage() ;
		//ctl00_MainContent_fmwOrder_txtName
		
		//1.Will edit 1 st order 
		//2.get text of Paul Brown for verification
>>>>>>> c2f226c30aa0e10f71691bc79510cdcae9dc7ec7
		String actualPaulBrown = allOrdersPage.paulBrown.getText();

		allOrdersPage.firstRowEditOrder.click();

		orderpage.custName.clear();
		String fakename = "John Doe";
		orderpage.custName.sendKeys(fakename);

		allOrdersPage.updateButton.click();
<<<<<<< HEAD

		BrowserUtils.getScreenshot("test_Screenshot1");
		softAssert.assertEquals(actualPaulBrown, ConfigReader.getPropertyValue(fakename),
				"Test is passing if Paul Brown is not Equal to John Doe");
		loginpage.closeDriver();
		System.out.println("This is last print statement");

=======
		//5. writing our if else statement if Paul Brown name is Still in our allorder page or not
		
		Assert.assertNotEquals(actualPaulBrown, fakename,"Test is passing if Paul Brown is not Equal to John Doe");
		Driver.closeDriver();
		
		}
		
		
>>>>>>> c2f226c30aa0e10f71691bc79510cdcae9dc7ec7
	}

}
