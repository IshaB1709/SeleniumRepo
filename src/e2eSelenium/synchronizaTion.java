package e2eSelenium;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class synchronizaTion {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String[] s = { "Cucumber", "Tomato", "Cauliflower", "Potato" };

		for (int i = 0; i < s.length; i++) {
			AddVegetable(s[i]);

		}
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		driver.close();
	}

	public static void AddVegetable(String s) {
		List<WebElement> options = driver.findElements(By.xpath("//h4[@class='product-name']"));
		List<WebElement> button = driver.findElements(By.cssSelector("div[class='product-action']"));

		for (int i = 0; i < options.size(); i++) {

			if (options.get(i).getText().contains(s)) {

				button.get(i).click();
				break;

			}

		}

	}
}
