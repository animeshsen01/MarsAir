package practice.Test_Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static WebDriver driver;

    public static void getScreenshot(String tcName) throws IOException {
        if (driver != null) {
            File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scr, new File("/Users/animeshsen/eclipse-workspace/MarsAir/Screenshot/" + tcName + ".png"));
        }
    }

    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    }

    public String getProperty(String key) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/animeshsen/eclipse-workspace/MarsAir/src/test/java/practice/Test_Automation/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String value = prop.getProperty(key);
        return value;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void selectDropdown(WebElement webElement, String value) {
        Select dropdown = new Select(webElement);
        dropdown.selectByVisibleText(value);
    }
}