package com.test.demo;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver-win64\\chromedriver-win64-125\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("accept")).click();
		//switching to alert
		Alert alert =driver.switchTo().alert();
		
		//getting alert by using getText method
		String alertMessage=alert.getText(); 
		System.out.println("Message:->"+alertMessage);
		
		//accept alert - simple alert
		alert.accept();
		Thread.sleep(3000);
		
		//confirm alert
		
		driver.findElement(By.id("confirm")).click();
		Alert confirmalrt =driver.switchTo().alert();
		String confdismiss=confirmalrt.getText(); 
		System.out.println("Confirm alert dismiss:->"+confdismiss);
		
		//dismissing the alert. cancel
		
		confirmalrt.dismiss();
		Thread.sleep(3000);
		
		driver.findElement(By.id("confirm")).click();
		Alert confirmalrt1 =driver.switchTo().alert();
		String confok=confirmalrt1.getText(); 
		System.out.println("Confirm alert accept:->"+confok);
		confirmalrt1.accept();
		
		//Prompt alert
		
		driver.findElement(By.id("prompt")).click();
		Alert prompt =driver.switchTo().alert();
		String text=prompt.getText(); 
		System.out.println("Prompt alert:->"+text);
		prompt.sendKeys("Pooja Thamizh"); // we can't see the entered data on alert prompt
		Thread.sleep(3000);
		//File src=driver.getScreenshotAs(OutputType.FILE); // we can't take image when an alert is active
		//File des= new File("./snaps/alert.png"); //but i want to give a try
		prompt.accept();
		String verify=driver.findElement(By.id("myName")).getText();
		System.out.println("Verifying the name gave on prompt:->"+verify);
		
		driver.getCurrentUrl();
		
		driver.quit();
		
		
		

	}

	

}

//notes
//1. NoAlertPresentException : when we tried to handle the alert without alert we will get this exception.
//2.UnhandledAlertException: we will get this exception when we have not handled an alert.
