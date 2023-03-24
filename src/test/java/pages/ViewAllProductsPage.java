package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class ViewAllProductsPage {
	
	public ViewAllProductsPage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (css="table[class='ProductsTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(1)")
	public WebElement productNameText;
	
	@FindBy (css="table[class='ProductsTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement priceText;
	
	@FindBy (css="table[class='ProductsTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(3)")
	public WebElement discountText;
	
	@FindBy (css = "table[class='ProductsTable']>tbody>tr:nth-of-type(2)>td:nth-of-type(1)")
	public WebElement myMoneyText;
	
	@FindBy (css = "table[class='ProductsTable']>tbody>tr:nth-of-type(3)>td:nth-of-type(1)")
	public WebElement familyAlbumText;
	
	@FindBy (css = "table[class='ProductsTable']>tbody>tr:nth-of-type(4)>td:nth-of-type(1)")
	public WebElement screenSaverText;
	
	@FindBy (css = "table[class='ProductsTable']>tbody>tr:nth-of-type(2)>td:nth-of-type(2)")
	public WebElement $100Text;
	
	@FindBy (css = "table[class='ProductsTable']>tbody>tr:nth-of-type(3)>td:nth-of-type(2)")
	public WebElement $80Text;
	
	@FindBy (css = "table[class='ProductsTable']>tbody>tr:nth-of-type(4)>td:nth-of-type(2)")
	public WebElement $20Text;
	
	@FindBy (css = "table[class='ProductsTable']>tbody>tr:nth-of-type(2)>td:nth-of-type(3)")
	public WebElement percentage8Text;
	
	@FindBy (css = "table[class='ProductsTable']>tbody>tr:nth-of-type(3)>td:nth-of-type(3)")
	public WebElement percentage15Text;
	
	@FindBy (css = "table[class='ProductsTable']>tbody>tr:nth-of-type(4)>td:nth-of-type(3)")
	public WebElement percentage10Text;
	
	

}
