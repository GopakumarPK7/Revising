package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WHProductListPage {

	@FindBy(xpath="//a[contains(@title,\"DARSHANAM WORLD 220v 500w Portable\")]")
	private WebElement product;
	/**
	 * Method to click on particular product
	 */
public void clickOnProduct()
{
product.click();	
}
public WHProductListPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
