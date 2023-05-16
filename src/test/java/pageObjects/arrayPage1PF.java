package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class arrayPage1PF {

	public WebDriver driver;

	public arrayPage1PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Get Started']")
	WebElement getstartedBtn;
//	@FindBy(xpath = "//a[text()='Sign in']")WebElement signIn;
//	@FindBy(id = "id_username")WebElement userName;
//	@FindBy(id = "id_password")WebElement Password;
//	@FindBy(xpath = "//input[@value='Login']")WebElement logIn;
	@FindBy(xpath = "//a[@href='array']")
	WebElement arrayGetStartedBtn;
	@FindBy(xpath = "//a[text()='Arrays in Python']")
	WebElement arrayInPytBtn;
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHeredBtn;
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
	WebElement Type;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement Run;
	@FindBy(xpath = "//a[text()='Arrays Using List']")
	WebElement arrayUsiListBtn;
	@FindBy(xpath = "//a[text()='Basic Operations in Lists']")
	WebElement basicOpInListBtn;
	@FindBy(xpath = "//a[text()='Applications of Array']")
	WebElement AppOfArrBtn;
	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement praQueBtn;
	@FindBy(xpath = "//a[text()='Search the array']")
	WebElement seaTheArrBtn;
	@FindBy(xpath = "//a[text()='Max Consecutive Ones']")
	WebElement maxConOnesBtn;
	@FindBy(xpath = "//a[text()='Find Numbers with Even Number of Digits']")
	WebElement findNumsBtn;
	@FindBy(xpath = "//a[text()='Squares of  a Sorted Array']")
	WebElement sortAreaBtn;
	@FindBy(xpath = "//pre[@id='output']")
	WebElement outputArray;
	@FindBy(xpath = "//span[@role='presentation']")
	WebElement sourceArray;

//	public void ArrayLogIn() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://dsportalapp.herokuapp.com/");
//
//	}

//
	public String ArrayPageGetTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void getstartedClick() {
		getstartedBtn.click();
	}

	public String ArrayTopicCovered(String topicList) {
		WebElement topicCoveredList = null;

		if (topicList.contains("Arrays in Python")) {
			topicCoveredList = arrayInPytBtn;

		} else if (topicList.contains("Arrays Using List")) {
			topicCoveredList = arrayUsiListBtn;

		} else if (topicList.contains("Basic Operations in Lists")) {
			topicCoveredList = basicOpInListBtn;

		} else if (topicList.contains("Applications of Array")) {
			topicCoveredList = AppOfArrBtn;

		}
		System.out.println("User clicked on " + topicList + "link");
		topicCoveredList.click();
		return driver.getTitle();
	}

	public String tryHereArray() {
		tryHeredBtn.click();
		return driver.getTitle();
	}

	public void practiceQuesList() {
		praQueBtn.click();
		System.out.println(driver.getTitle());
	}

	public String practiceQuesGetTitle() {

		String Title = driver.getTitle();
		;
		return Title;
	}

	public void ArrayPracticeQues(String Links) {

		WebElement arrayPracticeQues = null;

		if (Links.contains("Search the array")) {
			arrayPracticeQues = seaTheArrBtn;

		} else if (Links.contains("Max Consecutive Ones")) {
			arrayPracticeQues = maxConOnesBtn;

		} else if (Links.contains("Find Numbers with Even Number of Digits")) {
			arrayPracticeQues = findNumsBtn;

		} else if (Links.contains("Squares of  a Sorted Array")) {
			arrayPracticeQues = sortAreaBtn;

		}
		System.out.println("User clicked on " + Links + "link");
		arrayPracticeQues.click();
	}

	public void ArrayPageValidCode(String pythonCodefrmFeature) throws InterruptedException {
		
		String runMsg="";
		System.out.println(pythonCodefrmFeature);
		Type.sendKeys(pythonCodefrmFeature);
		Run.click();
		
		runMsg = outputArray.getText();
		
		if(runMsg!="") {
			
			System.out.println(runMsg);
			ArrayClearText();
			tryEditorMessage();
		}
		else {
			
			switchToAlert();
		}
	}

//for valid code
	public String tryEditorValidPythonCode(String PythonCode) throws InterruptedException {

		System.out.println(PythonCode);
		Type.sendKeys(PythonCode);
		Run.click();
		String runMsg = outputArray.getText();
		System.out.println(runMsg);
		ArrayClearText();
		return runMsg;
	}

//for invalid code
	public void tryEditorInvalidPythonCode(String PythonCode) throws InterruptedException {

		Type.sendKeys(PythonCode);
		Run.click();
		Thread.sleep(3000);
		switchToAlert();
	}

	public String tryEditorMessage() {

		String runMsg = outputArray.getText();
		System.out.println(runMsg);
		return runMsg;
	}

	public String switchToAlert() throws InterruptedException {

		Alert alert = driver.switchTo().alert();
		String alertmsg = alert.getText();
		System.out.println(alert.getText());
		alert.dismiss();
		Thread.sleep(3000);
		ArrayClearText();
		return alertmsg;
	}

	public String tryEditorAlertMessage() throws InterruptedException {

		String alertMsg = outputArray.getText();
		System.out.println(alertMsg);

		return alertMsg;

	}

	public void ArrayClearText() throws InterruptedException {
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.keyDown(sourceArray, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE)
				.perform();
		Thread.sleep(3000);

	}

}
