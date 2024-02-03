package com.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class QyrusProgram {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\driver-chrome\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		ChromeDriver obj = new ChromeDriver();
	   obj.get("https://stg-testcloud.quinnox.info/");
	   obj.getTitle();
	   System.out.println("Title of the page "+obj.getTitle());
	   obj.getCurrentUrl();
	   System.out.println("URL of the page "+ obj.getCurrentUrl());
	   
	   
	   obj.quit();
	   

	}

}
