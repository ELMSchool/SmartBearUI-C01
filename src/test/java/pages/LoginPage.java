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

	@FindBy(id = "ctl00_MainContent_username")
	public WebElement userNameInput;

	@FindBy(id = "ctl00_MainContent_password")
	public WebElement userPasswordInput;

	@FindBy(id = "ctl00_MainContent_login_button")
	public WebElement loginButton;
	@FindBy(id = "ctl00_MainContent_status")
	public WebElement errorMsgLabel;

	public void loginMethod(String username, String password) {

		userNameInput.sendKeys(username);
		userPasswordInput.sendKeys(password);
		loginButton.click();
	}

}
