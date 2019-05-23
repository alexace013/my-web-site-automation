package tests.stepsDefinitions.selenide;

import static org.junit.jupiter.api.Assertions.*;
import static com.alexanderbakhin.site.MyPageUrl.HOME_PAGE_URL;
import static com.alexanderbakhin.site.MyPageUrl.SUPPORT_PAGE_URL;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lombok.extern.log4j.Log4j;
import tests.fixtures.SelenideFixture;

@Log4j
public class CommonPageStepsDefinitions extends SelenideFixture {

    @Given("^user opens \"([^\"]*)\" page on Selenide$")
    public void userOpensPage(final String pageUrl) {
        homePage.openPage(pageUrl);
    }

    @Then("^user is navigated to \"([^\"]*)\" page on Selenide$")
    public void userNavigatedToPage(final String pageUrl) {
        final String messageText = "This is %s.";
        if (pageUrl.equals(HOME_PAGE_URL.getPageUrl())) {
            log.info(String.format(messageText, HOME_PAGE_URL.name().toLowerCase()));
            assertTrue(homePage.isPage());
        } else if (pageUrl.equals(SUPPORT_PAGE_URL.getPageUrl())) {
            log.info(String.format(messageText, SUPPORT_PAGE_URL.name().toLowerCase()));
            assertTrue(supportPage.isPage());
        }
    }
}
