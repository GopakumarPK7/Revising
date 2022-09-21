package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import elementRepo.CartPage;
import elementRepo.HomePage;
import elementRepo.ProductPage;
import elementRepo.WHProductListPage;

public class BaseClass 

{
	protected String browser;
	protected String url;
	protected String timeouts;
	protected Long timeout;
	protected String prdct;
	public FileUtility file;
	public ExcelUtility excel;
	public WebDriver driver;
	protected HomePage home;
	protected WHProductListPage product;
	protected ProductPage productpage;
	protected CartPage cart;
	protected SoftAssert asert;
	protected WebdriverUtilities driverUtility;
	@BeforeSuite
	public void suiteSetup()
	{
		file=new FileUtility();
		excel=new ExcelUtility();
		file.initializePropertyFile(Iconstants.PROPERTYFILEPATH);
		excel.initializeExcel(Iconstants.EXCELFILEPATH);
		browser=file.getDataFromProperties("browser");
		url=file.getDataFromProperties("url");
		timeouts=file.getDataFromProperties("timeout");
		timeout=Long.parseLong(timeouts);
		prdct=excel.getTheDataFromExcel("Rmg", 1, 1);
	}
	@BeforeClass
	public void classSetup()
	{
		driverUtility=new WebdriverUtilities();

		driver=driverUtility.setupDriver(browser);
		driverUtility.openApplication(url);
		driverUtility.implicitWait(timeout);
		driverUtility.maximizeBrowser();
		home=new HomePage(driver);
		product=new WHProductListPage(driver);
		productpage=new ProductPage(driver);
		cart=new CartPage(driver);
		asert=new SoftAssert();
	}
	@BeforeMethod
	public void methodSetup()
	{
		home.closeLoginMsgBox();
	}
	
	@AfterClass
	public void classTearDown()
	{
		driverUtility.closeBrowser();
	}

}
