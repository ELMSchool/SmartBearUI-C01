package tests;

import pages.LoginPage;
import utils.ConfigReader;

import utils.Driver;

public class Test {

	public static void main(String[] args) {
		LoginPage credential = new LoginPage();
		
		
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		//2.We created object of Loginpage and we stored login input box location inside of Loginpage, and we reached out that 
		//that webelement by using id of that element.We sendKeys to enter the username.
		credential.userNameInput.sendKeys("Tester");
		//3.entering password
		credential.userPasswordInput.sendKeys("test");
		//4. clicking loging button
		credential.loginButton.click();
		

		
	}

}
