package e2eSelenium;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class staticDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//*****************Drop down Type- Static***************************************************
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByValue("USD");

//******************************************************************************************
		driver.findElement(By.id("divpaxinfo")).click();
		WebElement childPassenger = driver.findElement(By.id("hrefIncChd"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // code for implicit wait

//wait for explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(childPassenger));
		int click = 0;
		while (click < 3) {
			childPassenger.click();
			click++;
		}
		driver.findElement(By.cssSelector("input[class='buttonN']")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

//*****************************DYNAMIC DROPDOWN*******************************************************
		WebElement DepartureCity = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));

		DepartureCity.click();
		DepartureCity.sendKeys("goi");
		Actions a = new Actions(driver);
		WebElement DepartSelected = driver.findElement(By.xpath("//li[contains(@class,'city_selected')]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(DepartSelected));
		a.moveToElement(DepartSelected);
		a.doubleClick(DepartSelected).build().perform();

		WebElement ArrivalCity = driver
				.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CCU']"));
		wait.until(ExpectedConditions.elementToBeClickable(ArrivalCity));
		ArrivalCity.click();

//**************************Auto Suggest DropDown****************************************************
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		Iterator<WebElement> it = options.iterator();
		while (it.hasNext()) {
			WebElement test = it.next();
			if (test.getText().equals("India")) {
				System.out.println(test.getText());
				test.click();
				break;
			}
		}
		/*
		 * for(WebElement test: options) { if(test.getText().equals("India")) {
		 * test.click(); }
		 */
//********************************CheckBox***************************************************************
		System.out.println(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());

//******************** count the number of CheckBoxes********
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

//*************De-select the CheckBox***************************
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected() == false);

//*************Select RadioButton***********************************************
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

//*****************************Select Calendar*********************************************
		driver.findElement(By.cssSelector("button[class='ui-datepicker-trigger']")).click();
		// driver.findElement(By.xpath("//td[@class=' ui-datepicker-days-cell-over
		// ui-datepicker-today']")).click();
		driver.findElement(By.cssSelector("td[class*='ui-datepicker-today']")).click();
//point to remember- css selector using regEx

//********************************Click on Button
		driver.findElement(By.xpath("//input[contains(@name,'FindFlights')]")).click();

	}
}
