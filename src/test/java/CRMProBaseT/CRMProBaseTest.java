package CRMProBaseT;

import CRMProBase.CRMProPageBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class CRMProBaseTest extends CRMProPageBase {

    protected static CRMProPageBase base;
    protected static WebDriver driver;
    public Logger logger;

    @BeforeClass
    public void setup() {
        logger = Logger.getLogger("CRMPro");
        PropertyConfigurator.configure(".\\src\\main\\resources\\log4j.properties");
        logger.setLevel(Level.DEBUG);
    }

    @BeforeTest
    public static void initialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(prop.getProperty("CRMurl"));
    }

    @AfterTest
    public static void tearDown() {
        driver.close();
    }

}
