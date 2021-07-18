package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase7 {
	
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
	static ArrayList<String> getColumnName(WebDriver driver){
		System.out.println("Step4 - get list of column name");
		ArrayList<String> headerList = new ArrayList<String>();
		List<WebElement> columnNameList = driver.findElements(By.xpath("//table[@id='table1']//th"));
		for(WebElement elements : columnNameList) {
			headerList.add(elements.getText());
		}	
		return headerList;
	}
	
	static String getEmpData(WebDriver driver,String name,int index) {
		System.out.println("Step5 - get username of employee");
		String userName = driver.findElement(By.xpath("//td[text()='"+name+"']//parent::tr/td["+index+"]")).getText();
		return userName;
	}

	public static void main(String[] args) {
		setup();
		ArrayList<String> list = getColumnName(driver);
		int index = list.indexOf("Username")+1;
		System.out.println("Username of Dhara is : "+getEmpData(driver,"Dhara",index));
	}

}
