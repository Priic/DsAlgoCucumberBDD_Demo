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

public class queuePage_PF extends baseTest{
	
	public WebDriver driver;

	public queuePage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Queue Page
	@FindBy(xpath="//a[text()='Implementation of Queue in Python']")
	WebElement clickimplqueue;
	
	@FindBy(xpath="//a[text()='Implementation using collections.deque']")
	WebElement clickimpldeque;
	
	@FindBy(xpath="//a[text()='Implementation using array']")
	WebElement clickimplarray;
	
	@FindBy(xpath="//a[text()='Queue Operations']")
	WebElement clickqueueoperationlink;
	
	@FindBy(xpath="//a[text()='Practice Questions']")
	WebElement PracQuestion;
	
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHereLink;
	
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
	WebElement tryEditor;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement runButton;
	
	@FindBy(xpath = "//pre[@id='output']")
	WebElement outputQueue;
	
	@FindBy(xpath = "//span[@role='presentation']")
	WebElement sourceQueue;

	public String queuePageGetTitle() {

		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Queue");
		return driver.getTitle();

	}

	//method to select topic covered link in Queue module
		public void QueueTopicCovered(String topicList) {

			WebElement topicCoveredList = null;

			if (topicList.contains("Implementation of Queue in")) {
	            topicCoveredList = clickimplqueue;
				
			} else if (topicList.contains("Implementation using collections.deque")) {
				topicCoveredList = clickimpldeque;

			} else if (topicList.contains("Implementation using array")) {
				topicCoveredList = clickimplarray;

			} else if (topicList.contains("Queue Operations")) {
				topicCoveredList = clickqueueoperationlink;

			} 
			System.out.println("User clicked on " + topicList + " link");

			topicCoveredList.click();
			
		
		}

		public String practiceQuesGetTitle() {
			
			String Title=driver.getTitle(); ;
			return Title;
		}
		
	// click practice question link
	public void practiceQuesQueue() {
		PracQuestion.click();
		System.out.println(driver.getTitle());
	
	}
	
	

	// Click on tryHere>>> link
	public String tryHere() {
		tryHereLink.click();
		return driver.getTitle();
	}

	
// method to receive python code and check if it's valid or invalid code[ from main program(will be implementing thru excel later)
	public void QueuePagePythonCodeValidationAndRun(String PythonCodeFrmFeature) throws InterruptedException {

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
		String runMsg=outputQueue.getText();
		System.out.println(runMsg);
		QueuePageClearText();
		return runMsg; 			
	}
	
	// invalid python code validation method
	public void tryEditorInvalidPythonCode(String PythonCode) throws InterruptedException {

		tryEditor.sendKeys(PythonCode);
		runButton.click();
	//	Thread.sleep(1000);
		switchToAlert();
		
	}
	public String tryEditorMessage() {
		
		String runMsg=outputQueue.getText();
		System.out.println(runMsg);
		return runMsg;
	}
	
	
	// Pop up alert in case of invalid code and get text alert
		public String switchToAlert() throws InterruptedException {

			Alert alert = driver.switchTo().alert();
			String alertmsg=alert.getText();
			System.out.println(alert.getText());
			alert.dismiss();
		//	Thread.sleep(1000);
			return alertmsg;
		} 
		
	public void QueuePageClearText() throws InterruptedException {
		Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.keyDown(sourceQueue, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE)
				.perform();
	//	Thread.sleep(1000);

	}
	
	}



