package e2eSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JSExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,900)");

		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		int Expectedsum = 0;
		List<WebElement> products = driver.findElements(By.xpath("//*[@id='product']/tbody/tr/td[4]"));
		for (WebElement product : products) {
			Expectedsum = Expectedsum + Integer.parseInt(product.getText());
		}
		int ActualSum = Integer
				.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(Expectedsum, ActualSum);

//*******************handling WebTables************************************

//Find number of row

		int rowsize = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th")).size();
		System.out.println("Number of rows: " + rowsize);

//Find number of column

		int columnsize = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size();
		System.out.println("Number of rows: " + columnsize);

//Print the values of a particular row

		int inputRow = 4;

		System.out.println(
				driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).get(inputRow).getText());

//******Miscellaneous -Auto Select Drop-down**********************************************//
		String searchCountry = "ind";
		String ExpectedCountry = "India";

		driver.findElement(By.id("autocomplete")).sendKeys(searchCountry);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		By countryLocator = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li");
		wait.until((ExpectedConditions.presenceOfAllElementsLocatedBy(countryLocator)));

		List<WebElement> countryList = driver.findElements(countryLocator);

		for (WebElement country : countryList) {

			if (country.getText().equals(ExpectedCountry)) {
				System.out.println(country.getText());
				country.click();
				break;
			}
		}

		driver.close();
	}

}
