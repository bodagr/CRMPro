package CRMProBase;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

public class CRMProPageBase {

    protected WebDriver driver;
    protected Properties prop;
    private WebDriverWait wait;

    public CRMProPageBase(WebDriver driver) {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    ".\\src\\main\\resources\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    protected void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Clicking on --> {0}")
    protected void click(WebElement el) {
        wait.until(ExpectedConditions.elementToBeClickable(el));
        Actions actions = new Actions(driver);
        actions.moveToElement(el).pause(500).build().perform();
        el.click();
    }

    protected void waitForVisibility(WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    protected void moveToElement(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        sleep(1);
    }

    protected void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0,"+pixels+")");
    }

    protected boolean isElementPresent(By el) {
        return driver.findElements(el).size() > 0;
    }


}
