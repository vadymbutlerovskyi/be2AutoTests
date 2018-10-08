package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BasePage;

public class MyProfileTests extends BasePage  {

	@Parameters("age")
	@Test	
	public void validateAge (String age) 
	{
		loginLogout.clickOnAvatarImg();
		myProfile.waitForMyProfile();
		Assert.assertEquals(age, myProfile.getAge(), "The expected age did not match the current one");
	}

	@Parameters("education")
	@Test	
	public void validateEducation (String education) 
	{
		loginLogout.clickOnAvatarImg();
		myProfile.waitForMyProfile();
		Assert.assertEquals(education, myProfile.getEducation(), "The expected education did not match the current one");
	}
}
