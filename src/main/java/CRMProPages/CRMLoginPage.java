package CRMProPages;

import CRMProBase.CRMProPageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRMLoginPage extends CRMProPageBase {

    @FindBy(xpath="//a[@class='navbar-brand']/img[contains(@class, 'img-responsive')]")
    WebElement crmLogo;

    @FindBy (xpath = "//input[@name='username']")
    WebElement usernameInput;

    @FindBy (xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy (xpath = "//input[@type='submit']")
    WebElement loginBtn;

    public CRMLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting page title..")
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Step("Checking if CRM logo displayed...")
    public boolean validateCRMImage() {
        return crmLogo.isDisplayed();
    }

    @Step("Login to CRM account")
    public CRMHomePage login() {
        usernameInput.sendKeys(prop.getProperty("username"));
        passwordInput.sendKeys(prop.getProperty("password"));
        click(loginBtn);
        return new CRMHomePage(driver);
    }

}
