package tests;

import com.github.javafaker.Faker;

import pages.LoginPage;
import pages.OrderPage;
import pages.ViewAllOrdersPage;
import utils.ConfigReader;
import utils.Driver;

public class ViewAllOrdersTest {
	public static void main(String[] args) {
		
		
		isPaulStillThere();
		
		
		
		
		

}
	public static void isPaulStillThere() {
		ViewAllOrdersPage  allOrdersPage = new ViewAllOrdersPage() ;
		OrderPage orderpage = new OrderPage() ;
		//ctl00_MainContent_fmwOrder_txtName
		LoginPageTest.testLoginWithValidCredentials();
		//1.Will edit 1 st order 
		//2.get text of Paul Brown for verification
		String actualPaulBrown = allOrdersPage.paulBrown.getText();
		allOrdersPage.firstRowEditOrder.click();
		//3. Will change Paul Brown to John Doe
		orderpage.custName.clear();
		String fakename = new Faker().name().firstName();
		orderpage.custName.sendKeys(fakename);
		//4 will update changes
		allOrdersPage.updateButton.click();
		//5. writing our if else statement if Paul Brown name is Still in our allorder page or not
		if(allOrdersPage.paulBrown.getText().equals(actualPaulBrown)) {
			System.out.println("Test Failed");
		}else {
			System.out.println("Test Passed");
		}
		
	}
}
