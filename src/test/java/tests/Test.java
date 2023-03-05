package tests;

import utils.ConfigReader;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(ConfigReader.getPropertyValue("url"));
	}

}
