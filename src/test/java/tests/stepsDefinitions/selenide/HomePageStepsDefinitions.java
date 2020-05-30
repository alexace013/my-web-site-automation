package tests.stepsDefinitions.selenide;

import com.alexanderbakhin.selenium.pages.HomePage;
import com.alexanderbakhin.site.MyPageUrl;
import com.codeborne.selenide.WebDriverRunner;
import controller.PropertyController;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.fixtures.SelenideFixture;
import utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class HomePageStepsDefinitions extends SelenideFixture {

    private static final String WAIT_30_SEC = PropertyController.loadProperty("wait.timeout.30sec");
    private static final String COPYRIGHT_SYMBOL = PropertyController.loadProperty("home.page.copyright.symbol");
    private static final String COPYRIGHT_TEXT = PropertyController.loadProperty("home.page.copyright.text");

    @When("^user clicks on DOWNLOAD RESUME button on Selenide$")
    public void userClicksOnDownloadResumeButtonOnSelenide() {
        homePage.clickOnDownloadResumeButton();
    }

    @When("^user inputs \"([^\"]*)\" data in name field on Selenide$")
    public void userInputsDataInNameFieldOnSelenide(final String data) {
        homePage.inputDataIntoNameField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in e-mail field on Selenide$")
    public void userInputsDataInEmailFieldOnSelenide(final String data) {
        homePage.inputDataIntoEmailField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in country field on Selenide$")
    public void userInputsDataInCountryFieldOnSelenide(final String data) {
        homePage.inputDataIntoCountryField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in city field on Selenide$")
    public void userInputsDataInCityFieldOnSelenide(final String data) {
        homePage.inputDataIntoCityField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in phone field on Selenide$")
    public void userInputsDataInPhoneFieldOnSelenide(final String data) {
        homePage.inputDataIntoPhoneField(data);
    }

    @When("^user inputs \"([^\"]*)\" data in message textarea on Selenide$")
    @And("^user inputs \"([^\"]*)\" data in message field on Selenide$")
    public void userInputsDataInMessageFieldOnSelenide(final String data) {
        homePage.inputDataIntoMessageTextArea(data);
    }

    @When("^user clicks on SEND button on Selenide$")
    public void userClicksOnSendButtonOnSelenide() {
        homePage.clickOnSendButton();
    }

    @When("^user clicks on SUPPORT button on Selenide")
    public void userClicksOnSupportButtonOnSelenide() {
        homePage.clickOnSupportButton();
    }

    @Then("^form was sent successfully with alert \"([^\"]*)\" text on Selenide$")
    public void formWasSentSuccessfullyWithTextOnSelenide(final String text) {
        WebDriverWait driverWait = new WebDriverWait(WebDriverRunner.getWebDriver(), Integer.parseInt(WAIT_30_SEC));
        driverWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = WebDriverRunner.getWebDriver().switchTo().alert();
        alert.accept();
        Assertions.assertThat(alert.getText()).as("alert message is not correct.").isEqualTo(text);
    }

    @Then("^user checks urls from bottom links on Selenide$")
    public void userChecksUrlsFromBottomLinksOnSelenide() {
        List<String> actualUrls = new ArrayList<>();
        actualUrls.add(homePage.getHrefFromBottomLink(HomePage.BottomLinks.FACEBOOK));
        actualUrls.add(homePage.getHrefFromBottomLink(HomePage.BottomLinks.LINKEDIN));
        actualUrls.add(homePage.getHrefFromBottomLink(HomePage.BottomLinks.INSTAGRAM));
        actualUrls.add(homePage.getHrefFromBottomLink(HomePage.BottomLinks.YOUTUBE));
        actualUrls.add(homePage.getHrefFromBottomLink(HomePage.BottomLinks.GOOGLE_PLUS));
        Assert.assertTrue(actualUrls.equals(MyPageUrl.getUrls()));
    }

    @Then("^user checks copyright text on Selenide$")
    public void userChecksCopyrightText() {
        SoftAssertions softly = new SoftAssertions();
        final String copyrightWebElementText = homePage.getCopyrightText();
        softly.assertThat(copyrightWebElementText.substring(0, 1)).isEqualTo(COPYRIGHT_SYMBOL);
        softly.assertThat(copyrightWebElementText.substring(7)).isEqualTo(COPYRIGHT_TEXT);
        softly.assertAll();
    }

    @And("^copyright date is a current year on Selenide$")
    public void copyrightDateIsCurrentYear() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePage.getCopyrightYear())
                .as("Copyright year is not actual current year")
                .isEqualTo(DateUtil.getCurrentYear());
        softly.assertAll();
    }

    @And("^user checks copyright link on Selenide$")
    public void userChecksCopyrightLink() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePage.getCopyrightLink()).isEqualTo(COPYRIGHT_TEXT);
        softly.assertAll();
    }
}