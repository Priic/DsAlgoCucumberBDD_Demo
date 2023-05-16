package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.baseTest;

public class linkedListPage_PF extends baseTest {

	public WebDriver driver;

	public linkedListPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Linked List Page
	@FindBy(tagName = "h4")
	WebElement linkedListText;
	@FindBy(xpath = "//a[text()='Introduction']")
	WebElement introLinkedList;
	@FindBy(xpath = "//a[text()='Creating Linked LIst']")
	WebElement createLinkedList;
	@FindBy(xpath = "//a[text()='Types of Linked List']")
	WebElement typeOfLinkedList;
	@FindBy(xpath = "//a[contains(text(),'Implement')]")
	WebElement impLinkedListinPython;
	@FindBy(xpath = "//a[contains(text(),'Traversal')]")
	WebElement traversalLinkedList;
	@FindBy(xpath = "//a[contains(text(),'Insertion')]")
	WebElement insertionLinkedList;
	@FindBy(xpath = "//a[contains(text(),'Deletion')]")
	WebElement deletionLinkedList;
	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement PracQuestion;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHere;

	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")

	WebElement tryEditor;

	@FindBy(xpath = "//button[@type='button']")
	WebElement runButton;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement outputLinkedList;

	@FindBy(xpath = "//span[@role='presentation']")
	WebElement sourceLinkedList;

	public String linkedListPageGetTitle() {

		String title = driver.getTitle();
		return title;

	}

//method to select topic covered link in Linked List module
	public String LinkedListTopicCovered(String topicList) throws InterruptedException {

		WebElement topicCoveredList = null;

		if (topicList.contains("Introduction")) {

			topicCoveredList = introLinkedList;
		} else if (topicList.contains("Creating Linked LIst")) {
			topicCoveredList = createLinkedList;

		} else if (topicList.contains("type of")) {
			topicCoveredList = typeOfLinkedList;

		} else if (topicList.contains("Implement Linked")) {
			topicCoveredList = impLinkedListinPython;

		} else if (topicList.contains("Traversal")) {
			topicCoveredList = traversalLinkedList;

		} else if (topicList.contains("Insertion")) {
			topicCoveredList = insertionLinkedList;

		} else if (topicList.contains("Deletion")) {
			topicCoveredList = deletionLinkedList;
		}
		System.out.println("//User clicked on " + topicList + " link"+topicCoveredList);

		topicCoveredList.click();
		
		//System.out.println("//User clicked on " + topicList + " link"+topicCoveredList);
		Thread.sleep(2000);
		return driver.getTitle();
		// topicCoveredList.click();

	}

	// click practice question link
	public void practiceQuesLinkedList() {
		PracQuestion.click();
		System.out.println(driver.getTitle());
	
	}
	
	public String practiceQuesGetTitle() {
		
		String Title=driver.getTitle(); ;
		return Title;
	}
	

	// Click on tryHere>>> link
	public String tryHere() {
		tryHere.click();
		return driver.getTitle();
	}

	
// method to receive python code and check if it's valid or invalid code[ from main program(will be implementing thru excel later)
	public void linkedListPagePythonCodeValidationAndRun(String PythonCodeFrmFeature) throws InterruptedException {

		if (PythonCodeFrmFeature.contains(" '")) {
			System.out.println("User Enter:  "+PythonCodeFrmFeature);
			tryEditorValidPythonCode(PythonCodeFrmFeature);

		} else {
			System.out.println("User Enter: "+PythonCodeFrmFeature);
			tryEditorInvalidPythonCode(PythonCodeFrmFeature);

		}
	}

	// valid python code validation method
	public String tryEditorValidPythonCode(String PythonCode) throws InterruptedException {
		
		tryEditor.sendKeys(PythonCode);
		runButton.click();
		Thread.sleep(1000);
		String runMsg=outputLinkedList.getText();
		System.out.println(runMsg);
		linkedListPageClearText();
		return runMsg; 			
	}
	
	// invalid python code validation method
	public void tryEditorInvalidPythonCode(String PythonCode) throws InterruptedException {

		tryEditor.sendKeys(PythonCode);
		runButton.click();
		Thread.sleep(1000);
		switchToAlert();
		
	}
	public String tryEditorMessage() {
		
		String runMsg=outputLinkedList.getText();
		System.out.println(runMsg);
		return runMsg;
	}
	
	public String tryEditorAlertMessage() throws InterruptedException {
		
		String alertMsg=outputLinkedList.getText();
		System.out.println(alertMsg);
		
		return alertMsg;
				
	}
	
	// Pop up alert in case of invalid code and get text alert
	public String switchToAlert() throws InterruptedException {

		Alert alert = driver.switchTo().alert();
		String alertmsg=alert.getText();
		System.out.println(alert.getText());
		alert.dismiss();
		Thread.sleep(1000);
	//	linkedListPageClearText();
		return alertmsg;
	} 

  // clear the text field where code is written
	public void linkedListPageClearText() throws InterruptedException {
		Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.keyDown(sourceLinkedList, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE)
				.keyUp(Keys.DELETE).perform();
		Thread.sleep(1000);

	}

}
