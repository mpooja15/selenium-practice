package com.test.demo;

import java.util.logging.Logger;

import org.apache.log4j.spi.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {


	public static void main(String[] args) throws InterruptedException {
		
		//logger
		final Logger log = Logger.getLogger(NavigationCommands.class.getName());
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\\\driver-chrome\\\\chromedriver-win32\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://stg-testcloud.quinnox.info/");
		log.severe("qyrus app started");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("mpooja@quinnox.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/form/div[4]/button")).click();
		
		Thread.sleep(9000);
		
		
		
		/*if (driver.findElement(By.xpath("//*[text()=\"Multiple Sessions Detected!\"]"))).isDisplayed() {
			
		}*/
		
		boolean isPopup = driver.findElement(By.xpath("//*[text()=\"Multiple Sessions Detected!\"]")).isDisplayed();
		
		Thread.sleep(4000);
		
		if(isPopup){
			driver.findElement(By.xpath("//*[@id=\"terminateremote\"]")).click();
			Thread.sleep(3000);
		}
		
		
		
		driver.findElement(By.xpath("//*[@id=\"services\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Web Testing\"]/li/span")).click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		System.out.println("current url "+ driver.getCurrentUrl());
		System.out.println("Title "+driver.getTitle());
		
		driver.navigate().to("https://stg-testcloud.quinnox.info/");
		driver.navigate().refresh();
			
		
		driver.quit();
	}

}
