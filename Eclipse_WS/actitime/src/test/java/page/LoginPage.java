package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(id = "username")
	WebElement usernameTxtBox;
	
	
	
	public void enterUsername(String un)
	{
		usernameTxtBox.sendKeys(un);
	}
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
}