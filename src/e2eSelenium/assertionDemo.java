package e2eSelenium;

import static org.testng.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class assertionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//***************************AssertTrue and AssertFalse****************************************
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());

//********************************AssertEquals**********************************
		driver.findElement(By.id("divpaxinfo")).click();
		WebElement childPassenger=driver.findElement(By.id("hrefIncChd"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //code for implicit wait

		//wait for explicit wait
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(childPassenger));
		int click=0;
		while(click<3) {
			 childPassenger.click();
			 click++;
		}
		driver.findElement(By.cssSelector("input[class='buttonN']")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"1 Adult, 3 Child");
	}

}
