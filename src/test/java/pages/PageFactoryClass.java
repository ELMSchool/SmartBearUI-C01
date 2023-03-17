package pages;

import org.openqa.selenium.WebDriver;


public class  PageFactoryClass {
//	private WebDriver driver;
//	public PageFactoryClass (WebDriver driver) {
//		this.driver = driver ;
//	}
	
	public static LoginPage loginPage () {
		return new LoginPage();
	}
	public static OrderPage orderPage () {
		return new OrderPage();
	}

	public static ViewAllOrdersPage viewAllordersPage () {
		return new ViewAllOrdersPage();
	}
	public static ViewAllProductsPage viewAllproductsPage () {
		return new ViewAllProductsPage();
	}
}
