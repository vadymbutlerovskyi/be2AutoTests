package pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import tests.BaseTest;

public class LoginPage extends BaseTest {

	public LoginPage(WebDriver driver, ExtentTest test){
		super(driver, test);
		PageFactory.initElements(driver,  this);
	}
	
	//*******Page Objects*******	
	@FindBy(how = How.XPATH, using = "//div[@id='login-access-btn']")
	private WebElement loginExpander;

	@FindBy(how = How.XPATH, using = "//input[@id='be2_login_username']")
	private WebElement emailField;

	@FindBy(how = How.XPATH, using = "//input[@id='be2_login_password']")
	private WebElement passField;
	
	@FindBy(how = How.XPATH, using = "//button[@id='be2_loginButton']")
	private WebElement submitBtn;

	@FindBy(how = How.XPATH, using = "//li[@class='nav-myprofile']/a")
	private WebElement avatarImg;

	//*******Actions*******	
	public void expandLoginBar() {
		loginExpander.click();
		report.pass("Login bar expanded");
	}
	
	public void clickOnSubmit() {
		submitBtn.click();
		report.pass("Submitted credentials by the Login button");
	}

	public void enterIntoEmail(String email) {
		emailField.sendKeys(email);
		report.pass(email + " was entered into email field");
	}

	public void enterIntoPassword(String pass) {
		passField.sendKeys(pass);
		report.pass(pass + " was entered into password field");
	}

	public void clickOnAvatarImg() {
		avatarImg.click();
		report.pass("Clicked on the Avatar");
	}

	//*******Waiters*******
	Integer interval = 10;
	Wait<WebDriver> wait = new FluentWait<WebDriver>(_driver).withTimeout(Duration.ofSeconds(interval))
			.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
	
	public void waitForAvatar() {
		try {
			WebDriverWait wait = new WebDriverWait(_driver, interval);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(avatarImg));
			report.info("Avatar is loaded");
		}
		catch (org.openqa.selenium.TimeoutException exp) {
			report.fail("Avatar was not loaded within " + interval + " secs because of timeout exeption");
		}
	}
}
