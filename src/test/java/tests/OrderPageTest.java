package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.LoginPage;
import pages.OrderPage;
import utils.Driver;

public class OrderPageTest{
    
	@AfterMethod
    public void closePages() {
   	Driver.closeDriver();    
   	}
  
	
	@Test
	public  void fillingInformations () {
				
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
		// 15a.Locate visa radio buttons and choose one 
		orderPage.visaButton.click();
		Assert.assertTrue(orderPage.visaButton.isSelected(), "Visa is not selected");
		
		orderPage.masterCard.click();
		Assert.assertTrue(orderPage.masterCard.isSelected(), "MasterCard is not selected");
		
		orderPage.americanExpress.click();
		Assert.assertTrue(orderPage.americanExpress.isSelected(), "AmericanExpress is not selected");

		
		//16.Locate cardnumber input box and enter values
		orderPage.cardNumber.sendKeys("8327856767230000");
		//17.Locate expdate input box and enter values		
		orderPage.expDate.sendKeys("01/24");
	}
	@Test
	public  void testProcessButton () {
		
		fillingInformations();
		
		OrderPage orderPage = new OrderPage();
		orderPage.processButton.click();
		//19.Locate and verify order adding text
		Assert.assertEquals(orderPage.orderAddedText.getText(), "New order has been successfully added.","Order has not been processed");
	}
	@Test
	public  void testResetButton () {
		
		fillingInformations();
		
		OrderPage orderPage = new OrderPage();
		orderPage.resetButton.click();
		
	}

}
