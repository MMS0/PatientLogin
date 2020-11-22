package homePagePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInObjects {

	@FindBy(xpath="//div[@class='main_btn_action']")
	public static WebElement signin;
	@FindBy(how=How.ID,using="userLoginId") 
	public static WebElement id;
	@FindBy(how=How.ID,using="currentPassword")
	public static WebElement pwd;
	@FindBy(xpath="//span[@id='remember_me_label']")
	public static WebElement remember;
	@FindBy(xpath="//span[@onclick='login.resetPassword()']")
	public static WebElement forget_pwd;
	@FindBy(id="signin_button")
	public static WebElement SignIn;
	@FindBy(xpath="//span[text()='Sign Up']")
	public static WebElement SignUp;
	
}
