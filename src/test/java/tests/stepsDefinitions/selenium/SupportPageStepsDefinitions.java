package tests.stepsDefinitions.selenium;

import controller.PropertyController;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import tests.fixtures.SeleniumFixture;

public class SupportPageStepsDefinitions extends SeleniumFixture {

    private static final String EXPECTED_TEST_TEXT = PropertyController.loadProperty("support.page.test.text");

    @Then("^recheck support page url$")
    public void recheckSupportPageUrl() {
        Assert.assertTrue("not support page", myWebSite.supportPage.isSupportPage());
    }

    @When("^user clicks on TEST button$")
    public void userClicksOnTestButton() {
        myWebSite.supportPage.clickOnTestButton();
    }

    @Then("^user checks test text on support page$")
    public void userChecksTestTextOnSupportPage() {
        Assertions.assertThat(myWebSite.supportPage.getTestText())
                .isEqualTo(EXPECTED_TEST_TEXT)
                .as("test text is incorrect");
    }
}