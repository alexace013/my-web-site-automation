package driver;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import controller.OSController;
import controller.PropertyController;

import java.io.IOException;

@Log4j
public class WebDriverInstance {

    private static final String BROWSER_PATH_UNIX = PropertyController.loadProperty("chromedriver.path.unix");
    private static final String BROWSER_PATH_WINDOWS = PropertyController.loadProperty("chromedriver.path.windows");
    private static final String BROWSER_PATH_MAC = PropertyController.loadProperty("chromedriver.path.mac");
    private static final String CHROME_NAME = PropertyController.loadProperty("chrome.name");
    private static final String SELENIDE_TIMEOUT = PropertyController.loadProperty("selenide.wait.timeout.30sec");
    private static final String WEBDRIVER_CHROME_DRIVER = PropertyController.loadProperty("webdriver.chrome.driver");

    public static WebDriver driver;

    public WebDriverInstance() {
    }

    public static WebDriver initWebDriver(final boolean isWebDriverHeadless) {
        DesiredCapabilities desiredCapabilities;
        System.setProperty(WEBDRIVER_CHROME_DRIVER, System.getProperty("user.dir") + getChromeDriverPath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        if (isWebDriverHeadless) {
            chromeOptions.addArguments("headless");
            chromeOptions.addArguments("window-size=1920x1080");
        }
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public static void initSelenideChromeWebDriver() {
        final String selenideInstanceMessage = "\n--- SELENIDE INSTANCE ---\nBROWSER: %s\n---\n";
        log.info(String.format(selenideInstanceMessage, CHROME_NAME));
        Configuration.timeout = Long.parseLong(SELENIDE_TIMEOUT);
        System.setProperty(WEBDRIVER_CHROME_DRIVER, getChromeDriverPath());
        Configuration.browser = CHROME_NAME;
    }

    private static String getChromeDriverPath() {
        if (OSController.isUnix()) {
            return BROWSER_PATH_UNIX;
        } else if (OSController.isWindows()) {
            return BROWSER_PATH_WINDOWS;
        } else if (OSController.isMac()) {
            return BROWSER_PATH_MAC;
        } else {
            try {
                throw new IOException();
            } catch (IOException e) {
                log.debug("not found chrome driver for unix, windows or mac os");
                log.error(e);
            }
        }
        return "dev\\null";
    }
}
