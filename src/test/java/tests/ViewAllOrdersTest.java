package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.github.javafaker.Faker;

import pages.LoginPage;
import pages.OrderPage;
import pages.ViewAllOrdersPage;
import utils.ConfigReader;
import utils.Driver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ViewAllOrdersTest {
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
		String actualPaulBrown = allOrdersPage.paulBrown.getText();
		allOrdersPage.firstRowEditOrder.click();
		//3. Will change Paul Brown to John Doe
		orderpage.custName.clear();
		String fakename = "John Doe";
		orderpage.custName.sendKeys(fakename);
		//4 will update changes
		allOrdersPage.updateButton.click();
		//5. writing our if else statement if Paul Brown name is Still in our allorder page or not
		
		Assert.assertNotEquals(actualPaulBrown, fakename,"Test is passing if Paul Brown is not Equal to John Doe");
		Driver.closeDriver();
		
		}
		
		
	}

