package commonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LaunchBrowser {
	public static WebDriver driver;
	public static Properties property;
	
	public static Properties properties() throws IOException
	{
		FileInputStream pro=new FileInputStream("config.properties");
		property=new Properties();
		property.load(pro);
		return property;
	}
	@BeforeTest
	public void browser() throws IOException {
		properties();
		String browser=property.getProperty("browsername");
		String url=property.getProperty("url");
		String chromelocation=property.getProperty("chromelocation");
		String firefoxlocation=property.getProperty("firefoxlocation");
		String ielocation=property.getProperty("ielocation");
		String operalocation=property.getProperty("operalocation");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chromelocation);
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", firefoxlocation);
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", ielocation);
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver", operalocation);
			driver=new OperaDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", chromelocation);
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("\nThe Title of 75health.com Home page is: "+driver.getTitle()+"\n");
	}
	
	@AfterTest
	public void closebrowser()
	{
		driver.close();
	}

}
