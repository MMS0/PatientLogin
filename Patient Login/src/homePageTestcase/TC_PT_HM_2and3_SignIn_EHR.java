package homePageTestcase;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.LaunchBrowser;
import homePagePageObjects.PatientHomePageObjects;
import homePagePageObjects.SignInObjects;

public class TC_PT_HM_2and3_SignIn_EHR extends LaunchBrowser {

	public void Signin() {
		PageFactory.initElements(driver, SignInObjects.class);
		SignInObjects.signin.click();
		SignInObjects.id.sendKeys(property.getProperty("Patientid"));
		SignInObjects.pwd.sendKeys(property.getProperty("Patientpwd"));
		SignInObjects.SignIn.click();
	}
	public void ListEHR() throws IOException, InterruptedException {
		PageFactory.initElements(driver, PatientHomePageObjects.class);
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(PatientHomePageObjects.HealthRecord));
		//Thread.sleep(3000);
		System.out.println("TC2. Verify whether it navigate to home page of 75Health.com when click on sign in/login button after entering valid username and password "
				+ "\nTC3. Verify Whether List EHR page is displayed after successfull login");
		String actualtitle=driver.getTitle();
		String expectedtitle="List EHR";
		String ehr=PatientHomePageObjects.HealthRecord.getText();
		if(ehr.equalsIgnoreCase("HEALTH RECORD"))
		//if(actualtitle.equals(expectedtitle))
		{
			System.out.println("\nList EHR page is displayed after successfull login: " + ehr +"\n");
			//System.out.println("\nList EHR page is displayed after successfull login: " + actualtitle +"\n");
		}else{
			System.out.println("\nNot Displayed the List EHR page");
		}
		/*WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(PatientHomePageObjects.HealthRecord));*/
	
		File EHRsc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(EHRsc, new File("ScreenShots/TC2and3.ListEHRpageScreenshot.png"));
	}
	@Test
	public void testcase2() throws IOException, InterruptedException
	{
		Signin();
		ListEHR();
		
	}
}
