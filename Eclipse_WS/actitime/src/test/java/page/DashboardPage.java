package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	
	@FindBy(id = "logoutLink")
	WebElement logoutLink;
	
	public void clickLogout()
	{
		logoutLink.click();
	}
	
	public DashboardPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
}
