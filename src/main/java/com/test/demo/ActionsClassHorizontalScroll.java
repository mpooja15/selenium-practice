package com.test.demo;

import java.io.File;
import java.io.IOException;

//Import required classes
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class ActionsClassHorizontalScroll {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Set the path to your ChromeDriver executable
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver-win64\\chromedriver-win64-125\\chromedriver-win64\\chromedriver.exe");

		// Initialize ChromeDriver
		WebDriver driver = new ChromeDriver();

		// Open a webpage
		driver.get("https://www.w3schools.com/howto/howto_css_menu_horizontal_scroll.asp");

		// Find the element you want to scroll into view
		WebElement element = driver.findElement(By.xpath("//*[text()=\"Work\"]"));

		// Create an instance of Actions class
		Actions actions = new Actions(driver);

		// Scroll horizontally to the element
		actions.moveToElement(element).perform();
		
		Thread.sleep(3000);

		// Close the browser
		driver.quit();
	}
}
