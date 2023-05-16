package stepDefinitions;

import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Helper;
import utilities.readingConfigPropertiesFile;

public class Hooks {

	// Hooks for initial configurations of the project
	@Before(order=0)
    public static void setUp() throws IOException {
     
     Helper.setUpDriver();
    }
	
	@Before(order=1)
    public static void getdriver() throws IOException {
		
		Helper.getDriver();
     
	}
    
 
    @After
    public static void tearDown(Scenario scenario) {
 
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Helper.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 
        }   
         
    //   Helper.tearDown();
    }

}
