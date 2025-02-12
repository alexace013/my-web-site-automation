package tests.stepsDefinitions.selenium;

import com.alexanderbakhin.selenium.pages.HomePage;
import com.alexanderbakhin.site.MyPageUrl;
import controller.PropertyController;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import tests.fixtures.SeleniumFixture;
import utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class HomePageStepsDefinitions extends SeleniumFixture {

    private static final String COPYRIGHT_SYMBOL = PropertyController.loadProperty("home.page.copyright.symbol");
    private static final String COPYRIGHT_TEXT = PropertyController.loadProperty("home.page.copyright.text");

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

    @When("^user clicks on SUPPORT button$")
    public void userCLicksOnSupportButton() {
        myWebSite.homePage.clickOnSendButton();
    }

    @When("^user clicks on DOWNLOAD RESUME button$")
    public void userClicksOnDownloadResumeButton() {
        myWebSite.homePage.clickOnDownloadResumeButton();
    }

    @Then("^recheck home page url$")
    public void recheckHomePageUrl() {
        Assertions.assertThat(myWebSite.homePage.isHomePage()).as("not home page").isTrue();
    }

    @Then("^form was sent successfully with alert \"([^\"]*)\" text$")
    public void formWasSentSuccessfullyWithText(final String text) {
        Assert.assertTrue(myWebSite.homePage.isMessageTextEquals(text));
    }

    @Then("^user checks urls from bottom links$")
    public void userChecksUrlsFromBottomLinks() {
        List<String> actualUrls = new ArrayList<>();
        actualUrls.add(myWebSite.homePage.getHrefFromBottomLink(HomePage.BottomLinks.FACEBOOK));
        actualUrls.add(myWebSite.homePage.getHrefFromBottomLink(HomePage.BottomLinks.LINKEDIN));
        actualUrls.add(myWebSite.homePage.getHrefFromBottomLink(HomePage.BottomLinks.INSTAGRAM));
        actualUrls.add(myWebSite.homePage.getHrefFromBottomLink(HomePage.BottomLinks.YOUTUBE));
        actualUrls.add(myWebSite.homePage.getHrefFromBottomLink(HomePage.BottomLinks.GOOGLE_PLUS));
        Assert.assertTrue(actualUrls.equals(MyPageUrl.getUrls()));
    }

    @Then("^user checks copyright text$")
    public void userChecksCopyrightText() {
        SoftAssertions softly = new SoftAssertions();
        final String copyrightWebElementText = myWebSite.homePage.getCopyrightText();
        softly.assertThat(copyrightWebElementText.substring(0, 1)).isEqualTo(COPYRIGHT_SYMBOL);
        softly.assertThat(copyrightWebElementText.substring(7)).isEqualTo(COPYRIGHT_TEXT);
        softly.assertAll();
    }

    @And("^copyright date is a current year$")
    public void copyrightDateIsCurrentYear() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(myWebSite.homePage.getCopyrightYear())
                .as("Copyright year is not actual current year")
                .isEqualTo(DateUtil.getCurrentYear());
        softly.assertAll();
    }

    @And("^user checks copyright link$")
    public void userChecksCopyrightLink() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(myWebSite.homePage.getCopyrightLink()).isEqualTo(MyPageUrl.HOME_PAGE_URL.getPageUrl());
        softly.assertAll();
    }
}
