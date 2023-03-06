package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;


import utils.ConfigReader;
import utils.Driver;

import pages.LoginPage;
import pages.OrderPage;
import pages.ViewAllOrdersPage;
import utils.ConfigReader;

import utils.Driver;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		OrderPage orderPage = new OrderPage();
		LoginPage credential = new LoginPage();

		//Changes
		//hello
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Driver.getDriver().get(ConfigReader.getPropertyValue("url"));
		// 2.We created object of Loginpage and we stored login input box location
		// inside of Loginpage, and we reached out that
		// that webelement by using id of that element.We sendKeys to enter the
		// username.
		credential.userNameInput.sendKeys("Tester");
		// 3.entering password
		credential.userPasswordInput.sendKeys("test");
		// 4. clicking loging button.
		credential.loginButton.click();
		// 5. Manually checked table headers and verified if all headers are there
		// (verified by Vehbi,Farid,Refia)
		// 6.go to Orders link
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
		// 14.locate zipcode box and send value by faker
		String fakezip = new Faker().address().zipCode();
		orderPage.zip.sendKeys(fakezip);
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
		
		//16.Locate cardnumber input box and enter values by using Faker 
		String fakeCard = new Faker().phoneNumber().cellPhone();
		orderPage.cardNumber.sendKeys(fakeCard);
		//17.Locate expdate input box and enter values by using Faker 
//				String fakeExp = new Faker().date();
//				element.cardNumber.sendKeys(fakeCard);
		Actions action = new Actions(Driver.getDriver());


	}

}
