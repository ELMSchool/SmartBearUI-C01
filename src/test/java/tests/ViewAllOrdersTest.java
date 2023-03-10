package tests;

import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class ViewAllOrdersTest {
	public static void main(String[] args) {
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		new LoginPage().loginMethod(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
	}

}
