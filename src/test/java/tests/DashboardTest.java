package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class DashboardTest {

	public static void main(String[] args) {


		LoginPage loginPage = new LoginPage();
		DashboardPage dashBoardChoices = new DashboardPage();

		LoginPageTest loginpage = new LoginPageTest();
		loginpage.testLoginWithValidCredentials();
		verifyDashBoardPage();
		verifyviewAllOrderButton();
		verifyviewAllProductsButton();
		verifyorderButton();
 	    verifylogoutButton();
	}
@Test
	public static void verifyDashBoardPage() {
	
	String  WelcomeMessage = (" Welcome, Tester!");
System.out.println(WelcomeMessage);
		if  (DashboardPage.webOrders.getText().equals(WelcomeMessage)){
	
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		}
	

	public static void verifyviewAllOrderButton() {
		DashboardPage dashBoardChoices = new DashboardPage();

		dashBoardChoices.viewAllOrderButton.click();

	}

	public static void verifyviewAllProductsButton() {
		DashboardPage dashBoardChoices = new DashboardPage();

		dashBoardChoices.viewAllProductsButton.click();

	}

	public static void verifyorderButton() {
		DashboardPage dashBoardChoices = new DashboardPage();

		dashBoardChoices.orderButton.click();

	}

	public static void verifylogoutButton() {
		DashboardPage dashBoardChoices = new DashboardPage();

		dashBoardChoices.logoutButton.click();

	}




}
