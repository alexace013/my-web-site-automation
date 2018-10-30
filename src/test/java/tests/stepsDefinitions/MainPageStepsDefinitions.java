package tests.stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import tests.Fixture;

public class MainPageStepsDefinitions extends Fixture {

    @When("^user inputs \"([^\"]*)\" data in name field$")
    public void userInputsDataInNameField(final String data) {
        myWebSite.mainPage.inputDataIntoNameField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in e-mail field$")
    public void userInputsDataInEmailField(final String data) {
        myWebSite.mainPage.inputDataIntoEmailField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in country field$")
    public void userInputsDataInCountryField(final String data) {
        myWebSite.mainPage.inputDataIntoCountryField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in city field$")
    public void userInputsDataInCityField(final String data) {
        myWebSite.mainPage.inputDataIntoCityField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in phone field$")
    public void userInputsDataInPhoneField(final String data) {
        myWebSite.mainPage.inputDataIntoPhoneField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in message textarea$")
    @And("^user inputs \"([^\"]*)\" data in message field$")
    public void userInputsDataInMessageField(final String data) {
        myWebSite.mainPage.inputDataIntoMessageTextarea(data);
    }

    @When("^user clicks on SEND button$")
    public void userClicksOnSendButton() {
        myWebSite.mainPage.clickOnSendButton();
    }

    @When("^user clicks on DOWNLOAD RESUME button$")
    public void userClicksOnDownloadResumeButton() {
        myWebSite.mainPage.clickOnDownloadResumeButton();
    }

    @Then("^Recheck main page url$")
    public void recheckMainPageUrl() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(myWebSite.mainPage.isMainPage()).as("not main page");
        softly.assertAll();
    }

    @Then("^form was sent successfully with alert \"([^\"]*)\" text$")
    public void formWasSentSuccessfullyWithText(final String text) {
        Assert.assertTrue(myWebSite.mainPage.isMessageTextEquals(text));
    }
}
