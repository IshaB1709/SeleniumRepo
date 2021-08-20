package e2eSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tabToggle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
		String ParentWindow = driver.getWindowHandle();
		driver.findElement(By.id("opentab")).click();
		Set<String> window1 = driver.getWindowHandles();
		Iterator<String> it = window1.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			if (driver.getTitle().equals("Rahul Shetty Academy")) {
				driver.findElement(By.xpath("//a[@class='btn btn-theme btn-sm btn-min-block']")).click();
				System.out.println(driver.getTitle());
				driver.close();
			}

		}

		driver.switchTo().window(ParentWindow);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("openwindow")).click();
		Set<String> window2 = driver.getWindowHandles();
		it = window2.iterator();
		while (it.hasNext()) {
			String CurrentWindow = it.next();
			if (!CurrentWindow.contains(ParentWindow)) {
				driver.switchTo().window(CurrentWindow);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(ParentWindow);
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
