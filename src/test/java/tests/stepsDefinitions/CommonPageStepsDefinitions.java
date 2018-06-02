package tests.stepsDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.Fixture;

public class CommonPageStepsDefinitions extends Fixture {

    @When("^user navigates to (\\D+) page$")
    public void userNavigatesToPage(final String pageUrl) {
        myWebSite.webElementsActions.openPage(pageUrl);
    }

    @Then("^user is navigated to (\\D+) page$")
    public void userNavigatedToPage(final String pageUrl) {
        // TODO 2
    }

    @Then("^page status code is (\\d+)$")
    public void statusCodeIs(final String statusCode) {
        // TODO 3
    }
}
