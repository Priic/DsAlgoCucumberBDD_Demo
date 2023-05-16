package stepDefinitions;


import org.apache.commons.lang3.RandomStringUtils;

import pageObjects.HomePagePOM;
import pageObjects.linkedListPagePOM;
import pageObjects.queuePagePOM;
import pageObjects.registerPagePOM;
import pageObjects.signInPagePOM;
import pageObjects.stackPagePOM;
import pageObjects.startPagePOM;


public class baseTest {
	// Base class to maintain the page object classes
	//reusable methods that are applicable to all classes
	public HomePagePOM hPage;
	public startPagePOM sPage;
	public registerPagePOM regPage;
	public signInPagePOM signpage;
	public linkedListPagePOM lListpage;
	public stackPagePOM stackPage;
	public queuePagePOM queuePage;
	
	
	
	public static String randomUtilUsername() {
		
		String userName = RandomStringUtils.randomAlphanumeric(5);
		String id="@ninja.com";
		String Userid=userName+id;
		System.out.println(Userid);
		return Userid;
	}
	
	
}

	




