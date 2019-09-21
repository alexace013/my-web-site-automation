package tests.stepsDefinitions.selenide;

import static com.codeborne.selenide.Condition.visible;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

import com.alexanderbakhin.selenium.pages.HomePage;
import com.alexanderbakhin.site.IHomePage;
import com.alexanderbakhin.site.MyPageUrl;
import com.codeborne.selenide.WebDriverRunner;
import controller.PropertyController;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.fixtures.SelenideFixture;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class HomePageStepsDefinitions extends SelenideFixture {

    private static final String WAIT_30_SEC = PropertyController.loadProperty("wait.timeout.30sec");
    private static final String COPYRIGHT_SYMBOL = PropertyController.loadProperty("home.page.copyright.symbol");
    private static final String COPYRIGHT_TEXT = PropertyController.loadProperty("home.page.copyright.text");

    @When("^user clicks on DOWNLOAD RESUME button on Selenide$")
    public void userClicksOnDownloadResumeButtonOnSelenide() {
        $(xpath(IHomePage.DOWNLOAD_RESUME_BUTTON)).shouldBe(visible).click();
    }

    @When("^user inputs \"([^\"]*)\" data in name field on Selenide$")
    public void userInputsDataInNameFieldOnSelenide(final String data) {
        inputDataIntoField(IHomePage.MessagePanel.NAME, data);
    }

    @When("^user inputs \"([^\"]*)\" data in e-mail field on Selenide$")
    public void userInputsDataInEmailFieldOnSelenide(final String data) {
        inputDataIntoField(IHomePage.MessagePanel.E_MAIL, data);
    }

    @When("^user inputs \"([^\"]*)\" data in country field on Selenide$")
    public void userInputsDataInCountryFieldOnSelenide(final String data) {
        inputDataIntoField(IHomePage.MessagePanel.COUNTRY, data);
    }

    @When("^user inputs \"([^\"]*)\" data in city field on Selenide$")
    public void userInputsDataInCityFieldOnSelenide(final String data) {
        inputDataIntoField(IHomePage.MessagePanel.CITY, data);
    }

    @When("^user inputs \"([^\"]*)\" data in phone field on Selenide$")
    public void userInputsDataInPhoneFieldOnSelenide(final String data) {
        inputDataIntoField(IHomePage.MessagePanel.PHONE, data);
    }

    private static void inputDataIntoField(final IHomePage.MessagePanel messagePanel, final String data) {
        $(xpath(format(IHomePage.INPUT_FIELDS, messagePanel.getField()))).shouldBe(visible).setValue(data);
    }

    @When("^user inputs \"([^\"]*)\" data in message textarea on Selenide$")
    @And("^user inputs \"([^\"]*)\" data in message field on Selenide$")
    public void userInputsDataInMessageFieldOnSelenide(final String data) {
        $(xpath(IHomePage.MESSAGE_TEXT_AREA)).shouldBe(visible).setValue(data);
    }

    @When("^user clicks on SEND button on Selenide$")
    public void userClicksOnSendButtonOnSelenide() {
        $(xpath(IHomePage.SEND_BUTTON)).shouldBe(visible).click();
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
}