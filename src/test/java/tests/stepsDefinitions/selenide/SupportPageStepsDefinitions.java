package tests.stepsDefinitions.selenide;

import com.codeborne.selenide.Condition;
import controller.PropertyController;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import tests.fixtures.SelenideFixture;

import static com.codeborne.selenide.Selenide.$x;

public class SupportPageStepsDefinitions extends SelenideFixture {

    private static final String EXPECTED_TEST_TEXT = PropertyController.loadProperty("support.page.test.text");

    @When("^user clicks on TEST button on Selenide$")
    public void userClicksOnTestButtonOnSelenide() {
        $x(supportPage.TEST_BUTTON_XPATH).shouldBe(Condition.visible).click();
    }

    @Then("^user checks test text on support page on Selenide$")
    public void userChecksTestTextOnSupportPageOnSelenide() {
        Assertions.assertThat($x(supportPage.TEST_TEXT_XPATH).shouldBe(Condition.visible).getText())
                .as("test text is incorrect").isEqualTo(EXPECTED_TEST_TEXT);
    }
}