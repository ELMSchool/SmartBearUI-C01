package tests;

import pages.LoginPage;
import utils.AplicationConstants;
import utils.ConfigReader;
import utils.Driver;
import  pages.PageFactoryClass;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Parameters;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import static pages.PageFactoryClass.*;

import org.testng.annotations.Test;
public class LoginPageTest {
	

	
	@BeforeMethod
	public void setUpDriverAndNavigateToUrl() {
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	

	@AfterMethod
	public void closeDriver() {

		Driver.closeDriver();
	}
	@Test
	public  void testLoginWithValidCredentialss() {
		Driver.getDriver().manage().timeouts();
	PageFactoryClass.loginPage().loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
	Assert.assertEquals(Driver.getDriver().getTitle(),AplicationConstants.APPLICATION_TITLE,"Actual title is not equal to expected title");
	}
	
	
	@Test
	public  void testLoginInvalidCredentials() {
		
		loginPage().loginMethod(ConfigReader.getPropertyValue("invalidusername"), ConfigReader.getPropertyValue("invalidpassword"));	
		Assert.assertEquals(loginPage().errorMsgLabel.getText(), AplicationConstants.LOGIN_ERROR_MESSAGE,"Actual title is not equal to expected title");
	}
	@Test
	public  void testLoginWithEmptyCredentials() {
		
		
		loginPage().loginMethod(ConfigReader.getPropertyValue("emptyusername"), ConfigReader.getPropertyValue("emptypassword"));
		Assert.assertEquals(loginPage().errorMsgLabel.getText(), "Invalid Login or Password.","Actual title is not equal to expected title");
		
	}
	
}
