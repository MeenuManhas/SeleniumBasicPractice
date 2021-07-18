package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3_4 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launch chrome brower");
		System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("click on Javascript Confirmation button");		
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		element.click();
		System.out.println("get alert text");
		Alert alert = driver.switchTo().alert();
		String actualAlertMsg = alert.getText();
		String expectedAlertMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		System.out.println("Verify alert text");
		if(actualAlertMsg.equals(expectedAlertMsg))
			System.out.println("Test Pass - correct alert message");
		else
			System.out.println("Test fail - Incorrect alert message");
		alert.accept();
		System.out.println("check label msg");
		String actualLabelMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedLabelMsg = "You pressed OK!";
		System.out.println("verify label msg");
		if(actualLabelMsg.equals(expectedLabelMsg))
			System.out.println("Correct message");
		else
			System.out.println("Incorrect message");		
	    driver.close();				
	}
}
