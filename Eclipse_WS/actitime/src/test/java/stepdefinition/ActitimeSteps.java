package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeSteps {
	WebDriver driver = null;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
	}

	@When("user enter valid {} and {}")
	public void user_enter_valid_username_and_password(String un , String pwd) {
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);

	}

	@When("click on login Button")
	public void click_on_login_button() {
		driver.findElement(By.id("loginButton")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user will be landed in dashboard page")
	public void user_will_be_landed_in_dashboard_page() {
		Assert.assertEquals("actiTIME - Enter Time-Track", driver.getTitle());
	}

//	@When("user enter invalid username and password")
//	public void user_enter_invalid_username_and_password() {
//		driver.findElement(By.id("username")).sendKeys("admin1");
//		driver.findElement(By.name("pwd")).sendKeys("manager1");
//	}

	@Then("user will be stay on login page with error message")
	public void user_will_be_stay_on_login_page_with_error_message() {
		Assert.assertEquals("actiTIME - Login", driver.getTitle());
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	}
	
	
	//------------------- create customer test ---------------------
	
	@Given("user is logged in to the application")
	public void user_is_logged_in_to_the_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@When("user click on tasks and verify the task page")
	public void user_click_on_tasks_and_verify_the_task_page() {
	   
		driver.findElement(By.xpath("//div[text()='TASKS']/parent::a")).click();
		Assert.assertEquals("actiTIME - Task List", driver.getTitle());
		
	}
	@When("user click on new customer button")
	public void user_click_on_new_customer_button() throws InterruptedException {
	    driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
	    Thread.sleep(3000);
	    
	}
	@Then("user enter {} and {}")
	public void user_enter_customername_and_customerdesc(String cn, String cd) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("customerLightBox_nameField"))));
	   driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
	   driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
	}
	@Then("click on create customer")
	public void click_on_create_customer() {
		   driver.findElement(By.id("customerLightBox_commitBtn")).click();
	}
	@Then("user validate the success message")
	public void user_validate_the_success_message() {
	   WebDriverWait wait = new WebDriverWait(driver,20);
	   WebElement toastElement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
	   System.out.println(toastElement.getText());
	   wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
	   
	}
	@Then("logout of the application")
	public void logout_of_the_application() {
	  driver.findElement(By.id("logoutLink")).click();
	  driver.close();
	}

}
