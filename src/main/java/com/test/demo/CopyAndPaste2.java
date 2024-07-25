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
                "D:\\utilities\\driver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        copyAndNavigateToNewTab(driver);
        driver.quit();
    }

    public static void copyAndNavigateToNewTab(WebDriver driver) {
        try {
            // Navigate to the W3Schools site
            driver.get("https://www.w3schools.com/howto/howto_js_copy_clipboard.asp");
            
            // Wait for the page to load
            Thread.sleep(3000);
            
            // Clear the text from the input field and set the new URL
            String urlToCopy = "https://www.google.com/?safe=active&ssui=on";
            driver.findElement(By.xpath("//*[@id='myInput']")).clear();
            driver.findElement(By.xpath("//*[@id='myInput']")).sendKeys(urlToCopy);
            
            // Wait a moment to ensure the text is set
            Thread.sleep(1000);
            
            // Click the copy button
            driver.findElement(By.xpath("//*[@id='main']/div[3]/button")).click();
            
            // Wait for the copy action to complete
            Thread.sleep(1000);

            // Get the copied URL from clipboard
            String copiedUrl = getClipboardContents();
            
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

    private static String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
