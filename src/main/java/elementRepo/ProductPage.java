package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
@FindBy(xpath="//span[contains(text(),\"DARSHANAM WORLD 220v 500w\")]")
private WebElement productDtls;
@FindBy(xpath ="//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")
private WebElement addToCartBtn;
/**
 * Method to get product name
 */
public String product() {
	return productDtls.getText();
	
}
/**
 * method to click on add to cart button
 */
public void clickOnAddToCartBtn()
{
	addToCartBtn.click();
}
public ProductPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
}
