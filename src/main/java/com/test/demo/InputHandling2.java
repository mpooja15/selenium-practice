package com.test.demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputHandling2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver-win64\\chromedriver-win64-125\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		openLetCode(driver);
		driver.quit();

	}

	public static void openLetCode(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.get("https://letcode.in/edit");

		// entering name

		driver.findElement(By.id("fullName")).sendKeys("Pooja");

		// appending the text and performing sendkey opeartion

		driver.findElement(By.id("join")).sendKeys("-Person", Keys.TAB);

		// get attribute

		String attribute = driver.findElement(By.id("getMe")).getAttribute("value");
		System.out.println(attribute);

		// clear

		driver.findElement(By.id("clearMe")).clear();

		// element disabled

		boolean isDisabled = driver.findElement(By.xpath("//*[@id=\"noEdit\"]")).isEnabled();
		System.out.println(isDisabled);

		driver.quit();

	}

}
