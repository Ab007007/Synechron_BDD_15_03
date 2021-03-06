package stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksDemo {

	WebDriver driver = null;
	@Before(value = "@google")
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		GoogleSearch.driver = driver;
		ActitimeSteps.driver = driver;
	}
	
	
	//@After
	public void teardown(Scenario sc) throws IOException
	{
		if(sc.isFailed())
		{
			Date d = new Date();
			String dt = d.toString().replace(" ", "_").replace(":", "_");
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
	
	@AfterStep
	public void printLine()
	{
		System.out.println("----------------------------------------------------");
	}
	
	
	@BeforeStep
	public void welcomeMSg()
	{
		System.out.println("----------------Step Starting------------------------");
	}
	
}
