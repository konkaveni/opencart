package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseTest;

public class TC001_AccountRegistrationTest extends BaseTest {
	
		
	@Test(groups= {"sanity","Master"})
	public void test_Account_Registration() {
		logger.info("*****Starting TC001_AccountRegistrationTest******");
		try {
		HomePage hp= new HomePage(driver);
		
		hp.clickAccount();
		logger.info("Clicked on My Account....");
		
		hp.clickregister();
		logger.info("Clicked on Register...");
		
		RegistrationPage regPage= new RegistrationPage(driver);
		logger.info("Providing the customer details....");
		 regPage.setFirstName(randomString());
		 regPage.setLastName(randomString());
		 regPage.setEmail(randomString()+"@gmail.com");
		 regPage.setTelephone(randomNumber());
		 
		 String password=  randomAlphaNumeric();
		 regPage.setPassword(password);
		 regPage.setConfirmPassword(password);
		 regPage.clickPolicy();
		 regPage.clickContinue();
		 
		logger.info("validating the Expected Message....");		 
		 String confirmation=regPage.checkconfirmation();
		 Assert.assertEquals(confirmation, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			
			logger.info("Test failed....");
			logger.debug("debug logs...");
			Assert.fail();
		}
		
		logger.info("*****finished TC001_AccountRegistrationTest******");
	}
	
	

}
