package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import tests.BaseTest;

public class PaymentPage extends BaseTest {

	public PaymentPage(WebDriver driver, ExtentTest test){
		super(driver, test);
		PageFactory.initElements(driver,  this);
	}

	//*******Page Objects*******	
	@FindBy(how = How.XPATH, using = "//li[@class='nav-fees']/a")
	private WebElement paymentSection;

	@FindBy(how = How.XPATH, using = "//div[@class='packages']/div/div")
	private List<WebElement> packages;

	By payPalTabBy = By.xpath("//label[@for='pay-paypal']");
	private WebElement payPalTab;
	
	@FindBy(how = How.XPATH, using = "//button[@class='button-primary purchase button-paypal']")
	private WebElement payPalBtn;

	//*******Actions*******	
	public void gotoPayment() {
		paymentSection.click();
		report.pass("Payment section was triggered to open");
	}
	
	public void selectPackage(Integer nmb) {
		packages.get(nmb-1).click();
		report.pass("Package number " + nmb + " was sected");
	}
	
	public void openPayPalTab() {
		payPalTab = _driver.findElement(payPalTabBy);
		payPalTab.click();
		report.pass("PayPal tab was open");
	}
	
	//*******Booleans*******
	public Boolean isPayPalButton() {
		Boolean result;
		try {
			result = payPalBtn.isDisplayed();
			report.pass("PayPal button was displayed");
		}
		catch (NoSuchElementException exp) {
			report.fail("PayPal button was not found displayed");
			result = false;
		}
		return result;
	}

	//*******Waiters*******
	Integer interval = 5;
	WebDriverWait wait = new WebDriverWait(_driver, interval);
	public void waitForPaymentPackages() {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("packages")));
			report.info("Payment packages are loaded");
		}
		catch (org.openqa.selenium.TimeoutException exp) {
			report.fail("Payment packages were not loaded within " + interval + " secs because of timeout exeption");
		}
	}
	
	public void waitForPayPalTab() {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(payPalTabBy));
			report.info("PayPal option is displayed");
		}
		catch (org.openqa.selenium.TimeoutException exp) {
			report.fail("PayPal option was not displayed within " + interval + " secs because of timeout exeption");
		}
	}
	
	public void waitForPayPalButton() {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(payPalBtn));
			report.info("PayPal button is displayed");
		}
		catch (org.openqa.selenium.TimeoutException exp) {
			report.fail("PayPal button was not displayed within " + interval + " secs because of timeout exeption");
		}
	}
}
