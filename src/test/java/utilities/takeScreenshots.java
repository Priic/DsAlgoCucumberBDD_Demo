package utilities;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class takeScreenshots {
	
	//public static WebDriver driver;
	
/*	public takeScreenshots(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} */
	
	
	public static void captureScreenShots(WebDriver driver,String filename) throws IOException {
				
		Date currentdate=new Date();
		String screenshotfilename=currentdate.toString().replace(" ","-").replace(":", "-");
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ScreenShots\\"+screenshotfilename+".png"));	

	}
}


