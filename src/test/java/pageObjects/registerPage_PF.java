package pageObjects;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.baseTest;

public class registerPage_PF extends baseTest {

	public WebDriver driver;

	public registerPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password1']")
	WebElement passWord;

	@FindBy(xpath = "//input[@name='password2']")
	WebElement confirmPassWord;
	@FindBy(xpath = "//input[@value='Register']")
	WebElement registerBtnRegisterPage;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement displayMessage;

	@FindBy(xpath = "//a[text()='Login ']")
	WebElement loginlink;

	public void callTakescreenShots(String filename) throws IOException {

		// utilities.takeScreenshots ts = new utilities.takeScreenshots(driver);
		// ts.captureScreenShots();
		utilities.takeScreenshots.captureScreenShots(driver, filename);

	}

	public void regPageEmptyUserDetails() throws InterruptedException {

		registerBtnRegisterPage.click();
		Thread.sleep(500);
	}

	public void regPagePasswordBlank() throws InterruptedException {

		userName.sendKeys(baseTest.randomUtilUsername());
		registerBtnRegisterPage.click();
		Thread.sleep(500);
	}

	public void regPageCnfPasswordBlank(String pswrd) throws InterruptedException {

		userName.sendKeys(baseTest.randomUtilUsername());
		passWord.sendKeys(pswrd);
		registerBtnRegisterPage.click();
		Thread.sleep(500);
	}

	/*
	 * public void registerUser(String user, String passwrd, String confirmPs,
	 * String msg) throws InterruptedException, IOException {
	 * 
	 * if (user.isBlank() && passwrd.isBlank() && confirmPs.isBlank()) {
	 * 
	 * }
	 * 
	 * else if (!(user.isBlank())) { System.out.println("User is not blank");
	 * 
	 * } }
	 */
	public void registerRecDataFromExcel(String exceluser, String excelpasswrd, String excelconfirmPs, String excelmsg)
			throws InterruptedException, IOException {
		userName.clear();
		userName.sendKeys(exceluser);
		passWord.clear();
		passWord.sendKeys(excelpasswrd);
		confirmPassWord.clear();
		confirmPassWord.sendKeys(excelconfirmPs);
		// registerBtnRegisterPage.click();
		Thread.sleep(500);

		if (exceluser != null || excelpasswrd != null || excelconfirmPs != null) {

			System.out.println("Data received is not null");
			RegisterUserValidation(exceluser, excelpasswrd, excelconfirmPs, excelmsg);
		}

	}

	public void RegisterUserValidation(String user, String passwrd, String confirmPs, String msg)
			throws InterruptedException {

		Pattern p = Pattern.compile("[a-zA-Z0-9 @,.,-/_ ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(user);
		boolean b = m.find();
		System.out.println(b);

		if (!b) {
			System.out.println("Invalid UserName entered");
			//System.out.println(displayMessage.getText());
			//return displayMessage.getText();
		}
		if (!(passwrd.isBlank()) && (passwrd == confirmPs)) {
			System.out.println("validate password if username is valid");

			RegisterPasswordValidation(passwrd);
		//	return displayMessage.getText();

		} else {
			System.out.println("Entered Password and Confirmed Password is not same");

		}
		//return displayMessage.getText();
	}

	public void RegisterPasswordValidation(String passwrd) throws InterruptedException {

		if (passwrd.length() >= 8) {
			Pattern letter = Pattern.compile("[a-zA-z]");
			Pattern digit = Pattern.compile("[0-9]");
			Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
			// Pattern eight = Pattern.compile (".{8}");

			Matcher hasLetter = letter.matcher(passwrd);
			Matcher hasDigit = digit.matcher(passwrd);
			Matcher hasSpecial = special.matcher(passwrd);
			boolean b = hasLetter.find() && hasDigit.find() && hasSpecial.find();
			System.out.println(b);
			if (b) {

				Thread.sleep(500);
				loginlink.click();
				System.out.println("Valid Password");
				//System.out.println(displayMessage.getText());
			//	return displayMessage.getText();
			}
		} else {
			System.out.println("password less than 8 digit");
		//	System.out.println(displayMessage.getText());
		//	return displayMessage.getText();

		}
	//	return displayMessage.getText();
	}

	public void RegisterValidData(String passwrd, String confirmPs) throws InterruptedException {
		userName.clear();
		userName.sendKeys(baseTest.randomUtilUsername());
		passWord.clear();
		passWord.sendKeys(passwrd);
		confirmPassWord.clear();
		confirmPassWord.sendKeys(confirmPs);
		// registerBtnRegisterPage.click();
	}

	public String homeToregisterPage() throws InterruptedException {

		driver.getTitle();
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public void clickRegBtnOnRegisterPage() throws InterruptedException {

		registerBtnRegisterPage.click();
		Thread.sleep(500);
	}

	public String gotoHomePage() throws InterruptedException {

		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public String Message() {

		String WebMsg = displayMessage.getText();
		return WebMsg;

	}

}
