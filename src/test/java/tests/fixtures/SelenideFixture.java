package tests.fixtures;

import driver.WebDriverInstance;
import org.junit.BeforeClass;

public class SelenideFixture {

    @BeforeClass
    public void setUp() {
        WebDriverInstance.initSelenideChromeWebDriver();
    }

}
