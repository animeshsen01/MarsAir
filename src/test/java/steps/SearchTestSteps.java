package steps;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import pageObjects.SearchPage;
import practice.Test_Automation.Base;

import java.io.File;
import java.io.IOException;

public class SearchTestSteps extends Base {

    SearchPage searchPage = new SearchPage(driver);

    @Given("I go to {string} homepage")
    public void i_go_to_homepage(String url) throws IOException {
        goToUrl(getProperty(url));
    }

    @When("I select dropdown {string} with value {string}")
    public void i_select_dropdown_with_value(String dropdown, String value) {
        if(dropdown.equalsIgnoreCase("departure")) {
            WebElement departing = searchPage.departing;
            selectDropdown(departing, value);
        } else if(dropdown.equalsIgnoreCase("return")) {
            WebElement returning = searchPage.returning;
            selectDropdown(returning, value);

        }
    }

    @When("I click on Search")
    public void i_click_on_search() {
        searchPage.searchButton.click();
    }

    @Then("I see seat availability")
    public void i_see_seat_availability() throws InterruptedException {
        String seatAvailable = "Seats available!";
        String seatNotAvailable = "Sorry, there are no more seats available.";
        String scheduleNotPossible = "Unfortunately, this schedule is not possible. Please try again.";
        String searchResult = searchPage.seatAvailability.getText();
        System.out.println(searchResult);
        if (searchResult.equals(seatAvailable)) {
            Assert.assertTrue(true);
        } else if (searchResult.equals(seatNotAvailable)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("I see {string}")
    public void i_see(String message) {
        if(message.contains("seat availability")) {
            String seatAvailable = "Seats available!";
            String seatNotAvailable = "Sorry, there are no more seats available.";
            String searchResult = searchPage.seatAvailability.getText();
            System.out.println(searchResult);
            if (searchResult.equals(seatAvailable)) {
                Assert.assertTrue(true);
            } else if (searchResult.equals(seatNotAvailable)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        } else if(message.contains("schedule not possible")) {
            String scheduleNotPossible = "Unfortunately, this schedule is not possible. Please try again.";
            String searchResult = searchPage.seatAvailability.getText();
            System.out.println(searchResult);
            Assert.assertEquals(searchResult, scheduleNotPossible);
        }
    }

//    @AfterStep
//    public void addScreenshot(Scenario scenario) {
//
//        //validate if scenario has failed
//        if (scenario.isFailed()) {
//            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", "image");
//        }
//    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotPath = "Screenshots/" + scenario.getName() + ".png";
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                scenario.attach(FileUtils.readFileToByteArray(new File(screenshotPath)), "image/png", "Screenshot");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}