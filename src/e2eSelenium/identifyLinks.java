package e2eSelenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class identifyLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		String ParentWindow = driver.getWindowHandle();
		System.out.println(driver.findElements(By.xpath("//a")).size());// using xpath-a refers to anchor and everylink
																		// will have "a" as tagname
		System.out.println(driver.findElements(By.cssSelector("a")).size());// using cssSelector
//***** Counting links on a Particular section***********************************************//
		WebElement footerSection = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerSection.findElements(By.tagName("a")).size());
		System.out.println(driver.findElements(By.xpath(("//div[@id='gf-BIG']//a"))).size());
//******count link on a Particular column*****************************************************//
		int count = footerSection.findElements(By.xpath("//table//tbody//tr//td[1]//a")).size();
		int i = 0;

//******click on every link and open in a separate tab***************************************//
		while (i < count) {

			a.moveToElement(footerSection.findElements(By.xpath("//table//tbody//tr//td[1]//a")).get(i))
					.keyDown(Keys.CONTROL).click().build().perform();

			i++;
		}

//************************navigate to each child window and Print the Title**********************************//
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			String currentWindow = it.next();
			if (!currentWindow.equals(ParentWindow)) {
				System.out.println(driver.switchTo().window(currentWindow).getTitle());
			}
		}

		driver.quit();
	}

}
