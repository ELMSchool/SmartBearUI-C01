package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import tests.LoginPageTest;
import utils.Driver;

public class OrderPage {
	
	public OrderPage() {

		PageFactory.initElements(Driver.getDriver(), this);

	}
	
	//ctl00_MainContent_fmwOrder_TextBox1
	@FindBy (id="ctl00_MainContent_fmwOrder_ddlProduct")
	public WebElement dropDownProduct;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantityBox;
	
	@FindBy (xpath = "//input[@value='Calculate']")
	public WebElement calculateButton;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_txtTotal")
	public WebElement totalBox;
	
	
	@FindBy (id="ctl00_MainContent_fmwOrder_txtName")
	public WebElement custName;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement street;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement city;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_TextBox4")
	public WebElement State;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement zip;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_cardList_0")
	public WebElement visaButton;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_cardList_1")
	public WebElement masterCard;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_cardList_2")
	public WebElement americanExpress;

	@FindBy (id="ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardNumber;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement expDate;
	
	@FindBy (id="ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement processButton;
	
	@FindBy (xpath="//*[contains(text(),'New order has been successfully added.')]")
	public WebElement orderAddedText;
	
	@FindBy (xpath="//input[@type='reset']")
	public WebElement resetButton;
	
	
}
