package testCases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase10 {
	
	static WebDriver driver;
	
	static void setup() {
		System.out.println("Step1 - Launch Chrome browser");
		System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("Step2 - Click on Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Step3 - Click on Employee basic Infromation Tables");
		driver.findElement(By.xpath("//table[@id='table1']")).click();
	}
	
	static HashMap<String,String> getEmpData(WebDriver driver,String name){
		HashMap<String,String> empData = new HashMap<String,String>();
		String lastName = driver.findElement(By.xpath("//table[@id='table1']//td[text()='"+name+"']/following-sibling::td[1]")).getText();
		String userName = driver.findElement(By.xpath("//table[@id='table1']//td[text()='"+name+"']/following-sibling::td[2]")).getText();
		empData.put("LastName", lastName);
		empData.put("UserName", userName);
		return empData;
	}
	public static void main(String[] args) {
		setup();
		System.out.println(getEmpData(driver,"Maulik"));

	}

}
