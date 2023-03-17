package tests;

import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
<<<<<<< HEAD
import org.testng.annotations.Parameters;
=======
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
>>>>>>> c2f226c30aa0e10f71691bc79510cdcae9dc7ec7
import org.testng.annotations.Test;
public class LoginPageTest {
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUpDriverAndNavigateToUrl() {
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage = new LoginPage();
	}
	
<<<<<<< HEAD
	@AfterMethod (dependsOnMethods = {"testLoginWithValidCredentials","testLoginInvalidCredentials","testLoginWithEmptyCredentials"})
	public void closeDriver() throws InterruptedException {
		Thread.sleep(4000);
=======
	@AfterMethod
	public void closeDriver() {
>>>>>>> c2f226c30aa0e10f71691bc79510cdcae9dc7ec7
		Driver.closeDriver();
	}

	@Test
	@Parameters({"userxml","passxml"})
	public  void testLoginWithValidCredentials() {
		Driver.getDriver().manage().timeouts();
		
		
		loginPage.loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
		Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders","Actual title is not equal to expected title");
		
	}
	
	@Test
	public  void testLoginInvalidCredentials() {
		
		loginPage.loginMethod(ConfigReader.getPropertyValue("invalidusername"), ConfigReader.getPropertyValue("invalidpassword"));
		Assert.assertEquals(loginPage.errorMsgLabel.getText(), "Invalid Login or Password.","Actual title is not equal to expected title");
	}
	@Test
	public  void testLoginWithEmptyCredentials() {
		
		
		loginPage.loginMethod(ConfigReader.getPropertyValue("emptyusername"), ConfigReader.getPropertyValue("emptypassword"));
		Assert.assertEquals(loginPage.errorMsgLabel.getText(), "Invalid Login or Password.","Actual title is not equal to expected title");
		
	}
	
}
