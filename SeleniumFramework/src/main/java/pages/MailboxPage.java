package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import tests.BaseTest;

public class MailboxPage extends BaseTest {

	public MailboxPage(WebDriver driver, ExtentTest test){
		super(driver, test);
		PageFactory.initElements(driver,  this);
	}

	//*******Page Objects*******	
	@FindBy(how = How.XPATH, using = "//li[@class='nav-messaging']/a")
	private WebElement mailbox;

	@FindBy(how = How.XPATH, using = "//div[@class='contact'][last()]//div[@class='last-message']")
	private WebElement readableContactLast;
	
	@FindBy(how = How.ID, using = "messaging")
	private WebElement messaging;

	//*******Actions*******	
	public void goToMailbox() {
		mailbox.click();
		report.pass("Clicked on the Mailbox");
	}

	//*******Gets*******
	public String getMsgFromLastReadableContact(Integer length) {
		String msgLastReadCont = readableContactLast.getText();
		report.info(msgLastReadCont.substring(0, length) + "... message was found in the last readable contact");
		return msgLastReadCont;	
	}
	
	//*******Waiters*******
	public void waitForMessaging() {
		Integer interval = 5;
		try {
			WebDriverWait wait = new WebDriverWait(_driver, interval);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(messaging));
			report.info("Messaging is loaded");
		}
		catch (org.openqa.selenium.TimeoutException exp) {
			report.fail("Messaging was not loaded within " + interval + " secs because of timeout exeption");
		}
	}
}
