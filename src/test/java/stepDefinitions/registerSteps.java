package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageObjects.HomePage_PF;
import pageObjects.registerPage_PF;

//import utilities.ExcelReader;
import utilities.excelReader3;
import utilities.Helper;
//import utilities.takeScreenshots;


public class registerSteps {

	public WebDriver driver;
	private String title ;
	private HomePage_PF hPage=new HomePage_PF(Helper.getDriver());
	private registerPage_PF regPage= new registerPage_PF(Helper.getDriver());

	
	
	@When("The user clicks the Register button on Home page")
	public void the_user_clicks_the_register_button_on_home_page() throws InterruptedException {
		
		hPage.homeRegisterLinkClick();
	    
	}

	@Then("The User will be navigated to Register Page with title as {string}")
	public void the_user_will_be_navigated_to_register_page_with_title_as(String string) {
		
		Helper.getTitle();
		System.out.println(Helper.getTitle());
	    
	}
	
	@Given("User is on Register page of dsAlgo Portal")
	public void user_is_on_register_page_of_ds_algo_portal() {
	  
		Helper.gotoRegisterPage();
	 //  regPage= hPage.homePageToRegister();
	}
	
	@When("The user clicks the Register button on register page with all fields value empty")
	public void the_user_clicks_the_register_button_on_register_page_with_all_fields_value_empty() throws InterruptedException, IOException {
	   
		//Thread.sleep(3000);
		regPage.regPageEmptyUserDetails();
		regPage.callTakescreenShots("AllEmptyfield.png");
	}

	@Then("Error message is displayed {string}")
	public void error_message_is_displayed(String experrmsg) throws IOException {

		regPage.callTakescreenShots("Emptyfield.png");
		System.out.println(experrmsg);
	}

	@When("The user clicks the Register button on register page with valid Username and Password fields value empty")
	public void the_user_clicks_the_register_button_on_register_page_with_valid_username_and_password_fields_value_empty() throws IOException, InterruptedException {
	    
		
		regPage.regPagePasswordBlank();
		regPage.callTakescreenShots("PasswordEmpty.png");
	}
	
	
	
	@When("The user clicks the Register link on register page with Password as {string} confirmPassword fields value empty")
	public void the_user_clicks_the_register_link_on_register_page_with_password_as_confirm_password_fields_value_empty(String pswrd) throws IOException, InterruptedException {
	   
		regPage.regPageCnfPasswordBlank(pswrd);
		regPage.callTakescreenShots("ConfirmPaswrdEmpty.png");
	   
	}

	
	@When("User enter Invalid signUp details on register page from given sheetname {string} and {int}")
	public void user_enter_invalid_sign_up_details_on_register_page_from_given_sheetname_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
	   
	   
	   excelReader3 reader=new excelReader3();

	//getting the testdata from excel and passing it to the user validation methods
		List<Map<String, String>> testdata = reader.getData("C:\\Users\\tusha\\eclipse-workspace\\DS_Algo_CucumberBDD\\src\\test\\resources\\Exceldata\\uservalidation.xlsx", sheetName);
		String username = testdata.get(rowNumber).get("Username");
		String password = testdata.get(rowNumber).get("Password");
		String Confpassword = testdata.get(rowNumber).get("Password confirmation");
		String expMsg = testdata.get(rowNumber).get("expectedMessage");
		
		regPage.registerRecDataFromExcel(username, password, Confpassword, expMsg);
	}

	
	@When("The user clicks Register button")
	public void the_user_clicks_register_button() throws InterruptedException {
	    regPage.clickRegBtnOnRegisterPage();
	}


	@Then("Registration failed and error message is displayed")
	public void registration_failed_and_error_message_is_displayed() throws IOException {
		System.out.println("registration failed");
		System.out.println(regPage.Message());
		regPage.callTakescreenShots("InvalidRegistration");
	}

	
	@When("User enter Valid signUp details on register page UserName , Password as {string} and ConfirmPassword as {string}")
	public void user_enter_valid_sign_up_details_on_register_page_user_name_password_as_and_confirm_password_as(String passwrd, String cnfrmPasswrd) throws InterruptedException {
	   
	   
	   regPage.RegisterValidData(passwrd, cnfrmPasswrd);
	}

	@Then("User will be navigated to Home page of DS Algo")
	public void user_will_be_navigated_to_home_page_of_ds_algo() throws InterruptedException, IOException {
		//regPage.clickRegButton();
		//regPage.callTakescreenShots();
		title=regPage.gotoHomePage();
		Helper.EqualAssert(title, "NumpyNinja");
	}

	@Then("successMessage will be displayed {string}")
	public void success_message_will_be_displayed(String expMsg) throws IOException, InterruptedException {

		String Message = regPage.Message();
		System.out.println(Message);
		System.out.println(expMsg);
		Thread.sleep(2000);

	}
	
	


	


}
