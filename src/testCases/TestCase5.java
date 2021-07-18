package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase5 {

	public static void main(String[] args) {
		System.out.println("Step1 - Launch Chrome browser");
		System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Step2 - Select any day from dropdown");
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='select-demo']"));
		Select select= new Select(dropDown);
		select.selectByIndex(2);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", dropDown);
		System.out.println("Step3 - Select multiple values from multilist Demo");
		System.out.println("All the options of dropdown are :");
		WebElement multiDropDown = driver.findElement(By.xpath("//select[@id='multi-select']"));
		Select select1 = new Select(multiDropDown);
		List<WebElement> l1 = select1.getOptions();
		for(WebElement allOptions : l1) 
			System.out.println(allOptions.getText());			
		System.out.println("Step4 - select multiple options");
		select1.selectByIndex(0);		
		select1.selectByIndex(2);
		select1.selectByIndex(3);
		System.out.println("Selected options are :");
		List<WebElement> l2 = select1.getAllSelectedOptions();
		for(WebElement selectedOptions : l2) 
			System.out.println(selectedOptions.getText());
		l1.remove(l2);
		select1.deselectAll();
			
	}	
}	
