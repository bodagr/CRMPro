package CRMProPages;

import CRMProBase.CRMProPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CRMDealsPage extends CRMProPageBase {

    private WebDriver driver;

    public CRMDealsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
