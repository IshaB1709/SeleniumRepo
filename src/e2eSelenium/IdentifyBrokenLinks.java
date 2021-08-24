package e2eSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class IdentifyBrokenLinks {
	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");

		SoftAssert sa = new SoftAssert();

//1.Find all the urls on the webpage;
		List<WebElement> links = driver.findElements(By.tagName("a"));

//2.Click on all the links and check for status code
		for (WebElement link : links) {

			String url = link.getAttribute("href");// find the exact url from the href attribute
			System.out.println(url);

			if (isUrlValid(url)) {
				HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();// pass the url in the
																							// openConnection()
				conn.setRequestMethod("GET");// set the http method to hit the url
				conn.connect();// invoke the http method through connect()
				int outPutStatus = conn.getResponseCode();
				System.out.println(outPutStatus);
				sa.assertTrue(outPutStatus < 400, url);// implement Soft assertions to check the responsecode

			}

			else {
				System.out.println("Invalid URL");
			}

		}
		sa.assertAll();//this will make sure to validate if their is any failure in the above soft assertion
		
		
		driver.quit();
	}

//objective of this function is to validate if the URL is a correct url or not
	public static boolean isUrlValid(String url) {
		try {
			URL obj = new URL(url);
			obj.toURI();
			return true;
		} catch (MalformedURLException e) {
			return false;
		} catch (URISyntaxException e) {
			return false;
		}
	}
}
