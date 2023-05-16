package stepDefinitions;


import org.apache.commons.lang3.RandomStringUtils;

import pageObjects.HomePage_PF;
import pageObjects.linkedListPage_PF;
import pageObjects.queuePage_PF;
import pageObjects.registerPage_PF;
import pageObjects.signInPage_PF;
import pageObjects.stackPage_PF;
import pageObjects.startPage_PF;


public class baseTest {
	// Base class to maintain the page object classes
	//reusable methods that are applicable to all classes
	public HomePage_PF hPage;
	public startPage_PF sPage;
	public registerPage_PF regPage;
	public signInPage_PF signpage;
	public linkedListPage_PF lListpage;
	public stackPage_PF stackPage;
	public queuePage_PF queuePage;
	
	
	
	public static String randomUtilUsername() {
		
		String userName = RandomStringUtils.randomAlphanumeric(5);
		String id="@ninja.com";
		String Userid=userName+id;
		System.out.println(Userid);
		return Userid;
	}
	
	
}

	




