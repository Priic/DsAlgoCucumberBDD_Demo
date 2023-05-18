package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import io.cucumber.java.en.*;
import pageObjects.ArrayPage_PF;
import pageObjects.HomePage_PF;
import utilities.Helper;
import utilities.LoggerLoad;
import utilities.excelReader3;

public class arraySteps {

	ArrayPage_PF aPage = new ArrayPage_PF(Helper.getDriver());
	HomePage_PF hPage = new HomePage_PF(Helper.getDriver());
	String title;
	
	
	@Given("The User is on practice page of data Structure")
	public void the_user_is_on_practice_page_of_data_structure() {
		Helper.getTitle();
		System.out.println(Helper.getTitle());
		LoggerLoad.info("The User is on practice page of data Structure");
	    	}

	@When("The user select {string}  from dropbox menu")
	public void the_user_select_from_dropbox_menu(String option) throws InterruptedException {
		hPage.homeClickDrpdown(option);
		LoggerLoad.info("The user select Array option from dropbox menu");
	}

	@When("user is navigate to {string} Page")
	public void user_is_navigate_to_page(String expTitle) {

		title = Helper.getTitle();
		System.out.println(title);
		Helper.EqualAssert(title, expTitle);
		LoggerLoad.info("The user is navigate to Array Page");
	}

	@When("User click {string} link on Array page")
	public void user_click_link_on_array_page(String topiclist) {
		aPage.ArrayTopicCovered(topiclist);
		LoggerLoad.info("The user click on topiclist link on Array page");
	}

	@When("User clicks Try Here button of selected topic")
	public void user_clicks_try_here_button_of_selected_topic() {
		aPage.tryHereArray();
		LoggerLoad.info("The user clicks on Try Here button of selected topic");
	}

	@When("User Enter valid Python code in tryEditor from  {string} for topics in Array and click Run button")
	public void user_enter_valid_python_code_in_try_editor_from_for_topics_in_array_and_click_run_button(
			String ValidPythoncode) throws InterruptedException {
		aPage.ArrayPageValidCode(ValidPythoncode);
	}

	@Then("User should be presented with the Run output for valid Python code and massege for Array Page")
	public void user_should_be_presented_with_the_run_output_for_valid_python_code_and_massege_for_array_page() {
		String Message = aPage.tryEditorMessage();
		System.out.println("Message will be displayed for valid Python code on run Output: " + Message);
		LoggerLoad.info("The user should be presented with the Run output for valid Python code and massege for Array Page");
	}

	@When("User Enter Invalid Python code in tryEditor from  {string} for topics in Array and click Run button")
	public void user_enter_invalid_python_code_in_try_editor_from_for_topics_in_array_and_click_run_button(
			String InValidPythoncode) throws InterruptedException {
		aPage.ArrayPageValidCode(InValidPythoncode);
		LoggerLoad.error("User Enter Invalid Python code in tryEditor from topiclist in Array and click Run button");
	}

	@Then("User should be presented with alert and no runOutput for Invalid Python code for Array Page")
	public void user_should_be_presented_with_alert_and_no_run_output_for_invalid_python_code_for_array_page()
			throws InterruptedException {
		String Message = aPage.tryEditorAlertMessage();
		System.out.println("Message will be displayed for valid Python code on run Output: " + Message);
		LoggerLoad.warn("User should be presented with alert and no runOutput for Invalid Python code for Array Page");

	}

	@Then("User navigate back to Array topic list")
	public void user_navigate_back_to_array_topic_list() {
		Helper.NavBack();
		LoggerLoad.info("User navigate back to Array topic list");
	}

	@When("user click on practice Question")
	public void user_click_on_practice_question() {
		aPage.practiceQuesList();
	}

	@Then("User will be navigated to Practice Question  Array page  as {string}")
	public void user_will_be_navigated_to_practice_question_array_page_as(String expTitle) {
		title = Helper.getTitle();
		System.out.println(title);
		Helper.EqualAssert(title, expTitle);
	}

	@Then("User click {string} on practice question Array page")
	public void user_click_on_practice_question_array_page(String Links) {
		aPage.ArrayPracticeQues(Links);
		LoggerLoad.info("user click on practice Question");
	}

	@Then("User should clear textcode in tryEditor")
	public void user_should_clear_textcode_in_try_editor() throws InterruptedException {
		aPage.ArrayClearText();
	}

	@When("User entered valid Python code in tryEditor  {string} and {int} and click Run button")
	public void user_entered_valid_python_code_in_try_editor_and_and_click_run_button(String SheetName,
			Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {

		//Thread.sleep(1000);
		excelReader3 reader = new excelReader3();

		List<Map<String, String>> testdata = reader.getData(
				"C:\\Users\\tusha\\eclipse-workspace\\DS_Algo_CucumberBDD\\src\\test\\resources\\Exceldata\\PythoncodeValidation.xlsx",
				SheetName);
		String PythonCode = testdata.get(RowNumber).get("PythonCode");
		aPage.ArrayPageValidCode(PythonCode);
		 LoggerLoad.info("User entered valid Python code in tryEditor by using excel sheet click Run button");
	}

}
