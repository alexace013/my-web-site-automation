package tests.stepsDefinitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import tests.Fixture;

public class SupportPageStepsDefinitions extends Fixture {

    @Then("^Recheck support page url$")
    public void recheckSupportPageUrl() {
        Assert.assertTrue("not support page", myWebSite.supportPage.isSupportPage());
    }
}