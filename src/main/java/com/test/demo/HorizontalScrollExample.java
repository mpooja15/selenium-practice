package com.test.demo;

//Import required classes
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HorizontalScrollExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver-win64\\chromedriver-win64-125\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Navigate to the webpage with horizontal scrolling
		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_image_gallery_scroll");

		// Get JavascriptExecutor instance
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Execute script to scroll horizontally by a certain amount (pixels)
		js.executeScript("window.scrollBy(500,0)"); // Replace 2000 with desired pixel value

		// Alternatively, you can scroll to a specific element using its coordinates
		// WebElement element = driver.findElement(By.id("scrollToHere"));
		// js.executeScript("arguments[0].scrollIntoView(true)", element);

		// Perform your tests after scrolling

		// Close the browser (optional)
		driver.quit();
	}
}
