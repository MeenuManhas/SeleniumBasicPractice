package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3_3 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step1 - Launch Chrome browser");
		System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Step2 - click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("Step3 - click Alert button");
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//je.executeScript("scroll(0,300)");
		je.executeScript("arguments[0].scrollIntoView(true)",element);
		element.click();
		System.out.println("Step4 - get alert text");
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = "You must be TechnoCredits student!!";
		System.out.println("Step5 - verify alert messege");
		if(actualAlertText.equals(expectedAlertText))
			System.out.println("Test Pass - correct alert message");
		else
			System.out.println("Test Fail");
		alert.accept();
		driver.close();
	}
}
