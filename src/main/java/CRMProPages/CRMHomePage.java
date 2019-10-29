package CRMProPages;

import CRMProBase.CRMProPageBase;
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

    final WebDriver driver;

    public CRMHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName() {
        return userNameLabell.isDisplayed();
    }

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

    public void clickOnNewContactLink() {
        Actions action = new Actions(driver);
        action.moveToElement(contactLink).build().perform();
        newContactLink.click();
    }
}
