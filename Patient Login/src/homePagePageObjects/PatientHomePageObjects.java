package homePagePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientHomePageObjects {
	
	@FindBy(xpath="//*[@id=\"leftSideHistory\"]/td[2]")
	public static WebElement EHR;
	@FindBy(xpath="/html/body/div[4]/div[4]/div[1]/div[2]/div/table/tbody/tr/td[2]/div/div[6]/div[44]/div[1]/div[1]/div/div[1]/span")
	public static WebElement HealthRecord;
	@FindBy(xpath="//*[@id=\"list_ehr_needHelp\"]/i")
	public static WebElement print;
	@FindBy(xpath="/html/body")
	public static WebElement printiframe;

}
