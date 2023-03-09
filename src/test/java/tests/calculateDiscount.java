package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.OrderPage;
import utils.Driver;

public class calculateDiscount {

	public static void main(String[] args) throws InterruptedException {

		LoginPageTest.testLoginWithValidCredentials();
		selectOrders();
// 	myMoney();
//        familyAlbum();
	screenSaver();

		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public static void selectOrders() {
		OrderPage orderPage = new OrderPage();
		// 6.go to Orders link
		WebElement orders = Driver.getDriver().findElement(By.linkText("Order"));
		orders.click();
		// 7.Located dropdown and located values of products and selected "FamilyAlbum"
		WebElement dropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
		dropDown.click();

	}

	public static  String familyAlbum() {

		int percentage = 15;
		int quantityBox = 0;

		OrderPage orderPage = new OrderPage();

		Select select = new Select(orderPage.dropDownProduct);
		select.selectByValue("FamilyAlbum");

		// 8.Located quantity box and sendkey value
		orderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
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
		return totalBox;
	}
	
	public static  String myMoney() {

		int percentage =8;
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
		return totalBox;
	}
	
	public static  String screenSaver() {

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
		return totalBox;
	}
	
}
