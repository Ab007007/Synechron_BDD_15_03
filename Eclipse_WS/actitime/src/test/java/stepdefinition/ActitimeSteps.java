package stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeSteps {
	static WebDriver driver = null;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
	}

	@When("loginuser enter valid {} and {}")
	public void user_enter_valid_username_and_password(String un, String pwd) {
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

	@When("loginuser enter invalid username and password")
	public void user_enter_invalid_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("admin1");
		driver.findElement(By.name("pwd")).sendKeys("manager1");
	}

	@Then("user will be stay on login page with error message")
	public void user_will_be_stay_on_login_page_with_error_message() {
		Assert.assertEquals("actiTIME - Login", driver.getTitle());
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	}

	// ------------------- create customer test ---------------------

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
		
	}

	@Then("user enter {} and {}")
	public void user_enter_customername_and_customerdesc(String cn, String cd) {
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
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement toastElement = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println(toastElement.getText());
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));

	}

	@Then("logout of the application")
	public void logout_of_the_application() {
		driver.findElement(By.id("logoutLink")).click();
		driver.close();
	}

	@Then("application throws error message")
	public void application_throws_error_message() {

		String errormessage = driver.findElement(By.id("customerLightBox_nameDuplicateError")).getText();
		Assert.assertEquals(errormessage, "Customer with the specified name already exists");
	}

	@Then("user validate the error message and click on cancel")
	public void user_validate_the_error_message_and_click_on_cancel() {
		driver.findElement(By.id("customerLightBox_cancelBtn")).click();
		driver.switchTo().alert().accept();
	}

	// --------------- delete customer -----------------------------
	@Then("user search for a customer {} and click on settings button")
	public void user_search_for_a_customer_and_click_on_settings_button(String string) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='customersProjectsPanel']//input")).clear();
				driver.findElement(By.xpath("//div[@class='customersProjectsPanel']//input")).sendKeys(string);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(
				"//div[@class='node allCustomersNode selected']/following-sibling::div//div[@class='editButton available']")))
				.perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='node allCustomersNode selected']/following-sibling::div//div[@class='editButton available']")).click();

	}

	@Then("click on Actions and delete button")
	public void click_on_actions_and_delete_button() throws InterruptedException {
		WebElement ele = driver.findElement(
				By.xpath("//div[@class='edit_customer_sliding_panel sliding_panel']//div[text()='ACTIONS']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		driver.findElement(By.xpath("//div[@class='edit_customer_sliding_panel sliding_panel']//div[text()='Delete']"))
				.click();
		
		driver.findElement(By.id("customerPanel_deleteConfirm_submitTitle")).click();
		/*
		 * Thread.sleep(1000); WebDriverWait wait1 = new WebDriverWait(driver, 30);
		 * WebElement toastElement = wait1
		 * .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
		 * "//div[@class='toasts']")))); System.out.println(toastElement.getText());
		 * wait1.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(
		 * "//div[@class='toasts']"))));
		 */

	}

	@Then("user will confirm by clicking on delete button")
	public void user_will_confirm_by_clicking_on_delete_button() throws InterruptedException {

	}

	@When("user create multiple customer and validate success message")
	public void user_create_multiple_customer_and_validate_success_message(DataTable dataTable)
			throws InterruptedException {
		List<List<String>> data = dataTable.asLists();
		String customerName = null;
		String customerDesc = null;
		for (int i = 0; i < data.size(); i++) {
			customerName = data.get(i).get(0);
			customerDesc = data.get(i).get(1);
			user_click_on_new_customer_button();
			user_enter_customername_and_customerdesc(customerName, customerDesc);
			click_on_create_customer();
			user_validate_the_success_message();
		}
	}
	
//	@After("@testss or @actitime or @regression")
	public void teardown(Scenario sc) throws IOException
	{
		System.out.println("----------AFTER HOOK ---------------");
		System.out.println("Status of the test - " + sc.getName());
		System.out.println("Status of the test - " + sc.getStatus());
		System.out.println("Status of the test - " + sc.isFailed());
		System.out.println("---------------------------------");
		if(sc.isFailed())
		{
			Date d = new Date();
			String dt = d.toString().replace(" ", "_").replace(":", "_");
			System.out.println(dt);
			TakesScreenshot ss = (TakesScreenshot) driver;
			File file = ss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("target/screenShots/ss" + dt + ".jpg"));
		}
		else
		{
			System.out.println("Scenario " + sc.getName() + " is passed");
		}
		driver.close();
	}


}
