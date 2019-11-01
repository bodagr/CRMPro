package CRMProPages;

import CRMProBase.CRMProPageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class CRMContactPage extends CRMProPageBase {

    @FindBy(xpath="//td[contains(text(), 'Contacts')]")
    WebElement contactsLabell;

    @FindBy(id="first_name")
    WebElement firstName;

    @FindBy(id="surname")
    WebElement lastName;

    @FindBy(name="client_lookup")
    WebElement companyName;

    @FindBy(name="title")
    WebElement titleName;

    @FindBy(id="phone")
    WebElement phoneInput;

    @FindBy(id="mobile")
    WebElement mobileInput;

    @FindBy(id="home_phone")
    WebElement homePhoneInput;

    @FindBy(id="email")
    WebElement emailInput;

    @FindBy(xpath="//input[@value='Save']")
    WebElement saveBtn;

    @FindBy(xpath = "//form[@id='vContactsForm']")
    WebElement contactForm;

    @FindBy(xpath = "//div[@class='pagination']//a")
    List<WebElement> nextPageBtn;


    public CRMContactPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyContactsLabel() {
        return contactsLabell.isDisplayed();
    }

    public void selectContactsByName(String name) {
        driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
                + "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    }

    @Step("Adding user...")
    public void createNewContact(String title, String ftName, String ltName, String comp, String ph, String hp, String mp, String em) {
        waitForVisibility(titleName);
        Select select = new Select(titleName);
        select.selectByVisibleText(title);

        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        companyName.sendKeys(comp);
        phoneInput.sendKeys(ph);
        homePhoneInput.sendKeys(hp);
        mobileInput.sendKeys(mp);
        emailInput.sendKeys(em);
        click(saveBtn);
    }

    @Step("Checking if contact is created...")
    public boolean checkIfNewContactWasCreated(String title, String ftName, String ltName, String comp, String ph, String hp, String mp, String em) {
        String nameRow = "//a[text()='"+ ftName.trim()+ " "+ltName.trim() +"']//parent::td[@class='datalistrow']";
        String [] checkList = {title,comp,ph,hp,mp,em};
        moveToElement(contactForm);

        if (!isElementPresent(By.xpath(nameRow)) && nextPageBtn.size() > 0) {
            for (int i = 1; i <= nextPageBtn.size() / 2; i++) {
                String next = "//div[@class='pagination']//a["+ i +"]";
                click(driver.findElement(By.xpath(next)));
                sleep(1);
                if (isElementPresent(By.xpath(nameRow)))
                    break;
            }
        }

        for (int i = 1; i < checkList.length; i++) {
            String locator = nameRow + "/following-sibling::td["+ i +"]";
            String x = driver.findElement(By.xpath(locator)).getText();
            System.out.println(x + " with " + checkList[i]);
            if (!x.trim().equalsIgnoreCase(checkList[i].trim()))
                return false;
        }
        return true;
    }
}
