package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import tests.fixtures.SeleniumFixture;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty",
                "json:target/report/cucumber-report.json",
                "html:target/cucumber-reports"},
        features = {"src/test/resources/features"},
        glue = {"tests/stepsDefinitions"},
        tags = {"@SelenideHomePage, @SelenideSupportPage, @Rest"}
)
public class MyWebSiteTestsSelenideRunner extends SeleniumFixture {
}