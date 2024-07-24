package com.test.demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class InputHandling3 {

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

        // Simulate copying text to clipboard
        String textToPaste = "Hello, this is a test";
        StringSelection stringSelection = new StringSelection(textToPaste);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // Find the search input field and paste the text
        driver.findElement(By.name("q")).sendKeys(Keys.CONTROL + "v");

        // Optional: Submit the search
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        // Wait for a few seconds to see the result (you can adjust or remove this)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}