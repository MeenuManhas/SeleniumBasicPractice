package testCases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase12 {

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
	
	static HashMap<String,Integer> getNumOfEmpInEachDept(WebDriver driver) {
		System.out.println("Find number of employees in each department");
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr")).size();
		HashMap<String,Integer> NumOfEmpInEachDept = new HashMap<String,Integer>();
 		for(int index = 1;index<=size;index++) {
 			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+index+"]/td[5]")).getText();
 			if(NumOfEmpInEachDept.containsKey(deptName))
 				NumOfEmpInEachDept.put(deptName, NumOfEmpInEachDept.get(deptName)+1);
 			else
 				NumOfEmpInEachDept.put(deptName, 1);
 		}
 		return NumOfEmpInEachDept;
	}
	
	static HashMap<String,Integer> getNumOfEmpEachUnderManager(WebDriver driver) {
		System.out.println("Find number of employees under each manager");
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr")).size();
		HashMap<String,Integer> NumOfEmpUnderEachManager = new HashMap<String,Integer>();
		for(int index = 1;index<=size;index++) {
			String managerId = driver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+index+"]/td[4]")).getText();
			if(NumOfEmpUnderEachManager.containsKey(managerId))
				NumOfEmpUnderEachManager.put(managerId, NumOfEmpUnderEachManager.get(managerId)+1);
			else
				NumOfEmpUnderEachManager.put(managerId, 1);
		}
		return NumOfEmpUnderEachManager;
	}
	
	public static void main(String[] args) {
		setup();
		System.out.println("Emplyee count in each department : "+getNumOfEmpInEachDept(driver));
		System.out.println("Number of employee under each manager : "+getNumOfEmpEachUnderManager(driver));
		driver.close();
	}

}
