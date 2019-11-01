package CRMProPages;

import CRMProBase.CRMProPageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMHomePage extends CRMProPageBase {

    @FindBy(xpath = "//td[contains(text(), 'User: Bohdan Hr')]")
    WebElement userNameLabell;

    @FindBy(xpath = "//a[@title='Contacts']")
    WebElement contactLink;

    @FindBy(xpath = "//a[@title='Deals']")
    WebElement dealsLink;

    @FindBy(xpath = "//a[@title='Tasks']")
    WebElement taskLink;

    @FindBy(xpath="//a[@title='New Contact']")
    WebElement newContactLink;

    public CRMHomePage(WebDriver driver) {
        super(driver);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    @Step("Verifying user name...")
    public boolean verifyCorrectUserName() {
        return userNameLabell.isDisplayed();
    }

    @Step("Clicked on Contact")
    public CRMContactPage clickContactLink() {
        contactLink.click();
        return new CRMContactPage(driver);
    }

    public CRMDealsPage clickDealsLink() {
        dealsLink.click();
        return new CRMDealsPage(driver);
    }

    public CRMTastPage clickTaskLink() {
        taskLink.click();
        return new CRMTastPage(driver);
    }

    @Step("Clicked on new Contact")
    public CRMContactPage clickOnNewContactLink() {
        Actions action = new Actions(driver);
        action.moveToElement(contactLink).build().perform();
        newContactLink.click();
        return new CRMContactPage(driver);
    }
}
