package pages;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import tests.BaseTest;

public class BasePage {
	
	ITestContext testContext = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	public static ExtentTest reportLogInOut;
	public static ExtentTest reportMailbox;
	public static ExtentTest reportMyProfile;
	public static ExtentTest reportPayment;

	public static BaseTest baseTest;
	public static LoginPage loginLogout;
	public static MailboxPage mailbox;
	public static MyProfilePage myProfile;
	public static PaymentPage payment;

	@BeforeSuite
	public void extentReportSetup() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		reportLogInOut = extent.createTest("Log in and out", "These are login and logout tests");
		reportMailbox = extent.createTest("Mailbox", "These are tests for mailbox functionality");
		reportMyProfile = extent.createTest("My Profile", "These are tests for My Profile page");
		reportPayment = extent.createTest("Payment", "These are tests for Payment page");
		
		baseTest = new BaseTest();
		loginLogout = new LoginPage(baseTest._driver, baseTest.report);
		mailbox = new MailboxPage(baseTest._driver, baseTest.report);
		myProfile = new MyProfilePage(baseTest._driver, baseTest.report);
		payment = new PaymentPage(baseTest._driver, baseTest.report);
	}
	
	@BeforeTest
	public void testSetup(final ITestContext testContext){

		String currentTestName = testContext.getName();
		switch (currentTestName) {
			case "LoginTests":
				baseTest.report = reportLogInOut;			
				break;
			case "MailboxTests":
				baseTest.report = reportMailbox;
				break;
			case "MyProfileTests":
				baseTest.report = reportMyProfile;				
				break;
			case "PaymentTests":
				baseTest.report = reportPayment;		
				break;
			default:
				System.out.println("HINT: Double check test names correspond to cases at @BeforeTest");
		}		
	}

	@AfterSuite
	public void afterSuite() {
		extent.flush();
	}
	
	@AfterSuite
	public void cleanUp() {
		baseTest.tearDown();
	}
}
