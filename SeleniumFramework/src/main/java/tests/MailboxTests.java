package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BasePage;

public class MailboxTests extends BasePage {

	@Parameters("msgWelcome")
	@Test(groups= {"smoke"})
	public void checkWelcomeMsg (String msgWelcome) {
		Integer lengthWelc = msgWelcome.length();		
		BasePage.mailbox.goToMailbox();
		BasePage.mailbox.waitForMessaging();
		String message = BasePage.mailbox.getMsgFromLastReadableContact(lengthWelc);
		Assert.assertTrue(message.startsWith(msgWelcome), 
				"The first " + lengthWelc + " symbols of the welcome message did not match. Given: \"" + msgWelcome
				+ "\". Found: \"" + message.substring(0, lengthWelc) + "\"");
	}
}