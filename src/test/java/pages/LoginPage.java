package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Driver;

public class LoginPage {
	public LoginPage() {

		PageFactory.initElements(Driver.getDriver(), this);

	}
//	@FindBy(id="userName")
//	public WebElement fullNameInputBox;
	////ctl00_MainContent_login_button
	
	@FindBy (id="ctl00_MainContent_username")
	public WebElement userNameInput;
	
	@FindBy (id="ctl00_MainContent_password")
	public WebElement userPasswordInput;
	
	@FindBy (id="ctl00_MainContent_login_button")
	public WebElement loginButton;
	
	

}
