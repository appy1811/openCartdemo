package testCases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationpage;
import pageObjects.homepage;
 

 


public class TC_001_AccountRegistrationTest extends testCases.baseclass {

    @Test
    public void test_account_registration() throws InterruptedException {

        logger.debug("application logs.....");
        logger.info("*** Starting TC_001_AccountRegistrationTest ***");

      try{

          homepage hp = new homepage(driver);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        hp.clickMyAccount();
        logger.info("clicked on my account");
        hp.clickRegister();
          logger.info("clicked on register link");

        AccountRegistrationpage regpage = new AccountRegistrationpage(driver);
          logger.info("Providing customer data");

        regpage.setFirstName(randomString().toUpperCase());

        regpage.setLastName(randomString().toUpperCase());

        regpage.setEMail(randomString() + "@gmail.com"); //randomly generated email

        String password = randomAlphaNumeric();
        regpage.setPassword(password);


        regpage.setPrivacyPolicy();

        regpage.clickcontinue();
          logger.info("clicked on continue");

        String confmsg = regpage.getConfirmationMsg();
        logger.info("validating expected message");
        Assert.assertEquals(confmsg, "Your Account Has Been Created",logger.error("not getting expected msg"));

    }
        catch (Exception e) {
          logger.error("test failed");
            Assert.fail();
        }


    }


}
