package utils;

import java.util.Scanner;

import pages.OrderPage;

public class CalculateDiscount {

	public static void main(String[] args) {

		discountMyMoney();
		//discountFamilyAlbum();
		//discountScreenSaver();
	}

//	If a product is ordered in the ‘Quantity’ of 10 or more,
//	then the ‘Discount’ from ‘List of Products' page will become active - see below:

	public static void discountMyMoney() {


     	OrderPage orderPage = new OrderPage();
		
		int quantity = 0;

		int totalPrice = 100 * quantity;
		int percentage = 8;
		if (quantity >= 10) {
			totalPrice = totalPrice - (totalPrice * percentage / 100);
			System.out.println("Total Price is :$" + totalPrice);
		} else {
			System.out.println("Total Price is :$" + totalPrice);
		}

	}

	public static void discountFamilyAlbum() {

		int quantity = 0;

		int totalPrice = 80 * quantity;
		int percentage = 15;
		if (quantity >= 10) {
			totalPrice = totalPrice - (totalPrice * percentage / 100);
			System.out.println("Total Price is :$" + totalPrice);
		} else {
			System.out.println("Total Price is :$" + totalPrice);

		}
	}

	public static void discountScreenSaver() {

		int quantity = 0;
		int totalPrice = 20 * quantity;
		int percentage = 10;
		if (quantity >= 10) {
			totalPrice = totalPrice - (totalPrice * percentage / 100);
			System.out.println("Total Price is :$" + totalPrice);
		} else {
			System.out.println("Total Price is :$" + totalPrice);
		}

	}
}
