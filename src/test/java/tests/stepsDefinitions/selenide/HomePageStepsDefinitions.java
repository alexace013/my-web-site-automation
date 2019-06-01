package tests.stepsDefinitions.selenide;

import com.alexanderbakhin.site.IHomePage;
import com.codeborne.selenide.Condition;
import controller.PropertyController;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import tests.fixtures.SeleniumFixture;

import static com.codeborne.selenide.Selenide.$;

public class HomePageStepsDefinitions extends SeleniumFixture {

    private static final String COPYRIGHT_SYMBOL = PropertyController.loadProperty("home.page.copyright.symbol");
    private static final String COPYRIGHT_TEXT = PropertyController.loadProperty("home.page.copyright.text");

    @When("^user clicks on DOWNLOAD RESUME button on Selenide$")
    public void userClicksOnDownloadResumeButton() {
        $(By.xpath(IHomePage.DOWNLOAD_RESUME_BUTTON)).shouldBe(Condition.visible).click();
    }
}