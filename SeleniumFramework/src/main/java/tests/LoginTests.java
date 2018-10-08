package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BasePage;

public class LoginTests extends BasePage {
		
	@Parameters({"login", "home", "email", "password"})
	@Test	
	public void logIn (String login, String home, String email, String password) {
		baseTest.goToUrl(login);
		baseTest.waitForPageLoaded(5);
		loginLogout.expandLoginBar();
		loginLogout.enterIntoEmail(email);
		loginLogout.enterIntoPassword(password);	
		loginLogout.clickOnSubmit();
		baseTest.waitForPageLoaded(5);
		loginLogout.waitForAvatar();
		baseTest.amIOnUrl(home);
	}
}
