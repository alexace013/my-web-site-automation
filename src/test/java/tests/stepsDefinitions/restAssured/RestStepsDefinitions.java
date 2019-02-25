package tests.stepsDefinitions.restAssured;

import com.jayway.restassured.RestAssured;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;

@Log4j
public class RestStepsDefinitions {

    private static final String NAVIGATE_INFO_MSG = "navigated to %s url";

    @When("^send request to (\\D+) url$")
    @And("^send request to ([^\"]*) url for my web site$")
    public void sendRequestToUrlForMyWebSite(final String url) {
        log.info(String.format(NAVIGATE_INFO_MSG, url));
        RestAssured.when().get(url);
    }

    @And("^send request to ([^\"]*) url$")
    public void sendRequestToUrl(final String url) {
        log.info(String.format(NAVIGATE_INFO_MSG, url));
        RestAssured.when().get(url);
    }

    @Then("^status code is (\\d+)$")
    public void statusCodeIs(final int statusCode) {
        log.info(String.format("status code = %d", statusCode));
        RestAssured.given().then().statusCode(statusCode);
    }

}
