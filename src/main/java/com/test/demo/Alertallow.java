package com.test.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alertallow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver-win64\\chromedriver-win64-125\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		openUrl(driver);
		driver.quit();

	}
	
	public static void openUrl(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		
		
		driver.get("https://www.rapidtables.com/tools/camera.html");
		
		Thread.sleep(30000);
		
		driver.findElement(By.xpath("//*[@id=\"rcol\"]/ul[1]/li[1]/a")).click();
		
		 driver.getCurrentUrl();
		
		
		
		/*Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"button-init\"]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"button-start\"]")).click();
		Thread.sleep(3000);
		
		
		
		Alert alert =driver.switchTo().alert();
		alert.accept(); */
		
		
		
	}

}
