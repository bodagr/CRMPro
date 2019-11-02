package CRMProPageTests;

import CRMProBaseT.CRMProBaseTest;
import CRMProPages.CRMContactPage;
import CRMProPages.CRMHomePage;
import CRMProPages.CRMLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class CRMHomePageTest extends CRMProBaseTest {

    CRMHomePage homePage;
    CRMLoginPage loginPage;
    CRMContactPage contactsPage;

    @BeforeMethod
    void setUp() {
        loginPage = new CRMLoginPage(getDriver());
        homePage = new CRMHomePage(getDriver());
        contactsPage = new CRMContactPage(getDriver());
        loginPage.login();
        getDriver().switchTo().frame("mainpanel");
    }

    @Test (priority = 1, description = "Verify user name")
    public void verifyUserNameTest() {
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test(priority = 2, description = "Check contact link")
    public void verifyContactsLinkTest() {
        contactsPage = homePage.clickContactLink();
        System.out.println("Contact is clicked. Xpath works fine!");
    }
}
