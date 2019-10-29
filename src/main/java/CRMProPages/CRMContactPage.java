package CRMProPages;

import CRMProBase.CRMProPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CRMContactPage extends CRMProPageBase {

    private WebDriver driver;

    @FindBy(xpath="//td[contains(text(), 'Contacts')]")
    WebElement contactsLabell;

    @FindBy(id="first_name")
    WebElement firstName;

    @FindBy(id="surname")
    WebElement lastName;

    @FindBy(name="client_lookup")
    WebElement companyName;

    @FindBy(xpath="//input[@value='Save']")
    WebElement saveBtn;

    public CRMContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyContactsLabel() {
        return contactsLabell.isDisplayed();
    }

    public void selectContactsByName(String name) {
        driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
                + "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    }

    public void createNewContact(String title, String ftName, String ltName, String comp) {
        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(title);

        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        companyName.sendKeys(comp);
        saveBtn.click();
    }
}
