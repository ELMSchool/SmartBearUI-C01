package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class ViewAllProductsPage {
	
	public ViewAllProductsPage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath="//*[contains(text(),'Product name')]")
	public WebElement productNameText;
	
	@FindBy (xpath="//*[contains(text(),'Price')]")
	public WebElement priceText;
	
	@FindBy (xpath="//*[contains(text(),'Discount')]")
	public WebElement discountText;
	
	@FindBy (xpath = "//*[contains(text(),'MyMoney')]")
	public WebElement myMoneyText;
	
	@FindBy (xpath = "//*[contains(text(),'FamilyAlbum')]")
	public WebElement familyAlbumText;
	
	@FindBy (xpath = "//*[contains(text(),'ScreenSaver')]")
	public WebElement screenSaverText;
	
	@FindBy (xpath = "//*[contains(text(),'$100')]")
	public WebElement $100Text;
	
	@FindBy (xpath = "//*[contains(text(),'$80')]")
	public WebElement $80Text;
	
	@FindBy (xpath = "//*[contains(text(),'$20')]")
	public WebElement $20Text;
	
	@FindBy (xpath = "//*[contains(text(),'8%')]")
	public WebElement percentage8Text;
	
	@FindBy (xpath = "//*[contains(text(),'15%')]")
	public WebElement percentage15Text;
	
	@FindBy (xpath = "//*[contains(text(),'10%')]")
	public WebElement percentage10Text;
	
	

}
