package tests.stepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import tests.Fixture;

@Log4j
public class CommonPageStepsDefinitions extends Fixture {

    @Given("^user opens (\\D+) page$")
    public void userNavigatesToPage(final String pageUrl) {
        myWebSite.actions.openPage(pageUrl);
//        myWebSite.actions.navigateToPage("http://alexanderbakhin.com/");
        myWebSite.actions.waitForPageLoaded();
    }

    @Then("^user is navigated to (\\D+) page$")
    public void userNavigatedToPage(final String expectedPageUrl) {
        String actualPageUrl = myWebSite.actions.getCurrentUrl();
        log.info(String.format("navigated to: %s", actualPageUrl));
        Assert.assertEquals("Was opened incorrectly page", expectedPageUrl, actualPageUrl);
    }
}
