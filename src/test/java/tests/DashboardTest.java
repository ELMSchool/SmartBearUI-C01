package tests;

import org.openqa.selenium.By;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Driver;

public class DashboardTest {

	public static void main(String[] args) {

		LoginPage loginPage = new LoginPage();
		DashboardPage dashBoardChoices = new DashboardPage();

		LoginPageTest.testLoginWithValidCredentials();
		verifyDashBoardPage();
		verifyviewAllOrderButton();
		verifyviewAllProductsButton();
		verifyorderButton();
		verifylogoutButton();
	}

	public static void verifyDashBoardPage() {
		DashboardPage.webOrders = Driver.getDriver().findElement(By.tagName("h1"));

		if (DashboardPage.webOrders.getText().equals("Web Orders")) {
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
