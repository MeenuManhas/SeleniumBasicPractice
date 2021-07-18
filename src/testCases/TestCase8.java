package testCases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase8 {

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
	
	static HashMap<Integer,String> getEmpDetails(WebDriver driver){
		System.out.println("Step4 - return a map of empId and empName");
		HashMap<Integer,String> empData =  new HashMap<Integer,String>();
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr")).size();
		System.out.println(size);
		for(int index = 1;index<=size;index++) {
			int empId = Integer.valueOf(driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+index+"]/td[2]")).getText());
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+index+"]/td[3]")).getText();
			empData.put(empId, empName);
		}
		return empData;
	}
	public static void main(String[] args) {
		setup();
		System.out.println(getEmpDetails(driver));

	}

}
