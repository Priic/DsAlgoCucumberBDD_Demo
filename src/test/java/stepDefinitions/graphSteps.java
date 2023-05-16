package stepDefinitions;

//import com.github.dockerjava.api.model.Driver;

import io.cucumber.java.en.*;
import pageObjects.HomePagePOM;
import pageObjects.signInPagePOM;
import pageObjects.graphPagePOM;
import utilities.Helper;

public class graphSteps {
	
	
	signInPagePOM signPage= new signInPagePOM(Helper.getDriver());
	HomePagePOM hPage= new HomePagePOM(Helper.getDriver());
	graphPagePOM graphPage=new graphPagePOM(Helper.getDriver());
	String title;
	
	@Given("The User is on practice page of Tree")
	public void the_user_is_on_practice_page_of_tree() {
		Helper.getTitle();
		System.out.println(Helper.getTitle());
	   
	}
	
	@Then("User will be navigated to Graph page title as {string}")
	public void user_will_be_navigated_to_graph_page_title_as(String option) throws InterruptedException {
		hPage.homeClickDrpdown(option);
	}
	
	@When("User click {string} to select topics covered on Graph page")
	public void user_click_to_select_topics_covered_on_graph_page(String topicCovList) {
		
		graphPage.GraphTopicCovered(topicCovList);
	}
	
	@When("User clicks Try Here button in the  Graph of selected topic page")
	public void user_clicks_try_here_button_in_the_graph_of_selected_topic_page() {
	   
		graphPage.tryHere();
	}
	
	@When("User Enter valid Python code in tryEditor from  {string} for Graph topic and click Run button")
	public void user_enter_valid_python_code_in_try_editor_from_for_graph_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException  {
	    
		graphPage.graphPagePythonCodeValidationAndRun(pythonCodefrmFeature);
	}
	
	@Then("User should be presented with the Run output for valid Python code and Message for for Graph Page")
	public void user_should_be_presented_with_the_run_output_for_valid_python_code_and_message_for_for_graph_page() {
	   
		String Message=	graphPage.tryEditorMessage();
		System.out.println("Message will be displayed for valid Python code on run Output: " +Message);
	}
	@When("User Enter Invalid Python code in tryEditor from  {string} for Graph topic and click Run button")
	public void user_enter_invalid_python_code_in_try_editor_from_for_graph_topic_and_click_run_button(String pythonCodefrmFeature) throws InterruptedException{
	    
		graphPage.graphPagePythonCodeValidationAndRun(pythonCodefrmFeature);
	}
	
	@Then("User should be presented with alert and no runOutput for Invalid Python code for Graph Page")
	public void user_should_be_presented_with_alert_and_no_run_output_for_invalid_python_code_for_graph_page() throws InterruptedException {
	    
         String Message=graphPage.tryEditorMessage();
		
		System.out.println("Alert msg will be displayed and Run output will be empty : " +Message);
	}
	
	@Then("User navigate back to Graph page of selected topic")
	public void user_navigate_back_to_graph_page_of_selected_topic() throws InterruptedException {
		Thread.sleep(1000);
	//	Helper.graphPage();
		Helper.NavBack();
		Thread.sleep(1000);
		Helper.NavBack();
		
		Thread.sleep(1000);
		//Helper.NavBack();
	}

	
	@Given("User is on graph page of selected topic")
	public void user_is_on_graph_page_of_selected_topic() {
	   
		Helper.NavForward();
	}
	
	@When("User clicks Practice Questions Page on Graph Page")
	public void user_clicks_practice_questions_page_on_graph_page() {
		graphPage.practiceQuesGraph();
	}
	
	
	@Then("User should be redirected to a Practice Questions Page of selected Graph Topic Page")
	public void user_should_be_redirected_to_a_practice_questions_page_of_selected_graph_topic_page() {
	    
		title=graphPage.practiceQuesGetTitle();
		System.out.println(title);
		Helper.EqualAssert(title, "Practice Questions");
	}

	

}
