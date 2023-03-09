package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;
import utils.Driver;

public class DashboardPage {

	public DashboardPage() {

		PageFactory.initElements(Driver.getDriver(), this);

	}
	
//Finding Element Welcome Tester

	@FindBy(xpath="*[contains(text(),'\"login_info')]")
	public static  WebElement welcomeMsg;
//	
//	@FindBy(xpath =(// href/"Default.aspx"))
//	public  WebElement viewAllOrderButton;
//	
//	@FindBy(xpath ="//input[@value = 'View all products'" )
//	public WebElement viewAllProducts;
//
//	

}
