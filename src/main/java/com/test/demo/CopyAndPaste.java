package com.test.demo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


		public class CopyAndPaste {

		    public static void main(String[] args) {
		        System.setProperty("webdriver.chrome.driver",
		                "D:\\chromedriver-win64\\chromedriver-win64-125\\chromedriver-win64\\chromedriver.exe");
		        WebDriver driver = new ChromeDriver();
		        openNewTab(driver);
		        driver.quit();
		    }

		    public static void openNewTab(WebDriver driver) {
		        // Open Google in the first tab
		        driver.get("https://gist.github.com/nareshrathnam/e2f7a9a152a65af1a552e243987fb731");
		        driver.findElement(By.xpath("(//*[@id=\"clipboard-button\"])[2]")).click();

		        // Open a new tab
		        ((JavascriptExecutor) driver).executeScript("window.open()");

		        // Switch to the new tab
		        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		        driver.switchTo().window(tabs.get(1));

		        // Navigate to a different URL in the new tab
		        driver.get("https://www.google.com/?safe=active&ssui=on");
		        driver.findElement(By.name("q")).sendKeys(Keys.CONTROL + "v");
		        

		        // Wait for a few seconds to see the result (you can adjust or remove this)
		        try {
		            Thread.sleep(3000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		        // Optionally, switch back to the first tab
		        // driver.switchTo().window(tabs.get(0));
		    }
		
	}


