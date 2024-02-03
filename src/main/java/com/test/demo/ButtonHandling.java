package com.test.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonHandling {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"D:\\\\\\\\driver-chrome\\\\\\\\chromedriver-win32\\\\\\\\chromedriver-win32\\\\\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://stg-testcloud.quinnox.info/");
		// log.severe("qyrus app started");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("mpooja@quinnox.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/form/div[4]/button")).click();

		Thread.sleep(9000);

		/*
		 * if
		 * (driver.findElement(By.xpath("//*[text()=\"Multiple Sessions Detected!\"]")))
		 * .isDisplayed() {
		 * 
		 * }
		 */

		boolean isPopup = driver.findElement(By.xpath("//*[text()=\"Multiple Sessions Detected!\"]")).isDisplayed();

		Thread.sleep(4000);

		if (isPopup) {
			driver.findElement(By.xpath("//*[@id=\"terminateremote\"]")).click();
			Thread.sleep(3000);
		}

		driver.findElement(By.xpath("//*[@id=\"services\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Web Testing\"]/li/span")).click();

		Thread.sleep(3000);

		driver.navigate().back();
		Thread.sleep(3000);

		System.out.println("current url " + driver.getCurrentUrl());
		System.out.println("Title " + driver.getTitle());

		// Button handling
		// driver.findElement(By.xpath("//*[@id=\"getting_started\"]")).getLocation();
		// //we can directly declare like this or we have another one option
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"getting_started\"]")); // here findelement will return
																						// webelement interface
		Point new1 = ele.getLocation();
		int x = new1.getX();
		int y = new1.getY();

		System.out.println("X ->" + x + " and " + "y->" + y);
		System.out.println("X->" + new1.x + " " + "and " + "Y->" + new1.y);

		// finding the color of the button

		WebElement btncolor = driver.findElement(By.xpath("//*[@id=\"getting_started\"]"));
		String backgroundcolor = btncolor.getCssValue("background-color");
		String textcolor = btncolor.getCssValue("color");

		System.out.println("Backgroundcolor ->" + backgroundcolor + " " + "textcolor ->" + textcolor);

		// getting the height and width of the button
		// using rect method

		Rectangle rect = driver.findElement(By.xpath("//*[@id=\"getting_started\"]")).getRect();
		System.out.println("width" + " " + rect.width);
		System.out.println("height" + " " + rect.height);
		System.out.println("using get width method");
		System.out.println("get width" + " " + rect.getWidth());
		System.out.println("height" + " " + rect.getHeight());

		// we can use rect to find x and y coordinates
		System.out.println("Points by using rect method:" + rect.x + " and " + rect.y);

		// getting height and width by using dimension
		Dimension dim = driver.findElement(By.xpath("//*[@id=\"dropdownMenuButton\"]")).getSize();
		System.out.println("Using dimension method");
		System.out.println("width" + " " + dim.width);
		System.out.println("height" + " " + dim.height);
		System.out.println("get width" + " " + dim.getWidth());
		System.out.println("height" + " " + dim.getHeight());

		// is disabled and enabled

		boolean disabled = driver.findElement(By.xpath("//*[@id=\"schedule\"]")).isEnabled();

		System.out.println("is disabled" + ":" + disabled);

		boolean enabled = driver.findElement(By.id("dropdownMenuButton")).isEnabled();
		System.out.println("is enables" + ":" + enabled);

		// capturing the screenshot
		// ChromeDriver driver1 = new ChromeDriver();
		File image1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./snaps/image1.png");
		FileHandler.copy(image1, dest1);

		// capturing only specified image and for section also same
		WebElement element = driver.findElement(By.id("logged_in_user_name"));
		File image2 = element.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("./snaps/image2.png");
		FileHandler.copy(image2, dest2);

		driver.quit();

		// cast webdriver to takescreenshot (using takescreenshot interface)

		WebDriver obj = new ChromeDriver();
		obj.get("https://music.youtube.com/");
		obj.manage().window().maximize();
		Thread.sleep(2000);
		TakesScreenshot src = (TakesScreenshot) obj;
		File image3 = src.getScreenshotAs(OutputType.FILE);

		File dest3 = new File("./snaps/image3.png");

		//FileHandler.copy(image3, dest3);

		System.out.println("image saved:" + dest3.getAbsolutePath());

		obj.quit();

	}

}
