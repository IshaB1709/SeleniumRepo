package e2eSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class aJaxAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		Actions a = new Actions(driver);
		// below line of code will hover over the element
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();

		// keydown is used for holding a keyboard button
		// below line of code will enter hello in caps
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
				.build().perform();
		
		// below line of code will double click on the WebElement
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).doubleClick().build().perform();
		
		driver.close();
	}

}
