package e2eSelenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//TakesScreenshot class is used for capturing screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		
//get the screenshot in file format and save in a file
		File srcFile = ts.getScreenshotAs((OutputType.FILE));

//Move file to new destination

		File DestFile = new File("C:\\test\\isha.png");

//Copy file at destination

//to read more about FileHandler-https://www.seleniumeasy.com/selenium-tutorials/take-screenshot-using-FileHandler-class
		FileHandler.copy(srcFile, DestFile);

	}

}
