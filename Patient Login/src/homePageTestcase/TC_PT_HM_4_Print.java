package homePageTestcase;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.LaunchBrowser;
import homePagePageObjects.PatientHomePageObjects;
import homePagePageObjects.SignInObjects;

public class TC_PT_HM_4_Print extends LaunchBrowser {
	
	public void Signin() {
		PageFactory.initElements(driver, SignInObjects.class);
		SignInObjects.signin.click();
		SignInObjects.id.sendKeys(property.getProperty("Patientid"));
		SignInObjects.pwd.sendKeys(property.getProperty("Patientpwd"));
		SignInObjects.SignIn.click();
	}
	public void ehrprint() throws IOException, InterruptedException
	{
		PageFactory.initElements(driver, PatientHomePageObjects.class);
		PatientHomePageObjects.print.click();
		System.out.println("TC4. Verify Whether able to print the page \n");
		Thread.sleep(5000);
		System.out.println("Print Page is Showing Successfully\n");
		//driver.switchTo().frame(PatientHomePageObjects.printiframe);
		File print=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(print, new File("ScreenShots/TC4.PrintpageScreenshot.png"));
	}
	
	@Test
	public void testcase4() throws IOException, InterruptedException {
		Signin();
		ehrprint();
		
	}
}
