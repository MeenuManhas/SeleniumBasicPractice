package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCase9 {
	
	public static void main(String[] args){
		System.out.println("Step1 - Launch Chrome browser");
		System.setProperty("webDriver.chrome.driver", "chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Step2 - Click on Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Step3 - Click on Employee basic Infromation Tables");
		driver.findElement(By.xpath("//table[@id='table1']")).click();			
		System.out.println("Step4 - Verify username of employee");
		int size = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+index+"]/td[2]")).getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+index+"]/td[3]")).getText();
			String actualUserName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+index+"]/td[4]")).getText();
			String expectedUserName = (firstName.charAt(0)+lastName).toLowerCase();
			if(actualUserName.equals(expectedUserName))
				System.out.println("Correct username :"+actualUserName);
			else
				System.out.println("Test fail");		
		}
		
	}

}		
		

	


