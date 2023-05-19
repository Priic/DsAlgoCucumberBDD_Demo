package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class treePage_PF {
	public WebDriver driver;
	
	public  treePage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Tree page
	
	@FindBy(xpath=("//a[text()='Overview of Trees']"))
	WebElement overviewoftreelink;
	
	@FindBy(xpath=("//a[text()='Terminologies']"))
	WebElement Terminologieslink;
	
	@FindBy(xpath=("//a[text()='Types of Trees']"))
	WebElement TypesofTreeslink;
	
	@FindBy(xpath=("//a[text()='Tree Traversals']"))
	WebElement TreeTraversals;
	
	@FindBy(xpath=("//a[text()='Traversals-Illustration']"))
	WebElement TraversalsIllustration;
	
	@FindBy(xpath=("//a[text()='Binary Trees']"))
	WebElement BinaryTrees ;
	
	@FindBy(xpath=("//a[text()='Types of Binary Trees']"))
	WebElement typesofBinaryTrees ;
	
	@FindBy(xpath=("//a[text()='Implementation in Python']"))
	WebElement implinpython ;
	
	@FindBy(xpath=("//a[text()='Binary Tree Traversals']"))
	WebElement BinaryTreeTraversals ;
	
	@FindBy(xpath=("//a[text()='Implementation of Binary Trees']"))
	WebElement implofbinarytrees ;
	
	@FindBy(xpath=("//a[text()='Applications of Binary trees']"))
	WebElement Applofbinarytrees;
	
	@FindBy(xpath=("//a[text()='Binary Search Trees']"))
	WebElement BinarySearchTrees;
	
	@FindBy(xpath=("//a[text()='Implementation Of BST']"))
	WebElement ImplOfBST;
	
	@FindBy(xpath="//a[text()='Practice Questions']")
	WebElement PracQuestion;
	
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHereLink;
	
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
	WebElement tryEditor;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement runButton;
	
	@FindBy(xpath = "//pre[@id='output']")
	WebElement outputTree;
	
	@FindBy(xpath = "//span[@role='presentation']")
	WebElement sourceTree;

	public String treePageGetTitle() {
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Tree");
		return driver.getTitle();

	}
	
	//method to select topic covered link in Tree module
	public  void TreeTopicCovered(String topicList) {

		WebElement topicCoveredList = null;

		if (topicList.contains("Overview of Trees")) {
            topicCoveredList = overviewoftreelink;
			
		} else if (topicList.contains("Terminologies")) {
			topicCoveredList = Terminologieslink ;

		} else if (topicList.contains("Types of Trees")) {
			topicCoveredList = TypesofTreeslink ;

		} else if (topicList.contains("Tree Traversals")) {
			topicCoveredList = TreeTraversals ;

		} else if (topicList.contains("Traversals-Illustration")) {
			topicCoveredList = TraversalsIllustration ;

		} else if (topicList.contains("Binary Trees")) {
			topicCoveredList = BinaryTrees;

		} else if (topicList.contains("Types of Binary Trees")) {
			topicCoveredList = typesofBinaryTrees ;

		} else if (topicList.contains("Implementation in Python")) {
			topicCoveredList = implinpython ;

		} else if (topicList.contains("Binary Tree Traversals")) {
			topicCoveredList = BinaryTreeTraversals ;

		} else if (topicList.contains("Implementation of Binary Trees")) {
			topicCoveredList = implofbinarytrees ;

		} else if (topicList.contains("Applications of Binary trees")) {
			topicCoveredList = Applofbinarytrees ;

		} else if (topicList.contains("Binary Search Trees")) {
			topicCoveredList = BinarySearchTrees ;

		} else if (topicList.contains("Implementation Of BST")) {
			topicCoveredList = ImplOfBST ;

		} 
		
		System.out.println("User clicked on " + topicList + " link");

		topicCoveredList.click();
	
	}
	
	public String practiceQuesGetTitle() {
		
		String Title=driver.getTitle(); ;
		return Title;
	}
	
	//click practice question link  
	public void practiceQuesTree() {
		PracQuestion.click();
		System.out.println(driver.getTitle());
	
	}
	
	//Click on tryHere>>> link
		public String tryHere() {
			tryHereLink.click();
			return driver.getTitle();
		}
	
	
		// method to receive python code and check if it's valid or invalid code
		public void treePagePythonCodeValidationAndRun(String PythonCodeFrmFeature) throws InterruptedException {

			if (PythonCodeFrmFeature.contains(" '")) {
				System.out.println("User Enter:  "+PythonCodeFrmFeature);
				tryEditorValidPythonCode(PythonCodeFrmFeature);

			} else {
				System.out.println("User Enter: "+PythonCodeFrmFeature);
				tryEditorInvalidPythonCode(PythonCodeFrmFeature);

			}
		}

		public String tryEditorValidPythonCode(String PythonCode) throws InterruptedException {
			
			tryEditor.sendKeys(PythonCode);
			runButton.click();
			Thread.sleep(1000);
			String runMsg=outputTree.getText();
			System.out.println(runMsg);
			treePageClearText();
			return runMsg; 			
		}
		//invalid python code validation method
		public void tryEditorInvalidPythonCode(String PythonCode) throws InterruptedException {

			tryEditor.sendKeys(PythonCode);
			runButton.click();
		//	Thread.sleep(1000);
			switchToAlert();
			
		}

		public String tryEditorMessage() {
			
			String runMsg=outputTree.getText();
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
		public void treePageClearText() throws InterruptedException {
			Thread.sleep(1000);
			Actions a = new Actions(driver);
			a.keyDown(sourceTree, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE)
					.keyUp(Keys.DELETE).perform();
		//	Thread.sleep(1000);

		}

}
