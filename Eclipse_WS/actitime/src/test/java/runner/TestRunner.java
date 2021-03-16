package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/feature/",
		glue = {"stepdefinition"},
		//dryRun = true,
		monochrome = true,
		//tags = "@test1",
		//tags = "@test1 and @test2",
//		tags = "@test1 or @test2",
		tags = "@hooks",
		plugin = {"pretty","junit:target/junitreports/report.xml",
							"html:target/htmlreports/report.html",
							"json:target/jsonreports/report.json"})
public class TestRunner {

}
