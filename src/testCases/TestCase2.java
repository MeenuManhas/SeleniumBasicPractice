package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) {
		System.out.println("Step1 - Launch chrome browser ");
		System.setProperty("webDriver.chrome.driver","chromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step2 - Open google.com");
		String url = "https://www.google.com/";
		driver.get(url);
		System.out.println("Step3 - Get page title name and verify with expected title");
		String expectedTitle = "Google";
		String äctualTitle = driver.getTitle();
		if(äctualTitle.equals(expectedTitle))
			System.out.println("Correct Title : "+äctualTitle);
		else
			System.out.println("Incorrect Title");
		System.out.println("Step4 - Navigate to automationbykrishna.com");
		String url1 = "http://automationbykrishna.com/";
		driver.navigate().to(url1);
		System.out.println("Step5 - Get page title name of automationbykrishna and verify with expected title for ");
		String expectedTitle1 = "Login Signup Demo";
		String äctualTitle1 = driver.getTitle();
		if(äctualTitle1.equals(expectedTitle1))
			System.out.println("Correct Title : "+äctualTitle1);
		else
			System.out.println("Incorrect Title");
		System.out.println("Step6 - Navigate back in history");
		driver.navigate().back();
		System.out.println("Step7 - Get page title name of history page and verify it with expected title ");
		String expectedTitleOfHistoryPage = "Google";
		String actualTitleOfHistoryPage = driver.getTitle();
		if(actualTitleOfHistoryPage.equals(expectedTitleOfHistoryPage))
			System.out.println("Correct Title : "+actualTitleOfHistoryPage);
		else
			System.out.println("Incorrect page title");
		System.out.println("Step8 - Navigate forward");
		driver.navigate().forward();
		System.out.println("Step9 - Get page title name of forward page and verify with expected title");
		String expectedTitleOfForwardPage = "Login Signup Demo";
		String actualTitleOfForwardPage = driver.getTitle();
		if(actualTitleOfForwardPage.equals(expectedTitleOfForwardPage))
			System.out.println("Correct Title : "+actualTitleOfForwardPage);
		else
			System.out.println("Incorrect Title");
		System.out.println("Step10 - Refresh the page and verify the expected title");
		String expectedTitleOfRefreshPage = "Login Signup Demo";
		String actualTitleOfRefreshPage = driver.getTitle();
		if(actualTitleOfRefreshPage.equals(expectedTitleOfRefreshPage))
			System.out.println("Correct Title : "+actualTitleOfRefreshPage);
		else
			System.out.println("Incorrect Title");
		System.out.println("Step11 - Close the browser");
		driver.close();
	}
}
