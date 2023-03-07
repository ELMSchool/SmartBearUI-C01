package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import utils.Driver;

public class ViewAllOrdersPage {
	public ViewAllOrdersPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	//1.Locating Table Headers
	////table[@class='SampleTable']//th
	@FindBy(xpath = "//table[@class='SampleTable']//th")
	public WebElement tableHeader;
			
	

	
}

