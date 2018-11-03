package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;

public class PaymentTests extends BasePage {

	@Test(groups= {"smoke", "regression"})
	public void verifyPayPalAvailability () {
		payment.gotoPayment();
		payment.waitForPaymentPackages();
		payment.selectPackage(2);
		payment.waitForPayPalTab();
		payment.openPayPalTab();
		payment.waitForPayPalButton();
		Assert.assertTrue(payment.isPayPalButton(), "PayPal button was not located");
	}
}