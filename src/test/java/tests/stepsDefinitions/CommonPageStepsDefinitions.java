package tests.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import tests.Fixture;
import utils.UrlController;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class CommonPageStepsDefinitions extends Fixture {

    @Given("^user opens (\\D+) page$")
    public void userNavigatesToPage(final String pageUrl) {
        myWebSite.actions.openPage(pageUrl);
        myWebSite.actions.waitForPageLoaded();
    }

    @Then("^user is navigated to (\\D+) page$")
    @And("^user is navigated to \"([^\"]*)\" page$")
    public void userNavigatedToPage(final String expectedPageUrl) {
        String actualPageUrl = myWebSite.actions.getCurrentUrl();
        log.info(String.format("navigated to: %s", actualPageUrl));
        Assert.assertEquals("Was opened incorrectly page", expectedPageUrl, actualPageUrl);
    }

    @And("^user is switched in new tab to (.*) url$")
    public void userNavigatedToPageUrl(final String expectedPageUrl) {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        log.info("URL: " + driver.getCurrentUrl());
        String actualPageUrl = driver.getCurrentUrl();
        Assert.assertEquals("Was opened incorrectly page", expectedPageUrl, UrlController.getUrlFromNewTab(driver, 2));
    }
}
