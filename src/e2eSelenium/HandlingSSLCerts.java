package e2eSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingSSLCerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//general DesiredCapabilities--Desired capabilities is the class used for SSL handling
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

//merging the general desired capabilities to the local browser
		ChromeOptions op = new ChromeOptions();
		op.merge(caps);
//
		op.addArguments("incognito");
		op.addArguments("start-maximized");

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
//passing the chromeoptions to the webDriver
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://www.google.com");

		driver.close();

	}

}
