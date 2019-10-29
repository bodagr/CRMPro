package CRMProPageTests;

import CRMProBaseT.CRMProBaseTest;
import CRMProPages.CRMLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRMLoginPageTest extends CRMProBaseTest {

    CRMLoginPage loginPage;

    @BeforeClass
    void start() {
        logger.info("=============> Started TC <=============");
    }

    @Test
    public void verifyLoginPageTitle() {
        loginPage = new CRMLoginPage(driver);
        String expectedTitle = "CRMPRO - CRM software for customer relationship management, sales, and support.";
        logger.info("*****_Checking status code_*****");
        Assert.assertEquals(loginPage.getPageTitle(), expectedTitle);
    }

    @Test
    public void crmLogoImageTest() {
        loginPage = new CRMLoginPage(driver);
        Assert.assertTrue(loginPage.validateCRMImage());
    }

    @Test
    public void login() {
        loginPage = new CRMLoginPage(driver);
        loginPage.login();
    }
}
