package tests.stepsDefinitions;

import cucumber.api.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import tests.Fixture;

public class MainPageStepsDefinitions extends Fixture {

    @Then("^Recheck main page url$")
    public void recheckMainPageUrl() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(myWebSite.mainPage.isMainPage()).as("not main page");
        softly.assertAll();
    }
}
