package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // Junit execution

@CucumberOptions(plugin = { "pretty", "html:target/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		}, // reporting purpose
		monochrome = false, // console output color
		//tags = "@tag", //tags from feature file
		features = { "src/test/resources/Features/" }, // location of feature files
		glue = "stepDefinitions") // location of step definition files

public class testRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}

}
