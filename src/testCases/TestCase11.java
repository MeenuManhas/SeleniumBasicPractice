package testCases;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase11 {

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
		System.out.println("Step3 - Click on Employee Manager Table");
		driver.findElement(By.xpath("//table[@class='table table-striped']")).click();			
	}
	
	static void getDept(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr/td[5]"));
		HashSet<String> uniqueDept = new HashSet<String>();
		for(WebElement element : list) {
			uniqueDept.add(element.getText());
		}
		System.out.println("Number of Depts we have :"+uniqueDept.size());
	}
	
	static void getNumOfManager(WebDriver driver) {
		List<WebElement> managerId = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr/td[4]"));
		HashSet<String> deptManager = new HashSet<String>();
		for(WebElement element1 : managerId) {
			deptManager.add(element1.getText());
		}
		System.out.println("Number of managers we have :"+deptManager.size());
	}
	
	static void getNumOfEmployee(WebDriver driver) {
		List<WebElement> numOfEmp = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr/td[3]"));
		HashSet<String> employeeName = new HashSet<String>();
		for(WebElement element3 : numOfEmp) {
			employeeName.add(element3.getText());
		}
		System.out.println("Number of managers we have :"+employeeName.size());
	}
	
	public static void main(String[] args) {
		setup();
		getDept(driver);
		getNumOfManager(driver);
		getNumOfEmployee(driver);
	}
}
