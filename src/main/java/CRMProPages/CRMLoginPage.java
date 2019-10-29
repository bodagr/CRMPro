package CRMProPages;

import CRMProBase.CRMProPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMLoginPage extends CRMProPageBase {

    @FindBy(xpath="//a[@class='navbar-brand']/img[contains(@class, 'img-responsive')]")
    WebElement crmLogo;

    @FindBy (xpath = "//input[@name='username']")
    WebElement usernameInput;

    @FindBy (xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy (xpath = "//input[@type='submit']")
    WebElement loginBtn;

    private WebDriver driver;

    public CRMLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean validateCRMImage() {
        return crmLogo.isDisplayed();
    }

    public CRMHomePage login() {
        usernameInput.sendKeys(prop.getProperty("username"));
        passwordInput.sendKeys(prop.getProperty("password"));
        loginBtn.click();
        return new CRMHomePage(driver);
    }

}
