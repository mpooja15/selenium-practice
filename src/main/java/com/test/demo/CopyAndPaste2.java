package com.test.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

public class CopyAndPaste2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		copyAndNavigateToNewTab(driver);
		driver.quit();
	}

	public static void copyAndNavigateToNewTab(WebDriver driver) {
		try {
			// Navigate to the W3Schools site
			driver.get("https://github.com/mpooja15/selenium-4/blob/main/google-safe-session");

			// Wait for the page to load
			Thread.sleep(3000);

			// Click the copy button
			driver.findElement(By.xpath("//*[@id=\"repos-sticky-header\"]/div[1]/div[2]/div[2]/div[1]/div[1]/button"))
					.click();

			// Wait for the copy action to complete
			Thread.sleep(1000);

			// Get the copied URL from clipboard
			String copiedUrl = "";
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			try {
				copiedUrl = (String) clipboard.getData(DataFlavor.stringFlavor);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Print the copied URL to verify
			System.out.println("Copied URL: " + copiedUrl);

			// Open a new tab
			((JavascriptExecutor) driver).executeScript("window.open()");

			// Switch to the new tab
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			// Navigate to the copied URL
			driver.get(copiedUrl);

			// Wait for a few seconds to see the result (you can adjust or remove this)
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
