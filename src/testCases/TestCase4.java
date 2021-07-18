package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4{

	static WebDriver driver = new ChromeDriver();
	
	static void setup(String url) {
		System.out.println("Step1 - Launch Chrome Driver");
		System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	static void validateVisibleButton(WebDriver driver) throws InterruptedException{ 
		setup("file:///C:/Users/AAKASH/Downloads/Krishna%20Requirement.html");
		System.out.println("Step2 - click on Visible & Hidden button");
		WebElement button1 = driver.findElement(By.xpath("//button[@id='visibleAndHidden']"));
		button1.click();
		Thread.sleep(2000);
		System.out.println("Step3 - Check if block isvisible");		
		WebElement block = driver.findElement(By.xpath("//div[@id='myDIV']"));
		if(!block.isDisplayed())
			System.out.println("Block is not visible - Test pass");
		else
			System.out.println("Test Fail");		
		System.out.println("Step4 - click on Visible & Hidden button again");
		button1.click();
		System.out.println("Step5 - Check again if block isvisible");
		if(block.isDisplayed())
			System.out.println("Block is visible - Test pass");
		else
			System.out.println("Test Fail");		
	}
	
	static void validateEnableButton(WebDriver driver) throws InterruptedException {
		setup("file:///C:/Users/AAKASH/Downloads/Krishna%20Requirement.html");
		System.out.println("Step1 - click on Enable & Disable button");
		WebElement button2 = driver.findElement(By.xpath("//button[@id='enableAndDisable']"));
		button2.click();
		Thread.sleep(2000);
		System.out.println("Step2 - Check if Textbox isvisible");
		WebElement textBox = driver.findElement(By.xpath("//input[@id='myText']"));
		if(!textBox.isEnabled())
			System.out.println("Textbox is grid out - Test Pass");
		else
			System.out.println("Test fail");
		System.out.println("Step3 - click on Enable & Disable button again");
		button2.click();
		if(textBox.isEnabled())
			System.out.println("Test Pass");
		else
			System.out.println("Textbox is grid out - Test fail");		
	}
	
	static void validateRadioButton(WebDriver driver) throws InterruptedException {
		setup("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(2000);
		System.out.println("Check if Male radio button is selected");
		WebElement radioButton = driver.findElement(By.xpath("//input[@id='radio-01']"));
		if(radioButton.isSelected()) {
			System.out.println("Male radio button is selected");
			System.out.println("Select Female radio button");
			WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@id='radio-02']"));
			femaleRadioButton.click();
			if(femaleRadioButton.isSelected())
				System.out.println("Female radio button is selected - Test pass");
			else
				System.out.println("Test fail");
		}						
	}

	public static void main(String[] args) throws InterruptedException {
	validateVisibleButton(driver);
	validateEnableButton(driver);
	validateRadioButton(driver);
	driver.close();
	}
}
