package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.startPagePOM;
import utilities.Helper;
import utilities.LoggerLoad;


public class startSteps extends baseTest {
	
	public WebDriver driver;

	private startPagePOM sPage;

	
	
	@Given("The User launches the Chrome browser")
	public void the_user_launches_the_chrome_browser() throws InterruptedException {
	   
		sPage = new startPagePOM(Helper.getDriver()); //getting the driver value from helper class and getDriver method(utilities package)
	//	Thread.sleep(3000);
		
		LoggerLoad.info("User launches the Chrome Browser");
	   
	}

	@When("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() throws InterruptedException {
	   
	//	Thread.sleep(3000);
		LoggerLoad.info("The user opens DS Algo portal link");
		Helper.openPage();
	   
	}

	@When("The user clicks the Get Started button")
	public void the_user_clicks_the_get_started_button() throws InterruptedException {
	    
		LoggerLoad.info("The user clicks the Get Started button");
		sPage.getStartedClick();
	   
	}

	@Then("The user should be redirected to homepage with page title as {string}")
	public void the_user_should_be_redirected_to_homepage_with_page_title_as(String string) {
	    
	 LoggerLoad.info("The user should be redirected to homepage with page title as NumpyNinja");	
	  String title= sPage.startPageTitle();
	  System.out.println(title);
	}



}
