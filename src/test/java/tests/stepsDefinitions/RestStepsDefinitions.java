package tests.stepsDefinitions;

import com.jayway.restassured.RestAssured;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;

@Log4j
public class RestStepsDefinitions {

    @When("^send request to (\\D+) url$")
    public void sendRequestToUrl(final String url) {
        log.info(String.format("navigated to %s url", url));
        RestAssured.when().get(url);
    }

    @Then("^status code is (\\d+)$")
    public void statusCodeIs(final int statusCode) {
        log.info(String.format("status code = %d", statusCode));
        RestAssured.given().then().statusCode(statusCode);
    }

}
