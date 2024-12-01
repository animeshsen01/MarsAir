package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import practice.Test_Automation.Base;


@CucumberOptions(
        features = "src/test/java/features", // Ensure this path is correct
        glue = "steps", // Ensure this path is correct
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@SearchTest"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setUp() {
        new Base().setupDriver();
    }

    @AfterClass
    public void tearDown() {
        if (Base.driver != null) {
            Base.driver.quit();
        }
    }
}