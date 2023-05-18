package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.HomePage_PF;
import pageObjects.queuePage_PF;
import pageObjects.signInPage_PF;
//import pageObjects.stackPagePOM;
import utilities.Helper;
import utilities.LoggerLoad;

public class queueSteps {

	signInPage_PF signPage = new signInPage_PF(Helper.getDriver());
	HomePage_PF hPage = new HomePage_PF(Helper.getDriver());
	queuePage_PF QueuePage = new queuePage_PF(Helper.getDriver());
	String title;

	@Given("The User is on practice page of Stack")
	public void the_user_is_on_practice_page_of_stack() {
		Helper.getTitle();
		System.out.println(Helper.getTitle());
		LoggerLoad.info("The User is on practice page of Stack");
	}

	@Then("User will be navigated to Queue page title as {string}")
	public void user_will_be_navigated_to_queue_page_title_as(String option) throws InterruptedException {

		hPage.homeClickDrpdown(option);
		LoggerLoad.info("User will be navigated to Queue page");
	}

	@When("User click {string} to select topics covered on Queue page")
	public void user_click_to_select_topics_covered_on_queue_page(String topicCoveredList) {

		QueuePage.QueueTopicCovered(topicCoveredList);
		LoggerLoad.info("user_click_to_select_topics_covered_on_queue_page");
	}

	@When("User clicks Try Here button in the Queue of selected topic page")
	public void user_clicks_try_here_button_in_the_queue_of_selected_topic_page() {

		QueuePage.tryHere();
		LoggerLoad.info("User clicks Try Here button in the Queue of selected topic page");

	}

	@When("User Enter valid Python code in tryEditor from  {string} for Queue topic and click Run button")
	public void user_enter_valid_python_code_in_try_editor_from_for_queue_topic_and_click_run_button(
			String pythonCodefrmFeature) throws InterruptedException {

		QueuePage.QueuePagePythonCodeValidationAndRun(pythonCodefrmFeature);
		LoggerLoad.info("User Enter valid Python code in tryEditor for Queue topic and click Run button");
	}

	@Then("User should be presented with the Run output for valid Python code and Message for for Queue Page")
	public void user_should_be_presented_with_the_run_output_for_valid_python_code_and_message_for_for_queue_page() {

		String Message = QueuePage.tryEditorMessage();
		System.out.println("Message will be displayed for valid Python code on run Output: " + Message);
		LoggerLoad.info(
				"User should be presented with the Run output for valid Python code and Message for for Queue Page");
	}

	@When("User Enter Invalid Python code in tryEditor from  {string} for Queue topic and click Run button")
	public void user_enter_invalid_python_code_in_try_editor_from_for_queue_topic_and_click_run_button(
			String pythonCodefrmFeature) throws InterruptedException {

		QueuePage.QueuePagePythonCodeValidationAndRun(pythonCodefrmFeature);
		LoggerLoad.error("User Enter Invalid Python code in tryEditor for Queue topic and click Run button");
	}

	@Then("User should be presented with alert and no runOutput for Invalid Python code for Queue Page")
	public void user_should_be_presented_with_alert_and_no_run_output_for_invalid_python_code_for_queue_page()
			throws InterruptedException {

		String Message = QueuePage.tryEditorMessage();

		System.out.println("Alert msg will be displayed and Run output will be empty : " + Message);
		LoggerLoad.warn("User should be presented with alert and no runOutput for Invalid Python code for Queue Page");
	}

	@Then("User navigate back to Queue page of selected topic")
	public void user_navigate_back_to_queue_page_of_selected_topic() {

		Helper.NavBack();
		LoggerLoad.info("User navigate back to Queue page of selected topic");

	}

	@When("User clicks Practice Questions Page on Queue Page")
	public void user_clicks_practice_questions_page_on_queue_page() {

		QueuePage.practiceQuesQueue();
		LoggerLoad.info("User clicks Practice Questions Page on Queue Page");
	}

	@Then("User should be redirected to a Practice Questions Page of selected Queue Topic Page")
	public void user_should_be_redirected_to_a_practice_questions_page_of_selected_queue_topic_page() {

		title = QueuePage.practiceQuesGetTitle();
		System.out.println(title);
		Helper.EqualAssert(title, "Practice Questions");
		LoggerLoad.info("User should be redirected to a Practice Questions Page of selected Queue Topic Page");
	}

}
