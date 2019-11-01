package CRMProPageTests;

import CRMProBaseT.CRMProBaseTest;
import CRMProPages.CRMLoginPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMLoginPageTest extends CRMProBaseTest {

    CRMLoginPage loginPage;

    @BeforeMethod
    void setUp() {
        loginPage = new CRMLoginPage(getDriver());
    }

    @Test (priority = 1, description = "Verify Login page title")
    @Description("Title")
    public void verifyLoginPageTitle() {
        String expectedTitle = "CRMPRO - CRM software for customer relationship management, sales, and support.";
        logger.info("--->> Verified Login Page Title");
        Assert.assertEquals(loginPage.getPageTitle(), expectedTitle);
    }

    @Test (priority = 2, description = "Check CRM logo")
    @Description("CRM Logo")
    public void crmLogoImageTest() {
        logger.info("--->> Verified CRM logo img");
        Assert.assertTrue(loginPage.validateCRMImage());
    }

    @Test (priority = 3, description = "Login to CRM account")
    @Description("Login to the account")
    public void login() {
        logger.info("--->> Verified login");
        loginPage.login();
    }
}
