package pageObjects;


import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM  {

	public WebDriver driver;
	//public static FileReader fileReader; // reading properties file
	//public static Properties p = new Properties(); // getting properties of file
     

	public HomePagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// DataStructure webElement
	@FindBy(xpath = "//h5[text()='Data Structures-Introduction']")
	WebElement dsIntroOption;

	@FindBy(xpath = "//h5[text()='Data Structures-Introduction']/../a")
	WebElement dsIntroGetstartedBtn;

	// Array webElement
	@FindBy(xpath = "//h5[text()='Array']")
	WebElement ArrayOption;
	@FindBy(xpath = "//h5[text()='Array']/../a")
	WebElement ArrayGetStartedBtn;
	@FindBy(xpath = "//a[@href='/array']")
	WebElement ArrayDrpDown;

	// LinkedListOption webElement
	@FindBy(xpath = "//h5[text()='Linked List']")
	WebElement LinkedListsOption;
	@FindBy(xpath = "//h5[text()='Linked List']/../a")
	WebElement LinkedListsGetstartedBtn;
	@FindBy(xpath = "//a[@href='/linked-list']")
	WebElement linkedListDrpDown;

	// StackOption
	@FindBy(xpath = "//h5[text()='Stack']")
	WebElement StackOption;
	@FindBy(xpath = "//h5[text()='Stack']/../a")
	WebElement StackGetStartedBtn;
	@FindBy(xpath = "//a[@href='/stack']")
	WebElement stackDrpDown;

	// Tree webElement
	@FindBy(xpath = "//h5[text()='Tree']")
	WebElement TreeOption;
	@FindBy(xpath = "//h5[text()='Tree']/../a")
	WebElement TreeGetstartedBtn;
	@FindBy(xpath = "//a[@href='/tree']")
	WebElement treeDrpDown;

	// Queue webElement
	@FindBy(xpath = "//h5[text()='Queue']")
	WebElement QueueOption;
	@FindBy(xpath = "//h5[text()='Queue']/../a")
	WebElement QueueGetstartedBtn;
	@FindBy(xpath ="//a[@href='/queue']")
	WebElement queueDrpDown;

	// Graph webElement
	@FindBy(xpath = "//h5[text()='Graph']")
	WebElement GraphOption;
	@FindBy(xpath = "//h5[text()='Graph']/../a")
	WebElement GraphGetStartedBtn;
	@FindBy(xpath ="//a[@href='/graph']")
	WebElement graphDrpDown;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement dropDownOptionElement;
	@FindBy(xpath = "//div[@role='alert']")
	WebElement warningMessage;
	// SignIn
	@FindBy(xpath ="//a[@href='/login']")
	WebElement signInBtn;

	// register
	@FindBy(xpath ="//a[@href='/register']")
	WebElement registerBtnHomePage;
	//signIn
	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement signInbutton;

	// dropdown box option
	public void homeClickDrpdown(String option) throws InterruptedException {
		Thread.sleep(1000);
		WebElement dropoptionlist = null;
		dropDownOptionElement.click();

		if (option.equals("Array")) {

			dropoptionlist = ArrayDrpDown;
		} else if (option.equals("Linked List")) {

			dropoptionlist = linkedListDrpDown;
		} else if (option.equals("Stack")) {
			dropoptionlist = stackDrpDown;
		} else if (option.equals("Queue")) {
			dropoptionlist = queueDrpDown;
		} else if (option.equals("Tree")) {
			dropoptionlist = treeDrpDown;
		} else if (option.equals("Graph")) {
			dropoptionlist = graphDrpDown;
		}
		System.out.println("User select " + option + " from the dropDownBox");
		dropoptionlist.click();
		Thread.sleep(1000);
	}

	// click on get started button at home page
	public void homeGetStartedClick(String option) throws InterruptedException {

		WebElement optionlist = null;

		if (option.equals("Data Structures-Introduction")) {

			optionlist = dsIntroGetstartedBtn;
		} else if (option.equals("Array")) {
			optionlist = ArrayGetStartedBtn;
		} else if (option.equals("Linked List")) {
			optionlist = LinkedListsGetstartedBtn;
		} else if (option.equals("Stack")) {
			optionlist = StackGetStartedBtn;
		} else if (option.equals("Queue")) {
			optionlist = QueueGetstartedBtn;
		} else if (option.equals("Tree")) {
			optionlist = TreeGetstartedBtn;
		} else if (option.equals("Graph")) {
			optionlist = GraphGetStartedBtn;
		}
		System.out.println("User clicked on " + option + " GetStartedButton");
		
		optionlist.click();
		Thread.sleep(1000);
	}

	public void homeSignInLink() throws InterruptedException {
		
		Thread.sleep(1000);
		signInBtn.click();
	}

	public void homeRegisterLinkClick() throws InterruptedException {
		
		Thread.sleep(1000);
		registerBtnHomePage.click();
	}

	public String WarningMsg() {
		
		String msgString=warningMessage.getText();
					
		System.out.println("You need to sign in to access the content "+ msgString);
		
		return msgString;
	}
	
	
	
	
	 public registerPagePOM homePageToRegister() {
	    	
	//	 driver.get(p.getProperty("HomePageURL"));
		 System.out.println(driver.getTitle());
		   return new registerPagePOM(driver); 	
		    
	    }
}
