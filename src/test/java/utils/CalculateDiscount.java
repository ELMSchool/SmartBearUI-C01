package utils;

import java.util.Scanner;

public class CalculateDiscount {

	public static void main(String[] args) {

		discountMyMoney();
		discountFamilyAlbum();
		discountScreenSaver();
	}

//	If a product is ordered in the ‘Quantity’ of 10 or more,
//	then the ‘Discount’ from ‘List of Products' page will become active - see below:

	public static void discountMyMoney() {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the quantity for My Money");
		int quantity = input.nextInt();

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

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the quantity for Family Album");
		int quantity = input.nextInt();

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

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the quantity for Screen Saver");
		int quantity = input.nextInt();

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
