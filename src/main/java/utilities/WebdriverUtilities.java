package utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class WebdriverUtilities {
	WebDriver driver;
	/**
	 * 	This method is used to setup the driver instance
	 */
	public WebDriver setupDriver(String browser)
	{
		switch(browser)
		{
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();   
			break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case"ie":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Wrong browser key");
			break;
		}
		return driver;
	}
	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to wait the paging implicit wait
	 */
	public void implicitWait(long longTimeout)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}
	/**
	 * This method is used to load the web application
	 */
	public void openApplication(String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used to close particular browser
	 */
	public void closeBrowser()
	{
		driver.quit();
	}
	/**
	 * This method is used to close particular tab
	 */
	public void closeTab()
	{
		driver.close();
	}
	/**
	 * This method is used to switch frame based on index
	 */
	public void switchFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch frame based on Webelement address
	 */
	public void switchFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch frame based name or id attribute
	 */
	public void switchFrame(String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * This method used to get current window session id
	 */
	public String parentWindowId()
	{
	return driver.getWindowHandle();	
	}
	/**
	 * This method is used to switch the window
	 */
	public void switchWindow(String pid)
	{
		Set<String> winIds=driver.getWindowHandles();
		for(String id:winIds)
		{
			if(!pid.equals(id))
			{
				driver.switchTo().window(id);
			}
}
}
}