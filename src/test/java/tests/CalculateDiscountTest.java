package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.LoginPage;
import pages.OrderPage;
import utils.ConfigReader;
import utils.Driver;

public class CalculateDiscountTest {

//    myMoney();
//          familyAlbum();
//		    screenSaver();

//		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	@BeforeSuite
	public void testLoginWithValidCredentials() {

		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		new LoginPage().loginMethod(ConfigReader.getPropertyValue("username"),
				ConfigReader.getPropertyValue("password"));

		if (Driver.getDriver().getTitle().equals("Web Orders")) {
			System.out.println("Passed");

		} else {
			System.out.println("Failed");
		}
	}

	@BeforeTest

	public void selectOrders() {

		// 6.go to Orders link
		WebElement orders = Driver.getDriver().findElement(By.linkText("Order"));
		orders.click();
		// 7.Located drop down and located values of products and selected "FamilyAlbum"
		WebElement dropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
		dropDown.click();

	}

	@Test(priority = 0)
	public void familyAlbum() {

		int percentage = 15;
		int quantityBox = 0;

		OrderPage orderPage = new OrderPage();

		Select select = new Select(orderPage.dropDownProduct);
		select.selectByValue("FamilyAlbum");

		// 8.Located quantity box and sendkey value
		orderPage.quantityBox.sendKeys(Keys.BACK_SPACE);

		orderPage.quantityBox.click();
		orderPage.quantityBox.sendKeys("8");

		// locate calculate button and click
		orderPage.calculateButton.click();

		// locate total box
		String totalBox = orderPage.totalBox.getAttribute("value");

		Integer total = Integer.valueOf(totalBox);

		if (quantityBox >= 10) {
			total = total - (total * percentage / 100);
			System.out.println("Total Price is :$" + total);
		} else {
			System.out.println("Total Price is :$" + total);
		}

		// 9.locate calculate button and click
		orderPage.calculateButton.click();
//		return totalBox;
	}

	@Test(priority = 1)
	public void myMoney() {

		int percentage = 8;
		int quantityBox = 0;

		OrderPage orderPage = new OrderPage();

		Select select = new Select(orderPage.dropDownProduct);
		select.selectByValue("MyMoney");

		// 8.Located quantity box and sendkey value
		orderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
		orderPage.quantityBox.sendKeys("10");

		// locate calculate button and click
		orderPage.calculateButton.click();

		// locate total box
		String totalBox = orderPage.totalBox.getAttribute("value");

		Integer total = Integer.valueOf(totalBox);

		if (quantityBox >= 10) {
			total = total - (total * percentage / 100);
			System.out.println("Total Price is :$" + total);
		} else {
			System.out.println("Total Price is :$" + total);
		}

		// 9.locate calculate button and click
		orderPage.calculateButton.click();
//		return totalBox;
	}

	@Test(priority = 2)
	public void screenSaver() {

		int percentage = 10;
		int quantityBox = 0;

		OrderPage orderPage = new OrderPage();

		Select select = new Select(orderPage.dropDownProduct);
		select.selectByValue("ScreenSaver");

		// 8.Located quantity box and sendkey value
		orderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
		orderPage.quantityBox.sendKeys("10");

		// locate calculate button and click
		orderPage.calculateButton.click();

		// locate total box
		String totalBox = orderPage.totalBox.getAttribute("value");

		Integer total = Integer.valueOf(totalBox);

		if (quantityBox >= 10) {
			total = total - (total * percentage / 100);
			System.out.println("Total Price is :$" + total);
		} else {
			System.out.println("Total Price is :$" + total);
		}

		// 9.locate calculate button and click
		orderPage.calculateButton.click();
//		return totalBox;
	}
	@AfterSuite
	 public void close() {
		 
		 Driver.closeDriver();
			
	 }

}
