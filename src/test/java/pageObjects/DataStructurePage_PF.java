package pageObjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class DataStructurePage_PF {
	
	public WebDriver driver;

	public DataStructurePage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h5[text()='Data Structures-Introduction']/../..//a")WebElement DSgetStarted;
	@FindBy(xpath="//a[text()='Time Complexity']")WebElement DStimeCompBtn;
	
	@FindBy(xpath="//a[text()='Try here>>>']")WebElement tryHere;
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")WebElement tryEditor;
	@FindBy(xpath="//button[text()='Run']")WebElement RunButton;
	@FindBy(xpath ="//form[@id='answer_form']/../..//span")WebElement delete;
	@FindBy(xpath = "//pre[@id='output']")WebElement outputDS;
	@FindBy(xpath = "//span[@role='presentation']")WebElement sourceDS;
	@FindBy(xpath = "//a[text()='Practice Questions']") WebElement PracQuestion;
	

	public String dataStructurePage() {
		String title = driver.getTitle();
		return title;


	}
	
	// click practice question link
		public void practiceQuesdStr() {
			PracQuestion.click();
			System.out.println(driver.getTitle());
		
		}
		
		public String practiceQuesGetTitle() {
			
			String Title=driver.getTitle(); ;
			return Title;
		}
		
	
	public void getStartedClick() {
		DSgetStarted.click();
	}
	public void dsTopicsCovered() {
		DStimeCompBtn.click();
	}
	public void tryHereDS() {
		tryHere.click();
	}
	

	public void dsPagePythonCodeValidation(String PythonCodeFrmFeature) throws InterruptedException {

		if (PythonCodeFrmFeature.contains(" '")) {
			System.out.println("User Enter:  "+PythonCodeFrmFeature);
			tryEditorValidPythonCode(PythonCodeFrmFeature);

		} else {
			System.out.println("User Enter: "+PythonCodeFrmFeature);
			tryEditorInvalidPythonCode(PythonCodeFrmFeature);

		}
	}
//for valid code
	public String tryEditorValidPythonCode(String PythonCode) throws InterruptedException {

		tryEditor.sendKeys(PythonCode);
		RunButton.click();
		String runMsg = outputDS.getText();
		System.out.println(runMsg);
		//Thread.sleep(1000);
		dsPageClearText();
		return runMsg;
	}
//for invalid code
	public void tryEditorInvalidPythonCode(String PythonCode) throws InterruptedException {

		tryEditor.sendKeys(PythonCode);
		RunButton.click();
	//	Thread.sleep(1000);
		switchToAlert();
	}
	   public String tryEditorMessage() {
			
			String runMsg=outputDS.getText();
			System.out.println(runMsg);
			return runMsg;
		}
		

	public String switchToAlert() throws InterruptedException {

		Alert alert = driver.switchTo().alert();
		String alertmsg=alert.getText();
		System.out.println(alert.getText());
		alert.dismiss();
	//	Thread.sleep(1000);
		dsPageClearText();
		return alertmsg;
	}

    public String tryEditorAlertMessage() throws InterruptedException {
	
	String alertMsg=outputDS.getText();
	System.out.println(alertMsg);
	
	return alertMsg;
			
}


	public void dsPageClearText() throws InterruptedException {
	//	Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.keyDown(sourceDS, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE)
				.perform();
	//	Thread.sleep(1000);

	}

}
