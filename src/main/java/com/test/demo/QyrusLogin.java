package com.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QyrusLogin {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.setProperty("webdriver.chrome.driver",
			"D:\\driver-chrome\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	
	LoginFuncXpath(driver);
	
	
	}

	public static void LoginFuncXpath(ChromeDriver driver) {
		
		driver.get("https://stg-testcloud.quinnox.info/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement usernameInput = driver.findElement(By.name("username"));
		usernameInput.sendKeys("mpooja@quinnox.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElementByXPath("//span[.=\"Sign In\"]").click();
		//driver.quit();
		

	}

}
