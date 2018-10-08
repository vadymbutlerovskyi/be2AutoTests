package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import tests.BaseTest;

public class MyProfilePage extends BaseTest {

	public MyProfilePage(WebDriver driver, ExtentTest test){
		super(driver, test);
		PageFactory.initElements(driver,  this);
	}

	//*******Page Objects*******	
	@FindBy(how = How.XPATH, using = "//tr[@class='greeting']//following::tr/td[2]")
	private List<WebElement> profileProperties;

	//*******Gets*******	
	public String getAge() {
		String age = profileProperties.get(0).getText();
		report.pass(age + " was returned as an age");
		return age;
	}

	public String getEducation() {
		String edu = profileProperties.get(1).getText();
		report.pass(edu + " was was returned as an education");
		return edu;
	}

	//*******Waiters*******
	public void waitForMyProfile() {
		Integer interval = 5;
		try {
			WebDriverWait wait = new WebDriverWait(_driver, interval);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("profile-properties")));
			report.pass("My Profile is loaded");
		}
		catch (org.openqa.selenium.TimeoutException exp) {
			report.fail("My Profile was not loaded within " + interval + " secs because of timeout exeption");
		}
	}
}
