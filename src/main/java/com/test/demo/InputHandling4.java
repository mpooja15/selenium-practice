package com.test.demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputHandling4 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "D:\\chromedriver-win64\\chromedriver-win64-125\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        openGoogleAndPaste(driver);
        driver.quit();
    }

    public static void openGoogleAndPaste(WebDriver driver) {
        // Open Google
        driver.get("https://www.google.com/?safe=active&ssui=on");

        // Find the search input field
        WebElement searchField = driver.findElement(By.name("q"));

        // Enter text
        searchField.sendKeys("Text to be copied and pasted");

        // Select all text (Ctrl+A)
        searchField.sendKeys(Keys.CONTROL + "a");

        // Copy selected text (Ctrl+C)
        searchField.sendKeys(Keys.CONTROL + "c");

        // Clear the field
        searchField.clear();

        // Paste the copied text (Ctrl+V)
        searchField.sendKeys(Keys.CONTROL + "v");

        // Optional: Submit the search
        searchField.sendKeys(Keys.ENTER);

        // Wait for a few seconds to see the result (you can adjust or remove this)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}