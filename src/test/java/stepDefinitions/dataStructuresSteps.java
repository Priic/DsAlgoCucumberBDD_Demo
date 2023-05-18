package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.DataStructurePage_PF;
import pageObjects.HomePage_PF;
import utilities.Helper;
import utilities.LoggerLoad;


public class dataStructuresSteps {
	
	private HomePage_PF hPage=new HomePage_PF(Helper.getDriver());
	//private registerPagePOM regPage= new registerPagePOM(Helper.getDriver());
	private DataStructurePage_PF dSPage= new DataStructurePage_PF(Helper.getDriver());

	String title;
	
	@When("The user clicks on DataStructure GetStarted button on homepage {string}")
	public void the_user_clicks_on_data_structure_get_started_button_on_homepage(String option) throws InterruptedException {
	    
		hPage.homeGetStartedClick(option);
		LoggerLoad.info("The user clicks on DataStructure GetStarted button ");  
	   
	}

	@Then("User will be navigated to Data Structures-Introduction page title as {string}")
	public void user_will_be_navigated_to_data_structures_introduction_page_title_as(String expTitle) {
	   
		title=Helper.getTitle();
		System.out.println(title);
		Helper.EqualAssert(title, expTitle);
		LoggerLoad.info("User will be navigated to Data Structures-Introduction page");
	}

	@When("User clicks on Time Complexity link")
	public void user_clicks_on_time_complexity_link() {
	    
		dSPage.dsTopicsCovered();
		LoggerLoad.info("User clicks on Time Complexity link");
	   
	}
	

	@Then("User will be navigated to time-complexity page title as {string}")
	public void user_will_be_navigated_to_time_complexity_page_title_as(String expTitle) {
	    
		title=Helper.getTitle();
		System.out.println(title);
		Helper.EqualAssert(title, expTitle);
		LoggerLoad.info("User will be navigated to time-complexity page");
	   
	}

	@When("User clicks Try Here button in the datastructure page")
	public void user_clicks_try_here_button_in_the_datastructure_page() {
	    
		dSPage.tryHereDS();
		LoggerLoad.info("User clicks Try Here button in the datastructure page");
	   
	}


	@Then("User should be redirected tryEditor page title as {string} with a Run button to test Python code")
	public void user_should_be_redirected_try_editor_page_title_as_with_a_run_button_to_test_python_code(String expTitle) {
	    
		title=Helper.getTitle();
		System.out.println(title);
		Helper.EqualAssert(title, expTitle);
		LoggerLoad.info("User should be redirected tryEditor page title as {string} with a Run button to test Python code");
	   
	}

	@When("User Enter Python code in tryEditor from  {string} for DataStructures topic and click Run button")
	public void user_enter_python_code_in_try_editor_from_for_data_structures_topic_and_click_run_button(String pythonCodeFrmFeature) throws InterruptedException {
	    
	   dSPage.dsPagePythonCodeValidation(pythonCodeFrmFeature);
	   LoggerLoad.info("User Enter Python code in tryEditor from DataStructures topic and click Run button");
	}

	@Then("User should be presented with the Run output for valid Python code and Message for DataStructure Page")
	public void user_should_be_presented_with_the_run_output_for_valid_python_code_and_message_for_data_structure_page() {
	    
		String Message=	dSPage.tryEditorMessage();
		System.out.println("Message will be displayed for valid Python code on run Output: " +Message);
		LoggerLoad.info("User should be presented with the Run output for valid Python code and Message for DataStructure Page");
	}

	@Then("User navigate back to dataStructure page of selected topic")
	public void user_navigate_back_to_data_structure_page_of_selected_topic() {
	    
		Helper.NavBack();
		LoggerLoad.info("User navigate back to dataStructure page of selected topic"); 
	   
	}
	
	@When("User clicks Practice Questions Page on DataStructure Page")
	public void user_clicks_practice_questions_page_on_data_structure_page() {
		
		dSPage.practiceQuesdStr();
		LoggerLoad.info("User clicks Practice Questions Page on DataStructure Page"); 
		   
	   
	}

	@Then("User should be redirected to a Practice Questions Page of selected DataStructure Topic Page")
	public void user_should_be_redirected_to_a_practice_questions_page_of_selected_data_structure_topic_page() {
	   
		title=dSPage.practiceQuesGetTitle();
		System.out.println(title);
		LoggerLoad.info("User should be redirected to a Practice Questions Page of selected DataStructure Topic Page");
	}



}
