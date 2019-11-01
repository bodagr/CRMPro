package CRMProBaseT;

import CRMProBase.CRMProPageBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CRMProBaseTest {

    private WebDriver driver;
    public Logger logger;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setup() {
        logger = Logger.getLogger("CRMPro");
        PropertyConfigurator.configure(".\\src\\main\\resources\\log4j.properties");
        logger.setLevel(Level.DEBUG);
        logger.info("=============> Started TC <=============");
    }

    @BeforeMethod
    public void initialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.crmpro.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public void lodend() {
        logger.info("********** Test case FINISHED **********");
    }


}
