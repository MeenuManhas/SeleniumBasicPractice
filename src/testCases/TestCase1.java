/*Test case - 1

1. Launch a chrome
2. Open Google.com
3. Get page title name and length and print on console
4. Get page URL and verify if it is a correct or not.
5. Get page source and page source length and print on console
6. Close the browser.
*/

package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.google.com/";
		driver.get(url);
		System.out.println("Title of WebPage is : "+driver.getTitle());
		String currentUrl = driver.getCurrentUrl();
		if(url.equals(currentUrl))
			System.out.println("Correct url is Opened");
		else
			System.out.println("Url is not Correct");
		String pageSource = driver.getPageSource();
		System.out.println("Length of PageSource is :"+pageSource.length());
		driver.close();
	}
}
