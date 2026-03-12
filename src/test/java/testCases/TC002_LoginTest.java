package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC002_LoginTest extends BaseTest {
	
	@Test(groups= {"Regression","Master"})
	public void verifyLoginTest() {
		logger.info("*** starting TC002_LoginTest*** ");
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickAccount();
		logger.info("Clicked on Account");
		
		hp.clickLogin();
		logger.info("clicked on Login");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickBtnLogin();
		
		MyAccountPage ap=new MyAccountPage(driver);
		boolean targetPage=ap.isMyAccountPageExists();
		Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"login failed");
		}
		catch(Exception e){
			Assert.fail();
		}
		logger.info("*** finished TC002_LoginTest*** ");
	}

}
