package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3_5 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launch chrome brower");
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("scroll down and click on Javascript Prompt");
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		element.click();
		System.out.println("switch to alert");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Meenu");
		alert.accept();
		System.out.println("get label message");
		String actualLabelMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedLabelMsg = "Hello Meenu! How are you today?";
		System.out.println("Verify label message");
		if(actualLabelMsg.equals(expectedLabelMsg))
			System.out.println("Test Pass - correct message");
		else
			System.out.println("Test fail - Incorrect message");
		System.out.println("Close the browser");
		driver.close();
	}
}
