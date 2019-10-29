package CRMProPages;

import CRMProBase.CRMProPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CRMTastPage extends CRMProPageBase {
    private WebDriver driver;

    public CRMTastPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
