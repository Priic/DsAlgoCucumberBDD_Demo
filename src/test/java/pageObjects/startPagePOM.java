package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class startPagePOM {

	public WebDriver driver;

	// driver initialization

	public startPagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// webElement PageFactory Model
	@FindBy(className = "btn")

	WebElement getStartedbtn;

	// clicking on getStartedButton
	public void getStartedClick() throws InterruptedException {
		Thread.sleep(1000);
		getStartedbtn.click();

	}

	public String startPageTitle() {

		String title = driver.getTitle();
		System.out.println(driver.getTitle());
		return (title);
	}

	
	 public HomePagePOM startPageHomePage() {
	  
	  System.out.println("I am on home page"); 
	  return new HomePagePOM(driver);
	  
	  }
	 

}
