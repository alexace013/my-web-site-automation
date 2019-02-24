package tests.stepsDefinitions.selenium;

import com.alexanderbakhin.selenium.pages.HomePage;
import com.alexanderbakhin.site.MyPageUrl;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import tests.fixtures.SeleniumFixture;

import java.util.ArrayList;
import java.util.List;

public class HomePageStepsDefinitions extends SeleniumFixture {

    @When("^user inputs \"([^\"]*)\" data in name field$")
    public void userInputsDataInNameField(final String data) {
        myWebSite.homePage.inputDataIntoNameField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in e-mail field$")
    public void userInputsDataInEmailField(final String data) {
        myWebSite.homePage.inputDataIntoEmailField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in country field$")
    public void userInputsDataInCountryField(final String data) {
        myWebSite.homePage.inputDataIntoCountryField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in city field$")
    public void userInputsDataInCityField(final String data) {
        myWebSite.homePage.inputDataIntoCityField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in phone field$")
    public void userInputsDataInPhoneField(final String data) {
        myWebSite.homePage.inputDataIntoPhoneField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in message textarea$")
    @And("^user inputs \"([^\"]*)\" data in message field$")
    public void userInputsDataInMessageField(final String data) {
        myWebSite.homePage.inputDataIntoMessageTextArea(data);
    }

    @When("^user clicks on SEND button$")
    public void userClicksOnSendButton() {
        myWebSite.homePage.clickOnSendButton();
    }

    @When("^user clicks on DOWNLOAD RESUME button$")
    public void userClicksOnDownloadResumeButton() {
        myWebSite.homePage.clickOnDownloadResumeButton();
    }

    @Then("^Recheck home page url$")
    public void recheckHomePageUrl() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(myWebSite.homePage.isHomePage()).as("not home page");
        softly.assertAll();
    }

    @Then("^form was sent successfully with alert \"([^\"]*)\" text$")
    public void formWasSentSuccessfullyWithText(final String text) {
        Assert.assertTrue(myWebSite.homePage.isMessageTextEquals(text));
    }

    @Then("^user checks urls from bottom links$")
    public void userChecksUrlsFromBottomLinks() {
        List<String> expectedUrls = new ArrayList<>();
        expectedUrls.add(MyPageUrl.FACEBOOK_LINK_URL.getPageUrl());
        expectedUrls.add(MyPageUrl.LINKEDIN_LINK_URL.getPageUrl());
        expectedUrls.add(MyPageUrl.INSTAGRAM_LINK_URL.getPageUrl());
        expectedUrls.add(MyPageUrl.YOUTUBE_LINK_URL.getPageUrl());
        expectedUrls.add(MyPageUrl.GOOGLE_PLUS_LINK_URL.getPageUrl());
        List<String> actualUrls = new ArrayList<>();
        actualUrls.add(myWebSite.homePage.getHrefFromBottomLink(HomePage.BottomLinks.FACEBOOK));
        actualUrls.add(myWebSite.homePage.getHrefFromBottomLink(HomePage.BottomLinks.LINKEDIN));
        actualUrls.add(myWebSite.homePage.getHrefFromBottomLink(HomePage.BottomLinks.INSTAGRAM));
        actualUrls.add(myWebSite.homePage.getHrefFromBottomLink(HomePage.BottomLinks.YOUTUBE));
        actualUrls.add(myWebSite.homePage.getHrefFromBottomLink(HomePage.BottomLinks.GOOGLE_PLUS));
        Assert.assertTrue(actualUrls.equals(expectedUrls));
    }
}
