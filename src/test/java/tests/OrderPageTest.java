package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import pages.LoginPage;
import pages.OrderPage;
import utils.Driver;

public class OrderPageTest{
	
	public static void main(String[] args) {
			
		testProcessButton ();
		testResetButton ();
				
	}
	
	public static void fillingInformations () {
				
		OrderPage orderPage = new OrderPage();
		LoginPageTest loginpage = new LoginPageTest();
		loginpage.testLoginWithValidCredentials();
		
		WebElement orders = Driver.getDriver().findElement(By.linkText("Order"));
		orders.click();
		// 7.Located dropdown and located values of products and selected "FamilyAlbum"
		WebElement dropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
		dropDown.click();
		Select select = new Select(orderPage.dropDownProduct);
		select.selectByValue("FamilyAlbum");
		// 8.Located quantity box and sendkey value
		orderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
		orderPage.quantityBox.sendKeys("20");
		// 9.locate calculate button and click
		orderPage.calculateButton.click();
		// 10.locate customername inbox and send value by faker
		String fakename = new Faker().name().firstName();
		orderPage.custName.sendKeys(fakename);
		// 11.locate street box and send value by faker
		String fakeStreet = new Faker().address().streetAddress();
		orderPage.street.sendKeys(fakeStreet);
		// 12.locate city box and send value by faker
		String fakeCity = new Faker().address().city();
		orderPage.city.sendKeys(fakeCity);
		// 13.locate state box and send value by faker
		String fakeState = new Faker().address().state();
		orderPage.State.sendKeys(fakeState);
		// 14.locate zipcode box and send value		
		orderPage.zip.sendKeys("53280");
		// 15a.Locate visa radio buttons and choose one (Lead by Refia)
		orderPage.visaButton.click();

		if (orderPage.visaButton.isSelected()) {
			System.out.println("Visa is selected, Test passing");

		} else {
			System.out.println("Visa is not selected ,Test Failed");
		}
		boolean mastercard = orderPage.masterCard.isSelected();
		boolean americanExp = orderPage.americanExpress.isSelected();
		if (mastercard || americanExp) {
			System.out.println("Wrong selection only Visa can be selected. Test is failing");

		} else {
			System.out.println("Only visa is selected. Test is passing");
			
		}

		// 15b.Locate Mastercard radio buttons and choose one
//		element.masterCard.click();
//
//		if (element.visaButton.isSelected()) {
//			System.out.println("Mastercard is selected, Test passing");
//
//		} else {
//			System.out.println("Mastercard is not selected ,Test Failed");
//		}
//		boolean mastercard1 = element.masterCard.isSelected();
//		boolean americanExp1 = element.americanExpress.isSelected();
//		if (mastercard || americanExp) {
//			System.out.println("Wrong selection only Mastercard can be selected. Test is failing");
//
//		} else {
//			System.out.println("Only Mastercard is selected. Test is passing");
//		}
//		// 15c.Locate AmericanExpress radio buttons and choose one
//		element.americanExpress.click();
//
//		if (element.visaButton.isSelected()) {
//			System.out.println("AmericanExpress is selected, Test passing");
//
//		} else {
//			System.out.println("AmericanExpress is not selected ,Test Failed");
//		}
//		boolean mastercard2 = element.masterCard.isSelected();
//		boolean americanExp2 = element.americanExpress.isSelected();
//		if (mastercard || americanExp) {
//			System.out.println("Wrong selection only AmericanExpress can be selected. Test is failing");
//
//		} else {
//			System.out.println("Only AmericanExpress is selected. Test is passing");
//		}
		
		//16.Locate cardnumber input box and enter values
		orderPage.cardNumber.sendKeys("8327856767230000");
		//17.Locate expdate input box and enter values		
		orderPage.expDate.sendKeys("01/24");
	}
	
	public static void testProcessButton () {
		
		fillingInformations();
		
		OrderPage orderPage = new OrderPage();
		orderPage.processButton.click();
		//19.Locate and verify order adding text
		if(orderPage.orderAddedText.getText().equals("New order has been successfully added.")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}
	
	public static void testResetButton () {
		
		fillingInformations();
		
		OrderPage orderPage = new OrderPage();
		orderPage.resetButton.click();
		
	}

}
