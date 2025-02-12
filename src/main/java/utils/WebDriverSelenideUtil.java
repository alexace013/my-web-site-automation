package utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

public class WebDriverSelenideUtil {

    public static WebDriver getWebDriver() {
        return WebDriverRunner.getWebDriver();
    }
}