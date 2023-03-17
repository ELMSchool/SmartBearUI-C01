package tests;

import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class LoginPageTest {
	
	
	
	@AfterMethod (dependsOnMethods = {"testLoginWithValidCredentials","testLoginInvalidCredentials","testLoginWithEmptyCredentials"})
	public void closeDriver() throws InterruptedException {
		Thread.sleep(4000);
		Driver.closeDriver();
	}

	@Test
	@Parameters({"userxml","passxml"})
	public  void testLoginWithValidCredentials() {
		Driver.getDriver().manage().timeouts();
		
		
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		new LoginPage().loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
		
		Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders","Actual title is not equal to expected title");
		
	}
	
	@Test
	public  void testLoginInvalidCredentials() {
		LoginPage loginpage = new LoginPage();
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		loginpage.loginMethod(ConfigReader.getPropertyValue("invalidusername"), ConfigReader.getPropertyValue("invalidpassword"));
		Assert.assertEquals(loginpage.errorMsgLabel.getText(), "Invalid Login or Password.","Actual title is not equal to expected title");
	}
	@Test
	public  void testLoginWithEmptyCredentials() {
		LoginPage loginpage = new LoginPage();
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		loginpage.loginMethod(ConfigReader.getPropertyValue("emptyusername"), ConfigReader.getPropertyValue("emptypassword"));
		Assert.assertEquals(loginpage.errorMsgLabel.getText(), "Invalid Login or Password.","Actual title is not equal to expected title");
		
	}
	
}
