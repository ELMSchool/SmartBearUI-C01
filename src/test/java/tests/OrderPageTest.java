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
import static pages.PageFactoryClass.*;

public class OrderPageTest{
    
	@AfterMethod
    public void closePages() {
   	Driver.closeDriver();    
   	}
  
	
	@Test
	public  void fillingInformations () {
				

		loginFromPageFactory().testLoginWithValidCredentialss();
		
		WebElement orders = Driver.getDriver().findElement(By.linkText("Order"));
		orders.click();
		
		WebElement dropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
		dropDown.click();
		Select select = new Select(orderPage().dropDownProduct);
		select.selectByValue("FamilyAlbum");
		
		orderPage().quantityBox.sendKeys(Keys.BACK_SPACE);
		orderPage().quantityBox.sendKeys("20");
		
		orderPage().calculateButton.click();
		
		String fakename = new Faker().name().firstName();
		orderPage().custName.sendKeys(fakename);
		
		String fakeStreet = new Faker().address().streetAddress();
		orderPage().street.sendKeys(fakeStreet);
		
		String fakeCity = new Faker().address().city();
		orderPage().city.sendKeys(fakeCity);
		
		String fakeState = new Faker().address().state();
		orderPage().State.sendKeys(fakeState);
	
		orderPage().zip.sendKeys("53280");
		
		orderPage().visaButton.click();
		Assert.assertTrue(orderPage().visaButton.isSelected(), "Visa is not selected");
		
		orderPage().masterCard.click();
		Assert.assertTrue(orderPage().masterCard.isSelected(), "MasterCard is not selected");
		
		orderPage().americanExpress.click();
		Assert.assertTrue(orderPage().americanExpress.isSelected(), "AmericanExpress is not selected");

		
		orderPage().cardNumber.sendKeys("8327856767230000");
	
		orderPage().expDate.sendKeys("01/24");
	}
	@Test
	public  void testProcessButton () {
		
		fillingInformations();
		
		orderPage().processButton.click();
		//19.Locate and verify order adding text
		Assert.assertEquals(orderPage().orderAddedText.getText(), "New order has been successfully added.","Order has not been processed");
	}
	@Test
	public  void testResetButton () {
		
		fillingInformations();
		
		OrderPage orderPage = new OrderPage();
		orderPage.resetButton.click();
		
	}

}
