package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class DashboardPageTableHeaders {

	public DashboardPageTableHeaders() {
		PageFactory.initElements(Driver.getDriver(), this);

	}

	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(2)")
	public WebElement nameHeader;
	
	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(3)")
	public WebElement productHeader;

	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(4)")
	public WebElement quantityHeader;

	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(5)")
	public WebElement dateHeader;

	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(6)")
	public WebElement streetHeader;

	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(7)")
	public WebElement cityHeader;

	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(8)")
	public WebElement stateHeader;

	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(9)")
	public WebElement zipcodeHeader;

	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(10)")
	public WebElement cardTypeHeader;

	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(11)")
	public WebElement cardNumberHeader;

	@FindBy(css = "table[class='SampleTable']>tbody>tr:nth-of-type(1)>th:nth-of-type(12)")
	public WebElement expNumberHeader;

	@FindBy(xpath = "//input[@type ='checkbox']")
	public  WebElement checkbox;
}
