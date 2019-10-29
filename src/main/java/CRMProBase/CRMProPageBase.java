package CRMProBase;


import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CRMProPageBase {

    private static WebDriver driver;
    protected static Properties prop;

    public CRMProPageBase() {
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
    }





}
