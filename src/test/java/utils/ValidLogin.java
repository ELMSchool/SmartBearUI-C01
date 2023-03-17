package utils;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.PageFactoryClass;

public class ValidLogin {
	@Test
	public  void testLoginWithValidCredentialss() {
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.getDriver().manage().timeouts();
	PageFactoryClass.loginPage().loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
	Assert.assertEquals(Driver.getDriver().getTitle(),AplicationConstants.APPLICATION_TITLE,"Actual title is not equal to expected title");
	//Driver.closeDriver();
	}

}
