package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.HomePage_PF;
//import pageObjects.linkedListPagePOM;
import pageObjects.signInPage_PF;
import pageObjects.treePage_PF;
import utilities.Helper;
import utilities.LoggerLoad;


public class treeSteps {
	
	signInPage_PF signPage= new signInPage_PF(Helper.getDriver());
	HomePage_PF hPage= new HomePage_PF(Helper.getDriver());
	//linkedListPagePOM lListpage=new linkedListPagePOM(Helper.getDriver());
	treePage_PF treePage=new treePage_PF(Helper.getDriver());
	String title;
	
	@Given("The User is on practice page of Queue")
	public void the_user_is_on_practice_page_of_queue() {
	    
		Helper.getTitle();
		System.out.println(Helper.getTitle());
		LoggerLoad.info("The User is on practice page of Queue");
	}
	
	@Then("User will be navigated to Tree page title as {string}")
	public void user_will_be_navigated_to_tree_page_title_as(String option) throws InterruptedException {
	    
		hPage.homeClickDrpdown(option);
		LoggerLoad.info("User will be navigated to Tree page title as Tree");
	}

	@When("User click {string} to select topics covered on Tree page")
	public void user_click_to_select_topics_covered_on_tree_page(String topicCovList) {
	    
		treePage.TreeTopicCovered(topicCovList);
		LoggerLoad.info("User clicks select topics covered on Tree page");
	}

	@When("User clicks Try Here button in the Tree of selected topic page")
	public void user_clicks_try_here_button_in_the_tree_of_selected_topic_page() {
	    
		treePage.tryHere();
		LoggerLoad.info("User clicks Try Here button in the Tree of selected topic page");
	   
	}

	@When("User Enter valid Python code in tryEditor from  {string} for Tree topic and click Run button")
	public void user_enter_valid_python_code_in_try_editor_from_for_tree_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException {
	    
		treePage.treePagePythonCodeValidationAndRun(pythonCodefrmFeature);
		LoggerLoad.info("User Enter valid Python code in tryEditor for Tree topic and click Run button");
	}

	@Then("User should be presented with the Run output for valid Python code and Message for for Tree Page")
	public void user_should_be_presented_with_the_run_output_for_valid_python_code_and_message_for_for_tree_page() {
	    
		String Message=	treePage.tryEditorMessage();
		System.out.println("Message will be displayed for valid Python code on run Output: " +Message);
		LoggerLoad.info("Message will be displayed for valid Python code on run Output with Valid Python code");
	}

	@When("User Enter Invalid Python code in tryEditor from  {string} for Tree topic and click Run button")
	public void user_enter_invalid_python_code_in_try_editor_from_for_tree_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException {
	    
		treePage.treePagePythonCodeValidationAndRun(pythonCodefrmFeature);
		LoggerLoad.error("User Enter Invalid Python code in tryEditor for Tree topic and click Run button");
	}

	@Then("User should be presented with alert and no runOutput for Invalid Python code for Tree Page")
	public void user_should_be_presented_with_alert_and_no_run_output_for_invalid_python_code_for_tree_page() {
	    
		String Message=	treePage.tryEditorMessage();
		
		System.out.println("Alert msg will be displayed and Run output will be empty : " +Message);
		LoggerLoad.warn("User should be presented with alert and no runOutput for Invalid Python code for Tree Page");
	}

	@Then("User navigate back to Tree page of selected topic")
	public void user_navigate_back_to_tree_page_of_selected_topic() {
	    
		Helper.NavBack();
		LoggerLoad.info("User navigate back to Tree page of selected topic");
	   
	}

	@When("User clicks Practice Questions Page on Tree Page")
	public void user_clicks_practice_questions_page_on_tree_page() {
	    
		treePage.practiceQuesTree();
		LoggerLoad.info("User clicks Practice Questions Page on Tree Page");
	}

	@Then("User should be redirected to a Practice Questions Page of selected Tree Topic Page")
	public void user_should_be_redirected_to_a_practice_questions_page_of_selected_tree_topic_page() {
	    
		title=treePage.practiceQuesGetTitle();
		System.out.println(title);
		Helper.EqualAssert(title, "Practice Questions");
		LoggerLoad.info("User should be redirected to a Practice Questions Page of selected Tree Topic Page");
	}


}
