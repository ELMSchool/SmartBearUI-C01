package tests;

import static pages.PageFactoryClass.*;

import pages.LoginPage;
import pages.PageFactoryClass;

public class Dashboardtest2 {
	
	public static void main(String[] args) {
		
		loginFromPageFactory().testLoginWithValidCredentialss();
	    dashboardpage().dashboardPages("Order").click();
	}

}
