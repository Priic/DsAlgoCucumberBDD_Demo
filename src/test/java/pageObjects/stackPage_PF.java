package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class stackPage_PF {

	public WebDriver driver;

	public  stackPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Stack Page
	@FindBy(tagName = "h4")
	WebElement linkedListText;
	@FindBy(xpath = "//a[text()='Operations in Stack']")
	WebElement operationInStackLink;
	@FindBy(xpath = "//a[text()='Implementation']")
	WebElement ImplementStackLink;
	@FindBy(xpath = "//a[text()='Applications']")
	WebElement applicationStackLink;

	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement PracQuestion;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHereLink;

	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")

	WebElement tryEditor;

	@FindBy(xpath = "//button[@type='button']")
	WebElement runButton;

	@FindBy(xpath = "//pre[@id='output']")
	WebElement outputStack;

	@FindBy(xpath = "//span[@role='presentation']")
	WebElement sourceStack;

	public String stackPageGetTitle() {
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Stack");
		return driver.getTitle();

	}

//method to select topic covered link in Linked List module
	public void StackTopicCovered(String topicList) {

		WebElement topicCoveredList = null;

		if (topicList.contains("Operations in")) {

			topicCoveredList = operationInStackLink;

		} else if (topicList.contains("Applications")) {
			topicCoveredList = applicationStackLink;

		} else if (topicList.contains("Implementation")) {
			topicCoveredList = ImplementStackLink;

		}
		System.out.println("User clicked on " + topicList + " link");

		topicCoveredList.click();
		
	}

	public String practiceQuesGetTitle() {
		
		String Title=driver.getTitle(); ;
		return Title;
	}
	
	public void practiceQuesStack() {
		PracQuestion.click();
		System.out.println(driver.getTitle());
	
	}
		
		
		

		// Click on tryHere>>> link
		public String tryHere() {
			tryHereLink.click();
			return driver.getTitle();
		}

		
	// method to receive python code and check if it's valid or invalid code[ from main program(will be implementing thru excel later)
		public void stackPagePythonCodeValidationAndRun(String PythonCodeFrmExcel) throws InterruptedException {

			if (PythonCodeFrmExcel.contains(" '")) {
				System.out.println("User Enter:  "+PythonCodeFrmExcel);
				tryEditorValidPythonCode(PythonCodeFrmExcel);

			} else {
				System.out.println("User Enter: "+PythonCodeFrmExcel);
				tryEditorInvalidPythonCode(PythonCodeFrmExcel);

			}
		}

		// valid python code validation method
		public String tryEditorValidPythonCode(String PythonCode) throws InterruptedException {
			
			tryEditor.sendKeys(PythonCode);
			runButton.click();
		//	Thread.sleep(1000);
			String runMsg=outputStack.getText();
			System.out.println(runMsg);
			stackPageClearText();
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
			
			String runMsg=outputStack.getText();
			System.out.println(runMsg);
			return runMsg;
		}
		
	/*	public String tryEditorAlertMessage() throws InterruptedException {
			
			String alertMsg=outputStack.getText();
			System.out.println(alertMsg);
			return alertMsg;
					
		} */
		
		// Pop up alert in case of invalid code and get text alert
		public String switchToAlert() throws InterruptedException {

			Alert alert = driver.switchTo().alert();
			String alertmsg=alert.getText();
			System.out.println(alert.getText());
			alert.dismiss();
			Thread.sleep(500);
			return alertmsg;
		} 

		public void stackPageClearText() throws InterruptedException {
			Thread.sleep(1000);
			Actions a = new Actions(driver);
			a.keyDown(sourceStack, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE)
					.keyUp(Keys.DELETE).perform();
		//	Thread.sleep(1000);

		}

}
