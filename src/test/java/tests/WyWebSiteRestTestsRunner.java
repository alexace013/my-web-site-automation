package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty",
                "json:target/report/cucumber-report.json"},
        features = {"src/test/resources/features"},
        glue = {"tests/stepsDefinitions"},
        tags = {"@Rest"}
)
public class WyWebSiteRestTestsRunner {
}