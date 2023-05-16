package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.HomePagePOM;
import pageObjects.linkedListPagePOM;
import pageObjects.signInPagePOM;
import utilities.Helper;
import utilities.LoggerLoad;

public class linkedListSteps {
	
	signInPagePOM signPage= new signInPagePOM(Helper.getDriver());
	HomePagePOM hPage= new HomePagePOM(Helper.getDriver());
	linkedListPagePOM lListpage=new linkedListPagePOM(Helper.getDriver());
	String title;
		
	
	@Given("The User is on practice page of Array")
	public void the_user_is_on_practice_page_of_array() {
	   
		Helper.getTitle();
		System.out.println(Helper.getTitle());
		LoggerLoad.info("The User is on practice page of Array title as  Practice Questions ");
		
	}
	@When("The user select {string}  from homepage dropDown menu")
	public void the_user_select_from_homepage_drop_down_menu(String option) throws InterruptedException {
		
		hPage.homeClickDrpdown(option);
	   
	}

	@Then("User will be navigated to LinkedList page title as {string}")
	public void user_will_be_navigated_to_linked_list_page_title_as(String expTitle) {
	    
		title=Helper.getTitle();
		System.out.println(title);
		Helper.EqualAssert(title, expTitle);
	}

	
	@When("User click {string} to select topics covered on Link List page")
	public void user_click_to_select_topics_covered_on_link_list_page(String topicCovList) throws InterruptedException {
	    
		lListpage.LinkedListTopicCovered(topicCovList);
	}

	@When("User clicks Try Here button in the  Linked List of selected topic page")
	public void user_clicks_try_here_button_in_the_linked_list_of_selected_topic_page() {
	    
		lListpage.tryHere();
	   
	}

	@When("User Enter valid Python code in tryEditor from  {string} for for LinkedList topic and click Run button")
	public void user_enter_valid_python_code_in_try_editor_from_for_for_linked_list_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException {
	    
		lListpage.linkedListPagePythonCodeValidationAndRun(pythonCodefrmFeature);
	}

	@Then("User should be presented with the Run output for valid Python code and Message for for LinkedList Page")
	public void user_should_be_presented_with_the_run_output_for_valid_python_code_and_message_for_for_linked_list_page() {
	    
		String Message=	lListpage.tryEditorMessage();
		System.out.println("Message will be displayed for valid Python code on run Output: " +Message);
	}

	@When("User Enter Invalid Python code in tryEditor from  {string} for for LinkedList topic and click Run button")
	public void user_enter_invalid_python_code_in_try_editor_from_for_for_linked_list_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException {
	    
		lListpage.linkedListPagePythonCodeValidationAndRun(pythonCodefrmFeature);
	}

	@Then("User should be presented with alert and no runOutput for Invalid Python code for LinkedList Page")
	public void user_should_be_presented_with_alert_and_no_run_output_for_invalid_python_code_for_linked_list_page() {
	    
		String Message=	lListpage.tryEditorMessage();
		System.out.println("Alert msg will be displayed and Run output will be empty : " +Message);
	}

	@Then("User navigate back to LinkedList page of selected topic")
	public void user_navigate_back_to_linked_list_page_of_selected_topic() {
		 
		Helper.NavBack();
	  
	}

	@When("User clicks Practice Questions Page on LinkedList Page")
	public void user_clicks_practice_questions_page_on_linked_list_page() throws InterruptedException {
	    
	//	Thread.sleep(1000);
		lListpage.practiceQuesLinkedList();
	}

	@Then("User should be redirected to a Practice Questions Page of selected LinkedList Topic Page")
	public void user_should_be_redirected_to_a_practice_questions_page_of_selected_linked_list_topic_page() {
	    
		title=lListpage.practiceQuesGetTitle();
		System.out.println(title);
		Helper.EqualAssert(title, "Practice Questions");
	}



}
