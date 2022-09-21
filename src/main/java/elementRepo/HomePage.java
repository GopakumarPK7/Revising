package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

@FindBy(xpath="//button[text()='✕']")
private WebElement closeIcon;
@FindBy(name="q")
private WebElement searchBox;
@FindBy(xpath="//button[@type=\"submit\"]")
private WebElement searchBtn;
/**
 * This method used to close the login message
 */
public void closeLoginMsgBox()
{
closeIcon.click();	
}
/**
 * this method used to pass values in searchbox
 */
public void search(String productName)
{
searchBox.sendKeys(productName);	
}
/**
 * This method is used to click on search button
 */
public void clickSearchBtn() {
	searchBtn.click();
}
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
