package tests.stepsDefinitions.selenide;

import static org.junit.jupiter.api.Assertions.*;
import static com.alexanderbakhin.site.MyPageUrl.HOME_PAGE_URL;
import static com.alexanderbakhin.site.MyPageUrl.SUPPORT_PAGE_URL;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lombok.extern.log4j.Log4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import tests.fixtures.SelenideFixture;
import utils.UrlUtil;

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

    @And("^user is switched in new tab to (.*) url on Selenide$")
    public void userNavigatedToPageUrl(final String expectedPageUrl) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        String windowHandle = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        log.debug("URL: " + driver.getCurrentUrl());
        String actualPageUrl = UrlUtil.getUrlFromNewTab(driver, 2);
        Assertions.assertThat(actualPageUrl).as("Was opened incorrect page.").isEqualTo(expectedPageUrl);
        driver.close();
        driver.switchTo().window(windowHandle);
    }
}
