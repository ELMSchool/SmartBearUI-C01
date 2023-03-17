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
import org.testng.annotations.DataProvider;

import static pages.PageFactoryClass.*;

import org.testng.annotations.Test;
public class LoginPageTest {
	@DataProvider
	public Object [][] loginInputCredentials(){
		
		return new Object[][] {
			{"Tester","test"},
			{"invalidUsername","invalidPassword"},
			{"",""},
			{"Tester","invalidPassword"},
			{"invalidUsername","test"},
			{"Tester",""},
			{"","test"},
		};
	}
	

	
	@BeforeMethod
	public void setUpDriverAndNavigateToUrl() {
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	

	@AfterMethod
	public void closeDriver() {

		Driver.closeDriver();
	}
	

	@Test(dataProvider = "loginInputCredentials")
	public  void testLoginWithDataProvider(String username,String password) {
		Driver.getDriver().manage().timeouts();
	PageFactoryClass.loginPage().loginMethod(username,password);
	Assert.assertEquals(Driver.getDriver().getTitle(),AplicationConstants.APPLICATION_TITLE,"Actual title is not equal to expected title");
	}
	
	
	
	
	//Tests are under this line, datas provided by @Parameter
	
//	public  void testLoginWithValidCredentialss() {
//	Driver.getDriver().manage().timeouts();
//PageFactoryClass.loginPage().loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
//Assert.assertEquals(Driver.getDriver().getTitle(),AplicationConstants.APPLICATION_TITLE,"Actual title is not equal to expected title");
//}
	
//	@Test (description = "Login with valid credentials passed by parameter")
//	@Parameters ( {"username","password"} )
//	public  void testLoginWithValidCredentialsByParameter(String username, String password) {
//		Driver.getDriver().manage().timeouts();
//	loginPage().loginMethod(username,password);
//	Assert.assertEquals(Driver.getDriver().getTitle(),AplicationConstants.APPLICATION_TITLE,"Actual title is not equal to expected title");
//	}
//	
//	@Test (description = "Login with valid credentials passed by parameter")
//	@Parameters ( {"invalidusername","invalidpassword"} )
//	public  void testLoginWithinValidCredentialsByParameter(String username, String password) {
//		Driver.getDriver().manage().timeouts();
//	loginPage().loginMethod(username,password);
//	Assert.assertEquals(Driver.getDriver().getTitle(),AplicationConstants.APPLICATION_TITLE,"Actual title is not equal to expected title");
//	}
	
	
	
}
