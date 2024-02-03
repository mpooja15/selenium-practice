package com.test.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class W3School {
	public static void myFunc(WebDriver driver) {
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		driver.manage().window().maximize();
		List<WebElement> element = driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr"));
		String[] beforeSort_name = new String[element.size()];
		// Get the text into the array
		for (int i = 0; i < element.size(); i++) {
			beforeSort_name[i] = element.get(i).getText().trim();
			System.out.println(beforeSort_name[i]);
			// Verify the element with the table data
			if (element.get(i).getText().equals("Koniglich Essen Germany")) {
				System.out.println("Company Name : " + element.get(i).getText() + " is found at position " + (i));
				break;
			}
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\driver-chrome\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		myFunc(driver);
		driver.quit();
		
	}
}