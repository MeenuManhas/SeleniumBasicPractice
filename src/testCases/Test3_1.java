package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3_1 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step1 - Launch chrome broswer");
		System.setProperty("webDriver.chorme.driver", "chromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step2 - Open automationbykrishna");
		String url = "http://automationbykrishna.com/";
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Step3 - click on Basic Elements");
	    driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(200);
		System.out.println("Step4 - Enter Fname, Lname and Company name");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Meenu");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Manhas");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("Zensar");
		System.out.println("Step5 - click on submit button");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		System.out.println("Step6 - get text of alert and verify it");
		Alert alert = driver.switchTo().alert();	
		String actualAlert = alert.getText();
		String expectedAlert = "Meenu and Manhas and Zensar";
		if(actualAlert.equals(expectedAlert))
			System.out.println("Alert is correct - Test Pass");
		else
			System.out.println("Test Fail - Incorrect alert");
		alert.accept();
		System.out.println("Close the browser");
		driver.close();		
	}
}
