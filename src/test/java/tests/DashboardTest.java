package tests;
import java.utils.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class DashboardTest {

public static void main(String[] args) {
	LoginPage loginPage = new LoginPage();
    DashboardPage welcomeMsg = new DashboardPage();
    DashboardPage dashBoardChoices = new DashboardPage();
	
		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		
	
		loginPage.loginMethod("Tester", "test");
		
	if (DashboardPage.welcomeMsg.getText().equals(" Welcome, Tester !")){
						System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
		
//	dashBoardChoices.viewAllOrderButton.click();
//	dashBoardChoices.viewAllProducts.click();
	}
	
}
