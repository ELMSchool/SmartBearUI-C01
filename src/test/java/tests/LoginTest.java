package tests;

import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class LoginTest {
	public static void main(String []args) {
		
		testLoginWithValidCredentials();
		testLoginInvalidCredentials();
		
	}

	public static void testLoginWithValidCredentials() {
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		new LoginPage().loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
		if(Driver.getDriver().getTitle().equals("Web Orders")){
			System.out.println("Passed");
			
		}else {
			System.out.println("Failed");
		}
		Driver.closeDriver();
		
	}
	public static void testLoginInvalidCredentials() {
		//
		LoginPage loginpage = new LoginPage();
		
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		loginpage.loginMethod(ConfigReader.getPropertyValue("invalidusername"), ConfigReader.getPropertyValue("invalidpassword"));
		if(loginpage.errorMsgLabel.getText().equals("Invalid Login or Password.")){
			System.out.println("Passed");
			
		}else {
			System.out.println("Failed");
		}
		Driver.closeDriver();
		
	}
}
