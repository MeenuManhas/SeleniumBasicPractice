package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3_2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step1 - Launch Chrome browser");
		System.setProperty("webDriver.chrome.driver", "chromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Step2 - click on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(200);
		System.out.println("Step3 - Enter your email address");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("meenumanhas4@gmail.com");
		System.out.println("Step4 - Enter your password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Meenu@1234");
		System.out.println("Step5 - click on submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		System.out.println("verify submit button message");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "You successfully clicked on it";
		if(actualText.equals(expectedText))
			System.out.println("Correct button message : "+actualText);
		else
			System.out.println("Test fail - incorrect message");
		alert.accept();
		driver.close();
	}
}
