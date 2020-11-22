package homePageTestcase;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event.ID;

import commonFunctions.LaunchBrowser;
import homePagePageObjects.SignInObjects;

public class TC_PT_HM_1_SignInPage extends LaunchBrowser {
	
	public void Home()
	{
		PageFactory.initElements(driver, SignInObjects.class);
		SignInObjects.signin.click();
	}
	public void signinpage() throws IOException
	{
		PageFactory.initElements(driver, SignInObjects.class);
		System.out.println("\"Verify whether it display the following on signin/login page\r\n" + 
				"1. Email\r\n" + 
				"2. Password\r\n" + 
				"3. sign in\r\n" + 
				"4. Sign Up\r\n" + 
				"5. forget password\r\n" + 
				"6. Remember me\"");
		System.out.println("\nSignIn Page title is: "+driver.getTitle()+"\n");
		if(SignInObjects.id.isDisplayed()){
			System.out.println("Email text box is Displayed");
		}else {
			System.out.println("Not Displayed the Email text box");
		}
		if(SignInObjects.pwd.isDisplayed()){
			System.out.println("Password text box is Displayed");
		}else {
			System.out.println("Not Displayed the Password text box");
		}
		if(SignInObjects.SignIn.isDisplayed()){
			System.out.println("SignIn button is Displayed");
		}else {
			System.out.println("Not Displayed the SignIn button");
		}
		if(SignInObjects.remember.isDisplayed()){
			System.out.println("Remember me checkbox is Displayed");
		}else {
			System.out.println("Not Displayed the Remember Me");
		}
		if(SignInObjects.forget_pwd.isDisplayed()){
			System.out.println("Forgot Password button is Displayed");
		}else {
			System.out.println("Not Displayed the Forgot Password button");
		}
		if(SignInObjects.SignUp.isDisplayed()){
			System.out.println("Sign Up button is Displayed\n");
		}else {
			System.out.println("Not Displayed the Sign Up button");
		}
		
		File signinscreen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(signinscreen, new File ("ScreenShots/TC1.SignInPageScreenshot.png"));
	}
	@Test
	public void SignIn() throws IOException
	{
		Home();
		signinpage();
	}

}
