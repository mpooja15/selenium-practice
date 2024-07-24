package com.test.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

public class CopyAndPaste2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "D:\\chromedriver-win64\\chromedriver-win64-125\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        copyAndNavigateToNewTab(driver);
        driver.quit();
    }

    public static void copyAndNavigateToNewTab(WebDriver driver) {
        // Navigate to the Gist
        driver.get("https://gist.github.com/mpooja15/db98ee008904c39c8982ddb2426a4736");
        
        // Click the copy button
        driver.findElement(By.xpath("(//*[@id=\"clipboard-button\"])[2]")).click();

        // Get the copied URL from clipboard
        String copiedUrl = getClipboardContents();

        // Open a new tab
        ((JavascriptExecutor) driver).executeScript("window.open()");

        // Switch to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Navigate to the copied URL
        driver.get(copiedUrl);

        // Wait for a few seconds to see the result (you can adjust or remove this)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
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