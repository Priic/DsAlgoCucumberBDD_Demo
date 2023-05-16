package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Helper;

public class signInPage_PF {
	
	public  WebDriver driver ;

	public signInPage_PF(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// user and Password
	@FindBy(xpath = "//input[@type='text']")
	WebElement loginPageUserName;
	@FindBy(xpath = "//input[@type='password']")
	WebElement loginPagePassWord;
	//signinbutton home page
	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement homePageSignInLink;

	//registerLink
	@FindBy(xpath = "//a[text()=' Register ']")
	WebElement homePageRegisterLink;
	
	//LoginButton at Login page
	@FindBy(xpath = "//input[@type='submit']")
	WebElement SignInPageloginbtn;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement displayMessage;
	
	@FindBy(xpath="//a[text()='Sign out']")
	WebElement signOutbutton;
	
	
	

	public  String homePageclickLogin()
	{
		homePageSignInLink.click();
		
		
		return driver.getTitle();
		
	}
	
	/*public  void clickLoginButtonLPage()
	{
		SignInPageloginbtn.click();
	/*	String displayMsg=displayMessage.getText();
		loginPageDisplayMsg();
		return displayMsg; */
		
	//} 
	
	public  String loginPageDisplayMsg()
	{
	
		String displayMsg=displayMessage.getText();
	//	System.out.println(displayMsg);
		return displayMsg;
		
	}
	
	public void signInPageValidation(String lUsername, String lPassword, String excelMsg) throws InterruptedException {
	//	String errorMsg = null;
		loginPageUserName.sendKeys(lUsername);
		loginPagePassWord.sendKeys(lPassword);
		
		if ((lUsername.isBlank()))
		{
			System.out.println(excelMsg);
		//	return excelMsg;
		}
		
		if ((lPassword.isBlank()))
		{
			System.out.println(excelMsg);
		//	return excelMsg;
		}
		
		if (!(lUsername.isBlank()) && !(lPassword.isBlank())) {
			Thread.sleep(1000);
			
			SignInPageloginbtn.click();
		//	errorMsg=displayMessage.getText();
		//	return errorMsg;
		}
		//	LoginPageDoSignin(lUsername, lPassword);
		//	errorMsg= displayMessage.getText();
		//	loginPageDisplayMsg();
		//	return errorMsg; /
		//	return excelMsg;
		//	} 
			
	//	return excelMsg;

	}

	public void LoginPageDoSignin(String username, String psw) throws InterruptedException {
	
		Thread.sleep(1000);
		//loginPageUserName.clear();
		loginPageUserName.sendKeys(username);
	//	loginPagePassWord.clear();
		loginPagePassWord.sendKeys(psw);
		//clickLoginButtonLPage();
		SignInPageloginbtn.click();
		
		//return successMsg;
				
	}
	public void LoginPageDoSignOut() {
		
		
		signOutbutton.click();
		loginPageDisplayMsg();
		
	}
	
	
}
