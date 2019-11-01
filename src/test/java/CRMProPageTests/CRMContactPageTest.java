package CRMProPageTests;

import CRMProBaseT.CRMProBaseTest;
import CRMProPages.CRMContactPage;
import CRMProPages.CRMHomePage;
import CRMProPages.CRMLoginPage;
import Utils.XLUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CRMContactPageTest extends CRMProBaseTest {

    CRMLoginPage loginPage;
    CRMHomePage homePage;
    CRMContactPage contactPage;
    XLUtils xlUtils;


    @BeforeMethod
    void setUp() {
        loginPage = new CRMLoginPage(getDriver());
        homePage = new CRMHomePage(getDriver());
        contactPage = new CRMContactPage(getDriver());
        loginPage.login();
        getDriver().switchTo().frame("mainpanel");
    }

    @Test(priority = 1, description = "Create new contact [fail test cases]")
    public void createNewContact2() {
        homePage.clickOnNewContactLink()
                .createNewContact("Dr.", "Year", "Feld", "Arr", "120", "000", "777", "ew@ex.com");
        Assert.assertTrue(homePage.clickContactLink().checkIfNewContactWasCreated("Dr.", "Day", "Feld", "Arr", "120", "000", "777", "ew@ex.com"));
    }

    @Test (priority = 2, dataProvider = "contactList", description = "Add user: {1} {2}")
    public void createNewContact(String title, String ftName, String ltName, String comp, String ph, String hp, String mp, String em) {
        homePage.clickOnNewContactLink()
            .createNewContact(title, ftName, ltName, comp, ph, hp, mp, em);
        Assert.assertTrue(homePage.clickContactLink().checkIfNewContactWasCreated(title, ftName, ltName, comp, ph, hp, mp, em));
    }

    @DataProvider(name = "contactList")
    Object [][] getContactsData() throws IOException {
        String path = "C:\\Users\\Admin\\IdeaProjects\\CRMPro\\src\\main\\resources\\contactsListN.xlsx";
        int rownum = xlUtils.getRowCount(path, "Sheet1");
        int colnum = xlUtils.getCellCount(path, "Sheet1", 1);

        String [][] contactData = new String[rownum][colnum];
        for (int i = 1; i < rownum; i++) {
            for (int k = 0; k < colnum; k++) {
                contactData [i-1][k] = xlUtils.getCellData(path, "Sheet1", i, k);
            }
        }
        return contactData;
    }


}
