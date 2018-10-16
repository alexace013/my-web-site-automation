package tests.stepsDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import tests.Fixture;

public class MainPageStepsDefinitions extends Fixture {

    @When("^user clicks on DOWNLOAD RESUME button$")
    public void userClicksOnDownloadResumeButton() {
        myWebSite.mainPage.clickOnDownloadResumeButton();
    }

    @Then("^Recheck main page url$")
    public void recheckMainPageUrl() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(myWebSite.mainPage.isMainPage()).as("not main page");
        softly.assertAll();
    }
}
