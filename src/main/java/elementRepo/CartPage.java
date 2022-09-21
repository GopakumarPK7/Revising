package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
@FindBy(xpath="//a[contains(text(),\"DARSHANAM WORLD 220v 500w\")]")
private WebElement productName;
/**
 * method to get productname from cartpage
 */
public String productName()
{
	return productName.getText();
	
}
public CartPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
}
