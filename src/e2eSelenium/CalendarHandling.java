package e2eSelenium;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();
		calendarPick("May", "20");
		driver.close();
	}

	public static void calendarPick(String Month, String Date) {
		WebElement Currmonth = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]"));
		// WebElement
		// CurrYear=driver.findElement(By.cssSelector("span[class='ui-datepicker-year']"));

		while ((!Currmonth.getText().contains(Month))) {

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			Currmonth = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]"));

		}
		List<WebElement> currdate = driver
				.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td/a"));
		for (WebElement TestDate : currdate) {
			if (TestDate.getText().equals(Date)) {
				TestDate.click();

				break;
			}
		}

	}

}
