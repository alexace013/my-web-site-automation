package tests.stepsDefinitions.selenium;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import tests.fixtures.SeleniumFixture;

public class SupportPageStepsDefinitions extends SeleniumFixture {

    @Then("^Recheck support page url$")
    public void recheckSupportPageUrl() {
        Assert.assertTrue("not support page", myWebSite.supportPage.isSupportPage());
    }
}