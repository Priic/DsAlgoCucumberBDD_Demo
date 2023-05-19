package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class graphPage_PF {
	
	public WebDriver driver;

	public  graphPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Queue page
	
	@FindBy(xpath=("//a[@href='graph']"))
	WebElement graphlink;
	
	@FindBy(xpath=("//a[@href='/graph/graph-representations/']"))
	WebElement GraphRepresentations;
	
	@FindBy(xpath="//a[text()='Practice Questions']")
	WebElement PracQuestion;
	
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHereLink;
	
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
	WebElement tryEditor;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement runButton;
	
	@FindBy(xpath = "//pre[@id='output']")
	WebElement outputGraph;
	
	@FindBy(xpath = "//span[@role='presentation']")
	WebElement sourceGraph;

	public String GraphPageGetTitle() {
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Graph");
		return driver.getTitle();

	}
	
	//method to select topic covered link in Queue module
	public  void GraphTopicCovered(String topicList) {

		WebElement topicCoveredList = null;

		if (topicList.contains("Graph")) {
            topicCoveredList = graphlink ;
			
		} else if (topicList.equals("GraphRepresentations")) {
			topicCoveredList = GraphRepresentations ;

		} 
		System.out.println("User clicked on " + topicList + " link");

		topicCoveredList.click();
		//System.out.println("AfterUser clicked on " + topicList + " link"+ topicCoveredList);
	}
	
	
public String practiceQuesGetTitle() {
		
		String Title=driver.getTitle(); ;
		return Title;
	}


public void practiceQuesGraph() {
	PracQuestion.click();
	System.out.println(driver.getTitle());

}


	//Click on tryHere>>> link
		public String tryHere() {
			tryHereLink.click();
			return driver.getTitle();
		}
	
	
		// method to receive python code and check if it's valid or invalid code
		public void graphPagePythonCodeValidationAndRun(String pythonCodefrmFeature) throws InterruptedException {

			if (pythonCodefrmFeature.contains(" '")) {
				System.out.println("User Enter:  "+pythonCodefrmFeature);
				tryEditorValidPythonCode(pythonCodefrmFeature);

			} else {
				System.out.println("User Enter: "+pythonCodefrmFeature);
				tryEditorInvalidPythonCode(pythonCodefrmFeature);

			}
		}
		// valid python code validation method
				public String tryEditorValidPythonCode(String PythonCode) throws InterruptedException {
					
					tryEditor.sendKeys(PythonCode);
					runButton.click();
					Thread.sleep(1000);
					String runMsg=outputGraph.getText();
					System.out.println(runMsg);
					GraphPageClearText();
					return runMsg; 			
				}
				
		//invalid python code validation method
		public void tryEditorInvalidPythonCode(String PythonCode) throws InterruptedException {

			tryEditor.sendKeys(PythonCode);
			runButton.click();
		//	Thread.sleep(2000);
			switchToAlert();
			
		}

public String tryEditorMessage() {
			
			String runMsg=outputGraph.getText();
			System.out.println(runMsg);
			return runMsg;
		}
		//Pop up alert in case of invalid code and get text alert 
		public String switchToAlert() throws InterruptedException {

			Alert alert = driver.switchTo().alert();
			String alertmsg=alert.getText();
			System.out.println(alert.getText());
			alert.dismiss();
			Thread.sleep(1000);
			return alertmsg;
		}
		
	// clear the text field where code is written
		public void GraphPageClearText() throws InterruptedException {
			Thread.sleep(1000);
			Actions a = new Actions(driver);
			a.keyDown(sourceGraph, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE)
					.keyUp(Keys.DELETE).perform();
			Thread.sleep(1000);

		}


}
